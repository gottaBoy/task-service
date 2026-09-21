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

import SA.SRFDA.PS.Core.Deploy.IPSSVNServer;
import SA.SRFDA.PS.Core.Deploy.PSSVNServerImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSSVNServer;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSVNServerGlobalModel
extends PSGlobalModelBase<String, PSSVNServer, IPSSVNServer> {
    private static final Log log = LogFactory.getLog(PSSVNServerGlobalModel.class);

    @Override
    protected PSSVNServer GetObject(String strPSSVNServerId) {
        PSSVNServer psSVNServer = new PSSVNServer();
        CallResult callResult = this.iPSModelHelper.getPSSVNServer(strPSSVNServerId, psSVNServer);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u7248\u672c\u63a7\u5236\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSVNServerId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSVNServer;
    }

    @Override
    protected IPSSVNServer OnCreateModelHelper(PSSVNServer vt) throws Exception {
        PSSVNServerImpl iPSSVNServer = new PSSVNServerImpl();
        iPSSVNServer.init(this.iDAGlobalHelper, vt);
        return iPSSVNServer;
    }

    @Override
    protected Boolean TestObjectRenew(PSSVNServer obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSSVNServer vt) {
        return vt.getPSSVNSERVERID();
    }
}

