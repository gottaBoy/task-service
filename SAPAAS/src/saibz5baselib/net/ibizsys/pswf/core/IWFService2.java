/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.core.WFActionResult;

public interface IWFService2
extends IWFService {
    public WFActionResult suspend(WFActionParam var1) throws Exception;

    public WFActionResult resume(WFActionParam var1) throws Exception;
}

