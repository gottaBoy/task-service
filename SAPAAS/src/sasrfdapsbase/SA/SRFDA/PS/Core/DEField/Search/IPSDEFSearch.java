/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DEField.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Search.IPSDESearch;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;

@PSModelIgnoreMeta
public interface IPSDEFSearch
extends IPSModelObject {
    public IPSDEField getPSDEField();

    public IPSDESearch getPSDESearch() throws Exception;

    public IPSSysSearchDEField getPSSysSearchDEField() throws Exception;

    public IPSSysSearchField getPSSysSearchField() throws Exception;

    public String getFieldTag();

    public String getFieldTag2();
}

