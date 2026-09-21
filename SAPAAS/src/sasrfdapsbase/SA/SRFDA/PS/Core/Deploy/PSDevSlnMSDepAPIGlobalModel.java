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

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAPIImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevSlnMSDepAPI;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepAPIGlobalModel
extends PSGlobalModelBase<String, PSDevSlnMSDepAPI, IPSDevSlnMSDepAPI> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAPIGlobalModel.class);

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
    protected PSDevSlnMSDepAPI GetObject(String strPSDevSlnMSDepAPIId) {
        PSDevSlnMSDepAPI psDevSlnMSDepAPI = new PSDevSlnMSDepAPI();
        CallResult callResult = this.iPSModelHelper.getPSDevSlnMSDepAPI(strPSDevSlnMSDepAPIId, psDevSlnMSDepAPI);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevSlnMSDepAPIId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevSlnMSDepAPI;
    }

    @Override
    protected IPSDevSlnMSDepAPI OnCreateModelHelper(PSDevSlnMSDepAPI vt) throws Exception {
        PSDevSlnMSDepAPIImpl iPSDevSlnMSDepAPI = new PSDevSlnMSDepAPIImpl();
        iPSDevSlnMSDepAPI.init(this.iDAGlobalHelper, null, vt);
        return iPSDevSlnMSDepAPI;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevSlnMSDepAPI obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected IPSDevSlnMSDepAPI registerModel(PSDevSlnMSDepAPI vt) throws Exception {
        IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI = (IPSDevSlnMSDepAPI)this.InternalGetModelHelper(vt.getPSDEVSLNMSDEPAPIID());
        if (iPSDevSlnMSDepAPI != null) {
            return iPSDevSlnMSDepAPI;
        }
        this.setModel(vt.getPSDEVSLNMSDEPAPIID(), vt, null);
        return (IPSDevSlnMSDepAPI)this.FindModelHelper(vt.getPSDEVSLNMSDEPAPIID());
    }

    @Override
    protected String getObjectId(PSDevSlnMSDepAPI vt) {
        return vt.getPSDEVSLNMSDEPAPIID();
    }
}

