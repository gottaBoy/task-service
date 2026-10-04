# SAPAAS source-build tool dependencies

These JARs are compile-only inputs for the recovered SAPAAS source tree.
They are intentionally kept outside `SAPAAS/lib`, so Ant does not copy them
into the application WAR.

| File | Version | Purpose | SHA-256 |
| --- | --- | --- | --- |
| `javax.servlet-api-4.0.1.jar` | 4.0.1 | Servlet API | `83a03dd877d3674576f0da7b90755c8524af099ccf0607fc61aa971535ad7c60` |
| `tomcat-el-api-9.0.100.jar` | Tomcat 9.0.100 (javax.el / EL 3.0) | Compile-only `javax.el.ELContext` for `jsp-api-task7.jar` | `2f41bf229e30975b0a07ddacee38b5c45c63308a2d71963bb866d774df6b9caa` |
| `jsp-api-task7.jar` | task7 runtime API | JSP `PageContext` API | `c40c7e9e939f7cc7285f066e80674df0daaea40c313a86d597b514ed58988513` |
| `servlet-api-task7.jar` | task7 runtime API | Runtime servlet API compatibility | `f1463b29e0f8f91f9484a40bce8d65f94cbcee2268f2d98608ac540ccf9bd262` |
| `spring-security-oauth2-2.3.8.RELEASE.jar` | 2.3.8.RELEASE | Legacy OAuth2 client API | `90a48f7c6244fcb6700aa300a1f42fffcae01b3dd46c722e12476bbc716de4e1` |
| `spring-security-core-5.4.1.jar` | 5.4.1 | Spring Security core API | `4b48624625c7ab6d10111dd77fe4b37017fb6182875815c061557538d0821fae` |
| `spring-security-crypto-5.4.1.jar` | 5.4.1 | Spring Security crypto API | `4f327033b04df8798a7d569ac78a817195facc39715913703e619651e18f4202` |
| `spring-security-rsa-1.0.9.RELEASE.jar` | 1.0.9.RELEASE | Spring Security RSA API | `a2f685f77c50d9efceb5c86bbbdb8b2980fb08d2edc7d555c2a12e8a9b0b531b` |
| `activemq-all-5.10.0.jar` | 5.10.0 | JMS and ActiveMQ client API | `853008ca11788ceb74969dfaeb7dbefff93eac88393b417c0910428064cb6b63` |
| `poi-3.10-FINAL.jar` | 3.10-FINAL | HSSF/POI API | `113d2cbe641bd82b1a990fdf946f416753241a017f89777d92f7136f87e806a5` |
| `poi-ooxml-3.10-FINAL.jar` | 3.10-FINAL | XSSF/OOXML API | `19110b78ede60a6ba018e962d84061470adc71880894cb0425c24a44f58dbc38` |
| `poi-ooxml-schemas-3.10-FINAL.jar` | 3.10-FINAL | POI OOXML schema types | `350f6797066df25b177e765941cab517a79f28540fab315e2e1bd82fa81723f1` |
| `xmlbeans-2.6.0.jar` | 2.6.0 | POI OOXML type support | `c77974359688b2823b48fa9a33da68559d64f8474441480d9df4f9e254332a96` |
| `itext-2.1.7.jar` | 2.1.7 | Legacy PDF merge API | `7d82c6b097a31cdf5a6d49a327bf582fdec7304da69308f9f6abf54aa9fd9055` |
| `jxl-2.6.12.jar` | 2.6.12 | Legacy Excel BIFF API | `c5c53645ab751288398f30adaec5551879c5ee334d4862ea77b25a386646621c` |
| `commons-fileupload-1.5.jar` | 1.5 | Multipart parsing for local SmartUpload compatibility | `51f7b3dcb4e50c7662994da2f47231519ff99707a5c7fb7b05f4c4d3a1728c14` |
| `javax.mail-1.5.6.jar` | 1.5.6 | JavaMail API used by mail backend services | `40ca806a724848616d88461ea565bc597d92b8a90ba426ab92e4c471552dd097` |

The four Spring Security artifacts are open-source Maven artifacts copied
from the local Maven cache. The two API JARs named `*-task7.jar` were recovered
from the original task7 runtime image because the source uses its JSP and
servlet surface directly.

The ActiveMQ, POI, iText, JXL, Commons FileUpload and JavaMail artifacts are
open-source Maven artifacts selected for the legacy Java 7 source API used by
task7. All JARs in this directory are automatically added to the Ant compile
classpath. Runtime-required artifacts are copied into the WAR by the source
build; servlet/JSP API artifacts remain compile-only because Tomcat supplies
those APIs.

The EL API is the official Apache Tomcat Maven Central artifact
`org.apache.tomcat:tomcat-el-api:9.0.100`, fetched from
`https://repo.maven.apache.org/maven2/org/apache/tomcat/tomcat-el-api/9.0.100/tomcat-el-api-9.0.100.jar`.
Its local SHA-256 matches the `.jar.sha256` served alongside the artifact.
`javap` confirms `javax.servlet.jsp.JspContext.getELContext()` returns the
`javax.el.ELContext` present in this JAR. The pinned runtime image reports
Tomcat 9.0.122, while the compile-only EL API is 9.0.100; both expose the
Tomcat 9 javax.el API, but this is not an exact patch-version match. `build.xml`
adds all build-tools/lib JARs to `compile.classpath` but copies only its
explicit runtime allowlist to `WEB-INF/lib`, which excludes this EL JAR;
Tomcat supplies EL at runtime.
