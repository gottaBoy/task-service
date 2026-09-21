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

import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.PSDeployCenterImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDeployCenter;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDeployCenterGlobalModel
extends PSGlobalModelBase<String, PSDeployCenter, IPSDeployCenter> {
    private static final Log log = LogFactory.getLog(PSDeployCenterGlobalModel.class);

    @Override
    protected PSDeployCenter GetObject(String strPSDeployCenterId) {
        PSDeployCenter psDeployCenter = new PSDeployCenter();
        CallResult callResult = this.iPSModelHelper.getPSDeployCenter(strPSDeployCenterId, psDeployCenter);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6253\u5305\u90e8\u7f72\u4e2d\u5fc3[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDeployCenterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDeployCenter;
    }

    @Override
    protected IPSDeployCenter OnCreateModelHelper(PSDeployCenter vt) throws Exception {
        PSDeployCenterImpl iPSDeployCenter = new PSDeployCenterImpl();
        iPSDeployCenter.init(this.iDAGlobalHelper, vt);
        return iPSDeployCenter;
    }

    @Override
    protected Boolean TestObjectRenew(PSDeployCenter obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDeployCenter vt) {
        return vt.getPSDEPLOYCENTERID();
    }
}

