/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLinkCondBase;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogicLink;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDELogicLinkCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u4e3b\u72b6\u6001\u903b\u8f91\u8fde\u63a5\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="logicType", model="PSDELLCond")
@PSModelPFIgnoreMeta
public interface IPSDEMSLogicLinkCond
extends IPSDELogicLinkCondBase {
    public void init(ISRFDAGlobalHelper var1, IPSDEMSLogicLink var2, IPSDEMSLogicLinkCond var3, PSDELogicLinkCond var4) throws Exception;

    public IPSDEMSLogicLink getPSDEMSLogicLink();
}

