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
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.SqlParamList
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
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.db.SqlParamList;

public class PSSQLiteDBTypeImpl
extends PSDBTypeImpl {
    public static final String SQLite = "SQLite";

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"SELECT m.name as TABLE_NAME FROM sqlite_master m where type='table' and UPPER(name)='%1$s'", (Object)strTableName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        String strSQL = StringHelper.Format((String)"PRAGMA table_info('%1$s')", (Object)strTableName.toUpperCase());
        Connection conn = iPSDatabase.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);
        while (rs.next()) {
            if (StringHelper.Compare((String)iPSDEFDTColumn.getColumnName(), (String)rs.getString("name"), (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        String strTableName = strTableName2;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        String strSQL = StringHelper.Format((String)"PRAGMA table_info('%1$s')", (Object)strTableName.toUpperCase());
        Connection conn = iPSDatabase.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(strSQL);
        ArrayList<String> list2 = new ArrayList<String>();
        while (rs.next()) {
            list2.add(rs.getString("name"));
        }
        return list2;
    }

    protected boolean isViewExists(IPSDatabase iPSDatabase, String strViewName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strViewName = String.valueOf(strViewName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"SELECT m.name as VIEW_NAME FROM sqlite_master m where type='view' and UPPER(name)='%1$s'", (Object)strViewName), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        return true;
    }

    protected void fillCreateTableSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strTableName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        boolean bFirst = true;
        StringBuilderEx sb = new StringBuilderEx();
        String strKeyColumnName = "";
        String strRealTableName = strTableName;
        if (bTempMode) {
            strRealTableName = String.valueOf(strRealTableName) + "_TMP";
        }
        sb.Append("CREATE TABLE %1$s(", (Object)this.getDBObjStandardName(strRealTableName));
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
                sb.Append("\"%1$s\" %2$s PRIMARY KEY ", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(true, false, false, null));
                if (!bTempMode) continue;
                sb.Append("\n,");
                sb.Append("SRFORIKEY %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                sb.Append("\n,");
                sb.Append("SRFDRAFTFLAG INT ");
                continue;
            }
            sb.Append("\"%1$s\" %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
        }
        sb.Append("\n);");
        sqlList.add(sb.toString());
    }

    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult compileDBProc(IPSDatabase iPSDatabase, String strProcName, String strSQL) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append("CREATE INDEX %1$s \n", (Object)iPSDEDBIndex.getCodeName());
        stringBuilder.Append(" ON %1$s \n", (Object)strTableName);
        stringBuilder.Append("(\n");
        Iterator psDEDBIndexFields = iPSDEDBIndex.getPSDEDBIndexFields(false);
        boolean bFirst = true;
        while (psDEDBIndexFields.hasNext()) {
            IPSDEDBIndexField iPSDEDBIndexField = (IPSDEDBIndexField)psDEDBIndexFields.next();
            if (bFirst) {
                bFirst = false;
            } else {
                stringBuilder.Append(",");
            }
            stringBuilder.Append("%1$s %2$s", (Object)iPSDEDBIndexField.getPSDEField().getPSDTColumn(SQLite).getColumnName(), (Object)iPSDEDBIndexField.getSortDir());
        }
        stringBuilder.Append(")\n");
        return stringBuilder.toString();
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"SELECT m.name as TABLE_NAME FROM sqlite_master m where type='index' and UPPER(name)='%1$s' and UPPER(tbl_name)='%2$s'", (Object)strIndexName, (Object)iPSDEDBConfig.getTableName());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    protected void fillCreateTableColumnSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        String strDataType = iPSDEFDTColumn.getDBDataType(false, true, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iPSDEFDTColumn.getPSDEField().getFullName()));
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (bTempMode) {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(String.valueOf(iPSDEFDTColumn.getRealTableName()) + "_TMP"));
        } else {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getRealTableName()));
        }
        sb.Append("ADD %1$s %2$s\n", (Object)iPSDEFDTColumn.getColumnName(), (Object)strDataType);
        sqlList.add(sb.toString());
    }

    public String getDBObjStandardName(String strOriginName) {
        return StringHelper.Format((String)"\"%1$s\"", (Object)strOriginName);
    }
}

