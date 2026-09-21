/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDERNN
extends IPSModelObject {
    public IPSDER1N getFirstPSDER1N();

    public IPSDER1N getSecondPSDER1N();

    public IPSDER1NBase getFirstPSDER();

    public IPSDER1NBase getSecondPSDER();
}

