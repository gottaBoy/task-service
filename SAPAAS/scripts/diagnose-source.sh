#!/usr/bin/env bash
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
ARTIFACT_DIR="${TASK_DIAGNOSTIC_DIR:-$ROOT_DIR/.artifacts/source-diagnostics}"
IMAGE="${TASK_TOOLCHAIN_IMAGE:-aibiz/task7:source-toolchain}"
MAX_ERRORS="${TASK_JAVAC_MAX_ERRORS:-20000}"
PLATFORM="${TASK_BUILD_PLATFORM:-linux/arm64}"

if [[ ! "$MAX_ERRORS" =~ ^[1-9][0-9]*$ ]]; then
  echo "TASK_JAVAC_MAX_ERRORS must be a positive integer." >&2
  exit 2
fi
if ! command -v docker >/dev/null 2>&1; then
  echo "Docker is required for source diagnostics." >&2
  exit 1
fi

mkdir -p "$ARTIFACT_DIR"
ARTIFACT_DIR="$(cd "$ARTIFACT_DIR" && pwd)"
rm -f "$ARTIFACT_DIR/diagnostics.json" "$ARTIFACT_DIR/javac.log"
if ! docker build --platform "$PLATFORM" --target source-toolchain \
  -f "$ROOT_DIR/Dockerfile.source" -t "$IMAGE" "$ROOT_DIR" \
  > "$ARTIFACT_DIR/toolchain-build.log" 2>&1; then
  printf '{"status":"blocked","reason":"toolchain-build-failed","log":"%s"}\n' \
    "$ARTIFACT_DIR/toolchain-build.log" > "$ARTIFACT_DIR/diagnostics.json"
  echo "Source toolchain build failed: $ARTIFACT_DIR/toolchain-build.log" >&2
  exit 1
fi

volume="$(docker volume create)"
cleanup() {
  docker volume rm "$volume" >/dev/null 2>&1 || true
}
trap cleanup EXIT

# Ant clean must delete a child of the volume, not the volume mount point.
set +e
docker run --rm --platform "$PLATFORM" \
  --mount "type=bind,src=$ROOT_DIR,dst=/workspace/task7,readonly" \
  --mount "type=volume,src=$volume,dst=/var/task7-build" \
  -w /workspace/task7 "$IMAGE" \
  ant "-Dbuild.dir=/var/task7-build/target" "-Djavac.max.errors=$MAX_ERRORS" \
    -f SAPAAS/resources/classes/build.xml war \
  > "$ARTIFACT_DIR/javac.log" 2>&1
status=$?
set -e
printf '{"status":"%s","exitCode":%s,"maxErrors":%s,"log":"%s"}\n' \
  "$([[ "$status" -eq 0 ]] && printf 'compiled' || printf 'blocked')" \
  "$status" "$MAX_ERRORS" "$ARTIFACT_DIR/javac.log" \
  > "$ARTIFACT_DIR/diagnostics.json"
echo "Source diagnostics: $ARTIFACT_DIR/javac.log (exit $status)"
exit "$status"
