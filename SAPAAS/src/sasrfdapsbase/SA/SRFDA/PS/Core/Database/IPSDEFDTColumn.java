/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEFDTColumn
 *  net.ibizsys.paas.db.IDBFunction
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCodeExp;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.db.IDBFunction;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(implement="PSDEFDTColumnImpl")
public interface IPSDEFDTColumn
extends IPSModelObject,
IDEFDTColumn {
    public static final String NULLVALORDERMODE_FIRST = "FIRST";
    public static final String NULLVALORDERMODE_LAST = "LAST";

    public void init(ISRFDAGlobalHelper var1, IPSDEDBConfig var2, IPSDEField var3, PSDEFDTColumn var4) throws Exception;

    public IPSDEDBConfig getPSDEDBConfig();

    public IPSDEField getPSDEField();

    public String getDBDataType() throws Exception;

    public String getDBDataType(boolean var1, boolean var2, boolean var3, String var4) throws Exception;

    public String getColumnName();

    public String getFormalColumnName();

    public int getJDBCType() throws Exception;

    public String getFormulaFormat() throws Exception;

    public String getFormulaColumns() throws Exception;

    public boolean isPhisical() throws Exception;

    public boolean isFormula() throws Exception;

    public boolean isValueAutoGen() throws Exception;

    public String getValueGenFunc() throws Exception;

    public int getLength() throws Exception;

    public int getPrecision() throws Exception;

    public int getScale() throws Exception;

    public String getDefaultValue() throws Exception;

    public String getStatisticsNullConvert();

    public boolean isNullable() throws Exception;

    public boolean isInsertProcParam() throws Exception;

    public boolean isUpdateProcParam() throws Exception;

    public boolean isEnableInsert() throws Exception;

    public boolean isEnableUpdate() throws Exception;

    public String getQueryCaseSenstive() throws Exception;

    public String getTableScope() throws Exception;

    public String getRealTableName() throws Exception;

    public boolean isFKey() throws Exception;

    public boolean isPKey() throws Exception;

    public boolean isAutoIncrement();

    public boolean isUnsigned();

    public String getInsertValueFunc();

    public String getInsertValueFuncField();

    public String getUpdateValueFunc();

    public String getUpdateValueFuncField();

    public String getConditionSQL(IPSDEDQEngine var1, String var2, String var3, String var4, String var5, String var6) throws Exception;

    public String getConditionSQL(IPSDEDQEngine var1, String var2, IDBFunction var3, String var4, String var5, String var6, String var7) throws Exception;

    public boolean isCustomColumnName();

    public String getNullValueOrderMode();

    public boolean isFormulaPhisical();

    public IPSDEDataQueryCodeExp getPSDEDataQueryCodeExp() throws Exception;

    public String getQueryCodeExp() throws Exception;

    public String getDBType();

    public String getStandardColumnName();
}

