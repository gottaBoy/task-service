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

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.PSDevSlnSysImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnSysGlobalModel
extends PSGlobalModelBase<String, PSDevSlnSys, IPSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysGlobalModel.class);

    @Override
    protected PSDevSlnSys GetObject(String strPSDevSlnSysId) {
        PSDevSlnSys PSDevSlnSys2 = new PSDevSlnSys();
        CallResult callResult = this.iPSModelHelper.getPSDevSlnSys(strPSDevSlnSysId, PSDevSlnSys2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevSlnSysId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDevSlnSys2;
    }

    @Override
    protected IPSDevSlnSys OnCreateModelHelper(PSDevSlnSys vt) throws Exception {
        PSDevSlnSysImpl iPSDevSlnSys = new PSDevSlnSysImpl();
        iPSDevSlnSys.init(this.iDAGlobalHelper, vt);
        return iPSDevSlnSys;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevSlnSys obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevSlnSys vt) {
        return vt.getPSDEVSLNSYSID();
    }
}

