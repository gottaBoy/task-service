/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBICubeDimensionObject;
import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.BI.IPSBILevel;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBICubeLevel
extends IPSBICubeDimensionObject {
    @Override
    public IPSBICubeDimension getPSBICubeDimension();

    public IPSBIHierarchy getPSBIHierarchy();

    public IPSBILevel getPSBILevel();

    public IPSDEField getPSDEField();

    public String getLevelTag();

    public String getLevelTag2();

    public boolean isAllLevel();
}

