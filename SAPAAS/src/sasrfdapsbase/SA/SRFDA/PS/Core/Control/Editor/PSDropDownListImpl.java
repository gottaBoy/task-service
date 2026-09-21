/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSDropDownList;
import SA.SRFDA.PS.Core.Control.Editor.PSCodeListEditorImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"DROPDOWNLIST", "MOBDROPDOWNLIST", "DROPDOWNLIST_100"})
public class PSDropDownListImpl
extends PSCodeListEditorImpl
implements IPSDropDownList {
    @Override
    @PSModelRTMeta(description="\u5355\u9879\u9009\u62e9\u6a21\u5f0f")
    public boolean isSingleSelect() {
        return true;
    }
}

