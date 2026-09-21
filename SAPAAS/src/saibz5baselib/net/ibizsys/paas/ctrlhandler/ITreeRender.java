/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.ITreeModel;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;

public interface ITreeRender
extends IMDCtrlRender {
    public String getNodeId(IWebContext var1) throws Exception;

    public void fillFetchResult(ITreeModel var1, MDAjaxActionResult var2, ArrayList<ITreeNode> var3) throws Exception;
}

