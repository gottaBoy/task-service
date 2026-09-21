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

import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.PSDevSlnSysDynaInstImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnSysDynaInstGlobalModel
extends PSGlobalModelBase<String, PSDevSlnSysDynaInst, IPSDevSlnSysDynaInst> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstGlobalModel.class);

    @Override
    protected PSDevSlnSysDynaInst GetObject(String strPSDevSlnSysDynaInstId) {
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        CallResult callResult = this.iPSModelHelper.getPSDevSlnSysDynaInst(strPSDevSlnSysDynaInstId, psDevSlnSysDynaInst);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevSlnSysDynaInstId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevSlnSysDynaInst;
    }

    @Override
    protected IPSDevSlnSysDynaInst OnCreateModelHelper(PSDevSlnSysDynaInst vt) throws Exception {
        PSDevSlnSysDynaInstImpl iPSDevSlnSysDynaInst = new PSDevSlnSysDynaInstImpl();
        iPSDevSlnSysDynaInst.init(this.iDAGlobalHelper, vt);
        return iPSDevSlnSysDynaInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevSlnSysDynaInst obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevSlnSysDynaInst vt) {
        return vt.getPSDEVSLNSYSDYNAINSTID();
    }
}

