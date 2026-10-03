import { readFileSync, writeFileSync } from 'node:fs';
import { resolve } from 'node:path';

const [logPath, rootPath = '.', mode] = process.argv.slice(2);
if (!logPath || (mode && mode !== '--apply')) {
  console.error('Usage: node fix-typed-service-casts.mjs BUILD_LOG [TASK7_ROOT] [--apply]');
  process.exit(2);
}

const root = resolve(rootPath);
const diagnostics = readFileSync(logPath, 'utf8').split(/\r?\n/);
const changes = new Map();
let candidates = 0;
let skipped = 0;

for (let index = 0; index < diagnostics.length; index += 1) {
  const error = diagnostics[index].match(
    /SAPAAS\/src\/saibz5studiolib\/([^:]+):(\d+): error: (.*)/,
  );
  if (!error) continue;
  const [, relative, lineNumber, message] = error;
  if (
    !message.startsWith('incompatible types: IEntity cannot be converted to ') &&
    !/^no suitable method found for .*IEntity/.test(message)
  ) continue;

  const diagnosticLine = diagnostics[index + 1]?.match(/\[javac\] (.*)$/)?.[1];
  const variable = diagnosticLine?.match(/\(IEntity\)(\w+)/)?.[1];
  if (!variable || relative.includes('..')) {
    skipped += 1;
    continue;
  }

  const file = resolve(root, 'SAPAAS/src/saibz5studiolib', relative);
  if (!changes.has(file)) {
    const original = readFileSync(file, 'utf8');
    changes.set(file, { original, lines: original.split('\n'), edits: 0 });
  }
  const entry = changes.get(file);
  const entity = entry.original.match(/extends PSCoreSysServiceBase<(\w+)>/)?.[1];
  const position = Number(lineNumber) - 1;
  const declaration = entity && new RegExp(`\\b${entity}\\s+${variable}\\b`);
  if (
    !entity ||
    !declaration.test(entry.original) ||
    entry.lines[position] !== diagnosticLine ||
    entry.lines[position].split(`(IEntity)${variable}`).length !== 2
  ) {
    skipped += 1;
    continue;
  }
  const targetType = message.match(/^incompatible types: IEntity cannot be converted to (\w+)/)?.[1];
  if (targetType && targetType !== entity) {
    skipped += 1;
    continue;
  }
  entry.lines[position] = diagnosticLine.replace(`(IEntity)${variable}`, variable);
  entry.edits += 1;
  candidates += 1;
}

const changed = [...changes].filter(([, entry]) => entry.edits > 0);
if (mode === '--apply') {
  for (const [file, entry] of changed) {
    if (readFileSync(file, 'utf8') !== entry.original) {
      throw new Error(`Concurrent change detected: ${file}`);
    }
    writeFileSync(file, entry.lines.join('\n'));
  }
}
console.log(`${mode === '--apply' ? 'Removed' : 'Found'} ${candidates} typed-service casts in ${changed.length} files; skipped ${skipped} diagnostics`);
