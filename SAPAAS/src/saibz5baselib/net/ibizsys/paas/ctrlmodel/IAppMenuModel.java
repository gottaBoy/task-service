/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IAppMenuModel
extends ICtrlModel,
IAppMenu {
    public void fillFetchResult(MDAjaxActionResult var1) throws Exception;

    public AppMenuRootItem getRootItem();
}

