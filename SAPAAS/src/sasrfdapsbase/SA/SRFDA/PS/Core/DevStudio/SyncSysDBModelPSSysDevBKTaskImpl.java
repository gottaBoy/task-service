/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEField
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDETable
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDETableService
 *  net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryException;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.GITPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Pub.PSDBPublishContextImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.StdDataTypeCodeListModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETableService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBColumn;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBDetail;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBTable;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfgBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSysDBModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(SyncSysDBModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getTASKPARAM())) {
            if (this.getPSSysRunSession() == null || this.getPSSysRunSession().getPSSystemDBConfig() == null) {
                return "\u6ca1\u6709\u6307\u5b9a\u540c\u6b65\u6570\u636e\u6e90";
            }
            this.psSysDevBKTask.setTASKPARAM(this.getPSSysRunSession().getPSSystemDBConfig().getId());
        }
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
        psSystemDBConfig2.setPSSystemDBCfgId(this.psSysDevBKTask.getTASKPARAM());
        psSystemDBCfgService.get((IEntity)psSystemDBConfig2);
        try {
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSystemDBConfig2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            String strRet = this.syncSysDBModel(psSystemDBConfig2);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strRet;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            throw ex;
        }
    }

    protected String syncSysDBModel(PSSystemDBCfg psSystemDBConfig) throws Exception {
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psSystemDBConfig.getPSSystemId());
        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
        PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)sessionFactory);
        PSSysDBDetailService psSysDBDetailService = (PSSysDBDetailService)ServiceGlobal.getService(PSSysDBDetailService.class, (SessionFactory)sessionFactory);
        ArrayList psDataEntityList = psDataEntityService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysDBDetailList = psSysDBDetailService.selectByPSSystemDBCfg((PSSystemDBCfgBase)psSystemDBConfig);
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        for (PSDataEntity psDataEntity : psDataEntityList) {
            if (!DataObject.getBoolValue((Integer)psDataEntity.getValidFlag(), (boolean)true) || DataObject.getIntegerValue((Object)psDataEntity.getDynaModelFlag(), (Integer)0) != 0) continue;
            psDataEntityMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
        }
        for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
            PSDataEntity psDataEntity;
            if (!psDataEntityMap.containsKey(psSysDBDetail.getPSDEId()) || DataTypeHelper.compare((int)9, (Object)(psDataEntity = (PSDataEntity)psDataEntityMap.get(psSysDBDetail.getPSDEId())).getDBVer(), (Object)psSysDBDetail.getPubDBVer()) != 0L) continue;
            psDataEntityMap.remove(psSysDBDetail.getPSDEId());
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.psSysDevBKTask.getPSDEVSLNSYSID());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        if (iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        }
        IPSSystemDBConfig iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(psSystemDBConfig.getPSSystemDBCfgName());
        Iterator<IPSDataEntity> psDataEntities = iPSSystem.getAllPSDataEntities();
        if (psDataEntities != null) {
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                if (!iPSDataEntity.isEnableSQLStorage()) continue;
                this.onPublishDBModel3(iPSDataEntity);
            }
        }
        if (psDataEntityMap.size() == 0) {
            return StringHelper.format((String)"\u6ca1\u6709\u540c\u6b65\u4efb\u4f55\u6570\u636e");
        }
        HashMap<String, IPSDataEntity> psDataEntityMap2 = new HashMap<String, IPSDataEntity>();
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            psDataEntityMap2.put(psDataEntity.getPSDataEntityName(), iPSSystem.getPSDataEntity2(psDataEntity.getPSDataEntityName()));
        }
        IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
        GITPSSystemDBConfig jitPSSystemDBConfig = null;
        if (jitPSDBDevInst != null && StringHelper.compare((String)iPSSystemDBConfig.getDBType(), (String)jitPSDBDevInst.getDBType(), (boolean)true) == 0 && StringHelper.compare((String)iPSSystemDBConfig.getPSDBDevInstId(), (String)jitPSDBDevInst.getId(), (boolean)false) != 0) {
            GITPSSystemDBConfig psSystemDBConfig2 = new GITPSSystemDBConfig();
            psSystemDBConfig2.init(this.getDAGlobalHelper(), iPSSystem);
            jitPSSystemDBConfig = psSystemDBConfig2;
        }
        int nTotalCount = psDataEntityMap.size();
        sBuilderEx.append("[v%1$s]\u540c\u6b65\u6570\u636e\u5e93\u6a21\u578b[%2$s]", (Object)iPSSystem.getVersion(), (Object)nTotalCount);
        int nIndex = 0;
        nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            sBuilderEx.append("\r\n[%1$s]\u540c\u6b65\u5b9e\u4f53\u6a21\u578b[%2$s]", (Object)(nIndex + 1), (Object)psDataEntity.getPSDataEntityName());
            ++nIndex;
            this.onPublishDBModel(iPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            if (jitPSSystemDBConfig != null) {
                this.onPublishDBModel(jitPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            }
            log.info((Object)StringHelper.format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDataEntityName(), (Object)nIndex, (Object)nTotalCount));
        }
        nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            ++nIndex;
            this.onPublishDBModel2(iPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            if (jitPSSystemDBConfig != null) {
                this.onPublishDBModel2(jitPSSystemDBConfig, (IPSDataEntity)psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
            }
            log.info((Object)StringHelper.format((String)"\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b2\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDataEntityName(), (Object)nIndex, (Object)nTotalCount));
            PSSysDBDetail psSysDBDetail = new PSSysDBDetail();
            psSysDBDetail.setPSSysDBDetailName(psDataEntity.getPSDataEntityName());
            psSysDBDetail.setPSDEId(psDataEntity.getPSDataEntityId());
            psSysDBDetail.setPSSystemDBCfgId(psSystemDBConfig.getPSSystemDBCfgId());
            psSysDBDetail.setPubDBVer(psDataEntity.getDBVer());
            psSysDBDetailService.save((IEntity)psSysDBDetail, false);
        }
        iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
        return sBuilderEx.toString();
    }

    protected void onPublishDBModel(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(iPSSystemDBConfig.getPSSysModelInstId());
        psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.isNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        IPSDEDBConfig iPSDEDBConfig = null;
        try {
            boolean bTryMode = iPSDataEntity.isSubSysDE() || !iPSDataEntity.isEnableSQLStorage();
            iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6307\u5b9a\u6570\u636e\u5e93[%2$s]\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getName(), (Object)iPSSystemDBConfig.getName(), (Object)ex.getMessage()), ex);
        }
        if (iPSDEDBConfig != null && iPSDEDBConfig.isValidFlag() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel(psPublishContextImpl, iPSDBDevInst);
        }
    }

    protected void onPublishDBModel2(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl(this.getDAGlobalHelper(), null);
        psPublishContextImpl.setPSSysModelInstId(iPSSystemDBConfig.getPSSysModelInstId());
        psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.isNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        IPSDEDBConfig iPSDEDBConfig = null;
        try {
            boolean bTryMode;
            boolean bl = bTryMode = !iPSDataEntity.isEnableSQLStorage();
            if (!bTryMode && iPSDataEntity.isSubSysDE()) {
                bTryMode = true;
                Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
                while (psDEDataQueries.hasNext()) {
                    IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                    if (iPSDEDataQuery.getExtendMode() != 2) continue;
                    bTryMode = false;
                    break;
                }
            }
            iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6307\u5b9a\u6570\u636e\u5e93[%2$s]\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getName(), (Object)iPSSystemDBConfig.getName(), (Object)ex.getMessage()), ex);
        }
        if (iPSDEDBConfig != null) {
            if (iPSDEDBConfig.isValid() && iPSDEDBConfig.isPubModel()) {
                iPSDEDBConfig.publishDBModel2(psPublishContextImpl, iPSDBDevInst);
            }
            if (iPSDEDBConfig.isValid()) {
                Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
                while (psDEDataQueries.hasNext()) {
                    IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                    if (iPSDataEntity.isSubSysDE() && iPSDEDataQuery.getExtendMode() != 2) continue;
                    IPSDBType iDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
                    IPSDEDQCodePublisher iPSDEDQCodePublisher = iDBType.getPSDEDQCodePublisher();
                    try {
                        iPSDEDQCodePublisher.generateCode(psPublishContextImpl, iPSDEDataQuery);
                        iPSDEDQCodePublisher.close();
                    }
                    catch (Exception ex) {
                        throw new PSDEDataQueryException(iPSDEDataQuery, 20013, StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u6570\u636e\u67e5\u8be2[%2$s]\u53d1\u5e03\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDEDataQuery.getPSDataEntity().getName(), (Object)iPSDEDataQuery.getName(), (Object)ex.getMessage()));
                    }
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onPublishDBModel3(IPSDataEntity iPSDataEntity) throws Exception {
        iPSSysDBScheme = iPSDataEntity.getPSSysDBScheme();
        if (iPSSysDBScheme == null) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)iPSDataEntity.getTableName())) {
            return;
        }
        iPSSysDBTable = iPSSysDBScheme.getPSSysDBTable(iPSDataEntity.getTableName(), true);
        strPSSysDBTableId = null;
        if (iPSSysDBTable == null) {
            sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
            psSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, (SessionFactory)sessionFactory);
            psSysDBTable = new PSSysDBTable();
            psSysDBTable.setPSSysDBSchemeId(iPSSysDBScheme.getId());
            psSysDBTable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
            if (!psSysDBTableService.existsData((IEntity)psSysDBTable)) {
                try {
                    psSysDBTable.setCodeName(iPSDataEntity.getTableName());
                    psSysDBTable.setLogicName(iPSDataEntity.getLogicName());
                    psSysDBTable.setPSSysDBSchemeName(iPSSysDBScheme.getName());
                    psSysDBTable.setTableType("TABLE");
                    psSysDBTableService.create((IEntity)psSysDBTable, true);
                    strPSSysDBTableId = psSysDBTable.getPSSysDBTableId();
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6570\u636e\u5e93\u8868[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)iPSDataEntity.getTableName(), (Object)ex.getMessage()), ex);
                }
            } else {
                strPSSysDBTableId = psSysDBTable.getPSSysDBTableId();
            }
        } else {
            strPSSysDBTableId = iPSSysDBTable.getId();
        }
        iPSDEDBTable = iPSDataEntity.getPSDEDBTable(iPSDataEntity.getTableName(), true);
        strPSDEDBTableId = null;
        if (iPSDEDBTable == null) {
            sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
            psDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)sessionFactory);
            psDETable = new PSDETable();
            psDETable.setPSDEId(iPSDataEntity.getId());
            psDETable.setPSSysDBTableId(strPSSysDBTableId);
            if (!psDETableService.existsData((IEntity)psDETable)) {
                try {
                    psDETable.reset();
                    psDETable.setPSDEId(iPSDataEntity.getId());
                    psDETable.setTableType("MAIN");
                    if (psDETableService.select((IEntity)psDETable, true)) {
                        psDETable.setPSDEName(iPSDataEntity.getName());
                        psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setTableType("MAIN");
                        psDETable.setPSSysDBTableId(strPSSysDBTableId);
                        psDETableService.update((IEntity)psDETable, true);
                        strPSDEDBTableId = psDETable.getPSDETableId();
                    }
                    psDETable.setPSDEName(iPSDataEntity.getName());
                    psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                    psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                    psDETable.setTableType("MAIN");
                    psDETable.setPSSysDBTableId(strPSSysDBTableId);
                    psDETableService.create((IEntity)psDETable, true);
                    strPSDEDBTableId = psDETable.getPSDETableId();
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u8868[%1$s-%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getName(), (Object)iPSDataEntity.getTableName(), (Object)ex.getMessage()), ex);
                }
            } else {
                strPSDEDBTableId = psDETable.getPSDETableId();
            }
        } else {
            strPSDEDBTableId = iPSDEDBTable.getId();
            if (StringHelper.isNullOrEmpty((String)iPSDEDBTable.getPSSysDBTableId())) {
                sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
                psDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, (SessionFactory)sessionFactory);
                try {
                    psDETable = new PSDETable();
                    psDETable.setPSDETableId(strPSDEDBTableId);
                    psDETable.setPSSysDBTableId(strPSSysDBTableId);
                    psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                    psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                    psDETable.setTableType("MAIN");
                    psDETableService.update((IEntity)psDETable, true);
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.format((String)"\u66f4\u65b0\u5b9e\u4f53\u6570\u636e\u8868[%1$s-%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getName(), (Object)iPSDataEntity.getTableName(), (Object)ex.getMessage()), ex);
                }
            }
        }
        if (iPSDataEntity.getSaaSMode() != IPSDataEntity.SAASMODE_NOTSUPPORTED.intValue() && !StringHelper.isNullOrEmpty((String)iPSDataEntity.getSaaSDCIdColumnName()) && iPSDataEntity.getPSDEField(iPSDataEntity.getSaaSDCIdColumnName(), true) == null) {
            strPSSysDBColumnId = null;
            if (iPSSysDBTable != null && (iPSSysDBColumn = iPSSysDBTable.getPSSysDBColumn(iPSDataEntity.getSaaSDCIdColumnName(), true)) != null) {
                strPSSysDBColumnId = iPSSysDBColumn.getId();
            }
            if (StringHelper.isNullOrEmpty(strPSSysDBColumnId)) {
                sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
                psSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)sessionFactory);
                psSysDBColumn = new PSSysDBColumn();
                psSysDBColumn.setPSSysDBTableId(strPSSysDBTableId);
                psSysDBColumn.setPSSysDBColumnName(iPSDataEntity.getSaaSDCIdColumnName());
                if (!psSysDBColumnService.existsData((IEntity)psSysDBColumn)) {
                    try {
                        psSysDBColumn.setCodeName(iPSDataEntity.getSaaSDCIdColumnName());
                        psSysDBColumn.setLogicName("\u79df\u6237\u6807\u8bc6");
                        psSysDBColumn.setStdDataType(Integer.valueOf(25));
                        psSysDBColumn.setLength(Integer.valueOf(100));
                        psSysDBColumnService.create((IEntity)psSysDBColumn, true);
                        strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                    }
                    catch (Exception ex) {
                        throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6570\u636e\u8868\u5217[%1$s-%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getTableName(), (Object)iPSDataEntity.getSaaSDCIdColumnName(), (Object)ex.getMessage()), ex);
                    }
                }
            }
        }
        iPSSystemUtil = (IPSSystemUtil)iPSDataEntity.getPSSystem();
        stdDataTypeCodeListModel = (StdDataTypeCodeListModel)CodeListGlobal.getCodeList(StdDataTypeCodeListModel.class);
        psDEFields = iPSDataEntity.getAllPSDEFields();
        if (psDEFields != null) {
            while (psDEFields.hasNext()) {
                iPSDEField = psDEFields.next();
                if (!iPSDEField.isPhisicalDEField()) continue;
                iPSSysDBColumn = iPSDEField.getPSSysDBColumn();
                if (iPSSysDBColumn != null && StringHelper.compare((String)strPSSysDBTableId, (String)iPSSysDBColumn.getPSSysDBTable().getId(), (boolean)false) != 0) {
                    iPSSysDBColumn = null;
                }
                if (iPSSysDBColumn != null) {
                    if (!SyncSysDBModelPSSysDevBKTaskImpl.testCompatibleDataType(iPSDEField.getStdDataType(), iPSSysDBColumn.getStdDataType())) {
                        iPSSystemUtil.getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", new Object[]{iPSDataEntity.getName(), iPSDEField.getName()}), String.format("\u6807\u51c6\u7c7b\u578b[%1$s]\u4e0e\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u6807\u51c6\u7c7b\u578b[%4$s]\u53ef\u80fd\u4e0d\u517c\u5bb9", new Object[]{stdDataTypeCodeListModel.getCodeListText(Integer.toString(iPSDEField.getStdDataType()), false), iPSSysDBColumn.getPSSysDBTable().getName(), iPSSysDBColumn.getName(), stdDataTypeCodeListModel.getCodeListText(Integer.toString(iPSSysDBColumn.getStdDataType()), false)}));
                        continue;
                    }
                    if (DataTypeHelper.isLongStringType((int)iPSDEField.getStdDataType())) continue;
                    if (DataTypeHelper.isStringType((int)iPSDEField.getStdDataType())) {
                        if (iPSDEField.getLength() <= iPSSysDBColumn.getLength()) continue;
                        iPSSystemUtil.getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", new Object[]{iPSDataEntity.getName(), iPSDEField.getName()}), String.format("\u6570\u636e\u957f\u5ea6[%1$s]\u5927\u4e8e\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u6570\u636e\u957f\u5ea6[%4$s]", new Object[]{iPSDEField.getLength(), iPSSysDBColumn.getPSSysDBTable().getName(), iPSSysDBColumn.getName(), iPSSysDBColumn.getLength()}));
                        continue;
                    }
                    if (DataTypeHelper.isIntType((int)iPSDEField.getStdDataType())) {
                        if (iPSDEField.getLength() <= 0 || iPSSysDBColumn.getLength() <= 0 || iPSDEField.getLength() <= iPSSysDBColumn.getLength()) continue;
                        iPSSystemUtil.getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", new Object[]{iPSDataEntity.getName(), iPSDEField.getName()}), String.format("\u6570\u636e\u4f4d\u6570[%1$s]\u5927\u4e8e\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u6570\u636e\u4f4d\u6570[%4$s]", new Object[]{iPSDEField.getLength(), iPSSysDBColumn.getPSSysDBTable().getName(), iPSSysDBColumn.getName(), iPSSysDBColumn.getLength()}));
                        continue;
                    }
                    if (!DataTypeHelper.isBigDecimalType((int)iPSDEField.getStdDataType()) && !SyncSysDBModelPSSysDevBKTaskImpl.isNumberType(iPSDEField.getStdDataType())) continue;
                    if (iPSDEField.getLength() > 0 && iPSSysDBColumn.getLength() > 0 && iPSDEField.getLength() > iPSSysDBColumn.getLength()) {
                        iPSSystemUtil.getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", new Object[]{iPSDataEntity.getName(), iPSDEField.getName()}), String.format("\u6570\u636e\u4f4d\u6570[%1$s]\u5927\u4e8e\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u6570\u636e\u4f4d\u6570[%4$s]", new Object[]{iPSDEField.getLength(), iPSSysDBColumn.getPSSysDBTable().getName(), iPSSysDBColumn.getName(), iPSSysDBColumn.getLength()}));
                    }
                    if (iPSDEField.getPrecision() <= 0 || iPSDEField.getPrecision() <= iPSSysDBColumn.getPrecision()) continue;
                    iPSSystemUtil.getPSSysConsole().warn(String.format("\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]", new Object[]{iPSDataEntity.getName(), iPSDEField.getName()}), String.format("\u5c0f\u6570\u4f4d\u6570[%1$s]\u5927\u4e8e\u6570\u636e\u8868[%2$s]\u5217[%3$s]\u5c0f\u6570\u4f4d\u6570[%4$s]", new Object[]{iPSDEField.getPrecision(), iPSSysDBColumn.getPSSysDBTable().getName(), iPSSysDBColumn.getName(), iPSSysDBColumn.getPrecision()}));
                    continue;
                }
                if (StringHelper.compare((String)iPSDataEntity.getTableName(), (String)iPSDEField.getTableName(), (boolean)true) != 0) continue;
                strPSSysDBColumnId = null;
                if (iPSSysDBTable != null && (iPSSysDBColumn = iPSSysDBTable.getPSSysDBColumn(iPSDEField.getName(), true)) != null) {
                    strPSSysDBColumnId = iPSSysDBColumn.getId();
                }
                if (StringHelper.isNullOrEmpty(strPSSysDBColumnId)) {
                    sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
                    psSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, (SessionFactory)sessionFactory);
                    psSysDBColumn = new PSSysDBColumn();
                    psSysDBColumn.setPSSysDBTableId(strPSSysDBTableId);
                    psSysDBColumn.setPSSysDBColumnName(iPSDEField.getName());
                    if (!psSysDBColumnService.existsData((IEntity)psSysDBColumn)) {
                        try {
                            psSysDBColumn.setCodeName(iPSDEField.getName());
                            psSysDBColumn.setLogicName(iPSDEField.getLogicName());
                            if (iPSDEField.isKeyDEField()) {
                                psSysDBColumn.setPKey(Integer.valueOf(1));
                                psSysDBColumn.setAllowEmpty(Integer.valueOf(0));
                            }
                            psSysDBColumn.setStdDataType(Integer.valueOf(iPSDEField.getStdDataType()));
                            if (iPSDEField.getLength() > 0) {
                                psSysDBColumn.setLength(Integer.valueOf(iPSDEField.getLength()));
                            }
                            if (iPSDEField.getPrecision() >= 0) {
                                psSysDBColumn.setPrecision2(Integer.valueOf(iPSDEField.getPrecision()));
                            }
                            psSysDBColumnService.create((IEntity)psSysDBColumn, true);
                            strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                            if (StringHelper.isNullOrEmpty((String)iPSDEField.getPredefinedType()) || StringHelper.compare((String)iPSDEField.getPredefinedType(), (String)"CREATEDATE", (boolean)true) != 0 && StringHelper.compare((String)iPSDEField.getPredefinedType(), (String)"CREATEMAN", (boolean)true) != 0 && StringHelper.compare((String)iPSDEField.getPredefinedType(), (String)"LOGICVALID", (boolean)true) != 0 && StringHelper.compare((String)iPSDEField.getPredefinedType(), (String)"UPDATEMAN", (boolean)true) != 0 && StringHelper.compare((String)iPSDEField.getPredefinedType(), (String)"UPDATEDATE", (boolean)true) != 0) ** GOTO lbl157
                            psSysDBColumn.setAllowEmpty(Integer.valueOf(0));
                        }
                        catch (Exception ex) {
                            throw new Exception(StringHelper.format((String)"\u5efa\u7acb\u7cfb\u7edf\u6570\u636e\u8868\u5217[%1$s-%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)iPSDataEntity.getTableName(), (Object)iPSDEField.getName(), (Object)ex.getMessage()), ex);
                        }
                    } else {
                        strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                    }
                }
lbl157:
                // 5 sources

                sessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
                psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)sessionFactory);
                psDEField = new PSDEField();
                psDEField.setPSDEFieldId(iPSDEField.getId());
                psDEField.setPSDETableId(strPSDEDBTableId);
                psDEField.setPSSysDBColumnId(strPSSysDBColumnId);
                psDEFieldService.sysUpdate((IEntity)psDEField, false);
            }
        }
    }

    public static boolean testCompatibleDataType(int nSrcDataType, int nDstDataType) {
        return nSrcDataType == nDstDataType || !(DataTypeHelper.isStringType((int)nSrcDataType) && !DataTypeHelper.isStringType((int)nDstDataType) || DataTypeHelper.isDateTimeType((int)nSrcDataType) && !DataTypeHelper.isDateTimeType((int)nDstDataType) || DataTypeHelper.isBinaryType((int)nSrcDataType) && !DataTypeHelper.isBinaryType((int)nDstDataType) || (nSrcDataType == 29 || nSrcDataType == 6) && nDstDataType != 29 && nDstDataType != 6 || SyncSysDBModelPSSysDevBKTaskImpl.isNumberType(nSrcDataType) && !SyncSysDBModelPSSysDevBKTaskImpl.isNumberType(nDstDataType)) && (!DataTypeHelper.isLongStringType((int)nSrcDataType) || DataTypeHelper.isLongStringType((int)nDstDataType));
    }

    protected static boolean isNumberType(int nStdDataType) {
        return DataTypeHelper.isBigDecimalType((int)nStdDataType) || DataTypeHelper.isBigIntType((int)nStdDataType) || DataTypeHelper.isDoubleType((int)nStdDataType) || DataTypeHelper.isIntType((int)nStdDataType);
    }
}

