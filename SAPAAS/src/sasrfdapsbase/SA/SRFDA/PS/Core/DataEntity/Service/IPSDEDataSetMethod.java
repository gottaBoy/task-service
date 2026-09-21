/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethod;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSDEDataSetMethod
extends IPSDEMethod,
IPSDEDataSet {
    public static final String PARENTKEYMODE_DEFAULT = "DEFAULT";
    public static final String PARENTKEYMODE_CHILDOF = "CHILDOF";
    public static final String PARENTKEYMODE_IGNORE = "IGNORE";

    public IPSDEDataSet getPSDEDataSet();

    public IPSDER1N getPSDER1N();

    public String getParentKeyMode();

    public IPSDEField getPickupPSDEField();
}

