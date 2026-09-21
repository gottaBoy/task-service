/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.dataview.IDataViewDataItem
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataView;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.control.dataview.IDataViewDataItem;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEDataViewDataItem
extends IPSDataItem,
IDataViewDataItem {
    @Override
    public int getDataType();

    public IPSCodeList getFrontPSCodeList();

    public IPSDEDataView getPSDEDataView();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public boolean isCustomCode();

    public String getScriptCode();
}

