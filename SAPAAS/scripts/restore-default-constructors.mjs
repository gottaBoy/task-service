#!/usr/bin/env node
/*
 * Add the missing explicit constructor to classes whose implicit default
 * constructor cannot be generated because a superclass constructor declares
 * `throws Exception`:
 *
 *   public class Foo extends FooBase {   // FooBase() throws Exception
 *       private static final long serialVersionUID = -1L;
 *   }
 *
 * becomes
 *
 *   public class Foo extends FooBase {
 *       private static final long serialVersionUID = -1L;
 *
 *       public Foo() throws Exception {
 *           super();
 *       }
 *   }
 *
 * Only non-abstract classes that declare no constructor of their own and whose
 * superclass chain leads to a throwing no-arg constructor are touched. Classes
 * outside the source tree are treated as non-throwing.
 *
 * Usage: node SAPAAS/scripts/restore-default-constructors.mjs [--apply]
 */
import { readFileSync, readdirSync, statSync, writeFileSync } from 'node:fs';
import { dirname, join, relative, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const apply = process.argv.includes('--apply');
const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const srcRoot = resolve(root, 'src');

const walk = (dir, out = []) => {
  for (const entry of readdirSync(dir)) {
    const full = join(dir, entry);
    if (statSync(full).isDirectory()) walk(full, out);
    else if (entry.endsWith('.java')) out.push(full);
  }
  return out;
};

const classRe = /^(?:(?:public|protected|private)\s+)?(?:(?:abstract|final|static)\s+)*class\s+(\w+)(?:\s*<[^>]*>)?\s*(?:\n\s*)?extends\s+([\w$.]+)/m;

/** @type {Map<string, {file: string, base: string, abstract: boolean, ctorThrows: boolean|null, src: string}>} */
const classes = new Map();
const files = walk(srcRoot);
for (const file of files) {
  const src = readFileSync(file, 'utf8');
  const match = src.match(classRe);
  if (!match) continue;
  const name = match[1];
  const ctorRe = new RegExp(`^\\s*(?:public|protected|private)?\\s*${name}\\s*\\([^;{]*\\)\\s*(throws[^{;]*)?\\{`, 'm');
  const ctor = src.match(ctorRe);
  classes.set(name, {
    file,
    base: match[2].split('.').pop(),
    abstract: /abstract/.test(match[0]),
    ctorThrows: ctor ? Boolean(ctor[1]) : null,
    src,
  });
}

const memo = new Map();
const effectiveThrows = (name, seen = new Set()) => {
  if (memo.has(name)) return memo.get(name);
  if (seen.has(name) || !classes.has(name)) return false;
  seen.add(name);
  const entry = classes.get(name);
  const result = entry.ctorThrows !== null
    ? entry.ctorThrows
    : effectiveThrows(entry.base, seen);
  memo.set(name, result);
  return result;
};

let changed = 0;
for (const [name, entry] of classes) {
  if (entry.abstract || entry.ctorThrows !== null) continue;
  if (!effectiveThrows(entry.base)) continue;
  const declIndex = entry.src.search(new RegExp(`class\\s+${name}\\b`));
  const braceIndex = entry.src.indexOf('{', declIndex);
  if (braceIndex < 0) continue;
  const constructor = `\n\n    public ${name}() throws Exception {\n        super();\n    }`;
  const updated = `${entry.src.slice(0, braceIndex + 1)}${constructor}${entry.src.slice(braceIndex + 1)}`;
  if (apply) writeFileSync(entry.file, updated);
  changed++;
  console.log(`${relative(srcRoot, entry.file)}: ${name} extends ${entry.base}`);
}
console.log(`${changed} classes ${apply ? 'updated' : 'eligible'} (use --apply to update)`);
