/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParamBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELNParam")
public interface IPSDELogicNodeParam
extends IPSDELogicNodeParamBase {
    public static final String PARAMACTION_SQLPARAM = "SQLPARAM";
    public static final String PARAMACTION_MERGEMAPPARAM = "MERGEMAPPARAM";
    public static final String PARAMACTION_AGGREGATEMAPPARAM = "AGGREGATEMAPPARAM";

    public void init(ISRFDAGlobalHelper var1, IPSDELogicNode var2, PSDELogicNodeParam var3) throws Exception;

    public IPSDELogicNode getPSDELogicNode();

    public String getLogicNodeParamType();

    public IPSDELogicParam getDstPSDELogicParam() throws Exception;

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception;

    public String getDirectCode();

    public String getExpression();

    public IPSSysTranslator getPSSysTranslator() throws Exception;

    public IPSSysSequence getPSSysSequence() throws Exception;

    public boolean isOutTranslate();

    public Properties getParams();
}

