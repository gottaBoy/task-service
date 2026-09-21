/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u7edd\u5bf9\u5e03\u5c40\u5360\u4f4d\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"ABSOLUTE"})
public interface IPSAbsoluteLayoutPos
extends IPSLayoutPos {
    public static final String AL_POS_LTWH = "LTWH";
    public static final String AL_POS_LTRB = "LTRB";
    public static final String AL_POS_RBWH = "RBWH";

    public String getLayoutPos();

    public int getLeft();

    public int getTop();

    public int getBottom();

    public int getRight();
}

