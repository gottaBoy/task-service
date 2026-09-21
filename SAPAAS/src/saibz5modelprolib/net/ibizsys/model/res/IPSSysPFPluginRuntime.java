/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.entity.PSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSSysPFPluginRuntime
extends IPSSysPFPlugin {
    public void init(IPSModelStorageContext var1, IPSSystem var2, PSSysPFPlugin var3) throws Exception;
}

