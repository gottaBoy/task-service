/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanelParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5206\u9875\u89c6\u56fe\u9762\u677f\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDETabViewPanelParam
extends IPSDEViewPanelParam {
    public String getPSSysCounterId();

    public String getCounterId();

    public String getNavPSDERId();

    public String getNavPSDERName();

    public String getPSSysImageId();

    public String getNavFilter();

    public String getPSDEOPPrivId();
}

