/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.tree.ITreeGridColumn
 */
package net.ibizsys.model.control.tree;

import net.ibizsys.model.control.tree.IPSDETree;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.paas.control.tree.ITreeGridColumn;

public interface IPSDETreeColumn
extends IPSModelObject,
ITreeGridColumn {
    public static final String ALIGN_LEFT = "LEFT";
    public static final String ALIGN_CENTER = "CENTER";
    public static final String ALIGN_RIGHT = "RIGHT";

    public IPSDETree getPSDETree();

    public String getCodeName();

    public String getWidthUnit();

    public int getWidth();

    public String getColumnType();

    public boolean isEnableSort();

    public String getWidthString();

    public String getAlign();

    public boolean isHideDefault();

    public boolean isEnableRowEdit();

    public String getCapLanResTag();

    public String getColumnStyle();

    public String getUserTag();

    public String getUserTag2();

    public IPSDETreeColumn getParentPSTreeColumn();
}

