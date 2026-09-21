/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelInit;
import SA.SRFDA.PS.Core.PSModelInitImpl;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSModelInit;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelInitGlobalModel
extends BaseDAGlobalModel<String, PSModelInit, IPSModelInit> {
    private static final Log log = LogFactory.getLog(PSModelInitGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;
    private IPSModelInit iPSModelInit = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSModelInit iPSModelInit) {
        this.iPSModelInit = iPSModelInit;
        this.bEnableEmptyMap = true;
        return super.Init(iDAGlobalHelper);
    }

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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u6a21\u578b\u521d\u59cb\u5316\u914d\u7f6e\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSModelInit GetObject(String strPSModelInitId) {
        PSModelInit PSModelInit2 = new PSModelInit();
        CallResult callResult = this.iPSModelHelper.getPSModelInit(strPSModelInitId, PSModelInit2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u6a21\u578b\u521d\u59cb\u5316\u914d\u7f6e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSModelInitId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSModelInit2;
    }

    protected IPSModelInit OnCreateModelHelper(PSModelInit vt) throws Exception {
        PSModelInitImpl iPSModelInit = new PSModelInitImpl();
        iPSModelInit.init(this.iDAGlobalHelper, vt);
        return iPSModelInit;
    }

    protected Boolean TestObjectRenew(PSModelInit obj) {
        return false;
    }
}

