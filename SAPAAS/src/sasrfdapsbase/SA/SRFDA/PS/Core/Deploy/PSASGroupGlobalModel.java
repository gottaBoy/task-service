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

import SA.SRFDA.PS.Core.Deploy.IPSASGroup;
import SA.SRFDA.PS.Core.Deploy.PSASGroupImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSASGroup;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSASGroupGlobalModel
extends PSGlobalModelBase<String, PSASGroup, IPSASGroup> {
    private static final Log log = LogFactory.getLog(PSASGroupGlobalModel.class);

    @Override
    protected PSASGroup GetObject(String strPSASGroupId) {
        PSASGroup psASGroup = new PSASGroup();
        CallResult callResult = this.iPSModelHelper.getPSASGroup(strPSASGroupId, psASGroup);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u5bb9\u5668\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSASGroupId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psASGroup;
    }

    @Override
    protected IPSASGroup OnCreateModelHelper(PSASGroup vt) throws Exception {
        PSASGroupImpl iPSASGroup = new PSASGroupImpl();
        iPSASGroup.init(this.iDAGlobalHelper, vt);
        return iPSASGroup;
    }

    @Override
    protected Boolean TestObjectRenew(PSASGroup obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSASGroup vt) {
        return vt.getPSASGROUPID();
    }
}

