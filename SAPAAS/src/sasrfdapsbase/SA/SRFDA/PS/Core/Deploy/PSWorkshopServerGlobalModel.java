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

import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSWorkshopServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSWorkshopServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkshopServerGlobalModel
extends PSGlobalModelBase<String, PSWorkshopServer, IPSWorkshopServer> {
    private static final Log log = LogFactory.getLog(PSWorkshopServerGlobalModel.class);

    @Override
    protected PSWorkshopServer GetObject(String strPSWorkshopServerId) {
        PSWorkshopServer psWorkshopServer = new PSWorkshopServer();
        CallResult callResult = this.iPSModelHelper.getPSWorkshopServer(strPSWorkshopServerId, psWorkshopServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5de5\u7a0b\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSWorkshopServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psWorkshopServer;
    }

    @Override
    protected IPSWorkshopServer OnCreateModelHelper(PSWorkshopServer vt) throws Exception {
        PSWorkshopServerImpl iPSWorkshopServer = new PSWorkshopServerImpl();
        iPSWorkshopServer.init(this.iDAGlobalHelper, vt);
        return iPSWorkshopServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSWorkshopServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSWorkshopServer vt) {
        return vt.getPSWORKSHOPSERVERID();
    }
}

