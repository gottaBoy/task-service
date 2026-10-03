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

## Source build

The local Ant entry point is `SAPAAS/resources/classes/build.xml`. It verifies
the 154-JAR dependency closure, compiles all recovered Java sources, stages the
web application, and writes `SAPAAS/target/SAPAAS.war`.

From this directory:

```sh
ant -f SAPAAS/resources/classes/build.xml war
```

The same build is used by `Dockerfile.source`:

```sh
docker build -f Dockerfile.source -t task7:source .
```

The dependency provenance and hashes are recorded in `SAPAAS/lib/README.md`
and `SAPAAS/lib/SHA256SUMS`. The source build runs the cross-platform
`BuildPreflight` helper before `javac`; it verifies the dependency manifest and
rejects recovered decompiler control-flow pseudo-syntax. The Unix convenience
wrapper `SAPAAS/scripts/check-source-build.sh` delegates to the same Ant
target. Windows can use `SAPAAS\scripts\check-source-build.cmd`; neither
wrapper is part of the build logic, and the Ant target does not require `sh`,
`grep`, `awk`, or `sha256sum`. `Dockerfile.source` installs Apache Ant
`1.10.18` from a SHA-256-pinned distribution instead of an unpinned OS package.
The current recovered source set passes the pseudo-syntax preflight and
compiles with zero errors; `ant -f SAPAAS/resources/classes/build.xml war`
produces `SAPAAS/target/SAPAAS.war`. Run
`bash SAPAAS/scripts/diagnose-source.sh` for a complete compiler log and
receipt under `.artifacts/source-diagnostics/`.
`bash SAPAAS/scripts/build-source.sh` builds the runtime image from
`Dockerfile.source` and writes its receipt to
`.artifacts/source-build-image/source-build.json`. The script mounts the source
read-only and isolates Ant output in a disposable
Docker volume; `SOURCE-BUILD-AUDIT.md` records the error inventory and the
runtime equivalence checks against the reference deployment.
No prebuilt self-developed JAR is copied into the source build to hide errors.
