#!/usr/bin/env bash
#
# Source-error census for the recovered Task SAPAAS tree.
#
# Why this exists
# ---------------
# javac stops attributing further classes as soon as an error has been reported
# (`should-stop.ifError`, default INIT), so `diagnose-source.sh` can only ever
# show the *next* offender - typically one file per run. It therefore cannot
# answer "how many files are still broken". This script overlays a build.xml
# that adds `-XDshould-stop.ifError=GENERATE` so javac keeps going and reports
# the whole remaining tail in a single run.
#
# Fail-closed guarantees
# ----------------------
# * the repository is never modified: the patched build.xml is a temp copy bind
#   mounted over the original path; the rest of the tree stays read-only;
# * the WAR is written to a disposable docker volume, never to SAPAAS/target;
# * this is a *measurement* run only - it never produces a shippable artefact.
#
# Self-check: every run must print CENSUS-OVERLAY-ACTIVE, which only the patched
# build.xml emits. A nested *file* bind mount over a path inside another bind
# mount is silently ignored by docker (observed: the control run with an invalid
# -XD value behaved identically to the normal build), so the patched copy is
# mounted as a whole directory instead and the marker proves it was used.
# TASK_CENSUS_STOP_POLICY=BOGUS is the negative control: it must make the
# marker appear *and* javac reject the value.
#
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
ARTIFACT_DIR="${TASK_CENSUS_DIR:-$ROOT_DIR/.artifacts/source-census}"
IMAGE="${TASK_TOOLCHAIN_IMAGE:-aibiz/task7:source-toolchain}"
MAX_ERRORS="${TASK_JAVAC_MAX_ERRORS:-20000}"
PLATFORM="${TASK_BUILD_PLATFORM:-linux/arm64}"
# JDK 8 spells this option `shouldStopPolicyIfError` (verified with
# `javap -v com.sun.tools.javac.main.JavaCompiler` -> Utf8 shouldStopPolicyIfError).
# The JDK 9+ spelling `-XDshould-stop.ifError` is silently ignored by 1.8, which
# is why an early attempt looked like "the knob does nothing".
STOP_POLICY_OPTION="${TASK_CENSUS_STOP_OPTION:-shouldStopPolicyIfError}"
STOP_POLICY="${TASK_CENSUS_STOP_POLICY:-GENERATE}"
# Space separated extra raw javac arguments, for probing which internal knobs
# this JDK actually honours (e.g. -XDshould-stop.ifNoError=PARSE).
EXTRA_ARGS="${TASK_CENSUS_EXTRA_JAVAC_ARGS:-}"

if [[ ! "$MAX_ERRORS" =~ ^[1-9][0-9]*$ ]]; then
  echo "TASK_JAVAC_MAX_ERRORS must be a positive integer." >&2
  exit 2
fi
if ! command -v docker >/dev/null 2>&1; then
  echo "Docker is required for the source-error census." >&2
  exit 1
fi

mkdir -p "$ARTIFACT_DIR"
ARTIFACT_DIR="$(cd "$ARTIFACT_DIR" && pwd)"
rm -f "$ARTIFACT_DIR/javac.log" "$ARTIFACT_DIR/census.json"

if ! docker image inspect "$IMAGE" >/dev/null 2>&1; then
  echo "Toolchain image $IMAGE is missing; run SAPAAS/scripts/diagnose-source.sh once first." >&2
  exit 1
fi

tmp="$(mktemp -d)"
trap 'rm -rf "$tmp"' EXIT

# Copy the whole directory that holds build.xml so it can be mounted over the
# original path (basedir stays identical, so every relative path still works).
cp -a "$ROOT_DIR/SAPAAS/resources/classes" "$tmp/classes"

python3 - "$ROOT_DIR/SAPAAS/resources/classes/build.xml" "$tmp/classes/build.xml" "$STOP_POLICY" "$EXTRA_ARGS" "$STOP_POLICY_OPTION" <<'PY'
import sys

src, dst, policy, extra_args, option = sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4], sys.argv[5]
text = open(src, encoding='utf-8').read()
needle = '<compilerarg value="${javac.max.errors}"/>'
if text.count(needle) != 1:
    sys.exit('anchor %r not found exactly once in build.xml' % needle)
extra = '            <compilerarg value="-XD%s=%s"/>' % (option, policy)
for arg in extra_args.split():
    extra += '\n            <compilerarg value="%s"/>' % arg
text = text.replace(needle, needle + '\n' + extra)

target = '<target name="compile" depends="clean,verify-dependencies,verify-source">'
if text.count(target) != 1:
    sys.exit('compile target anchor not found exactly once in build.xml')
marker = target + '\n        <echo message="CENSUS-OVERLAY-ACTIVE %s=%s extra=[%s]"/>' % (option, policy, extra_args)
text = text.replace(target, marker)

open(dst, 'w', encoding='utf-8').write(text)
PY

if [[ "$(grep -c 'CENSUS-OVERLAY-ACTIVE' "$tmp/classes/build.xml")" != "1" ]]; then
  echo "Patched build.xml is missing the overlay marker; aborting." >&2
  exit 1
fi

echo "Census run: -XDshould-stop.ifError=$STOP_POLICY (patched build.xml overlay)"

volume="$(docker volume create)"
cleanup() {
  docker volume rm "$volume" >/dev/null 2>&1 || true
}
trap 'cleanup; rm -rf "$tmp"' EXIT

set +e
docker run --rm --platform "$PLATFORM" \
  --mount "type=bind,src=$ROOT_DIR,dst=/workspace/task7,readonly" \
  --mount "type=bind,src=$tmp/classes,dst=/workspace/task7/SAPAAS/resources/classes,readonly" \
  --mount "type=volume,src=$volume,dst=/var/task7-build" \
  -w /workspace/task7 "$IMAGE" \
  ant "-Dbuild.dir=/var/task7-build/target" "-Djavac.max.errors=$MAX_ERRORS" \
    -f SAPAAS/resources/classes/build.xml war \
  > "$ARTIFACT_DIR/javac.log" 2>&1
status=$?
set -e

if ! grep -q 'CENSUS-OVERLAY-ACTIVE' "$ARTIFACT_DIR/javac.log"; then
  echo "MEASUREMENT INVALID: patched build.xml was not used (no overlay marker in the log)." >&2
  echo "The counts below describe a normal diagnostic run, not the census." >&2
  exit 3
fi
echo "overlay marker found: $(grep -o 'CENSUS-OVERLAY-ACTIVE[^]]*' "$ARTIFACT_DIR/javac.log" | head -1)"

errors="$(grep -cE '\[javac\] .*error:' "$ARTIFACT_DIR/javac.log" || true)"
files="$(grep -oE '/workspace/task7/SAPAAS/src/[A-Za-z0-9_/$.]+\.java' "$ARTIFACT_DIR/javac.log" | sort -u | wc -l | tr -d ' ')"
summary="$(grep -oE '^    \[javac\] [0-9]+ error[s]?' "$ARTIFACT_DIR/javac.log" | tail -1 | tr -s ' ' | sed 's/^ //')"

printf '{"status":"%s","exitCode":%s,"stopPolicy":"%s","errors":%s,"files":%s,"javacSummary":"%s","log":"%s"}\n' \
  "$([[ "$status" -eq 0 ]] && printf 'compiled' || printf 'census')" \
  "$status" "$STOP_POLICY" "$errors" "$files" "$summary" "$ARTIFACT_DIR/javac.log" \
  > "$ARTIFACT_DIR/census.json"

echo "error lines   : $errors"
echo "distinct files: $files"
echo "javac summary : $summary"
echo "log           : $ARTIFACT_DIR/javac.log"
exit 0
