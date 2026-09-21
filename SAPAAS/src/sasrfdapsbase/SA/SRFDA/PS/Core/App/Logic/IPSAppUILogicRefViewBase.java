/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.Logic;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateParamContainer;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5168\u5c40\u754c\u9762\u903b\u8f91\u5f15\u7528\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppUILogicRefViewBase
extends IPSNavigateParamContainer,
IPSModelObject {
    public String getRefCat();

    public String getRefMode();

    public String getRefModeDesc();

    public IPSAppView getRefPSAppView();

    public String getOpenMode();
}

