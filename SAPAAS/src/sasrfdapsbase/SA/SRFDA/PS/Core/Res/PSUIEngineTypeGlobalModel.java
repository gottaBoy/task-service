/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Res.PSUIEngineTypeImpl;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Data.PSUIEngineType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSUIEngineTypeGlobalModel
extends PSGlobalModelBase<String, PSUIEngineType, IPSUIEngineType> {
    private static final Log log = LogFactory.getLog(PSUIEngineTypeGlobalModel.class);

    @Override
    protected PSUIEngineType GetObject(String strPSUIEngineTypeId) {
        PSUIEngineType psUIEngineType = new PSUIEngineType();
        CallResult callResult = this.iPSModelHelper.getPSUIEngineType(strPSUIEngineTypeId, psUIEngineType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u754c\u9762\u5f15\u64ce\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSUIEngineTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psUIEngineType;
    }

    @Override
    protected IPSUIEngineType OnCreateModelHelper(PSUIEngineType vt) throws Exception {
        PSUIEngineTypeImpl iPSUIEngineType = new PSUIEngineTypeImpl();
        iPSUIEngineType.init(this.iDAGlobalHelper, vt);
        return iPSUIEngineType;
    }

    @Override
    protected Boolean TestObjectRenew(PSUIEngineType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSUIEngineType vt) {
        return vt.getPSUIENGINETYPEID();
    }
}

