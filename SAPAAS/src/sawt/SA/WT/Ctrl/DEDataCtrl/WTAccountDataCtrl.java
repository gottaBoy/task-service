/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl.DEDataCtrl;

import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.DEDataCtrl.WTDEDataCtrl;
import SA.WT.Ctrl.IWTAccountHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTAccountDataCtrl
extends WTDEDataCtrl {
    private static final Log log = LogFactory.getLog(WTAccountDataCtrl.class);
    public static final String CUSTOMCALL_PUBLISHMENU = "PUBLISHMENU";
    public static final String CUSTOMCALL_SYNCUSERGROUP = "SYNCUSERGROUP";
    public static final String CUSTOMCALL_SYNCUSER = "SYNCUSER";

    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISHMENU, (boolean)true) == 0) {
            return this.PublishMenu(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCUSERGROUP, (boolean)true) == 0) {
            return this.SyncUserGroup(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCUSER, (boolean)true) == 0) {
            return this.SyncUser(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult PublishMenu(BaseDataEntity dataEntity) {
        try {
            return this.OnPublishMenu(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnPublishMenu(BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = new CallResult();
        String strWTAccountId = dataEntity.GetParamStringValue("WTACCOUNTID", "");
        IWTAccountHelper iWTAccountHelper = this.getWTModelStorage().FindWTAccount(strWTAccountId);
        iWTAccountHelper.PublishWTMenu();
        return callResult;
    }

    public CallResult SyncUserGroup(BaseDataEntity dataEntity) {
        try {
            return this.OnSyncUserGroup(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnSyncUserGroup(BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = new CallResult();
        String strWTAccountId = dataEntity.GetParamStringValue("WTACCOUNTID", "");
        IWTAccountHelper iWTAccountHelper = this.getWTModelStorage().FindWTAccount(strWTAccountId);
        iWTAccountHelper.SyncWTUserGroup(true);
        return callResult;
    }

    public CallResult SyncUser(BaseDataEntity dataEntity) {
        try {
            return this.OnSyncUser(dataEntity);
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult OnSyncUser(BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = new CallResult();
        String strWTAccountId = dataEntity.GetParamStringValue("WTACCOUNTID", "");
        IWTAccountHelper iWTAccountHelper = this.getWTModelStorage().FindWTAccount(strWTAccountId);
        iWTAccountHelper.SyncWTUser(false);
        return callResult;
    }
}

