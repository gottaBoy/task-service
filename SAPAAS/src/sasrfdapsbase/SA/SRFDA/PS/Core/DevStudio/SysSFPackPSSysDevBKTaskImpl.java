/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import java.io.File;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SysSFPackPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysSFPackPSSysDevBKTaskImpl.class);
    public static final String PACK_SUCCESSMSG = "PACK_SUCCESSMSG";
    public static final String PACK_SUCCESSMSGCNT = "PACK_SUCCESSMSGCNT";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysSFPub psSysSFPub = new PSSysSFPub();
        psSysSFPub.setPSSysSFPubId(this.psSysDevBKTask.getTASKPARAM());
        psSysSFPubService.get((IEntity)psSysSFPub);
        return this.generateCode(psSysSFPub);
    }

    protected String generateCode(PSSysSFPub psSysSFPub) throws Exception {
        IPSSFStyle iPSSFStyle;
        String strSuccessMsg;
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
        String strJSCmdFile = String.valueOf(strCodeFolder) + "createjar_before.js";
        String strJSCmdFile2 = String.valueOf(strCodeFolder) + "createjar_after.js";
        String strInitJarCmdFile = "";
        if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0) {
            strInitJarCmdFile = String.valueOf(strCodeFolder) + "createjar_before.sh";
            strCodeFolder = String.valueOf(strCodeFolder) + "createjar.sh";
        } else {
            strInitJarCmdFile = String.valueOf(strCodeFolder) + "createjar_before.bat";
            strCodeFolder = String.valueOf(strCodeFolder) + "createjar.bat";
        }
        File beforeFile = new File(strInitJarCmdFile);
        if (beforeFile.exists()) {
            this.runBat(strInitJarCmdFile, false);
        }
        this.executeJSCode(strJSCmdFile);
        String strPSSFStyleId = psSysSFPub.getPSSFStyleId();
        if (StringHelper.isNullOrEmpty((String)strPSSFStyleId) && psSysSFPub.getPPSSysSFPub() != null) {
            strPSSFStyleId = psSysSFPub.getPPSSysSFPub().getPSSFStyleId();
        }
        if (!StringHelper.isNullOrEmpty((String)(strSuccessMsg = (iPSSFStyle = ((IPSSystemUtil)((Object)iPSSystem)).getPSSFStyle(iPSSystem.getSFType(), strPSSFStyleId, psSysSFPub.getCodeName())).getStyleParam(PACK_SUCCESSMSG, "")))) {
            int nSuccessMsgCount = iPSSFStyle.getStyleParam(PACK_SUCCESSMSGCNT, 1);
            long nBeginTime = System.currentTimeMillis();
            String strResult = this.runBat(strCodeFolder, true);
            if (!StringHelper.isNullOrEmpty((String)strResult)) {
                int nCount = SysSFPackPSSysDevBKTaskImpl.calcStringPartCount(strResult, strSuccessMsg);
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
        if (strPSSFStyleId.indexOf("J2EE6_IBIZSYSRT_R2") == 0) {
            long nBeginTime = System.currentTimeMillis();
            String strResult = this.runBat(strCodeFolder, true);
            if (!StringHelper.isNullOrEmpty((String)strResult)) {
                int nCount = SysSFPackPSSysDevBKTaskImpl.calcStringPartCount(strResult, "BUILD SUCCESS");
                if (nCount == 4) {
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
        long nBeginTime = System.currentTimeMillis();
        String strResult = this.runBat(strCodeFolder, true);
        if (!StringHelper.isNullOrEmpty((String)strResult)) {
            if (strResult.indexOf("BUILD SUCCESSFUL") != -1) {
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
}

