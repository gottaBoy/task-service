<#ibiztemplate>
TARGET=PSSYSAPP
</#ibiztemplate>
// 扩展编辑器样式内容
<#if app.getAllPSAppEditorStyleRefs?? && app.getAllPSAppEditorStyleRefs()??>
<#list app.getAllPSAppEditorStyleRefs() as editorStyleRef>
<#if editorStyleRef.render?? && editorStyleRef.render.code3??>
${editorStyleRef.render.code3}
</#if>
</#list>
</#if>