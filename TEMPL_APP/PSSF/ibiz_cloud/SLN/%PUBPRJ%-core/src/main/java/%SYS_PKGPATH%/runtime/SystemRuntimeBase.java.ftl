<#ibiztemplate>
TARGET=PSSYSTEM
</#ibiztemplate>
package ${pub.getPKGCodeName()}.runtime;

import net.ibizsys.central.cloud.core.ServiceSystemRuntime;
import net.ibizsys.central.dataentity.IDataEntityRuntime;
import net.ibizsys.central.dataentity.service.IDEService;
import net.ibizsys.model.IPSDynaInstService;
import net.ibizsys.model.IPSSystemService;
import net.ibizsys.model.PSModelServiceImpl;
import net.ibizsys.model.res.IPSSysUtil;
import net.ibizsys.runtime.res.ISysUtilRuntime;

public class SystemRuntimeBase extends ServiceSystemRuntime implements ISystemRuntime {

    @Override
    public String getName() {
        return "${item.getName()}";
    }

    @Override
    protected IPSSystemService createPSSystemService() throws Exception {
        PSModelServiceImpl psModelServiceImpl = new PSModelServiceImpl();
        psModelServiceImpl.setPSModelFolderPath("/model/${pub.getPKGCodeName()?replace(".","/")}", true);
        return psModelServiceImpl;
    }

    @Override
    protected ISysUtilRuntime createDefaultSysUtilRuntime(IPSSysUtil iPSSysUtil) {
        <#if sys.getAllPSSysUtils()??>
        <#list sys.getAllPSSysUtils() as sysUtil>
        <#if sysUtil.getUtilType() == 'USER' && !(sysUtil.getPSSysSFPlugin()??)>
        if(iPSSysUtil.getCodeName().equals("${sysUtil.getCodeName()}"))
            return new ${pub.getPKGCodeName()}.runtime.sysutil.${sysUtil.getCodeName()}();
        </#if>
        </#list>
        </#if>
        return super.createDefaultSysUtilRuntime(iPSSysUtil);
    }

}
