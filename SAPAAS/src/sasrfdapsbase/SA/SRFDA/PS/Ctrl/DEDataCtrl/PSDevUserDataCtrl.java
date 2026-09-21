/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.LoginAccount
 *  SA.SRFDA.Ctrl.Data.User
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.LoginAccount;
import SA.SRFDA.Ctrl.Data.User;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.PS.Data.PSDevUser;
import SA.SRFDA.PS.Data.PSUAWizard2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.util.Random;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevUserDataCtrl
extends PSDEDataCtrl {
    private static final String _PASSWORD_ = "__HASH_PASS__";
    private static final Log log = LogFactory.getLog(PSDevUserDataCtrl.class);
    private static Random random = new Random();
    public static final String CUSTOMCALL_INITUSER = "INITUSER";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.compare((String)strCallName, (String)CUSTOMCALL_INITUSER, (boolean)true) == 0) {
            return this.initUser(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult initUser(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            PSDevUser psDevUser = new PSDevUser();
            psDevUser.proxy(dataEntity);
            this.Get(psDevUser);
            this.onInitUser(psDevUser);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitUser(PSDevUser psDevUser) throws Exception {
        PSUAWizard2 psUAWizard2 = new PSUAWizard2();
        psUAWizard2.setParamValue("loginname", psDevUser.getFULLLOGINNAME());
        String strPassword = "Sa123456!";
        LoginAccount loginAccount = new LoginAccount();
        loginAccount.setLOGINACCOUNTNAME(psDevUser.getFULLLOGINNAME());
        IDEDataCtrl loginAccountDataCtrl = this.GetRelatedDataCtrl("DE0142");
        CallResult callResult = loginAccountDataCtrl.Select((BaseDataEntity)loginAccount);
        if (callResult.isOk() && loginAccount.getPWD().indexOf(_PASSWORD_) != 0) {
            strPassword = loginAccount.getPWD();
        }
        psUAWizard2.setParamValue("oripassword", strPassword);
        psUAWizard2.setParamValue("newpassword", strPassword);
        psUAWizard2.setParamValue("newpassword2", strPassword);
        psUAWizard2.setParamValue("psdevcenterid", psDevUser.getPSDEVCENTERID());
        IDEDataCtrl psUAWizard2DataCtrl = this.GetRelatedDataCtrl("DE2851");
        callResult = psUAWizard2DataCtrl.CustomCall("CREATEUSER", (BaseDataEntity)psUAWizard2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            PSDevUser psDevUser = new PSDevUser();
            psDevUser.proxy(dataEntity);
            if (bInsert && StringHelper.isNullOrEmpty((String)psDevUser.getFROMPSDEVUSERID())) {
                User user = new User();
                user.setUSERID(psDevUser.getPSDEVUSERID());
                user.setUSERNAME(psDevUser.getPSDEVUSERNAME());
                user.set("VALIDFLAG", (Object)1);
                IDEDataCtrl userDataCtrl = this.GetRelatedDataCtrl("DE0030");
                callResult = userDataCtrl.Save(true, (BaseDataEntity)user);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                String strPassword = psDevUser.getLOGINPWD();
                if (StringHelper.isNullOrEmpty((String)strPassword)) {
                    strPassword = this.calcPassword();
                }
                PSDevCenter psDevCenter = new PSDevCenter();
                psDevCenter.setPSDEVCENTERID(psDevUser.getPSDEVCENTERID());
                IDEDataCtrl psDevCenterDataCtrl = this.GetRelatedDataCtrl("DE2010");
                callResult = psDevCenterDataCtrl.Get((BaseDataEntity)psDevCenter);
                if (callResult.isError()) {
                    log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psDevUser.getPSDEVCENTERID(), (Object)callResult.getErrorInfo()));
                    return callResult;
                }
                String strLoginName = "";
                strLoginName = !StringHelper.isNullOrEmpty((String)psDevCenter.getFULLDOMAINNAME()) ? StringHelper.format((String)"%1$s@%2$s", (Object)psDevUser.getLOGINNAME(), (Object)psDevCenter.getFULLDOMAINNAME()) : StringHelper.format((String)"%1$s@%2$s", (Object)psDevUser.getLOGINNAME(), (Object)psDevCenter.getDOMAINNAME());
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setPWD(strPassword);
                loginAccount.setLOGINACCOUNTNAME(strLoginName);
                loginAccount.setUSERID(psDevUser.getPSDEVUSERID());
                loginAccount.setUSERNAME(psDevUser.getPSDEVUSERNAME());
                loginAccount.setISENABLE(true);
                IDEDataCtrl loginAccountDataCtrl = this.GetRelatedDataCtrl("DE0142");
                callResult = loginAccountDataCtrl.Save(true, (BaseDataEntity)loginAccount);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                PSUAWizard2 psUAWizard2 = new PSUAWizard2();
                psUAWizard2.setParamValue("loginname", strLoginName);
                psUAWizard2.setParamValue("oripassword", strPassword);
                psUAWizard2.setParamValue("newpassword", strPassword);
                psUAWizard2.setParamValue("newpassword2", strPassword);
                psUAWizard2.setParamValue("psdevcenterid", psDevCenter.getPSDEVCENTERID());
                IDEDataCtrl psUAWizard2DataCtrl = this.GetRelatedDataCtrl("DE2851");
                callResult = psUAWizard2DataCtrl.CustomCall("CREATEUSER", (BaseDataEntity)psUAWizard2);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psDevUser.Reset();
                psDevUser.setPSDEVUSERID(loginAccount.getUSERID());
                psDevUser.setFULLLOGINNAME(strLoginName);
                psDevUser.setLOGINPWD(_PASSWORD_);
                return this.Save(false, dataEntity);
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        try {
            PSDevUser psDevUser = new PSDevUser();
            psDevUser.proxy(dataEntity);
            if (!bInsert && StringHelper.isNullOrEmpty((String)psDevUser.getFROMPSDEVUSERID())) {
                IDEDataCtrl loginAccountDataCtrl = this.GetRelatedDataCtrl("DE0142");
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setLOGINACCOUNTNAME(psDevUser.getFULLLOGINNAME());
                CallResult callResult = loginAccountDataCtrl.Select((BaseDataEntity)loginAccount);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                boolean bUpdateLoginAccount = false;
                if (psDevUser.getVALIDFLAG() != loginAccount.getISENABLE()) {
                    bUpdateLoginAccount = true;
                    loginAccount.setISENABLE(psDevUser.getVALIDFLAG());
                }
                if (StringHelper.compare((String)psDevUser.getLOGINPWD(), (String)_PASSWORD_, (boolean)true) != 0) {
                    loginAccount.setPWD(psDevUser.getLOGINPWD());
                    callResult = loginAccountDataCtrl.Save(false, (BaseDataEntity)loginAccount);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    PSUAWizard2 psUAWizard2 = new PSUAWizard2();
                    psUAWizard2.set("loginname", psDevUser.getFULLLOGINNAME());
                    psUAWizard2.set("oripassword", psDevUser.getLOGINPWD());
                    psUAWizard2.set("newpassword", psDevUser.getLOGINPWD());
                    psUAWizard2.set("newpassword2", psDevUser.getLOGINPWD());
                    psUAWizard2.set("psdevcenterid", psDevUser.getPSDEVCENTERID());
                    psUAWizard2.set("updateloginaccount", 0);
                    IDEDataCtrl psUAWizard2DataCtrl = this.GetRelatedDataCtrl("DE2851");
                    callResult = psUAWizard2DataCtrl.CustomCall("CHANGEPWD", (BaseDataEntity)psUAWizard2);
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.format((String)"\u4fee\u6539\u767b\u5f55\u8d26\u6237\u5bc6\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    psDevUser.setLOGINPWD(_PASSWORD_);
                } else if (bUpdateLoginAccount && (callResult = loginAccountDataCtrl.Save(false, (BaseDataEntity)loginAccount)).isError()) {
                    throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u767b\u5f55\u8d26\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
            return super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
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
}

