/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDETreeNodeRV
extends IPSModelObject {
    public String getPSDEViewBaseId();

    public IPSDETreeNode getPSDETreeNode();

    public String getViewParam();
}

