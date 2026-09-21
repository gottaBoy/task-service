/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPartParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u83dc\u5355\u95e8\u6237\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDBAppMenuPortletPartParam
extends IPSDBPortletPartParam {
    public String getPSAppMenuId();

    public String getAMPSSysPFPluginId();

    public String getAMListStyle();

    public String getPSAppFuncPickupViewId();
}

