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
import net.ibizsys.model.app.IPSAppUtilPageRuntime;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.entity.PSAppUtilPage;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppUtilPageImpl
extends PSApplicationObjectImpl
implements IPSAppUtilPageRuntime {
    protected PSAppUtilPage psAppUtilPage = null;
    private static final Log log = LogFactory.getLog(PSAppUtilPageImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppUtilPage psAppUtilPage) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psAppUtilPage = psAppUtilPage;
            this.setId(this.psAppUtilPage.getPSAPPUTILPAGEID());
            this.setName(this.psAppUtilPage.getPSAPPUTILPAGENAME());
            this.setPSObjectData(this.psAppUtilPage);
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u7c7b\u578b", codelist="AppUtilPage")
    public String getName() {
        return super.getName();
    }

    @PSModelRTMeta(description="\u9875\u9762\u8def\u5f84")
    public String getPageUrl() {
        return this.psAppUtilPage.getPAGEURL();
    }
}

