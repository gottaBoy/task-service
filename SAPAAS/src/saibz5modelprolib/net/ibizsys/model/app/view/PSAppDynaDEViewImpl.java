/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.view.IPSViewType
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.view.IPSAppDynaDEView;
import net.ibizsys.model.app.view.PSAppViewImpl;
import net.ibizsys.model.app.view.PSViewAjaxHandlerImpl;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.ajax.IPSAjaxHandlerRuntime;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.entity.PSAppView;
import net.ibizsys.model.entity.PSDynaDEViewTempl;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDynaDEViewImpl
extends PSAppViewImpl
implements IPSAppDynaDEView {
    private static final Log log = LogFactory.getLog(PSAppDynaDEViewImpl.class);
    protected String strPSDynaDEViewTemplId = "";
    protected String strPSDynaDEViewTemplName = "";
    protected IPSViewType iPSViewType = null;
    protected PSDynaDEViewTempl psDynaDEViewTempl = new PSDynaDEViewTempl();
    private boolean bEnableDP = true;
    protected String strPSAjaxControlId = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(iPSApplication);
            this.setPSDynaDEViewTemplId(psApplicationView.getPSDYNADEVIEWTEMPLID());
            this.setPSDynaDEViewTemplName(psApplicationView.getPSDYNADEVIEWTEMPLNAME());
            StringHelper.isNullOrEmpty((String)this.psDynaDEViewTempl.getPSDYNADETEMPLID());
            super.init(iPSModelStorageContext, iPSApplication, psApplicationView);
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
        super.onInit();
    }

    @Override
    protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
        PSACHandler psACHandler = ((IPSSystemRuntime)this.getPSSystem()).getPSAjaxControlHandlerData(strPSAjaxHandlerId, false);
        PSViewAjaxHandlerImpl iPSAjaxHandler = new PSViewAjaxHandlerImpl();
        ((IPSAjaxHandlerRuntime)iPSAjaxHandler).init(this.getPSModelStorageContext(), this, psACHandler);
        return iPSAjaxHandler;
    }

    protected BaseDataEntity createRealViewDataEntity() {
        return new PSDynaDEViewTempl();
    }

    protected BaseDataEntity createRealViewTemplDataEntity() {
        return new PSDynaDEViewTempl();
    }

    @Override
    public String getViewType() {
        return this.iPSViewType.getId();
    }

    @Override
    public String getPSDynaDEViewTemplId() {
        return this.strPSDynaDEViewTemplId;
    }

    @Override
    public String getPSDynaDEViewTemplName() {
        return this.strPSDynaDEViewTemplName;
    }

    protected void setPSDynaDEViewTemplId(String strPSDynaDEViewTemplId) {
        this.strPSDynaDEViewTemplId = strPSDynaDEViewTemplId;
    }

    protected void setPSDynaDEViewTemplName(String strPSDynaDEViewTemplName) {
        this.strPSDynaDEViewTemplName = strPSDynaDEViewTemplName;
    }

    @Override
    public void setPSViewType(IPSViewType iPSViewType) {
        this.iPSViewType = iPSViewType;
    }

    @Override
    public IPSViewType getPSViewType() {
        return this.iPSViewType;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6570\u636e\u6743\u9650")
    public boolean isEnableDP() {
        return this.bEnableDP;
    }

    public String getPSAjaxControlHandlerId() {
        return this.strPSAjaxControlId;
    }

    protected void setPSAjaxControlHandlerId(String strPSAjaxControlId) {
        this.strPSAjaxControlId = strPSAjaxControlId;
    }

    @Override
    protected boolean isUserRefModeDefault() {
        return true;
    }

    public boolean isEnableWF() {
        return false;
    }

    @Override
    public boolean isDynamicView() {
        return true;
    }
}

