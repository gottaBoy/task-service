#!/usr/bin/env node
/*
 * Restore element generics on raw collection locals that the decompiler left
 * untyped. Keyed off a javac diagnostic log: for every
 *
 *   Foo.java:123: error: incompatible types: Object cannot be converted to T
 *       for (T item : rawLocal) {
 *
 * where `rawLocal` is declared as a raw java.util collection in the same file,
 * the declaration gains an element type parameter (`Vector rawLocal` ->
 * `Vector<T> rawLocal`). A local is only touched when every diagnostic loop
 * over it agrees on a single, simple element type, mirroring the guard in
 * restore-modelapi-generics.mjs.
 *
 * Usage: node SAPAAS/scripts/restore-raw-collection-generics.mjs <javac.log> [--apply]
 */
import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const RAW_COLLECTIONS = new Set([
  'List', 'ArrayList', 'Vector', 'Collection', 'Set', 'HashSet',
  'LinkedList', 'TreeSet', 'TreeMap', 'Stack', 'LinkedHashSet',
]);

const apply = process.argv.includes('--apply');
const logPath = process.argv[2];
if (!logPath || logPath.startsWith('--')) {
  console.error('Usage: node SAPAAS/scripts/restore-raw-collection-generics.mjs <javac.log> [--apply]');
  process.exit(2);
}

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(logPath, 'utf8').split('\n');

const diagnostic = /SAPAAS\/src\/(.+?):(\d+): error: incompatible types: Object cannot be converted to (.+)/;
const foreach = /for \(\s*([\w$.<>\[\], ]+?)\s+(\w+)\s*:\s*([A-Za-z_$][\w$]*)\s*\)\s*\{?\s*$/;
const getter = /=\s*([A-Za-z_$][\w$]*)\.(?:get|remove|elementAt|firstElement|lastElement)\s*\(/;
const declaration = /^(\s*)([\w$.]+)\s+([A-Za-z_$][\w$]*)\s*[=;]/;

// Collect every diagnosed raw for-each error as (file, loop line, element
// type, iterable).
const loops = [];
for (let i = 0; i < log.length; i++) {
  const parsed = (log[i] ?? '').replace('[javac] ', '').match(diagnostic);
  if (!parsed) continue;
  const [, file, line, target] = parsed;
  const code = (log[i + 1] ?? '').replace('[javac] ', '').trim();
  let iterable;
  const loop = code.match(foreach);
  if (loop) {
    const [, loopType, , name] = loop;
    if (loopType.trim() !== target.trim()) continue;
    iterable = name;
  } else {
    const get = code.match(getter);
    if (!get) continue;
    iterable = get[1];
  }
  loops.push({ file, line: Number(line), target: target.trim(), iterable });
}

const fileCache = new Map();
const readLines = (file) => {
  if (!fileCache.has(file)) {
    fileCache.set(file, readFileSync(resolve(root, 'src', file), 'utf8').split('\n'));
  }
  return fileCache.get(file);
};

// Group by the declaration each loop resolves to, not by variable name: the
// decompiler reuses a name across scopes, and those are different locals.
/** @type {Map<string, {file: string, declIndex: number, variable: string, types: Set<string>, loops: number[]}>} */
const targets = new Map();
const skipped = [];
for (const loop of loops) {
  const lines = readLines(loop.file);
  let declIndex = -1;
  for (let i = loop.line - 2; i >= Math.max(0, loop.line - 1 - 400); i--) {
    const parsed = lines[i]?.match(declaration);
    if (parsed && parsed[3] === loop.iterable) {
      declIndex = i;
      break;
    }
  }
  if (declIndex < 0) {
    skipped.push(`${loop.file}:${loop.line}: declaration of ${loop.iterable} not found`);
    continue;
  }
  const key = `${loop.file}\u0000${declIndex}`;
  const entry = targets.get(key) ??
    { file: loop.file, declIndex, variable: loop.iterable, types: new Set(), loops: [] };
  entry.types.add(loop.target);
  entry.loops.push(loop.line);
  targets.set(key, entry);
}

const byFile = new Map();
for (const entry of targets.values()) {
  if (!byFile.has(entry.file)) byFile.set(entry.file, []);
  byFile.get(entry.file).push(entry);
}

let changed = 0;
for (const [file, entries] of byFile) {
  const lines = readLines(file).slice();
  let dirty = false;
  for (const entry of entries) {
    if (entry.types.size !== 1) {
      skipped.push(`${file}:${entry.declIndex + 1}: ${entry.variable} has mixed element types ${[...entry.types].join(', ')}`);
      continue;
    }
    const [type] = entry.types.values();
    if (!/^[A-Za-z_$][\w$]*$/.test(type)) {
      skipped.push(`${file}:${entry.declIndex + 1}: ${entry.variable} element type is not a simple name (${type})`);
      continue;
    }
    const parsed = lines[entry.declIndex].match(declaration);
    const rawName = parsed[2].split('.').pop();
    if (!RAW_COLLECTIONS.has(rawName)) {
      skipped.push(`${file}:${entry.declIndex + 1}: ${entry.variable} declared as ${parsed[2]}, not a raw java.util collection`);
      continue;
    }
    if (parsed[2].includes('<')) continue;
    const next = lines[entry.declIndex].replace(
      new RegExp(`(\\b${rawName.replace('.', '\\.')})\\s+${entry.variable}\\b`),
      `$1<${type}> ${entry.variable}`,
    );
    if (next === lines[entry.declIndex]) continue;
    lines[entry.declIndex] = next;
    dirty = true;
    changed++;
    console.log(`${file}:${entry.declIndex + 1}: ${rawName}<${type}> ${entry.variable} (loops at ${entry.loops.join(',')})`);
  }
  if (apply && dirty) writeFileSync(resolve(root, 'src', file), lines.join('\n'));
}

for (const note of skipped) console.log(`SKIP ${note}`);
console.log(`${changed} declarations ${apply ? 'updated' : 'eligible'} in ${loops.length} diagnosed loops (use --apply to update)`);
