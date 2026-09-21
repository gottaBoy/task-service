/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnType;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDepSlnType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDepSlnTypeGlobalModel
extends PSGlobalModelBase<String, PSDepSlnType, IPSDepSlnType> {
    private static final Log log = LogFactory.getLog(PSDepSlnTypeGlobalModel.class);

    @Override
    protected PSDepSlnType GetObject(String strPSDepSlnTypeId) {
        PSDepSlnType PSDepSlnType2 = new PSDepSlnType();
        CallResult callResult = this.iPSModelHelper.getPSDepSlnType(strPSDepSlnTypeId, PSDepSlnType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u90e8\u7f72\u65b9\u6848\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDepSlnTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDepSlnType2;
    }

    @Override
    protected IPSDepSlnType OnCreateModelHelper(PSDepSlnType vt) throws Exception {
        PSDepSlnTypeImpl iPSDepSlnType = new PSDepSlnTypeImpl();
        iPSDepSlnType.init(this.iDAGlobalHelper, vt);
        return iPSDepSlnType;
    }

    @Override
    protected Boolean TestObjectRenew(PSDepSlnType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDepSlnType vt) {
        return vt.getPSDEPSLNTYPEID();
    }
}

