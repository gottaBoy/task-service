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

import SA.SRFDA.PS.Core.Deploy.IPSDevServer;
import SA.SRFDA.PS.Core.Deploy.PSDevServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevServerGlobalModel
extends PSGlobalModelBase<String, PSDevServer, IPSDevServer> {
    private static final Log log = LogFactory.getLog(PSDevServerGlobalModel.class);

    @Override
    protected PSDevServer GetObject(String strPSDevServerId) {
        PSDevServer psDevServer = new PSDevServer();
        CallResult callResult = this.iPSModelHelper.getPSDevServer(strPSDevServerId, psDevServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5f00\u53d1\u684c\u9762[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevServer;
    }

    @Override
    protected IPSDevServer OnCreateModelHelper(PSDevServer vt) throws Exception {
        PSDevServerImpl iPSDevServer = new PSDevServerImpl();
        iPSDevServer.init(this.iDAGlobalHelper, vt);
        return iPSDevServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDevServer vt) {
        return vt.getPSDEVSERVERID();
    }
}

