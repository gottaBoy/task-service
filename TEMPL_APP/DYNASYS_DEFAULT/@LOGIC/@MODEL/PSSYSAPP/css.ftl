/***    START:系统样式表    ***/
<#if item.getPSSystem().getAllPSSysCsses?? && item.getPSSystem().getAllPSSysCsses()??>
<#list item.getPSSystem().getAllPSSysCsses() as sysCss>
    <#if sysCss.getDesignCssStyle?? && sysCss.getDesignCssStyle()?? && (sysCss.getDesignCssStyle() != "")>
    .${sysCss.getCssName()}{
      ${sysCss.getDesignCssStyle()}
    }
    </#if>
    <#if sysCss.getCssStyle?? && sysCss.getCssStyle()?? && (sysCss.getCssStyle() != "")>
    ${sysCss.getCssStyle()}
    </#if>
</#list>
</#if>
/***    END:系统样式表    ***/