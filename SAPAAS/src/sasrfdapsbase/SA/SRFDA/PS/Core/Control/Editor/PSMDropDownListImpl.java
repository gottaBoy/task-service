/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSMDropDownList;
import SA.SRFDA.PS.Core.Control.Editor.PSDropDownListImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"MDROPDOWNLIST"})
public class PSMDropDownListImpl
extends PSDropDownListImpl
implements IPSMDropDownList {
    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9\u6a21\u5f0f")
    public boolean isSingleSelect() {
        return false;
    }
}

