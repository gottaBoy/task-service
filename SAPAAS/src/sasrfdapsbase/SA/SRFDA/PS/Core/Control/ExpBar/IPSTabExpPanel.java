/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPage;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5206\u9875\u5bfc\u822a\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSTabExpPanel
extends IPSControl,
IPSControlContainer {
    public static final String TABLAYOUT_TOP = "TOP";
    public static final String TABLAYOUT_LEFT = "LEFT";
    public static final String TABLAYOUT_BOTTOM = "BOTTOM";
    public static final String TABLAYOUT_RIGHT = "RIGHT";
    public static final String TABLAYOUT_FLOW = "FLOW";
    public static final String TABLAYOUT_FLOW_NOHEADER = "FLOW_NOHEADER";
    public static final String TABLAYOUT_NOHEADER = "NOHEADER";

    public String getTabLayout();

    public Iterator<IPSTabExpPage> getPSTabExpPages();

    public String getUniqueTag();
}

