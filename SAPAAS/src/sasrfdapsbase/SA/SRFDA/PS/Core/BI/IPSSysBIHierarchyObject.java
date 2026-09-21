/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchyObject;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysBIHierarchyObject
extends IPSBIHierarchyObject,
IPSSysBISchemeObject {
    public IPSSysBIHierarchy getPSSysBIHierarchy();
}

