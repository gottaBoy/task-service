<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if pub.isEnableModelRT()>
package ${pub.getPKGCodeName()}.runtime;

public class SystemRuntime extends SystemRuntimeBase {
    
}
</#if>