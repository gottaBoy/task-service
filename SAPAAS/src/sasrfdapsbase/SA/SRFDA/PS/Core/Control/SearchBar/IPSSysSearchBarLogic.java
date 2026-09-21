/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBar;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u7cfb\u7edf\u641c\u7d22\u680f\u90e8\u4ef6\u903b\u8f91\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysSearchBarLogic")
public interface IPSSysSearchBarLogic
extends IPSDEUILogicGroupDetail,
IPSControlObject {
    public IPSSysSearchBar getPSSysSearchBar();

    public String getPSSysSearchBarItemName();
}

