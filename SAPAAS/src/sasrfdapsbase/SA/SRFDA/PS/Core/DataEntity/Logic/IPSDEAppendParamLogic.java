/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u9644\u52a0\u903b\u8f91\u53c2\u6570\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"APPENDPARAM"})
public interface IPSDEAppendParamLogic
extends IPSDELogicNode {
    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception;

    public String getSrcFieldName() throws Exception;

    public int getSrcIndex();

    public int getSrcSize();

    public int getDstIndex();
}

