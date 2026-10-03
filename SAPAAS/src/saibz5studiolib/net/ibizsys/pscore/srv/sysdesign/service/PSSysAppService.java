package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import net.ibizsys.pscore.srv.config.entity.PSPFStylePrj;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSPFStyleService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaApp;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaAppService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysAppService extends PSSysAppServiceBase {
   private static final Log log = LogFactory.getLog(PSSysAppService.class);

   protected void onBeforeCreate(PSSysApp var1) throws Exception {
      this.syncPSPFStyle(var1);
      if (var1.getDefaultPub() == null) {
         PSSysApp var2 = new PSSysApp();
         var2.setPSSystemId(var1.getPSSystemId());
         var2.setDefaultPub(1);
         if (!this.existsData(var2)) {
            var1.setDefaultPub(1);
         }
      } else if (DataObject.getBoolValue(var1.getDefaultPub(), false)) {
         PSSysApp var3 = new PSSysApp();
         var3.setPSSystemId(var1.getPSSystemId());
         var3.setDefaultPub(1);
         if (this.existsData(var3)) {
            var3.setDefaultPub(0);
            this.update(var3, false);
         }
      }

      super.onBeforeCreate(var1);
   }

   protected void onBeforeUpdate(PSSysApp var1) throws Exception {
      this.syncPSPFStyle(var1);
      if (DataObject.getBoolValue(var1.getDefaultPub(), false)) {
         PSSysApp var2 = new PSSysApp();
         var2.setPSSystemId(var1.getPSSystemId());
         var2.setDefaultPub(1);
         if (this.existsData(var2) && StringHelper.compare(var2.getPSSysAppId(), var1.getPSSysAppId(), false) != 0) {
            var2.setDefaultPub(0);
            this.update(var2, false);
         }
      }

      super.onBeforeUpdate(var1);
   }

   protected void onInitModel(PSSysApp var1) throws Exception {
      super.onInitModel(var1);
      this.initPSSysAppLanRes(var1);
   }

   protected void initPSSysAppLanRes(PSSysApp var1) throws Exception {
      PSLanguageResService var2 = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, this.getSessionFactory());
      PSAppIndexViewService var3 = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, this.getSessionFactory());

      for (PSAppIndexView var6 : var3.selectByPSSysApp(var1)) {
         PSAppIndexView var7 = new PSAppIndexView();
         var7.setPSAppIndexViewId(var6.getPSAppIndexViewId());
         if (this.initPSAppViewLanRes(var1, var2, var6, var7)) {
            var3.update(var7, false);
         }
      }

      PSAppPortalViewService var19 = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, this.getSessionFactory());

      for (PSAppPortalView var8 : var19.selectByPSSysApp(var1)) {
         PSAppPortalView var9 = new PSAppPortalView();
         var9.setPSAppPortalViewId(var8.getPSAppPortalViewId());
         if (this.initPSAppViewLanRes(var1, var2, var8, var9)) {
            var19.update(var9, false);
         }
      }

      PSAppMenuService var22 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, this.getSessionFactory());
      PSAppMenuItemService var23 = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, this.getSessionFactory());

      for (PSAppMenu var11 : var1.getPSAppMenus()) {
         boolean var12 = false;

         for (PSAppMenuItem var15 : var11.getPSAppMenuItems()) {
            PSAppMenuItem var16 = new PSAppMenuItem();
            var16.setPSAppMenuItemId(var15.getPSAppMenuItemId());
            boolean var17 = false;
            if (!StringHelper.isNullOrEmpty(var15.getCaption()) && StringHelper.isNullOrEmpty(var15.getCapPSLanResId())) {
               PSLanguageRes var18 = new PSLanguageRes();
               var18.setPSSystemId(var1.getPSSystemId());
               var18.setLanResType("CONTROL");
               var18.setUserData(
                  StringHelper.format("APPMENUITEM.CAPTION.%1$s.%2$s.%3$s", var1.getAppPKGName(), var11.getCodeName(), var15.getPSAppMenuItemName())
                     .toUpperCase()
               );
               if (!var2.select(var18, true)) {
                  var18.setPSSysAppId(var1.getPSSysAppId());
                  var18.setPSSysAppName(var1.getPSSysAppName());
                  var18.setContent(var15.getCaption());
                  var2.create(var18);
                  var16.setCapPSLanResId(var18.getPSLanguageResId());
                  var16.setCapPSLanResName(var18.getPSLanguageResName());
                  var17 = true;
               }
            }

            if (!StringHelper.isNullOrEmpty(var15.getTooltipInfo()) && StringHelper.isNullOrEmpty(var15.getTipPSLanResId())) {
               PSLanguageRes var26 = new PSLanguageRes();
               var26.setPSSystemId(var1.getPSSystemId());
               var26.setLanResType("CONTROL");
               var26.setUserData(
                  StringHelper.format("APPMENUITEM.TOOLTIP.%1$s.%2$s.%3$s", var1.getAppPKGName(), var11.getCodeName(), var15.getPSAppMenuItemName())
                     .toUpperCase()
               );
               if (!var2.select(var26, true)) {
                  var26.setPSSysAppId(var1.getPSSysAppId());
                  var26.setPSSysAppName(var1.getPSSysAppName());
                  var26.setContent(var15.getTooltipInfo());
                  var2.create(var26);
                  var16.setTipPSLanResId(var26.getPSLanguageResId());
                  var16.setTipPSLanResName(var26.getPSLanguageResName());
                  var17 = true;
               }
            }

            if (var17) {
               var12 = true;
               var23.update(var16, false);
            }
         }

         if (var12) {
            PSAppMenu var25 = new PSAppMenu();
            var25.setPSAppMenuId(var11.getPSAppMenuId());
            var22.update(var25, false);
         }
      }
   }

   protected boolean initPSAppViewLanRes(PSSysApp var1, PSLanguageResService var2, PSAppView var3, PSAppView var4) throws Exception {
      boolean var5 = false;
      if (!StringHelper.isNullOrEmpty(var3.getTitle()) && StringHelper.isNullOrEmpty(var3.getTitlePSLanResId())) {
         PSLanguageRes var6 = new PSLanguageRes();
         var6.setPSSystemId(var1.getPSSystemId());
         var6.setLanResType("PAGE");
         var6.setUserData(StringHelper.format("TITLE.%1$s.%2$s", var3.getPSSysApp().getAppPKGName(), var3.getPSAppViewName()).toUpperCase());
         if (!var2.select(var6, true)) {
            var6.setPSSysAppId(var3.getPSSysAppId());
            var6.setPSSysAppName(var3.getPSSysAppName());
            var6.setPSAppViewId(var3.getPSAppViewId());
            var6.setPSAppViewName(var3.getPSAppViewName());
            var6.setContent(var3.getTitle());
            var2.create(var6);
            var4.setTitlePSLanResId(var6.getPSLanguageResId());
            var4.setTitlePSLanResName(var6.getPSLanguageResName());
            var5 = true;
         }
      }

      if (!StringHelper.isNullOrEmpty(var3.getCaption()) && StringHelper.isNullOrEmpty(var3.getCapPSLanResId())) {
         PSLanguageRes var7 = new PSLanguageRes();
         var7.setPSSystemId(var1.getPSSystemId());
         var7.setLanResType("PAGE");
         var7.setUserData(StringHelper.format("CAPTION.%1$s.%2$s", var3.getPSSysApp().getAppPKGName(), var3.getPSAppViewName()).toUpperCase());
         if (!var2.select(var7, true)) {
            var7.setPSSysAppId(var3.getPSSysAppId());
            var7.setPSSysAppName(var3.getPSSysAppName());
            var7.setPSAppViewId(var3.getPSAppViewId());
            var7.setPSAppViewName(var3.getPSAppViewName());
            var7.setContent(var3.getCaption());
            var2.create(var7);
            var4.setCapPSLanResId(var7.getPSLanguageResId());
            var4.setCapPSLanResName(var7.getPSLanguageResName());
            var5 = true;
         }
      }

      if (!StringHelper.isNullOrEmpty(var3.getSubCaption()) && StringHelper.isNullOrEmpty(var3.getSubCapPSLanResId())) {
         PSLanguageRes var8 = new PSLanguageRes();
         var8.setPSSystemId(var1.getPSSystemId());
         var8.setLanResType("PAGE");
         var8.setUserData(StringHelper.format("SUBCAP.%1$s.%2$s", var3.getPSSysApp().getAppPKGName(), var3.getPSAppViewName()).toUpperCase());
         if (!var2.select(var8, true)) {
            var8.setPSSysAppId(var3.getPSSysAppId());
            var8.setPSSysAppName(var3.getPSSysAppName());
            var8.setPSAppViewId(var3.getPSAppViewId());
            var8.setPSAppViewName(var3.getPSAppViewName());
            var8.setContent(var3.getSubCaption());
            var2.create(var8);
            var4.setSubCapPSLanResId(var8.getPSLanguageResId());
            var4.setSubCapPSLanResName(var8.getPSLanguageResName());
            var5 = true;
         }
      }

      return var5;
   }

   @Override
   protected void onBeforeRemove(PSSysApp var1) throws Exception {
      PSSysApp var2 = this.getLast(var1);
      if (DataObject.getIntegerValue(var2.getRemoveFlag(), 0) != 1) {
         throw new Exception(StringHelper.format("应用[%1$s]必须设置为[允许删除]才能删除", var2.getPSSysAppName()));
      }

      if (var2.getPSSystem() != null) {
         String var3 = var2.getPSSystem().getPSDevSlnSysId();
         if (!StringHelper.isNullOrEmpty(var3)) {
            PSDevSlnSysAppService var4 = (PSDevSlnSysAppService)ServiceGlobal.getService(
               PSDevSlnSysAppService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
            );
            PSDevSlnSysApp var5 = new PSDevSlnSysApp();
            var1.copyTo(var5, false);
            var5.setPSDevSlnSysId(var3);
            var4.fillEntityKeyValue(var5);
            if (var4.checkKey(var5) == 1) {
               var4.remove(var5);
            }
         }
      }

      super.onBeforeRemove(var1);
   }

   protected void onAfterCreate(PSSysApp var1) throws Exception {
      if (var1.isPSPFStyleIdDirty()) {
         this.buildPSSysProject(var1);
      }

      if (var1.getPSSystem() != null) {
         String var2 = var1.getPSSystem().getPSDevSlnSysId();
         if (!StringHelper.isNullOrEmpty(var2)) {
            PSDevSlnSysAppService var3 = (PSDevSlnSysAppService)ServiceGlobal.getService(
               PSDevSlnSysAppService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
            );
            PSDevSlnSysApp var4 = new PSDevSlnSysApp();
            var1.copyTo(var4, false);
            var4.setPSDevSlnSysId(var2);
            var4.setPSDevSlnSysAppName(var1.getPSSysAppName());
            var3.create(var4, false);
         }
      }

      this.initPSDynaApp(var1);
      super.onAfterCreate(var1);
   }

   protected void onAfterUpdate(PSSysApp var1) throws Exception {
      if (var1.isPSPFStyleIdDirty()) {
         PSSysApp var2 = var1;
         if (StringHelper.isNullOrEmpty(var1.getPSSystemId())
            || StringHelper.isNullOrEmpty(var1.getPSSystemName())
            || StringHelper.isNullOrEmpty(var1.getPSSysAppId())
            || StringHelper.isNullOrEmpty(var1.getPSSysAppName())
            || StringHelper.isNullOrEmpty(var1.getAppPKGName())) {
            PSSysApp var3 = this.getLast(var1);
            var2 = new PSSysApp();
            var3.copyTo(var2, false);
            var1.copyTo(var2, false);
         }

         this.buildPSSysProject(var2);
      }

      String var5 = null;
      if (var1.getPSSystem() != null) {
         var5 = var1.getPSSystem().getPSDevSlnSysId();
      } else {
         PSSysApp var6 = this.getLast(var1);
         if (var6.getPSSystem() != null) {
            var5 = var6.getPSSystem().getPSDevSlnSysId();
         }
      }

      if (!StringHelper.isNullOrEmpty(var5)) {
         PSDevSlnSysAppService var7 = (PSDevSlnSysAppService)ServiceGlobal.getService(
            PSDevSlnSysAppService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
         );
         PSDevSlnSysApp var4 = new PSDevSlnSysApp();
         var1.copyTo(var4, false);
         var4.setPSDevSlnSysId(var5);
         if (!StringHelper.isNullOrEmpty(var1.getPSSysAppName())) {
            var4.setPSDevSlnSysAppName(var1.getPSSysAppName());
         }

         var7.save(var4, false);
      }

      this.initPSDynaApp(var1);
      super.onAfterUpdate(var1);
   }

   protected void buildPSSysProject(PSSysApp var1) throws Exception {
      if (StringHelper.isNullOrEmpty(var1.getPSPFStyleId())) {
         PSSysProjectService var2 = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, this.getSessionFactory());

         for (PSSysProject var5 : var1.getPSSysProjects()) {
            var2.remove(var5);
         }
      } else {
         PSPFStyleService var11 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
         PSPFStyle var12 = new PSPFStyle();
         var12.setPSPFStyleId(var1.getPSPFStyleId());
         var11.get(var12);

         ArrayList<PSPFStylePrj> var13;
         for (var13 = var12.getPSPFStylePrjs(); var13.size() == 0; var13 = var12.getPSPFStylePrjs()) {
            var12 = var12.getTemplPSPFStyle();
            if (var12 == null) {
               break;
            }
         }

         PSSysProjectService var14 = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, this.getSessionFactory());
         ArrayList<PSSysProject> var6 = var1.getPSSysProjects();
         HashMap<String, PSSysProject> var7 = new HashMap<String, PSSysProject>();

         for (PSSysProject var9 : var6) {
            var7.put(var9.getPSSysProjectId(), var9);
         }

         for (PSPFStylePrj var17 : var13) {
            PSSysProject var10 = new PSSysProject();
            var10.setPSSysProjectName(var17.getNameFmt().replace("_APPPKGNAME_", var1.getAppPKGName()));
            var10.setPSSystemId(var1.getPSSystemId());
            var10.setPSSystemName(var1.getPSSystemName());
            var10.setPrjType(var17.getPrjType());
            var10.setReadOnlyMode(var17.getReadOnlyMode());
            var10.setPSObjType("PSSYSAPP");
            var10.setPSSysAppId(var1.getPSSysAppId());
            var10.setPSSysAppName(var1.getPSSysAppName());
            var10.setPSObjId(var1.getPSSysAppId());
            var10.setPSObjName(var1.getPSSysAppName());
            var14.save(var10);
            var7.remove(var10.getPSSysProjectId());
         }

         for (PSSysProject var18 : var7.values()) {
            var14.remove(var18);
         }
      }
   }

   @Override
   protected boolean isPrepareLastForUpdate() {
      return true;
   }

   protected void initPSDynaApp(PSSysApp var1) throws Exception {
      if (var1.isEnableDynaSysDirty()) {
         if (DataObject.getBoolValue(var1.getEnableDynaSys(), false)) {
            if (var1.getPSSystem() != null) {
               if (DataObject.getIntegerValue(var1.getPSSystem().getEnableDynaSys(), 0) == 0) {
                  throw new Exception(StringHelper.format("当前系统没有启用动态系统功能，不能启用应用的动态功能"));
               }

               PSDynaAppService var2 = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, this.getSessionFactory());
               PSDynaApp var3 = new PSDynaApp();
               var3.setPSDynaAppId(var1.getPSSysAppId());
               if (var1.isPSSysAppNameDirty()) {
                  var3.setPSDynaAppName(var1.getPSSysAppName());
               }

               var3.setPSDynaSysId(var1.getPSSystem().getPSSystemId());
               var3.setPSDynaSysName(var1.getPSSystem().getPSSystemName());
               if (var1.isLogicNameDirty()) {
                  var3.setLogicName(var1.getLogicName());
               }

               var2.save(var3);
            }
         }
      }
   }

   @Override
   protected void onInitPSAppModules(PSSysApp var1) throws Exception {
      if (!var1.isFullEntity()) {
         this.get(var1);
      } else {
         var1.setSessionFactory(this.getSessionFactory());
      }

      ArrayList<PSModule> var2 = var1.getPSSystem().getPSModules();
      ArrayList<PSAppModule> var3 = var1.getPSAppModules();
      boolean var4 = true;

      for (PSAppModule var6 : var3) {
         if (DataObject.getBoolValue(var6.getDefaultFlag(), false)) {
            var4 = false;
            break;
         }
      }

      if (var4) {
         String var10 = "Ungroup";
         int var12 = 0;
         if (var12 > 0) {
            var10 = StringHelper.format("Ungroup%1$s", var12);
         }

         for (PSAppModule var8 : var3) {
            if (StringHelper.compare(var8.getCodeName(), var10, true) == 0) {
               var12++;
            }
         }

         PSAppModule var14 = new PSAppModule();
         var14.setSessionFactory(this.getSessionFactory());
         var14.setPSSysAppId(var1.getPSSysAppId());
         var14.setCodeName(var10);
         var14.setColor("orange");
         var14.setPSAppModuleName("未分类模块");
         var14.setOrderValue(99999999);
         var14.setDefaultFlag(1);
         var14.create();
      }

      for (PSModule var13 : var2) {
         if (!DataObject.getBoolValue(var13.getSubSysModule(), false)) {
            boolean var15 = true;

            for (PSAppModule var9 : var3) {
               if (StringHelper.compare(var9.getPSModuleId(), var13.getPSModuleId(), true) == 0) {
                  var15 = false;
                  break;
               }
            }

            if (var15) {
               for (PSAppModule var19 : var3) {
                  if (StringHelper.compare(var19.getCodeName(), var13.getCodeName(), true) == 0) {
                     var15 = false;
                     break;
                  }
               }
            }

            if (var15) {
               PSAppModule var18 = new PSAppModule();
               var18.setSessionFactory(this.getSessionFactory());
               var18.setPSSysAppId(var1.getPSSysAppId());
               var18.setCodeName(var13.getCodeName());
               var18.setColor(var13.getColor());
               var18.setPSAppModuleName(var13.getPSModuleName());
               var18.setPSModuleId(var13.getPSModuleId());
               var18.setOrderValue(var13.getOrderValue());
               if (var18.getOrderValue() == null) {
                  var18.setOrderValue(1000);
               }

               var18.create();
            }
         }
      }
   }

   @Override
   protected void onOpenQuickApp(PSSysApp var1) throws Exception {
      if (this.getWebContext() != null && this.getWebContext().getCurAjaxActionResult() != null) {
         var1.setSessionFactory(this.getSessionFactory());
         String var2 = var1.getPSSystem().getPSDevSlnSysId();
         if (StringHelper.isNullOrEmpty(var2)) {
            throw new Exception("当前系统没有指定开发系统");
         }

         this.getWebContext()
            .getCurAjaxActionResult()
            .setJSCode(
               StringHelper.format(
                  "window.open('quickappview.jsp?DEVSLNSYS=1&srfkeys=%1$s&PSSYSAPPID=%2$s','_blank');",
                  URLEncoder.encode(var2, "UTF-8"),
                  URLEncoder.encode(var1.getPSSysAppId(), "UTF-8")
               )
            );
      } else {
         throw new Exception("当前请求环境不正确");
      }
   }

   @Override
   protected void onGetCur(PSSysApp var1) throws Exception {
      JSONObject var2 = WebContext.getAppData();
      if (var2 == null) {
         throw new Exception(StringHelper.format("上下文数据无效"));
      }

      String var3 = var2.optString("pssysappid");
      var1.setPSSysAppId(var3);
      this.get(var1);
   }

   protected void syncPSPFStyle(PSSysApp var1) throws Exception {
      if (!StringHelper.isNullOrEmpty(var1.getPSPFStyleId())) {
         if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            PSPFStyleService var2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, this.getSessionFactory());
            PSPFStyle var3 = new PSPFStyle();
            var3.setPSPFStyleId(var1.getPSPFStyleId());
            if (!var2.get(var3, true)) {
               PSPFStyleService var4 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
               PSPFStyle var5 = new PSPFStyle();
               var5.setPSPFStyleId(var1.getPSPFStyleId());
               if (!var4.get(var5, true)) {
                  throw new Exception(StringHelper.format("无法获取指定前台模板样式[%1$s]", var1.getPSPFStyleId()));
               }

               PSPFService var6 = (PSPFService)ServiceGlobal.getService(PSPFService.class, this.getSessionFactory());
               PSPF var7 = new PSPF();
               var7.setPSPFId(var5.getPSPFId());
               if (!var6.get(var7, true)) {
                  PSPFService var8 = (PSPFService)ServiceGlobal.getService(PSPFService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
                  PSPF var9 = new PSPF();
                  var9.setPSPFId(var5.getPSPFId());
                  if (!var8.get(var9, true)) {
                     throw new Exception(StringHelper.format("无法获取指定前台模板[%1$s]", var5.getPSPFId()));
                  }

                  PSAppTypeService var10 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, PSCoreSysServiceBase.getCurMajorSessionFactory());
                  PSAppType var11 = new PSAppType();
                  var11.setPSAppTypeId(var9.getPSAppTypeId());
                  if (!var10.get(var11, true)) {
                     throw new Exception(StringHelper.format("无法获取指定前台模板[%1$s]", var5.getPSPFId()));
                  }

                  PSAppTypeService var12 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, this.getSessionFactory());
                  var12.save(var11, false);
                  var7.setPSAppTypeId(var11.getPSAppTypeId());
                  var7.setPSAppTypeName(var11.getPSAppTypeName());
                  var7.setPSPFId(var9.getPSPFId());
                  var7.setPSPFName(var9.getPSPFName());
                  var7.setValidFlag(1);
                  var6.create(var7);
               }

               var3.setPSPFStyleId(var5.getPSPFStyleId());
               var3.setPSPFStyleName(var5.getPSPFStyleName());
               var3.setPSPFId(var5.getPSPFId());
               var3.setPSPFName(var5.getPSPFName());
               var3.setStyleCode(var5.getStyleCode());
               var3.setStyleEngine(var5.getStyleEngine());
               var2.create(var3);
            }
         }
      }
   }

   public boolean fillModelV2Key(PSSysApp var1, ObjectNode var2, String var3, String var4, boolean var5) throws Exception {
      boolean var6 = super.fillModelV2Key(var1, var2, var3, var4, var5);
      if (var5) {
         var1.setPSDevSlnSysAppId(null);
      }

      return var6;
   }
}
