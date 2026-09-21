/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.List.IPSDEList;
import SA.SRFDA.PS.Core.Control.List.IPSListDataItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5217\u8868\u90e8\u4ef6\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEListDataItem
extends IPSListDataItem {
    public IPSDEList getPSDEList();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();
}

