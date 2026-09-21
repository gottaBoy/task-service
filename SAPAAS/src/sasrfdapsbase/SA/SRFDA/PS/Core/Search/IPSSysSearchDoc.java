/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchSchemeObject;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysSearchDoc
extends IPSSysSearchSchemeObject,
IPSSearchDoc {
    public void registerPSSysSearchDE(IPSSysSearchDE var1);

    public Iterator<? extends IPSSysSearchDE> getAllPSSysSearchDEs() throws Exception;

    public IPSSysSearchDE getPSSysSearchDE(String var1) throws Exception;

    public IPSSysSearchDE getPSSysSearchDE(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysSearchField> getAllPSSysSearchFields() throws Exception;

    public IPSSysSearchField getPSSysSearchField(String var1) throws Exception;

    public IPSSysSearchField getPSSysSearchField(String var1, boolean var2) throws Exception;

    public IPSSysSearchField getPSSysSearchField(IPSSysSearchDEField var1) throws Exception;
}

