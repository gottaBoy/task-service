/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DBAction
 *  SA.SRFDA.Ctrl.Data.DBActionStep
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DBActionStep;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlServerDEHelper
extends BaseDEHelper {
    public static final String TAG_INSERTMODE_VERSION = "VERSION";
    public static final String TAG_UPDATEMODE_VERSION = "VERSION";
    public static final String TAG_PERSONID = "@SRF_PERSONID";
    public static final String TAG_RETCODE = "@SRF_RETCODE";
    public static final String TAG_RETINFO = "@SRF_RETINFO";
    public static final String TAG_TAG = "@SRF_TAG";
    public static final String TAG_VAR = "@VAR_";
    public static final String TAG_VAREX = "@VAREX_";
    public static final String TAG_VF = "@VF_";
    public static final String TAG_UNICODECHAR_PREFIX = "N";
    protected String strDBSCHEMA = "SAEAM3USR";
    private static final Log log = LogFactory.getLog(SqlServerDEHelper.class);
    protected boolean bDALog = true;
    protected boolean bUnicodeChar = false;

    public boolean Init(DataEntity dataEntity, IDAModelHelper iDAModelHelper, ISRFDAGlobalHelper contextHelperEx) {
        if (!super.Init(dataEntity, iDAModelHelper, contextHelperEx)) {
            return false;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.GetDBStorage())) {
            IDBStorage iDBStorage = contextHelperEx.getDAModelStorage().FindDBStorage(this.GetDBStorage());
            if (iDBStorage == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.GetDBStorage()));
                return false;
            }
            this.strDBSCHEMA = iDBStorage.GetDBSCHEMA();
            String strUnicodeChar = iDBStorage.GetProperty("UNICODECHAR");
            if (!StringHelper.IsNullOrEmpty((String)strUnicodeChar)) {
                this.bUnicodeChar = StringHelper.Compare((String)strUnicodeChar, (String)"TRUE", (boolean)true) == 0;
            }
        } else {
            this.strDBSCHEMA = contextHelperEx.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
            this.bUnicodeChar = contextHelperEx.getWebExConfig().GetValue("SRFDA.SQLSERVER", "UNICODECHAR", this.bUnicodeChar);
        }
        this.bDALog = this.OnGetDALog();
        return true;
    }

    protected boolean OnGetDALog() {
        return this.GetProperty("DALOG", StringHelper.IsNullOrEmpty((String)this.GetDBStorage()));
    }

    protected String OnGetDBType() {
        return "MSSQL";
    }

    public String GetInsertProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_INSERTPROC_HEADER(this.GetInsertProcName(), stringBuilder);
        this.APPEND_INSERTPROC_BODY(this.GetInsertProcName(), stringBuilder);
        return stringBuilder.toString();
    }

    public String GetUpdateProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_UPDATEPROC_HEADER(this.GetUpdateProcName(), stringBuilder);
        this.APPEND_UPDATEPROC_BODY(this.GetUpdateProcName(), stringBuilder);
        return stringBuilder.toString();
    }

    public String GetDeleteProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_DELETEPROC_HEADER(this.GetDeleteProcName(), stringBuilder);
        this.APPEND_DELETEPROC_BODY(this.GetDeleteProcName(), stringBuilder);
        return stringBuilder.toString();
    }

    protected void APPEND_INSERTPROC_HEADER(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("CREATE   PROCEDURE  %2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
        String strSystemParam = this.GETSQL_INSERTPROC_HEADER_SYSTEMPARAM();
        String strUserParam = this.GETSQL_INSERTPROC_HEADER_USERPARAM();
        if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
            stringBuilder.Append(strSystemParam);
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserParam)) {
            if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
                stringBuilder.Append(",\n");
            }
            stringBuilder.Append(strUserParam);
        }
        stringBuilder.Append("\n)\n");
    }

    protected void APPEND_UPDATEPROC_HEADER(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("CREATE  PROCEDURE  %2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
        String strSystemParam = this.GETSQL_UPDATEPROC_HEADER_SYSTEMPARAM();
        String strUserParam = this.GETSQL_UPDATEPROC_HEADER_USERPARAM();
        if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
            stringBuilder.Append(strSystemParam);
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserParam)) {
            if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
                stringBuilder.Append(",\n");
            }
            stringBuilder.Append(strUserParam);
        }
        stringBuilder.Append("\n)\n");
    }

    protected void APPEND_DELETEPROC_HEADER(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("CREATE  PROCEDURE  %2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
        String strSystemParam = this.GETSQL_DELETEPROC_HEADER_SYSTEMPARAM();
        String strUserParam = this.GETSQL_DELETEPROC_HEADER_USERPARAM();
        if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
            stringBuilder.Append(strSystemParam);
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserParam)) {
            if (!StringHelper.IsNullOrEmpty((String)strSystemParam)) {
                stringBuilder.Append(",\n");
            }
            stringBuilder.Append(strUserParam);
        }
        stringBuilder.Append("\n)\n");
    }

    protected String GETSQL_INSERTPROC_HEADER_SYSTEMPARAM() {
        return this.GetProcSystemParam(false);
    }

    protected String GETSQL_UPDATEPROC_HEADER_SYSTEMPARAM() {
        return this.GetProcSystemParam(false);
    }

    protected String GETSQL_DELETEPROC_HEADER_SYSTEMPARAM() {
        return this.GetProcSystemParam(true);
    }

    protected String GetProcSystemParam(boolean bDelete) {
        String strSystemParams = "";
        if (this.IsDBUnicodeChar()) {
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_PERSONID NVARCHAR(200),\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETCODE  INT output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFO NVARCHAR(200) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFORES NVARCHAR(200) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFORESARG NVARCHAR(500) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_TAG NVARCHAR(200) output,";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_ACTIONMODE NVARCHAR(200),\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_ACTIONARG NVARCHAR(200),\n";
            if (this.bDALog) {
                strSystemParams = String.valueOf(strSystemParams) + "@SRF_DALOG INT,\n";
            }
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_CHECKKEY INT ";
        } else {
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_PERSONID VARCHAR(200),\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETCODE  INT output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFO VARCHAR(200) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFORES VARCHAR(200) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_RETINFORESARG VARCHAR(500) output,\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_TAG VARCHAR(200) output,";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_ACTIONMODE VARCHAR(200),\n";
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_ACTIONARG VARCHAR(200),\n";
            if (this.bDALog) {
                strSystemParams = String.valueOf(strSystemParams) + "@SRF_DALOG INT,\n";
            }
            strSystemParams = String.valueOf(strSystemParams) + "@SRF_CHECKKEY INT ";
        }
        if (!bDelete) {
            strSystemParams = String.valueOf(strSystemParams) + ",\n@SRF_RETDATA INT";
        }
        return strSystemParams;
    }

    protected String GETSQL_INSERTPROC_HEADER_USERPARAM() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            String strSQLParam = this.GETSQL_INSERTPROC_HEADER_USERPARAM_ITEM(iDEFHelper);
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + ",\n";
            }
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            strSQL = String.valueOf(strSQL) + strSQLParam;
        }
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_HEADER_USERPARAM() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            String strSQLParam = this.GETSQL_UPDATEPROC_HEADER_USERPARAM_ITEM(iDEFHelper);
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + ",\n";
            }
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            strSQL = String.valueOf(strSQL) + strSQLParam;
        }
        return strSQL;
    }

    protected String GETSQL_DELETEPROC_HEADER_USERPARAM() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            String strSQLParam;
            if (!iDEFHelper.IsKeyDEField() || StringHelper.IsNullOrEmpty((String)(strSQLParam = this.GETSQL_DELETEPROC_HEADER_USERPARAM_ITEM(iDEFHelper)))) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + ",\n";
            }
            if (StringHelper.IsNullOrEmpty((String)strSQLParam)) continue;
            strSQL = String.valueOf(strSQL) + strSQLParam;
        }
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_HEADER_USERPARAM_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        if (!iDEFDTColumn.IsInsertProcParam()) {
            return "";
        }
        String strDBType = iDEFHelper.GetDTColumn().GetDBDataType(false, true, false, "");
        Integer nLength = iDEFHelper.GetDTColumn().GetLength();
        if (nLength == null || nLength == 0) {
            nLength = 200;
        }
        if (StringHelper.Compare((String)iDEFHelper.GetStdDataType(), (String)"VARCHAR", (boolean)true) == 0) {
            strDBType = this.IsDBUnicodeChar() ? "NVARCHAR(" + nLength.toString() + ")" : "VARCHAR(" + nLength.toString() + ")";
        }
        String strSQL = StringHelper.Format((String)"  %1$s%2$s %3$s", (Object)TAG_VAR, (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_HEADER_USERPARAM_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        if (!iDEFDTColumn.IsUpdateProcParam()) {
            return "";
        }
        String strDBType = iDEFHelper.GetDTColumn().GetDBDataType(false, true, false, "");
        Integer nLength = iDEFHelper.GetDTColumn().GetLength();
        if (nLength == null || nLength == 0) {
            nLength = 200;
        }
        if (StringHelper.Compare((String)iDEFHelper.GetStdDataType(), (String)"VARCHAR", (boolean)true) == 0) {
            strDBType = this.IsDBUnicodeChar() ? "NVARCHAR(" + nLength.toString() + ")" : "VARCHAR(" + nLength.toString() + ")";
        }
        String strSQL = StringHelper.Format((String)"  %1$s%2$s %3$s", (Object)TAG_VAR, (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        strSQL = String.valueOf(strSQL) + ",\n";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)" %1$s%2$s INT", (Object)TAG_VF, (Object)iDEFDTColumn.GetColumnName());
        return strSQL;
    }

    protected String GETSQL_DELETEPROC_HEADER_USERPARAM_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        String strDBType = iDEFHelper.GetDTColumn().GetDBDataType(false, true, false, "");
        Integer nLength = iDEFHelper.GetDTColumn().GetLength();
        if (nLength == null || nLength == 0) {
            nLength = 200;
        }
        if (StringHelper.Compare((String)iDEFHelper.GetStdDataType(), (String)"VARCHAR", (boolean)true) == 0) {
            strDBType = this.IsDBUnicodeChar() ? "NVARCHAR(" + nLength.toString() + ")" : "VARCHAR(" + nLength.toString() + ")";
        }
        String strSQL = StringHelper.Format((String)" %1$s%2$s %3$s", (Object)TAG_VAR, (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected void APPEND_INSERTPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("AS\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(" \n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_SYSTEMINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_CHECKISNOTNULL());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_INPUTCHECKS());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_BEFOREINSERT());
        stringBuilder.Append("\n");
        if (this.GetInheritDEHelper() != null) {
            stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_INSERT(true));
            stringBuilder.Append("\n");
        }
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_INSERT(false));
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_AFTERINSERT());
        stringBuilder.Append("\n");
        stringBuilder.Append("IF @SRF_RETDATA IS NULL OR @SRF_RETDATA = 1 \nbegin \n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_SELECT(true));
        stringBuilder.Append("\nend \n");
        stringBuilder.Append("IF @SRF_RETDATA IS NOT NULL AND @SRF_RETDATA = 0 \nbegin \n");
        stringBuilder.Append("SELECT @SRF_RETDATA\n");
        stringBuilder.Append("end \n");
        stringBuilder.Append(" set @SRF_RETCODE= 0\n");
        stringBuilder.Append(" set @SRF_RETINFO=''\n");
        stringBuilder.Append(" set @SRF_RETINFORES=''\n");
        stringBuilder.Append("EXIT_TAG: \nRETURN \n");
        stringBuilder.Append(" \n");
    }

    protected void APPEND_UPDATEPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("AS\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(" \n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_SYSTEMINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_CHECKEXISTING());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_INPUTCHECKS());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_BEFOREUPDATE());
        stringBuilder.Append("\n");
        boolean bHasMainDER1Ns = false;
        for (DER1N der1n : this.GetDER1Ns(true)) {
            if (!der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0) continue;
            bHasMainDER1Ns = true;
            break;
        }
        if (bHasMainDER1Ns) {
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_GETMAJORTEXT(true));
            stringBuilder.Append("\n");
        }
        if (this.GetInheritDEHelper() != null) {
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_UPDATE(true));
            stringBuilder.Append("\n");
        }
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_UPDATE(false));
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        if (bHasMainDER1Ns) {
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_GETMAJORTEXT(false));
            stringBuilder.Append("\n");
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_TESTMAJORTEXTCHANGED());
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("IF @SRF_RETDATA IS NULL OR @SRF_RETDATA = 1 \nbegin \n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_SELECT(false));
        stringBuilder.Append("\nend \n");
        stringBuilder.Append("IF @SRF_RETDATA IS NOT NULL AND @SRF_RETDATA = 0 \nbegin \n");
        stringBuilder.Append("SELECT @SRF_RETDATA\n");
        stringBuilder.Append("end \n");
        stringBuilder.Append(" set @SRF_RETCODE= 0\n");
        stringBuilder.Append(" set @SRF_RETINFO=''\n");
        stringBuilder.Append(" set @SRF_RETINFORES=''\n");
        stringBuilder.Append("EXIT_TAG: \nRETURN \n");
        stringBuilder.Append(" \n");
    }

    protected void APPEND_DELETEPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("AS\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(" \n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_SYSTEMINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_CHECKEXISTING());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_BEFOREDELETE());
        stringBuilder.Append("\n");
        IDEHelper inheritDEHelper = this.GetInheritDEHelper();
        if (inheritDEHelper != null) {
            if (inheritDEHelper.IsLogicValid()) {
                if (this.IsLogicValid()) {
                    stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(false));
                    stringBuilder.Append("\n");
                }
                stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(true));
                stringBuilder.Append("\n");
            } else if (this.IsLogicValid()) {
                stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(false));
                stringBuilder.Append("\n");
            } else {
                stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(false));
                stringBuilder.Append("\n");
                stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(true));
                stringBuilder.Append("\n");
            }
        } else {
            stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_DELETE(false));
            stringBuilder.Append("\n");
        }
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_AFTERDELETE());
        stringBuilder.Append("\n");
        stringBuilder.Append(" set @SRF_RETCODE= 0\n");
        stringBuilder.Append(" set @SRF_RETINFO=''\n");
        stringBuilder.Append(" set @SRF_RETINFORES=''\n");
        stringBuilder.Append("EXIT_TAG: \nRETURN \n");
        stringBuilder.Append(" \n");
    }

    protected String GETSQL_INSERTPROC_BODY_INSERT(boolean bInheritTable) {
        SqlServerDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
        String strMainTable = iDEHelper.GetMainTable();
        String strMinorDataTable = iDEHelper.getDataEntity().getMINORTABLENAME();
        String strUserDataTable = iDEHelper.GetUserTable();
        boolean bAppendMinor = false;
        boolean bAppendUser = false;
        if (!StringHelper.IsNullOrEmpty((String)strMinorDataTable) && StringHelper.Compare((String)strMinorDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendMinor = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserDataTable) && StringHelper.Compare((String)strUserDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendUser = true;
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_INSERTPROC_BODY_INSERTTABLE(stringBuilder, strMainTable, iDEHelper.IsLogicValid(), bInheritTable);
        if (bAppendMinor) {
            this.APPEND_INSERTPROC_BODY_INSERTTABLE(stringBuilder, strMinorDataTable, false, bInheritTable);
        }
        if (bAppendUser) {
            this.APPEND_INSERTPROC_BODY_INSERTTABLE(stringBuilder, strUserDataTable, false, bInheritTable);
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_UPDATE(boolean bInheritTable) {
        String strCondition;
        SqlServerDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
        String strMainTable = iDEHelper.GetMainTable();
        String strMinorDataTable = iDEHelper.getDataEntity().getMINORTABLENAME();
        String strUserDataTable = iDEHelper.GetUserTable();
        boolean bAppendMinor = false;
        boolean bAppendUser = false;
        if (!StringHelper.IsNullOrEmpty((String)strMinorDataTable) && StringHelper.Compare((String)strMinorDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendMinor = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserDataTable) && StringHelper.Compare((String)strUserDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendUser = true;
        }
        if (StringHelper.IsNullOrEmpty((String)(strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", bInheritTable)))) {
            log.error((Object)"\u66f4\u65b0\u8fc7\u7a0b\u6ca1\u6709\u83b7\u53d6\u952e\u503c");
            return "";
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_UPDATEPROC_BODY_UPDATETABLE(stringBuilder, strMainTable, strCondition, bInheritTable);
        if (bAppendMinor) {
            this.APPEND_UPDATEPROC_BODY_UPDATETABLE(stringBuilder, strMinorDataTable, strCondition, bInheritTable);
        }
        if (bAppendUser) {
            this.APPEND_UPDATEPROC_BODY_UPDATETABLE(stringBuilder, strUserDataTable, strCondition, bInheritTable);
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_DELETEPROC_BODY_DELETE(boolean bInheritTable) {
        String strCondition;
        SqlServerDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
        String strMainTable = iDEHelper.GetMainTable();
        String strMinorDataTable = iDEHelper.getDataEntity().getMINORTABLENAME();
        String strUserDataTable = iDEHelper.GetUserTable();
        boolean bAppendMinor = false;
        boolean bAppendUser = false;
        if (!StringHelper.IsNullOrEmpty((String)strMinorDataTable) && StringHelper.Compare((String)strMinorDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendMinor = true;
        }
        if (!StringHelper.IsNullOrEmpty((String)strUserDataTable) && StringHelper.Compare((String)strUserDataTable, (String)strMainTable, (boolean)true) != 0) {
            bAppendUser = true;
        }
        if (StringHelper.IsNullOrEmpty((String)(strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", bInheritTable)))) {
            log.error((Object)"\u66f4\u65b0\u8fc7\u7a0b\u6ca1\u6709\u83b7\u53d6\u952e\u503c");
            return "";
        }
        StringBuilderEx stringBuilder = new StringBuilderEx();
        if (!iDEHelper.IsLogicValid()) {
            if (bAppendUser) {
                this.APPEND_DELETEPROC_BODY_DELETETABLE(stringBuilder, strUserDataTable, strCondition, false);
            }
            if (bAppendMinor) {
                this.APPEND_DELETEPROC_BODY_DELETETABLE(stringBuilder, strMinorDataTable, strCondition, false);
            }
        }
        this.APPEND_DELETEPROC_BODY_DELETETABLE(stringBuilder, strMainTable, strCondition, iDEHelper.IsLogicValid());
        return stringBuilder.toString();
    }

    protected void GetTableInsertFields(String strTableName, TreeMap<String, String> fields, boolean bLogicEnable, boolean bInheritTable) {
        IDEFHelper iValidDEFHelper;
        IDEFHelper iDEFHelper2;
        SqlServerDEHelper iDEHelper = this;
        if (bInheritTable) {
            iDEHelper = this.GetInheritDEHelper();
        }
        for (IDEFHelper iDEFHelper2 : this.GetDEFHelpers()) {
            this.GetTableInsertField(strTableName, iDEFHelper2, fields, bInheritTable);
        }
        if (bLogicEnable && (iValidDEFHelper = iDEHelper.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
            fields.put(iValidDEFHelper.GetDTColumn().GetColumnName(), this.GetProperty("VALIDVALUE"));
        }
        if (bInheritTable) {
            try {
                iDEFHelper2 = iDEHelper.GetIndexTypeDEFHelper();
                Object objValue = iDEFHelper2.GetDEFValue(this.GetInheritDER().getTYPEVALUE());
                if (objValue instanceof String) {
                    fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), StringHelper.Format((String)"'%1$s'", (Object)objValue));
                } else {
                    fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), StringHelper.Format((String)"%1$s", (Object)objValue));
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7ee7\u627f\u5b9e\u4f53\u5173\u7cfb\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            }
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("CREATEMAN")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), TAG_PERSONID);
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("CREATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "@SRF_CURTIME");
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("UPDATEMAN")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), TAG_PERSONID);
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "@SRF_CURTIME");
        }
    }

    protected void GetTableUpdateFields(String strTableName, TreeMap<String, String> fields, boolean bInheritTable) {
        IDEFHelper iDEFHelper2;
        for (IDEFHelper iDEFHelper2 : this.GetDEFHelpers()) {
            if (iDEFHelper2.IsKeyDEField()) continue;
            this.GetTableUpdateField(strTableName, iDEFHelper2, fields, bInheritTable);
        }
        iDEFHelper2 = this.GetDEFHelperByPreDefineType("UPDATEMAN");
        if (iDEFHelper2 != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), TAG_PERSONID);
        }
        if ((iDEFHelper2 = this.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "@SRF_CURTIME");
        }
    }

    protected void GetTableInsertField(String strTableName, IDEFHelper iDEFHelper, TreeMap<String, String> fields, boolean bInheritTable) {
        IDEFDTColumn iDTColumn = null;
        if (bInheritTable) {
            if (!iDEFHelper.IsInheritDEField()) {
                return;
            }
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
            iDTColumn = inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn();
        } else {
            if (iDEFHelper.IsInheritDEField()) {
                return;
            }
            iDTColumn = iDEFHelper.GetDTColumn();
        }
        if (!iDTColumn.IsPKey()) {
            if (!StringHelper.IsNullOrEmpty((String)iDTColumn.GetTableName()) && StringHelper.Compare((String)iDTColumn.GetTableName(), (String)strTableName, (boolean)true) != 0) {
                return;
            }
            if (!iDTColumn.IsEnableInsert()) {
                return;
            }
        }
        fields.put(iDTColumn.GetColumnName().toUpperCase(), this.GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(iDEFHelper));
    }

    protected void GetTableUpdateField(String strTableName, IDEFHelper iDEFHelper, TreeMap<String, String> fields, boolean bInheritTable) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (bInheritTable) {
            if (!iDEFHelper.IsInheritDEField()) {
                return;
            }
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
            iDTColumn = inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn();
        } else {
            if (iDEFHelper.IsInheritDEField()) {
                return;
            }
            iDTColumn = iDEFHelper.GetDTColumn();
        }
        if (!iDTColumn.IsPKey() && !StringHelper.IsNullOrEmpty((String)iDTColumn.GetTableName()) && StringHelper.Compare((String)iDTColumn.GetTableName(), (String)strTableName, (boolean)true) != 0) {
            return;
        }
        if (!iDTColumn.IsEnableUpdate()) {
            return;
        }
        fields.put(iDTColumn.GetColumnName().toUpperCase(), this.GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(iDEFHelper, bInheritTable));
    }

    protected void APPEND_INSERTPROC_BODY_INSERTTABLE(StringBuilderEx stringBuilder, String strTableName, boolean bLogicEnable, boolean bInheritTable) {
        TreeMap<String, String> fields = new TreeMap<String, String>();
        this.GetTableInsertFields(strTableName, fields, bLogicEnable, bInheritTable);
        if (bInheritTable) {
            IDEHelper inheritDEHelper = this.GetInheritDEHelper();
            fields.put(inheritDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName().toUpperCase(), this.GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(this.GetKeyDEFHelper()));
            if (StringHelper.Compare((String)strTableName, (String)inheritDEHelper.GetMainTable(), (boolean)true) == 0 && this.GetMajorDEFHelper() != null && inheritDEHelper.GetMajorDEFHelper() != null && this.GetMajorDEFHelper().GetDTColumn().IsEnableInsert()) {
                fields.put(inheritDEHelper.GetMajorDEFHelper().GetDTColumn().GetColumnName().toUpperCase(), this.GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(this.GetMajorDEFHelper()));
            }
        }
        if (fields.size() == 0) {
            return;
        }
        stringBuilder.Append("INSERT INTO %1$s (\n", (Object)strTableName);
        boolean bFirstUpdate = true;
        for (String strParam : fields.keySet()) {
            if (!bFirstUpdate) {
                stringBuilder.Append(",");
            } else {
                bFirstUpdate = false;
            }
            stringBuilder.Append("[%1$s]\n", (Object)strParam);
        }
        stringBuilder.Append(")\n");
        stringBuilder.Append("VALUES\n(\n");
        bFirstUpdate = true;
        for (String strValue : fields.values()) {
            if (!bFirstUpdate) {
                stringBuilder.Append(",");
            } else {
                bFirstUpdate = false;
            }
            stringBuilder.Append("%1$s\n", (Object)strValue);
        }
        stringBuilder.Append(") \n");
    }

    protected void APPEND_UPDATEPROC_BODY_UPDATETABLE(StringBuilderEx stringBuilder, String strTableName, String strCondition, boolean bInheritTable) {
        IDEHelper inheritDEHelper;
        TreeMap<String, String> fields = new TreeMap<String, String>();
        this.GetTableUpdateFields(strTableName, fields, bInheritTable);
        if (bInheritTable && StringHelper.Compare((String)strTableName, (String)(inheritDEHelper = this.GetInheritDEHelper()).GetMainTable(), (boolean)true) == 0 && this.GetMajorDEFHelper() != null && inheritDEHelper.GetMajorDEFHelper() != null && this.GetMajorDEFHelper().GetDTColumn().IsEnableUpdate()) {
            fields.put(inheritDEHelper.GetMajorDEFHelper().GetDTColumn().GetColumnName().toUpperCase(), this.GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(this.GetMajorDEFHelper(), bInheritTable));
        }
        if (fields.size() == 0) {
            return;
        }
        stringBuilder.Append("UPDATE  %1$s SET \n", (Object)strTableName);
        boolean bFirstUpdate = true;
        for (String strParam : fields.keySet()) {
            if (!bFirstUpdate) {
                stringBuilder.Append("\n,");
            } else {
                bFirstUpdate = false;
            }
            stringBuilder.Append("[%1$s] = %2$s ", (Object)strParam, (Object)fields.get(strParam));
        }
        stringBuilder.Append("\n");
        stringBuilder.Append(" WHERE %1$s \n", (Object)strCondition);
    }

    protected void APPEND_DELETEPROC_BODY_DELETETABLE(StringBuilderEx stringBuilder, String strTableName, String strCondition, boolean bLogicEnable) {
        if (bLogicEnable) {
            IDEFHelper iDEFHelper;
            IDEFHelper iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iValidDEFHelper != null) {
                stringBuilder.Append("UPDATE  %1$s SET [%2$s]=%3$s \n", (Object)strTableName, (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("INVALIDVALUE"));
            }
            if ((iDEFHelper = this.GetDEFHelperByPreDefineType("UPDATEMAN")) != null) {
                stringBuilder.Append(",[%1$s]=@SRF_PERSONID \n", (Object)iDEFHelper.GetDTColumn().GetColumnName());
            }
            if ((iDEFHelper = this.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
                stringBuilder.Append(",[%1$s]=@SRF_CURTIME \n", (Object)iDEFHelper.GetDTColumn().GetColumnName());
            }
        } else {
            stringBuilder.Append("DELETE FROM %1$s ", (Object)strTableName);
        }
        stringBuilder.Append(" WHERE %1$s \n", (Object)strCondition);
    }

    protected String GETSQL_INSERTPROC_BODY_INPUTCHECKS() {
        String strViewName = this.GetDEViewName();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFHelper iValidDEFHelper;
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (iDTColumn.IsPKey()) {
                stringBuilder.Append("IF @SRF_CHECKKEY IS NULL OR @SRF_CHECKKEY = 1 \n begin \n");
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL \n begin \n", (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR), (Object)iDTColumn.GetColumnName());
                stringBuilder.Append("select @nTemp=count(*)   from %1$s where ", (Object)this.GetMainTable());
                stringBuilder.Append(" (%1$s = %2$s%1$s ) ", (Object)iDTColumn.GetColumnName(), (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR));
                stringBuilder.Append(" \n");
                stringBuilder.Append("IF @nTemp <> 0 \n begin \n");
                stringBuilder.Append(" set @SRF_RETCODE = %1$s \n", (Object)1007);
                stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append(" set @SRF_TAG = %2$s'%1$s' \n", (Object)iDTColumn.GetColumnName(), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append("GOTO EXIT_TAG \n");
                stringBuilder.Append("END  \n");
                stringBuilder.Append("END  \n");
                stringBuilder.Append("END  \n");
                stringBuilder.Append("\n");
                continue;
            }
            if (!iDEFHelper.IsDupCheck()) continue;
            IDEFHelper checkDupRangeDEFHelper = iDEFHelper.GetDupCheckRangeDEFHelper();
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL \n begin \n", (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR), (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL AND %4$s%3$s IS NOT NULL \n begin \n", (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR), (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)(checkDupRangeDEFHelper.GetDTColumn().IsValueAutoGen() ? TAG_VAREX : TAG_VAR));
            }
            stringBuilder.Append("select @nTemp=count(*)    from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (%1$s = %2$s%1$s ) ", (Object)iDTColumn.GetColumnName(), (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR));
            if (checkDupRangeDEFHelper != null) {
                stringBuilder.Append(" AND (%1$s = %2$s%1$s ) ", (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)(checkDupRangeDEFHelper.GetDTColumn().IsValueAutoGen() ? TAG_VAREX : TAG_VAR));
            }
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetDupCheckCode(true))) {
                stringBuilder.Append(" AND (%1$s) ", (Object)iDEFHelper.GetDupCheckCode(true));
            }
            stringBuilder.Append(" \n");
            stringBuilder.Append("IF @nTemp <> 0 \n begin \n");
            stringBuilder.Append(" set @SRF_RETCODE = %1$s \n", (Object)1007);
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append(" set @SRF_TAG = %2$s'%1$s' \n", (Object)iDTColumn.GetColumnName(), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            } else {
                stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"\u76f8\u540c%2$s\u4e2d\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName(""), (Object)checkDupRangeDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append(" set @SRF_TAG = %3$s'%1$s|%2$s' \n", (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.getLogicName(""), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            }
            stringBuilder.Append("GOTO EXIT_TAG\n");
            stringBuilder.Append("END \n");
            stringBuilder.Append("END \n");
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GetDBActionStepCode("INSERT", "INPUTCHECK"));
        return stringBuilder.toString();
    }

    protected String GETSQL_INSERTPROC_BODY_CHECKISNOTNULL() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableInsert() || iDTColumn.IsNullable()) continue;
            stringBuilder.Append("IF %1$s%2$s IS  NULL \nbegin\n", (Object)(iDTColumn.IsValueAutoGen() ? TAG_VAREX : TAG_VAR), (Object)iDTColumn.GetColumnName());
            stringBuilder.Append(" set @SRF_RETCODE = %1$s \n", (Object)1005);
            stringBuilder.Append(" set @SRF_TAG = %2$s'%1$s' \n", (Object)iDTColumn.GetColumnName(), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"%1$s\u4e0d\u80fd\u4e3a\u7a7a\u503c", (Object)iDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            stringBuilder.Append("GOTO EXIT_TAG\n");
            stringBuilder.Append("END  \n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_PROC_BODY_PKEYCONDITION(boolean bInsert, String strAlias, boolean bInheritTable) {
        String strCondition = "";
        if (bInheritTable) {
            IDEFHelper keyDEFHelper = this.GetInheritDEHelper().GetKeyDEFHelper();
            strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)keyDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, this.GetKeyDEFHelper())) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.[%1$s]=%2$s)", (Object)keyDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, this.GetKeyDEFHelper()), (Object)strAlias);
        } else {
            for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
                IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
                if (!iDTColumn.IsPKey()) continue;
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " AND ";
                }
                strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)iDTColumn.GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper)) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.[%1$s]=%2$s)", (Object)iDTColumn.GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper), (Object)strAlias);
            }
        }
        return strCondition;
    }

    protected String GETSQL_PROC_BODY_PKEYCONDITION(IDEHelper indexDEHelper, boolean bInsert, String strAlias) {
        String strCondition = "";
        IDEFHelper iDEFHelper = this.GetKeyDEFHelper();
        IDEFHelper curDEFHelper = indexDEHelper.GetKeyDEFHelper();
        strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)curDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper)) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.[%1$s]=%2$s)", (Object)curDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper), (Object)strAlias);
        return strCondition;
    }

    protected String GETSQL_UPDATEPROC_BODY_INPUTCHECKS() {
        IDEFHelper iValidDEFHelper;
        String strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false);
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c\uff0c\u65e0\u6cd5\u5904\u7406\u66f4\u65b0\u6570\u636e\u68c0\u67e5");
            return "";
        }
        String strViewName = this.getDataEntity().getVIEWNAME();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            if (!iDEFHelper.IsDupCheck()) continue;
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            IDEFHelper checkDupRangeDEFHelper = iDEFHelper.GetDupCheckRangeDEFHelper();
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL \n begin \n", (Object)TAG_VAR, (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL AND %1$s%3$s IS NOT NULL \n begin \n", (Object)TAG_VAR, (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName());
            }
            stringBuilder.Append("select @nTemp=count(*)  from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (%1$s = %2$s%1$s ) ", (Object)iDTColumn.GetColumnName(), (Object)TAG_VAR);
            if (checkDupRangeDEFHelper != null) {
                stringBuilder.Append(" AND (%1$s = %2$s%1$s ) ", (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)TAG_VAR);
            }
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetDupCheckCode(false))) {
                stringBuilder.Append(" AND (%1$s) ", (Object)iDEFHelper.GetDupCheckCode(false));
            }
            stringBuilder.Append(" AND NOT(%1$s) ", (Object)strCondition);
            stringBuilder.Append(" \n");
            stringBuilder.Append("IF @nTemp <> 0 \nbegin\n");
            stringBuilder.Append(" set @SRF_RETCODE = %1$s \n", (Object)1007);
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append(" set @SRF_TAG = %2$s'%1$s' \n", (Object)iDTColumn.GetColumnName(), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            } else {
                stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)StringHelper.Format((String)"\u76f8\u540c%2$s\u4e2d\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName(""), (Object)checkDupRangeDEFHelper.getLogicName("")), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
                stringBuilder.Append(" set @SRF_TAG = %3$s'%1$s|%2$s' \n", (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.getLogicName(""), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            }
            stringBuilder.Append("GOTO EXIT_TAG\n");
            stringBuilder.Append("END ;\n");
            stringBuilder.Append("END ;\n");
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GetDBActionStepCode("UPDATE", "INPUTCHECK"));
        Vector dbActions = new Vector();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBActions(this.getId(), this.GetDBType(), "UPDATE", dbActions);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u6a21\u5f0f\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        for (DBAction dbAction : dbActions) {
            if (StringHelper.IsNullOrEmpty((String)dbAction.getCHECKCOND())) continue;
            stringBuilder.Append("\n");
            stringBuilder.Append("IF UPPER(SRF_ACTIONMODE)='%1$s' \nbegin\n", (Object)dbAction.getACTIONMODE().toUpperCase());
            stringBuilder.Append("select @nTemp=count(*)   from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (%1$s) ", (Object)strCondition);
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            stringBuilder.Append(" AND NOT (%1$s) ", (Object)dbAction.getCHECKCOND());
            stringBuilder.Append(" \n");
            stringBuilder.Append("IF @nTemp <> 0 \nbegin\n");
            stringBuilder.Append("SET @SRF_RETCODE = %1$s  \n", (Object)dbAction.getERRORCODE());
            stringBuilder.Append("SET @SRF_RETINFO= %2$s'%1$s' \n", (Object)dbAction.getERRORINFO(), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
            stringBuilder.Append("GOTO EXIT_TAG \n");
            stringBuilder.Append("END   \n");
            stringBuilder.Append("END   \n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_CHECKEXISTING() {
        return this.GetCheckExistingCode(true);
    }

    protected String GETSQL_UPDATEPROC_BODY_GETMAJORTEXT(boolean bOld) {
        IDEFHelper iValidDEFHelper;
        String strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false);
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c\uff0c\u65e0\u6cd5\u5904\u7406\u66f4\u65b0\u6570\u636e\u68c0\u67e5");
            return "";
        }
        String strViewName = this.getDataEntity().getVIEWNAME();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strParamName = bOld ? "@strLastName" : "@strCurName";
        stringBuilder.Append("if %1$s%2$s = 1 \nbegin\n", (Object)TAG_VF, (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName());
        stringBuilder.Append("select %2$s=%1$s  from %3$s where ", (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName(), (Object)strParamName, (Object)strViewName);
        stringBuilder.Append(" (%1$s) ", (Object)strCondition);
        if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
            stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
        }
        stringBuilder.Append("\n");
        stringBuilder.Append("END \n");
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_TESTMAJORTEXTCHANGED() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append("if %1$s%2$s = 1 AND @strLastName <> @strCurName \nbegin\n", (Object)TAG_VF, (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName());
        for (DER1N der1n : this.GetDER1Ns(true)) {
            IDEFHelper iValidDEFHelper;
            if (!der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0) continue;
            IDEHelper iMinorDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(der1n.getMINORDEID());
            if (iMinorDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getMINORDEID()));
                continue;
            }
            IPickupDEFHelper pickupDEFHelper = iMinorDEHelper.FindPickupDEFHelper(der1n.getDERID());
            if (pickupDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6DER1N[%1$s]\u62fe\u53d6\u5c5e\u6027\u8f85\u52a9\u5bf9\u8c61", (Object)der1n.getDERID()));
                continue;
            }
            stringBuilder.Append("UPDATE %1$s SET %2$s=@strCurName WHERE %3$s=%4$s ", (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)pickupDEFHelper.GetPickupTextDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(false, this.GetKeyDEFHelper()));
            if (iMinorDEHelper.IsLogicValid() && (iValidDEFHelper = iMinorDEHelper.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                if (StringHelper.Compare((String)iValidDEFHelper.GetDTColumn().GetTableName(), (String)pickupDEFHelper.GetDTColumn().GetTableName(), (boolean)true) == 0) {
                    stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                } else {
                    stringBuilder.Append("AND exists(SELECT * from %1$s WHERE %1$s.%2$s = %3$s.%2$s AND %1$s.%4$s=%5$s) ", (Object)iValidDEFHelper.GetDTColumn().GetTableName(), (Object)iMinorDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                }
            }
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("end\n");
        return stringBuilder.toString();
    }

    protected String GETSQL_DELETEPROC_BODY_CHECKEXISTING() {
        return this.GetCheckExistingCode(false);
    }

    protected String GetCheckExistingCode(boolean bUpdate) {
        IDEFHelper iValidDEFHelper;
        String strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false);
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c\uff0c\u65e0\u6cd5\u5904\u7406\u66f4\u65b0\u6570\u636e\u68c0\u67e5");
            return "";
        }
        String strViewName = this.getDataEntity().getVIEWNAME();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append("IF @SRF_CHECKKEY IS NULL OR @SRF_CHECKKEY = 1 \nbegin\n");
        stringBuilder.Append(" select @nTemp=count(*)  from %1$s where ", (Object)strViewName);
        stringBuilder.Append(" (%1$s) ", (Object)strCondition);
        if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
            stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
        }
        stringBuilder.Append(" \n");
        stringBuilder.Append("IF @nTemp = 0 \nbegin\n");
        stringBuilder.Append(" set @SRF_RETCODE = %1$s \n", (Object)1003);
        stringBuilder.Append(" set @SRF_RETINFO = %2$s'%1$s' \n", (Object)(bUpdate ? "\u6307\u5b9a\u7684\u66f4\u65b0\u6570\u636e\u4e0d\u5b58\u5728" : "\u6307\u5b9a\u7684\u5220\u9664\u6570\u636e\u4e0d\u5b58\u5728"), (Object)(this.IsDBUnicodeChar() ? TAG_UNICODECHAR_PREFIX : ""));
        stringBuilder.Append("GOTO EXIT_TAG\n");
        stringBuilder.Append("END \n");
        stringBuilder.Append("END \n");
        return stringBuilder.toString();
    }

    protected String GETSQL_INSERTPROC_BODY_SYSTEMDECLARE() {
        return this.GetProcSystemDeclare();
    }

    protected String GETSQL_UPDATEPROC_BODY_SYSTEMDECLARE() {
        String strOld = this.GetProcSystemDeclare();
        strOld = String.valueOf(strOld) + "\n";
        if (this.IsDBUnicodeChar()) {
            strOld = String.valueOf(strOld) + "declare @strLastName NVARCHAR(200)\n";
            strOld = String.valueOf(strOld) + "declare @strCurName NVARCHAR(200)\n";
        } else {
            strOld = String.valueOf(strOld) + "declare @strLastName VARCHAR(200)\n";
            strOld = String.valueOf(strOld) + "declare @strCurName VARCHAR(200)\n";
        }
        return strOld;
    }

    protected String GETSQL_DELETEPROC_BODY_SYSTEMDECLARE() {
        return this.GetProcSystemDeclare();
    }

    protected String GetProcSystemDeclare() {
        String strSystemDeclare = "declare @nTemp INT \n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "declare @SRF_CURTIME datetime";
        return strSystemDeclare;
    }

    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableInsert() || !iDTColumn.IsValueAutoGen()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.GETSQL_INSERTPROC_BODY_USERDECLARE_ITEM(iDEFHelper);
        }
        strSQL = String.valueOf(strSQL) + this.GetDBActionStepCode("INSERT", "USERDECLARE");
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        return this.GetDBActionStepCode("UPDATE", "USERDECLARE");
    }

    protected String GETSQL_DELETEPROC_BODY_USERDECLARE() {
        return this.GetDBActionStepCode("DELETE", "USERDECLARE");
    }

    protected String GETSQL_INSERTPROC_BODY_USERDECLARE_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        String strDBType = iDTColumn.GetDBDataType(false, false, false, "");
        String strSQL = StringHelper.Format((String)"declare %1$s%2$s %3$s", (Object)TAG_VAREX, (Object)iDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_SYSTEMINIT() {
        return this.GetProcSystemInit();
    }

    protected String GETSQL_UPDATEPROC_BODY_SYSTEMINIT() {
        return this.GetProcSystemInit();
    }

    protected String GETSQL_DELETEPROC_BODY_SYSTEMINIT() {
        return this.GetProcSystemInit();
    }

    protected String GetProcSystemInit() {
        String strSQL = "";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET @SRF_CURTIME=getdate() \n");
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_USERINIT() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableInsert() || !iDTColumn.IsValueAutoGen()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.GETSQL_INSERTPROC_BODY_USERINIT_ITEM(iDEFHelper);
        }
        strSQL = String.valueOf(strSQL) + "\n";
        strSQL = String.valueOf(strSQL) + this.GetDBActionStepCode("INSERT", "USERINIT");
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_BODY_USERINIT() {
        return this.GetDBActionStepCode("UPDATE", "USERINIT");
    }

    protected String GETSQL_DELETEPROC_BODY_USERINIT() {
        return this.GetDBActionStepCode("DELETE", "USERINIT");
    }

    protected String GETSQL_INSERTPROC_BODY_BEFOREINSERT() {
        return this.GetDBActionStepCode("INSERT", "BEFOREACTION");
    }

    protected String GETSQL_UPDATEPROC_BODY_BEFOREUPDATE() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append(this.GetDBActionStepCode("UPDATE", "BEFOREACTION"));
        return script.toString();
    }

    protected String GETSQL_DELETEPROC_BODY_BEFOREDELETE() {
        return this.GetDBActionStepCode("DELETE", "BEFOREACTION");
    }

    protected String GETSQL_PROC_BODY_SELECT(boolean bInsert) {
        String strSQL = StringHelper.Format((String)"select m1.* from %1$s m1 ", (Object)this.GetDEViewName());
        String strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(bInsert, "m1", false);
        if (this.IsLogicValid()) {
            IDEFHelper iValidDEFHelper;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            if ((iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s] = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_USERINIT_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (iDTColumn.IsValueAutoGen()) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.Append("IF %1$s%2$s IS NOT NULL \nbegin\n", (Object)TAG_VAR, (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append(" set %1$s%2$s = %3$s%2$s \n", (Object)TAG_VAREX, (Object)iDTColumn.GetColumnName(), (Object)TAG_VAR);
            stringBuilderEx.Append(" end \n ELSE\nbegin\n", (Object)TAG_VAREX, (Object)iDTColumn.GetColumnName(), (Object)TAG_VAR);
            String strValueGenFunc = iDTColumn.GetValueGenFunc();
            stringBuilderEx.Append(" set %1$s%2$s = %3$s \n", (Object)TAG_VAREX, (Object)iDTColumn.GetColumnName(), (Object)strValueGenFunc);
            stringBuilderEx.Append("END  \n", (Object)TAG_VF, (Object)iDTColumn.GetColumnName());
            return stringBuilderEx.toString();
        }
        return "";
    }

    protected String GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        return this.GETFIELDPARAMNAME(true, iDTColumn);
    }

    protected String GETFIELDPARAMNAME(boolean bInsert, IDEFDTColumn iDTColumn) {
        if (iDTColumn.IsValueAutoGen() && bInsert) {
            return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAREX, (Object)iDTColumn.GetColumnName());
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAR, (Object)iDTColumn.GetColumnName());
    }

    protected String GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (StringHelper.Compare((String)"VERSION", (String)iDTColumn.GetUpdateMode(), (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE %3$s + 1 END", (Object)TAG_VF, (Object)TAG_VAR, (Object)iDTColumn.GetColumnName());
        }
        return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE %3$s END", (Object)TAG_VF, (Object)TAG_VAR, (Object)iDTColumn.GetColumnName());
    }

    protected String GETSQL_UPDATEPROC_BODY_UPDATETABLE_FIELDVALUE(IDEFHelper iDEFHelper, boolean bInheritMode) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        String strOriginName = iDTColumn.GetColumnName();
        if (bInheritMode) {
            if (iDEFHelper.IsMajorDEField()) {
                strOriginName = this.GetInheritDEHelper().GetMajorDEFHelper().GetDTColumn().GetColumnName();
            } else if (iDEFHelper.IsInheritDEField()) {
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                strOriginName = inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn().GetColumnName();
            }
        }
        if (StringHelper.Compare((String)"VERSION", (String)iDTColumn.GetUpdateMode(), (boolean)true) == 0) {
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE [%4$s] + 1 END", (Object)TAG_VF, (Object)TAG_VAR, (Object)iDTColumn.GetColumnName(), (Object)strOriginName);
        }
        return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE [%4$s] END", (Object)TAG_VF, (Object)TAG_VAR, (Object)iDTColumn.GetColumnName(), (Object)strOriginName);
    }

    protected String GETSQL_PROC_BODY_PKEYFIELDVALUE(boolean bInsert, IDEFHelper iDEFHelper) {
        if (bInsert && iDEFHelper.GetDTColumn().IsValueAutoGen()) {
            return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAREX, (Object)iDEFHelper.GetDTColumn().GetColumnName());
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)TAG_VAR, (Object)iDEFHelper.GetDTColumn().GetColumnName());
    }

    public String GetCheckKeyCode(Vector<ProcParam> procParams) {
        String strSQL = "";
        if (this.IsLogicValid()) {
            IDEFHelper logicDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID");
            strSQL = StringHelper.Format((String)"select m1.[%2$s],m1.[%3$s] from %1$s m1 ", (Object)this.GetMainTable(), (Object)this.GetKeyDEFHelper().getName(), (Object)logicDEFHelper.getName());
        } else {
            strSQL = StringHelper.Format((String)"select m1.[%2$s] from %1$s m1 ", (Object)this.GetMainTable(), (Object)this.GetKeyDEFHelper().getName());
        }
        String strCondition = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsPKey()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s]=?)", (Object)iDTColumn.GetColumnName());
            ProcParam procParam = new ProcParam();
            procParam.SetParamValue("PARAMNAME", (Object)iDTColumn.GetColumnName());
            procParams.add(procParam);
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    public String GetSelectCode(Vector<ProcParam> procParams) {
        String strSQL = StringHelper.Format((String)"select m1.* from %1$s m1 ", (Object)this.GetDEViewName());
        String strCondition = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsPKey()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s]=?)", (Object)iDTColumn.GetColumnName());
            ProcParam procParam = new ProcParam();
            procParam.SetParamValue("PARAMNAME", (Object)iDTColumn.GetColumnName());
            procParams.add(procParam);
        }
        if (this.IsLogicValid()) {
            IDEFHelper iValidDEFHelper;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            if ((iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s] = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    public String GetSelectCode(BaseDataEntity dataEntity, Vector<ProcParam> procParams) {
        if (dataEntity.getParamList() == null) {
            return "";
        }
        String strSQL = StringHelper.Format((String)"select m1.* from %1$s m1 ", (Object)this.GetDEViewName());
        String strCondition = "";
        for (Object objKey : dataEntity.getParamList().keySet()) {
            String strKey = objKey.toString();
            IDEFHelper iDEFHelper = this.GetDEFHelper(strKey);
            if (iDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)this.GetFullName(), (Object)strKey));
                return "";
            }
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s]=?)", (Object)iDTColumn.GetColumnName());
            ProcParam procParam = new ProcParam();
            procParam.SetParamValue("PARAMNAME", (Object)iDTColumn.GetColumnName());
            procParams.add(procParam);
        }
        if (this.IsLogicValid()) {
            IDEFHelper iValidDEFHelper;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            if ((iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.[%1$s] = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        stringBuilder.Append(this.GetDBActionStepCode("INSERT", "AFTERACTION"));
        if (this.bDALog) {
            stringBuilder.Append("IF @SRF_DALOG IS NULL OR @SRF_DALOG = 1 \n begin \n");
            if (DataTypeHelper.IsStringType((String)this.GetKeyDEFHelper().GetStdDataType())) {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',%2$s,'CREATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(true), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else if (this.IsDBUnicodeChar()) {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as nvarchar ),'CREATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(true), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as varchar ),'CREATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(true), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            }
            stringBuilder.Append("END  \n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String str = this.GetDBActionStepCode("UPDATE", "AFTERACTION");
        stringBuilder.Append(str);
        if (this.bDALog) {
            stringBuilder.Append("IF @SRF_DALOG IS NULL OR @SRF_DALOG = 1 \n begin \n");
            if (DataTypeHelper.IsStringType((String)this.GetKeyDEFHelper().GetStdDataType())) {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',%2$s,'UPDATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else if (this.IsDBUnicodeChar()) {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as nvarchar ),'UPDATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else {
                stringBuilder.Append(" EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as varchar ),'UPDATE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            }
            stringBuilder.Append("END  \n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_DELETEPROC_BODY_AFTERDELETE() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String str = this.GetDBActionStepCode("DELETE", "AFTERACTION");
        stringBuilder.Append(str);
        if (this.bDALog) {
            stringBuilder.Append("IF @SRF_DALOG IS NULL OR @SRF_DALOG = 1 \n begin \n");
            if (DataTypeHelper.IsStringType((String)this.GetKeyDEFHelper().GetStdDataType())) {
                stringBuilder.Append("EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',%2$s,'DELETE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else if (this.IsDBUnicodeChar()) {
                stringBuilder.Append("EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as nvarchar),'DELETE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            } else {
                stringBuilder.Append("EXEC SP_DALOG_LOG @SRF_PERSONID,%3$s,'%1$s',cast(%2$s as varchar),'DELETE',%4$s  \n", (Object)this.GetDALOGObjectType(), (Object)this.GetDALOGObjectIdParam(false), (Object)this.GetDALOGEventName(), (Object)this.GetDALOGEventInfo());
            }
            stringBuilder.Append("END  \n");
        }
        return stringBuilder.toString();
    }

    protected String GetDALOGObjectType() {
        return this.getId().toUpperCase();
    }

    protected String GetDALOGObjectIdParam(boolean bInsert) {
        return this.GETFIELDPARAMNAME(bInsert, this.GetKeyDEFHelper().GetDTColumn());
    }

    protected String GetDALOGEventName() {
        return StringHelper.Format((String)"'%1$s'", (Object)this.getName());
    }

    public String GetDeleteProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_D%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.OnGetDBVersion());
    }

    public String GetInsertProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_I%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.OnGetDBVersion());
    }

    public String GetUpdateProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_U%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.OnGetDBVersion());
    }

    protected String GetDALOGEventInfo() {
        return "@SRF_ACTIONMODE";
    }

    protected String GetDBActionStepCode(String strAction, String strActionStep) {
        Vector dbActionSteps = new Vector();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBActionSteps(this.getId(), this.GetDBType(), strAction, strActionStep, dbActionSteps);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u6b65\u9aa4\u9644\u52a0\u4ee3\u7801\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        if (dbActionSteps.size() == 0) {
            return "";
        }
        StringBuilderEx dbActionCode = new StringBuilderEx();
        for (DBActionStep dbActionStep : dbActionSteps) {
            String strActionCode = dbActionStep.getACTIONCODE();
            if (StringHelper.IsNullOrEmpty((String)strActionCode)) continue;
            strActionCode = strActionCode.replace("\r\n", "\n");
            strActionCode = strActionCode.replace("\r", "\n");
            strActionCode = String.valueOf(strActionCode) + "\n\n";
            dbActionCode.Append(strActionCode);
        }
        return dbActionCode.toString();
    }

    protected String GetPreFixProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_", (Object)"SRFP_", (Object)strDENAME).toUpperCase();
    }

    public String GetDBSchema() {
        return this.strDBSCHEMA;
    }

    public boolean IsDBUnicodeChar() {
        return this.bUnicodeChar;
    }
}

