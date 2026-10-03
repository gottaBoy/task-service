/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.AppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.AppMenuModelBase
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.CtrlModel;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import java.util.ArrayList;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.ctrlmodel.AppMenuModelBase;
import net.ibizsys.paas.util.StringHelper;

public class PSJITAppMenuModel
extends AppMenuModelBase
implements IPSJITCtrlModel {
    private IPSControl iPSControl = null;

    @Override
    public void init(IViewController iViewController, IPSControl iPSControl) throws Exception {
        this.iPSControl = iPSControl;
        this.init(iViewController);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSControl;
    }

    public IPSAppMenu getPSAppMenu() {
        return (IPSAppMenu)this.getPSControl();
    }

    protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
        ArrayList<IAppMenuItem> appMenuItems = this.getPSAppMenu().getRootItem().getAllItems();
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
            if (iPSAppMenuItem.getPSSysImage() != null) {
                appMenuItemModel.setIconCls(iPSAppMenuItem.getPSSysImage().getCssClass());
                appMenuItemModel.setIconPath(iPSAppMenuItem.getPSSysImage().getImagePath());
            }
            if (iPSAppMenuItem.getPSSysCss() != null) {
                appMenuItemModel.setTextCls(iPSAppMenuItem.getPSSysCss().getCssName());
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
