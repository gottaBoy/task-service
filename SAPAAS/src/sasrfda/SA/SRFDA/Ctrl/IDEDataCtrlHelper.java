/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IDEDataCtrlHelper {
    public boolean Init(ISRFDAGlobalHelper var1, IDBStorage var2);

    public String GetSQL_IsProcExist(String var1);

    public String GetSQL_DropProc(String var1);

    public String GetSQL_GetProcParams(String var1);

    public String GetSQL_IsTableColumnExist(String var1, String var2);

    public String GetSQL_IsTableExist(String var1);

    public String GetSQL_GetTableColumnDataType(String var1, String var2);

    public String GetSQL_AutoGenProcs(String var1);

    public String GetSQL_DropTrigger(String var1);

    public String GetSQL_IsTriggerExist(String var1);

    public String GetSQL_DropIndex(DBIndex var1);

    public String GetSQL_IsIndexExist(DBIndex var1);

    public String GetSQL_DropFunc(String var1);

    public String GetSQL_IsFuncExist(String var1);

    public String GetSQL_DropTable(String var1);

    public String GetSQL_DropView(String var1);

    public String GetSQL_IsViewExist(String var1);

    public String GetSQL_DropSequence(String var1);

    public String GetSQL_IsSequenceExist(String var1);
}

