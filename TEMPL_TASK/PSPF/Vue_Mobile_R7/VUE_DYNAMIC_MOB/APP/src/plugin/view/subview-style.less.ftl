<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
// 扩展视图样式内容
<#if app.getAllPSAppSubViewTypeRefs?? && app.getAllPSAppSubViewTypeRefs()??>
<#list app.getAllPSAppSubViewTypeRefs() as subViewTypeRef>
<#if subViewTypeRef.render?? && subViewTypeRef.render.code3??>
${subViewTypeRef.render.code3}
</#if>
</#list>
</#if>