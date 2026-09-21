/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppModule
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService
 *  net.ibizsys.pscore.srv.config.entity.PSSubSys
 *  net.ibizsys.pscore.srv.config.entity.PSSubSysVer
 *  net.ibizsys.pscore.srv.config.service.PSSubSysService
 *  net.ibizsys.pscore.srv.config.service.PSSubSysVerService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysVer;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.config.service.PSSubSysVerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class InitAppModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
    private static final Log log = LogFactory.getLog(InitAppModelPSSysDevBKTaskImpl.class);

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onRun() throws Exception {
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysApp psSysApp2 = new PSSysApp();
        psSysApp2.setPSSysAppId(this.psSysDevBKTask.getTASKPARAM());
        psSysAppService.get((IEntity)psSysApp2);
        try {
            PSCoreSysServiceBase.setCurrentPSSystemId((String)psSysApp2.getPSSystemId());
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId((String)this.getPSDevSlnSysId());
            SessionFactoryManager.addRef();
            String strResult = this.initSyncModel(psSysApp2);
            SessionFactoryManager.releaseRef((boolean)true);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            return strResult;
        }
        catch (Exception ex) {
            PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
            PSCoreSysServiceBase.setCurrentPSSystemId(null);
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String initSyncModel(PSSysApp psSysApp2) throws Exception {
        ActionSessionManager.openSession((String)"");
        try {
            StringBuilderEx sBuilderEx = new StringBuilderEx();
            sBuilderEx.append("\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5f00\u59cb\r\n");
            SessionFactory curSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId());
            SessionFactory srcSessionFactory = null;
            String strSysType = this.psSysDevBKTask.getTASKPARAM2();
            if (StringHelper.compare((String)strSysType, (String)"SYSREFAPP", (boolean)true) == 0) {
                String strPSSysRefId = this.psSysDevBKTask.getTASKPARAM3();
                if (StringHelper.isNullOrEmpty((String)strPSSysRefId)) throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5b50\u7cfb\u7edf\u6807\u8bc6"));
                PSSysRefService psSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)curSessionFactory);
                PSSysRef psSysRef = new PSSysRef();
                psSysRef.setPSSysRefId(strPSSysRefId);
                if (!psSysRefService.get((IEntity)psSysRef, true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u5f15\u7528[%1$s]", (Object)strPSSysRefId));
                }
                if (StringHelper.compare((String)psSysRef.getSysRefType(), (String)"SUBSYS", (boolean)true) != 0) throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9e\u73b0"));
                String strPSSubSysId = psSysRef.getPSSubSysId();
                PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class);
                PSSubSys psSubSys = new PSSubSys();
                psSubSys.setPSSubSysId(strPSSubSysId);
                if (!psSubSysService.get((IEntity)psSubSys, true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]", (Object)strPSSubSysId));
                }
                PSSubSysVerService psSubSysVerService = (PSSubSysVerService)ServiceGlobal.getService(PSSubSysVerService.class);
                PSSubSysVer psSubSysVer = new PSSubSysVer();
                psSubSysVer.setPSSubSysId(psSubSys.getPSSubSysId());
                psSubSysVer.setVersion(psSubSys.getVersion());
                if (!psSubSysVerService.select((IEntity)psSubSysVer, true)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b50\u7cfb\u7edf[%1$s]\u7248\u672c[%2$s]", (Object)psSubSys.getPSSubSysName(), (Object)psSubSys.getVersion()));
                }
                srcSessionFactory = PSSysModelInstGlobal.getSessionFactory((String)psSubSysVer.getPSSysModelInstId());
            } else {
                srcSessionFactory = curSessionFactory;
                if (StringHelper.compare((String)this.psSysDevBKTask.getTASKPARAM4(), (String)psSysApp2.getPSSysAppId(), (boolean)false) == 0) {
                    throw new Exception("\u521d\u59cb\u5316\u6e90\u7cfb\u7edf\u5e94\u7528\u4e0d\u80fd\u4e0e\u5f53\u524d\u5e94\u7528\u4e00\u81f4");
                }
            }
            String strPSSysAppId = this.psSysDevBKTask.getTASKPARAM4();
            PSSysApp psSysApp = new PSSysApp();
            psSysApp.setPSSysAppId(strPSSysAppId);
            HashMap<String, PSAppModule> psAppModuleMap = new HashMap<String, PSAppModule>();
            HashMap<String, PSAppDEView> psAppDEViewMap = new HashMap<String, PSAppDEView>();
            HashMap<String, Object> psAppFuncMap = new HashMap<String, Object>();
            HashMap<String, PSAppMenu> psAppMenuMap = new HashMap<String, PSAppMenu>();
            PSAppModuleService psAppModuleService2 = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)curSessionFactory);
            ArrayList psAppModuleList2 = psAppModuleService2.selectByPSSysApp((PSSysAppBase)psSysApp2);
            for (PSAppModule psAppModule : psAppModuleList2) {
                if (StringHelper.isNullOrEmpty((String)psAppModule.getFromObjId())) continue;
                psAppModuleMap.put(psAppModule.getFromObjId(), psAppModule);
            }
            PSAppModuleService psAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)srcSessionFactory);
            ArrayList psAppModuleList = psAppModuleService.selectByPSSysApp((PSSysAppBase)psSysApp);
            Iterator iterator = psAppModuleList.iterator();
            while (iterator.hasNext()) {
                PSAppModule psAppModule = (PSAppModule)iterator.next();
                if (psAppModuleMap.containsKey(psAppModule.getPSAppModuleId())) continue;
                psAppModule.setFromObjId(psAppModule.getPSAppModuleId());
                psAppModule.resetPSAppModuleId();
                psAppModule.setPSSysAppId(psSysApp2.getPSSysAppId());
                psAppModule.setPSSysAppName(psSysApp2.getPSSysAppName());
                psAppModuleService2.create((IEntity)psAppModule);
                psAppModuleMap.put(psAppModule.getFromObjId(), psAppModule);
                sBuilderEx.append("[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)psAppModuleService2.getDEModel().getLogicName(), (Object)psAppModuleService2.getDEModel().getDataInfo((IEntity)psAppModule));
            }
            PSAppDEViewService psAppDEViewService2 = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)curSessionFactory);
            ArrayList psAppDEViewList2 = psAppDEViewService2.selectByPSSysApp((PSSysAppBase)psSysApp2);
            for (PSAppDEView psAppDEView : psAppDEViewList2) {
                psAppDEViewMap.put(KeyValueHelper.genUniqueId((String)psSysApp.getPSSysAppId(), (String)psAppDEView.getPSDEViewBaseId()), psAppDEView);
            }
            PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)srcSessionFactory);
            ArrayList psAppDEViewList = psAppDEViewService.selectByPSSysApp((PSSysAppBase)psSysApp);
            iterator = psAppDEViewList.iterator();
            while (iterator.hasNext()) {
                PSAppDEView psAppDEView = (PSAppDEView)iterator.next();
                if (psAppDEViewMap.containsKey(psAppDEView.getPSAppDEViewId())) continue;
                psAppDEView.resetPSAppDEViewId();
                psAppDEView.setPSSysAppId(psSysApp2.getPSSysAppId());
                psAppDEView.setPSSysAppName(psSysApp2.getPSSysAppName());
                PSAppModule psAppModule = (PSAppModule)psAppModuleMap.get(psAppDEView.getPSAppModuleId());
                if (psAppModule != null) {
                    psAppDEView.setPSAppModuleId(psAppModule.getPSAppModuleId());
                    psAppDEView.setPSAppModuleName(psAppModule.getPSAppModuleName());
                }
                psAppDEViewService2.create((IEntity)psAppDEView);
                psAppDEViewMap.put(KeyValueHelper.genUniqueId((String)psSysApp.getPSSysAppId(), (String)psAppDEView.getPSDEViewBaseId()), psAppDEView);
                sBuilderEx.append("[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)psAppDEViewService2.getDEModel().getLogicName(), (Object)psAppDEViewService2.getDEModel().getDataInfo((IEntity)psAppDEView));
            }
            PSAppFuncService psAppFuncService2 = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)curSessionFactory);
            ArrayList psAppFuncList2 = psAppFuncService2.selectByPSSysApp((PSSysAppBase)psSysApp2);
            for (PSAppFunc psAppFunc : psAppFuncList2) {
                if (StringHelper.isNullOrEmpty((String)psAppFunc.getFromObjId())) continue;
                psAppFuncMap.put(psAppFunc.getFromObjId(), psAppFunc);
            }
            PSAppFuncService psAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)srcSessionFactory);
            ArrayList psAppFuncList = psAppFuncService.selectByPSSysApp((PSSysAppBase)psSysApp);
            for (Object psAppFunc : psAppFuncList) {
                PSAppDEView psAppView;
                if (psAppFuncMap.containsKey(psAppFunc.getPSAppFuncId())) continue;
                psAppFunc.setFromObjId(psAppFunc.getPSAppFuncId());
                psAppFunc.resetPSAppFuncId();
                psAppFunc.setPSSysAppId(psSysApp2.getPSSysAppId());
                psAppFunc.setPSSysAppName(psSysApp2.getPSSysAppName());
                if (!StringHelper.isNullOrEmpty((String)psAppFunc.getPSAppViewId()) && (psAppView = (PSAppDEView)psAppDEViewMap.get(psAppFunc.getPSAppViewId())) != null) {
                    psAppFunc.setPSAppViewId(psAppView.getPSAppDEViewId());
                    psAppFunc.setPSAppViewName(psAppView.getPSAppDEViewName());
                }
                psAppFuncService2.create((IEntity)psAppFunc);
                psAppFuncMap.put(psAppFunc.getFromObjId(), psAppFunc);
                sBuilderEx.append("[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)psAppFuncService2.getDEModel().getLogicName(), (Object)psAppFuncService2.getDEModel().getDataInfo((IEntity)psAppFunc));
            }
            PSAppMenuService psAppMenuService2 = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)curSessionFactory);
            PSAppMenuItemService psAppMenuItemService2 = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)curSessionFactory);
            ArrayList psAppMenuList2 = psAppMenuService2.selectByPSSysApp((PSSysAppBase)psSysApp2);
            for (PSAppMenu psAppMenu : psAppMenuList2) {
                if (StringHelper.isNullOrEmpty((String)psAppMenu.getFromObjId())) continue;
                psAppMenuMap.put(psAppMenu.getFromObjId(), psAppMenu);
            }
            PSAppMenuService psAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)srcSessionFactory);
            PSAppMenuItemService psAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)srcSessionFactory);
            ArrayList psAppMenuList = psAppMenuService.selectByPSSysApp((PSSysAppBase)psSysApp);
            for (PSAppMenu psAppMenu : psAppMenuList) {
                if (psAppMenuMap.containsKey(psAppMenu.getPSAppMenuId())) continue;
                ArrayList psAppMenuItemList = psAppMenuItemService.selectByPSAppMenu((PSAppMenuBase)psAppMenu);
                psAppMenu.setFromObjId(psAppMenu.getPSAppMenuId());
                psAppMenu.resetPSAppMenuId();
                psAppMenu.setPSSysAppId(psSysApp2.getPSSysAppId());
                psAppMenu.setPSSysAppName(psSysApp2.getPSSysAppName());
                psAppMenuService2.create((IEntity)psAppMenu);
                psAppMenuMap.put(psAppMenu.getFromObjId(), psAppMenu);
                HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
                while (psAppMenuItemList.size() > 0) {
                    PSAppMenuItem psAppMenuItem = (PSAppMenuItem)psAppMenuItemList.remove(0);
                    if (StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAppMenuItemId())) {
                        PSAppFunc psAppFunc;
                        if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPSAppFuncId()) && (psAppFunc = (PSAppFunc)psAppFuncMap.get(psAppMenuItem.getPSAppFuncId())) != null) {
                            psAppMenuItem.setPSAppFuncId(psAppFunc.getPSAppFuncId());
                            psAppMenuItem.setPSAppFuncName(psAppFunc.getPSAppFuncName());
                        }
                        psAppMenuItem.setPSAppMenuId(psAppMenu.getPSAppMenuId());
                        psAppMenuItem.setPSAppMenuName(psAppMenu.getPSAppMenuName());
                        String strOriginId = psAppMenuItem.getPSAppMenuItemId();
                        psAppMenuItem.resetPSAppMenuItemId();
                        psAppMenuItemService2.create((IEntity)psAppMenuItem);
                        psAppMenuItemMap.put(strOriginId, psAppMenuItem);
                        continue;
                    }
                    PSAppMenuItem pPSAppMenuItem = (PSAppMenuItem)psAppMenuItemMap.get(psAppMenuItem.getPPSAppMenuItemId());
                    if (pPSAppMenuItem != null) {
                        PSAppFunc psAppFunc;
                        psAppMenuItem.setPPSAppMenuItemId(pPSAppMenuItem.getPSAppMenuItemId());
                        psAppMenuItem.setPPSAppMenuItemName(pPSAppMenuItem.getPSAppMenuItemName());
                        if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPSAppFuncId()) && (psAppFunc = (PSAppFunc)psAppFuncMap.get(psAppMenuItem.getPSAppFuncId())) != null) {
                            psAppMenuItem.setPSAppFuncId(psAppFunc.getPSAppFuncId());
                            psAppMenuItem.setPSAppFuncName(psAppFunc.getPSAppFuncName());
                        }
                        psAppMenuItem.setPSAppMenuId(psAppMenu.getPSAppMenuId());
                        psAppMenuItem.setPSAppMenuName(psAppMenu.getPSAppMenuName());
                        String strOriginId = psAppMenuItem.getPSAppMenuItemId();
                        psAppMenuItem.resetPSAppMenuItemId();
                        psAppMenuItemService2.create((IEntity)psAppMenuItem);
                        psAppMenuItemMap.put(strOriginId, psAppMenuItem);
                        continue;
                    }
                    psAppMenuItemList.add(psAppMenuItem);
                }
                sBuilderEx.append("[%1$s]\u5bfc\u5165[%2$s]\r\n", (Object)psAppMenuService2.getDEModel().getLogicName(), (Object)psAppMenuService2.getDEModel().getDataInfo((IEntity)psAppMenu));
            }
            sBuilderEx.append("\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u5b8c\u6210\u3002");
            ActionSessionManager.closeSession();
            return sBuilderEx.toString();
        }
        catch (Exception ex) {
            ActionSessionManager.closeSession();
            throw ex;
        }
    }
}

