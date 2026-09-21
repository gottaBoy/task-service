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
package SA.SRFDA.WS.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.WS.Ctrl.IWSModelHelper;
import SA.SRFDA.WS.Ctrl.WSModelHelperFactory;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseWSGlobalModel<KT, VT extends BaseDataEntity, HT>
extends BaseDAGlobalModel<KT, VT, HT> {
    private static final Log log = LogFactory.getLog(BaseWSGlobalModel.class);
    protected IWSModelHelper iWSModelHelper = null;

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iWSModelHelper = WSModelHelperFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u7f51\u7ad9\u6a21\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    @Override
    protected Boolean TestObjectRenew(VT obj) {
        return false;
    }
}

