import { readFileSync } from 'node:fs';
import { resolve } from 'node:path';

const [logPath, rootPath = '.'] = process.argv.slice(2);
if (!logPath) {
  console.error('Usage: node check-autoget-diagnostics.mjs BUILD_LOG [TASK7_ROOT]');
  process.exit(2);
}

const root = resolve(rootPath);
const lines = readFileSync(logPath, 'utf8').split(/\r?\n/);
const sources = new Map();
const failures = [];
const files = new Set();
let checked = 0;

for (let index = 0; index < lines.length; index += 1) {
  const match = lines[index].match(
    /SAPAAS\/src\/saibz5studiolib\/([^:]+):(\d+): error: incompatible types: IEntity cannot be converted to (\w+)/,
  );
  if (!match) continue;

  const [, relativePath, lineNumber, entityType] = match;
  const diagnostic = lines[index + 1]?.match(/(\w+)\.autoGet\(\(IEntity\)(\w+)\)/);
  const file = `SAPAAS/src/saibz5studiolib/${relativePath}`;
  files.add(file);
  checked += 1;
  if (!diagnostic) {
    failures.push(`${file}:${lineNumber}: unexpected diagnostic context`);
    continue;
  }

  const [, service, entity] = diagnostic;
  let source = sources.get(file);
  if (!source) {
    source = readFileSync(resolve(root, file), 'utf8').split(/\r?\n/);
    sources.set(file, source);
  }
  const position = Number(lineNumber) - 1;
  const line = source[position]?.trim();
  const context = source.slice(Math.max(0, position - 12), position + 1).join('\n');
  const entityDeclaration = `${entityType} ${entity} = new ${entityType}(`;
  const serviceDeclaration = `${entityType}Service ${service} =`;
  if (
    line !== `${service}.autoGet(${entity});` ||
    !context.includes(entityDeclaration) ||
    !context.includes(serviceDeclaration)
  ) {
    failures.push(`${file}:${lineNumber}: typed entity/service or autoGet call differs from diagnostic`);
  }
}

if (checked === 0) failures.push('No matching studiolib IEntity diagnostics found');
if (failures.length > 0) {
  console.error(failures.slice(0, 20).join('\n'));
  console.error(`${failures.length} of ${checked} diagnostics failed verification`);
  process.exit(1);
}
console.log(`Verified ${checked} autoGet calls in ${files.size} studiolib files`);
