/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.appmodel.IApplicationPlugin;
import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginBase;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.sysmodel.ISystemApplicationPlugin;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemPlugin;
import net.ibizsys.paas.sysmodel.ISystemServicePlugin;
import net.ibizsys.paas.sysmodel.ISystemViewMsgGroupPlugin;
import net.ibizsys.paas.sysmodel.SystemServicePlugin;
import net.ibizsys.paas.sysmodel.SystemViewMsgGroupPlugin;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;

public class SystemPluginBase
extends PluginBase
implements ISystemPlugin {
    private ISystemModel iSystemModel = null;
    private ISystemServicePlugin iSystemServicePlugin = null;
    private ISystemApplicationPlugin iSystemApplicationPlugin = null;
    private ISystemViewMsgGroupPlugin iSystemViewMsgGroupPlugin = null;
    private ISystemPlugin prevSystemPlugin = null;

    @Override
    public void init(ISystemModel iSystemModel, String strPluginParams) throws Exception {
        this.iSystemModel = iSystemModel;
        this.init(strPluginParams);
    }

    protected ISystemModel getSystemModel() {
        return this.iSystemModel;
    }

    @Override
    public IServicePlugin getServicePlugin() {
        if (this.iSystemServicePlugin != null) {
            return this.iSystemServicePlugin;
        }
        if (this.prevSystemPlugin != null) {
            return this.prevSystemPlugin.getServicePlugin();
        }
        return null;
    }

    protected void registerServicePlugin(String strDEName, IServicePlugin iServicePlugin) throws Exception {
        if (this.iSystemServicePlugin == null) {
            this.iSystemServicePlugin = this.createSystemServicePlugin();
            this.iSystemServicePlugin.setPrevPlugin(this.getPrevPlugin());
        }
        this.iSystemServicePlugin.registerServicePlugin(strDEName, iServicePlugin);
    }

    protected ISystemServicePlugin createSystemServicePlugin() throws Exception {
        return new SystemServicePlugin();
    }

    @Override
    public IViewMsgGroupPlugin getViewMsgGroupPlugin() {
        if (this.iSystemViewMsgGroupPlugin != null) {
            return this.iSystemViewMsgGroupPlugin;
        }
        if (this.prevSystemPlugin != null) {
            return this.prevSystemPlugin.getViewMsgGroupPlugin();
        }
        return null;
    }

    protected void registerViewMsgGroupPlugin(String strUniqueTag, IViewMsgGroupPlugin iViewMsgGroupPlugin) throws Exception {
        if (this.iSystemViewMsgGroupPlugin == null) {
            this.iSystemViewMsgGroupPlugin = this.createSystemViewMsgGroupPlugin();
            this.iSystemViewMsgGroupPlugin.setPrevPlugin(this.getPrevPlugin());
        }
        this.iSystemViewMsgGroupPlugin.registerViewMsgGroupPlugin(strUniqueTag, iViewMsgGroupPlugin);
    }

    protected ISystemViewMsgGroupPlugin createSystemViewMsgGroupPlugin() throws Exception {
        return new SystemViewMsgGroupPlugin();
    }

    @Override
    public void setPrevPlugin(IPlugin iPlugin) {
        super.setPrevPlugin(iPlugin);
        if (iPlugin instanceof ISystemPlugin) {
            this.prevSystemPlugin = (ISystemPlugin)iPlugin;
        }
    }

    @Override
    public IApplicationPlugin getApplicationPlugin() {
        if (this.iSystemApplicationPlugin != null) {
            return this.iSystemApplicationPlugin;
        }
        if (this.prevSystemPlugin != null) {
            return this.prevSystemPlugin.getApplicationPlugin();
        }
        return null;
    }
}

