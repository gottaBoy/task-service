/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.LoginAccount
 *  SA.SRFDA.Ctrl.Data.User
 *  SA.SRFDA.Ctrl.Data.UserRoleDetail
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.DEDataCtrl.IMDEDataCtrl;
import SA.SRFDA.Ctrl.Data.LoginAccount;
import SA.SRFDA.Ctrl.Data.User;
import SA.SRFDA.Ctrl.Data.UserRoleDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;

public class IMAdminDataCtrl
extends IMDEDataCtrl {
    private String strDefaultPwd = "123456";

    protected CallResult OnBeforeSave(boolean bInsert, String strMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strMode, dataEntity, lastDataEntity);
        try {
            if (bInsert || StringHelper.Compare((String)strMode, (String)"CHANGEPWD", (boolean)true) == 0) {
                String strOldPwd = dataEntity.GetParamStringValue("PASSWD", "");
                if (StringHelper.IsNullOrEmpty((String)strOldPwd)) {
                    strOldPwd = this.strDefaultPwd;
                }
                strOldPwd = String.valueOf(dataEntity.GetParamStringValue("IMADMINID", "")) + strOldPwd;
                String strNewPwd = Helper.GenMD5((String)strOldPwd);
                dataEntity.SetParamValue("PASSWD", (Object)strNewPwd);
            }
        }
        catch (Exception e) {
            callResult.setErrorInfo(e.getMessage());
            callResult.setRetCode(1);
        }
        return callResult;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (bInsert) {
                IDEDataCtrl userDEDataCtrl = this.GetRelatedDataCtrl("DE0030");
                User user = new User();
                user.setUSERID(dataEntity.GetParamStringValue("IMADMINID", ""));
                user.setUSERNAME(dataEntity.GetParamStringValue("IMADMINNAME", ""));
                callResult = userDEDataCtrl.Save(true, (BaseDataEntity)user);
                if (callResult.IsError()) {
                    return callResult;
                }
                IDEDataCtrl loginAccDEDataCtrl = this.GetRelatedDataCtrl("DE0142");
                LoginAccount loginAcc = new LoginAccount();
                loginAcc.setLOGINACCOUNTNAME(dataEntity.GetParamStringValue("IMADMINID", ""));
                loginAcc.setUSERID(user.getUSERID());
                loginAcc.setPWD(dataEntity.GetParamStringValue("PASSWD", ""));
                loginAcc.setISENABLE(dataEntity.GetParamIntValue("VALIDFLAG", 0) == 1);
                loginAcc.setUSERMODEID("DOMAINADMIN");
                callResult = loginAccDEDataCtrl.Save(true, (BaseDataEntity)loginAcc);
                if (callResult.IsError()) {
                    return callResult;
                }
                IDEDataCtrl usroledetailDEDataCtrl = this.GetRelatedDataCtrl("DE0035");
                UserRoleDetail userRoleDetail = new UserRoleDetail();
                userRoleDetail.setUSEROBJECTID(user.getUSERID());
                userRoleDetail.setUSERROLEID("DOMAINADMIN");
                return usroledetailDEDataCtrl.Save(true, (BaseDataEntity)userRoleDetail);
            }
            IDEDataCtrl userDEDataCtrl = this.GetRelatedDataCtrl("DE0030");
            User user = new User();
            user.setUSERID(dataEntity.GetParamStringValue("IMADMINID", ""));
            user.setUSERNAME(dataEntity.GetParamStringValue("IMADMINNAME", ""));
            callResult = userDEDataCtrl.Save(false, (BaseDataEntity)user);
            IDEDataCtrl loginAccDEDataCtrl = this.GetRelatedDataCtrl("DE0142");
            BaseDataEntity condition = new BaseDataEntity();
            condition.SetParamValue("LOGINACCOUNTNAME", (Object)dataEntity.GetParamStringValue("IMADMINID", ""));
            Vector vector = new Vector();
            callResult = loginAccDEDataCtrl.Select(condition, vector);
            if (vector.size() > 0) {
                BaseDataEntity loginAcc = (BaseDataEntity)vector.get(0);
                loginAcc.SetParamValue("LOGINACCOUNTNAME", (Object)dataEntity.GetParamStringValue("IMADMINID", ""));
                loginAcc.SetParamValue("PWD", (Object)dataEntity.GetParamStringValue("PASSWD", ""));
                loginAcc.SetParamValue("ISENABLE", dataEntity.GetParamValue("VALIDFLAG"));
                return loginAccDEDataCtrl.Save(false, loginAcc);
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            IDEDataCtrl usroledetailDEDataCtrl = this.GetRelatedDataCtrl("DE0035");
            UserRoleDetail userRoleDetail = new UserRoleDetail();
            userRoleDetail.setUSEROBJECTID(dataEntity.GetParamStringValue("IMADMINID", ""));
            Vector vector = new Vector();
            callResult = usroledetailDEDataCtrl.Select((BaseDataEntity)userRoleDetail, vector);
            callResult = usroledetailDEDataCtrl.Remove((BaseDataEntity)userRoleDetail);
            if (vector.size() > 0 && (callResult = usroledetailDEDataCtrl.Remove((BaseDataEntity)vector.get(0))).IsError()) {
                return callResult;
            }
            IDEDataCtrl loginAccDEDataCtrl = this.GetRelatedDataCtrl("DE0142");
            BaseDataEntity condition = new BaseDataEntity();
            condition.SetParamValue("LOGINACCOUNTNAME", (Object)dataEntity.GetParamStringValue("IMADMINID", ""));
            Vector vectorLoginAcc = new Vector();
            callResult = loginAccDEDataCtrl.Select(condition, vectorLoginAcc);
            if (vectorLoginAcc.size() > 0 && (callResult = loginAccDEDataCtrl.Remove((BaseDataEntity)vectorLoginAcc.get(0))).IsError()) {
                return callResult;
            }
            IDEDataCtrl userDEDataCtrl = this.GetRelatedDataCtrl("DE0030");
            User user = new User();
            user.setUSERID(dataEntity.GetParamStringValue("IMADMINID", ""));
            callResult = userDEDataCtrl.Remove((BaseDataEntity)user);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }
}

