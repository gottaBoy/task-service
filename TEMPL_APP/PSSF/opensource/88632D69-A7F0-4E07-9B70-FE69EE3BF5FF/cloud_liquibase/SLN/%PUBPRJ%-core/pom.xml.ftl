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
   
	</dependencies>

    <properties>
        <maven.build.timestamp.format>yyyyMMddHHmmss</maven.build.timestamp.format>
        <maven-jar-plugin.version>2.6</maven-jar-plugin.version>
    </properties>

    <profiles>
        
    </profiles>
</project>
