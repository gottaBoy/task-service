# Task 30088 Source Build Audit

## Status (latest source build)

The independent source-built WAR now exists (see below). The source-built Docker
image is **not yet available**.
Do not use the healthy external `task` container as proof of this build.
The local source-build path uses JDK 8, Ant 1.10.18 and Tomcat 9; see
`Dockerfile.source` and `SAPAAS/resources/classes/build.xml`.

As of `rnext81` the recovered tree **compiles cleanly**: the whole-tree
diagnostic reports `status: "compiled"`, exit code 0 and 0 errors, and `ant war`
builds `SAPAAS.war`. The first source-built WAR is preserved at
`.artifacts/source-war-out/target/SAPAAS.war` (197,466,395 bytes, sha256
`ebf60cf1c0ebdd064f4cfb950fb1ce637fd334642650deaae0a3f2a157ffef2a`, 49,093
entries, 40,461 `.class` files and zero `.java` files under `WEB-INF/classes`,
213 third-party jars under `WEB-INF/lib`). It is therefore a build of the
recovered source, not a repackaging of the external image's self-developed
binaries. The latest diagnostic log is
`.artifacts/source-build-continue-rnext81/javac.log`, with
fail-closed status in the adjacent `diagnostics.json`. This uses the pinned
Docker toolchain, a read-only source bind mount and a disposable volume for
Ant output; it does not modify the host's `SAPAAS/target`. Dependency
verification passed 200/200, and source preflight passed after scanning
33,503 Java files. Compilation of 33,490 sources reported **17 errors**
in **15 files** at `rnext39`; from `rnext40` on javac reports the remaining
defects one offending file per run, so later counts are per-file rather than
tree-wide. Recent
whole-tree diagnostics reported 35 (`rnext38`), 47 (`rnext37`),
65 (`rnext36`), 81 (`rnext35`), 90 (`rnext34`), 97 (`rnext33`),
104 (`rnext32`), 110 (`rnext31`), 116 (`rnext30`), 125 (`rnext29`),
138 (`rnext27`), 151 (`rnext26`), 162 (`rnext25`), 192 (`rnext24`),
218 (`rnext23`), 755 (`rnext22`) and 1,599 (`rnext17`) errors. The
`rnext23`-`rnext35` drops came from six diagnostic-driven repair scripts in
`SAPAAS/scripts`: `restore-raw-collection-generics.mjs` (raw `java.util`
collection locals gain their element type; a local is rewritten only when every
diagnosed loop or element getter over it resolves to one declaration and agrees
on one simple element type), `restore-object-argument-casts.mjs` (drops a
redundant `(Object)` cast on a call javac rejected),
`restore-prepared-statement-types.mjs` (`Statement` locals assigned from
`prepareStatement` become `PreparedStatement`),
`restore-declared-types.mjs` (a local whose declared type contradicts the
assigned expression is retyped, excluding `Object`, array and invariance cases
and any local that is reassigned) and `restore-iterator-locals.mjs` (a local
used first as a collection iterator and later as a `String` is split into an
`Iterator<T>` and a `String`) and `restore-object-use-casts.mjs` (a local
declared `Object` but used with a concrete method gains a cast at that use site,
the type taken from its nearest casted assignment) and
`restore-default-constructors.mjs` (a non-abstract class whose superclass
constructor throws gains an explicit `public X() throws Exception`; 1056
classes). The `rnext40`-`rnext54` phase removed the remaining flow and
exception artifacts one file at a time: that constructor gap, a declared
`access$000` synthetic accessor, unreachable `break` statements,
`missing return` cases, and checked exceptions thrown by decompiled
reflection, IO and DB calls that must be caught locally because the enclosing
interface method cannot declare `throws`. The `rnext55`-`rnext73` phase added
two further diagnostic-driven scripts, `wrap-throwing-ajax-action-lookups.mjs`
(45 call sites: a getter that only forwards to
`getPSAjaxHandlerAction(String, boolean) throws Exception`, which cannot be
caught by the caller because the getter is an override with no `throws`, is
wrapped in `try`/`catch` returning `null`, mirroring the shape the decompiler
already produced for the sibling `getGetPSControlAction` methods) and
`wrap-throwing-dto-lookups.mjs` (a `getPSAppDEMethodDTO()`-style lookup and its
null guard inside a labelled block are split so the declaration stays outside
and the initialisation plus guard sit in a `try` whose `catch` re-uses the
block's existing `break blockNN` fall-through). It also cleared the
`*PubHelpImpl.create*` family (9 call sites), the `PSLinkDEFieldImpl`
link-field lookups (guarded exactly like the sibling class in
`saibz5modelprolib`), and the `getPSModelHelper(...)` lookups in
`SysBeginPubCodePSSysDevBKTaskImpl`.

Three DevStudio task classes (`PSCodePreviewPSSysDevBKTaskImpl`,
`PSDynaInstPreviewPSSysDevBKTaskImpl`, `PSSFPreviewPSSysDevBKTaskImpl`) needed a
reconstruction rather than a mechanical repair: their `onRun` bodies contained an
unguarded copy of the "job cancelled" branch (`setActionState(40)`,
`setActionResult("作业被取消")`, `return null;`) placed directly before the
`setActionState(20)` block, which made every following statement unreachable
(`javac: unreachable statement`). The duplicated branch was verified to be
pre-existing decompiler output (present at `HEAD`), not a repair artefact. It was
restored as `if (this.isCancel()) { ... return null; }`, matching the sibling
cancel branch that is already guarded in the same methods; the deploy work that
follows is itself guarded by `if (!this.isCancel())`, so the cancellation outcome
is unchanged while the deploy path becomes reachable again.

Earlier drops also came
from per-file work: splits of locals the decompiler had reused for two
unrelated types (for example `PSDevSlnSysRefService.getPSDevSlnSys`, whose
`entityBase` held both a `PSDevSlnSysRef` and a `PSDevSlnSys`, and
`PSJITWFInteractiveProcessModel.onInit`, whose `procRole`/`procRole2` spanned
`WFProcRoleModelBase` subclasses) and map/collection locals typed from their
concrete use. The prior
Docker image build
(`.artifacts/source-build-continue-20260929/full-r7/source-build.json`)
failed with 8,816 errors and BuildKit omitted portions of the diagnostics.
The WAR and the image described above are the first source-built artefacts.

The source-built runtime image was then produced with the repository's own
fail-closed entry point (`SAPAAS/scripts/build-source.sh`), recorded in
`.artifacts/source-build-image/source-build.json` as `aibiz/task7:source-built`
(`sha256:70a52657843e1b88ac90b36fab020e307ac5c008e85e7bfde3a35cedd61a667e`).
Runtime smoke test on a spare port with the audited container's environment:
Tomcat deployed `/usr/local/tomcat/webapps/SAPAAS.war` in 104 s,
`Server startup in [104506] ms`, no `SEVERE` entries, the model layer registered
its DAOs, and `/SAPAAS/index.jsp` answered `302` exactly like the audited
deployment. Two differences from the audited deployment remain: the
context-root welcome page `SAPAAS/default.htm` (382 bytes, dated 2010-01-19) is
absent from the recovered `SAPAAS/webapp` tree, so `GET /SAPAAS/` returns 404
instead of the redirect to `srfpage/index_real.jsp`; and the large generated
webapp directories of the audited deployment (`saps` 14,147 files, `srf` 576,
`srfds` 473, `configex_srfadv` 456, `configex_runtime` 49, `commonex` 13) are not
in the WAR - the recovered source references them (for example `srfds` appears
in 28 Java files) and `jscache` was demonstrably created at runtime by our own
container, so they needed classification - see the web-resource gap below. `GET /` returning 404 is by design of `Dockerfile.source`,
which deletes every other webapp and deploys only `SAPAAS.war`.

The context-root gap has since been closed: `SAPAAS/webapp/default.htm` now
carries a reconstructed 572-byte welcome page that performs the same redirect to
`srfpage/index_real.jsp` as the vendor page (the vendor original is 382 bytes,
GBK-encoded, md5 `f9a12a8944918811e5bef3d9b183cf29`; its payload was not copied,
the page is written here and the provenance is recorded in this file). After
rebuilding, `aibiz/task7:source-built`
(`sha256:ae88a676b85a07a3d10b89ea3e996f580bb0f95fa7b2488ece656cdd8c60b465`, WAR
`sha256:2dfe5b3e0190ac93b249e28ba5e387e64e977a6ddc9ac17b511bf341713bc44a`)
answers `GET /SAPAAS/` with 200 and `GET /SAPAAS/index.jsp` with 302, matching
the audited deployment.

Runtime equivalence was then checked path by path against the audited
deployment instead of being asserted. Static and dynamic responses match
exactly (`ours`/`audited`): `/SAPAAS/` 200/200, `/SAPAAS/index.jsp` 302/302,
`/SAPAAS/uacclient/uaclogin.jsp` 200/200, `/SAPAAS/uacclient/uaclogin2.jsp`
302/302, `/SAPAAS/uacclient/uaclogin_formaction.jsp` 200/200,
`/SAPAAS/srfpage/index_real.jsp` 302/302, `/SAPAAS/default.htm` 200/200 and
`/SAPAAS/css/` 404/404. The dynamic pages carry the most weight because those
JSPs instantiate recovered classes
(`SA.SRFDA.UAC.Client.Web.LoginPage`), and the container log shows that code
executing: the vendor SSO filter builds
`http://cas.ibizcloud.cn:8080/SAUAC/login?service=...` inside our image, just as
it does in the audited one.

A full interactive login cannot be completed in this environment, and that is
pre-existing rather than a defect of the source build: `web.xml` points
authentication at the external UAC/CAS endpoints
`http://cas.ibizcloud.cn:8080/SAUAC/login` and
`http://192.168.100.5:8050/SAUA/login/login.jsp`, neither of which is part of the
local stack, so the audited deployment fails in the same way. The
end-to-end item is therefore closed as **environment-limited**, with path-by-path
A/B equivalence as the evidence rather than a successful login.

The whole flow is now reproducible as a single gate:
`SAPAAS/scripts/selftest-source-build.sh` clones HEAD into a temp directory,
builds the WAR from that clone, asserts the WAR really is a source build
(compiled classes present, no `.java` smuggled in, third-party jars bundled,
context-root welcome page present), builds the runtime image through
`Dockerfile.source`, starts it with the reference deployment's environment on an
ephemeral port, and compares the entry/auth surface path by path with the
reference container. It writes `.artifacts/source-selftest/receipt.json` and
exits non-zero on any failing check. Latest run at `33d95a47`: **PASS** with 0
compiler errors, 40,461 classes, 0 sources in the WAR, 213 bundled jars and 8/8
probes equal (WAR
`sha256:196eda32eb2978e23e7ad659801ccc00e7e42cee4c2e6af7ba9bc72653b58b5d`, image
`aibiz/task7:selftest`
`sha256:8ecd4ede17a87a866c269fe29e2ef6bcf3d66cb8380ab79795d004931c56961e`).
Running the gate found two bugs **in the gate itself**, both worth remembering:
a file that is not committed yet shows up immediately as "exists only outside
git" (which is the point), and `grep -q` inside a pipeline is unsafe under
`set -o pipefail` - grep exits on the first match, the upstream `unzip` dies of
SIGPIPE, and the pipeline reports failure even though the pattern matched, so
the script counts matches instead.

A full interactive login cannot be completed in this environment, and that is

The remaining web-resource gap is now classified rather than unknown. Every one
of those files predates 2026 (mostly 2015-2021, the vendor WAR's own timestamps)
and none appeared during the audited deployment's four days of running, so they
shipped inside the vendor WAR instead of being generated by it; the recovered
`SAPAAS/webapp` tree simply does not contain them, and no bundled jar does
either. By content they are vendor design-time and pre-generated assets rather
than runtime application code:
`saps/pf` (253 MB: DevStudio preview pages such as `deformpreview.jsp`,
`degridpreview.jsp` plus bundled AngularJS/ExtJS front-end libraries),
`srf/javaext/PSSYSMODEL/<modelId>/*.sql` (857 MB, 576 generated SQL scripts),
`srfds` (8.3 MB, 473 designer pages: `codelistdesigner.jsp`,
`customerspformdesigner.jsp`, ...), `configex_srfadv` (2.5 MB, 456 `adv_*`
files), `configex_runtime` (716 KB) and `commonex` (60 KB). The source-built
image serves the application entry and login redirect without them; model
publishing and the DevStudio designer/preview features are the parts that would
need them, so recovering that 1.1 GB (or re-generating it) is a separate
workstream and deliberately not done by copying the vendor binaries.

The 59 self-developed JARs shipped by the external runtime image are excluded
from the source-build classpath. `SAPAAS/lib` contains 200 hash-pinned
third-party JARs; coordinates, origins and compatibility notes are in
`SAPAAS/lib/README.md` and exact digests in `SAPAAS/lib/SHA256SUMS`.
`BuildPreflight --dependencies` checks both the declared count and hashes.

## Blocking Work

1. Whole-tree `javac` now passes. The `rnext23`-`rnext39` phase cleared the
   type/collection defects (755 to 17 errors) and the `rnext40`-`rnext81` phase
   cleared the decompiler flow artifacts - missing constructors for classes
   whose superclass constructor throws, a declared synthetic accessor,
   unreachable statements, `missing return` cases, and checked exceptions from
   reflected/IO/DB calls that must be caught locally. `ant war` now produces
   `SAPAAS.war` (see Status). Note that javac stops attributing as soon as an
   error occurs, so `diagnose-source.sh` only ever revealed about one file per
   run; `SAPAAS/scripts/census-source-errors.sh` overrides the JDK 8 stop policy
   (`-XDshouldStopPolicyIfError=GENERATE`) and reports the whole tail at once -
   the final tail was 23 sites in 9 files, not the single file the normal
   diagnostic suggested.
   What is still missing: the context-root `default.htm` (or an explicit
   decision to serve the context root differently), a deploy/publish run that
   proves the generated webapp directories are regenerated rather than lost in
   recovery, an end-to-end functional check beyond "the server starts and the
   application redirects" (a real login and a rendered page), and committing the
   recovered source plus these repairs.
2. Lucene 3.0.3, HTML Parser 2.1, Quartz 1.8.6, Mule 2.2.1, JML 1.0b4,
   the checked JDBC drivers and Axis2 dependencies have been added since
   the early diagnostic. The full runtime dependency closure is unverified.
   Mondrian's Eigenbase/olap4j/Java CUP dependencies remain unresolved.
   Check `SAPAAS/lib/README.md` for exact versions and scope.
3. IM FTP now issues expiring per-file-ID PBKDF2 credentials and returns
   `PASSWORD` with upload metadata. Focused tests include an actual FTP
   upload with a dynamic credential and denial after revocation (22/22).
   The source-built server, legacy client handling of `PASSWORD`, and
   complete IM Servlet 3 meeting/FTP flow remain unverified. Deployment
   must provide a private credentials file through
   `IBIZ_IM_FTP_CREDENTIALS_FILE` or `ibiz.im.ftp.credentials.file`.
   `Dockerfile.source` creates a private empty file at the default path,
   but the default PLM Compose still runs the external Task image and has
   no source-built Task credential-volume configuration.

`verify-source` still fails closed on any reintroduced decompiler stubs.
Do not bypass the guard or ship placeholder classes or the external
image's self-developed binaries to manufacture a passing build.

## Reproduction

From `task7/` with Apache Ant/JDK 8 installed:

```sh
ant -f SAPAAS/resources/classes/build.xml verify-dependencies
ant -f SAPAAS/resources/classes/build.xml verify-source
ant -f SAPAAS/resources/classes/build.xml war
docker build --progress=plain --target source-build -f Dockerfile.source .
bash SAPAAS/scripts/diagnose-source.sh
bash SAPAAS/scripts/run-focused-tests.sh
```

The host currently has a JRE but no host `ant` or `javac`; use the pinned
Docker builder or install the documented build toolchain. The diagnostic
script captures the full compiler log outside BuildKit output truncation,
uses `TASK_DIAGNOSTIC_DIR` and `TASK_JAVAC_MAX_ERRORS` to control output,
and returns nonzero on failure. The Dockerfile
downloads Ant 1.10.18 with SHA-256
`b45db2fdd76d639301550930d33dd7bc672c9d4fdea0fe8cfd2e6a3518388d59`
and pins the Maven/JDK 8 and Tomcat 9 image manifests.
The pinned Tomcat runtime image reports Tomcat 9.0.122; compilation uses
Tomcat EL API 9.0.100 from `SAPAAS/build-tools/lib` and does not package
that API in the WAR. Presence of JSP/EL API classes in the runtime image
was checked, but no WAR integration test has run.
`run-focused-tests.sh` uses the pinned Maven/JDK 8 builder independently of
the whole-tree gate. It checks the preflight scanner, dependency hashes,
IM FTP credentials/login/upload and EAI transformer configuration. The latest
run of `bash SAPAAS/scripts/run-focused-tests.sh`
passed 200/200 dependencies and 114 tests in 24 suites covering
FTP, EAI configuration, lifecycle, router, data controller, transformer,
endpoint, XML managers, simulated Servlet/JSP, WebEx DP and enum JSON naming. The transformer
and endpoint tests now compile their `BaseDataEntity` dependency from local
source instead of a self-developed JAR. Mule Registry lookup for the EAI
global helper is tested with a proxy; actual Mule XML child context startup
is not yet validated. These focused tests are not end-to-end runtime proof.
EAI JSON's 5 tests now compile against local `BaseDataEntity` source.

Once the entire source tree compiles, deploy the produced WAR in Tomcat 9 and
run actual modeling, PLM, task API, IM and FTP flows against **that image**.
Existing browser regressions against external runtime containers are useful
comparisons but do not fulfill source-build acceptance.

## Historical Evidence

Earlier preflight runs found 77 files / 361 pseudo-syntax matches, then
76 / 360 and 76 / 357 after two repair batches; these were subsequently
repaired further. Logs named `docker-build-after-safe-batch2.log` and the
corresponding `pseudo-syntax-inventory.md` record that **historical** phase,
not the current gate. The later `docker-build-axis2-r2.log` entered `javac`
after pseudo-syntax preflight passed, before the runtime-stub check existed.
No source-built WAR or image resulted from either phase.
The later `.artifacts/source-build-audit/docker-build-eai-config-r4.log`
verified 182/182 pinned JARs and stopped at the 32-file/147-site source
gate. The newer `.artifacts/source-build-audit/docker-build-localization-r5.log`
verified 197/197 pinned JARs and stopped at the 30-file/143-site gate.
The historical `.artifacts/source-build-audit/docker-build-localization-r6.log`
verified 197/197 pinned JARs and stopped at the 28-file/137-site gate.
None of those historical builds reached whole-tree compilation.
