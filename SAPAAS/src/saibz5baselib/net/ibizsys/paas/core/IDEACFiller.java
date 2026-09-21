/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDEACFiller {
    public void init(IGlobalContext var1, IDEACMode var2) throws Exception;

    public void fillAjaxFetchActionResult(MDAjaxActionResult var1, IDataTable var2, IWebContext var3) throws Exception;

    public void close();
}

