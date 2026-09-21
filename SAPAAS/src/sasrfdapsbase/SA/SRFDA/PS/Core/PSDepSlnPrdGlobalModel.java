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

import SA.SRFDA.PS.Core.IPSDepSlnPrd;
import SA.SRFDA.PS.Core.PSDepSlnPrdImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSlnPrd;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnPrdGlobalModel
extends PSGlobalModelBase<String, PSDepSlnPrd, IPSDepSlnPrd> {
    private static final Log log = LogFactory.getLog(PSDepSlnPrdGlobalModel.class);

    @Override
    protected PSDepSlnPrd GetObject(String strPSDepSlnPrdId) {
        PSDepSlnPrd PSDepSlnPrd2 = new PSDepSlnPrd();
        CallResult callResult = this.iPSModelHelper.getPSDepSlnPrd(strPSDepSlnPrdId, PSDepSlnPrd2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u90e8\u7f72\u4ea7\u54c1[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepSlnPrdId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepSlnPrd2;
    }

    @Override
    protected IPSDepSlnPrd OnCreateModelHelper(PSDepSlnPrd vt) throws Exception {
        PSDepSlnPrdImpl iPSDepSlnPrd = new PSDepSlnPrdImpl();
        iPSDepSlnPrd.init(this.iDAGlobalHelper, vt);
        return iPSDepSlnPrd;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnPrd obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepSlnPrd vt) {
        return vt.getPSDEPSLNPRDID();
    }
}

