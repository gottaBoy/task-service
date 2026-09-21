/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.DEField.IPSDEField
 *  SA.SRFDA.PS.Core.DEField.IPSPickupDEField
 *  SA.SRFDA.PS.Core.DataEntity.IPSDataEntity
 *  SA.SRFDA.PS.Core.Database.IPSDBType2
 *  SA.SRFDA.PS.Core.Database.IPSDBType3
 *  SA.SRFDA.PS.Core.Database.IPSDEDBConfig
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndex
 *  SA.SRFDA.PS.Core.Database.IPSDEDBIndexField
 *  SA.SRFDA.PS.Core.Database.IPSDEFDTColumn
 *  SA.SRFDA.PS.Core.Database.IPSDatabase
 *  SA.SRFDA.PS.Core.Database.PSDBFunctionImpl
 *  SA.SRFDA.PS.Core.Database.PSDBTypeImpl
 *  SA.SRFDA.PS.Core.IPSTaskServerEnv
 *  SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext
 *  SA.SRFDA.PS.Core.Pub.IPSPublisherContext
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.MySQL5DateDiffNow2DBFunctionImpl
 *  net.ibizsys.paas.db.impl.MySQL5DateDiffNowDBFunctionImpl
 *  net.ibizsys.paas.db.impl.MySQL5StrLenDBFunctionImpl
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBK
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType2;
import SA.SRFDA.PS.Core.Database.IPSDBType3;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndexField;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.PSDBFunctionImpl;
import SA.SRFDA.PS.Core.Database.PSDBTypeImpl;
import SA.SRFDA.PS.Core.Database.Util.MySQLHelper;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParam;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.MySQL5DateDiffNow2DBFunctionImpl;
import net.ibizsys.paas.db.impl.MySQL5DateDiffNowDBFunctionImpl;
import net.ibizsys.paas.db.impl.MySQL5StrLenDBFunctionImpl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBK;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMySQL5DBTypeImpl
extends PSDBTypeImpl
implements IPSDBType2,
IPSDBType3 {
    public static final String MySQL5 = "MYSQL5";
    private static final Log log = LogFactory.getLog(PSMySQL5DBTypeImpl.class);
    private static MySQL5DateDiffNowDBFunctionImpl mySQL5DateDiffNowDBFunctionImpl = new MySQL5DateDiffNowDBFunctionImpl();
    private static MySQL5StrLenDBFunctionImpl mySQL5StrLenDBFunctionImpl = new MySQL5StrLenDBFunctionImpl();
    private static MySQL5DateDiffNow2DBFunctionImpl mySQL5DateDiffNowDB2FunctionImpl = new MySQL5DateDiffNow2DBFunctionImpl();

    public PSMySQL5DBTypeImpl() {
        this.registerDBFunction((IDBFunction)mySQL5DateDiffNowDBFunctionImpl);
        this.registerDBFunction((IDBFunction)mySQL5StrLenDBFunctionImpl);
        this.registerDBFunction((IDBFunction)mySQL5DateDiffNowDB2FunctionImpl);
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("DAYOFWEEK", 9, "DAYOFWEEK(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("DAYOFMONTH", 9, "DAYOFMONTH(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("DAYOFYEAR", 9, "DAYOFYEAR(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("WEEK", 9, "WEEK(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("MONTH", 9, "MONTH(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("QUARTER", 9, "QUARTER(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("YEAR", 9, "YEAR(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("HOUR", 9, "HOUR(%1$s)", 1));
        this.registerDBFunction((IDBFunction)new PSDBFunctionImpl("MINUTE", 9, "MINUTE(%1$s)", 1));
    }

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select TABLE_NAME from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s'  and UPPER(COLUMN_NAME)='%3$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName, (Object)iPSDEFDTColumn.getColumnName().toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        Vector list;
        String strSQL;
        CallResult callResult;
        String strTableName = strTableName2;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        if ((callResult = this.selectMulti(iPSDatabase, strSQL = StringHelper.Format((String)"select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s' ", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName.toUpperCase()), null, list = new Vector())).isError()) {
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
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strViewName = String.valueOf(strViewName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select TABLE_NAME from INFORMATION_SCHEMA.VIEWS where UPPER(TABLE_SCHEMA)='%1$s' and UPPER(TABLE_NAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strViewName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"SELECT CONSTRAINT_NAME FROM `INFORMATION_SCHEMA`.`KEY_COLUMN_USAGE` where UPPER(TABLE_SCHEMA) ='%1$s' AND  UPPER(CONSTRAINT_NAME)='%2$s' AND UPPER(TABLE_NAME)='%3$s' ", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strFKName.toUpperCase(), (Object)iPSDEDBConfig.getTableName().toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    protected void fillCreateTableSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strTableName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        boolean bFirst = true;
        StringBuilderEx sb = new StringBuilderEx();
        String strKeyColumnName = "";
        String strRealTableName = strTableName;
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        if (bTempMode) {
            strRealTableName = String.valueOf(strRealTableName) + strTempTag;
        }
        boolean bPubComment = true;
        if (iPSPublisherContext != null && iPSPublisherContext.getPSSystemDBConfig() != null) {
            bPubComment = iPSPublisherContext.getPSSystemDBConfig().isPubModelComment();
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
                if (iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD.intValue() || iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD2.intValue()) {
                    sb.Append("`%1$s` INT AUTO_INCREMENT PRIMARY KEY", (Object)iPSDEDBConfig.getSaaSDataIdColumnName());
                    sb.Append("\n,");
                    sb.Append("`%1$s` VARCHAR(60)", (Object)iPSDEDBConfig.getSaaSDCIdColumnName());
                    sb.Append("\n,");
                } else if (iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue() || iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD4.intValue()) {
                    sb.Append("`%1$s` VARCHAR(60)", (Object)iPSDEDBConfig.getSaaSDCIdColumnName());
                    sb.Append("\n,");
                }
                strKeyColumnName = iPSDEFDTColumn.getColumnName();
                sb.Append("`%1$s` %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(true, false, false, null));
                if (iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_NOTSUPPORTED.intValue() || iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD3.intValue() || iPSDEDBConfig.getPSDataEntity().getSaaSMode() == IPSDataEntity.SAASMODE_STANDARD4.intValue()) {
                    if (iPSDEFDTColumn.isAutoIncrement()) {
                        sb.Append("AUTO_INCREMENT ");
                    }
                    sb.Append("PRIMARY KEY ");
                }
                if (bPubComment) {
                    sb.Append("COMMENT '%1$s' ", (Object)iPSDEField.getLogicName());
                }
                if (!bTempMode) continue;
                if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                    sb.Append("\n,");
                    sb.Append("`srforikey` %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                    sb.Append("\n,");
                    sb.Append("`srfdraftflag` INT ");
                    continue;
                }
                sb.Append("\n,");
                sb.Append("`SRFORIKEY` %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                sb.Append("\n,");
                sb.Append("`SRFDRAFTFLAG` INT ");
                continue;
            }
            sb.Append("`%1$s` %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
            if (!bPubComment) continue;
            sb.Append("COMMENT '%1$s' ", (Object)iPSDEField.getLogicName());
        }
        sb.Append("\n)");
        if (bPubComment) {
            sb.Append("COMMENT='%1$s'", (Object)iPSDEDBConfig.getPSDataEntity().getLogicName());
        }
        sb.Append(";");
        sqlList.add(sb.toString());
    }

    protected void fillCreateTableColumnSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        String strDataType;
        boolean bPubComment = true;
        if (iPSPublisherContext != null && iPSPublisherContext.getPSSystemDBConfig() != null) {
            bPubComment = iPSPublisherContext.getPSSystemDBConfig().isPubModelComment();
        }
        if (StringHelper.IsNullOrEmpty((String)(strDataType = iPSDEFDTColumn.getDBDataType(false, true, false, "")))) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iPSDEFDTColumn.getPSDEField().getFullName()));
        }
        StringBuilderEx sb = new StringBuilderEx();
        if (bTempMode) {
            String strTempTag = "_TMP";
            if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                strTempTag = "_tmp";
            }
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(String.valueOf(iPSDEFDTColumn.getRealTableName()) + strTempTag));
        } else {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getRealTableName()));
        }
        sb.Append("ADD COLUMN %1$s %2$s", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()), (Object)strDataType);
        if (bPubComment) {
            sb.Append(" COMMENT '%1$s' ", (Object)iPSDEFDTColumn.getPSDEField().getLogicName());
        }
        sb.Append("\n");
        sqlList.add(sb.toString());
    }

    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        Vector dataEntities;
        String strSQL = StringHelper.Format((String)"SELECT PARAMETER_MODE,PARAMETER_NAME,DATA_TYPE FROM  information_schema.PARAMETERS WHERE UPPER(SPECIFIC_SCHEMA)='%1$s' AND UPPER(SPECIFIC_NAME)='%2$s' ORDER BY ORDINAL_POSITION", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strProcName.toUpperCase());
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
            sqlParamList.add((Object)sqlParam);
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

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        if (StringHelper.Compare((String)iPSDEDBIndex.getIndexType(), (String)"UNIQUE", (boolean)false) == 0) {
            stringBuilder.Append(" CREATE UNIQUE INDEX `%1$s` ", (Object)iPSDEDBIndex.getCodeName());
        } else {
            stringBuilder.Append(" CREATE INDEX `%1$s` ", (Object)iPSDEDBIndex.getCodeName());
        }
        stringBuilder.Append(" ON `%1$s` ", (Object)strTableName);
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
            stringBuilder.Append("`%1$s` %2$s", (Object)iPSDEDBIndexField.getPSDEField().getPSDTColumn(MySQL5).getColumnName(), (Object)iPSDEDBIndexField.getSortDir());
        }
        stringBuilder.Append(")");
        return stringBuilder.toString();
    }

    protected String getDropIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        return StringHelper.Format((String)"DROP INDEX `%1$s` ON `%2$s`", (Object)iPSDEDBIndex.getCodeName(), (Object)iPSDEDBConfig.getTableName().toUpperCase());
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"SELECT INDEX_NAME FROM `INFORMATION_SCHEMA`.`STATISTICS` where UPPER(TABLE_SCHEMA) ='%1$s' AND UPPER(INDEX_NAME) ='%2$s' AND UPPER(TABLE_NAME)='%3$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strIndexName.toUpperCase(), (Object)iPSDEDBConfig.getTableName().toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, dataEntity = new BaseDataEntity());
        return !callResult.isError();
    }

    public String getDBObjStandardName(String strOriginName) {
        String[] items = strOriginName.split("[.]");
        if (items.length == 1) {
            return StringHelper.Format((String)"`%1$s`", (Object)strOriginName);
        }
        net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
        int i = 0;
        while (i < items.length) {
            if (i != 0) {
                sb.append(".");
            }
            sb.append("`%1$s`", (Object)items[i]);
            ++i;
        }
        return sb.toString();
    }

    public CallResult clearLocks(IPSDatabase iPSDatabase, int nTimeout) throws Exception {
        Vector list;
        String strSQL = StringHelper.Format((String)"select trx_mysql_thread_id from information_schema.innodb_trx");
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, list = new Vector());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u8868\u4e8b\u7269\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (list.size() == 0) {
            return callResult;
        }
        HashMap<Integer, String> threadIdMap = new HashMap<Integer, String>();
        for (BaseDataEntity BaseDataEntity2 : list) {
            threadIdMap.put(BaseDataEntity2.GetParamIntValue("trx_mysql_thread_id", 0), "");
        }
        Vector list2 = new Vector();
        callResult = this.selectMulti(iPSDatabase, "show  processlist", null, list2);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u8868\u4f5c\u4e1a\u6e05\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (BaseDataEntity process : list2) {
            int nTime;
            int nId = process.GetParamIntValue("id", -1);
            if (!threadIdMap.containsKey(nId) || (nTime = process.GetParamIntValue("time", 120)) <= nTimeout) continue;
            log.warn((Object)StringHelper.Format((String)"\u6e05\u9664\u6570\u636e\u5e93\u8d85\u65f6\u4e8b\u7269\u8fdb\u7a0b[%1$s|%2$s|%3$s]", (Object)nId, (Object)process.getParamValue("host"), (Object)process.getParamValue("user")));
            this.callCreateDBModelSql(iPSDatabase, StringHelper.Format((String)"kill %1$s", (Object)nId));
        }
        return callResult;
    }

    public CallResult getTables(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        String strSQL = StringHelper.Format((String)"select `TABLE_NAME` AS `NAME` from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s' and TABLE_TYPE='BASE TABLE' and UPPER(TABLE_NAME) LIKE '%%%2$s%%'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strFilter.toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, list);
        return callResult;
    }

    public CallResult getViews(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        String strSQL = StringHelper.Format((String)"select `TABLE_NAME` AS `NAME` from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s' and TABLE_TYPE='VIEW' and UPPER(TABLE_NAME) LIKE '%%%2$s%%'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strFilter.toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, list);
        return callResult;
    }

    public CallResult getFunctions(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult getIndices(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult getProceduces(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        return null;
    }

    public CallResult getSequenses(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult getTableColumns(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult getViewColumns(IPSDatabase iPSDatabase, String strFilter, Vector<BaseDataEntity> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult generateSQL(IPSDatabase iPSDatabase, String strDBObjType, String strDBObject, String strCodeType, Vector<BaseDataEntity> list) throws Exception {
        if (StringHelper.Compare((String)strDBObjType, (String)"TABLE", (boolean)true) == 0) {
            if (StringHelper.Compare((String)strCodeType, (String)"CREATEMODEL", (boolean)true) == 0) {
                BaseDataEntity model;
                String strSQL = StringHelper.Format((String)"SHOW CREATE TABLE %1$s", (Object)strDBObject);
                CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, model = new BaseDataEntity());
                if (callResult.isError()) {
                    return callResult;
                }
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", model.get("Create Table"));
                list.add(sqlModel);
                return callResult;
            }
            if (StringHelper.Compare((String)strCodeType, (String)"INSERTDATA", (boolean)true) == 0) {
                CallResult callResult = new CallResult();
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", (Object)StringHelper.Format((String)"INSERT INTO %1$s () VALUES ()", (Object)strDBObject));
                list.add(sqlModel);
                return callResult;
            }
            if (StringHelper.Compare((String)strCodeType, (String)"SELECTDATA", (boolean)true) == 0) {
                CallResult callResult = new CallResult();
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", (Object)StringHelper.Format((String)"SELECT t1.* FROM %1$s t1", (Object)strDBObject));
                list.add(sqlModel);
                return callResult;
            }
            if (StringHelper.Compare((String)strCodeType, (String)"SELECTCOUNT", (boolean)true) == 0) {
                CallResult callResult = new CallResult();
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", (Object)StringHelper.Format((String)"SELECT COUNT(*) FROM %1$s t1", (Object)strDBObject));
                list.add(sqlModel);
                return callResult;
            }
        }
        if (StringHelper.Compare((String)strDBObjType, (String)"VIEW", (boolean)true) == 0) {
            if (StringHelper.Compare((String)strCodeType, (String)"CREATEMODEL", (boolean)true) == 0) {
                BaseDataEntity model;
                String strSQL = StringHelper.Format((String)"SHOW CREATE VIEW %1$s", (Object)strDBObject);
                CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, model = new BaseDataEntity());
                if (callResult.isError()) {
                    return callResult;
                }
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", model.get("Create View"));
                list.add(sqlModel);
                return callResult;
            }
            if (StringHelper.Compare((String)strCodeType, (String)"SELECTDATA", (boolean)true) == 0) {
                CallResult callResult = new CallResult();
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", (Object)StringHelper.Format((String)"SELECT t1.* FROM %1$s t1", (Object)strDBObject));
                list.add(sqlModel);
                return callResult;
            }
            if (StringHelper.Compare((String)strCodeType, (String)"SELECTCOUNT", (boolean)true) == 0) {
                CallResult callResult = new CallResult();
                BaseDataEntity sqlModel = new BaseDataEntity();
                sqlModel.set("SQL", (Object)StringHelper.Format((String)"SELECT COUNT(*) FROM %1$s t1", (Object)strDBObject));
                list.add(sqlModel);
                return callResult;
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u4ea7\u751f\u6570\u636e\u5e93\u6a21\u578b\u4ee3\u7801\uff0c[%1$s-%2$s]", (Object)strDBObjType, (Object)strCodeType));
    }

    public CallResult executeSQL(IPSDatabase iPSDatabase, String strSQL, Vector<BaseDataEntity> list) throws Exception {
        CallResult callResult = new CallResult();
        Connection connection = iPSDatabase.getConnection();
        SelectResult selectResult = this.invokeSQL(connection, strSQL, null, -1, 50);
        connection.close();
        if (selectResult == null || selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
            if (selectResult != null) {
                callResult.from((DBResult)selectResult);
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u4e0d\u660e\u9519\u8bef\uff0c%1$s", (Object)strSQL));
            }
            return callResult;
        }
        JSONObject jo = new JSONObject();
        jo.put("updatecount", selectResult.getUpdateCount());
        if (selectResult.getMainTable() != null) {
            ArrayList<String> columnList = new ArrayList<String>();
            int nColCount = selectResult.getMainTable().GetColumnCount();
            int i = 0;
            while (i < nColCount) {
                String strName = selectResult.getMainTable().GetDataColumn(i).getName();
                columnList.add(strName);
                ++i;
            }
            jo.put("columns", (Object)JSONArray.fromArray((Object[])columnList.toArray()));
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i2 = 0;
            while (i2 < nRowCount) {
                BaseDataEntity baseDataEntity = new BaseDataEntity();
                baseDataEntity.FromDataRow(selectResult.getMainTable().GetRow(i2));
                list.add(baseDataEntity);
                ++i2;
            }
        }
        callResult.setRetCode(0);
        callResult.setUserObject((Object)jo);
        return callResult;
    }

    public CallResult getDBUsedSize(IPSDatabase iPSDatabase, BaseDataEntity entity) throws Exception {
        String strSQL = StringHelper.Format((String)"select round(sum(`data_length`/1024)) AS `USEDSIZE`, round(sum(`table_rows`)) AS `ROWCNT` from INFORMATION_SCHEMA.TABLES where UPPER(TABLE_SCHEMA)='%1$s'", (Object)iPSDatabase.getDBName().toUpperCase());
        CallResult callResult = this.selectSingle(iPSDatabase, strSQL, null, entity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    public CallResult getTableSummaries(IPSDatabase iPSDatabase, Vector<BaseDataEntity> list) throws Exception {
        String strSQL = StringHelper.Format((String)"select `TABLE_NAME`,`TABLE_ROWS` as `ROWCNT`,(`DATA_LENGTH`/1024) AS  `USEDSIZE` from INFORMATION_SCHEMA.TABLES where TABLE_TYPE ='BASE TABLE' AND UPPER(TABLE_SCHEMA)='%1$s' ", (Object)iPSDatabase.getDBName().toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, list);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    protected void backupPSSysModelInst(PSSysModelInst psSysModelInst, PSSysModelInstBK dbBackupData, boolean bOffline) throws Exception {
    }

    protected void backupPSDBDevInst(PSDBDevInst psDBDevInst, PSDBDevInstBK dbBackupData, boolean bOffline) throws Exception {
    }

    protected void onBackupPSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        MySQLHelper.backupDBInst(strFullBKFilePath, psDCDBInst, dbBackupData, psDBDevInst, psDBServer, psAppServer);
    }

    protected void onOfflinePSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
    }

    protected void restorePSSysModelInst(PSSysModelInst psSysModelInst, PSSysModelInstBK dbBackupData) throws Exception {
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        PSDBServer psDBServer = psSysModelInst.getPSDBServer();
        if (psDBServer == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u6a21\u578b\u7684\u6570\u636e\u5e93\u670d\u52a1\u5668");
        }
    }

    protected void restorePSDBDevInst(PSDBDevInst psDBDevInst, PSDBDevInstBK dbBackupData) throws Exception {
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        PSDBServer psDBServer = psDBDevInst.getPSDBServer();
        if (psDBServer == null) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u5b9e\u4f8b\u7684\u6570\u636e\u5e93\u670d\u52a1\u5668");
        }
    }

    protected void onRestorePSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        MySQLHelper.restoreDBInst(strFullBKFilePath, psDCDBInst, dbBackupData, psDBDevInst, psDBServer, psAppServer);
    }

    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, boolean bTempMode) throws Exception {
        super.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, bTempMode);
        IPSDataEntity iPSDataEntity = iPSDEDBConfig.getPSDataEntity();
        if (!iPSDataEntity.isSubSysDE() && !bTempMode) {
            iPSDataEntity.isVirtual();
        }
    }
}

