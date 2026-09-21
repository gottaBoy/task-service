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

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppServerGlobalModel
extends PSGlobalModelBase<String, PSAppServer, IPSAppServer> {
    private static final Log log = LogFactory.getLog(PSAppServerGlobalModel.class);

    @Override
    protected PSAppServer GetObject(String strPSAppServerId) {
        PSAppServer psAppServer = new PSAppServer();
        CallResult callResult = this.iPSModelHelper.getPSAppServer(strPSAppServerId, psAppServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u5bb9\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psAppServer;
    }

    @Override
    protected IPSAppServer OnCreateModelHelper(PSAppServer psAppServer) throws Exception {
        IPSAppServerType iPSAppServerType = this.getPSModelStorage().getPSAppServerType(psAppServer.getASTYPE());
        IPSAppServer iPSAppServer = iPSAppServerType.createPSAppServer(psAppServer);
        iPSAppServer.init(this.getDAGlobalHelper(), psAppServer);
        return iPSAppServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSAppServer vt) {
        return vt.getPSAPPSERVERID();
    }
}

