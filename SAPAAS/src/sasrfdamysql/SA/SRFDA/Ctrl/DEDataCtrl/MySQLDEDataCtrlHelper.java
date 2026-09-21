/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DBIndex
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class MySQLDEDataCtrlHelper
implements IDEDataCtrlHelper {
    protected String strDBSCHEMA = "satest";
    protected ISRFDAGlobalHelper contextHelperEx;
    protected IDBStorage iDBStorage;
    protected String strDBStorageId = "";

    public boolean Init(ISRFDAGlobalHelper contextHelperEx, IDBStorage iDBStorage) {
        this.contextHelperEx = contextHelperEx;
        this.iDBStorage = iDBStorage;
        if (this.iDBStorage != null) {
            this.strDBSCHEMA = this.iDBStorage.GetDBSCHEMA();
            this.strDBStorageId = this.iDBStorage.GetId();
        } else {
            this.strDBSCHEMA = contextHelperEx.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
        }
        return true;
    }

    public String GetSQL_GetProcParams(String strProcName) {
        String strSQL = StringHelper.Format((String)"select param_list from mysql.proc where UPPER(specific_name)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsProcExist(String strProcName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from information_schema.routines where UPPER(ROUTINE_SCHEMA) = '%1$s' AND  UPPER(specific_name)='%2$s'  ", (Object)this.strDBSCHEMA.toUpperCase(), (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsTableColumnExist(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from information_schema.columns where UPPER(TABLE_SCHEMA) = '%1$s' AND UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)this.strDBSCHEMA.toUpperCase(), (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_GetTableColumnDataType(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select DATA_TYPE AS TYPENAME,CHARACTER_OCTET_LENGTH AS LENGTH,NUMERIC_SCALE AS SCALE  from  information_schema.columns where UPPER(TABLE_SCHEMA) = '%1$s' AND UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)this.strDBSCHEMA.toUpperCase(), (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_DropProc(String strProcName) {
        String strSQL = StringHelper.Format((String)"drop procedure %1$s", (Object)strProcName);
        return strSQL;
    }

    public String GetSQL_IsTableExist(String strTableName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from information_schema.tables where UPPER(TABLE_SCHEMA) = '%1$s' AND UPPER(TABLE_NAME)='%2$s'", (Object)this.strDBSCHEMA.toUpperCase(), (Object)strTableName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_DropTrigger(String strTriggerName) {
        return null;
    }

    public String GetSQL_IsTriggerExist(String strTriggerName) {
        return null;
    }

    public String GetSQL_AutoGenProcs(String strProcPreFix) {
        String strSQL = StringHelper.Format((String)"select UPPER(specific_name) AS PROCNAME from information_schema.routines where UPPER(ROUTINE_SCHEMA) = '%1$s' AND UPPER(specific_name) LIKE '%2$s%%'  ", (Object)this.strDBSCHEMA.toUpperCase(), (Object)strProcPreFix);
        return strSQL;
    }

    public String GetSQL_DropFunc(String strFuncName) {
        return null;
    }

    public String GetSQL_DropIndex(DBIndex dbIndex) {
        return null;
    }

    public String GetSQL_DropSequence(String strSequenceName) {
        return null;
    }

    public String GetSQL_DropView(String strViewName) {
        return null;
    }

    public String GetSQL_DropTable(String strTableName) {
        return null;
    }

    public String GetSQL_IsFuncExist(String strFuncName) {
        return null;
    }

    public String GetSQL_IsIndexExist(DBIndex dbIndex) {
        return null;
    }

    public String GetSQL_IsSequenceExist(String strSequenceName) {
        return null;
    }

    public String GetSQL_IsViewExist(String strViewName) {
        return null;
    }
}

