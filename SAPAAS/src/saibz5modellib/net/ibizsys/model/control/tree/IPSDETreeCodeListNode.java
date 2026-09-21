/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.paas.ctrlmodel.ITreeCodeListNodeModel;

public interface IPSDETreeCodeListNode
extends IPSDETreeNode,
ITreeCodeListNodeModel {
    public IPSCodeList getPSCodeList();
}

