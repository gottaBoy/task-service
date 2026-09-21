/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.PSSystemImpl;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemGlobalModel
extends PSGlobalModelBase<String, PSSystem, IPSSystem> {
    private static final Log log = LogFactory.getLog(PSSystemGlobalModel.class);

    @Override
    protected PSSystem GetObject(String strPSSystemId) {
        PSSystem PSSystem2 = new PSSystem();
        CallResult callResult = this.iPSModelHelper.getPSSystem(strPSSystemId, PSSystem2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSSystem2;
    }

    @Override
    protected IPSSystem OnCreateModelHelper(PSSystem vt) throws Exception {
        PSSystemImpl iPSSystem = new PSSystemImpl();
        iPSSystem.init(this.iDAGlobalHelper, null, vt);
        return iPSSystem;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystem obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSystem vt) {
        return vt.getPSSYSTEMID();
    }
}

