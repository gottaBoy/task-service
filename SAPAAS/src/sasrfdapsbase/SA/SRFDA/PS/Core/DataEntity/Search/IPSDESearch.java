/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Search;

import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSDESearch
extends IPSDataEntityObject {
    public IPSSysSearchScheme getPSSysSearchScheme() throws Exception;

    public IPSSysSearchDE getPSSysSearchDE() throws Exception;

    public IPSSysSearchDoc getPSSysSearchDoc() throws Exception;

    public Iterator<IPSDEFSearch> getAllPSDEFSearchs() throws Exception;

    public Iterator<IPSDEFSearch> getAllPSDEFSearches() throws Exception;

    public String getDETag();

    public String getDETag2();

    public boolean isNoSQLStorage();
}

