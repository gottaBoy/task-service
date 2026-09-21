/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Search.IPSSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEObject;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;

@PSModelPFIgnoreMeta
public interface IPSSysSearchDEField
extends IPSSearchDEField,
IPSSysSearchDEObject {
    public IPSSysSearchField getPSSysSearchField();
}

