/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u7ed3\u675f\u8282\u70b9\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"END"})
public interface IPSDEUIEndLogic
extends IPSDEUILogicNode {
    public static final String RETURNTYPE_NONEVALUE = "NONEVALUE";
    public static final String RETURNTYPE_NULLVALUE = "NULLVALUE";
    public static final String RETURNTYPE_SRCVALUE = "SRCVALUE";
    public static final String RETURNTYPE_LOGICPARAM = "LOGICPARAM";
    public static final String RETURNTYPE_LOGICPARAMFIELD = "LOGICPARAMFIELD";
    public static final String RETURNTYPE_BREAK = "BREAK";

    public String getReturnType();

    public String getRawValue();

    public int getRawValueStdDataType();

    public IPSDEUILogicParam getReturnParam() throws Exception;

    public String getDstFieldName() throws Exception;
}

