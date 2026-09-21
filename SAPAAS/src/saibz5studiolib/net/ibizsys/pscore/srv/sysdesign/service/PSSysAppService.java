/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexViewBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalViewBase;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysProject;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysProjectService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSSysAppService
extends PSSysAppServiceBase {
    private static final Log log = LogFactory.getLog(PSSysAppService.class);

    @Override
    protected void onBeforeCreate(PSSysApp pSSysApp) throws Exception {
        this.syncPSPFStyle(pSSysApp);
        if (pSSysApp.getDefaultPub() == null) {
            PSSysApp pSSysApp2 = new PSSysApp();
            pSSysApp2.setPSSystemId(pSSysApp.getPSSystemId());
            pSSysApp2.setDefaultPub(1);
            if (!this.existsData(pSSysApp2)) {
                pSSysApp.setDefaultPub(1);
            }
        } else if (DataObject.getBoolValue((Integer)pSSysApp.getDefaultPub(), (boolean)false)) {
            PSSysApp pSSysApp3 = new PSSysApp();
            pSSysApp3.setPSSystemId(pSSysApp.getPSSystemId());
            pSSysApp3.setDefaultPub(1);
            if (this.existsData(pSSysApp3)) {
                pSSysApp3.setDefaultPub(0);
                this.update(pSSysApp3, false);
            }
        }
        super.onBeforeCreate(pSSysApp);
    }

    @Override
    protected void onBeforeUpdate(PSSysApp pSSysApp) throws Exception {
        this.syncPSPFStyle(pSSysApp);
        if (DataObject.getBoolValue((Integer)pSSysApp.getDefaultPub(), (boolean)false)) {
            PSSysApp pSSysApp2 = new PSSysApp();
            pSSysApp2.setPSSystemId(pSSysApp.getPSSystemId());
            pSSysApp2.setDefaultPub(1);
            if (this.existsData(pSSysApp2) && StringHelper.compare((String)pSSysApp2.getPSSysAppId(), (String)pSSysApp.getPSSysAppId(), (boolean)false) != 0) {
                pSSysApp2.setDefaultPub(0);
                this.update(pSSysApp2, false);
            }
        }
        super.onBeforeUpdate(pSSysApp);
    }

    @Override
    protected void onInitModel(PSSysApp pSSysApp) throws Exception {
        super.onInitModel(pSSysApp);
        this.initPSSysAppLanRes(pSSysApp);
    }

    protected void initPSSysAppLanRes(PSSysApp pSSysApp) throws Exception {
        Serializable serializable;
        Object object;
        Object object2;
        Serializable serializable22;
        PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
        PSAppIndexViewService pSAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
        ArrayList arrayList = pSAppIndexViewService.selectByPSSysApp(pSSysApp);
        for (Serializable serializable22 : arrayList) {
            object2 = new PSAppIndexView();
            ((PSAppIndexViewBase)object2).setPSAppIndexViewId(((PSAppIndexViewBase)serializable22).getPSAppIndexViewId());
            if (!this.initPSAppViewLanRes(pSSysApp, pSLanguageResService, (PSAppView)serializable22, (PSAppView)object2)) continue;
            pSAppIndexViewService.update(object2, false);
        }
        PSAppPortalViewService pSAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        serializable22 = pSAppPortalViewService.selectByPSSysApp(pSSysApp);
        object2 = ((ArrayList)serializable22).iterator();
        while (object2.hasNext()) {
            object = (PSAppPortalView)object2.next();
            serializable = new PSAppPortalView();
            ((PSAppPortalViewBase)serializable).setPSAppPortalViewId(((PSAppPortalViewBase)object).getPSAppPortalViewId());
            if (!this.initPSAppViewLanRes(pSSysApp, pSLanguageResService, (PSAppView)object, (PSAppView)serializable)) continue;
            pSAppPortalViewService.update(serializable, false);
        }
        object2 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        object = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        serializable = pSSysApp.getPSAppMenus();
        Iterator iterator = ((ArrayList)serializable).iterator();
        while (iterator.hasNext()) {
            PSAppMenu pSAppMenu = (PSAppMenu)iterator.next();
            boolean bl = false;
            ArrayList<PSAppMenuItem> arrayList2 = pSAppMenu.getPSAppMenuItems();
            for (PSAppMenuItem pSAppMenuItem : arrayList2) {
                PSLanguageRes pSLanguageRes;
                PSAppMenuItem pSAppMenuItem2 = new PSAppMenuItem();
                pSAppMenuItem2.setPSAppMenuItemId(pSAppMenuItem.getPSAppMenuItemId());
                boolean bl2 = false;
                if (!StringHelper.isNullOrEmpty((String)pSAppMenuItem.getCaption()) && StringHelper.isNullOrEmpty((String)pSAppMenuItem.getCapPSLanResId())) {
                    pSLanguageRes = new PSLanguageRes();
                    pSLanguageRes.setPSSystemId(pSSysApp.getPSSystemId());
                    pSLanguageRes.setLanResType("CONTROL");
                    pSLanguageRes.setUserData(StringHelper.format((String)"APPMENUITEM.CAPTION.%1$s.%2$s.%3$s", (Object)pSSysApp.getAppPKGName(), (Object)pSAppMenu.getCodeName(), (Object)pSAppMenuItem.getPSAppMenuItemName()).toUpperCase());
                    if (!pSLanguageResService.select(pSLanguageRes, true)) {
                        pSLanguageRes.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSLanguageRes.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSLanguageRes.setContent(pSAppMenuItem.getCaption());
                        pSLanguageResService.create(pSLanguageRes);
                        pSAppMenuItem2.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
                        pSAppMenuItem2.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                        bl2 = true;
                    }
                }
                if (!StringHelper.isNullOrEmpty((String)pSAppMenuItem.getTooltipInfo()) && StringHelper.isNullOrEmpty((String)pSAppMenuItem.getTipPSLanResId())) {
                    pSLanguageRes = new PSLanguageRes();
                    pSLanguageRes.setPSSystemId(pSSysApp.getPSSystemId());
                    pSLanguageRes.setLanResType("CONTROL");
                    pSLanguageRes.setUserData(StringHelper.format((String)"APPMENUITEM.TOOLTIP.%1$s.%2$s.%3$s", (Object)pSSysApp.getAppPKGName(), (Object)pSAppMenu.getCodeName(), (Object)pSAppMenuItem.getPSAppMenuItemName()).toUpperCase());
                    if (!pSLanguageResService.select(pSLanguageRes, true)) {
                        pSLanguageRes.setPSSysAppId(pSSysApp.getPSSysAppId());
                        pSLanguageRes.setPSSysAppName(pSSysApp.getPSSysAppName());
                        pSLanguageRes.setContent(pSAppMenuItem.getTooltipInfo());
                        pSLanguageResService.create(pSLanguageRes);
                        pSAppMenuItem2.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
                        pSAppMenuItem2.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                        bl2 = true;
                    }
                }
                if (!bl2) continue;
                bl = true;
                ((PSCoreSysServiceBase)object).update(pSAppMenuItem2, false);
            }
            if (!bl) continue;
            PSAppMenu pSAppMenu2 = new PSAppMenu();
            pSAppMenu2.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
            ((PSCoreSysServiceBase)object2).update(pSAppMenu2, false);
        }
    }

    protected boolean initPSAppViewLanRes(PSSysApp pSSysApp, PSLanguageResService pSLanguageResService, PSAppView pSAppView, PSAppView pSAppView2) throws Exception {
        PSLanguageRes pSLanguageRes;
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSAppView.getTitle()) && StringHelper.isNullOrEmpty((String)pSAppView.getTitlePSLanResId())) {
            pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSSystemId(pSSysApp.getPSSystemId());
            pSLanguageRes.setLanResType("PAGE");
            pSLanguageRes.setUserData(StringHelper.format((String)"TITLE.%1$s.%2$s", (Object)pSAppView.getPSSysApp().getAppPKGName(), (Object)pSAppView.getPSAppViewName()).toUpperCase());
            if (!pSLanguageResService.select(pSLanguageRes, true)) {
                pSLanguageRes.setPSSysAppId(pSAppView.getPSSysAppId());
                pSLanguageRes.setPSSysAppName(pSAppView.getPSSysAppName());
                pSLanguageRes.setPSAppViewId(pSAppView.getPSAppViewId());
                pSLanguageRes.setPSAppViewName(pSAppView.getPSAppViewName());
                pSLanguageRes.setContent(pSAppView.getTitle());
                pSLanguageResService.create(pSLanguageRes);
                pSAppView2.setTitlePSLanResId(pSLanguageRes.getPSLanguageResId());
                pSAppView2.setTitlePSLanResName(pSLanguageRes.getPSLanguageResName());
                bl = true;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppView.getCaption()) && StringHelper.isNullOrEmpty((String)pSAppView.getCapPSLanResId())) {
            pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSSystemId(pSSysApp.getPSSystemId());
            pSLanguageRes.setLanResType("PAGE");
            pSLanguageRes.setUserData(StringHelper.format((String)"CAPTION.%1$s.%2$s", (Object)pSAppView.getPSSysApp().getAppPKGName(), (Object)pSAppView.getPSAppViewName()).toUpperCase());
            if (!pSLanguageResService.select(pSLanguageRes, true)) {
                pSLanguageRes.setPSSysAppId(pSAppView.getPSSysAppId());
                pSLanguageRes.setPSSysAppName(pSAppView.getPSSysAppName());
                pSLanguageRes.setPSAppViewId(pSAppView.getPSAppViewId());
                pSLanguageRes.setPSAppViewName(pSAppView.getPSAppViewName());
                pSLanguageRes.setContent(pSAppView.getCaption());
                pSLanguageResService.create(pSLanguageRes);
                pSAppView2.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
                pSAppView2.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                bl = true;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)pSAppView.getSubCaption()) && StringHelper.isNullOrEmpty((String)pSAppView.getSubCapPSLanResId())) {
            pSLanguageRes = new PSLanguageRes();
            pSLanguageRes.setPSSystemId(pSSysApp.getPSSystemId());
            pSLanguageRes.setLanResType("PAGE");
            pSLanguageRes.setUserData(StringHelper.format((String)"SUBCAP.%1$s.%2$s", (Object)pSAppView.getPSSysApp().getAppPKGName(), (Object)pSAppView.getPSAppViewName()).toUpperCase());
            if (!pSLanguageResService.select(pSLanguageRes, true)) {
                pSLanguageRes.setPSSysAppId(pSAppView.getPSSysAppId());
                pSLanguageRes.setPSSysAppName(pSAppView.getPSSysAppName());
                pSLanguageRes.setPSAppViewId(pSAppView.getPSAppViewId());
                pSLanguageRes.setPSAppViewName(pSAppView.getPSAppViewName());
                pSLanguageRes.setContent(pSAppView.getSubCaption());
                pSLanguageResService.create(pSLanguageRes);
                pSAppView2.setSubCapPSLanResId(pSLanguageRes.getPSLanguageResId());
                pSAppView2.setSubCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                bl = true;
            }
        }
        return bl;
    }

    @Override
    protected void onBeforeRemove(PSSysApp pSSysApp) throws Exception {
        String string;
        PSSysApp pSSysApp2 = (PSSysApp)this.getLast((IEntity)pSSysApp);
        if (DataObject.getIntegerValue((Object)pSSysApp2.getRemoveFlag(), (Integer)0) != 1) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528[%1$s]\u5fc5\u987b\u8bbe\u7f6e\u4e3a[\u5141\u8bb8\u5220\u9664]\u624d\u80fd\u5220\u9664", (Object)pSSysApp2.getPSSysAppName()));
        }
        if (pSSysApp2.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysApp2.getPSSystem().getPSDevSlnSysId()))) {
            PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
            pSSysApp.copyTo((IDataObject)pSDevSlnSysApp, false);
            pSDevSlnSysApp.setPSDevSlnSysId(string);
            pSDevSlnSysAppService.fillEntityKeyValue((IEntity)pSDevSlnSysApp);
            if (pSDevSlnSysAppService.checkKey(pSDevSlnSysApp) == 1) {
                pSDevSlnSysAppService.remove((IEntity)pSDevSlnSysApp);
            }
        }
        super.onBeforeRemove(pSSysApp);
    }

    @Override
    protected void onAfterCreate(PSSysApp pSSysApp) throws Exception {
        String string;
        if (pSSysApp.isPSPFStyleIdDirty()) {
            this.buildPSSysProject(pSSysApp);
        }
        if (pSSysApp.getPSSystem() != null && !StringHelper.isNullOrEmpty((String)(string = pSSysApp.getPSSystem().getPSDevSlnSysId()))) {
            PSDevSlnSysAppService pSDevSlnSysAppService = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
            pSSysApp.copyTo((IDataObject)pSDevSlnSysApp, false);
            pSDevSlnSysApp.setPSDevSlnSysId(string);
            pSDevSlnSysApp.setPSDevSlnSysAppName(pSSysApp.getPSSysAppName());
            pSDevSlnSysAppService.create(pSDevSlnSysApp, false);
        }
        this.initPSDynaApp(pSSysApp);
        super.onAfterCreate(pSSysApp);
    }

    @Override
    protected void onAfterUpdate(PSSysApp pSSysApp) throws Exception {
        Object object;
        Object object2;
        if (pSSysApp.isPSPFStyleIdDirty()) {
            object2 = pSSysApp;
            if (StringHelper.isNullOrEmpty((String)pSSysApp.getPSSystemId()) || StringHelper.isNullOrEmpty((String)pSSysApp.getPSSystemName()) || StringHelper.isNullOrEmpty((String)pSSysApp.getPSSysAppId()) || StringHelper.isNullOrEmpty((String)pSSysApp.getPSSysAppName()) || StringHelper.isNullOrEmpty((String)pSSysApp.getAppPKGName())) {
                object = (PSSysApp)this.getLast((IEntity)pSSysApp);
                object2 = new PSSysApp();
                object.copyTo((IDataObject)object2, false);
                pSSysApp.copyTo((IDataObject)object2, false);
            }
            this.buildPSSysProject((PSSysApp)object2);
        }
        object2 = null;
        if (pSSysApp.getPSSystem() != null) {
            object2 = pSSysApp.getPSSystem().getPSDevSlnSysId();
        } else {
            object = (PSSysApp)this.getLast((IEntity)pSSysApp);
            if (((PSSysAppBase)object).getPSSystem() != null) {
                object2 = ((PSSysAppBase)object).getPSSystem().getPSDevSlnSysId();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)object2)) {
            object = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysApp pSDevSlnSysApp = new PSDevSlnSysApp();
            pSSysApp.copyTo((IDataObject)pSDevSlnSysApp, false);
            pSDevSlnSysApp.setPSDevSlnSysId((String)object2);
            if (!StringHelper.isNullOrEmpty((String)pSSysApp.getPSSysAppName())) {
                pSDevSlnSysApp.setPSDevSlnSysAppName(pSSysApp.getPSSysAppName());
            }
            object.save((IEntity)pSDevSlnSysApp, false);
        }
        this.initPSDynaApp(pSSysApp);
        super.onAfterUpdate(pSSysApp);
    }

    protected void buildPSSysProject(PSSysApp pSSysApp) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysApp.getPSPFStyleId())) {
            PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysProject> arrayList = pSSysApp.getPSSysProjects();
            for (PSSysProject pSSysProject : arrayList) {
                pSSysProjectService.remove((IEntity)pSSysProject);
            }
        } else {
            PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPFStyle pSPFStyle = new PSPFStyle();
            pSPFStyle.setPSPFStyleId(pSSysApp.getPSPFStyleId());
            pSPFStyleService.get((IEntity)pSPFStyle);
            ArrayList<PSPFStylePrj> arrayList = pSPFStyle.getPSPFStylePrjs();
            while (arrayList.size() == 0 && (pSPFStyle = pSPFStyle.getTemplPSPFStyle()) != null) {
                arrayList = pSPFStyle.getPSPFStylePrjs();
            }
            PSSysProjectService pSSysProjectService = (PSSysProjectService)ServiceGlobal.getService(PSSysProjectService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<PSSysProject> arrayList2 = pSSysApp.getPSSysProjects();
            HashMap<String, PSSysProject> hashMap = new HashMap<String, PSSysProject>();
            for (PSSysProject entityBase : arrayList2) {
                hashMap.put(entityBase.getPSSysProjectId(), entityBase);
            }
            for (PSPFStylePrj pSPFStylePrj : arrayList) {
                PSSysProject pSSysProject = new PSSysProject();
                pSSysProject.setPSSysProjectName(pSPFStylePrj.getNameFmt().replace("_APPPKGNAME_", pSSysApp.getAppPKGName()));
                pSSysProject.setPSSystemId(pSSysApp.getPSSystemId());
                pSSysProject.setPSSystemName(pSSysApp.getPSSystemName());
                pSSysProject.setPrjType(pSPFStylePrj.getPrjType());
                pSSysProject.setReadOnlyMode(pSPFStylePrj.getReadOnlyMode());
                pSSysProject.setPSObjType("PSSYSAPP");
                pSSysProject.setPSSysAppId(pSSysApp.getPSSysAppId());
                pSSysProject.setPSSysAppName(pSSysApp.getPSSysAppName());
                pSSysProject.setPSObjId(pSSysApp.getPSSysAppId());
                pSSysProject.setPSObjName(pSSysApp.getPSSysAppName());
                pSSysProjectService.save((IEntity)pSSysProject);
                hashMap.remove(pSSysProject.getPSSysProjectId());
            }
            for (PSSysProject pSSysProject : hashMap.values()) {
                pSSysProjectService.remove((IEntity)pSSysProject);
            }
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected void initPSDynaApp(PSSysApp pSSysApp) throws Exception {
        if (!pSSysApp.isEnableDynaSysDirty()) {
            return;
        }
        if (!DataObject.getBoolValue((Integer)pSSysApp.getEnableDynaSys(), (boolean)false)) {
            return;
        }
        if (pSSysApp.getPSSystem() == null) {
            return;
        }
        if (DataObject.getIntegerValue((Object)pSSysApp.getPSSystem().getEnableDynaSys(), (Integer)0) == 0) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u542f\u7528\u52a8\u6001\u7cfb\u7edf\u529f\u80fd\uff0c\u4e0d\u80fd\u542f\u7528\u5e94\u7528\u7684\u52a8\u6001\u529f\u80fd"));
        }
        PSDynaAppService pSDynaAppService = (PSDynaAppService)ServiceGlobal.getService(PSDynaAppService.class, (SessionFactory)this.getSessionFactory());
        PSDynaApp pSDynaApp = new PSDynaApp();
        pSDynaApp.setPSDynaAppId(pSSysApp.getPSSysAppId());
        if (pSSysApp.isPSSysAppNameDirty()) {
            pSDynaApp.setPSDynaAppName(pSSysApp.getPSSysAppName());
        }
        pSDynaApp.setPSDynaSysId(pSSysApp.getPSSystem().getPSSystemId());
        pSDynaApp.setPSDynaSysName(pSSysApp.getPSSystem().getPSSystemName());
        if (pSSysApp.isLogicNameDirty()) {
            pSDynaApp.setLogicName(pSSysApp.getLogicName());
        }
        pSDynaAppService.save((IEntity)pSDynaApp);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onInitPSAppModules(PSSysApp pSSysApp) throws Exception {
        if (!pSSysApp.isFullEntity()) {
            this.get((IEntity)pSSysApp);
        } else {
            pSSysApp.setSessionFactory(this.getSessionFactory());
        }
        ArrayList<PSModule> arrayList = pSSysApp.getPSSystem().getPSModules();
        ArrayList<PSAppModule> arrayList2 = pSSysApp.getPSAppModules();
        boolean bl = true;
        for (PSAppModule entityBase : arrayList2) {
            if (!DataObject.getBoolValue((Integer)entityBase.getDefaultFlag(), (boolean)false)) continue;
            bl = false;
            break;
        }
        if (bl) {
            Object object = "Ungroup";
            int n = 0;
            if (n > 0) {
                object = StringHelper.format((String)"Ungroup%1$s", (Object)n);
            }
            for (PSAppModule pSAppModule : arrayList2) {
                void var6_8;
                if (StringHelper.compare((String)pSAppModule.getCodeName(), (String)object, (boolean)true) != 0) continue;
                ++var6_8;
            }
            PSAppModule pSAppModule = new PSAppModule();
            pSAppModule.setSessionFactory(this.getSessionFactory());
            pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppModule.setCodeName((String)object);
            pSAppModule.setColor("orange");
            pSAppModule.setPSAppModuleName("\u672a\u5206\u7c7b\u6a21\u5757");
            pSAppModule.setOrderValue(99999999);
            pSAppModule.setDefaultFlag(1);
            pSAppModule.create();
        }
        for (PSModule pSModule : arrayList) {
            if (DataObject.getBoolValue((Integer)pSModule.getSubSysModule(), (boolean)false)) continue;
            boolean bl2 = true;
            for (PSAppModule pSAppModule : arrayList2) {
                if (StringHelper.compare((String)pSAppModule.getPSModuleId(), (String)pSModule.getPSModuleId(), (boolean)true) != 0) continue;
                bl2 = false;
                break;
            }
            if (bl2) {
                for (PSAppModule pSAppModule : arrayList2) {
                    if (StringHelper.compare((String)pSAppModule.getCodeName(), (String)pSModule.getCodeName(), (boolean)true) != 0) continue;
                    bl2 = false;
                    break;
                }
            }
            if (!bl2) continue;
            PSAppModule pSAppModule = new PSAppModule();
            pSAppModule.setSessionFactory(this.getSessionFactory());
            pSAppModule.setPSSysAppId(pSSysApp.getPSSysAppId());
            pSAppModule.setCodeName(pSModule.getCodeName());
            pSAppModule.setColor(pSModule.getColor());
            pSAppModule.setPSAppModuleName(pSModule.getPSModuleName());
            pSAppModule.setPSModuleId(pSModule.getPSModuleId());
            pSAppModule.setOrderValue(pSModule.getOrderValue());
            if (pSAppModule.getOrderValue() == null) {
                pSAppModule.setOrderValue(1000);
            }
            pSAppModule.create();
        }
    }

    @Override
    protected void onOpenQuickApp(PSSysApp pSSysApp) throws Exception {
        if (this.getWebContext() == null || this.getWebContext().getCurAjaxActionResult() == null) {
            throw new Exception("\u5f53\u524d\u8bf7\u6c42\u73af\u5883\u4e0d\u6b63\u786e");
        }
        pSSysApp.setSessionFactory(this.getSessionFactory());
        String string = pSSysApp.getPSSystem().getPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf");
        }
        this.getWebContext().getCurAjaxActionResult().setJSCode(StringHelper.format((String)"window.open('quickappview.jsp?DEVSLNSYS=1&srfkeys=%1$s&PSSYSAPPID=%2$s','_blank');", (Object)URLEncoder.encode(string, "UTF-8"), (Object)URLEncoder.encode(pSSysApp.getPSSysAppId(), "UTF-8")));
    }

    @Override
    protected void onGetCur(PSSysApp pSSysApp) throws Exception {
        JSONObject jSONObject = WebContext.getAppData();
        if (jSONObject == null) {
            throw new Exception(StringHelper.format((String)"\u4e0a\u4e0b\u6587\u6570\u636e\u65e0\u6548"));
        }
        String string = jSONObject.optString("pssysappid");
        pSSysApp.setPSSysAppId(string);
        this.get((IEntity)pSSysApp);
    }

    protected void syncPSPFStyle(PSSysApp pSSysApp) throws Exception {
        if (StringHelper.isNullOrEmpty((String)pSSysApp.getPSPFStyleId())) {
            return;
        }
        if (this.getSessionFactory() == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        PSPFStyleService pSPFStyleService = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)this.getSessionFactory());
        PSPFStyle pSPFStyle = new PSPFStyle();
        pSPFStyle.setPSPFStyleId(pSSysApp.getPSPFStyleId());
        if (pSPFStyleService.get((IEntity)pSPFStyle, true)) {
            return;
        }
        PSPFStyleService pSPFStyleService2 = (PSPFStyleService)ServiceGlobal.getService(PSPFStyleService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSPFStyle pSPFStyle2 = new PSPFStyle();
        pSPFStyle2.setPSPFStyleId(pSSysApp.getPSPFStyleId());
        if (!pSPFStyleService2.get((IEntity)pSPFStyle2, true)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f\u6837\u5f0f[%1$s]", (Object)pSSysApp.getPSPFStyleId()));
        }
        PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
        PSPF pSPF = new PSPF();
        pSPF.setPSPFId(pSPFStyle2.getPSPFId());
        if (!pSPFService.get((IEntity)pSPF, true)) {
            PSPFService pSPFService2 = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSPF pSPF2 = new PSPF();
            pSPF2.setPSPFId(pSPFStyle2.getPSPFId());
            if (!pSPFService2.get((IEntity)pSPF2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSAppType pSAppType = new PSAppType();
            pSAppType.setPSAppTypeId(pSPF2.getPSAppTypeId());
            if (!pSAppTypeService.get((IEntity)pSAppType, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u524d\u53f0\u6a21\u677f[%1$s]", (Object)pSPFStyle2.getPSPFId()));
            }
            PSAppTypeService pSAppTypeService2 = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
            pSAppTypeService2.save((IEntity)pSAppType, false);
            pSPF.setPSAppTypeId(pSAppType.getPSAppTypeId());
            pSPF.setPSAppTypeName(pSAppType.getPSAppTypeName());
            pSPF.setPSPFId(pSPF2.getPSPFId());
            pSPF.setPSPFName(pSPF2.getPSPFName());
            pSPF.setValidFlag(1);
            pSPFService.create(pSPF);
        }
        pSPFStyle.setPSPFStyleId(pSPFStyle2.getPSPFStyleId());
        pSPFStyle.setPSPFStyleName(pSPFStyle2.getPSPFStyleName());
        pSPFStyle.setPSPFId(pSPFStyle2.getPSPFId());
        pSPFStyle.setPSPFName(pSPFStyle2.getPSPFName());
        pSPFStyle.setStyleCode(pSPFStyle2.getStyleCode());
        pSPFStyle.setStyleEngine(pSPFStyle2.getStyleEngine());
        pSPFStyleService.create(pSPFStyle);
    }

    @Override
    public boolean fillModelV2Key(PSSysApp pSSysApp, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        boolean bl2 = super.fillModelV2Key(pSSysApp, objectNode, string, string2, bl);
        if (bl) {
            pSSysApp.setPSDevSlnSysAppId(null);
        }
        return bl2;
    }
}

