<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <artifactId>${pub.getCodeName()?lower_case}</artifactId>
    <groupId>${pub.getPKGCodeName()?lower_case}</groupId>
    <version>${pub.getVersionString()?default("V0.0.1_alpha")}</version>
    <name>${pub.getCodeName()?lower_case?cap_first}</name>
    <description>${pub.getMemo()?default(pub.getName())}</description>
    <packaging>pom</packaging>

    <!--  Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.0</version>
    </parent>

    <#--  modules  -->
    <modules>
        <!-- cores -->
        <module>${pub.getCodeName()?lower_case}-core</module>
        <!-- services -->
        <module>${pub.getCodeName()?lower_case}-provider</module>
    </modules>

    <properties>
        <ibiz.cloud.version>8.1.0.563</ibiz.cloud.version>
    </properties>


    <dependencies>

<#if pub.isEnableModelRT()>
        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-cloud</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-redis</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-mybatisplus-spring-boot-starter</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

         <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-zookeeper</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-poi</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-liquibase</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>net.ibizsys.plugin</groupId>
            <artifactId>ibiz-plugin-extension</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

</#if>
        <#comment>引用组件包</#comment>
        <#if pub.getPSSysSFPubPkgs?? && pub.getPSSysSFPubPkgs()??>
        <#list pub.getPSSysSFPubPkgs() as package>
            <#if package.getPkgParam?? && package.getPkgParam()??>
        ${package.getPkgParam()}

            </#if>
        </#list>
        </#if>
    </dependencies>

    <repositories>
<#if pub.isEnableModelRT()>        
		<repository>
			<id>ibizmvnrepository</id>
			<name>ibizmvnrepository</name>
			<url>http://172.16.240.220:8081/repository/public/</url>
			<layout>default</layout>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
<#else>
		<repository>
			<id>aliyunmaven</id>
			<name>阿里云公共仓库</name>
			<url>https://maven.aliyun.com/repository/public/</url>
			<layout>default</layout>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
</#if>        
	</repositories>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>versions-maven-plugin</artifactId>
                <configuration>
                    <generateBackupPoms>false</generateBackupPoms>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.gmavenplus</groupId>
                <artifactId>gmavenplus-plugin</artifactId>
                <version>1.13.1</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>addSources</goal>
                            <goal>addTestSources</goal>
                            <goal>generateStubs</goal>
                            <goal>compile</goal>
                            <goal>generateTestStubs</goal>
                            <goal>compileTests</goal>
                            <goal>removeStubs</goal>
                            <goal>removeTestStubs</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
