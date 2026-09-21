/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.sysmodel.SystemPluginBase
 */
package net.ibizsys.pscoreux.srv.plugin;

import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.sysmodel.SystemPluginBase;
import net.ibizsys.pscoreux.srv.plugin.PSAppMenuServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSDEDataQueryServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSDEFieldServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSDERServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSDEUIActionServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSDataEntityServicePlugin;
import net.ibizsys.pscoreux.srv.plugin.PSWFDEServicePlugin;

public class PSCoreSysModelPlugin
extends SystemPluginBase {
    protected void onInit() throws Exception {
        this.registerServicePlugin("PSDATAENTITY", (IServicePlugin)new PSDataEntityServicePlugin());
        this.registerServicePlugin("PSDEDATAQUERY", (IServicePlugin)new PSDEDataQueryServicePlugin());
        this.registerServicePlugin("PSDER", (IServicePlugin)new PSDERServicePlugin());
        this.registerServicePlugin("PSWFDE", (IServicePlugin)new PSWFDEServicePlugin());
        this.registerServicePlugin("PSDEUIACTION", (IServicePlugin)new PSDEUIActionServicePlugin());
        this.registerServicePlugin("PSAPPMENU", (IServicePlugin)new PSAppMenuServicePlugin());
        this.registerServicePlugin("PSDEFIELD", (IServicePlugin)new PSDEFieldServicePlugin());
        super.onInit();
    }
}

