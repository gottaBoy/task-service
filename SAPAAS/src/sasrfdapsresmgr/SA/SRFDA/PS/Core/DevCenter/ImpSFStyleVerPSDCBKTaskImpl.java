/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.PSDCSVNInstRepoImpl
 *  SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase
 *  SA.SRFDA.PS.Core.IPSTaskServerEnv
 *  SA.SRFDA.PS.Core.PSObjectFactory
 *  SA.SRFDA.PS.Core.Util.CmdHelper
 *  SA.SRFDA.PS.Data.PSDevCenterSVN
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.config.entity.PSSFStyleVer
 *  net.ibizsys.pscore.srv.config.service.PSSFStyleVerService
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.Deploy.PSDCSVNInstRepoImpl;
import SA.SRFDA.PS.Core.DevCenter.PSDevCenterBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.Util.CmdHelper;
import SA.SRFDA.PS.Data.PSDevCenterSVN;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import org.hibernate.SessionFactory;

public class ImpSFStyleVerPSDCBKTaskImpl
extends PSDevCenterBKTaskImplBase {
    protected String onRun() throws Exception {
        String strPSSFStyleVerId = this.getTaskParam();
        PSSFStyleVerService psSFStyleVerService = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSSFStyleVer psSFStyleVer = new PSSFStyleVer();
        psSFStyleVer.setPSSFStyleVerId(strPSSFStyleVerId);
        psSFStyleVerService.get(psSFStyleVer);
        if (StringHelper.isNullOrEmpty((String)psSFStyleVer.getPSDevCenterSVNId())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u6a21\u677f[%1$s]\u4f7f\u7528\u7684\u7248\u672c\u4ed3\u5e93", (Object)psSFStyleVer.getPSSFStyleVerName()));
        }
        PSDevCenterSVN psSVNInstRepo = new PSDevCenterSVN();
        CallResult callResult = PSObjectFactory.getPSModelHelper((ISRFDAGlobalHelper)this.getDAGlobalHelper(), null).getPSDevCenterSVN(psSFStyleVer.getPSDevCenterSVNId(), psSVNInstRepo);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        PSDCSVNInstRepoImpl psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
        psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        String strFullTemplFolder = StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSFSTYLEVER%2$s%4$s", (Object)iPSTaskServerEnv.getBackupFolder(), (Object)File.separator, (Object)psSFStyleVer.getPSDevCenterId(), (Object)psSFStyleVer.getPSSFStyleVerId());
        File folder = new File(strFullTemplFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        this.updatePSDCBKTaskStep("\u83b7\u53d6\u7248\u672c\u5e93\u5185\u5bb9", 300, 300);
        String strCmd = StringHelper.format((String)"\"%1$s\\java\\bin\\java.exe\" -cp %1$s\\js\\saibz5.jar net.ibizsys.paas.builder.SynGitHelper %2$s %3$s", (Object)iPSTaskServerEnv.getToolFolder(), (Object)psSVNInstRepoImpl.getResCfgFilePath(), (Object)strFullTemplFolder);
        CmdHelper.getInstance().executeBat(strCmd);
        this.updatePSDCBKTaskStep("\u5bfc\u5165\u6a21\u677f", 60);
        psSFStyleVer.set("SRFPRJFOLDER", (Object)(String.valueOf(strFullTemplFolder) + File.separator + "templ"));
        psSFStyleVerService.impStyleVer(psSFStyleVer);
        return super.onRun();
    }
}
