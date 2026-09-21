/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTModelHelper;
import SA.WT.Ctrl.IWTModelStorage;
import SA.WT.Ctrl.IWTServiceTypeHelper;
import SA.WT.Ctrl.WTModelHelperFactory;
import SA.WT.Ctrl.WTModelStorageFactory;
import SA.WT.Ctrl.WTServiceTypeHelper;
import SA.WT.Data.WTServiceType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTServiceTypeGlobalModel
extends BaseDAGlobalModel<String, WTServiceType, IWTServiceTypeHelper> {
    private static final Log log = LogFactory.getLog(WTServiceTypeGlobalModel.class);
    protected IWTModelHelper iWTModelHelper = null;
    protected IWTModelStorage iWTModelStorage = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iWTModelHelper = WTModelHelperFactory.Create(this.iDAGlobalHelper);
            this.iWTModelStorage = WTModelStorageFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316WT\u670d\u52a1\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected WTServiceType GetObject(String strWTServiceTypeId) {
        WTServiceType WTServiceType2 = new WTServiceType();
        CallResult callResult = this.iWTModelHelper.GetWTServiceType(strWTServiceTypeId, WTServiceType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9aWT\u670d\u52a1\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strWTServiceTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return WTServiceType2;
    }

    protected IWTServiceTypeHelper OnCreateModelHelper(WTServiceType vt) throws Exception {
        WTServiceTypeHelper iWTServiceTypeHelper = new WTServiceTypeHelper();
        iWTServiceTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iWTServiceTypeHelper;
    }

    protected Boolean TestObjectRenew(WTServiceType obj) {
        return false;
    }
}

