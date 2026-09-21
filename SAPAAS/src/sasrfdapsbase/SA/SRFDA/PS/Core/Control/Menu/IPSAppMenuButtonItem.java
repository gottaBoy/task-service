/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.Control.IPSButtonBase;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;

public interface IPSAppMenuButtonItem
extends IPSAppMenuItem,
IPSButtonBase {
    public static final String ACTIONTYPE_CUSTOM = "CUSTOM";
    public static final String ACTIONTYPE_APPFUNC = "APPFUNC";

    public String getActionType();
}

