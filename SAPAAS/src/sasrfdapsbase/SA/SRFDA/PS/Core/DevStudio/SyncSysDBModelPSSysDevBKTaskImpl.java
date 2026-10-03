package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.PSDEDataQueryException;
import SA.SRFDA.PS.Core.Database.GITPSSystemDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Pub.PSDBPublishContextImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBColumnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBTableService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class SyncSysDBModelPSSysDevBKTaskImpl extends PSSysDevBKTaskImplBase {
   private static final Log log = LogFactory.getLog(SyncSysDBModelPSSysDevBKTaskImpl.class);

   @Override
   protected void onInit() throws Exception {
      super.onInit();
   }

   @Override
   protected String onRun() throws Exception {
      if (StringHelper.isNullOrEmpty(this.psSysDevBKTask.getTASKPARAM())) {
         if (this.getPSSysRunSession() == null || this.getPSSysRunSession().getPSSystemDBConfig() == null) {
            return "没有指定同步数据源";
         }

         this.psSysDevBKTask.setTASKPARAM(this.getPSSysRunSession().getPSSystemDBConfig().getId());
      }

      PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(
         PSSystemDBCfgService.class, PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId())
      );
      PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
      psSystemDBConfig2.setPSSystemDBCfgId(this.psSysDevBKTask.getTASKPARAM());
      psSystemDBCfgService.get(psSystemDBConfig2);

      try {
         PSCoreSysServiceBase.setCurrentPSSystemId(psSystemDBConfig2.getPSSystemId());
         PSCoreSysServiceBase.setCurrentPSDevSlnSysId(this.getPSDevSlnSysId());
         String strRet = this.syncSysDBModel(psSystemDBConfig2);
         PSCoreSysServiceBase.setCurrentPSSystemId(null);
         PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
         return strRet;
      } catch (Exception ex) {
         PSCoreSysServiceBase.setCurrentPSSystemId(null);
         PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
         throw ex;
      }
   }

   protected String syncSysDBModel(PSSystemDBCfg psSystemDBConfig) throws Exception {
      StringBuilderEx sBuilderEx = new StringBuilderEx();
      PSSystem psSystem = new PSSystem();
      psSystem.setPSSystemId(psSystemDBConfig.getPSSystemId());
      SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
      PSDataEntityService psDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, sessionFactory);
      PSSysDBDetailService psSysDBDetailService = (PSSysDBDetailService)ServiceGlobal.getService(PSSysDBDetailService.class, sessionFactory);
      ArrayList<PSDataEntity> psDataEntityList = psDataEntityService.selectByPSSystem(psSystem);
      ArrayList<PSSysDBDetail> psSysDBDetailList = psSysDBDetailService.selectByPSSystemDBCfg(psSystemDBConfig);
      HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<>();

      for (PSDataEntity psDataEntity : psDataEntityList) {
         if (DataObject.getBoolValue(psDataEntity.getValidFlag(), true) && DataObject.getIntegerValue(psDataEntity.getDynaModelFlag(), 0) == 0) {
            psDataEntityMap.put(psDataEntity.getPSDataEntityId(), psDataEntity);
         }
      }

      for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
         if (psDataEntityMap.containsKey(psSysDBDetail.getPSDEId())) {
            PSDataEntity psDataEntity = psDataEntityMap.get(psSysDBDetail.getPSDEId());
            if (DataTypeHelper.compare(9, psDataEntity.getDBVer(), psSysDBDetail.getPubDBVer()) == 0L) {
               psDataEntityMap.remove(psSysDBDetail.getPSDEId());
            }
         }
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
            if (iPSDataEntity.isEnableSQLStorage()) {
               this.onPublishDBModel3(iPSDataEntity);
            }
         }
      }

      if (psDataEntityMap.size() == 0) {
         return StringHelper.format("没有同步任何数据");
      }

      HashMap<String, IPSDataEntity> psDataEntityMap2 = new HashMap<>();

      for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
         psDataEntityMap2.put(psDataEntity.getPSDataEntityName(), iPSSystem.getPSDataEntity2(psDataEntity.getPSDataEntityName()));
      }

      IPSDBDevInst jitPSDBDevInst = iPSSystem.getJITPSDBDevInst();
      IPSSystemDBConfig jitPSSystemDBConfig = null;
      if (jitPSDBDevInst != null
         && StringHelper.compare(iPSSystemDBConfig.getDBType(), jitPSDBDevInst.getDBType(), true) == 0
         && StringHelper.compare(iPSSystemDBConfig.getPSDBDevInstId(), jitPSDBDevInst.getId(), false) != 0) {
         GITPSSystemDBConfig psSystemDBConfig2 = new GITPSSystemDBConfig();
         psSystemDBConfig2.init(this.getDAGlobalHelper(), iPSSystem);
         jitPSSystemDBConfig = psSystemDBConfig2;
      }

      int nTotalCount = psDataEntityMap.size();
      sBuilderEx.append("[v%1$s]同步数据库模型[%2$s]", iPSSystem.getVersion(), nTotalCount);
      int nIndex = 0;
      nIndex = 0;

      for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
         sBuilderEx.append("\r\n[%1$s]同步实体模型[%2$s]", nIndex + 1, psDataEntity.getPSDataEntityName());
         nIndex++;
         this.onPublishDBModel(iPSSystemDBConfig, psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
         if (jitPSSystemDBConfig != null) {
            this.onPublishDBModel(jitPSSystemDBConfig, psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
         }

         log.info(StringHelper.format("发布实体[%1$s]数据库模型，%2$s/%3$s", psDataEntity.getPSDataEntityName(), nIndex, nTotalCount));
      }

      nIndex = 0;

      for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
         nIndex++;
         this.onPublishDBModel2(iPSSystemDBConfig, psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
         if (jitPSSystemDBConfig != null) {
            this.onPublishDBModel2(jitPSSystemDBConfig, psDataEntityMap2.get(psDataEntity.getPSDataEntityName()));
         }

         log.info(StringHelper.format("发布实体[%1$s]数据库模型2，%2$s/%3$s", psDataEntity.getPSDataEntityName(), nIndex, nTotalCount));
         PSSysDBDetail psSysDBDetail = new PSSysDBDetail();
         psSysDBDetail.setPSSysDBDetailName(psDataEntity.getPSDataEntityName());
         psSysDBDetail.setPSDEId(psDataEntity.getPSDataEntityId());
         psSysDBDetail.setPSSystemDBCfgId(psSystemDBConfig.getPSSystemDBCfgId());
         psSysDBDetail.setPubDBVer(psDataEntity.getDBVer());
         psSysDBDetailService.save(psSysDBDetail, false);
      }

      iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
      return sBuilderEx.toString();
   }

   protected void onPublishDBModel(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
      PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl(this.getDAGlobalHelper(), null);
      psPublishContextImpl.setPSSysModelInstId(iPSSystemDBConfig.getPSSysModelInstId());
      psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
      IPSDBDevInst iPSDBDevInst = null;
      if (!StringHelper.isNullOrEmpty(iPSSystemDBConfig.getPSDBDevInstId())) {
         iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
      }

      IPSDEDBConfig iPSDEDBConfig = null;

      try {
         boolean bTryMode = iPSDataEntity.isSubSysDE() || !iPSDataEntity.isEnableSQLStorage();
         iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
      } catch (Exception ex) {
         throw new Exception(StringHelper.format("获取实体[%1$s]指定数据库[%2$s]配置发生异常，%3$s", iPSDataEntity.getName(), iPSSystemDBConfig.getName(), ex.getMessage()), ex);
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
      if (!StringHelper.isNullOrEmpty(iPSSystemDBConfig.getPSDBDevInstId())) {
         iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
      }

      IPSDEDBConfig iPSDEDBConfig = null;

      try {
         boolean bTryMode = !iPSDataEntity.isEnableSQLStorage();
         if (!bTryMode && iPSDataEntity.isSubSysDE()) {
            bTryMode = true;
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();

            while (psDEDataQueries.hasNext()) {
               IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
               if (iPSDEDataQuery.getExtendMode() == 2) {
                  bTryMode = false;
                  break;
               }
            }
         }

         iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName(), bTryMode);
      } catch (Exception ex) {
         throw new Exception(StringHelper.format("获取实体[%1$s]指定数据库[%2$s]配置发生异常，%3$s", iPSDataEntity.getName(), iPSSystemDBConfig.getName(), ex.getMessage()), ex);
      }

      if (iPSDEDBConfig != null) {
         if (iPSDEDBConfig.isValid() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel2(psPublishContextImpl, iPSDBDevInst);
         }

         if (iPSDEDBConfig.isValid()) {
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();

            while (psDEDataQueries.hasNext()) {
               IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
               if (!iPSDataEntity.isSubSysDE() || iPSDEDataQuery.getExtendMode() == 2) {
                  IPSDBType iDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
                  IPSDEDQCodePublisher iPSDEDQCodePublisher = iDBType.getPSDEDQCodePublisher();

                  try {
                     iPSDEDQCodePublisher.generateCode(psPublishContextImpl, iPSDEDataQuery);
                     iPSDEDQCodePublisher.close();
                  } catch (Exception ex) {
                     throw new PSDEDataQueryException(
                        iPSDEDataQuery,
                        20013,
                        StringHelper.format(
                           "实体[%1$s]数据查询[%2$s]发布发生异常，%3$s", iPSDEDataQuery.getPSDataEntity().getName(), iPSDEDataQuery.getName(), ex.getMessage()
                        )
                     );
                  }
               }
            }
         }
      }
   }

   protected void onPublishDBModel3(IPSDataEntity iPSDataEntity) throws Exception {
      IPSSysDBScheme iPSSysDBScheme = iPSDataEntity.getPSSysDBScheme();
      if (iPSSysDBScheme != null) {
         if (!StringHelper.isNullOrEmpty(iPSDataEntity.getTableName())) {
            IPSSysDBTable iPSSysDBTable = iPSSysDBScheme.getPSSysDBTable(iPSDataEntity.getTableName(), true);
            String strPSSysDBTableId = null;
            if (iPSSysDBTable == null) {
               SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
               PSSysDBTableService psSysDBTableService = (PSSysDBTableService)ServiceGlobal.getService(PSSysDBTableService.class, sessionFactory);
               PSSysDBTable psSysDBTable = new PSSysDBTable();
               psSysDBTable.setPSSysDBSchemeId(iPSSysDBScheme.getId());
               psSysDBTable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
               if (!psSysDBTableService.existsData(psSysDBTable)) {
                  try {
                     psSysDBTable.setCodeName(iPSDataEntity.getTableName());
                     psSysDBTable.setLogicName(iPSDataEntity.getLogicName());
                     psSysDBTable.setPSSysDBSchemeName(iPSSysDBScheme.getName());
                     psSysDBTable.setTableType("TABLE");
                     psSysDBTableService.create(psSysDBTable, true);
                     strPSSysDBTableId = psSysDBTable.getPSSysDBTableId();
                  } catch (Exception ex) {
                     throw new Exception(StringHelper.format("建立系统数据库表[%1$s]发生异常，%2$s", iPSDataEntity.getTableName(), ex.getMessage()), ex);
                  }
               } else {
                  strPSSysDBTableId = psSysDBTable.getPSSysDBTableId();
               }
            } else {
               strPSSysDBTableId = iPSSysDBTable.getId();
            }

            IPSDEDBTable iPSDEDBTable = iPSDataEntity.getPSDEDBTable(iPSDataEntity.getTableName(), true);
            String strPSDEDBTableId = null;
            if (iPSDEDBTable == null) {
               SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
               PSDETableService psDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, sessionFactory);
               PSDETable psDETable = new PSDETable();
               psDETable.setPSDEId(iPSDataEntity.getId());
               psDETable.setPSSysDBTableId(strPSSysDBTableId);
               if (!psDETableService.existsData(psDETable)) {
                  try {
                     psDETable.reset();
                     psDETable.setPSDEId(iPSDataEntity.getId());
                     psDETable.setTableType("MAIN");
                     if (psDETableService.select(psDETable, true)) {
                        psDETable.setPSDEName(iPSDataEntity.getName());
                        psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setTableType("MAIN");
                        psDETable.setPSSysDBTableId(strPSSysDBTableId);
                        psDETableService.update(psDETable, true);
                        strPSDEDBTableId = psDETable.getPSDETableId();
                     } else {
                        psDETable.setPSDEName(iPSDataEntity.getName());
                        psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                        psDETable.setTableType("MAIN");
                        psDETable.setPSSysDBTableId(strPSSysDBTableId);
                        psDETableService.create(psDETable, true);
                        strPSDEDBTableId = psDETable.getPSDETableId();
                     }
                  } catch (Exception ex) {
                     throw new Exception(
                        StringHelper.format("建立实体数据表[%1$s-%2$s]发生异常，%3$s", iPSDataEntity.getName(), iPSDataEntity.getTableName(), ex.getMessage()), ex
                     );
                  }
               } else {
                  strPSDEDBTableId = psDETable.getPSDETableId();
               }
            } else {
               strPSDEDBTableId = iPSDEDBTable.getId();
               if (StringHelper.isNullOrEmpty(iPSDEDBTable.getPSSysDBTableId())) {
                  SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
                  PSDETableService psDETableService = (PSDETableService)ServiceGlobal.getService(PSDETableService.class, sessionFactory);

                  try {
                     PSDETable psDETable = new PSDETable();
                     psDETable.setPSDETableId(strPSDEDBTableId);
                     psDETable.setPSSysDBTableId(strPSSysDBTableId);
                     psDETable.setPSSysDBTableName(iPSDataEntity.getTableName().toUpperCase());
                     psDETable.setPSDETableName(iPSDataEntity.getTableName().toUpperCase());
                     psDETable.setTableType("MAIN");
                     psDETableService.update(psDETable, true);
                  } catch (Exception ex) {
                     throw new Exception(
                        StringHelper.format("更新实体数据表[%1$s-%2$s]发生异常，%3$s", iPSDataEntity.getName(), iPSDataEntity.getTableName(), ex.getMessage()), ex
                     );
                  }
               }
            }

            if (iPSDataEntity.getSaaSMode() != IPSDataEntity.SAASMODE_NOTSUPPORTED
               && !StringHelper.isNullOrEmpty(iPSDataEntity.getSaaSDCIdColumnName())
               && iPSDataEntity.getPSDEField(iPSDataEntity.getSaaSDCIdColumnName(), true) == null) {
               String strPSSysDBColumnId = null;
               if (iPSSysDBTable != null) {
                  IPSSysDBColumn iPSSysDBColumn = iPSSysDBTable.getPSSysDBColumn(iPSDataEntity.getSaaSDCIdColumnName(), true);
                  if (iPSSysDBColumn != null) {
                     strPSSysDBColumnId = iPSSysDBColumn.getId();
                  }
               }

               if (StringHelper.isNullOrEmpty(strPSSysDBColumnId)) {
                  SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
                  PSSysDBColumnService psSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(PSSysDBColumnService.class, sessionFactory);
                  PSSysDBColumn psSysDBColumn = new PSSysDBColumn();
                  psSysDBColumn.setPSSysDBTableId(strPSSysDBTableId);
                  psSysDBColumn.setPSSysDBColumnName(iPSDataEntity.getSaaSDCIdColumnName());
                  if (!psSysDBColumnService.existsData(psSysDBColumn)) {
                     try {
                        psSysDBColumn.setCodeName(iPSDataEntity.getSaaSDCIdColumnName());
                        psSysDBColumn.setLogicName("租户标识");
                        psSysDBColumn.setStdDataType(25);
                        psSysDBColumn.setLength(100);
                        psSysDBColumnService.create(psSysDBColumn, true);
                        strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                     } catch (Exception ex) {
                        throw new Exception(
                           StringHelper.format(
                              "建立系统数据表列[%1$s-%2$s]发生异常，%3$s", iPSDataEntity.getTableName(), iPSDataEntity.getSaaSDCIdColumnName(), ex.getMessage()
                           ),
                           ex
                        );
                     }
                  }
               }
            }

            IPSSystemUtil iPSSystemUtil = (IPSSystemUtil)iPSDataEntity.getPSSystem();
            StdDataTypeCodeListModel stdDataTypeCodeListModel = (StdDataTypeCodeListModel)CodeListGlobal.getCodeList(StdDataTypeCodeListModel.class);
            Iterator<IPSDEField> psDEFields = iPSDataEntity.getAllPSDEFields();
            if (psDEFields != null) {
               while (psDEFields.hasNext()) {
                  IPSDEField iPSDEField = psDEFields.next();
                  if (iPSDEField.isPhisicalDEField()) {
                     IPSSysDBColumn iPSSysDBColumn = iPSDEField.getPSSysDBColumn();
                     if (iPSSysDBColumn != null && StringHelper.compare(strPSSysDBTableId, iPSSysDBColumn.getPSSysDBTable().getId(), false) != 0) {
                        iPSSysDBColumn = null;
                     }

                     if (iPSSysDBColumn != null) {
                        if (!testCompatibleDataType(iPSDEField.getStdDataType(), iPSSysDBColumn.getStdDataType())) {
                           iPSSystemUtil.getPSSysConsole()
                              .warn(
                                 String.format("实体[%1$s]属性[%2$s]", iPSDataEntity.getName(), iPSDEField.getName()),
                                 String.format(
                                    "标准类型[%1$s]与数据表[%2$s]列[%3$s]标准类型[%4$s]可能不兼容",
                                    stdDataTypeCodeListModel.getCodeListText(Integer.toString(iPSDEField.getStdDataType()), false),
                                    iPSSysDBColumn.getPSSysDBTable().getName(),
                                    iPSSysDBColumn.getName(),
                                    stdDataTypeCodeListModel.getCodeListText(Integer.toString(iPSSysDBColumn.getStdDataType()), false)
                                 )
                              );
                        } else if (!DataTypeHelper.isLongStringType(iPSDEField.getStdDataType())) {
                           if (DataTypeHelper.isStringType(iPSDEField.getStdDataType())) {
                              if (iPSDEField.getLength() > iPSSysDBColumn.getLength()) {
                                 iPSSystemUtil.getPSSysConsole()
                                    .warn(
                                       String.format("实体[%1$s]属性[%2$s]", iPSDataEntity.getName(), iPSDEField.getName()),
                                       String.format(
                                          "数据长度[%1$s]大于数据表[%2$s]列[%3$s]数据长度[%4$s]",
                                          iPSDEField.getLength(),
                                          iPSSysDBColumn.getPSSysDBTable().getName(),
                                          iPSSysDBColumn.getName(),
                                          iPSSysDBColumn.getLength()
                                       )
                                    );
                              }
                           } else if (DataTypeHelper.isIntType(iPSDEField.getStdDataType())) {
                              if (iPSDEField.getLength() > 0 && iPSSysDBColumn.getLength() > 0 && iPSDEField.getLength() > iPSSysDBColumn.getLength()) {
                                 iPSSystemUtil.getPSSysConsole()
                                    .warn(
                                       String.format("实体[%1$s]属性[%2$s]", iPSDataEntity.getName(), iPSDEField.getName()),
                                       String.format(
                                          "数据位数[%1$s]大于数据表[%2$s]列[%3$s]数据位数[%4$s]",
                                          iPSDEField.getLength(),
                                          iPSSysDBColumn.getPSSysDBTable().getName(),
                                          iPSSysDBColumn.getName(),
                                          iPSSysDBColumn.getLength()
                                       )
                                    );
                              }
                           } else if (DataTypeHelper.isBigDecimalType(iPSDEField.getStdDataType()) || isNumberType(iPSDEField.getStdDataType())) {
                              if (iPSDEField.getLength() > 0 && iPSSysDBColumn.getLength() > 0 && iPSDEField.getLength() > iPSSysDBColumn.getLength()) {
                                 iPSSystemUtil.getPSSysConsole()
                                    .warn(
                                       String.format("实体[%1$s]属性[%2$s]", iPSDataEntity.getName(), iPSDEField.getName()),
                                       String.format(
                                          "数据位数[%1$s]大于数据表[%2$s]列[%3$s]数据位数[%4$s]",
                                          iPSDEField.getLength(),
                                          iPSSysDBColumn.getPSSysDBTable().getName(),
                                          iPSSysDBColumn.getName(),
                                          iPSSysDBColumn.getLength()
                                       )
                                    );
                              }

                              if (iPSDEField.getPrecision() > 0 && iPSDEField.getPrecision() > iPSSysDBColumn.getPrecision()) {
                                 iPSSystemUtil.getPSSysConsole()
                                    .warn(
                                       String.format("实体[%1$s]属性[%2$s]", iPSDataEntity.getName(), iPSDEField.getName()),
                                       String.format(
                                          "小数位数[%1$s]大于数据表[%2$s]列[%3$s]小数位数[%4$s]",
                                          iPSDEField.getPrecision(),
                                          iPSSysDBColumn.getPSSysDBTable().getName(),
                                          iPSSysDBColumn.getName(),
                                          iPSSysDBColumn.getPrecision()
                                       )
                                    );
                              }
                           }
                        }
                     } else if (StringHelper.compare(iPSDataEntity.getTableName(), iPSDEField.getTableName(), true) == 0) {
                        String strPSSysDBColumnId = null;
                        if (iPSSysDBTable != null) {
                           iPSSysDBColumn = iPSSysDBTable.getPSSysDBColumn(iPSDEField.getName(), true);
                           if (iPSSysDBColumn != null) {
                              strPSSysDBColumnId = iPSSysDBColumn.getId();
                           }
                        }

                        if (StringHelper.isNullOrEmpty(strPSSysDBColumnId)) {
                           SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
                           PSSysDBColumnService psSysDBColumnService = (PSSysDBColumnService)ServiceGlobal.getService(
                              PSSysDBColumnService.class, sessionFactory
                           );
                           PSSysDBColumn psSysDBColumn = new PSSysDBColumn();
                           psSysDBColumn.setPSSysDBTableId(strPSSysDBTableId);
                           psSysDBColumn.setPSSysDBColumnName(iPSDEField.getName());
                           if (!psSysDBColumnService.existsData(psSysDBColumn)) {
                              try {
                                 psSysDBColumn.setCodeName(iPSDEField.getName());
                                 psSysDBColumn.setLogicName(iPSDEField.getLogicName());
                                 if (iPSDEField.isKeyDEField()) {
                                    psSysDBColumn.setPKey(1);
                                    psSysDBColumn.setAllowEmpty(0);
                                 }

                                 psSysDBColumn.setStdDataType(iPSDEField.getStdDataType());
                                 if (iPSDEField.getLength() > 0) {
                                    psSysDBColumn.setLength(iPSDEField.getLength());
                                 }

                                 if (iPSDEField.getPrecision() >= 0) {
                                    psSysDBColumn.setPrecision2(iPSDEField.getPrecision());
                                 }

                                 psSysDBColumnService.create(psSysDBColumn, true);
                                 strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                                 if (!StringHelper.isNullOrEmpty(iPSDEField.getPredefinedType())
                                    && (
                                       StringHelper.compare(iPSDEField.getPredefinedType(), "CREATEDATE", true) == 0
                                          || StringHelper.compare(iPSDEField.getPredefinedType(), "CREATEMAN", true) == 0
                                          || StringHelper.compare(iPSDEField.getPredefinedType(), "LOGICVALID", true) == 0
                                          || StringHelper.compare(iPSDEField.getPredefinedType(), "UPDATEMAN", true) == 0
                                          || StringHelper.compare(iPSDEField.getPredefinedType(), "UPDATEDATE", true) == 0
                                    )) {
                                    psSysDBColumn.setAllowEmpty(0);
                                 }
                              } catch (Exception ex) {
                                 throw new Exception(
                                    StringHelper.format("建立系统数据表列[%1$s-%2$s]发生异常，%3$s", iPSDataEntity.getTableName(), iPSDEField.getName(), ex.getMessage()),
                                    ex
                                 );
                              }
                           } else {
                              strPSSysDBColumnId = psSysDBColumn.getPSSysDBColumnId();
                           }
                        }

                        SessionFactory sessionFactory = PSSysModelInstGlobal.getSessionFactory(this.getPSSysModelInstId());
                        PSDEFieldService psDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, sessionFactory);
                        PSDEField psDEField = new PSDEField();
                        psDEField.setPSDEFieldId(iPSDEField.getId());
                        psDEField.setPSDETableId(strPSDEDBTableId);
                        psDEField.setPSSysDBColumnId(strPSSysDBColumnId);
                        psDEFieldService.sysUpdate(psDEField, false);
                     }
                  }
               }
            }
         }
      }
   }

   public static boolean testCompatibleDataType(int nSrcDataType, int nDstDataType) {
      return nSrcDataType == nDstDataType
         || (!DataTypeHelper.isStringType(nSrcDataType) || DataTypeHelper.isStringType(nDstDataType))
            && (!DataTypeHelper.isDateTimeType(nSrcDataType) || DataTypeHelper.isDateTimeType(nDstDataType))
            && (!DataTypeHelper.isBinaryType(nSrcDataType) || DataTypeHelper.isBinaryType(nDstDataType))
            && (nSrcDataType != 29 && nSrcDataType != 6 || nDstDataType == 29 || nDstDataType == 6)
            && (!isNumberType(nSrcDataType) || isNumberType(nDstDataType))
            && (!DataTypeHelper.isLongStringType(nSrcDataType) || DataTypeHelper.isLongStringType(nDstDataType));
   }

   protected static boolean isNumberType(int nStdDataType) {
      return DataTypeHelper.isBigDecimalType(nStdDataType)
         || DataTypeHelper.isBigIntType(nStdDataType)
         || DataTypeHelper.isDoubleType(nStdDataType)
         || DataTypeHelper.isIntType(nStdDataType);
   }
}
