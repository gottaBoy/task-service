/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6a21\u578b\u57fa\u7840\u5bf9\u8c61\u63a5\u53e3", util=true)
public interface IPSDELogicNodeParamBase
extends IPSModelObject {
    public static final String PARAMACTION_SETPARAMVALUE = "SETPARAMVALUE";
    public static final String PARAMACTION_RESETPARAM = "RESETPARAM";
    public static final String PARAMACTION_COPYPARAM = "COPYPARAM";
    public static final String PARAMACTION_BINDPARAM = "BINDPARAM";
    public static final String PARAMACTION_APPENDPARAM = "APPENDPARAM";
    public static final String PARAMACTION_SORTPARAM = "SORTPARAM";
    public static final String SRCVALUETYPE_SRCDLPARAM = "SRCDLPARAM";
    public static final String SRCVALUETYPE_WEBCONTEXT = "WEBCONTEXT";
    public static final String SRCVALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String SRCVALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String SRCVALUETYPE_EXPRESSION = "EXPRESSION";

    public String getParamAction();

    public String getDstFieldName() throws Exception;

    public String getSrcFieldName() throws Exception;

    public String getSrcValue();

    public String getSrcValueType();

    public int getSrcIndex();

    public int getSrcSize();

    public int getDstIndex();

    public String getAggMode();

    public String getDstSortDir();

    public int getSrcValueStdDataType();
}

