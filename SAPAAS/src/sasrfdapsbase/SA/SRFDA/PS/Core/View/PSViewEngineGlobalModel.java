/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.PSViewEngineImpl;
import SA.SRFDA.PS.Data.PSViewEngine;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewEngineGlobalModel
extends PSGlobalModelBase<String, PSViewEngine, IPSViewEngine> {
    private static final Log log = LogFactory.getLog(PSViewEngineGlobalModel.class);

    @Override
    protected PSViewEngine GetObject(String strPSViewEngineId) {
        PSViewEngine PSViewEngine2 = new PSViewEngine();
        CallResult callResult = this.iPSModelHelper.getPSViewEngine(strPSViewEngineId, PSViewEngine2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u89c6\u56fe\u5f15\u64ce[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewEngineId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSViewEngine2;
    }

    @Override
    protected IPSViewEngine OnCreateModelHelper(PSViewEngine vt) throws Exception {
        PSViewEngineImpl iPSViewEngine = new PSViewEngineImpl();
        iPSViewEngine.init(this.iDAGlobalHelper, vt);
        return iPSViewEngine;
    }

    @Override
    protected Boolean TestObjectRenew(PSViewEngine obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSViewEngine vt) {
        return vt.getPSVIEWENGINEID();
    }
}

