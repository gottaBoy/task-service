#!/usr/bin/env node
/*
 * Correct a local whose declared type contradicts the expression assigned to
 * it, e.g.
 *
 *   Foo.java:293: error: incompatible types: String cannot be converted to Iterator
 *       Iterator strLevelGroup = groupData3.GetParamStringValue(...);
 *
 * When javac reports `SRC cannot be converted to DST` on a declaration
 * `DST v = ...`, the declaration is retyped to SRC. The rewrite is skipped when
 * the local is assigned anywhere else in the file, because the decompiler also
 * reuses one name for two unrelated types (that reuse is not safely fixable by
 * retyping).
 *
 * Usage: node SAPAAS/scripts/restore-declared-types.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-declared-types.mjs <javac.log> [--apply]');
  process.exit(2);
}

const escape = (value) => value.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');
const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: incompatible types: (.+?) cannot be converted to (.+)/;

const byFile = new Map();
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed) continue;
  const [, file, line, srcType, dstType] = parsed;
  const src = srcType.trim();
  const dst = dstType.trim();
  // `Object cannot be converted to T` and array covariance (String[] -> Object[])
  // need a cast at the use site, and equal raw names (Vector<A> vs Vector<B>,
  // Iterator<A> vs Iterator<B>) are invariance cases that need judgement, so
  // none of them are retyped here.
  const rawName = (type) => type.replace(/<.*/, '').trim();
  if (src === 'Object' || dst === 'Object') continue;
  if (src.endsWith('[]') || dst.endsWith('[]')) continue;
  if (rawName(src) === rawName(dst)) continue;
  const code = (log[i + 1] ?? '').replace('[javac] ', '');
  const decl = code.match(new RegExp(`^(\\s*)${escape(dstType.trim())}\\s+([A-Za-z_$][\\w$]*)\\s*=`));
  if (!decl) continue;
  const variable = decl[2];
  const assignment = new RegExp(`^\\s*${variable}\\s*=(?!=)`);
  if (code.split('\n').length === 0) continue;
  const key = `${file}`;
  if (!byFile.has(key)) byFile.set(key, []);
  byFile.get(key).push({ line: Number(line), srcType: srcType.trim(), dstType: dstType.trim(), variable, assignment });
}

let changed = 0;
const skipped = [];
for (const [file, entries] of byFile) {
  const path = resolve(root, 'src', file);
  const lines = readFileSync(path, 'utf8').split('\n');
  let dirty = false;
  for (const entry of entries) {
    const reassignments = lines.filter((line) => entry.assignment.test(line)).length;
    if (reassignments > 0) {
      skipped.push(`${file}:${entry.line}: ${entry.variable} reassigned elsewhere; not retyping`);
      continue;
    }
    const index = entry.line - 1;
    const before = lines[index] ?? '';
    const after = before.replace(new RegExp(`^(\\s*)${escape(entry.dstType)}`), `$1${entry.srcType}`);
    if (after === before) {
      skipped.push(`${file}:${entry.line}: ${entry.variable} declaration did not match ${entry.dstType}`);
      continue;
    }
    lines[index] = after;
    dirty = true;
    changed++;
    console.log(`${file}:${entry.line}: ${entry.dstType} -> ${entry.srcType} ${entry.variable}`);
  }
  if (apply && dirty) writeFileSync(path, lines.join('\n'));
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} declarations ${apply ? 'updated' : 'eligible'} (use --apply to update)`);
