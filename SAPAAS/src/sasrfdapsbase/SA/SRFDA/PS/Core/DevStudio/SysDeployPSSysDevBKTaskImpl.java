/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import java.io.File;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysDeployPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysDeployPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        IPSDCMSPlatform iPSDCMSPlatform = null;
        if (this.getPSSysRunSession().getPSDevSlnMSDepAPI() != null) {
            iPSDCMSPlatform = this.getPSSysRunSession().getPSDevSlnMSDepAPI().getPSDCMSPlatform();
        } else if (this.getPSSysRunSession().getPSDevSlnMSDepApp() != null) {
            iPSDCMSPlatform = this.getPSSysRunSession().getPSDevSlnMSDepApp().getPSDCMSPlatform();
        }
        if (iPSDCMSPlatform != null) {
            if (iPSDCMSPlatform.getResState() != 20) {
                ICodeList iCodeList = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
                throw new Exception(StringHelper.format((String)"\u5fae\u670d\u52a1\u5e73\u53f0[%1$s]\u5904\u4e8e[%2$s]\u72b6\u6001\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)iPSDCMSPlatform.getName(), (Object)iCodeList.getCodeListText("20", true)));
            }
            if (iPSDCMSPlatform.getExpiredTime() != null && iPSDCMSPlatform.getExpiredTime().getTime() < System.currentTimeMillis()) {
                throw new Exception(StringHelper.format((String)"\u5fae\u670d\u52a1\u5e73\u53f0[%1$s]\u5df2\u8fc7\u6709\u6548\u671f\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)iPSDCMSPlatform.getName()));
            }
        } else {
            IPSAppServer iPSAppServer = this.getPSSysRunSession().getPSAppServer();
            if (iPSAppServer == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u670d\u52a1\u5668");
            }
            if (iPSAppServer.getResState() != 20) {
                ICodeList iCodeList = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u670d\u52a1\u5668[%1$s]\u5904\u4e8e[%2$s]\u72b6\u6001\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)iPSAppServer.getName(), (Object)iCodeList.getCodeListText("20", true)));
            }
            if (iPSAppServer.getExpiredTime() != null && iPSAppServer.getExpiredTime().getTime() < System.currentTimeMillis()) {
                throw new Exception(StringHelper.format((String)"\u5e94\u7528\u670d\u52a1\u5668[%1$s]\u5df2\u8fc7\u6709\u6548\u671f\uff0c\u4e0d\u80fd\u4f7f\u7528", (Object)iPSAppServer.getName()));
            }
        }
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysSFPub psSysSFPub = new PSSysSFPub();
        psSysSFPub.setPSSysSFPubId(this.psSysDevBKTask.getTASKPARAM());
        psSysSFPubService.get((IEntity)psSysSFPub);
        return this.deploySys(psSysSFPub);
    }

    protected String deploySys(PSSysSFPub psSysSFPub) throws Exception {
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(true);
        String strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getPSDevCenterDomain();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getPubSystemId();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + iPSSystem.getVCName();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "srv_" + psSysSFPub.getCodeName();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "TOOLS";
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0 ? String.valueOf(strCodeFolder) + "deploysys.sh" : String.valueOf(strCodeFolder) + "deploysys.bat";
        long nBeginTime = System.currentTimeMillis();
        String strResult = this.runBat(strCodeFolder, false);
        return strResult;
    }
}

