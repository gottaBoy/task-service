/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5e94\u7528\u5b9e\u4f53\u641c\u7d22\u89c6\u56fe\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e332", description="\u652f\u6301\u641c\u7d22\u89c6\u56fe\u914d\u7f6e\u641c\u7d22\u680f\u529f\u80fd", model="PSDEViewBase")
public interface IPSAppDESearchView3 {
    public static final String CONTROL_SEARCHBAR = "searchbar";

    public IPSSearchBar getPSSearchBar();
}

