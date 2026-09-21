/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.ctrlmodel.ITreeNodeModel;

public interface ITreeDEDataSetNodeModel
extends ITreeNodeModel {
    @Override
    public String getDEName();

    public String getDEDataSetName();

    public String getFilterDEDataSetName();

    public String getIdField();

    public String getTextField();

    public String getIconField();

    public String getSortField();

    public String getSortDir();

    public boolean isDistinctMode();

    public String getChildCntField();

    public String getRemoveDEActionName();

    public String getRemoveDataAccessAction();

    public String getActiveDataDELogicId();

    public String getDataTypeField();

    public String getLeafFlagField();

    public int getMaxSize();
}

