/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import java.io.File;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysPFPackPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysPFPackPSSysDevBKTaskImpl.class);
    public static final String PACK_SUCCESSMSG = "PACK_SUCCESSMSG";
    public static final String PACK_SUCCESSMSGCNT = "PACK_SUCCESSMSGCNT";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysApp psSysApp = new PSSysApp();
        psSysApp.setPSSysAppId(this.psSysDevBKTask.getTASKPARAM());
        psSysAppService.get((IEntity)psSysApp);
        return this.generateCode(psSysApp);
    }

    protected String generateCode(PSSysApp psSysApp) throws Exception {
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
        strCodeFolder = String.valueOf(strCodeFolder) + "app_" + psSysApp.getAppPKGName();
        if (!StringHelper.isNullOrEmpty((String)psSysApp.getUIStyle())) {
            PSAppUIStyle psAppUIStyle = new PSAppUIStyle();
            psAppUIStyle.setSessionFactory(psSysApp.getSessionFactory());
            psAppUIStyle.setPSSysAppId(psSysApp.getPSSysAppId());
            psAppUIStyle.setUIStyle(psSysApp.getUIStyle());
            if (psAppUIStyle.select(true) && !StringHelper.isNullOrEmpty((String)psAppUIStyle.getAppPKGName())) {
                strCodeFolder = String.valueOf(strCodeFolder) + psAppUIStyle.getAppPKGName();
            }
        }
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        strCodeFolder = String.valueOf(strCodeFolder) + "TOOLS";
        strCodeFolder = String.valueOf(strCodeFolder) + File.separator;
        String strJSCmdFile = String.valueOf(strCodeFolder) + "createapp_before.js";
        String strJSCmdFile2 = String.valueOf(strCodeFolder) + "createapp_after.js";
        String strInitAppCmdFile = "";
        if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0) {
            strInitAppCmdFile = String.valueOf(strCodeFolder) + "createapp_before.sh";
            strCodeFolder = String.valueOf(strCodeFolder) + "createapp.sh";
        } else {
            strInitAppCmdFile = String.valueOf(strCodeFolder) + "createapp_before.bat";
            strCodeFolder = String.valueOf(strCodeFolder) + "createapp.bat";
        }
        IPSApplication iPSApplication = iPSSystem.getPSApplication(psSysApp.getPSSysAppId());
        long nBeginTime = System.currentTimeMillis();
        File beforeFile = new File(strInitAppCmdFile);
        if (beforeFile.exists()) {
            this.runBat(strInitAppCmdFile, false);
        }
        this.executeJSCode(strJSCmdFile);
        String strSuccessMsg = iPSApplication.getPSPFStyle().getStyleParam(PACK_SUCCESSMSG, "");
        if (!StringHelper.isNullOrEmpty((String)strSuccessMsg)) {
            int nSuccessMsgCount = iPSApplication.getPSPFStyle().getStyleParam(PACK_SUCCESSMSGCNT, 1);
            String strResult = this.runBat(strCodeFolder, true);
            if (!StringHelper.isNullOrEmpty((String)strResult)) {
                int nCount = SysPFPackPSSysDevBKTaskImpl.calcStringPartCount(strResult, strSuccessMsg);
                if (nCount == nSuccessMsgCount) {
                    this.executeJSCode(strJSCmdFile2);
                    nBeginTime = System.currentTimeMillis() - nBeginTime;
                    return StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime);
                }
                log.error((Object)strResult);
                int nPos = strResult.indexOf("compile:");
                if (nPos != -1) {
                    String strErrorInfo = strResult.substring(nPos);
                    throw new Exception(strErrorInfo);
                }
            }
            throw new Exception(strResult);
        }
        String strResult = this.runBat(strCodeFolder, false);
        this.executeJSCode(strJSCmdFile2);
        nBeginTime = System.currentTimeMillis() - nBeginTime;
        return StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime);
    }
}

