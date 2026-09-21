<#ibiztemplate>
TARGET=PSSYSUTIL
</#ibiztemplate>
<#if item.getUtilType() == 'USER' && !(item.getPSSysSFPlugin()??)>
package ${pub.getPKGCodeName()}.runtime.sysutil;

import net.ibizsys.central.sysutil.ISysUtilRuntime;

public interface I${item.getCodeName()} extends ISysUtilRuntime  {

}
</#if>