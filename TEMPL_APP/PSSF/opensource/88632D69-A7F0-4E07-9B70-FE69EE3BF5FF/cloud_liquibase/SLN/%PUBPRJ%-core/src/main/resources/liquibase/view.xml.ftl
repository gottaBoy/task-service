<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if sysrun.getPSDBDevInst()??>
    <#assign dbinst = sysrun.getPSDBDevInst()>
    <#assign curdate=.now?string["yyyyMMddHHmmss"]>
</#if>
<?xml version="1.1" encoding="UTF-8" standalone="no"?>
<databaseChangeLog xmlns="http://www.liquibase.org/xml/ns/dbchangelog" xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.6.xsd">
   <#assign sequenceNumber=0>

  <#comment>输出视图信息</#comment>
<#list sys.getAllPSDataEntities() as de>
    <#if de.getStorageMode()==1>
        <#if de.getViewName?? && ((de.getViewName()!'')!='') && de.isSubSysDE()==false && de.isNoViewMode()!=true>
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
        <#if !P.exists("view_",de.getViewName(),"") && bPubDb == true>
        <!--输出实体[${de.getName()}]视图结构信息 runOnChange="true"  当视图发生变更时，通过liquibase强刷prod的视图，实现视图的同步-->
     <changeSet author="<#if dbinst?? && dbinst.getUserName()??>${dbinst.getUserName()}<#else>root</#if>" id="view-${deName}-${deVersion}-${sequenceNumber}" runOnChange="true">
         <createView fullDefinition="false" replaceIfExists="true" viewName="${de.getViewName()}">
            <#if de.getAllPSDEDataQueries?? && de.getAllPSDEDataQueries()??>
                <#assign resultDataQuery = de.getAllPSDEDataQueries()>
                <#list resultDataQuery as singleQuery>
                    <#if singleQuery.getCodeName()?lower_case=='default'>
                        <#if singleQuery.getAllPSDEDataQueryCodes()??>
                            <#assign queryCodeList = singleQuery.getAllPSDEDataQueryCodes()>
                            <#assign sql="">
                            <#comment>遍历数据查询，有oracle则输出，无则输出mysql</#comment>
                            <#list singleQuery.getAllPSDEDataQueryCodes() as dedqcode>
                                <#assign sql=srfjavasqlcode('${dedqcode.getQueryCode()}')>
                                <#assign dbtype=dedqcode.getDBType()?lower_case?replace("mysql5","mysql")>
                                <#if dbtype?lower_case=='oracle'>
                                    <#break>
                                </#if>
                            </#list>
               <![CDATA[ ${sql}]]>
                            <#break>
                        </#if>
                    </#if>
                </#list>
            </#if>
         </createView>
     </changeSet>
            </#if>
        </#if>
    </#if>
</#list>

</databaseChangeLog>
