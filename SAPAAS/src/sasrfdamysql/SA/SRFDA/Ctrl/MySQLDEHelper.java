/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DBAction
 *  SA.SRFDA.Ctrl.Data.DBActionStep
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDBStorage
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DBActionStep;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MySQLDEHelper
extends BaseDEHelper {
    public static final String TAG_INSERTMODE_VERSION = "VERSION";
    public static final String TAG_UPDATEMODE_VERSION = "VERSION";
    protected String strDBSCHEMA = "satest";
    private static final Log log = LogFactory.getLog(MySQLDEHelper.class);
    protected boolean bDALog = true;

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
        } else {
            this.strDBSCHEMA = contextHelperEx.getWebExConfig().GetValue("SRFDA", "DBSCHEMA", this.strDBSCHEMA);
        }
        this.bDALog = this.OnGetDALog();
        return true;
    }

    protected boolean OnGetDALog() {
        return this.GetProperty("DALOG", true);
    }

    protected String OnGetDBType() {
        return "MYSQL";
    }

    public String GetInsertProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_INSERTPROC_HEADER(this.GetInsertProcName(), stringBuilder);
        this.APPEND_INSERTPROC_BODY(this.GetInsertProcName(), stringBuilder);
        System.out.println("--------------");
        System.out.println(stringBuilder.toString());
        System.out.println("--------------");
        return stringBuilder.toString();
    }

    public String GetUpdateProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_UPDATEPROC_HEADER(this.GetUpdateProcName(), stringBuilder);
        this.APPEND_UPDATEPROC_BODY(this.GetUpdateProcName(), stringBuilder);
        System.out.println("--------------");
        System.out.println(stringBuilder.toString());
        System.out.println("--------------");
        return stringBuilder.toString();
    }

    public String GetDeleteProcCode() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        this.APPEND_DELETEPROC_HEADER(this.GetDeleteProcName(), stringBuilder);
        this.APPEND_DELETEPROC_BODY(this.GetDeleteProcName(), stringBuilder);
        return stringBuilder.toString();
    }

    protected void APPEND_INSERTPROC_HEADER(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("CREATE PROCEDURE %1$s.%2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
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
        stringBuilder.Append("CREATE PROCEDURE  %1$s.%2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
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
        stringBuilder.Append("CREATE PROCEDURE  %1$s.%2$s (\n", (Object)this.strDBSCHEMA, (Object)strProcName);
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
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_PERSONID VARCHAR(60),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETCODE INT,\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFO VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFORES  VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_RETINFORESARG  VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "OUT SRF_TAG VARCHAR(1000),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ACTIONMODE VARCHAR(100),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_ACTIONARG VARCHAR(100),\n";
        strSystemParams = String.valueOf(strSystemParams) + "IN SRF_CHECKKEY INT";
        if (!bDelete) {
            strSystemParams = String.valueOf(strSystemParams) + ",\nIN SRF_RETDATA INT";
        }
        return strSystemParams;
    }

    protected String GETSQL_INSERTPROC_HEADER_USERPARAM() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            String strSQLParam = this.GETSQL_INSERTPROC_HEADER_USERPARAM_ITEM(iDEFHelper);
            if (StringHelper.IsNullOrEmpty((String)(strSQLParam = strSQLParam.trim()))) continue;
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
            if (StringHelper.IsNullOrEmpty((String)(strSQLParam = strSQLParam.trim()))) continue;
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
            if (!iDEFHelper.IsKeyDEField()) continue;
            String strSQLParam = this.GETSQL_DELETEPROC_HEADER_USERPARAM_ITEM(iDEFHelper);
            if (StringHelper.IsNullOrEmpty((String)(strSQLParam = strSQLParam.trim()))) continue;
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
        String strSQL = StringHelper.Format((String)"IN %1$s%2$s %3$s", (Object)"VAR_", (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_HEADER_USERPARAM_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        if (!iDEFDTColumn.IsUpdateProcParam()) {
            return "";
        }
        String strDBType = iDEFHelper.GetDTColumn().GetDBDataType(false, true, false, "");
        String strSQL = StringHelper.Format((String)"IN %1$s%2$s %3$s", (Object)"VAR_", (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        strSQL = String.valueOf(strSQL) + ",\n";
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"IN %1$s%2$s INT", (Object)"VF_", (Object)iDEFDTColumn.GetColumnName());
        return strSQL;
    }

    protected String GETSQL_DELETEPROC_HEADER_USERPARAM_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDEFDTColumn = iDEFHelper.GetDTColumn();
        String strDBType = iDEFHelper.GetDTColumn().GetDBDataType(false, true, false, "");
        String strSQL = StringHelper.Format((String)"IN %1$s%2$s %3$s", (Object)"VAR_", (Object)iDEFDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected void APPEND_INSERTPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("SRFBODY:\nBEGIN\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_INSERTPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
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
        stringBuilder.Append("IF SRF_RETDATA IS NULL OR SRF_RETDATA = 1 THEN \n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_SELECT(true));
        stringBuilder.Append(";\n");
        stringBuilder.Append("END IF; \n");
        stringBuilder.Append("SET SRF_RETCODE= 0;\n");
        stringBuilder.Append("SET SRF_RETINFO='';\n");
        stringBuilder.Append("SET SRF_RETINFORES='';\n");
        stringBuilder.Append("END SRFBODY;\n");
    }

    protected void APPEND_UPDATEPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("SRFBODY:\nBEGIN\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_SYSTEMINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_USERINIT());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_CHECKEXISTING());
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
        if (bHasMainDER1Ns) {
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_GETMAJORTEXT(false));
            stringBuilder.Append("\n");
            stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_TESTMAJORTEXTCHANGED());
            stringBuilder.Append("\n");
        }
        stringBuilder.Append(this.GETSQL_UPDATEPROC_BODY_AFTERUPDATE());
        stringBuilder.Append("\n");
        stringBuilder.Append("IF SRF_RETDATA IS NULL OR SRF_RETDATA = 1 THEN \n");
        stringBuilder.Append(this.GETSQL_PROC_BODY_SELECT(false));
        stringBuilder.Append(";\n");
        stringBuilder.Append("END IF; \n");
        stringBuilder.Append("SET SRF_RETCODE= 0;\n");
        stringBuilder.Append("SET SRF_RETINFO='';\n");
        stringBuilder.Append("SET SRF_RETINFORES='';\n");
        stringBuilder.Append("END SRFBODY;\n");
    }

    protected String GETSQL_UPDATEPROC_BODY_GETMAJORTEXT(boolean bOld) {
        IDEFHelper iValidDEFHelper;
        String strParamName;
        String strCondition = this.GETSQL_PROC_BODY_PKEYCONDITION(false, "", false);
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            log.error((Object)"\u6ca1\u6709\u6307\u5b9a\u952e\u503c\uff0c\u65e0\u6cd5\u5904\u7406\u66f4\u65b0\u6570\u636e\u68c0\u67e5");
            return "";
        }
        String strViewName = this.getDataEntity().getVIEWNAME();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String string = strParamName = bOld ? "strLastName" : "strCurName";
        if (this.GetMajorDEFHelper().IsFormulaDEField()) {
            stringBuilder.Append("if 1 = 1 THEN\n");
        } else {
            stringBuilder.Append("if %1$s%2$s = 1 THEN\n", (Object)"VF_", (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName());
        }
        stringBuilder.Append("select %1$s into %2$s from %3$s where ", (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName(), (Object)strParamName, (Object)strViewName);
        stringBuilder.Append(" (%1$s) ", (Object)strCondition);
        if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
            stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
        }
        stringBuilder.Append(";\n");
        stringBuilder.Append("END IF;\n");
        HashMap<String, String> physicalFieldMap = new HashMap<String, String>();
        for (DER1N der1n : this.GetDER1Ns(true)) {
            if (!der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) continue;
            IDEFHelper iDEFHelper = this.GetDEFHelper(der1n.getRELATEDTEXTDEFID());
            physicalFieldMap.put(iDEFHelper.getId(), iDEFHelper.GetDTColumn().GetColumnName());
        }
        for (String strDEFieldId : physicalFieldMap.keySet()) {
            IDEFHelper iValidDEFHelper2;
            String strColumnName = (String)physicalFieldMap.get(strDEFieldId);
            String strParamName2 = StringHelper.Format((String)(bOld ? "strLast%1$s" : "strCur%1$s"), (Object)strColumnName);
            IDEFHelper iDEFHelper = this.GetDEFHelper(strDEFieldId);
            if (iDEFHelper.IsFormulaDEField()) {
                stringBuilder.Append("if 1 = 1 THEN\n");
            } else {
                stringBuilder.Append("if %1$s%2$s = 1 THEN\n", (Object)"VF_", (Object)iDEFHelper.GetDTColumn().GetColumnName());
            }
            stringBuilder.Append("select %1$s into %2$s from %3$s where ", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)strParamName2, (Object)strViewName);
            stringBuilder.Append(" (%1$s) ", (Object)strCondition);
            if (this.IsLogicValid() && (iValidDEFHelper2 = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper2.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            stringBuilder.Append(";\n");
            stringBuilder.Append("END IF;\n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_TESTMAJORTEXTCHANGED() {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        if (this.GetMajorDEFHelper().IsFormulaDEField()) {
            stringBuilder.Append("if strLastName <> strCurName THEN\n");
        } else {
            stringBuilder.Append("if %1$s%2$s = 1 AND strLastName <> strCurName THEN\n", (Object)"VF_", (Object)this.GetMajorDEFHelper().GetDTColumn().GetColumnName());
        }
        for (DER1N der1n : this.GetDER1Ns(true)) {
            IDEFHelper iValidDEFHelper;
            if (!StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID()) || !der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0) continue;
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
            stringBuilder.Append("UPDATE %1$s SET %2$s=strCurName WHERE %3$s=%4$s ", (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)pickupDEFHelper.GetPickupTextDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(false, this.GetKeyDEFHelper()));
            if (iMinorDEHelper.IsLogicValid() && (iValidDEFHelper = iMinorDEHelper.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                if (StringHelper.Compare((String)iValidDEFHelper.GetDTColumn().GetTableName(), (String)pickupDEFHelper.GetDTColumn().GetTableName(), (boolean)true) == 0) {
                    stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                } else {
                    stringBuilder.Append("AND exists(SELECT * from %1$s WHERE %1$s.%2$s = %3$s.%2$s AND %1$s.%4$s=%5$s) ", (Object)iValidDEFHelper.GetDTColumn().GetTableName(), (Object)iMinorDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                }
            }
            stringBuilder.Append(";\n");
        }
        stringBuilder.Append("END IF;\n");
        HashMap<String, String> physicalFieldMap = new HashMap<String, String>();
        for (DER1N der1n : this.GetDER1Ns(true)) {
            if (!der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) continue;
            IDEFHelper iDEFHelper = this.GetDEFHelper(der1n.getRELATEDTEXTDEFID());
            physicalFieldMap.put(iDEFHelper.getId(), iDEFHelper.GetDTColumn().GetColumnName());
        }
        for (String strDEFieldId : physicalFieldMap.keySet()) {
            String strColumnName = (String)physicalFieldMap.get(strDEFieldId);
            IDEFHelper iDEFHelper = this.GetDEFHelper(strDEFieldId);
            if (iDEFHelper.IsFormulaDEField()) {
                stringBuilder.Append("if strLast%1$s <> strCur%1$s THEN\n", (Object)strColumnName);
            } else {
                stringBuilder.Append("if %1$s%2$s = 1 AND strLast%2$s <> strCur%2$s THEN\n", (Object)"VF_", (Object)strColumnName);
            }
            for (DER1N der1n : this.GetDER1Ns(true)) {
                IDEFHelper iValidDEFHelper;
                if (StringHelper.Compare((String)der1n.getRELATEDTEXTDEFID(), (String)strDEFieldId, (boolean)false) != 0 || !der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0) continue;
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
                stringBuilder.Append("UPDATE %1$s SET %2$s=strCur%5$s WHERE %3$s=%4$s ", (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)pickupDEFHelper.GetPickupTextDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(false, this.GetKeyDEFHelper()), (Object)strColumnName);
                if (iMinorDEHelper.IsLogicValid() && (iValidDEFHelper = iMinorDEHelper.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                    if (StringHelper.Compare((String)iValidDEFHelper.GetDTColumn().GetTableName(), (String)pickupDEFHelper.GetDTColumn().GetTableName(), (boolean)true) == 0) {
                        stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                    } else {
                        stringBuilder.Append("AND exists(SELECT * from %1$s WHERE %1$s.%2$s = %3$s.%2$s AND %1$s.%4$s=%5$s) ", (Object)iValidDEFHelper.GetDTColumn().GetTableName(), (Object)iMinorDEHelper.GetKeyDEFHelper().GetDTColumn().GetColumnName(), (Object)pickupDEFHelper.GetDTColumn().GetTableName(), (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)iMinorDEHelper.GetProperty("VALIDVALUE"));
                    }
                }
                stringBuilder.Append(";\n");
            }
            stringBuilder.Append("END IF;\n");
        }
        return stringBuilder.toString();
    }

    protected void APPEND_DELETEPROC_BODY(String strProcName, StringBuilderEx stringBuilder) {
        stringBuilder.Append("SRFBODY:\nBEGIN\n", (Object)stringBuilder);
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_SYSTEMDECLARE());
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GETSQL_DELETEPROC_BODY_USERDECLARE());
        stringBuilder.Append("\n");
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
        stringBuilder.Append("SET SRF_RETCODE= 0;\n");
        stringBuilder.Append("SET SRF_RETINFO='';\n");
        stringBuilder.Append("SET SRF_RETINFORES='';\n");
        stringBuilder.Append("END SRFBODY;\n");
    }

    protected String GETSQL_INSERTPROC_BODY_INSERT(boolean bInheritTable) {
        IDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
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
        IDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
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
        IDEHelper iDEHelper = bInheritTable ? this.GetInheritDEHelper() : this;
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
        IDEHelper iDEHelper = this;
        if (bInheritTable) {
            iDEHelper = this.GetInheritDEHelper();
        }
        for (IDEFHelper defHelper : this.GetDEFHelpers()) {
            this.GetTableInsertField(strTableName, defHelper, fields, bInheritTable);
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
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_PERSONID");
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("CREATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_CURTIME");
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("UPDATEMAN")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_PERSONID");
        }
        if ((iDEFHelper2 = iDEHelper.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_CURTIME");
        }
    }

    protected void GetTableUpdateFields(String strTableName, TreeMap<String, String> fields, boolean bInheritTable) {
        IDEFHelper iDEFHelper2;
        for (IDEFHelper defHelper : this.GetDEFHelpers()) {
            if (defHelper.IsKeyDEField()) continue;
            this.GetTableUpdateField(strTableName, defHelper, fields, bInheritTable);
        }
        iDEFHelper2 = this.GetDEFHelperByPreDefineType("UPDATEMAN");
        if (iDEFHelper2 != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_PERSONID");
        }
        if ((iDEFHelper2 = this.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
            fields.put(iDEFHelper2.GetDTColumn().GetColumnName(), "SRF_CURTIME");
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
        if (!iDTColumn.IsPKey()) {
            if (!StringHelper.IsNullOrEmpty((String)iDTColumn.GetTableName()) && StringHelper.Compare((String)iDTColumn.GetTableName(), (String)strTableName, (boolean)true) != 0) {
                return;
            }
            if (!iDTColumn.IsEnableUpdate()) {
                return;
            }
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
            stringBuilder.Append("`%1$s`\n", (Object)strParam);
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
        stringBuilder.Append(");\n");
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
            stringBuilder.Append("`%1$s` = %2$s ", (Object)strParam, (Object)fields.get(strParam));
        }
        stringBuilder.Append("\n");
        stringBuilder.Append(" WHERE %1$s;\n", (Object)strCondition);
    }

    protected void APPEND_DELETEPROC_BODY_DELETETABLE(StringBuilderEx stringBuilder, String strTableName, String strCondition, boolean bLogicEnable) {
        if (bLogicEnable) {
            IDEFHelper iDEFHelper;
            IDEFHelper iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID");
            if (iValidDEFHelper != null) {
                stringBuilder.Append("UPDATE  %1$s SET %2$s=%3$s \n", (Object)strTableName, (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("INVALIDVALUE"));
            }
            if ((iDEFHelper = this.GetDEFHelperByPreDefineType("UPDATEMAN")) != null) {
                stringBuilder.Append(",%1$s=SRF_PERSONID \n", (Object)iDEFHelper.GetDTColumn().GetColumnName());
            }
            if ((iDEFHelper = this.GetDEFHelperByPreDefineType("UPDATEDATE")) != null) {
                stringBuilder.Append(",%1$s=SRF_CURTIME \n", (Object)iDEFHelper.GetDTColumn().GetColumnName());
            }
        } else {
            stringBuilder.Append("DELETE FROM %1$s ", (Object)strTableName);
        }
        stringBuilder.Append(" WHERE %1$s;\n", (Object)strCondition);
    }

    protected String GETSQL_INSERTPROC_BODY_INPUTCHECKS() {
        String strViewName = this.GetDEViewName();
        StringBuilderEx stringBuilder = new StringBuilderEx();
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFHelper iValidDEFHelper;
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (iDTColumn.IsPKey()) {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL THEN\n", (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"), (Object)iDTColumn.GetColumnName());
                stringBuilder.Append("select count(*) into nTemp from %1$s where ", (Object)this.GetMainTable());
                stringBuilder.Append(" (upper(%1$s) = upper(%2$s%1$s) ) ", (Object)iDTColumn.GetColumnName(), (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"));
                stringBuilder.Append(";\n");
                stringBuilder.Append("IF nTemp <> 0 THEN\n");
                stringBuilder.Append("SET SRF_RETCODE= %1$s;\n", (Object)1007);
                stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")));
                stringBuilder.Append("SET SRF_TAG= '%1$s';\n", (Object)iDTColumn.GetColumnName());
                stringBuilder.Append("LEAVE SRFBODY ;\n");
                stringBuilder.Append("END IF;\n");
                stringBuilder.Append("END IF;\n");
                stringBuilder.Append("\n");
                continue;
            }
            if (!iDEFHelper.IsDupCheck()) continue;
            IDEFHelper checkDupRangeDEFHelper = iDEFHelper.GetDupCheckRangeDEFHelper();
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL THEN\n", (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"), (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL AND %4$s%3$s IS NOT NULL THEN\n", (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"), (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)(checkDupRangeDEFHelper.GetDTColumn().IsValueAutoGen() ? "VAREX_" : "VAR_"));
            }
            stringBuilder.Append("select count(*) into nTemp from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (upper(%1$s) = upper(%2$s%1$s) ) ", (Object)iDTColumn.GetColumnName(), (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"));
            if (checkDupRangeDEFHelper != null) {
                stringBuilder.Append(" AND (upper(%1$s) = upper(%2$s%1$s) ) ", (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)(checkDupRangeDEFHelper.GetDTColumn().IsValueAutoGen() ? "VAREX_" : "VAR_"));
            }
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetDupCheckCode(true))) {
                stringBuilder.Append(" AND (%1$s) ", (Object)iDEFHelper.GetDupCheckCode(true));
            }
            stringBuilder.Append(";\n");
            stringBuilder.Append("IF nTemp <> 0 THEN\n");
            stringBuilder.Append("SET SRF_RETCODE= %1$s;\n", (Object)1007);
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")));
                stringBuilder.Append("SET SRF_TAG= '%1$s';\n", (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u76f8\u540c%2$s\u4e2d\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName(""), (Object)checkDupRangeDEFHelper.getLogicName("")));
                stringBuilder.Append("SET SRF_TAG= '%1$s|%2$s';\n", (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.getLogicName(""));
            }
            stringBuilder.Append("LEAVE SRFBODY ;\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("END IF;\n");
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
            stringBuilder.Append("IF %1$s%2$s IS  NULL THEN\n", (Object)(iDTColumn.IsValueAutoGen() ? "VAREX_" : "VAR_"), (Object)iDTColumn.GetColumnName());
            stringBuilder.Append("SET SRF_RETCODE= %1$s;\n", (Object)1005);
            stringBuilder.Append("SET SRF_TAG= '%1$s';\n", (Object)iDTColumn.GetColumnName());
            stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"%1$s\u4e0d\u80fd\u4e3a\u7a7a\u503c", (Object)iDEFHelper.getLogicName("")));
            stringBuilder.Append("LEAVE SRFBODY ;\n");
            stringBuilder.Append("END IF;\n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_PROC_BODY_PKEYCONDITION(boolean bInsert, String strAlias, boolean bInheritTable) {
        String strCondition = "";
        if (bInheritTable) {
            IDEFHelper keyDEFHelper = this.GetInheritDEHelper().GetKeyDEFHelper();
            strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)keyDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, this.GetKeyDEFHelper())) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.%1$s=%2$s)", (Object)keyDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, this.GetKeyDEFHelper()), (Object)strAlias);
        } else {
            for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
                IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
                if (!iDTColumn.IsPKey()) continue;
                if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                    strCondition = String.valueOf(strCondition) + " AND ";
                }
                strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)iDTColumn.GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper)) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.%1$s=%2$s)", (Object)iDTColumn.GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper), (Object)strAlias);
            }
        }
        return strCondition;
    }

    protected String GETSQL_PROC_BODY_PKEYCONDITION(IDEHelper indexDEHelper, boolean bInsert, String strAlias) {
        String strCondition = "";
        IDEFHelper iDEFHelper = this.GetKeyDEFHelper();
        IDEFHelper curDEFHelper = indexDEHelper.GetKeyDEFHelper();
        strCondition = StringHelper.IsNullOrEmpty((String)strAlias) ? String.valueOf(strCondition) + StringHelper.Format((String)"(%1$s=%2$s)", (Object)curDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper)) : String.valueOf(strCondition) + StringHelper.Format((String)"(%3$s.%1$s=%2$s)", (Object)curDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GETSQL_PROC_BODY_PKEYFIELDVALUE(bInsert, iDEFHelper), (Object)strAlias);
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
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL THEN\n", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("IF %1$s%2$s IS NOT NULL AND %1$s%3$s IS NOT NULL THEN\n", (Object)"VAR_", (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName());
            }
            stringBuilder.Append("select count(*) into nTemp from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (upper(%1$s) = upper(%2$s%1$s) ) ", (Object)iDTColumn.GetColumnName(), (Object)"VAR_");
            if (checkDupRangeDEFHelper != null) {
                stringBuilder.Append(" AND (upper(%1$s) = upper(%2$s%1$s) ) ", (Object)checkDupRangeDEFHelper.GetDTColumn().GetColumnName(), (Object)"VAR_");
            }
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.GetDupCheckCode(false))) {
                stringBuilder.Append(" AND (%1$s) ", (Object)iDEFHelper.GetDupCheckCode(false));
            }
            stringBuilder.Append(" AND NOT(%1$s) ", (Object)strCondition);
            stringBuilder.Append(";\n");
            stringBuilder.Append("IF nTemp <> 0 THEN\n");
            stringBuilder.Append("SET SRF_RETCODE= %1$s;\n", (Object)1007);
            if (checkDupRangeDEFHelper == null) {
                stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName("")));
                stringBuilder.Append("SET SRF_TAG= '%1$s';\n", (Object)iDTColumn.GetColumnName());
            } else {
                stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)StringHelper.Format((String)"\u76f8\u540c%2$s\u4e2d\u51fa\u73b0\u91cd\u590d\u7684%1$s", (Object)iDEFHelper.getLogicName(""), (Object)checkDupRangeDEFHelper.getLogicName("")));
                stringBuilder.Append("SET SRF_TAG= '%1$s|%2$s';\n", (Object)iDTColumn.GetColumnName(), (Object)checkDupRangeDEFHelper.getLogicName(""));
            }
            stringBuilder.Append("LEAVE SRFBODY ;\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("\n");
        }
        stringBuilder.Append("\n");
        stringBuilder.Append(this.GetDBActionStepCode("UPDATE", "INPUTCHECK"));
        Vector<DBAction> dbActions = new Vector<DBAction>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBActions(this.getId(), this.GetDBType(), "UPDATE", dbActions);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5e93\u64cd\u4f5c\u6a21\u5f0f\u96c6\u5408\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return "";
        }
        for (DBAction dbAction : dbActions) {
            if (StringHelper.IsNullOrEmpty((String)dbAction.getCHECKCOND())) continue;
            stringBuilder.Append("\n");
            stringBuilder.Append("IF UPPER(SRF_ACTIONMODE)='%1$s' THEN\n", (Object)dbAction.getACTIONMODE().toUpperCase());
            stringBuilder.Append("select count(*) into nTemp from %1$s where ", (Object)strViewName);
            stringBuilder.Append(" (%1$s) ", (Object)strCondition);
            if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
                stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
            stringBuilder.Append(" AND NOT (%1$s) ", (Object)dbAction.getCHECKCOND());
            stringBuilder.Append(";\n");
            stringBuilder.Append("IF nTemp <> 0 THEN\n");
            stringBuilder.Append("SET SRF_RETCODE = %1$s;\n", (Object)dbAction.getERRORCODE());
            stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)dbAction.getERRORINFO());
            stringBuilder.Append("LEAVE SRFBODY ;\n");
            stringBuilder.Append("END IF;\n");
            stringBuilder.Append("END IF;\n");
        }
        return stringBuilder.toString();
    }

    protected String GETSQL_UPDATEPROC_BODY_CHECKEXISTING() {
        return this.GetCheckExistingCode(true);
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
        stringBuilder.Append("select count(*) into nTemp from %1$s where ", (Object)strViewName);
        stringBuilder.Append(" (%1$s) ", (Object)strCondition);
        if (this.IsLogicValid() && (iValidDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID")) != null) {
            stringBuilder.Append("AND (%1$s=%2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
        }
        stringBuilder.Append(";\n");
        stringBuilder.Append("IF nTemp = 0 THEN\n");
        stringBuilder.Append("SET SRF_RETCODE= %1$s;\n", (Object)1003);
        stringBuilder.Append("SET SRF_RETINFO= '%1$s';\n", (Object)(bUpdate ? "\u6307\u5b9a\u7684\u66f4\u65b0\u6570\u636e\u4e0d\u5b58\u5728" : "\u6307\u5b9a\u7684\u5220\u9664\u6570\u636e\u4e0d\u5b58\u5728"));
        stringBuilder.Append("LEAVE SRFBODY ;\n");
        stringBuilder.Append("END IF;\n");
        return stringBuilder.toString();
    }

    protected String GETSQL_INSERTPROC_BODY_SYSTEMDECLARE() {
        return this.GetProcSystemDeclare();
    }

    protected String GETSQL_UPDATEPROC_BODY_SYSTEMDECLARE() {
        String strOld = this.GetProcSystemDeclare();
        strOld = String.valueOf(strOld) + "\n";
        strOld = String.valueOf(strOld) + "DECLARE strLastName VARCHAR(200);\n";
        strOld = String.valueOf(strOld) + "DECLARE strCurName VARCHAR(200);\n";
        HashMap<String, String> physicalFieldMap = new HashMap<String, String>();
        for (DER1N der1n : this.GetDER1Ns(true)) {
            if (!der1n.getPHYSICALMODE() || StringHelper.Compare((String)der1n.getPHYSICALUPDATEMODE(), (String)"UPDATEWHENMODIFY", (boolean)true) != 0 || StringHelper.IsNullOrEmpty((String)der1n.getRELATEDTEXTDEFID())) continue;
            IDEFHelper iDEFHelper = this.GetDEFHelper(der1n.getRELATEDTEXTDEFID());
            physicalFieldMap.put(iDEFHelper.getId(), iDEFHelper.GetDTColumn().GetColumnName());
        }
        for (String strColumnName : physicalFieldMap.values()) {
            strOld = String.valueOf(strOld) + StringHelper.Format((String)"declare strLast%1$s VARCHAR(200);\n", (Object)strColumnName);
            strOld = String.valueOf(strOld) + StringHelper.Format((String)"declare strCur%1$s VARCHAR(200);\n", (Object)strColumnName);
        }
        return strOld;
    }

    protected String GETSQL_DELETEPROC_BODY_SYSTEMDECLARE() {
        return this.GetProcSystemDeclare();
    }

    protected String GetProcSystemDeclare() {
        String strSystemDeclare = "DECLARE nTemp INT;\n";
        strSystemDeclare = String.valueOf(strSystemDeclare) + "DECLARE SRF_CURTIME TIMESTAMP;";
        return strSystemDeclare;
    }

    protected String GETSQL_INSERTPROC_BODY_USERDECLARE() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IInheritDEFHelper inheritDEFHelper;
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableInsert() || !iDTColumn.IsValueAutoGen() && (!iDEFHelper.IsInheritDEField() ? !iDEFHelper.IsPhisicalDEField() || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) != 0 : !(inheritDEFHelper = (IInheritDEFHelper)iDEFHelper).GetRelatedDEFHelper().GetDTColumn().IsValueAutoGen())) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.GETSQL_INSERTPROC_BODY_USERDECLARE_ITEM(iDEFHelper);
        }
        strSQL = String.valueOf(strSQL) + this.GetDBActionStepCode("INSERT", "USERDECLARE");
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableUpdate() || !iDEFHelper.IsPhisicalDEField() || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) != 0) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.GETSQL_UPDATEPROC_BODY_USERDECLARE_ITEM(iDEFHelper);
        }
        strSQL = String.valueOf(strSQL) + "\n";
        strSQL = String.valueOf(strSQL) + this.GetDBActionStepCode("UPDATE", "USERDECLARE");
        return strSQL;
    }

    protected String GETSQL_UPDATEPROC_BODY_USERDECLARE_ITEM(IDEFHelper iDEFHelper) {
        if (iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
            IDEFDTColumn iDTColumn = inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn();
            String strDBType = iDTColumn.GetDBDataType(false, false, false, "");
            String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)strDBType);
            return strSQL;
        }
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        String strDBType = iDTColumn.GetDBDataType(false, false, false, "");
        String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)strDBType);
        return strSQL;
    }

    protected String GETSQL_DELETEPROC_BODY_USERDECLARE() {
        return this.GetDBActionStepCode("DELETE", "USERDECLARE");
    }

    protected String GETSQL_INSERTPROC_BODY_USERDECLARE_ITEM(IDEFHelper iDEFHelper) {
        if (iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
            IDEFDTColumn iDTColumn = inheritDEFHelper.GetRelatedDEFHelper().GetDTColumn();
            String strDBType = iDTColumn.GetDBDataType(false, false, false, "");
            String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)strDBType);
            return strSQL;
        }
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        String strDBType = iDTColumn.GetDBDataType(false, false, false, "");
        String strSQL = StringHelper.Format((String)"DECLARE %1$s%2$s %3$s;", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)strDBType);
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
        strSQL = String.valueOf(strSQL) + StringHelper.Format((String)"SET SRF_CURTIME=NOW();");
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_USERINIT() {
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IInheritDEFHelper inheritDEFHelper;
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableInsert() || !iDTColumn.IsValueAutoGen() && (!iDEFHelper.IsInheritDEField() ? !iDEFHelper.IsPhisicalDEField() || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) != 0 : !(inheritDEFHelper = (IInheritDEFHelper)iDEFHelper).GetRelatedDEFHelper().GetDTColumn().IsValueAutoGen())) continue;
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
        String strSQL = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsEnableUpdate() || !iDEFHelper.IsPhisicalDEField() || StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) != 0) continue;
            if (!StringHelper.IsNullOrEmpty((String)strSQL)) {
                strSQL = String.valueOf(strSQL) + "\n";
            }
            strSQL = String.valueOf(strSQL) + this.GETSQL_UPDATEPROC_BODY_USERINIT_ITEM(iDEFHelper);
        }
        strSQL = String.valueOf(strSQL) + "\n";
        strSQL = String.valueOf(strSQL) + this.GetDBActionStepCode("UPDATE", "USERINIT");
        return strSQL;
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
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
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
        if (!iDTColumn.IsValueAutoGen()) {
            if (iDEFHelper.IsInheritDEField()) {
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                iDTColumn = inheritDEFHelper.GetDTColumn();
            } else if (iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                iDTColumn = iDEFHelper.GetDTColumn();
            }
        }
        if (iDTColumn == null) {
            return "";
        }
        if (iDTColumn.IsValueAutoGen()) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.Append("IF %1$s%2$s IS NOT NULL THEN\n", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SET %1$s%2$s= %3$s%2$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_");
            stringBuilderEx.Append("ELSE\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_");
            stringBuilderEx.Append("SET %1$s%2$s= %3$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)iDTColumn.GetValueGenFunc());
            stringBuilderEx.Append("END IF;\n", (Object)"VF_", (Object)iDTColumn.GetColumnName());
            return stringBuilderEx.toString();
        }
        if (iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            if (!(iDEFHelper instanceof ILinkDEFHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iDEFHelper.getName()));
                return "";
            }
            ILinkDEFHelper iLinkDefHelper = (ILinkDEFHelper)iDEFHelper;
            IPickupDEFHelper iPickupDEFHelper = iLinkDefHelper.getDEHelper().FindPickupDEFHelper(iLinkDefHelper.GetDERId());
            if (iPickupDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]DER1N\u5173\u7cfb[%2$s]\u5bf9\u5e94\u7684\u5c5e\u6027", (Object)iLinkDefHelper.getDEHelper().getId(), (Object)iLinkDefHelper.GetDERId()));
                return "";
            }
            IDEFDTColumn iDTColumn2 = iPickupDEFHelper.GetDTColumn();
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAR_", (Object)iDTColumn2.GetColumnName());
            stringBuilderEx.Append("SET %1$s%2$s = NULL;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("ELSE\n");
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SELECT %5$s INTO %1$s%2$s FROM  %7$s WHERE %6$s = %3$s%4$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_", (Object)iDTColumn2.GetColumnName(), (Object)iLinkDefHelper.GetRealDEFHelper().GetDTColumn().GetColumnName(), (Object)iPickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetColumnName(), (Object)iPickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDEViewName());
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SET SRF_RETCODE = %1$s;\n", (Object)1003);
            stringBuilderEx.Append("SET SRF_RETINFO = '%1$s';\n", (Object)StringHelper.Format((String)"\u6307\u5b9a\u6570\u636e\u4e0d\u5b58\u5728"));
            stringBuilderEx.Append("SET SRF_TAG = '%1$s';\n", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SET SRF_RETINFORES = '%1$s';\n", (Object)"ERROR.STD.DB.INVALIDDATA");
            stringBuilderEx.Append("SET SRF_RETINFORESARG = '%1$s';\n", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("LEAVE SRFBODY ;\n");
            stringBuilderEx.Append("END IF;\n");
            stringBuilderEx.Append("ELSE\n");
            stringBuilderEx.Append("SET %1$s%2$s = %3$s%2$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_");
            stringBuilderEx.Append("END IF;\n");
            stringBuilderEx.Append("END IF;\n");
            return stringBuilderEx.toString();
        }
        return "";
    }

    protected String GETSQL_UPDATEPROC_BODY_USERINIT_ITEM(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        if (iDEFHelper.IsInheritDEField()) {
            IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
            iDTColumn = inheritDEFHelper.GetDTColumn();
        } else if (iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            iDTColumn = iDEFHelper.GetDTColumn();
        }
        if (iDTColumn == null) {
            return "";
        }
        if (iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            if (!(iDEFHelper instanceof ILinkDEFHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iDEFHelper.getName()));
                return "";
            }
            ILinkDEFHelper iLinkDefHelper = (ILinkDEFHelper)iDEFHelper;
            IPickupDEFHelper iPickupDEFHelper = iLinkDefHelper.getDEHelper().FindPickupDEFHelper(iLinkDefHelper.GetDERId());
            if (iPickupDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]DER1N\u5173\u7cfb[%2$s]\u5bf9\u5e94\u7684\u5c5e\u6027", (Object)iLinkDefHelper.getDEHelper().getId(), (Object)iLinkDefHelper.GetDERId()));
                return "";
            }
            IDEFDTColumn iDTColumn2 = iPickupDEFHelper.GetDTColumn();
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            stringBuilderEx.Append("IF %1$s%2$s = 1 THEN\n", (Object)"VF_", (Object)iDTColumn2.GetColumnName());
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAR_", (Object)iDTColumn2.GetColumnName());
            stringBuilderEx.Append("SET %1$s%2$s = NULL;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("ELSE\n");
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SELECT %5$s INTO %1$s%2$s FROM  %7$s WHERE %6$s = %3$s%4$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_", (Object)iDTColumn2.GetColumnName(), (Object)iLinkDefHelper.GetRealDEFHelper().GetDTColumn().GetColumnName(), (Object)iPickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetColumnName(), (Object)iPickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDEViewName());
            stringBuilderEx.Append("IF %1$s%2$s IS NULL THEN\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SET SRF_RETCODE = %1$s;\n", (Object)1003);
            stringBuilderEx.Append("SET SRF_RETINFO = '%1$s';\n", (Object)StringHelper.Format((String)"\u6307\u5b9a\u6570\u636e\u4e0d\u5b58\u5728"));
            stringBuilderEx.Append("SET SRF_TAG = '%1$s';\n", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("SET SRF_RETINFORES = '%1$s';\n", (Object)"ERROR.STD.DB.INVALIDDATA");
            stringBuilderEx.Append("SET SRF_RETINFORESARG = '%1$s';\n", (Object)iDTColumn.GetColumnName());
            stringBuilderEx.Append("LEAVE SRFBODY ;\n");
            stringBuilderEx.Append("END IF;\n");
            stringBuilderEx.Append("ELSE\n");
            stringBuilderEx.Append("SET %1$s%2$s = %3$s%2$s;\n", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)"VAR_");
            stringBuilderEx.Append("END IF;\n");
            stringBuilderEx.Append("END IF;\n");
            stringBuilderEx.Append("END IF;\n");
            return stringBuilderEx.toString();
        }
        return "";
    }

    protected String GETSQL_INSERTPROC_BODY_INSERTTABLE_FIELDVALUE(IDEFHelper iDEFHelper) {
        IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
        return this.GETFIELDPARAMNAME(true, iDEFHelper, iDTColumn);
    }

    protected String GETFIELDPARAMNAME(boolean bInsert, IDEFDTColumn iDTColumn) {
        return this.GETFIELDPARAMNAME(bInsert, null, iDTColumn);
    }

    protected String GETFIELDPARAMNAME(boolean bInsert, IDEFHelper iDEFHelper, IDEFDTColumn iDTColumn) {
        if (bInsert) {
            if (iDTColumn.IsValueAutoGen()) {
                return StringHelper.Format((String)"%1$s%2$s", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            }
            if (iDEFHelper != null && iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
                return StringHelper.Format((String)"%1$s%2$s", (Object)"VAREX_", (Object)iDTColumn.GetColumnName());
            }
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)"VAR_", (Object)iDTColumn.GetColumnName());
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
            return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE `%4$s` + 1 END", (Object)"VF_", (Object)"VAR_", (Object)iDTColumn.GetColumnName(), (Object)strOriginName);
        }
        if (iDEFHelper.IsPhisicalDEField() && StringHelper.Compare((String)iDEFHelper.GetDataType(), (String)"PICKUPTEXT", (boolean)true) == 0) {
            if (!(iDEFHelper instanceof ILinkDEFHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)iDEFHelper.getName()));
                return "";
            }
            ILinkDEFHelper iLinkDefHelper = (ILinkDEFHelper)iDEFHelper;
            IPickupDEFHelper iPickupDEFHelper = iLinkDefHelper.getDEHelper().FindPickupDEFHelper(iLinkDefHelper.GetDERId());
            if (iPickupDEFHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]DER1N\u5173\u7cfb[%2$s]\u5bf9\u5e94\u7684\u5c5e\u6027", (Object)iLinkDefHelper.getDEHelper().getId(), (Object)iLinkDefHelper.GetDERId()));
                return "";
            }
            IDEFDTColumn iDTColumn2 = iPickupDEFHelper.GetDTColumn();
            return StringHelper.Format((String)"CASE %1$s%5$s WHEN 1 THEN %2$s%3$s ELSE `%4$s` END", (Object)"VF_", (Object)"VAREX_", (Object)iDTColumn.GetColumnName(), (Object)strOriginName, (Object)iDTColumn2.GetColumnName());
        }
        return StringHelper.Format((String)"CASE %1$s%3$s WHEN 1 THEN %2$s%3$s ELSE `%4$s` END", (Object)"VF_", (Object)"VAR_", (Object)iDTColumn.GetColumnName(), (Object)strOriginName);
    }

    protected String GETSQL_PROC_BODY_PKEYFIELDVALUE(boolean bInsert, IDEFHelper iDEFHelper) {
        if (bInsert && iDEFHelper.GetDTColumn().IsValueAutoGen()) {
            return StringHelper.Format((String)"%1$s%2$s", (Object)"VAREX_", (Object)iDEFHelper.GetDTColumn().GetColumnName());
        }
        return StringHelper.Format((String)"%1$s%2$s", (Object)"VAR_", (Object)iDEFHelper.GetDTColumn().GetColumnName());
    }

    public String GetCheckKeyCode(Vector<ProcParam> procParams) {
        String strSQL = "";
        if (this.IsLogicValid()) {
            IDEFHelper logicDEFHelper = this.GetDEFHelperByPreDefineType("LOGICVALID");
            strSQL = StringHelper.Format((String)"select m1.%2$s,m1.%3$s from %1$s m1 ", (Object)this.GetMainTable(), (Object)this.GetKeyDEFHelper().getName(), (Object)logicDEFHelper.getName());
        } else {
            strSQL = StringHelper.Format((String)"select m1.%2$s from %1$s m1 ", (Object)this.GetMainTable(), (Object)this.GetKeyDEFHelper().getName());
        }
        String strCondition = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            IDEFDTColumn iDTColumn = iDEFHelper.GetDTColumn();
            if (!iDTColumn.IsPKey()) continue;
            if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
                strCondition = String.valueOf(strCondition) + " AND ";
            }
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s=?)", (Object)iDTColumn.GetColumnName());
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
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s=?)", (Object)iDTColumn.GetColumnName());
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
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
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
            strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s=?)", (Object)iDTColumn.GetColumnName());
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
                strCondition = String.valueOf(strCondition) + StringHelper.Format((String)"(m1.%1$s = %2$s) ", (Object)iValidDEFHelper.GetDTColumn().GetColumnName(), (Object)this.GetProperty("VALIDVALUE"));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strCondition)) {
            strSQL = String.valueOf(strSQL) + " WHERE ";
            strSQL = String.valueOf(strSQL) + strCondition;
        }
        return strSQL;
    }

    protected String GETSQL_INSERTPROC_BODY_AFTERINSERT() {
        return "";
    }

    protected String GETSQL_UPDATEPROC_BODY_AFTERUPDATE() {
        return "";
    }

    protected String GETSQL_DELETEPROC_BODY_AFTERDELETE() {
        return "";
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
        return StringHelper.Format((String)"%1$s%2$s_D%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.getDataEntity().getDEVERSION());
    }

    public String GetInsertProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_I%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.getDataEntity().getDEVERSION());
    }

    public String GetUpdateProcName() {
        String strDENAME = this.getName();
        if (StringHelper.Length((String)strDENAME) > 20) {
            strDENAME = strDENAME.substring(0, 20);
        }
        return StringHelper.Format((String)"%1$s%2$s_U%3$s", (Object)"SRFP_", (Object)strDENAME, (Object)this.getDataEntity().getDEVERSION());
    }

    protected String GetDALOGEventInfo() {
        return "SRF_ACTIONMODE";
    }

    protected String GetDBActionStepCode(String strAction, String strActionStep) {
        Vector<DBActionStep> dbActionSteps = new Vector<DBActionStep>();
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

    protected CallResult InternalGetProcParams(String strProcName, Vector<ProcParam> params) {
        String strSQL = StringHelper.Format((String)"select param_list from mysql.proc where UPPER(specific_name)='%2$s' ", (Object)this.strDBSCHEMA, (Object)strProcName.toUpperCase());
        Vector dataEntities = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.contextHelperEx, (String)this.GetDBStorage(), (String)strSQL, dataEntities, null);
        if (callResult.IsError()) {
            return callResult;
        }
        if (dataEntities.size() == 0) {
            callResult.setRetCode(3);
            return callResult;
        }
        Object obj = ((BaseDataEntity)dataEntities.get(0)).GetParamValue("param_list");
        String strParamList = "";
        if (obj != null && obj instanceof byte[]) {
            try {
                byte[] buffer = (byte[])obj;
                strParamList = new String(buffer);
            }
            catch (Exception ex) {
                System.out.print(obj.toString());
                ex.printStackTrace();
            }
        }
        String[] a = strParamList.split("[\n]");
        int i = 0;
        while (i < a.length) {
            String[] b;
            ProcParam procParam = new ProcParam();
            if (!StringHelper.IsNullOrEmpty((String)a[i]) && (b = a[i].split("[ ]")).length >= 2) {
                procParam.SetParamValue("PARAMNAME", (Object)b[1]);
                procParam.SetParamValue("DIRECTION", (Object)b[0]);
                params.add(procParam);
            }
            ++i;
        }
        return callResult;
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
}
