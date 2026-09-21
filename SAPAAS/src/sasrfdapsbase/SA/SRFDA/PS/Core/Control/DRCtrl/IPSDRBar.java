/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDRCtrl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;

@PSModelInterfaceMeta(title="\u6570\u636e\u5173\u7cfb\u8fb9\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDRBar
extends IPSDRCtrl,
IPSControlContainer {
    public String getTitle();

    public IPSLanguageRes getTitlePSLanguageRes();

    public boolean isShowTitle();
}

