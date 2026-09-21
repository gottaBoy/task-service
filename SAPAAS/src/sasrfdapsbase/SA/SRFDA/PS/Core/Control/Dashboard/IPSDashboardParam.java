/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDashboardParam
extends IPSAjaxControlParam {
    public double[] getColumnModels();

    public String getLayoutMode();

    public String getFlexDir();

    public String getFlexAlign();

    public String getFlexVAlign();

    public Boolean isEnableCustomized();

    public Integer getCustomizeMode();

    public String getDashboardStyle();

    public String getDashboardTag();

    public String getDashboardTag2();

    public Boolean isShowDashboardNavBar();

    public String getNavBarPos();

    public String getNavBarStyle();

    public Double getNavBarWidth();

    public Double getNavBarHeight();

    public String getNavBarPSSysCssId();
}

