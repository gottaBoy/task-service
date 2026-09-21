/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFStyle;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;

public interface IPSPFStyleRuntime
extends IPSPFStyle {
    public void init(IPSModelStorageContext var1, IPSPF var2, PSPFStyle var3) throws Exception;
}

