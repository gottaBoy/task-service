/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IPlugin;

public abstract class PluginBase
implements IPlugin {
    private String strPluginParams = null;
    private IPlugin iPlugin = null;

    @Override
    public void init(String strPluginParams) throws Exception {
        this.strPluginParams = strPluginParams;
        this.onInit();
    }

    protected void onInit() throws Exception {
    }

    protected String getPluginParams() {
        return this.strPluginParams;
    }

    @Override
    public void setPrevPlugin(IPlugin iPlugin) {
        this.iPlugin = iPlugin;
    }

    protected IPlugin getPrevPlugin() {
        return this.iPlugin;
    }
}

