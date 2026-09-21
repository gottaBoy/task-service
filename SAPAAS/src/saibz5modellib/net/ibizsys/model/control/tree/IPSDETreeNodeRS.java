/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.paas.ctrlmodel.ITreeNodeRSModel;

public interface IPSDETreeNodeRS
extends IPSModelObject,
ITreeNodeRSModel {
    public IPSDETree getPSDETree();

    public String getPPSTreeNodeId();

    public String getCPSTreeNodeId();

    public int getOrderValue();

    public IPSDEAction getPSDEAction();

    public IPSDETreeNode getParentPSDETreeNode() throws Exception;

    public IPSDETreeNode getChildPSDETreeNode() throws Exception;
}

