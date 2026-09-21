/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.Ajax.IPSMDAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.IPSAjaxControl;
import SA.SRFDA.PS.Core.Control.IPSMDControl;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSMDAjaxControl
extends IPSAjaxControl,
IPSMDControl {
    public static final String EVENT_SELECTIONCHANGE = "SELECTIONCHANGE";
    public static final String EVENT_LOAD = "LOAD";

    public IPSMDAjaxControlHandler getPSMDAjaxControlHandler();

    public boolean hasWFDataItems();
}

