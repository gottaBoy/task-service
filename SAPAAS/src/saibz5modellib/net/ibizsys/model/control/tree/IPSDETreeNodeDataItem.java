/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITreeNodeDataItem
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETreeColumn;
import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.data.IPSDataItem;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.paas.control.tree.ITreeNodeDataItem;

public interface IPSDETreeNodeDataItem
extends IPSDataItem,
ITreeNodeDataItem {
    public IPSDETreeNode getPSDETreeNode();

    public IPSDETreeColumn getPSDETreeColumn();

    public IPSDEField getPSDEField();

    public String getCLConvertMode();

    public String getPSCodeListId();

    public boolean isEnableItemPriv();

    public String getItemPrivId();
}

