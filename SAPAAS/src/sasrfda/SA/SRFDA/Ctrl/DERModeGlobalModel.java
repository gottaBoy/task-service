/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.DERMode;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DERModeGlobalModel
extends BaseDAGlobalModel<String, DERMode, IDERModeHelper> {
    private static final Log log = LogFactory.getLog(DERModeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected DERMode GetObject(String objObjectId) {
        DERMode derMode = new DERMode();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetDERMode(objObjectId, derMode);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return derMode;
    }

    @Override
    protected Boolean TestObjectRenew(DERMode obj) {
        return false;
    }

    @Override
    protected IDERModeHelper OnCreateModelHelper(DERMode derMode) throws Exception {
        Object objDERModeHelper;
        String strHelperObject = "";
        if (StringHelper.IsNullOrEmpty((String)derMode.getHELPEROBJECT())) {
            strHelperObject = "SA.SRFDA.Ctrl.DERModeHelper";
        }
        if ((objDERModeHelper = ObjectHelper.Create((String)strHelperObject)) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]", (Object)derMode.getDERMODEID(), (Object)strHelperObject));
        }
        if (!(objDERModeHelper instanceof IDERModeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u5173\u7cfb\u6a21\u5f0f[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)derMode.getDERMODEID(), (Object)strHelperObject));
        }
        IDERModeHelper iDERModeHelper = (IDERModeHelper)objDERModeHelper;
        iDERModeHelper.Init(this.iDAGlobalHelper, derMode);
        return iDERModeHelper;
    }
}

