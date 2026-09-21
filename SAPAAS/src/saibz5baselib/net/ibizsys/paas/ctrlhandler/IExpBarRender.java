/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlmodel.IExpBarModel;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface IExpBarRender
extends ICtrlRender {
    public void fillFetchResult(IExpBarModel var1, MDAjaxActionResult var2) throws Exception;

    public void fillFetchResult(ArrayList<ITreeNode> var1, MDAjaxActionResult var2) throws Exception;
}

