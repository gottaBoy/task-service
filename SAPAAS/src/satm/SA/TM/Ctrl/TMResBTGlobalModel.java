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
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.TM.Ctrl.Data.TMResBT;
import SA.TM.Ctrl.ITMModelHelper;
import SA.TM.Ctrl.TMModelHelperFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TMResBTGlobalModel
extends BaseDAGlobalModel {
    private static final Log log = LogFactory.getLog(TMResBTGlobalModel.class);
    protected ITMModelHelper iTMModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iTMModelHelper = TMModelHelperFactory.Create(this.iDAGlobalHelper);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u8d44\u6e90\u9884\u7ea6\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        TMResBT biPageType = new TMResBT();
        CallResult callRsult = this.iTMModelHelper.GetTMResBT((String)objObjectId, biPageType);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8d44\u6e90\u9884\u7ea6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return biPageType;
    }

    protected Boolean TestObjectRenew(Object obj) {
        return false;
    }
}

