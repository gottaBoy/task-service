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
import SA.SRFDA.Ctrl.Data.DERType;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DERTypeGlobalModel
extends BaseDAGlobalModel<String, DERType, IDERTypeHelper> {
    private static final Log log = LogFactory.getLog(DERTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected DERType GetObject(String objObjectId) {
        DERType derType = new DERType();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetDERType(objObjectId, derType);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb\u7c7b\u522b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        int nDEVersion = this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0001", derType.getDEID());
        derType.SetParamValue("DEVERSION", nDEVersion);
        return derType;
    }

    @Override
    protected Boolean TestObjectRenew(DERType obj) {
        if (obj.GetParamIntValue("DEVERSION", 0) != this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0001", obj.getDEID())) {
            return true;
        }
        return false;
    }

    @Override
    protected IDERTypeHelper OnCreateModelHelper(DERType vt) throws Exception {
        String strObjectName = "SA.SRFDA.Ctrl.DERTypeHelper";
        Object objObject = ObjectHelper.Create((String)strObjectName);
        if (objObject == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strObjectName));
        }
        if (!(objObject instanceof IDERTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObjectName));
        }
        IDERTypeHelper iDERTypeHelper = (IDERTypeHelper)objObject;
        iDERTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iDERTypeHelper;
    }
}

