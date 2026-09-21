/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity;

import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEGroupDetail
extends IPSModelObject {
    public IPSDEGroup getPSDEGroup();

    public IPSDataEntity getPSDataEntity();

    @Override
    public String getCodeName();

    public int getOrderValue();

    public String getCodeName2();

    public String getDetailParam();

    public String getDetailParam2();

    public String getDetailTag();

    public String getDetailTag2();

    public String getData();
}

