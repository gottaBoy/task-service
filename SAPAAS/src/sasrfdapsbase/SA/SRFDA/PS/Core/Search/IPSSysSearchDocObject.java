/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDocObject;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchSchemeObject;

@PSModelPFIgnoreMeta
public interface IPSSysSearchDocObject
extends IPSSearchDocObject,
IPSSysSearchSchemeObject {
    public IPSSysSearchDoc getPSSysSearchDoc();
}

