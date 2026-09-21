/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigatable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u652f\u6301\u5bfc\u822a\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlNavigatable
extends IPSControl,
IPSNavigatable {
    public double getNavViewWidth();

    public double getNavViewHeight();

    public double getNavViewMinWidth();

    public double getNavViewMinHeight();

    public double getNavViewMaxWidth();

    public double getNavViewMaxHeight();

    public String getNavViewPos();

    public int getNavViewShowMode();
}

