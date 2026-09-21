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
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.func.IPSAppFuncRuntime;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.control.menu.IPSAppMenuItemRuntime;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.menu.IPSMenuItem;
import net.ibizsys.model.control.menu.PSMenuItemImpl;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuAMRefImpl
extends PSMenuItemImpl
implements IPSAppMenuItem,
IPSAppMenuItemRuntime {
    private static final Log log = LogFactory.getLog(PSAppMenuAMRefImpl.class);
    private IPSAppMenu iPSAppMenu = null;
    private IPSAppMenuModel iPSAppMenuModel = null;
    private IPSAppMenuItem parentPSAppMenuItem = null;
    private PSAppMenuItem psAppMenuItem = null;
    protected IPSAppFunc iPSAppFunc = null;
    protected ArrayList<IPSAppMenuItem> psAppMenuItemList = null;
    protected ArrayList<IAppMenuItem> appMenuItemList = null;
    private boolean bDisableClose = false;
    private boolean bOpenDefault = false;
    private IPSSysImage iPSSysImage = null;
    private IPSSysCss iPSSysCss = null;
    private boolean bHideSideBar = false;
    private boolean bValidFlag = true;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSAppMenuModel iPSAppMenuModel, IPSAppMenuItem parentPSAppMenuItem, PSAppMenuItem psAppMenuItem) throws Exception {
        try {
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
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getPSAPPFUNCID())) {
                this.iPSAppFunc = this.getPSAppMenuModel().getPSApplication().getPSAppFunc(this.psAppMenuItem.getPSAPPFUNCID());
                if (!this.psAppMenuItem.isOPENDEFAULTNull()) {
                    this.bOpenDefault = this.psAppMenuItem.getOPENDEFAULT();
                }
                if (!this.psAppMenuItem.isDISABLECLOSENull()) {
                    this.bDisableClose = this.psAppMenuItem.getDISABLECLOSE();
                }
            }
            if (!this.psAppMenuItem.isHIDESIDEBARNull()) {
                this.bHideSideBar = this.psAppMenuItem.getHIDESIDEBAR();
            }
            if (!this.psAppMenuItem.isENABLEMODENull()) {
                this.bValidFlag = this.psAppMenuItem.getENABLEMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysCss(psAppMenuItem.getPSSYSCSSID());
            }
            if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysImage(psAppMenuItem.getPSSYSIMAGEID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSAppMenuItems();
        if (this.psAppMenuItemList != null) {
            this.appMenuItemList = new ArrayList();
            this.appMenuItemList.addAll(this.psAppMenuItemList);
        }
    }

    protected void onPreparePSAppMenuItems() throws Exception {
        String strRefPSAppMenuId;
        if (this.psAppMenuItemList != null) {
            this.psAppMenuItemList.clear();
        }
        if (StringHelper.isNullOrEmpty((String)(strRefPSAppMenuId = this.psAppMenuItem.getREFPSAPPMENUID()))) {
            return;
        }
        if (StringHelper.compare((String)strRefPSAppMenuId, (String)this.psAppMenuItem.getPSAPPMENUID(), (boolean)true) == 0) {
            throw new Exception(StringHelper.format((String)"\u5e94\u7528\u83dc\u5355[%1$s]\u4e0d\u80fd\u5f15\u7528\u81ea\u8eab", (Object)this.getPSAppMenuModel().getName()));
        }
        boolean bOpenActionSession = false;
        ActionSession recursionSession = ActionSessionManager.getCurrentSession();
        if (recursionSession == null) {
            bOpenActionSession = true;
            recursionSession = ActionSessionManager.openSession((String)this.getPSAppMenuModel().getName());
        }
        try {
            if (!recursionSession.registerRecursion(strRefPSAppMenuId, (Object)"")) {
                return;
            }
            Vector<PSAppMenuItem> psAppMenuItemList = new Vector<PSAppMenuItem>();
            CallResult callResult = this.getPSModelQueryHelper().getPSAppMenuItems(strRefPSAppMenuId, psAppMenuItemList);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
                psAppMenuItemMap.put(psAppMenuItem.getPSAPPMENUITEMID(), psAppMenuItem);
            }
            int nTopMenuItemCount = 0;
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
                if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) {
                    PSAppMenuItem parentPSAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemMap.get(psAppMenuItem.getPPSAPPMENUITEMID()));
                    if (parentPSAppMenuItem == null) continue;
                    parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem);
                    continue;
                }
                ++nTopMenuItemCount;
            }
            for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
                if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || !StringHelper.isNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
                if (nTopMenuItemCount > 1) {
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorageContext().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    ((IPSAppMenuItemRuntime)iPSAppMenuItem).init(this.getPSModelStorageContext(), (IPSAppMenuModel)this.getPSAppMenu(), this, psAppMenuItem);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                    continue;
                }
                ArrayList<PSAppMenuItem> psAppMenuItemList2 = psAppMenuItem.getChildPSAppMenuItems(false);
                if (psAppMenuItemList2 == null || psAppMenuItemList2.size() == 0) {
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorageContext().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    ((IPSAppMenuItemRuntime)iPSAppMenuItem).init(this.getPSModelStorageContext(), (IPSAppMenuModel)this.getPSAppMenu(), this, psAppMenuItem);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                    continue;
                }
                for (PSAppMenuItem psAppMenuItem2 : psAppMenuItemList2) {
                    if (!psAppMenuItem2.isENABLEMODENull() && !psAppMenuItem2.getENABLEMODE()) continue;
                    IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorageContext().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
                    ((IPSAppMenuItemRuntime)iPSAppMenuItem).init(this.getPSModelStorageContext(), (IPSAppMenuModel)this.getPSAppMenu(), this, psAppMenuItem2);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                }
            }
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
        }
        catch (Exception ex) {
            if (bOpenActionSession) {
                ActionSessionManager.closeSession();
            }
            throw ex;
        }
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
        return this.iPSAppFunc;
    }

    public String getItemType() {
        return this.getPSAppMenuItemData().getAMITEMTYPE();
    }

    public Iterator<IPSAppMenuItem> getPSAppMenuItems() {
        if (this.psAppMenuItemList == null) {
            return null;
        }
        return this.psAppMenuItemList.iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.iPSAppFunc != null) {
            ((IPSAppFuncRuntime)this.iPSAppFunc).fillRelatedPSAppViews(relatedAppViewList);
        }
        if (this.psAppMenuItemList != null) {
            for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
                ((IPSAppMenuItemRuntime)iPSAppMenuItem).fillRelatedPSAppViews(relatedAppViewList);
            }
        }
    }

    public ArrayList<IAppMenuItem> getItems() {
        return this.appMenuItemList;
    }

    public String getAppFuncId() {
        return this.psAppMenuItem.getPSAPPFUNCID();
    }

    @Override
    public void fillRelatedPSAppFuncs(ArrayList<IPSAppFunc> psAppFuncList) {
        if (this.iPSAppFunc != null) {
            psAppFuncList.add(this.iPSAppFunc);
        }
        if (this.psAppMenuItemList != null) {
            for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
                ((IPSAppMenuItemRuntime)iPSAppMenuItem).fillRelatedPSAppFuncs(psAppFuncList);
            }
        }
    }

    public boolean isSeperator() {
        return false;
    }

    public boolean isOpenDefault() {
        return this.bOpenDefault;
    }

    public boolean isDisableClose() {
        return this.bDisableClose;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSAppMenuModel()).getPSSysModelInstId();
    }

    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    public boolean isHideSideBar() {
        return this.bHideSideBar;
    }

    @Override
    public String getTooltip() {
        return this.getCaption();
    }

    public int getAccUserMode() {
        if (this.iPSAppFunc != null) {
            return this.iPSAppFunc.getAccUserMode();
        }
        return AccessUserModes.UNKNOWN;
    }

    @Override
    public String getAccessKey() {
        if (this.iPSAppFunc != null) {
            return this.iPSAppFunc.getAccessKey();
        }
        return null;
    }

    public boolean isValid() {
        return this.bValidFlag;
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

    public int getAppMenuItemState() {
        return 0;
    }

    public boolean isHidden() {
        return false;
    }
}

