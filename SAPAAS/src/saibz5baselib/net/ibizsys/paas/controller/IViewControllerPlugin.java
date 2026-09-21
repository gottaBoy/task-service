/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.web.IWebContext;

public interface IViewControllerPlugin
extends IPlugin {
    public PluginActionResult doTestUserAccess(IViewController var1, IWebContext var2, boolean var3, Object var4) throws Exception;

    public PluginActionResult doViewCtrlAjaxAction(IViewController var1, HttpServletRequest var2, HttpServletResponse var3, String var4, String var5, ICtrlHandler var6, Object var7) throws Exception;

    public PluginActionResult doGetViewMessages(IViewController var1, IViewMsgGroupModel var2, ArrayList<IViewMessage> var3, Object var4) throws Exception;

    public PluginActionResult doGetViewWizards(IViewController var1, IViewWizardGroupModel var2, String var3, ArrayList<IViewWizard> var4, Object var5) throws Exception;
}

