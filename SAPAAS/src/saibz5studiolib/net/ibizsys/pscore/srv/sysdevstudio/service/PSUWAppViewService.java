package net.ibizsys.pscore.srv.sysdevstudio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppUtilView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeStruct;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewRV;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewRVService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWAppView;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWAppViewService extends PSUWAppViewServiceBase {
   private static final Log log = LogFactory.getLog(PSUWAppViewService.class);

   @Override
   protected void onChangeSearchForm(PSUWAppView var1) throws Exception {
      String var2 = this.getWebContext().getPostValue("srfactionparam");
      if (!StringHelper.isNullOrEmpty(var2)) {
         JSONObject var3 = JSONObject.fromString(var2);
         String var4 = var3.optString("srforikey");
         if (StringHelper.isNullOrEmpty(var4)) {
            var4 = var3.optString("srfkey");
         }

         if (!StringHelper.isNullOrEmpty(var4)) {
            var1.setPSDESearchFormId(var4);
            var1.setPSDESearchFormName(var3.optString("psdeformname"));
         }
      }
   }

   @Override
   protected void onChangeEditForm(PSUWAppView var1) throws Exception {
      String var2 = this.getWebContext().getPostValue("srfactionparam");
      if (!StringHelper.isNullOrEmpty(var2)) {
         JSONObject var3 = JSONObject.fromString(var2);
         String var4 = var3.optString("srforikey");
         if (StringHelper.isNullOrEmpty(var4)) {
            var4 = var3.optString("srfkey");
         }

         if (!StringHelper.isNullOrEmpty(var4)) {
            var1.setPSDEFormId(var4);
            var1.setPSDEFormName(var3.optString("psdeformname"));
         }
      }
   }

   @Override
   protected void onChangeToolbar(PSUWAppView var1) throws Exception {
      String var2 = this.getWebContext().getPostValue("srfactionparam");
      if (!StringHelper.isNullOrEmpty(var2)) {
         JSONObject var3 = JSONObject.fromString(var2);
         String var4 = var3.optString("srforikey");
         if (StringHelper.isNullOrEmpty(var4)) {
            var4 = var3.optString("srfkey");
         }

         if (!StringHelper.isNullOrEmpty(var4)) {
            var1.setPSDEToolbarId(var4);
            var1.setPSDEToolbarName(var3.optString("psdetoolbarname"));
         }
      }
   }

   @Override
   protected void onChangeGrid(PSUWAppView var1) throws Exception {
      String var2 = this.getWebContext().getPostValue("srfactionparam");
      if (!StringHelper.isNullOrEmpty(var2)) {
         JSONObject var3 = JSONObject.fromString(var2);
         String var4 = var3.optString("srforikey");
         if (StringHelper.isNullOrEmpty(var4)) {
            var4 = var3.optString("srfkey");
         }

         if (!StringHelper.isNullOrEmpty(var4)) {
            var1.setPSDEGridId(var4);
            var1.setPSDEGridName(var3.optString("psdegridname"));
         }
      }
   }

   @Override
   protected void onUpdateViewType(PSUWAppView var1) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1.getPSAppViewType())) {
         if (var1.getPSAppViewType().indexOf("DE") == 0) {
            var1.setPSDEViewBaseType(var1.getPSAppViewType().replaceAll("\\d+", ""));
            var1.setSRFNextForm("de");
         } else {
            if (StringHelper.isNullOrEmpty(var1.getPSAppModuleId())) {
               PSAppModuleService var2 = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, this.getSessionFactory());
               PSAppModule var3 = new PSAppModule();
               var3.setPSSysAppId(var1.getPSSysAppId());
               var3.setDefaultFlag(1);
               if (!var2.select(var3, true)) {
                  var3.reset();
                  var3.setPSSysAppId(var1.getPSSysAppId());
                  if (!var2.select(var3, true)) {
                     var3 = null;
                  }
               }

               if (var3 != null) {
                  var1.setPSAppModuleId(var3.getPSAppModuleId());
                  var1.setPSAppModuleName(var3.getPSAppModuleName());
               }
            }

            PSViewTypeStruct var8 = PSModelGlobal.getPSViewType(var1.getPSAppViewType());
            var1.setPSUWAppViewName(var8.getPSViewTypeName());
            if (StringHelper.compare(var1.getPSAppViewType(), "APPINDEXVIEW", true) == 0) {
               PSAppIndexViewService var12 = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, this.getSessionFactory());
               String var15 = var8.getTitle();
               String var18 = var8.getCodeName();
               int var21 = 0;

               while (true) {
                  var21++;
                  PSAppIndexView var24 = new PSAppIndexView();
                  var24.setPSSysAppId(var1.getPSSysAppId());
                  var24.setPSAppIndexViewName(StringHelper.format("%1$s%2$s", var18, var21 == 1 ? "" : var21));
                  if (!var12.select(var24, true)) {
                     var1.setCodeName(var24.getPSAppIndexViewName());
                     var24.reset();
                     var24.setPSSysAppId(var1.getPSSysAppId());
                     var24.setTitle(StringHelper.format("%1$s%2$s", var15, var21 == 1 ? "" : var21));
                     if (!var12.select(var24, true)) {
                        var1.setTitle(var24.getTitle());
                        break;
                     }
                  }
               }
            } else if (StringHelper.compare(var1.getPSAppViewType(), "APPPORTALVIEW", true) == 0) {
               PSAppPortalViewService var11 = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, this.getSessionFactory());
               String var14 = var8.getTitle();
               String var17 = var8.getCodeName();
               int var20 = 0;

               while (true) {
                  var20++;
                  PSAppPortalView var23 = new PSAppPortalView();
                  var23.setPSSysAppId(var1.getPSSysAppId());
                  var23.setPSAppPortalViewName(StringHelper.format("%1$s%2$s", var17, var20 == 1 ? "" : var20));
                  if (!var11.select(var23, true)) {
                     var1.setCodeName(var23.getPSAppPortalViewName());
                     var23.reset();
                     var23.setPSSysAppId(var1.getPSSysAppId());
                     var23.setTitle(StringHelper.format("%1$s%2$s", var14, var20 == 1 ? "" : var20));
                     if (!var11.select(var23, true)) {
                        var1.setTitle(var23.getTitle());
                        break;
                     }
                  }
               }
            } else if (StringHelper.compare(var1.getPSAppViewType(), "APPPANELVIEW", true) == 0) {
               PSAppPanelViewService var10 = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, this.getSessionFactory());
               String var13 = var8.getTitle();
               String var16 = var8.getCodeName();
               int var19 = 0;

               while (true) {
                  var19++;
                  PSAppPanelView var22 = new PSAppPanelView();
                  var22.setPSSysAppId(var1.getPSSysAppId());
                  var22.setPSAppPanelViewName(StringHelper.format("%1$s%2$s", var16, var19 == 1 ? "" : var19));
                  if (!var10.select(var22, true)) {
                     var1.setCodeName(var22.getPSAppPanelViewName());
                     var22.reset();
                     var22.setPSSysAppId(var1.getPSSysAppId());
                     var22.setTitle(StringHelper.format("%1$s%2$s", var13, var19 == 1 ? "" : var19));
                     if (!var10.select(var22, true)) {
                        var1.setTitle(var22.getTitle());
                        break;
                     }
                  }
               }
            } else {
               PSAppUtilViewService var9 = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, this.getSessionFactory());
               String var4 = var8.getTitle();
               String var5 = var8.getCodeName();
               int var6 = 0;

               while (true) {
                  var6++;
                  PSAppUtilView var7 = new PSAppUtilView();
                  var7.setPSSysAppId(var1.getPSSysAppId());
                  var7.setPSAppUtilViewName(StringHelper.format("%1$s%2$s", var5, var6 == 1 ? "" : var6));
                  if (!var9.select(var7, true)) {
                     var1.setCodeName(var7.getPSAppUtilViewName());
                     var7.reset();
                     var7.setPSSysAppId(var1.getPSSysAppId());
                     var7.setTitle(StringHelper.format("%1$s%2$s", var4, var6 == 1 ? "" : var6));
                     if (!var9.select(var7, true)) {
                        var1.setTitle(var7.getTitle());
                        break;
                     }
                  }
               }
            }

            var1.setSRFNextForm("finish");
         }

         this.update(var1);
      }
   }

   @Override
   protected void onInitViewParam(PSUWAppView var1) throws Exception {
      PSUWAppView var2 = new PSUWAppView();
      var2.setPSUWAppViewId(var1.getPSUWAppViewId());
      this.get(var2);
      var1.setPSAppViewType(var2.getPSAppViewType());
      if (!StringHelper.isNullOrEmpty(var1.getPSAppViewType())) {
         PSSysAppService var3 = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, this.getSessionFactory());
         PSSysApp var4 = new PSSysApp();
         var4.setPSSysAppId(var2.getPSSysAppId());
         var3.initPSAppModules(var4);
         if (var1.getPSAppViewType().indexOf("DE") == 0) {
            PSDataEntity var5 = null;
            if (!StringHelper.isNullOrEmpty(var1.getPSDEId())) {
               var5 = new PSDataEntity();
               var5.setSessionFactory(this.getSessionFactory());
               var5.setPSDataEntityId(var1.getPSDEId());

               try {
                  var5.get(true);
               } catch (Exception var8) {
                  throw new Exception(StringHelper.format("无法获取指定实体对象[%1$s]", var1.getPSDEId()));
               }

               PSAppModuleService var6 = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, this.getSessionFactory());
               PSAppModule var7 = new PSAppModule();
               var7.setPSSysAppId(var2.getPSSysAppId());
               var7.setPSModuleId(var5.getPSModuleId());
               if (!var6.select(var7, true)) {
                  var7.reset();
                  var7.setPSSysAppId(var2.getPSSysAppId());
                  var7.setCodeName(var5.getPSModule().getCodeName());
                  if (!var6.select(var7, true)) {
                     var7.reset();
                     var7.setPSSysAppId(var2.getPSSysAppId());
                     var7.setDefaultFlag(1);
                     if (!var6.select(var7, true)) {
                        var7 = null;
                     }
                  }
               }

               if (var7 != null) {
                  var1.setPSAppModuleId(var7.getPSAppModuleId());
                  var1.setPSAppModuleName(var7.getPSAppModuleName());
               }
            }

            PSViewTypeStruct var9 = PSModelGlobal.getPSViewType(var1.getPSAppViewType());
            this.initPSUWAppView(var1, var5, var9);
            var1.setSRFNextForm("finish");
            if (!StringHelper.isNullOrEmpty(var1.getPSDEGridId())) {
               var1.setSRFNextForm("grid");
            } else if (!StringHelper.isNullOrEmpty(var1.getPSDEFormId())) {
               var1.setSRFNextForm("editform");
            }
         }
      }

      this.update(var1);
   }

   protected void initPSUWAppView(PSUWAppView var1, PSDataEntity var2, PSViewTypeStruct var3) throws Exception {
      if (var2 != null) {
         if (!StringHelper.isNullOrEmpty(var3.getTitle())) {
            var1.setTitle(StringHelper.format("%1$s%2$s", var2.getLogicName(), var3.getTitle()));
         }

         String var4 = StringHelper.format("%1$s%2$s", var2.getLogicName(), var3.getPSViewTypeName());
         int var5 = 1;

         PSDEViewBase var6;
         do {
            if (var5 > 1) {
               var4 = StringHelper.format(
                  "%1$s%2$s",
                  StringHelper.format("%1$s%2$s", var2.getLogicName(), var3.getPSViewTypeName()),
                  var5 == 1 ? "" : StringHelper.format("(%1$s)", var5)
               );
            }

            var5++;
            var6 = new PSDEViewBase();
            var6.setSessionFactory(this.getSessionFactory());
            var6.setPSDEId(var2.getPSDataEntityId());
            var6.setPSDEViewBaseName(var4);
         } while (var6.select(true));

         var1.setPSUWAppViewName(var4);
         String var14 = var3.getCodeName();
         var5 = 1;

         PSDEViewBase var7;
         do {
            if (var5 > 1) {
               var14 = StringHelper.format("Usr%1$s%2$s", var5 == 1 ? "" : var5, var3.getCodeName());
            }

            var5++;
            var7 = new PSDEViewBase();
            var7.setSessionFactory(this.getSessionFactory());
            var7.setPSDEId(var2.getPSDataEntityId());
            var7.setCodeName(var14);
         } while (var7.select(true));

         var1.setCodeName(var14);
      }

      HashMap var10 = null;
      if (DataObject.getBoolValue(var1.getEnableSrcPSDEView(), false) && !StringHelper.isNullOrEmpty(var1.getSrcPSDEViewId())) {
         PSDEViewBase var12 = new PSDEViewBase();
         var12.setSessionFactory(this.getSessionFactory());
         var12.setPSDEId(var2.getPSDataEntityId());
         var12.setPSDEViewBaseId(var1.getSrcPSDEViewId());
         if (var12.select(true)) {
            var10 = new HashMap();

            for (PSDEViewCtrl var8 : var12.getPSDEViewCtrls()) {
               var10.put(var8.getPSDEViewCtrlName().toUpperCase(), var8);
            }
         }
      }

      ArrayList<PSVTCtrl> var13 = var3.getPSVTCtrls();
      if (var13 != null) {
         for (PSVTCtrl var18 : var13) {
            if (DataObject.getBoolValue(var18.getValidFlag(), true)) {
               try {
                  PSDEViewCtrl var19 = null;
                  if (var10 != null) {
                     var19 = (PSDEViewCtrl)var10.get(var18.getPSVTCtrlName().toUpperCase());
                  }

                  this.initDEViewCtrl(var1, var2, var3, var18, var19);
               } catch (Exception var9) {
                  throw new Exception(
                     StringHelper.format("建立视图类型[%1$s]部件[%2$s]发生异常，%3$s", var3.getPSViewTypeName(), var18.getPSVTCtrlName(), var9.getMessage()), var9
                  );
               }
            }
         }
      }
   }

   protected void initDEViewCtrl(PSUWAppView var1, PSDataEntity var2, PSViewTypeStruct var3, PSVTCtrl var4, PSDEViewCtrl var5) throws Exception {
      if (DataObject.getBoolValue(var4.getValidFlag(), true)) {
         PSSystem var6 = null;
         if (var2 != null) {
            var6 = var2.getPSSystem();
         }

         this.fillDEViewCtrl(var1, var6, var2, var3, var4, var5, "", "");
      }
   }

   protected void fillDEViewCtrl(
      PSUWAppView var1, PSSystem var2, PSDataEntity var3, PSViewTypeStruct var4, PSVTCtrl var5, PSDEViewCtrl var6, String var7, String var8
   ) throws Exception {
      if (StringHelper.compare(var5.getCtrlType(), "FORM", true) == 0) {
         if (var6 != null) {
            var1.setPSDEFormId(var6.getPSDEFormId());
            var1.setPSDEFormName(var6.getPSDEFormName());
            var1.setPSACHandlerId(var6.getPSACHandlerId());
            var1.setPSACHandlerName(var6.getPSACHandlerName());
         } else {
            boolean var21 = false;
            if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
               var21 = true;
            }

            String var27 = this.getPSDEEditFormId(var3, var21);
            if (!StringHelper.isNullOrEmpty(var27)) {
               var1.setPSDEFormId(var27);
               if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
                  var1.setPSACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
               }
            }
         }
      } else if (StringHelper.compare(var5.getCtrlType(), "SEARCHFORM", true) == 0) {
         if (var6 != null) {
            var1.setPSDESearchFormId(var6.getPSDEFormId());
            var1.setPSDESearchFormName(var6.getPSDEFormName());
            var1.setPSSFACHandlerId(var6.getPSACHandlerId());
            var1.setPSSFACHandlerName(var6.getPSACHandlerName());
         } else {
            boolean var20 = false;
            if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
               var20 = true;
            }

            String var26 = this.getPSDESearchFormId(var3, var20);
            if (!StringHelper.isNullOrEmpty(var26)) {
               var1.setPSDESearchFormId(var26);
               if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
                  var1.setPSSFACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
               }
            }
         }
      } else if (StringHelper.compare(var5.getCtrlType(), "GRID", true) == 0) {
         if (var6 != null) {
            var1.setPSDEGridId(var6.getPSDEGridId());
            var1.setPSDEGridName(var6.getPSDEGridName());
            var1.setPSACHandlerId(var6.getPSACHandlerId());
            var1.setPSACHandlerName(var6.getPSACHandlerName());
            var1.setPSDEDataSetId(var6.getPSDEDataSetId());
         } else {
            boolean var19 = false;
            if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
               var19 = true;
            }

            String var25 = this.getPSDEGridId(var3, var19);
            if (!StringHelper.isNullOrEmpty(var25)) {
               var1.setPSDEGridId(var25);
            }

            var1.setPSDEDataSetId(this.getPSDEDataSetId(var3));
            if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
               var1.setPSACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
            }
         }
      } else if (StringHelper.compare(var5.getCtrlType(), "TOOLBAR", true) == 0) {
         if (var6 != null) {
            var1.setPSDEToolbarId(var6.getPSDEToolbarId());
            var1.setPSDEToolbarName(var6.getPSDEToolbarName());
         } else if (!StringHelper.isNullOrEmpty(var5.getPSSysToolbarId())) {
            PSDEToolbar var18 = this.getPSDEToolbarId(var5.getPSSysToolbarId(), var2);
            if (var18 != null) {
               var1.setPSDEToolbarId(var18.getPSDEToolbarId());
               var1.setPSDEToolbarName(var18.getPSDEToolbarName());
            }
         }
      } else if (StringHelper.compare(var5.getCtrlType(), "PICKUPVIEWPANEL", true) == 0) {
         if (var6 != null) {
            var1.setPSDEViewId(var6.getPSDEViewId());
            var1.setPSDEViewName(var6.getPSDEViewName());
         } else {
            String var17 = this.getPSDEViewBaseId(var3, var4, var7, var8);
            if (!StringHelper.isNullOrEmpty(var17)) {
               var1.setPSDEViewId(var17);
            }
         }
      } else if (StringHelper.compare(var5.getCtrlType(), "DRBAR", true) != 0 && StringHelper.compare(var5.getCtrlType(), "DRTAB", true) != 0) {
         if (StringHelper.compare(var5.getCtrlType(), "DATAVIEW", true) == 0) {
            if (var6 != null) {
               var1.setPSDEDataViewId(var6.getPSDEDataViewId());
               var1.setPSDEDataViewName(var6.getPSDEDataViewName());
               var1.setPSACHandlerId(var6.getPSACHandlerId());
               var1.setPSACHandlerName(var6.getPSACHandlerName());
               var1.setPSDEDataSetId(var6.getPSDEDataSetId());
            } else {
               var1.setPSDEDataViewId(this.getPSDEDataViewId(var3, var7, var8));
               var1.setPSDEDataSetId(this.getPSDEDataSetId(var3, var7, var8));
               if (StringHelper.isNullOrEmpty(var7)) {
                  if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
                     var1.setPSACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
                  }
               } else {
                  String var15 = "";
                  if (StringHelper.isNullOrEmpty(var7)) {
                     var15 = var3.getPSDataEntityId();
                     PSDEDataSetService var22 = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, this.getSessionFactory());
                     PSDEDataSet var11 = new PSDEDataSet();
                     var11.setPSDEDataSetId(var3.getPSDataEntityId());
                     if (var22.checkKey(var11) == 1) {
                        var1.setPSDEDataSetId(var3.getPSDataEntityId());
                     }

                     if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
                        var1.setPSACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
                     }
                  } else {
                     var15 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), var7, var8);
                     String var23 = "";
                     String var28 = "";
                     if (StringHelper.compare(var7, "INDEXDETYPE", true) == 0) {
                        var23 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "INDEXDETYPE", var8);
                        var28 = "INDEXPICKUPDATAVIEWHANDLER";
                     } else if (StringHelper.compare(var7, "FORMTYPE", true) == 0) {
                        var23 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "FORMTYPE", "");
                        var28 = "FORMPICKUPDATAVIEWHANDLER";
                     }

                     PSDEDataSetService var12 = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, this.getSessionFactory());
                     PSDEDataSet var13 = new PSDEDataSet();
                     var13.setPSDEDataSetId(var23);
                     if (var12.checkKey(var13) == 1) {
                        var1.setPSDEDataSetId(var23);
                     }

                     var1.setPSACHandlerId(this.getPSACHandlerId(var28, var2));
                  }

                  PSDEDataViewService var24 = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, this.getSessionFactory());
                  PSDEDataView var29 = new PSDEDataView();
                  var29.setPSDEDataViewId(var15);
                  if (var24.checkKey(var29) == 1) {
                     var1.setPSDEDataViewId(var15);
                  }
               }
            }
         } else if (StringHelper.compare(var5.getCtrlType(), "MOBMDCTRL", true) == 0) {
            if (var6 != null) {
               var1.setPSDEListId(var6.getPSDEListId());
               var1.setPSDEListName(var6.getPSDEListName());
               var1.setPSACHandlerId(var6.getPSACHandlerId());
               var1.setPSACHandlerName(var6.getPSACHandlerName());
               var1.setPSDEDataSetId(var6.getPSDEDataSetId());
               var1.setMDCtrlParam(var6.getCtrlParam());
            } else {
               var1.setPSDEListId(this.getPSDEListId(var3, var7, var8, true));
               var1.setPSDEDataSetId(this.getPSDEDataSetId(var3, var7, var8));
               if (StringHelper.isNullOrEmpty(var7)) {
                  if (!StringHelper.isNullOrEmpty(var5.getPSSysACHandlerId())) {
                     var1.setPSACHandlerId(this.getPSACHandlerId(var5.getPSSysACHandlerId(), var2));
                  }
               } else {
                  String var14 = var5.getPSSysACHandlerId();
                  var1.setPSACHandlerId(this.getPSACHandlerId(var14, var2));
               }

               var1.setMDCtrlParam("LISTVIEW");
            }
         }
      } else {
         if (var6 != null) {
            var1.setPSDEDRId(var6.getPSDEDRId());
            var1.setPSDEDRName(var6.getPSDEDRName());
         } else {
            boolean var9 = false;
            if (var4 != null && var4.getPSViewTypeId().indexOf("DEMOB") != -1) {
               var9 = true;
            }

            String var10 = this.getPSDEDataRelationId(var3, var9);
            var1.setPSDEDRId(var10);
         }
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

   protected PSDEToolbar getPSDEToolbarId(String var1, PSSystem var2) throws Exception {
      String var3 = KeyValueHelper.genUniqueId(var2.getPSSystemId(), var1);
      PSDEToolbarService var4 = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, this.getSessionFactory());
      PSDEToolbar var5 = new PSDEToolbar();
      var5.setPSDEToolbarId(var3);
      return var4.get(var5, true) ? var5 : null;
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

         ArrayList var11 = var8.select(var10);
         return var11.size() == 0 ? null : ((PSDEViewBase)var11.get(0)).getPSDEViewBaseId();
      }
   }

   protected String getPSDEDataRelationId(PSDataEntity var1, boolean var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      String var4 = StringHelper.format("%1$s#%2$s#%3$s", "PSDEDATARELATION", var1.getPSDataEntityId(), var2);
      if (var3 != null) {
         Object var5 = var3.getActionParam(var4);
         if (var5 != null) {
            if (var5 instanceof String) {
               return (String)var5;
            }

            return null;
         }
      }

      String var6 = this.getPSDEDataRelationIdReal(var1, var2);
      if (var3 != null) {
         if (var6 == null) {
            var3.setActionParam(var4, EntityBase.EMPTY);
         } else {
            var3.setActionParam(var4, var6);
         }
      }

      return var6;
   }

   protected String getPSDEDataRelationIdReal(PSDataEntity var1, boolean var2) throws Exception {
      boolean var3 = this.isEnableFolderKey(var1);
      String var4 = null;
      if (var3) {
         var4 = StringHelper.format("%1$s-%2$s", var1.getPSDataEntityId(), "R1");
      } else {
         var4 = var1.getPSDataEntityId();
      }

      PSDEDataRelation var5 = new PSDEDataRelation();
      var5.setPSDEDataRelationId(var4);
      PSDEDataRelationService var6 = (PSDEDataRelationService)ServiceGlobal.getService(PSDEDataRelationService.class, this.getSessionFactory());
      if (var6.checkKey(var5) == 1) {
         return var4;
      }

      SelectCond var7 = new SelectCond();
      var7.setFetchFirst(true);
      var7.set("PSDEID", var1.getPSDataEntityId());
      var7.setIsNull("PSWFDEID");
      if (var2) {
         var7.set("DRTAG", "MOB");
      } else {
         var7.setIsNull("DRTAG");
      }

      ArrayList var8 = var6.select(var7);
      return var8.size() > 0 ? ((PSDEDataRelation)var8.get(0)).getPSDEDataRelationId() : null;
   }

   protected void initDEViewCtrl(PSUWAppView var1, PSViewTypeStruct var2, PSDEViewBase var3, PSVTCtrl var4, String var5, String var6) throws Exception {
      if (DataObject.getBoolValue(var4.getValidFlag(), true)) {
         PSDEViewCtrl var7 = new PSDEViewCtrl();
         var7.setPSDEViewBaseId(var3.getPSDEViewBaseId());
         var7.setPSDEViewBaseName(var3.getPSDEViewBaseName());
         var7.setPSDEViewCtrlName(var4.getPSVTCtrlName());
         var7.setPSDEViewCtrlType(var4.getCtrlType());
         var7.setPSDEId(var3.getPSDEId());
         var7.setPSDEName(var3.getPSDEName());
         if (var4.getDefaultFlag() != null) {
            var7.setDefaultFlag(var4.getDefaultFlag());
         } else {
            var7.setDefaultFlag(1);
         }

         this.fillDEViewCtrlParams(var7, var4);
         if (var4.getOrderValue() != null) {
            var7.setOrderValue(var4.getOrderValue());
         }

         if (var4.getEnableViewActions() != null) {
            var7.setEnableViewActions(var4.getEnableViewActions());
         }

         this.fillDEViewCtrl(var7, var1, var2, var3, var4, var5, var6);
         PSDEViewCtrlService var8 = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, this.getSessionFactory());
         var8.create(var7);
         var8.update(var7);
      }
   }

   protected void fillDEViewCtrl(PSDEViewCtrl var1, PSUWAppView var2, PSViewTypeStruct var3, PSDEViewBase var4, PSVTCtrl var5, String var6, String var7) throws Exception {
      if (StringHelper.compare(var5.getCtrlType(), "FORM", true) == 0) {
         var1.setPSDEFormId(var2.getPSDEFormId());
         var1.setPSACHandlerId(var2.getPSACHandlerId());
      } else if (StringHelper.compare(var5.getCtrlType(), "SEARCHFORM", true) == 0) {
         var1.setPSDEFormId(var2.getPSDESearchFormId());
         var1.setPSACHandlerId(var2.getPSSFACHandlerId());
      } else if (StringHelper.compare(var5.getCtrlType(), "GRID", true) == 0) {
         var1.setPSDEGridId(var2.getPSDEGridId());
         var1.setPSDEDataSetId(var2.getPSDEDataSetId());
         var1.setPSACHandlerId(var2.getPSACHandlerId());
      } else if (StringHelper.compare(var5.getCtrlType(), "TOOLBAR", true) == 0) {
         var1.setPSDEToolbarId(var2.getPSDEToolbarId());
      } else if (StringHelper.compare(var5.getCtrlType(), "PICKUPVIEWPANEL", true) != 0) {
         if (StringHelper.compare(var5.getCtrlType(), "DRBAR", true) == 0 || StringHelper.compare(var5.getCtrlType(), "DRTAB", true) == 0) {
            var1.setPSDEDRId(var2.getPSDEDRId());
         } else if (StringHelper.compare(var5.getCtrlType(), "DATAVIEW", true) == 0) {
            var1.setPSDEDataViewId(var2.getPSDEDataViewId());
            var1.setPSDEDataSetId(var2.getPSDEDataSetId());
            var1.setPSACHandlerId(var2.getPSACHandlerId());
         } else if (StringHelper.compare(var5.getCtrlType(), "MOBMDCTRL", true) == 0) {
            var1.setPSDEListId(var2.getPSDEListId());
            var1.setPSDEDataSetId(var2.getPSDEDataSetId());
            var1.setPSACHandlerId(var2.getPSACHandlerId());
            var1.setCtrlParam("LISTVIEW");
         }
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
   protected void onUpdateEditForm(PSUWAppView var1) throws Exception {
      PSUWAppView var2 = new PSUWAppView();
      var2.setPSUWAppViewId(var1.getPSUWAppViewId());
      this.get(var2);
      var1.setSRFNextForm("finish");
      if (!StringHelper.isNullOrEmpty(var2.getPSDEToolbarId())) {
         var1.setSRFNextForm("toolbar");
      }

      this.update(var1);
   }

   @Override
   protected void onUpdateSearchForm(PSUWAppView var1) throws Exception {
      PSUWAppView var2 = new PSUWAppView();
      var2.setPSUWAppViewId(var1.getPSUWAppViewId());
      this.get(var2);
      var1.setSRFNextForm("finish");
      if (!StringHelper.isNullOrEmpty(var2.getPSDEToolbarId())) {
         var1.setSRFNextForm("toolbar");
      }

      this.update(var1);
   }

   @Override
   protected void onUpdateGrid(PSUWAppView var1) throws Exception {
      PSUWAppView var2 = new PSUWAppView();
      var2.setPSUWAppViewId(var1.getPSUWAppViewId());
      this.get(var2);
      var1.setSRFNextForm("finish");
      if (!StringHelper.isNullOrEmpty(var2.getPSDESearchFormId())) {
         var1.setSRFNextForm("searchform");
      }

      this.update(var1);
   }

   @Override
   protected void onUpdateToolbar(PSUWAppView var1) throws Exception {
      var1.setSRFNextForm("finish");
      this.update(var1);
   }

   @Override
   protected void onFinishWizard(PSUWAppView var1) throws Exception {
      this.get(var1);
      PSViewTypeStruct var2 = PSModelGlobal.getPSViewType(var1.getPSAppViewType());
      if (var1.getPSAppViewType().indexOf("DE") == 0) {
         PSDataEntity var3 = new PSDataEntity();
         var3.setSessionFactory(this.getSessionFactory());
         var3.setPSDataEntityId(var1.getPSDEId());

         try {
            var3.get(true);
         } catch (Exception var16) {
            throw new Exception(StringHelper.format("无法获取指定实体对象[%1$s]", var1.getPSDEId()));
         }

         PSDEViewBase var4 = new PSDEViewBase();
         String var5 = KeyValueHelper.genGuidEx();
         var4.setPSDEViewBaseId(var5);
         var4.setPSSystemId(var3.getPSSystemId());
         var4.setPSDEId(var3.getPSDataEntityId());
         var4.setPSDEName(var3.getPSDataEntityName());
         var4.setPSDEViewBaseName(var1.getPSUWAppViewName());
         var4.setTitle(var1.getTitle());
         var4.setCaption(var1.getCaption());
         var4.setPSDEViewBaseType(var2.getPSViewTypeId());
         var4.setCodeName(var1.getCodeName());
         var4.setSessionFactory(this.getSessionFactory());

         try {
            var4.create();
         } catch (Exception var15) {
            throw new Exception(StringHelper.format("建立实体视图[%1$s]发生异常，%2$s", var4.getPSDEViewBaseName(), var15.getMessage()), var15);
         }

         PSSystem var6 = var3.getPSSystem();
         ArrayList<PSVTCtrl> var7 = var2.getPSVTCtrls();
         if (var7 != null) {
            for (PSVTCtrl var9 : var7) {
               if (DataObject.getBoolValue(var9.getValidFlag(), true)) {
                  try {
                     this.initDEViewCtrl(var1, var2, var4, var9, null, null);
                  } catch (Exception var14) {
                     throw new Exception(
                        StringHelper.format("建立实体视图[%1$s]部件[%2$s]发生异常，%3$s", var4.getPSDEViewBaseName(), var9.getPSVTCtrlName(), var14.getMessage()), var14
                     );
                  }
               }
            }
         }

         ArrayList<PSVTRV> var32 = var2.getPSVTRVs();
         if (var32 != null) {
            for (PSVTRV var10 : var32) {
               if (DataObject.getBoolValue(var10.getValidFlag(), true) && DataObject.getBoolValue(var10.getDefaultFlag(), true)) {
                  try {
                     this.initDEViewRV(var6, var3, var2, var4, var10, null, null);
                  } catch (Exception var13) {
                     throw new Exception(
                        StringHelper.format("建立实体视图[%1$s]视图引用[%2$s]发生异常，%3$s", var4.getPSDEViewBaseName(), var10.getPSVTRVName(), var13.getMessage()), var13
                     );
                  }
               }
            }
         }

         PSAppDEView var35 = new PSAppDEView();
         var35.setPSDEViewBaseId(var4.getPSDEViewBaseId());
         var35.setPSSysAppId(var1.getPSSysAppId());
         var35.setPSAppModuleId(var1.getPSAppModuleId());
         var35.setPSAppModuleName(var1.getPSAppModuleName());
         var35.setSessionFactory(this.getSessionFactory());

         try {
            var35.create();
         } catch (Exception var12) {
            throw new Exception(StringHelper.format("建立应用实体视图[%1$s]发生异常，%2$s", var4.getPSDEViewBaseName(), var12.getMessage()), var12);
         }

         var1.setPSAppViewId(var35.getPSAppViewId());
         var1.setPSAppViewName(var35.getPSAppViewName());
         this.update(var1);
      } else if (StringHelper.compare(var1.getPSAppViewType(), "APPINDEXVIEW", true) == 0) {
         PSAppMenu var17 = new PSAppMenu();
         PSAppMenuService var21 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, this.getSessionFactory());
         int var25 = 0;

         while (true) {
            var25++;
            PSAppMenu var27 = new PSAppMenu();
            var27.setPSSysAppId(var1.getPSSysAppId());
            var27.setPSAppMenuName(StringHelper.format("%1$s%2$s", var1.getCodeName(), var25 == 1 ? "" : var25));
            if (!var21.select(var27, true)) {
               var17.setPSAppMenuName(var27.getPSAppMenuName());
               var27.reset();
               var27.setPSSysAppId(var1.getPSSysAppId());
               var27.setCodeName(StringHelper.format("%1$s%2$s", var1.getCodeName(), var25 == 1 ? "" : var25));
               if (!var21.select(var27, true)) {
                  var17.setCodeName(var27.getCodeName());
                  var17.setPublicFlag(0);
                  var17.setPSSysAppId(var1.getPSSysAppId());
                  var17.setLogicName(StringHelper.format("%1$s默认菜单", var1.getTitle()));
                  var21.create(var17);
                  PSAppIndexViewService var28 = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, this.getSessionFactory());
                  PSAppIndexView var30 = new PSAppIndexView();
                  var30.setPSSysAppId(var1.getPSSysAppId());
                  var30.setPSAppModuleId(var1.getPSAppModuleId());
                  var30.setPSAppIndexViewName(var1.getCodeName());
                  var30.setTitle(var1.getTitle());
                  var30.setCaption(var1.getCaption());
                  var30.setPSAppMenuId(var17.getPSAppMenuId());
                  var30.setPSAppMenuName(var17.getPSAppMenuName());
                  var28.create(var30);
                  var17.reset();
                  var17.setPSAppMenuId(var30.getPSAppMenuId());
                  var17.setOwnerType("PSAPPINDEXVIEW");
                  var17.setOwnerId(var30.getPSAppIndexViewId());
                  var21.sysUpdate(var17, false);
                  var1.setPSAppViewId(var30.getPSAppViewId());
                  var1.setPSAppViewName(var30.getPSAppViewName());
                  this.update(var1);
                  break;
               }
            }
         }
      } else if (StringHelper.compare(var1.getPSAppViewType(), "APPPORTALVIEW", true) == 0) {
         PSAppPortalViewService var18 = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, this.getSessionFactory());
         PSAppPortalView var22 = new PSAppPortalView();
         var22.setPSSysAppId(var1.getPSSysAppId());
         var22.setPSAppModuleId(var1.getPSAppModuleId());
         var22.setPSAppPortalViewName(var1.getCodeName());
         var22.setTitle(var1.getTitle());
         var22.setCaption(var1.getCaption());
         var22.setColModel("50%;50%");
         var22.setLayoutMode("TABLE_24COL");
         var18.create(var22);
         var1.setPSAppViewId(var22.getPSAppViewId());
         var1.setPSAppViewName(var22.getPSAppViewName());
         this.update(var1);
      } else if (StringHelper.compare(var1.getPSAppViewType(), "APPPANELVIEW", true) == 0) {
         PSSysAppService var19 = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, this.getSessionFactory());
         PSSysApp var23 = new PSSysApp();
         var23.setPSSysAppId(var1.getPSSysAppId());
         var19.get(var23);
         PSAppTypeService var26 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         PSAppType var29 = new PSAppType();
         var29.setPSAppTypeId(var23.getPSAppTypeId());
         var26.get(var29);
         PSSysViewPanel var31 = new PSSysViewPanel();
         PSSysViewPanelService var33 = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, this.getSessionFactory());
         int var36 = 0;

         PSSysViewPanel var37;
         do {
            var36++;
            var37 = new PSSysViewPanel();
            var37.setPSSystemId(var23.getPSSystemId());
            var37.setCodeName(StringHelper.format("%1$s%2$s", var1.getCodeName(), var36 == 1 ? "" : var36));
         } while (var33.select(var37, true));

         var31.setCodeName(var37.getCodeName());
         var31.setViewLayoutFlag(0);
         var31.setPublicFlag(0);
         var31.setPSSysAppId(var23.getPSSysAppId());
         var31.setPSSysAppName(var23.getPSSysAppName());
         var31.setPSSystemId(var23.getPSSystemId());
         var31.setPSSystemName(var23.getPSSystemName());
         var31.setPSSysViewPanelName(StringHelper.format("%1$s默认面板", var1.getTitle()));
         if (DataObject.getBoolValue(var29.getMobileMode(), false)) {
            var31.setMobFlag(1);
         } else {
            var31.setMobFlag(0);
         }

         var31.setPublicFlag(0);
         var33.create(var31);
         PSAppPanelViewService var38 = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, this.getSessionFactory());
         PSAppPanelView var11 = new PSAppPanelView();
         var11.setPSSysAppId(var1.getPSSysAppId());
         var11.setPSAppModuleId(var1.getPSAppModuleId());
         var11.setPSAppPanelViewName(var1.getCodeName());
         var11.setTitle(var1.getTitle());
         var11.setCaption(var1.getCaption());
         var11.setPSSysViewPanelId(var31.getPSSysViewPanelId());
         var11.setPSSysViewPanelName(var31.getPSSysViewPanelName());
         var38.create(var11);
         var31.reset();
         var31.setPSSysViewPanelId(var11.getPSSysViewPanelId());
         var31.setOwnerType("PSAPPPANELVIEW");
         var31.setOwnerId(var11.getPSAppPanelViewId());
         var33.sysUpdate(var31, false);
         var1.setPSAppViewId(var11.getPSAppViewId());
         var1.setPSAppViewName(var11.getPSAppViewName());
         this.update(var1);
      } else {
         PSAppUtilViewService var20 = (PSAppUtilViewService)ServiceGlobal.getService(PSAppUtilViewService.class, this.getSessionFactory());
         PSAppUtilView var24 = new PSAppUtilView();
         var24.setPSSysAppId(var1.getPSSysAppId());
         var24.setPSAppModuleId(var1.getPSAppModuleId());
         var24.setPSAppUtilViewName(var1.getCodeName());
         var24.setTitle(var1.getTitle());
         var24.setCaption(var1.getCaption());
         var24.setPSAppUtilViewType(var1.getPSAppViewType());
         var20.create(var24);
         var1.setPSAppViewId(var24.getPSAppViewId());
         var1.setPSAppViewName(var24.getPSAppViewName());
         this.update(var1);
      }
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
      var9.create(var8);
   }

   protected void fillDEViewRV(
      PSDEViewRV var1, PSSystem var2, PSDataEntity var3, PSViewTypeStruct var4, PSDEViewBase var5, PSVTRV var6, String var7, String var8
   ) throws Exception {
      if (StringHelper.compare(var4.getPSViewTypeId(), "DEGRIDVIEW", true) == 0 || StringHelper.compare(var4.getPSViewTypeId(), "DEMDCUSTOMVIEW", true) == 0) {
         if (StringHelper.compare(var6.getPSVTRVName(), "NEWDATA", true) == 0) {
            String var10 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "DEEDITVIEW");
            var1.setMinorPSDEViewId(var10);
            return;
         }

         if (StringHelper.compare(var6.getPSVTRVName(), "EDITDATA", true) == 0) {
            String var9 = KeyValueHelper.genUniqueId(var3.getPSDataEntityId(), "DEEDITVIEW");
            var1.setMinorPSDEViewId(var9);
            return;
         }
      }
   }

   protected String getNextForm(PSUWAppView var1) throws Exception {
      return "finish";
   }
}
