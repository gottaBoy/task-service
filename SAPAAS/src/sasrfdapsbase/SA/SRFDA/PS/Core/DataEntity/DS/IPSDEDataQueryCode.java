/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQueryCode
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeCond;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDataQueryCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataQueryCode;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u4ee3\u7801\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDQCode")
public interface IPSDEDataQueryCode
extends IPSModelObject,
IDEDataQueryCode,
IPSDynaInstSupportable {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataQuery var2, PSDEDataQueryCode var3) throws Exception;

    public String getDBType();

    public IPSDEDataQuery getPSDEDataQuery();

    public Iterator<IPSDEDataQueryCodeExp> getPSDEDataQueryCodeExps() throws Exception;

    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp(String var1, boolean var2) throws Exception;

    public Iterator<IPSDEDataQueryCodeCond> getPSDEDataQueryCodeConds() throws Exception;

    public void loadAll() throws Exception;

    public String getQueryCode();

    public String getQueryCodeTemp();

    public String getDeclareCode();
}

