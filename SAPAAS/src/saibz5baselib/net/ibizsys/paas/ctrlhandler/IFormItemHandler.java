/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlmodel.IFormModel;

public interface IFormItemHandler
extends ICtrlItemHandler {
    public static final String ACTION_ITEMFETCH = "itemfetch";

    public void init(IFormModel var1, ICtrlHandler var2) throws Exception;
}

