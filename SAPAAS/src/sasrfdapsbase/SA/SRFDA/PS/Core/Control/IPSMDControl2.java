/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSMDControl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u591a\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e32")
public interface IPSMDControl2
extends IPSMDControl {
    public IPSDEToolbar getQuickPSDEToolbar();

    public IPSDEToolbar getBatchPSDEToolbar();
}

