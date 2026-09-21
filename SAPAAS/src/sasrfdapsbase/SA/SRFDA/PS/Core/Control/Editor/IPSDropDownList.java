/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSCodeListEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u4e0b\u62c9\u5217\u8868\u6846\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DROPDOWNLIST", "MOBDROPDOWNLIST", "DROPDOWNLIST_100"})
public interface IPSDropDownList
extends IPSCodeListEditor {
    public boolean isSingleSelect();
}

