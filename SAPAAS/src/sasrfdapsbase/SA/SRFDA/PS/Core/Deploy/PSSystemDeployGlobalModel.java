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

import SA.SRFDA.PS.Core.Deploy.IPSSystemDeploy;
import SA.SRFDA.PS.Core.Deploy.PSSystemDeployImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSystemDeploy;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemDeployGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemDeploy, IPSSystemDeploy> {
    private static final Log log = LogFactory.getLog(PSSystemDeployGlobalModel.class);

    @Override
    protected PSSystemDeploy GetObject(String strPSSystemDeployId) {
        PSSystemDeploy psSystemDeploy = new PSSystemDeploy();
        CallResult callResult = this.iPSModelHelper.getPSSystemDeploy(strPSSystemDeployId, psSystemDeploy);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u90e8\u7f72[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemDeployId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSystemDeploy;
    }

    @Override
    protected IPSSystemDeploy OnCreateModelHelper(PSSystemDeploy vt) throws Exception {
        PSSystemDeployImpl iPSSystemDeploy = new PSSystemDeployImpl();
        iPSSystemDeploy.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSystemDeploy;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystemDeploy obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSystemDeploy vt) {
        return vt.getPSSYSDEPLOYID();
    }
}

