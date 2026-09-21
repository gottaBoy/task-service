/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.context.ApplicationListener
 *  org.springframework.context.event.ContextRefreshedEvent
 */
package net.ibizsys.paas.appmodel;

import java.util.HashMap;
import net.ibizsys.paas.appmodel.AppModelBaseBase;
import net.ibizsys.paas.appmodel.IAppModeModel;
import net.ibizsys.paas.appmodel.IAppPFHelper;
import net.ibizsys.paas.appmodel.IApplicationRuntime;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public abstract class AppModelBase
extends AppModelBaseBase
implements ApplicationListener<ContextRefreshedEvent>,
IApplicationRuntime {
    private static final Log log = LogFactory.getLog(AppModelBase.class);
    private HashMap<String, IAppModeModel> appModeModelMap = new HashMap();
    private String strApplicationUrl = null;

    public void onApplicationEvent(ContextRefreshedEvent event) {
    }

    protected void prepareAppModes() throws Exception {
    }

    protected void registerAppModeModel(IAppModeModel iAppModeModel) throws Exception {
        this.appModeModelMap.put(iAppModeModel.getMode(), iAppModeModel);
    }

    protected IAppModeModel createAppModeModel(String strMode) throws Exception {
        return null;
    }

    protected IAppModeModel getAppModeModel() {
        if (WebContext.getCurrent() != null) {
            String strAppMode = WebContext.getAppMode(WebContext.getCurrent());
            return this.appModeModelMap.get(strAppMode);
        }
        return null;
    }

    @Override
    public IAppPFHelper getAppPFHelper() {
        IAppModeModel iAppModeModel = this.getAppModeModel();
        if (iAppModeModel != null) {
            return iAppModeModel.getAppPFHelper();
        }
        return super.getAppPFHelper();
    }

    @Override
    public ICtrlRender getCtrlRender(String strCtrlType, String strRender) {
        IAppModeModel iAppModeModel = this.getAppModeModel();
        if (iAppModeModel != null) {
            return iAppModeModel.getCtrlRender(strCtrlType, strRender);
        }
        return super.getCtrlRender(strCtrlType, strRender);
    }

    @Override
    public String getApplicationUrl() {
        if (this.strApplicationUrl == null) {
            String strUrlTag = "APPURL_" + this.getName().toUpperCase();
            this.strApplicationUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
            if (StringHelper.isNullOrEmpty(this.strApplicationUrl) && this.getAppPFHelper() != null) {
                this.strApplicationUrl = this.getAppPFHelper().getAppType() == 2 ? WebConfig.getCurrent().getDefaultMobAppUrl() : WebConfig.getCurrent().getDefaultWebAppUrl();
            }
        }
        return this.strApplicationUrl;
    }

    @Override
    public String getHtmlUrl(String strTag) {
        String strUrlTag = "HTMLURL_" + this.getName().toUpperCase() + "_" + strTag;
        String strHtmlUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
        if (StringHelper.isNullOrEmpty(strHtmlUrl)) {
            strUrlTag = "HTMLURL_" + strTag;
            strHtmlUrl = WebConfig.getCurrent().getAttribute(strUrlTag, "");
        }
        return strHtmlUrl;
    }
}

