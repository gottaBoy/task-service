/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DBIndex
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEDataCtrlHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;

public class SqlServerDEDataCtrlHelper
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
        String strSQL = StringHelper.Format((String)"select replace(t.name,'@','') as PARAMNAME,case t.is_output when 1 then 'OUT' else 'IN' end as DIRECTION  from sys.all_parameters  t inner join sys.sysobjects p  on t.object_id=p.id where p.status>=0 and p.xtype='p' and UPPER(p.name)='%1$s'  order by t.parameter_id ", (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsProcExist(String strProcName) {
        String strSQL = StringHelper.Format((String)"select count(*) as [ROWCOUNT] from dbo.sysobjects p where xtype='p'   and p.status>=0 and UPPER(name)='%1$s'  ", (Object)strProcName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_IsTableColumnExist(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select count(*) as [ROWCOUNT] from    sys.all_columns t inner join sys.sysobjects p     on t.object_id=p.id where p.status>=0 and p.xtype='U' and       UPPER(p.name)='%1$s' AND UPPER(t.name)='%2$s'", (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_GetTableColumnDataType(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select s.name AS TYPENAME,t.max_length AS LENGTH,t.scale AS SCALE   from    sys.all_columns t inner join sys.sysobjects p     on t.object_id=p.id  inner join dbo.systypes s on t.user_type_id=s.xtype  where p.status>=0 and p.xtype='U' and       UPPER(p.name)='%1$s' AND UPPER(t.name)='%2$s'", (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_DropProc(String strProcName) {
        String strSQL = StringHelper.Format((String)"drop procedure %1$s", (Object)strProcName);
        return strSQL;
    }

    public String GetSQL_IsTableExist(String strTableName) {
        String strSQL = StringHelper.Format((String)"select count(*) as [ROWCOUNT] from    dbo.sysobjects v where xtype='U'  and v.status>=0 and  UPPER(v.name)='%1$s'", (Object)strTableName.toUpperCase());
        return strSQL;
    }

    public String GetSQL_DropTrigger(String strTriggerName) {
        return null;
    }

    public String GetSQL_IsTriggerExist(String strTriggerName) {
        return null;
    }

    public String GetSQL_AutoGenProcs(String strProcPreFix) {
        String strSQL = StringHelper.Format((String)"select UPPER(name) as [PROCNAME] from dbo.sysobjects p where xtype='p'   and p.status>=0 and UPPER(name) LIKE '%1$s%%'  ", (Object)strProcPreFix);
        return strSQL;
    }

    public String GetSQL_DropFunc(String strFuncName) {
        String strSQL = StringHelper.Format((String)"drop FUNCTION [dbo].[%1$s]", (Object)strFuncName);
        return strSQL;
    }

    public String GetSQL_DropIndex(DBIndex dbIndex) {
        IDEHelper iDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(dbIndex.getDEID());
        String strSQL = StringHelper.Format((String)"DROP INDEX [%1$s] ON [dbo].[%2$s] WITH ( ONLINE = OFF )", (Object)dbIndex.getDBINDEXNAME(), (Object)iDEHelper.GetMainTable());
        return strSQL;
    }

    public String GetSQL_DropSequence(String strSequenceName) {
        return null;
    }

    public String GetSQL_DropTable(String strTableName) {
        String strSQL = StringHelper.Format((String)"DROP TABLE [dbo].[%1$s]", (Object)strTableName);
        return strSQL;
    }

    public String GetSQL_DropView(String strViewName) {
        String strSQL = StringHelper.Format((String)"DROP VIEW [dbo].[%1$s]", (Object)strViewName);
        return strSQL;
    }

    public String GetSQL_IsFuncExist(String strFuncName) {
        String strSQL = StringHelper.Format((String)"SELECT count(*) as [ROWCOUNT] FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[%1$s]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT')", (Object)strFuncName);
        return strSQL;
    }

    public String GetSQL_IsIndexExist(DBIndex dbIndex) {
        IDEHelper iDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(dbIndex.getDEID());
        String strSQL = StringHelper.Format((String)"SELECT count(*) as [ROWCOUNT] FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[%1$s]') AND name = N'%2$s'", (Object)iDEHelper.GetMainTable(), (Object)dbIndex.getDBINDEXNAME());
        return strSQL;
    }

    public String GetSQL_IsSequenceExist(String strSequenceName) {
        return null;
    }

    public String GetSQL_IsViewExist(String strViewName) {
        String strSQL = StringHelper.Format((String)"SELECT count(*) as [ROWCOUNT]  FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[%1$s]')", (Object)strViewName);
        return strSQL;
    }
}

