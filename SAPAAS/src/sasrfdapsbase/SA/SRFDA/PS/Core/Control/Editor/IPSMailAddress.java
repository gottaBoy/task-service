/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSAutoComplete;
import SA.SRFDA.PS.Core.Control.Editor.IPSPickerEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u90ae\u4ef6\u5730\u5740\u8f93\u5165\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"ADDRESSPICKUP", "ADDRESSPICKUP_AC"})
public interface IPSMailAddress
extends IPSPickerEditor,
IPSAutoComplete {
    public static final String PARAM_PICKUPVIEW = "PICKUPVIEW";
}

