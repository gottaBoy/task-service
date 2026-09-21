/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;

public interface IPSDEGridFieldColumn
extends IPSDEGridColumn {
    public IPSDEField getPSDEField();

    public IPSCodeList getPSCodeList();

    public String getPSCodeListId();

    public String getValueFormat();

    public String[] getFields();

    public boolean isEnableItemPriv();

    public String getItemPrivId();

    public String getGroupItem();

    public IPSDEUIAction getPSDEUIAction();

    public String getCLConvertMode();

    public boolean isGenerateDataItems();
}

