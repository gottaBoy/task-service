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

import SA.SRFDA.PS.Core.Deploy.IPSDCCluster;
import SA.SRFDA.PS.Core.Deploy.PSDCClusterImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDCCluster;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCClusterGlobalModel
extends PSGlobalModelBase<String, PSDCCluster, IPSDCCluster> {
    private static final Log log = LogFactory.getLog(PSDCClusterGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.nRenewTimer = 0;
        return super.OnInit();
    }

    @Override
    protected boolean getEnableRenew() {
        return true;
    }

    @Override
    protected PSDCCluster GetObject(String strPSDCClusterId) {
        PSDCCluster psCluster = new PSDCCluster();
        CallResult callResult = this.iPSModelHelper.getPSDCCluster(strPSDCClusterId, psCluster);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u8ba1\u7b97\u96c6\u7fa4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCClusterId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psCluster;
    }

    @Override
    protected IPSDCCluster OnCreateModelHelper(PSDCCluster vt) throws Exception {
        PSDCClusterImpl iPSDCCluster = new PSDCClusterImpl();
        iPSDCCluster.init(this.iDAGlobalHelper, vt);
        return iPSDCCluster;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCCluster obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDCCluster vt) {
        return vt.getPSDCCLUSTERID();
    }
}

