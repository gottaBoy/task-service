/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.tree;

import net.ibizsys.paas.data.IDataItem;

public interface ITreeNodeDataItem
extends IDataItem {
    public boolean isDataAccessAction();

    public String getPrivilegeId();
}

