/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.IControlCustomizable;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenu;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.AppMenuModelGlobal;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.SystemUtilBase;
import net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppCustomizeUtilBase
extends SystemUtilBase
implements IAppCustomizeUtil {
    private static final Log log = LogFactory.getLog(AppCustomizeUtilBase.class);
    public static final String DE_APPMENU = "APPMENUDENAME";
    public static final String DE_APPMENUITEM = "APPMENUITEMDENAME";
    public static final String DEF_LOCKFLAG = "LOCKFLAG";
    public static final String DEF_VALIDFLAG = "VALIDFLAG";
    public static final String DEF_ORDERVALUE = "ORDERVALUE";
    public static final String DEF_APPFUNCID = "APPFUNCID";
    public static final String DEF_ITEMTYPE = "ITEMTYPE";
    public static final String DEF_EXPANDEDFLAG = "EXPANDEDFLAG";
    public static final String DEF_SEPERATORFLAG = "SEPERATORFLAG";
    public static final String DEF_HIDESIDEBARFLAG = "HIDESIDEBARFLAG";
    public static final String DEF_OPENDEFAULTFLAG = "OPENDEFAULTFLAG";
    public static final String DEF_ICONCLS = "ICONCLS";
    public static final String DEF_ICONPATH = "ICONPATH";
    public static final String DEF_TEXTCLS = "TEXTCLS";
    public static final String DEF_ACCUSERMODE = "ACCUSERMODE";
    public static final String DEF_ACCESSKEY = "ACCESSKEY";
    public static final String DEF_TEXT = "TEXT";
    public static final String DEF_COUNTERID = "COUNTERID";
    private HashMap<String, AppMenuRootItem> appMenuRootItemMap = new HashMap();

    public AppCustomizeUtilBase() {
        this.setUtilType("APPCUSTOMIZE");
    }

    @Override
    public Iterator<IAppMenuItem> getAppMenuItems(IAppMenu iAppMenu) throws Exception {
        AppMenuRootItem appMenuRootItem = this.getAppMenuRootItem(iAppMenu);
        if (appMenuRootItem != null) {
            return appMenuRootItem.getItems().iterator();
        }
        return iAppMenu.getAppMenuItems();
    }

    @Override
    public void installAll() throws Exception {
        this.installAllAppMenus();
    }

    @Override
    public void installAllAppMenus() throws Exception {
        Iterator<IAppMenuModel> appMenuModels = AppMenuModelGlobal.getAllAppMenuModels();
        if (appMenuModels != null) {
            HashMap<String, String> appMenuModelMap = new HashMap<String, String>();
            while (appMenuModels.hasNext()) {
                IAppMenuModel iAppMenuModel = appMenuModels.next();
                if (!(iAppMenuModel instanceof IControlCustomizable) || !((IControlCustomizable)((Object)iAppMenuModel)).isEnableCustomize()) continue;
                if (!appMenuModelMap.containsKey(iAppMenuModel.getId())) {
                    appMenuModelMap.put(iAppMenuModel.getId(), "");
                }
                this.installAppMenu(iAppMenuModel);
            }
        }
    }

    @Override
    public void installAppMenu(IAppMenu iAppMenu) throws Exception {
        if (iAppMenu instanceof IControlCustomizable) {
            if (!((IControlCustomizable)((Object)iAppMenu)).isEnableCustomize()) {
                throw new Exception(StringHelper.format("\u5e94\u7528\u83dc\u5355[%1$s]\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49", iAppMenu.getName()));
            }
        } else {
            throw new Exception(StringHelper.format("\u5e94\u7528\u83dc\u5355[%1$s]\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49", iAppMenu.getName()));
        }
        if (StringHelper.isNullOrEmpty(this.getAppMenuDEName()) || StringHelper.isNullOrEmpty(this.getAppMenuItemDEName())) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5e94\u7528\u83dc\u5355\u5b58\u50a8\u5b9e\u4f53");
        }
        IService appMenuService = DEModelGlobal.getDEModel(this.getAppMenuDEName()).getService();
        IService appMenuItemService = DEModelGlobal.getDEModel(this.getAppMenuItemDEName()).getService();
        Object appMenu = appMenuService.getDEModel().createEntity();
        appMenu.set(appMenuService.getDEModel().getKeyDEField().getName(), iAppMenu.getId());
        boolean bCreate = true;
        if (appMenuService.get(appMenu, true)) {
            if (DataObject.getIntegerValue(appMenu.get(DEF_LOCKFLAG), 0) == 1) {
                return;
            }
            bCreate = false;
        }
        appMenu.reset();
        appMenu.set(appMenuService.getDEModel().getKeyDEField().getName(), iAppMenu.getId());
        if (bCreate && appMenuService.getDEModel().getMajorDEField() != null) {
            appMenu.set(appMenuService.getDEModel().getMajorDEField().getName(), iAppMenu.getName());
        }
        try {
            if (bCreate) {
                appMenuService.create(appMenu);
            } else {
                appMenuService.update(appMenu);
            }
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format("\u4fdd\u5b58\u5e94\u7528\u83dc\u5355[%1$s]\u914d\u7f6e\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", iAppMenu.getName(), ex.getMessage()), ex);
        }
        Iterator<IAppMenuItem> appMenuItems = iAppMenu.getAppMenuItems();
        if (appMenuItems != null) {
            int nOrderValue = 100;
            while (appMenuItems.hasNext()) {
                IAppMenuItem iAppMenuItem = appMenuItems.next();
                this.saveAppMenuItem(iAppMenuItem, nOrderValue, iAppMenu, (IEntity)appMenu, appMenuItemService, appMenuService);
                ++nOrderValue;
            }
        }
    }

    protected IEntity saveAppMenuItem(IAppMenuItem iAppMenuItem, int nOrderValue, IAppMenu iAppMenu, IEntity appMenu, IService appMenuItemService, IService appMenuService) throws Exception {
        Object appMenuItem = appMenuItemService.getDEModel().createEntity();
        appMenuItem.set(appMenuItemService.getDEModel().getKeyDEField().getName(), iAppMenuItem.getId());
        boolean bCreate = true;
        if (appMenuItemService.get(appMenuItem, true)) {
            if (DataObject.getIntegerValue(appMenu.get(DEF_LOCKFLAG), 0) == 1) {
                return appMenuItem;
            }
            bCreate = false;
        }
        appMenuItem.reset();
        appMenuItem.set(appMenuItemService.getDEModel().getKeyDEField().getName(), iAppMenuItem.getId());
        appMenuItem.set(appMenuItemService.getDEModel().getMajorDEField().getName(), iAppMenuItem.getText());
        appMenuItem.set("P" + appMenuItemService.getDEModel().getKeyDEField().getName(), iAppMenuItem.getPId());
        appMenuItem.set(appMenuService.getDEModel().getKeyDEField().getName(), appMenu.get(appMenuService.getDEModel().getKeyDEField().getName()));
        appMenuItem.set(DEF_TEXT, iAppMenuItem.getText());
        appMenuItem.set(DEF_ORDERVALUE, nOrderValue);
        appMenuItem.set(DEF_APPFUNCID, iAppMenuItem.getAppFuncId());
        appMenuItem.set(DEF_ITEMTYPE, iAppMenuItem.getItemType());
        appMenuItem.set(DEF_EXPANDEDFLAG, iAppMenuItem.isExpanded() ? 1 : 0);
        appMenuItem.set(DEF_SEPERATORFLAG, iAppMenuItem.isSeperator() ? 1 : 0);
        appMenuItem.set(DEF_HIDESIDEBARFLAG, iAppMenuItem.isHideSideBar() ? 1 : 0);
        appMenuItem.set(DEF_OPENDEFAULTFLAG, iAppMenuItem.isOpenDefault() ? 1 : 0);
        appMenuItem.set(DEF_ICONCLS, iAppMenuItem.getIconCls());
        appMenuItem.set(DEF_ICONPATH, iAppMenuItem.getIconPath());
        appMenuItem.set(DEF_TEXTCLS, iAppMenuItem.getTextCls());
        appMenuItem.set(DEF_ACCUSERMODE, iAppMenuItem.getAccUserMode());
        appMenuItem.set(DEF_ACCESSKEY, iAppMenuItem.getAccessKey());
        appMenuItem.set(DEF_COUNTERID, iAppMenuItem.getCounterId());
        try {
            if (bCreate) {
                appMenuItemService.create(appMenuItem);
            } else {
                appMenuItemService.update(appMenuItem);
            }
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format("\u4fdd\u5b58\u5e94\u7528\u83dc\u5355\u9879[%1$s][%2$s]\u914d\u7f6e\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%3$s", iAppMenu.getName(), iAppMenuItem.getText(), ex.getMessage()), ex);
        }
        ArrayList<IAppMenuItem> appMenuItemList = iAppMenuItem.getItems();
        if (appMenuItemList != null) {
            int nOrderValue2 = 100;
            for (IAppMenuItem childAppMenuItem : appMenuItemList) {
                this.saveAppMenuItem(childAppMenuItem, nOrderValue2, iAppMenu, appMenu, appMenuItemService, appMenuService);
                ++nOrderValue2;
            }
        }
        return appMenuItem;
    }

    protected String getAppMenuDEName() {
        return this.getUtilParam(DE_APPMENU, "");
    }

    protected String getAppMenuItemDEName() {
        return this.getUtilParam(DE_APPMENUITEM, "");
    }

    @Override
    public void resetCache() throws Exception {
        this.appMenuRootItemMap.clear();
    }

    protected AppMenuRootItem getAppMenuRootItem(IAppMenu iAppMenu) throws Exception {
        AppMenuRootItem appMenuRootItem = this.appMenuRootItemMap.get(iAppMenu.getId());
        if (appMenuRootItem != null) {
            return appMenuRootItem;
        }
        IService appMenuService = DEModelGlobal.getDEModel(this.getAppMenuDEName()).getService();
        IService appMenuItemService = DEModelGlobal.getDEModel(this.getAppMenuItemDEName()).getService();
        SelectCond selectCond = new SelectCond();
        selectCond.set(appMenuService.getDEModel().getKeyDEField().getName(), iAppMenu.getId());
        selectCond.setOrderInfo("ORDER BY ORDERVALUE");
        ArrayList list = appMenuItemService.select(selectCond);
        ArrayList<IEntity> list2 = new ArrayList<IEntity>();
        String DEF_IDNAME = appMenuItemService.getDEModel().getKeyDEField().getName();
        String DEF_PIDNAME = "P" + DEF_IDNAME;
        HashMap<String, Boolean> appMenuItemMap = new HashMap<String, Boolean>();
        appMenuRootItem = new AppMenuRootItem();
        while (list.size() > 0) {
            list2.clear();
            for (IEntity iEntity : list) {
                String strId = DataObject.getStringValue(iEntity.get(DEF_IDNAME), "");
                String strPId = DataObject.getStringValue(iEntity.get(DEF_PIDNAME), "");
                if (!StringHelper.isNullOrEmpty(strPId)) {
                    if (!appMenuItemMap.containsKey(strPId)) {
                        list2.add(iEntity);
                        continue;
                    }
                    if (!((Boolean)appMenuItemMap.get(strPId)).booleanValue()) {
                        appMenuItemMap.put(strId, false);
                        continue;
                    }
                }
                boolean bValidFlag = DataObject.getBoolValue(iEntity.get(DEF_VALIDFLAG), true);
                appMenuItemMap.put(strId, bValidFlag);
                if (!bValidFlag) continue;
                AppMenuItem appMenuItem = appMenuRootItem.addItem(strId, strPId);
                appMenuItem.setAppFuncId(DataObject.getStringValue(iEntity.get(DEF_APPFUNCID)));
                appMenuItem.setItemType(DataObject.getStringValue(iEntity.get(DEF_ITEMTYPE)));
                appMenuItem.setText(DataObject.getStringValue(iEntity.get(DEF_TEXT)));
                appMenuItem.setExpanded(DataObject.getBoolValue(iEntity, DEF_EXPANDEDFLAG, false));
                appMenuItem.setSeperator(DataObject.getBoolValue(iEntity, DEF_SEPERATORFLAG, false));
                appMenuItem.setHideSideBar(DataObject.getBoolValue(iEntity, DEF_HIDESIDEBARFLAG, false));
                appMenuItem.setOpenDefault(DataObject.getBoolValue(iEntity, DEF_OPENDEFAULTFLAG, false));
                appMenuItem.setIconCls(DataObject.getStringValue(iEntity, DEF_ICONCLS, ""));
                appMenuItem.setIconPath(DataObject.getStringValue(iEntity, DEF_ICONPATH, ""));
                appMenuItem.setTextCls(DataObject.getStringValue(iEntity, DEF_TEXTCLS, ""));
                appMenuItem.setAccUserMode(DataObject.getIntegerValue(iEntity, DEF_ACCUSERMODE, AccessUserModes.UNKNOWN));
                appMenuItem.setAccessKey(DataObject.getStringValue(iEntity, DEF_ACCESSKEY, ""));
                appMenuItem.setCounterId(DataObject.getStringValue(iEntity, DEF_COUNTERID, ""));
            }
            if (list2.size() == 0) break;
            if (list2.size() == list.size()) {
                log.error((Object)StringHelper.format("\u5e94\u7528\u83dc\u5355[%1$s][%2$s]\u914d\u7f6e\u51fa\u73b0\u65e0\u6548\u83dc\u5355\u9879", iAppMenu.getId(), iAppMenu.getName()));
                break;
            }
            list.clear();
            list.addAll(list2);
        }
        return appMenuRootItem;
    }
}

