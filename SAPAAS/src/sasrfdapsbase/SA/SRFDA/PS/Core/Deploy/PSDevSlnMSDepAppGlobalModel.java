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

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAppImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDevSlnMSDepApp;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevSlnMSDepAppGlobalModel
extends PSGlobalModelBase<String, PSDevSlnMSDepApp, IPSDevSlnMSDepApp> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDepAppGlobalModel.class);

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
    protected PSDevSlnMSDepApp GetObject(String strPSDevSlnMSDepAppId) {
        PSDevSlnMSDepApp psDevSlnMSDepApp = new PSDevSlnMSDepApp();
        CallResult callResult = this.iPSModelHelper.getPSDevSlnMSDepApp(strPSDevSlnMSDepAppId, psDevSlnMSDepApp);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u65b9\u6848\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDevSlnMSDepAppId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psDevSlnMSDepApp;
    }

    @Override
    protected IPSDevSlnMSDepApp OnCreateModelHelper(PSDevSlnMSDepApp vt) throws Exception {
        PSDevSlnMSDepAppImpl iPSDevSlnMSDepApp = new PSDevSlnMSDepAppImpl();
        iPSDevSlnMSDepApp.init(this.iDAGlobalHelper, null, vt);
        return iPSDevSlnMSDepApp;
    }

    @Override
    protected Boolean TestObjectRenew(PSDevSlnMSDepApp obj) {
        return true;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected IPSDevSlnMSDepApp registerModel(PSDevSlnMSDepApp vt) throws Exception {
        IPSDevSlnMSDepApp iPSDevSlnMSDepApp = (IPSDevSlnMSDepApp)this.InternalGetModelHelper(vt.getPSDEVSLNMSDEPAPPID());
        if (iPSDevSlnMSDepApp != null) {
            return iPSDevSlnMSDepApp;
        }
        this.setModel(vt.getPSDEVSLNMSDEPAPPID(), vt, null);
        return (IPSDevSlnMSDepApp)this.FindModelHelper(vt.getPSDEVSLNMSDEPAPPID());
    }

    @Override
    protected String getObjectId(PSDevSlnMSDepApp vt) {
        return vt.getPSDEVSLNMSDEPAPPID();
    }
}

