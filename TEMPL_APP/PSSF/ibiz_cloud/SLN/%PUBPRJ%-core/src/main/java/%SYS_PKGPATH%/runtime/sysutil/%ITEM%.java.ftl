<#ibiztemplate>
TARGET=PSSYSUTIL
</#ibiztemplate>
<#if item.getUtilType() == 'USER' && !(item.getPSSysSFPlugin()??)>
package ${pub.getPKGCodeName()}.runtime.sysutil;

import net.ibizsys.central.sysutil.SysUtilRuntimeBase;
import ${pub.getPKGCodeName()}.runtime.ISystemRuntime;

public class ${item.getCodeName()} extends SysUtilRuntimeBase implements I${item.getCodeName()} {

    public ISystemRuntime getSystemRuntime() {
        return (ISystemRuntime) super.getSystemRuntime();
    }

}
</#if>