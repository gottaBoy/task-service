/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u7f16\u8f91\u8868\u5355\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3")
public interface IPSWFEditForm
extends IPSControl {
    public IPSControlAction getWFStartPSControlAction();

    public IPSControlAction getWFSubmitPSControlAction();
}

