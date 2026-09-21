/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBSysPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDBSysPortletPartParam
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.model.res.IPSSysPortlet
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBSysPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBSysPortletPartParam;
import net.ibizsys.model.control.dashboard.PSDBPortletPartImpl;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDBSysPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBSysPortletPart {
    private static final Log log = LogFactory.getLog(PSDBSysPortletPartImpl.class);
    protected IPSSysPortlet iPSSysPortlet = null;
    private IPSDBSysPortletPartParam iPSDBSysPortletPartParam = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBSysPortletPartParam = (IPSDBSysPortletPartParam)iPSControlParam;
            this.setId(this.iPSDBSysPortletPartParam.getPSSysPortletId());
            this.setName(strName);
            this.iPSSysPortlet = iPSControlContainer.getPSAppView().getPSApplication().getPSSystem().getPSSysPortlet(this.iPSDBSysPortletPartParam.getPSSysPortletId());
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected String getPSAjaxControlHandlerId() {
        String strPSAjaxControlHandlerId = super.getPSAjaxControlHandlerId();
        if (StringHelper.isNullOrEmpty((String)strPSAjaxControlHandlerId)) {
            return this.iPSSysPortlet.getPSACHandlerId();
        }
        return strPSAjaxControlHandlerId;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType")
    public String getPortletType() {
        return this.iPSSysPortlet.getPortletType();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        if (StringHelper.isNullOrEmpty((String)super.getTitle())) {
            return this.iPSSysPortlet.getTitle();
        }
        return super.getTitle();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u95e8\u6237\u90e8\u4ef6")
    public IPSSysPortlet getPSSysPortlet() {
        return this.iPSSysPortlet;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6")
    public double getHeight() {
        if (this.iPSDBSysPortletPartParam.getHeight() != null) {
            return this.iPSDBSysPortletPartParam.getHeight();
        }
        return this.getPSSysPortlet().getHeight();
    }

    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08\u6beb\u79d2\uff09")
    public long getTimer() {
        return this.getPSSysPortlet().getReloadTimer();
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.getPSSysPortlet().getPSPortletType();
    }

    @Override
    protected boolean onGetShowTitleBar() {
        return this.iPSSysPortlet.isShowTitleBar();
    }
}

