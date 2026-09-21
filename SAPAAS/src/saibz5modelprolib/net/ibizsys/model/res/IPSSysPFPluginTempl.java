/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.res;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPluginTempl;
import net.ibizsys.model.res.IPSSysPFPlugin;

public interface IPSSysPFPluginTempl
extends IPSModelObject,
IPSPFPluginTempl {
    public IPSSysPFPlugin getPSSysPFPlugin();

    @Override
    public IPSPF getPSPF();

    @Override
    public String getCode(String var1);
}

