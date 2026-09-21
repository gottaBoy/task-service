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

import SA.SRFDA.PS.Core.Deploy.IPSDCDBDevInst;
import SA.SRFDA.PS.Core.Deploy.PSDCDBDevInstImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCDBDevInstGlobalModel
extends PSGlobalModelBase<String, PSDevCenterDBInst, IPSDCDBDevInst> {
    private static final Log log = LogFactory.getLog(PSDCDBDevInstGlobalModel.class);

    @Override
    protected PSDevCenterDBInst GetObject(String strPSDCDBDevInstId) {
        PSDevCenterDBInst psDevCenterDBInst = new PSDevCenterDBInst();
        CallResult callResult = this.iPSModelHelper.getPSDCDBInst(strPSDCDBDevInstId, psDevCenterDBInst);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCDBDevInstId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevCenterDBInst;
    }

    @Override
    protected IPSDCDBDevInst OnCreateModelHelper(PSDevCenterDBInst vt) throws Exception {
        PSDCDBDevInstImpl iPSDCDBDevInst = new PSDCDBDevInstImpl();
        iPSDCDBDevInst.init(this.iDAGlobalHelper, vt);
        return iPSDCDBDevInst;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevCenterDBInst obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevCenterDBInst vt) {
        return vt.getPSDEVCENTERDBINSTID();
    }
}

