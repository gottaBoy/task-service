/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTO;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165DTO\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEACTIONPARAM"}, description="")
public interface IPSDEActionInputDTOField
extends IPSDEMethodDTOField {
    public static final String SOURCETYPE_DEACTIONPARAM = "DEACTIONPARAM";

    public IPSDEActionInputDTO getPSDEActionInputDTO();

    public IPSDEActionParam getPSDEActionParam();
}

