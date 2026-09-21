/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEWFEditViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEWFSTARTVIEW"})
public class PSAppDEWFStartViewImpl
extends PSAppDEWFEditViewImpl {
    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00\u6a21\u5f0f", codelist="DEViewOpenMode", doc="\u672a\u5b9a\u4e49\u65f6\u9ed8\u8ba4\u4e3a[POPUPMODAL]")
    public String getOpenMode() {
        String strOpenMode = super.getOpenMode();
        if (StringHelper.isNullOrEmpty((String)strOpenMode)) {
            return "POPUPMODAL";
        }
        return strOpenMode;
    }
}

