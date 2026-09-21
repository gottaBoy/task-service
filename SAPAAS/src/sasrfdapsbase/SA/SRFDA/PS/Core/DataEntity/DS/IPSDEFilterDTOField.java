/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEFilterDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u65b9\u6cd5\u8fc7\u6ee4\u5668DTO\u5c5e\u6027\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEFSEARCHMODE"})
public interface IPSDEFilterDTOField
extends IPSDEMethodDTOField {
    public static final String SOURCETYPE_DEFSEARCHMODE = "DEFSEARCHMODE";

    public IPSDEFilterDTO getPSDEFilterDTO();

    public IPSDEFSearchMode getPSDEFSearchMode();
}

