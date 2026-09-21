/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u6d41\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelPFIgnoreMeta
public interface IPSDEDataFlowNodeParam
extends IPSModelObject {
    public static final String NODEPARAMTYPE_MERGEPARAM = "MERGEPARAM";
    public static final String NODEPARAMTYPE_PREPAREPARAM = "PREPAREPARAM";
    public static final String NODEPARAMTYPE_AGGREGATEPARAM = "AGGREGATEPARAM";
    public static final String NODEPARAMTYPE_SORTPARAM = "SORTPARAM";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataFlowNode var2, PSDELogicNodeParam var3) throws Exception;

    public IPSDEDataFlowNode getPSDEDataFlowNode();

    public String getNodeParamType();

    public String getDstField() throws Exception;

    public String getSrcField() throws Exception;

    public String getSrcValue();

    public String getSrcValueType();

    public int getSrcIndex();

    public int getSrcSize();

    public int getDstIndex();

    public String getAggMode();

    public String getDstSortDir();

    public int getSrcValueStdDataType();

    public String getExpression();

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public IPSSysSequence getPSSysSequence() throws Exception;

    public boolean isOutTranslate();
}

