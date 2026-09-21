/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.menu.IPSAppMenuModel
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.model.control.menu.IPSMenuItem
 *  net.ibizsys.model.res.IPSSysCss
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.menu;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.control.menu.IPSAppMenuItemRuntime;
import net.ibizsys.model.control.menu.IPSMenuItem;
import net.ibizsys.model.control.menu.PSMenuItemImpl;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.StringHelper;

public class PSAppMenuSeperatorImpl
extends PSMenuItemImpl
implements IPSAppMenuItem,
IPSAppMenuItemRuntime {
    private IPSAppMenu iPSAppMenu = null;
    private IPSAppMenuItem parentPSAppMenuItem = null;
    private PSAppMenuItem psAppMenuItem = null;
    private IPSAppMenuModel iPSAppMenuModel = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSAppMenuModel iPSAppMenuModel, IPSAppMenuItem parentPSAppMenuItem, PSAppMenuItem psAppMenuItem) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSAppMenuModel(iPSAppMenuModel);
        this.setParentPSAppMenuItem(parentPSAppMenuItem);
        this.setPSAppMenuItemData(psAppMenuItem);
        this.setId(this.psAppMenuItem.getPSAPPMENUITEMID());
        this.setName(this.psAppMenuItem.getPSAPPMENUITEMNAME());
        String strCaption = psAppMenuItem.getCAPTION();
        if (StringHelper.isNullOrEmpty((String)strCaption)) {
            strCaption = this.psAppMenuItem.getPSAPPFUNCNAME();
        }
        this.setCaption(strCaption);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public IPSAppMenuModel getPSAppMenuModel() {
        return this.iPSAppMenuModel;
    }

    protected void setPSAppMenuModel(IPSAppMenuModel iPSAppMenuModel) {
        this.iPSAppMenuModel = iPSAppMenuModel;
        if (this.iPSAppMenuModel == null) {
            this.iPSAppMenu = null;
        } else if (this.iPSAppMenuModel instanceof IPSAppMenu) {
            this.iPSAppMenu = (IPSAppMenu)this.iPSAppMenuModel;
        }
    }

    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    public IPSAppMenuItem getParentPSAppMenuItem() {
        return this.parentPSAppMenuItem;
    }

    protected void setParentPSAppMenuItem(IPSAppMenuItem parentPSAppMenuItem) {
        this.parentPSAppMenuItem = parentPSAppMenuItem;
        this.setParentPSMenuItem((IPSMenuItem)this.parentPSAppMenuItem);
    }

    public PSAppMenuItem getPSAppMenuItemData() {
        return this.psAppMenuItem;
    }

    protected void setPSAppMenuItemData(PSAppMenuItem psAppMenuItem) {
        this.psAppMenuItem = psAppMenuItem;
    }

    public IPSAppFunc getPSAppFunc() {
        return null;
    }

    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="AppMenuItemType")
    public String getItemType() {
        return this.getPSAppMenuItemData().getAMITEMTYPE();
    }

    public Iterator<IPSAppMenuItem> getPSAppMenuItems() {
        return null;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    public ArrayList<IAppMenuItem> getItems() {
        return null;
    }

    public String getAppFuncId() {
        return null;
    }

    @Override
    public void fillRelatedPSAppFuncs(ArrayList<IPSAppFunc> psAppFuncList) {
    }

    public boolean isSeperator() {
        return true;
    }

    public boolean isOpenDefault() {
        return false;
    }

    public boolean isDisableClose() {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSAppMenuModel()).getPSSysModelInstId();
    }

    public boolean isHideSideBar() {
        return false;
    }

    @Override
    public String getTooltip() {
        return null;
    }

    public IPSSysImage getPSSysImage() {
        return null;
    }

    public IPSSysCss getPSSysCss() {
        return null;
    }

    public int getAccUserMode() {
        return AccessUserModes.UNKNOWN;
    }

    public boolean isValid() {
        return true;
    }

    public int getAppMenuItemState() {
        return 0;
    }

    public boolean isHidden() {
        return false;
    }

    @Override
    public String getModelType() {
        return "PSAPPMENUITEM";
    }
}

