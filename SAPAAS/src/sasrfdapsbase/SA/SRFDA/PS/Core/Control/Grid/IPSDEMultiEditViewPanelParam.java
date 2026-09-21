/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u591a\u7f16\u8f91\u9875\u9762\u677f\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEMultiEditViewPanelParam
extends IPSDEGridParam {
    public String getPSDEViewId();

    public String getPanelStyle();
}

