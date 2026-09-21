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

import SA.SRFDA.PS.Core.Deploy.IPSMobAppPackServer;
import SA.SRFDA.PS.Core.Deploy.PSMobAppPackServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSMobAppPackServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMobAppPackServerGlobalModel
extends PSGlobalModelBase<String, PSMobAppPackServer, IPSMobAppPackServer> {
    private static final Log log = LogFactory.getLog(PSMobAppPackServerGlobalModel.class);

    @Override
    protected PSMobAppPackServer GetObject(String strPSMobAppPackServerId) {
        PSMobAppPackServer psMobAppPackServer = new PSMobAppPackServer();
        CallResult callResult = this.iPSModelHelper.getPSMobAppPackServer(strPSMobAppPackServerId, psMobAppPackServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u79fb\u52a8\u7aef\u5e94\u7528\u6253\u5305\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSMobAppPackServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psMobAppPackServer;
    }

    @Override
    protected IPSMobAppPackServer OnCreateModelHelper(PSMobAppPackServer vt) throws Exception {
        PSMobAppPackServerImpl iPSMobAppPackServer = new PSMobAppPackServerImpl();
        iPSMobAppPackServer.init(this.iDAGlobalHelper, vt);
        return iPSMobAppPackServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSMobAppPackServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSMobAppPackServer vt) {
        return vt.getPSMOBAPPPACKSERVERID();
    }
}

