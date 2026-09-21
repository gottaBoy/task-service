/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEExplorerView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTreeExpBar;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u6811\u5bfc\u822a\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DETREEEXPVIEW", "DETREEEXPVIEW3"})
public interface IPSAppDETreeExplorerView
extends IPSAppDEExplorerView,
IPSAppDEMultiDataView {
    public static final String CTRL_TREEEXPBAR = "TREEEXPBAR";
    public static final String VIEWPARAM_UI_ENABLEEXPTREECAT = "UI.ENABLEEXPTREECAT";

    public IPSTreeExpBar getPSTreeExpBar();
}

