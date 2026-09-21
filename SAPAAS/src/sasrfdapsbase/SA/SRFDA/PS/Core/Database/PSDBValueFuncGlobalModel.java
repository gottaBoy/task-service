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
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Database.IPSDBValueFunc;
import SA.SRFDA.PS.Core.Database.PSDBValueFuncImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSDBValueFunc;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBValueFuncGlobalModel
extends BaseDAGlobalModel<String, PSDBValueFunc, IPSDBValueFunc> {
    private static final Log log = LogFactory.getLog(PSDBValueFuncGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u6570\u636e\u5e93\u503c\u51fd\u6570\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSDBValueFunc GetObject(String strPSDBValueFuncId) {
        PSDBValueFunc PSDBValueFunc2 = new PSDBValueFunc();
        CallResult callResult = this.iPSModelHelper.getPSDBValueFunc(strPSDBValueFuncId, PSDBValueFunc2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6570\u636e\u5e93\u503c\u51fd\u6570[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBValueFuncId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDBValueFunc2;
    }

    protected IPSDBValueFunc OnCreateModelHelper(PSDBValueFunc vt) throws Exception {
        PSDBValueFuncImpl iPSDBValueFunc = new PSDBValueFuncImpl();
        iPSDBValueFunc.init(this.iDAGlobalHelper, vt);
        return iPSDBValueFunc;
    }

    protected Boolean TestObjectRenew(PSDBValueFunc obj) {
        return false;
    }
}

