<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <artifactId>${pub.getCodeName()?lower_case}</artifactId>
        <groupId>${pub.getPKGCodeName()?lower_case}</groupId>
        <version>${pub.getVersionString()?default("V0.0.1_alpha")}</version>
    </parent>

    <artifactId>${pub.getCodeName()?lower_case}-core</artifactId>
    <name>${pub.getCodeName()?lower_case?cap_first} Core</name>
    <description>${pub.getCodeName()?lower_case?cap_first} Core</description>

    <dependencies>
        <!--  Liquibase  -->
        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-core</artifactId>
            <version>3.9.0</version>
        </dependency>

        <!--  H2  -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.200</version>
        </dependency>     
	</dependencies>


    <properties>
        <maven.build.timestamp.format>yyyyMMddHHmmss</maven.build.timestamp.format>
    </properties>

    <profiles>
        <profile>
            <id>diff</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.liquibase</groupId>
                        <artifactId>liquibase-maven-plugin</artifactId>
                        <version>${r'${liquibase.version}'}</version>
                        <executions>
                            <execution>
                                <id>prepare-newdb</id>
                                <configuration>
                                    <changeLogFile>${r'${project.basedir}'}/src/main/resources/liquibase/h2_table.xml</changeLogFile>
                                    <driver>org.h2.Driver</driver>
                                    <url>jdbc:h2:file:${r'${project.build.directory}'}/db/new;MODE=mysql</url>
                                    <username>root</username>
                                    <dropFirst>true</dropFirst>
                                </configuration>
                                <phase>process-resources</phase>
                                <goals>
                                    <goal>update</goal>
                                </goals>
                            </execution>
                            <execution>
                                <id>prepare-olddb</id>
                                <configuration>
                                    <changeLogFile>${r'${project.basedir}'}/src/main/resources/liquibase/master_table.xml</changeLogFile>
                                    <driver>org.h2.Driver</driver>
                                    <url>jdbc:h2:file:${r'${project.build.directory}'}/db/last;MODE=mysql</url>
                                    <username>root</username>
                                    <dropFirst>true</dropFirst>
                                </configuration>
                                <phase>process-resources</phase>
                                <goals>
                                    <goal>update</goal>
                                </goals>
                            </execution>
                            <execution>
                                <id>make-diff</id>
                                <configuration>
                                    <changeLogFile>${r'${project.basedir}'}/src/main/resources/liquibase/changelog/empty.xml</changeLogFile>
                                    <diffChangeLogFile>${r'${project.basedir}'}/src/main/resources/liquibase/changelog/${r'${maven.build.timestamp}'}_changelog.xml</diffChangeLogFile>
                                    <driver>org.h2.Driver</driver>
                                    <url>jdbc:h2:file:${r'${project.build.directory}'}/db/last;MODE=mysql</url>
                                    <username>root</username>
                                    <password></password>
                                    <referenceUrl>jdbc:h2:file:${r'${project.build.directory}'}/db/new;MODE=mysql</referenceUrl>
                                    <referenceDriver>org.h2.Driver</referenceDriver>
                                    <referenceUsername>root</referenceUsername>
                                    <verbose>true</verbose>
                                    <logging>debug</logging>
                                    <contexts>!test</contexts>
                                    <diffExcludeObjects>Index:.*,table:ibzfile,ibzuser,ibzdataaudit,ibzcfg,IBZFILE,IBZUSER,IBZDATAAUDIT,IBZCFG</diffExcludeObjects>
                                </configuration>
                                <phase>process-resources</phase>
                                <goals>
                                    <goal>diff</goal>
                                </goals>
                            </execution>
                        </executions>

                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>


</project>
