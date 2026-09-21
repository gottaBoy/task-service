/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.Control.Editor.IPSNumberEditor;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u6b65\u8fdb\u7f16\u8f91\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"STEPPER", "MOBSTEPPER"})
public interface IPSStepper
extends IPSNumberEditor {
    public static final String EDITORPARAM_STEPVALUE = "STEPVALUE";

    public Double getStepValue();
}

