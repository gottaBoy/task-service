/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataSetGroupParam
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDSGroupParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataSetGroupParam;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u5206\u7ec4\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEDSGrpParam")
public interface IPSDEDataSetGroupParam
extends IPSModelObject,
IDEDataSetGroupParam {
    public void init(ISRFDAGlobalHelper var1, IPSDEDataSet var2, PSDEDSGroupParam var3) throws Exception;

    public IPSDEDataSet getPSDEDataSet();

    public int getStdDataType();

    public boolean isEnableSort();

    public IPSDEField getPSDEField();

    public String getAggMode();

    public String getGroupCode();

    public String[] getGroupFields();

    public String getSortDir();

    public int getSortOrder();

    public boolean isReCalc();

    public boolean isEnableGroup();

    public String getAlias();

    public String getGroupJoinCode();

    public String getSelectCode();
}

