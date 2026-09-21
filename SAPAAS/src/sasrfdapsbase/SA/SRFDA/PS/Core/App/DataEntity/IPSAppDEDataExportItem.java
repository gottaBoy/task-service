/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGridCol")
public interface IPSAppDEDataExportItem
extends IPSDEDataExportItem {
    @Override
    public IPSAppDEField getPSAppDEField();
}

