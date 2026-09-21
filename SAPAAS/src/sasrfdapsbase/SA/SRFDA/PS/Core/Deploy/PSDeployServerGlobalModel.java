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

import SA.SRFDA.PS.Core.Deploy.IPSDeployServer;
import SA.SRFDA.PS.Core.Deploy.PSDeployServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDeployServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDeployServerGlobalModel
extends PSGlobalModelBase<String, PSDeployServer, IPSDeployServer> {
    private static final Log log = LogFactory.getLog(PSDeployServerGlobalModel.class);

    @Override
    protected PSDeployServer GetObject(String strPSDeployServerId) {
        PSDeployServer psDeployServer = new PSDeployServer();
        CallResult callResult = this.iPSModelHelper.getPSDeployServer(strPSDeployServerId, psDeployServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6253\u5305\u90e8\u7f72\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDeployServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDeployServer;
    }

    @Override
    protected IPSDeployServer OnCreateModelHelper(PSDeployServer vt) throws Exception {
        PSDeployServerImpl iPSDeployServer = new PSDeployServerImpl();
        iPSDeployServer.init(this.iDAGlobalHelper, vt);
        return iPSDeployServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSDeployServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDeployServer vt) {
        return vt.getPSDEPLOYSERVERID();
    }
}

