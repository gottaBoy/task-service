/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanel;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelItem;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.IPSDataItem;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u9762\u677f\u6570\u636e\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSSysPanelDataItem
extends IPSDataItem {
    public IPSSysPanel getPSSysPanel();

    public IPSSysPanelItem getPSSysPanelItem();

    public IPSDEField getPSDEField();

    public IPSAppDEField getPSAppDEField();
}

