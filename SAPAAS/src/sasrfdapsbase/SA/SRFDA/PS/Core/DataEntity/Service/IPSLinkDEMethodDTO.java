/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u94fe\u63a5\u5b9e\u4f53\u65b9\u6cd5DTO\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"LINK"})
public interface IPSLinkDEMethodDTO
extends IPSDEMethodDTO {
    public IPSDataEntity getRefPSDataEntity();

    public IPSDEFGroup getRefPSDEFGroup();

    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception;
}

