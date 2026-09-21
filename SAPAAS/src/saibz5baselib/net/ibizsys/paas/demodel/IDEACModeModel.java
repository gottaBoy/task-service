/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDEACModeModel
extends IDEACMode,
IModelBase3 {
    public void fillFetchResult(MDAjaxActionResult var1, IDataTable var2, IWebContext var3) throws Exception;
}

