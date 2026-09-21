<#ibiztemplate>
TARGET=PSSYSDBSCHEME
</#ibiztemplate>
<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog" xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.6.xsd">

<#list item.getAllPSSysDBTables() as table>
    <!--输出实体[${table.getName()}]数据结构 -->
    <changeSet author="root" id="${table.getName()}">
        <createTable tableName="${table.getName()}" remarks="${table.getLogicName()}">
         <#list table.getAllPSSysDBColumns() as column>
            <#assign dataType="${srfdatatype(column.getStdDataType())}">
            <#assign javaType="${srfr7javatype(column.stdDataType)}">
            <#comment>varchar需要设置字段长度，若不设置，则liquibase比较时会自动填充，最终恢复到生产库会报错</#comment>
            <#if javaType=='String'>
                    <#if column.getLength()?? && column.getLength()?c!='-1'>
                        <#assign dataType="${srfdatatype(column.getStdDataType())}(${column.getLength()?c})" >
                    <#else>
                        <#assign dataType="${srfdatatype(column.getStdDataType())}(200)">
                    </#if>
            <#elseif dataType?lower_case=='decimal'>
                        <#assign dataType="${srfdatatype(column.getStdDataType())}(38,2)"><#comment>设置数值类型精度</#comment>
            </#if>
            <#if javaType='BigDecimal'>
                <#assign dataType="DECIMAL(38,2)"><#comment>数据类型转换varchar-->decimal</#comment>
            </#if>
                <#comment>由于liquibase不支持修改mysql的remarks，修改remarks会导致启动报错，所以mysql数据库暂时不发remarks</#comment>
            <column name="${column.getName()}" remarks="${column.getLogicName()}" type="${dataType}">
            <#if column.isPKey()>
                <#comment>oracle中约束名长度不能大于30</#comment>
                <#assign constraintName="PK_"+table.getName()+"_"+column.getName()>
                <#if constraintName?length gt 30>
                    <#assign constraintName=constraintName?substring(0,30)>
                </#if>
                <constraints primaryKey="true" primaryKeyName="${constraintName}"/>
            </#if>
            </column>
         </#list>
        </createTable>
    </changeSet>

</#list>
</databaseChangeLog>
