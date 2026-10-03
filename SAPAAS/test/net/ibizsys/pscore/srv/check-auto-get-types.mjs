import assert from 'node:assert/strict';
import { readFileSync, readdirSync } from 'node:fs';
import { join, resolve } from 'node:path';

const source = resolve(import.meta.dirname, '../../../../../src/saibz5studiolib');
const allowCasts = process.argv.includes('--allow-casts');

function* javaFiles(dir) {
  for (const entry of readdirSync(dir, { withFileTypes: true })) {
    const path = join(dir, entry.name);
    if (entry.isDirectory()) yield* javaFiles(path);
    else if (entry.name.endsWith('.java')) yield path;
  }
}

const files = [...javaFiles(source)];
const serviceTypes = new Map();
for (const file of files) {
  if (!file.endsWith('ServiceBase.java') && !file.endsWith('Service.java')) continue;
  const text = readFileSync(file, 'utf8');
  const base = text.match(/\bclass\s+(\w+ServiceBase)\s+extends\s+(\w+Service(?:Base)?)<(\w+)>/);
  const bounded = text.match(/\bclass\s+(\w+Service)<\w+\s+extends\s+(\w+)>\s+extends\s+\w+ServiceBase<\w+>/);
  if (!base && !bounded) continue;
  const name = base ? base[1].replace(/Base$/, '') : bounded[1];
  const type = base ? base[3] : bounded[2];
  if (serviceTypes.has(name)) {
    assert.equal(serviceTypes.get(name), type, `ambiguous service ${name}`);
  }
  serviceTypes.set(name, type);
}

let checked = 0;
let casts = 0;
for (const file of files) {
  const text = readFileSync(file, 'utf8');
  const call = /\b(\w+)\.autoGet\(\s*(\(IEntity\))?\s*(\w+)\s*(?:,\s*(?:true|false))?\s*\)/g;
  let checkedInFile = 0;
  for (const match of text.matchAll(call)) {
    const [, service, cast, variable] = match;
    const context = `${file}:${text.slice(0, match.index).split('\n').length}`;
    // Generated entity getters declare and construct their target immediately before loading it.
    const before = text.slice(Math.max(0, match.index - 1800), match.index);
    let entityType;
    let serviceType;
    if (service === 'this') {
      const parameter = [...before.matchAll(new RegExp(`\\b(\\w+)\\s+${variable}\\s*\\)`, 'g'))].at(-1);
      assert.ok(parameter, `${context}: missing parameter declaration for ${variable}`);
      entityType = parameter[1];
      const ownClass = text.match(/\bclass\s+(\w+Service)\s+extends\s+\w+ServiceBase\b/);
      assert.ok(ownClass, `${context}: unknown enclosing service`);
      serviceType = ownClass[1];
    } else {
      const declaration = [...before.matchAll(new RegExp(`\\b(\\w+)\\s+${variable}\\s*=\\s*new\\s+(\\w+)\\s*\\(`, 'g'))].at(-1);
      assert.ok(declaration, `${context}: missing local constructor for ${variable}`);
      assert.equal(declaration[1], declaration[2], `${context}: declared and constructed entities differ`);
      entityType = declaration[1];
      const serviceDeclaration = [...before.matchAll(new RegExp(`\\b(\\w+Service)\\s+${service}\\s*=`, 'g'))].at(-1);
      assert.ok(serviceDeclaration, `${context}: missing declaration for ${service}`);
      serviceType = serviceDeclaration[1];
    }
    assert.equal(serviceTypes.get(serviceType), entityType, `${context}: ${serviceType} does not accept ${entityType}`);
    checked++;
    checkedInFile++;
    if (cast) casts++;
  }
  const totalInFile = [...text.matchAll(/\bautoGet\s*\(/g)].length;
  assert.equal(checkedInFile, totalInFile, `${file}: unrecognized autoGet call shape`);
}

assert.ok(checked > 0, 'no autoGet calls checked');
if (!allowCasts) assert.equal(casts, 0, 'redundant IEntity autoGet arguments remain');
console.log(`Checked ${checked} typed autoGet calls in saibz5studiolib; IEntity casts: ${casts}`);
