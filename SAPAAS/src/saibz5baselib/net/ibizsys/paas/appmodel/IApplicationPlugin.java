/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package net.ibizsys.paas.appmodel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.IViewControllerPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.web.Page;

public interface IApplicationPlugin
extends IPlugin,
IViewControllerPlugin {
    public PluginActionResult doGetCtrlRender(IApplicationModel var1, String var2, String var3, Object var4);

    public PluginActionResult doFilter(IApplicationModel var1, IViewController var2, HttpServletRequest var3, HttpServletResponse var4, Object var5) throws Exception;

    public PluginActionResult doFilter(IApplicationModel var1, Page var2, HttpServletRequest var3, HttpServletResponse var4, Object var5) throws Exception;
}

