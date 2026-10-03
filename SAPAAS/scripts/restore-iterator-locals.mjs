#!/usr/bin/env node
/*
 * Split a decompiler local that is used first as a collection iterator and
 * later as a String, e.g.
 *
 *   Object object = arrayList.iterator();
 *   while (object.hasNext()) {
 *       PSSysDBPart item = object.next();     // Object cannot be converted to PSSysDBPart
 *       ...
 *   }
 *   ...
 *   object = StringHelper.format(...);        // later used as String
 *   x.setName((String)object);
 *
 * becomes
 *
 *   String object;
 *   Iterator<PSSysDBPart> objectIterator = arrayList.iterator();
 *   while (objectIterator.hasNext()) {
 *       PSSysDBPart item = objectIterator.next();
 *   ...
 *
 * The split is applied only when the local is declared `Object <v> =
 * <expr>.iterator();`, iterated with `<v>.hasNext()`/`<v>.next()`, and later
 * assigned from `StringHelper.format(...)`/`StringHelper.Format(...)`.
 *
 * Usage: node SAPAAS/scripts/restore-iterator-locals.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-iterator-locals.mjs <javac.log> [--apply]');
  process.exit(2);
}

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');
const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: (.*)/;
const location = /^location:\s+variable ([A-Za-z_$][\w$]*) of type Object$/;
const nextCall = /^\s*([A-Za-z_$][\w$.<>\[\], ]+?)\s+[A-Za-z_$][\w$]*\s*=\s*([A-Za-z_$][\w$]*)\.next\(\);$/;

/** @type {Map<string, {file: string, variable: string, type: string}>} */
const targets = new Map();
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed || !parsed[3].includes('cannot find symbol')) continue;
  const call = (log[i + 1] ?? '').replace('[javac] ', '').trim().match(nextCall);
  if (!call) continue;
  const [, loopType, variable] = call;
  if (!/^[A-Za-z_$][\w$]*$/.test(loopType.trim())) continue;
  let located = null;
  for (let j = i + 2; j < Math.min(i + 12, log.length); j++) {
    const stripped = (log[j] ?? '').replace('[javac] ', '').trim();
    if (stripped.startsWith('location:')) {
      located = stripped.match(location)?.[1] ?? null;
      break;
    }
    if (diagnostic.test(log[j] ?? '')) break;
  }
  if (located !== variable) continue;
  targets.set(`${parsed[1]}\u0000${variable}`, { file: parsed[1], variable, type: loopType.trim() });
}

let changed = 0;
const skipped = [];
for (const entry of targets.values()) {
  const path = resolve(root, 'src', entry.file);
  const lines = readFileSync(path, 'utf8').split('\n');
  const declaration = new RegExp(`^(\\s*)Object\\s+${entry.variable}\\s*=\\s*(.+)\\.iterator\\(\\);\\s*$`);
  const declIndex = lines.findIndex((line) => declaration.test(line));
  if (declIndex < 0) {
    skipped.push(`${entry.file}: Object ${entry.variable} = <expr>.iterator() not found`);
    continue;
  }
  const loopIndex = lines.findIndex((line) => line.includes(`while (${entry.variable}.hasNext())`));
  if (loopIndex < 0 || loopIndex < declIndex) {
    skipped.push(`${entry.file}: while (${entry.variable}.hasNext()) not found`);
    continue;
  }
  const reuse = lines.findIndex((line, i) => i > loopIndex &&
    new RegExp(`(^|[^\\w$])${entry.variable}\\s*=\\s*StringHelper\\.([Ff])ormat\\(`).test(line));
  if (reuse < 0) {
    skipped.push(`${entry.file}: ${entry.variable} is not reused as a StringHelper.format result`);
    continue;
  }
  const iterator = `${entry.variable}Iterator`;
  const declarationMatch = lines[declIndex].match(declaration);
  lines[declIndex] = `${declarationMatch[1]}String ${entry.variable};\n`
    + `${declarationMatch[1]}Iterator<${entry.type}> ${iterator} = ${declarationMatch[2]}.iterator();`;
  lines[loopIndex] = lines[loopIndex].replace(`while (${entry.variable}.hasNext())`, `while (${iterator}.hasNext())`);
  const nextIndex = lines.findIndex((line, i) => i > declIndex && i <= loopIndex + 4 &&
    new RegExp(`=\\s*${entry.variable}\\.next\\(\\);`).test(line));
  if (nextIndex >= 0) {
    lines[nextIndex] = lines[nextIndex].replace(`${entry.variable}.next()`, `${iterator}.next()`);
  }
  const body = lines.join('\n');
  if (!body.includes('import java.util.Iterator;')) {
    const utilImport = lines.findIndex((line) => line.trim() === 'import java.util.HashMap;');
    if (utilImport >= 0) lines.splice(utilImport + 1, 0, 'import java.util.Iterator;');
    else lines.unshift('import java.util.Iterator;');
  }
  if (apply) writeFileSync(path, lines.join('\n'));
  changed++;
  console.log(`${entry.file}: String ${entry.variable} + Iterator<${entry.type}> ${iterator}`);
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} locals ${apply ? 'split' : 'eligible'} (use --apply to update)`);
