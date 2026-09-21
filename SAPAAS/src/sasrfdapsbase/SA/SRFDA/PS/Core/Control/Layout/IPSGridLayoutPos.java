/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6805\u683c\u5e03\u5c40\u5360\u4f4d\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"TABLE_12COL", "TABLE_24COL"})
public interface IPSGridLayoutPos
extends IPSLayoutPos {
    public int getColXS();

    public int getColSM();

    public int getColMD();

    public int getColLG();

    public int getColXSOffset();

    public int getColSMOffset();

    public int getColMDOffset();

    public int getColLGOffset();

    public int getColWidth();
}

