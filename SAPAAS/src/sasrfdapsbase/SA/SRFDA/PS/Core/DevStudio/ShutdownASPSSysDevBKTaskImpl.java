/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import java.io.File;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemASService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class ShutdownASPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(ShutdownASPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        String strRunMode = null;
        if (this.getPSSysRunSession() != null) {
            strRunMode = this.getPSSysRunSession().getRunMode();
        }
        if (StringHelper.compare((String)strRunMode, (String)"STARTMSAPP", (boolean)true) == 0 || StringHelper.compare((String)strRunMode, (String)"STARTMSAPI", (boolean)true) == 0) {
            IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI;
            IPSDevSlnMSDepApp iPSDevSlnMSDepApp;
            if (StringHelper.compare((String)strRunMode, (String)"STARTMSAPP", (boolean)true) == 0 && (iPSDevSlnMSDepApp = this.getPSSysRunSession().getPSDevSlnMSDepApp()) == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5fae\u90e8\u7f72\u5e94\u7528\u90e8\u7f72");
            }
            if (StringHelper.compare((String)strRunMode, (String)"STARTMSAPI", (boolean)true) == 0 && (iPSDevSlnMSDepAPI = this.getPSSysRunSession().getPSDevSlnMSDepAPI()) == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5fae\u90e8\u7f72\u63a5\u53e3\u90e8\u7f72");
            }
            IPSSysSFPub iPSSysSFPub = this.getPSSysRunSession().getPSSysSFPub();
            if (iPSSysSFPub == null) {
                throw new Exception("\u5fae\u90e8\u7f72\u5e94\u7528\u90e8\u7f72\u6ca1\u6709\u670d\u52a1\u7ec4\u4ef6\u53d1\u5e03");
            }
            return this.shutdownMS(iPSSysSFPub);
        }
        PSSystemASService psSystemASService = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystemAS psSystemAS = new PSSystemAS();
        psSystemAS.setPSSystemASId(this.psSysDevBKTask.getTASKPARAM());
        psSystemASService.get(psSystemAS);
        if (StringHelper.isNullOrEmpty((String)psSystemAS.getPSAppServerId())) {
            PSDevCenterASService psDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class);
            PSDevCenterAS psDevCenterAS = new PSDevCenterAS();
            psDevCenterAS.setPSDevCenterASId(psSystemAS.getPSDevCenterASId());
            if (!psDevCenterASService.get(psDevCenterAS, true)) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u670d\u52a1\u5668");
            }
            return this.shutdownAS(psDevCenterAS);
        }
        PSAppServerService psAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class);
        PSAppServer psAppServer = new PSAppServer();
        psAppServer.setPSAppServerId(psSystemAS.getPSAppServerId());
        if (!psAppServerService.get(psAppServer, true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u670d\u52a1\u5668");
        }
        return this.shutdownAS(psAppServer);
    }

    protected String shutdownAS(PSAppServer psAppServer) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)psAppServer.getSSHIPAddr())) {
            int nPort = DataObject.getIntegerValue((Object)psAppServer.getSSHPort(), (Integer)22);
            log.debug((Object)StringHelper.format((String)"\u6267\u884c\u5e73\u53f0\u5e94\u7528\u5bb9\u5668[%1$s][%2$s]\u505c\u6b62\u547d\u4ee4[%3$s]", (Object)psAppServer.getPSAppServerName(), (Object)psAppServer.getPSAppServerId(), (Object)psAppServer.getStopCmd()));
            return SSHCmd.runRemoteScript2(psAppServer.getSSHIPAddr(), nPort, psAppServer.getUserName(), psAppServer.getPasswd(), psAppServer.getStopCmd());
        }
        String strResult = this.runBat(psAppServer.getStopCmd(), true);
        return strResult;
    }

    protected String shutdownAS(PSDevCenterAS psDevCenterAS) throws Exception {
        IPSAppServerType iPSAppServerType = this.getPSModelStorage().getPSAppServerType(psDevCenterAS.getASType());
        String strInstallPath = psDevCenterAS.getASInstallPath();
        if (StringHelper.isNullOrEmpty((String)strInstallPath)) {
            strInstallPath = iPSAppServerType.getInstallPath("");
        }
        String strCmd = iPSAppServerType.getShutdownCmd("", strInstallPath);
        int nPort = DataObject.getIntegerValue((Object)psDevCenterAS.getHostPort(), (Integer)22);
        log.debug((Object)StringHelper.format((String)"\u6267\u884c\u4e2d\u5fc3\u5e94\u7528\u5bb9\u5668[%1$s][%2$s]\u505c\u6b62\u547d\u4ee4[%3$s]", (Object)psDevCenterAS.getPSDevCenterASName(), (Object)psDevCenterAS.getPSDevCenterASId(), (Object)strCmd));
        return SSHCmd.runRemoteScript2(psDevCenterAS.getHostAddress(), nPort, psDevCenterAS.getHostUserName(), psDevCenterAS.getHostPasswd(), strCmd);
    }

    protected String shutdownMS(IPSSysSFPub iPSSysSFPub) throws Exception {
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
        strCodeFolder = String.valueOf(strCodeFolder) + "srv_" + iPSSysSFPub.getCodeName();
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "TOOLS";
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0 ? String.valueOf(strCodeFolder) + "shutdownms.sh" : String.valueOf(strCodeFolder) + "shutdownms.bat";
        long nBeginTime = System.currentTimeMillis();
        String strResult = this.runBat(strCodeFolder, false);
        return strResult;
    }
}
