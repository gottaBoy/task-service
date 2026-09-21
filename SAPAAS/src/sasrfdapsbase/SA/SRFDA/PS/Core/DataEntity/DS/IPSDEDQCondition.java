/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.logic.ICondition
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQGroupCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQJoin;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.logic.ICondition;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="condType", model="PSDEDQCond")
public interface IPSDEDQCondition
extends ICondition,
IPSModelObject {
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_SINGLE = "SINGLE";
    public static final String CONDTYPE_CUSTOM = "CUSTOM";

    public void init(ISRFDAGlobalHelper var1, IPSDEDQJoin var2, IPSDEDQGroupCondition var3, PSDEDataQueryCond var4) throws Exception;

    public String getCondType();

    public IPSDEDQJoin getPSDEDQJoin();

    public String getCondOp();

    public String getCondTag();

    public String getCondTag2();
}

