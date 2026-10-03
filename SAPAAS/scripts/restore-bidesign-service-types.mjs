import { readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const log = readFileSync(process.argv[2], 'utf8');
const prefix = 'saibz5studiolib/net/ibizsys/pscore/srv/bidesign/service/';
const locations = new Map();
const diagnostic = /SAPAAS\/src\/(saibz5studiolib\/net\/ibizsys\/pscore\/srv\/bidesign\/service\/[^:\r\n]+):(\d+): error: (?:incompatible types: IEntity cannot be converted to |no suitable method found for |cannot find symbol)/g;

for (const match of log.matchAll(diagnostic)) {
  const [, name, line] = match;
  if (!name.startsWith(prefix)) continue;
  if (!locations.has(name)) locations.set(name, new Set());
  locations.get(name).add(Number(line));
}

let changed = 0;
for (const [name, lineNumbers] of locations) {
  const path = resolve(root, 'src', name);
  const original = readFileSync(path, 'utf8');
  const lines = original.split('\n');
  for (const number of lineNumbers) {
    const index = number - 1;
    const next = lines[index]?.replace(/\(IEntity\)(?=[A-Za-z_$][\w$]*)/g, '');
    if (next !== undefined && next !== lines[index]) {
      lines[index] = next;
      changed++;
    }
  }
  const updated = lines.join('\n');
  if (updated !== original && process.argv[3] !== '--dry-run') {
    writeFileSync(path, updated);
  }
}
console.log(`${changed} diagnostic lines in ${locations.size} bidesign service files${process.argv[3] === '--dry-run' ? ' (dry run)' : ''}`);
