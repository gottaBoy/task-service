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
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMConfigType;
import SA.IM.Ctrl.IIMConfigTypeHelper;
import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IIMModelStorage;
import SA.IM.Ctrl.IMConfigTypeHelper;
import SA.IM.Ctrl.IMModelHelperFactory;
import SA.IM.Ctrl.IMModelStorageFactory;
import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMConfigTypeGlobalModel
extends BaseDAGlobalModel<String, IMConfigType, IIMConfigTypeHelper> {
    private static final Log log = LogFactory.getLog(IMConfigTypeGlobalModel.class);
    protected IIMModelHelper iIMModelHelper = null;
    protected IIMModelStorage iIMModelStorage = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iIMModelHelper = IMModelHelperFactory.Create(this.iDAGlobalHelper);
            this.iIMModelStorage = IMModelStorageFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316IM\u914d\u7f6e\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected IMConfigType GetObject(String strIMConfigTypeId) {
        IMConfigType IMConfigType2 = new IMConfigType();
        CallResult callResult = this.iIMModelHelper.GetIMConfigType(strIMConfigTypeId, IMConfigType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9aIM\u914d\u7f6e\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strIMConfigTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return IMConfigType2;
    }

    protected IIMConfigTypeHelper OnCreateModelHelper(IMConfigType vt) throws Exception {
        IMConfigTypeHelper iIMConfigTypeHelper = new IMConfigTypeHelper();
        iIMConfigTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iIMConfigTypeHelper;
    }

    protected Boolean TestObjectRenew(IMConfigType obj) {
        return false;
    }
}

