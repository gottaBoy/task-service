<#ibiztemplate>
TARGET=PSSYSLOCALE
</#ibiztemplate>
#${item.name}
<#list sys.getAllPSLanguageReses() as res>
<#assign content=res.getContent(item.id,false)>
<#if content?? && content?length gt 0>
${res.getLanResTag()}=${srfibizmsg(content)}
</#if>
</#list>