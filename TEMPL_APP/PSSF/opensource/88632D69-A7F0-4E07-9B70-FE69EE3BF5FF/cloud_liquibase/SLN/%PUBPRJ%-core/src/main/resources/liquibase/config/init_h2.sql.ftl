<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>

<#if sysrun.getPSDBDevInst()??>
    <#assign dbinst = sysrun.getPSDBDevInst()>
create schema if not exists ${dbinst.getUserName()};
set schema ${dbinst.getUserName()};

<#--CREATE ALIAS IF NOT EXISTS  TO_NUMBER AS $$-->
<#--Long toNumber(String value) {-->
    <#--return value == null ? null : Long.valueOf(value);-->
<#--}-->
<#--$$;-->
</#if>


