/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdevstudio.service;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWAppFunc;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWAppFuncServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class PSUWAppFuncService
extends PSUWAppFuncServiceBase {
    private static final Log log = LogFactory.getLog(PSUWAppFuncService.class);

    @Override
    protected void onBeforeCreate(PSUWAppFunc pSUWAppFunc) throws Exception {
        if (WebContext.getCurrent() != null && WebContext.getReferData() != null) {
            IDataEntityModel iDataEntityModel;
            String string = WebContext.getReferData().optString("srfdeid");
            String string2 = WebContext.getReferData().optString("srfkey");
            if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)string2) && StringHelper.compare((String)(iDataEntityModel = DEModelGlobal.getDEModel((String)string)).getName(), (String)"PSAPPMENUITEM", (boolean)true) == 0) {
                PSAppMenuItem pSAppMenuItem = new PSAppMenuItem();
                pSAppMenuItem.setPSAppMenuItemId(string2);
                PSAppMenuItemService pSAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
                if (pSAppMenuItemService.autoGet(pSAppMenuItem, true) && pSAppMenuItem.getPSAppMenu() != null) {
                    pSUWAppFunc.setPSSysAppId(pSAppMenuItem.getPSAppMenu().getPSSysAppId());
                }
            }
        }
        super.onBeforeCreate(pSUWAppFunc);
    }

    @Override
    protected void onFinishStepSelecttype(PSUWAppFunc pSUWAppFunc) throws Exception {
        if (StringHelper.compare((String)pSUWAppFunc.getAppFuncType(), (String)"APPVIEW", (boolean)true) == 0) {
            pSUWAppFunc.setAppViewType("APPDEVIEW");
            pSUWAppFunc.setOpenMode("INDEXVIEWTAB");
            pSUWAppFunc.setSRFNextForm("selectview");
        } else {
            pSUWAppFunc.setSRFNextForm("finish");
        }
        this.update(pSUWAppFunc);
    }

    @Override
    protected void onFinishStepSelectview(PSUWAppFunc pSUWAppFunc) throws Exception {
        PSUWAppFunc pSUWAppFunc2 = new PSUWAppFunc();
        pSUWAppFunc2.setPSUWAppFuncId(pSUWAppFunc.getPSUWAppFuncId());
        this.get(pSUWAppFunc2);
        if (StringHelper.compare((String)pSUWAppFunc.getAppViewType(), (String)"APPDEVIEW", (boolean)true) == 0) {
            PSAppDEView appDEView = new PSAppDEView();
            appDEView.setPSDEViewBaseId(pSUWAppFunc.getPSDEViewBaseId());
            appDEView.setPSSysAppId(pSUWAppFunc.getPSSysAppId());
            appDEView.setSessionFactory(this.getSessionFactory());
            if (!appDEView.select(true)) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(pSUWAppFunc.getPSDEId());
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(pSUWAppFunc.getPSSysAppId());
                PSAppModuleService pSAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
                PSAppModule pSAppModule = pSAppModuleService.getDefaultByPSDataEntity(pSSysApp, pSDataEntity);
                appDEView.setPSDEViewBaseName(pSUWAppFunc.getPSDEViewBaseName());
                appDEView.setPSAppModuleId(pSAppModule.getPSAppModuleId());
                appDEView.setPSAppModuleName(pSAppModule.getPSAppModuleName());
                appDEView.setPSSysAppName(pSAppModule.getPSSysAppName());
                appDEView.create();
            }
            pSUWAppFunc.setPSAppViewId(appDEView.getPSAppDEViewId());
            pSUWAppFunc.setPSAppViewName(appDEView.getPSAppDEViewName());
        } else if (StringHelper.compare((String)pSUWAppFunc.getAppViewType(), (String)"APPINDEXVIEW", (boolean)true) == 0) {
            pSUWAppFunc.setPSAppViewId(pSUWAppFunc.getPSAppIndexViewId());
            pSUWAppFunc.setPSAppViewName(pSUWAppFunc.getPSAppIndexViewName());
        } else if (StringHelper.compare((String)pSUWAppFunc.getAppViewType(), (String)"APPPORTALVIEW", (boolean)true) == 0) {
            pSUWAppFunc.setPSAppViewId(pSUWAppFunc.getPSAppPortalViewId());
            pSUWAppFunc.setPSAppViewName(pSUWAppFunc.getPSAppPortalViewName());
        }
        PSAppFunc appFunc = new PSAppFunc();
        appFunc.setSessionFactory(this.getSessionFactory());
        appFunc.setAppFuncType(pSUWAppFunc2.getAppFuncType());
        appFunc.setPSSysAppId(pSUWAppFunc.getPSSysAppId());
        appFunc.setPSAppViewId(pSUWAppFunc.getPSAppViewId());
        if (appFunc.select(true)) {
            pSUWAppFunc.setPSAppFuncId(appFunc.getPSAppFuncId());
            pSUWAppFunc.setPSAppFuncName(appFunc.getPSAppFuncName());
            pSUWAppFunc.setPSUWAppFuncName(appFunc.getPSAppFuncName());
            pSUWAppFunc.setTooltipInfo(appFunc.getTooltipInfo());
            pSUWAppFunc.setMemo(appFunc.getMemo());
        }
        pSUWAppFunc.setSRFNextForm("finish");
        this.update(pSUWAppFunc);
    }

    @Override
    protected void onFinishStepFinish(PSUWAppFunc pSUWAppFunc) throws Exception {
        this.update(pSUWAppFunc);
    }

    @Override
    protected void onFinishWizard(PSUWAppFunc pSUWAppFunc) throws Exception {
        PSUWAppFunc pSUWAppFunc2 = new PSUWAppFunc();
        pSUWAppFunc2.setPSUWAppFuncId(pSUWAppFunc.getPSUWAppFuncId());
        this.get(pSUWAppFunc2);
        PSAppFunc pSAppFunc = new PSAppFunc();
        pSUWAppFunc2.copyTo((IDataObject)pSAppFunc, false);
        pSAppFunc.setPSAppFuncName(pSUWAppFunc2.getPSUWAppFuncName());
        pSAppFunc.setSessionFactory(this.getSessionFactory());
        if (StringHelper.isNullOrEmpty((String)pSAppFunc.getPSAppFuncId())) {
            PSSysApp pSSysApp = new PSSysApp();
            pSSysApp.setPSSysAppId(pSUWAppFunc2.getPSSysAppId());
            pSSysApp.setSessionFactory(this.getSessionFactory());
            pSSysApp.get();
            pSAppFunc.setPSSysAppName(pSSysApp.getPSSysAppName());
            pSAppFunc.create();
        } else {
            pSAppFunc.update();
        }
        pSUWAppFunc.reset();
        pSUWAppFunc.setPSUWAppFuncId(pSUWAppFunc2.getPSUWAppFuncId());
        pSUWAppFunc.setPSAppFuncId(pSAppFunc.getPSAppFuncId());
        pSUWAppFunc.setPSAppFuncName(pSAppFunc.getPSAppFuncName());
        this.update(pSUWAppFunc);
    }
}
