/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DEField.IPSPickupDEField
 *  SA.SRFDA.PS.Core.Database.IPSDEDBConfig
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndex
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndexField
 *  SA.SRFDA.PS.Core.Database.IPSDEFDTColumn
 *  SA.SRFDA.PS.Core.Database.IPSDatabase
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDB2DBTypeImpl
extends PSDBTypeImpl {
    private static final Log log = LogFactory.getLog(PSDB2DBTypeImpl.class);
    public static final String DB2 = "DB2";

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String[] items = strTableName.split("[.]");
        String strSchema = iPSDatabase.getDBName();
        if (items.length >= 2) {
            strSchema = items[0];
            strTableName = items[1];
        }
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select TABNAME from syscat.TABLES  where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s'", (Object)strSchema.toUpperCase(), (Object)strTableName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        String[] items = strTableName.split("[.]");
        String strSchema = iPSDatabase.getDBName();
        if (items.length >= 2) {
            strSchema = items[0];
            strTableName = items[1];
        }
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select COLNAME from syscat.COLUMNS where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s'  and UPPER(COLNAME)='%3$s'", (Object)strSchema.toUpperCase(), (Object)strTableName.toUpperCase(), (Object)iPSDEFDTColumn.getColumnName().toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        Vector list;
        String strSQL;
        CallResult callResult;
        String strTableName = strTableName2;
        String[] items = strTableName.split("[.]");
        String strSchema = iPSDatabase.getDBName();
        if (items.length >= 2) {
            strSchema = items[0];
            strTableName = items[1];
        }
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        if ((callResult = this.selectMulti(iPSDatabase, strSQL = StringHelper.Format((String)"select COLNAME from syscat.COLUMNS where UPPER(TABSCHEMA)='%1$s' and UPPER(TABNAME)='%2$s' ", (Object)strSchema.toUpperCase(), (Object)strTableName.toUpperCase()), null, list = new Vector())).isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u8868\u5217\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ArrayList<String> list2 = new ArrayList<String>();
        for (BaseDataEntity item : list) {
            list2.add(item.getParamStringValue("COLNAME", null));
        }
        return list2;
    }

    protected boolean isViewExists(IPSDatabase iPSDatabase, String strViewName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String[] items = strViewName.split("[.]");
        String strSchema = iPSDatabase.getDBName();
        if (items.length >= 2) {
            strSchema = items[0];
            strViewName = items[1];
        }
        if (bTempMode) {
            strViewName = String.valueOf(strViewName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select VIEWNAME from syscat.VIEWS where UPPER(VIEWSCHEMA)='%1$s' and UPPER(VIEWNAME)='%2$s'", (Object)strSchema.toUpperCase(), (Object)strViewName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select CONSTNAME from SYSCAT.REFERENCES where UPPER(TABSCHEMA)='%1$s' and UPPER(CONSTNAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strFKName.toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    protected void fillCreateTableSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strTableName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        boolean bFirst = true;
        StringBuilderEx sb = new StringBuilderEx();
        String strKeyColumnName = "";
        String strRealTableName = strTableName;
        if (bTempMode) {
            strRealTableName = String.valueOf(strRealTableName) + "_TMP";
        }
        sb.Append("CREATE TABLE %1$s(", (Object)strRealTableName);
        Iterator psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEFDTColumn iPSDEFDTColumn;
            IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
            if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || StringHelper.Compare((String)strTableName, (String)(iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId())).getRealTableName(), (boolean)true) != 0 || bTempMode && !iPSDEField.isEnableTempData()) continue;
            if (bFirst) {
                bFirst = false;
                sb.Append("\n");
            } else {
                sb.Append("\n,");
            }
            if (iPSDEFDTColumn.isPKey()) {
                strKeyColumnName = iPSDEFDTColumn.getColumnName();
                sb.Append("%1$s %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(true, false, false, null));
                if (!bTempMode) continue;
                sb.Append("\n,");
                sb.Append("SRFORIKEY %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                sb.Append("\n,");
                sb.Append("SRFDRAFTFLAG INTEGER ");
                continue;
            }
            sb.Append("%1$s %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
        }
        sb.Append("\n)");
        String strTableSpace = iPSDEDBConfig.getTableSpace();
        if (!StringHelper.IsNullOrEmpty((String)strTableSpace)) {
            sb.Append("IN \"%1$s\"", (Object)strTableSpace);
        }
        sqlList.add(sb.toString());
        sb.Reset();
        if (!StringHelper.IsNullOrEmpty((String)strKeyColumnName)) {
            sb.Append("ALTER TABLE %1$s\n", (Object)strRealTableName);
            sb.Append("ADD PRIMARY KEY (%1$s)\n", (Object)strKeyColumnName);
            sqlList.add(sb.toString());
        }
    }

    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        Vector dataEntities;
        String strSQL = StringHelper.Format((String)"SELECT PARM_MODE,PARAMNAME,TYPENAME FROM  SYSCAT.PROCPARMS WHERE UPPER(PROCSCHEMA)='%1$s' AND UPPER(PROCNAME)='%2$s' ORDER BY ordinal", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strProcName.toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, dataEntities = new Vector());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        SqlParamList sqlParamList = new SqlParamList();
        for (BaseDataEntity baseDataEntity : dataEntities) {
            SqlParam sqlParam = new SqlParam();
            sqlParam.setParamName(baseDataEntity.getParamStringValue("PARAMNAME", ""));
            String strPARM_MODE = baseDataEntity.getParamStringValue("PARM_MODE", "");
            if (StringHelper.Compare((String)strPARM_MODE, (String)"IN", (boolean)true) == 0) {
                sqlParam.setDirection(1);
            } else if (StringHelper.Compare((String)strPARM_MODE, (String)"OUT", (boolean)true) == 0) {
                sqlParam.setDirection(2);
            } else {
                sqlParam.setDirection(3);
            }
            sqlParam.setDataType(DataTypeHelper.FromString((String)baseDataEntity.getParamStringValue("TYPENAME", "")));
            sqlParamList.add((Object)sqlParam);
        }
        return sqlParamList;
    }

    public CallResult compileDBProc(IPSDatabase iPSDatabase, String strProcName, String strProcSQL) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select *  from syscat.PROCEDURES where UPPER(PROCSCHEMA)='%1$s' and UPPER(PROCNAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strProcName.toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        if (!callResult.isError() && (callResult = this.callCreateDBModelSql(iPSDatabase, strSQL = StringHelper.Format((String)"DROP SPECIFIC PROCEDURE \"%1$s\".\"%2$s\" ", (Object)iPSDatabase.getDBName(), (Object)strProcName))).isError()) {
            throw new Exception(StringHelper.Format((String)"\u7f16\u8bd1\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = this.callCreateDBModelSql(iPSDatabase, strProcSQL);
        return callResult;
    }

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CREATE INDEX %1$s", (Object)iPSDEDBIndex.getCodeName());
        stringBuilder.Append(" ON %1$s ", (Object)strTableName);
        stringBuilder.Append("(");
        Iterator psDEDBIndexFields = iPSDEDBIndex.getPSDEDBIndexFields(false);
        boolean bFirst = true;
        while (psDEDBIndexFields.hasNext()) {
            IPSDEDBIndexField iPSDEDBIndexField = (IPSDEDBIndexField)psDEDBIndexFields.next();
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s %2$s ", (Object)iPSDEDBIndexField.getPSDEField().getPSDTColumn(this.getId()).getColumnName(), (Object)iPSDEDBIndexField.getSortDir());
        }
        stringBuilder.Append(")");
        if (iPSDEDBIndex.isAllowReverse()) {
            stringBuilder.Append("  ALLOW REVERSE SCANS ");
        } else {
            stringBuilder.Append("  DISALLOW REVERSE SCANS ");
        }
        return stringBuilder.toString();
    }

    protected String getAfterCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CALL SYSPROC.ADMIN_CMD(' ");
        stringBuilder.Append(" RUNSTATS ON TABLE \"%1$s\" ", (Object)strTableName);
        stringBuilder.Append(" FOR INDEX \"%1$s\" ", (Object)iPSDEDBIndex.getCodeName());
        stringBuilder.Append(" ALLOW READ ACCESS ");
        stringBuilder.Append(" ') ");
        return stringBuilder.toString();
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select INDNAME from syscat.INDEXES where UPPER(INDSCHEMA)='%1$s' and UPPER(INDNAME)='%2$s' ", (Object)iPSDatabase.getDBName(), (Object)strIndexName.toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }
}

