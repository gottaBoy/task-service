/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarFilter;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarGroup;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarItem;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarQuickSearch;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u641c\u7d22\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u57fa\u7840\u63a5\u53e3", model="PSSysSearchBar")
public interface IPSSearchBar
extends IPSControlContainer,
IPSControl {
    public static final int QUICKSEARCH_NONE = 0;
    public static final int QUICKSEARCH_DEFAULT = 1;
    public static final int QUICKSEARCH_ADVANCE = 2;

    public String getSearchBarStyle();

    public boolean isMobileSearchBar();

    @Override
    public String getCodeName();

    public IPSSysCounterRef getPSSysCounterRef();

    public IPSAppCounterRef getPSAppCounterRef();

    public boolean isEnableQuickSearch();

    public int getQuickSearchWidth();

    public boolean isEnableFilter();

    public boolean isEnableGroup();

    public Iterator<? extends IPSSearchBarItem> getPSSearchBarItems();

    public Iterator<? extends IPSSearchBarFilter> getPSSearchBarFilters();

    public Iterator<? extends IPSSearchBarQuickSearch> getPSSearchBarQuickSearchs();

    public Iterator<? extends IPSSearchBarGroup> getPSSearchBarGroups();

    public int getQuickSearchMode();

    public int getQuickGroupCount();

    public String getGroupMoreText();

    public String getGroupMode();

    public IPSSearchBarFilter getPSSearchBarFilter(String var1, boolean var2) throws Exception;
}

