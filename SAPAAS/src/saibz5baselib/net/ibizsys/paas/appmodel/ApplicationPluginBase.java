/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.appmodel;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;

public abstract class ApplicationPluginBase
extends PluginBase
implements IApplicationPlugin {
    private IApplicationPlugin prevApplicationPlugin = null;
    private HashMap<String, IViewControllerPlugin> viewControllerPluginMap = null;
    private IViewControllerPlugin defaultViewControllerPlugin = null;

    @Override
    public void setPrevPlugin(IPlugin iPlugin) {
        super.setPrevPlugin(iPlugin);
        if (iPlugin instanceof IApplicationPlugin) {
            this.prevApplicationPlugin = (IApplicationPlugin)iPlugin;
        }
    }

    @Override
    public PluginActionResult doGetCtrlRender(IApplicationModel iApplicationModel, String strCtrlType, String strRender, Object objParam) {
        if (this.prevApplicationPlugin != null) {
            return this.prevApplicationPlugin.doGetCtrlRender(iApplicationModel, strCtrlType, strRender, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doFilter(IApplicationModel iApplicationModel, IViewController iViewController, HttpServletRequest request, HttpServletResponse response, Object objParam) throws Exception {
        if (this.prevApplicationPlugin != null) {
            return this.prevApplicationPlugin.doFilter(iApplicationModel, iViewController, request, response, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doFilter(IApplicationModel iApplicationModel, Page page, HttpServletRequest request, HttpServletResponse response, Object objParam) throws Exception {
        if (this.prevApplicationPlugin != null) {
            return this.prevApplicationPlugin.doFilter(iApplicationModel, page, request, response, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doTestUserAccess(IViewController iViewController, IWebContext iWebContext, boolean bSendBack, Object objParam) throws Exception {
        PluginActionResult pluginActionResult;
        IViewControllerPlugin iViewControllerPlugin;
        if (this.viewControllerPluginMap != null && (iViewControllerPlugin = this.viewControllerPluginMap.get(iViewController.getId())) != null && (pluginActionResult = iViewControllerPlugin.doTestUserAccess(iViewController, iWebContext, bSendBack, objParam)) == PluginActionResult.Replace) {
            return pluginActionResult;
        }
        if (this.prevApplicationPlugin != null) {
            return this.prevApplicationPlugin.doTestUserAccess(iViewController, iWebContext, bSendBack, objParam);
        }
        return PluginActionResult.Continue;
    }

    @Override
    public PluginActionResult doViewCtrlAjaxAction(IViewController iViewController, HttpServletRequest request, HttpServletResponse response, String strCtrlId, String strAction, ICtrlHandler iCtrlHandler, Object objParam) throws Exception {
        return null;
    }

    @Override
    public PluginActionResult doGetViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel, ArrayList<IViewMessage> viewMessageList, Object objParam) throws Exception {
        return null;
    }

    @Override
    public PluginActionResult doGetViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery, ArrayList<IViewWizard> viewWizardList, Object objParam) throws Exception {
        return null;
    }

    protected IViewControllerPlugin getViewControllerPlugin(IViewController iViewController) {
        IViewControllerPlugin iViewControllerPlugin;
        if (this.viewControllerPluginMap != null && (iViewControllerPlugin = this.viewControllerPluginMap.get(iViewController.getId())) != null) {
            return iViewControllerPlugin;
        }
        return this.defaultViewControllerPlugin;
    }

    protected void registerViewControllerPlugin(String strViewControllerId, IViewControllerPlugin iViewControllerPlugin) {
        if (StringHelper.isNullOrEmpty(strViewControllerId)) {
            this.defaultViewControllerPlugin = iViewControllerPlugin;
        } else {
            if (this.viewControllerPluginMap == null) {
                this.viewControllerPluginMap = new HashMap();
            }
            this.viewControllerPluginMap.put(strViewControllerId, iViewControllerPlugin);
        }
    }
}

