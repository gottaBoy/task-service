/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u8fb9\u7f18\u5e03\u5c40\u5360\u4f4d\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"BORDER"})
public interface IPSBorderLayoutPos
extends IPSLayoutPos {
    public static final String BL_POS_NORTH = "NORTH";
    public static final String BL_POS_WEST = "WEST";
    public static final String BL_POS_EAST = "EAST";
    public static final String BL_POS_SOUTH = "SOUTH";
    public static final String BL_POS_CENTER = "CENTER";

    public String getLayoutPos();
}

