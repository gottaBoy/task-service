/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;

public interface IMDCtrlRender
extends ICtrlRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext var1) throws Exception;

    public String getFetchQuickSearch();
}

