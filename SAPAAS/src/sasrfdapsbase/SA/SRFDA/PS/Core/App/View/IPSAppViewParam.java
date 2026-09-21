/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u89c6\u56fe\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSAppViewParam
extends IPSModelObject {
    public IPSAppView getPSAppView();

    public String getKey();

    public String getValue();

    public String getDesc();
}

