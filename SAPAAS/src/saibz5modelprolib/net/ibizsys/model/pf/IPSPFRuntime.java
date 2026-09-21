/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.entity.PSPF;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pub.IPSPFCtrlCodePublisher;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;

public interface IPSPFRuntime
extends IPSPF,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, PSPF var2) throws Exception;

    public IPSPFStyle createPSPFStyle() throws Exception;

    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception;

    public IPSPFCtrlCodePublisher createPSPFCtrlCodePublisher() throws Exception;
}

