/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.PluginActionResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServicePluginBase
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItemBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppModule
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppView
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService
 *  net.ibizsys.pscore.srv.appdesign.service.PSAppViewService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppFunc;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuItemBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppModule;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppIndexViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppModuleService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPortalViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSAppMenuServicePlugin
extends ServicePluginBase {
    private static final Log log = LogFactory.getLog(PSAppMenuServicePlugin.class);

    public PluginActionResult doCopyDetails(IService iService, int nActionPos, IEntity iEntity, Object objParam) throws Exception {
        if (nActionPos == 0) {
            if (this.getSessionFactory() == null) {
                this.setSessionFactory(iService.getSessionFactory());
            }
            String psAppMenuOldId = (String)objParam;
            PSAppMenu psAppMenuNew = (PSAppMenu)iEntity;
            PSAppMenuService psAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)iService.getSessionFactory());
            PSAppMenuItemService psAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)iService.getSessionFactory());
            PSAppMenu psAppMenuOld = new PSAppMenu();
            psAppMenuOld.setPSAppMenuId(psAppMenuOldId);
            if (psAppMenuService.select((IEntity)psAppMenuOld, true)) {
                if (StringHelper.compare((String)psAppMenuNew.getPSSysAppId(), (String)psAppMenuOld.getPSSysAppId(), (boolean)false) != 0) {
                    HashMap<String, PSAppFunc> psAppFuncMap = new HashMap<String, PSAppFunc>();
                    HashMap<String, PSAppModule> psAppModuleMap = new HashMap<String, PSAppModule>();
                    ArrayList psAppMenuItemNewList = psAppMenuItemService.selectByPSAppMenu((PSAppMenuBase)psAppMenuNew);
                    if (psAppMenuItemNewList != null && psAppMenuItemNewList.size() > 0) {
                        for (PSAppMenuItem psAppMenuItem : psAppMenuItemNewList) {
                            PSAppMenuItem psAppMenuItemNow = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItem, psAppFuncMap, psAppModuleMap);
                            psAppMenuItemService.update((IEntity)psAppMenuItemNow);
                        }
                    } else {
                        ArrayList psAppMenuItemList = psAppMenuItemService.selectByPSAppMenu((PSAppMenuBase)psAppMenuOld);
                        ArrayList<PSAppMenuItem> psAppMenuItemTopLevelList = new ArrayList<PSAppMenuItem>();
                        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                            if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAppMenuItemId())) continue;
                            psAppMenuItemTopLevelList.add(psAppMenuItem);
                        }
                        for (PSAppMenuItem psAppMenuItemCurrent : psAppMenuItemTopLevelList) {
                            ArrayList menuitmeList = psAppMenuItemService.selectByPPSAppMenuItem((PSAppMenuItemBase)psAppMenuItemCurrent);
                            PSAppMenuItem psAppMenuItemTop = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItemCurrent, psAppFuncMap, psAppModuleMap);
                            psAppMenuItemTop.resetPSAppMenuItemId();
                            psAppMenuItemTop.setPSSysAppId(psAppMenuNew.getPSSysAppId());
                            psAppMenuItemService.create((IEntity)psAppMenuItemTop);
                            if (menuitmeList.size() <= 0) continue;
                            this.appMenuItmeOperation(iService, psAppMenuNew, psAppMenuItemTop, menuitmeList, psAppFuncMap, psAppModuleMap);
                        }
                    }
                }
            } else {
                throw new Exception("\u5b9e\u4f53\u4e0d\u5b58\u5728\uff0c\u65e0\u6548\u7684\u62f7\u8d1d\u6e90\u4e3b\u952e\uff1a" + objParam);
            }
            return PluginActionResult.Replace;
        }
        return super.doCopyDetails(iService, nActionPos, iEntity, objParam);
    }

    private void appMenuItmeOperation(IService iService, PSAppMenu psAppMenuNew, PSAppMenuItem fatherAppMenuItem, ArrayList<PSAppMenuItem> menuitmeList, Map<String, PSAppFunc> psAppFuncMap, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        PSAppMenuItemService psAppMenuItemService = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)iService.getSessionFactory());
        for (PSAppMenuItem psAppMenuItem : menuitmeList) {
            ArrayList menuitmeListItem = psAppMenuItemService.selectByPPSAppMenuItem((PSAppMenuItemBase)psAppMenuItem);
            PSAppMenuItem psAppMenuItemNow = this.appMenuItemAssociationCreateOperation(iService, psAppMenuNew, psAppMenuItem, psAppFuncMap, psAppModuleMap);
            psAppMenuItemNow.setPPSAppMenuItemId(fatherAppMenuItem.getPSAppMenuItemId());
            psAppMenuItemNow.setPPSAppMenuItemName(fatherAppMenuItem.getPSAppMenuItemName());
            psAppMenuItemNow.resetPSAppMenuItemId();
            psAppMenuItemNow.setPSSysAppId(psAppMenuNew.getPSSysAppId());
            psAppMenuItemService.create((IEntity)psAppMenuItemNow);
            if (menuitmeListItem.size() <= 0) continue;
            this.appMenuItmeOperation(iService, psAppMenuNew, psAppMenuItemNow, menuitmeListItem, psAppFuncMap, psAppModuleMap);
        }
    }

    private PSAppMenuItem appMenuItemAssociationCreateOperation(IService iService, PSAppMenu psAppMenuNew, PSAppMenuItem psAppMenuItemCurrent, Map<String, PSAppFunc> psAppFuncMap, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        block13: {
            block14: {
                PSAppFunc psAppFunc;
                block15: {
                    String psAppFuncOldId;
                    PSAppFuncService psAppFuncService;
                    block16: {
                        PSAppView psAppViewItem;
                        String appViewType;
                        String strValue;
                        PSAppView psAppView;
                        block17: {
                            psAppFuncService = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)iService.getSessionFactory());
                            PSAppViewService psAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)iService.getSessionFactory());
                            if (StringHelper.isNullOrEmpty((String)psAppMenuItemCurrent.getPSAppFuncId())) break block13;
                            psAppFunc = new PSAppFunc();
                            psAppFunc.setPSAppFuncId(psAppMenuItemCurrent.getPSAppFuncId());
                            if (!psAppFuncService.select((IEntity)psAppFunc, true)) break block14;
                            if (psAppFuncMap.containsKey(psAppFunc.getPSAppFuncId())) break block15;
                            psAppFuncOldId = psAppFunc.getPSAppFuncId();
                            psAppView = new PSAppView();
                            psAppView.setPSAppViewId(psAppFunc.getPSAppViewId());
                            if (!psAppViewService.select((IEntity)psAppView, true)) break block16;
                            strValue = this.reckonAppViewId(psAppMenuNew.getPSSysAppId(), psAppView.getPSDEViewBaseId());
                            appViewType = psAppView.getPSAppViewType();
                            psAppViewItem = new PSAppView();
                            psAppViewItem.setPSAppViewId(strValue);
                            if (!psAppViewService.get((IEntity)psAppViewItem, true)) break block17;
                            psAppFunc.setPSAppViewId(psAppViewItem.getPSAppViewId());
                            psAppFunc.setPSAppViewName(psAppViewItem.getPSAppViewName());
                            break block16;
                        }
                        psAppViewItem.setPSAppViewId(psAppView.getPSAppViewId());
                        switch (appViewType) {
                            case "APPDEVIEW": {
                                PSAppDEView psAppDEView = this.appDEViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
                                psAppFunc.setPSAppViewId(psAppDEView.getPSAppViewId());
                                psAppFunc.setPSAppViewName(psAppDEView.getPSAppViewName());
                                break;
                            }
                            case "APPPORTALVIEW": {
                                PSAppPortalView psAppPortalView = this.appPortalViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
                                psAppFunc.setPSAppViewId(psAppPortalView.getPSAppViewId());
                                psAppFunc.setPSAppViewName(psAppPortalView.getPSAppViewName());
                                break;
                            }
                            case "APPINDEXVIEW": {
                                PSAppIndexView psAppIndexView = this.appIndexViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
                                psAppFunc.setPSAppViewId(psAppIndexView.getPSAppViewId());
                                psAppFunc.setPSAppViewName(psAppIndexView.getPSAppViewName());
                                break;
                            }
                            default: {
                                throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppView.getPSAppViewId() + "\uff0c\u89c6\u56fe\u7c7b\u578b\u8bc6\u522b\u51fa\u9519\uff0c\u975e(APPDEVIEW,APPPORTALVIEW,APPINDEXVIEW)\u5df2\u786e\u8ba4\u4e09\u4e2a\u7c7b\u578b\u4e2d\u4efb\u4f55\u4e00\u4e2a,\u65e0\u6cd5\u5904\u7406\u62f7\u8d1d\u3002");
                            }
                        }
                    }
                    psAppFunc.resetPSAppFuncId();
                    psAppFunc.setPSSysAppId(psAppMenuNew.getPSSysAppId());
                    psAppFunc.setPSSysAppName(psAppMenuNew.getPSSysAppName());
                    psAppFuncService.create((IEntity)psAppFunc);
                    psAppFuncMap.put(psAppFuncOldId, psAppFunc);
                    psAppMenuItemCurrent.setPSAppFuncId(psAppFunc.getPSAppFuncId());
                    psAppMenuItemCurrent.setPSAppFuncName(psAppFunc.getPSAppFuncName());
                    break block13;
                }
                PSAppFunc psAppFuncCurrent = psAppFuncMap.get(psAppFunc.getPSAppFuncId());
                psAppMenuItemCurrent.setPSAppFuncId(psAppFuncCurrent.getPSAppFuncId());
                psAppMenuItemCurrent.setPSAppFuncName(psAppFuncCurrent.getPSAppFuncName());
                break block13;
            }
            throw new Exception("\u5b9e\u4f53PSAppMenuItem\u4e3b\u952e\uff1a" + psAppMenuItemCurrent.getPSAppMenuItemId() + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppFunc\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppMenuItemCurrent.getPSAppFuncId() + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
        }
        psAppMenuItemCurrent.setPSAppMenuId(psAppMenuNew.getPSAppMenuId());
        psAppMenuItemCurrent.setPSAppMenuName(psAppMenuNew.getPSAppMenuName());
        return psAppMenuItemCurrent;
    }

    private PSAppDEView appDEViewOperation(String id, PSAppMenu psAppMenuNew, PSAppView psAppViewItem, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        PSAppDEViewService psAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
        PSAppDEView psAppDEView = new PSAppDEView();
        psAppDEView.setPSAppDEViewId(psAppViewItem.getPSAppViewId());
        if (!psAppDEViewService.get((IEntity)psAppDEView, true)) {
            throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppDEView\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
        }
        PSAppModule psAppModule = new PSAppModule();
        psAppModule = !psAppModuleMap.containsKey(psAppDEView.getPSAppModuleId()) ? this.appModuleOperation(psAppMenuNew, psAppDEView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap) : psAppModuleMap.get(psAppDEView.getPSAppModuleId());
        psAppDEView.setPSAppModuleId(psAppModule.getPSAppModuleId());
        psAppDEView.setPSAppModuleName(psAppModule.getPSAppModuleName());
        psAppDEView.setPSAppDEViewId(id);
        psAppDEView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
        psAppDEView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
        psAppDEViewService.create((IEntity)psAppDEView);
        return psAppDEView;
    }

    private PSAppPortalView appPortalViewOperation(String id, PSAppMenu psAppMenuNew, PSAppView psAppViewItem, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        PSAppPortalViewService psAppPortalViewService = (PSAppPortalViewService)ServiceGlobal.getService(PSAppPortalViewService.class, (SessionFactory)this.getSessionFactory());
        PSAppPortalView psAppPortalView = new PSAppPortalView();
        psAppPortalView.setPSAppPortalViewId(psAppViewItem.getPSAppViewId());
        if (!psAppPortalViewService.get((IEntity)psAppPortalView, true)) {
            throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppPortalView\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
        }
        PSAppModule psAppModule = new PSAppModule();
        psAppModule = !psAppModuleMap.containsKey(psAppPortalView.getPSAppModuleId()) ? this.appModuleOperation(psAppMenuNew, psAppPortalView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap) : psAppModuleMap.get(psAppPortalView.getPSAppModuleId());
        psAppPortalView.setPSAppModuleId(psAppModule.getPSAppModuleId());
        psAppPortalView.setPSAppModuleName(psAppModule.getPSAppModuleName());
        psAppPortalView.setPSAppPortalViewId(id);
        psAppPortalView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
        psAppPortalView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
        psAppPortalViewService.create((IEntity)psAppPortalView);
        return psAppPortalView;
    }

    private PSAppIndexView appIndexViewOperation(String id, PSAppMenu psAppMenuNew, PSAppView psAppViewItem, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        PSAppModule psAppModule;
        PSAppIndexView psAppIndexView;
        PSAppIndexViewService psAppIndexViewService;
        block11: {
            block10: {
                block12: {
                    String strValue;
                    PSAppView psAppView;
                    block13: {
                        psAppIndexViewService = (PSAppIndexViewService)ServiceGlobal.getService(PSAppIndexViewService.class, (SessionFactory)this.getSessionFactory());
                        PSAppViewService psAppViewService = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
                        psAppIndexView = new PSAppIndexView();
                        psAppIndexView.setPSAppIndexViewId(psAppViewItem.getPSAppViewId());
                        if (!psAppIndexViewService.get((IEntity)psAppIndexView, true)) break block10;
                        psAppModule = new PSAppModule();
                        if (StringHelper.isNullOrEmpty((String)psAppIndexView.getDefPSAppViewId())) break block11;
                        psAppView = new PSAppView();
                        psAppView.setPSAppViewId(psAppIndexView.getDefPSAppViewId());
                        if (!psAppViewService.get((IEntity)psAppView, true)) break block12;
                        strValue = this.reckonAppViewId(psAppMenuNew.getPSSysAppId(), psAppView.getPSDEViewBaseId());
                        PSAppView psAppView2 = new PSAppView();
                        psAppView2.setPSAppViewId(strValue);
                        if (!psAppViewService.get((IEntity)psAppView2, true)) break block13;
                        psAppIndexView.setPSAppViewId(psAppView2.getPSAppViewId());
                        psAppIndexView.setPSAppViewName(psAppView2.getPSAppViewName());
                        break block11;
                    }
                    switch (psAppView.getPSAppViewType()) {
                        case "APPDEVIEW": {
                            PSAppDEView psAppDEView = this.appDEViewOperation(strValue, psAppMenuNew, psAppViewItem, psAppModuleMap);
                            psAppIndexView.setDefPSAppViewId(psAppDEView.getPSAppViewId());
                            psAppIndexView.setDefPSAppViewName(psAppDEView.getPSAppViewName());
                            break block11;
                        }
                        case "APPPORTALVIEW": {
                            PSAppPortalView psAppPortalView = this.appPortalViewOperation(strValue, psAppMenuNew, psAppView, psAppModuleMap);
                            psAppIndexView.setDefPSAppViewId(psAppPortalView.getPSAppViewId());
                            psAppIndexView.setDefPSAppViewName(psAppPortalView.getPSAppViewName());
                            break block11;
                        }
                        default: {
                            throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppView.getPSAppViewId() + "\uff0c\u89c6\u56fe\u7c7b\u578b\u8bc6\u522b\u51fa\u9519\uff0c\u975e(APPDEVIEW,APPPORTALVIEW)\u5df2\u786e\u8ba4\u4e09\u4e2a\u7c7b\u578b\u4e2d\u4efb\u4f55\u4e00\u4e2a,\u65e0\u6cd5\u5904\u7406\u62f7\u8d1d\u3002");
                        }
                    }
                }
                throw new Exception("\u5b9e\u4f53PSAppIndexView\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppView\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppIndexView.getDefPSAppViewId() + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
            }
            throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppIndexView\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppViewItem.getPSAppViewId() + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
        }
        psAppModule = !psAppModuleMap.containsKey(psAppIndexView.getPSAppModuleId()) ? this.appModuleOperation(psAppMenuNew, psAppIndexView.getPSAppModuleId(), psAppViewItem.getPSAppViewId(), psAppModuleMap) : psAppModuleMap.get(psAppIndexView.getPSAppModuleId());
        psAppIndexView.setPSAppModuleId(psAppModule.getPSAppModuleId());
        psAppIndexView.setPSAppModuleName(psAppModule.getPSAppModuleName());
        psAppIndexView.setPSAppIndexViewId(id);
        psAppIndexView.setPSSysAppId(psAppMenuNew.getPSSysAppId());
        psAppIndexView.setPSSysAppName(psAppMenuNew.getPSSysAppName());
        psAppIndexView.setPSAppMenuId(psAppMenuNew.getPSAppMenuId());
        psAppIndexView.setPSAppMenuName(psAppMenuNew.getPSAppMenuName());
        psAppIndexViewService.create((IEntity)psAppIndexView);
        return psAppIndexView;
    }

    private PSAppModule appModuleOperation(PSAppMenu psAppMenuNew, String psAppModuleOldId, String psAppviewId, Map<String, PSAppModule> psAppModuleMap) throws Exception {
        PSAppModuleService psAppModuleService = (PSAppModuleService)ServiceGlobal.getService(PSAppModuleService.class, (SessionFactory)this.getSessionFactory());
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSAppModuleId(psAppModuleOldId);
        if (!psAppModuleService.get((IEntity)psAppModule, true)) {
            throw new Exception("\u5b9e\u4f53PSAppView\u4e3b\u952e\uff1a" + psAppviewId + "\uff0c\u5173\u8054\u5b9e\u4f53PSAppModule\u5b9e\u4f53\u4e3b\u952e\uff1a" + psAppModuleOldId + "\u67e5\u8be2\u4fe1\u606f\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u62f7\u8d1d\u3002");
        }
        psAppModule.resetPSAppModuleId();
        psAppModule.setPSSysAppId(psAppMenuNew.getPSSysAppId());
        psAppModule.setPSSysAppName(psAppMenuNew.getPSSysAppName());
        psAppModuleService.create((IEntity)psAppModule);
        psAppModuleMap.put(psAppModuleOldId, psAppModule);
        return psAppModule;
    }

    private String reckonAppViewId(String psSysAppId, String psDEViewBaseId) {
        StringBuilderEx sb = new StringBuilderEx();
        String objPSSysAppId = psSysAppId;
        if (objPSSysAppId == null) {
            objPSSysAppId = "__EMTPY__";
        }
        sb.append("%1$s", (Object)objPSSysAppId);
        sb.append("||");
        String objPSDEViewBaseId = psDEViewBaseId;
        if (objPSDEViewBaseId == null) {
            objPSDEViewBaseId = "__EMTPY__";
        }
        sb.append("%1$s", (Object)objPSDEViewBaseId);
        return KeyValueHelper.genUniqueId((String)sb.toString());
    }
}

