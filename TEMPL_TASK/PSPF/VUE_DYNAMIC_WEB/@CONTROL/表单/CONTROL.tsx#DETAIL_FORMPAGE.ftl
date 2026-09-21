<#assign content>
<#list item.getPSDEFormDetails() as formmenber>
    <#if !(formmenber.isHidden?? && formmenber.isHidden())>
    <#ibizinclude>
    ../@MACRO/CONTROL/FORM_MEMBER_LAYOUT.vue.ftl
    </#ibizinclude>
    </#if>
</#list>
</#assign>
<#if item.getPSLayout()?? &&  item.getPSLayout().getLayout() == "FLEX">
<#assign pageLayout = item.getPSLayout()>
<div style="height: 100%;display: flex;<#if pageLayout.getDir()!="">flex-direction: ${pageLayout.getDir()};</#if><#if pageLayout.getAlign()!="">justify-content: ${pageLayout.getAlign()};</#if><#if pageLayout.getVAlign()!="">align-items: ${pageLayout.getVAlign()};</#if>">
    ${content}
</div>
<#else>
    ${content}
</#if>