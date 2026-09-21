/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import net.ibizsys.paas.ajax.IAjaxHandler;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;

public interface IAjaxCodeListHandler
extends IAjaxHandler {
    public ICodeList getCodeList();

    public AjaxActionResult process(ICodeList var1, IAjaxActionContext var2) throws Exception;
}

