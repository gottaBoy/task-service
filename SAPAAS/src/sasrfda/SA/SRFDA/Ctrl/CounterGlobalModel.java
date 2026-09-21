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
import SA.SRFDA.Ctrl.Data.Counter;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CounterGlobalModel
extends BaseDAGlobalModel<String, Counter, ICounterHelper> {
    private static final Log log = LogFactory.getLog(CounterGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected Counter GetObject(String objObjectId) {
        Counter Counter2 = new Counter();
        CallResult callRsult = this.iDAGlobalHelper.getDAModelHelper().GetCounter(objObjectId, Counter2);
        if (callRsult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callRsult.getErrorInfo()));
            return null;
        }
        return Counter2;
    }

    @Override
    protected Boolean TestObjectRenew(Counter obj) {
        if (obj.getVERSION() != this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0286", obj.getCOUNTERID())) {
            return true;
        }
        return false;
    }

    @Override
    protected ICounterHelper OnCreateModelHelper(Counter vt) throws Exception {
        Object objObject;
        String strObjectName = vt.getHELPEROBJECT();
        if (StringHelper.IsNullOrEmpty((String)strObjectName) && !StringHelper.IsNullOrEmpty((String)vt.getCOUNTERTYPE())) {
            ICounterTypeHelper iCounterTypeHelper = this.iDAGlobalHelper.getDAModelStorage().FindCounterType(vt.getCOUNTERTYPE());
            strObjectName = iCounterTypeHelper.getCounterHelperObject();
        }
        if ((objObject = ObjectHelper.Create((String)strObjectName)) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61[%1$s]", (Object)strObjectName));
        }
        if (!(objObject instanceof ICounterHelper)) {
            throw new Exception(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObjectName));
        }
        ICounterHelper iCounterHelper = (ICounterHelper)objObject;
        iCounterHelper.Init(this.iDAGlobalHelper, vt);
        return iCounterHelper;
    }
}

