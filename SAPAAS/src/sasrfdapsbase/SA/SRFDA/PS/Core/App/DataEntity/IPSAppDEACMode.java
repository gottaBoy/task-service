/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.DataEntity;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Panel.IPSLayoutPanel;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEACMode")
public interface IPSAppDEACMode
extends IPSDEACMode {
    public IPSAppDataEntity getPSAppDataEntity();

    public IPSAppDEField getValuePSAppDEField();

    public IPSAppDEField getTextPSAppDEField();

    public IPSAppDEField getMinorSortPSAppDEField();

    public IPSAppView getPickupPSAppView();

    public IPSAppView getLinkPSAppView();

    public IPSLayoutPanel getItemPSLayoutPanel();

    public IPSAppDEDataSet getPSAppDEDataSet();
}

