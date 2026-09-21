/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumnConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public interface IDEFDTColumn {
    public CallResult Init(IDEFHelper var1, DEFDTColumnConfig var2, ISRFDAGlobalHelper var3);

    public boolean IsPKey();

    public boolean IsFKey();

    public String GetTableName();

    public String GetDBDataType();

    public String GetDBDataType(boolean var1, boolean var2, boolean var3, String var4);

    public String GetColumnName();

    public String GetFormalColumnName();

    public int GetJDBCType();

    public boolean IsSupportSearchAction(SearchItemConfig var1);

    public String GetFormulaFormat();

    public String GetFormulaColumns();

    public boolean IsPhisical();

    public boolean IsFormula();

    public boolean IsValueAutoGen();

    public String GetValueGenFunc();

    public int GetLength();

    public int GetPrecision();

    public int GetScale();

    public String GetStatisticsNullConvert();

    public boolean IsNullable();

    public boolean IsInsertProcParam();

    public boolean IsUpdateProcParam();

    public boolean IsEnableInsert();

    public boolean IsEnableUpdate();

    public String GetInsertMode();

    public String GetUpdateMode();

    public String GetQueryCaseSenstive();

    public boolean isViewColumn();
}

