/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.AC;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u81ea\u52a8\u586b\u5145\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEACModeItem")
public interface IPSDEACModeDataItem
extends IPSDataItem {
    public IPSDEACMode getPSDEACMode();

    public IPSDEField getPSDEField();

    public String getDataItemParam0Format();

    public boolean isCustomCode();

    public String getScriptCode();

    public IPSAppDEField getPSAppDEField();
}

