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

import SA.SRFDA.PS.Core.Deploy.IPSMQInst;
import SA.SRFDA.PS.Core.Deploy.PSMQInstImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMQInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMQInstGlobalModel
extends PSGlobalModelBase<String, PSMQInst, IPSMQInst> {
    private static final Log log = LogFactory.getLog(PSMQInstGlobalModel.class);

    @Override
    protected PSMQInst GetObject(String strPSMQInstId) {
        PSMQInst psMQInst = new PSMQInst();
        CallResult callResult = this.iPSModelHelper.getPSMQInst(strPSMQInstId, psMQInst);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0MQ\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMQInstId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psMQInst;
    }

    @Override
    protected IPSMQInst OnCreateModelHelper(PSMQInst vt) throws Exception {
        PSMQInstImpl iPSMQInst = new PSMQInstImpl();
        iPSMQInst.init(this.iDAGlobalHelper, vt);
        return iPSMQInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSMQInst obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMQInst vt) {
        return vt.getPSMQINSTID();
    }
}

