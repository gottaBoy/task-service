/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u65b9\u6cd5\u8fc7\u6ee4\u5668DTO\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEFILTER"})
public interface IPSDEFilterDTO
extends IPSDEMethodDTO {
    public static final String SOURCETYPE_DEFILTER = "DEFILTER";

    public Iterator<? extends IPSDEFilterDTOField> getPSDEFilterDTOFields();
}

