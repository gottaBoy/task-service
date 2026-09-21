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

import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.PSCounterTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSCounterType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCounterTypeGlobalModel
extends PSGlobalModelBase<String, PSCounterType, IPSCounterType> {
    private static final Log log = LogFactory.getLog(PSCounterTypeGlobalModel.class);

    @Override
    protected PSCounterType GetObject(String strPSCounterTypeId) {
        PSCounterType PSCounterType2 = new PSCounterType();
        CallResult callResult = this.iPSModelHelper.getPSCounterType(strPSCounterTypeId, PSCounterType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u8ba1\u6570\u5668\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCounterTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSCounterType2;
    }

    @Override
    protected IPSCounterType OnCreateModelHelper(PSCounterType vt) throws Exception {
        PSCounterTypeImpl iPSCounterType = new PSCounterTypeImpl();
        iPSCounterType.init(this.iDAGlobalHelper, vt);
        return iPSCounterType;
    }

    @Override
    protected Boolean TestObjectRenew(PSCounterType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSCounterType vt) {
        return vt.getPSCOUNTERTYPEID();
    }
}

