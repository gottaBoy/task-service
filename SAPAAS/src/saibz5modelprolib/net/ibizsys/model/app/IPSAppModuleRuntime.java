/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSAppModule
 *  net.ibizsys.model.app.IPSApplication
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.entity.PSAppModule;

public interface IPSAppModuleRuntime
extends IPSAppModule {
    public void init(IPSModelStorageContext var1, IPSApplication var2, PSAppModule var3) throws Exception;
}

