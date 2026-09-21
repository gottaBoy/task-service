/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodReturn;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u884c\u4e3a\u8fd4\u56de\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9e\u4f53\u884c\u4e3a\u8fd4\u56de\u6a21\u578b\u662f\u5b9e\u4f53\u884c\u4e3a\u6a21\u578b\u7684\u7ec4\u6210", model="PSDEAction")
public interface IPSDEActionReturn
extends IPSDEMethodReturn {
    public IPSDEAction getPSDEAction();

    public IPSDEFGroup getPSDEFGroup();

    public int getStdDataType();

    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception;

    public IPSSysDynaModel getRefPSSysDynaModel();

    public IPSDEDataQuery getPSDEDataQuery();

    public IPSDataEntity getRefPSDataEntity() throws Exception;

    public IPSDEFGroup getRefPSDEFGroup() throws Exception;
}

