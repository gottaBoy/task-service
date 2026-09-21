/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.UFTemplRole;
import SA.SRFDA.Ctrl.Data.UserRoleDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserFuncDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(UserFuncDataCtrl.class);

    @Override
    protected CallResult OnAfterSaveOK(boolean insert, String arg1, BaseDataEntity afterDataEntity, BaseDataEntity beforeDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(insert, arg1, afterDataEntity, beforeDataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strUSERFUNCTEMPLID = afterDataEntity.GetParamStringValue("USERFUNCTEMPLID", "");
        String strUSEROBJECTID = afterDataEntity.GetParamStringValue("USEROBJECTID", "");
        if (StringHelper.IsNullOrEmpty((String)strUSERFUNCTEMPLID) || StringHelper.IsNullOrEmpty((String)strUSEROBJECTID)) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u529f\u80fd\u6a21\u677f\u6216\u7528\u6237\u5bf9\u8c61\u4e3a\u7a7a"));
            return callResult;
        }
        String strUserTag = StringHelper.Format((String)"%1$s:%2$s", (Object)strUSERFUNCTEMPLID, (Object)afterDataEntity.GetParamStringValue("USERFUNCID", ""));
        String strSQLRoles = "SELECT * FROM T_SRFUSERROLEDETAIL WHERE USERTAG = ?";
        Vector listUserRoleDetail = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strUserTag);
        callResult = BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQLRoles, callParamList.GetList(), listUserRoleDetail, UserRoleDetail.class.getName());
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u6210\u5458\u6570\u636e\u5931\u8d25"));
            return callResult;
        }
        IDEDataCtrl userDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0035", this.getWebContext());
        if (userDataCtrl == null) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s],[%2$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0035", (Object)"\u7528\u6237\u89d2\u8272\u6210\u5458"));
            return callResult;
        }
        for (UserRoleDetail userRole : listUserRoleDetail) {
            userDataCtrl.Remove(userRole);
        }
        String strSQL = "SELECT * FROM T_SRFUFTEMPLROLE WHERE USERFUNCTEMPLID = ?";
        Vector list = new Vector();
        callParamList.Reset();
        callParamList.Add((Object)strUSERFUNCTEMPLID);
        callResult = BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQL, callParamList.GetList(), list, UFTemplRole.class.getName());
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u529f\u80fd\u6a21\u677f\u89d2\u8272\u6570\u636e\u5931\u8d25"));
            return callResult;
        }
        UserRoleDetail userRoleDetail = new UserRoleDetail();
        for (UFTemplRole uFTemplRole : list) {
            String strUSERROLEID = uFTemplRole.getUSERROLEID();
            if (StringHelper.IsNullOrEmpty((String)strUSERROLEID)) continue;
            userRoleDetail.setUSERROLEID(strUSERROLEID);
            userRoleDetail.setUSEROBJECTID(strUSEROBJECTID);
            userRoleDetail.setUSERTAG(strUserTag);
            userDataCtrl.Save(true, userRoleDetail);
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterRemoveOK(String arg0, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(arg0, dataEntity);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strUSERFUNCTEMPLID = dataEntity.GetParamStringValue("USERFUNCTEMPLID", "");
        String strUSEROBJECTID = dataEntity.GetParamStringValue("USEROBJECTID", "");
        if (StringHelper.IsNullOrEmpty((String)strUSERFUNCTEMPLID) || StringHelper.IsNullOrEmpty((String)strUSEROBJECTID)) {
            return callResult;
        }
        String strUserTag = StringHelper.Format((String)"%1$s:%2$s", (Object)strUSERFUNCTEMPLID, (Object)dataEntity.GetParamStringValue("USERFUNCID", ""));
        String strSQLRoles = "SELECT * FROM T_SRFUSERROLEDETAIL WHERE USERTAG = ?";
        Vector listUserRoleDetail = new Vector();
        CallParamList callParamList = new CallParamList();
        callParamList.Add((Object)strUserTag);
        callResult = BaseDEDataCtrl.SelectMultiEx(this.globalHelperEx, this.GetDEHelper().GetDBStorage(), strSQLRoles, callParamList.GetList(), listUserRoleDetail, UserRoleDetail.class.getName());
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u89d2\u8272\u6570\u636e\u5931\u8d25"));
            return callResult;
        }
        IDEDataCtrl userDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0035", this.getWebContext());
        if (userDataCtrl == null) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s],[%2$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0035", (Object)"\u7528\u6237\u89d2\u8272\u660e\u7ec6"));
            return callResult;
        }
        for (UserRoleDetail userRole : listUserRoleDetail) {
            userDataCtrl.Remove(userRole);
        }
        return callResult;
    }
}

