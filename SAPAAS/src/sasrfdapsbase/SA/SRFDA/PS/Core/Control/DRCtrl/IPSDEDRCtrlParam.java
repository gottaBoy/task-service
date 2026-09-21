/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u90e8\u4ef6\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSDEDRCtrlParam
extends IPSAjaxControlParam {
    public String getPSDEDRId();

    public String getPSSysCounterId();
}

