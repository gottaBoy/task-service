/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppModule
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import java.util.Vector;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.PSAppModuleImpl;
import net.ibizsys.model.app.PSApplicationException;
import net.ibizsys.model.app.PSApplicationGlobalModelBase;
import net.ibizsys.model.entity.PSAppModule;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppModuleGlobalModel
extends PSApplicationGlobalModelBase<String, PSAppModule, IPSAppModule> {
    private static final Log log = LogFactory.getLog(PSAppModuleGlobalModel.class);

    @Override
    protected PSAppModule getObject(String strPSApplicationViewId) {
        PSAppModule psAppModule = new PSAppModule();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppModule(strPSApplicationViewId, psAppModule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u6a21\u5757[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSApplicationViewId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.compare((String)this.getPSApplication().getId(), (String)psAppModule.getPSSYSAPPID(), (boolean)false) != 0) {
            return null;
        }
        return psAppModule;
    }

    @Override
    protected IPSAppModule onCreateModelHelper(PSAppModule vt) throws Exception {
        PSAppModuleImpl iPSAppModule = new PSAppModuleImpl();
        iPSAppModule.init(this.getPSModelStorageContext(), this.getPSApplication(), vt);
        return iPSAppModule;
    }

    @Override
    protected Boolean testObjectRenew(PSAppModule obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSAppModule vt) {
        return vt.getPSAPPMODULEID();
    }

    @Override
    protected IPSAppModule registerModel(PSAppModule vt) throws Exception {
        IPSAppModule iPSAppModule = (IPSAppModule)this.internalGetModelHelper(vt.getPSAPPMODULEID());
        if (iPSAppModule != null) {
            return iPSAppModule;
        }
        this.setModel(vt.getPSAPPMODULEID(), vt, null);
        return (IPSAppModule)this.findModelHelper(vt.getPSAPPMODULEID());
    }

    @Override
    protected Vector<PSAppModule> getAllModels() throws Exception {
        Vector<PSAppModule> list = new Vector<PSAppModule>();
        CallResult callResult = this.getPSModelQueryHelper().getAllPSAppModules(this.iPSApplication.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u5168\u90e8\u5e94\u7528\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
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
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    protected Exception createNotFoundException(String objObjectId) throws Exception {
        return PSApplicationException.create(this.getPSApplication(), 40004, objObjectId);
    }
}

