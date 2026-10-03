#!/usr/bin/env bash
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
ANT_BUILD_FILE="$ROOT_DIR/SAPAAS/resources/classes/build.xml"

if ! command -v ant >/dev/null 2>&1; then
  echo "Ant is required for the source preflight." >&2
  exit 1
fi

# Keep this Unix convenience entry point on the same cross-platform
# implementation used by the Ant build and Docker source build.
exec ant -f "$ANT_BUILD_FILE" verify-source
