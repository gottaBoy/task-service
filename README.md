# task-service

iBiz Task/SAPAAS service source import.

## Layout

- `SAPAAS/`: Tomcat web application source, resources, web assets, and startup script.
- `TEMPL_TASK/`: task generation templates used by the runtime image.
- `TEMPL_APP/`: application generation templates used by the runtime image.
- `githelp.py.ftl`: replacement template copied by the legacy image entrypoint.

## Runtime

The current local stack runs Task through the prebuilt image
`task7:v124.2.opensource.25082603` and the wrapper in
`aibiz-scripts` (`scripts/task-entrypoint.sh`). This repository is the source
baseline for future source-level changes and custom image builds.

The Java source was recovered from the self-developed JARs in the Task image.
See `SAPAAS/JAR-MANIFEST.md` for the JAR inventory and decompilation summary.
The baseline is intended to preserve byte-for-byte source files, so Git line
ending normalization is disabled in `.gitattributes`.
