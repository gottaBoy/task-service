/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.expbar.ExpBarRootItem;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IExpBarModel
extends ICtrlModel {
    public static final String CTRLPARAM_SECTIONNAME = "SECTION.NAME";

    public void fillFetchResult(MDAjaxActionResult var1) throws Exception;

    public ExpBarRootItem getRootItem();
}

