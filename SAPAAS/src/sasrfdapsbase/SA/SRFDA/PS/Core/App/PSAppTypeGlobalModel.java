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
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.App.PSAppTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSAppType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppTypeGlobalModel
extends BaseDAGlobalModel<String, PSAppType, IPSAppType> {
    private static final Log log = LogFactory.getLog(PSAppTypeGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.isError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5e94\u7528\u7a0b\u5e8f\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSAppType GetObject(String strPSAppTypeId) {
        PSAppType PSAppType2 = new PSAppType();
        CallResult callResult = this.iPSModelHelper.getPSAppType(strPSAppTypeId, PSAppType2);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u7a0b\u5e8f\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSAppType2;
    }

    protected IPSAppType OnCreateModelHelper(PSAppType vt) throws Exception {
        PSAppTypeImpl iPSAppType = new PSAppTypeImpl();
        iPSAppType.init(this.iDAGlobalHelper, vt);
        return iPSAppType;
    }

    protected Boolean TestObjectRenew(PSAppType obj) {
        return false;
    }
}

