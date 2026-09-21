/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFJoinCond;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelExtendMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u8fde\u63a5\u5355\u9879\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"SINGLE"})
public interface IPSDEDFJoinSingleCond
extends IPSDEDFJoinCond {
    public String getJoinFieldScope();

    public String getJoinField();

    public String getCondValueType();

    public String getCondValue();

    public int getStdDataType();
}

