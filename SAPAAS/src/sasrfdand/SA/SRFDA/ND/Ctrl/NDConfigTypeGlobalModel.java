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
package SA.SRFDA.ND.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.ND.Ctrl.INDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.INDModelHelper;
import SA.SRFDA.ND.Ctrl.INDModelStorage;
import SA.SRFDA.ND.Ctrl.NDConfigTypeHelper;
import SA.SRFDA.ND.Ctrl.NDModelHelperFactory;
import SA.SRFDA.ND.Ctrl.NDModelStorageFactory;
import SA.SRFDA.ND.Data.NDConfigType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NDConfigTypeGlobalModel
extends BaseDAGlobalModel<String, NDConfigType, INDConfigTypeHelper> {
    private static final Log log = LogFactory.getLog(NDConfigTypeGlobalModel.class);
    protected INDModelHelper iNDModelHelper = null;
    protected INDModelStorage iNDModelStorage = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iNDModelHelper = NDModelHelperFactory.Create(this.iDAGlobalHelper);
            this.iNDModelStorage = NDModelStorageFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7f51\u76d8\u914d\u7f6e\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected NDConfigType GetObject(String strNDConfigTypeId) {
        NDConfigType NDConfigType2 = new NDConfigType();
        CallResult callResult = this.iNDModelHelper.GetNDConfigType(strNDConfigTypeId, NDConfigType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7f51\u76d8\u914d\u7f6e\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strNDConfigTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return NDConfigType2;
    }

    protected INDConfigTypeHelper OnCreateModelHelper(NDConfigType vt) throws Exception {
        NDConfigTypeHelper iNDConfigTypeHelper = new NDConfigTypeHelper();
        iNDConfigTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iNDConfigTypeHelper;
    }

    protected Boolean TestObjectRenew(NDConfigType obj) {
        return false;
    }
}

