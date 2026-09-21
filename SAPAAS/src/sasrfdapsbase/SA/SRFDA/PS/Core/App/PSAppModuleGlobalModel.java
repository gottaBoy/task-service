/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.PSApplicationException;
import SA.SRFDA.PS.Core.App.PSApplicationGlobalModelBase;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppModuleGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppModule, IPSAppModule> {
    private static final Log log = LogFactory.getLog(PSAppModuleGlobalModel.class);
    private IPSAppModule defaultPSAppModule = null;

    @Override
    protected PSAppModule GetObject(String strPSApplicationViewId) {
        PSAppModule psAppModule = new PSAppModule();
        CallResult callResult = this.iPSModelHelper.getPSAppModule(strPSApplicationViewId, psAppModule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u6a21\u5757[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSApplicationViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)this.getPSApplication().getId(), (String)psAppModule.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppModule;
    }

    @Override
    protected IPSAppModule OnCreateModelHelper(PSAppModule vt) throws Exception {
        PSAppModuleImpl iPSAppModule = new PSAppModuleImpl();
        iPSAppModule.init(this.iDAGlobalHelper, this.getPSApplication(), vt);
        return iPSAppModule;
    }

    @Override
    protected Boolean TestObjectRenew(PSAppModule obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppModule vt) {
        return vt.getPSAPPMODULEID();
    }

    @Override
    protected IPSAppModule registerModel(PSAppModule vt) throws Exception {
        IPSAppModule iPSAppModule = (IPSAppModule)this.InternalGetModelHelper(vt.getPSAPPMODULEID());
        if (iPSAppModule != null) {
            return iPSAppModule;
        }
        this.setModel(vt.getPSAPPMODULEID(), vt, null);
        iPSAppModule = (IPSAppModule)this.FindModelHelper(vt.getPSAPPMODULEID());
        if (iPSAppModule.isDefaultModule()) {
            this.defaultPSAppModule = iPSAppModule;
        }
        return iPSAppModule;
    }

    @Override
    protected Vector<PSAppModule> getAllModels() throws Exception {
        Vector<PSAppModule> list = new Vector<PSAppModule>();
        CallResult callResult = this.iPSModelHelper.getAllPSAppModules(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppModule psAppModule : list) {
            this.setModel(psAppModule.getPSAPPMODULEID(), psAppModule, null);
        }
        return list;
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
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40004, objObjectId);
    }

    public IPSAppModule getDefaultPSAppModule() {
        this.preloadModels();
        return this.defaultPSAppModule;
    }
}

