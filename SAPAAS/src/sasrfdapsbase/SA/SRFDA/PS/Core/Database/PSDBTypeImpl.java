/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataSet
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.IDBFunction
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBK
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItemLog
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndex;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERIndexDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQColumn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDSCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQColumnImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDQEngineImpl;
import SA.SRFDA.PS.Core.DataEntity.DS.SimplePSDEDQMainImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityException;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDBType4;
import SA.SRFDA.PS.Core.Database.IPSDBTypeEx;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBIndex;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.PSDBSysProcTemplGlobalModel;
import SA.SRFDA.PS.Core.Deploy.IPSSystemDeployDB;
import SA.SRFDA.PS.Core.Deploy.PSSystemDeployDBImpl;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSDBPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDBType;
import SA.SRFDA.PS.Data.PSDEDBConfig;
import SA.SRFDA.PS.Data.PSDEFDTColumn;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFDA.PS.Data.PSSystemDeployDB;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataSet;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBK;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDMItemLog;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDMItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

@PSModelIgnoreMeta
public abstract class PSDBTypeImpl
extends PSObjectImpl
implements IPSDBType,
IPSDBType4,
IPSDBTypeEx {
    protected PSDBType psDBType = null;
    private static final Log log = LogFactory.getLog(PSDBTypeImpl.class);
    protected ArrayList<IPSDEDQCodePublisher> psDEDQCodePublisher = new ArrayList();
    protected ArrayList<IPSDEDSCodePublisher> psDEDSCodePublisher = new ArrayList();
    private String strHibernateDialect = null;
    private String strJdbcDialect = null;
    private String strDBClientPath = null;
    private HashMap<String, IDBFunction> dbFunctionMap = new HashMap();
    protected PSDBSysProcTemplGlobalModel psDBSysProcTemplGlobalModel = new PSDBSysProcTemplGlobalModel();
    private long nLastResetTime = System.currentTimeMillis();
    private final long RESETTIMER = 600000L;

    public PSDBTypeImpl() {
        this.registerDBFunction(new IDBFunction(){

            public String getName() {
                return "AVG";
            }

            public int getOutputDataType() {
                return 6;
            }

            public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
                if (args == null || args.length != 1) {
                    throw new Exception(String.format("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", new Object[0]));
                }
                return String.format("AVG(%1$s)", args[0]);
            }
        });
        this.registerDBFunction(new IDBFunction(){

            public String getName() {
                return "MAX";
            }

            public int getOutputDataType() {
                return 6;
            }

            public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
                if (args == null || args.length != 1) {
                    throw new Exception(String.format("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", new Object[0]));
                }
                return String.format("MAX(%1$s)", args[0]);
            }
        });
        this.registerDBFunction(new IDBFunction(){

            public String getName() {
                return "MIN";
            }

            public int getOutputDataType() {
                return 6;
            }

            public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
                if (args == null || args.length != 1) {
                    throw new Exception(String.format("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", new Object[0]));
                }
                return String.format("MIN(%1$s)", args[0]);
            }
        });
        this.registerDBFunction(new IDBFunction(){

            public String getName() {
                return "SUM";
            }

            public int getOutputDataType() {
                return 6;
            }

            public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
                if (args == null || args.length != 1) {
                    throw new Exception(String.format("\u4f20\u5165\u53c2\u6570\u4e0d\u6b63\u786e", new Object[0]));
                }
                return String.format("SUM(%1$s)", args[0]);
            }
        });
        this.registerDBFunction(new IDBFunction(){

            public String getName() {
                return "COUNT";
            }

            public int getOutputDataType() {
                return 6;
            }

            public String getFuncSQL(boolean bInsert, String[] args) throws Exception {
                return String.format("COUNT(1)", new Object[0]);
            }
        });
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBType psDBType) throws Exception {
        this.psDBType = psDBType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDBType.getPSDBTYPEID());
        this.setName(psDBType.getPSDBTYPENAME());
        this.setPSObjectData(this.psDBType);
        this.psDBSysProcTemplGlobalModel.Init(iDAGlobalHelper, this);
        this.strHibernateDialect = this.psDBType.getHIBDIALECT();
        this.strJdbcDialect = this.psDBType.getJDBCDIALECT();
        this.strDBClientPath = this.psDBType.getDBCLIENTPATH();
        this.onInit();
    }

    @Override
    public IPSDBSysProcTempl getPSDBSysProcTempl(String strPSDBSysProcTypeId) throws Exception {
        String strRealId = Helper.GenUniqueId((String)this.getId(), (String)strPSDBSysProcTypeId);
        return (IPSDBSysProcTempl)this.psDBSysProcTemplGlobalModel.FindModelHelper(strRealId);
    }

    @Override
    public void resetPSDBSysProcTempl(String strPSDBSysProcTypeId) {
        String strRealId = Helper.GenUniqueId((String)this.getId(), (String)strPSDBSysProcTypeId);
        this.psDBSysProcTemplGlobalModel.ResetModel(strRealId);
    }

    @Override
    public IPSSystemDeployDB createPSSystemDeployDB(PSSystemDeployDB psSystemDeployDB) throws Exception {
        return new PSSystemDeployDBImpl();
    }

    @Override
    public String getDriverName() {
        return this.psDBType.getJDBCDRIVERNAME();
    }

    @Override
    public IPSDEFDTColumn createPSDEFDTColumn(PSDEFDTColumn psDEFDTColumn) throws Exception {
        return (IPSDEFDTColumn)ObjectHelper.Create((String)this.psDBType.getDEFDTCOLOBJ());
    }

    public static int getJDBCType(int dataType) {
        if (dataType == 1) {
            return -5;
        }
        if (dataType == 2 || dataType == 22) {
            return -2;
        }
        if (dataType == 3) {
            return -7;
        }
        if (dataType == 4 || dataType == 11 || dataType == 26) {
            return 1;
        }
        if (dataType == 28 || dataType == 5 || dataType == 16) {
            return 93;
        }
        if (dataType == 6 || dataType == 10 || dataType == 18) {
            return 3;
        }
        if (dataType == 7) {
            return 6;
        }
        if (dataType == 8) {
            return -4;
        }
        if (dataType == 9) {
            return 4;
        }
        if (dataType == 12 || dataType == 21) {
            return -1;
        }
        if (dataType == 14) {
            return 2;
        }
        if (dataType == 13 || dataType == 19 || dataType == 20 || dataType == 25) {
            return 12;
        }
        if (dataType == 15) {
            return 7;
        }
        if (dataType == 17) {
            return 5;
        }
        if (dataType == 23) {
            return -6;
        }
        if (dataType == 24) {
            return -3;
        }
        return 12;
    }

    @Override
    public IPSDEDBConfig createPSDEDBConfig(PSDEDBConfig psDEDBConfig) throws Exception {
        return (IPSDEDBConfig)ObjectHelper.Create((String)this.psDBType.getDEDBCFGOBJ());
    }

    @Override
    public IPSSystemDBConfig createPSSystemDBConfig(PSSystemDBConfig psSystemDBConfig) throws Exception {
        return (IPSSystemDBConfig)ObjectHelper.Create((String)this.psDBType.getSYSDBCFGOBJ());
    }

    @Override
    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig) throws Exception {
        IPSDataEntity iPSDataEntity = iPSDEDBConfig.getPSDataEntity();
        if (iPSDataEntity.isSubSysDE()) {
            return;
        }
        this.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, false);
        if (iPSDataEntity.isEnableTempDataBackend()) {
            this.publishPSDataEntityDBModel(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, true);
        }
    }

    @Override
    public void publishPSDataEntityDBModel(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, boolean bTempMode) throws Exception {
        String strTableName;
        IPSDEFDTColumn iPSDEFDTColumn;
        IPSDEField iPSDEField;
        Iterator<IPSDEField> psDEFields;
        IPSDataEntity iPSDataEntity = iPSDEDBConfig.getPSDataEntity();
        if (iPSDataEntity.isSubSysDE()) {
            return;
        }
        if (iPSDataEntity.isVirtual() && iPSDataEntity.getVirtualMode() != 5) {
            return;
        }
        boolean bPubView = true;
        boolean bPubFKey = true;
        boolean bPubIndex = true;
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        IPSDBPublisherContext iPSDBPublisherContext = null;
        if (iPSPublisherContext != null && iPSPublisherContext instanceof IPSDBPublisherContext && (iPSDBPublisherContext = (IPSDBPublisherContext)iPSPublisherContext).getPSSystemDBConfig() != null) {
            bPubView = iPSDBPublisherContext.getPSSystemDBConfig().isPubView();
            bPubFKey = iPSDBPublisherContext.getPSSystemDBConfig().isPubFKey();
            bPubIndex = iPSDBPublisherContext.getPSSystemDBConfig().isPubIndex();
        }
        if (iPSDatabase != null && iPSDatabase.isLocalRes()) {
            if (this.isTableExists(iPSDatabase, iPSDEDBConfig.getTableName(), bTempMode)) {
                ArrayList<String> columns = this.getTableColumns(iPSDatabase, iPSDEDBConfig.getTableName(), bTempMode);
                HashMap<String, String> columnMap = new HashMap<String, String>();
                for (String strName : columns) {
                    columnMap.put(strName.toUpperCase(), "");
                }
                psDEFields = iPSDataEntity.getPSDEFields();
                while (psDEFields.hasNext()) {
                    iPSDEField = psDEFields.next();
                    if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || bTempMode && !iPSDEField.isEnableTempData()) continue;
                    iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
                    if (StringHelper.Compare((String)iPSDataEntity.getTableName(), (String)iPSDEFDTColumn.getTableScope(), (boolean)true) != 0 || columnMap.containsKey(iPSDEFDTColumn.getColumnName().toUpperCase())) continue;
                    this.createTableColumn(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEFDTColumn, bTempMode);
                }
            } else {
                this.createTable(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBConfig.getTableName(), bTempMode);
            }
            if (!bTempMode && bPubIndex) {
                Iterator<IPSDEDBIndex> psDEDBIndexs = iPSDataEntity.getAllPSDEDBIndexs();
                while (psDEDBIndexs.hasNext()) {
                    IPSDEDBIndex iPSDEDBIndex = psDEDBIndexs.next();
                    this.createIndex(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex);
                }
            }
        }
        if (StringHelper.IsNullOrEmpty((String)(strTableName = iPSDEDBConfig.getTableName()))) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u6307\u5b9a\u8868\u540d", iPSDataEntity.getName()));
        }
        if (bTempMode) {
            strTableName = String.valueOf(strTableName) + strTempTag;
        }
        String strPSSystemDBCfgId = Helper.GenUniqueId((String)iPSDataEntity.getPSSystem().getId(), (String)this.getId());
        SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem = new SA.SRFDA.PS.Data.PSSysDMItem();
        psSysDMItem.setPSSYSTEMDBCFGID(strPSSystemDBCfgId);
        psSysDMItem.setPSSYSTEMDBCFGNAME(this.getId());
        psSysDMItem.setPSDEID(iPSDataEntity.getId());
        psSysDMItem.setPSDENAME(iPSDataEntity.getName());
        psSysDMItem.setDBOBJTYPE("TABLE");
        psSysDMItem.setPSSYSDMITEMNAME(strTableName.toUpperCase());
        psSysDMItem.setPSOBJID(iPSDataEntity.getId());
        psSysDMItem.setPSOBJNAME(iPSDataEntity.getName());
        psSysDMItem.setPSSYSDMITEMID(Helper.GenUniqueId((String)psSysDMItem.getPSSYSTEMDBCFGID(), (String)psSysDMItem.getDBOBJTYPE(), (String)psSysDMItem.getPSOBJID(), (String)psSysDMItem.getPSSYSDMITEMNAME()));
        if (iPSDataEntity.getPSSystem().getActivePSSysDMVer() != null) {
            psSysDMItem.setPSSYSDMVERID(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getId());
            psSysDMItem.setPSSYSDMVERNAME(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getName());
        }
        ArrayList<String> sqlList = new ArrayList<String>();
        this.fillCreateTableSqls(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBConfig.getTableName(), bTempMode, sqlList);
        for (String strSQL : sqlList) {
            String strSQL2 = strSQL.trim().toUpperCase();
            if (strSQL2.indexOf("CREATE ") == 0) {
                psSysDMItem.setCREATESQL(strSQL);
                psSysDMItem.setTESTSQL(StringHelper.Format((String)"SELECT 1 FROM %1$s WHERE 1<>1", (Object)this.getDBObjStandardName(strTableName)));
                continue;
            }
            if (strSQL2.indexOf("DROP ") == 0) {
                psSysDMItem.setDROPSQL(strSQL);
                continue;
            }
            if (strSQL2.indexOf("ALTER TABLE ") != 0) continue;
            psSysDMItem.setCREATESQL2(strSQL);
        }
        this.savePSSysDMItem(iPSPublisherContext, psSysDMItem, iPSDataEntity);
        psDEFields = iPSDataEntity.getPSDEFields();
        while (psDEFields.hasNext()) {
            iPSDEField = psDEFields.next();
            if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
            iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
            if (StringHelper.Compare((String)iPSDataEntity.getTableName(), (String)iPSDEFDTColumn.getTableScope(), (boolean)true) != 0 || bTempMode && !iPSDEField.isEnableTempData()) continue;
            SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem2 = new SA.SRFDA.PS.Data.PSSysDMItem();
            psSysDMItem2.setPSSYSTEMDBCFGID(strPSSystemDBCfgId);
            psSysDMItem2.setPSSYSTEMDBCFGNAME(this.getId());
            psSysDMItem2.setPSDEID(iPSDataEntity.getId());
            psSysDMItem2.setPSDENAME(iPSDataEntity.getName());
            psSysDMItem2.setDBOBJTYPE("COLUMN");
            psSysDMItem2.setPSSYSDMITEMNAME(StringHelper.Format((String)"%1$s.%2$s", (Object)strTableName, (Object)iPSDEFDTColumn.getColumnName().toUpperCase()));
            psSysDMItem2.setPSOBJID(iPSDEField.getId());
            psSysDMItem2.setPSOBJNAME(iPSDEField.getName());
            psSysDMItem2.setPSSYSDMITEMID(Helper.GenUniqueId((String)psSysDMItem2.getPSSYSTEMDBCFGID(), (String)psSysDMItem2.getDBOBJTYPE(), (String)psSysDMItem2.getPSOBJID(), (String)psSysDMItem2.getPSSYSDMITEMNAME()));
            if (iPSDataEntity.getPSSystem().getActivePSSysDMVer() != null) {
                psSysDMItem2.setPSSYSDMVERID(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getId());
                psSysDMItem2.setPSSYSDMVERNAME(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getName());
            }
            ArrayList<String> sqlList2 = new ArrayList<String>();
            this.fillCreateTableColumnSqls(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEFDTColumn, bTempMode, sqlList2);
            for (String strSQL : sqlList2) {
                String strSQL2 = strSQL.trim().toUpperCase();
                if (strSQL2.indexOf("ALTER ") != 0) continue;
                psSysDMItem2.setCREATESQL(strSQL);
                psSysDMItem2.setTESTSQL(StringHelper.Format((String)"SELECT %2$s FROM %1$s WHERE 1<>1", (Object)this.getDBObjStandardName(strTableName), (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName())));
            }
            this.savePSSysDMItem(iPSPublisherContext, psSysDMItem2, iPSDEFDTColumn);
        }
        if (!bTempMode && bPubFKey) {
            psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                iPSDEField = psDEFields.next();
                if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !(iPSDEField instanceof IPSPickupDEField)) continue;
                IPSPickupDEField iPSPickupDEField = (IPSPickupDEField)iPSDEField;
                IPSDEFDTColumn iPSDEFDTColumn2 = iPSDEField.getPSDTColumn(this.getId());
                if (StringHelper.Compare((String)iPSDataEntity.getTableName(), (String)iPSDEFDTColumn2.getTableScope(), (boolean)true) != 0) continue;
                SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem3 = new SA.SRFDA.PS.Data.PSSysDMItem();
                psSysDMItem3.setPSSYSTEMDBCFGID(strPSSystemDBCfgId);
                psSysDMItem3.setPSSYSTEMDBCFGNAME(this.getId());
                psSysDMItem3.setPSDEID(iPSDataEntity.getId());
                psSysDMItem3.setPSDENAME(iPSDataEntity.getName());
                psSysDMItem3.setDBOBJTYPE("FKEY");
                psSysDMItem3.setPSSYSDMITEMNAME(StringHelper.Format((String)"%1$s.%2$s", (Object)strTableName, (Object)iPSDEFDTColumn2.getColumnName().toUpperCase()));
                psSysDMItem3.setPSOBJID(iPSDEField.getId());
                psSysDMItem3.setPSOBJNAME(iPSDEField.getName());
                psSysDMItem3.setPSSYSDMITEMID(Helper.GenUniqueId((String)psSysDMItem3.getPSSYSTEMDBCFGID(), (String)psSysDMItem3.getDBOBJTYPE(), (String)psSysDMItem3.getPSOBJID(), (String)psSysDMItem3.getPSSYSDMITEMNAME()));
                if (iPSDataEntity.getPSSystem().getActivePSSysDMVer() != null) {
                    psSysDMItem3.setPSSYSDMVERID(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getId());
                    psSysDMItem3.setPSSYSDMVERNAME(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getName());
                }
                String strFKName = iPSPickupDEField.getPSDER1N().getFKeyName();
                if (((IPSDER1N)iPSPickupDEField.getPSDER()).isEnableFKey()) {
                    psSysDMItem3.setCREATESQL(this.getCreateFKeySql(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn2, strFKName));
                    psSysDMItem3.setDROPSQL("");
                } else {
                    psSysDMItem3.setCREATESQL("");
                    psSysDMItem3.setDROPSQL(this.getDropFKeySql(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn2, strFKName));
                }
                this.savePSSysDMItem(iPSPublisherContext, psSysDMItem3, iPSDEFDTColumn2);
            }
        }
        if (!bTempMode && bPubIndex) {
            Iterator<IPSDEDBIndex> psDEDBIndexs = iPSDataEntity.getAllPSDEDBIndexs();
            while (psDEDBIndexs.hasNext()) {
                IPSDEDBIndex iPSDEDBIndex = psDEDBIndexs.next();
                SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem4 = new SA.SRFDA.PS.Data.PSSysDMItem();
                psSysDMItem4.setPSSYSTEMDBCFGID(strPSSystemDBCfgId);
                psSysDMItem4.setPSSYSTEMDBCFGNAME(this.getId());
                psSysDMItem4.setPSDEID(iPSDataEntity.getId());
                psSysDMItem4.setPSDENAME(iPSDataEntity.getName());
                psSysDMItem4.setDBOBJTYPE("INDEX");
                psSysDMItem4.setPSSYSDMITEMNAME(iPSDEDBIndex.getName());
                psSysDMItem4.setPSOBJID(iPSDEDBIndex.getId());
                psSysDMItem4.setPSOBJNAME(iPSDEDBIndex.getName());
                psSysDMItem4.setPSSYSDMITEMID(Helper.GenUniqueId((String)psSysDMItem4.getPSSYSTEMDBCFGID(), (String)psSysDMItem4.getDBOBJTYPE(), (String)psSysDMItem4.getPSOBJID(), (String)psSysDMItem4.getPSSYSDMITEMNAME()));
                if (iPSDataEntity.getPSSystem().getActivePSSysDMVer() != null) {
                    psSysDMItem4.setPSSYSDMVERID(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getId());
                    psSysDMItem4.setPSSYSDMVERNAME(iPSDataEntity.getPSSystem().getActivePSSysDMVer().getName());
                }
                String strIndexName = iPSDEDBIndex.getCodeName();
                if (iPSDEDBIndex.getRemoveFlag()) {
                    psSysDMItem4.setCREATESQL("");
                    psSysDMItem4.setCREATESQL2("");
                    psSysDMItem4.setDROPSQL(this.getDropIndexSql(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
                } else {
                    psSysDMItem4.setCREATESQL(this.getCreateIndexSql(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
                    psSysDMItem4.setCREATESQL2(this.getAfterCreateIndexSql(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
                    psSysDMItem4.setDROPSQL("");
                }
                this.savePSSysDMItem(iPSPublisherContext, psSysDMItem4, iPSDEDBIndex);
            }
        }
    }

    protected void savePSSysDMItem(IPSPublisherContext iPSPublisherContext, SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem, Object obj) throws Exception {
        boolean bInsert = true;
        PSSysDMItemService psSysDMItemService = (PSSysDMItemService)iPSPublisherContext.getService(PSSysDMItemService.class);
        PSSysDMItem psSysDMItem2 = new PSSysDMItem();
        PSSysDMItem psSysDMItem3 = new PSSysDMItem();
        psSysDMItem2.setPSSysDMItemId(psSysDMItem.getPSSYSDMITEMID());
        psSysDMItem3.setPSSysDMItemId(psSysDMItem.getPSSYSDMITEMID());
        String strLastSql = "";
        if (psSysDMItemService.get(psSysDMItem3, true)) {
            if (DataObject.getBoolValue((Integer)psSysDMItem3.getUserFlag(), (boolean)false)) {
                return;
            }
            bInsert = false;
            strLastSql = psSysDMItem3.getCreateSql();
            if (StringHelper.IsNullOrEmpty((String)strLastSql)) {
                strLastSql = psSysDMItem3.getCreateSql4();
            }
        }
        PSDEDataCtrl.convertEntity2(psSysDMItem, (IEntity)psSysDMItem2);
        psSysDMItem2.setUserFlag(Integer.valueOf(0));
        String strCurSql = psSysDMItem2.getCreateSql();
        if (StringHelper.Length((String)psSysDMItem2.getCreateSql()) < 2000) {
            psSysDMItem2.setCreateSql4(psSysDMItem2.getCreateSql());
            psSysDMItem2.setCreateSql(null);
        } else {
            psSysDMItem2.setCreateSql4(null);
        }
        if (!bInsert && StringHelper.Compare((String)psSysDMItem2.getCreateSql(), (String)psSysDMItem3.getCreateSql(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql2(), (String)psSysDMItem3.getCreateSql2(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql3(), (String)psSysDMItem3.getCreateSql3(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql4(), (String)psSysDMItem3.getCreateSql4(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql5(), (String)psSysDMItem3.getCreateSql5(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql6(), (String)psSysDMItem3.getCreateSql6(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getCreateSql7(), (String)psSysDMItem3.getCreateSql7(), (boolean)false) == 0 && StringHelper.Compare((String)psSysDMItem2.getDropSql(), (String)psSysDMItem3.getDropSql(), (boolean)false) == 0) {
            return;
        }
        if (bInsert) {
            psSysDMItemService.create(psSysDMItem2, false);
        } else {
            psSysDMItemService.update(psSysDMItem2, false);
        }
        if (!StringHelper.IsNullOrEmpty((String)strLastSql) && StringHelper.Compare((String)psSysDMItem2.getDBObjType(), (String)"COLUMN", (boolean)true) == 0 && StringHelper.Compare((String)strLastSql, (String)strCurSql, (boolean)false) != 0) {
            PSSysDMItemLogService psSysDMItemLogService = (PSSysDMItemLogService)iPSPublisherContext.getService(PSSysDMItemLogService.class);
            PSSysDMItemLog psSysDMItemLog = new PSSysDMItemLog();
            psSysDMItem2.copyTo((IDataObject)psSysDMItemLog, false);
            psSysDMItemLog.setPSSysDMItemLogName(psSysDMItem2.getPSSysDMItemName());
            if (StringHelper.Length((String)strCurSql) >= 2000) {
                strCurSql = String.valueOf(strCurSql.substring(0, 1980)) + "...[\u622a\u65ad]";
            }
            psSysDMItemLog.setNewSql(strCurSql);
            if (StringHelper.Length((String)strLastSql) >= 2000) {
                strLastSql = String.valueOf(strLastSql.substring(0, 1980)) + "...[\u622a\u65ad]";
            }
            psSysDMItemLog.setOldSql(strLastSql);
            psSysDMItemLogService.create(psSysDMItemLog, false);
        }
    }

    @Override
    public void publishPSDataEntityDBModel2(IPSPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig) throws Exception {
        if (iPSDEDBConfig.getPSDataEntity().isSubSysDE()) {
            return;
        }
        boolean bPubView = true;
        boolean bPubFKey = true;
        boolean bPubIndex = true;
        IPSDBPublisherContext iPSDBPublisherContext = null;
        if (iPSPublisherContext != null && iPSPublisherContext instanceof IPSDBPublisherContext && (iPSDBPublisherContext = (IPSDBPublisherContext)iPSPublisherContext).getPSSystemDBConfig() != null) {
            bPubView = iPSDBPublisherContext.getPSSystemDBConfig().isPubView();
            bPubFKey = iPSDBPublisherContext.getPSSystemDBConfig().isPubFKey();
            bPubIndex = iPSDBPublisherContext.getPSSystemDBConfig().isPubIndex();
        }
        Iterator<IPSDEField> psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSDEField iPSDEField = psDEFields.next();
            if (!iPSDEField.isPhisicalDEField() || iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !(iPSDEField instanceof IPSPickupDEField)) continue;
            IPSPickupDEField iPSPickupDEField = (IPSPickupDEField)iPSDEField;
            IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
            if (StringHelper.Compare((String)iPSDEDBConfig.getTableName(), (String)iPSDEFDTColumn.getRealTableName(), (boolean)true) != 0 || !bPubFKey) continue;
            this.createFKey(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn);
        }
        if (!iPSDEDBConfig.getPSDataEntity().isNoViewMode() && bPubView) {
            int i = 0;
            while (i <= iPSDEDBConfig.getPSDataEntity().getEnableViewLevel()) {
                if (i == 0) {
                    this.createView(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBConfig.getViewName(), false);
                } else {
                    this.createView(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBConfig.getViewName(i), i, false);
                }
                ++i;
            }
            if (iPSDEDBConfig.getPSDataEntity().isEnableTempDataBackend()) {
                this.createView(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBConfig.getViewName(), true);
            }
        }
    }

    protected abstract boolean isTableExists(IPSDatabase var1, String var2, boolean var3) throws Exception;

    protected abstract boolean isTableColumnExists(IPSDatabase var1, IPSDEFDTColumn var2, boolean var3) throws Exception;

    protected abstract ArrayList<String> getTableColumns(IPSDatabase var1, String var2, boolean var3) throws Exception;

    protected abstract boolean isViewExists(IPSDatabase var1, String var2, boolean var3) throws Exception;

    protected void createTable(IPSDBPublisherContext iPSDBPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strTableName, boolean bTempMode) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strTableName)) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u6307\u5b9a\u6570\u636e\u8868\u540d\u79f0[%2$s]", iPSDEDBConfig.getPSDataEntity().getName()));
        }
        ArrayList<String> sqlList = new ArrayList<String>();
        this.fillCreateTableSqls(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, strTableName, bTempMode, sqlList);
        for (String strSQL : sqlList) {
            CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            if (!callResult.isError()) continue;
            throw new Exception(callResult.getErrorInfo());
        }
    }

    protected void createTableColumn(IPSDBPublisherContext iPSDBPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode) throws Exception {
        ArrayList<String> sqlList = new ArrayList<String>();
        this.fillCreateTableColumnSqls(iPSDBPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEFDTColumn, bTempMode, sqlList);
        for (String strSQL : sqlList) {
            CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            if (!callResult.isError()) continue;
            throw new Exception(callResult.getErrorInfo());
        }
    }

    protected abstract void fillCreateTableSqls(IPSDBPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3, String var4, boolean var5, ArrayList<String> var6) throws Exception;

    protected void fillCreateTableColumnSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEFDTColumn iPSDEFDTColumn, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        String strDataType;
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        if (StringHelper.IsNullOrEmpty((String)(strDataType = iPSDEFDTColumn.getDBDataType(false, true, false, "")))) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u6570\u636e\u5e93\u7c7b\u578b\u5931\u8d25", (Object)iPSDEFDTColumn.getPSDEField().getFullName()));
        }
        SA.SRFramework.UtilityEx.StringBuilderEx sb = new SA.SRFramework.UtilityEx.StringBuilderEx();
        if (bTempMode) {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(String.valueOf(iPSDEFDTColumn.getRealTableName()) + strTempTag));
        } else {
            sb.Append("ALTER TABLE %1$s\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getRealTableName()));
        }
        sb.Append("ADD COLUMN %1$s %2$s\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()), (Object)strDataType);
        sqlList.add(sb.toString());
    }

    protected void createView(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode) throws Exception {
        this.createView(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, 0, bTempMode);
    }

    protected void createView(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, int nViewLevel, boolean bTempMode) throws Exception {
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            throw new Exception(String.format("\u5b9e\u4f53[%1$s]\u672a\u6307\u5b9a\u6570\u636e\u89c6\u56fe\u540d\u79f0[%2$s]", iPSDEDBConfig.getPSDataEntity().getName(), nViewLevel));
        }
        ArrayList<String> sqlList = new ArrayList<String>();
        if (iPSDatabase != null && iPSDatabase.isLocalRes()) {
            if (nViewLevel == 0) {
                this.fillCreateViewSqls(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, bTempMode, sqlList);
            } else {
                this.fillCreateViewSqls(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, nViewLevel, bTempMode, sqlList);
            }
            for (String strSQL : sqlList) {
                CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
                if (!callResult.isError()) continue;
                throw new Exception(callResult.getErrorInfo());
            }
        }
        sqlList.clear();
        if (nViewLevel == 0) {
            this.fillCreateViewSqls2(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, bTempMode, sqlList);
        } else {
            this.fillCreateViewSqls2(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, nViewLevel, bTempMode, sqlList);
        }
        String strViewName2 = strViewName;
        if (bTempMode) {
            strViewName2 = String.valueOf(strViewName2) + strTempTag;
        }
        String strPSSystemDBCfgId = Helper.GenUniqueId((String)iPSDEDBConfig.getPSDataEntity().getPSSystem().getId(), (String)this.getId());
        SA.SRFDA.PS.Data.PSSysDMItem psSysDMItem = new SA.SRFDA.PS.Data.PSSysDMItem();
        psSysDMItem.setPSSYSTEMDBCFGID(strPSSystemDBCfgId);
        psSysDMItem.setPSSYSTEMDBCFGNAME(this.getId());
        psSysDMItem.setPSDEID(iPSDEDBConfig.getPSDataEntity().getId());
        psSysDMItem.setPSDENAME(iPSDEDBConfig.getPSDataEntity().getName());
        psSysDMItem.setDBOBJTYPE("VIEW");
        psSysDMItem.setPSSYSDMITEMNAME(strViewName2.toUpperCase());
        psSysDMItem.setPSOBJID(iPSDEDBConfig.getPSDataEntity().getId());
        psSysDMItem.setPSOBJNAME(iPSDEDBConfig.getPSDataEntity().getName());
        psSysDMItem.setPSSYSDMITEMID(Helper.GenUniqueId((String)psSysDMItem.getPSSYSTEMDBCFGID(), (String)psSysDMItem.getDBOBJTYPE(), (String)psSysDMItem.getPSOBJID(), (String)psSysDMItem.getPSSYSDMITEMNAME()));
        if (iPSDEDBConfig.getPSDataEntity().getPSSystem().getActivePSSysDMVer() != null) {
            psSysDMItem.setPSSYSDMVERID(iPSDEDBConfig.getPSDataEntity().getPSSystem().getActivePSSysDMVer().getId());
            psSysDMItem.setPSSYSDMVERNAME(iPSDEDBConfig.getPSDataEntity().getPSSystem().getActivePSSysDMVer().getName());
        }
        for (String strSQL : sqlList) {
            String strSQL2 = strSQL.trim().toUpperCase();
            if (strSQL2.indexOf("CREATE ") == 0) {
                if (nViewLevel == 0) {
                    psSysDMItem.setCREATESQL(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, bTempMode));
                    continue;
                }
                psSysDMItem.setCREATESQL(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, nViewLevel, bTempMode));
                continue;
            }
            if (strSQL2.indexOf("DROP ") != 0) continue;
            psSysDMItem.setDROPSQL(this.getDropViewSql(iPSDEDBConfig, strViewName, bTempMode));
        }
        this.savePSSysDMItem(iPSPublisherContext, psSysDMItem, iPSDEDBConfig);
    }

    @Override
    public CallResult callCreateDBModelSql(IPSDatabase iPSDatabase, String strSQL) throws Exception {
        CallResult callResult = new CallResult();
        if (iPSDatabase == null) {
            return callResult;
        }
        if (StringHelper.IsNullOrEmpty((String)strSQL)) {
            return callResult;
        }
        Connection connection = iPSDatabase.getConnection();
        if (connection == null) {
            return callResult;
        }
        log.debug((Object)StringHelper.Format((String)"\u51c6\u5907\u6267\u884cSQL:\r\n%1$s", (Object)strSQL));
        SelectResult selectResult = this.invokeSQL(connection, strSQL, null, -1);
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
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult selectSingle(IPSDatabase iPSDatabase, String strSQL, Vector<CallParam> params, BaseDataEntity dataEntity) throws Exception {
        CallResult callResult = new CallResult();
        Connection connection = iPSDatabase.getConnection();
        if (connection == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6570\u636e\u5e93\u8fde\u63a5\u4e0d\u5b58\u5728");
            return callResult;
        }
        SelectResult selectResult = this.invokeSQL(connection, strSQL, params, -1);
        connection.close();
        if (selectResult == null || selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
            if (selectResult != null) {
                callResult.from((DBResult)selectResult);
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u4e0d\u660e\u9519\u8bef\uff0c%1$s", (Object)strSQL));
            }
            return callResult;
        }
        if (selectResult.getMainTable() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
            return callResult;
        }
        if (selectResult.getMainTable().GetRowCount() == 0) {
            callResult.setRetCode(3);
            return callResult;
        }
        dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
        callResult.setRetCode(0);
        return callResult;
    }

    protected CallResult selectMulti(IPSDatabase iPSDatabase, String strSQL, Vector<CallParam> params, Vector<BaseDataEntity> dataEntities) throws Exception {
        CallResult callResult = new CallResult();
        Connection connection = iPSDatabase.getConnection();
        if (connection == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6570\u636e\u5e93\u8fde\u63a5\u4e0d\u5b58\u5728");
            return callResult;
        }
        SelectResult selectResult = this.invokeSQL(connection, strSQL, params, -1);
        connection.close();
        if (selectResult == null || selectResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)strSQL));
            if (selectResult != null) {
                callResult.from((DBResult)selectResult);
            } else {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u4e0d\u660e\u9519\u8bef\uff0c%1$s", (Object)strSQL));
            }
            return callResult;
        }
        if (selectResult.getMainTable() == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
            return callResult;
        }
        int nRowCount = selectResult.getMainTable().GetRowCount();
        int i = 0;
        while (i < nRowCount) {
            BaseDataEntity baseDataEntity = new BaseDataEntity();
            baseDataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
            dataEntities.add(baseDataEntity);
            ++i;
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected SelectResult invokeSQL(Connection connection, String strCommand, Vector<CallParam> list, int nTimeOut) throws SQLException {
        return this.invokeSQL(connection, strCommand, list, -1, -1);
    }

    protected SelectResult invokeSQL(Connection connection, String strCommand, Vector<CallParam> list, int nTimeOut, int nMaxRowCount) throws SQLException {
        SelectResult dbResult = new SelectResult();
        dbResult.setRetCode(-1);
        try (PreparedStatement cstmt = connection.prepareStatement(strCommand)) {
            if (list != null) {
                int i = 0;
                while (i < list.size()) {
                    CallParam callParam = list.get(i);
                    if (callParam.getDataType() != 0) {
                        cstmt.setObject(i + 1, callParam.getValue(), this.getJDCBType(callParam.getDataType()));
                    } else {
                        cstmt.setObject(i + 1, callParam.getValue());
                    }
                    ++i;
                }
            }
            cstmt.execute();
            DataSet dataSet = this.createDataSet();
            do {
                int updateCount;
                if ((updateCount = cstmt.getUpdateCount()) >= 0) {
                    dbResult.setUpdateCount(updateCount);
                    continue;
                }
                ResultSet rs = cstmt.getResultSet();
                if (rs == null) break;
                if (nMaxRowCount >= 0) {
                    dataSet.AddResultSet(rs, true);
                    dataSet.getTable(0).ReadRows(nMaxRowCount);
                } else {
                    dataSet.AddResultSet(rs);
                }
                rs.close();
            } while (cstmt.getMoreResults() || cstmt.getUpdateCount() != -1);
            Integer nRetCode = 0;
            dbResult.setRetCode(nRetCode.intValue());
            dbResult.setSelectData(dataSet);
            dbResult.setDataTableIndex(0);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            dbResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff0c%1$s\r\n%2$s", (Object)ex.toString(), (Object)strCommand));
        }
        return dbResult;
    }

    protected DataSet createDataSet() {
        return new DataSet();
    }

    protected int getJDCBType(int nDataType) {
        return PSDBTypeImpl.getJDBCType(nDataType);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDEDQCodePublisher getPSDEDQCodePublisher() throws Exception {
        ArrayList<IPSDEDQCodePublisher> arrayList = this.psDEDQCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psDEDQCodePublisher.clear();
            } else if (this.psDEDQCodePublisher.size() > 0) {
                return this.psDEDQCodePublisher.remove(0);
            }
        }
        IPSDEDQCodePublisher iPSDEDQCodePublisher = (IPSDEDQCodePublisher)ObjectHelper.Create((String)this.psDBType.getDEDQPUBOBJ());
        iPSDEDQCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSDEDQCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSDEDQCodePublisher(IPSDEDQCodePublisher iPSDEDQCodePublisher) {
        ArrayList<IPSDEDQCodePublisher> arrayList = this.psDEDQCodePublisher;
        synchronized (arrayList) {
            this.psDEDQCodePublisher.add(iPSDEDQCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDEDQCodePublishers() {
        ArrayList<IPSDEDQCodePublisher> arrayList = this.psDEDQCodePublisher;
        synchronized (arrayList) {
            this.psDEDQCodePublisher.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPSDEDSCodePublisher getPSDEDSCodePublisher() throws Exception {
        ArrayList<IPSDEDSCodePublisher> arrayList = this.psDEDSCodePublisher;
        synchronized (arrayList) {
            if (System.currentTimeMillis() - this.nLastResetTime > 600000L) {
                this.nLastResetTime = System.currentTimeMillis();
                this.psDEDSCodePublisher.clear();
            } else if (this.psDEDSCodePublisher.size() > 0) {
                return this.psDEDSCodePublisher.remove(0);
            }
        }
        IPSDEDSCodePublisher iPSDEDSCodePublisher = (IPSDEDSCodePublisher)ObjectHelper.Create((String)this.psDBType.getDEDSPUBOBJ());
        iPSDEDSCodePublisher.init(this.getDAGlobalHelper(), this);
        return iPSDEDSCodePublisher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void releasePSDEDSCodePublisher(IPSDEDSCodePublisher iPSDEDSCodePublisher) {
        ArrayList<IPSDEDSCodePublisher> arrayList = this.psDEDSCodePublisher;
        synchronized (arrayList) {
            this.psDEDSCodePublisher.add(iPSDEDSCodePublisher);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPSDEDSCodePublishers() {
        ArrayList<IPSDEDSCodePublisher> arrayList = this.psDEDSCodePublisher;
        synchronized (arrayList) {
            this.psDEDSCodePublisher.clear();
        }
    }

    @Override
    public IPSDEDQEngine createPSDEDQEngine() {
        return (IPSDEDQEngine)ObjectHelper.Create((String)this.psDBType.getDEDQENGOBJ());
    }

    protected void fillCreateViewSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        this.fillCreateViewSqls(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, 0, bTempMode, sqlList);
    }

    protected void fillCreateViewSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, int nViewLevel, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        if (this.isViewExists(iPSDatabase, strViewName, bTempMode)) {
            sqlList.add(this.getDropViewSql(iPSDEDBConfig, strViewName, bTempMode));
        }
        if (nViewLevel == 0) {
            sqlList.add(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, bTempMode));
        } else {
            sqlList.add(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, nViewLevel, bTempMode));
        }
    }

    protected void fillCreateViewSqls2(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        this.fillCreateViewSqls2(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, strViewName, 0, bTempMode, sqlList);
    }

    protected void fillCreateViewSqls2(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, String strViewName, int nViewLevel, boolean bTempMode, ArrayList<String> sqlList) throws Exception {
        sqlList.add(this.getDropViewSql(iPSDEDBConfig, strViewName, bTempMode));
        if (nViewLevel == 0) {
            sqlList.add(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, bTempMode));
        } else {
            sqlList.add(this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, nViewLevel, bTempMode));
        }
    }

    protected void createFKey(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn) throws Exception {
        ArrayList<String> sqlList = new ArrayList<String>();
        this.fillCreateFKeySqls(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn, sqlList);
        for (String strSQL : sqlList) {
            CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            if (!callResult.isError()) continue;
            log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff0c%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSQL));
        }
    }

    protected void createIndex(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex) throws Exception {
        ArrayList<String> sqlList = new ArrayList<String>();
        this.fillCreateIndexSqls(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, sqlList);
        for (String strSQL : sqlList) {
            CallResult callResult = this.callCreateDBModelSql(iPSDatabase, strSQL);
            if (!callResult.isError()) continue;
            log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u5f02\u5e38\uff0c%1$s\r\n%2$s", (Object)callResult.getErrorInfo(), (Object)strSQL));
        }
    }

    protected void fillCreateFKeySqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, ArrayList<String> sqlList) throws Exception {
        String strFKName = iPSPickupDEField.getPSDER1N().getFKeyName();
        boolean bEnableFKey = ((IPSDER1N)iPSPickupDEField.getPSDER()).isEnableFKey();
        if (iPSDatabase != null) {
            if (!bEnableFKey && this.isFKeyExists(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn, strFKName)) {
                sqlList.add(this.getDropFKeySql(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn, strFKName));
            }
            if (bEnableFKey && !this.isFKeyExists(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn, strFKName)) {
                sqlList.add(this.getCreateFKeySql(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSPickupDEField, iPSDEFDTColumn, strFKName));
            }
        }
    }

    protected void fillCreateIndexSqls(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, ArrayList<String> sqlList) throws Exception {
        String strIndexName = iPSDEDBIndex.getCodeName();
        if (iPSDEDBIndex.getRemoveFlag()) {
            if (this.isIndexExists(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName)) {
                sqlList.add(this.getDropIndexSql(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
            }
        } else if (!this.isIndexExists(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName)) {
            sqlList.add(this.getCreateIndexSql(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
            sqlList.add(this.getAfterCreateIndexSql(iPSPublisherContext, iPSDatabase, iPSDEDBConfig, iPSDEDBIndex, strIndexName));
        }
    }

    protected abstract boolean isFKeyExists(IPSDBPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3, IPSPickupDEField var4, IPSDEFDTColumn var5, String var6) throws Exception;

    protected abstract boolean isIndexExists(IPSDBPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3, IPSDEDBIndex var4, String var5) throws Exception;

    protected String getDropFKeySql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        return StringHelper.Format((String)"ALTER TABLE %1$s DROP  FOREIGN KEY %2$s", (Object)iPSDEFDTColumn.getRealTableName(), (Object)strFKName);
    }

    protected String getCreateFKeySql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSPickupDEField iPSPickupDEField, IPSDEFDTColumn iPSDEFDTColumn, String strFKName) throws Exception {
        IPSDEFDTColumn relatedPSDEFDTColumn = iPSPickupDEField.getRealPSDEField().getPSDTColumn(this.getId());
        return StringHelper.Format((String)"ALTER TABLE %1$s ADD CONSTRAINT %2$s FOREIGN KEY(%3$s) REFERENCES %4$s(%5$s)", (Object)iPSDEFDTColumn.getRealTableName(), (Object)strFKName, (Object)iPSDEFDTColumn.getColumnName(), (Object)relatedPSDEFDTColumn.getRealTableName(), (Object)relatedPSDEFDTColumn.getColumnName());
    }

    protected abstract String getCreateIndexSql(IPSDBPublisherContext var1, IPSDatabase var2, IPSDEDBConfig var3, IPSDEDBIndex var4, String var5) throws Exception;

    protected String getDropIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        return StringHelper.Format((String)"DROP INDEX %1$s ON %2$s", (Object)iPSDEDBIndex.getCodeName(), (Object)iPSDEDBConfig.getTableName());
    }

    protected String getAfterCreateIndexSql(IPSDBPublisherContext iPSPublisherContext, IPSDatabase iPSDatabase, IPSDEDBConfig iPSDEDBConfig, IPSDEDBIndex iPSDEDBIndex, String strIndexName) throws Exception {
        return "";
    }

    protected String getDropViewSql(IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode) throws Exception {
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        SA.SRFramework.UtilityEx.StringBuilderEx script = new SA.SRFramework.UtilityEx.StringBuilderEx();
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            throw new Exception("\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u79fb\u9664");
        }
        if (bTempMode) {
            script.Append("DROP VIEW %1$s \n", (Object)this.getDBObjStandardName(String.valueOf(strViewName) + strTempTag));
        } else {
            script.Append("DROP VIEW %1$s \n", (Object)this.getDBObjStandardName(strViewName));
        }
        return script.toString();
    }

    protected String getCreateViewSql(IPSDBPublisherContext iPSPublisherContext, IPSDEDBConfig iPSDEDBConfig, String strViewName, boolean bTempMode) throws Exception {
        return this.getCreateViewSql(iPSPublisherContext, iPSDEDBConfig, strViewName, 0, bTempMode);
    }

    protected String getCreateViewSql(IPSDBPublisherContext iPSPublisherContext, IPSDEDBConfig iPSDEDBConfig, String strViewName, int nViewLevel, boolean bTempMode) throws Exception {
        IPSDEField keyDEFHelper;
        SA.SRFramework.UtilityEx.StringBuilderEx script = new SA.SRFramework.UtilityEx.StringBuilderEx();
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u89c6\u56fe\u540d\u79f0\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb", (Object)iPSDEDBConfig.getPSDataEntity().getName()));
        }
        String strRealQueryCode = null;
        if (iPSDEDBConfig.getPSDataEntity().isVirtual() && iPSDEDBConfig.getPSDataEntity().getVirtualMode() == 3) {
            int nIndex = 0;
            StringBuilderEx unionAll = new StringBuilderEx();
            Iterator<IPSDERIndex> psDERIndexs = iPSDEDBConfig.getPSDataEntity().getPSDERIndexs(true);
            if (psDERIndexs != null) {
                while (psDERIndexs.hasNext()) {
                    Iterator<IPSDERIndexDEFieldMap> psDERIndexDEFieldMaps;
                    PSDEDQColumnImpl psDEDQColumnImpl;
                    IPSDERIndex iPSDERIndex = psDERIndexs.next();
                    if (iPSDERIndex.isInherit()) continue;
                    HashMap<String, IPSDEField> fieldMap = new HashMap<String, IPSDEField>();
                    ArrayList<IPSDEDQColumn> psDEDQColumnList = new ArrayList<IPSDEDQColumn>();
                    if (iPSDEDBConfig.getPSDataEntity().getKeyPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField() != null) {
                        psDEDQColumnImpl = new PSDEDQColumnImpl();
                        psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField().getName());
                        psDEDQColumnList.add(psDEDQColumnImpl);
                        fieldMap.put(iPSDEDBConfig.getPSDataEntity().getKeyPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getKeyPSDEField());
                    }
                    if (iPSDEDBConfig.getPSDataEntity().getMajorPSDEField() != null && iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField() != null) {
                        psDEDQColumnImpl = new PSDEDQColumnImpl();
                        psDEDQColumnImpl.setName(iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField().getName());
                        psDEDQColumnList.add(psDEDQColumnImpl);
                        fieldMap.put(iPSDEDBConfig.getPSDataEntity().getMajorPSDEField().getName(), iPSDERIndex.getMinorPSDataEntity().getMajorPSDEField());
                    }
                    if ((psDERIndexDEFieldMaps = iPSDERIndex.getPSDERIndexDEFieldMaps()) != null) {
                        while (psDERIndexDEFieldMaps.hasNext()) {
                            IPSDERIndexDEFieldMap iPSDERIndexDEFieldMap = psDERIndexDEFieldMaps.next();
                            if (iPSDERIndexDEFieldMap.getMinorPSDEField() == null || iPSDERIndexDEFieldMap.getMajorPSDEField() == null) continue;
                            PSDEDQColumnImpl psDEDQColumnImpl2 = new PSDEDQColumnImpl();
                            psDEDQColumnImpl2.setName(iPSDERIndexDEFieldMap.getMinorPSDEField().getName());
                            psDEDQColumnList.add(psDEDQColumnImpl2);
                            fieldMap.put(iPSDERIndexDEFieldMap.getMajorPSDEField().getName(), iPSDERIndexDEFieldMap.getMinorPSDEField());
                        }
                    }
                    PSDEDQEngineImpl psDEDQEngineImpl = new PSDEDQEngineImpl();
                    psDEDQEngineImpl.init(this.getDAGlobalHelper(), this, iPSDERIndex.getMinorPSDataEntity());
                    SimplePSDEDQMainImpl simplePSDEDQMainImpl = new SimplePSDEDQMainImpl();
                    simplePSDEDQMainImpl.init(this.getDAGlobalHelper(), iPSDERIndex.getMinorPSDataEntity(), psDEDQColumnList);
                    psDEDQEngineImpl.compile(simplePSDEDQMainImpl);
                    String strCode = psDEDQEngineImpl.getQueryScript();
                    StringBuilderEx sb = new StringBuilderEx();
                    ++nIndex;
                    sb.append("SELECT\n");
                    if (iPSDEDBConfig.getPSDataEntity().getIndexTypePSDEField() == null) {
                        throw new Exception("\u7d22\u5f15\u4e3b\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u7c7b\u578b\u5c5e\u6027");
                    }
                    IPSDEFDTColumn iPSDEFDTColumn = iPSDEDBConfig.getPSDataEntity().getIndexTypePSDEField().getPSDTColumn(this.getId());
                    if (DataTypeHelper.IsStringType((int)iPSDEDBConfig.getPSDataEntity().getIndexTypePSDEField().getStdDataType())) {
                        sb.append("'%1$s' AS %2$s", (Object)iPSDERIndex.getTypeValue(), (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    } else {
                        sb.append("%1$s AS %2$s", (Object)iPSDERIndex.getTypeValue(), (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    }
                    Iterator<IPSDEField> psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
                    while (psDEFields.hasNext()) {
                        IPSDEField iPSDEField = psDEFields.next();
                        if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || iPSDEField.isIndexTypeDEField()) continue;
                        IPSDEFDTColumn iPSDEFDTColumn2 = iPSDEField.getPSDTColumn(this.getId());
                        IPSDEField minorPSDEField = (IPSDEField)fieldMap.get(iPSDEField.getName());
                        if (minorPSDEField == null) {
                            sb.append(",NULL AS %1$s\n", (Object)this.getDBObjStandardName(iPSDEFDTColumn2.getColumnName()));
                            continue;
                        }
                        IPSDEFDTColumn minorPSDEFDTColumn = minorPSDEField.getPSDTColumn(this.getId());
                        sb.append(",v%1$s.%2$s AS %3$s\n", (Object)nIndex, (Object)this.getDBObjStandardName(minorPSDEFDTColumn.getColumnName()), (Object)this.getDBObjStandardName(iPSDEFDTColumn2.getColumnName()));
                    }
                    sb.append("FROM\n");
                    sb.append("(%1$s) v%2$s\n", (Object)strCode, (Object)nIndex);
                    if (nIndex > 1) {
                        unionAll.append("UNION ALL\n");
                    }
                    unionAll.append(sb.toString());
                }
            }
            strRealQueryCode = unionAll.toString();
        }
        String strTempTag = "_TMP";
        if (StringHelper.Compare((String)iPSDEDBConfig.getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
            strTempTag = "_tmp";
        }
        if (bTempMode) {
            script.Append("CREATE VIEW %1$s AS \n", (Object)this.getDBObjStandardName(String.valueOf(strViewName) + strTempTag));
        } else {
            script.Append("CREATE VIEW %1$s AS \n", (Object)this.getDBObjStandardName(strViewName));
        }
        script.Append("SELECT\n");
        Vector<String> derList = new Vector<String>();
        TreeMap<String, Integer> derAliasMap = new TreeMap<String, Integer>();
        boolean bFirst = true;
        if (bTempMode) {
            script.Append("t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG");
            bFirst = false;
        }
        if ((keyDEFHelper = iPSDEDBConfig.getPSDataEntity().getKeyPSDEField()) == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7684\u4e3b\u952e\u5c5e\u6027 ", (Object)iPSDEDBConfig.getPSDataEntity().getFullName()));
        }
        String strInheritTypeFieldExp = null;
        IPSDEField inheritTypePSDEField = null;
        boolean bAppendInheritTypeCond = false;
        if (iPSDEDBConfig.getPSDataEntity().getInheritPSDataEntity() != null && iPSDEDBConfig.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField() != null && iPSDEDBConfig.getPSDataEntity().getInheritPSDataEntity().isEnableSQLStorage() && iPSDEDBConfig.getPSDataEntity().isEnableSQLStorage() && StringHelper.Compare((String)iPSDEDBConfig.getPSDataEntity().getTableName(), (String)iPSDEDBConfig.getPSDataEntity().getInheritPSDataEntity().getTableName(), (boolean)true) == 0) {
            bAppendInheritTypeCond = true;
        }
        Iterator<IPSDEField> psDEFields = iPSDEDBConfig.getPSDataEntity().getPSDEFields();
        while (psDEFields.hasNext()) {
            IPSLinkDEField iPSLinkDEField;
            IPSDEField iPSDEField = psDEFields.next();
            if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField()) continue;
            if (!iPSDEField.isPhisicalDEField() && iPSDEField.isLinkDEField() && !(iPSLinkDEField = (IPSLinkDEField)iPSDEField).getRealPSDataEntity().isEnableSQLStorage()) {
                log.warn((Object)String.format("\u5c5e\u6027[%1$s]\u5b9e\u9645\u5f15\u7528\u5b9e\u4f53[%2$s]\u4e0d\u652f\u6301SQL\u5b58\u50a8\uff0c\u5ffd\u7565", iPSLinkDEField.getName(), iPSLinkDEField.getRealPSDataEntity().getName()));
                continue;
            }
            if (bTempMode && !iPSDEField.isEnableTempData() || !bTempMode && !iPSDEField.isQueryColumn(nViewLevel)) continue;
            String strPSDEFieldExp = this.getPSDEFieldExp(iPSDEField, "", derAliasMap, derList, "t");
            if (bFirst) {
                bFirst = false;
            } else {
                script.Append(",\n");
            }
            script.Append("%1$s AS %2$s", (Object)strPSDEFieldExp, (Object)this.getDBObjStandardName(iPSDEField.getPSDTColumn(this.getId()).getFormalColumnName()));
            if (!bAppendInheritTypeCond || StringHelper.Compare((String)iPSDEDBConfig.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField().getName(), (String)iPSDEField.getName(), (boolean)true) != 0) continue;
            strInheritTypeFieldExp = strPSDEFieldExp;
            inheritTypePSDEField = iPSDEField;
        }
        String strMainTable = iPSDEDBConfig.getTableName();
        String strUserTable = iPSDEDBConfig.getUserTable();
        if (iPSDEDBConfig.getPSDataEntity().isVirtual()) {
            if (iPSDEDBConfig.getPSDataEntity().getKeyPSDEField() == null) {
                throw PSDataEntityException.create(iPSDEDBConfig.getPSDataEntity(), 20014);
            }
            if (iPSDEDBConfig.getPSDataEntity().getKeyPSDEField() instanceof IPSLinkDEField) {
                IPSDataEntity realPSDataEntity = ((IPSLinkDEField)iPSDEDBConfig.getPSDataEntity().getKeyPSDEField()).getRealPSDEField(true).getPSDataEntity();
                strMainTable = realPSDataEntity.getPSDEDBConfig(this.getId()).getTableName();
                strUserTable = realPSDataEntity.getPSDEDBConfig(this.getId()).getUserTable();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strRealQueryCode)) {
            script.Append("\nFROM (%1$s) t1 \n", (Object)strRealQueryCode);
        } else if (!StringHelper.IsNullOrEmpty((String)strMainTable)) {
            if (bTempMode) {
                script.Append("\nFROM %1$s t1 \n", (Object)this.getDBObjStandardName(String.valueOf(strMainTable) + strTempTag));
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", (Object)this.getDBObjStandardName(String.valueOf(strUserTable) + strTempTag), (Object)this.getDBObjStandardName(keyDEFHelper.getPSDTColumn(this.getId()).getColumnName()));
                }
            } else {
                script.Append("\nFROM %1$s t1 \n", (Object)this.getDBObjStandardName(strMainTable));
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    script.Append("INNER JOIN %1$s t2 ON t1.%2$s = t2.%2$s\n", (Object)this.getDBObjStandardName(strUserTable), (Object)this.getDBObjStandardName(keyDEFHelper.getPSDTColumn(this.getId()).getColumnName()));
                }
            }
        }
        TreeMap<String, Integer> joinMap = new TreeMap<String, Integer>();
        for (String strDERs : derList) {
            this.getJoin(script, iPSDEDBConfig.getPSDataEntity(), "", strDERs, derAliasMap, joinMap, "t", bTempMode);
        }
        if (bAppendInheritTypeCond && inheritTypePSDEField != null && !StringHelper.IsNullOrEmpty(strInheritTypeFieldExp)) {
            String strCondition = inheritTypePSDEField.getPSDEFDTColumn(this.getId()).getConditionSQL(null, strInheritTypeFieldExp, "EQ", iPSDEDBConfig.getPSDataEntity().getPSDERInherit().getTypeValue(), null, null);
            script.Append("WHERE (%1$s)\n", (Object)strCondition);
        }
        return script.toString();
    }

    protected void getJoin(SA.SRFramework.UtilityEx.StringBuilderEx script, IPSDataEntity iPSDataEntity, String strParentDERs, String strDER, TreeMap<String, Integer> derAliasMap, TreeMap<String, Integer> joinMap, String strPreFix, boolean bTempMode) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)strDER)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u8fde\u63a5\u5173\u7cfb"));
        }
        String[] strDERs = strDER.split("[|]");
        String strCurDERId = strDERs[0];
        String strCurTotalDER = strParentDERs;
        if (!StringHelper.IsNullOrEmpty((String)strCurTotalDER)) {
            strCurTotalDER = String.valueOf(strCurTotalDER) + "|";
        }
        strCurTotalDER = String.valueOf(strCurTotalDER) + strCurDERId;
        IPSDEDBConfig iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(this.getId());
        IPSDataEntity nextPSDataEntity = null;
        IPSLinkDEField joinDEFHelper = null;
        boolean bInheritMode = false;
        IPSDERBase iPSDERBase = iPSDataEntity.getPSSystem().getPSDER(strCurDERId);
        if (iPSDERBase instanceof IPSDERCustom) {
            IPSDERCustom iPSDERCustom = (IPSDERCustom)iPSDERBase;
        } else {
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getPSDEFields();
            while (psDEFields.hasNext()) {
                IPSLinkDEField iPSLinkDEField;
                IPSDEField iPSDEField = psDEFields.next();
                if (!iPSDEField.isLinkDEField() || StringHelper.Compare((String)(iPSLinkDEField = (IPSLinkDEField)iPSDEField).getDERId(), (String)strCurDERId, (boolean)true) != 0) continue;
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                    joinDEFHelper = iPSLinkDEField;
                    break;
                }
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
                bInheritMode = true;
                nextPSDataEntity = iPSLinkDEField.getRelatedPSDEField().getPSDataEntity();
                break;
            }
            boolean bSameTable = false;
            if (joinDEFHelper == null && nextPSDataEntity == null && (iPSDataEntity.getPSDERInherit() != null && iPSDataEntity.getPSDERInherit().isSameTable() || iPSDataEntity.getVirtualMode() == 5)) {
                bSameTable = true;
                psDEFields = iPSDataEntity.getPSDEFields();
                while (psDEFields.hasNext()) {
                    IPSLinkDEField linkDEFHelper;
                    IPSDEField iPSDEField = psDEFields.next();
                    if (iPSDEField.isDynaStorageDEField() || iPSDEField.isUIAssistDEField() || !iPSDEField.isLinkDEField() || !(iPSDEField instanceof IPSLinkDEField) || StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0 || (linkDEFHelper = (linkDEFHelper = (IPSLinkDEField)iPSDEField).getRelatedPSDEField() instanceof IPSLinkDEField ? (IPSLinkDEField)linkDEFHelper.getRelatedPSDEField() : null) == null) continue;
                    iPSDEField = linkDEFHelper;
                    if (StringHelper.Compare((String)linkDEFHelper.getDERId(), (String)strCurDERId, (boolean)true) != 0) continue;
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                        joinDEFHelper = linkDEFHelper;
                        break;
                    }
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) != 0) continue;
                    bInheritMode = true;
                    nextPSDataEntity = linkDEFHelper.getRelatedPSDEField().getPSDataEntity();
                    break;
                }
            }
            if (bInheritMode) {
                if (!joinMap.containsKey(strCurTotalDER)) {
                    String strMTAlias = "";
                    String strUTAlias = "";
                    if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                        strMTAlias = String.valueOf(strPreFix) + "1";
                        strUTAlias = String.valueOf(strPreFix) + "2";
                    } else {
                        if (!derAliasMap.containsKey(strParentDERs)) {
                            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                        }
                        Integer nAlias = derAliasMap.get(strParentDERs);
                        strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                        strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                    }
                    String strCurMTAlias = "";
                    String strCurUTAlias = "";
                    if (!derAliasMap.containsKey(strCurTotalDER)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    }
                    Integer nAlias = derAliasMap.get(strCurTotalDER);
                    strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                    boolean bJoinAsMain = true;
                    IPSDEField iKeyDEFHelper = iPSDataEntity.getKeyPSDEField();
                    bJoinAsMain = StringHelper.Compare((String)iKeyDEFHelper.getPSDTColumn(this.getId()).getRealTableName(), (String)iPSDataEntity.getPSDEDBConfig(this.getId()).getTableName(), (boolean)true) == 0;
                    String strMainTable = nextPSDataEntity.getPSDEDBConfig(this.getId()).getTableName();
                    String strUserTable = nextPSDataEntity.getPSDEDBConfig(this.getId()).getUserTable();
                    String strMainTable2 = strMainTable;
                    String strUserTable2 = strUserTable;
                    String strTempTag = "_TMP";
                    if (StringHelper.Compare((String)nextPSDataEntity.getPSDEDBConfig(this.getId()).getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                        strTempTag = "_tmp";
                    }
                    boolean bTmpTable = bTempMode;
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)this.getDBObjStandardName(String.valueOf(strMainTable2) + (bTmpTable ? strTempTag : "")), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.getDBObjStandardName(iKeyDEFHelper.getPSDTColumn(this.getId()).getColumnName()), (Object)this.getDBObjStandardName(nextPSDataEntity.getKeyPSDEField().getPSDTColumn(this.getId()).getColumnName()));
                    if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                        IPSDEField pkeyDEFHelper = nextPSDataEntity.getKeyPSDEField();
                        script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)this.getDBObjStandardName(String.valueOf(strUserTable2) + (bTmpTable ? strTempTag : "")), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.getDBObjStandardName(pkeyDEFHelper.getPSDTColumn(this.getId()).getColumnName()));
                    }
                    joinMap.put(strCurTotalDER, 1);
                }
                String strNextDERId = "";
                int i = 1;
                while (i < strDERs.length) {
                    if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                        strNextDERId = String.valueOf(strNextDERId) + "|";
                    }
                    strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                    ++i;
                }
                if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    return;
                }
                this.getJoin(script, nextPSDataEntity, strCurTotalDER, strNextDERId, derAliasMap, joinMap, strPreFix, bTempMode);
                return;
            }
            if (joinDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53[%1$s]\u5173\u7cfb[%2$s]\u7684\u8fde\u63a5\u5c5e\u6027", (Object)iPSDataEntity.getFullName(), (Object)strCurDERId));
            }
            IPSDEField joinRelatedDEFHelper = joinDEFHelper.getRelatedPSDEField();
            if (joinRelatedDEFHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5c5e\u6027[%1$s]\u5173\u8054\u5c5e\u6027", (Object)joinDEFHelper.getFullName()));
            }
            nextPSDataEntity = joinRelatedDEFHelper.getPSDataEntity();
            if (!joinMap.containsKey(strCurTotalDER)) {
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDERs)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDERs)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                    }
                    Integer nAlias = derAliasMap.get(strParentDERs);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                String strCurMTAlias = "";
                String strCurUTAlias = "";
                if (!derAliasMap.containsKey(strCurTotalDER)) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDERs));
                }
                Integer nAlias = derAliasMap.get(strCurTotalDER);
                strCurMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                strCurUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                boolean bJoinAsMain = true;
                String strRealTableName = joinDEFHelper.getPSDTColumn(this.getId()).getRealTableName();
                bJoinAsMain = bSameTable || StringHelper.Compare((String)strRealTableName, (String)iPSDEDBConfig.getTableName(), (boolean)true) == 0;
                String strMainTable = nextPSDataEntity.getPSDEDBConfig(this.getId()).getTableName();
                String strUserTable = nextPSDataEntity.getPSDEDBConfig(this.getId()).getUserTable();
                String strMainTable2 = strMainTable;
                String strUserTable2 = strUserTable;
                boolean bTmpTable = false;
                if (bTempMode && ((IPSDER1N)joinDEFHelper.getPSDER()).getTempDataOrder() >= 0) {
                    bTmpTable = true;
                }
                String strTempTag = "_TMP";
                if (StringHelper.Compare((String)nextPSDataEntity.getPSDEDBConfig(this.getId()).getObjNameCase(), (String)"LCASE", (boolean)true) == 0) {
                    strTempTag = "_tmp";
                }
                script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%5$s \n", (Object)this.getDBObjStandardName(String.valueOf(strMainTable2) + (bTmpTable ? strTempTag : "")), (Object)strCurMTAlias, (Object)(bJoinAsMain ? strMTAlias : strUTAlias), (Object)this.getDBObjStandardName(joinDEFHelper.getPSDTColumn(this.getId()).getColumnName()), (Object)this.getDBObjStandardName(joinRelatedDEFHelper.getPSDTColumn(this.getId()).getColumnName()));
                if (!StringHelper.IsNullOrEmpty((String)strUserTable)) {
                    IPSDEField pkeyDEFHelper = null;
                    pkeyDEFHelper = joinRelatedDEFHelper.getPSDTColumn(this.getId()).isPKey() ? joinRelatedDEFHelper : nextPSDataEntity.getKeyPSDEField();
                    script.Append("LEFT JOIN %1$s %2$s ON %3$s.%4$s = %2$s.%4$s\n", (Object)this.getDBObjStandardName(String.valueOf(strUserTable2) + (bTmpTable ? strTempTag : "")), (Object)strCurUTAlias, (Object)strCurMTAlias, (Object)this.getDBObjStandardName(pkeyDEFHelper.getPSDTColumn(this.getId()).getColumnName()));
                }
                joinMap.put(strCurTotalDER, 1);
            }
            String strNextDERId = "";
            int i = 1;
            while (i < strDERs.length) {
                if (!StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                    strNextDERId = String.valueOf(strNextDERId) + "|";
                }
                strNextDERId = String.valueOf(strNextDERId) + strDERs[i];
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strNextDERId)) {
                return;
            }
            this.getJoin(script, nextPSDataEntity, strCurTotalDER, strNextDERId, derAliasMap, joinMap, strPreFix, bTempMode);
        }
    }

    protected String getPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList, String strPreFix) throws Exception {
        boolean bClose = false;
        ActionSession actionSession = null;
        try {
            actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                bClose = true;
                actionSession = ActionSessionManager.openSession((String)"PSDBTypeImpl");
                actionSession.registerRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId());
            } else if (!actionSession.registerRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId())) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]SQL\u8868\u8fbe\u5f0f\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)iPSDEField.getFullName()));
            }
            String strPSDEFieldExp = this.onGetPSDEFieldExp(iPSDEField, strParentDER, derAliasMap, derList, strPreFix);
            actionSession.unregisterRecursion("PSDEFIELDEXP", (Object)iPSDEField.getId());
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            return strPSDEFieldExp;
        }
        catch (Exception ex) {
            if (bClose) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
    }

    protected String onGetPSDEFieldExp(IPSDEField iPSDEField, String strParentDER, TreeMap<String, Integer> derAliasMap, Vector<String> derList, String strPreFix) throws Exception {
        try {
            IPSDEField relatedDEFHelper;
            IPSDEField relatedPSPSDEField;
            IPSDEFDTColumn iPSDEFDTColumn2;
            IPSDataEntity iDEHelper = iPSDEField.getPSDataEntity();
            IPSDEFDTColumn iPSDEFDTColumn = iPSDEField.getPSDTColumn(this.getId());
            if (iPSDEField.isInheritDEField() && (iPSDEFDTColumn2 = (relatedPSPSDEField = ((IPSInheritDEField)iPSDEField).getRelatedPSDEField()).getPSDTColumn(this.getId())).isFormula()) {
                iPSDEFDTColumn = iPSDEFDTColumn2;
            }
            if (iPSDEFDTColumn.isFormula() && !iPSDEFDTColumn.isFormulaPhisical()) {
                String strFormulaFields = iPSDEFDTColumn.getFormulaColumns();
                String strFormulaFormat = iPSDEFDTColumn.getFormulaFormat();
                if (!StringHelper.IsNullOrEmpty((String)strFormulaFields)) {
                    Object[] params = null;
                    String[] strFields = strFormulaFields.split("[;]");
                    params = new Object[strFields.length];
                    int i = 0;
                    while (i < strFields.length) {
                        String strDEFName = strFields[i].toUpperCase();
                        IPSDEField argvField = iDEHelper.getPSDEField(strDEFName, true);
                        params[i] = argvField != null ? this.getPSDEFieldExp(argvField, strParentDER, derAliasMap, derList, strPreFix) : strDEFName;
                        ++i;
                    }
                    String strExp = StringHelper.Format((String)strFormulaFormat, (Object[])params);
                    return strExp;
                }
                if (iPSDEField.getPSDataEntity().isVirtual() && iPSDEField.getPSDataEntity().getVirtualMode() == 3) {
                    String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)"t1", (Object)this.getDBObjStandardName(iPSDEFDTColumn.getColumnName()));
                    return strExp;
                }
                String strExp = StringHelper.Format((String)iPSDEFDTColumn.getFormulaFormat());
                return strExp;
            }
            IPSDataEntity realPSDataEntity = null;
            if (StringHelper.IsNullOrEmpty((String)strParentDER) && iPSDEField.getPSDataEntity().isVirtual()) {
                if (iPSDEField.getPSDataEntity().getKeyPSDEField() == null) {
                    throw PSDataEntityException.create(iPSDEField.getPSDataEntity(), 20014);
                }
                if (iPSDEField.getPSDataEntity().getVirtualMode() != 4 && iPSDEField.getPSDataEntity().getVirtualMode() != 5) {
                    if (!(iPSDEField.getPSDataEntity().getKeyPSDEField() instanceof IPSLinkDEField)) {
                        throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6807\u8bb0\u4e3a\u865a\u62df\u5b9e\u4f53\uff0c\u4f46\u4e3b\u952e\u5c5e\u6027[%2$s]\u4e0d\u662f\u94fe\u63a5\u5c5e\u6027", (Object)iPSDEField.getPSDataEntity().getName(), (Object)iPSDEField.getPSDataEntity().getKeyPSDEField().getName()));
                    }
                    realPSDataEntity = ((IPSLinkDEField)iPSDEField.getPSDataEntity().getKeyPSDEField()).getRealPSDEField(true).getPSDataEntity();
                    if (StringHelper.Compare((String)((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDataEntity().getId(), (String)realPSDataEntity.getId(), (boolean)false) != 0) {
                        realPSDataEntity = null;
                    }
                }
            }
            String strDERID = "";
            IPSLinkDEField iPSLinkDEField = null;
            boolean bAddJoin = false;
            if (realPSDataEntity == null && iPSDEField instanceof IPSLinkDEField) {
                iPSLinkDEField = (IPSLinkDEField)iPSDEField;
                strDERID = iPSLinkDEField.getDERId();
                bAddJoin = true;
                if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) {
                    strDERID = "";
                    bAddJoin = false;
                } else {
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPTEXT", (boolean)true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                        strDERID = "";
                        bAddJoin = false;
                    }
                    if (StringHelper.Compare((String)iPSDEField.getDataType(), (String)"PICKUPDATA", (boolean)true) == 0 && iPSDEField.getPSDEFieldData().getDEFTYPE() == 1) {
                        strDERID = "";
                        bAddJoin = false;
                    }
                    if (iPSLinkDEField != null && StringHelper.Compare((String)iPSDEField.getDataType(), (String)"INHERIT", (boolean)true) == 0) {
                        if (iPSDEField.getPSDataEntity().getPSDERInherit() != null && iPSDEField.getPSDataEntity().getPSDERInherit().isSameTable()) {
                            bAddJoin = false;
                            if (iPSLinkDEField.getRelatedPSDEField() != null && iPSLinkDEField.getRelatedPSDEField().isPhisicalDEField()) {
                                strDERID = "";
                            }
                        } else if (iPSDEField.getPSDataEntity().getVirtualMode() == 5) {
                            bAddJoin = false;
                            if (iPSLinkDEField.getRelatedPSDEField() != null && iPSLinkDEField.getRelatedPSDEField().isPhisicalDEField()) {
                                strDERID = "";
                            }
                        }
                    }
                }
            }
            if (StringHelper.IsNullOrEmpty((String)strDERID)) {
                String strMainTable = "";
                String strUserTable = "";
                if (realPSDataEntity != null) {
                    strMainTable = realPSDataEntity.getPSDEDBConfig(this.getId()).getTableName();
                    strUserTable = realPSDataEntity.getPSDEDBConfig(this.getId()).getUserTable();
                } else {
                    strMainTable = iDEHelper.getPSDEDBConfig(this.getId()).getTableName();
                    strUserTable = iDEHelper.getPSDEDBConfig(this.getId()).getUserTable();
                }
                String strMTAlias = "";
                String strUTAlias = "";
                if (StringHelper.IsNullOrEmpty((String)strParentDER)) {
                    strMTAlias = String.valueOf(strPreFix) + "1";
                    strUTAlias = String.valueOf(strPreFix) + "2";
                } else {
                    if (!derAliasMap.containsKey(strParentDER)) {
                        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u627e\u5230\u5173\u7cfb[%1$s]\u522b\u540d", (Object)strParentDER));
                    }
                    Integer nAlias = derAliasMap.get(strParentDER);
                    strMTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 1));
                    strUTAlias = StringHelper.Format((String)"%1$s%2$s", (Object)strPreFix, (Object)(nAlias + 2));
                }
                IPSDEField relatedDEFHelper2 = null;
                String strDEFTableName = iPSDEField.getPSDTColumn(this.getId()).getRealTableName();
                if (StringHelper.IsNullOrEmpty((String)strDEFTableName) && iPSDEField.getPSDataEntity().isVirtual()) {
                    strDEFTableName = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true).getPSDTColumn(this.getId()).getRealTableName();
                    relatedDEFHelper2 = ((IPSLinkDEField)iPSDEField).getRealPSDEField(true);
                }
                if (relatedDEFHelper2 != null) {
                    if (StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                        String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strMTAlias, (Object)this.getDBObjStandardName(relatedDEFHelper2.getPSDTColumn(this.getId()).getColumnName()));
                        return strExp;
                    }
                    if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                        String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strUTAlias, (Object)this.getDBObjStandardName(relatedDEFHelper2.getPSDTColumn(this.getId()).getColumnName()));
                        return strExp;
                    }
                } else {
                    if (StringHelper.Compare((String)strMainTable, (String)strDEFTableName, (boolean)true) == 0) {
                        String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strMTAlias, (Object)this.getDBObjStandardName(iPSDEField.getPSDTColumn(this.getId()).getColumnName()));
                        return strExp;
                    }
                    if (StringHelper.Compare((String)strUserTable, (String)strDEFTableName, (boolean)true) == 0) {
                        String strExp = StringHelper.Format((String)"%1$s.%2$s", (Object)strUTAlias, (Object)this.getDBObjStandardName(iPSDEField.getPSDTColumn(this.getId()).getColumnName()));
                        return strExp;
                    }
                }
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5c5e\u6027[%1$s]\u8868\u540d[%2$s]", (Object)iPSDEField.getFullName(), (Object)strDEFTableName));
            }
            String strNewDER = strParentDER;
            if (bAddJoin) {
                if (!StringHelper.IsNullOrEmpty((String)strNewDER)) {
                    strNewDER = String.valueOf(strNewDER) + "|";
                }
                strNewDER = String.valueOf(strNewDER) + strDERID;
            }
            if ((relatedDEFHelper = iPSLinkDEField.getRelatedPSDEField()) == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u5173\u7cfb\u5c5e\u6027", (Object)iPSLinkDEField.getFullName()));
            }
            if (bAddJoin && !derAliasMap.containsKey(strNewDER)) {
                Integer nCurIndex = derAliasMap.get("%CURVALUE%");
                if (nCurIndex == null) {
                    nCurIndex = 0;
                }
                nCurIndex = nCurIndex + 10;
                derAliasMap.put(strNewDER, nCurIndex);
                derAliasMap.put("%CURVALUE%", nCurIndex);
                String strLastDERID = "";
                if (derList.size() > 0) {
                    strLastDERID = derList.get(derList.size() - 1);
                }
                if (!(strNewDER.indexOf(strLastDERID) != 0 || strNewDER.length() != strLastDERID.length() && strNewDER.charAt(strLastDERID.length()) != '|' || StringHelper.IsNullOrEmpty((String)strLastDERID))) {
                    derList.set(derList.size() - 1, strNewDER);
                } else {
                    derList.add(strNewDER);
                }
            }
            return this.getPSDEFieldExp(relatedDEFHelper, strNewDER, derAliasMap, derList, strPreFix);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8868\u8fbe\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iPSDEField.getFullModelName(), (Object)ex.getMessage()), ex);
        }
    }

    @Override
    public CallResult compileDBProc(IPSDatabase iPSDatabase, String strProcName, String strSQL) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getHibernateDialect() {
        return this.strHibernateDialect;
    }

    @Override
    public String getJdbcDialect() {
        return this.strJdbcDialect;
    }

    @Override
    public String getDBObjStandardName(String strOriginName) {
        return strOriginName;
    }

    public static final int compareSQL(String strValue1, String strValue2) {
        return StringHelper.Compare((String)PSDBTypeImpl.getSQLCode(strValue1), (String)PSDBTypeImpl.getSQLCode(strValue2), (boolean)false);
    }

    private static String getSQLCode(String strSQLCode) {
        if (strSQLCode == null) {
            return null;
        }
        strSQLCode = strSQLCode.replace("\r\n", " ");
        strSQLCode = strSQLCode.replace("\r", " ");
        strSQLCode = strSQLCode.replace("\n", " ");
        if (StringHelper.IsNullOrEmpty((String)(strSQLCode = strSQLCode.trim()))) {
            return null;
        }
        return strSQLCode;
    }

    @Override
    public String getDBClientPath(String strOS) {
        return this.strDBClientPath;
    }

    @Override
    public String getFuncSQL(String strFuncType, boolean bInsert, String[] args) throws Exception {
        IDBFunction iDBFunction = this.dbFunctionMap.get(strFuncType.toUpperCase());
        if (iDBFunction != null) {
            return iDBFunction.getFuncSQL(bInsert, args);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93\u51fd\u6570[%1$s]\u5bf9\u5e94\u7684SQL", (Object)strFuncType));
    }

    @Override
    public IDBFunction getDBFunction(String strFuncType) throws Exception {
        IDBFunction iDBFunction = this.dbFunctionMap.get(strFuncType);
        if (iDBFunction != null) {
            return iDBFunction;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5e93\u51fd\u6570[%1$s]", (Object)strFuncType));
    }

    protected void registerDBFunction(IDBFunction iDBFunction) {
        this.dbFunctionMap.put(iDBFunction.getName().toUpperCase(), iDBFunction);
    }

    @Override
    public void backupDBInst(String strDBInstType, BaseDataEntity dbInstData, BaseDataEntity dbBackupData, boolean bOffline) throws Exception {
        if (StringHelper.Compare((String)strDBInstType, (String)"PSSYSMODELINST", (boolean)false) == 0) {
            PSSysModelInst psSysModelInst = new PSSysModelInst();
            PSSysModelInstBK psSysModelInstBK = new PSSysModelInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psSysModelInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psSysModelInstBK);
            this.backupPSSysModelInst(psSysModelInst, psSysModelInstBK, bOffline);
            PSDEDataCtrl.convertEntity((IEntity)psSysModelInstBK, dbBackupData);
            return;
        }
        if (StringHelper.Compare((String)strDBInstType, (String)"PSDBDEVINST", (boolean)false) == 0) {
            PSDBDevInst psDBDevInst = new PSDBDevInst();
            PSDBDevInstBK psDBDevInstBK = new PSDBDevInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psDBDevInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psDBDevInstBK);
            this.backupPSDBDevInst(psDBDevInst, psDBDevInstBK, bOffline);
            PSDEDataCtrl.convertEntity((IEntity)psDBDevInstBK, dbBackupData);
            return;
        }
        if (StringHelper.Compare((String)strDBInstType, (String)"PSDEVCENTERDBINST", (boolean)false) == 0) {
            PSDevCenterDBInst psDCDBInst = new PSDevCenterDBInst();
            PSDCDBInstBK psDCDBInstBK = new PSDCDBInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psDCDBInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psDCDBInstBK);
            PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCDBInstBKService psDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevCenterDBInstService.get(psDCDBInst);
            psDCDBInstBKService.get(psDCDBInstBK);
            try {
                PSDevCenterDBInst psDCDBInst2 = new PSDevCenterDBInst();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction("BACKUP");
                psDevCenterDBInstService.update(psDCDBInst2);
                this.backupPSDCDBInst(psDCDBInst, psDCDBInstBK, bOffline);
                psDCDBInst2.reset();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction(null);
                psDevCenterDBInstService.update(psDCDBInst2);
            }
            catch (Exception ex) {
                PSDevCenterDBInst psDCDBInst2 = new PSDevCenterDBInst();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction(null);
                psDevCenterDBInstService.update(psDCDBInst2);
                throw ex;
            }
            PSDEDataCtrl.convertEntity((IEntity)psDCDBInstBK, dbBackupData);
            return;
        }
    }

    protected void backupPSSysModelInst(PSSysModelInst psSysModelInst, PSSysModelInstBK dbBackupData, boolean bOffline) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void backupPSDBDevInst(PSDBDevInst psDBDevInst, PSDBDevInstBK dbBackupData, boolean bOffline) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void backupPSDCDBInst(PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, boolean bOffline) throws Exception {
        int nFileSize;
        if ((DataObject.getIntegerValue((Object)psDCDBInst.getResPos(), (Integer)0) & 1) != 1) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u662f\u5e73\u53f0\u9884\u7f6e\u8d44\u6e90\uff0c\u4e0d\u80fd\u8fdb\u884c\u6062\u590d\u64cd\u4f5c", (Object)psDCDBInst.getPSDevCenterDBInstName()));
        }
        if (DataObject.getIntegerValue((Object)psDCDBInst.getResState(), (Integer)0) != 20) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u5904\u4e8e\u6b63\u5e38\u72b6\u6001\uff0c\u4e0d\u80fd\u8fdb\u884c\u6062\u590d\u64cd\u4f5c", (Object)psDCDBInst.getPSDevCenterDBInstName()));
        }
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        String strTmpFile = StringHelper.Format((String)"%1$tY%1$tm%1$td%1$tH%1$tM%1$tS.bak", (Object)new Date());
        String strFullBKFolder = StringHelper.Format((String)"%1$s%2$s%3$s%2$sPSDCDBINST%2$s%4$s", (Object)iPSTaskServerEnv.getBackupFolder(), (Object)File.separator, (Object)psDCDBInst.getPSDevCenterId(), (Object)psDCDBInst.getPSDevCenterDBInstId());
        String strBKFolder = StringHelper.Format((String)"%3$s%2$sPSDCDBINST%2$s%4$s", (Object)iPSTaskServerEnv.getBackupFolder(), (Object)File.separator, (Object)psDCDBInst.getPSDevCenterId(), (Object)psDCDBInst.getPSDevCenterDBInstId());
        File folder = new File(strFullBKFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        PSAppServer psAppServer = null;
        PSDBServer psDBServer = null;
        PSDBDevInst psDBDevInst = null;
        if (psDCDBInst.getPSDevCenterAS() != null) {
            psAppServer = psDCDBInst.getPSDevCenterAS().getPSAppServer();
        }
        if ((psDBDevInst = psDCDBInst.getPSDBDevInst()) != null) {
            psDBServer = psDBDevInst.getPSDBServer();
        }
        String strFullBKFilePath = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strFullBKFolder, (Object)File.separator, (Object)strTmpFile);
        String strBKFilePath = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)strBKFolder, (Object)File.separator, (Object)strTmpFile);
        this.onBackupPSDCDBInst(strFullBKFilePath, psDCDBInst, dbBackupData, psDBDevInst, psDBServer, psAppServer);
        dbBackupData.setBKFilePath(strBKFilePath);
        dbBackupData.setFullBKFilePath(strFullBKFilePath);
        dbBackupData.setPSTaskServerId(iPSTaskServerEnv.getId());
        dbBackupData.setPSTaskServerName(iPSTaskServerEnv.getName());
        File file = new File(strFullBKFilePath);
        if (file.exists()) {
            nFileSize = (int)(file.length() / 1024L);
            if (nFileSize <= 0) {
                nFileSize = 1;
            }
        } else {
            throw new Exception("\u5907\u4efd\u5931\u8d25");
        }
        dbBackupData.setBackupSize(Integer.valueOf(nFileSize));
    }

    protected void onBackupPSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void onOfflinePSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void restoreDBInst(String strDBInstType, BaseDataEntity dbInstData, BaseDataEntity dbBackupData) throws Exception {
        if (StringHelper.Compare((String)strDBInstType, (String)"PSSYSMODELINST", (boolean)false) == 0) {
            PSSysModelInst psSysModelInst = new PSSysModelInst();
            PSSysModelInstBK psSysModelInstBK = new PSSysModelInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psSysModelInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psSysModelInstBK);
            this.restorePSSysModelInst(psSysModelInst, psSysModelInstBK);
            PSDEDataCtrl.convertEntity((IEntity)psSysModelInstBK, dbBackupData);
            return;
        }
        if (StringHelper.Compare((String)strDBInstType, (String)"PSDBDEVINST", (boolean)false) == 0) {
            PSDBDevInst psDBDevInst = new PSDBDevInst();
            PSDBDevInstBK psDBDevInstBK = new PSDBDevInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psDBDevInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psDBDevInstBK);
            this.restorePSDBDevInst(psDBDevInst, psDBDevInstBK);
            PSDEDataCtrl.convertEntity((IEntity)psDBDevInstBK, dbBackupData);
            return;
        }
        if (StringHelper.Compare((String)strDBInstType, (String)"PSDEVCENTERDBINST", (boolean)false) == 0) {
            PSDevCenterDBInst psDCDBInst = new PSDevCenterDBInst();
            PSDCDBInstBK psDCDBInstBK = new PSDCDBInstBK();
            PSDEDataCtrl.convertEntity2(dbInstData, (IEntity)psDCDBInst);
            PSDEDataCtrl.convertEntity2(dbBackupData, (IEntity)psDCDBInstBK);
            PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCDBInstBKService psDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDevCenterDBInstService.get(psDCDBInst);
            psDCDBInstBKService.get(psDCDBInstBK);
            try {
                PSDevCenterDBInst psDCDBInst2 = new PSDevCenterDBInst();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction("RESTORE");
                psDevCenterDBInstService.update(psDCDBInst2);
                this.restorePSDCDBInst(psDCDBInst, psDCDBInstBK);
                psDCDBInst2.reset();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction(null);
                psDevCenterDBInstService.update(psDCDBInst2);
            }
            catch (Exception ex) {
                PSDevCenterDBInst psDCDBInst2 = new PSDevCenterDBInst();
                psDCDBInst2.setPSDevCenterDBInstId(psDCDBInst.getPSDevCenterDBInstId());
                psDCDBInst2.setCurDBAction(null);
                psDevCenterDBInstService.update(psDCDBInst2);
                throw ex;
            }
            PSDEDataCtrl.convertEntity((IEntity)psDCDBInstBK, dbBackupData);
            return;
        }
    }

    protected void restorePSSysModelInst(PSSysModelInst psSysModelInst, PSSysModelInstBK dbBackupData) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void restorePSDBDevInst(PSDBDevInst psDBDevInst, PSDBDevInstBK dbBackupData) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void restorePSDCDBInst(PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData) throws Exception {
        if ((DataObject.getIntegerValue((Object)psDCDBInst.getResPos(), (Integer)0) & 1) != 1) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u662f\u5e73\u53f0\u9884\u7f6e\u8d44\u6e90\uff0c\u4e0d\u80fd\u8fdb\u884c\u6062\u590d\u64cd\u4f5c", (Object)psDCDBInst.getPSDevCenterDBInstName()));
        }
        if (DataObject.getIntegerValue((Object)psDCDBInst.getResState(), (Integer)0) != 20) {
            throw new Exception(StringHelper.Format((String)"[%1$s]\u4e0d\u5904\u4e8e\u6b63\u5e38\u72b6\u6001\uff0c\u4e0d\u80fd\u8fdb\u884c\u6062\u590d\u64cd\u4f5c", (Object)psDCDBInst.getPSDevCenterDBInstName()));
        }
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        String strFullBKFile = StringHelper.Format((String)"%1$s%2$s%3$s", (Object)iPSTaskServerEnv.getBackupFolder(), (Object)File.separator, (Object)dbBackupData.getBKFilePath());
        PSAppServer psAppServer = null;
        PSDBServer psDBServer = null;
        PSDBDevInst psDBDevInst = null;
        if (psDCDBInst.getPSDevCenterAS() != null) {
            psAppServer = psDCDBInst.getPSDevCenterAS().getPSAppServer();
        }
        if ((psDBDevInst = psDCDBInst.getPSDBDevInst()) != null) {
            psDBServer = psDBDevInst.getPSDBServer();
        }
        this.onRestorePSDCDBInst(strFullBKFile, psDCDBInst, dbBackupData, psDBDevInst, psDBServer, psAppServer);
    }

    protected void onRestorePSDCDBInst(String strFullBKFilePath, PSDevCenterDBInst psDCDBInst, PSDCDBInstBK dbBackupData, PSDBDevInst psDBDevInst, PSDBServer psDBServer, PSAppServer psAppServer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSDEFDTColumn createPSDEFDTColumnEx(PSDEFDTColumn psDEFDTColumn, IPSDEDBConfig iPSDEDBConfig) throws Exception {
        return this.createPSDEFDTColumn(psDEFDTColumn);
    }
}

