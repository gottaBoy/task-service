/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.Control.IPSControlAttribute;
import SA.SRFDA.PS.Core.Control.IPSControlLogic;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSControlRender;
import java.util.Iterator;

public interface IPSControlItem
extends IPSControlObject {
    public static final String HandlerType_None = "None";
    public static final String HandlerType_CodeList = "CodeList";
    public static final String HandlerType_PickupText = "PickupText";
    public static final String HandlerType_AC = "AC";
    public static final String HandlerType_Custom = "Custom";

    public Iterator<? extends IPSControlLogic> getPSControlLogics();

    public Iterator<? extends IPSControlAttribute> getPSControlAttributes();

    public Iterator<? extends IPSControlRender> getPSControlRenders();
}

