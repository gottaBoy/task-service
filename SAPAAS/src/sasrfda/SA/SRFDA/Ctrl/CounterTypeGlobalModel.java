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
import SA.SRFDA.Ctrl.Data.CounterType;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CounterTypeGlobalModel
extends BaseDAGlobalModel<String, CounterType, ICounterTypeHelper> {
    private static final Log log = LogFactory.getLog(CounterTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CounterType GetObject(String objObjectId) {
        CounterType CounterType2 = new CounterType();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetCounterType(objObjectId, CounterType2);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8ba1\u6570\u5668\u7c7b\u522b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return CounterType2;
    }

    @Override
    protected Boolean TestObjectRenew(CounterType obj) {
        if (obj.getVERSION() != this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0285", obj.getCOUNTERTYPEID())) {
            return true;
        }
        return false;
    }

    @Override
    protected ICounterTypeHelper OnCreateModelHelper(CounterType vt) throws Exception {
        String strObjectName = "SA.SRFDA.Ctrl.CounterTypeHelper";
        Object objObject = ObjectHelper.Create((String)strObjectName);
        if (objObject == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strObjectName));
        }
        if (!(objObject instanceof ICounterTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObjectName));
        }
        ICounterTypeHelper iCounterTypeHelper = (ICounterTypeHelper)objObject;
        iCounterTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iCounterTypeHelper;
    }
}

