/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCounterGlobalModel
extends PSGlobalModelBase<String, PSCounter, IPSCounter> {
    private static final Log log = LogFactory.getLog(PSCounterGlobalModel.class);

    @Override
    protected PSCounter GetObject(String strPSCounterId) {
        PSCounter psCounter = new PSCounter();
        CallResult callResult = this.iPSModelHelper.getPSCounter(strPSCounterId, psCounter);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u9884\u7f6e\u8ba1\u6570\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCounterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psCounter;
    }

    @Override
    protected IPSCounter OnCreateModelHelper(PSCounter vt) throws Exception {
        IPSCounterType iPSCounterType = this.iPSModelStorage.getPSCounterType(vt.getCOUNTERTYPE());
        IPSCounter iPSCounter = iPSCounterType.createPSCounter(vt);
        iPSCounter.init(this.iDAGlobalHelper, vt);
        return iPSCounter;
    }

    @Override
    protected Boolean TestObjectRenew(PSCounter obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSCounter vt) {
        return vt.getPSCOUNTERID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

