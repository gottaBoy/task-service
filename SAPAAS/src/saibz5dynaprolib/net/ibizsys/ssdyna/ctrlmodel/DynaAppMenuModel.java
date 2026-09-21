/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.ssdyna.ctrlmodel;

import java.util.ArrayList;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.AppMenuModelBase;
import net.ibizsys.ssdyna.view.IDynaViewModel;

public class DynaAppMenuModel
extends AppMenuModelBase {
    private IPSControl iPSControl = null;

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    @Override
    public IPSAppMenu getPSAppMenu() {
        return (IPSAppMenu)this.getPSControl();
    }

    protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
        ArrayList appMenuItems = this.getPSAppMenu().getRootItem().getAllItems();
        for (IAppMenuItem iAppMenuItem : appMenuItems) {
            IPSAppMenuItem iPSAppMenuItem = (IPSAppMenuItem)iAppMenuItem;
            AppMenuItem appMenuItemModel = appMenuRootItem.addItem(iPSAppMenuItem.getId(), iPSAppMenuItem.getPId());
            if (!StringHelper.isNullOrEmpty((String)iPSAppMenuItem.getAppFuncId())) {
                appMenuItemModel.setAppFuncId(iPSAppMenuItem.getAppFuncId());
            }
            if (!StringHelper.isNullOrEmpty((String)iPSAppMenuItem.getItemType())) {
                appMenuItemModel.setItemType(iPSAppMenuItem.getItemType());
            }
            appMenuItemModel.setText(iPSAppMenuItem.getText());
            if (iPSAppMenuItem.isExpanded()) {
                appMenuItemModel.setExpanded(true);
            }
            if (iPSAppMenuItem.isSeperator()) {
                appMenuItemModel.setSeperator(true);
            }
            if (iPSAppMenuItem.isHideSideBar()) {
                appMenuItemModel.setHideSideBar(true);
            }
            if (iPSAppMenuItem.isOpenDefault()) {
                appMenuItemModel.setOpenDefault(true);
            }
            if (iPSAppMenuItem.getAccUserMode() > 0) {
                appMenuItemModel.setAccUserMode(iPSAppMenuItem.getAccUserMode());
            }
            if (StringHelper.isNullOrEmpty((String)iPSAppMenuItem.getAccessKey())) continue;
            appMenuItemModel.setAccessKey(iPSAppMenuItem.getAccessKey());
            appMenuItemModel.setAccUserMode(4);
        }
    }
}

