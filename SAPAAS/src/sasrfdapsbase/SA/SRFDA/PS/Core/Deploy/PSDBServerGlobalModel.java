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

import SA.SRFDA.PS.Core.Deploy.IPSDBServer;
import SA.SRFDA.PS.Core.Deploy.PSDBServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDBServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBServerGlobalModel
extends PSGlobalModelBase<String, PSDBServer, IPSDBServer> {
    private static final Log log = LogFactory.getLog(PSDBServerGlobalModel.class);

    @Override
    protected PSDBServer GetObject(String strPSDBServerId) {
        PSDBServer psDBServer = new PSDBServer();
        CallResult callResult = this.iPSModelHelper.getPSDBServer(strPSDBServerId, psDBServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u6570\u636e\u5e93\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDBServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDBServer;
    }

    @Override
    protected IPSDBServer OnCreateModelHelper(PSDBServer vt) throws Exception {
        PSDBServerImpl iPSDBServer = new PSDBServerImpl();
        iPSDBServer.init(this.iDAGlobalHelper, vt);
        return iPSDBServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSDBServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSDBServer vt) {
        return vt.getPSDBSERVERID();
    }
}

