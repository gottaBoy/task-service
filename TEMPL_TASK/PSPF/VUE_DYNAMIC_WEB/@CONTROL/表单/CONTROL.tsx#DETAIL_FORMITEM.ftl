<#if !item.isHidden()>
<#if item.render??>
${item.render.code}
<#else>
<app-form-item
    name='${item.name}'
    caption={'${item.getCaption()}'}
    isEmptyCaption={${item.isEmptyCaption()?c}}
    isShowCaption={${item.isShowCaption()?c}}
    labelWidth={${item.getLabelWidth()?c}}
    labelPos='${item.getLabelPos()}'
    uiStyle='${item.getDetailStyle()}'
    class='<#if item.getPSSysCss?? && item.getPSSysCss()??>${item.getPSSysCss().getCssName()}</#if>'
    <#if item.getLabelPSSysCss?? && item.getLabelPSSysCss()??> labelStyle="${item.getLabelPSSysCss().getCssName()}"</#if>
>
<#--  itemRules={this.rules}、detailsInstance={this.detailsInstance}、required={this.runtimeModel?.required}、error={this.runtimeModel?.error}、style={contentStyle}、controlInstance={this.controlInstance}  -->
${P.getEditorCode(item, "EDITOR.vue").code}
</app-form-item>
</#if>
</#if>