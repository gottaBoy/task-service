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

import SA.SRFDA.PS.Core.DevStudio.PSSysBTException;
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

public class SysRemotePackPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SysRemotePackPSSysDevBKTaskImpl.class);
    public static final String PACK_SUCCESSMSG = "PACK_SUCCESSMSG";
    public static final String PACK_SUCCESSMSGCNT = "PACK_SUCCESSMSGCNT";
    public static final String PACK_SUCCESSMSG2 = "PACK_SUCCESSMSG2";
    public static final String PACK_SUCCESSMSG2CNT = "PACK_SUCCESSMSG2CNT";
    public static final String PACK_SUCCESSMSG3 = "PACK_SUCCESSMSG3";
    public static final String PACK_SUCCESSMSG3CNT = "PACK_SUCCESSMSG3CNT";
    public static final String PACK_SUCCESSMSG4 = "PACK_SUCCESSMSG4";
    public static final String PACK_SUCCESSMSG4CNT = "PACK_SUCCESSMSG4CNT";

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
        String strJSCmdFile = String.valueOf(strCodeFolder) + "remotepack_before.js";
        String strJSCmdFile2 = String.valueOf(strCodeFolder) + "remotepack_after.js";
        String strInitJarCmdFile = "";
        if (StringHelper.compare((String)PSTaskServerEnvImpl.getCurrent().getOSType(), (String)"LINUX", (boolean)true) == 0) {
            strInitJarCmdFile = String.valueOf(strCodeFolder) + "remotepack_before.sh";
            strCodeFolder = String.valueOf(strCodeFolder) + "remotepack.sh";
        } else {
            strInitJarCmdFile = String.valueOf(strCodeFolder) + "remotepack_before.bat";
            strCodeFolder = String.valueOf(strCodeFolder) + "remotepack.bat";
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
            int nCount;
            int nSuccessMsgCount = iPSSFStyle.getStyleParam(PACK_SUCCESSMSGCNT, 1);
            long nBeginTime = System.currentTimeMillis();
            String strResult = this.runBat(strCodeFolder, true);
            if (!StringHelper.isNullOrEmpty((String)strResult) && (nCount = SysRemotePackPSSysDevBKTaskImpl.calcStringPartCount(strResult, strSuccessMsg)) == nSuccessMsgCount) {
                this.executeJSCode(strJSCmdFile2);
                nBeginTime = System.currentTimeMillis() - nBeginTime;
                return String.valueOf(StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime)) + "\r\n" + strResult;
            }
            log.error((Object)strResult);
            throw new PSSysBTException(5, strResult);
        }
        if (strPSSFStyleId.indexOf("J2EE6_IBIZSYSRT_R2") == 0) {
            int nCount;
            long nBeginTime = System.currentTimeMillis();
            String strResult = this.runBat(strCodeFolder, true);
            if (!StringHelper.isNullOrEmpty((String)strResult) && (nCount = SysRemotePackPSSysDevBKTaskImpl.calcStringPartCount(strResult, "BUILD SUCCESS")) >= 4) {
                this.executeJSCode(strJSCmdFile2);
                nBeginTime = System.currentTimeMillis() - nBeginTime;
                return String.valueOf(StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime)) + "\r\n" + strResult;
            }
            log.error((Object)strResult);
            throw new PSSysBTException(5, strResult);
        }
        long nBeginTime = System.currentTimeMillis();
        String strResult = this.runBat(strCodeFolder, true);
        if (!StringHelper.isNullOrEmpty((String)strResult) && strResult.indexOf("BUILD SUCCESSFUL") != -1) {
            this.executeJSCode(strJSCmdFile2);
            nBeginTime = System.currentTimeMillis() - nBeginTime;
            return String.valueOf(StringHelper.format((String)"\u6253\u5305\u6210\u529f, \u8017\u65f6[%1$s]ms", (Object)nBeginTime)) + "\r\n" + strResult;
        }
        log.error((Object)strResult);
        throw new PSSysBTException(5, strResult);
    }
}

