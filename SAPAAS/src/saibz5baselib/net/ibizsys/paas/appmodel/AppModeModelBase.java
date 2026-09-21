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

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.AppModelBaseBase;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.appmodel.IAppModeModel;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppModeModelBase
extends AppModelBaseBase
implements IAppModeModel {
    private static final Log log = LogFactory.getLog(AppModeModelBase.class);
    private IApplicationModel iApplicationModel = null;
    private String strMode = null;

    @Override
    public void init(IApplicationModel iApplicationModel) throws Exception {
        this.iApplicationModel = iApplicationModel;
        this.onInit();
    }

    @Override
    public IApplicationModel getAppModel() {
        return this.iApplicationModel;
    }

    @Override
    public ISystem getSystem() {
        return this.getAppModel().getSystem();
    }

    @Override
    public String getMode() {
        return this.strMode;
    }

    public void setMode(String strMode) {
        this.strMode = strMode;
    }

    @Override
    public void setId(String strId) {
        super.setId(strId);
    }

    @Override
    public void setName(String strName) {
        super.setName(strName);
    }

    @Override
    public void setPFType(String strPFType) {
        super.setPFType(strPFType);
    }

    @Override
    public boolean doFilter(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.getAppModel().doFilter(iViewController, request, response);
    }

    @Override
    public boolean doFilter(Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.getAppModel().doFilter(page, request, response);
    }

    @Override
    public IWebContext createWebContext(IViewController iViewController, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.getAppModel().createWebContext(iViewController, request, response);
    }

    @Override
    public AjaxActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler) throws Exception {
        return this.getAppModel().doViewCtrlAjaxAction(iViewController, request, response, strCtrlId, strAction, iCtrlHandler);
    }

    @Override
    public AjaxActionResult doFilterViewAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strAction, AjaxActionResult ajaxActionResult) throws Exception {
        return this.getAppModel().doFilterViewAction(iViewController, request, response, strAction, ajaxActionResult);
    }

    @Override
    public void registerAppView(IAppViewModel iAppViewModel) throws Exception {
        this.getAppModel().registerAppView(iAppViewModel);
    }

    @Override
    public IAppViewModel getAppView(String strAppViewId, boolean bTryMode) throws Exception {
        return this.getAppModel().getAppView(strAppViewId, bTryMode);
    }

    @Override
    public IAppDEViewModel getAppViewByDEViewId(String strDEViewId, boolean bTryMode) throws Exception {
        return this.getAppModel().getAppViewByDEViewId(strDEViewId, bTryMode);
    }

    @Override
    public IAppMenuModel getAppMenuModel(String strUserMode) throws Exception {
        return this.getAppModel().getAppMenuModel(strUserMode);
    }

    @Override
    public void registerUserModeMenu(String strUserMode, String strAppMenuModelId) throws Exception {
        this.getAppModel().registerUserModeMenu(strUserMode, strAppMenuModelId);
    }

    @Override
    public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
        return this.getAppModel().getViewMessages(iViewController, iViewMsgGroupModel);
    }

    @Override
    public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
        return this.getAppModel().getViewWizards(iViewController, iViewWizardGroupModel, strQuery);
    }

    @Override
    public boolean testUserViewAccess(IViewController iViewController, IWebContext iWebContext) throws Exception {
        return this.getAppModel().testUserViewAccess(iViewController, iWebContext);
    }

    @Override
    public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin) throws Exception {
        this.getAppModel().setApplicationPlugin(iApplicationPlugin);
    }

    @Override
    public void setApplicationPlugin(IApplicationPlugin iApplicationPlugin, boolean bIgnoreOrigin) throws Exception {
        this.getAppModel().setApplicationPlugin(iApplicationPlugin, bIgnoreOrigin);
    }

    @Override
    public IApplicationPlugin getApplicationPlugin() {
        return this.getAppModel().getApplicationPlugin();
    }

    @Override
    public String getAppFolder() {
        return this.getAppModel().getAppFolder();
    }

    @Override
    public void fillAppDataAjaxActionResult(IViewController iViewController, AppDataAjaxActionResult appDataAjaxActionResult) throws Exception {
        this.getAppModel().fillAppDataAjaxActionResult(iViewController, appDataAjaxActionResult);
    }

    @Override
    public void logException(Object logger, Throwable throwable, String strMessage, Object objUserData) {
        this.getAppModel().logException(logger, throwable, strMessage, objUserData);
    }
}

