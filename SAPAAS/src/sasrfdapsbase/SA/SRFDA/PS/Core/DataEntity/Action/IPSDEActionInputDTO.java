/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInputDTOField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u884c\u4e3a\u8f93\u5165DTO\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEACTIONINPUT"})
public interface IPSDEActionInputDTO
extends IPSDEMethodDTO {
    public static final String SOURCETYPE_DEACTIONINPUT = "DEACTIONINPUT";

    public IPSDEActionInput getPSDEActionInput();

    public Iterator<? extends IPSDEActionInputDTOField> getPSDEActionInputDTOFields();

    public boolean containsKeyField();
}

