/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSAppModuleRuntime;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.entity.PSAppModule;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppModuleImpl
extends PSApplicationObjectImpl
implements IPSAppModuleRuntime {
    private static final Log log = LogFactory.getLog(PSAppModuleImpl.class);
    protected PSAppModule psAppModule = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppModule psAppModule) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psAppModule = psAppModule;
            this.setId(this.psAppModule.getPSAPPMODULEID());
            this.setName(this.psAppModule.getPSAPPMODULENAME());
            this.setPSObjectData(this.psAppModule);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psAppModule.getCODENAME();
    }
}

