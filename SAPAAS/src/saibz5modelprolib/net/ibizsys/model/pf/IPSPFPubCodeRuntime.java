/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFPubCode;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFPubCode;

public interface IPSPFPubCodeRuntime
extends IPSPFPubCode {
    public void init(IPSModelStorageContext var1, IPSPF var2, IPSPFPubCode var3, PSPFPubCode var4) throws Exception;

    public boolean isDynaViewPubCode();

    public boolean isDynaModelPubCode();
}

