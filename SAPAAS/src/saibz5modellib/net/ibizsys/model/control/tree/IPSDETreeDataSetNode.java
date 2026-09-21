/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETreeNode;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.paas.ctrlmodel.ITreeDEDataSetNodeModel;

public interface IPSDETreeDataSetNode
extends IPSDETreeNode,
ITreeDEDataSetNodeModel {
    public IPSDEDataSet getPSDEDataSet();

    public IPSDEDataSet getFilterPSDEDataSet();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEOPPriv getRemovePSDEOPPriv();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getUpdatePSDEOPPriv();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getIdPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSDEField getIconPSDEField();

    public IPSDEField getSortPSDEField();

    public IPSDEField getChildCntPSDEField();

    public IPSDEField getLeafFlagPSDEField();
}

