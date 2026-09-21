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
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.SqlParam
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.HANADateDiffNow2DBFunctionImpl
 *  net.ibizsys.paas.db.impl.HANADateDiffNowDBFunctionImpl
 *  net.ibizsys.paas.db.impl.HANAStrLenDBFunctionImpl
 *  net.ibizsys.paas.util.StringBuilderEx
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
import SA.SRFramework.Data.DataTypeHelper;
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
import net.ibizsys.paas.db.impl.HANADateDiffNow2DBFunctionImpl;
import net.ibizsys.paas.db.impl.HANADateDiffNowDBFunctionImpl;
import net.ibizsys.paas.db.impl.HANAStrLenDBFunctionImpl;

public class PSHANADBTypeImpl
extends PSDBTypeImpl {
    public static final String HANA = "HANA";
    private static HANADateDiffNowDBFunctionImpl hanaDateDiffNowDBFunctionImpl = new HANADateDiffNowDBFunctionImpl();
    private static HANAStrLenDBFunctionImpl hanaStrLenDBFunctionImpl = new HANAStrLenDBFunctionImpl();
    private static HANADateDiffNow2DBFunctionImpl hanaDateDiffNowDB2FunctionImpl = new HANADateDiffNow2DBFunctionImpl();

    public PSHANADBTypeImpl() {
        this.registerDBFunction((IDBFunction)hanaDateDiffNowDBFunctionImpl);
        this.registerDBFunction((IDBFunction)hanaStrLenDBFunctionImpl);
        this.registerDBFunction((IDBFunction)hanaDateDiffNowDB2FunctionImpl);
    }

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select V.TABLE_NAME from SYS.CS_TABLES_ V where upper(TABLE_NAME)='%1$s'", (Object)strTableName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select V.COLUMN_NAME from SYS.CS_COLUMNS_ V LEFT JOIN SYS.CS_TABLES_ V1 ON V1.TABLE_OID=V.TABLE_OID where UPPER(V1.SCHEMA_NAME)='%1$s' and UPPER(V1.TABLE_NAME)='%2$s'  and UPPER(V.COLUMN_NAME)='%3$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName, (Object)iPSDEFDTColumn.getColumnName().toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        Vector list;
        String strSQL;
        CallResult callResult;
        String strTableName = strTableName2;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        if ((callResult = this.selectMulti(iPSDatabase, strSQL = StringHelper.Format((String)"select  V.COLUMN_NAME from SYS.CS_COLUMNS_ V LEFT JOIN SYS.CS_TABLES_ V1 ON V1.TABLE_OID=V.TABLE_OID where UPPER(V1.SCHEMA_NAME)='%1$s' and UPPER(V1.TABLE_NAME)='%2$s' AND V.USAGE_TYPE_FLAGS=1", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strTableName.toUpperCase()), null, list = new Vector())).isError()) {
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
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select NAME from SYS.RS_VIEWS where UPPER(SCHEMA)='%1$s' and UPPER(NAME)='%2$s'", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strViewName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        BaseDataEntity dataEntity;
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        String strSQL = StringHelper.Format((String)"select NAME from sys.CS_JOIN_CONSTRAINTS_ where  UPPER(ATTR_TABLE_NAME)='%1$s' AND ATTR_FIELD_NAME = 'KEY' AND NAME='%2$s' ", (Object)iPSDEFDTColumn.getRealTableName().toUpperCase(), (Object)strFKName);
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
                sb.Append("\"%1$s\" %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(true, false, false, null));
                if (!bTempMode) continue;
                sb.Append("\n,");
                sb.Append("\"SRFORIKEY\" %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                sb.Append("\n,");
                sb.Append("\"SRFDRAFTFLAG\" INT ");
                continue;
            }
            sb.Append("\"%1$s\" %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
        }
        sb.Append("\n);");
        sqlList.add(sb.toString());
        sb.Reset();
        if (!StringHelper.IsNullOrEmpty((String)strKeyColumnName)) {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(strRealTableName));
            sb.Append("ADD PRIMARY KEY (%1$s);\n", (Object)this.getDBObjStandardName(strKeyColumnName));
            sqlList.add(sb.toString());
        }
    }

    public SqlParamList getDBProcParamList(IPSDatabase iPSDatabase, String strProcName) throws Exception {
        Vector dataEntities;
        String strDBSCHEMA = iPSDatabase.getDBName().toUpperCase();
        String strSQL = StringHelper.Format((String)"select PARAMNAME as PARAMETER_NAME,MODE as PARAMETER_MODE from sys.P_PROCPARAMS_ V LEFT JOIN SYS.P_PROCEDURES_ V1 ON V1.OID=V.PID where UPPER (V1.SCHEMA)='%1$S' UPPER(V1.NAME)='%2$s'   order by position", (Object)strDBSCHEMA, (Object)strProcName.toUpperCase());
        CallResult callResult = this.selectMulti(iPSDatabase, strSQL, null, dataEntities = new Vector());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u53c2\u6570\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        SqlParamList sqlParamList = new SqlParamList();
        for (BaseDataEntity baseDataEntity : dataEntities) {
            SqlParam sqlParam = new SqlParam();
            sqlParam.setParamName(baseDataEntity.getParamStringValue("PARAMETER_NAME", ""));
            String strPARAMETER_MODE = baseDataEntity.getParamStringValue("PARAMETER_MODE", "");
            if (StringHelper.Compare((String)strPARAMETER_MODE, (String)"1", (boolean)true) == 0) {
                sqlParam.setDirection(1);
            } else if (StringHelper.Compare((String)strPARAMETER_MODE, (String)"4", (boolean)true) == 0) {
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
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = this.selectSingle(iPSDatabase, StringHelper.Format((String)"select 1 from \"SYS\".\"P_PROCEDURES_\" where \"NAME\"='%1$s'", (Object)strProcName), null, dataEntity);
        if (callResult.isOk()) {
            callResult = this.callCreateDBModelSql(iPSDatabase, StringHelper.Format((String)"DROP PROCEDURE \"%1$s\"", (Object)strProcName));
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u7f16\u8bd1\u5b58\u50a8\u8fc7\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            return callResult;
        }
        return new CallResult();
    }

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append(" CREATE INDEX \"%1$s\" ", (Object)iPSDEDBIndex.getCodeName());
        stringBuilder.Append(" ON \"%1$s\" ", (Object)strTableName);
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
            stringBuilder.Append("\"%1$s\" %2$s ", (Object)iPSDEDBIndexField.getPSDEField().getPSDTColumn(this.getId()).getColumnName(), (Object)iPSDEDBIndexField.getSortDir());
        }
        stringBuilder.Append(")");
        if (iPSDEDBIndex.isAllowReverse()) {
            stringBuilder.Append("  REVERSE ");
        }
        return stringBuilder.toString();
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select INDEX_NAME from P_INDEXES_ where upper(SCHEMA)='%1$s' and UPPER(NAME)='%2$s'", (Object)iPSDatabase.getDBName(), (Object)strIndexName.toUpperCase());
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
        sb.Append("ADD (%1$s %2$s)\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()), (Object)strDataType);
        sqlList.add(sb.toString());
    }

    public String getDBObjStandardName(String strOriginName) {
        String[] items = strOriginName.split("[.]");
        if (items.length == 1) {
            return StringHelper.Format((String)"\"%1$s\"", (Object)strOriginName);
        }
        net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
        int i = 0;
        while (i < items.length) {
            if (i != 0) {
                sb.append(".");
            }
            sb.append("\"%1$s\"", (Object)items[i]);
            ++i;
        }
        return sb.toString();
    }

    protected void savePSSysDMItem(IPSPublisherContext iPSPublisherContext, PSSysDMItem psSysDMItem, Object obj) throws Exception {
        IPSDBPublisherContext iPSDBPublisherContext;
        boolean bPubComment = true;
        if (iPSPublisherContext instanceof IPSDBPublisherContext && (iPSDBPublisherContext = (IPSDBPublisherContext)iPSPublisherContext) != null && iPSDBPublisherContext.getPSSystemDBConfig() != null) {
            bPubComment = iPSDBPublisherContext.getPSSystemDBConfig().isPubModelComment();
        }
        if (StringHelper.Compare((String)psSysDMItem.getDBOBJTYPE(), (String)"TABLE", (boolean)true) == 0) {
            if (obj != null && obj instanceof IPSDataEntity) {
                IPSDataEntity iPSDataEntity = (IPSDataEntity)obj;
                if (bPubComment) {
                    psSysDMItem.setCREATESQL5(StringHelper.Format((String)"COMMENT ON TABLE \"%1$s\" IS '%2$s'", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDataEntity.getLogicName()));
                } else {
                    psSysDMItem.setCREATESQL5("");
                }
            }
        } else if (StringHelper.Compare((String)psSysDMItem.getDBOBJTYPE(), (String)"COLUMN", (boolean)true) == 0 && obj != null && obj instanceof IPSDEFDTColumn) {
            IPSDEFDTColumn iPSDEFDTColumn = (IPSDEFDTColumn)obj;
            if (bPubComment) {
                psSysDMItem.setCREATESQL5(StringHelper.Format((String)"COMMENT ON COLUMN %1$s IS '%2$s'", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDEFDTColumn.getPSDEField().getLogicName()));
            } else {
                psSysDMItem.setCREATESQL5("");
            }
        }
        super.savePSSysDMItem(iPSPublisherContext, psSysDMItem, obj);
    }

    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, boolean bTempMode) throws Exception {
        super.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, bTempMode);
        if (!(iPSDEDBConfig.getPSDataEntity().isSubSysDE() || bTempMode || iPSDEDBConfig.getPSDataEntity().isVirtual())) {
            String strSQL;
            CallResult callResult;
            IPSDBPublisherContext iPSDBPublisherContext;
            boolean bPubComment = true;
            if (iPSPublisherContext instanceof IPSDBPublisherContext && (iPSDBPublisherContext = (IPSDBPublisherContext)iPSPublisherContext) != null && iPSDBPublisherContext.getPSSystemDBConfig() != null) {
                bPubComment = iPSDBPublisherContext.getPSSystemDBConfig().isPubModelComment();
            }
            if (bPubComment && (callResult = this.callCreateDBModelSql(iPSDatabase, strSQL = StringHelper.Format((String)"COMMENT ON TABLE \"%1$s\" IS '%2$s'", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEDBConfig.getPSDataEntity().getLogicName()))).isError()) {
                throw new Exception(callResult.getErrorInfo());
            }
            if (bPubComment) {
                Iterator psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
                while (psDEFields.hasNext()) {
                    String strSQL2;
                    CallResult callResult2;
                    IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
                    if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
                    IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
                    if (StringHelper.Compare((String)iPSDEDBConfig.getTableName(), (String)iPSDEFDTColumn.getRealTableName(), (boolean)true) != 0 || !(callResult2 = this.callCreateDBModelSql(iPSDatabase, strSQL2 = StringHelper.Format((String)"COMMENT ON COLUMN \"%1$s\".\"%2$s\" IS '%3$s'", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEFDTColumn.getColumnName().toUpperCase(), (Object)iPSDEField.getLogicName()))).isError()) continue;
                    throw new Exception(callResult2.getErrorInfo());
                }
            }
        }
    }
}

