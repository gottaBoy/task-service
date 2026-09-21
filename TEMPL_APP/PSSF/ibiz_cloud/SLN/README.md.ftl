<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
# 系统概要

## 背景

## 系统模块
<#if sys.getAllPSSystemModules()??>
<#if srfemptylist(sys.getAllPSSystemModules())>
   无
<#else>
<#list sys.getAllPSSystemModules() as module>
<#if !module.isSubSysModule()>
* [${module.getName()}](module/${module.getCodeName()}.md)
</#if>
</#list>
</#if>
</#if>


## 支持数据库

<#if sys.getAllPSSystemDBConfigs()??>
<#if srfemptylist(sys.getAllPSSystemDBConfigs())>
<#list sys.getAllPSSystemDBConfigs() as dbcfg>
  * [${dbcfg.getName()}](db/${dbcfg.getName()}.md) 

</#list>
</#if>
</#if>

## 系统应用
<#if sys.getAllPSApps()??>
<#if srfemptylist(sys.getAllPSApps())>
   无
<#else>
<#list item.getAllPSApps() as app>
* [${app.getName()}](ibizmos:/${app.getMOSFilePath()}.ibizmodel) 
</#list>
</#if>
</#if>

## 工作流
<#if srfemptylist(sys.getAllPSWorkflows())>
   无
<#else>
<#list sys.getAllPSWorkflows() as workflow>
* [${workflow.getName()}](workflow/${workflow.getCodeName()}.md)
</#list>   
</#if>

## 服务接口
<#if srfemptylist(sys.getAllPSSysServiceAPIs())>
   无
<#else>
<#list sys.getAllPSSysServiceAPIs() as api>
* [${api.getName()}](service/${api.getCodeName()}.md)
</#list>   
</#if>


