/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.grid.IGridDataItem
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import net.ibizsys.paas.control.grid.IGridDataItem;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u683c\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEGridDataItem
extends IPSDataItem,
IGridDataItem {
    public IPSDEGrid getPSDEGrid();

    public IPSDEGridColumn getPSDEGridColumn();

    public boolean isTreeNodeValue();

    public boolean isTreeNodePValue();

    public boolean isTreeNodeText();

    public boolean isTreeNodePText();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();

    public String getDataItemParam0Format();

    public boolean isCustomCode();

    public String getScriptCode();

    public String getValueType();
}

