/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.PSSubAppImpl;
import SA.SRFDA.PS.Core.SubSys.PSSubSysGlobalModelBase;
import SA.SRFDA.PS.Data.PSSubApp;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubAppGlobalModel
extends PSSubSysGlobalModelBase<String, PSSubApp, IPSSubApp> {
    private static final Log log = LogFactory.getLog(PSSubAppGlobalModel.class);

    @Override
    protected PSSubApp GetObject(String strPSSubAppId) {
        PSSubApp psSubApp = new PSSubApp();
        CallResult callResult = this.iPSModelHelper.getPSSubApp(strPSSubAppId, psSubApp);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b50\u7cfb\u7edf\u5e94\u7528[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSubAppId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSubApp;
    }

    @Override
    protected IPSSubApp OnCreateModelHelper(PSSubApp vt) throws Exception {
        PSSubAppImpl iPSSubApp = new PSSubAppImpl();
        iPSSubApp.init(this.iDAGlobalHelper, this.getPSSubSys(), vt);
        return iPSSubApp;
    }

    @Override
    protected Boolean TestObjectRenew(PSSubApp obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSSubApp registerModel(PSSubApp vt) throws Exception {
        IPSSubApp iPSSubApp = (IPSSubApp)this.InternalGetModelHelper(vt.getPSSUBAPPID());
        if (iPSSubApp != null) {
            return iPSSubApp;
        }
        this.setModel(vt.getPSSUBAPPID(), vt, null);
        return (IPSSubApp)this.FindModelHelper(vt.getPSSUBAPPID());
    }

    @Override
    protected Vector<PSSubApp> getAllModels() throws Exception {
        Vector<PSSubApp> list = new Vector<PSSubApp>();
        CallResult callResult = this.iPSModelHelper.getAllPSSubApps(this.getPSSubSys().getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u5168\u90e8\u5e94\u7528\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSubApp vt) {
        return vt.getPSSUBAPPID();
    }
}

