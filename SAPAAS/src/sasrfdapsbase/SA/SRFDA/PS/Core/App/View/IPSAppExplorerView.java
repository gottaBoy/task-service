/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5bfc\u822a\u89c6\u56fe\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppExplorerView
extends IPSAppView {
    public static final String VIEWREFMODE_EXPITEM = "EXPITEM";

    public boolean isIFrameMode();
}

