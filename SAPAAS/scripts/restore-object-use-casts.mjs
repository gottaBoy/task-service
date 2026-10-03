#!/usr/bin/env node
/*
 * Add a cast at the use site for a local the decompiler declared `Object` but
 * then used with a concrete method, e.g.
 *
 *   Foo.java:151: error: cannot find symbol
 *       object.get(pSDevCenterSVN);
 *       ^
 *     location: variable object of type Object
 *
 * where the nearest preceding assignment is `object = (PSDevCenterSVNService)...`.
 * The call becomes `((PSDevCenterSVNService)object).get(pSDevCenterSVN);`.
 *
 * Using a cast at the use site (instead of retyping the declaration) is safe
 * when one name is reused for several unrelated concrete types, because the
 * other uses keep their own types.
 *
 * Usage: node SAPAAS/scripts/restore-object-use-casts.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-object-use-casts.mjs <javac.log> [--apply]');
  process.exit(2);
}

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');
const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: (.*)/;
const location = /^location:\s+variable ([A-Za-z_$][\w$]*) of type Object$/;

/** @type {Map<string, {file: string, variable: string}>} */
const targets = new Map();
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed || !parsed[3].includes('cannot find symbol')) continue;
  let variable = null;
  for (let j = i + 2; j < Math.min(i + 12, log.length); j++) {
    const stripped = (log[j] ?? '').replace('[javac] ', '').trim();
    if (stripped.startsWith('location:')) {
      variable = stripped.match(location)?.[1] ?? null;
      break;
    }
    if (diagnostic.test(log[j] ?? '')) break;
  }
  if (!variable) continue;
  const code = (log[i + 1] ?? '').replace('[javac] ', '');
  if (!new RegExp(`\\b${variable}\\.`).test(code)) continue;
  const key = `${parsed[1]}\u0000${variable}`;
  const entry = targets.get(key) ?? { file: parsed[1], variable, lines: new Set() };
  entry.lines.add(Number(parsed[2]));
  targets.set(key, entry);
}

const byFile = new Map();
for (const entry of targets.values()) {
  if (!byFile.has(entry.file)) byFile.set(entry.file, []);
  byFile.get(entry.file).push(entry);
}

const cast = /^\s*([A-Za-z_$][\w$]*)\s*=\s*\(([A-Za-z_$][\w$.]+)\)/;
let changed = 0;
const skipped = [];
for (const [file, entries] of byFile) {
  const lines = readFileSync(resolve(root, 'src', file), 'utf8').split('\n');
  let dirty = false;
  for (const entry of entries) {
    const pattern = new RegExp(`\\b${entry.variable}\\.`);
    for (const number of entry.lines) {
      const i = number - 1;
      if (!pattern.test(lines[i] ?? '')) continue;
      let type = null;
      for (let j = i - 1; j >= 0 && j >= i - 200; j--) {
        const parsed = lines[j].match(cast);
        if (parsed && parsed[1] === entry.variable) {
          type = parsed[2];
          break;
        }
      }
      if (!type) continue;
      const before = lines[i];
      const after = before.replace(pattern, `((${type})${entry.variable}).`);
      if (after === before) continue;
      lines[i] = after;
      dirty = true;
      changed++;
      console.log(`${file}:${i + 1}: ((${type})${entry.variable}).`);
    }
  }
  if (dirty) {
    if (apply) writeFileSync(resolve(root, 'src', file), lines.join('\n'));
  } else {
    skipped.push(`${file}: no casted assignment found for the reported local`);
  }
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} use sites ${apply ? 'cast' : 'eligible'} (use --apply to update)`);
