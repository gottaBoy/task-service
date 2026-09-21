<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
<#if pub.isEnableModelRT()>
package ${pub.getPKGCodeName()}.runtime;

import net.ibizsys.central.cloud.core.IServiceSystemRuntime;

public interface ISystemRuntime extends IServiceSystemRuntime {
    
}



</#if>