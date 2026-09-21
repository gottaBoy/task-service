/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DB2DEDataCtrlHelper
implements IDEDataCtrlHelper {
    protected ISRFDAGlobalHelper contextHelperEx;
    protected String strDBSCHEMA = "DB2ADMIN";
    private static final Log log = LogFactory.getLog(DB2DEDataCtrlHelper.class);
    protected IDBStorage iDBStorage = null;
    protected String strDBStorageId = "";

    @Override
    public boolean Init(ISRFDAGlobalHelper contextHelperEx, IDBStorage iDBStorage) {
        this.contextHelperEx = contextHelperEx;
        this.iDBStorage = iDBStorage;
        if (this.iDBStorage != null) {
            this.strDBSCHEMA = this.iDBStorage.GetDBSCHEMA();
            this.strDBStorageId = this.iDBStorage.GetId();
        } else {
            this.strDBSCHEMA = contextHelperEx.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
        }
        this.strDBSCHEMA = this.strDBSCHEMA.toUpperCase();
        return true;
    }

    @Override
    public String GetSQL_GetProcParams(String strProcName) {
        String strSQL = StringHelper.Format((String)"select PARMNAME as PARAMNAME,PARM_MODE as DIRECTION from SYSCAT.PROCPARMS where UPPER(PROCSCHEMA)='%1$s' and UPPER(PROCNAME)='%2$s'  order by ordinal", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_IsProcExist(String strProcName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.PROCEDURES where UPPER(PROCSCHEMA)='%1$s' and UPPER(PROCNAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_IsTableColumnExist(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.COLUMNS where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s' AND UPPER(COLNAME)='%3$s'", (Object)this.strDBSCHEMA, (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_GetTableColumnDataType(String strTableName, String strColumnName) {
        String strSQL = StringHelper.Format((String)"select TYPENAME,LENGTH,SCALE from syscat.COLUMNS where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s' AND UPPER(COLNAME)='%3$s'", (Object)this.strDBSCHEMA, (Object)strTableName.toUpperCase(), (Object)strColumnName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_DropProc(String strProcName) {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select *  from syscat.PROCEDURES where UPPER(PROCSCHEMA)='%1$s' and UPPER(PROCNAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.contextHelperEx, this.strDBStorageId, strSQL, dataEntity = new BaseDataEntity());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b58\u50a8\u8fc7\u7a0b[%1$s]\u4fe1\u606f\u5931\u8d25\uff0c%2$s", (Object)strProcName, (Object)callResult.getErrorInfo()));
            return "";
        }
        strSQL = StringHelper.Format((String)"DROP SPECIFIC PROCEDURE \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)dataEntity.GetParamValue("SPECIFICNAME"));
        return strSQL;
    }

    @Override
    public String GetSQL_IsTableExist(String strTableName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.TABLES where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strTableName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_DropTrigger(String strTriggerName) {
        String strSQL = StringHelper.Format((String)"DROP TRIGGER \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)strTriggerName);
        return strSQL;
    }

    @Override
    public String GetSQL_IsTriggerExist(String strTriggerName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.TRIGGERS where UPPER(TRIGSCHEMA)='%1$s' and UPPER(TRIGNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strTriggerName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_AutoGenProcs(String strProcPreFix) {
        String strSQL = StringHelper.Format((String)"select UPPER(PROCNAME) as PROCNAME from syscat.PROCEDURES where UPPER(PROCSCHEMA)='%1$s' and UPPER(PROCNAME) LIKE '%2$s%%'", (Object)this.strDBSCHEMA, (Object)strProcPreFix);
        return strSQL;
    }

    @Override
    public String GetSQL_DropFunc(String strFuncName) {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select *  from syscat.FUNCTIONS where UPPER(FUNCSCHEMA)='%1$s' and UPPER(FUNCNAME)='%2$s'", (Object)this.strDBSCHEMA, (Object)strFuncName.toUpperCase());
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.contextHelperEx, this.strDBStorageId, strSQL, dataEntity = new BaseDataEntity());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u51fd\u6570\u8fc7\u7a0b[%1$s]\u4fe1\u606f\u5931\u8d25\uff0c%2$s", (Object)strFuncName, (Object)callResult.getErrorInfo()));
            return "";
        }
        strSQL = StringHelper.Format((String)"DROP SPECIFIC FUNCTION \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)dataEntity.GetParamValue("SPECIFICNAME"));
        return strSQL;
    }

    @Override
    public String GetSQL_DropIndex(DBIndex dbIndex) {
        String strSQL = StringHelper.Format((String)"DROP INDEX \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)dbIndex.getDBINDEXNAME());
        return strSQL;
    }

    @Override
    public String GetSQL_DropSequence(String strSequenceName) {
        String strSQL = StringHelper.Format((String)"DROP SEQUENCE \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)strSequenceName);
        return strSQL;
    }

    @Override
    public String GetSQL_DropTable(String strTableName) {
        String strSQL = StringHelper.Format((String)"DROP TABLE \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)strTableName);
        return strSQL;
    }

    @Override
    public String GetSQL_DropView(String strViewName) {
        String strSQL = StringHelper.Format((String)"DROP VIEW \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)strViewName);
        return strSQL;
    }

    @Override
    public String GetSQL_IsFuncExist(String strFuncName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.FUNCTIONS where UPPER(FUNCSCHEMA)='%1$s' and UPPER(FUNCNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strFuncName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_IsIndexExist(DBIndex dbIndex) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.INDEXES where UPPER(INDSCHEMA)='%1$s' and UPPER(INDNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)dbIndex.getDBINDEXNAME().toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_IsSequenceExist(String strSequenceName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.SEQUENCES where UPPER(SEQSCHEMA)='%1$s' and UPPER(SEQNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strSequenceName.toUpperCase());
        return strSQL;
    }

    @Override
    public String GetSQL_IsViewExist(String strViewName) {
        String strSQL = StringHelper.Format((String)"select count(*) as ROWCOUNT from syscat.VIEWS where UPPER(VIEWSCHEMA)='%1$s' and UPPER(VIEWNAME)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strViewName.toUpperCase());
        return strSQL;
    }
}

