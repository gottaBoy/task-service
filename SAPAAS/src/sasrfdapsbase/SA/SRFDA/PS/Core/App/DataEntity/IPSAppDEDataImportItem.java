/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImportItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDataImpItem")
public interface IPSAppDEDataImportItem
extends IPSDEDataImportItem {
    public IPSAppDEField getPSAppDEField();
}

