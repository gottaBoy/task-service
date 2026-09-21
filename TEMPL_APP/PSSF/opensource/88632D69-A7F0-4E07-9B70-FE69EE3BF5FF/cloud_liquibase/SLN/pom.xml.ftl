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
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.deploy.skip>false</maven.deploy.skip>
        <ibiz.cloud.version>8.1.0.567.27</ibiz.cloud.version>
        <log4j2.version>2.17.1</log4j2.version>
    </properties>

    <dependencies>

<#if pub.isEnableModelRT()>
        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-cloud</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-redis</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-mybatisplus-spring-boot-starter</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

         <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-zookeeper</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-poi</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-liquibase</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-elasticsearch</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
       </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-kafka</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-quartz</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-rabbitmq</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-mongodb</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-activemq</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

                <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-solr</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-python</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibizlab-plugin-groovy</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-eai</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-psmodel-runtime</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-jgit</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
       </dependency>

        <dependency>
			<groupId>cn.ibizlab.plugin</groupId>
			<artifactId>ibiz-plugin-neo4j</artifactId>
			<version><#noparse>${ibiz.cloud.version}</#noparse></version>
		</dependency>
		
		<dependency>
			<groupId>cn.ibizlab.plugin</groupId>
			<artifactId>ibiz-plugin-antvg6</artifactId>
			<version><#noparse>${ibiz.cloud.version}</#noparse></version>
		</dependency>

        <dependency>
			<groupId>cn.ibizlab.plugin</groupId>
			<artifactId>ibiz-plugin-neo4j-report</artifactId>
			<version><#noparse>${ibiz.cloud.version}</#noparse></version>
		</dependency>

        <dependency>
			<groupId>cn.ibizlab.plugin</groupId>
			<artifactId>ibiz-plugin-extension</artifactId>
			<version><#noparse>${ibiz.cloud.version}</#noparse></version>
		</dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-opml</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>
        
        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-version</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>
        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-util</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-ai</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-wechat</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-open</artifactId>
            <version><#noparse>${ibiz.cloud.version}</#noparse></version>
        </dependency>

        <dependency>
            <groupId>cn.ibizlab.plugin</groupId>
            <artifactId>ibiz-plugin-calcite</artifactId>
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
        </plugins>
    </build>

</project>
