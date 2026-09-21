/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u8868\u683c\u5e03\u5c40\u5360\u4f4d\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"TABLE"})
public interface IPSTableLayoutPos
extends IPSLayoutPos {
    public Integer getColSN();

    public Integer getRowSN();

    public Integer getColSpan();

    public Integer getRowSpan();
}

