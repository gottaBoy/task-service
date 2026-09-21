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

public class OraDEDataCtrlHelper
implements IDEDataCtrlHelper {
    protected String strDBSCHEMA = "DB2ADMIN";
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
        String strSQL = StringHelper.Format((String)"select argument_name as PARAMNAME,in_out as DIRECTION from USER_ARGUMENTS where UPPER(object_name)='%2$s'   order by position", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsProcExist(String strProcName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from USER_procedures where UPPER(object_name)='%2$s'  ", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsTableColumnExist(String strTableName, String strColumnName) {
        strTableName = strTableName.toUpperCase();
        strColumnName = strColumnName.toUpperCase();
        String strSQL = null;
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from user_tab_columns where   UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)this.strDBSCHEMA, (Object)strTableName, (Object)strColumnName);
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from all_tab_columns where UPPER(OWNER)='%1$s' AND  UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)items[0], (Object)items[1], (Object)strColumnName);
        }
        return strSQL;
    }

    public String GetSQL_GetTableColumnDataType(String strTableName, String strColumnName) {
        strTableName = strTableName.toUpperCase();
        strColumnName = strColumnName.toUpperCase();
        String strSQL = null;
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"select DATA_TYPE AS TYPENAME,DATA_LENGTH AS LENGTH,DATA_SCALE AS SCALE   from user_tab_columns where   UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)this.strDBSCHEMA, (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"select DATA_TYPE AS TYPENAME,DATA_LENGTH AS LENGTH,DATA_SCALE AS SCALE   from all_tab_columns where UPPER(OWNER)='%1$s' AND  UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)items[0], (Object)items[1], (Object)strColumnName);
        }
        return strSQL;
    }

    public String GetSQL_DropProc(String strProcName) {
        String strSQL = StringHelper.Format((String)"drop procedure %1$s", (Object)strProcName);
        return strSQL;
    }

    public String GetSQL_IsTableExist(String strTableName) {
        strTableName = strTableName.toUpperCase();
        String strSQL = null;
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from user_tables where  UPPER(TABLE_NAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strTableName);
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from all_tables where  UPPER(OWNER)='%1$s' AND UPPER(TABLE_NAME)='%2$s'", (Object)items[0].toUpperCase(), (Object)items[1].toUpperCase());
        }
        return strSQL;
    }

    public String GetSQL_DropTrigger(String strTriggerName) {
        String strSQL = StringHelper.Format((String)"drop trigger %1$s", (Object)strTriggerName);
        return strSQL;
    }

    public String GetSQL_IsTriggerExist(String strTriggerName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from sys.user_triggers where  UPPER(TRIGGER_NAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strTriggerName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_AutoGenProcs(String strProcPreFix) {
        String strSQL = StringHelper.Format((String)"select UPPER(object_name) as PROCNAME from USER_procedures where UPPER(object_name) LIKE '%2$s%%'  ", (Object)this.strDBSCHEMA, (Object)strProcPreFix);
        return strSQL;
    }

    public String GetSQL_DropFunc(String strFuncName) {
        String strSQL = StringHelper.Format((String)"drop function %1$s", (Object)strFuncName);
        return strSQL;
    }

    public String GetSQL_DropIndex(DBIndex dbIndex) {
        String strSQL = StringHelper.Format((String)"drop index %1$s", (Object)dbIndex.getDBINDEXNAME());
        return strSQL;
    }

    public String GetSQL_DropSequence(String strSequenceName) {
        String strSQL = StringHelper.Format((String)"drop sequence %1$s", (Object)strSequenceName);
        return strSQL;
    }

    public String GetSQL_DropTable(String strTableName) {
        String strSQL = StringHelper.Format((String)"DROP TABLE %1$s", (Object)strTableName);
        return strSQL;
    }

    public String GetSQL_DropView(String strViewName) {
        String strSQL = StringHelper.Format((String)"drop view %1$s", (Object)strViewName);
        return strSQL;
    }

    public String GetSQL_IsFuncExist(String strFuncName) {
        return this.GetSQL_IsProcExist(strFuncName);
    }

    public String GetSQL_IsIndexExist(DBIndex dbIndex) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from USER_INDEXES where  UPPER(INDEX_NAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)dbIndex.getDBINDEXNAME().toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsSequenceExist(String strSequenceName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from sys.user_sequences where  UPPER(SEQUENCE_NAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strSequenceName);
        return strSQL;
    }

    public String GetSQL_IsViewExist(String strViewName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from sys.user_views where  UPPER(VIEW_NAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strViewName.toUpperCase());
        return strSQL;
    }
}

