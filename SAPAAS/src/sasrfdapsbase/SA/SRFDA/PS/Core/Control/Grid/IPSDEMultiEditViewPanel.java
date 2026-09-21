/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u591a\u7f16\u8f91\u89c6\u56fe\u9762\u677f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEGrid")
public interface IPSDEMultiEditViewPanel
extends IPSDEGrid {
    public IPSAppView getEmbeddedPSAppView();

    public IPSAppDEView getPSAppDEView();

    public String getPanelStyle();
}

