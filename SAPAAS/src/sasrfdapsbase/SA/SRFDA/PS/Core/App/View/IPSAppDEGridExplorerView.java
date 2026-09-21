/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDESideBarExplorerView;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSGridExpBar;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u8868\u683c\u8fb9\u680f\u5bfc\u822a\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEGRIDEXPVIEW"})
public interface IPSAppDEGridExplorerView
extends IPSAppDESideBarExplorerView,
IPSAppDEMultiDataView {
    public static final String CTRL_GRIDEXPBAR = "GRIDEXPBAR";

    public IPSGridExpBar getPSGridExpBar();
}

