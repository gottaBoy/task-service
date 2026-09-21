/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDocObject;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSSysSearchDE
extends IPSSearchDE,
IPSSysSearchDocObject {
    public Iterator<? extends IPSSysSearchDEField> getAllPSSysSearchDEFields() throws Exception;

    public IPSSysSearchDEField getPSSysSearchDEField(String var1) throws Exception;

    public IPSSysSearchDEField getPSSysSearchDEField(String var1, boolean var2) throws Exception;
}

