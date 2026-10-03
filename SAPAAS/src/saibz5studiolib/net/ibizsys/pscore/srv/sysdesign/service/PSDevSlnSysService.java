package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUIStyle;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceProxy;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDInstCfg;
import net.ibizsys.pscore.srv.bdscheme.service.PSSysBDInstCfgService;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFStyle;
import net.ibizsys.pscore.srv.config.entity.PSSFStyleVer;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleService;
import net.ibizsys.pscore.srv.config.service.PSSFStyleVerService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevSlnSysKey;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDepFuncItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnPipelineStep;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrv;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemAS;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysRefLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.ibizsys.pscore.srv.util.IPSDCASOwnerListener;
import net.ibizsys.pscore.srv.util.IPSDCDBInstOwnerListener;
import net.ibizsys.pscore.srv.util.IPSDCSVNOwnerListener;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabHelper;
import net.ibizsys.pscore.srv.util.gitlab.model.Project;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDevSlnSysService extends PSDevSlnSysServiceBase implements IPSDCDBInstOwnerListener, IPSDCASOwnerListener, IPSDCSVNOwnerListener {
   private static final Log log = LogFactory.getLog(PSDevSlnSysService.class);
   private static Random random = new Random();
   public static final String DEFAULTSYSTEMID = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
   public static final String SRCPSSYSMODELINSTID = "srcpssysmodelinstid";
   public static final String DSTPSSYSMODELINSTID = "dstpssysmodelinstid";
   public static final String ACTIONPARAM_IGNORECALCRESSTATE = "IGNORECALCRESSTATE";
   public static final String PARAM_IGNOREPSDEVCENTERTS = "IGNOREPSDEVCENTERTS";
   private static final HashMap<Integer, Integer> psResStateLevelMap = new HashMap<>();

   public void getDraft(PSDevSlnSys var1) throws Exception {
      super.getDraft(var1);
      if (var1.getMainPSDevSlnSys() != null) {
         PSDevSlnSys var2 = var1.getMainPSDevSlnSys();
         var2.copyTo(var1, true);
         var1.resetPSDevSlnSysId();
         var1.resetPSDevSlnSysName();
         var1.resetPSSysModelInstId();
         var1.resetPSSysModelInstName();
         var1.resetSysVer();
         var1.resetPSDevCenterASId();
         var1.resetPSDevCenterASId2();
         var1.resetPSDevCenterAS3Id();
         var1.resetPSDevCenterAS4Id();
         var1.resetPSDevCenterASName();
         var1.resetPSDevCenterASName2();
         var1.resetPSDevCenterAS3Name();
         var1.resetPSDevCenterAS4Name();
         var1.resetVCType();
         var1.setMainPSDevSlnSysId(var2.getPSDevSlnSysId());
         var1.setMainPSDevSlnSysName(var2.getPSDevSlnSysName());
      }
   }

   protected void onBeforeCreate(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         boolean var2 = false;
         PSDevCenter var3 = null;
         if (!DataObject.getBoolValue(var1.getShareFlag(), false)) {
            if (var1.getPSDevSln() != null && var1.getPSDevSln().getPSDevCenter() != null) {
               var3 = var1.getPSDevSln().getPSDevCenter();
               var2 = DataObject.getBoolValue(var3.getEnableWorkspace(), false);
            }

            PSDevCenterHelper.testCreate(var3, "DEVSYSCNT", false);
         }

         if (isCloudMode()) {
            var2 = true;
            var1.setEnableMySQL5(1);
            var1.setTemplEngine("V2");
            var1.setEnableDynaSys(1);
            var1.setSaaSMode(4);
            if (StringHelper.isNullOrEmpty(var1.getPSSFId())) {
               var1.setPSSFId("J2EE6");
               var1.setPSSFName("Java体系架构");
            }
         } else if (var2
            && !isEnableGitBranch()
            && !StringHelper.isNullOrEmpty(var1.getMainPSDevSlnSysId())
            && StringHelper.isNullOrEmpty(var1.getSysTag())
            && StringHelper.isNullOrEmpty(var1.getSysTag2())) {
            var2 = false;
         }

         if (var2) {
            var1.setDevSysState(35);
         } else if (var1.getDevSysState() == null || var1.getDevSysState() == 10) {
            var1.setDevSysState(30);
         }

         if (StringHelper.isNullOrEmpty(var1.getStudioVer())) {
            if (var3 == null && var1.getPSDevSln() != null && var1.getPSDevSln().getPSDevCenter() != null) {
               var3 = var1.getPSDevSln().getPSDevCenter();
            }

            if (var3 != null) {
               var1.setStudioVer(var3.getStudioVer());
               if (StringHelper.isNullOrEmpty(var1.getStudioTag())) {
                  var1.setStudioTag(var3.getStudioTag());
               }

               if (StringHelper.isNullOrEmpty(var1.getStudioTag2())) {
                  var1.setStudioTag2(var3.getStudioTag2());
               }
            }
         }

         if (!StringHelper.isNullOrEmpty(var1.getPSDCSysLicId())) {
            PSDCSysLic var4 = new PSDCSysLic();
            var4.setPSDCSysLicId(var1.getPSDCSysLicId());
            PSDCSysLicService var5 = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, this.getSessionFactory());
            var5.get(var4);
            var5.testLic(var4, "MAXSYSCNT", var4.getCurSysCnt() + 1);
         }

         this.fillPSDevSlnSysInfo(var1, false);
         if (!DataObject.getBoolValue(var1.getShareFlag(), false)) {
            if (var2) {
               PSSysModelInstService var7 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
               PSSysModelInst var8 = new PSSysModelInst();
               var8.setPSDevCenterId(var3.getPSDevCenterId());
               var8.setPSDevCenterName(var3.getPSDevCenterName());
               var8.setPSSvrDomainId(var3.getPSSvrDomainId());
               String var6 = StringHelper.format("[开发系统]%1$s\\%2$s", var1.getPSDevSlnName(), var1.getPSDevSlnSysName());
               var8.setRefInfo(var6);
               var7.createDraft(var8);
               var1.setPSSysModelInstId(var8.getPSSysModelInstId());
               var1.setPSSysModelInstName(var8.getPSSysModelInstName());
            } else if (var1.getDevSysState() != 35) {
               this.fillPSSysModelInst(var1);
            }
         }

         if (var1.getPSDevSln() != null) {
            var1.setPSSystemId(var1.getPSDevSln().getPSSystemId());
         }

         if (StringHelper.isNullOrEmpty(var1.getPSSystemId())) {
            var1.setPSSystemId("2C40DFCD-0DF5-47BF-91A5-C45F810B0001");
         }

         if (StringHelper.isNullOrEmpty(var1.getPSSystemId())) {
            var1.setPSSystemId(KeyValueHelper.genGuidEx());
         }
      }

      super.onBeforeCreate(var1);
   }

   protected void onBeforeUpdate(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         this.fillPSDevSlnSysInfo(var1, true);
         if (var1.getDevSysState() == null || var1.getDevSysState() == 10) {
            var1.setDevSysState(30);
         }
      }

      super.onBeforeUpdate(var1);
   }

   protected void onAfterCreate(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         if (DataObject.getIntegerValue(var1.getDevSysState(), 30) != 20) {
            String var2 = getCurrentPSSystemId();
            String var3 = getCurrentPSDevSlnSysId();
            setCurrentPSSystemId(var1.getPSSystemId());
            setCurrentPSDevSlnSysId(var1.getPSDevSlnSysId());

            try {
               if (DataObject.getIntegerValue(var1.getDevSysState(), 30) == 30) {
                  this.syncPSSysModelInst(var1, true, false);
               } else {
                  this.syncPSSysModelInst2(var1, true, false);
               }

               setCurrentPSSystemId(var2);
               setCurrentPSDevSlnSysId(var3);
            } catch (Exception var5) {
               setCurrentPSSystemId(var2);
               setCurrentPSDevSlnSysId(var3);
               throw var5;
            }
         } else {
            final PSDevSlnSys var6 = var1;
            SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction() {
               @Override
               public void commit() {
                  try {
                     PSDevSlnSysService.this.executeAction("X_ADDBINDSYSMODELTASK", var6);
                  } catch (Exception var2) {
                     PSDevSlnSysService.log.error(var2);
                  }
               }

               @Override
               public void rollback() {
               }
            });
         }

         PSDevCenterHelper.updatetPSDCResRep(var1.getPSDevSln().getPSDevCenter(), "DEVSYSCNT");
      }

      super.onAfterCreate(var1);
   }

   protected void onAfterUpdate(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         if (DataObject.getIntegerValue(var1.getDevSysState(), 30) == 30) {
            this.syncPSSysModelInst(var1, false, false);
         } else {
            this.syncPSSysModelInst2(var1, false, false);
         }
      }

      super.onAfterUpdate(var1);
   }

   protected void fillPSSysModelInst(PSDevSlnSys var1) throws Exception {
      if (DataObject.getIntegerValue(var1.getDevSysState(), 30) != 20) {
         PSSysModelInstService var2 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
         SelectCond var3 = new SelectCond();
         var3.set("INSTSTATE", "20");
         PSDevSln var4 = var1.getPSDevSln();
         PSDevCenter var5 = var4 == null ? null : var4.getPSDevCenter();
         if (var5 != null) {
            var3.set("PSDEVCENTERID", var5.getPSDevCenterId());
         }

         if (var5 != null && !StringHelper.isNullOrEmpty(var5.getPSSvrDomainId())) {
            var3.set("PSSVRDOMAINID", var5.getPSSvrDomainId());
         }

         var3.set("SYSTYPE", "DEVSYS");
         String var6 = DataObject.getStringValue(var1.get("srcpssysmodelinstid"));
         String var7 = DataObject.getStringValue(var1.get("dstpssysmodelinstid"));
         if (!StringHelper.isNullOrEmpty(var6)) {
            var3.set("INSTSTATE", "10");
         } else if (var1.getMainPSDevSlnSys() != null) {
            var3.set("PSDBSERVERID", var1.getMainPSDevSlnSys().getPSSysModelInst().getPSDBServerId());
            var3.set("INSTSTATE", "10");
         }

         if (!StringHelper.isNullOrEmpty(var7)) {
            var3.set("PSSYSMODELINSTID", var7);
         }

         var3.setMaxRowCount(100);
         ArrayList var8 = var2.select(var3);
         if (var8.size() == 0) {
            if (var1.getMainPSDevSlnSys() != null) {
               var3.remove("PSDBSERVERID");
               var8 = var2.select(var3);
            }

            if (var8.size() == 0) {
               throw new Exception(StringHelper.format("当前应用中心无可用系统模型实例，请联系中心管理员确认"));
            }
         }

         int var9 = random.nextInt(100) % var8.size();
         PSSysModelInst var10 = (PSSysModelInst)var8.get(var9);
         var10.setPSDevCenterId(var1.getPSDevSln().getPSDevCenterId());
         var10.setPSDevCenterName(var1.getPSDevSln().getPSDevCenterName());
         String var11 = StringHelper.format("[开发方案]%1$s\\%2$s", var1.getPSDevSlnName(), var1.getPSDevSlnSysName());
         var10.setRefInfo(var11);
         int var12 = -1;
         if (!StringHelper.isNullOrEmpty(var6)) {
            try {
               PSSysModelInst var13 = new PSSysModelInst();
               var13.setPSSysModelInstId(var6);
               var2.get(var13);
               var10.set("SRCPSSYSMODELINSTID", var6);
               var12 = var13.getModelVer();
               var10.set("PSDEVCENTERTSID", var1.getPSDevCenterTSId());
               var2.executeAction("X_CLONE", var10);
            } catch (Exception var17) {
               var10.setInstState("41");
               var2.update(var10, false);
               SessionFactoryManager.commit();
               log.error(StringHelper.format("克隆系统模型库发生错误，%1$s", var17.getMessage()), var17);
               throw new Exception(StringHelper.format("克隆系统模型库发生错误，%1$s", var17.getMessage()));
            }
         } else if (var1.getMainPSDevSlnSys() != null) {
            try {
               var10.set("SRCPSSYSMODELINSTID", var1.getMainPSDevSlnSys().getPSSysModelInstId());
               var12 = var1.getMainPSDevSlnSys().getPSSysModelInst().getModelVer();
               if (var1.getPPSDevSlnSys() != null) {
                  var10.set("SRCPSSYSMODELINSTID", var1.getPPSDevSlnSys().getPSSysModelInstId());
                  var12 = var1.getPPSDevSlnSys().getPSSysModelInst().getModelVer();
               }

               var10.set("PSDEVCENTERTSID", var1.getMainPSDevSlnSys().getPSDevCenterTSId());
               var2.executeAction("X_CLONE", var10);
            } catch (Exception var16) {
               var10.setInstState("41");
               var2.update(var10, false);
               SessionFactoryManager.commit();
               log.error(StringHelper.format("克隆系统模型库发生错误，%1$s", var16.getMessage()), var16);
               throw new Exception(StringHelper.format("克隆系统模型库发生错误，%1$s", var16.getMessage()));
            }
         }

         var1.setPSSysModelInstId(var10.getPSSysModelInstId());
         var1.setPSSysModelInstName(var10.getPSSysModelInstName());
         if (var12 != -1) {
            var10.setModelVer(var12);
         }

         var10.setInstState("30");
         var2.update(var10);
      } else if (StringHelper.isNullOrEmpty(var1.getPSSysModelInstId())) {
         PSSysModelInstService var18 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
         SelectCond var20 = new SelectCond();
         var20.set("INSTSTATE", "20");
         PSDevSln var22 = var1.getPSDevSln();
         PSDevCenter var24 = var22 == null ? null : var22.getPSDevCenter();
         if (var24 != null) {
            var20.set("PSDEVCENTERID", var24.getPSDevCenterId());
         }

         if (var24 != null && !StringHelper.isNullOrEmpty(var24.getPSSvrDomainId())) {
            var20.set("PSSVRDOMAINID", var24.getPSSvrDomainId());
         }

         var20.set("SYSTYPE", "DEVSYS");
         String var26 = DataObject.getStringValue(var1.get("srcpssysmodelinstid"));
         String var28 = DataObject.getStringValue(var1.get("dstpssysmodelinstid"));
         if (!StringHelper.isNullOrEmpty(var26)) {
            var20.set("INSTSTATE", "10");
         } else if (var1.getMainPSDevSlnSys() != null) {
            var20.set("PSDBSERVERID", var1.getMainPSDevSlnSys().getPSSysModelInst().getPSDBServerId());
            var20.set("INSTSTATE", "10");
         }

         if (!StringHelper.isNullOrEmpty(var28)) {
            var20.set("PSSYSMODELINSTID", var28);
         }

         var20.setMaxRowCount(100);
         ArrayList var29 = var18.select(var20);
         if (var29.size() == 0) {
            if (var1.getMainPSDevSlnSys() != null) {
               var20.remove("PSDBSERVERID");
               var29 = var18.select(var20);
            }

            if (var29.size() == 0) {
               throw new Exception(StringHelper.format("当前应用中心无可用系统模型实例，请联系中心管理员确认"));
            }
         }

         int var30 = random.nextInt(100) % var29.size();
         PSSysModelInst var31 = (PSSysModelInst)var29.get(var30);
         var31.setPSDevCenterId(var1.getPSDevSln().getPSDevCenterId());
         var31.setPSDevCenterName(var1.getPSDevSln().getPSDevCenterName());
         String var32 = StringHelper.format("[开发系统]%1$s\\%2$s", var1.getPSDevSlnName(), var1.getPSDevSlnSysName());
         var31.setRefInfo(var32);
         byte var33 = -1;
         var1.setPSSysModelInstId(var31.getPSSysModelInstId());
         var1.setPSSysModelInstName(var31.getPSSysModelInstName());
         if (var33 != -1) {
            var31.setModelVer(Integer.valueOf(var33));
         }

         var31.setInstState("30");
         var18.update(var31);
      } else {
         int var19 = -1;
         String var21 = "";
         PSSysModelInstService var23 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
         PSSysModelInst var25 = new PSSysModelInst();
         var25.setPSSysModelInstId(var1.getPSSysModelInstId());
         if (!StringHelper.isNullOrEmpty(var21)) {
            try {
               PSSysModelInst var27 = new PSSysModelInst();
               var27.setPSSysModelInstId(var21);
               var23.get(var27);
               var25.set("SRCPSSYSMODELINSTID", var21);
               var19 = var27.getModelVer();
               var25.set("PSDEVCENTERTSID", var1.getPSDevCenterTSId());
               var23.executeAction("X_CLONE", var25);
            } catch (Exception var15) {
               var25.setInstState("41");
               var23.update(var25, false);
               SessionFactoryManager.commit();
               log.error(StringHelper.format("克隆系统模型库发生错误，%1$s", var15.getMessage()), var15);
               throw new Exception(StringHelper.format("克隆系统模型库发生错误，%1$s", var15.getMessage()));
            }
         } else if (var1.getMainPSDevSlnSys() != null) {
            try {
               var25.set("SRCPSSYSMODELINSTID", var1.getMainPSDevSlnSys().getPSSysModelInstId());
               var19 = var1.getMainPSDevSlnSys().getPSSysModelInst().getModelVer();
               if (var1.getPPSDevSlnSys() != null) {
                  var25.set("SRCPSSYSMODELINSTID", var1.getPPSDevSlnSys().getPSSysModelInstId());
                  var19 = var1.getPPSDevSlnSys().getPSSysModelInst().getModelVer();
               }

               var25.set("PSDEVCENTERTSID", var1.getMainPSDevSlnSys().getPSDevCenterTSId());
               var23.executeAction("X_CLONE", var25);
            } catch (Exception var14) {
               var25.setInstState("41");
               var23.update(var25, false);
               SessionFactoryManager.commit();
               log.error(StringHelper.format("克隆系统模型库发生错误，%1$s", var14.getMessage()), var14);
               throw new Exception(StringHelper.format("克隆系统模型库发生错误，%1$s", var14.getMessage()));
            }
         }

         if (var19 != -1) {
            var25.setModelVer(var19);
         }

         var25.setInstState("30");
         var23.update(var25);
      }
   }

   protected void fillPSDevSlnSysInfo(PSDevSlnSys var1, boolean var2) throws Exception {
      PSDevSlnSysRes var3 = var1.getPSDevSlnSysRes();
      PSDevSlnSys var4 = null;
      if (var2) {
         var4 = this.getLast(var1);
         if (!var1.isDevSysStateDirty()) {
            var1.setDevSysState(var4.getDevSysState());
         }

         if (!var1.isEnableDB2Dirty()) {
            var1.setEnableDB2(var4.getEnableDB2());
         }

         if (!var1.isEnableHBaseDirty()) {
            var1.setEnableHBase(var4.getEnableHBase());
         }

         if (!var1.isEnableMySQL5Dirty()) {
            var1.setEnableMySQL5(var4.getEnableMySQL5());
         }

         if (!var1.isEnableOracleDirty()) {
            var1.setEnableOracle(var4.getEnableOracle());
         }

         if (!var1.isEnablePGSQLDirty()) {
            var1.setEnablePGSQL(var4.getEnablePGSQL());
         }

         if (!var1.isEnablePPASDirty()) {
            var1.setEnablePPAS(var4.getEnablePPAS());
         }

         if (!var1.isEnableSqlServerDirty()) {
            var1.setEnableSqlServer(var4.getEnableSqlServer());
         }

         if (!var1.isEnableSQLiteDirty()) {
            var1.setEnableSQLite(var4.getEnableSQLite());
         }

         if (!var1.isEnableDMDirty()) {
            var1.setEnableDM(var4.getEnableDM());
         }

         if (!var1.isEnableHANADirty()) {
            var1.setEnableHANA(var4.getEnableHANA());
         }
      }

      if (var1.isMainPSDevSlnSysNameDirty()
         && var1.isMainPSDevSlnSysIdDirty()
         && var1.isSysVerDirty()
         && !StringHelper.isNullOrEmpty(var1.getMainPSDevSlnSysName())) {
         if (var1.getMainPSDevSlnSys() != null) {
            var1.setPSDevSlnId(var1.getMainPSDevSlnSys().getPSDevSlnId());
            var1.setPSDevSlnName(var1.getMainPSDevSlnSys().getPSDevSlnName());
         }

         var1.setPSDevSlnSysName(StringHelper.format("%1$s_%2$s", var1.getMainPSDevSlnSysName(), var1.getSysVer().replace(".", "_")));
      }

      String var5 = "";
      if (DataObject.getBoolValue(var1.getEnableMySQL5(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "MYSQL5";
         if (var1.isMySQLPSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getMySQLPSDCDBInstId(), var1.getMySQLPSDCDBInstId(), false) != 0)
            && var1.getMySQLPSDCDBInst() != null
            && StringHelper.compare(var1.getMySQLPSDCDBInst().getDBType(), "MYSQL5", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "MySQL"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnableSqlServer(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "SQLSERVER";
         if (var1.isMSSQLPSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getMSSQLPSDCDBInstId(), var1.getMSSQLPSDCDBInstId(), false) != 0)
            && var1.getMSSQLPSDCDBInst() != null
            && StringHelper.compare(var1.getMSSQLPSDCDBInst().getDBType(), "SQLSERVER", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "SqlServer"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnableOracle(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "ORACLE";
         if (var1.isOraPSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getOraPSDCDBInstId(), var1.getOraPSDCDBInstId(), false) != 0)
            && var1.getOraPSDCDBInst() != null
            && StringHelper.compare(var1.getOraPSDCDBInst().getDBType(), "ORACLE", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "Oracle"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnableDB2(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "DB2";
         if (var1.isDB2PSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getDB2PSDCDBInstId(), var1.getDB2PSDCDBInstId(), false) != 0)
            && var1.getDB2PSDCDBInst() != null
            && StringHelper.compare(var1.getDB2PSDCDBInst().getDBType(), "DB2", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "DB2"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnablePGSQL(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "POSTGRESQL";
         if (var1.isPGSQLPSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getPGSQLPSDCDBInstId(), var1.getPGSQLPSDCDBInstId(), false) != 0)
            && var1.getPGSQLPSDCDBInst() != null
            && StringHelper.compare(var1.getPGSQLPSDCDBInst().getDBType(), "POSTGRESQL", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "PostgreSQL"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnablePPAS(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "PPAS";
         if (var1.isPPASPSDCDBInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getPPASPSDCDBInstId(), var1.getPPASPSDCDBInstId(), false) != 0)
            && var1.getPPASPSDCDBInst() != null
            && StringHelper.compare(var1.getPPASPSDCDBInst().getDBType(), "PPAS", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "PPAS"));
         }
      }

      if (DataObject.getBoolValue(var1.getEnableSQLite(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "SQLITE";
      }

      if (DataObject.getBoolValue(var1.getEnableDM(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "DM";
      }

      if (DataObject.getBoolValue(var1.getEnableHANA(), false)) {
         if (!StringHelper.isNullOrEmpty(var5)) {
            var5 = var5 + ";";
         }

         var5 = var5 + "HANA";
      }

      var1.setDBTypes(var5);
      String var6 = "";
      if (DataObject.getBoolValue(var1.getEnableHBase(), false)) {
         if (!StringHelper.isNullOrEmpty(var6)) {
            var6 = var6 + ";";
         }

         var6 = var6 + "HBASE";
         if (var1.isHBasePSDCBDInstIdDirty()
            && (var4 == null || StringHelper.compare(var4.getHBasePSDCBDInstId(), var1.getHBasePSDCBDInstId(), false) != 0)
            && var1.getHBasePSDCDBInst() != null
            && StringHelper.compare(var1.getHBasePSDCDBInst().getBDType(), "HBASE", true) != 0) {
            throw new Exception(StringHelper.format("[%1$s]开发数据库实例类型不正确", "HBase"));
         }
      }

      if (var1.get("IGNOREPSDEVCENTERTS") == null && StringHelper.isNullOrEmpty(var1.getPSDevCenterTSId()) && (!var2 || var1.isPSDevCenterTSIdDirty())) {
         PSDevCenterTS var7 = null;
         if (var1.getPPSDevSlnSys() != null) {
            var7 = var1.getPPSDevSlnSys().getPSDevCenterTS();
         }

         if (var7 == null && var1.getMainPSDevSlnSys() != null) {
            var7 = var1.getMainPSDevSlnSys().getPSDevCenterTS();
         }

         if (var7 == null) {
            PSDevCenterTSService var8 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, this.getSessionFactory());
            ArrayList<PSDevCenterTS> var9 = var8.selectByPSDevCenter(var1.getPSDevSln().getPSDevCenter());
            if (var9.size() == 0) {
               throw new Exception(StringHelper.format("无法从应用中心选择任务服务器"));
            }

            int var10 = 0;
            if (var9.size() > 1) {
               ArrayList<PSDevCenterTS> var11 = new ArrayList<>();

               for (PSDevCenterTS var13 : var9) {
                  if (DataObject.getBoolValue(var13.getValidFlag(), true)) {
                     if (StringHelper.isNullOrEmpty(var13.getServerUsage())) {
                        var11.add(var13);
                     } else if (StringHelper.compare(var13.getServerUsage(), "SYSPUB", false) == 0) {
                        var11.add(var13);
                     }
                  }
               }

               if (var11.size() > 0) {
                  var9.clear();
                  var9.addAll(var11);
               }

               if (var9.size() > 1) {
                  var10 = random.nextInt(100) % var9.size();
               }
            }

            var7 = (PSDevCenterTS)var9.get(var10);
         }

         if (var7 == null) {
            throw new Exception(StringHelper.format("无法从应用中心选择任务服务器"));
         }

         var1.setPSDevCenterTSId(var7.getPSDevCenterTSId());
         var1.setPSDevCenterTSName(var7.getPSDevCenterTSName());
      }

      if (var3 != null) {
         var1.setPSDevCenterSVNId(var3.getPSDevCenterSVNId());
         var1.setPSDevCenterSVNName(var3.getPSDevCenterSVNName());
      }
   }

   @Override
   protected boolean isPrepareLastForUpdate() {
      return true;
   }

   protected void syncPSSysModelInst(PSDevSlnSys var1) throws Exception {
      this.syncPSSysModelInst(var1, false, false);
   }

   protected void syncPSSysModelInst(PSDevSlnSys var1, boolean var2, boolean var3) throws Exception {
      this.syncPSSysModelInst(var1, var2, var3, var2);
   }

   protected void syncPSSysModelInst(PSDevSlnSys var1, boolean var2, boolean var3, boolean var4) throws Exception {
      ActionSessionManager.getCurrentSession().setActionParam("IGNORECALCRESSTATE", "");
      PSDevSlnSys var5 = null;
      if (!var2) {
         var5 = this.getLast(var1);
      }

      boolean var6 = false;
      if (var1.isShareFlagDirty()) {
         var6 = DataObject.getBoolValue(var1.getShareFlag(), false);
      } else if (var5 != null) {
         var6 = DataObject.getBoolValue(var5.getShareFlag(), false);
      }

      this.syncPSDevSlnSysRefs(var1);
      if (var6) {
         this.syncSharePSSysModelInst(var1);
      } else {
         int var7 = 0;
         if (var1.isEnableDynaSysDirty()) {
            var7 = DataObject.getIntegerValue(var1.getEnableDynaSys(), 0);
         } else if (var5 != null) {
            var7 = DataObject.getIntegerValue(var5.getEnableDynaSys(), 0);
         }

         int var8 = 0;
         if (var1.isSaaSModeDirty()) {
            var8 = DataObject.getIntegerValue(var1.getSaaSMode(), 0);
         } else if (var5 != null) {
            var8 = DataObject.getIntegerValue(var5.getSaaSMode(), 0);
         }

         String var9 = null;
         if (var1.isSysVerDirty()) {
            var9 = var1.getSysVer();
         } else if (var5 != null) {
            var9 = var5.getSysVer();
         }

         String var10 = var1.getPSDevSlnSysName();
         String var11 = var1.getPSDevSlnName();
         if (StringHelper.isNullOrEmpty(var10) || StringHelper.isNullOrEmpty(var11)) {
            if (var5 != null) {
               var10 = var5.getPSDevSlnSysName();
               var11 = var5.getPSDevSlnName();
            } else {
               var10 = "未知系统名称";
            }
         }

         String var12 = var1.getPSSystemId();
         if (StringHelper.isNullOrEmpty(var12)) {
            if (var5 != null) {
               var12 = var5.getPSSystemId();
            } else {
               var12 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
            }
         }

         PSDevSlnSysRes var13 = null;
         if (var1.isPSDevSlnSysResIdDirty()) {
            var13 = var1.getPSDevSlnSysRes();
         } else if (var5 != null) {
            var13 = var5.getPSDevSlnSysRes();
         }

         String var14 = null;
         if (StringHelper.isNullOrEmpty(var11)) {
            var14 = var10;
         } else {
            var14 = StringHelper.format("%1$s\\%2$s", var11, var10);
         }

         ArrayList var15 = new ArrayList();
         PSSystem var16 = new PSSystem();
         SessionFactory var17 = PSSysModelInstGlobal.getSessionFactory(var1.getPSSysModelInst());
         PSSystemService var18 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var17);
         PSDevCenterService var19 = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, var17);
         PSSvrDomainService var20 = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, var17);
         PSDevSlnService var21 = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, var17);
         PSSystemDBCfgService var22 = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, var17);
         PSSystemASService var23 = (PSSystemASService)ServiceGlobal.getService(PSSystemASService.class, var17);
         PSSysAppService var24 = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, var17);
         PSSysSFPubService var25 = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, var17);
         PSPFStyleService var26 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, var17);
         PSSFStyleService var27 = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, var17);
         PSSysBDInstCfgService var28 = (PSSysBDInstCfgService)ServiceGlobal.getService(PSSysBDInstCfgService.class, var17);
         PSDynaSysService var29 = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, var17);
         if (var2) {
            PSSystem var30 = new PSSystem();
            var30.setPSSystemId(var1.getPSSystemId());
            if (var18.get(var30, true)) {
               var30.reset();
               var30.setPSSystemId(var1.getPSSystemId());
               var30.setEnableDynaSys(var1.getEnableDynaSys());
               var30.setPSDevSlnId(null);
               var30.setPSDevSlnSysId(null);
               var30.setPSDevCenterTSId(null);
               var30.setPSDevCenterTSName(null);
               var18.update(var30, false);

               for (PSSystemDBCfg var33 : var22.select(new SelectCond())) {
                  var33.setPSDevCenterDBInstId(null);
                  var33.setPSDevCenterDBInstName(null);
                  var33.setPSDBDevInstId(null);
                  var33.setPSDBDevInstName(null);
                  var22.update(var33, false);
               }

               for (PSSystemAS var34 : var23.select(new SelectCond())) {
                  var34.setPSAppServerId(null);
                  var34.setPSDevCenterASId(null);
                  var34.setPSDevCenterASName(null);
                  var23.update(var34, false);
               }

               for (PSSysBDInstCfg var35 : var28.select(new SelectCond())) {
                  var35.setPSDCBDInstId(null);
                  var35.setPSDCBDInstName(null);
                  var28.update(var35, false);
               }
            }
         }

         if (var2) {
            for (PSDevSln var74 : var21.select(new SelectCond())) {
               if (StringHelper.compare(var74.getPSDevSlnId(), var1.getPSDevSlnId(), false) != 0) {
                  try {
                     var21.remove(var74);
                  } catch (Exception var52) {
                     log.error(StringHelper.format("删除原有开发方案发生异常，%1$s", var52.getMessage()), var52);
                  }
               }
            }
         }

         if (var2) {
            for (PSDevCenter var75 : var19.select(new SelectCond())) {
               if (StringHelper.compare(var75.getPSDevCenterId(), var1.getPSDevSln().getPSDevCenterId(), false) != 0) {
                  try {
                     var19.remove(var75);
                  } catch (Exception var51) {
                     log.error(StringHelper.format("删除原有应用中心发生异常，%1$s", var51.getMessage()), var51);
                  }
               }
            }
         }

         if (var2) {
            PSDevSln var56 = var1.getPSDevSln();
            PSDevCenter var63 = var56.getPSDevCenter();
            PSDevCenter var76 = new PSDevCenter();
            var63.copyTo(var76, true);
            PSSvrDomain var86 = var63.getPSSvrDomain();
            if (var86 != null) {
               PSSvrDomain var96 = new PSSvrDomain();
               var86.copyTo(var96, true);
               var20.save(var96, false);
            }

            var76.setV6PSSvnInstRepoId(null);
            var76.setV6PSSvnInstRepoName(null);
            var76.setPSPMSServerId(null);
            var76.setPSPMSServerName(null);
            var19.save(var76, false);
            PSDevSln var97 = new PSDevSln();
            var56.copyTo(var97, true);
            var97.setAdminPSDevUserId(null);
            var97.setAdminPSDevUserName(null);
            var97.setPSDCDeployCenterId(null);
            var97.setPSDCDeployCenterName(null);
            var97.setPSDCWorkshopServerId(null);
            var97.setPSDCWorkshopServerName(null);
            var97.setPSSystemId(null);
            var97.setVCUser(null);
            var97.setVCPassword(null);
            var21.save(var97, false);
         }

         PSDevCenterTSService var57 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, var17);
         PSTaskServerService var64 = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, var17);
         if (var1.getPSDevCenterTS() != null) {
            PSTaskServer var77 = var1.getPSDevCenterTS().getPSTaskServer();
            PSTaskServer var87 = new PSTaskServer();
            var77.copyTo(var87, false);
            var87.setPSMobAppPackServerId(null);
            var87.setPSMobAppPackServerName(null);
            var87.setNo2PSMobAppPSId(null);
            var87.setNo2PSMobAppPSName(null);
            var87.setPSDeployCenterId(null);
            var87.setPSDeployCenterName(null);
            var87.setPSWorkshopServerId(null);
            var87.setPSWorkshopServerName(null);
            var87.setPSSvrDomainId(null);
            var87.setPSSvrDomainName(null);
            var64.save(var87);
            PSDevCenterTS var98 = new PSDevCenterTS();
            var1.getPSDevCenterTS().copyTo(var98, false);
            var57.save(var98);
         }

         PSSFService var58 = (PSSFService)ServiceGlobal.getService(PSSFService.class, var17);
         if (!StringHelper.isNullOrEmpty(var1.getPSSFId())) {
            PSSF var65 = new PSSF();
            var65.setPSSFId(var1.getPSSFId());
            if (var58.checkKey(var65) == 0) {
               var1.getPSSF().copyTo(var65, false);
               var58.update(var65, false);
            }
         }

         PSDevSln var59 = var1.getPSDevSln();
         if (var2) {
            var1.copyTo(var16, true);
            var16.setPSDevCenterId(var59.getPSDevCenterId());
            var16.setPSDevCenterName(var59.getPSDevCenterName());
            var16.setPSSystemName(var1.getPSDevSlnSysName());
            var18.save(var16);
            var18.mergeChild("", "", var16.getPSSystemId());
         } else {
            var16.setPSSystemId(var1.getPSSystemId());
            var16.setDBTypes(var1.getDBTypes());
            var16.setPSDevCenterId(var59.getPSDevCenterId());
            var16.setPSDevCenterName(var59.getPSDevCenterName());
            var16.setPSSystemName(var1.getPSDevSlnSysName());
            var18.save(var16);
         }

         HashMap var60 = new HashMap();
         PSDevCenterASService var66 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, this.getSessionFactory());
         SelectCond var78 = new SelectCond();
         var78.set("PSSYSTEMID", var12);

         for (PSSystemAS var105 : var23.select(var78)) {
            String var36 = var105.getPSDevCenterASId();
            if (!StringHelper.isNullOrEmpty(var36)) {
               PSDevCenterAS var37 = new PSDevCenterAS();
               var37.setPSDevCenterASId(var36);
               var66.get(var37);
               if ((StringHelper.isNullOrEmpty(var37.getRefObjType()) || StringHelper.compare(var37.getRefObjType(), "PSDEVSLNSYS", false) == 0)
                  && (StringHelper.isNullOrEmpty(var37.getRefObjId()) || StringHelper.compare(var37.getRefObjId(), var1.getPSDevSlnSysId(), false) == 0)) {
                  var37.setRefFlag(0);
                  var37.setRefObjType(null);
                  var37.setRefObjId(null);
                  var37.setRefObjName(null);
                  var66.update(var37, false);
               }
            }
         }

         PSDevCenterASService var100 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, var17);
         String var106 = var1.getPSDevCenterASId();
         String var111 = var1.getPSDevCenterASName();
         if (StringHelper.isNullOrEmpty(var106) && var13 != null) {
            if (var13.getResPos() == 1 && !StringHelper.isNullOrEmpty(var13.getPSDevCenterASId())) {
               var106 = var13.getPSDevCenterASId();
               var111 = var13.getPSDevCenterASName();
            } else if (var13.getResPos() == 2 && !StringHelper.isNullOrEmpty(var13.getUPSDevCenterASId())) {
               var106 = var13.getUPSDevCenterASId();
               var111 = var13.getUPSDevCenterASName();
            }
         }

         if (!StringHelper.isNullOrEmpty(var106)) {
            if (var60.containsKey(var106)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var14, var111));
            }

            var60.put(var106, var111);
            PSDevCenterAS var117 = new PSDevCenterAS();
            var117.setPSDevCenterASId(var106);
            var66.get(var117);
            if (DataObject.getBoolValue(var117.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var117.getRefObjType()) && StringHelper.compare(var117.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var117.getRefObjId()) && StringHelper.compare(var117.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var117.getPSDevCenterASName(), var117.getRefObjName()));
            }

            this.addToPSResList(var15, var117);
            var117.reset();
            var117.setPSDevCenterASId(var106);
            var117.setRefFlag(1);
            var117.setRefObjType("PSDEVSLNSYS");
            var117.setRefObjId(var1.getPSDevSlnSysId());
            var117.setRefObjName(var14);
            var66.update(var117);
            var100.save(var117);
         }

         String var118 = var1.getPSDevCenterASId2();
         String var38 = var1.getPSDevCenterASName2();
         if (StringHelper.isNullOrEmpty(var118) && var13 != null) {
            if (var13.getResPos() == 1 && !StringHelper.isNullOrEmpty(var13.getPSDevCenterASId2())) {
               var118 = var13.getPSDevCenterASId2();
               var38 = var13.getPSDevCenterASName2();
            } else if (var13.getResPos() == 2 && !StringHelper.isNullOrEmpty(var13.getUPSDevCenterASId2())) {
               var118 = var13.getUPSDevCenterASId2();
               var38 = var13.getUPSDevCenterASName2();
            }
         }

         if (!StringHelper.isNullOrEmpty(var118)) {
            if (var60.containsKey(var118)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var14, var38));
            }

            var60.put(var118, var38);
            PSDevCenterAS var39 = new PSDevCenterAS();
            var39.setPSDevCenterASId(var118);
            var66.get(var39);
            if (DataObject.getBoolValue(var39.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var39.getRefObjType()) && StringHelper.compare(var39.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var39.getRefObjId()) && StringHelper.compare(var39.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var39.getPSDevCenterASName(), var39.getRefObjName()));
            }

            this.addToPSResList(var15, var39);
            var39.reset();
            var39.setPSDevCenterASId(var118);
            var39.setRefFlag(1);
            var39.setRefObjType("PSDEVSLNSYS");
            var39.setRefObjId(var1.getPSDevSlnSysId());
            var39.setRefObjName(var14);
            var66.update(var39);
            var100.save(var39);
         }

         String var129 = var1.getPSDevCenterAS3Id();
         String var40 = var1.getPSDevCenterAS3Name();
         if (!StringHelper.isNullOrEmpty(var129)) {
            if (var60.containsKey(var129)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var14, var40));
            }

            var60.put(var129, var40);
            PSDevCenterAS var41 = new PSDevCenterAS();
            var41.setPSDevCenterASId(var129);
            var66.get(var41);
            if (DataObject.getBoolValue(var41.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var41.getRefObjType()) && StringHelper.compare(var41.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var41.getRefObjId()) && StringHelper.compare(var41.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var41.getPSDevCenterASName(), var41.getRefObjName()));
            }

            this.addToPSResList(var15, var41);
            var41.reset();
            var41.setPSDevCenterASId(var129);
            var41.setRefFlag(1);
            var41.setRefObjType("PSDEVSLNSYS");
            var41.setRefObjId(var1.getPSDevSlnSysId());
            var41.setRefObjName(var14);
            var66.update(var41);
            var100.save(var41);
         }

         String var141 = var1.getPSDevCenterAS4Id();
         String var42 = var1.getPSDevCenterAS4Name();
         if (!StringHelper.isNullOrEmpty(var141)) {
            if (var60.containsKey(var141)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var14, var42));
            }

            var60.put(var141, var42);
            PSDevCenterAS var43 = new PSDevCenterAS();
            var43.setPSDevCenterASId(var141);
            var66.get(var43);
            if (DataObject.getBoolValue(var43.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var43.getRefObjType()) && StringHelper.compare(var43.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var43.getRefObjId()) && StringHelper.compare(var43.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var43.getPSDevCenterASName(), var43.getRefObjName()));
            }

            this.addToPSResList(var15, var43);
            var43.reset();
            var43.setPSDevCenterASId(var141);
            var43.setRefFlag(1);
            var43.setRefObjType("PSDEVSLNSYS");
            var43.setRefObjId(var1.getPSDevSlnSysId());
            var43.setRefObjName(var14);
            var66.update(var43);
            var100.save(var43);
         }

         PSSystemAS var154 = new PSSystemAS();
         var154.setPSSystemId(var16.getPSSystemId());
         var154.setPSSystemName(var16.getPSSystemName());
         var154.setASId("AS01");
         if (!StringHelper.isNullOrEmpty(var106)) {
            var154.setPSSystemASName(var111);
            var154.setPSDevCenterASId(var106);
            var154.setPSDevCenterASName(var111);
         } else {
            var154.setPSSystemASName("未指定");
            var154.setPSDevCenterASId(null);
            var154.setPSDevCenterASName(null);
         }

         var23.save(var154);
         var154 = new PSSystemAS();
         var154.setPSSystemId(var16.getPSSystemId());
         var154.setPSSystemName(var16.getPSSystemName());
         var154.setASId("AS02");
         if (!StringHelper.isNullOrEmpty(var118)) {
            var154.setPSSystemASName(var38);
            var154.setPSDevCenterASId(var118);
            var154.setPSDevCenterASName(var38);
         } else {
            var154.setPSSystemASName("未指定");
            var154.setPSDevCenterASId(null);
            var154.setPSDevCenterASName(null);
         }

         var23.save(var154);
         var154 = new PSSystemAS();
         var154.setPSSystemId(var16.getPSSystemId());
         var154.setPSSystemName(var16.getPSSystemName());
         var154.setASId("AS03");
         if (!StringHelper.isNullOrEmpty(var129)) {
            var154.setPSSystemASName(var40);
            var154.setPSDevCenterASId(var129);
            var154.setPSDevCenterASName(var40);
         } else {
            var154.setPSSystemASName("未指定");
            var154.setPSDevCenterASId(null);
            var154.setPSDevCenterASName(null);
         }

         var23.save(var154);
         var154 = new PSSystemAS();
         var154.setPSSystemId(var16.getPSSystemId());
         var154.setPSSystemName(var16.getPSSystemName());
         var154.setASId("AS04");
         if (!StringHelper.isNullOrEmpty(var141)) {
            var154.setPSSystemASName(var42);
            var154.setPSDevCenterASId(var141);
            var154.setPSDevCenterASName(var42);
         } else {
            var154.setPSSystemASName("未指定");
            var154.setPSDevCenterASId(null);
            var154.setPSDevCenterASName(null);
         }

         var23.save(var154);
         PSDBDevInstService var67 = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, var17);
         PSDevCenterDBInstService var79 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, var17);
         PSDevCenterDBInstService var89 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, this.getSessionFactory());
         PSDCDBInstRefService var101 = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, this.getSessionFactory());
         ArrayList<PSSystemDBCfg> var107 = var22.selectByPSSystem(var16);
         ArrayList<PSSystemDBCfg> var112 = new ArrayList<>();
         ArrayList<PSSystemDBCfg> var119 = new ArrayList<>();
         HashMap<String, PSDevCenterDBInst> var123 = new HashMap<>();
         HashMap<String, String> var130 = new HashMap<>();
         if (DataObject.getBoolValue(var1.getEnableMySQL5(), false)) {
            var123.put("MYSQL5", null);
            if (var1.getMySQLPSDCDBInst() != null) {
               var123.put("MYSQL5", var1.getMySQLPSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getMySQLPSDCDBInst() != null) {
                  var123.put("MYSQL5", var13.getMySQLPSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUMySQLPSDCDBInst() != null) {
                  var123.put("MYSQL5", var13.getUMySQLPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableDB2(), false)) {
            var123.put("DB2", null);
            if (var1.getDB2PSDCDBInst() != null) {
               var123.put("DB2", var1.getDB2PSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getDB2PSDCDBInst() != null) {
                  var123.put("DB2", var13.getDB2PSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUDB2PSDCDBInst() != null) {
                  var123.put("DB2", var13.getUDB2PSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableOracle(), false)) {
            var123.put("ORACLE", null);
            if (var1.getOraPSDCDBInst() != null) {
               var123.put("ORACLE", var1.getOraPSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getOraPSDCDBInst() != null) {
                  var123.put("ORACLE", var13.getOraPSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUOraPSDCDBInst() != null) {
                  var123.put("ORACLE", var13.getUOraPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableSqlServer(), false)) {
            var123.put("SQLSERVER", null);
            if (var1.getMSSQLPSDCDBInst() != null) {
               var123.put("SQLSERVER", var1.getMSSQLPSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getMSSqlPSDCDBInst() != null) {
                  var123.put("SQLSERVER", var13.getMSSqlPSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUMSSqlPSDCDBInst() != null) {
                  var123.put("SQLSERVER", var13.getUMSSqlPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnablePGSQL(), false)) {
            var123.put("POSTGRESQL", null);
            if (var1.getPGSQLPSDCDBInst() != null) {
               var123.put("POSTGRESQL", var1.getPGSQLPSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getPGSQLPSDCDBInst() != null) {
                  var123.put("POSTGRESQL", var13.getPGSQLPSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUPGSQLPSDCDBInst() != null) {
                  var123.put("POSTGRESQL", var13.getUPGSQLPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnablePPAS(), false)) {
            var123.put("PPAS", null);
            if (var1.getPPASPSDCDBInst() != null) {
               var123.put("PPAS", var1.getPPASPSDCDBInst());
            } else if (var13 != null) {
               if (var13.getResPos() == 1 && var13.getPPASPSDCDBInst() != null) {
                  var123.put("PPAS", var13.getPPASPSDCDBInst());
               } else if (var13.getResPos() == 2 && var13.getUPPASPSDCDBInst() != null) {
                  var123.put("PPAS", var13.getUPPASPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableSQLite(), false)) {
            var123.put("SQLITE", null);
         }

         if (DataObject.getBoolValue(var1.getEnableDM(), false)) {
            var123.put("DM", null);
         }

         if (DataObject.getBoolValue(var1.getEnableHANA(), false)) {
            var123.put("HANA", null);
         }

         for (PSSystemDBCfg var142 : var107) {
            if (!var123.containsKey(var142.getPSSystemDBCfgName())) {
               var119.add(var142);
            }

            PSDevCenterDBInst var149 = (PSDevCenterDBInst)var123.get(var142.getPSSystemDBCfgName());
            if (var149 == null) {
               var112.add(var142);
            } else if (StringHelper.compare(var142.getPSDevCenterDBInstId(), var149.getPSDevCenterDBInstId(), true) != 0
               && !StringHelper.isNullOrEmpty(var142.getPSDevCenterDBInstId())) {
               var112.add(var142);
            }
         }

         for (PSSystemDBCfg var143 : var112) {
            var130.put(var143.getPSDevCenterDBInstId(), "");
         }

         for (PSSystemDBCfg var144 : var119) {
            try {
               var22.remove(var144);
            } catch (Exception var50) {
               log.error(StringHelper.format("删除原有系统数据库配置发生异常，%1$s", var50.getMessage()), var50);
            }
         }

         for (String var145 : var123.keySet()) {
            PSDevCenterDBInst var150 = (PSDevCenterDBInst)var123.get(var145);
            if (var150 != null) {
               if (!StringHelper.isNullOrEmpty(var150.getPSDevCenterASId()) && !var60.containsKey(var150.getPSDevCenterASId())) {
                  throw new Exception(StringHelper.format("数据库实例[%1$s]必须在应用容器[%2$s]下使用", var150.getPSDevCenterDBInstName(), var150.getPSDevCenterASName()));
               }

               this.addToPSResList(var15, var150);
               if (var150.getPSDBDevInst() != null) {
                  PSDBDevInst var158 = var150.getPSDBDevInst();
                  var158.setPSSvrDomainId(null);
                  var158.setPSSvrDomainName(null);
                  var158.setPasswd("******");
                  var158.setDMPassWD("******");
                  var67.save(var158);
               }

               var79.save(var150);
            }

            PSSystemDBCfg var159 = new PSSystemDBCfg();
            var159.setPSSystemDBCfgName(var145);
            if (var150 != null && var150.getPSDBDevInst() != null) {
               var159.setPSDBDevInstId(var150.getPSDBDevInst().getPSDBDevInstId());
               var159.setPSDBDevInstName(var150.getPSDBDevInst().getPSDBDevInstName());
            } else {
               var159.setPSDBDevInstId(null);
               var159.setPSDBDevInstName(null);
            }

            var159.setPSSystemId(var16.getPSSystemId());
            var159.setPSSystemName(var16.getPSSystemName());
            if (var150 != null) {
               var159.setPSDevCenterDBInstId(var150.getPSDevCenterDBInstId());
               var159.setPSDevCenterDBInstName(var150.getPSDevCenterDBInstName());
            } else {
               var159.setPSDevCenterDBInstId(null);
               var159.setPSDevCenterDBInstName(null);
            }

            var22.save(var159, false);
            if (var150 != null) {
               String var44 = var150.getPSDevCenterDBInstName();
               if (StringHelper.isNullOrEmpty(var44)) {
                  var44 = "数据库实例名称";
               }

               var130.put(var150.getPSDevCenterDBInstId(), var44);
            }
         }

         for (String var146 : var130.keySet()) {
            var42 = (String)var130.get(var146);
            PSDevCenterDBInst var160 = new PSDevCenterDBInst();
            var160.setPSDevCenterDBInstId(var146);
            PSDCDBInstRef var162 = new PSDCDBInstRef();
            var162.setRefObjType("PSDEVSLNSYS");
            var162.setPSDevCenterDBInstId(var146);
            var162.setRefObjId(var1.getPSDevSlnSysId());
            var101.fillEntityKeyValue(var162);
            boolean var45 = var101.checkKey(var162) == 0;
            if (!StringHelper.isNullOrEmpty(var42)) {
               if (var45) {
                  PSDevSln var46 = var1.getPSDevSln();
                  var162.setPSDevCenterId(var46.getPSDevCenterId());
                  var162.setPSDevCenterName(var46.getPSDevCenterName());
                  var162.setPSDevCenterDBInstName(var42);
                  var162.setRefObjName(var10);
                  var162.setPSDCDBInstRefName(var14);
                  var101.create(var162, false);
               }
            } else if (!var45) {
               try {
                  var101.remove(var162);
               } catch (Exception var49) {
                  log.error(StringHelper.format("删除原有应用中心数据库实例发生异常，%1$s", var49.getMessage()), var49);
               }
            }
         }

         PSDevCenterSVNService var68 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
         boolean var80 = true;
         if (var5 != null && !StringHelper.isNullOrEmpty(var5.getPSDevCenterSVNId())) {
            if (StringHelper.compare(var5.getPSDevCenterSVNId(), var1.getPSDevCenterSVNId(), false) != 0) {
               PSDevCenterSVN var90 = new PSDevCenterSVN();
               var90.setPSDevCenterSVNId(var5.getPSDevCenterSVNId());
               var68.get(var90);
               if ((StringHelper.isNullOrEmpty(var90.getRefObjType()) || StringHelper.compare(var90.getRefObjType(), "PSDEVSLNSYS", false) == 0)
                  && (StringHelper.isNullOrEmpty(var90.getRefObjId()) || StringHelper.compare(var90.getRefObjId(), var1.getPSDevSlnSysId(), false) == 0)) {
                  var90.setRefFlag(0);
                  var90.setRefObjId(null);
                  var90.setRefObjName(null);
                  var90.setRefObjType(null);
                  var68.update(var90);
               }
            } else {
               var80 = false;
            }
         }

         if (var80) {
            PSDevCenterSVNService var91 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, var17);
            if (!StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())) {
               PSDevCenterSVN var102 = new PSDevCenterSVN();
               var102.setPSDevCenterSVNId(var1.getPSDevCenterSVNId());
               var68.get(var102);
               if (DataObject.getBoolValue(var102.getRefFlag(), false)
                  && (
                     !StringHelper.isNullOrEmpty(var102.getRefObjType()) && StringHelper.compare(var102.getRefObjType(), "PSDEVSLNSYS", false) != 0
                        || !StringHelper.isNullOrEmpty(var102.getRefObjId()) && StringHelper.compare(var102.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
                  )) {
                  throw new Exception(StringHelper.format("代码版本库[%1$s]已经被[%2$s]使用，无法再次使用", var102.getPSDevCenterSVNName(), var102.getRefObjName()));
               }

               this.addToPSResList(var15, var102);
               var102.reset();
               var102.setPSDevCenterSVNId(var1.getPSDevCenterSVNId());
               var102.setRefFlag(1);
               var102.setRefObjType("PSDEVSLNSYS");
               var102.setRefObjId(var1.getPSDevSlnSysId());
               var102.setRefObjName(var14);
               var68.update(var102);
               var91.save(var102);
            }
         }

         PSSubSysService var69 = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, this.getSessionFactory());
         PSSysRefService var81 = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, var17);
         PSSubSysService var92 = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, var17);
         boolean var103 = true;
         if (var5 != null && !StringHelper.isNullOrEmpty(var5.getSFPSSubSysId())) {
            if (StringHelper.compare(var5.getSFPSSubSysId(), var1.getSFPSSubSysId(), false) != 0) {
               PSSubSys var108 = new PSSubSys();
               var108.setPSSubSysId(var5.getSFPSSubSysId());

               for (PSSysRef var124 : var81.selectByPSSubSys(var108)) {
                  try {
                     var81.remove(var124);
                  } catch (Exception var48) {
                     log.error(StringHelper.format("删除原有系统引用发生异常，%1$s", var48.getMessage()), var48);
                  }
               }

               try {
                  var92.remove(var108);
               } catch (Exception var47) {
                  log.error(StringHelper.format("删除原有子系统发生异常，%1$s", var47.getMessage()), var47);
               }
            } else {
               var103 = false;
            }
         }

         if (var103 && !StringHelper.isNullOrEmpty(var1.getSFPSSubSysId())) {
            PSSubSys var109 = new PSSubSys();
            var109.setPSSubSysId(var1.getSFPSSubSysId());
            var69.get(var109);
            var92.save(var109);
            PSSysRef var114 = new PSSysRef();
            var114.setPSSubSysId(var109.getPSSubSysId());
            var114.setPSSubSysName(var109.getPSSubSysName());
            var114.setPSSystemId(var16.getPSSystemId());
            var114.setPSSystemName(var16.getPSSystemName());
            var114.setPSSysRefName(var109.getPSSubSysName());
            var114.setMemo(var109.getMemo());
            var114.setSysRefType("SUBSYS");
            var114.setRealSysId(var109.getPSSubSysId());
            var114.setOrderValue(0);
            var114.setSFFWFlag(var109.getSFFWFlag());
            var81.save(var114);
         }

         PSDevSlnSys var70 = new PSDevSlnSys();
         var70.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         this.calcPSDevSlnSysResState(var70, var15);
         this.sysUpdate(var70, false);
         var1.setDevResInfo(var70.getDevResInfo());
         var1.setDevResState(var70.getDevResState());
         var1.setResReadyTime(var70.getResReadyTime());
         PSDynaSys var71 = new PSDynaSys();
         var71.setPSDynaSysId(var12);
         boolean var82 = var29.get(var71, true);
         if (!var82 && var7 > 0) {
            var71.setPSDynaSysName(var1.getPSDevSlnSysName());
            var71.setLogicName(var1.getLogicName());
            var29.create(var71, false);
         }

         PSSystem var93 = new PSSystem();
         var93.setPSSystemId(var12);
         var93.setEnableDynaSys(var7);
         var93.setSaaSMode(var8);
         var93.setSysVer(var9);
         var18.update(var93, false);
         if (!StringHelper.isNullOrEmpty(var1.getPSSystemId())) {
            PSSystem var72 = new PSSystem();
            var72.setPSSystemId(var1.getPSSystemId());
            ArrayList<PSSysSFPub> var83 = var25.selectByPSSystem(var72);
            HashMap<String, String> var94 = new HashMap<>();
            HashMap<String, String> var104 = new HashMap<>();
            HashMap<String, String> var110 = new HashMap<>();

            for (PSSysSFPub var121 : var83) {
               if (!StringHelper.isNullOrEmpty(var121.getPSSFStyleId())) {
                  var94.put(var121.getPSSFStyleId(), "");
               }

               if (!StringHelper.isNullOrEmpty(var121.getPSSFStyleVerId())) {
                  var104.put(var121.getPSSFStyleVerId(), "");
               }
            }

            PSAppViewServiceProxy var116 = (PSAppViewServiceProxy)ServiceGlobal.getService(PSAppViewServiceProxy.class, var17);

            for (PSSysApp var131 : var24.selectByPSSystem(var72)) {
               var110.put(var131.getPSPFStyleId(), "");

               for (PSAppUIStyle var152 : var131.getPSAppUIStyles()) {
                  var110.put(var152.getPSPFStyleId(), "");
               }

               SelectCond var148 = new SelectCond();
               var148.set("PSSYSAPPID", var131.getPSSysAppId());
               var148.setIsNotNull("PSPFSTYLEID");

               for (PSAppView var163 : var116.select(var148)) {
                  var110.put(var163.getPSPFStyleId(), "");
               }
            }

            for (String var132 : var94.keySet()) {
               if (!StringHelper.isNullOrEmpty(var132)) {
                  this.syncPSSFStyle2(var132, var17);
               }
            }

            for (String var133 : var104.keySet()) {
               if (!StringHelper.isNullOrEmpty(var133)) {
                  this.syncPSSFStyleVer(var133, var17);
               }
            }

            for (String var134 : var110.keySet()) {
               if (!StringHelper.isNullOrEmpty(var134)) {
                  this.syncPSPFStyle(var134, var17);
               }
            }
         }

         if (var4) {
            var18.executeRaw("UPDATE T_SRFPSSYSDBDETAIL SET PUBDBVER = 0  ", null);
         }
      }
   }

   protected void syncPSSysModelInst2(PSDevSlnSys var1, boolean var2, boolean var3) throws Exception {
      ActionSessionManager.getCurrentSession().setActionParam("IGNORECALCRESSTATE", "");
      PSDevSlnSys var4 = null;
      if (!var2) {
         var4 = this.getLast(var1);
      }

      boolean var5 = false;
      if (var1.isShareFlagDirty()) {
         var5 = DataObject.getBoolValue(var1.getShareFlag(), false);
      } else if (var4 != null) {
         var5 = DataObject.getBoolValue(var4.getShareFlag(), false);
      }

      if (var5) {
         this.syncSharePSSysModelInst(var1);
      } else {
         int var6 = 0;
         if (var1.isEnableDynaSysDirty()) {
            var6 = DataObject.getIntegerValue(var1.getEnableDynaSys(), 0);
         } else if (var4 != null) {
            var6 = DataObject.getIntegerValue(var4.getEnableDynaSys(), 0);
         }

         String var7 = var1.getPSDevSlnSysName();
         String var8 = var1.getPSDevSlnName();
         if (StringHelper.isNullOrEmpty(var7) || StringHelper.isNullOrEmpty(var8)) {
            if (var4 != null) {
               var7 = var4.getPSDevSlnSysName();
               var8 = var4.getPSDevSlnName();
            } else {
               var7 = "未知系统名称";
            }
         }

         String var9 = var1.getPSSystemId();
         if (StringHelper.isNullOrEmpty(var9)) {
            if (var4 != null) {
               var9 = var4.getPSSystemId();
            } else {
               var9 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
            }
         }

         PSDevSlnSysRes var10 = null;
         if (var1.isPSDevSlnSysResIdDirty()) {
            var10 = var1.getPSDevSlnSysRes();
         } else if (var4 != null) {
            var10 = var4.getPSDevSlnSysRes();
         }

         String var11 = null;
         if (StringHelper.isNullOrEmpty(var8)) {
            var11 = var7;
         } else {
            var11 = StringHelper.format("%1$s\\%2$s", var8, var7);
         }

         ArrayList var12 = new ArrayList();
         PSSystem var13 = new PSSystem();
         PSDevSln var14 = var1.getPSDevSln();
         var1.copyTo(var13, true);
         var13.setPSDevCenterId(var14.getPSDevCenterId());
         var13.setPSDevCenterName(var14.getPSDevCenterName());
         var13.setPSSystemName(var1.getPSDevSlnSysName());
         HashMap var32 = new HashMap();
         PSDevCenterASService var15 = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, this.getSessionFactory());
         SelectCond var16 = new SelectCond();
         var16.set("PSSYSTEMID", var9);
         String var17 = var1.getPSDevCenterASId();
         String var18 = var1.getPSDevCenterASName();
         if (StringHelper.isNullOrEmpty(var17) && var10 != null) {
            if (var10.getResPos() == 1 && !StringHelper.isNullOrEmpty(var10.getPSDevCenterASId())) {
               var17 = var10.getPSDevCenterASId();
               var18 = var10.getPSDevCenterASName();
            } else if (var10.getResPos() == 2 && !StringHelper.isNullOrEmpty(var10.getUPSDevCenterASId())) {
               var17 = var10.getUPSDevCenterASId();
               var18 = var10.getUPSDevCenterASName();
            }
         }

         if (!StringHelper.isNullOrEmpty(var17)) {
            if (var32.containsKey(var17)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var11, var18));
            }

            var32.put(var17, var18);
            PSDevCenterAS var19 = new PSDevCenterAS();
            var19.setPSDevCenterASId(var17);
            var15.get(var19);
            if (DataObject.getBoolValue(var19.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var19.getRefObjType()) && StringHelper.compare(var19.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var19.getRefObjId()) && StringHelper.compare(var19.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var19.getPSDevCenterASName(), var19.getRefObjName()));
            }

            this.addToPSResList(var12, var19);
            var19.reset();
            var19.setPSDevCenterASId(var17);
            var19.setRefFlag(1);
            var19.setRefObjType("PSDEVSLNSYS");
            var19.setRefObjId(var1.getPSDevSlnSysId());
            var19.setRefObjName(var11);
            var15.update(var19);
         }

         String var48 = var1.getPSDevCenterASId2();
         String var20 = var1.getPSDevCenterASName2();
         if (StringHelper.isNullOrEmpty(var48) && var10 != null) {
            if (var10.getResPos() == 1 && !StringHelper.isNullOrEmpty(var10.getPSDevCenterASId2())) {
               var48 = var10.getPSDevCenterASId2();
               var20 = var10.getPSDevCenterASName2();
            } else if (var10.getResPos() == 2 && !StringHelper.isNullOrEmpty(var10.getUPSDevCenterASId2())) {
               var48 = var10.getUPSDevCenterASId2();
               var20 = var10.getUPSDevCenterASName2();
            }
         }

         if (!StringHelper.isNullOrEmpty(var48)) {
            if (var32.containsKey(var48)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var11, var20));
            }

            var32.put(var48, var20);
            PSDevCenterAS var21 = new PSDevCenterAS();
            var21.setPSDevCenterASId(var48);
            var15.get(var21);
            if (DataObject.getBoolValue(var21.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var21.getRefObjType()) && StringHelper.compare(var21.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var21.getRefObjId()) && StringHelper.compare(var21.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var21.getPSDevCenterASName(), var21.getRefObjName()));
            }

            this.addToPSResList(var12, var21);
            var21.reset();
            var21.setPSDevCenterASId(var48);
            var21.setRefFlag(1);
            var21.setRefObjType("PSDEVSLNSYS");
            var21.setRefObjId(var1.getPSDevSlnSysId());
            var21.setRefObjName(var11);
            var15.update(var21);
         }

         String var54 = var1.getPSDevCenterAS3Id();
         String var22 = var1.getPSDevCenterAS3Name();
         if (!StringHelper.isNullOrEmpty(var54)) {
            if (var32.containsKey(var54)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var11, var22));
            }

            var32.put(var54, var22);
            PSDevCenterAS var23 = new PSDevCenterAS();
            var23.setPSDevCenterASId(var54);
            var15.get(var23);
            if (DataObject.getBoolValue(var23.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var23.getRefObjType()) && StringHelper.compare(var23.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var23.getRefObjId()) && StringHelper.compare(var23.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var23.getPSDevCenterASName(), var23.getRefObjName()));
            }

            this.addToPSResList(var12, var23);
            var23.reset();
            var23.setPSDevCenterASId(var54);
            var23.setRefFlag(1);
            var23.setRefObjType("PSDEVSLNSYS");
            var23.setRefObjId(var1.getPSDevSlnSysId());
            var23.setRefObjName(var11);
            var15.update(var23);
         }

         String var66 = var1.getPSDevCenterAS4Id();
         String var24 = var1.getPSDevCenterAS4Name();
         if (!StringHelper.isNullOrEmpty(var66)) {
            if (var32.containsKey(var66)) {
               throw new Exception(StringHelper.format("开发系统[%1$s]多次引用应用容器[%2$s]", var11, var24));
            }

            var32.put(var66, var24);
            PSDevCenterAS var25 = new PSDevCenterAS();
            var25.setPSDevCenterASId(var66);
            var15.get(var25);
            if (DataObject.getBoolValue(var25.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var25.getRefObjType()) && StringHelper.compare(var25.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var25.getRefObjId()) && StringHelper.compare(var25.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("应用容器[%1$s]已经被[%2$s]使用，无法再次使用", var25.getPSDevCenterASName(), var25.getRefObjName()));
            }

            this.addToPSResList(var12, var25);
            var25.reset();
            var25.setPSDevCenterASId(var66);
            var25.setRefFlag(1);
            var25.setRefObjType("PSDEVSLNSYS");
            var25.setRefObjId(var1.getPSDevSlnSysId());
            var25.setRefObjName(var11);
            var15.update(var25);
         }

         PSDevCenterDBInstService var33 = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, this.getSessionFactory());
         PSDCDBInstRefService var38 = (PSDCDBInstRefService)ServiceGlobal.getService(PSDCDBInstRefService.class, this.getSessionFactory());
         ArrayList<PSSystemDBCfg> var42 = new ArrayList<>();
         new ArrayList();
         HashMap<String, PSDevCenterDBInst> var49 = new HashMap<>();
         HashMap<String, String> var51 = new HashMap<>();
         if (DataObject.getBoolValue(var1.getEnableMySQL5(), false)) {
            if (var1.getMySQLPSDCDBInst() != null) {
               var49.put("MYSQL5", var1.getMySQLPSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getMySQLPSDCDBInst() != null) {
                  var49.put("MYSQL5", var10.getMySQLPSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUMySQLPSDCDBInst() != null) {
                  var49.put("MYSQL5", var10.getUMySQLPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableDB2(), false)) {
            if (var1.getDB2PSDCDBInst() != null) {
               var49.put("DB2", var1.getDB2PSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getDB2PSDCDBInst() != null) {
                  var49.put("DB2", var10.getDB2PSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUDB2PSDCDBInst() != null) {
                  var49.put("DB2", var10.getUDB2PSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableOracle(), false)) {
            if (var1.getOraPSDCDBInst() != null) {
               var49.put("ORACLE", var1.getOraPSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getOraPSDCDBInst() != null) {
                  var49.put("ORACLE", var10.getOraPSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUOraPSDCDBInst() != null) {
                  var49.put("ORACLE", var10.getUOraPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableSqlServer(), false)) {
            if (var1.getMSSQLPSDCDBInst() != null) {
               var49.put("SQLSERVER", var1.getMSSQLPSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getMSSqlPSDCDBInst() != null) {
                  var49.put("SQLSERVER", var10.getMSSqlPSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUMSSqlPSDCDBInst() != null) {
                  var49.put("SQLSERVER", var10.getUMSSqlPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnablePGSQL(), false)) {
            if (var1.getPGSQLPSDCDBInst() != null) {
               var49.put("POSTGRESQL", var1.getPGSQLPSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getPGSQLPSDCDBInst() != null) {
                  var49.put("POSTGRESQL", var10.getPGSQLPSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUPGSQLPSDCDBInst() != null) {
                  var49.put("POSTGRESQL", var10.getUPGSQLPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnablePPAS(), false)) {
            if (var1.getPPASPSDCDBInst() != null) {
               var49.put("PPAS", var1.getPPASPSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getPPASPSDCDBInst() != null) {
                  var49.put("PPAS", var10.getPPASPSDCDBInst());
               } else if (var10.getResPos() == 2 && var10.getUPPASPSDCDBInst() != null) {
                  var49.put("PPAS", var10.getUPPASPSDCDBInst());
               }
            }
         }

         if (DataObject.getBoolValue(var1.getEnableSQLite(), false)) {
            var49.put("SQLITE", null);
         }

         if (DataObject.getBoolValue(var1.getEnableDM(), false)) {
            var49.put("DM", null);
         }

         if (DataObject.getBoolValue(var1.getEnableHANA(), false)) {
            var49.put("HANA", null);
         }

         for (PSSystemDBCfg var61 : var42) {
            var51.put(var61.getPSDevCenterDBInstId(), "");
         }

         for (String var62 : var49.keySet()) {
            PSDevCenterDBInst var67 = (PSDevCenterDBInst)var49.get(var62);
            if (var67 != null) {
               if (!StringHelper.isNullOrEmpty(var67.getPSDevCenterASId()) && !var32.containsKey(var67.getPSDevCenterASId())) {
                  throw new Exception(StringHelper.format("数据库实例[%1$s]必须在应用容器[%2$s]下使用", var67.getPSDevCenterDBInstName(), var67.getPSDevCenterASName()));
               }

               this.addToPSResList(var12, var67);
            }

            if (var67 != null) {
               var24 = var67.getPSDevCenterDBInstName();
               if (StringHelper.isNullOrEmpty(var24)) {
                  var24 = "数据库实例名称";
               }

               var51.put(var67.getPSDevCenterDBInstId(), var24);
            }
         }

         for (String var63 : var51.keySet()) {
            var66 = (String)var51.get(var63);
            PSDevCenterDBInst var72 = new PSDevCenterDBInst();
            var72.setPSDevCenterDBInstId(var63);
            PSDCDBInstRef var73 = new PSDCDBInstRef();
            var73.setRefObjType("PSDEVSLNSYS");
            var73.setPSDevCenterDBInstId(var63);
            var73.setRefObjId(var1.getPSDevSlnSysId());
            var38.fillEntityKeyValue(var73);
            boolean var26 = var38.checkKey(var73) == 0;
            if (!StringHelper.isNullOrEmpty(var66)) {
               if (var26) {
                  PSDevSln var27 = var1.getPSDevSln();
                  var73.setPSDevCenterId(var27.getPSDevCenterId());
                  var73.setPSDevCenterName(var27.getPSDevCenterName());
                  var73.setPSDevCenterDBInstName(var66);
                  var73.setRefObjName(var7);
                  var73.setPSDCDBInstRefName(var11);
                  var38.create(var73, false);
               }
            } else if (!var26) {
               try {
                  var38.remove(var73);
               } catch (Exception var28) {
                  log.error(StringHelper.format("删除原有应用中心数据库实例发生异常，%1$s", var28.getMessage()), var28);
               }
            }
         }

         PSDCBDInstService var34 = (PSDCBDInstService)ServiceGlobal.getService(PSDCBDInstService.class, this.getSessionFactory());
         ArrayList<PSSysBDInstCfg> var39 = new ArrayList<>();
         HashMap<String, PSDCBDInst> var43 = new HashMap<>();
         HashMap<String, String> var47 = new HashMap<>();
         if (DataObject.getBoolValue(var1.getEnableHBase(), false)) {
            if (var1.getHBasePSDCDBInst() != null) {
               var43.put("HBASE", var1.getHBasePSDCDBInst());
            } else if (var10 != null) {
               if (var10.getResPos() == 1 && var10.getHBasePSDCBDInst() != null) {
                  var43.put("HBASE", var10.getHBasePSDCBDInst());
               } else if (var10.getResPos() == 2 && var10.getUHBasePSDCBDInst() != null) {
                  var43.put("HBASE", var10.getUHBasePSDCBDInst());
               }
            }
         }

         boolean var50 = var43.size() > 0;

         for (PSSysBDInstCfg var58 : var39) {
            var47.put(var58.getPSDCBDInstId(), "");
         }

         var20 = "";

         for (String var64 : var43.keySet()) {
            PSDCBDInst var69 = (PSDCBDInst)var43.get(var64);
            var69.setPSBDDevInstId(null);
            var69.setPSBDDevInstName(null);
            var47.put(var69.getPSDCBDInstId(), "");
            if (!StringHelper.isNullOrEmpty(var20)) {
               var20 = var20 + ";";
            }

            var20 = var20 + var64;
         }

         for (String var65 : var47.keySet()) {
            PSDCBDInst var70 = new PSDCBDInst();
            var70.setPSDCBDInstId(var65);
            if (var34.get(var70, true)) {
               var34.calcRefInfo(var70);
            }
         }

         PSDevCenterSVNService var35 = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, this.getSessionFactory());
         boolean var40 = true;
         if (var4 != null && !StringHelper.isNullOrEmpty(var4.getPSDevCenterSVNId())) {
            if (StringHelper.compare(var4.getPSDevCenterSVNId(), var1.getPSDevCenterSVNId(), false) != 0) {
               PSDevCenterSVN var44 = new PSDevCenterSVN();
               var44.setPSDevCenterSVNId(var4.getPSDevCenterSVNId());
               var35.get(var44);
               if ((StringHelper.isNullOrEmpty(var44.getRefObjType()) || StringHelper.compare(var44.getRefObjType(), "PSDEVSLNSYS", false) == 0)
                  && (StringHelper.isNullOrEmpty(var44.getRefObjId()) || StringHelper.compare(var44.getRefObjId(), var1.getPSDevSlnSysId(), false) == 0)) {
                  var44.setRefFlag(0);
                  var44.setRefObjId(null);
                  var44.setRefObjName(null);
                  var44.setRefObjType(null);
                  var35.update(var44);
               }
            } else {
               var40 = false;
            }
         }

         if (var40 && !StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())) {
            PSDevCenterSVN var45 = new PSDevCenterSVN();
            var45.setPSDevCenterSVNId(var1.getPSDevCenterSVNId());
            var35.get(var45);
            if (DataObject.getBoolValue(var45.getRefFlag(), false)
               && (
                  !StringHelper.isNullOrEmpty(var45.getRefObjType()) && StringHelper.compare(var45.getRefObjType(), "PSDEVSLNSYS", false) != 0
                     || !StringHelper.isNullOrEmpty(var45.getRefObjId()) && StringHelper.compare(var45.getRefObjId(), var1.getPSDevSlnSysId(), false) != 0
               )) {
               throw new Exception(StringHelper.format("代码版本库[%1$s]已经被[%2$s]使用，无法再次使用", var45.getPSDevCenterSVNName(), var45.getRefObjName()));
            }

            this.addToPSResList(var12, var45);
         }

         PSSubSysService var36 = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, this.getSessionFactory());
         boolean var41 = true;
         if (var4 != null
            && !StringHelper.isNullOrEmpty(var4.getSFPSSubSysId())
            && StringHelper.compare(var4.getSFPSSubSysId(), var1.getSFPSSubSysId(), false) == 0) {
            var41 = false;
         }

         if (var41 && !StringHelper.isNullOrEmpty(var1.getSFPSSubSysId())) {
            PSSubSys var46 = new PSSubSys();
            var46.setPSSubSysId(var1.getSFPSSubSysId());
            var36.get(var46);
         }

         PSDevSlnSys var37 = new PSDevSlnSys();
         var37.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         this.calcPSDevSlnSysResState(var37, var12);
         this.sysUpdate(var37, false);
         var1.setDevResInfo(var37.getDevResInfo());
         var1.setDevResState(var37.getDevResState());
         var1.setResReadyTime(var37.getResReadyTime());
      }
   }

   @Override
   protected boolean isPrepareLastForRemove() {
      return PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) ? true : super.isPrepareLastForRemove();
   }

   protected void internalRemove(PSDevSlnSys var1) throws Exception {
      if (!PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory()) || !this.doMovePSDevSlnSys(var1)) {
         super.internalRemove(var1);
      }
   }

   protected boolean doMovePSDevSlnSys(PSDevSlnSys var1) throws Exception {
      if (StringHelper.isNullOrEmpty(getRecyclePSDCId())) {
         return false;
      }

      PSDevSlnSys var2 = this.getLast(var1);
      PSDevSln var3 = var2.getPSDevSln();
      PSDevSln var4 = new PSDevSln();
      var4.setPSDevSlnName(StringHelper.format("S%1$s", KeyValueHelper.genUniqueId(var1.getPSDevSlnSysId(), Integer.toString(random.nextInt(99999999)))));
      var4.setCodeName(var4.getPSDevSlnName());
      var4.setPSDevCenterId(getRecyclePSDCId());
      StringBuilderEx var5 = new StringBuilderEx();
      if (var3 != null) {
         var5.append("PSDEVCENTERID=%1$s\r\n", var3.getPSDevCenterId());
         var5.append("PSDEVCENTERNAME%1$s\r\n", var3.getPSDevCenterName());
         var5.append("PSDEVSLNID=%1$s\r\n", var3.getPSDevSlnId());
         var5.append("PSDEVSLNNAME=%1$s\r\n", var3.getPSDevSlnName());
      }

      var5.append("PSDEVSLNSYSID=%1$s\r\n", var2.getPSDevSlnSysId());
      var5.append("PSDEVSLNSYSNAME=%1$s\r\n", var2.getPSDevSlnSysName());
      var4.setMemo(var5.toString());

      try {
         PSDevSlnService var6 = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, this.getSessionFactory());
         var6.create(var4);
      } catch (Exception var13) {
         log.error(StringHelper.format("建立回收开发方案发生异常，%1$s", var13.getMessage()), var13);
         throw new Exception(StringHelper.format("建立回收开发方案发生异常，%1$s", var13.getMessage()), var13);
      }

      if (!StringHelper.isNullOrEmpty(var2.getPSSysModelInstId())) {
         try {
            PSSysModelInstService var14 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
            PSSysModelInst var7 = new PSSysModelInst();
            var7.setPSSysModelInstId(var2.getPSSysModelInstId());
            var7.setPSDevCenterId(var4.getPSDevCenterId());
            var7.setPSDevCenterName(var4.getPSDevCenterName());
            var14.sysUpdate(var7, false);
         } catch (Exception var12) {
            log.error(StringHelper.format("更新模型仓库归属发生异常，%1$s", var12.getMessage()), var12);
            throw new Exception(StringHelper.format("更新模型仓库归属发生异常，%1$s", var12.getMessage()), var12);
         }
      }

      try {
         PSDevSlnSys var15 = new PSDevSlnSys();
         var15.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         var15.setPSDevSlnId(var4.getPSDevSlnId());
         var15.setPSDevSlnName(var4.getPSDevSlnName());
         var15.setPSDevCenterId(var4.getPSDevCenterId());
         var15.setPSDevCenterName(var4.getPSDevCenterName());
         this.sysUpdate(var15, false);
      } catch (Exception var11) {
         log.error(StringHelper.format("更新开发系统归属发生异常，%1$s", var11.getMessage()), var11);
         throw new Exception(StringHelper.format("更新开发系统归属发生异常，%1$s", var11.getMessage()), var11);
      }

      Project var16 = null;
      Project var17 = null;
      if (isEnableGitLabPlugin()) {
         try {
            var16 = getPSGitLabPlugin().moveCodeProjectByPSDevSlnSys(var2, var4);
            var17 = getPSGitLabPlugin().moveModelProjectByPSDevSlnSys(var2, var4);
         } catch (Exception var10) {
            log.error(StringHelper.format("转移代码仓库群组发生异常，%1$s", var10.getMessage()), var10);
            throw new Exception(StringHelper.format("转移代码仓库群组发生异常，%1$s", var10.getMessage()), var10);
         }
      }

      try {
         if (var2.getPSDevCenterSVN() != null) {
            PSGitLabHelper.movePSDevCenterSVN(var2.getPSDevCenterSVN(), var16, var4);
         }

         if (var2.getModelPSDevCenterSVN() != null) {
            PSGitLabHelper.movePSDevCenterSVN(var2.getModelPSDevCenterSVN(), var17, var4);
         }

         return true;
      } catch (Exception var9) {
         log.error(StringHelper.format("转移平台仓库发生异常，%1$s", var9.getMessage()), var9);
         throw new Exception(StringHelper.format("转移平台仓库发生异常，%1$s", var9.getMessage()), var9);
      }
   }

   protected void onAfterRemove(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         PSDevSlnSys var2 = this.getLast(var1);
         PSDevCenterHelper.updatetPSDCResRep(var2.getPSDevSln().getPSDevCenter(), "DEVSYSCNT");
      }

      super.onAfterRemove(var1);
   }

   public void resetLoadTimeByPSTaskServer(PSTaskServer var1) throws Exception {
      final String var2 = var1.getPSTaskServerId();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            String var2x = "UPDATE T_SRFPSDEVSLNSYS SET LOADTIME = NULL WHERE PSTASKSERVERID = ?";
            SqlParamList var3 = new SqlParamList();
            var3.addString(var2);
            PSDevSlnSysService.this.getDAO().executeRawSql(null, var2x, var3);
         }
      });
   }

   @Override
   protected void onSwitchPSRes(PSDevSlnSys var1) throws Exception {
      this.get(var1);
      if (!StringHelper.isNullOrEmpty(var1.getPSDevSlnSysResId())) {
         PSDevSlnSysRes var2 = new PSDevSlnSysRes();
         var2.setPSDevSlnSysResId(var1.getPSDevSlnSysResId());
         PSDevSlnSysResService var3 = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, this.getSessionFactory());
         var3.get(var2);
         if (var2.getResPos() != 1) {
            var2.reset();
            var2.setPSDevSlnSysResId(var1.getPSDevSlnSysResId());
            var2.setResPos(1);
            var3.update(var2);
            this.syncPSSysModelInst(var1, false, true);
         }
      }
   }

   @Override
   protected void onSwitchUserRes(PSDevSlnSys var1) throws Exception {
      this.get(var1);
      if (!StringHelper.isNullOrEmpty(var1.getPSDevSlnSysResId())) {
         PSDevSlnSysRes var2 = new PSDevSlnSysRes();
         var2.setPSDevSlnSysResId(var1.getPSDevSlnSysResId());
         PSDevSlnSysResService var3 = (PSDevSlnSysResService)ServiceGlobal.getService(PSDevSlnSysResService.class, this.getSessionFactory());
         var3.get(var2);
         if (var2.getResPos() != 2) {
            var2.reset();
            var2.setPSDevSlnSysResId(var1.getPSDevSlnSysResId());
            var2.setResPos(2);
            var3.update(var2);
            this.syncPSSysModelInst(var1, false, true);
         }
      }
   }

   @Override
   protected void onAdminVisit(PSDevSlnSys var1) throws Exception {
      super.onAdminVisit(var1);
   }

   public PSDevSlnSysKey createAdminKey(PSDevSlnSys var1) throws Exception {
      final PSDevSlnSys var2 = var1;
      final CallResult var3 = new CallResult();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var3.setUserObject(PSDevSlnSysService.this.onCreateAdminKey(var2));
         }
      });
      return (PSDevSlnSysKey)var3.getUserObject();
   }

   protected PSDevSlnSysKey onCreateAdminKey(PSDevSlnSys var1) throws Exception {
      throw new Exception("没有实现自定义行为[ADMINVISIT]");
   }

   @Override
   public void onPSDCASChanged(PSDevCenterAS var1, PSDevCenterAS var2) throws Exception {
      if (!ActionSessionManager.getCurrentSession().containsActionParam("IGNORECALCRESSTATE")) {
         PSDevSlnSys var3 = new PSDevSlnSys();
         var3.setPSDevSlnSysId(var1.getRefObjId());
         if (StringHelper.isNullOrEmpty(var3.getPSDevSlnSysId()) && var2 != null) {
            var3.setPSDevSlnSysId(var2.getRefObjId());
         }

         this.update(var3);
      }
   }

   @Override
   public void onPSDCDBInstChanged(PSDCDBInstRef var1, PSDevCenterDBInst var2, PSDevCenterDBInst var3) throws Exception {
      if (!ActionSessionManager.getCurrentSession().containsActionParam("IGNORECALCRESSTATE")) {
         PSDevSlnSys var4 = new PSDevSlnSys();
         String var5 = var1.getRefObjId();
         var4.setPSDevSlnSysId(var5);
         this.update(var4);
      }
   }

   @Override
   public void onPSDCSVNChanged(PSDevCenterSVN var1, PSDevCenterSVN var2) throws Exception {
      if (!ActionSessionManager.getCurrentSession().containsActionParam("IGNORECALCRESSTATE")) {
         PSDevSlnSys var3 = new PSDevSlnSys();
         var3.setPSDevSlnSysId(var1.getRefObjId());
         if (StringHelper.isNullOrEmpty(var3.getPSDevSlnSysId()) && var2 != null) {
            var3.setPSDevSlnSysId(var2.getRefObjId());
         }

         this.update(var3);
      }
   }

   protected void addToPSResList(ArrayList<IEntity> var1, IEntity var2) throws Exception {
      IEntity var3 = var2.getClass().newInstance();
      var2.copyTo(var3, false);
      var1.add(var3);
   }

   protected void calcPSDevSlnSysResState(PSDevSlnSys var1, ArrayList<IEntity> var2) throws Exception {
      int var3 = 11;
      ICodeList var4 = CodeListGlobal.getCodeList(DevCenterResStateCodeListModel.class);
      Timestamp var5 = null;
      boolean var6 = true;
      StringBuilderEx var7 = new StringBuilderEx();

      for (IEntity var9 : var2) {
         int var10 = DataObject.getIntegerValue(var9, "RESSTATE", 20);
         if (var6) {
            var3 = var10;
         } else if (psResStateLevelMap.get(var10) > psResStateLevelMap.get(var3)) {
            var3 = var10;
         }

         String var11 = var4.getCodeListText(Integer.toString(var10), true);
         Timestamp var12 = DataObject.getTimestampValue(var9, "RESREADYTIME", null);
         if (var12 != null) {
            if (var5 == null) {
               var5 = var12;
            } else if (var12.getTime() > var5.getTime()) {
               var5 = var12;
            }
         }

         if (var6) {
            var6 = false;
         } else {
            var7.append("\r\n");
         }

         if (var9 instanceof PSDevCenterAS) {
            PSDevCenterAS var13 = (PSDevCenterAS)var9;
            var7.append("应用容器[%1$s] %2$s", var13.getPSDevCenterASName(), var11);
         } else if (var9 instanceof PSDevCenterDBInst) {
            PSDevCenterDBInst var14 = (PSDevCenterDBInst)var9;
            var7.append("数据库实例[%1$s] %2$s", var14.getPSDevCenterDBInstName(), var11);
         } else {
            if (!(var9 instanceof PSDevCenterSVN)) {
               continue;
            }

            PSDevCenterSVN var15 = (PSDevCenterSVN)var9;
            var7.append("代码仓库[%1$s] %2$s", var15.getPSDevCenterSVNName(), var11);
         }

         if (var12 != null) {
            var7.append(",资源就绪时间[%1$s]", DateHelper.toDateTimeString(var12));
         }
      }

      if (var3 != 42) {
         var5 = null;
      }

      var1.setDevResInfo(var7.toString());
      var1.setDevResState(var3);
      var1.setResReadyTime(var5);
   }

   public void remove(PSDevSlnSys var1) throws Exception {
      final PSDevSlnSys var2 = var1;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSDevSlnSysService.this.doRealRemove(var2);
         }
      }, true);
   }

   protected void doRealRemove(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         this.get(var1);
         if (StringHelper.isNullOrEmpty(getRecyclePSDCId())) {
            if (DataObject.getIntegerValue(var1.getDevSysState(), 30) != 42) {
               throw new Exception("开发系统禁止删除");
            }
         } else {
            int var2 = DataObject.getIntegerValue(var1.getDevSysState(), 30);
            switch (var2) {
               case 20:
               case 21:
               case 30:
               case 31:
                  throw new Exception(StringHelper.format("状态为[创建中]、[恢复中]、[正常]、[运维中]的开发系统禁止删除"));
            }
         }

         if (!StringHelper.isNullOrEmpty(var1.getPSDCWorkspaceId())) {
            throw new Exception(StringHelper.format("已经绑定生产线的开发系统禁止删除"));
         }

         var1.setPSDevSlnSysResId(null);
         var1.setPSDevSlnSysResName(null);
         var1.setPSDCSysLicId(null);
         var1.setEnableMySQL5(0);
         var1.setMySQLPSDCDBInstId(null);
         var1.setEnableDB2(0);
         var1.setDB2PSDCDBInstId(null);
         var1.setEnableHBase(0);
         var1.setHBasePSDCBDInstId(null);
         var1.setEnableOracle(0);
         var1.setOraPSDCDBInstId(null);
         var1.setEnablePGSQL(0);
         var1.setPGSQLPSDCDBInstId(null);
         var1.setEnablePPAS(0);
         var1.setPPASPSDCDBInstId(null);
         var1.setEnableSqlServer(0);
         var1.setMSSQLPSDCDBInstId(null);
         var1.setEnableSQLite(0);
         var1.setEnableDM(0);
         var1.setEnableHANA(0);
         var1.setPSDevCenterASId(null);
         var1.setPSDevCenterASId2(null);
         var1.setPSDevCenterAS3Id(null);
         var1.setPSDevCenterAS4Id(null);
         var1.setPSDevCenterId(null);
         var1.setPSDevCenterTSId(null);
         var1.setPSTaskServerId(null);
         var1.setPSTaskServerName(null);
         var1.setPSDCRobotId(null);
         var1.setPSDCRobotName(null);
         var1.set("IGNOREPSDEVCENTERTS", 1);
         this.update(var1, true);
         SelectContext var7 = new SelectContext();
         var7.addSelectField("PSDEVSLNSYSBAKID");
         var7.set("PSDEVSLNSYSID", var1.getPSDevSlnSysId());
         var7.set("OFFLINEFLAG", 1);
         PSDevSlnSysBakService var3 = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, this.getSessionFactory());

         for (PSDevSlnSysBak var6 : var3.select(var7)) {
            var6.setOfflineFlag(0);
            var3.sysUpdate(var6, false);
         }
      }

      super.remove(var1);
   }

   @Override
   protected void onBeforeRemove(PSDevSlnSys var1) throws Exception {
      super.onBeforeRemove(var1);
   }

   @Override
   protected void onRebindSystem(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())) {
         this.get(var1);
         this.syncPSSysModelInst(var1, true, false, false);
      }
   }

   public void movePSDevSlnSys(PSDevSlnSys var1, PSDevCenter var2, PSDevSln var3) throws Exception {
      if (this.get(var1, true)) {
         final PSDevSlnSys var4 = var1;
         final PSDevCenter var5 = var2;
         final PSDevSln var6 = var3;
         ServiceWorkHelper.getInstance(this.getWebContext()).execute(new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               PSDevSln var2x = var4.getPSDevSln();
               PSDCSysLic var3x = var4.getPSDCSysLic();
               var4.setPSDevSlnSysResId(null);
               var4.setPSDevSlnSysResName(null);
               var4.setPSDevCenterSVNId(null);
               var4.setROPSDevCenterSvnId(null);
               var4.setModelPSDevCenterSVNId(null);
               var4.setPSDCSysLicId(null);
               var4.setEnableMySQL5(0);
               var4.setMySQLPSDCDBInstId(null);
               var4.setEnableDB2(0);
               var4.setDB2PSDCDBInstId(null);
               var4.setEnableHBase(0);
               var4.setHBasePSDCBDInstId(null);
               var4.setEnableOracle(0);
               var4.setOraPSDCDBInstId(null);
               var4.setEnablePGSQL(0);
               var4.setPGSQLPSDCDBInstId(null);
               var4.setEnablePPAS(0);
               var4.setPPASPSDCDBInstId(null);
               var4.setEnableSqlServer(0);
               var4.setMSSQLPSDCDBInstId(null);
               var4.setEnableSQLite(0);
               var4.setEnableDM(0);
               var4.setEnableHANA(0);
               var4.setPSDevCenterASId(null);
               var4.setPSDevCenterASId2(null);
               var4.setPSDevCenterAS3Id(null);
               var4.setPSDevCenterAS4Id(null);
               var4.setPSDevCenterId(null);
               var4.setPSDevCenterTSId(null);
               var4.setPSTaskServerId(null);
               var4.setPSTaskServerName(null);
               var4.setPSDCRobotId(null);
               var4.setPSDCRobotName(null);
               if (var6 != null) {
                  var4.setPSDevSlnId(var6.getPSDevSlnId());
                  var4.setPSDevSlnName(var6.getPSDevSlnName());
               }

               var4.set("IGNOREPSDEVCENTERTS", 1);
               PSDevSlnSysService.this.update(var4, false);
               if (var6 == null) {
                  PSDevSlnService var4x = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, PSDevSlnSysService.this.getSessionFactory());
                  var2x.setMemo(StringHelper.format("来源[%1$s][%2$s]", var2x.getPSDevCenterName(), var2x.getPSDevSlnName()));
                  var2x.setPSDevSlnName(var2x.getPSDevSlnName() + StringHelper.format("_%1$s", new Random().nextInt(9999999)));
                  var2x.setCodeName(var2x.getCodeName() + StringHelper.format("_%1$s", new Random().nextInt(9999999)));
                  var2x.setPSDevCenterId(var5.getPSDevCenterId());
                  var2x.setPSDevCenterName(var5.getPSDevCenterName());
                  var4x.sysUpdate(var2x, false);
               }

               if (var3x != null) {
                  PSDCSysLicService var5x = (PSDCSysLicService)ServiceGlobal.getService(PSDCSysLicService.class, PSDevSlnSysService.this.getSessionFactory());
                  var5x.mergeChild(null, null, var3x.getPSDCSysLicId());
               }
            }
         });
      }
   }

   @Override
   protected void onBindSysModel(PSDevSlnSys var1) throws Exception {
      this.get(var1);
      if (DataObject.getIntegerValue(var1.getDevSysState(), 30) != 20) {
         throw new Exception(
            StringHelper.format(
               "开发系统[%1$s]当前状态[%2$s]，无法绑定系统模型",
               var1.getPSDevSlnSysName(),
               DevSysStateCodeListModel.getInstance().getCodeItem(var1.getDevSysState().toString()).getText()
            )
         );
      }

      this.fillPSSysModelInst(var1);
      var1.setDevSysState(30);
      this.internalUpdate(var1);
      this.onRebindSystem(var1);
   }

   @Override
   protected void onCreateAsync(PSDevSlnSys var1) throws Exception {
      var1.setDevSysState(20);
      this.create(var1);
   }

   @Override
   protected void onGetCur(PSDevSlnSys var1) throws Exception {
      JSONObject var2 = WebContext.getAppData();
      if (var2 == null) {
         throw new Exception(StringHelper.format("上下文数据无效"));
      }

      String var3 = var2.optString("psdevslnsysid");
      var1.setPSDevSlnSysId(var3);
      this.get(var1);
   }

   protected void syncSharePSSysModelInst(PSDevSlnSys var1) throws Exception {
   }

   protected void syncPSDevSlnSysRefs(PSDevSlnSys var1) throws Exception {
      SessionFactory var2 = PSSysModelInstGlobal.getSessionFactory(var1.getPSSysModelInst());
      PSSysAppService var3 = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, var2);
      PSSysSFPubService var4 = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, var2);
      PSSysServiceAPIService var5 = (PSSysServiceAPIService)ServiceGlobal.getService(PSSysServiceAPIService.class, var2);
      PSDevSlnSysAppService var6 = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, this.getSessionFactory());
      PSDevSlnSysSrvService var7 = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, this.getSessionFactory());
      PSDevSlnSysAPIService var8 = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, this.getSessionFactory());
      PSDevSlnMSDepAppService var9 = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, this.getSessionFactory());
      PSDevSlnMSDepAPIService var10 = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, this.getSessionFactory());
      PSDevSlnMSDepFuncItemService var11 = (PSDevSlnMSDepFuncItemService)ServiceGlobal.getService(PSDevSlnMSDepFuncItemService.class, this.getSessionFactory());
      PSDevSlnTemplService var12 = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, this.getSessionFactory());
      PSDevSlnSysRefService var13 = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, this.getSessionFactory());
      PSDevSlnSysRefLinkService var14 = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, this.getSessionFactory());
      PSDevSlnPipelineStepService var15 = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, this.getSessionFactory());
      ArrayList<PSDevSlnSysApp> var16 = var6.selectByPSDevSlnSys(var1);
      ArrayList<PSDevSlnSysSrv> var17 = var7.selectByPSDevSlnSys(var1);
      ArrayList<PSDevSlnSysAPI> var18 = var8.selectByPSDevSlnSys(var1);
      HashMap<String, PSDevSlnSysApp> var19 = new HashMap<>();

      for (PSDevSlnSysApp var21 : var16) {
         var19.put(var21.getPSDevSlnSysAppId(), var21);
      }

      HashMap<String, PSDevSlnSysSrv> var42 = new HashMap<>();

      for (PSDevSlnSysSrv var22 : var17) {
         var42.put(var22.getPSDevSlnSysSrvId(), var22);
      }

      HashMap<String, PSDevSlnSysAPI> var44 = new HashMap<>();

      for (PSDevSlnSysAPI var23 : var18) {
         var44.put(var23.getPSDevSlnSysAPIId(), var23);
      }

      ArrayList<PSDevSlnSysApp> var46 = new ArrayList<>();
      PSSystem var47 = new PSSystem();
      var47.setPSSystemId(var1.getPSSystemId());

      for (PSSysApp var26 : var3.selectByPSSystem(var47)) {
         PSDevSlnSysApp var27 = new PSDevSlnSysApp();
         var26.copyTo(var27, false);
         var27.setValidFlag(1);
         var27.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         var27.setPSDevSlnSysAppName(var26.getPSSysAppName());
         var6.save(var27, false);
         if (var19.size() > 0) {
            PSDevSlnSysApp var28 = (PSDevSlnSysApp)var19.remove(var27.getPSDevSlnSysAppId());
            if (var28 == null) {
               var46.add(var27);
            }
         }
      }

      if (var19.size() > 0) {
         for (PSDevSlnSysApp var51 : var46) {
            for (Entry var60 : var19.entrySet()) {
               if (StringHelper.compare(var51.getAppPKGName(), ((PSDevSlnSysApp)var60.getValue()).getAppPKGName(), true) == 0) {
                  PSDevSlnSysApp var29 = (PSDevSlnSysApp)var60.getValue();
                  var19.remove(var60.getKey());

                  for (PSDevSlnMSDepApp var32 : var29.getPSDevSlnMSDepApps()) {
                     PSDevSlnMSDepApp var33 = new PSDevSlnMSDepApp();
                     var33.setPSDevSlnMSDepAppId(var32.getPSDevSlnMSDepAppId());
                     var33.setPSDevSlnSysAppId(var51.getPSDevSlnSysAppId());
                     var9.sysUpdate(var33, false);
                  }

                  for (PSDevSlnMSDepFuncItem var86 : var29.getPSDevSlnMSDepFuncItems()) {
                     PSDevSlnMSDepFuncItem var34 = new PSDevSlnMSDepFuncItem();
                     var34.setPSDevSlnMSDepFuncItemId(var86.getPSDevSlnMSDepFuncItemId());
                     var34.setPSDevSlnSysAppId(var51.getPSDevSlnSysAppId());
                     var11.sysUpdate(var34, false);
                  }

                  for (PSDevSlnTempl var92 : var29.getPSDevSlnTempls()) {
                     PSDevSlnTempl var35 = new PSDevSlnTempl();
                     var35.setPSDevSlnTemplId(var92.getPSDevSlnTemplId());
                     var35.setPSDevSlnSysAppId(var51.getPSDevSlnSysAppId());
                     var12.sysUpdate(var35, false);
                  }

                  for (PSDevSlnPipelineStep var98 : var29.getPSDevSlnPipelineSteps()) {
                     PSDevSlnPipelineStep var36 = new PSDevSlnPipelineStep();
                     var36.setPSDevSlnPipelineStepId(var98.getPSDevSlnPipelineStepId());
                     var36.setPSDevSlnSysAppId(var51.getPSDevSlnSysAppId());
                     var15.sysUpdate(var36, false);
                  }

                  var6.remove(var29);
                  break;
               }
            }
         }

         for (Entry var52 : var19.entrySet()) {
            if (DataObject.getBoolValue(((PSDevSlnSysApp)var52.getValue()).getValidFlag(), true)) {
               PSDevSlnSysApp var55 = new PSDevSlnSysApp();
               var55.setPSDevSlnSysAppId((String)var52.getKey());
               var55.setValidFlag(0);
               var6.sysUpdate(var55, false);
            }
         }
      }

      ArrayList<PSDevSlnSysSrv> var50 = new ArrayList<>();

      for (PSSysSFPub var61 : var4.selectByPSSystem(var47)) {
         PSDevSlnSysSrv var65 = new PSDevSlnSysSrv();
         var61.copyTo(var65, false);
         var65.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         var65.setPSDevSlnSysSrvName(var61.getPSSysSFPubName());
         var65.setValidFlag(1);
         var7.save(var65, false);
         if (var42.size() > 0) {
            PSDevSlnSysSrv var71 = (PSDevSlnSysSrv)var42.remove(var65.getPSDevSlnSysSrvId());
            if (var71 == null) {
               var50.add(var65);
            }
         }
      }

      if (var42.size() > 0) {
         for (PSDevSlnSysSrv var62 : var50) {
            for (Entry var72 : var42.entrySet()) {
               if (StringHelper.compare(var62.getCodeName(), ((PSDevSlnSysSrv)var72.getValue()).getCodeName(), true) == 0
                  && StringHelper.compare(var62.getPKGCodeName(), ((PSDevSlnSysSrv)var72.getValue()).getPKGCodeName(), true) == 0) {
                  PSDevSlnSysSrv var77 = (PSDevSlnSysSrv)var72.getValue();
                  var42.remove(var72.getKey());

                  for (PSDevSlnSysRef var94 : var77.getPSDevSlnSysRefs()) {
                     PSDevSlnSysRef var99 = new PSDevSlnSysRef();
                     var99.setPSDevSlnSysRefId(var94.getPSDevSlnSysRefId());
                     var99.setRefPSDevSlnSysSrvId(var62.getPSDevSlnSysSrvId());
                     var13.sysUpdate(var99, false);
                  }

                  for (PSDevSlnSysRefLink var100 : var77.getPSDevSlnSysRefLinks()) {
                     PSDevSlnSysRefLink var104 = new PSDevSlnSysRefLink();
                     var104.setPSDevSlnSysRefLinkId(var100.getPSDevSlnSysRefLinkId());
                     var104.setPSDevSlnSysSrvId(var62.getPSDevSlnSysSrvId());
                     var14.sysUpdate(var104, false);
                  }

                  for (PSDevSlnTempl var105 : var77.getPSDevSlnTempls()) {
                     PSDevSlnTempl var37 = new PSDevSlnTempl();
                     var37.setPSDevSlnTemplId(var105.getPSDevSlnTemplId());
                     var37.setPSDevSlnSysSrvId(var62.getPSDevSlnSysSrvId());
                     var12.sysUpdate(var37, false);
                  }

                  for (PSDevSlnPipelineStep var109 : var77.getPSDevSlnPipelineSteps()) {
                     PSDevSlnPipelineStep var38 = new PSDevSlnPipelineStep();
                     var38.setPSDevSlnPipelineStepId(var109.getPSDevSlnPipelineStepId());
                     var38.setPSDevSlnSysSrvId(var62.getPSDevSlnSysSrvId());
                     var15.sysUpdate(var38, false);
                  }

                  var7.remove(var77);
                  break;
               }
            }
         }

         for (Entry var63 : var42.entrySet()) {
            if (DataObject.getBoolValue(((PSDevSlnSysSrv)var63.getValue()).getValidFlag(), true)) {
               PSDevSlnSysSrv var67 = new PSDevSlnSysSrv();
               var67.setPSDevSlnSysSrvId((String)var63.getKey());
               var67.setValidFlag(0);
               var7.sysUpdate(var67, false);
            }
         }
      }

      ArrayList<PSDevSlnSysAPI> var59 = new ArrayList<>();

      for (PSSysServiceAPI var73 : var5.selectByPSSystem(var47)) {
         PSDevSlnSysAPI var78 = new PSDevSlnSysAPI();
         var73.copyTo(var78, false);
         var78.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         var78.setPSDevSlnSysAPIName(var73.getPSSysServiceAPIName());
         var8.save(var78, false);
         if (var44.size() > 0) {
            PSDevSlnSysAPI var84 = (PSDevSlnSysAPI)var44.remove(var78.getPSDevSlnSysAPIId());
            if (var84 == null) {
               var59.add(var78);
            }
         }
      }

      if (var44.size() > 0) {
         for (PSDevSlnSysAPI var74 : var59) {
            for (Entry var85 : var44.entrySet()) {
               if (StringHelper.compare(var74.getPSSysServiceAPIName(), ((PSDevSlnSysAPI)var85.getValue()).getPSSysServiceAPIName(), true) == 0) {
                  PSDevSlnSysAPI var91 = (PSDevSlnSysAPI)var85.getValue();
                  var44.remove(var85.getKey());
                  PSDevSlnSysAPI var97 = new PSDevSlnSysAPI();
                  var97.setPSDevSlnSysAPIId(var74.getPSDevSlnSysAPIId());
                  var97.setClientPSDevSlnSysId(var91.getClientPSDevSlnSysId());
                  var97.setClient2PSDevSlnSysId(var91.getClient2PSDevSlnSysId());
                  var97.setClientPSDevSlnSysName(var91.getClientPSDevSlnSysName());
                  var97.setClient2PSDevSlnSysName(var91.getClient2PSDevSlnSysName());
                  var8.sysUpdate(var97, false);

                  for (PSDevSlnSysRef var110 : var91.getPSDevSlnSysRefs()) {
                     PSDevSlnSysRef var113 = new PSDevSlnSysRef();
                     var113.setPSDevSlnSysRefId(var110.getPSDevSlnSysRefId());
                     var113.setRefPSDevSlnSysAPIId(var74.getPSDevSlnSysAPIId());
                     var13.sysUpdate(var113, false);
                  }

                  for (PSDevSlnMSDepAPI var114 : var91.getPSDevSlnMSDepAPIs()) {
                     PSDevSlnMSDepAPI var39 = new PSDevSlnMSDepAPI();
                     var39.setPSDevSlnMSDepAPIId(var114.getPSDevSlnMSDepAPIId());
                     var39.setPSDevSlnSysAPIId(var74.getPSDevSlnSysAPIId());
                     var10.sysUpdate(var39, false);
                  }

                  for (PSDevSlnMSDepFuncItem var117 : var91.getPSDevSlnMSDepFuncItems()) {
                     PSDevSlnMSDepFuncItem var40 = new PSDevSlnMSDepFuncItem();
                     var40.setPSDevSlnMSDepFuncItemId(var117.getPSDevSlnMSDepFuncItemId());
                     var40.setPSDevSlnSysAPIId(var74.getPSDevSlnSysAPIId());
                     var11.sysUpdate(var40, false);
                  }

                  for (PSDevSlnPipelineStep var119 : var91.getPSDevSlnPipelineSteps()) {
                     PSDevSlnPipelineStep var41 = new PSDevSlnPipelineStep();
                     var41.setPSDevSlnPipelineStepId(var119.getPSDevSlnPipelineStepId());
                     var41.setPSDevSlnSysAPIId(var74.getPSDevSlnSysAPIId());
                     var15.sysUpdate(var41, false);
                  }

                  var8.remove(var91);
                  break;
               }
            }
         }

         for (Entry var75 : var44.entrySet()) {
            if (DataObject.getBoolValue(((PSDevSlnSysAPI)var75.getValue()).getValidFlag(), true)) {
               PSDevSlnSysAPI var80 = new PSDevSlnSysAPI();
               var80.setPSDevSlnSysAPIId((String)var75.getKey());
               var80.setValidFlag(0);
               var8.sysUpdate(var80, false);
            }
         }
      }
   }

   protected boolean isUpdateModelKeeper(PSDevSlnSys var1) throws Exception {
      return PSCoreEntityKeeperGlobal.getCurrent(this.getSessionFactory()).isPSDevSlnSysEnabled();
   }

   protected void onUpdateModelKeeper(PSDevSlnSys var1) throws Exception {
      final String var2 = var1.getPSDevSlnSysId();
      SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction() {
         @Override
         public void commit() {
            try {
               PSDevSlnSys var1x = new PSDevSlnSys();
               var1x.setPSDevSlnSysId(var2);
               PSDevSlnSysService.this.get(var1x);
               PSCoreEntityKeeperGlobal.getCurrent(PSDevSlnSysService.this.getSessionFactory()).updatePSDevSlnSys(var1x);
            } catch (Exception var2x) {
               PSDevSlnSysService.log.error(var2x);
            }
         }

         @Override
         public void rollback() {
         }
      });
   }

   @Override
   protected void onOffline(PSDevSlnSys var1) throws Exception {
      this.get(var1);
      if (DataObject.getIntegerValue(var1.getDevSysState(), DevSysStateCodeListModel.ONLINE) != DevSysStateCodeListModel.ONLINE) {
         throw new Exception(StringHelper.format("开发系统未处于连线状态"));
      }

      PSDevCenterService var2 = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
      PSDevCenter var3 = new PSDevCenter();
      var3.setPSDevCenterId(var1.getPSDevCenterId());
      if (!var2.get(var3, true)) {
         throw new Exception(StringHelper.format("无法获取开发系统所属应用中心"));
      }

      boolean var4 = false;
      var4 = DataObject.getBoolValue(var3.getEnableWorkspace(), false);
      if (!var4) {
         throw new Exception("当前应用中心未启用生产线模式");
      }

      if (StringHelper.isNullOrEmpty(var1.getPSDCWorkspaceId())) {
         this.executeAction("X_ADDOFFLINESYSMODELTASK", var1);
      } else {
         PSDCWorkspaceService var5 = (PSDCWorkspaceService)ServiceGlobal.getService(
            PSDCWorkspaceService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
         );
         PSDCWorkspace var6 = new PSDCWorkspace();
         var6.setPSDCWorkspaceId(var1.getPSDCWorkspaceId());
         var6.setPSDevSlnSysId(var1.getPSDevSlnSysId());
         var6.setPSDevSlnSysName(var1.getPSDevSlnSysName());
         var5.uninstallSys(var6);
      }
   }

   protected void syncPSPFStyle(String var1, SessionFactory var2) throws Exception {
      PSPFStyleService var3 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, var2);
      PSPFStyle var4 = new PSPFStyle();
      var4.setPSPFStyleId(var1);
      if (!var3.get(var4, true)) {
         PSPFStyleService var5 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         PSPFStyle var6 = new PSPFStyle();
         var6.setPSPFStyleId(var1);
         if (!var5.get(var6, true)) {
            if (isCloudMode()) {
               log.error(StringHelper.format("无法获取指定前台模板样式[%1$s]，忽略同步", var1));
            } else {
               throw new Exception(StringHelper.format("无法获取指定前台模板样式[%1$s]", var1));
            }
         } else {
            PSPFService var7 = (PSPFService)ServiceGlobal.getService(PSPFService.class, var2);
            PSPF var8 = new PSPF();
            var8.setPSPFId(var6.getPSPFId());
            if (!var7.get(var8, true)) {
               PSPFService var9 = (PSPFService)ServiceGlobal.getService(PSPFService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
               PSPF var10 = new PSPF();
               var10.setPSPFId(var6.getPSPFId());
               if (!var9.get(var10, true)) {
                  throw new Exception(StringHelper.format("无法获取指定前台模板[%1$s]", var6.getPSPFId()));
               }

               PSAppTypeService var11 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
               PSAppType var12 = new PSAppType();
               var12.setPSAppTypeId(var10.getPSAppTypeId());
               if (!var11.get(var12, true)) {
                  throw new Exception(StringHelper.format("无法获取指定前台模板[%1$s]", var6.getPSPFId()));
               }

               PSAppTypeService var13 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, var2);
               var13.save(var12, false);
               var8.setPSAppTypeId(var12.getPSAppTypeId());
               var8.setPSAppTypeName(var12.getPSAppTypeName());
               var8.setPSPFId(var10.getPSPFId());
               var8.setPSPFName(var10.getPSPFName());
               var8.setValidFlag(1);
               var7.create(var8);
            }

            var4.setPSPFStyleId(var6.getPSPFStyleId());
            var4.setPSPFStyleName(var6.getPSPFStyleName());
            var4.setPSPFId(var6.getPSPFId());
            var4.setPSPFName(var6.getPSPFName());
            var4.setStyleCode(var6.getStyleCode());
            var4.setStyleEngine(var6.getStyleEngine());
            var3.create(var4);
         }
      }
   }

   protected void syncPSSFStyle2(String var1, SessionFactory var2) throws Exception {
      PSSFStyleService var3 = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, var2);
      PSSFStyle var4 = new PSSFStyle();
      var4.setPSSFStyleId(var1);
      if (!var3.get(var4, true)) {
         PSSFStyleService var5 = (PSSFStyleService)ServiceGlobal.getService(PSSFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         PSSFStyle var6 = new PSSFStyle();
         var6.setPSSFStyleId(var1);
         if (!var5.get(var6, true)) {
            if (isCloudMode()) {
               log.error(StringHelper.format("无法获取指定后台模板样式[%1$s]，忽略同步", var1));
            } else {
               throw new Exception(StringHelper.format("无法获取指定后台模板样式[%1$s]", var1));
            }
         } else {
            PSSFService var7 = (PSSFService)ServiceGlobal.getService(PSSFService.class, var2);
            PSSF var8 = new PSSF();
            var8.setPSSFId(var6.getPSSFId());
            if (!var7.get(var8, true)) {
               PSSFService var9 = (PSSFService)ServiceGlobal.getService(PSSFService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
               PSSF var10 = new PSSF();
               var10.setPSSFId(var6.getPSSFId());
               if (!var9.get(var10, true)) {
                  throw new Exception(StringHelper.format("无法获取指定后台模板[%1$s]", var6.getPSSFId()));
               }

               var8.setPSSFId(var10.getPSSFId());
               var8.setPSSFName(var10.getPSSFName());
               var8.setCodeFlag(var10.getCodeFlag());
               var8.setDocFlag(var10.getDocFlag());
               var8.setValidFlag(1);
               var7.create(var8);
            }

            var4.setPSSFStyleId(var6.getPSSFStyleId());
            var4.setPSSFStyleName(var6.getPSSFStyleName());
            var4.setPSSFId(var6.getPSSFId());
            var4.setPSSFName(var6.getPSSFName());
            var4.setStyleEngine(var6.getStyleEngine());
            var3.create(var4);
         }
      }
   }

   protected void syncPSSFStyleVer(String var1, SessionFactory var2) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1)) {
         PSSFStyleVerService var3 = (PSSFStyleVerService)ServiceGlobal.getService(PSSFStyleVerService.class, var2);
         PSSFStyleVer var4 = new PSSFStyleVer();
         var4.setPSSFStyleVerId(var1);
         if (!var3.get(var4, true)) {
            PSSFStyleVerService var5 = (PSSFStyleVerService)ServiceGlobal.getService(
               PSSFStyleVerService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
            );
            PSSFStyleVer var6 = new PSSFStyleVer();
            var6.setPSSFStyleVerId(var1);
            if (!var5.get(var6, true)) {
               if (isCloudMode()) {
                  log.error(StringHelper.format("无法获取指定后台模板样式版本[%1$s]，忽略同步", var1));
               } else {
                  throw new Exception(StringHelper.format("无法获取指定后台模板样式版本[%1$s]", var1));
               }
            } else {
               var4.setPSSFStyleVerId(var6.getPSSFStyleVerId());
               var4.setPSSFStyleVerName(var6.getPSSFStyleVerName());
               var4.setPSSFId(var6.getPSSFId());
               var4.setPSSFStyleId(var6.getPSSFStyleId());
               var4.setPSSFStyleName(var6.getPSSFStyleName());
               var3.create(var4);
            }
         }
      }
   }

   protected void internalCreate(PSDevSlnSys var1) throws Exception {
      if (PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory())
         && StringHelper.isNullOrEmpty(var1.getPSDevCenterSVNId())
         && StringHelper.isNullOrEmpty(var1.getModelPSDevCenterSVNId())
         && isEnableGitLabPlugin()) {
         PSDevSln var2 = var1.getPSDevSln();
         if (var2 == null) {
            throw new Exception("系统开发方案无效");
         }

         PSDevCenter var3 = var2.getPSDevCenter();
         if (var3 == null) {
            throw new Exception("系统应用中心无效");
         }

         if (var3.getV6PSSvnInstRepo() != null) {
            PSDevSlnSys var4 = null;
            String var5 = null;
            String var6 = "";
            if (isCloudMode()) {
               if (!StringHelper.isNullOrEmpty(var1.getPPSDevSlnSysId())) {
                  var4 = var1.getPPSDevSlnSys();
               } else if (!StringHelper.isNullOrEmpty(var1.getMainPSDevSlnSysId())) {
                  var4 = var1.getMainPSDevSlnSys();
               }

               if (var4 != null) {
                  PSDevCenterSVN var7 = var4.getModelPSDevCenterSVN();
                  if (var7 != null && var7.getPSSVNInstRepo() != null) {
                     PSSVNServer var8 = var7.getPSSVNInstRepo().getPSSVNServer();
                     if (var8 != null) {
                        var5 = var8.getGITUserName();
                        var6 = var8.getGITPassword();
                        if (StringHelper.isNullOrEmpty(var6)) {
                           var6 = "";
                        }
                     }
                  }
               }
            }

            String var16 = var1.getSysFolder();
            var1.set("importurl", var16);
            if (var4 != null) {
               PSDevCenterSVN var17 = var4.getModelPSDevCenterSVN();
               if (var17 != null) {
                  var1.set("importurl", var17.getGitPath());
                  if (!StringHelper.isNullOrEmpty(var5)) {
                     String var9 = var17.getGitPath();
                     int var10 = var9.indexOf("//");
                     if (var10 != -1) {
                        String var11 = var9.substring(0, var10 + 2);
                        var11 = var11 + String.format("%1$s:%2$s@", var5, var6);
                        var11 = var11 + var9.substring(var10 + 2);
                        var1.set("importurl", var11);
                     }
                  }
               }
            }

            Project var18 = getPSGitLabPlugin().createModelProjectByPSDevSlnSys(var1);
            var1.setSysFolder(null);
            var1.set("importurl", null);
            if (var4 != null) {
               PSDevCenterSVN var19 = var4.getPSDevCenterSVN();
               if (var19 != null) {
                  var1.set("importurl", var19.getGitPath());
                  if (!StringHelper.isNullOrEmpty(var5)) {
                     String var21 = var19.getGitPath();
                     int var26 = var21.indexOf("//");
                     if (var26 != -1) {
                        String var12 = var21.substring(0, var26 + 2);
                        var12 = var12 + String.format("%1$s:%2$s@", var5, var6);
                        var12 = var12 + var21.substring(var26 + 2);
                        var1.set("importurl", var12);
                     }
                  }
               }
            }

            Project var20 = getPSGitLabPlugin().createCodeProjectByPSDevSlnSys(var1);
            var1.set("importurl", null);
            if (var4 != null) {
               PSDevCenterSVN var22 = var4.getRTModelPSDevCenterSVN();
               if (var22 != null) {
                  var1.set("importurl", var22.getGitPath());
                  if (!StringHelper.isNullOrEmpty(var5)) {
                     String var27 = var22.getGitPath();
                     int var32 = var27.indexOf("//");
                     if (var32 != -1) {
                        String var13 = var27.substring(0, var32 + 2);
                        var13 = var13 + String.format("%1$s:%2$s@", var5, var6);
                        var13 = var13 + var27.substring(var32 + 2);
                        var1.set("importurl", var13);
                     }
                  }
               }
            }

            Project var23 = getPSGitLabPlugin().createRuntimeProjectByPSDevSlnSys(var1);
            var1.set("importurl", null);
            if (var4 != null) {
               PSDevCenterSVN var28 = var4.getDocPSDevCenterSVN();
               if (var28 != null) {
                  var1.set("importurl", var28.getGitPath());
                  if (!StringHelper.isNullOrEmpty(var5)) {
                     String var33 = var28.getGitPath();
                     int var37 = var33.indexOf("//");
                     if (var37 != -1) {
                        String var14 = var33.substring(0, var37 + 2);
                        var14 = var14 + String.format("%1$s:%2$s@", var5, var6);
                        var14 = var14 + var33.substring(var37 + 2);
                        var1.set("importurl", var14);
                     }
                  }
               }
            }

            Project var29 = getPSGitLabPlugin().createDocProjectByPSDevSlnSys(var1);
            var1.set("importurl", null);
            PSDevCenterSVN var34 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var20);
            PSDevCenterSVN var38 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var18);
            PSDevCenterSVN var41 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var23);
            PSDevCenterSVN var15 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var29);
            var1.setPSDevCenterSVNId(var34.getPSDevCenterSVNId());
            var1.setPSDevCenterSVNName(var34.getPSDevCenterSVNName());
            var1.setModelPSDevCenterSVNId(var38.getPSDevCenterSVNId());
            var1.setModelPSDevCenterSVNName(var38.getPSDevCenterSVNName());
            var1.setDocPSDevCenterSVNId(var15.getPSDevCenterSVNId());
            var1.setDocPSDevCenterSVNName(var15.getPSDevCenterSVNName());
            if (!isCloudMode()) {
               var1.setRTModelPSDevCenterSVNId(var41.getPSDevCenterSVNId());
               var1.setRTModelPSDevCenterSVNName(var41.getPSDevCenterSVNName());
            }
         }
      }

      super.internalCreate(var1);
   }

   @Override
   public void executeAction(String var1, IEntity var2) throws Exception {
      if (this.isMajorSessionFactory()) {
         final String var3 = var1;
         final IEntity var4 = var2;
         this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               PSDevSlnSysService.this.onTestSysAction(var3, var4);
            }
         });
      }

      super.executeAction(var1, var2);
   }

   protected void onTestSysAction(String var1, IEntity var2) throws Exception {
      if (StringHelper.compare(var1, "X_ADDBACKUPSYSMODELTASK", false) == 0) {
         PSDevSlnSys var3 = new PSDevSlnSys();
         var2.copyTo(var3, false);
         this.get(var3);
         if (StringHelper.compare(var1, "X_ADDBACKUPSYSMODELTASK", false) == 0) {
            PSDevCenterHelper.testCreate(var3.getPSDevSln().getPSDevCenter(), "SYSBAKCNT", false);
         }
      }
   }

   @Override
   protected void onFixPSDCSVNs(PSDevSlnSys var1) throws Exception {
      if (this.isMajorSessionFactory()) {
         if (isEnableGitLabPlugin()) {
            this.get(var1);
            PSDevSln var2 = var1.getPSDevSln();
            if (var2 == null) {
               throw new Exception("系统开发方案无效");
            }

            PSDevCenter var3 = var2.getPSDevCenter();
            if (var3 == null) {
               throw new Exception("系统应用中心无效");
            }

            if (var3.getV6PSSvnInstRepo() != null) {
               boolean var4 = false;
               PSDevSlnSys var5 = new PSDevSlnSys();
               var5.setPSDevSlnSysId(var1.getPSDevSlnSysId());
               if (StringHelper.isNullOrEmpty(var1.getModelPSDevCenterSVNId())) {
                  Project var6 = getPSGitLabPlugin().createModelProjectByPSDevSlnSys(var1);
                  PSDevCenterSVN var7 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var6);
                  var5.setModelPSDevCenterSVNId(var7.getPSDevCenterSVNId());
                  var5.setModelPSDevCenterSVNName(var7.getPSDevCenterSVNName());
                  var4 = true;
               }

               if (StringHelper.isNullOrEmpty(var1.getRTModelPSDevCenterSVNId())) {
                  Project var8 = getPSGitLabPlugin().createRuntimeProjectByPSDevSlnSys(var1);
                  PSDevCenterSVN var10 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var8);
                  var5.setRTModelPSDevCenterSVNId(var10.getPSDevCenterSVNId());
                  var5.setRTModelPSDevCenterSVNName(var10.getPSDevCenterSVNName());
                  var4 = true;
               }

               if (StringHelper.isNullOrEmpty(var1.getDocPSDevCenterSVNId())) {
                  Project var9 = getPSGitLabPlugin().createDocProjectByPSDevSlnSys(var1);
                  PSDevCenterSVN var11 = PSGitLabHelper.createPSDevCenterSVN(var3, var2, var9);
                  var5.setDocPSDevCenterSVNId(var11.getPSDevCenterSVNId());
                  var5.setDocPSDevCenterSVNName(var11.getPSDevCenterSVNName());
                  var4 = true;
               }

               if (var4) {
                  this.sysUpdate(var5, false);
               }
            }
         }
      }
   }

   @Override
   public void rawOffline(PSDevSlnSys var1) throws Exception {
      this.get(var1);
      if (!StringHelper.isNullOrEmpty(var1.getPSSysModelInstId())) {
         PSSysModelInstService var2 = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, this.getSessionFactory());
         PSSysModelInst var3 = new PSSysModelInst();
         var3.setPSSysModelInstId(var1.getPSSysModelInstId());
         var3.setInstState("35");
         var2.update(var3);
      }

      if (!StringHelper.isNullOrEmpty(var1.getPSDCWorkspaceId())) {
         PSDCWorkspaceService var7 = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, this.getSessionFactory());
         PSWorkspaceService var9 = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, this.getSessionFactory());
         PSDCWorkspace var4 = new PSDCWorkspace();
         var4.setPSDCWorkspaceId(var1.getPSDCWorkspaceId());
         if (var7.get(var4, true)) {
            PSWorkspace var5 = new PSWorkspace();
            var5.setPSWorkspaceId(var5.getPSWorkspaceId());
            if (var9.get(var5, true)) {
               PSWorkspace var6 = new PSWorkspace();
               var6.setPSWorkspaceId(var5.getPSWorkspaceId());
               var6.setCurAction(null);
               var6.setActionOwner(null);
               var9.sysUpdate(var6, false);
            }

            PSDCWorkspace var10 = new PSDCWorkspace();
            var10.setPSDCWorkspaceId(var4.getPSDCWorkspaceId());
            var10.setPSDevSlnSysId(null);
            var7.sysUpdate(var10, false);
         }
      }

      PSDevSlnSys var8 = new PSDevSlnSys();
      var8.setPSDevSlnSysId(var1.getPSDevSlnSysId());
      var8.setDevSysState(35);
      var8.setCurAction("NONE");
      var8.setPSDCWorkspaceId(null);
      var8.setActionOwner(null);
      EntityBase.setLastUpdateDate(var8, var1.getUpdateDate());
      this.sysUpdate(var8, true);
      PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(var8);
   }

   static {
      psResStateLevelMap.put(40, 100);
      psResStateLevelMap.put(41, 90);
      psResStateLevelMap.put(42, 80);
      psResStateLevelMap.put(10, 60);
      psResStateLevelMap.put(11, 50);
      psResStateLevelMap.put(20, 0);
   }
}
