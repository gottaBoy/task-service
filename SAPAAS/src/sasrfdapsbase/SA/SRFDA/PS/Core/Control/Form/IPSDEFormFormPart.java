/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;

public interface IPSDEFormFormPart
extends IPSDEFormGroupPanel {
    public static final String FORMPARTTYPE_DYNASYS = "DYNASYS";
    public static final String FORMPARTTYPE_FORMRF = "FORMRF";

    public String getFormPartType();
}

