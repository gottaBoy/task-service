#!/usr/bin/env bash
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
IMAGE="${TASK_BUILDER_IMAGE:-aibiz/task7:source-built}"
ARTIFACT_DIR="${TASK_ARTIFACT_DIR:-$ROOT_DIR/.artifacts/source-build}"
BUILD_PLATFORM="${TASK_BUILD_PLATFORM:-linux/arm64}"
MAX_ERRORS="${TASK_JAVAC_MAX_ERRORS:-1000}"

usage() {
  cat <<'EOF'
Usage: build-source.sh [--image IMAGE] [--artifact-dir DIR] [--max-errors COUNT]

Builds the Task WAR and runtime image from the checked-in source tree.
The command is fail-closed: failed Docker/Ant compilation never produces
ready evidence.
EOF
}

while (($#)); do
  case "$1" in
    --image)
      IMAGE="${2:?missing value for --image}"
      shift 2
      ;;
    --artifact-dir)
      ARTIFACT_DIR="${2:?missing value for --artifact-dir}"
      shift 2
      ;;
    --max-errors)
      MAX_ERRORS="${2:?missing value for --max-errors}"
      shift 2
      ;;
    -h|--help)
      usage
      exit 0
      ;;
    *)
      echo "unknown argument: $1" >&2
      usage >&2
      exit 2
      ;;
  esac
done

if [[ ! "$MAX_ERRORS" =~ ^[1-9][0-9]*$ ]]; then
  echo "--max-errors must be a positive integer." >&2
  exit 2
fi

if ! command -v docker >/dev/null 2>&1; then
  echo "Docker is required for the Task source build." >&2
  exit 1
fi

mkdir -p "$ARTIFACT_DIR"
commit="$(git -C "$ROOT_DIR" rev-parse HEAD 2>/dev/null || printf 'unknown')"
started_at="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
log_file="$ARTIFACT_DIR/docker-build.log"
metadata_file="$ARTIFACT_DIR/source-build.json"
war_file="$ARTIFACT_DIR/SAPAAS.war"
rm -f "$metadata_file" "$war_file"

set +e
docker build \
  --platform "$BUILD_PLATFORM" \
  --build-arg "JAVAC_MAX_ERRORS=$MAX_ERRORS" \
  -f "$ROOT_DIR/Dockerfile.source" \
  -t "$IMAGE" \
  "$ROOT_DIR" 2>&1 | tee "$log_file"
build_status="${PIPESTATUS[0]}"
set -e

if ((build_status != 0)); then
  printf '{"status":"blocked","reason":"docker-build-failed","commit":"%s","imageTag":"%s","platform":"%s","maxErrors":%s,"startedAt":"%s","exitCode":%s}\n' \
    "$commit" "$IMAGE" "$BUILD_PLATFORM" "$MAX_ERRORS" "$started_at" "$build_status" > "$metadata_file"
  echo "Task source build blocked; see $log_file" >&2
  exit "$build_status"
fi

container="$(docker create "$IMAGE")"
cleanup() {
  docker rm "$container" >/dev/null 2>&1 || true
}
trap cleanup EXIT
docker cp "$container:/usr/local/tomcat/webapps/SAPAAS.war" "$war_file"

sha256="$(sha256sum "$war_file" | awk '{print $1}')"
image_id="$(docker image inspect "$IMAGE" --format '{{.Id}}')"
image_platform="$(docker image inspect "$IMAGE" --format '{{.Os}}/{{.Architecture}}')"
printf '{"status":"ready","artifact":"%s","sha256":"%s","commit":"%s","imageTag":"%s","imageId":"%s","platform":"%s","maxErrors":%s,"startedAt":"%s"}\n' \
  "$war_file" "$sha256" "$commit" "$IMAGE" "$image_id" "$image_platform" "$MAX_ERRORS" "$started_at" > "$metadata_file"
echo "Task source build ready: $war_file"
echo "Task source image ready: $IMAGE ($image_id)"
