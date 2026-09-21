/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlItemHandler;
import net.ibizsys.paas.ctrlmodel.IGridModel;

public interface IGridEditItemUpdateHandler
extends ICtrlItemHandler {
    public static final String ACTION_UPDATEGRIDEDITITEM = "updategridedititem";

    public void init(IGridModel var1, ICtrlHandler var2) throws Exception;
}

