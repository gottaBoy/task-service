/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSSysPFPluginTempl;
import net.ibizsys.model.pf.IPSPFPluginTemplRuntime;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.res.IPSSysPFPlugin;
import net.ibizsys.model.res.IPSSysPFPluginTempl;

public interface IPSSysPFPluginTemplRuntime
extends IPSSysPFPluginTempl,
IPSPFPluginTemplRuntime {
    public void init(IPSModelStorageContext var1, IPSSysPFPlugin var2, PSSysPFPluginTempl var3) throws Exception;

    public PSSysPFPluginTempl getPSSysPFPluginTemplData(IPSPFStyle var1) throws Exception;
}

