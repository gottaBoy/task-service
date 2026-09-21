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
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.SSHCmd;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Ctrl.Util.PSDBServerBackupHelper;
import SA.SRFDA.PS.Data.PSDBDevInst;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFDA.PS.Data.PSDCInst;
import SA.SRFDA.PS.Data.PSSvrDomain;
import SA.SRFDA.PS.Data.PSSysModelInst;
import SA.SRFramework.CommonEx.Errors;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBServerDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDBServerDataCtrl.class);
    public static final String CUSTOMCALL_INITSYSMODELINST = "INITSYSMODELINST";
    public static final String CUSTOMCALL_INITSYSMODELINST_DEP = "INITSYSMODELINST_DEP";
    public static final String CUSTOMCALL_INITDEVINST = "INITDEVINST";
    public static final String CUSTOMCALL_INITDEVINST_JIT = "INITDEVINST_JIT";
    public static final String CUSTOMCALL_INITDCINST = "INITDCINST";
    public static final String CUSTOMCALL_BACKUPMODELINST = "BACKUPMODELINST";
    private static Random random = new Random();

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSYSMODELINST, (boolean)true) == 0) {
            return this.initSysModelInst(dataEntity, "DEVSYS");
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSYSMODELINST_DEP, (boolean)true) == 0) {
            return this.initSysModelInst(dataEntity, "DEPSYS");
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITDEVINST, (boolean)true) == 0) {
            return this.initDBDevInst(dataEntity, null, "DEVELOP");
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITDEVINST_JIT, (boolean)true) == 0) {
            return this.initDBDevInst(dataEntity, null, "JIT");
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITDCINST, (boolean)true) == 0) {
            return this.initDCInst(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_BACKUPMODELINST, (boolean)true) == 0) {
            return this.backupSysModelInst(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initSysModelInst(BaseDataEntity dataEntity, String strSysType) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.proxy(dataEntity);
            this.onInitSysModelInst(psDBServer, strSysType);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSysModelInst(PSDBServer psDBServer, String strSysType) throws Exception {
        if (StringHelper.Compare((String)psDBServer.getDBTYPE(), (String)"MYSQL5", (boolean)true) != 0) {
            throw new Exception("\u76ee\u524d\u53ea\u652f\u6301MySQL\u6570\u636e\u5e93");
        }
        String strDomainCode = this.getDomainCode(psDBServer);
        if (!StringHelper.IsNullOrEmpty((String)strDomainCode)) {
            strDomainCode = "_" + strDomainCode + "_";
        }
        IDEDataCtrl psSysModelInstDataCtrl = this.GetRelatedDataCtrl("DE1895");
        int nCount = 20;
        while (nCount > 0) {
            PSSysModelInst psSysModelInst = new PSSysModelInst();
            String strDBInstName = "s" + strDomainCode + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9);
            psSysModelInst.setPSSVRDOMAINID(psDBServer.getPSSVRDOMAINID());
            psSysModelInst.setPSSVRDOMAINNAME(psDBServer.getPSSVRDOMAINNAME());
            psSysModelInst.setPSDBSERVERID(psDBServer.getPSDBSERVERID());
            psSysModelInst.setPSDBSERVERNAME(psDBServer.getPSDBSERVERNAME());
            psSysModelInst.setDBTYPE(psDBServer.getDBTYPE());
            psSysModelInst.setINSTSTATE("10");
            psSysModelInst.setPSSYSMODELINSTNAME(strDBInstName);
            psSysModelInst.setCONNSTR(StringHelper.Format((String)psDBServer.getDBURL(), (Object)strDBInstName));
            psSysModelInst.setSYSTYPE(strSysType);
            psSysModelInst.setDBNAME(strDBInstName);
            psSysModelInst.setUSERNAME(strDBInstName);
            String strPassword = this.calcPassword();
            psSysModelInst.setPASSWD(strPassword);
            CallResult callResult = psSysModelInstDataCtrl.Save(true, (BaseDataEntity)psSysModelInst);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.runCreateMySQLDBCmd(psDBServer, strDBInstName, strPassword);
            --nCount;
        }
    }

    public CallResult initDCInst(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.proxy(dataEntity);
            this.onInitDCInst(psDBServer);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitDCInst(PSDBServer psDBServer) throws Exception {
        if (StringHelper.Compare((String)psDBServer.getDBTYPE(), (String)"MYSQL5", (boolean)true) != 0) {
            throw new Exception("\u76ee\u524d\u53ea\u652f\u6301MySQL\u6570\u636e\u5e93");
        }
        String strDomainCode = this.getDomainCode(psDBServer);
        if (!StringHelper.IsNullOrEmpty((String)strDomainCode)) {
            strDomainCode = "_" + strDomainCode + "_";
        }
        IDEDataCtrl psDCInstDataCtrl = this.GetRelatedDataCtrl("DE1898");
        int nCount = 10;
        while (nCount > 0) {
            PSDCInst psDCInst = new PSDCInst();
            String strDBInstName = "d" + strDomainCode + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9);
            psDCInst.setPSSVRDOMAINID(psDBServer.getPSSVRDOMAINID());
            psDCInst.setPSSVRDOMAINNAME(psDBServer.getPSSVRDOMAINNAME());
            psDCInst.setPSDBSERVERID(psDBServer.getPSDBSERVERID());
            psDCInst.setPSDBSERVERNAME(psDBServer.getPSDBSERVERNAME());
            psDCInst.setDBTYPE(psDBServer.getDBTYPE());
            psDCInst.setINSTSTATE("10");
            psDCInst.setPSDCINSTNAME(strDBInstName);
            psDCInst.setCONNSTR(StringHelper.Format((String)psDBServer.getDBURL(), (Object)strDBInstName));
            psDCInst.setDBNAME(strDBInstName);
            psDCInst.setUSERNAME(strDBInstName);
            String strPassword = this.calcPassword();
            psDCInst.setPASSWD(strPassword);
            CallResult callResult = psDCInstDataCtrl.Save(true, (BaseDataEntity)psDCInst);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5e94\u7528\u4e2d\u5fc3\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.runCreateMySQLDBCmd(psDBServer, strDBInstName, strPassword);
            --nCount;
        }
    }

    public CallResult initDBDevInst(BaseDataEntity dataEntity, String strUsageMode) {
        return this.initDBDevInst(dataEntity, null, strUsageMode);
    }

    public CallResult initDBDevInst(BaseDataEntity dataEntity, BaseDataEntity srcDBDevInst, String strUsageMode) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.proxy(dataEntity);
            PSDBDevInst srcPSDBDevInst = null;
            if (srcDBDevInst != null) {
                srcPSDBDevInst = new PSDBDevInst();
                srcPSDBDevInst.proxy(srcDBDevInst);
            }
            this.onInitDBDevInst(psDBServer, srcPSDBDevInst, strUsageMode);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u5f00\u53d1\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitDBDevInst(PSDBServer psDBServer, PSDBDevInst srcPSDBDevInst, String strUsageMode) throws Exception {
        if (StringHelper.Compare((String)psDBServer.getDBTYPE(), (String)"MYSQL5", (boolean)true) != 0) {
            throw new Exception("\u76ee\u524d\u53ea\u652f\u6301MySQL\u6570\u636e\u5e93");
        }
        String strDomainCode = this.getDomainCode(psDBServer);
        if (!StringHelper.IsNullOrEmpty((String)strDomainCode)) {
            strDomainCode = "_" + strDomainCode + "_";
        }
        IDEDataCtrl psDBDevInstDataCtrl = this.GetRelatedDataCtrl("DE1900");
        int nCount = 20;
        while (nCount > 0) {
            PSDBDevInst psDBDevInst = new PSDBDevInst();
            if (srcPSDBDevInst != null) {
                srcPSDBDevInst.CopyTo(psDBDevInst, "PARAM|PARAM2|PARAM3|PARAM4|PARAM5|PARAM6|PARAM7|PARAM8", false);
            }
            String strDBInstName = "a" + strDomainCode + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 9);
            psDBDevInst.setPSSVRDOMAINID(psDBServer.getPSSVRDOMAINID());
            psDBDevInst.setPSSVRDOMAINNAME(psDBServer.getPSSVRDOMAINNAME());
            psDBDevInst.setPSDBSERVERID(psDBServer.getPSDBSERVERID());
            psDBDevInst.setPSDBSERVERNAME(psDBServer.getPSDBSERVERNAME());
            psDBDevInst.setDBTYPE(psDBServer.getDBTYPE());
            if (StringHelper.IsNullOrEmpty((String)strUsageMode)) {
                psDBDevInst.setUSAGEMODE("DEVELOP");
            } else {
                psDBDevInst.setUSAGEMODE(strUsageMode);
            }
            psDBDevInst.setPSDBDEVINSTNAME(strDBInstName);
            psDBDevInst.setCONNSTR(StringHelper.Format((String)psDBServer.getDBURL(), (Object)strDBInstName));
            psDBDevInst.setINSTSTATE(20);
            psDBDevInst.setDBNAME(strDBInstName);
            psDBDevInst.setUSERNAME(strDBInstName);
            String strPassword = this.calcPassword();
            psDBDevInst.setPASSWD(strPassword);
            CallResult callResult = psDBDevInstDataCtrl.Save(true, (BaseDataEntity)psDBDevInst);
            if (callResult.isError()) {
                if (Errors.IsSpecialError((int)callResult.getRetCode(), (int)7)) continue;
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u5f00\u53d1\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.runCreateMySQLDBCmd(psDBServer, strDBInstName, strPassword);
            --nCount;
        }
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

    protected void runCreateMySQLDBCmd(PSDBServer psDBServer, String strDBInstName, String strPassword) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)psDBServer.getUSERNAME()) || StringHelper.Compare((String)psDBServer.getUSERNAME(), (String)"#", (boolean)true) == 0) {
            String strToolFolder = this.getGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", "");
            String strCmd = StringHelper.Format((String)"mysql.exe -h %4$s -u%1$s -p%2$s -e \"create database %3$s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName, (Object)psDBServer.getIPADDR());
            String strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd));
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql.exe -h %5$s -u%1$s -p%2$s -e \"CREATE USER '%3$s'@'%%' IDENTIFIED BY '%4$s'\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName, (Object)strPassword, (Object)psDBServer.getIPADDR());
            strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd));
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql.exe -h %4$s -u%1$s -p%2$s -e \"GRANT ALL PRIVILEGES ON %3$s.* TO '%3$s'@'%%' WITH GRANT OPTION\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName, (Object)psDBServer.getIPADDR());
            strRet = this.runBat(strCmd = StringHelper.Format((String)"cmd.exe /c %1$s%2$smysql5%2$sbin%2$s%3$s", (Object)strToolFolder, (Object)File.separator, (Object)strCmd));
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        } else {
            int nSSHPort = 22;
            if (!psDBServer.isPORTNull() && (nSSHPort = psDBServer.getPORT()) <= 0) {
                nSSHPort = 22;
            }
            String strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"create database %3$s DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName);
            String strRet = SSHCmd.runRemoteScript2(psDBServer.getIPADDR(), nSSHPort, psDBServer.getUSERNAME(), psDBServer.getPASSWD(), strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"CREATE USER '%3$s'@'%%' IDENTIFIED BY '%4$s'\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName, (Object)strPassword);
            strRet = SSHCmd.runRemoteScript2(psDBServer.getIPADDR(), nSSHPort, psDBServer.getUSERNAME(), psDBServer.getPASSWD(), strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
            strCmd = StringHelper.Format((String)"mysql -u%1$s -p%2$s -e \"GRANT ALL PRIVILEGES ON %3$s.* TO '%3$s'@'%%' WITH GRANT OPTION\"", (Object)psDBServer.getDBUSERNAME(), (Object)psDBServer.getDBPASSWD(), (Object)strDBInstName);
            strRet = SSHCmd.runRemoteScript2(psDBServer.getIPADDR(), nSSHPort, psDBServer.getUSERNAME(), psDBServer.getPASSWD(), strCmd);
            if (strRet.indexOf("ERROR ") != -1) {
                throw new Exception(StringHelper.Format((String)"\u6267\u884c\u8fdc\u7a0b\u547d\u4ee4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)strRet));
            }
        }
    }

    protected String getDomainCode(PSDBServer psDBServer) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)psDBServer.getPSSVRDOMAINID())) {
            return "";
        }
        IDEDataCtrl iDEDataCtrl = this.GetRelatedDataCtrl("DE1885");
        PSSvrDomain psSvrDomain = new PSSvrDomain();
        psSvrDomain.setPSSVRDOMAINID(psDBServer.getPSSVRDOMAINID());
        CallResult callResult = iDEDataCtrl.Get((BaseDataEntity)psSvrDomain);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u57df\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psSvrDomain.getDOMAINCODE();
    }

    public CallResult backupSysModelInst(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSDBServer psDBServer = new PSDBServer();
            psDBServer.proxy(dataEntity);
            PSDBServerBackupHelper psDBServerBackupHelper = new PSDBServerBackupHelper();
            psDBServerBackupHelper.backup(psDBServer.getPSDBSERVERID(), PSTaskServerEnvImpl.getCurrent().getBackupFolder());
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5907\u4efd\u7cfb\u7edf\u6a21\u578b\u5b9e\u4f8b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

