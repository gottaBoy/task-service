/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.pswf.core.WFActionResult;

public interface IWFServiceWork {
    public WFActionResult execute(ITransaction var1) throws Exception;
}

