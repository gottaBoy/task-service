#!/usr/bin/env node
/*
 * Remove a redundant `(Object)` cast the decompiler left on the argument of a
 * call that javac rejected, e.g.
 *
 *   Foo.java:12: error: no suitable method found for add(Object)
 *       coll.add((Object)item);
 *
 * The cast is dropped only when it sits immediately inside the diagnosed call,
 * so nested casts (`new SqlParam((Object)s, 25)`) are left alone. The target
 * collections are typed (`SqlParamList extends ArrayList<SqlParam>`), which is
 * why `add(Object)` has no applicable overload.
 *
 * Usage: node SAPAAS/scripts/restore-object-argument-casts.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-object-argument-casts.mjs <javac.log> [--apply]');
  process.exit(2);
}

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');
const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: no suitable method found for (\w+)\(Object\)/;

/** @type {Map<string, {file: string, method: string, lines: number[]}>} */
const targets = new Map();
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed) continue;
  const [, file, line, method] = parsed;
  const code = (log[i + 1] ?? '').replace('[javac] ', '');
  if (!new RegExp(`\\.${method}\\(\\(Object\\)`).test(code)) continue;
  const key = `${file}\u0000${method}`;
  const entry = targets.get(key) ?? { file, method, lines: [] };
  entry.lines.push(Number(line));
  targets.set(key, entry);
}

const byFile = new Map();
for (const entry of targets.values()) {
  if (!byFile.has(entry.file)) byFile.set(entry.file, []);
  byFile.get(entry.file).push(entry);
}

let changed = 0;
const skipped = [];
for (const [file, entries] of byFile) {
  const path = resolve(root, 'src', file);
  const lines = readFileSync(path, 'utf8').split('\n');
  let dirty = false;
  for (const entry of entries) {
    for (const number of entry.lines) {
      const index = number - 1;
      const before = lines[index] ?? '';
      const after = before.replace(new RegExp(`(\\.${entry.method}\\()\\(Object\\)`), '$1');
      if (after === before) {
        skipped.push(`${file}:${number}: no leading (Object) cast on .${entry.method}(`);
        continue;
      }
      lines[index] = after;
      dirty = true;
      changed++;
      console.log(`${file}:${number}: ${entry.method}( (dropped (Object))`);
    }
  }
  if (apply && dirty) writeFileSync(path, lines.join('\n'));
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} casts ${apply ? 'removed' : 'eligible'} (use --apply to update)`);
