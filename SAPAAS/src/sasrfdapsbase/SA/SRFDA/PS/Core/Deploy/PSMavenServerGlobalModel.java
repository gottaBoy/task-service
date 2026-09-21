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

import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.PSMavenServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMavenServerGlobalModel
extends PSGlobalModelBase<String, PSMavenServer, IPSMavenServer> {
    private static final Log log = LogFactory.getLog(PSMavenServerGlobalModel.class);

    @Override
    protected PSMavenServer GetObject(String strPSMavenServerId) {
        PSMavenServer psMavenServer = new PSMavenServer();
        CallResult callResult = this.iPSModelHelper.getPSMavenServer(strPSMavenServerId, psMavenServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0Maven\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMavenServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psMavenServer;
    }

    @Override
    protected IPSMavenServer OnCreateModelHelper(PSMavenServer vt) throws Exception {
        PSMavenServerImpl iPSMavenServer = new PSMavenServerImpl();
        iPSMavenServer.init(this.iDAGlobalHelper, vt);
        return iPSMavenServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSMavenServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMavenServer vt) {
        return vt.getPSMAVENSERVERID();
    }
}

