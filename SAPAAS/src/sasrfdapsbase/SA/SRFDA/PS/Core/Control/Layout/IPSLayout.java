/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Layout;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSLayout;

@PSModelInterfaceMeta(title="\u5e03\u5c40\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", typefield="layout", model="PSLayout")
public interface IPSLayout
extends IPSModelObject {
    public static final String LAYOUT_TABLE = "TABLE";
    public static final String LAYOUT_TABLE_12COL = "TABLE_12COL";
    public static final String LAYOUT_TABLE_24COL = "TABLE_24COL";
    public static final String LAYOUT_FLEX = "FLEX";
    public static final String LAYOUT_BORDER = "BORDER";
    public static final String LAYOUT_ABSOLUTE = "ABSOLUTE";
    public static final String LAYOUT_SIMPLEFLEX = "SIMPLEFLEX";

    public void init(IPSModelObject var1, PSLayout var2) throws Exception;

    public String getLayout();

    public IPSLayoutPos createPSLayoutPos(IPSModelObject var1, PSLayout var2) throws Exception;

    public IPSControl getPSControl();
}

