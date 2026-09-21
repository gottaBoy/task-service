/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.security.AccessUserModes
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutPos;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemImpl;
import SA.SRFDA.PS.Core.Control.Menu.PSMenuItemImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemImplBase
extends PSMenuItemImpl
implements IPSAppMenuItem {
    private static final Log log = LogFactory.getLog(PSAppMenuItemImpl.class);
    private IPSAppMenu iPSAppMenu = null;
    private IPSAppMenuModel iPSAppMenuModel = null;
    private IPSAppMenuItem parentPSAppMenuItem = null;
    protected PSAppMenuItem psAppMenuItem = null;
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
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private String strLayoutMode = "";
    private IPSLayoutPos iPSLayoutPos = null;
    private IPSLayout iPSLayout = null;
    private int nTitleBarCloseMode = 0;
    private String strData = "";
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppMenuModel iPSAppMenuModel, IPSAppMenuItem parentPSAppMenuItem, PSAppMenuItem psAppMenuItem) throws Exception {
        try {
            String strPSDynaInstId;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSAppMenuModel(iPSAppMenuModel);
            this.setParentPSAppMenuItem(parentPSAppMenuItem);
            this.setPSAppMenuItemData(psAppMenuItem);
            this.setId(this.psAppMenuItem.getPSAPPMENUITEMID());
            this.setName(this.psAppMenuItem.getPSAPPMENUITEMNAME());
            String strCaption = psAppMenuItem.getCAPTION();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCaption)) {
                strCaption = this.psAppMenuItem.getPSAPPFUNCNAME();
            }
            this.setCaption(strCaption);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getPSAPPFUNCID())) {
                this.iPSAppFunc = this.getPSAppMenuModel().getPSApplication().getPSAppFunc(this.psAppMenuItem.getPSAPPFUNCID(), false, this.getPSAppMenu());
                if (this.getPSAppMenu().getPSAppView() != null) {
                    this.getPSAppMenu().getPSAppView().registerPSAppFunc(this.iPSAppFunc);
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
            if (!this.psAppMenuItem.isTITLEBARCLOSEMODENull()) {
                this.nTitleBarCloseMode = this.psAppMenuItem.getTITLEBARCLOSEMODE();
            }
            if (this.getPSAppMenu() != null) {
                PSLayout psLayout;
                IPSLayout iPSLayout;
                this.strLayoutMode = this.psAppMenuItem.getLAYOUTMODE();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                    this.strLayoutMode = parentPSAppMenuItem == null ? this.getPSAppMenu().getLayoutMode() : parentPSAppMenuItem.getLayoutMode();
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                    this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.strLayoutMode, this.psAppMenuItem);
                }
                if (this.parentPSAppMenuItem != null) {
                    if (this.parentPSAppMenuItem instanceof IPSLayoutContainer && (iPSLayout = this.parentPSAppMenuItem.getPSLayout()) != null) {
                        psLayout = new PSLayout();
                        psLayout.proxy(this.psAppMenuItem);
                        this.iPSLayoutPos = iPSLayout.createPSLayoutPos(this, psLayout);
                    }
                } else if (this.getPSAppMenu() instanceof IPSLayoutContainer && (iPSLayout = this.getPSAppMenu().getPSLayout()) != null) {
                    psLayout = new PSLayout();
                    psLayout.proxy(this.psAppMenuItem);
                    this.iPSLayoutPos = iPSLayout.createPSLayoutPos(this, psLayout);
                }
            }
            boolean bRegisterToContainer = true;
            if (this.getPSAppMenu() != null && this.getPSAppMenu().getPSAppView() != null) {
                bRegisterToContainer = this.getPSAppMenu().getPSAppView().getPSPFStyle().isRegisterToContainer();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPSSYSCSSID())) {
                this.iPSSysCss = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysCss(psAppMenuItem.getPSSYSCSSID());
                if (this.getPSAppMenu() != null) {
                    if (bRegisterToContainer) {
                        if (this.getPSAppMenu().getPSControlContainer() != null) {
                            this.getPSAppMenu().getPSControlContainer().registerPSSysCss(this.iPSSysCss);
                        }
                    } else if (this.getPSAppMenu().getPSAppView() != null) {
                        this.getPSAppMenu().getPSAppView().registerPSSysCss(this.iPSSysCss);
                    }
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysImage(psAppMenuItem.getPSSYSIMAGEID());
                if (this.getPSAppMenu() != null) {
                    if (bRegisterToContainer) {
                        if (this.getPSAppMenu().getPSControlContainer() != null) {
                            this.getPSAppMenu().getPSControlContainer().registerPSSysImage(this.iPSSysImage);
                        }
                    } else if (this.getPSAppMenu().getPSAppView() != null) {
                        this.getPSAppMenu().getPSAppView().registerPSSysImage(this.iPSSysImage);
                    }
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSAppMenuModel().getPSApplication().getPSSystem().getPSSysUniRes(this.psAppMenuItem.getPSSYSUNIRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getCOUNTERID())) {
                this.strCounterId = this.psAppMenuItem.getCOUNTERID();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getTOOLTIPINFO())) {
                this.setTooltip(this.psAppMenuItem.getTOOLTIPINFO());
            } else if (this.iPSAppFunc != null) {
                this.setTooltip(this.iPSAppFunc.getTooltip());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getCAPPSLANRESID())) {
                this.setCapPSLanguageRes(this.getPSAppMenu().getPSApplication().getPSLanguageRes(this.psAppMenuItem.getCAPPSLANRESID()));
            } else if (this.iPSAppFunc != null) {
                this.setCapPSLanguageRes(this.iPSAppFunc.getNamePSLanguageRes());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getTIPPSLANRESID())) {
                this.setTooltipPSLanguageRes(this.getPSAppMenu().getPSApplication().getPSLanguageRes(this.psAppMenuItem.getTIPPSLANRESID()));
            } else if (this.iPSAppFunc != null) {
                this.setTooltipPSLanguageRes(this.iPSAppFunc.getTooltipPSLanguageRes());
            }
            if (!psAppMenuItem.isMENUITEMSTATENull()) {
                this.nAppMenuItemState = this.psAppMenuItem.getMENUITEMSTATE();
            }
            if (!this.psAppMenuItem.isHIDDENITEMNull()) {
                this.bHiddenItem = this.psAppMenuItem.getHIDDENITEM();
            }
            if (!this.psAppMenuItem.isEXPANDNull()) {
                this.setExpanded(this.psAppMenuItem.getEXPAND());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getFILLEROBJ())) {
                this.strFillerObj = this.psAppMenuItem.getFILLEROBJ();
            }
            this.strData = this.psAppMenuItem.getDATA();
            if (this.getPSAppMenu() != null && this.getPSAppMenu().getPSAppView() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenuItem.getPSSYSPFPLUGINID())) {
                    this.iPSSysPFPlugin = this.getPSAppMenu().getPSAppView().getPSApplication() != null ? this.getPSAppMenu().getPSAppView().getPSApplication().getPSSysPFPlugin(this.psAppMenuItem.getPSSYSPFPLUGINID(), "CONTROLITEM", this.getPSAppMenu().getControlType(), this.getItemType()) : this.getPSAppMenu().getPSAppView().getPSApplication().getPSSystem().getPSSysPFPlugin(this.psAppMenuItem.getPSSYSPFPLUGINID());
                    this.getPSAppMenu().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
                }
                if (this.getPSSysPFPlugin() != null) {
                    String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppMenu().getPSAppView().getPSApplication().getPSPF().getId());
                    IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppMenu().getPSAppView().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                    if (iPSSysPFPluginTempl != null) {
                        this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, (Object)this.getPSAppMenu().getPSAppView(), (Object)this.getPSAppMenu(), (Object)this);
                    }
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strPSDynaInstId = this.psAppMenuItem.getParamStringValue("PSDEVSLNSYSDYNAINSTID", null)))) {
                String strTag = "srfdynainstid".toUpperCase();
                PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strPSDynaInstId, null, true);
                if (this.psNavigateContextMap == null) {
                    this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                }
                this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
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
            IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorage().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
            IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
            iPSAppMenuItem.init(this.getDAGlobalHelper(), this.getPSAppMenu(), this, psAppMenuItem);
            this.psAppMenuItemList.add(iPSAppMenuItem);
        }
    }

    public IPSAppMenuItem getParentPSAppMenuItem() {
        return this.parentPSAppMenuItem;
    }

    protected void setParentPSAppMenuItem(IPSAppMenuItem parentPSAppMenuItem) {
        this.parentPSAppMenuItem = parentPSAppMenuItem;
        this.setParentPSMenuItem(this.parentPSAppMenuItem);
    }

    public PSAppMenuItem getPSAppMenuItemData() {
        return this.psAppMenuItem;
    }

    protected void setPSAppMenuItemData(PSAppMenuItem psAppMenuItem) {
        this.psAppMenuItem = psAppMenuItem;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd", dumpref=true, from="IPSApplication", fields={"PSAPPFUNCID"})
    public IPSAppFunc getPSAppFunc() {
        return this.iPSAppFunc;
    }

    protected void setPSAppFunc(IPSAppFunc iPSAppFunc) {
        this.iPSAppFunc = iPSAppFunc;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u7c7b\u578b", codelist="AppMenuItemType2", fields={"AMITEMTYPE"})
    public String getItemType() {
        return this.getPSAppMenuItemData().getAMITEMTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", hideempty=true, child=true)
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() {
        if (this.psAppMenuItemList == null) {
            return null;
        }
        return this.psAppMenuItemList.iterator();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        if (this.iPSAppFunc != null) {
            this.iPSAppFunc.fillRelatedPSAppViews(relatedAppViewList);
        }
        if (this.psAppMenuItemList != null) {
            for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
                iPSAppMenuItem.fillRelatedPSAppViews(relatedAppViewList);
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
                iPSAppMenuItem.fillRelatedPSAppFuncs(psAppFuncList);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5206\u9694\u680f", ignoredumpvalues="false", ignorert=3)
    public boolean isSeperator() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u5ef6\u5c55", ignoredumpvalues="false", staticcode="false")
    public boolean isSpanMode() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6253\u5f00", ignoredumpvalues="false", fields={"OPENDEFAULT"})
    public boolean isOpenDefault() {
        return this.bOpenDefault;
    }

    @Override
    @PSModelRTMeta(description="\u7981\u7528\u5173\u95ed", ignoredumpvalues="false", fields={"DISABLECLOSE"})
    public boolean isDisableClose() {
        return this.bDisableClose;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppMenuModel().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u56fe\u7247", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6837\u5f0f\u8868", fields={"PSSYSIMAGEID"})
    public IPSSysCss getPSSysCss() {
        return this.iPSSysCss;
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u65f6\u9690\u85cf\u8fb9\u680f", ignoredumpvalues="false", fields={"HIDESIDEBAR"})
    public boolean isHideSideBar() {
        return this.bHideSideBar;
    }

    @Override
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
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6", doc="\u4f18\u5148\u4f7f\u7528\u914d\u7f6e\u7684\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u4ee3\u7801\uff0c\u672a\u5b9a\u4e49\u65f6\u4f7f\u7528\u5e94\u7528\u529f\u80fd\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        if (this.iPSSysUniRes != null) {
            return this.iPSSysUniRes.getResCode();
        }
        if (this.iPSAppFunc != null) {
            return this.iPSAppFunc.getAccessKey();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true", fields={"ENABLEMODE"})
    public boolean isValid() {
        return this.bValidFlag;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bc6", fields={"COUNTERID"})
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
    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f", dump=false)
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return super.getIconCls();
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u72b6\u6001", codelist="MenuItemState", ignoredumpvalues="0", fields={"MENUITEMSTATE"})
    public int getAppMenuItemState() {
        return this.nAppMenuItemState;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf", ignoredumpvalues="false", fields={"HIDDENITEM"})
    public boolean isHidden() {
        return this.bHiddenItem;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u586b\u5145\u5668\u5bf9\u8c61", dump=false)
    public String getFillerObj() {
        return this.strFillerObj;
    }

    @Override
    public String getModelType() {
        return "PSAPPMENUITEM";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppMenu().getModelId(), (Object)this.getName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppMenu().getPSApplication().getPSSystem());
    }

    public IPSSystem getPSSystem() {
        return this.getPSAppMenu().getPSApplication().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u8bbe\u7f6e", hideempty=true, child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u901a\u77e5\u6807\u8bb0", fields={"INFORMTAG"})
    public String getInformTag() {
        return this.psAppMenuItem.getINFORMTAG();
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u901a\u77e5\u6807\u8bb02", fields={"INFORMTAG2"})
    public String getInformTag2() {
        return this.psAppMenuItem.getINFORMTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u680f\u5173\u95ed\u6a21\u5f0f", codelist="FormTitleBarCloseMode", ignoredumpvalues="0")
    public int getTitleBarCloseMode() {
        return this.nTitleBarCloseMode;
    }

    @Override
    @PSModelRTMeta(description="\u4f4d\u7f6e", hideempty=true, child=true)
    public IPSLayoutPos getPSLayoutPos() {
        return this.iPSLayoutPos;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSAppMenu();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        if (this.getPSAppMenuModel() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppMenuModel().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u6570\u636e", fields={"DATA"})
    public String getData() {
        return this.strData;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    public String getRenderMode() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6837\u5f0f\u8868", fields={"DYNACLASS"})
    public String getDynaClass() {
        return this.psAppMenuItem.getDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"RAWCSSSTYLE"})
    public String getCssStyle() {
        return this.psAppMenuItem.getRAWCSSSTYLE();
    }

    @Override
    public String getItemStyle() {
        return this.psAppMenuItem.getITEMSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b", fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.psAppMenuItem.getPREDEFINEDTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b\u53c2\u6570", fields={"PREDEFINEDTYPEPARAM"})
    public String getPredefinedTypeParam() {
        return this.psAppMenuItem.getPREDEFINEDTYPEPARAM();
    }

    public IPSApplication getPSApplication() {
        if (this.getPSAppMenuModel() != null) {
            return this.getPSAppMenuModel().getPSApplication();
        }
        if (this.getPSAppMenu() != null && this.getPSAppMenu().getPSAppView() != null) {
            this.getPSAppMenu().getPSAppView().getPSApplication();
        }
        return null;
    }
}

