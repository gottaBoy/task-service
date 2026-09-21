/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u5904\u7406\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="logicType", model="PSDELLCond")
public interface IPSDELogicLinkCond
extends IPSDELogicLinkCondBase {
    public void init(ISRFDAGlobalHelper var1, IPSDELogicLink var2, IPSDELogicLinkCond var3, PSDELogicLinkCond var4) throws Exception;

    public IPSDELogicLink getPSDELogicLink();
}

