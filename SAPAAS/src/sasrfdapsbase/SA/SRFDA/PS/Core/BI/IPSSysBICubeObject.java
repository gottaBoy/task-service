/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeObject;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysBICubeObject
extends IPSBICubeObject,
IPSSysBISchemeObject {
    public IPSSysBICube getPSSysBICube();
}

