/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataMap;

import SA.SRFDA.PS.Core.DataEntity.DataMap.IPSDEMap;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEMapObject
extends IPSModelObject {
    public static final String MAPMODE_DEFAULT = "DEFAULT";
    public static final String MAPMODE_INNER = "INNER";

    public IPSDEMap getPSDEMap();
}

