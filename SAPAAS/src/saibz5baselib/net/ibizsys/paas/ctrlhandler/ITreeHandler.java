/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import net.ibizsys.paas.control.tree.ITreeNode;
import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext;

public interface ITreeHandler
extends IMDCtrlHandler {
    public static final String ACTION_FETCHCAT = "fetchcat";
    public static final String ACTION_FETCHCOUNTER = "fetchcounter";

    public ArrayList<ITreeNode> getAllTreeNodes(ITreeNodeFetchContext var1) throws Exception;
}

