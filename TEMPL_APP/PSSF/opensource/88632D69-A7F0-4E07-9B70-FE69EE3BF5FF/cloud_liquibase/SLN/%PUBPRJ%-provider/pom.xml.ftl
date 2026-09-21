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

    <artifactId>${pub.getCodeName()?lower_case}-provider</artifactId>
    
    <dependencies>
        <dependency>
            <groupId>${pub.getPKGCodeName()?lower_case}</groupId>
            <artifactId>${pub.getCodeName()?lower_case}-core</artifactId>
            <version>${pub.getVersionString()?default("V0.0.1_alpha")}</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>

     <properties>
        <maven-jar-plugin.version>2.6</maven-jar-plugin.version>
<#if pub.getPSDeployCenter()?? && pub.getPSDeployCenter().getPSRegistryRepo()??>
        <docker.image.prefix>${pub.getPSDeployCenter().getPSRegistryRepo().getConnStr()}</docker.image.prefix>
</#if>
    </properties>

    <profiles>
        <profile>
            <id><#if pub.getPSSysServiceAPI?? && pub.getPSSysServiceAPI()??>${pub.getPSSysServiceAPI().getCodeName()?lower_case}<#else>runtime</#if></id>
            <build>
                <resources>
                    <resource>
                        <directory>${r'${basedir}'}/src/main/resources</directory>
                        <includes>
                            <include>**/**</include>
                        </includes>
                    </resource>
                </resources>

                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <configuration>
                            <finalName>${pub.getCodeName()?lower_case}-provider</finalName>
                            <jvmArguments>-Dfile.encoding=UTF-8</jvmArguments>
                            <mainClass>${pub.getPKGCodeName()}.IBizRuntimeApplication</mainClass>
                            <outputDirectory>../</outputDirectory>
                        </configuration>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>repackage</goal>
                                </goals>
                            </execution>
                        </executions>
                    </plugin>

<#if pub.getPSDeployCenter()?? && pub.getPSDeployCenter().getPSRegistryRepo()??>                    
                    <plugin>
                        <groupId>com.spotify</groupId>
                        <artifactId>docker-maven-plugin</artifactId>
                        <version>0.4.13</version>
                        <configuration>
                        <serverId>ibiz-dev</serverId>
                        <imageName>${r'${docker.image.prefix}/${project.artifactId}'}:latest</imageName>
                        <dockerDirectory>${r'${project.basedir}'}/src/main/docker</dockerDirectory>
                        <resources>
                            <resource>
                                <targetPath>/</targetPath>
                                <directory>../</directory>
                                <include>${r'${project.artifactId}'}.jar</include>
                            </resource>
                        </resources>
                        </configuration>
                    </plugin>

                    <plugin>
                        <groupId>org.codehaus.mojo</groupId>
                        <artifactId>exec-maven-plugin</artifactId>
                        <version>3.0.0</version>
                        <executions>
                            <execution>
                                <id>prepare</id>
                                <configuration>
                                    <executable>cp</executable>
                                    <arguments>
                                        <argument>../${r'${project.artifactId}'}.jar</argument>
                                        <argument>${r'${project.basedir}'}/src/main/docker/</argument>
                                    </arguments>
                                </configuration>
                            </execution>
                            <execution>
                                <id>buildpush</id>
                                <configuration>
                                    <executable>docker</executable>
                                    <arguments>
                                        <argument>buildx</argument>
                                        <argument>build</argument>
                                        <argument>--platform</argument>
                                        <argument>linux/amd64,linux/arm64</argument>
                                        <argument>-t</argument>
                                        <argument>${r'${docker.image.prefix}/${project.artifactId}'}:latest</argument>
                                        <argument>${r'${project.basedir}'}/src/main/docker</argument>
                                        <argument>--push</argument>
                                    </arguments>
                                </configuration>
                            </execution>
                        </executions>
                    </plugin>
</#if>
                </plugins>
            </build>
        </profile>
    </profiles>

</project>
