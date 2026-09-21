/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodInput;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u8f93\u5165\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", description="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u8f93\u5165\u6a21\u578b\u662f\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6a21\u578b\u7684\u7ec4\u6210", model="PSDEDataQuery")
public interface IPSDEDataQueryInput
extends IPSDEMethodInput {
    public IPSDEDataQuery getPSDEDataQuery();

    public IPSDEFGroup getPSDEFGroup();

    public IPSSysDynaModel getRefPSSysDynaModel();

    public IPSDEFilterDTO getPSDEFilterDTO() throws Exception;
}

