#!/usr/bin/env node
/*
 * wrap-throwing-ajax-action-lookups.mjs
 *
 * Problem (decompiled Task SAPAAS source):
 *   A getter such as
 *       public IPSControlAction getCreatePSControlAction() {   // no `throws`
 *           ...
 *           return this.getPSAjaxControlHandler()
 *                      .getPSAjaxHandlerAction("create", true);   // throws Exception
 *       }
 *   does not compile: "unreported exception Exception; must be caught or declared to be thrown".
 *   The declaration `IPSAjaxHandlerAction getPSAjaxHandlerAction(String, boolean) throws Exception`
 *   cannot be changed (it is an interface contract implemented in several places), so the
 *   *call site* has to catch.
 *
 * Fix: wrap the offending single-line `return` statement in
 *       try { <return ...>; }
 *       catch (Exception exAjaxAction) { log.error((Object)exAjaxAction); return null; }
 *   which is exactly the shape the decompiler already produced for the sibling method
 *   `getGetPSControlAction()` in the same class (and the pattern used by the earlier rounds).
 *
 * Guards:
 *   - only single-line `return` statements whose expression contains `).getPSAjaxHandlerAction(`
 *     (method declarations and the delegating `return this.getPSAjaxHandlerAction(a, b);` are skipped),
 *   - skips sites whose nearest enclosing block opener is already `try` (already guarded),
 *   - skips files that do not use `log.error` (would not compile after the wrap),
 *   - idempotent: re-running does not double-wrap (nearest enclosing becomes `try`).
 *
 * Usage:
 *   node wrap-throwing-ajax-action-lookups.mjs <srcRoot>            # dry run
 *   node wrap-throwing-ajax-action-lookups.mjs <srcRoot> --apply    # write
 */

import fs from 'node:fs';
import path from 'node:path';

const args = process.argv.slice(2);
const apply = args.includes('--apply');
const root = args.find((a) => !a.startsWith('--'));
if (!root) {
  console.error('usage: node wrap-throwing-ajax-action-lookups.mjs <srcRoot> [--apply]');
  process.exit(2);
}

const CATCH_VAR = 'exAjaxAction';
const CALL = /\)\.getPSAjaxHandlerAction\(/;

function walk(dir, out = []) {
  for (const e of fs.readdirSync(dir, { withFileTypes: true })) {
    const p = path.join(dir, e.name);
    if (e.isDirectory()) walk(p, out);
    else if (e.name.endsWith('.java')) out.push(p);
  }
  return out;
}

const CONTROL = /^(if|for|while|switch|do|else|try|catch|finally|synchronized|block\d*:|[A-Za-z_$][\w$]*:(\s|$))/;

/** A line that opens a method/constructor body rather than a nested control block. */
function isMethodDecl(t) {
  return t.endsWith('{') && t.includes('(') && !CONTROL.test(t);
}

/**
 * Walk upwards through every enclosing block opener of the statement at `i`.
 * Returns the trimmed openers, innermost first, stopping at the enclosing method.
 */
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

const files = walk(root);
let changedFiles = 0;
let wrapped = 0;
let skippedGuarded = 0;
const perFile = [];

for (const file of files) {
  const text = fs.readFileSync(file, 'utf8');
  if (!text.includes('getPSAjaxHandlerAction(')) continue;
  const hasLog = /log\.error\(/.test(text);
  const lines = text.split('\n');
  const out = [];
  let n = 0;

  for (let i = 0; i < lines.length; i++) {
    const line = lines[i];
    const trimmed = line.trim();
    const indent = line.length - line.trimStart().length;

    const isCandidate =
      trimmed.startsWith('return ') &&
      trimmed.endsWith(';') &&
      CALL.test(trimmed) &&
      !trimmed.includes('throws');

    if (!isCandidate) {
      out.push(line);
      continue;
    }

    const openers = enclosingOpeners(lines, i, indent);
    if (openers.some((o) => o.startsWith('try'))) {
      skippedGuarded++;
      out.push(line);
      continue;
    }
    if (!hasLog) {
      out.push(line);
      continue;
    }

    const pad = line.slice(0, indent);
    out.push(`${pad}try {`);
    out.push(`${pad}   ${trimmed}`);
    out.push(`${pad}}`);
    out.push(`${pad}catch (Exception ${CATCH_VAR}) {`);
    out.push(`${pad}   log.error((Object)${CATCH_VAR});`);
    out.push(`${pad}   return null;`);
    out.push(`${pad}}`);
    n++;
  }

  if (n > 0) {
    changedFiles++;
    wrapped += n;
    perFile.push(`${path.relative(root, file)}: ${n}`);
    if (apply) fs.writeFileSync(file, out.join('\n'));
  }
}

console.log(`files scanned           : ${files.length}`);
console.log(`files needing change    : ${changedFiles}`);
console.log(`call sites wrapped      : ${wrapped}`);
console.log(`skipped (already in try): ${skippedGuarded}`);
if (perFile.length) console.log('\n' + perFile.join('\n'));
console.log(apply ? '\nAPPLIED' : '\nDRY RUN (use --apply to write)');
