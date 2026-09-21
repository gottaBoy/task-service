<#assign layout = 'TABLE_24COL'/>
<#if formmenber.getPSLayoutPos()??>
<#assign LayoutPos = formmenber.getPSLayoutPos()/>
<#assign layout = LayoutPos.getLayout()/>
</#if>
<#if layout == 'TABLE_24COL' && LayoutPos??>
<i-col 
style="{<#if (formmenber.getHeight?? && formmenber.getHeight() gt 0)>'height': '${formmenber.getHeight()?c}px !important',</#if><#if (formmenber.getWidth?? && formmenber.getWidth() gt 0)>'width':'${formmenber.getWidth()?c}px !important'</#if>}" 
<#if LayoutPos.getColXS() != -1> sm={{ span: ${LayoutPos.getColXS()}, offset: <#if LayoutPos.getColXSOffset() != -1>${LayoutPos.getColXSOffset()}<#else>0</#if> }}</#if>
<#if LayoutPos.getColSM() != -1> md={{ span: ${LayoutPos.getColSM()}, offset: <#if LayoutPos.getColSMOffset() != -1>${LayoutPos.getColSMOffset()}<#else>0</#if> }}</#if>
<#if LayoutPos.getColMD() != -1> lg={{ span: ${LayoutPos.getColMD()}, offset: <#if LayoutPos.getColMDOffset() != -1>${LayoutPos.getColMDOffset()}<#else>0</#if> }}</#if>
<#if LayoutPos.getColLG() != -1> xl={{ span: ${LayoutPos.getColLG()}, offset: <#if LayoutPos.getColLGOffset() != -1>${LayoutPos.getColLGOffset()}<#else>0</#if> }}</#if>>
    ${P.getPartCode(formmenber).code}
</i-col>
<#elseif layout == 'FLEX'>
<div  style="{<#if LayoutPos.getGrow() != -1>'flex-grow': '${LayoutPos.getGrow()?c}',<#if !LayoutPos.getHeight()??>'height': 0,</#if></#if><#if LayoutPos.getWidth()??>'width': '${LayoutPos.getWidth()?c}px',</#if><#if LayoutPos.getHeight()??>'height':'${LayoutPos.getHeight()?c}px'</#if>}">
${P.getPartCode(formmenber).code}
</div>
<#else>
<div>
    ${P.getPartCode(formmenber).code}
</div>
</#if>