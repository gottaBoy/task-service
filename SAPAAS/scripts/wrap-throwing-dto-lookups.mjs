#!/usr/bin/env node
/*
 * wrap-throwing-dto-lookups.mjs
 *
 * Problem (decompiled Task SAPAAS source):
 *   `IPSDEEditFormItemImpl` / `PSDEGridDataItemImpl` style value-type resolvers were
 *   decompiled into labelled blocks:
 *
 *       block7: {
 *           IPSAppDEMethodDTOField iPSAppDEMethodDTOField;
 *           block8: {
 *               IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();   // throws Exception
 *               if (iPSAppDEMethodDTO == null || (iPSAppDEMethodDTOField =
 *                       iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true)) == null)
 *                   break block7;                                                   // throws Exception
 *               ...
 *   `IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception` (and
 *   `getPSAppDEMethodDTOField(...) throws Exception`) cannot be caught by the caller
 *   because the enclosing method declares no `throws` and (in some variants) is
 *   itself an override.
 *
 * Fix: split the declaration out, wrap the initialisation + its null guard in
 *       try { ... } catch (Exception ex) { log.error((Object)ex); break blockNN; }
 *   The `break blockNN` mirrors the existing null guard, so the "not applicable"
 *   fall-through path (which ends in `return strValue;`) is unchanged.
 *
 * Guards:
 *   - the initialiser must contain `getPSAppDEMethodDTO`,
 *   - the next non-blank line must be the matching `if (...) break blockNN;` guard,
 *   - the labelled block targeted by `break blockNN` must be an enclosing block,
 *   - the nearest enclosing blocks must not already contain a `try` (idempotent),
 *   - the file must use `log.error`.
 *
 * Usage:
 *   node wrap-throwing-dto-lookups.mjs <srcRoot> [--apply]
 */

import fs from 'node:fs';
import path from 'node:path';

const args = process.argv.slice(2);
const apply = args.includes('--apply');
const root = args.find((a) => !a.startsWith('--'));
if (!root) {
  console.error('usage: node wrap-throwing-dto-lookups.mjs <srcRoot> [--apply]');
  process.exit(2);
}

const CONTROL = /^(if|for|while|switch|do|else|try|catch|finally|synchronized|block\d*:|[A-Za-z_$][\w$]*:(\s|$))/;
const isMethodDecl = (t) => t.endsWith('{') && t.includes('(') && !CONTROL.test(t);

function enclosingOpeners(lines, i, indent) {
  const res = [];
  let cur = indent;
  for (let j = i - 1; j >= 0; j--) {
    const t = lines[j].trim();
    if (!t) continue;
    const ji = lines[j].length - lines[j].trimStart().length;
    if (ji >= cur) continue;
    res.push(t);
    cur = ji;
    if (isMethodDecl(t) || ji === 0) break;
  }
  return res;
}

function walk(dir, out = []) {
  for (const e of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, e.name);
    if (e.isDirectory()) walk(p, out);
    else if (e.name.endsWith('.java')) out.push(p);
  }
  return out;
}

const DECL = /^([A-Za-z_$][\w$.]*(?:\s*<[^;=]*>)?(?:\[\])?)\s+([A-Za-z_$][\w$]*)\s*=\s*(.+);$/;
const GUARD = /^if\s*\(.*\)\s*break\s+(block\d+);$/;

const files = walk(root);
let changedFiles = 0;
let wrapped = 0;
const skipped = [];
const perFile = [];

for (const file of files) {
  const text = fs.readFileSync(file, 'utf8');
  if (!text.includes('getPSAppDEMethodDTO')) continue;
  const hasLog = /log\.error\(/.test(text);
  const lines = text.split('\n');
  const out = [];
  let n = 0;

  for (let i = 0; i < lines.length; i++) {
    const line = lines[i];
    const trimmed = line.trim();
    const indent = line.length - line.trimStart().length;
    const m = trimmed.match(DECL);

    if (!m || !m[3].includes('getPSAppDEMethodDTO') || !trimmed.endsWith(';')) {
      out.push(line);
      continue;
    }

    // next non-blank line must be the matching null guard
    let k = i + 1;
    while (k < lines.length && !lines[k].trim()) k++;
    const g = k < lines.length ? lines[k].trim().match(GUARD) : null;
    const guardVar = g ? g[0] : '';
    const target = g ? g[1] : null;
    if (!g || !guardVar.includes(m[2])) {
      out.push(line);
      continue;
    }

    const openers = enclosingOpeners(lines, i, indent);
    if (openers.some((o) => o.startsWith('try'))) {
      skipped.push(`${path.relative(root, file)}:${i + 1} already in try`);
      out.push(line);
      continue;
    }
    if (!openers.some((o) => o.startsWith(target + ':'))) {
      skipped.push(`${path.relative(root, file)}:${i + 1} target ${target} not enclosing`);
      out.push(line);
      continue;
    }
    if (!hasLog) {
      skipped.push(`${path.relative(root, file)}:${i + 1} no log.error`);
      out.push(line);
      continue;
    }

    const pad = line.slice(0, indent);
    out.push(`${pad}${m[1]} ${m[2]};`);
    out.push(`${pad}try {`);
    out.push(`${pad}   ${m[2]} = ${m[3]};`);
    out.push(`${pad}   ${lines[k].trim()}`);
    out.push(`${pad}}`);
    out.push(`${pad}catch (Exception ex) {`);
    out.push(`${pad}   log.error((Object)ex);`);
    out.push(`${pad}   break ${target};`);
    out.push(`${pad}}`);
    i = k; // consume the guard line too
    n++;
  }

  if (n > 0) {
    changedFiles++;
    wrapped += n;
    perFile.push(`${path.relative(root, file)}: ${n}`);
    if (apply) fs.writeFileSync(file, out.join('\n'));
  }
}

console.log(`files scanned        : ${files.length}`);
console.log(`files needing change : ${changedFiles}`);
console.log(`lookups wrapped      : ${wrapped}`);
if (skipped.length) console.log(`\nskipped:\n  ${skipped.join('\n  ')}`);
if (perFile.length) console.log(`\n${perFile.join('\n')}`);
console.log(apply ? '\nAPPLIED' : '\nDRY RUN (use --apply to write)');
