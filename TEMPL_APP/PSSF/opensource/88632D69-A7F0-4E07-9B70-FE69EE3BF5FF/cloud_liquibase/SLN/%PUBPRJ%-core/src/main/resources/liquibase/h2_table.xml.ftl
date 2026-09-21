<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if  sysrun?? && sysrun.getPSDevSlnMSDepAPI()?? && sysrun.getPSDevSlnMSDepAPI().getPSDCMSPlatformNode()??>
<#if sysrun.getPSDBDevInst()??>
    <#assign dbinst = sysrun.getPSDBDevInst()>
    <#assign curdate=.now?string["yyyyMMddHHmmss"]>
</#if>
<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog" xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.6.xsd">
    <#assign sequenceNumber=0>

<#list sys.getAllPSDataEntities() as de>


<#if de.getTableName?? &&de.getTableName()?? &&de.getTableName()?upper_case!='IBZUSER'&&de.getTableName()?upper_case!='IBZFILE'&&de.getTableName()?upper_case!='IBZDATAAUDIT' &&de.getStorageMode()?? &&de.getStorageMode()==1  && de.isSubSysDE()==false>
    <#assign bPubDb=false>
    <#if de.getAllPSDEDBConfigs()?? >
        <#list de.getAllPSDEDBConfigs() as dbpub>
            <#if dbpub.isPubModel() == true >
               <#assign bPubDb = true>
               <#break >
            </#if>
        </#list>
    </#if>
    <#assign sequenceNumber=sequenceNumber+1>
    <#assign deVersion=de.getVersion()?c>
    <#assign deName=de.getName()?lower_case>
    <#assign hasPhisicalDEField=false>
    <#comment>判断表中是否有物理属性</#comment>
    <#list de.getAllPSDEFields() as defield>
        <#if defield.isPhisicalDEField()==true>
            <#assign hasPhisicalDEField=true>
            <#break>
        </#if>
    </#list>
    <#comment>输出表结构</#comment>
    <!--输出实体[${de.getName()}]数据结构 -->
    <#if !P.exists("table_",de.getTableName()?lower_case,"") && bPubDb==true && hasPhisicalDEField==true>
    <changeSet author="root" id="tab-${deName}-${deVersion}-${sequenceNumber}">
        <createTable tableName="${de.getTableName()}">
         <#list de.getAllPSDEFields() as defield>
             <#if defield.isPhisicalDEField()==true><#comment>物理属性</#comment>
                <#assign dataLen="10">
                <#if defield.getLength()?? && defield.getLength()?c!='-1' && defield.getLength()?c!='0'>
                    <#assign dataLen="${defield.getLength()?c}">
                </#if>
                <#assign dataPrecision="">
                <#if defield.getPrecision()?? && defield.getPrecision()?c!='-1' && defield.getPrecision()?c!='0'>
                     <#assign dataPrecision=", ${defield.getPrecision()?c}">
                </#if>
                 <#assign dataType="${srfdatatype(defield.getStdDataType())}">
                 <#assign javaType="${srfr7javatype(defield.stdDataType)}">
                 <#comment>varchar需要设置字段长度，若不设置，则liquibase比较时会自动填充，最终恢复到生产库会报错</#comment>
                 <#if javaType=='String'>
                     <#if defield.getLength()?? && defield.getLength()?c!='-1'>
                         <#if srfdatatype(defield.getStdDataType())?lower_case=='clob' || srfdatatype(defield.getStdDataType())?lower_case=='text'>
                            <#assign dataType="CLOB" >
                            <#else>
                            <#assign dataType="${srfdatatype(defield.getStdDataType())}(${defield.getLength()?c})" >
                         </#if>
                     <#else>
                         <#assign dataType="${srfdatatype(defield.getStdDataType())}(200)">
                     </#if>
                 <#elseif dataType?lower_case=='decimal'>
                         <#assign dataType="${srfdatatype(defield.getStdDataType())}(${dataLen}${dataPrecision})"><#comment>设置数值类型精度</#comment>
                 <#elseif dataType?lower_case=='float'>
                                          <#assign dataType="${srfdatatype(defield.getStdDataType())}(${dataLen}${dataPrecision})"><#comment>设置数值类型精度</#comment>
                                  </#if>
                <#if javaType='BigDecimal'>
                    <#assign dataType="DECIMAL(${dataLen}${dataPrecision})"><#comment>数据类型转换varchar-->decimal</#comment>
                </#if>
                 <#comment>由于liquibase不支持修改mysql的remarks，修改remarks会导致启动报错，所以mysql数据库暂时不发remarks</#comment>
                <column name="${defield.getName()}" remarks="<#if dbinst?? && (dbinst.getDBType()!='MYSQL5')>${defield.getLogicName()}</#if>" type="${dataType}">
                <#if defield.isKeyDEField()==true>
                    <#comment>oracle中约束名长度不能大于30</#comment>
                    <#assign constraintName="PK_"+de.getName()+"_"+defield.getName()>
                    <#if constraintName?length gt 30>
                        <#assign constraintName=constraintName?substring(0,30)>
                    </#if>
                    <constraints primaryKey="true" primaryKeyName="${constraintName}"/>
                </#if>
                </column>
             </#if>
         </#list>
        </createTable>
    </changeSet>
    </#if>
</#if>
</#list>

<#comment>输出外键</#comment>
<#list sys.getAllPSDataEntities() as de>
    <#assign deVersion=de.getVersion()?c>
    <#assign deName=de.getName()?lower_case>
    <#if de.getTableName?? &&de.getTableName()??  &&de.getTableName()?upper_case!='IBZUSER'&&de.getTableName()?upper_case!='IBZFILE'&&de.getTableName()?upper_case!='IBZDATAAUDIT' &&de.getStorageMode()?? &&de.getStorageMode()==1 && de.isSubSysDE()==false>
        <#assign bPubDb=false>
        <#if de.getAllPSDEDBConfigs()?? >
            <#list de.getAllPSDEDBConfigs() as dbpub>
                <#if dbpub.isPubModel() == true >
                   <#assign bPubDb = true>
                   <#break >
                </#if>
            </#list>
        </#if>
        <#if de.getMinorPSDERs?? && de.getMinorPSDERs()?? >
        <!--输出实体[${de.getName()}]外键关系 -->
            <#list de.getMinorPSDERs() as fk>
                <#if fk.getDERType()=='DER1N' && fk.isEnableFKey()==true>
                    <#if fk.getMajorPSDataEntity().getTableName()??>
                        <#assign sequenceNumber=sequenceNumber+1>
                        <#comment>oracle中约束名长度不能大于30</#comment>
                        <#assign fkConstraintName="FK_"+de.getName()?upper_case+"_"+fk.getPSPickupDEField().getName()?upper_case>
                        <#if fkConstraintName?length gt 30>
                            <#assign fkConstraintName=fkConstraintName?substring(0,30)>
                        </#if>
    <#if !P.exists("fk_",fkConstraintName,"") && bPubDb==true && fk.getMajorPSDataEntity().getTableName()?? && fk.getMajorPSDataEntity().getTableName()!="">
    <changeSet author="root" id="fk-${deName}-${deVersion}-${sequenceNumber}">
       <addForeignKeyConstraint baseColumnNames="${fk.getPSPickupDEField().getName()}" baseTableName="${de.getTableName()}" constraintName="${fkConstraintName}" deferrable="false" initiallyDeferred="false" onDelete="RESTRICT" onUpdate="RESTRICT" referencedColumnNames="${fk.getMajorPSDataEntity().getKeyPSDEField().getName()}" referencedTableName="${fk.getMajorPSDataEntity().getTableName()}" validate="true"/>
    </changeSet>
    </#if>
                    </#if>
                </#if>
            </#list>
        </#if>
    </#if>
</#list>

</databaseChangeLog>
</#if>