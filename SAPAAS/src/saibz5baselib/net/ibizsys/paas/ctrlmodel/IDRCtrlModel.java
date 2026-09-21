/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.Iterator;
import net.ibizsys.paas.control.drctrl.IDRCtrlItem;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IDRCtrlModel
extends ICtrlModel {
    public void fillFetchResult(MDAjaxActionResult var1) throws Exception;

    public Iterator<IDRCtrlItem> getDRCtrlItems();

    public boolean testDRCtrlItemEnabled(IDRCtrlItem var1) throws Exception;
}

