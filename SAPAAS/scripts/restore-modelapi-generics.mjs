#!/usr/bin/env node
import { readFileSync, readdirSync, writeFileSync } from 'node:fs';
import { join } from 'node:path';

const root = new URL('../src/saibz5modelbase/net/ibizsys/modelapi/', import.meta.url).pathname;
const directories = [root, join(root, 'service', 'impl')];
const apply = process.argv.includes('--apply');
let changed = 0;

for (const directory of directories) {
  for (const name of readdirSync(directory).filter((entry) => entry.endsWith('.java'))) {
    const path = join(directory, name);
    const original = readFileSync(path, 'utf8');
    const lines = original.split('\n');
    for (let i = 0; i < lines.length; i++) {
      const declaration = lines[i].match(
        /^(\s*)List ([a-zA-Z_$][\w$]*) = PSModelServiceUtil\.getInstance\(\)\.\w+Service\(\)\.listAll(DTO)?\(\);$/,
      );
      if (!declaration) continue;
      const [, indent, variable, dto] = declaration;
      const following = lines.slice(i + 1, i + 8).join('\n');
      const loop = following.match(
        new RegExp(`for \\(([A-Za-z_$][\\w$]*) \\w+ : ${variable}\\) \\{`),
      );
      if (!loop || Boolean(dto) !== loop[1].endsWith('DTO')) continue;
      const type = loop[1];
      if (!original.includes(`import net.ibizsys.modelapi.${dto ? 'dto' : 'domain'}.${type};`)) {
        continue;
      }
      lines[i] = `${indent}List<${type}> ${variable} = ${lines[i].slice(declaration[0].indexOf(' = ') + 3)}`;
      changed++;
      console.log(`${path.slice(root.length)}:${i + 1}: List<${type}>`);
    }
    for (let i = 0; i < lines.length; i++) {
      const declaration = lines[i].match(
        /^(\s*)List<PSModelBase> list = (PSModelServiceUtil\.getInstance\(\)\.\w+Service\(\)\.listBy\w+\(t\));$/,
      );
      if (!declaration) continue;
      let branch = i;
      do {
        const first = branch === i;
        const assignment = first
          ? declaration[2]
          : lines[branch].match(
            /^\s*if \(\(list = (PSModelServiceUtil\.getInstance\(\)\.\w+Service\(\)\.listBy\w+\(t\))\) != null && list\.size\(\) > 0\) \{$/,
          )?.[1];
        if (!assignment) break;
        const offset = lines.slice(branch + 1, branch + 6)
          .findIndex((line) => /^\s*for \(\w+ \w+ : list\) \{$/.test(line));
        if (offset < 0) break;
        const loopIndex = branch + offset + 1;
        const type = lines[loopIndex].match(/for \((\w+) \w+ : list\)/)?.[1];
        if (!type || !original.includes(`import net.ibizsys.modelapi.domain.${type};`)) break;
        const variable = `${type[0].toLowerCase()}${type.slice(1)}List`;
        if (first) {
          lines[branch] = `${declaration[1]}List<${type}> ${variable} = ${assignment};`;
          lines[branch + 1] = lines[branch + 1]
            .replace(/\blist\b/g, variable);
        } else {
          const indent = lines[branch].match(/^\s*/)[0];
          lines[branch] = `${indent}List<${type}> ${variable} = ${assignment};\n`
            + `${indent}if (${variable} != null && ${variable}.size() > 0) {`;
        }
        lines[loopIndex] = lines[loopIndex].replace(': list)', `: ${variable})`);
        changed++;
        console.log(`${path.slice(root.length)}:${branch + 1}: List<${type}> ${variable}`);
        const next = lines.slice(loopIndex + 1).findIndex(
          (line) => /^\s*if \(\(list = PSModelServiceUtil\.getInstance\(\)/.test(line),
        );
        if (next < 0) break;
        branch = loopIndex + next + 1;
      } while (branch < lines.length);
    }
    for (let i = 0; i < lines.length; i++) {
      const declaration = lines[i].match(/^(\s*)List ([a-zA-Z_$][\w$]*);$/);
      if (!declaration) continue;
      const [, indent, variable] = declaration;
      const following = lines.slice(i + 1, i + 70).join('\n');
      if (!new RegExp(
        `\\(${variable} = PSModelServiceUtil\\.getInstance\\(\\)\\.\\w+Service\\(\\)\\.listAll(DTO)?\\(\\)\\)`,
      ).test(following)) continue;
      const loopTypes = [...following.matchAll(
        new RegExp(`for \\(([A-Za-z_$][\\w$]*) \\w+ : ${variable}\\) \\{`, 'g'),
      )].map((match) => match[1]);
      const types = [...new Set(loopTypes)];
      if (types.length !== 1) continue;
      const type = types[0];
      if (!original.includes(`import net.ibizsys.modelapi.${type.endsWith('DTO') ? 'dto' : 'domain'}.${type};`)) {
        continue;
      }
      lines[i] = `${indent}List<${type}> ${variable};`;
      changed++;
      console.log(`${path.slice(root.length)}:${i + 1}: List<${type}>`);
    }
    if (apply && lines.join('\n') !== original) writeFileSync(path, lines.join('\n'));
  }
}
console.log(`${changed} declarations ${apply ? 'updated' : 'eligible'} (use --apply to update)`);
