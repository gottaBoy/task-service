/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.dataview;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.dataview.IPSDEDataView;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSDEDataViewItem
extends IPSModelObject {
    public IPSDEDataView getPSDEDataView();

    public String getDataItemName();

    public String getValueFormat();

    public String[] getFields();

    public IPSCodeList getPSCodeList();

    public String getCLConvertMode();
}

