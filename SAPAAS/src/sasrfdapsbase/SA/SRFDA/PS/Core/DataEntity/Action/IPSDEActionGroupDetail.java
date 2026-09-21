/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(description="\u5b9e\u4f53\u884c\u4e3a\u7ec4\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEAGDetail")
public interface IPSDEActionGroupDetail
extends IPSModelObject {
    public static final String DETAILTYPE_DEACTION = "DEACTION";
    public static final String DETAILTYPE_DEDATASET = "DEDATASET";

    public String getDetailType();

    public IPSDEActionGroup getPSDEActionGroup();

    public IPSDEAction getPSDEAction();

    public IPSDEDataSet getPSDEDataSet();

    @Override
    public String getCodeName();

    public int getOrderValue();

    public String getCodeName2();
}

