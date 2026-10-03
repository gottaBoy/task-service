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
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.db.impl.MSSQLDateDiffNow2DBFunctionImpl
 *  net.ibizsys.paas.db.impl.MSSQLDateDiffNowDBFunctionImpl
 *  net.ibizsys.paas.db.impl.MSSQLStrLenDBFunctionImpl
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
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.db.impl.MSSQLDateDiffNow2DBFunctionImpl;
import net.ibizsys.paas.db.impl.MSSQLDateDiffNowDBFunctionImpl;
import net.ibizsys.paas.db.impl.MSSQLStrLenDBFunctionImpl;

public class PSMSSQLDBTypeImpl
extends PSDBTypeImpl {
    public static final String SQLSERVER = "SQLSERVER";
    private static MSSQLDateDiffNowDBFunctionImpl mssqlDateDiffNowDBFunctionImpl = new MSSQLDateDiffNowDBFunctionImpl();
    private static MSSQLStrLenDBFunctionImpl mssqlStrLenDBFunctionImpl = new MSSQLStrLenDBFunctionImpl();
    private static MSSQLDateDiffNow2DBFunctionImpl mssqlDateDiffNowDB2FunctionImpl = new MSSQLDateDiffNow2DBFunctionImpl();

    public PSMSSQLDBTypeImpl() {
        this.registerDBFunction((IDBFunction)mssqlDateDiffNowDBFunctionImpl);
        this.registerDBFunction((IDBFunction)mssqlStrLenDBFunctionImpl);
        this.registerDBFunction((IDBFunction)mssqlDateDiffNowDB2FunctionImpl);
    }

    protected boolean isTableExists(IPSDatabase iPSDatabase, String strTableName, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select v.name as [TABLE_NAME] from dbo.sysobjects v where xtype='U' and v.status>=0 and UPPER(v.name)='%1$s'", (Object)strTableName.toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isTableColumnExists(IPSDatabase iPSDatabase, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL;
        CallResult callResult;
        String strTableName = iPSDEFDTColumn.getRealTableName().toUpperCase();
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"select t.name as [COLUMN_NAME] from    sys.all_columns t inner join sys.sysobjects p     on t.object_id=p.id where p.status>=0 and p.xtype='U' and       UPPER(p.name)='%1$s' AND UPPER(t.name)='%2$s'", (Object)strTableName.toUpperCase(), (Object)iPSDEFDTColumn.getColumnName().toUpperCase()), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected ArrayList<String> getTableColumns(IPSDatabase iPSDatabase, String strTableName2, boolean bTempMode) throws Exception {
        Vector<BaseDataEntity> list;
        String strSQL;
        CallResult callResult;
        String strTableName = strTableName2;
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + "_TMP";
        }
        if ((callResult = this.selectMulti(iPSDatabase, strSQL = StringHelper.Format((String)"select t.name as [COLUMN_NAME] from    sys.all_columns t inner join sys.sysobjects p     on t.object_id=p.id where p.status>=0 and p.xtype='U' and       UPPER(p.name)='%1$s'", (Object)strTableName.toUpperCase()), null, list = new Vector())).isError()) {
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
        return !(callResult = this.selectSingle(iPSDatabase, strSQL = StringHelper.Format((String)"SELECT object_id as [TABLE_NAME]  FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[%1$s]')", (Object)strViewName), null, dataEntity = new BaseDataEntity())).isError();
    }

    protected boolean isFKeyExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"select name as [CONSTRAINT_NAME] from sys.sysobjects where UPPER(name)= '%2$s' and xtype= 'F '", (Object)iPSDatabase.getDBName().toUpperCase(), (Object)strFKName.toUpperCase());
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
                sb.Append("[%1$s] %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(true, false, false, null));
                if (!bTempMode) continue;
                sb.Append("\n,");
                sb.Append("[SRFORIKEY] %1$s", (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
                sb.Append("\n,");
                sb.Append("[SRFDRAFTFLAG] INT ");
                continue;
            }
            sb.Append("[%1$s] %2$s", (Object)iPSDEFDTColumn.getColumnName(), (Object)iPSDEFDTColumn.getDBDataType(false, true, false, null));
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
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public CallResult compileDBProc(IPSDatabase iPSDatabase, String strProcName, String strSQL) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected String getCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        StringBuilderEx stringBuilder = new StringBuilderEx();
        String strTableName = iPSDEDBConfig.getTableName();
        strTableName = strTableName.toUpperCase();
        stringBuilder.Append("CREATE NONCLUSTERED INDEX [%1$s] \n", (Object)iPSDEDBIndex.getCodeName());
        stringBuilder.Append(" ON [dbo].[%1$s] \n", (Object)strTableName);
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
            stringBuilder.Append("[%1$s] %2$s", (Object)iPSDEDBIndexField.getPSDEField().getPSDTColumn(SQLSERVER).getColumnName(), (Object)iPSDEDBIndexField.getSortDir());
        }
        stringBuilder.Append(")\n");
        return stringBuilder.toString();
    }

    protected boolean isIndexExists(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        BaseDataEntity dataEntity;
        String strSQL = StringHelper.Format((String)"SELECT name as [INDEX_NAME] FROM sys.indexes WHERE object_id = OBJECT_ID(N'[dbo].[%1$s]') AND name = N'%2$s'", (Object)iPSDEDBConfig.getTableName(), (Object)strIndexName);
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
        sb.Append("ADD [%1$s] %2$s\n", (Object)iPSDEFDTColumn.getColumnName(), (Object)strDataType);
        sqlList.add(sb.toString());
    }

    public String getDBObjStandardName(String strOriginName) {
        String[] items = strOriginName.split("[.]");
        if (items.length == 1) {
            return StringHelper.Format((String)"[%1$s]", (Object)strOriginName);
        }
        net.ibizsys.paas.util.StringBuilderEx sb = new net.ibizsys.paas.util.StringBuilderEx();
        int i = 0;
        while (i < items.length) {
            if (i != 0) {
                sb.append(".");
            }
            sb.append("[%1$s]", (Object)items[i]);
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
                    psSysDMItem.setCREATESQL5(StringHelper.Format((String)"EXECUTE sp_addextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%1$s', NULL, NULL", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDataEntity.getLogicName()));
                    psSysDMItem.setCREATESQL6(StringHelper.Format((String)"EXECUTE sp_updateextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%1$s', NULL, NULL", (Object)psSysDMItem.getPSSYSDMITEMNAME(), (Object)iPSDataEntity.getLogicName()));
                } else {
                    psSysDMItem.setCREATESQL5("");
                    psSysDMItem.setCREATESQL6("");
                }
            }
        } else if (StringHelper.Compare((String)psSysDMItem.getDBOBJTYPE(), (String)"COLUMN", (boolean)true) == 0 && obj != null && obj instanceof IPSDEFDTColumn) {
            IPSDEFDTColumn iPSDEFDTColumn = (IPSDEFDTColumn)obj;
            if (bPubComment) {
                String[] items;
                String strDBObjectName = psSysDMItem.getPSSYSDMITEMNAME();
                if (!StringHelper.IsNullOrEmpty((String)strDBObjectName) && (items = strDBObjectName.split("[.]")).length > 1) {
                    strDBObjectName = items[items.length - 1];
                }
                psSysDMItem.setCREATESQL5(StringHelper.Format((String)"EXEC sp_addextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%3$s', 'column', %1$s", (Object)strDBObjectName, (Object)iPSDEFDTColumn.getPSDEField().getLogicName(), (Object)iPSDEFDTColumn.getRealTableName()));
                psSysDMItem.setCREATESQL6(StringHelper.Format((String)"EXEC sp_updateextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%3$s', 'column', %1$s", (Object)strDBObjectName, (Object)iPSDEFDTColumn.getPSDEField().getLogicName(), (Object)iPSDEFDTColumn.getRealTableName()));
            } else {
                psSysDMItem.setCREATESQL5("");
                psSysDMItem.setCREATESQL6("");
            }
        }
        super.savePSSysDMItem(iPSPublisherContext, psSysDMItem, obj);
    }

    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, boolean bTempMode) throws Exception {
        super.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, bTempMode);
        if (!(iPSDEDBConfig.getPSDataEntity().isSubSysDE() || bTempMode || iPSDEDBConfig.getPSDataEntity().isVirtual())) {
            IPSDBPublisherContext iPSDBPublisherContext;
            boolean bPubComment = true;
            if (iPSPublisherContext instanceof IPSDBPublisherContext && (iPSDBPublisherContext = (IPSDBPublisherContext)iPSPublisherContext) != null && iPSDBPublisherContext.getPSSystemDBConfig() != null) {
                bPubComment = iPSDBPublisherContext.getPSSystemDBConfig().isPubModelComment();
            }
            if (bPubComment) {
                String strSQL = StringHelper.Format((String)"EXECUTE sp_addextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%1$s', NULL, NULL", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEDBConfig.getPSDataEntity().getLogicName());
                this.callCreateDBModelSql(iPSDatabase, strSQL);
                strSQL = StringHelper.Format((String)"EXECUTE sp_updateextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%1$s', NULL, NULL", (Object)iPSDEDBConfig.getTableName().toUpperCase(), (Object)iPSDEDBConfig.getPSDataEntity().getLogicName());
                CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
                if (callResult.isError()) {
                    throw new Exception(callResult.getErrorInfo());
                }
            }
            if (bPubComment) {
                Iterator psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = (IPSDEField)psDEFields.next();
                    if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
                    IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
                    if (StringHelper.Compare((String)iPSDEDBConfig.getTableName(), (String)iPSDEFDTColumn.getRealTableName(), (boolean)true) != 0) continue;
                    String strSQL = StringHelper.Format((String)"EXEC sp_addextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%3$s', 'column', %1$s", (Object)iPSDEFDTColumn.getColumnName().toUpperCase(), (Object)iPSDEFDTColumn.getPSDEField().getLogicName(), (Object)iPSDEFDTColumn.getRealTableName());
                    this.callCreateDBModelSql(iPSDatabase, strSQL);
                    strSQL = StringHelper.Format((String)"EXEC sp_updateextendedproperty 'MS_Description', '%2$s', 'user', dbo, 'table', '%3$s', 'column', %1$s", (Object)iPSDEFDTColumn.getColumnName().toUpperCase(), (Object)iPSDEFDTColumn.getPSDEField().getLogicName(), (Object)iPSDEFDTColumn.getRealTableName());
                    CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
                    if (!callResult.isError()) continue;
                    throw new Exception(callResult.getErrorInfo());
                }
            }
        }
    }
}

