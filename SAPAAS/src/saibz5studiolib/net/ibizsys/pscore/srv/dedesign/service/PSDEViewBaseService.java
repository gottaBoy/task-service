package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewEngine;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFDE;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEViewBaseService extends PSDEViewBaseServiceBase implements IPSModelService<PSDEViewBase> {
   private static final Log log = LogFactory.getLog(PSDEViewBaseService.class);
   private static final String[] initViewTypes = new String[]{
      "DEEDITVIEW",
      "DEEDITVIEW2",
      "DEGRIDVIEW",
      "DEINDEXPICKUPDATAVIEW",
      "DEFORMPICKUPDATAVIEW",
      "DEPICKUPGRIDVIEW",
      "DEPICKUPVIEW",
      "DEMPICKUPVIEW",
      "DEREDIRECTVIEW"
   };
   private static final String[] initMobViewTypes = new String[]{
      "DEMOBEDITVIEW",
      "DEMOBMDVIEW",
      "DEMOBINDEXPICKUPMDVIEW",
      "DEMOBFORMPICKUPMDVIEW",
      "DEMOBPICKUPMDVIEW",
      "DEMOBPICKUPVIEW",
      "DEMOBMPICKUPVIEW",
      "DEMOBREDIRECTVIEW"
   };
   private static final String[] initWFViewTypes = new String[]{"DEWFEXPVIEW", "DEWFGRIDVIEW", "DEWFEDITVIEW3"};
   private static final String[] initMobWFViewTypes = new String[]{"DEMOBWFMDVIEW", "DEMOBWFEDITVIEW"};
   private static final String[] initMSViewTypes = new String[]{"DEEDITVIEW3"};
   protected static final String LOGNAME_INITWFVIEW = "初始化流程视图";
   public static final String XMLNODE_DEVIEWCONFIG = "DEVIEWCONFIG";
   public static final String XMLNODE_DEVIEWCTRL = "DEVIEWCTRL";
   public static final String XMLNODE_DEVIEWRV = "DEVIEWRV";
   public static final String XMLNODE_DEVIEWLOGIC = "DEVIEWLOGIC";
   public static final String XMLNODE_DEVIEWENGINE = "DEVIEWENGINE";

   @Override
   protected void onFillParentInfo_PSDE(PSDEViewBase var1, PSDataEntity var2) throws Exception {
      super.onFillParentInfo_PSDE(var1, var2);
      var1.setPSSystemId(var2.getPSSystemId());
      var1.setPSSystemName(var2.getPSSystemName());
   }

   protected void onAfterGetDraftTemp(PSDEViewBase var1) throws Exception {
      String var2 = var1.getPSDEViewBaseType();
      PSViewType var3 = new PSViewType();
      var3.setPSViewTypeId(var2);
      PSViewTypeService var4 = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class);
      var4.getCache(var3);
      if (var1.getPSDE() != null) {
         if (StringHelper.isNullOrEmpty(var1.getPSDEViewBaseName())) {
            var1.setPSDEViewBaseName(StringHelper.format("%1$s%2$s", var1.getPSDE().getLogicName(), var3.getPSViewTypeName()));
         }

         if (StringHelper.isNullOrEmpty(var1.getTitle()) && !StringHelper.isNullOrEmpty(var3.getTitle())) {
            var1.setTitle(StringHelper.format("%1$s%2$s", var1.getPSDE().getLogicName(), var3.getTitle()));
         }
      }

      if (StringHelper.isNullOrEmpty(var1.getCodeName())) {
         var1.setCodeName(var3.getCodeName());
      }

      PSDEViewRVService var5 = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, this.getSessionFactory());
      PSDEViewCtrlService var6 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());
      PSDataEntity var7 = var1.getPSDE();
      PSViewTypeStruct var8 = PSModelGlobal.getPSViewType(var2);

      for (PSVTRV var11 : var3.getPSVTRVs()) {
         if (DataObject.getBoolValue(var11.getValidFlag(), true) && DataObject.getBoolValue(var11.getDefaultFlag(), true)) {
            PSDEViewRV var12 = new PSDEViewRV();
            var12.setMajorPSDEViewId(var1.getPSDEViewBaseId());
            var12.setMajorPSDEViewName(var1.getPSDEViewBaseName());
            var12.setPSDEViewRVName(var11.getPSVTRVName());
            if (var5.checkKeyTemp(var12) == 0) {
               var12.setDefViewType(var11.getDEFViewType());
               var12.setMemo(var11.getMemo());
               var12.setRefModeText(var11.getLogicName());
               if (var7 != null) {
                  this.fillDEViewRV(var12, var7.getPSSystem(), var7, var8, var1, var11, null, null);
               }

               var5.createTemp(var12);
            }
         }
      }

      for (PSVTCtrl var16 : var3.getPSVTCtrls()) {
         if (DataObject.getBoolValue(var16.getValidFlag(), true)) {
            PSDEViewCtrl var13 = new PSDEViewCtrl();
            var13.setPSDEViewBaseId(var1.getPSDEViewBaseId());
            var13.setPSDEViewBaseName(var1.getPSDEViewBaseName());
            var13.setPSDEViewCtrlName(var16.getPSVTCtrlName());
            var13.setPSDEViewCtrlType(var16.getCtrlType());
            if (var16.getDefaultFlag() != null) {
               var13.setDefaultFlag(var16.getDefaultFlag());
            } else {
               var13.setDefaultFlag(1);
            }

            this.fillDEViewCtrlParams(var13, var16);
            if (var16.getOrderValue() != null) {
               var13.setOrderValue(var16.getOrderValue());
            }

            if (var16.getEnableViewActions() != null) {
               var13.setEnableViewActions(var16.getEnableViewActions());
            }

            if (var7 != null) {
               this.fillDEViewCtrl(var13, var7.getPSSystem(), var7, var8, var1, var16, null, null);
            }

            if (var6.checkKeyTemp(var13) == 0) {
               var6.createTemp(var13);
            }
         }
      }

      super.onAfterGetDraftTemp(var1);
   }

   @Override
   public void initModel(String var1, IEntity var2, String var3) throws Exception {
      if (StringHelper.compare(var1, "PSDATAENTITY", true) == 0) {
         PSDataEntity var4 = new PSDataEntity();
         var4.proxy(var2);
         PSDEInitCfg var5 = PSModelGlobal.getPSDEInitCfg(var4.getPSDataEntityId(), this.getSessionFactory());
         if (var5 == null || !DataObject.getBoolValue(var5.getIgnoreUIModel(), false)) {
            for (String var9 : initViewTypes) {
               PSViewTypeStruct var10 = PSModelGlobal.getPSViewType(var9);
               this.initDEView(var4, var10);
            }

            if (DataObject.getBoolValue(var4.getEnableMob(), false)) {
               for (String var14 : initMobViewTypes) {
                  PSViewTypeStruct var15 = PSModelGlobal.getPSViewType(var14);
                  this.initDEView(var4, var15);
               }
            }

            this.initDEWFViews(var4);
         }
      }
   }

   protected void initDEView(PSDataEntity var1, PSViewTypeStruct var2) throws Exception {
      if (StringHelper.compare(var2.getPSViewTypeId(), "DEINDEXPICKUPDATAVIEW", true) == 0) {
         String var7 = var1.getIndexDEType();
         if (!StringHelper.isNullOrEmpty(var7)) {
            this.initDEView(var1, var2, "INDEXDETYPE", var7, null, null, null);
         }
      } else if (StringHelper.compare(var2.getPSViewTypeId(), "DEFORMPICKUPDATAVIEW", true) == 0) {
         if (DataObject.getIntegerValue(var1.getEnaMultiForm(), 0) > 0) {
            this.initDEView(var1, var2, "FORMTYPE", "", null, null, null);
         }
      } else if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBINDEXPICKUPMDVIEW", true) == 0) {
         String var6 = var1.getIndexDEType();
         if (!StringHelper.isNullOrEmpty(var6)) {
            this.initDEView(var1, var2, "INDEXDETYPE", var6, null, null, null);
         }
      } else if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBFORMPICKUPMDVIEW", true) == 0) {
         if (DataObject.getIntegerValue(var1.getEnaMultiForm(), 0) > 0) {
            this.initDEView(var1, var2, "FORMTYPE", "", null, null, null);
         }
      } else {
         String var3 = "";
         if (StringHelper.compare(var2.getPSViewTypeId(), "DEREDIRECTVIEW", true) == 0) {
            var3 = "REDIRECTVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEEDITVIEW", true) == 0) {
            var3 = "EDITVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEGRIDVIEW", true) == 0) {
            var3 = "MDATAVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEPICKUPVIEW", true) == 0) {
            var3 = "PICKUPVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMPICKUPVIEW", true) == 0) {
            var3 = "MPICKUPVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBREDIRECTVIEW", true) == 0) {
            var3 = "MOBREDIRECTVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBEDITVIEW", true) == 0) {
            var3 = "MOBEDITVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBMDVIEW", true) == 0) {
            var3 = "MOBMDATAVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBPICKUPVIEW", true) == 0) {
            var3 = "MOBPICKUPVIEW";
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBMPICKUPVIEW", true) == 0) {
            var3 = "MOBMPICKUPVIEW";
         }

         this.initDEView(var1, var2, "", "", null, var3, null);
         if (StringHelper.compare(var2.getPSViewTypeId(), "DEPICKUPVIEW", true) == 0) {
            String var4 = var1.getIndexDEType();
            if (!StringHelper.isNullOrEmpty(var4)) {
               PSDEViewBase var5 = new PSDEViewBase();
               var5.setPSDEViewBaseName(StringHelper.format("%1$s(索引实体)%2$s", var1.getLogicName(), var2.getPSViewTypeName()));
               if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
                  var5.setTitle(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getTitle()));
               }

               var5.setCodeName("Index" + var2.getCodeName());
               this.initDEView(var1, var2, "INDEXDETYPE", var4, var5, "INDEXDEPICKUPVIEW", null);
            }

            if (DataObject.getIntegerValue(var1.getEnaMultiForm(), 0) > 0) {
               PSDEViewBase var9 = new PSDEViewBase();
               var9.setPSDEViewBaseName(StringHelper.format("%1$s(表单类型)%2$s", var1.getLogicName(), var2.getPSViewTypeName()));
               if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
                  var9.setTitle(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getTitle()));
               }

               var9.setCodeName("Form" + var2.getCodeName());
               this.initDEView(var1, var2, "FORMTYPE", "", var9, "FORMPICKUPVIEW", null);
            }
         }

         if (StringHelper.compare(var2.getPSViewTypeId(), "DEMOBPICKUPVIEW", true) == 0) {
            String var8 = var1.getIndexDEType();
            if (!StringHelper.isNullOrEmpty(var8)) {
               PSDEViewBase var10 = new PSDEViewBase();
               var10.setPSDEViewBaseName(StringHelper.format("%1$s(索引实体)%2$s", var1.getLogicName(), var2.getPSViewTypeName()));
               if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
                  var10.setTitle(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getTitle()));
               }

               var10.setCodeName("MobIndex" + var2.getCodeName());
               this.initDEView(var1, var2, "INDEXDETYPE", var8, var10, "MOBINDEXDEPICKUPVIEW", null);
            }

            if (DataObject.getIntegerValue(var1.getEnaMultiForm(), 0) > 0) {
               PSDEViewBase var11 = new PSDEViewBase();
               var11.setPSDEViewBaseName(StringHelper.format("%1$s(表单类型)%2$s", var1.getLogicName(), var2.getPSViewTypeName()));
               if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
                  var11.setTitle(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getTitle()));
               }

               var11.setCodeName("MobForm" + var2.getCodeName());
               this.initDEView(var1, var2, "FORMTYPE", "", var11, "MOBFORMPICKUPVIEW", null);
            }
         }
      }
   }

   protected PSDEViewBase initDEView(PSDataEntity var1, PSViewTypeStruct var2, String var3, String var4, PSDEViewBase var5, String var6, String var7) throws Exception {
      boolean var8 = this.isEnableFolderKey(var1);
      PSDEViewBase var9 = new PSDEViewBase();
      boolean var10 = false;
      if (var8) {
         String var11 = "";
         if (StringHelper.isNullOrEmpty(var3)) {
            var11 = KeyValueHelper.genUniqueId(var2.getPSViewTypeId());
         } else {
            var11 = KeyValueHelper.genUniqueId(var2.getPSViewTypeId(), var3, var4);
         }

         var9.setDEViewTag(var11);
         var9.setPSDEId(var1.getPSDataEntityId());
         var10 = !this.selectOne(var9, true);
      } else {
         String var23 = "";
         if (StringHelper.isNullOrEmpty(var3)) {
            var23 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2.getPSViewTypeId());
         } else {
            var23 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2.getPSViewTypeId(), var3, var4);
         }

         var9.setPSDEViewBaseId(var23);
         if (this.get(var9, true)) {
            if (!StringHelper.isNullOrEmpty(var3)) {
               if (StringHelper.isNullOrEmpty(var9.getDEViewTag3())) {
                  var9.setDEViewTag3(var3);
                  var9.setDEViewTag4(var4);
                  this.update(var9);
               }
            } else if (!StringHelper.isNullOrEmpty(var9.getDEViewTag3())) {
               var9.setDEViewTag3(var3);
               var9.setDEViewTag4(var4);
               this.update(var9);
            }
         } else {
            var9.reset();
            SelectCond var12 = new SelectCond();
            var12.setFetchFirst(true);
            var12.set("PSDEID", var1.getPSDataEntityId());
            var12.set("PSDEVIEWBASETYPE", var2.getPSViewTypeId());
            if (StringHelper.isNullOrEmpty(var3)) {
               var12.setIsNull("DEVIEWTAG3");
               var12.setIsNull("DEVIEWTAG4");
            } else {
               var12.set("DEVIEWTAG3", var3);
               if (!StringHelper.isNullOrEmpty(var4)) {
                  var12.set("DEVIEWTAG4", var4);
               } else {
                  var12.setIsNull("DEVIEWTAG4");
               }
            }

            ArrayList var13 = this.select(var12);
            if (var13.size() != 0) {
               return (PSDEViewBase)var13.get(0);
            }

            String var14 = var2.getCodeName();
            if (var5 != null && !StringHelper.isNullOrEmpty(var5.getCodeName())) {
               var14 = var5.getCodeName();
            }

            if (!StringHelper.isNullOrEmpty(var14)) {
               var9.reset();
               var9.setPSDEId(var1.getPSDataEntityId());
               var9.setPSDEViewBaseType(var2.getPSViewTypeId());
               var9.setCodeName(var14);
               if (this.selectOne(var9, true)) {
                  return var9;
               }
            }

            var9.reset();
            var9.setPSDEViewBaseId(var23);
            var10 = true;
         }
      }

      if (var10) {
         var9.setPSSystemId(var1.getPSSystemId());
         var9.setPSDEId(var1.getPSDataEntityId());
         var9.setPSDEName(var1.getPSDataEntityName());
         var9.setPSDEViewBaseName(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getPSViewTypeName()));
         if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
            var9.setTitle(StringHelper.format("%1$s%2$s", var1.getLogicName(), var2.getTitle()));
         }

         var9.setPSDEViewBaseType(var2.getPSViewTypeId());
         var9.setCodeName(var2.getCodeName());
         if (var5 != null) {
            var5.copyTo(var9, false);
         }

         String var25 = var9.getCodeName();
         int var26 = 1;

         PSDEViewBase var27;
         do {
            if (var26 > 1) {
               var25 = StringHelper.format("Usr%1$s%2$s", var26 == 1 ? "" : var26, var9.getCodeName());
            }

            var26++;
            var27 = new PSDEViewBase();
            var27.setPSDEId(var1.getPSDataEntityId());
            var27.setCodeName(var25);
         } while (this.select(var27, true));

         var9.setCodeName(var25);
         if (!StringHelper.isNullOrEmpty(var6)) {
            var27 = new PSDEViewBase();
            var27.setPSDEId(var1.getPSDataEntityId());
            var27.setPredefinedViewType(var6);
            if (!StringHelper.isNullOrEmpty(var7)) {
               var27.setPDVTParam(var7);
            }

            if (!this.select(var27, true)) {
               var9.setPredefinedViewType(var6);
               var9.setPDVTParam(var7);
            }
         }

         var9.setDEViewTag3(var3);
         var9.setDEViewTag4(var4);

         try {
            this.create(var9);
         } catch (Exception var21) {
            throw new Exception(StringHelper.format("建立实体视图[%1$s]发生异常，%2$s", var9.getPSDEViewBaseName(), var21.getMessage()), var21);
         }

         PSSystem var29 = var1.getPSSystem();
         ArrayList<PSVTCtrl> var30 = var2.getPSVTCtrls();
         if (var30 != null) {
            for (PSVTCtrl var16 : var30) {
               if (DataObject.getBoolValue(var16.getValidFlag(), true)) {
                  try {
                     this.initDEViewCtrl(var29, var1, var2, var9, var16, var3, var4);
                  } catch (Exception var20) {
                     throw new Exception(
                        StringHelper.format("建立实体视图[%1$s]部件[%2$s]发生异常，%3$s", var9.getPSDEViewBaseName(), var16.getPSVTCtrlName(), var20.getMessage()), var20
                     );
                  }
               }
            }
         }

         ArrayList<PSVTRV> var31 = var2.getPSVTRVs();
         if (var31 != null) {
            for (PSVTRV var17 : var31) {
               if (DataObject.getBoolValue(var17.getValidFlag(), true) && DataObject.getBoolValue(var17.getDefaultFlag(), true)) {
                  try {
                     this.initDEViewRV(var29, var1, var2, var9, var17, var3, var4);
                  } catch (Exception var19) {
                     throw new Exception(
                        StringHelper.format("建立实体视图[%1$s]视图引用[%2$s]发生异常，%3$s", var9.getPSDEViewBaseName(), var17.getPSVTRVName(), var19.getMessage()), var19
                     );
                  }
               }
            }
         }
      }

      return var9;
   }

   protected void initDEViewCtrl(PSSystem var1, PSDataEntity var2, PSViewTypeStruct var3, PSDEViewBase var4, PSVTCtrl var5, String var6, String var7) throws Exception {
      if (DataObject.getBoolValue(var5.getValidFlag(), true)) {
         PSDEViewCtrl var8 = new PSDEViewCtrl();
         var8.setPSDEViewBaseId(var4.getPSDEViewBaseId());
         var8.setPSDEViewBaseName(var4.getPSDEViewBaseName());
         var8.setPSDEViewCtrlName(var5.getPSVTCtrlName());
         var8.setPSDEViewCtrlType(var5.getCtrlType());
         var8.setPSDEId(var4.getPSDEId());
         var8.setPSDEName(var4.getPSDEName());
         if (var5.getDefaultFlag() != null) {
            var8.setDefaultFlag(var5.getDefaultFlag());
         } else {
            var8.setDefaultFlag(1);
         }

         this.fillDEViewCtrlParams(var8, var5);
         if (var5.getOrderValue() != null) {
            var8.setOrderValue(var5.getOrderValue());
         }

         if (var5.getEnableViewActions() != null) {
            var8.setEnableViewActions(var5.getEnableViewActions());
         }

         this.fillDEViewCtrl(var8, var1, var2, var3, var4, var5, var6, var7);
         PSDEViewCtrlService var9 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());
         var9.create(var8);
         var9.update(var8);
      }
   }

   protected void fillDEViewCtrl(
      PSDEViewCtrl var1, PSSystem var2, PSDataEntity var3, PSViewTypeStruct var4, PSDEViewBase var5, PSVTCtrl var6, String var7, String var8
   ) throws Exception {
      if (StringHelper.compare(var6.getCtrlType(), "FORM", true) == 0) {
         boolean var16 = false;
         if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
            var16 = true;
         }

         String var18 = this.getPSDEEditFormId(var3, var16);
         if (!StringHelper.isNullOrEmpty(var18)) {
            var1.setPSDEFormId(var18);
         }

         if (!StringHelper.isNullOrEmpty(var6.getPSSysACHandlerId())) {
            var1.setPSACHandlerId(this.getPSACHandlerId(var6.getPSSysACHandlerId(), var2));
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "SEARCHFORM", true) == 0) {
         boolean var15 = false;
         if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
            var15 = true;
         }

         String var17 = this.getPSDESearchFormId(var3, var15);
         if (!StringHelper.isNullOrEmpty(var17)) {
            var1.setPSDEFormId(var17);
         }

         if (!StringHelper.isNullOrEmpty(var6.getPSSysACHandlerId())) {
            var1.setPSACHandlerId(this.getPSACHandlerId(var6.getPSSysACHandlerId(), var2));
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "GRID", true) == 0) {
         boolean var14 = false;
         if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
            var14 = true;
         }

         String var10 = this.getPSDEGridId(var3, var14);
         if (!StringHelper.isNullOrEmpty(var10)) {
            var1.setPSDEGridId(var10);
         }

         var1.setPSDEDataSetId(this.getPSDEDataSetId(var3));
         if (!StringHelper.isNullOrEmpty(var6.getPSSysACHandlerId())) {
            var1.setPSACHandlerId(this.getPSACHandlerId(var6.getPSSysACHandlerId(), var2));
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "TOOLBAR", true) == 0) {
         if (!StringHelper.isNullOrEmpty(var6.getPSSysToolbarId())) {
            var1.setPSDEToolbarId(this.getPSDEToolbarId(var6.getPSSysToolbarId(), var2));
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "PICKUPVIEWPANEL", true) == 0) {
         String var13 = this.getPSDEViewBaseId(var3, var4, var7, var8);
         if (!StringHelper.isNullOrEmpty(var13)) {
            var1.setPSDEViewId(var13);
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "DRBAR", true) == 0 || StringHelper.compare(var6.getCtrlType(), "DRTAB", true) == 0) {
         boolean var12 = false;
         if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
            var12 = true;
         }

         var1.setPSDEDRId(this.getPSDEDataRelationId(var3, var5, var12));
      } else if (StringHelper.compare(var6.getCtrlType(), "DATAVIEW", true) == 0) {
         var1.setPSDEDataViewId(this.getPSDEDataViewId(var3, var7, var8));
         var1.setPSDEDataSetId(this.getPSDEDataSetId(var3, var7, var8));
         if (StringHelper.isNullOrEmpty(var7)) {
            if (!StringHelper.isNullOrEmpty(var6.getPSSysACHandlerId())) {
               var1.setPSACHandlerId(this.getPSACHandlerId(var6.getPSSysACHandlerId(), var2));
            }
         } else {
            String var11 = "";
            if (StringHelper.compare(var7, "INDEXDETYPE", true) == 0) {
               var11 = "INDEXPICKUPDATAVIEWHANDLER";
            } else if (StringHelper.compare(var7, "FORMTYPE", true) == 0) {
               var11 = "FORMPICKUPDATAVIEWHANDLER";
            }

            var1.setPSACHandlerId(this.getPSACHandlerId(var11, var2));
         }
      } else if (StringHelper.compare(var6.getCtrlType(), "MOBMDCTRL", true) == 0) {
         var1.setPSDEListId(this.getPSDEListId(var3, var7, var8, true));
         var1.setPSDEDataSetId(this.getPSDEDataSetId(var3, var7, var8));
         if (StringHelper.isNullOrEmpty(var7)) {
            if (!StringHelper.isNullOrEmpty(var6.getPSSysACHandlerId())) {
               var1.setPSACHandlerId(this.getPSACHandlerId(var6.getPSSysACHandlerId(), var2));
            }
         } else {
            String var9 = var6.getPSSysACHandlerId();
            var1.setPSACHandlerId(this.getPSACHandlerId(var9, var2));
         }

         var1.setCtrlParam("LISTVIEW");
      }
   }

   protected String getPSACHandlerId(String var1, PSSystem var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s", "PSACHANDLER", var1);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSACHandlerIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSACHandlerIdReal(String var1, PSSystem var2) throws Exception {
      String var3 = KeyValueHelper.genUniqueId(var1, var2.getPSSFId());
      String var4 = KeyValueHelper.genUniqueId(var2.getPSSystemId(), var3);
      PSACHandlerService var5 = (PSACHandlerService)ServiceGlobal.getService(PSACHandlerService.class, this.getSessionFactory());
      PSACHandler var6 = new PSACHandler();
      var6.setPSACHandlerId(var4);
      if (var5.checkKey(var6) == 1) {
         return var4;
      }

      SelectCond var7 = new SelectCond();
      var7.setFetchFirst(true);
      var7.setIsNull("PSDEID");
      var7.set("PSSYSTEMID", var2.getPSSystemId());
      var7.set("PSSFACHANDLERID", var3);
      ArrayList var8 = var5.select(var7);
      return var8.size() > 0 ? ((PSACHandler)var8.get(0)).getPSACHandlerId() : null;
   }

   protected String getPSDEToolbarId(String var1, PSSystem var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s", "PSDETOOLBAR", var1);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSDEToolbarIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSDEToolbarIdReal(String var1, PSSystem var2) throws Exception {
      String var3 = KeyValueHelper.genUniqueId(var2.getPSSystemId(), var1);
      PSDEToolbarService var4 = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, this.getSessionFactory());
      PSDEToolbar var5 = new PSDEToolbar();
      var5.setPSDEToolbarId(var3);
      if (var4.checkKey(var5) == 1) {
         return var3;
      }

      SelectCond var6 = new SelectCond();
      var6.setFetchFirst(true);
      var6.setIsNull("PSDEID");
      var6.set("PSSYSTEMID", var2.getPSSystemId());
      var6.set("PSSYSTOOLBARID", var1);
      ArrayList var7 = var4.select(var6);
      return var7.size() > 0 ? ((PSDEToolbar)var7.get(0)).getPSDEToolbarId() : null;
   }

   protected String getPSDEEditFormId(PSDataEntity var1, boolean var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s#%3$s", "PSEDITFORM", var1.getPSDataEntityId(), var2);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSDEEditFormIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSDEEditFormIdReal(PSDataEntity var1, boolean var2) throws Exception {
      boolean var3 = this.isEnableFolderKey(var1);
      String var4 = null;
      if (var3) {
         var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
         if (var2) {
            var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R3");
         }
      } else {
         var4 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "EDITFORM");
         if (var2) {
            var4 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "EDITFORM", "MOB");
         }
      }

      PSDEFormService var5 = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, this.getSessionFactory());
      PSDEForm var6 = new PSDEForm();
      var6.setPSDEFormId(var4);
      if (var5.checkKey(var6) == 1) {
         return var4;
      }

      SelectCond var7 = new SelectCond();
      var7.set("FORMTYPE", "EDITFORM");
      var7.set("PSDEID", var1.getPSDataEntityId());

      for (PSDEForm var10 : var5.select(var7)) {
         if (var2) {
            if (DataObject.getBoolValue(var10.getMobFlag(), false)) {
               return var10.getPSDEFormId();
            }

            if (var10.getCodeName().indexOf("Mob") != -1) {
               return var10.getPSDEFormId();
            }
         } else if (!DataObject.getBoolValue(var10.getMobFlag(), false) && var10.getCodeName().indexOf("Mob") == -1) {
            return var10.getPSDEFormId();
         }
      }

      return null;
   }

   protected String getPSDESearchFormId(PSDataEntity var1, boolean var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s#%3$s", "PSSEARCHFORM", var1.getPSDataEntityId(), var2);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSDESearchFormIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSDESearchFormIdReal(PSDataEntity var1, boolean var2) throws Exception {
      boolean var3 = this.isEnableFolderKey(var1);
      String var4 = null;
      if (var3) {
         var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R2");
         if (var2) {
            var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R4");
         }
      } else {
         var4 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "SEARCHFORM");
         if (var2) {
            var4 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "SEARCHFORM", "MOB");
         }
      }

      PSDEFormService var5 = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, this.getSessionFactory());
      PSDEForm var6 = new PSDEForm();
      var6.setPSDEFormId(var4);
      if (var5.checkKey(var6) == 1) {
         return var4;
      }

      SelectCond var7 = new SelectCond();
      var7.set("FORMTYPE", "SEARCHFORM");
      var7.set("PSDEID", var1.getPSDataEntityId());

      for (PSDEForm var10 : var5.select(var7)) {
         if (var2) {
            if (DataObject.getBoolValue(var10.getMobFlag(), false)) {
               return var10.getPSDEFormId();
            }

            if (var10.getCodeName().indexOf("Mob") != -1) {
               return var10.getPSDEFormId();
            }
         } else if (!DataObject.getBoolValue(var10.getMobFlag(), false) && var10.getCodeName().indexOf("Mob") == -1) {
            return var10.getPSDEFormId();
         }
      }

      return null;
   }

   protected String getPSDEGridId(PSDataEntity var1, boolean var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s#%3$s", "PSDEGRID", var1.getPSDataEntityId(), var2);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSDEGridIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSDEGridIdReal(PSDataEntity var1, boolean var2) throws Exception {
      boolean var3 = this.isEnableFolderKey(var1);
      String var4 = null;
      if (var3) {
         var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
      } else {
         var4 = var1.getPSDataEntityId();
      }

      PSDEGridService var5 = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, this.getSessionFactory());
      PSDEGrid var6 = new PSDEGrid();
      var6.setPSDEGridId(var4);
      if (var5.checkKey(var6) == 1) {
         return var4;
      }

      SelectCond var7 = new SelectCond();
      var7.set("PSDEID", var1.getPSDataEntityId());

      for (PSDEGrid var10 : var5.select(var7)) {
         if (var2) {
            if (var10.getCodeName().indexOf("Mob") != -1) {
               return var10.getPSDEGridId();
            }
         } else if (var10.getCodeName().indexOf("Mob") == -1) {
            return var10.getPSDEGridId();
         }
      }

      return null;
   }

   protected String getPSDEDataSetId(PSDataEntity var1) throws Exception {
      return this.getPSDEDataSetId(var1, null, null);
   }

   protected String getPSDEDataSetId(PSDataEntity var1, String var2, String var3) throws Exception {
      ActionSession var4 = ActionSessionManager.getCurrentSession();
      String var5 = StringHelper.format("%1$s#%2$s#%3$s#%4$s", "PSDEDATASET", var1.getPSDataEntityId(), var2, var3);
      if (var4 != null) {
         Object var6 = var4.getActionParam(var5);
         if (var6 != null) {
            if (var6 instanceof String) {
               return (String)var6;
            }

            return null;
         }
      }

      String var7 = this.getPSDEDataSetIdReal(var1, var2, var3);
      if (var4 != null) {
         if (var7 == null) {
            var4.setActionParam(var5, EntityBase.EMPTY);
         } else {
            var4.setActionParam(var5, var7);
         }
      }

      return var7;
   }

   protected String getPSDEDataSetIdReal(PSDataEntity var1, String var2, String var3) throws Exception {
      boolean var4 = this.isEnableFolderKey(var1);
      String var5 = null;
      if (var4) {
         var5 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
      } else {
         var5 = var1.getPSDataEntityId();
         if (!StringHelper.isNullOrEmpty(var2)) {
            if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
               var5 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "INDEXDETYPE", var3);
            } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0) {
               var5 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "FORMTYPE", "");
            }
         }
      }

      PSDEDataSetService var6 = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, this.getSessionFactory());
      PSDEDataSet var7 = new PSDEDataSet();
      var7.setPSDEDataSetId(var5);
      if (var6.checkKey(var7) == 1) {
         return var5;
      }

      SelectCond var8 = new SelectCond();
      var8.set("PSDEID", var1.getPSDataEntityId());
      ArrayList<PSDEDataSet> var9 = var6.select(var8);
      if (!StringHelper.isNullOrEmpty(var2)) {
         for (PSDEDataSet var11 : var9) {
            if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
               if ("INDEXDE".equals(var11.getPredefineType())) {
                  return var11.getPSDEDataSetId();
               }
            } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0 && "MULTIFORM".equals(var11.getPredefineType())) {
               return var11.getPSDEDataSetId();
            }
         }
      } else {
         for (PSDEDataSet var15 : var9) {
            if (DataObject.getBoolValue(var15.getDefaultMode(), false)) {
               return var15.getPSDEDataSetId();
            }
         }

         Iterator var14 = var9.iterator();
         if (var14.hasNext()) {
            PSDEDataSet var16 = (PSDEDataSet)var14.next();
            return var16.getPSDEDataSetId();
         }
      }

      return null;
   }

   protected String getPSDEDataViewId(PSDataEntity var1, String var2, String var3) throws Exception {
      ActionSession var4 = ActionSessionManager.getCurrentSession();
      String var5 = StringHelper.format("%1$s#%2$s#%3$s#%4$s", "PSDEDATAVIEW", var1.getPSDataEntityId(), var2, var3);
      if (var4 != null) {
         Object var6 = var4.getActionParam(var5);
         if (var6 != null) {
            if (var6 instanceof String) {
               return (String)var6;
            }

            return null;
         }
      }

      String var7 = this.getPSDEDataViewIdReal(var1, var2, var3);
      if (var4 != null) {
         if (var7 == null) {
            var4.setActionParam(var5, EntityBase.EMPTY);
         } else {
            var4.setActionParam(var5, var7);
         }
      }

      return var7;
   }

   protected String getPSDEDataViewIdReal(PSDataEntity var1, String var2, String var3) throws Exception {
      String var4 = "";
      boolean var5 = this.isEnableFolderKey(var1);
      if (var5) {
         if (!StringHelper.isNullOrEmpty(var2)) {
            if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
               var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R2");
            } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0) {
               var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R3");
            }
         }
      } else if (StringHelper.isNullOrEmpty(var2)) {
         var4 = var1.getPSDataEntityId();
      } else {
         var4 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2, var3);
      }

      PSDEDataViewService var6 = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, this.getSessionFactory());
      PSDEDataView var7 = new PSDEDataView();
      var7.setPSDEDataViewId(var4);
      if (var6.checkKey(var7) == 1) {
         return var4;
      }

      SelectCond var8 = new SelectCond();
      var8.set("PSDEID", var1.getPSDataEntityId());
      ArrayList<PSDEDataView> var9 = var6.select(var8);
      if (!StringHelper.isNullOrEmpty(var2)) {
         for (PSDEDataView var11 : var9) {
            if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
               if ("IndexType".equals(var11.getCodeName())) {
                  return var11.getPSDEDataViewId();
               }
            } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0 && "FormType".equals(var11.getCodeName())) {
               return var11.getPSDEDataViewId();
            }
         }
      } else {
         Iterator var12 = var9.iterator();
         if (var12.hasNext()) {
            PSDEDataView var13 = (PSDEDataView)var12.next();
            return var13.getPSDEDataViewId();
         }
      }

      return null;
   }

   protected String getPSDEListId(PSDataEntity var1, String var2, String var3, boolean var4) throws Exception {
      ActionSession var5 = ActionSessionManager.getCurrentSession();
      String var6 = StringHelper.format("%1$s#%2$s#%3$s#%4$s#%5$s", "PSDELIST", var1.getPSDataEntityId(), var2, var3, var4);
      if (var5 != null) {
         Object var7 = var5.getActionParam(var6);
         if (var7 != null) {
            if (var7 instanceof String) {
               return (String)var7;
            }

            return null;
         }
      }

      String var8 = this.getPSDEListIdReal(var1, var2, var3, var4);
      if (var5 != null) {
         if (var8 == null) {
            var5.setActionParam(var6, EntityBase.EMPTY);
         } else {
            var5.setActionParam(var6, var8);
         }
      }

      return var8;
   }

   protected String getPSDEListIdReal(PSDataEntity var1, String var2, String var3, boolean var4) throws Exception {
      boolean var5 = this.isEnableFolderKey(var1);
      String var6 = "";
      if (var5) {
         if (StringHelper.isNullOrEmpty(var2)) {
            var6 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
         } else if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
            var6 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R2");
         } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0) {
            var6 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R3");
         }
      } else if (var4) {
         if (StringHelper.isNullOrEmpty(var2)) {
            var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "MOB");
         } else {
            var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2, var3, "MOB");
         }
      } else if (StringHelper.isNullOrEmpty(var2)) {
         var6 = var1.getPSDataEntityId();
      } else {
         var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2, var3);
      }

      PSDEListService var7 = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, this.getSessionFactory());
      PSDEList var8 = new PSDEList();
      var8.setPSDEListId(var6);
      if (var7.checkKey(var8) == 1) {
         return var6;
      }

      SelectCond var9 = new SelectCond();
      var9.set("PSDEID", var1.getPSDataEntityId());
      ArrayList<PSDEList> var10 = var7.select(var9);
      if (!StringHelper.isNullOrEmpty(var2)) {
         for (PSDEList var12 : var10) {
            if (StringHelper.compare(var2, "INDEXDETYPE", true) == 0) {
               if (var4) {
                  if ("MobIndexType".equals(var12.getCodeName())) {
                     return var12.getPSDEListId();
                  }
               } else if ("IndexType".equals(var12.getCodeName())) {
                  return var12.getPSDEListId();
               }
            } else if (StringHelper.compare(var2, "FORMTYPE", true) == 0) {
               if (var4) {
                  if ("MobFormType".equals(var12.getCodeName())) {
                     return var12.getPSDEListId();
                  }
               } else if ("FormType".equals(var12.getCodeName())) {
                  return var12.getPSDEListId();
               }
            }
         }
      } else {
         for (PSDEList var15 : var10) {
            if (var4 && "Mob".equals(var15.getCodeName())) {
               return var15.getPSDEListId();
            }
         }

         Iterator var14 = var10.iterator();
         if (var14.hasNext()) {
            PSDEList var16 = (PSDEList)var14.next();
            return var16.getPSDEListId();
         }
      }

      return null;
   }

   protected String getPSDEViewBaseId(PSDataEntity var1, PSViewTypeStruct var2, String var3, String var4) throws Exception {
      ActionSession var5 = ActionSessionManager.getCurrentSession();
      String var6 = StringHelper.format(
         "%1$s#%2$s#%3$s#%4$s#%5$s", "PSDEDATASET", var1.getPSDataEntityId(), var2 == null ? "" : var2.getPSViewTypeId(), var3, var4
      );
      if (var5 != null) {
         Object var7 = var5.getActionParam(var6);
         if (var7 != null) {
            if (var7 instanceof String) {
               return (String)var7;
            }

            return null;
         }
      }

      String var8 = this.getPSDEViewBaseIdReal(var1, var2, var3, var4);
      if (var5 != null) {
         if (var8 == null) {
            var5.setActionParam(var6, EntityBase.EMPTY);
         } else {
            var5.setActionParam(var6, var8);
         }
      }

      return var8;
   }

   protected String getPSDEViewBaseIdReal(PSDataEntity var1, PSViewTypeStruct var2, String var3, String var4) throws Exception {
      boolean var5 = this.isEnableFolderKey(var1);
      if (var5) {
         String var13 = "";
         if (var2 != null && var2.getPSViewTypeId().indexOf("DEMOB") != -1) {
            if (StringHelper.compare(var3, "INDEXDETYPE", true) == 0) {
               var13 = KeyValueHelper.genUniqueId("DEMOBINDEXPICKUPMDVIEW", var3, var4);
            } else if (StringHelper.compare(var3, "FORMTYPE", true) == 0) {
               var13 = KeyValueHelper.genUniqueId("DEMOBFORMPICKUPMDVIEW", var3, var4);
            } else {
               var13 = KeyValueHelper.genUniqueId("DEMOBPICKUPMDVIEW");
            }
         } else if (StringHelper.compare(var3, "INDEXDETYPE", true) == 0) {
            var13 = KeyValueHelper.genUniqueId("DEINDEXPICKUPDATAVIEW", var3, var4);
         } else if (StringHelper.compare(var3, "FORMTYPE", true) == 0) {
            var13 = KeyValueHelper.genUniqueId("DEFORMPICKUPDATAVIEW", var3, var4);
         } else {
            var13 = KeyValueHelper.genUniqueId("DEPICKUPGRIDVIEW");
         }

         PSDEViewBaseService var16 = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, this.getSessionFactory());
         PSDEViewBase var17 = new PSDEViewBase();
         var17.setDEViewTag(var13);
         var17.setPSDEId(var1.getPSDataEntityId());
         return var16.selectOne(var17, true) ? var17.getPSDEViewBaseId() : null;
      } else {
         String var6 = "";
         String var7 = "";
         if (var2 != null && var2.getPSViewTypeId().indexOf("DEMOB") != -1) {
            if (StringHelper.compare(var3, "INDEXDETYPE", true) == 0) {
               var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEMOBINDEXPICKUPMDVIEW", var3, var4);
               var7 = "DEMOBINDEXPICKUPMDVIEW";
            } else if (StringHelper.compare(var3, "FORMTYPE", true) == 0) {
               var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEMOBFORMPICKUPMDVIEW", var3, var4);
               var7 = "DEMOBFORMPICKUPMDVIEW";
            } else {
               var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEMOBPICKUPMDVIEW");
               var7 = "DEMOBPICKUPMDVIEW";
            }
         } else if (StringHelper.compare(var3, "INDEXDETYPE", true) == 0) {
            var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEINDEXPICKUPDATAVIEW", var3, var4);
            var7 = "DEINDEXPICKUPDATAVIEW";
         } else if (StringHelper.compare(var3, "FORMTYPE", true) == 0) {
            var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEFORMPICKUPDATAVIEW", var3, var4);
            var7 = "DEFORMPICKUPDATAVIEW";
         } else {
            var6 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), "DEPICKUPGRIDVIEW");
            var7 = "DEPICKUPGRIDVIEW";
         }

         PSDEViewBaseService var8 = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, this.getSessionFactory());
         PSDEViewBase var9 = new PSDEViewBase();
         var9.setPSDEViewBaseId(var6);
         if (var8.checkKey(var9) == 1) {
            return var9.getPSDEViewBaseId();
         }

         SelectCond var10 = new SelectCond();
         var10.setFetchFirst(true);
         var10.set("PSDEID", var1.getPSDataEntityId());
         var10.set("PSDEVIEWBASETYPE", var7);
         if (StringHelper.isNullOrEmpty(var3)) {
            var10.setIsNull("DEVIEWTAG3");
            var10.setIsNull("DEVIEWTAG4");
         } else {
            var10.set("DEVIEWTAG3", var3);
            if (!StringHelper.isNullOrEmpty(var4)) {
               var10.set("DEVIEWTAG4", var4);
            } else {
               var10.setIsNull("DEVIEWTAG4");
            }
         }

         ArrayList var11 = this.select(var10);
         return var11.size() == 0 ? null : ((PSDEViewBase)var11.get(0)).getPSDEViewBaseId();
      }
   }

   protected String getPSDEDataRelationId(PSDataEntity var1, PSDEViewBase var2, boolean var3) throws Exception {
      ActionSession var4 = ActionSessionManager.getCurrentSession();
      String var5 = StringHelper.format("%1$s#%2$s#%3$s#%4$s", "PSDEDATARELATION", var1.getPSDataEntityId(), var2.getPSWFDEId(), var3);
      if (var4 != null) {
         Object var6 = var4.getActionParam(var5);
         if (var6 != null) {
            if (var6 instanceof String) {
               return (String)var6;
            }

            return null;
         }
      }

      String var7 = this.getPSDEDataRelationIdReal(var1, var2, var3);
      if (var4 != null) {
         if (var7 == null) {
            var4.setActionParam(var5, EntityBase.EMPTY);
         } else {
            var4.setActionParam(var5, var7);
         }
      }

      return var7;
   }

   protected String getPSDEDataRelationIdReal(PSDataEntity var1, PSDEViewBase var2, boolean var3) throws Exception {
      boolean var4 = this.isEnableFolderKey(var1);
      String var5 = null;
      if (var4) {
         var5 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
      } else {
         var5 = var1.getPSDataEntityId();
      }

      if (!StringHelper.isNullOrEmpty(var2.getPSWFId())) {
         var5 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2.getPSWFId());
         if (var3) {
            var5 = KeyValueHelper.genUniqueId(var1.getPSDataEntityId(), var2.getPSWFId(), "MOB");
         }
      }

      PSDEDataRelation var6 = new PSDEDataRelation();
      var6.setPSDEDataRelationId(var5);
      PSDEDataRelationService var7 = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, this.getSessionFactory());
      if (var7.checkKey(var6) == 1) {
         return var5;
      }

      SelectCond var8 = new SelectCond();
      var8.setFetchFirst(true);
      var8.set("PSDEID", var2.getPSDEId());
      if (StringHelper.isNullOrEmpty(var2.getPSWFDEId())) {
         var8.setIsNull("PSWFDEID");
      } else {
         var8.set("PSWFDEID", var2.getPSWFDEId());
      }

      if (var3) {
         var8.set("DRTAG", "MOB");
      } else {
         var8.setIsNull("DRTAG");
      }

      ArrayList var9 = var7.select(var8);
      return var9.size() > 0 ? ((PSDEDataRelation)var9.get(0)).getPSDEDataRelationId() : null;
   }

   protected void initDEViewRV(PSSystem var1, PSDataEntity var2, PSViewTypeStruct var3, PSDEViewBase var4, PSVTRV var5, String var6, String var7) throws Exception {
      PSDEViewRV var8 = new PSDEViewRV();
      var8.setMajorPSDEViewId(var4.getPSDEViewBaseId());
      var8.setMajorPSDEViewName(var4.getPSDEViewBaseName());
      var8.setPSDEViewRVName(var5.getPSVTRVName());
      var8.setRefModeText(var5.getLogicName());
      var8.setMemo(var5.getMemo());
      var8.setDefViewType(var5.getDEFViewType());
      this.fillDEViewRV(var8, var1, var2, var3, var4, var5, var6, var7);
      PSDEViewRVService var9 = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, this.getSessionFactory());

      try {
         var9.create(var8);
      } catch (Exception var11) {
         throw new Exception(
            StringHelper.format("建立实体视图[%1$s]引用[%2$s]发生异常，%3$s", var4.getPSDEViewBaseName(), var8.getPSDEViewRVName(), var11.getMessage()), var11
         );
      }
   }

   protected void fillDEViewRV(
      PSDEViewRV var1, PSSystem var2, PSDataEntity var3, PSViewTypeStruct var4, PSDEViewBase var5, PSVTRV var6, String var7, String var8
   ) throws Exception {
      if (StringHelper.compare(var4.getPSViewTypeId(), "DEGRIDVIEW", true) == 0 || StringHelper.compare(var4.getPSViewTypeId(), "DEMDCUSTOMVIEW", true) == 0) {
         boolean var9 = this.isEnableFolderKey(var3);
         PSDEViewBaseService var10 = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, this.getSessionFactory());
         PSDEViewBase var11 = new PSDEViewBase();
         if (var9) {
            if (StringHelper.compare(var6.getPSVTRVName(), "NEWDATA", true) == 0) {
               String var13 = KeyValueHelper.genUniqueId("DEEDITVIEW");
               var11.setDEViewTag(var13);
               var11.setPSDEId(var3.getPSDataEntityId());
               if (var10.selectOne(var11, true)) {
                  var1.setMinorPSDEViewId(var11.getPSDEViewBaseId());
               }

               return;
            }

            if (StringHelper.compare(var6.getPSVTRVName(), "EDITDATA", true) == 0) {
               String var12 = KeyValueHelper.genUniqueId("DEEDITVIEW");
               var11.setDEViewTag(var12);
               var11.setPSDEId(var3.getPSDataEntityId());
               if (var10.selectOne(var11, true)) {
                  var1.setMinorPSDEViewId(var11.getPSDEViewBaseId());
               }

               return;
            }
         } else {
            if (StringHelper.compare(var6.getPSVTRVName(), "NEWDATA", true) == 0) {
               String var15 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "DEEDITVIEW");
               var11.setPSDEViewBaseId(var15);
               if (var10.checkKey(var11) == 1) {
                  var1.setMinorPSDEViewId(var15);
               }

               return;
            }

            if (StringHelper.compare(var6.getPSVTRVName(), "EDITDATA", true) == 0) {
               String var14 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "DEEDITVIEW");
               var11.setPSDEViewBaseId(var14);
               if (var10.checkKey(var11) == 1) {
                  var1.setMinorPSDEViewId(var14);
               }

               return;
            }
         }
      }
   }

   protected void initDEWFViews(PSDataEntity var1) throws Exception {
      ArrayList<PSWFDE> var2 = var1.getPSWFDEs();
      if (var2.size() != 0) {
         for (PSWFDE var4 : var2) {
            this.initWFDEViews(var4, var1);
         }
      }
   }

   public void initWFDEViews(PSWFDE var1, PSDataEntity var2) throws Exception {
      final PSWFDE var3 = var1;
      final PSDataEntity var4 = var2 != null ? var2 : var1.getPSDE();
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               PSDEFieldService var2x = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, PSDEViewBaseService.this.getSessionFactory());
               PSCodeListService var3x = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, PSDEViewBaseService.this.getSessionFactory());
               PSDataEntityService var4x = (PSDataEntityService)ServiceGlobal.getService(
                  PSDataEntityService.class, PSDEViewBaseService.this.getSessionFactory()
               );
               PSWFVersionService var5 = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, PSDEViewBaseService.this.getSessionFactory());
               if (!var4.isFullEntity()) {
                  var4x.get(var4);
               }

               ArrayList var6 = null;
               int var7 = DataObject.getIntegerValue(var3.getWFProxyMode(), 0);
               boolean var8 = (var7 & 1) == 1;
               boolean var9 = var7 != 1;
               boolean var10 = DataObject.getBoolValue(var3.getPSWF().getEnableDynaSys(), false);
               boolean var11 = false;
               if (DataObject.getBoolValue(var3.getPSWF().getEnableMob(), false)) {
                  var11 = true;
               }

               if (var8) {
                  var10 = false;
               }

               if (var10) {
                  PSWFVersion var12 = new PSWFVersion();
                  var12.setPSWFId(var3.getPSWFId());
                  var12.setEnableDynaSys(1);
                  if (var5.select(var12, true)) {
                     var6 = new ArrayList();
                     var6.add(var12);
                  }
               } else if (var9) {
                  var6 = var5.selectByPSWF(var3.getPSWF(), "ORDER BY WFVERSION DESC");
               }

               PSDEField var30 = null;
               PSCodeList var13 = null;
               PSCodeList var14 = null;
               PSCodeList var15 = null;
               if (!var10 && var9) {
                  if (DataObject.getIntegerValue(var4.getEnaMultiForm(), 0) > 0) {
                     var30 = new PSDEField();
                     var30.setPSDEId(var4.getPSDataEntityId());
                     var30.setMultiFormField(1);
                     if (!var2x.select(var30, false)) {
                        throw new Exception(StringHelper.format("实体[%1$s]没有定义多表单识别属性", var4.getPSDataEntityName()));
                     }

                     if (StringHelper.isNullOrEmpty(var30.getPSCodeListId())) {
                        throw new Exception(StringHelper.format("属性[%1$s]没有定义代码表", var30.getPSDEFieldName()));
                     }

                     var13 = new PSCodeList();
                     var13.setPSCodeListId(var30.getPSCodeListId());
                     var3x.getCache(var13);
                  }

                  if (!StringHelper.isNullOrEmpty(var3.getWFStepPSDEFId())) {
                     PSDEField var16 = new PSDEField();
                     var16.setPSDEFieldId(var3.getWFStepPSDEFId());
                     var2x.getCache(var16);
                     if (!StringHelper.isNullOrEmpty(var16.getPSCodeListId())) {
                        var15 = new PSCodeList();
                        var15.setPSCodeListId(var16.getPSCodeListId());
                        var3x.getCache(var15);
                     } else {
                        PSDEViewBaseService.this.getConsole()
                           .warn("初始化流程视图", StringHelper.format("实体属性[%1$s|%2$s]没有指定流程步骤代码表，可能无法正确初始化相关流程视图", var16.getPSDEName(), var16.getPSDEFieldName()));
                     }
                  } else {
                     PSDEViewBaseService.this.getConsole()
                        .warn("初始化流程视图", StringHelper.format("实体工作流[%1$s|%2$s]没有指定流程步骤属性，可能无法正确初始化相关流程视图", var3.getPSDEName(), var3.getPSWFName()));
                  }
               }

               PSDEField var32 = new PSDEField();
               var32.setPSDEFieldId(var3.getStatePSDEFId());
               var2x.getCache(var32);
               if (!StringHelper.isNullOrEmpty(var32.getPSCodeListId())) {
                  var14 = new PSCodeList();
                  var14.setPSCodeListId(var32.getPSCodeListId());
                  var3x.getCache(var14);
               } else {
                  PSDEViewBaseService.this.getConsole()
                     .warn("初始化流程视图", StringHelper.format("实体属性[%1$s|%2$s]没有指定流程用户数据状态代码表，可能无法正确初始化相关流程视图", var32.getPSDEName(), var32.getPSDEFieldName()));
               }

               PSDEDRGroupService var33 = (PSDEDRGroupService)ServiceGlobal.getService(PSDEDRGroupService.class, PSDEViewBaseService.this.getSessionFactory());
               PSDEDRGroup var17 = new PSDEDRGroup();
               var17.setPSDEDRGroupId(var4.getPSDataEntityId());
               if (!var33.get(var17, true)) {
                  var17.reset();
                  var17.setPSDEId(var4.getPSDataEntityId());
                  if (!var33.selectOne(var17, true)) {
                     var17.setPSDEDRGroupId(var4.getPSDataEntityId());
                     var17.setOrderValue(10000);
                     var17.setPSDEId(var4.getPSDataEntityId());
                     var17.setPSDEDRGroupName("详细信息");
                     var33.create(var17);
                  }
               }

               PSSysPDTViewService var18 = (PSSysPDTViewService)ServiceGlobal.getService(
                  PSSysPDTViewService.class, PSDEViewBaseService.this.getSessionFactory()
               );
               PSSysPDTView var19 = new PSSysPDTView();
               String var20 = KeyValueHelper.genUniqueId(var4.getPSSystemId(), "WF_STEPDATALIST");
               var19.setPSSysPDTViewId(var20);
               if (!var18.get(var19, true)) {
                  var19.reset();
                  var19.setPSPDTViewId("WF_STEPDATALIST");
                  if (!var18.selectOne(var19, true)) {
                     var19 = null;
                  }
               }

               PSSysPDTView var34 = new PSSysPDTView();
               String var21 = KeyValueHelper.genUniqueId(var4.getPSSystemId(), "WF_STEPACTORLIST");
               var34.setPSSysPDTViewId(var21);
               if (!var18.get(var34, true)) {
                  var34.reset();
                  var34.setPSPDTViewId("WF_STEPACTORLIST");
                  if (!var18.selectOne(var34, true)) {
                     var34 = null;
                  }
               }

               PSSysPDTView var35 = new PSSysPDTView();
               String var22 = KeyValueHelper.genUniqueId(var4.getPSSystemId(), "WF_STEPTRACECHART");
               var35.setPSSysPDTViewId(var22);
               if (!var18.get(var35, true)) {
                  var35.reset();
                  var35.setPSPDTViewId("WF_STEPTRACECHART");
                  if (!var18.selectOne(var35, true)) {
                     var35 = null;
                  }
               }

               PSDEDataRelation var36 = new PSDEDataRelation();
               String var23 = KeyValueHelper.genUniqueId(var4.getPSDataEntityId(), var3.getPSWFId());
               var36.setPSDEDataRelationId(var23);
               PSDEDataRelationService var24 = (PSDEDataRelationService)ServiceGlobal.getService(
                  PSDEDataRelationService.class, PSDEViewBaseService.this.getSessionFactory()
               );
               boolean var25 = true;
               if (var24.get(var36, true)) {
                  var25 = false;
                  if (StringHelper.isNullOrEmpty(var36.getPSWFDEId())) {
                     var36.setPSWFDEId(var3.getPSWFDEId());
                     var36.setDRTag(null);
                     var24.update(var36);
                  }
               } else {
                  var36.reset();
                  SelectCond var26 = new SelectCond();
                  var26.setFetchFirst(true);
                  var26.set("PSDEID", var4.getPSDataEntityId());
                  var26.set("PSWFDEID", var3.getPSWFDEId());
                  var26.setIsNull("DRTAG");
                  ArrayList var27 = var24.select(var26);
                  if (var27.size() > 0) {
                     var25 = false;
                     ((PSDEDataRelation)var27.get(0)).copyTo(var36, true);
                  } else {
                     var36.reset();
                     var36.setCodeName(var3.getCodeName() + "DR");
                     var36.setPSDEId(var4.getPSDataEntityId());
                     if (var24.select(var36, true)) {
                        var25 = false;
                        if (StringHelper.isNullOrEmpty(var36.getPSWFDEId())) {
                           var36.setPSWFDEId(var3.getPSWFDEId());
                           var36.setDRTag(null);
                           var24.update(var36);
                        }
                     }
                  }
               }

               if (var25) {
                  var36.setPSDEDataRelationId(var23);
                  var36.setPSDEId(var4.getPSDataEntityId());
                  var36.setPSDEDataRelationName(StringHelper.format("%1$s/%2$s关系界面组", var4.getLogicName(), var3.getPSWFName()));
                  var36.setCodeName(var3.getCodeName() + "DR");
                  var36.setPSWFDEId(var3.getPSWFDEId());
                  var24.create(var36);
                  PSDEDRDetailService var54 = (PSDEDRDetailService)ServiceGlobal.getService(
                     PSDEDRDetailService.class, PSDEViewBaseService.this.getSessionFactory()
                  );
                  if (var19 != null) {
                     PSDEDRDetail var60 = new PSDEDRDetail();
                     var60.setPSDEDRId(var23);
                     var60.setPSDEDRDetailName("dritem1");
                     var60.setCaption("流程处理");
                     var60.setDetailType("PDTVIEW");
                     var60.setOrderValue(1000);
                     var60.setPSSysPDTViewId(var19.getPSSysPDTViewId());
                     var60.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                     var54.create(var60);
                  }

                  if (var34 != null) {
                     PSDEDRDetail var61 = new PSDEDRDetail();
                     var61.setPSDEDRId(var23);
                     var61.setPSDEDRDetailName("dritem2");
                     var61.setCaption("流程催办");
                     var61.setDetailType("PDTVIEW");
                     var61.setOrderValue(1100);
                     var61.setPSSysPDTViewId(var34.getPSSysPDTViewId());
                     var61.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                     var54.create(var61);
                  }

                  if (var35 != null) {
                     PSDEDRDetail var62 = new PSDEDRDetail();
                     var62.setPSDEDRId(var23);
                     var62.setPSDEDRDetailName("dritem3");
                     var62.setCaption("流程跟踪");
                     var62.setDetailType("PDTVIEW");
                     var62.setOrderValue(1200);
                     var62.setPSSysPDTViewId(var35.getPSSysPDTViewId());
                     var62.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                     var54.create(var62);
                  }
               }

               if (var11) {
                  PSDEDataRelation var37 = new PSDEDataRelation();
                  var23 = KeyValueHelper.genUniqueId(var4.getPSDataEntityId(), var3.getPSWFId(), "MOB");
                  var37.setPSDEDataRelationId(var23);
                  var24 = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, PSDEViewBaseService.this.getSessionFactory());
                  var25 = true;
                  if (var24.get(var37, true)) {
                     var25 = false;
                     if (StringHelper.isNullOrEmpty(var37.getPSWFDEId())) {
                        var37.setPSWFDEId(var3.getPSWFDEId());
                        var37.setDRTag("MOB");
                        var24.update(var37);
                     }
                  } else {
                     var37.reset();
                     var37.setPSDEId(var4.getPSDataEntityId());
                     var37.setPSWFDEId(var3.getPSWFDEId());
                     var37.setDRTag("MOB");
                     if (var24.selectOne(var37, true)) {
                        var25 = false;
                     } else {
                        var37.reset();
                        var37.setCodeName(var3.getCodeName() + "MobDR");
                        var37.setPSDEId(var4.getPSDataEntityId());
                        if (var24.select(var37, true)) {
                           var25 = false;
                           if (StringHelper.isNullOrEmpty(var37.getPSWFDEId())) {
                              var37.setPSWFDEId(var3.getPSWFDEId());
                              var37.setDRTag("MOB");
                              var24.update(var37);
                           }
                        }
                     }
                  }

                  if (var25) {
                     var37.setPSDEDataRelationId(var23);
                     var37.setPSDEId(var4.getPSDataEntityId());
                     var37.setPSDEDataRelationName(StringHelper.format("%1$s/%2$s关系界面组（移动端）", var4.getLogicName(), var3.getPSWFName()));
                     var37.setCodeName(var3.getCodeName() + "MobDR");
                     var37.setPSWFDEId(var3.getPSWFDEId());
                     var37.setDRTag("MOB");
                     var24.create(var37);
                     PSDEDRDetailService var55 = (PSDEDRDetailService)ServiceGlobal.getService(
                        PSDEDRDetailService.class, PSDEViewBaseService.this.getSessionFactory()
                     );
                     if (var19 != null) {
                        PSDEDRDetail var63 = new PSDEDRDetail();
                        var63.setPSDEDRId(var23);
                        var63.setPSDEDRDetailName("dritem1");
                        var63.setCaption("流程处理");
                        var63.setDetailType("PDTVIEW");
                        var63.setOrderValue(1000);
                        var63.setPSSysPDTViewId(var19.getPSSysPDTViewId());
                        var63.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                        var55.create(var63);
                     }

                     if (var34 != null) {
                        PSDEDRDetail var64 = new PSDEDRDetail();
                        var64.setPSDEDRId(var23);
                        var64.setPSDEDRDetailName("dritem2");
                        var64.setCaption("流程催办");
                        var64.setDetailType("PDTVIEW");
                        var64.setOrderValue(1100);
                        var64.setPSSysPDTViewId(var34.getPSSysPDTViewId());
                        var64.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                        var55.create(var64);
                     }

                     if (var35 != null) {
                        PSDEDRDetail var65 = new PSDEDRDetail();
                        var65.setPSDEDRId(var23);
                        var65.setPSDEDRDetailName("dritem3");
                        var65.setCaption("流程跟踪");
                        var65.setDetailType("PDTVIEW");
                        var65.setOrderValue(1200);
                        var65.setPSSysPDTViewId(var35.getPSSysPDTViewId());
                        var65.setPSDEDRGroupId(var17.getPSDEDRGroupId());
                        var55.create(var65);
                     }
                  }
               }

               if (var13 != null) {
                  for (PSCodeItem var46 : var13.getPSCodeItems()) {
                     for (String var28 : PSDEViewBaseService.initWFViewTypes) {
                        PSViewTypeStruct var29 = PSModelGlobal.getPSViewType(var28);
                        PSDEViewBaseService.this.initDEWFView(var4, var46, var29, var3, var15, var14, var6);
                     }

                     if (var11) {
                        for (String var68 : PSDEViewBaseService.initMobWFViewTypes) {
                           PSViewTypeStruct var69 = PSModelGlobal.getPSViewType(var68);
                           PSDEViewBaseService.this.initDEWFView(var4, var46, var69, var3, var15, var14, var6);
                        }
                     }
                  }
               } else {
                  for (String var52 : PSDEViewBaseService.initWFViewTypes) {
                     PSViewTypeStruct var58 = PSModelGlobal.getPSViewType(var52);
                     PSDEViewBaseService.this.initDEWFView(var4, null, var58, var3, var15, var14, var6);
                  }

                  if (var11) {
                     for (String var53 : PSDEViewBaseService.initMobWFViewTypes) {
                        PSViewTypeStruct var59 = PSModelGlobal.getPSViewType(var53);
                        PSDEViewBaseService.this.initDEWFView(var4, null, var59, var3, var15, var14, var6);
                     }
                  }
               }
            }
         }
      );
   }

   protected void initDEWFView(
      PSDataEntity var1, PSCodeItem var2, PSViewTypeStruct var3, PSWFDE var4, PSCodeList var5, PSCodeList var6, ArrayList<PSWFVersion> var7
   ) throws Exception {
      boolean var8 = DataObject.getBoolValue(var4.getPSWF().getEnableDynaSys(), false);
      int var9 = DataObject.getIntegerValue(var4.getWFProxyMode(), 0);
      boolean var10 = (var9 & 1) == 1;
      boolean var11 = var9 != 1;
      if (var10) {
         var8 = false;
      }

      if (StringHelper.compare(var3.getPSViewTypeId(), "DEWFEXPVIEW", true) == 0) {
         PSWorkflow var32 = var4.getPSWF();
         PSDEViewBase var36 = new PSDEViewBase();
         var36.setPSWFDEId(var4.getPSWFDEId());
         var36.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getPSViewTypeName(), var32.getPSWorkflowName()));
         if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
            var36.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getTitle(), var32.getPSWorkflowName()));
         }

         var36.setCodeName(StringHelper.format("%1$s_%2$s", var4.getCodeName(), var3.getCodeName()));
         var36.setDyncMode(var8 ? 1 : 0);
         this.initDEView(var1, var3, var32.getPSWorkflowId(), "", var36, "", "");
      } else {
         String var12 = "";
         if (var2 != null) {
            var12 = var2.getCodeName();
            if (StringHelper.isNullOrEmpty(var12)) {
               var12 = var2.getCodeItemValue();
            }
         }

         if (StringHelper.compare(var3.getPSViewTypeId(), "DEWFGRIDVIEW", true) == 0) {
            PSWorkflow var35 = var4.getPSWF();
            String var42 = StringHelper.format("%1$s:D", var4.getCodeName());
            var42 = var42.toUpperCase();
            PSDEViewBase var59 = new PSDEViewBase();
            var59.setWFViewParam(0);
            var59.setPSWFDEId(var4.getPSWFDEId());
            var59.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getPSViewTypeName(), var35.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
               var59.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getTitle(), var35.getPSWorkflowName()));
            }

            var59.setCodeName(StringHelper.format("%1$s_D_%2$s", var4.getCodeName(), var3.getCodeName()));
            var59.setDyncMode(var8 ? 1 : 0);
            this.initDEView(var1, var3, var35.getPSWorkflowId(), "D", var59, "WFMDATAVIEW", var42);
            if (var6 != null && var6.getPSCodeItems() != null) {
               for (PSCodeItem var72 : var6.getPSCodeItems()) {
                  String var85 = StringHelper.format("%1$s:D:%2$s", var4.getCodeName(), var72.getCodeItemValue());
                  var85 = var85.toUpperCase();
                  PSDEViewBase var95 = new PSDEViewBase();
                  var95.setWFViewParam(0);
                  var95.setPSWFDEId(var4.getPSWFDEId());
                  var95.setPSDEViewBaseName(
                     StringHelper.format(
                        "%1$s%2$s(%3$s:%4$s)", var1.getLogicName(), var3.getPSViewTypeName(), var35.getPSWorkflowName(), var72.getPSCodeItemName()
                     )
                  );
                  if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                     var95.setTitle(
                        StringHelper.format("%1$s%2$s(%3$s:%4$s)", var1.getLogicName(), var3.getTitle(), var35.getPSWorkflowName(), var72.getPSCodeItemName())
                     );
                  }

                  var95.setCodeName(StringHelper.format("%1$s_D%2$s_%3$s", var4.getCodeName(), var72.getCodeItemValue(), var3.getCodeName()));
                  var95.setDyncMode(var8 ? 1 : 0);
                  this.initDEView(var1, var3, var35.getPSWorkflowId(), "D:" + var72.getCodeItemValue(), var95, "WFMDATAVIEW", var85);
               }
            }

            var42 = StringHelper.format("%1$s:W", var4.getCodeName());
            var42 = var42.toUpperCase();
            var59 = new PSDEViewBase();
            var59.setWFViewParam(1);
            var59.setPSWFDEId(var4.getPSWFDEId());
            var59.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getPSViewTypeName(), var35.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
               var59.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getTitle(), var35.getPSWorkflowName()));
            }

            var59.setCodeName(StringHelper.format("%1$s_W_%2$s", var4.getCodeName(), var3.getCodeName()));
            var59.setDyncMode(var8 ? 1 : 0);
            this.initDEView(var1, var3, var35.getPSWorkflowId(), "W", var59, "WFMDATAVIEW", var42);
            if (var5 != null && var5.getPSCodeItems() != null) {
               for (PSCodeItem var73 : var5.getPSCodeItems()) {
                  String var87 = StringHelper.format("%1$s:W:%2$s", var4.getCodeName(), var73.getCodeItemValue());
                  var87 = var87.toUpperCase();
                  PSDEViewBase var96 = new PSDEViewBase();
                  var96.setWFViewParam(1);
                  var96.setWFViewParam3(var73.getCodeItemValue());
                  var96.setPSWFDEId(var4.getPSWFDEId());
                  var96.setPSDEViewBaseName(
                     StringHelper.format(
                        "%1$s%2$s(%3$s:%4$s)", var1.getLogicName(), var3.getPSViewTypeName(), var35.getPSWorkflowName(), var73.getPSCodeItemName()
                     )
                  );
                  if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                     var96.setTitle(
                        StringHelper.format("%1$s%2$s(%3$s:%4$s)", var1.getLogicName(), var3.getTitle(), var35.getPSWorkflowName(), var73.getPSCodeItemName())
                     );
                  }

                  var96.setCodeName(StringHelper.format("%1$s_W%2$s_%3$s", var4.getCodeName(), var73.getCodeItemValue(), var3.getCodeName()));
                  this.initDEView(var1, var3, var35.getPSWorkflowId(), "W:" + var73.getCodeItemValue(), var96, "WFMDATAVIEW", var87);
               }
            }
         } else if (StringHelper.compare(var3.getPSViewTypeId(), "DEWFEDITVIEW", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEWFEDITVIEW2", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEWFEDITVIEW3", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEWFEDITVIEW4", true) == 0) {
            PSWorkflow var34 = var4.getPSWF();
            PSViewTypeStruct var41 = var3;
            if (!StringHelper.isNullOrEmpty(var34.getWFEditViewType())) {
               var41 = PSModelGlobal.getPSViewType(var34.getWFEditViewType());
            }

            String var53 = StringHelper.format("%1$s:D", var4.getCodeName());
            if (var2 != null) {
               var53 = StringHelper.format("%1$s:%2$s", var2.getCodeItemValue(), var53);
            }

            var53 = var53.toUpperCase();
            PSDEViewBase var65 = new PSDEViewBase();
            var65.setWFViewParam(0);
            var65.setPSWFDEId(var4.getPSWFDEId());
            if (var2 != null) {
               var65.setPSDEViewBaseName(
                  StringHelper.format(
                     "%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var41.getPSViewTypeName(), var2.getPSCodeItemName(), var34.getPSWorkflowName()
                  )
               );
               if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                  var65.setTitle(
                     StringHelper.format("%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var41.getTitle(), var2.getPSCodeItemName(), var34.getPSWorkflowName())
                  );
               }
            } else {
               var65.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var41.getPSViewTypeName(), var34.getPSWorkflowName()));
               if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                  var65.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var41.getTitle(), var34.getPSWorkflowName()));
               }
            }

            if (var2 != null) {
               var65.setCodeName(StringHelper.format("%3$s_%1$s_D_%2$s", var4.getCodeName(), var41.getCodeName(), var12));
            } else {
               var65.setCodeName(StringHelper.format("%1$s_D_%2$s", var4.getCodeName(), var41.getCodeName()));
            }

            String var78 = "";
            if (var2 != null) {
               var78 = StringHelper.format("%1$s:D", var2.getCodeItemValue());
            } else {
               var78 = StringHelper.format("D");
            }

            var65.setDyncMode(var8 ? 1 : 0);
            this.initDEView(var1, var41, var34.getPSWorkflowId(), var78, var65, "WFEDITVIEW", var53);
            if (var10) {
               PSViewTypeStruct var55 = PSModelGlobal.getPSViewType("DEWFEDITVIEW9");
               String var66 = StringHelper.format("%1$s:ED", var4.getCodeName());
               if (var2 != null) {
                  var66 = StringHelper.format("%1$s:%2$s", var2.getCodeItemValue(), var66);
               }

               String var67 = var66.toUpperCase();
               PSDEViewBase var80 = new PSDEViewBase();
               var80.setWFViewParam(0);
               var80.setPSWFDEId(var4.getPSWFDEId());
               if (var2 != null) {
                  var80.setPSDEViewBaseName(
                     StringHelper.format(
                        "%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var55.getPSViewTypeName(), var2.getPSCodeItemName(), var34.getPSWorkflowName()
                     )
                  );
                  if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                     var80.setTitle(
                        StringHelper.format("%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var55.getTitle(), var2.getPSCodeItemName(), var34.getPSWorkflowName())
                     );
                  }
               } else {
                  var80.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var55.getPSViewTypeName(), var34.getPSWorkflowName()));
                  if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                     var80.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var55.getTitle(), var34.getPSWorkflowName()));
                  }
               }

               if (var2 != null) {
                  var80.setCodeName(StringHelper.format("%3$s_%1$s_ED_%2$s", var4.getCodeName(), var55.getCodeName(), var12));
               } else {
                  var80.setCodeName(StringHelper.format("%1$s_ED_%2$s", var4.getCodeName(), var55.getCodeName()));
               }

               String var90 = "";
               if (var2 != null) {
                  var90 = StringHelper.format("%1$s:ED", var2.getCodeItemValue());
               } else {
                  var90 = StringHelper.format("ED");
               }

               var80.setDyncMode(var8 ? 1 : 0);
               this.initDEView(var1, var55, var34.getPSWorkflowId(), var90, var80, "WFEDITVIEW", var67);
            }

            if (var11 && var5 != null && var5.getPSCodeItems() != null) {
               PSWFProcessService var58 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, this.getSessionFactory());
               PSDEViewCtrlService var71 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());

               for (PSWFVersion var94 : var7) {
                  int var100 = var94.getWFVersion();
                  HashMap var103 = new HashMap();

                  for (PSWFProcess var109 : var58.selectByPSWFVersion(var94)) {
                     if (!StringHelper.isNullOrEmpty(var109.getWFStepValue())) {
                        var103.put(var109.getWFStepValue(), var109);
                     }
                  }

                  for (PSCodeItem var111 : var5.getPSCodeItems()) {
                     PSWFProcess var112 = (PSWFProcess)var103.get(var111.getCodeItemValue());
                     if (var112 != null) {
                        PSViewTypeStruct var114 = var41;
                        if (!StringHelper.isNullOrEmpty(var112.getWFEditViewType())) {
                           var114 = PSModelGlobal.getPSViewType(var112.getWFEditViewType());
                        }

                        String var115 = StringHelper.format("%1$s:%3$sW:%2$s", var4.getCodeName(), var111.getCodeItemValue(), var100 == 1 ? "" : var100);
                        if (var2 != null) {
                           var115 = StringHelper.format("%1$s:%2$s", var2.getCodeItemValue(), var115);
                        }

                        var115 = var115.toUpperCase();
                        PSDEViewBase var118 = new PSDEViewBase();
                        var118.setWFViewParam(1);
                        var118.setWFViewParam3(var111.getCodeItemValue());
                        var118.setPSWFDEId(var4.getPSWFDEId());
                        var118.setPSWFVersionId(var94.getPSWFVersionId());
                        var118.setPSWFVersionName(var94.getPSWFVersionName());
                        if (var2 != null) {
                           var118.setPSDEViewBaseName(
                              StringHelper.format(
                                 "%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)",
                                 var1.getLogicName(),
                                 var114.getPSViewTypeName(),
                                 var2.getPSCodeItemName(),
                                 var34.getPSWorkflowName(),
                                 var111.getPSCodeItemName(),
                                 var100
                              )
                           );
                           if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                              var118.setTitle(
                                 StringHelper.format(
                                    "%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)",
                                    var1.getLogicName(),
                                    var114.getTitle(),
                                    var2.getPSCodeItemName(),
                                    var34.getPSWorkflowName(),
                                    var111.getPSCodeItemName(),
                                    var100
                                 )
                              );
                           }
                        } else {
                           var118.setPSDEViewBaseName(
                              StringHelper.format(
                                 "%1$s%2$s(%3$sv%5$s:%4$s)",
                                 var1.getLogicName(),
                                 var114.getPSViewTypeName(),
                                 var34.getPSWorkflowName(),
                                 var111.getPSCodeItemName(),
                                 var100
                              )
                           );
                           if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                              var118.setTitle(
                                 StringHelper.format(
                                    "%1$s%2$s(%3$sv%5$s:%4$s)",
                                    var1.getLogicName(),
                                    var114.getTitle(),
                                    var34.getPSWorkflowName(),
                                    var111.getPSCodeItemName(),
                                    var100
                                 )
                              );
                           }
                        }

                        if (var2 != null) {
                           var118.setCodeName(
                              StringHelper.format(
                                 "%4$s_%1$s_%5$sW%2$s_%3$s",
                                 var4.getCodeName(),
                                 var111.getCodeItemValue(),
                                 var114.getCodeName(),
                                 var12,
                                 var100 == 1 ? "" : var100
                              )
                           );
                        } else {
                           var118.setCodeName(
                              StringHelper.format(
                                 "%1$s_%4$sW%2$s_%3$s", var4.getCodeName(), var111.getCodeItemValue(), var114.getCodeName(), var100 == 1 ? "" : var100
                              )
                           );
                        }

                        String var119 = "";
                        if (var2 != null) {
                           var119 = StringHelper.format("%1$s:%3$sD:%2$s", var2.getCodeItemValue(), var111.getCodeItemValue(), var100 == 1 ? "" : var100);
                        } else {
                           var119 = StringHelper.format("%2$sW:%1$s", var111.getCodeItemValue(), var100 == 1 ? "" : var100);
                        }

                        PSDEViewBase var121 = this.initDEView(var1, var114, var34.getPSWorkflowId(), var119, var118, "WFEDITVIEW", var115);
                        if (var121 != null && var112 != null && !StringHelper.isNullOrEmpty(var112.getPSDEFormId())) {
                           PSDEViewCtrl var31 = new PSDEViewCtrl();
                           var31.setPSDEViewBaseId(var121.getPSDEViewBaseId());
                           var31.setPSDEViewCtrlType("FORM");
                           if (var71.select(var31, true) && StringHelper.compare(var112.getPSDEFormId(), var31.getPSDEFormId(), false) != 0) {
                              var31.setPSDEFormId(var112.getPSDEFormId());
                              var31.setPSDEFormName(var112.getPSDEFormName());
                              var71.update(var31, false);
                           }
                        }
                     }
                  }
               }
            } else if (var10) {
               PSViewTypeStruct var56 = var41;
               String var68 = StringHelper.format("%1$s:W", var4.getCodeName());
               String var69 = var68.toUpperCase();
               PSDEViewBase var81 = new PSDEViewBase();
               var81.setWFViewParam(1);
               var81.setPSWFDEId(var4.getPSWFDEId());
               var81.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var56.getPSViewTypeName(), var34.getPSWorkflowName()));
               if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                  var81.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var56.getTitle(), var34.getPSWorkflowName()));
               }

               var81.setCodeName(StringHelper.format("%1$s_W_%2$s", var4.getCodeName(), var56.getCodeName()));
               String var92 = "W";
               var81.setDyncMode(var8 ? 1 : 0);
               PSDEViewBase var98 = this.initDEView(var1, var56, var34.getPSWorkflowId(), var92, var81, "WFEDITVIEW", var69);
            } else if (var8 && var7.size() > 0) {
               PSWFVersion var57 = (PSWFVersion)var7.get(0);
               PSViewTypeStruct var70 = var41;
               var78 = StringHelper.format("%1$s:W", var4.getCodeName());
               var78 = var78.toUpperCase();
               PSDEViewBase var93 = new PSDEViewBase();
               var93.setWFViewParam(1);
               var93.setPSWFDEId(var4.getPSWFDEId());
               var93.setPSWFVersionId(var57.getPSWFVersionId());
               var93.setPSWFVersionName(var57.getPSWFVersionName());
               var93.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var70.getPSViewTypeName(), var34.getPSWorkflowName()));
               if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                  var93.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var70.getTitle(), var34.getPSWorkflowName()));
               }

               var93.setCodeName(StringHelper.format("%1$s_W_%2$s", var4.getCodeName(), var70.getCodeName()));
               String var99 = "W";
               var93.setDyncMode(var8 ? 1 : 0);
               PSDEViewBase var102 = this.initDEView(var1, var70, var34.getPSWorkflowId(), var99, var93, "WFEDITVIEW", var78);
            }
         } else if (StringHelper.compare(var3.getPSViewTypeId(), "DEMOBWFMDVIEW", true) == 0) {
            PSWorkflow var33 = var4.getPSWF();
            String var37 = StringHelper.format("%1$s:D", var4.getCodeName());
            var37 = var37.toUpperCase();
            PSDEViewBase var51 = new PSDEViewBase();
            var51.setWFViewParam(0);
            var51.setPSWFDEId(var4.getPSWFDEId());
            var51.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getPSViewTypeName(), var33.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
               var51.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getTitle(), var33.getPSWorkflowName()));
            }

            var51.setCodeName(StringHelper.format("%1$s_D_%2$s", var4.getCodeName(), var3.getCodeName()));
            var51.setDyncMode(var8 ? 1 : 0);
            this.initDEView(var1, var3, var33.getPSWorkflowId(), "D", var51, "MOBWFMDATAVIEW", var37);
            var37 = StringHelper.format("%1$s:W", var4.getCodeName());
            var37 = var37.toUpperCase();
            var51 = new PSDEViewBase();
            var51.setWFViewParam(1);
            var51.setPSWFDEId(var4.getPSWFDEId());
            var51.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getPSViewTypeName(), var33.getPSWorkflowName()));
            if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
               var51.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var3.getTitle(), var33.getPSWorkflowName()));
            }

            var51.setCodeName(StringHelper.format("%1$s_W_%2$s", var4.getCodeName(), var3.getCodeName()));
            var51.setDyncMode(var8 ? 1 : 0);
            this.initDEView(var1, var3, var33.getPSWorkflowId(), "W", var51, "MOBWFMDATAVIEW", var37);
         } else if (StringHelper.compare(var3.getPSViewTypeId(), "DEMOBWFEDITVIEW", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEMOBWFEDITVIEW2", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEMOBWFEDITVIEW3", true) == 0
            || StringHelper.compare(var3.getPSViewTypeId(), "DEMOBWFEDITVIEW4", true) == 0) {
            PSWorkflow var13 = var4.getPSWF();
            PSViewTypeStruct var14 = var3;
            if (!StringHelper.isNullOrEmpty(var13.getMobWFEditViewType())) {
               var14 = PSModelGlobal.getPSViewType(var13.getMobWFEditViewType());
            }

            String var15 = StringHelper.format("%1$s:D", var4.getCodeName());
            if (var2 != null) {
               var15 = StringHelper.format("%1$s:%2$s", var2.getCodeItemValue(), var15);
            }

            var15 = var15.toUpperCase();
            PSDEViewBase var16 = new PSDEViewBase();
            var16.setWFViewParam(0);
            var16.setPSWFDEId(var4.getPSWFDEId());
            if (var2 != null) {
               var16.setPSDEViewBaseName(
                  StringHelper.format(
                     "%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var14.getPSViewTypeName(), var2.getPSCodeItemName(), var13.getPSWorkflowName()
                  )
               );
               if (!StringHelper.isNullOrEmpty(var14.getTitle())) {
                  var16.setTitle(
                     StringHelper.format("%1$s%2$s(%3$s)(%4$s)", var1.getLogicName(), var14.getTitle(), var2.getPSCodeItemName(), var13.getPSWorkflowName())
                  );
               }
            } else {
               var16.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var14.getPSViewTypeName(), var13.getPSWorkflowName()));
               if (!StringHelper.isNullOrEmpty(var14.getTitle())) {
                  var16.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var14.getTitle(), var13.getPSWorkflowName()));
               }
            }

            if (var2 != null) {
               var16.setCodeName(StringHelper.format("%3$s_%1$s_D_%2$s", var4.getCodeName(), var14.getCodeName(), var12));
            } else {
               var16.setCodeName(StringHelper.format("%1$s_D_%2$s", var4.getCodeName(), var14.getCodeName()));
            }

            String var17 = "";
            if (var2 != null) {
               var17 = StringHelper.format("%1$s:D", var2.getCodeItemValue());
            } else {
               var17 = StringHelper.format("D");
            }

            this.initDEView(var1, var14, var13.getPSWorkflowId(), var17, var16, "MOBWFEDITVIEW", var15);
            if (var5 != null && var5.getPSCodeItems() != null) {
               PSWFProcessService var50 = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, this.getSessionFactory());
               PSDEViewCtrlService var64 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());

               for (PSWFVersion var89 : var7) {
                  int var97 = var89.getWFVersion();
                  HashMap var101 = new HashMap();

                  for (PSWFProcess var23 : var50.selectByPSWFVersion(var89)) {
                     if (!StringHelper.isNullOrEmpty(var23.getWFStepValue())) {
                        var101.put(var23.getWFStepValue(), var23);
                     }
                  }

                  for (PSCodeItem var24 : var5.getPSCodeItems()) {
                     PSWFProcess var25 = (PSWFProcess)var101.get(var24.getCodeItemValue());
                     if (var25 != null) {
                        String var26 = StringHelper.format("%1$s:%3$sW:%2$s", var4.getCodeName(), var24.getCodeItemValue(), var97 == 1 ? "" : var97);
                        if (var2 != null) {
                           var26 = StringHelper.format("%1$s:%2$s", var2.getCodeItemValue(), var26);
                        }

                        var26 = var26.toUpperCase();
                        PSDEViewBase var27 = new PSDEViewBase();
                        var27.setWFViewParam(1);
                        var27.setWFViewParam3(var24.getCodeItemValue());
                        var27.setPSWFDEId(var4.getPSWFDEId());
                        var27.setPSWFVersionId(var89.getPSWFVersionId());
                        var27.setPSWFVersionName(var89.getPSWFVersionName());
                        if (var2 != null) {
                           var27.setPSDEViewBaseName(
                              StringHelper.format(
                                 "%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)",
                                 var1.getLogicName(),
                                 var14.getPSViewTypeName(),
                                 var2.getPSCodeItemName(),
                                 var13.getPSWorkflowName(),
                                 var24.getPSCodeItemName(),
                                 var97
                              )
                           );
                           if (!StringHelper.isNullOrEmpty(var14.getTitle())) {
                              var27.setTitle(
                                 StringHelper.format(
                                    "%1$s%2$s(%3$s)(%4$sv%6$s:%5$s)",
                                    var1.getLogicName(),
                                    var14.getTitle(),
                                    var2.getPSCodeItemName(),
                                    var13.getPSWorkflowName(),
                                    var24.getPSCodeItemName(),
                                    var97
                                 )
                              );
                           }
                        } else {
                           var27.setPSDEViewBaseName(
                              StringHelper.format(
                                 "%1$s%2$s(%3$sv%5$s:%4$s)",
                                 var1.getLogicName(),
                                 var14.getPSViewTypeName(),
                                 var13.getPSWorkflowName(),
                                 var24.getPSCodeItemName(),
                                 var97
                              )
                           );
                           if (!StringHelper.isNullOrEmpty(var14.getTitle())) {
                              var27.setTitle(
                                 StringHelper.format(
                                    "%1$s%2$s(%3$sv%5$s:%4$s)",
                                    var1.getLogicName(),
                                    var14.getTitle(),
                                    var13.getPSWorkflowName(),
                                    var24.getPSCodeItemName(),
                                    var97
                                 )
                              );
                           }
                        }

                        if (var2 != null) {
                           var27.setCodeName(
                              StringHelper.format(
                                 "%4$s_%1$s_%5$sW%2$s_%3$s", var4.getCodeName(), var24.getCodeItemValue(), var14.getCodeName(), var12, var97 == 1 ? "" : var97
                              )
                           );
                        } else {
                           var27.setCodeName(
                              StringHelper.format(
                                 "%1$s_%4$sW%2$s_%3$s", var4.getCodeName(), var24.getCodeItemValue(), var14.getCodeName(), var97 == 1 ? "" : var97
                              )
                           );
                        }

                        String var28 = "";
                        if (var2 != null) {
                           var28 = StringHelper.format("%1$s:%3$sD:%2$s", var2.getCodeItemValue(), var24.getCodeItemValue(), var97 == 1 ? "" : var97);
                        } else {
                           var28 = StringHelper.format("%2$sW:%1$s", var24.getCodeItemValue(), var97 == 1 ? "" : var97);
                        }

                        PSDEViewBase var29 = this.initDEView(var1, var14, var13.getPSWorkflowId(), var28, var27, "MOBWFEDITVIEW", var26);
                        if (var29 != null && var25 != null && !StringHelper.isNullOrEmpty(var25.getMobPSDEFormId())) {
                           PSDEViewCtrl var30 = new PSDEViewCtrl();
                           var30.setPSDEViewBaseId(var29.getPSDEViewBaseId());
                           var30.setPSDEViewCtrlType("FORM");
                           if (var64.select(var30, true) && StringHelper.compare(var25.getMobPSDEFormId(), var30.getPSDEFormId(), false) != 0) {
                              var30.setPSDEFormId(var25.getMobPSDEFormId());
                              var30.setPSDEFormName(var25.getMobPSDEFormName());
                              var64.update(var30, false);
                           }
                        }
                     }
                  }
               }
            } else if (var8 && var7.size() > 0) {
               PSWFVersion var49 = (PSWFVersion)var7.get(0);
               PSViewTypeStruct var63 = var14;
               var17 = StringHelper.format("%1$s:W", var4.getCodeName());
               var17 = var17.toUpperCase();
               PSDEViewBase var18 = new PSDEViewBase();
               var18.setWFViewParam(1);
               var18.setPSWFDEId(var4.getPSWFDEId());
               var18.setPSWFVersionId(var49.getPSWFVersionId());
               var18.setPSWFVersionName(var49.getPSWFVersionName());
               var18.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var63.getPSViewTypeName(), var13.getPSWorkflowName()));
               if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
                  var18.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var63.getTitle(), var13.getPSWorkflowName()));
               }

               var18.setCodeName(StringHelper.format("%1$s_W_%2$s", var4.getCodeName(), var63.getCodeName()));
               String var19 = "W";
               var18.setDyncMode(var8 ? 1 : 0);
               PSDEViewBase var20 = this.initDEView(var1, var63, var13.getPSWorkflowId(), var19, var18, "MOBWFEDITVIEW", var17);
            }
         }
      }
   }

   public void initDEMSViews(PSDEMainState var1, PSDataEntity var2) throws Exception {
      final PSDEMainState var3 = var1;
      final PSDataEntity var4 = var2 != null ? var2 : var1.getPSDE();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            if (StringHelper.isNullOrEmpty(var3.getEditViewType())) {
               for (String var5 : PSDEViewBaseService.initMSViewTypes) {
                  PSViewTypeStruct var6 = PSModelGlobal.getPSViewType(var5);
                  PSDEViewBaseService.this.initDMSView(var4, var6, var3);
               }
            } else {
               PSViewTypeStruct var7 = PSModelGlobal.getPSViewType(var3.getEditViewType());
               PSDEViewBaseService.this.initDMSView(var4, var7, var3);
            }
         }
      });
   }

   protected void initDMSView(PSDataEntity var1, PSViewTypeStruct var2, PSDEMainState var3) throws Exception {
      if (StringHelper.compare(var2.getPSViewTypeId(), "DEEDITVIEW", true) == 0
         || StringHelper.compare(var2.getPSViewTypeId(), "DEEDITVIEW2", true) == 0
         || StringHelper.compare(var2.getPSViewTypeId(), "DEEDITVIEW3", true) == 0
         || StringHelper.compare(var2.getPSViewTypeId(), "DEEDITVIEW4", true) == 0) {
         String var4 = StringHelper.format("MSTAG:%1$s", var3.getMSTag());
         var4 = var4.toUpperCase();
         PSDEViewBase var5 = new PSDEViewBase();
         var5.setPSDEMainStateId(var3.getPSDEMainStateId());
         var5.setPSDEViewBaseName(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var2.getPSViewTypeName(), var3.getPSDEMainStateName()));
         if (!StringHelper.isNullOrEmpty(var2.getTitle())) {
            var5.setTitle(StringHelper.format("%1$s%2$s(%3$s)", var1.getLogicName(), var2.getTitle(), var3.getPSDEMainStateName()));
         }

         var5.setCodeName(StringHelper.format("%1$s%2$s", var3.getCodeName(), var2.getCodeName()));
         PSDEViewBase var6 = this.initDEView(var1, var2, var3.getPSDEMainStateId(), "", var5, "EDITVIEW", var4);
         if (var6 != null && var3 != null && !StringHelper.isNullOrEmpty(var3.getPSDEFormId())) {
            PSDEViewCtrlService var7 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());
            PSDEViewCtrl var8 = new PSDEViewCtrl();
            var8.setPSDEViewBaseId(var6.getPSDEViewBaseId());
            var8.setPSDEViewCtrlType("FORM");
            if (var7.select(var8, true) && StringHelper.compare(var3.getPSDEFormId(), var8.getPSDEFormId(), false) != 0) {
               var8.setPSDEFormId(var3.getPSDEFormId());
               var8.setPSDEFormName(var3.getPSDEFormName());
               var7.update(var8, false);
            }
         }
      }
   }

   @Override
   protected void onBeforeRemove(PSDEViewBase var1) throws Exception {
      PSDEViewCtrlService var2 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());

      for (PSDEViewCtrl var5 : var2.selectByPSDEViewBase(var1)) {
         if (DataObject.getBoolValue(var5.getDefaultFlag(), false)) {
            var5.setDefaultFlag(0);
            var2.update(var5, false);
         }
      }

      super.onBeforeRemove(var1);
   }

   @Override
   protected void onBeforeRemoveTemp(PSDEViewBase var1) throws Exception {
      PSDEViewCtrlService var2 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());

      for (PSDEViewCtrl var5 : var2.selectTempByPSDEViewBase(var1)) {
         if (DataObject.getBoolValue(var5.getDefaultFlag(), false)) {
            var5.setDefaultFlag(0);
            var2.updateTemp(var5, false);
         }
      }

      super.onBeforeRemoveTemp(var1);
   }

   protected void onAfterCreate(PSDEViewBase var1) throws Exception {
      super.onAfterCreate(var1);
   }

   protected void onAfterUpdate(PSDEViewBase var1) throws Exception {
      String var2 = var1.getPSDE().getCodeName() + var1.getCodeName();
      PSAppDEViewService var3 = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, this.getSessionFactory());

      for (PSAppDEView var6 : var3.selectByPSDEViewBase(var1)) {
         if (DataObject.getBoolValue(var6.getSyncCodeName(), true) && StringHelper.compare(var6.getPSAppDEViewName(), var2, false) != 0) {
            PSAppDEView var7 = new PSAppDEView();
            var7.setPSAppDEViewId(var6.getPSAppDEViewId());
            var7.setPSAppDEViewName(var2);
            var3.update(var7, false);
         }
      }

      super.onAfterUpdate(var1);
   }

   protected void onAfterUpdateTempMajor(PSDEViewBase var1) throws Exception {
      if (DataObject.getBoolValue(var1.getDyncMode(), false)) {
         PSAppDEViewService var2 = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, this.getSessionFactory());

         for (PSAppDEView var5 : var2.selectByPSDEViewBase(var1)) {
            var2.initDynaView(var5);
         }

         super.onAfterUpdateTempMajor(var1);
      }
   }

   @Override
   protected void onJITPreview(PSDEViewBase var1) throws Exception {
      if (this.getWebContext() != null && this.getWebContext().getCurAjaxActionResult() != null) {
         String var2 = var1.getPSDEViewBaseId();
         if (KeyValueHelper.isTempKey(var1.getPSDEViewBaseId())) {
            this.getTemp(var1);
            var2 = (String)EntityBase.getOriginKey(var1);
            if (StringHelper.isNullOrEmpty(var2)) {
               throw new Exception(StringHelper.format("实体视图还未保存"));
            }
         }

         PSDEViewBase var3 = new PSDEViewBase();
         var3.setPSDEViewBaseId(var2);
         this.get(var3);
         PSAppDEViewService var4 = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, this.getSessionFactory());
         ArrayList<PSAppDEView> var5 = var4.selectByPSDEViewBase(var3);
         if (var5.size() == 0) {
            throw new Exception("实体视图还未加入到应用");
         }

         PSSysApp var6 = null;
         PSAppDEView var7 = null;

         for (PSAppDEView var9 : var5) {
            if (var6 == null) {
               var6 = var9.getPSSysApp();
               var7 = var9;
               if (DataObject.getBoolValue(var6.getDefaultPub(), false)) {
                  break;
               }
            } else {
               PSSysApp var10 = var9.getPSSysApp();
               if (DataObject.getBoolValue(var10.getDefaultPub(), false)) {
                  var7 = var9;
                  break;
               }
            }
         }

         var4.jITPreview(var7);
      } else {
         throw new Exception("当前请求环境不正确");
      }
   }

   protected void fillDEViewCtrlParams(PSDEViewCtrl var1, PSVTCtrl var2) throws Exception {
      if (var2.getCtrlParam() != null) {
         var1.setCtrlParam(var2.getCtrlParam());
      }

      if (var2.getCtrlParam2() != null) {
         var1.setCtrlParam2(var2.getCtrlParam2());
      }

      if (var2.getCtrlParam3() != null) {
         var1.setCtrlParam3(var2.getCtrlParam3());
      }

      if (var2.getCtrlParam4() != null) {
         var1.setCtrlParam4(var2.getCtrlParam4());
      }

      if (var2.getCtrlParam5() != null) {
         var1.setCtrlParam5(var2.getCtrlParam5());
      }

      if (var2.getCtrlParam6() != null) {
         var1.setCtrlParam6(var2.getCtrlParam6());
      }

      if (var2.getCtrlParam7() != null) {
         var1.setCtrlParam7(var2.getCtrlParam7());
      }

      if (var2.getCtrlParam8() != null) {
         var1.setCtrlParam8(var2.getCtrlParam8());
      }

      if (var2.getCtrlParam9() != null) {
         var1.setCtrlParam9(var2.getCtrlParam9());
      }

      if (var2.getCtrlParam10() != null) {
         var1.setCtrlParam10(var2.getCtrlParam10());
      }
   }

   @Override
   public void getDraftWithModel(PSDEViewBase var1) throws Exception {
      this.getDraftTempMajor(var1);
      var1.setViewModel(this.getViewModel(var1));
   }

   @Override
   public void getWithModel(PSDEViewBase var1) throws Exception {
      if (!KeyValueHelper.isTempKey(var1.getPSDEViewBaseId())) {
         this.getTempMajor(var1);
      } else {
         this.getTemp(var1);
      }

      var1.setViewModel(this.getViewModel(var1));
   }

   protected String getViewModel(PSDEViewBase var1) throws Exception {
      XmlNode var2 = new XmlNode();
      var2.setNodeName("DEVIEWCONFIG");
      var2.setAttribute("PSDEID", var1.getPSDEId());
      var2.setAttribute("PSSYSTEMID", var1.getPSSystemId());
      var2.setAttribute("PSDEVIEWBASEID", var1.getPSDEViewBaseId());
      PSDEViewCtrlService var3 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class.getCanonicalName(), this.getSessionFactory());
      ArrayList<PSDEViewCtrl> var4 = var3.selectTempByPSDEViewBase(var1);
      Collections.sort(var4, new Comparator<PSDEViewCtrl>() {
         public int compare(PSDEViewCtrl var1, PSDEViewCtrl var2x) {
            return StringHelper.compare(var1.getPSDEViewCtrlName(), var2x.getPSDEViewCtrlName(), false);
         }
      });

      for (PSDEViewCtrl var6 : var4) {
         XmlNode var7 = new XmlNode();
         var7.setNodeName("DEVIEWCTRL");
         var6.fillXmlNode(var7, true);
         var2.addNode(var7);
      }

      PSDEViewRVService var14 = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class.getCanonicalName(), this.getSessionFactory());
      ArrayList<PSDEViewRV> var15 = var14.selectTempByMajorPSDEView(var1);
      Collections.sort(var15, new Comparator<PSDEViewRV>() {
         public int compare(PSDEViewRV var1, PSDEViewRV var2x) {
            return StringHelper.compare(var1.getPSDEViewRVName(), var2x.getPSDEViewRVName(), false);
         }
      });

      for (PSDEViewRV var8 : var15) {
         XmlNode var9 = new XmlNode();
         var9.setNodeName("DEVIEWRV");
         var8.fillXmlNode(var9, true);
         var2.addNode(var9);
      }

      PSDEViewLogicService var17 = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class.getCanonicalName(), this.getSessionFactory());

      for (PSDEViewLogic var10 : var17.selectTempByPSDEViewBase(var1)) {
         XmlNode var11 = new XmlNode();
         var11.setNodeName("DEVIEWLOGIC");
         var10.fillXmlNode(var11, true);
         var2.addNode(var11);
      }

      PSDEViewEngineService var20 = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class.getCanonicalName(), this.getSessionFactory());

      for (PSDEViewEngine var12 : var20.selectTempByPSDEViewBase(var1)) {
         XmlNode var13 = new XmlNode();
         var13.setNodeName("DEVIEWENGINE");
         var12.fillXmlNode(var13, true);
         var2.addNode(var13);
      }

      return XmlNode.export(var2);
   }

   @Override
   public void createWithModel(PSDEViewBase var1) throws Exception {
      final PSDEViewBase var2 = var1;
      var2.setSessionFactory(this.getSessionFactory());
      log.debug("开始[createWithModel]作业");
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               PSDEViewCtrlService var2x = (PSDEViewCtrlService)ServiceGlobal.getService(
                  PSDEViewCtrlService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewCtrl> var3 = var2x.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewCtrl> var4 = new HashMap<String, PSDEViewCtrl>();

               for (PSDEViewCtrl var6 : var3) {
                  var4.put(var6.getPSDEViewCtrlId(), var6);
               }

               PSDEViewRVService var18 = (PSDEViewRVService)ServiceGlobal.getService(
                  PSDEViewRVService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewRV> var19 = var18.selectTempByMajorPSDEView(var2);
               HashMap<String, PSDEViewRV> var7 = new HashMap<String, PSDEViewRV>();

               for (PSDEViewRV var9 : var19) {
                  var7.put(var9.getPSDEViewRVId(), var9);
               }

               PSDEViewLogicService var20 = (PSDEViewLogicService)ServiceGlobal.getService(
                  PSDEViewLogicService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewLogic> var21 = var20.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewLogic> var10 = new HashMap<String, PSDEViewLogic>();

               for (PSDEViewLogic var12 : var21) {
                  var10.put(var12.getPSDEViewLogicId(), var12);
               }

               PSDEViewEngineService var22 = (PSDEViewEngineService)ServiceGlobal.getService(
                  PSDEViewEngineService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewEngine> var23 = var22.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewEngine> var13 = new HashMap<String, PSDEViewEngine>();

               for (PSDEViewEngine var15 : var23) {
                  var13.put(var15.getPSDEViewEngineId(), var15);
               }

               String var24 = var2.getViewModel();
               XmlNode var25 = XmlNode.loadFromXML(var24);
               if (var25 != null) {
                  var25.setAttribute("PSDEID", var2.getPSDEId());
                  var25.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                  var25.setAttribute("PSDEVIEWBASEID", var2.getPSDEViewBaseId());
                  PSDEViewBaseService.this.updatePSDEViewModel(var2, var25, var4, var7, var10, var13);
                  var2.setViewModel(XmlNode.export(var25));
               } else {
                  var2.setViewModel(null);
               }

               if (var10.size() > 0) {
                  for (PSDEViewLogic var17 : var10.values()) {
                     var20.removeTemp(var17);
                  }
               }

               if (var7.size() > 0) {
                  for (PSDEViewRV var28 : var7.values()) {
                     var18.removeTemp(var28);
                  }
               }

               if (var4.size() > 0) {
                  for (PSDEViewCtrl var29 : var4.values()) {
                     var2x.removeTemp(var29);
                  }
               }

               PSDEViewBaseService.this.createTempMajor(var2);
            }
         }
      );
   }

   @Override
   public void updateWithModel(PSDEViewBase var1) throws Exception {
      final PSDEViewBase var2 = var1;
      var2.setSessionFactory(this.getSessionFactory());
      log.debug("开始[updateWithModel]作业");
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               Object var2x = null;
               PSDEViewCtrlService var3 = (PSDEViewCtrlService)ServiceGlobal.getService(
                  PSDEViewCtrlService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewCtrl> var4 = var3.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewCtrl> var5 = new HashMap<String, PSDEViewCtrl>();

               for (PSDEViewCtrl var7 : var4) {
                  var5.put(var7.getPSDEViewCtrlId(), var7);
               }

               PSDEViewRVService var20 = (PSDEViewRVService)ServiceGlobal.getService(
                  PSDEViewRVService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewRV> var21 = var20.selectTempByMajorPSDEView(var2);
               HashMap<String, PSDEViewRV> var8 = new HashMap<String, PSDEViewRV>();

               for (PSDEViewRV var10 : var21) {
                  var8.put(var10.getPSDEViewRVId(), var10);
               }

               PSDEViewLogicService var22 = (PSDEViewLogicService)ServiceGlobal.getService(
                  PSDEViewLogicService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewLogic> var23 = var22.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewLogic> var11 = new HashMap<String, PSDEViewLogic>();

               for (PSDEViewLogic var13 : var23) {
                  var11.put(var13.getPSDEViewLogicId(), var13);
               }

               PSDEViewEngineService var24 = (PSDEViewEngineService)ServiceGlobal.getService(
                  PSDEViewEngineService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewEngine> var25 = var24.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewEngine> var14 = new HashMap<String, PSDEViewEngine>();

               for (PSDEViewEngine var16 : var25) {
                  var14.put(var16.getPSDEViewEngineId(), var16);
               }

               String var26 = var2.getViewModel();
               XmlNode var27 = XmlNode.loadFromXML(var26);
               if (var27 != null) {
                  var27.setAttribute("PSDEID", var2.getPSDEId());
                  var27.setAttribute("PSDEVIEWBASEID", var2.getPSDEViewBaseId());
                  var27.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                  PSDEViewBaseService.this.updatePSDEViewModel(var2, var27, var5, var8, var11, var14);
                  var2.setViewModel(XmlNode.export(var27));
               } else {
                  var2.setViewModel(null);
               }

               boolean var17 = false;
               if (var11.size() > 0) {
                  for (PSDEViewLogic var19 : var11.values()) {
                     var22.removeTemp(var19);
                     var17 = true;
                  }
               }

               if (var8.size() > 0) {
                  for (PSDEViewRV var33 : var8.values()) {
                     var20.removeTemp(var33);
                     var17 = true;
                  }
               }

               if (var5.size() > 0) {
                  for (PSDEViewCtrl var34 : var5.values()) {
                     var3.removeTemp(var34);
                     var17 = true;
                  }
               }

               PSDEViewBaseService.this.updateTempMajor(var2);
            }
         }
      );
   }

   @Override
   public void previewSave(PSDEViewBase var1) throws Exception {
      final PSDEViewBase var2 = var1;
      var2.setSessionFactory(this.getSessionFactory());
      log.debug("开始[updateWithModel]作业");
      this.doServiceWork(
         new IServiceWork() {
            @Override
            public void execute(ITransaction var1) throws Exception {
               Object var2x = null;
               PSDEViewCtrlService var3 = (PSDEViewCtrlService)ServiceGlobal.getService(
                  PSDEViewCtrlService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewCtrl> var4 = var3.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewCtrl> var5 = new HashMap<String, PSDEViewCtrl>();

               for (PSDEViewCtrl var7 : var4) {
                  var5.put(var7.getPSDEViewCtrlId(), var7);
               }

               PSDEViewRVService var20 = (PSDEViewRVService)ServiceGlobal.getService(
                  PSDEViewRVService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewRV> var21 = var20.selectTempByMajorPSDEView(var2);
               HashMap<String, PSDEViewRV> var8 = new HashMap<String, PSDEViewRV>();

               for (PSDEViewRV var10 : var21) {
                  var8.put(var10.getPSDEViewRVId(), var10);
               }

               PSDEViewLogicService var22 = (PSDEViewLogicService)ServiceGlobal.getService(
                  PSDEViewLogicService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewLogic> var23 = var22.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewLogic> var11 = new HashMap<String, PSDEViewLogic>();

               for (PSDEViewLogic var13 : var23) {
                  var11.put(var13.getPSDEViewLogicId(), var13);
               }

               PSDEViewEngineService var24 = (PSDEViewEngineService)ServiceGlobal.getService(
                  PSDEViewEngineService.class.getCanonicalName(), PSDEViewBaseService.this.getSessionFactory()
               );
               ArrayList<PSDEViewEngine> var25 = var24.selectTempByPSDEViewBase(var2);
               HashMap<String, PSDEViewEngine> var14 = new HashMap<String, PSDEViewEngine>();

               for (PSDEViewEngine var16 : var25) {
                  var14.put(var16.getPSDEViewEngineId(), var16);
               }

               String var26 = var2.getViewModel();
               XmlNode var27 = XmlNode.loadFromXML(var26);
               if (var27 != null) {
                  var27.setAttribute("PSDEID", var2.getPSDEId());
                  var27.setAttribute("PSDEVIEWBASEID", var2.getPSDEViewBaseId());
                  var27.setAttribute("PSSYSTEMID", var2.getPSSystemId());
                  PSDEViewBaseService.this.updatePSDEViewModel(var2, var27, var5, var8, var11, var14);
                  var2.setViewModel(XmlNode.export(var27));
               } else {
                  var2.setViewModel(null);
               }

               boolean var17 = false;
               if (var11.size() > 0) {
                  for (PSDEViewLogic var19 : var11.values()) {
                     var22.removeTemp(var19);
                     var17 = true;
                  }
               }

               if (var8.size() > 0) {
                  for (PSDEViewRV var33 : var8.values()) {
                     var20.removeTemp(var33);
                     var17 = true;
                  }
               }

               if (var5.size() > 0) {
                  for (PSDEViewCtrl var34 : var5.values()) {
                     var3.removeTemp(var34);
                     var17 = true;
                  }
               }
            }
         }
      );
   }

   protected void updatePSDEViewModel(
      PSDEViewBase var1,
      XmlNode var2,
      HashMap<String, PSDEViewCtrl> var3,
      HashMap<String, PSDEViewRV> var4,
      HashMap<String, PSDEViewLogic> var5,
      HashMap<String, PSDEViewEngine> var6
   ) throws Exception {
      Iterator var7 = var2.getChildNodes();
      if (var7 != null) {
         ArrayList<XmlNode> var8 = new ArrayList<XmlNode>();
         ArrayList<XmlNode> var9 = new ArrayList<XmlNode>();
         ArrayList<XmlNode> var10 = new ArrayList<XmlNode>();
         ArrayList<XmlNode> var11 = new ArrayList<XmlNode>();
         PSDEViewCtrlService var12 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class.getCanonicalName(), this.getSessionFactory());
         PSDEViewRVService var13 = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class.getCanonicalName(), this.getSessionFactory());
         PSDEViewLogicService var14 = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class.getCanonicalName(), this.getSessionFactory());
         PSDEViewEngineService var15 = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class.getCanonicalName(), this.getSessionFactory());

         while (var7.hasNext()) {
            XmlNode var16 = (XmlNode)var7.next();
            if (StringHelper.compare(var16.getNodeName(), "DEVIEWCTRL", true) == 0) {
               String var17 = var16.getAttribute("PSDEVIEWCTRLID", "");
               if (!StringHelper.isNullOrEmpty(var17)) {
                  PSDEViewCtrl var18 = (PSDEViewCtrl)var3.remove(var17);
                  if (var18 != null) {
                     boolean var19 = false;
                     if (StringHelper.compare(var18.getPSDEViewBaseId(), var1.getPSDEViewBaseId(), false) != 0) {
                        var18.setPSDEViewBaseId(var1.getPSDEViewBaseId());
                        var19 = true;
                     }

                     if (StringHelper.compare(var18.getPSDEViewBaseName(), var1.getPSDEViewBaseName(), false) != 0) {
                        var18.setPSDEViewBaseName(var1.getPSDEViewBaseName());
                        var19 = true;
                     }

                     if (var19) {
                        var12.updateTemp(var18);
                     }

                     var16.resetAttributes();
                     var18.fillXmlNode(var16, false);
                     var8.add(var16);
                  }
               }
            } else if (StringHelper.compare(var16.getNodeName(), "DEVIEWRV", true) == 0) {
               String var24 = var16.getAttribute("PSDEVIEWRVID", "");
               if (!StringHelper.isNullOrEmpty(var24)) {
                  PSDEViewRV var31 = (PSDEViewRV)var4.remove(var24);
                  if (var31 != null) {
                     boolean var34 = false;
                     if (StringHelper.compare(var31.getMajorPSDEViewId(), var1.getPSDEViewBaseId(), false) != 0) {
                        var31.setMajorPSDEViewId(var1.getPSDEViewBaseId());
                        var34 = true;
                     }

                     if (StringHelper.compare(var31.getMajorPSDEViewName(), var1.getPSDEViewBaseName(), false) != 0) {
                        var31.setMajorPSDEViewName(var1.getPSDEViewBaseName());
                        var34 = true;
                     }

                     if (var34) {
                        var13.updateTemp(var31);
                     }

                     var16.resetAttributes();
                     var31.fillXmlNode(var16, false);
                     var9.add(var16);
                  }
               }
            } else if (StringHelper.compare(var16.getNodeName(), "DEVIEWLOGIC", true) == 0) {
               String var25 = var16.getAttribute("PSDEVIEWLOGICID", "");
               if (!StringHelper.isNullOrEmpty(var25)) {
                  PSDEViewLogic var32 = (PSDEViewLogic)var5.remove(var25);
                  if (var32 != null) {
                     boolean var35 = false;
                     if (StringHelper.compare(var32.getPSDEViewBaseId(), var1.getPSDEViewBaseId(), false) != 0) {
                        var32.setPSDEViewBaseId(var1.getPSDEViewBaseId());
                        var35 = true;
                     }

                     if (StringHelper.compare(var32.getPSDEViewBaseName(), var1.getPSDEViewBaseName(), false) != 0) {
                        var32.setPSDEViewBaseName(var1.getPSDEViewBaseName());
                        var35 = true;
                     }

                     if (var35) {
                        var14.updateTemp(var32);
                     }

                     var16.resetAttributes();
                     var32.fillXmlNode(var16, false);
                     var10.add(var16);
                  }
               }
            } else if (StringHelper.compare(var16.getNodeName(), "DEVIEWENGINE", true) == 0) {
               String var26 = var16.getAttribute("PSDEVIEWENGINEID", "");
               if (!StringHelper.isNullOrEmpty(var26)) {
                  PSDEViewEngine var33 = (PSDEViewEngine)var6.remove(var26);
                  if (var33 != null) {
                     boolean var36 = false;
                     if (StringHelper.compare(var33.getPSDEViewBaseId(), var1.getPSDEViewBaseId(), false) != 0) {
                        var33.setPSDEViewBaseId(var1.getPSDEViewBaseId());
                        var36 = true;
                     }

                     if (StringHelper.compare(var33.getPSDEViewBaseName(), var1.getPSDEViewBaseName(), false) != 0) {
                        var33.setPSDEViewBaseName(var1.getPSDEViewBaseName());
                        var36 = true;
                     }

                     if (var36) {
                        var15.updateTemp(var33);
                     }

                     var16.resetAttributes();
                     var33.fillXmlNode(var16, false);
                     var11.add(var16);
                  }
               }
            }
         }

         var2.resetChildNodes();

         for (XmlNode var27 : var8) {
            var2.addNode(var27);
         }

         for (XmlNode var28 : var9) {
            var2.addNode(var28);
         }

         for (XmlNode var29 : var10) {
            var2.addNode(var29);
         }

         for (XmlNode var30 : var11) {
            var2.addNode(var30);
         }
      }
   }

   @Override
   public void getDraftFromWithModel(PSDEViewBase var1) throws Exception {
      super.getDraftTempMajorFrom(var1);
      var1.setViewModel(this.getViewModel(var1));
   }

   @Override
   public ObjectNode fillModelV2(ObjectNode var1, PSDEViewBase var2, String var3) throws Exception {
      var1 = super.fillModelV2(var1, var2, var3);
      if (var1 != null
         && (
            StringHelper.compare(var2.getPSDEViewBaseType(), "DEREDIRECTVIEW", false) == 0
               || StringHelper.compare(var2.getPSDEViewBaseType(), "DEMOBREDIRECTVIEW", false) == 0
         )
         && !StringHelper.isNullOrEmpty(var2.getViewParam7())) {
         try {
            String var4 = this.getModelV2UniqueTag("PSDEACTION", var2.getViewParam7(), var3);
            var1.remove("viewparam7");
            var1.put("viewparam7", var4);
         } catch (Exception var5) {
            log.error(var5);
         }
      }

      return var1;
   }

   public boolean fillModelV2Key(PSDEViewBase var1, ObjectNode var2, String var3, String var4, boolean var5) throws Exception {
      boolean var6 = super.fillModelV2Key(var1, var2, var3, var4, var5);
      if (var5
         && var2 != null
         && (
            StringHelper.compare(var1.getPSDEViewBaseType(), "DEREDIRECTVIEW", false) == 0
               || StringHelper.compare(var1.getPSDEViewBaseType(), "DEMOBREDIRECTVIEW", false) == 0
         )) {
         try {
            String var7 = JsonNodeHelper.getString(var2, "viewparam7", null);
            if (!StringHelper.isNullOrEmpty(var7)) {
               var7 = this.getModelV2Key("PSDEACTION", var7, var3, "VIEWPARAM7");
               var1.setViewParam7(var7);
            }
         } catch (Exception var8) {
            log.error(var8);
            var1.setViewParam7(null);
         }
      }

      return var6;
   }

   @Override
   protected void onBeforeRemoveByPSDE(PSDataEntity var1, ArrayList<PSDEViewBase> var2) throws Exception {
      PSDEViewRVService var3 = (PSDEViewRVService)ServiceGlobal.getService(PSDEViewRVService.class, this.getSessionFactory());

      for (PSDEViewBase var5 : var2) {
         var3.removeByMajorPSDEView(var5);
      }
   }
}
