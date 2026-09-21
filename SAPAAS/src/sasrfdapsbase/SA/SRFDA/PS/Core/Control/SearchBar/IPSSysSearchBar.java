/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarLogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u7cfb\u7edf\u641c\u7d22\u680f\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysSearchBar")
public interface IPSSysSearchBar
extends IPSSearchBar {
    public Iterator<? extends IPSSysSearchBarLogic> getPSSysSearchBarLogics();
}

