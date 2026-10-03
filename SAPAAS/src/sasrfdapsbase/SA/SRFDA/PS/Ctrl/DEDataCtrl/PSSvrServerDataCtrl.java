/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.CommonEx.Errors
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSSvrServer;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import net.ibizsys.paas.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSvrServerDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSvrServerDataCtrl.class);
    public static final String CUSTOMCALL_INITAPPSERVER = "INITAPPSERVER";
    public static final String CUSTOMCALL_INITAPPSERVER2 = "INITAPPSERVER2";
    public static final String CUSTOMCALL_INITAPPSERVER3 = "INITAPPSERVER3";
    private static Random random = new Random();

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITAPPSERVER, (boolean)true) == 0) {
            return this.initAppServer(dataEntity, 1, null);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITAPPSERVER2, (boolean)true) == 0) {
            return this.initAppServer(dataEntity, 2, null);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITAPPSERVER3, (boolean)true) == 0) {
            return this.initAppServer(dataEntity, 3, null);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initAppServer(BaseDataEntity dataEntity, int nMode, BaseDataEntity srcPSAppServer) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSvrServer psSvrServer = new PSSvrServer();
            psSvrServer.proxy(dataEntity);
            PSAppServer srcPSPSAppServer = null;
            if (srcPSAppServer != null) {
                srcPSPSAppServer = new PSAppServer();
                srcPSPSAppServer.proxy(srcPSAppServer);
                srcPSPSAppServer.RemoveParam("ASSTATE");
                srcPSPSAppServer.RemoveParam("REFINFO");
            }
            this.onInitAppServer(psSvrServer, nMode, srcPSPSAppServer);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u5e94\u7528\u5bb9\u5668\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitAppServer(PSSvrServer psSvrServer, int nMode, PSAppServer srcPSPSAppServer) throws Exception {
        IDEDataCtrl psAppServerDataCtrl = this.GetRelatedDataCtrl("DE1901");
        IDEDataCtrl psDBDevInstDataCtrl = this.GetRelatedDataCtrl("DE1900");
        IDEDataCtrl psDBServerDataCtrl = this.GetRelatedDataCtrl("DE1891");
        int nLastHttpPort = psSvrServer.getLASTHTTPPORT();
        int nLastSSHPort = psSvrServer.getLASTSSHPORT();
        int nCount = 10;
        while (nCount > 0) {
            PSAppServer psAppServer = new PSAppServer();
            if (srcPSPSAppServer == null) {
                throw new Exception("\u5fc5\u987b\u6709\u539f\u578b\u6570\u636e");
            }
            srcPSPSAppServer.CopyTo(psAppServer, false);
            ++nLastHttpPort;
            ++nLastSSHPort;
            String strAppServerName = "as" + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9);
            psAppServer.RemoveParam("PSAPPSERVERID");
            psAppServer.setPSSVRDOMAINID(psSvrServer.getPSSVRDOMAINID());
            psAppServer.setPSSVRDOMAINNAME(psSvrServer.getPSSVRDOMAINNAME());
            psAppServer.setPSSVRSERVERID(psSvrServer.getPSSVRSERVERID());
            psAppServer.setPSSVRSERVERNAME(psSvrServer.getPSSVRSERVERNAME());
            psAppServer.setASSTATE(20);
            psAppServer.setPSAPPSERVERNAME(strAppServerName);
            String strPassword = this.calcPassword();
            psAppServer.setPASSWD(strPassword);
            psAppServer.setHTTPPORT(nLastHttpPort);
            psAppServer.setSSHPORT(nLastSSHPort);
            CallResult callResult = psAppServerDataCtrl.Save(true, (BaseDataEntity)psAppServer);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5e94\u7528\u5bb9\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSAPPSERVERID", (Object)srcPSPSAppServer.getPSAPPSERVERID());
            Vector<PSDBServer> psDBServerList = new Vector<PSDBServer>();
            callResult = psDBServerDataCtrl.Select(cond, psDBServerList, PSDBServer.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5bb9\u5668\u6570\u636e\u5e93\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSDBServer psDBServer : psDBServerList) {
                cond.Reset();
                cond.setParamValue("PSDBSERVERID", (Object)psDBServer.getPSDBSERVERID());
                Vector<PSDBDevInst> psDBDevInstList = new Vector<PSDBDevInst>();
                callResult = psDBDevInstDataCtrl.Select(cond, psDBDevInstList, PSDBDevInst.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5bb9\u5668\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psDBServer.RemoveParam("PSDBSERVERID");
                psDBServer.setIPADDR(psAppServer.getSSHIPADDR());
                psDBServer.setPORT(psAppServer.getSSHPORT());
                psDBServer.setUSERNAME(psAppServer.getUSERNAME());
                psDBServer.setPASSWD(psAppServer.getPASSWD());
                psDBServer.setPSAPPSERVERID(psAppServer.getPSAPPSERVERID());
                psDBServer.setPSAPPSERVERNAME(psAppServer.getPSAPPSERVERNAME());
                psDBServer.setPSSVRDOMAINID(psSvrServer.getPSSVRDOMAINID());
                psDBServer.setPSSVRDOMAINNAME(psSvrServer.getPSSVRDOMAINNAME());
                psDBServer.setPSDBSERVERNAME(StringHelper.Format((String)"%1$s[%2$s]", (Object)strAppServerName, (Object)psDBServer.getDBTYPE()));
                callResult = psDBServerDataCtrl.Save(true, (BaseDataEntity)psDBServer);
                if (callResult.isError()) {
                    if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u6570\u636e\u5e93\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (PSDBDevInst psDBDevInst : psDBDevInstList) {
                    psDBDevInst.RemoveParam("PSDBDEVINSTID");
                    psDBDevInst.setPSAPPSERVERID(psAppServer.getPSAPPSERVERID());
                    psDBDevInst.setPSAPPSERVERNAME(psAppServer.getPSAPPSERVERNAME());
                    psDBDevInst.setPSSVRDOMAINID(psSvrServer.getPSSVRDOMAINID());
                    psDBDevInst.setPSSVRDOMAINNAME(psSvrServer.getPSSVRDOMAINNAME());
                    psDBDevInst.setPSDBDEVINSTNAME("a" + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9));
                    psDBDevInst.setPSDBSERVERID(psDBServer.getPSDBSERVERID());
                    psDBDevInst.setPSDBSERVERNAME(psDBServer.getPSDBSERVERNAME());
                    psDBDevInst.setINSTSTATE(20);
                    callResult = psDBDevInstDataCtrl.Save(true, (BaseDataEntity)psDBDevInst);
                    if (!callResult.isError() || Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            this.runCreateAppServerCmd(psSvrServer, psAppServer, nMode);
            --nCount;
        }
        psSvrServer.setLASTHTTPPORT(nLastHttpPort);
        psSvrServer.setLASTSSHPORT(nLastSSHPort);
        this.Save(false, psSvrServer);
    }

    protected String calcPassword() {
        String strSource = Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 8);
        String strPassword = "";
        int i = 0;
        while (i < 8) {
            int nPos = random.nextInt(100) % 5;
            strPassword = nPos == 0 ? String.valueOf(strPassword) + "@" : (nPos == 2 ? String.valueOf(strPassword) + strSource.substring(i, i + 1).toUpperCase() : String.valueOf(strPassword) + strSource.substring(i, i + 1));
            ++i;
        }
        return strPassword;
    }

    protected void runCreateAppServerCmd(PSSvrServer psSvrServer, PSAppServer psAppServer, int nMode) throws Exception {
        String strStopComd;
        String strCmd = "";
        switch (nMode) {
            case 1: {
                strCmd = psSvrServer.getTEMPL1ID();
                break;
            }
            case 2: {
                strCmd = psSvrServer.getTEMPL2ID();
                break;
            }
            case 3: {
                strCmd = psSvrServer.getTEMPL3ID();
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strCmd)) {
            throw new Exception("\u5bb9\u5668\u547d\u4ee4\u65e0\u6548");
        }
        Properties cmdProperties = PropertiesHelper.load((String)strCmd);
        String strRunComd = PropertiesHelper.getProperty((Properties)cmdProperties, (String)"runcmd");
        strRunComd = StringHelper.Format((String)strRunComd, (Object)psAppServer.getPSAPPSERVERNAME(), (Object)psAppServer.getHTTPPORT(), (Object)psAppServer.getSSHPORT());
        String strRet = SSHCmd.runRemoteScript2(psSvrServer.getIPADDR(), 22, psSvrServer.getUSERNAME(), psSvrServer.getPASSWD(), strRunComd);
        if (strRet.indexOf(" Error ") != -1) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5bb9\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
        }
        String strPasswd = PropertiesHelper.getProperty((Properties)cmdProperties, (String)"passwd");
        if (!StringHelper.IsNullOrEmpty((String)strPasswd)) {
            strRunComd = StringHelper.Format((String)"echo \"%1$s\" | passwd --stdin %2$s", (Object)psAppServer.getPASSWD(), (Object)psAppServer.getUSERNAME());
            strRet = SSHCmd.runRemoteScript2(psSvrServer.getIPADDR(), psAppServer.getSSHPORT(), "root", strPasswd, strRunComd);
            if (strRet.indexOf(" Error ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u7528\u6237\u5bc6\u7801\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strStopComd = PropertiesHelper.getProperty((Properties)cmdProperties, (String)"stopcmd")))) {
            strStopComd = StringHelper.Format((String)strStopComd, (Object)psAppServer.getPSAPPSERVERNAME(), (Object)psAppServer.getHTTPPORT(), (Object)psAppServer.getSSHPORT());
            strRet = SSHCmd.runRemoteScript2(psSvrServer.getIPADDR(), 22, psSvrServer.getUSERNAME(), psSvrServer.getPASSWD(), strStopComd);
            if (strRet.indexOf(" Error ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u5173\u95ed\u5bb9\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        }
    }
}
