/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParamBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u754c\u9762\u903b\u8f91\u8282\u70b9\u53c2\u6570\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDELNParam")
public interface IPSDEUILogicNodeParam
extends IPSDELogicNodeParamBase {
    public void init(ISRFDAGlobalHelper var1, IPSDEUILogicNode var2, PSDELogicNodeParam var3) throws Exception;

    public IPSDEUILogicNode getPSDEUILogicNode();

    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception;

    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception;

    public String getExpression();
}

