/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.appmodel;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IAppDEViewModel;
import net.ibizsys.paas.appmodel.IAppPFHelper;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.AppDataAjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;

public interface IApplicationModel
extends IApplication,
IModelBase3 {
    public static final String UTILPAGE_DOWNLOADTMPFILE = "DOWNLOADTMPFILE";
    public static final String UTILPAGE_LOGIN = "LOGIN";
    public static final String UTILPAGE_LOGOUT = "LOGOUT";
    public static final String UTILPAGE_ACCESSDENY = "ACCESSDENY";
    public static final String UTILPAGE_INTERNALERROR = "INTERNALERROR";
    public static final String UTILPAGE_PASSWORDEXPIRED = "PASSWORDEXPIRED";

    public ISystemModel getSystemModel();

    public ICtrlRender getCtrlRender(String var1, String var2);

    public IWebContext createWebContext(IViewController var1, HttpServletRequest var2, HttpServletResponse var3) throws Exception;

    public boolean doFilter(IViewController var1, HttpServletRequest var2, HttpServletResponse var3) throws Exception;

    public boolean doFilter(Page var1, HttpServletRequest var2, HttpServletResponse var3) throws Exception;

    public AjaxActionResult doViewCtrlAjaxAction(IViewController var1, HttpServletRequest var2, HttpServletResponse var3, String var4, String var5, ICtrlHandler var6) throws Exception;

    public AjaxActionResult doFilterViewAction(IViewController var1, HttpServletRequest var2, HttpServletResponse var3, String var4, AjaxActionResult var5) throws Exception;

    public String getUtilPageUrl(String var1) throws Exception;

    public void installRTDatas() throws Exception;

    public void registerAppView(IAppViewModel var1) throws Exception;

    public IAppViewModel getAppView(String var1, boolean var2) throws Exception;

    public IAppDEViewModel getAppViewByDEViewId(String var1, boolean var2) throws Exception;

    public IAppPFHelper getAppPFHelper();

    public IAppMenuModel getAppMenuModel(String var1) throws Exception;

    public void registerUserModeMenu(String var1, String var2) throws Exception;

    public Iterator<IViewMessage> getViewMessages(IViewController var1, IViewMsgGroupModel var2) throws Exception;

    public Iterator<IViewWizard> getViewWizards(IViewController var1, IViewWizardGroupModel var2, String var3) throws Exception;

    public boolean testUserViewAccess(IViewController var1, IWebContext var2) throws Exception;

    public void setApplicationPlugin(IApplicationPlugin var1) throws Exception;

    public void setApplicationPlugin(IApplicationPlugin var1, boolean var2) throws Exception;

    public IApplicationPlugin getApplicationPlugin();

    public int getAppType();

    public String getAppFolder();

    public void fillAppDataAjaxActionResult(IViewController var1, AppDataAjaxActionResult var2) throws Exception;

    public void logException(Object var1, Throwable var2, String var3, Object var4);

    public boolean isOutputFormItemUpdatePrivTag();
}

