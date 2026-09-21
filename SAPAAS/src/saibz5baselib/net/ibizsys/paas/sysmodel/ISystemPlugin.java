/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;

public interface ISystemPlugin
extends IPlugin {
    public void init(ISystemModel var1, String var2) throws Exception;

    public IServicePlugin getServicePlugin();

    public IApplicationPlugin getApplicationPlugin();

    public IViewMsgGroupPlugin getViewMsgGroupPlugin();
}

