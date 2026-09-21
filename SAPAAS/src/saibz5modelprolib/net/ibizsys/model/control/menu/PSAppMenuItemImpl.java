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
 *  net.ibizsys.model.security.IPSSysUniRes
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.menu;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.app.func.IPSAppFuncRuntime;
import net.ibizsys.model.app.menu.IPSAppMenuModel;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.IPSAppMenuItem;
import net.ibizsys.model.control.menu.IPSAppMenuItemRuntime;
import net.ibizsys.model.control.menu.IPSAppMenuItemType;
import net.ibizsys.model.control.menu.IPSMenuItem;
import net.ibizsys.model.control.menu.PSMenuItemImpl;
import net.ibizsys.model.entity.PSAppMenuItem;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemImpl
extends PSMenuItemImpl
implements IPSAppMenuItem,
IPSAppMenuItemRuntime {
    private static final Log log = LogFactory.getLog(PSAppMenuItemImpl.class);
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
    private String strAccessKey = null;
    private IPSSysUniRes iPSSysUniRes = null;
    private String strCounterId = null;
    private int nAppMenuItemState = 0;
    private boolean bHiddenItem = false;
    private String strFillerObj = null;

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
                if (this.getPSAppMenu().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSAppMenu().getPSAppView()).registerPSAppFunc(this.iPSAppFunc);
                }
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
                if (this.getPSAppMenu().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSAppMenu().getPSAppView()).registerPSSysCss(this.iPSSysCss);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)psAppMenuItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysImage(psAppMenuItem.getPSSYSIMAGEID());
                if (this.getPSAppMenu().getPSAppView() != null) {
                    ((IPSAppViewRuntime)this.getPSAppMenu().getPSAppView()).registerPSSysImage(this.iPSSysImage);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysUniRes(this.psAppMenuItem.getPSSYSUNIRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getCOUNTERID())) {
                this.strCounterId = this.psAppMenuItem.getCOUNTERID();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getTOOLTIPINFO())) {
                this.setTooltip(this.psAppMenuItem.getTOOLTIPINFO());
            } else if (this.iPSAppFunc != null) {
                this.setTooltip(this.iPSAppFunc.getTooltip());
            }
            if (!psAppMenuItem.isMENUITEMSTATENull()) {
                this.nAppMenuItemState = this.psAppMenuItem.getMENUITEMSTATE();
            }
            if (!this.psAppMenuItem.isHIDDENITEMNull()) {
                this.bHiddenItem = this.psAppMenuItem.getHIDDENITEM();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psAppMenuItem.getFILLEROBJ())) {
                this.strFillerObj = this.psAppMenuItem.getFILLEROBJ();
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
        ArrayList<PSAppMenuItem> psAppMenuItemList;
        if (this.psAppMenuItemList != null) {
            this.psAppMenuItemList.clear();
        }
        if ((psAppMenuItemList = this.psAppMenuItem.getChildPSAppMenuItems(false)) == null) {
            return;
        }
        if (this.psAppMenuItemList == null) {
            this.psAppMenuItemList = new ArrayList();
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorageContext().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
            IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
            ((IPSAppMenuItemRuntime)iPSAppMenuItem).init(this.getPSModelStorageContext(), (IPSAppMenuModel)this.getPSAppMenu(), this, psAppMenuItem);
            this.psAppMenuItemList.add(iPSAppMenuItem);
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

    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd")
    public IPSAppFunc getPSAppFunc() {
        return this.iPSAppFunc;
    }

    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="AppMenuItemType")
    public String getItemType() {
        return this.getPSAppMenuItemData().getAMITEMTYPE();
    }

    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", hideempty=true)
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

    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00")
    public boolean isOpenDefault() {
        return this.bOpenDefault;
    }

    @PSModelRTMeta(description="\u7981\u7528\u5173\u95ed")
    public boolean isDisableClose() {
        return this.bDisableClose;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSAppMenuModel()).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90")
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u6837\u5f0f")
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @PSModelRTMeta(description="\u6253\u5f00\u65f6\u9690\u85cf\u8fb9\u680f")
    public boolean isHideSideBar() {
        return this.bHideSideBar;
    }

    @PSModelRTMeta(description="\u8bbf\u95ee\u7528\u6237\u6a21\u5f0f", codelist="ViewAccessUsers")
    public int getAccUserMode() {
        if (this.iPSSysUniRes != null) {
            return AccessUserModes.LOGINUSERWITHKEY;
        }
        if (this.iPSAppFunc != null) {
            return this.iPSAppFunc.getAccUserMode();
        }
        return AccessUserModes.UNKNOWN;
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        if (this.iPSSysUniRes != null) {
            return this.iPSSysUniRes.getResCode();
        }
        if (this.iPSAppFunc != null) {
            return this.iPSAppFunc.getAccessKey();
        }
        return null;
    }

    @PSModelRTMeta(description="\u662f\u5426\u542f\u7528")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6")
    public String getCounterId() {
        return this.strCounterId;
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

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f")
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return super.getIconCls();
    }

    @PSModelRTMeta(description="\u83dc\u5355\u9879\u72b6\u6001", codelist="MenuItemState")
    public int getAppMenuItemState() {
        return this.nAppMenuItemState;
    }

    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf")
    public boolean isHidden() {
        return this.bHiddenItem;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u586b\u5145\u5668\u5bf9\u8c61")
    public String getFillerObj() {
        return this.strFillerObj;
    }

    @Override
    public String getModelType() {
        return "PSAPPMENUITEM";
    }
}

