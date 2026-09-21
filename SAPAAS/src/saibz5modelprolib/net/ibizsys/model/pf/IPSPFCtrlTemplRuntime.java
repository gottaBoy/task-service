/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFStyle;

public interface IPSPFCtrlTemplRuntime
extends IPSPFCtrlTempl {
    public void init(IPSModelStorageContext var1, IPSPF var2, IPSPFStyle var3, PSPFCtrlTempl var4) throws Exception;
}

