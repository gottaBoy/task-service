/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeCond
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeCond;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6761\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDQCodeCond")
public interface IPSDEDataQueryCodeCond
extends IPSModelObject,
IDEDataQueryCodeCond {
    public static final String CONDTYPE_DEFIELD = "DEFIELD";
    public static final String CONDTYPE_CUSTOM = "CUSTOM";
    public static final String CONDTYPE_GROUP = "GROUP";
    public static final String CONDTYPE_PREDEFINED = "PREDEFINED";

    public void init(ISRFDAGlobalHelper var1, IPSDEDataQueryCode var2, PSDEDataQueryCodeCond var3) throws Exception;

    public String getCondType();

    public String getCustomCond();

    public String getCustomType();
}

