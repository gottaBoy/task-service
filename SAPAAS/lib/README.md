# SAPAAS local dependency closure

This directory contains third-party JARs required by the recovered SAPAAS
source tree. The original 154 files are copied byte-for-byte from
the `WEB-INF/lib` directory of the following runtime image:

- image: `swr.ap-southeast-1.myhuaweicloud.com/find1024/task7:v124.2.opensource.25082603`
- digest: `sha256:d2687543cbc31f858a294e2d6436a8c448cb46b58115994b5039cd5984104c2d`
- scope: third-party JARs only; the 59 self-developed JARs are intentionally excluded

The other nine JARs supply the workflow JSON-to-BPMN path that was missing
from that image. Their exact versions and sources are:

| Coordinates | Source |
| --- | --- |
| `org.activiti:activiti-bpmn-model:5.22.0` | Maven Central |
| `org.activiti:activiti-bpmn-converter:5.22.0` | Maven Central |
| `org.activiti:activiti-json-converter:5.22.0` | Maven Central |
| `org.apache.commons:commons-lang3:3.3.2` | Maven Central, Activiti 5.22.0 parent dependency |
| `joda-time:joda-time:2.6` | Maven Central, Activiti 5.22.0 parent dependency |
| `math.geom2d:javaGeom:0.11.1` | Maven Central, Activiti 5.22.0 parent dependency |
| `com.alibaba:fastjson:2.0.5` | `runtime-analysis/extracted/ibizlab-uaa-api` (Maven Central binary) |
| `com.alibaba.fastjson2:fastjson2:2.0.5` | `runtime-analysis/extracted/ibizlab-uaa-api` (Maven Central binary) |
| `com.alibaba.fastjson2:fastjson2-extension:2.0.5` | `runtime-analysis/extracted/ibizlab-uaa-api` (Maven Central binary) |

`fastjson:2.0.5` is the fastjson1-compatible facade backed by the matching
fastjson2 libraries; it is not the standalone 1.x line. The workflow
converter uses the existing Jackson 2.9.9 and SLF4J 1.7.21 runtime JARs.

`de.javawi.jstun:jstun:0.7.4` comes from Maven Central for the
`SA.IM.Ctrl.IMStunServer` source and uses the existing SLF4J API. Its
SHA-256 is recorded in `SHA256SUMS`.

Three additional JARs supply Apache FtpServer for `IMCatalogServerInstance`,
`IMMeetingServerInstance`, and the custom FTP user manager. All were downloaded
from Maven Central at the following coordinates:

| Coordinates | Role |
| --- | --- |
| `org.apache.ftpserver:ftpserver-core:1.1.1` | Server, listener, and user-manager implementations |
| `org.apache.ftpserver:ftplet-api:1.1.1` | FTP authentication and user interfaces |
| `org.apache.mina:mina-core:2.0.16` | Required FTP server transport dependency |

FtpServer 1.1.1 declares SLF4J API 1.7.21 (already present); its Spring
integration dependency is optional. The FTP classes were checked against
the downloaded JAR APIs.

The reporting and XML-source modules use `org.jfree:jfreechart:1.0.19`,
`org.jfree:jcommon:1.0.23`, and `org.jdom:jdom:1.1.3` from Maven Central.
`jcommon` is the declared JFreeChart dependency; JDOM's optional Jaxen
dependency is only needed for XPath uses.

The SOAP client/server sources use Apache Axis2 1.5.6 (`axis2-kernel`,
`axis2-adb`, `axis2-transport-http`) and its parent-POM-aligned Apache
Axiom 1.2.12 (`axiom-api`, `axiom-impl`). These five JARs come from
Maven Central. The generated `SimpleWSStub` requires
`MTOMAwareXMLStreamWriter`, present in Axis2 1.5.6 but absent in 1.6.4.
Their exact SHA-256 values are in `SHA256SUMS`.
Axis2 kernel 1.5.6's POM and the axis2-parent 1.5.6 version properties
identify these further Maven Central inputs:

| Coordinates | Why included |
| --- | --- |
| `org.apache.ws.commons.axiom:axiom-dom:1.2.12` | Axis2 kernel's Axiom DOM dependency |
| `org.apache.geronimo.specs:geronimo-ws-metadata_2.0_spec:1.1.2` | Axis2 kernel annotation API |
| `wsdl4j:wsdl4j:1.6.2` | WSDL parsing |
| `org.apache.ws.commons.schema:XmlSchema:1.4.3` | XML Schema parsing |
| `org.apache.neethi:neethi:2.0.5` | WS-Policy |
| `org.apache.woden:woden-api:1.0M8` | WSDL 2.0 API |
| `org.apache.woden:woden-impl-dom:1.0M8` | WSDL 2.0 DOM implementation |
| `org.codehaus.woodstox:wstx-asl:3.2.9` | Axiom 1.2.12 implementation's StAX dependency |

All eight are byte-pinned below. The existing compile-only Servlet API,
the existing runtime `commons-fileupload-1.5.jar` and `javax.mail-1.5.6.jar`
in `SAPAAS/build-tools/lib`, and existing `activation-1.1.jar` and
`stax-api-1.0-2.jar` satisfy overlapping API references. The build copies
FileUpload 1.5 and JavaMail 1.5.6 into the WAR; the older Axis2 POM's
FileUpload 1.2 and Axiom POM's Geronimo JavaMail API were NOT added because
they duplicate these runtime classes. `jdeps` resolves the Axis2 kernel
against the combined build classpath, but SOAP interoperability is untested.
The Woden DOM JAR itself also contains `javax.xml.namespace.QName`, already
present in the original `xml-apis-1.3.04.jar`. In the JDK 8 build image,
`javap` with both JARs on the classpath loads this platform class from
`jre/lib/rt.jar` first. This known overlap is not a verified Tomcat
integration test.

EAI routing source signatures `route(MuleMessage, MuleSession)` and
`isMatch(MuleMessage)` match `org.mule:mule-core:2.2.1` from Maven Central.
Mule 3.5.0 changes this routing API. The Mule 2.2.1 parent POM specifies
backport-util-concurrent 3.1, Geronimo JCA 1.1, and JUG 2.0.0 (`asl`
classifier); the `-osgi` variants in that POM are not present at Maven
Central, so the same-version standard artifacts below provide their Java
classes without adding OSGi bundles:

| Coordinates | Checked class |
| --- | --- |
| `backport-util-concurrent:backport-util-concurrent:3.1` | `edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingDeque` |
| `org.apache.geronimo.specs:geronimo-j2ee-connector_1.5_spec:1.1` | `javax.resource.spi.work.WorkListener` |
| `org.safehaus.jug:jug:2.0.0:asl` | `org.safehaus.uuid.UUIDGenerator` |

`jdeps -cp "lib/*"` finds no unresolved class references in
`mule-core-2.2.1.jar` with these JARs present. This does not establish EAI
runtime behavior: the recovered EAI sources contain decompiler error stubs
and other Mule module requirements have not been integration-tested.

MSN-related sources require `net.sf.jml` interfaces. The upstream JML
release `jml-1.0b4.jar` was downloaded from
`https://sourceforge.net/projects/java-jml/files/java-jml/jml-1.0b4/jml-1.0b4.jar/download`.
Its MSN messenger and listener APIs were inspected against the imports and
calls in the recovered sources; two independent downloads gave the same
SHA-256 recorded here. There is no verified corresponding Maven Central
artifact. The historical MSN service is no longer available; compiling its
client does not make the messaging workflow operable.

Database-specific source calls were compared with the actual JAR APIs:

| Coordinates (Maven Central) | Required source API |
| --- | --- |
| `com.dameng:Dm7JdbcDriver18:7.6.0.142` | `DmdbType.sqlTypeToDType(int)`, `DmdbType.CURSOR`, `DmdbClob` |
| `com.sap.cloud.db.jdbc:ngdbc:2.2.16` | `com.sap.db.jdbc.packet.DataType.VARCHAR1`, `Unknown`, `getSQLType()` |

Newer DM8 8.1.x lacks the required `sqlTypeToDType(int)` method; older SAP
ngdbc 1.120.52 lacks the referenced packet DataType class. SAP's published
POM lists the SAP Developer License; confirm redistribution rights before
shipping this JAR in a distributed image. Neither database was available
for an integration test.

The toolbar condition evaluator uses `io.github.deonwu:ik-expression:1.0.2`
from Maven Central (Apache 2.0). Its JDK 8 bytecode exports the exact
`org.wltea.expression.ExpressionEvaluator.evaluate(String, Collection<Variable>)`
and `Variable.createVariable(String, Object)` signatures used by
`DefaultToolbarWriterContext`. The checked byte hash is in `SHA256SUMS`.

The recovered CAS SAML 1.1 ticket validator requires
`org.opensaml:opensaml:1.1` and `xml-security:xmlsec:1.3.0` (Maven Central),
matching the historical CAS 3.1.12 dependency declaration. OpenSAML 2+
does not expose the validator's `org.opensaml.*` API. Both JARs are pinned
in `SHA256SUMS`; a local HTTP/POST assertion test validates this pairing,
but it does not prove interoperability with a live CAS server.

The legacy full-text search and scheduler APIs in this source tree require
the following Maven Central binaries (see `SHA256SUMS` for exact bytes):

| Coordinates | Reason for the version |
| --- | --- |
| `org.apache.lucene:lucene-core:3.0.3` | Search code uses `Version.LUCENE_30`, `IndexWriter.MaxFieldLength`, and `org.apache.lucene.queryParser.QueryParser` |
| `org.apache.lucene:lucene-memory:3.0.3` | Required by `lucene-highlighter:3.0.3` |
| `org.apache.lucene:lucene-highlighter:3.0.3` | Search result highlighting |
| `org.htmlparser:htmllexer:2.1` | Required by `htmlparser:2.1` |
| `org.htmlparser:htmlparser:2.1` | HTML document extraction |
| `org.quartz-scheduler:quartz:1.8.6` | Scheduling code constructs `JobDetail` and `CronTrigger` with Quartz 1.x constructors |

Quartz's optional JDBC pool and logging bindings are not included as part of
this batch; scheduler integration still needs runtime validation.

BI cache-control code uses `pentaho:mondrian:3.14.0.0-12` from the Mondrian
project release at SourceForge (`mondrian/mondrian/mondrian-3.14.0`).
Its `RolapSchema`/`CacheControl` signatures match the recovered sources.
This JAR targets Java 8. Its embedded
`META-INF/maven/pentaho/mondrian/pom.xml` lists
`eigenbase:eigenbase-xom`, `eigenbase:eigenbase-properties`,
`eigenbase:eigenbase-resgen`, `org.olap4j:olap4j`, `olap4j-xmla`,
`olap4j-xmlaserver`, and `javacup:javacup:10k`, but gets the Eigenbase
and olap4j versions from `pentaho:pentaho-mondrian-parent-pom:3.14.0.0-12`.
That parent and these Eigenbase coordinates return HTTP 404 on Maven
Central; the historical Pentaho repository currently responds with a web
portal instead of the requested POM. `javacup:javacup:10k` also returns
HTTP 404 on Maven Central. `jdeps` shows unresolved
`org.eigenbase.xom.*`, `org.eigenbase.util.property.*`,
`org.olap4j.*`, and `java_cup.runtime.*`. Similar packages from newer
Maven Central artifacts are NOT presumed API-compatible. These unresolved
BI transitive dependencies block claiming a Mondrian runtime closure.

For reproducibility, all new Maven Central artifacts in this file use
`https://repo.maven.apache.org/maven2/<group-as-path>/<artifact>/<version>/<artifact>-<version>[-classifier].jar`;
their POMs at the same coordinates and the local SHA-256 entries identify
the selected bytes. Compile-only Tomcat 9 EL API provenance and hash are
recorded in `SAPAAS/build-tools/lib/README.md`; it is not copied into
the application WAR.

`SHA256SUMS` is the build input audit record. The Ant build verifies it with
the Java 7-compatible `BuildPreflight` helper, so the build does not depend on
Unix checksum commands. On a Unix shell it can also be checked with:

```sh
sha256sum --check SHA256SUMS
```

These binaries are dependency inputs from the runtime image or the additional
sources listed above. They are not claimed to have been rebuilt from source.
