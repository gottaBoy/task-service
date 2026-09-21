/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.pf.IPSPF;

public interface IPSPFPluginTempl
extends IPSModelObject {
    public String getCode(String var1);

    public IPSPF getPSPF();

    public String getPSPFPubCodeId();
}

