/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.res.IPSSysPDTView
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.PSApplicationObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.entity.PSAppPDTView;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppPDTViewImpl
extends PSApplicationObjectImpl
implements IPSAppPDTView {
    protected PSAppPDTView psAppPDTView = null;
    private static final Log log = LogFactory.getLog(PSAppPDTViewImpl.class);
    private IPSSysPDTView iPSSysPDTView = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppPDTView psAppPDTView) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.psAppPDTView = psAppPDTView;
            this.setId(this.psAppPDTView.getPSAPPPDTVIEWID());
            this.setName(this.psAppPDTView.getPSAPPPDTVIEWNAME());
            this.setPSObjectData(this.psAppPDTView);
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
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psAppPDTView.getPSSYSPDTVIEWID())) {
            this.iPSSysPDTView = this.getPSSystem().getPSSysPDTView(this.psAppPDTView.getPSSYSPDTVIEWID());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5e94\u7528\u89c6\u56fe", hideempty=true)
    public IPSAppView getPSAppView() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psAppPDTView.getPSAPPVIEWID())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u76ee\u6807\u5e94\u7528\u89c6\u56fe");
        }
        return this.getPSApplication().getPSAppView(this.psAppPDTView.getPSAPPVIEWID(), false);
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe", hideempty=true)
    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }
}

