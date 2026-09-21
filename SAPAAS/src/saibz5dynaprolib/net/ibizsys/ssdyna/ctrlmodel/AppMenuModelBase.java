/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuItem
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.ctrlmodel.AppMenuModelBase
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.ssdyna.ctrlmodel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.ctrlmodel.DynaCtrlModelBase;
import net.ibizsys.ssdyna.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppMenuModelBase
extends net.ibizsys.paas.ctrlmodel.AppMenuModelBase
implements IDynaCtrlModel {
    private static final Log log = LogFactory.getLog(AppMenuModelBase.class);
    private IDynaViewModel iDynaViewModel = null;
    private IPSAppMenu iPSAppMenu = null;

    public void init(IViewController iViewController) throws Exception {
        if (iViewController instanceof IDynaViewModel) {
            this.iDynaViewModel = (IDynaViewModel)iViewController;
            IPSControl iPSControl = null;
            if (this.iDynaViewModel.getPSAppView().hasPSControl(this.getName()) && !((iPSControl = this.iDynaViewModel.getPSAppView().getPSControl(this.getName())) instanceof IPSAppMenu)) {
                iPSControl = null;
            }
            Iterator psControls = this.iDynaViewModel.getPSAppView().getPSControls();
            while (psControls.hasNext()) {
                iPSControl = (IPSControl)psControls.next();
                if (!(iPSControl instanceof IPSAppMenu)) continue;
                this.iPSAppMenu = (IPSAppMenu)iPSControl;
                break;
            }
            if (this.iPSAppMenu == null) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u4ece\u89c6\u56fe[%1$s][%2$s]\u83b7\u53d6\u83dc\u5355\u5bf9\u8c61", (Object)iViewController.getId(), (Object)((IDynaViewModel)iViewController).getName()));
            }
        }
        super.init(iViewController);
    }

    @Override
    public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
        this.iDynaViewModel = iDynaViewModel;
        this.iPSAppMenu = (IPSAppMenu)iPSControl;
        super.init((IViewController)iDynaViewModel);
    }

    @Override
    public IPSControl getPSControl() {
        return this.iPSAppMenu;
    }

    protected void prepareCtrlModel() throws Exception {
        if (this.getPSControl() != null && this.getPSControl().isDynamicCtrl()) {
            this.onPrepareDynaRootItem(this.getRootItem());
            return;
        }
        super.prepareCtrlModel();
    }

    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    protected void onPrepareDynaRootItem(AppMenuRootItem appMenuRootItem) throws Exception {
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

    @Override
    public ObjectNode toJsonObject(ObjectNode objectNode) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        this.onFillJsonObject(objectNode);
        return objectNode;
    }

    protected void onFillJsonObject(ObjectNode objectNode) throws Exception {
        if (this.getPSControl() != null) {
            DynaCtrlModelBase.toJsonObject(objectNode, this.getPSControl());
        }
    }

    @Override
    public boolean isDynaCtrl() {
        if (this.getPSControl() != null) {
            return this.getPSControl().isDynamicCtrl();
        }
        return false;
    }
}

