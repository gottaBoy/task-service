#!/usr/bin/env bash
#
# End-to-end self-test for the Task source build.
#
# Runs the whole flow from a *pristine checkout of HEAD* so that it also proves
# the commit is self-contained, not just that this working tree happens to work:
#
#   1. clone HEAD into a temp dir (fails if anything needed lives outside git)
#   2. build the WAR from the clone (read-only mount, disposable output volume)
#   3. assert the WAR is really a source build (compiled classes, no sources)
#   4. build the runtime image from the clone through Dockerfile.source
#   5. start it with the reference deployment's environment on an ephemeral port
#   6. probe the entry/auth surface and compare path by path with the reference
#   7. write a receipt and exit non-zero if any assertion failed
#
# The reference deployment is the audited `task` container. It is only read
# from (inspect/logs/curl) and is never modified or restarted; if it is missing
# the comparison is reported as skipped instead of failing the run.
#
# Usage: bash SAPAAS/scripts/selftest-source-build.sh
# Env: TASK_SELFTEST_DIR, TASK_SELFTEST_IMAGE, TASK_TOOLCHAIN_IMAGE,
#      TASK_BUILD_PLATFORM, TASK_JAVAC_MAX_ERRORS, TASK_REFERENCE_CONTAINER
#
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
ARTIFACT_DIR="${TASK_SELFTEST_DIR:-$ROOT_DIR/.artifacts/source-selftest}"
TOOLCHAIN="${TASK_TOOLCHAIN_IMAGE:-aibiz/task7:source-toolchain}"
IMAGE="${TASK_SELFTEST_IMAGE:-aibiz/task7:selftest}"
PLATFORM="${TASK_BUILD_PLATFORM:-linux/arm64}"
MAX_ERRORS="${TASK_JAVAC_MAX_ERRORS:-20000}"
REF_CONTAINER="${TASK_REFERENCE_CONTAINER:-task}"

# Paths probed on both deployments (context path included).
PROBES=(
  /SAPAAS/
  /SAPAAS/index.jsp
  /SAPAAS/uacclient/uaclogin.jsp
  /SAPAAS/uacclient/uaclogin2.jsp
  /SAPAAS/uacclient/uaclogin_formaction.jsp
  /SAPAAS/srfpage/index_real.jsp
  /SAPAAS/default.htm
  /SAPAAS/css/
)

CONTAINER=task7-selftest
failures=()
notes=()

record_fail() { failures+=("$1"); printf '  FAIL %s\n' "$1"; }
record_ok()   { printf '  ok   %s\n' "$1"; }

mkdir -p "$ARTIFACT_DIR"
ARTIFACT_DIR="$(cd "$ARTIFACT_DIR" && pwd)"
rm -f "$ARTIFACT_DIR/receipt.json" "$ARTIFACT_DIR"/*.log

for tool in docker git python3; do
  command -v "$tool" >/dev/null 2>&1 || { echo "$tool is required." >&2; exit 2; }
done
docker image inspect "$TOOLCHAIN" >/dev/null 2>&1 || {
  echo "Missing $TOOLCHAIN; run SAPAAS/scripts/diagnose-source.sh once first." >&2
  exit 2
}

tmp="$(mktemp -d)"
volume="$(docker volume create)"
cleanup() {
  docker rm -f "$CONTAINER" >/dev/null 2>&1 || true
  docker volume rm "$volume" >/dev/null 2>&1 || true
  rm -rf "$tmp"
}
trap cleanup EXIT

commit="$(git -C "$ROOT_DIR" rev-parse HEAD)"
started_at="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "Self-test of $commit"
echo "artifacts: $ARTIFACT_DIR"
echo

# ---------------------------------------------------------------- 1. clone ---
echo "[1/6] clone HEAD"
clone="$tmp/clone"
git clone --quiet --local "$ROOT_DIR" "$clone"
cloned_commit="$(git -C "$clone" rev-parse HEAD)"
if [[ "$cloned_commit" == "$commit" ]]; then
  record_ok "clone at $cloned_commit"
else
  record_fail "clone is at $cloned_commit but HEAD is $commit"
fi

# Checked-out files only: anything the build needs must be tracked.
( cd "$ROOT_DIR" && find . -path ./.artifacts -prune -o -path ./.git -prune -o \
    -path ./SAPAAS/target -prune -o -type f -print ) | sed 's|^\./||' | sort > "$tmp/orig.txt"
( cd "$clone" && find . -path ./.git -prune -o -type f -print ) | sed 's|^\./||' | sort > "$tmp/clone.txt"
missing="$(comm -23 "$tmp/orig.txt" "$tmp/clone.txt" | wc -l | tr -d ' ')"
if [[ "$missing" == "0" ]]; then
  record_ok "no file exists only outside git ($(wc -l < "$tmp/clone.txt" | tr -d ' ') files)"
else
  record_fail "$missing files are missing from the clone"
  comm -23 "$tmp/orig.txt" "$tmp/clone.txt" | sed -n '1,5p' | sed 's/^/       /'
fi

# ------------------------------------------------------------- 2. WAR build ---
echo "[2/6] build the WAR from the clone"
set +e
docker run --rm --platform "$PLATFORM" \
  --mount "type=bind,src=$clone,dst=/workspace/task7,readonly" \
  --mount "type=volume,src=$volume,dst=/var/task7-build" \
  -w /workspace/task7 "$TOOLCHAIN" \
  ant "-Dbuild.dir=/var/task7-build/target" "-Djavac.max.errors=$MAX_ERRORS" \
    -f SAPAAS/resources/classes/build.xml war \
  > "$ARTIFACT_DIR/war-build.log" 2>&1
war_status=$?
set -e
errors="$(grep -cE '\[javac\] .*error:' "$ARTIFACT_DIR/war-build.log" || true)"
if [[ "$war_status" -eq 0 ]] && grep -q 'BUILD SUCCESSFUL' "$ARTIFACT_DIR/war-build.log"; then
  record_ok "ant war succeeded, ${errors:-0} compiler errors"
else
  record_fail "ant war failed (exit $war_status, $errors error lines)"
fi

# ------------------------------------------------ 3. artefact invariants ----
echo "[3/6] inspect the built WAR"
war="$ARTIFACT_DIR/SAPAAS.war"
set +e
docker run --rm --platform "$PLATFORM" \
  --mount "type=volume,src=$volume,dst=/var/task7-build" "$TOOLCHAIN" \
  tar -C /var/task7-build/target -cf - SAPAAS.war > "$tmp/war.tar" 2>/dev/null
war_extract=$?
set -e
if [[ "$war_extract" -eq 0 ]]; then
  tar -C "$ARTIFACT_DIR" -xf "$tmp/war.tar"
  classes="$(unzip -l "$war" 2>/dev/null | awk '{print $NF}' | grep -cE '\.class$' || true)"
  sources="$(unzip -l "$war" 2>/dev/null | awk '{print $NF}' | grep -cE '\.java$' || true)"
  libs="$(unzip -l "$war" 2>/dev/null | awk '{print $NF}' | grep -cE '^WEB-INF/lib/.*\.jar$' || true)"
  [[ "$classes" -gt 0 ]] && record_ok "$classes compiled classes" \
                         || record_fail "no .class files in the WAR"
  [[ "$sources" -eq 0 ]] && record_ok "no .java sources smuggled into the WAR" \
                         || record_fail "$sources .java files inside the WAR"
  [[ "$libs" -gt 0 ]] && record_ok "$libs third-party jars bundled" \
                      || record_fail "no jars under WEB-INF/lib"
  # NOTE: no `grep -q` here. grep -q exits on the first match, the upstream
  # unzip then dies of SIGPIPE and `set -o pipefail` turns that into a failure
  # even though the pattern matched. Count instead, and avoid `| head` for the
  # same reason.
  entries="$(unzip -l "$war" 2>/dev/null | awk '{print $NF}')"
  has_welcome="$(printf '%s\n' "$entries" | grep -cE '(^|/)default\.htm$')"
  [[ "$has_welcome" -gt 0 ]] && record_ok "context-root welcome page present" \
                             || record_fail "default.htm missing from the WAR"
  war_sha="$(sha256sum "$war" | awk '{print $1}')"
else
  record_fail "could not extract the WAR from the build volume"
  war_sha=""
fi

# ------------------------------------------------------------- 4. image ----
echo "[4/6] build the runtime image"
set +e
docker build --platform "$PLATFORM" \
  --build-arg "JAVAC_MAX_ERRORS=$MAX_ERRORS" \
  -f "$clone/Dockerfile.source" -t "$IMAGE" "$clone" \
  > "$ARTIFACT_DIR/docker-build.log" 2>&1
img_status=$?
set -e
if [[ "$img_status" -eq 0 ]]; then
  image_id="$(docker image inspect "$IMAGE" --format '{{.Id}}')"
  record_ok "image $IMAGE ($image_id)"
else
  image_id=""
  record_fail "docker build failed (exit $img_status)"
fi

# ------------------------------------------------- 5. run + probe both ----
echo "[5/6] run the image and probe it"
our_port=""
ref_port=""
ref_up=false

if [[ -n "$image_id" ]]; then
  env_file="$tmp/ref-env.list"
  if docker inspect "$REF_CONTAINER" >/dev/null 2>&1; then
    docker inspect "$REF_CONTAINER" --format '{{range .Config.Env}}{{println .}}{{end}}' \
      | grep -vE '^(PATH|HOSTNAME|HOME)=' > "$env_file" || true
    network="$(docker inspect "$REF_CONTAINER" --format '{{.HostConfig.NetworkMode}}')"
    ref_port="$(docker port "$REF_CONTAINER" 8080 2>/dev/null | sed -n '1s/.*://p')"
    [[ -n "$ref_port" ]] && ref_up=true
  else
    : > "$env_file"
    network="bridge"
  fi

  docker rm -f "$CONTAINER" >/dev/null 2>&1 || true
  docker run -d --name "$CONTAINER" --network "$network" \
    -p 127.0.0.1::8080 $( [[ -s "$env_file" ]] && printf -- '--env-file %s' "$env_file" ) \
    "$IMAGE" >/dev/null
  our_port="$(docker port "$CONTAINER" 8080 | sed -n '1s/.*://p')"
  if [[ -n "$our_port" ]]; then
    record_ok "container published on 127.0.0.1:$our_port"
  else
    record_fail "container did not publish port 8080"
  fi

  if [[ -n "$our_port" ]]; then
    # Bounded wait for Tomcat: curl retries instead of sleeping.
    if curl -s -o /dev/null --retry 40 --retry-delay 5 --retry-all-errors \
         --max-time 15 -L "http://127.0.0.1:$our_port/SAPAAS/" ; then
      record_ok "application answered on /SAPAAS/"
    else
      record_fail "no HTTP answer after ~3.5 min"
      docker logs "$CONTAINER" 2>&1 | tail -15 | sed 's/^/       /'
    fi
  fi
fi

# ------------------------------------------------------- 6. A/B compare ----
echo "[6/6] compare with the reference deployment"
ab_rows=()
if [[ -n "$our_port" && "$ref_up" == true ]]; then
  for p in "${PROBES[@]}"; do
    ours="$(curl -s -o /dev/null -m 45 -w '%{http_code}' "http://127.0.0.1:$our_port$p")"
    ref="$(curl -s -o /dev/null -m 45 -w '%{http_code}' "http://127.0.0.1:$ref_port$p")"
    ab_rows+=("$p|$ours|$ref")
    if [[ "$ours" == "$ref" ]]; then
      printf '  ok   %-42s %s == %s\n' "$p" "$ours" "$ref"
    else
      record_fail "$p ours=$ours reference=$ref"
    fi
  done
else
  notes+=("reference comparison skipped (reference container '$REF_CONTAINER' unavailable)")
  echo "  skip reference comparison (container '$REF_CONTAINER' unavailable)"
fi

# ------------------------------------------------------------- receipt ----
status="pass"
[[ "${#failures[@]}" -eq 0 ]] || status="fail"
{
  printf '{'
  printf '"status":"%s","commit":"%s","startedAt":"%s",' "$status" "$commit" "$started_at"
  printf '"warSha256":"%s","warBytes":%s,' \
    "${war_sha:-}" "$( [[ -f "$ARTIFACT_DIR/SAPAAS.war" ]] && stat -c %s "$ARTIFACT_DIR/SAPAAS.war" || echo 0 )"
  printf '"classes":%s,"sourcesInWar":%s,"bundledJars":%s,' \
    "${classes:-0}" "${sources:-0}" "${libs:-0}"
  printf '"image":"%s","imageId":"%s","ourPort":"%s","referencePort":"%s",' \
    "$IMAGE" "${image_id:-}" "${our_port:-}" "${ref_port:-}"
  printf '"failures":[' ; \
    for i in "${!failures[@]}"; do [[ "$i" -gt 0 ]] && printf ','; printf '"%s"' "${failures[$i]}"; done
  printf '],"notes":[' ; \
    for i in "${!notes[@]}"; do [[ "$i" -gt 0 ]] && printf ','; printf '"%s"' "${notes[$i]}"; done
  printf ']}\n'
} > "$ARTIFACT_DIR/receipt.json"

echo
echo "receipt: $ARTIFACT_DIR/receipt.json"
if [[ "$status" == "pass" ]]; then
  echo "SELFTEST PASS"
else
  echo "SELFTEST FAIL (${#failures[@]} failing check(s))"
fi
[[ "$status" == "pass" ]]
