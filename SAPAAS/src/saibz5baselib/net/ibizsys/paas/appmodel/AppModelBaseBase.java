/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.appmodel;

import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.AppDEViewModel;
import net.ibizsys.paas.appmodel.AppViewModel;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.appmodel.IAppPFHelper;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppModelBaseBase
extends ModelBase3Impl
implements IApplicationModel {
    private static final Log log = LogFactory.getLog(AppModelBaseBase.class);
    private HashMap<String, ICtrlRender> ctrlRenderMap = new HashMap();
    protected String strPFType = null;
    private HashMap<String, String> utilPageUrlMap = new HashMap();
    private HashMap<String, IAppViewModel> appViewMap = new HashMap();
    private HashMap<String, IAppDEViewModel> appDEViewMap = new HashMap();
    private HashMap<String, String> userModeMenuMap = new HashMap();
    private IAppPFHelper iAppModeHelper = null;
    private IApplicationPlugin iApplicationPlugin = null;
    private int nAppType = 0;
    private String strAppFolder = null;
    private boolean bOutputFormItemUpdatePrivTag = false;

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public boolean doFilter(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return false;
    }

    @Override
    public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return false;
    }

    @Override
    public String getPFType() {
        return this.strPFType;
    }

    protected void setPFType(String strPFType) {
        this.strPFType = strPFType;
        this.registerUtilPageUrl("DOWNLOADTMPFILE", "/ibizutil/exportfile3.jsp?");
        this.registerUtilPageUrl("LOGIN", "/ibizutil/login.jsp?");
        this.registerUtilPageUrl("LOGOUT", "/ibizutil/logout.jsp?");
        this.registerUtilPageUrl("INTERNALERROR", "/ibizutil/showerror.jsp?");
        this.registerUtilPageUrl("ACCESSDENY", "/ibizutil/accessdeny.jsp?");
        this.registerUtilPageUrl("PASSWORDEXPIRED", "/ibizutil/passwordexpired.jsp?");
        if (!StringHelper.isNullOrEmpty(this.strPFType)) {
            try {
                this.registerCtrlRender("CHART", "ECHARTS3", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            if (this.strPFType.indexOf("JQUERY") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.jquery.JQAppPFHelper");
                    this.iAppModeHelper.init(this);
                    this.registerCtrlRender("DRBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.DRBarJSTreeRender"));
                    this.registerCtrlRender("EXPBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender"));
                    this.registerCtrlRender("TREEEXPBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender"));
                    this.registerCtrlRender("WFEXPBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.WFExpBarJSTreeRender"));
                    this.registerCtrlRender("TREEVIEW", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.TreeJSTreeRender"));
                    this.registerCtrlRender("GRID", "BOOTSTRAPTABLE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridBootstrapTableRender"));
                    this.registerCtrlRender("GRID", "JQUERYDATATABLES", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridJQueryDatatableRender"));
                    this.registerCtrlRender("GRID", "PQGRID", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.GridPQGridRender"));
                    this.registerCtrlRender("CHART", "ECHARTS3", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("EXTJS5") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.extjs.ExtJSAppPFHelper");
                    this.iAppModeHelper.init(this);
                    this.registerCtrlRender("CHART", "ECHARTS3", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.extjs.render.ChartEcharts3Render"));
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("ANGULARJS") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.angularjs.NGAppPFHelper");
                    this.iAppModeHelper.init(this);
                    this.registerCtrlRender("CHART", "ECHARTS3", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
                    this.registerCtrlRender("TREEVIEW", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.TreeJSTreeRender2"));
                    this.registerCtrlRender("EXPBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender2"));
                    this.registerCtrlRender("TREEEXPBAR", "JSTREE", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ExpBarJSTreeRender2"));
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("ANGULAR") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.angular.AngularAppPFHelper");
                    this.iAppModeHelper.init(this);
                    this.registerCtrlRender("CHART", "ECHARTS3", (ICtrlRender)ObjectHelper.create("net.ibizsys.paas.web.jquery.render.ChartEcharts3Render"));
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("IONIC4_R6") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.ionic.Ionic4R6AppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("IONIC") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.ionic.IonicAppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("VUEMOB") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueMobAppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("VUE_R3") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.ssdyna.appmodel.Vue3AppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("VUE") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueAppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("REACTMOB") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.vue.VueMobAppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
            if (this.strPFType.indexOf("REACT") == 0) {
                try {
                    this.iAppModeHelper = (IAppPFHelper)ObjectHelper.create("net.ibizsys.paas.appmodel.react.ReactAppPFHelper");
                    this.iAppModeHelper.init(this);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
                return;
            }
        }
    }

    @Override
    public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringHelper.isNullOrEmpty(WebConfig.getCurrent().getWebContextObj())) {
            WebContext iWebContext = new WebContext();
            iWebContext.init(request, response, request.getSession().getServletContext());
            this.doRemoteLogin(iWebContext);
            return iWebContext;
        }
        IWebContext iWebContext = (IWebContext)ObjectHelper.create(WebConfig.getCurrent().getWebContextObj());
        iWebContext.init(request, response, request.getSession().getServletContext());
        this.doRemoteLogin(iWebContext);
        return iWebContext;
    }

    protected void doRemoteLogin(IWebContext iWebContext) throws Exception {
        if (!StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) {
            return;
        }
        String strLoginKey = WebContext.getLoginKey(iWebContext);
        if (StringHelper.isNullOrEmpty(strLoginKey)) {
            return;
        }
        LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
        if (loginLog == null) {
            return;
        }
        iWebContext.remoteLogin(loginLog);
    }

    @Override
    public AjaxActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler) throws Exception {
        return iCtrlHandler.processAction(strAction, iViewController.getWebContext());
    }

    @Override
    public AjaxActionResult doFilterViewAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strAction, AjaxActionResult ajaxActionResult) throws Exception {
        return ajaxActionResult;
    }

    protected void registerCtrlRender(String strCtrlType, String strRender, ICtrlRender iCtrlRender) throws Exception {
        String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
        this.ctrlRenderMap.put(strKey, iCtrlRender);
    }

    protected void registerUtilPageUrl(String strUtilPage, String strPageUrl) {
        this.utilPageUrlMap.put(strUtilPage, strPageUrl);
    }

    protected void unRegisterCtrlRender(String strCtrlType, String strRender, ICtrlRender iCtrlRender) throws Exception {
        String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
        this.ctrlRenderMap.remove(strKey);
    }

    @Override
    public ICtrlRender getCtrlRender(String strCtrlType, String strRender) {
        String strKey = StringHelper.format("%1$s|%2$s", strCtrlType, strRender);
        return this.ctrlRenderMap.get(strKey);
    }

    @Override
    public String getUtilPageUrl(String strUtilType) throws Exception {
        return this.utilPageUrlMap.get(strUtilType);
    }

    @Override
    public void installRTDatas() throws Exception {
        this.onInstallRTDatas();
    }

    protected void onInstallRTDatas() throws Exception {
    }

    protected void registerAppView(String strAppViewId, String strAppViewName, String strDEViewId, String strTitle, String strModuleName, String strOpenMode, int nWidth, int nHeight) throws Exception {
        if (StringHelper.isNullOrEmpty(strDEViewId)) {
            AppViewModel appViewModel = new AppViewModel();
            appViewModel.setId(strAppViewId);
            appViewModel.setName(strAppViewName);
            appViewModel.setTitle(strTitle);
            appViewModel.setModuleName(strModuleName);
            appViewModel.setOpenMode(strOpenMode);
            if (nWidth > 0) {
                appViewModel.setWidth(nWidth);
            }
            if (nHeight > 0) {
                appViewModel.setHeight(nHeight);
            }
            this.registerAppView(appViewModel);
        } else {
            AppDEViewModel appViewModel = new AppDEViewModel();
            appViewModel.setId(strAppViewId);
            appViewModel.setName(strAppViewName);
            appViewModel.setTitle(strTitle);
            appViewModel.setModuleName(strModuleName);
            appViewModel.setDEViewId(strDEViewId);
            appViewModel.setOpenMode(strOpenMode);
            if (nWidth > 0) {
                appViewModel.setWidth(nWidth);
            }
            if (nHeight > 0) {
                appViewModel.setHeight(nHeight);
            }
            this.registerAppView(appViewModel);
        }
    }

    @Override
    public void registerAppView(IAppViewModel iAppViewModel) throws Exception {
        IAppDEViewModel iAppDEViewModel;
        this.appViewMap.put(iAppViewModel.getId(), iAppViewModel);
        if (iAppViewModel instanceof IAppDEViewModel && !StringHelper.isNullOrEmpty((iAppDEViewModel = (IAppDEViewModel)iAppViewModel).getDEViewId())) {
            this.appDEViewMap.put(iAppDEViewModel.getDEViewId(), iAppDEViewModel);
        }
    }

    @Override
    public IAppViewModel getAppView(String strAppViewId, boolean bTryMode) throws Exception {
        IAppViewModel iAppViewModel = this.appViewMap.get(strAppViewId);
        if (iAppViewModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u89c6\u56fe[%1$s]", strAppViewId));
        }
        return iAppViewModel;
    }

    @Override
    public IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception {
        IAppDEViewModel iAppDEViewModel = this.appDEViewMap.get(strDEViewId);
        if (iAppDEViewModel == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u89c6\u56fe[%1$s]", strDEViewId));
        }
        return iAppDEViewModel;
    }

    @Override
    public IAppPFHelper getAppPFHelper() {
        return this.iAppModeHelper;
    }

    @Override
    public IAppMenuModel getAppMenuModel(String strUserMode) throws Exception {
        String strAppMenuModelId;
        if (strUserMode == null) {
            strUserMode = "";
        }
        if (StringHelper.isNullOrEmpty(strAppMenuModelId = this.userModeMenuMap.get(strUserMode)) && StringHelper.isNullOrEmpty(strAppMenuModelId = this.userModeMenuMap.get(""))) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7528\u6237\u6a21\u5f0f\u5e94\u7528\u83dc\u5355\u6a21\u578b"));
        }
        return AppMenuModelGlobal.getAppMenuModel(strAppMenuModelId);
    }

    @Override
    public void registerUserModeMenu(String strUserMode, String strAppMenuModelId) throws Exception {
        this.userModeMenuMap.put(strUserMode, strAppMenuModelId);
    }

    protected void prepareAppViews() throws Exception {
    }

    @Override
    public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        return ((ISystemModel)this.getSystem()).getViewMessages(iViewController, iViewMsgGroupModel);
    }

    @Override
    public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
        return ((ISystemModel)this.getSystem()).getViewWizards(iViewController, iViewWizardGroupModel, strQuery);
    }

    @Override
    public boolean testUserViewAccess(IViewController iViewController, IWebContext iWebContext) throws Exception {
        return iViewController.testUserAccess(iWebContext);
    }

    @Override
    public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin) throws Exception {
        this.setApplicationPlugin(iApplicationPlugin, false);
    }

    @Override
    public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin, boolean bIgnoreOrigin) throws Exception {
        IApplicationPlugin lastPlugin = null;
        if (!bIgnoreOrigin && (lastPlugin = this.iApplicationPlugin) == null && this.getSystemModel().getSystemPlugin() != null) {
            lastPlugin = this.getSystemModel().getSystemPlugin().getApplicationPlugin();
        }
        iApplicationPlugin.setPrevPlugin(lastPlugin);
        this.iApplicationPlugin = iApplicationPlugin;
    }

    @Override
    public IApplicationPlugin getApplicationPlugin() {
        return this.iApplicationPlugin;
    }

    @Override
    public ISystemModel getSystemModel() {
        return (ISystemModel)this.getSystem();
    }

    @Override
    public int getAppType() {
        if (this.nAppType != 0) {
            return this.nAppType;
        }
        return this.getAppPFHelper().getAppType();
    }

    @Override
    public String getAppFolder() {
        if (StringHelper.isNullOrEmpty(this.strAppFolder)) {
            return this.getName();
        }
        return this.strAppFolder;
    }

    protected void setAppFolder(String strAppFolder) {
        this.strAppFolder = strAppFolder;
    }

    @Override
    public void fillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
        this.onFillAppDataAjaxActionResult(iViewController, appDataAjaxActionResult);
    }

    protected void onFillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
    }

    @Override
    public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
        this.getSystemModel().logException(logger, throwable, strMessage, objUserData);
    }

    @Override
    public boolean isOutputFormItemUpdatePrivTag() {
        return this.bOutputFormItemUpdatePrivTag;
    }

    protected void setOutputFormItemUpdatePrivTag(boolean bOutputFormItemUpdatePrivTag) {
        this.bOutputFormItemUpdatePrivTag = bOutputFormItemUpdatePrivTag;
    }
}

