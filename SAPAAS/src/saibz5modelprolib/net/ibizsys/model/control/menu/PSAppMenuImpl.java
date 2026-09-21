/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.func.IPSAppFunc
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.control.menu.IPSAppMenuItem
 *  net.ibizsys.model.control.menu.IPSAppMenuParam
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ISystem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.menu.IPSAppMenuModelRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSAjaxControlImpl;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.control.menu.IPSAppMenuItemRuntime;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.menu.IPSAppMenuParam;
import net.ibizsys.model.entity.PSAppMenu;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuImpl
extends PSAjaxControlImpl
implements IPSAppMenu,
IPSAppMenuModelRuntime {
    private static final Log log = LogFactory.getLog(PSAppMenuImpl.class);
    protected PSAppMenu psAppMenu;
    protected ArrayList<IPSAppMenuItem> psAppMenuItemList = new ArrayList();
    protected AppMenuRootItem appMenuRootItem = new AppMenuRootItem();
    protected IPSAppMenuParam iPSAppMenuParam = null;
    protected IPSSysCounter iPSSysCounter = null;
    private IPSApplication iPSApplication = null;
    protected ArrayList<IPSAppMenuItem> allPSAppMenuItemList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.iPSAppMenuParam = (IPSAppMenuParam)iPSControlParam;
            this.setPSControlContainer(iPSControlContainer);
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSApplication(this.getPSAppView().getPSApplication());
            this.psAppMenu = new PSAppMenu();
            CallResult callResult = this.getPSModelQueryHelper().getPSAppMenu(this.iPSAppMenuParam.getPSAppMenuId(), this.psAppMenu);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psAppMenu.getPSAPPMENUID());
            this.setName(strName);
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenu.getPSSYSCOUNTERID())) {
                this.iPSSysCounter = this.getPSAppView().getPSSystem().getPSSysCounter(this.psAppMenu.getPSSYSCOUNTERID(), false);
            }
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication, PSAppMenu psAppMenu) throws Exception {
        this.iPSAppMenuParam = (IPSAppMenuParam)this.iPSControlParam;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setPSApplication(iPSApplication);
        this.psAppMenu = psAppMenu;
        this.setId(this.psAppMenu.getPSAPPMENUID());
        this.setName(this.psAppMenu.getPSAPPMENUNAME());
        if (!StringHelper.isNullOrEmpty((String)this.psAppMenu.getPSSYSCOUNTERID())) {
            this.iPSSysCounter = this.getPSApplication() != null ? this.getPSApplication().getPSSystem().getPSSysCounter(this.psAppMenu.getPSSYSCOUNTERID(), false) : this.getPSAppView().getPSSystem().getPSSysCounter(this.psAppMenu.getPSSYSCOUNTERID(), false);
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSControlContainer() != null) {
            if (this.getPSAppView() != null && this.getPSSysCounter() != null) {
                this.getPSAppViewRuntime().registerPSSysCounter(this.getPSSysCounter(), null);
            }
            super.onInit();
        }
        this.onPreparePSAppMenuItems();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psAppMenu.getCODENAME();
    }

    protected void onPreparePSAppMenuItems() throws Exception {
        this.psAppMenuItemList.clear();
        this.allPSAppMenuItemList.clear();
        Vector<PSAppMenuItem> psAppMenuItemList = new Vector<PSAppMenuItem>();
        CallResult callResult = this.getPSModelQueryHelper().getPSAppMenuItems(this.getId(), psAppMenuItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
            psAppMenuItemMap.put(psAppMenuItem.getPSAPPMENUITEMID(), psAppMenuItem);
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            PSAppMenuItem parentPSAppMenuItem;
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID()) || (parentPSAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemMap.get(psAppMenuItem.getPPSAPPMENUITEMID()))) == null) continue;
            parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem);
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || !StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
            IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorageContext().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
            IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
            ((IPSAppMenuItemRuntime)iPSAppMenuItem).init(this.getPSModelStorageContext(), this, null, psAppMenuItem);
            this.psAppMenuItemList.add(iPSAppMenuItem);
            this.appMenuRootItem.getItems().add(iPSAppMenuItem);
        }
        for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
            this.addToAllPSAppMenuItemList(iPSAppMenuItem);
        }
    }

    protected void addToAllPSAppMenuItemList(IPSAppMenuItem iPSAppMenuItem) throws Exception {
        this.allPSAppMenuItemList.add(iPSAppMenuItem);
        Iterator childPSAppMenuItems = iPSAppMenuItem.getPSAppMenuItems();
        if (childPSAppMenuItems != null) {
            while (childPSAppMenuItems.hasNext()) {
                this.addToAllPSAppMenuItemList((IPSAppMenuItem)childPSAppMenuItems.next());
            }
        }
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u7c7b\u578b")
    public String getControlType() {
        return "APPMENU";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.psAppMenuItemList != null) {
            for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
                ((IPSAppMenuItemRuntime)iPSAppMenuItem).fillRelatedPSAppViews(relatedAppViewList);
            }
        }
    }

    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408")
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception {
        return this.psAppMenuItemList.iterator();
    }

    public Iterator<IAppMenuItem> getAppMenuItems() {
        return this.appMenuRootItem.getItems().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSAppMenuParam;
    }

    public AppMenuRootItem getRootItem() {
        return this.appMenuRootItem;
    }

    @PSModelRTMeta(description="\u529f\u80fd\u96c6\u5408")
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        ArrayList<IPSAppFunc> psAppFuncList = new ArrayList<IPSAppFunc>();
        for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
            ((IPSAppMenuItemRuntime)iPSAppMenuItem).fillRelatedPSAppFuncs(psAppFuncList);
        }
        return psAppFuncList.iterator();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppViewRuntime().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPMENU";
    }

    public Iterator<IPSAppMenuItem> getAllPSAppMenuItems() throws Exception {
        return this.allPSAppMenuItemList.iterator();
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }
}

