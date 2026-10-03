#!/usr/bin/env bash
set -Eeuo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
SOURCE_DIR="$ROOT_DIR/SAPAAS/src"
OUTPUT_FILE="${1:-$ROOT_DIR/.artifacts/source-build-audit/pseudo-syntax-inventory.md}"
PREFLIGHT_SOURCE="$ROOT_DIR/SAPAAS/build-tools/BuildPreflight.java"

if [[ ! -d "$SOURCE_DIR" ]]; then
  echo "Missing source directory: $SOURCE_DIR" >&2
  exit 1
fi

if [[ ! -f "$PREFLIGHT_SOURCE" ]]; then
  echo "Missing source preflight: $PREFLIGHT_SOURCE" >&2
  exit 1
fi

BUILD_DIR="$(mktemp -d)"
trap 'rm -rf "$BUILD_DIR"' EXIT

javac -encoding UTF-8 -source 7 -target 7 \
  -d "$BUILD_DIR" "$PREFLIGHT_SOURCE"
java -cp "$BUILD_DIR" BuildPreflight --inventory "$SOURCE_DIR" "$OUTPUT_FILE"
