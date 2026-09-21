  <i-form
        props={{ model: this.data }}
        class={{ 'app-form': true,<#if ctrl.getPSSysCss()??> '${ctrl.getPSSysCss().getCssName()}' : true </#if> }}
        ref='${ctrl.name}'
        id='${ctrl.getPSAppDataEntity().getCodeName()?lower_case}_${ctrl.getCodeName()?lower_case}'
        style='<#if ctrl.getFormWidth() gt 1>width: ${ctrl.getFormWidth()?c}px;</#if>'
    >
    <input style='display:none;' />
    <row >
    <#list ctrl.getPSDEFormPages() as formmenber>
        ${P.getPartCode(formmenber).code}
    </#list>
    </row>
</i-form>