#!/usr/bin/env node
/*
 * Retype a JDBC local the decompiler widened to `java.sql.Statement`. When a
 * `Statement` local is actually assigned from `connection.prepareStatement(...)`
 * it must be `PreparedStatement` (that is where the no-arg `execute()` lives),
 * so `cstmt.execute()` has no applicable overload while the declaration is
 * `Statement`.
 *
 * Keyed off javac diagnostics:
 *   Foo.java:172: error: no suitable method found for execute(no arguments)
 *       cstmt.execute();
 *
 * For each such diagnostic the receiver variable is located and every
 * `Statement <var> = null;` declaration in the file is retyped to
 * `PreparedStatement`, swapping the specific `java.sql.Statement` import when
 * it becomes unused (a wildcard import needs no change).
 *
 * Usage: node SAPAAS/scripts/restore-prepared-statement-types.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-prepared-statement-types.mjs <javac.log> [--apply]');
  process.exit(2);
}

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');
const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: no suitable method found for execute\(no arguments\)/;
const call = /^([A-Za-z_$][\w$]*)\.execute\(\)\s*;/;

const byFile = new Map();
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed) continue;
  const receiver = (log[i + 1] ?? '').replace('[javac] ', '').trim().match(call)?.[1];
  if (!receiver) continue;
  if (!byFile.has(parsed[1])) byFile.set(parsed[1], new Set());
  byFile.get(parsed[1]).add(receiver);
}

let changed = 0;
const skipped = [];
for (const [file, receivers] of byFile) {
  const path = resolve(root, 'src', file);
  const lines = readFileSync(path, 'utf8').split('\n');
  let dirty = false;
  for (const variable of receivers) {
    const declaration = new RegExp(`^(\\s*)Statement\\s+${variable}\\s*[=;]`);
    let touched = false;
    for (let i = 0; i < lines.length; i++) {
      if (declaration.test(lines[i])) {
        lines[i] = lines[i].replace(/^(\s*)Statement(\s+)/, '$1PreparedStatement$2');
        touched = true;
        dirty = true;
        changed++;
        console.log(`${file}:${i + 1}: Statement -> PreparedStatement ${variable}`);
      }
    }
    if (!touched) skipped.push(`${file}: no 'Statement ${variable}' declaration found`);
  }
  if (dirty) {
    const body = lines.join('\n');
    if (!body.includes('import java.sql.PreparedStatement;') && /import java\.sql\.Statement;/.test(body)) {
      const stillUsesStatement = /(^|[^\w$])Statement([^\w$]|$)/.test(
        body.replace(/import java\.sql\.Statement;/, ''),
      );
      if (stillUsesStatement) {
        lines.splice(
          lines.findIndex((line) => line.trim() === 'import java.sql.Statement;'),
          0,
          'import java.sql.PreparedStatement;',
        );
        console.log(`${file}: added import java.sql.PreparedStatement;`);
      } else {
        for (let i = 0; i < lines.length; i++) {
          if (lines[i].trim() === 'import java.sql.Statement;') {
            lines[i] = lines[i].replace('java.sql.Statement', 'java.sql.PreparedStatement');
            console.log(`${file}:${i + 1}: import Statement -> PreparedStatement`);
          }
        }
      }
    }
  }
  if (apply && dirty) writeFileSync(path, lines.join('\n'));
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} declarations ${apply ? 'updated' : 'eligible'} (use --apply to update)`);
