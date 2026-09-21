/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimensionObject;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSSysBILevel;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysBICubeLevel
extends IPSBICubeLevel,
IPSSysBICubeDimensionObject {
    @Override
    public IPSSysBICubeDimension getPSSysBICubeDimension();

    public IPSSysBIHierarchy getPSSysBIHierarchy();

    public IPSSysBILevel getPSSysBILevel();
}

