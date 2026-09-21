/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQueryCodeExp
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryCodeExp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataQueryCodeExp;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u8868\u8fbe\u5f0f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDQCodeExp")
public interface IPSDEDataQueryCodeExp
extends IPSModelObject,
IDEDataQueryCodeExp {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataQueryCode var2, PSDEDataQueryCodeExp var3) throws Exception;

    public String getExpression();

    public int getShowOrder();
}

