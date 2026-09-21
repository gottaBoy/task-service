/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPFCtrlTemplDetail;
import net.ibizsys.model.pf.IPSPFCtrlTempl;
import net.ibizsys.model.pf.IPSPFCtrlTemplDetail;

public interface IPSPFCtrlTemplDetailRuntime
extends IPSPFCtrlTemplDetail {
    public void init(IPSModelStorageContext var1, IPSPFCtrlTempl var2, PSPFCtrlTemplDetail var3) throws Exception;
}

