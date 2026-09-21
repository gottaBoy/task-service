/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.core.IModelBase;

public interface ITreeNodeRSModel
extends IModelBase {
    public static final int SEARCHMODE_YES = 1;
    public static final int SEARCHMODE_NO = 2;
    public static final int SEARCHMODE_ALL = 3;

    public String getParentTreeNodeId();

    public String getChildTreeNodeId();

    public String getDEActionName();

    public int getSearchMode();
}

