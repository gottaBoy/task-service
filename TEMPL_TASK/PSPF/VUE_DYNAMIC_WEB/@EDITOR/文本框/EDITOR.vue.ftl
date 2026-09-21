<#if editor?? && editor.render??> 
    ${editor.render.code}
<#else>
<input-box 
    itemValue={this.data.${editor.name}}  
    <#if item.getUnitName()??> unit='${item.getUnitName()}'</#if>  
    type='<#if item.getPSDEField?? && item.getPSDEField()??><#assign datatype=srfjavatype(item.getPSDEField().getStdDataType())><#if datatype=='BigInteger' || datatype=='Integer' || datatype=='Double' || datatype=='Decimal' || datatype=='Float' || datatype=='BigDecimal'>number<#else>text</#if><#else>text</#if>' 
    <#if item.getPSDEField?? && item.getPSDEField()?? && item.getPSDEField().getPrecision??>
    <#assign datatype=srfjavatype(item.getPSDEField().getStdDataType())>
    <#if datatype=='Double' || datatype=='Decimal' || datatype=='Float' || datatype=='BigDecimal'>
    <#if item.getPSDEField().getPrecision() == 0>
    precision={2}
    <#else>
    precision={${item.getPSDEField().getPrecision()?c}}
    </#if>
    </#if>
    </#if>
    <#if item.getPlaceHolder()??> 
    placeholder='${item.getPlaceHolder()}'
    </#if> 
    style='${editor.getEditorCssStyle()}'>
</input-box>
</#if>
<#-- 
@enter="onEnter($event)"  
:disabled="detailsModel.${editor.name}.disabled" 
-->