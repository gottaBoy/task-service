/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DEField.IPSPickupDEField
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Database.IPSDEDBConfig
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndex
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndexField
 *  SA.SRFDA.PS.Core.Database.IPSDEFDTColumn
 *  SA.SRFDA.PS.Core.Database.IPSDatabase
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFDA.PS.Data.PSSysDMItem
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.PPASDateDiffNow2DBFunctionImpl
 *  net.ibizsys.paas.db.impl.PPASDateDiffNowDBFunctionImpl
 *  net.ibizsys.paas.db.impl.PPASStrLenDBFunctionImpl
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSSysDMItem;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.PPAS.PPASDataSet;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.PPASDateDiffNow2DBFunctionImpl;
import net.ibizsys.paas.db.impl.PPASDateDiffNowDBFunctionImpl;
import net.ibizsys.paas.db.impl.PPASStrLenDBFunctionImpl;

public class PSPPASDBTypeImpl
extends PSDBTypeImpl {
    public static final String PPAS = "PPAS";
    private static PPASDateDiffNowDBFunctionImpl ppasDateDiffNowDBFunctionImpl = new PPASDateDiffNowDBFunctionImpl();
    private static PPASStrLenDBFunctionImpl ppasStrLenDBFunctionImpl = new PPASStrLenDBFunctionImpl();
    private static PPASDateDiffNow2DBFunctionImpl ppasDateDiffNowDB2FunctionImpl = new PPASDateDiffNow2DBFunctionImpl();

    public PSPPASDBTypeImpl() {
        this.registerDBFunction((IDBFunction)ppasDateDiffNowDBFunctionImpl);
        this.registerDBFunction((IDBFunction)ppasStrLenDBFunctionImpl);
        this.registerDBFunction((IDBFunction)ppasDateDiffNowDB2FunctionImpl);
    }

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        strTableName = strTableName.toUpperCase();
        String strSQL = "";
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"select TABLE_NAME from user_tables where  UPPER(TABLE_NAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName);
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"select TABLE_NAME from all_tables where  UPPER(OWNER)='%1$s' AND UPPER(TABLE_NAME)='%2$s'", (Object)items[0].toUpperCase(), (Object)items[1].toUpperCase());
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity);
        return !callResult.isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        strTableName = strTableName.toUpperCase();
        String strSQL = "";
        String strColumnName = iPSDEFDTColumn.getColumnName().toUpperCase();
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"select COLUMN_NAME from user_tab_columns where   UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)strDBSCHEMA, (Object)strTableName, (Object)strColumnName);
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"select COLUMN_NAME from all_tab_columns where UPPER(OWNER)='%1$s' AND  UPPER(TABLE_NAME)='%2$s' AND UPPER(COLUMN_NAME)='%3$s'", (Object)items[0], (Object)items[1], (Object)strColumnName);
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity);
        return !callResult.isError();
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        String strTableName = strTableName2;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        strTableName = strTableName.toUpperCase();
        String strSQL = "";
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        if (strTableName.indexOf(".") == -1) {
            strSQL = StringHelper.Format((String)"SELECT COLUMN_NAME FROM user_tab_columns WHERE UPPER(TABLE_NAME)='%2$s' ", (Object)strDBSCHEMA, (Object)strTableName);
        } else {
            String[] items = strTableName.split("[.]");
            strSQL = StringHelper.Format((String)"SELECT COLUMN_NAME FROM all_tab_columns where UPPER(OWNER)='%1$s' AND  UPPER(TABLE_NAME)='%2$s' ", (Object)items[0], (Object)items[1]);
        }
        Vector<BaseDataEntity> list = new Vector();
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u8868\u5217\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ArrayList<String> list2 = new ArrayList<String>();
        for (BaseDataEntity item : list) {
            list2.add(item.getParamStringValue("COLUMN_NAME", null));
        }
        return list2;
    }

    protected boolean isViewExists(IPSDatabase iPSDatabase, String strViewName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strDBSCHEMA;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strViewName = String.valueOf(strViewName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select VIEW_NAME from sys.user_views where  UPPER(VIEW_NAME)='%2$s'", (Object)(strDBSCHEMA = iPSDatabase.getDBName().toUpperCase()), (Object)strViewName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
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
        sqlList.add(sb.toString());
        sb.Reset();
        if (!StringHelper.IsNullOrEmpty((String)strKeyColumnName)) {
            sb.Append("ALTER TABLE %1$s\n", (Object)strRealTableName);
            sb.Append("ADD PRIMARY KEY (%1$s)\n", (Object)strKeyColumnName);
            sqlList.add(sb.toString());
        }
    }

    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        Vector<BaseDataEntity> dataEntities;
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        String strSQL = StringHelper.Format((String)"SELECT PARAMETER_MODE,PARAMETER_NAME,DATA_TYPE FROM  information_schema.PARAMETERS WHERE UPPER(SPECIFIC_SCHEMA)='%1$s' AND UPPER(SPECIFIC_NAME)='%2$s' ORDER BY ORDINAL_POSITION", (Object)strDBSCHEMA, (Object)strProcName.toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, dataEntities = new Vector());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        SqlParamList sqlParamList = new SqlParamList();
        for (BaseDataEntity baseDataEntity : dataEntities) {
            SqlParam sqlParam = new SqlParam();
            sqlParam.setParamName(baseDataEntity.getParamStringValue("PARAMETER_NAME", ""));
            String strPARAMETER_MODE = baseDataEntity.getParamStringValue("PARAMETER_MODE", "");
            if (StringHelper.Compare((String)strPARAMETER_MODE, (String)"IN", (boolean)true) == 0) {
                sqlParam.setDirection(1);
            } else if (StringHelper.Compare((String)strPARAMETER_MODE, (String)"OUT", (boolean)true) == 0) {
                sqlParam.setDirection(2);
            } else {
                sqlParam.setDirection(3);
            }
            sqlParam.setDataType(DataTypeHelper.FromString((String)baseDataEntity.getParamStringValue("DATA_TYPE", "")));
            sqlParamList.add(sqlParam);
        }
        return sqlParamList;
    }

    public CallResult compileDBProc(IPSDatabase iPSDatabase, String strProcName, String strSQL) throws Exception {
        CallResult callResult = this.callCreateDBModelSql(iPSDatabase, StringHelper.Format((String)"DROP PROCEDURE IF EXISTS `%1$s`", (Object)strProcName));
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u7f16\u8bd1\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
        return callResult;
    }

    protected DataSet createDataSet() {
        return new PPASDataSet();
    }

    protected void fillCreateTableColumnSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        String strDataType = iPSDEFDTColumn.getDBDataType(false, true, false, "");
        if (StringHelper.IsNullOrEmpty((String)strDataType)) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iPSDEFDTColumn.getPSDEField().getFullName()));
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (bTempMode) {
            sb.Append("ALTER TABLE %1$s_TMP\n", (Object)iPSDEFDTColumn.getRealTableName());
        } else {
            sb.Append("ALTER TABLE %1$s\n", (Object)iPSDEFDTColumn.getRealTableName());
        }
        sb.Append("ADD %1$s %2$s\n", (Object)iPSDEFDTColumn.getColumnName(), (Object)strDataType);
        sqlList.add(sb.toString());
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        BaseDataEntity dataEntity;
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        String strSQL = StringHelper.Format((String)"select CONSTRAINT_NAME from sys.user_constraints where  UPPER(TABLE_NAME)='%2$s' AND CONSTRAINT_TYPE = 'R' AND CONSTRAINT_NAME='%3$s' ", (Object)strDBSCHEMA, (Object)iPSDEFDTColumn.getRealTableName().toUpperCase(), (Object)strFKName);
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CREATE INDEX %1$s ", (Object)iPSDEDBIndex.getCodeName());
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
            stringBuilder.Append("  REVERSE ");
        }
        return stringBuilder.toString();
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select INDEX_NAME from USER_INDEXES where  UPPER(INDEX_NAME)='%2$s'", (Object)iPSDatabase.getDBName(), (Object)strIndexName.toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    protected String getCreateViewSql(IPSDBPublisherContext iPSPublisherContext, IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode) throws Exception {
        String strSql = super.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, bTempMode);
        if (strSql.indexOf("CREATE ") == 0) {
            strSql = "CREATE OR REPLACE " + strSql.substring(7);
        }
        return strSql;
    }

    protected void savePSSysDMItem(IPSPublisherContext iPSPublisherContext, PSSysDMItem psSysDMItem, Object obj) throws Exception {
        if (StringHelper.Compare((String)psSysDMItem.getDBOBJTYPE(), (String)"TABLE", (boolean)true) == 0) {
            if (obj != null && obj instanceof IPSDataEntity) {
                IPSDataEntity iPSDataEntity = (IPSDataEntity)obj;
                psSysDMItem.setCREATESQL5(StringHelper.Format((String)"COMMENT ON TABLE %1$s IS '%2$s'", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDataEntity.getLogicName()));
            }
        } else if (StringHelper.Compare((String)psSysDMItem.getDBOBJTYPE(), (String)"COLUMN", (boolean)true) == 0 && obj != null && obj instanceof IPSDEFDTColumn) {
            IPSDEFDTColumn iPSDEFDTColumn = (IPSDEFDTColumn)obj;
            psSysDMItem.setCREATESQL5(StringHelper.Format((String)"COMMENT ON COLUMN %1$s IS '%2$s'", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDEFDTColumn.getPSDEField().getLogicName()));
        }
        super.savePSSysDMItem(iPSPublisherContext, psSysDMItem, obj);
    }

    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, boolean bTempMode) throws Exception {
        super.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, bTempMode);
        if (!iPSDEDBConfig.getPSDataEntity().isSubSysDE() && !bTempMode) {
            String strSQL = StringHelper.Format((String)"COMMENT ON TABLE %1$s IS '%2$s'", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEDBConfig.getPSDataEntity().getLogicName());
            CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            if (callResult.isError()) {
                throw new Exception(callResult.getErrorInfo());
            }
            Iterator psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
            while (psDEFields.hasNext()) {
                String strSQL2;
                CallResult callResult2;
                IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
                if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
                IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
                if (StringHelper.Compare((String)iPSDEDBConfig.getTableName(), (String)iPSDEFDTColumn.getRealTableName(), (boolean)true) != 0 || !(callResult2 = this.callCreateDBModelSql(iPSDatabase, strSQL2 = StringHelper.Format((String)"COMMENT ON COLUMN %1$s.%2$s IS '%3$s'", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEFDTColumn.getColumnName().toUpperCase(), (Object)iPSDEField.getLogicName()))).isError()) continue;
                throw new Exception(callResult2.getErrorInfo());
            }
        }
    }
}

