/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6805\u683c\u5e03\u5c40\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"TABLE_12COL", "TABLE_24COL"})
public interface IPSGridLayout
extends IPSLayout {
    public int getColumnCount();

    public boolean isEnableCol12ToCol24();

    public int getChildColXS();

    public int getChildColSM();

    public int getChildColMD();

    public int getChildColLG();
}

