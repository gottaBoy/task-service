/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDBModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DETrigger;
import SA.SRFDA.Ctrl.Data.TriggerCode;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DB2DBModelHelper
extends BaseDBModelHelper {
    private static final Log log = LogFactory.getLog(DB2DBModelHelper.class);

    @Override
    protected void AppendSql_CreateTable(StringBuilderEx stringBuilder, boolean bMain, IDEHelper relatedDEHelper) {
        String strDEName = this.dataEntity.getDENAME().toUpperCase();
        String strTableName = this.GetTableName(bMain);
        IDEFHelper keyDEFHelper = null;
        if (relatedDEHelper != null) {
            keyDEFHelper = relatedDEHelper.GetKeyDEFHelper();
        }
        if (bMain) {
            this.dataEntity.setTABLENAME(strTableName);
        } else {
            this.dataEntity.setEXTABLENAME(strTableName);
        }
        stringBuilder.Append("CREATE TABLE %1$s(\n", (Object)strTableName);
        if (keyDEFHelper != null) {
            stringBuilder.Append("%1$s VARCHAR(100) NOT NULL,\n", (Object)keyDEFHelper.getName());
        } else {
            stringBuilder.Append("%1$sID VARCHAR(100) NOT NULL,\n", (Object)strDEName);
        }
        if (bMain) {
            if (keyDEFHelper == null) {
                stringBuilder.Append("%1$sNAME VARCHAR(200) ,\n", (Object)strDEName);
            }
            if (this.dataEntity.isLOGICVALID()) {
                stringBuilder.Append("ENABLE INTEGER  NOT NULL,\n");
            }
            if (this.dataEntity.isINDEXDE()) {
                stringBuilder.Append("%1$sTYPE VARCHAR(100) NOT NULL,\n", (Object)strDEName);
                if (this.dataEntity.getINDEXMODE() == 1) {
                    stringBuilder.Append("%1$sID2 VARCHAR(100) NOT NULL,\n", (Object)strDEName);
                }
            }
        }
        stringBuilder.Append("CREATEMAN\tVARCHAR(60)\tNOT NULL,\n");
        stringBuilder.Append("CREATEDATE TIMESTAMP\tNOT NULL,\n");
        stringBuilder.Append("UPDATEMAN\tVARCHAR(60)\tNOT NULL,\n");
        stringBuilder.Append("UPDATEDATE TIMESTAMP\tNOT NULL\n");
        stringBuilder.Append(") ");
        if (!StringHelper.IsNullOrEmpty((String)this.dataEntity.getTABLESPACE())) {
            stringBuilder.Append("IN \"%1$s\"", (Object)this.dataEntity.getTABLESPACE());
        }
        stringBuilder.Append(";\n");
        stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
        if (keyDEFHelper != null) {
            stringBuilder.Append("ADD PRIMARY KEY (%1$s);\n", (Object)keyDEFHelper.getName());
        } else {
            stringBuilder.Append("ADD PRIMARY KEY (%1$sID);\n", (Object)strDEName);
        }
        if (!bMain) {
            String strMainTableName = this.dataEntity.getTABLENAME();
            stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
            if (keyDEFHelper != null) {
                stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%1$s)\n", (Object)keyDEFHelper.getName(), (Object)strMainTableName);
            } else {
                stringBuilder.Append("ADD FOREIGN KEY (%1$sID) REFERENCES %2$s (%1$sID)\n", (Object)strDEName, (Object)strMainTableName);
            }
            stringBuilder.Append("ON DELETE NO ACTION\n");
            stringBuilder.Append("ON UPDATE NO ACTION\n");
            stringBuilder.Append("ENFORCED\n");
            stringBuilder.Append(" ENABLE QUERY OPTIMIZATION;\n");
        } else if (keyDEFHelper != null) {
            String strMainTableName = this.dataEntity.getTABLENAME();
            stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
            stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%1$s)\n", (Object)keyDEFHelper.getName(), (Object)strMainTableName);
            stringBuilder.Append("ON DELETE NO ACTION\n");
            stringBuilder.Append("ON UPDATE NO ACTION\n");
            stringBuilder.Append("ENFORCED\n");
            stringBuilder.Append(" ENABLE QUERY OPTIMIZATION;\n");
        }
    }

    @Override
    protected void AppendSql_AddColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
        String strDataType = iDEFHelper.GetDTColumn().GetDBDataType(false, false, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iDEFHelper.GetFullName()));
            return;
        }
        stringBuilder.Append("ALTER TABLE \"%1$s\"\n", (Object)iDEFHelper.GetDTColumn().GetTableName().toUpperCase());
        stringBuilder.Append("ADD COLUMN %1$s %2$s;\n", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)strDataType);
    }

    @Override
    protected void AppendSql_AddPickupColumn(StringBuilderEx stringBuilder, IDEFHelper iDEFHelper) {
        String strDataType = iDEFHelper.GetDTColumn().GetDBDataType(false, false, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iDEFHelper.GetFullName()));
            return;
        }
        stringBuilder.Append("ALTER TABLE \"%1$s\"\n", (Object)iDEFHelper.GetDTColumn().GetTableName().toUpperCase());
        stringBuilder.Append("ADD COLUMN %1$s %2$s;\n", (Object)iDEFHelper.GetDTColumn().GetColumnName(), (Object)strDataType);
        if (iDEFHelper instanceof IPickupDEFHelper) {
            DER1N der1n;
            IPickupDEFHelper pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            boolean bAddForeignKey = true;
            if (StringHelper.Compare((String)pickupDEFHelper.getDEHelper().GetDBStorage(), (String)iDEFHelper.getDEHelper().GetDBStorage(), (boolean)true) != 0) {
                bAddForeignKey = false;
            }
            if (bAddForeignKey && (der1n = this.iDEHelper.FindDER1N(pickupDEFHelper.GetDERId())) != null) {
                bAddForeignKey = der1n.getFOREIGNKEY();
            }
            if (bAddForeignKey) {
                String strTableName = pickupDEFHelper.GetDTColumn().GetTableName();
                String strRealTableName = pickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetTableName();
                String strRealColumnName = pickupDEFHelper.GetRealDEFHelper().GetDTColumn().GetColumnName();
                stringBuilder.Append("ALTER TABLE %1$s\n", (Object)strTableName);
                stringBuilder.Append("ADD FOREIGN KEY (%1$s) REFERENCES %2$s (%3$s)\n", (Object)pickupDEFHelper.getName(), (Object)strRealTableName, (Object)strRealColumnName.toUpperCase());
                stringBuilder.Append("ON DELETE NO ACTION\n");
                stringBuilder.Append("ON UPDATE NO ACTION\n");
                stringBuilder.Append("ENFORCED\n");
                stringBuilder.Append(" ENABLE QUERY OPTIMIZATION;\n");
            }
        }
    }

    @Override
    protected CallResult CallCreateDBModelSql(String arg0) {
        String[] arrSqls = arg0.split(";");
        CallResult callResult = new CallResult();
        int i = 0;
        while (i < arrSqls.length) {
            if (StringHelper.Length((String)arrSqls[i]) > 5) {
                try {
                    SelectResult selectResult = this.globalHelperEx.getDBCaller(this.getDEHelper().GetDBStorage()).CallRaw2(arrSqls[i]);
                    callResult.From((DBResult)selectResult);
                    if (callResult.getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)arrSqls[i]));
                        return callResult;
                    }
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(ex.getMessage());
                    log.error((Object)StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u6a21\u578b\u8bed\u53e5\u53d1\u751f\u9519\u8bef:\r\n%1$s", (Object)arrSqls[i]), (Throwable)ex);
                    return callResult;
                }
            }
            ++i;
        }
        return callResult;
    }

    @Override
    protected boolean GetTableColumnRealDataType(DEField field, BaseDataEntity dataType) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_GetTableColumnDataType(field.getTABLENAME(), field.getDEFNAME());
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.globalHelperEx, this.dataEntity.getDBSTORAGE(), strSQL, dataType);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        String strDataType = dataType.GetParamStringValue("TYPENAME", "");
        String strDataLength = dataType.GetParamStringValue("LENGTH", "");
        String strDataScale = dataType.GetParamStringValue("SCALE", "");
        return true;
    }

    @Override
    protected void AppendSql_AddTrigger(StringBuilderEx sb, DETrigger trigger, TriggerCode triggerCode) {
        String strTargetName = "";
        strTargetName = StringHelper.Compare((String)trigger.getTGTARGET(), (String)"TABLE", (boolean)true) == 0 ? this.dataEntity.getTABLENAME() : this.dataEntity.getVIEWNAME();
        String strTriggerName = this.GetTriggerName(trigger);
        sb.Append("CREATE TRIGGER \"%1$s\".%2$s\n", (Object)this.strDBSCHEMA, (Object)strTriggerName);
        if (StringHelper.Compare((String)trigger.getTGACTION(), (String)"BEFORE", (boolean)true) == 0) {
            sb.Append("NO CASCADE BEFORE %1$s\n", (Object)trigger.getTGEVENT());
        }
        if (StringHelper.Compare((String)trigger.getTGACTION(), (String)"AFTER", (boolean)true) == 0) {
            sb.Append("AFTER %1$s\n", (Object)trigger.getTGEVENT());
        }
        if (StringHelper.Compare((String)trigger.getTGACTION(), (String)"INSTEADOF", (boolean)true) == 0) {
            sb.Append("INSTEAD OF %1$s\n", (Object)trigger.getTGEVENT());
        }
        sb.Append("ON \"%1$s\".%2$s\n", (Object)this.strDBSCHEMA, (Object)strTargetName);
        boolean bOutputReferencing = false;
        if (!StringHelper.IsNullOrEmpty((String)trigger.getOLDROWALIAS())) {
            if (!bOutputReferencing) {
                sb.Append("REFERENCING\n");
                bOutputReferencing = true;
            }
            sb.Append("\t\tOLD AS %1$s\n", (Object)trigger.getOLDROWALIAS());
        }
        if (!StringHelper.IsNullOrEmpty((String)trigger.getNEWROWALIAS())) {
            if (!bOutputReferencing) {
                sb.Append("REFERENCING\n");
                bOutputReferencing = true;
            }
            sb.Append("\t\tNEW AS %1$s\n", (Object)trigger.getNEWROWALIAS());
        }
        if (!StringHelper.IsNullOrEmpty((String)trigger.getOLDTABLEALIAS())) {
            if (!bOutputReferencing) {
                sb.Append("REFERENCING\n");
                bOutputReferencing = true;
            }
            sb.Append("\t\tOLD_TABLE AS %1$s\n", (Object)trigger.getOLDTABLEALIAS());
        }
        if (!StringHelper.IsNullOrEmpty((String)trigger.getNEWTABLEALIAS())) {
            if (!bOutputReferencing) {
                sb.Append("REFERENCING\n");
                bOutputReferencing = true;
            }
            sb.Append("\t\tNEW_TABLE AS %1$s\n", (Object)trigger.getNEWTABLEALIAS());
        }
        sb.Append("%1$s\n", (Object)triggerCode.getEXECMODE().toUpperCase());
        if (!StringHelper.IsNullOrEmpty((String)triggerCode.getSEARCHCOND())) {
            sb.Append("WHEN(%1$s)\n", (Object)triggerCode.getSEARCHCOND());
        }
        sb.Append("%1$s\n", (Object)triggerCode.getTRIGGERBODY());
    }

    @Override
    public String GetDBType() {
        return "DB2";
    }

    @Override
    protected void AppendSql_AddIndex(StringBuilderEx stringBuilder, DBIndex dbIndex, Vector<BaseDBModelHelper.DBIndexField> indexFields) {
        String strTableName = this.getDEHelper().GetMainTable();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CREATE INDEX \"%1$s\".\"%2$s\" \n", (Object)this.strDBSCHEMA, (Object)dbIndex.getDBINDEXNAME());
        stringBuilder.Append(" ON \"%1$s\".\"%2$s\" \n", (Object)this.strDBSCHEMA, (Object)strTableName);
        stringBuilder.Append("(\n");
        int i = 0;
        while (i < indexFields.size()) {
            BaseDBModelHelper.DBIndexField dbIndexField = indexFields.get(i);
            if (i != 0) {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("\"%1$s\" %2$s", (Object)dbIndexField.getField(), (Object)(dbIndexField.isSortAsc() ? "ASC" : "DESC"));
            ++i;
        }
        stringBuilder.Append(")\n");
        if (dbIndex.getALLOWREVERSE()) {
            stringBuilder.Append("  ALLOW REVERSE SCANS \n");
        } else {
            stringBuilder.Append(" DISALLOW REVERSE SCANS \n");
        }
    }

    @Override
    protected void AppendSql_AfterAddIndex(StringBuilderEx stringBuilder, DBIndex dbIndex) {
        String strTableName = this.getDEHelper().GetMainTable();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CALL SYSPROC.ADMIN_CMD(' ");
        stringBuilder.Append(" RUNSTATS ON TABLE \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)strTableName);
        stringBuilder.Append(" FOR INDEX \"%1$s\".\"%2$s\" ", (Object)this.strDBSCHEMA, (Object)dbIndex.getDBINDEXNAME());
        stringBuilder.Append(" ALLOW READ ACCESS ");
        stringBuilder.Append(" ') ");
    }
}

