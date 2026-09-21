/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.System;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.System.PSSystemModuleImpl;
import SA.SRFDA.PS.Data.PSSystemModule;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemModuleGlobalModel
extends PSSystemGlobalModelBase<String, PSSystemModule, IPSSystemModule> {
    private static final Log log = LogFactory.getLog(PSSystemModuleGlobalModel.class);
    private IPSSystemModule defaultPSSystemModule = null;

    @Override
    protected PSSystemModule GetObject(String strPSSystemModuleId) {
        PSSystemModule psSystemModule = new PSSystemModule();
        CallResult callResult = this.iPSModelHelper.getPSSystemModule(strPSSystemModuleId, psSystemModule);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6a21\u5757[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSystemModuleId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSystemModule;
    }

    @Override
    protected IPSSystemModule OnCreateModelHelper(PSSystemModule vt) throws Exception {
        PSSystemModuleImpl iPSSystemModule = new PSSystemModuleImpl();
        iPSSystemModule.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSystemModule;
    }

    @Override
    protected Boolean TestObjectRenew(PSSystemModule obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        block3: {
            super.onPreloadModels();
            try {
                Iterator psSystemModules = this.getAllModelHelpers();
                if (psSystemModules == null) break block3;
                while (psSystemModules.hasNext()) {
                    IPSSystemModule iPSSystemModule = (IPSSystemModule)psSystemModules.next();
                    if (!iPSSystemModule.isDefaultModule()) continue;
                    this.defaultPSSystemModule = iPSSystemModule;
                    break;
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    @Override
    protected IPSSystemModule registerModel(PSSystemModule vt) throws Exception {
        IPSSystemModule iPSSystemModule = (IPSSystemModule)this.InternalGetModelHelper(vt.getPSMODULEID());
        if (iPSSystemModule != null) {
            return iPSSystemModule;
        }
        this.setModel(vt.getPSMODULEID(), vt, null);
        return (IPSSystemModule)this.FindModelHelper(vt.getPSMODULEID());
    }

    @Override
    protected Vector<PSSystemModule> getAllModels() throws Exception {
        Vector<PSSystemModule> list = new Vector<PSSystemModule>();
        CallResult callResult = this.iPSModelHelper.getAllPSSystemModules(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6a21\u5757\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSystemModule vt) {
        return vt.getPSMODULEID();
    }

    public IPSSystemModule getDefaultPSSystemModule() {
        if (this.defaultPSSystemModule != null) {
            return this.defaultPSSystemModule;
        }
        this.preloadModels();
        return this.defaultPSSystemModule;
    }
}

