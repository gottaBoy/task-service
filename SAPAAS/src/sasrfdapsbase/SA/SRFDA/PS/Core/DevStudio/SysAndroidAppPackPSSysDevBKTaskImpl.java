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

public class SysAndroidAppPackPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysAndroidAppPackPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysApp psSysApp = new PSSysApp();
        psSysApp.setPSSysAppId(this.psSysDevBKTask.getTASKPARAM());
        psSysAppService.get(psSysApp);
        return this.generateCode(psSysApp);
    }

    protected String generateCode(PSSysApp psSysApp) throws Exception {
        String strInitAppCmdFile;
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
        String strJSCmdFile = String.valueOf(strCodeFolder) + "createandroidapp_before.js";
        String strJSCmdFile2 = String.valueOf(strCodeFolder) + "createandroidapp_after.js";
        if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0) {
            strInitAppCmdFile = String.valueOf(strCodeFolder) + "createandroidapp_before.sh";
            strCodeFolder = String.valueOf(strCodeFolder) + "createandroidapp.sh";
        } else {
            strInitAppCmdFile = String.valueOf(strCodeFolder) + "createandroidapp_before.bat";
            strCodeFolder = String.valueOf(strCodeFolder) + "createandroidapp.bat";
        }
        long nBeginTime = System.currentTimeMillis();
        File beforeFile = new File(strInitAppCmdFile);
        if (beforeFile.exists()) {
            this.runBat(strInitAppCmdFile, false);
        }
        this.executeJSCode(strJSCmdFile);
        String strResult = this.runBat(strCodeFolder, false);
        this.executeJSCode(strJSCmdFile2);
        nBeginTime = System.currentTimeMillis() - nBeginTime;
        return StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime);
    }
}
