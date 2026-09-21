/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDRDER1NItem
extends IPSDEDRItem {
    public IPSDER1N getPSDER1N();

    public String getPSDER1NName();

    public IPSDERBase getPSDER() throws Exception;
}

