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
import net.ibizsys.model.app.IPSAppLanRuntime;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.entity.PSAppLan;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppLanImpl
extends PSApplicationObjectImpl
implements IPSAppLanRuntime {
    private static final Log log = LogFactory.getLog(PSAppLanImpl.class);
    protected PSAppLan psAppLan = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppLan psAppLan) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psAppLan = psAppLan;
            this.setId(this.psAppLan.getPSAPPLANID());
            this.setName(this.psAppLan.getPSAPPLANNAME());
            this.setPSObjectData(this.psAppLan);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u8bed\u8a00")
    public String getLanguage() {
        return this.psAppLan.getPSLANGUAGEID();
    }
}

