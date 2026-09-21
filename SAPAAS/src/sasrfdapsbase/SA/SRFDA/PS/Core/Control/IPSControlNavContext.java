/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u754c\u9762\u90e8\u4ef6\u5bfc\u822a\u4e0a\u4e0b\u6587\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSControlNavContext
extends IPSNavigateContext {
    public IPSControl getPSControl();

    @Override
    public boolean isRawValue();
}

