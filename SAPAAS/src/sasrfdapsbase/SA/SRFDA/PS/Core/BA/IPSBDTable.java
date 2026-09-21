/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBDTable
extends IPSModelObject {
    public static final int BDTABLETYPE_MAJOR = 1;
    public static final int BDTABLETYPE_MINOR = 2;
    public static final int BDTABLETYPE_RELATED = 3;
    public static final int BDTABLETYPE_INHERIT = 9;

    @Override
    public String getCodeName();

    public String getLogicName();

    public int getBDTableType();

    public IPSDataEntity getPSDataEntity();

    public IPSDataEntity getMinorPSDataEntity();

    public String getPickupDEFName();

    public IPSDEField getPickupPSDEField();

    public IPSDER1N getPSDER1N();

    public IPSDataEntity getInheritPSDataEntity();

    public String getInheritTypeValue();
}

