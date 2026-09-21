/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSSearchBarButton
extends IPSSearchBarItem {
    public static final String BUTTON_SEARCH = "SEARCH";
    public static final String BUTTON_ADVSEARCH = "ADVSEARCH";
    public static final String BUTTON_RESET = "RESET";

    public String getButtonType();
}

