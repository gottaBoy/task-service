/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.tree;

import java.util.Iterator;
import net.ibizsys.paas.control.IControl;
import net.ibizsys.paas.control.tree.ITreeNode;

public interface ITree
extends IControl {
    public static final String FetchAction = "fetch";

    public Iterator<ITreeNode> getTreeNodes();
}

