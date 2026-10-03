/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.menu.AppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.ctrlmodel.AppMenuModelBase
 *  net.ibizsys.paas.ctrlmodel.IAppMenuModel
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.JIT.App;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.JIT.App.IPSJITAppModel;
import java.util.ArrayList;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.ctrlmodel.AppMenuModelBase;
import net.ibizsys.paas.ctrlmodel.IAppMenuModel;
import net.ibizsys.paas.util.StringHelper;

public class PSJITAppMenuModel
extends AppMenuModelBase {
    private IPSAppMenuModel iPSAppMenuModel = null;
    private IPSJITAppModel iPSJITAppModel = null;

    public void init(IPSJITAppModel iPSJITAppModel, IPSAppMenuModel iPSAppMenuModel) throws Exception {
        this.iPSJITAppModel = iPSJITAppModel;
        this.iPSAppMenuModel = iPSAppMenuModel;
        this.setName(this.iPSAppMenuModel.getCodeName());
        iPSJITAppModel.registerAppMenuModel2(iPSAppMenuModel.getId(), (IAppMenuModel)this);
        this.onInit();
    }

    protected void onInit() throws Exception {
        super.onInit();
    }

    public IPSAppMenuModel getPSAppMenuModel() {
        return this.iPSAppMenuModel;
    }

    protected void onPrepareRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
        ArrayList<IAppMenuItem> appMenuItems = this.getPSAppMenuModel().getRootItem().getAllItems();
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
