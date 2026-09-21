/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.menu.AppMenuRootItem
 *  net.ibizsys.paas.control.menu.IAppMenuItem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.Func.IPSAppFunc;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenu;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItem;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuLogic;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuParam;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuLogicImpl;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuParamImpl;
import SA.SRFDA.PS.Core.Control.PSAjaxControlImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppMenu;
import SA.SRFDA.PS.Data.PSAppMenuItem;
import SA.SRFDA.PS.Data.PSAppMenuLogic;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.control.menu.AppMenuRootItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"APPMENU"})
public class PSAppMenuImpl
extends PSAjaxControlImpl
implements IPSAppMenu {
    private static final Log log = LogFactory.getLog(PSAppMenuImpl.class);
    protected PSAppMenu psAppMenu;
    protected ArrayList<IPSAppMenuItem> psAppMenuItemList = new ArrayList();
    protected AppMenuRootItem appMenuRootItem = new AppMenuRootItem();
    protected IPSSysCounter iPSSysCounter = null;
    private IPSApplication iPSApplication = null;
    protected ArrayList<IPSAppMenuItem> allPSAppMenuItemList = new ArrayList();
    private boolean bEnableCustomize = false;
    protected String strLayoutMode = "";
    protected String strAppMenuStyle = "";
    private IPSLayout iPSLayout = null;
    private IPSSysCounterRef iPSSysCounterRef = null;
    private boolean bExportModelAlways = true;
    protected List<PSAppMenuLogicImpl> psAppMenuLogicList = new ArrayList<PSAppMenuLogicImpl>();
    private PSAppMenuParamImpl psAppMenuParamImpl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            IPSAppMenuParam iPSAppMenuParam = (IPSAppMenuParam)iPSControlParam;
            this.setPSControlContainer(iPSControlContainer);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(this.getPSAppView().getPSApplication());
            this.psAppMenu = new PSAppMenu();
            CallResult callResult = this.getPSModelHelper().getPSAppMenu(iPSAppMenuParam.getPSAppMenuId(), this.psAppMenu);
            if (callResult.isError()) {
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psAppMenu.getPSAPPMENUID());
            this.setName(strName);
            this.setLogicName(this.psAppMenu.getLOGICNAME());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenu.getPSSYSCOUNTERID())) {
                this.iPSSysCounter = this.getPSApplication() != null ? this.getPSApplication().getPSAppCounter(this.psAppMenu.getPSSYSCOUNTERID(), false) : this.getPSAppView().getPSSystem().getPSSysCounter(this.psAppMenu.getPSSYSCOUNTERID(), false);
            }
            if (!this.psAppMenu.isCUSTOMIZEDFLAGNull()) {
                this.bEnableCustomize = this.psAppMenu.getCUSTOMIZEDFLAG();
            }
            this.strAppMenuStyle = iPSAppMenuParam.getAppMenuStyle();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strAppMenuStyle) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenu.getAPPMENUSTYLE())) {
                this.strAppMenuStyle = this.psAppMenu.getAPPMENUSTYLE();
            }
            this.psAppMenuParamImpl = this.createPSAppMenuParamImpl();
            this.psAppMenuParamImpl.setPSCtrlMsgId(this.psAppMenu.getPSCTRLMSGID());
            this.psAppMenuParamImpl.setPSSysPFPluginId(this.psAppMenu.getPSSYSPFPLUGINID());
            this.psAppMenuParamImpl.setPSDEUILogicGroupId(this.psAppMenu.getPSCTRLLOGICGROUPID());
            this.psAppMenuParamImpl.setPSSysCssId(this.psAppMenu.getPSSYSCSSID());
            this.psAppMenuParamImpl.setAppMenuStyle(this.psAppMenu.getAPPMENUSTYLE());
            this.psAppMenuParamImpl.merge(iPSControlParam);
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psAppMenuParamImpl);
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
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppMenu psAppMenu) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.psAppMenu = psAppMenu;
            this.setId(this.psAppMenu.getPSAPPMENUID());
            this.setName(this.psAppMenu.getPSAPPMENUNAME());
            this.setLogicName(this.psAppMenu.getLOGICNAME());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppMenu.getPSSYSCOUNTERID())) {
                this.iPSSysCounter = this.getPSApplication() != null ? this.getPSApplication().getPSAppCounter(this.psAppMenu.getPSSYSCOUNTERID(), false) : this.getPSAppView().getPSApplication().getPSAppCounter(this.psAppMenu.getPSSYSCOUNTERID(), false);
            }
            this.bExportModelAlways = false;
            this.setPSObjectData(psAppMenu);
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
        if (this.getPSControlContainer() != null) {
            if (this.getPSAppView() != null && this.getPSSysCounter() != null) {
                this.iPSSysCounterRef = this.getPSSysCounter() instanceof IPSAppCounter ? this.getPSAppView().registerPSAppCounter((IPSAppCounter)this.getPSSysCounter(), null) : this.getPSAppView().registerPSSysCounter(this.getPSSysCounter(), null);
            }
            this.onPreparePSAppMenuLayout();
            super.onInit();
        }
        this.onPreparePSAppMenuItems();
        this.onPreparePSAppMenuLogics();
    }

    protected PSAppMenuParamImpl createPSAppMenuParamImpl() {
        return new PSAppMenuParamImpl();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.psAppMenu.getCODENAME(), null);
    }

    protected void onPreparePSAppMenuItems() throws Exception {
        String strLogicName;
        PSAppMenuItem psAppMenuItem2;
        int nIndex;
        IPSAppFunc iPSAppFunc;
        this.psAppMenuItemList.clear();
        this.allPSAppMenuItemList.clear();
        Vector<PSAppMenuItem> psAppMenuItemList = new Vector<PSAppMenuItem>();
        CallResult callResult = this.getPSModelHelper().getPSAppMenuItems(this.getId(), psAppMenuItemList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSAppMenuItem> psAppMenuItemMap = new HashMap<String, PSAppMenuItem>();
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE()) continue;
            psAppMenuItemMap.put(psAppMenuItem.getPSAPPMENUITEMID(), psAppMenuItem);
        }
        boolean bDynaInstMode = false;
        ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = null;
        IPSSystemRuntime iPSSystemRuntime = (IPSSystemRuntime)((Object)this.getPSSystem());
        if (iPSSystemRuntime.getDynaInstMode() == 1) {
            psDevSlnSysDynaInstList = iPSSystemRuntime.getPSDevSlnSysDynaInstList();
            bDynaInstMode = true;
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
            PSAppMenuItem parentPSAppMenuItem = (PSAppMenuItem)((Object)psAppMenuItemMap.get(psAppMenuItem.getPPSAPPMENUITEMID()));
            if (parentPSAppMenuItem == null) {
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u83dc\u5355\u7236\u9879[%1$s]\uff0c\u5ffd\u7565\u6b64\u6a21\u578b", (Object)psAppMenuItem.getPPSAPPMENUITEMID()), "PSAPPMENUITEM", "REMOVE", psAppMenuItem.getPSAPPMENUITEMID());
                continue;
            }
            if (bDynaInstMode && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPSAPPFUNCID()) && (iPSAppFunc = this.getPSApplication().getPSAppFunc(psAppMenuItem.getPSAPPFUNCID(), false, this)).getPSAppView() != null && iPSAppFunc.getPSAppView().getDynaInstMode() == 2 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppFunc.getUserData())) {
                if (psDevSlnSysDynaInstList == null) continue;
                nIndex = 0;
                for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTAG(), (String)iPSAppFunc.getPSAppView().getDynaInstTag(), (boolean)false) != 0) continue;
                    ++nIndex;
                    psAppMenuItem2 = new PSAppMenuItem();
                    psAppMenuItem.CopyTo(psAppMenuItem2, false);
                    strLogicName = psDevSlnSysDynaInst.getLOGICNAME();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicName)) {
                        strLogicName = psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME();
                    }
                    psAppMenuItem2.setPSAPPMENUITEMNAME(String.format("%1$s__srf%2$s", psAppMenuItem.getPSAPPMENUITEMNAME(), nIndex));
                    psAppMenuItem2.setCAPTION(String.format("%1$s%2$s", psAppMenuItem.getCAPTION(), strLogicName));
                    psAppMenuItem2.setTOOLTIPINFO(String.format("%1$s%2$s", psAppMenuItem.getTOOLTIPINFO(), strLogicName));
                    psAppMenuItem2.set("PSDEVSLNSYSDYNAINSTID", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                    parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem2);
                }
                continue;
            }
            parentPSAppMenuItem.getChildPSAppMenuItems(true).add(psAppMenuItem);
        }
        for (PSAppMenuItem psAppMenuItem : psAppMenuItemList) {
            if (!psAppMenuItem.isENABLEMODENull() && !psAppMenuItem.getENABLEMODE() || !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPPSAPPMENUITEMID())) continue;
            IPSAppMenuItemType iPSAppMenuItemType = this.getPSModelStorage().getPSAppMenuItemType(psAppMenuItem.getAMITEMTYPE());
            if (bDynaInstMode && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psAppMenuItem.getPSAPPFUNCID()) && (iPSAppFunc = this.getPSApplication().getPSAppFunc(psAppMenuItem.getPSAPPFUNCID(), false, this)).getPSAppView() != null && iPSAppFunc.getPSAppView().getDynaInstMode() == 2 && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSAppFunc.getUserData())) {
                if (psDevSlnSysDynaInstList == null) continue;
                nIndex = 0;
                for (PSDevSlnSysDynaInst psDevSlnSysDynaInst : psDevSlnSysDynaInstList) {
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTAG(), (String)iPSAppFunc.getPSAppView().getDynaInstTag(), (boolean)false) != 0) continue;
                    ++nIndex;
                    psAppMenuItem2 = new PSAppMenuItem();
                    psAppMenuItem.CopyTo(psAppMenuItem2, false);
                    strLogicName = psDevSlnSysDynaInst.getLOGICNAME();
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogicName)) {
                        strLogicName = psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME();
                    }
                    psAppMenuItem2.setPSAPPMENUITEMNAME(String.format("%1$s__srf%2$s", psAppMenuItem.getPSAPPMENUITEMNAME(), nIndex));
                    psAppMenuItem2.setCAPTION(String.format("%1$s%2$s", psAppMenuItem.getCAPTION(), strLogicName));
                    psAppMenuItem2.setTOOLTIPINFO(String.format("%1$s%2$s", psAppMenuItem.getTOOLTIPINFO(), strLogicName));
                    psAppMenuItem2.set("PSDEVSLNSYSDYNAINSTID", psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID());
                    IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem2);
                    iPSAppMenuItem.init(this.getDAGlobalHelper(), this, null, psAppMenuItem2);
                    this.psAppMenuItemList.add(iPSAppMenuItem);
                    this.appMenuRootItem.getItems().add(iPSAppMenuItem);
                }
                continue;
            }
            IPSAppMenuItem iPSAppMenuItem = iPSAppMenuItemType.createPSAppMenuItem(psAppMenuItem);
            iPSAppMenuItem.init(this.getDAGlobalHelper(), this, null, psAppMenuItem);
            this.psAppMenuItemList.add(iPSAppMenuItem);
            this.appMenuRootItem.getItems().add(iPSAppMenuItem);
        }
        for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
            this.addToAllPSAppMenuItemList(iPSAppMenuItem);
        }
    }

    protected void addToAllPSAppMenuItemList(IPSAppMenuItem iPSAppMenuItem) throws Exception {
        this.allPSAppMenuItemList.add(iPSAppMenuItem);
        Iterator<IPSAppMenuItem> childPSAppMenuItems = iPSAppMenuItem.getPSAppMenuItems();
        if (childPSAppMenuItems != null) {
            while (childPSAppMenuItems.hasNext()) {
                this.addToAllPSAppMenuItemList(childPSAppMenuItems.next());
            }
        }
    }

    protected void onPreparePSAppMenuLayout() throws Exception {
        this.strLayoutMode = this.psAppMenu.getLAYOUTMODE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            if (this.isDesignMode()) {
                this.strLayoutMode = this.getPreviewPSPF().getPanelLayoutMode();
            } else {
                String strPFType = "";
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPFType)) {
                    strPFType = this.getPSAppView().getPSApplication().getPFType();
                }
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPFType);
                this.strLayoutMode = iPSPF.getPanelLayoutMode();
            }
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            PSLayout psLayout = new PSLayout();
            psLayout.setFLEXALIGN(this.psAppMenu.getFLEXALIGN());
            psLayout.setFLEXDIR(this.psAppMenu.getFLEXDIR());
            psLayout.setFLEXVALIGN(this.psAppMenu.getFLEXVALIGN());
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.strLayoutMode, psLayout);
        }
    }

    protected void onPreparePSAppMenuLogics() throws Exception {
        this.psAppMenuLogicList.clear();
        this.onPreparePSAppMenuLogics(this.getId());
    }

    protected void onPreparePSAppMenuLogics(String strPSAppMenuId) throws Exception {
        Vector<PSAppMenuLogic> psAppMenuLogicList = new Vector<PSAppMenuLogic>();
        CallResult callResult = this.getPSModelHelper().getPSAppMenuLogics(strPSAppMenuId, psAppMenuLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u83dc\u5355\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSAppMenuLogic psAppMenuLogic : psAppMenuLogicList) {
            PSAppMenuLogicImpl psAppMenuLogicImpl = new PSAppMenuLogicImpl();
            psAppMenuLogicImpl.init(this.getDAGlobalHelper(), this, psAppMenuLogic);
            this.psAppMenuLogicList.add(psAppMenuLogicImpl);
        }
    }

    @Override
    protected String onGetControlType() {
        return "APPMENU";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.psAppMenuItemList != null) {
            for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
                iPSAppMenuItem.fillRelatedPSAppViews(relatedAppViewList);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u9879\u96c6\u5408", child=true)
    public Iterator<IPSAppMenuItem> getPSAppMenuItems() throws Exception {
        return this.psAppMenuItemList.iterator();
    }

    @Override
    public String getModelScope() {
        return "APP";
    }

    public Iterator<IAppMenuItem> getAppMenuItems() {
        return this.appMenuRootItem.getItems().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psAppMenuParamImpl;
    }

    @Override
    public AppMenuRootItem getRootItem() {
        return this.appMenuRootItem;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u529f\u80fd\u96c6\u5408")
    public Iterator<IPSAppFunc> getPSAppFuncs() {
        ArrayList<IPSAppFunc> psAppFuncList = new ArrayList<IPSAppFunc>();
        for (IPSAppMenuItem iPSAppMenuItem : this.psAppMenuItemList) {
            iPSAppMenuItem.fillRelatedPSAppFuncs(psAppFuncList);
        }
        LinkedHashMap<String, IPSAppFunc> psAppFuncMap = new LinkedHashMap<String, IPSAppFunc>();
        for (IPSAppFunc iPSAppFunc : psAppFuncList) {
            psAppFuncMap.put(iPSAppFunc.getId(), iPSAppFunc);
        }
        return psAppFuncMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668")
    public IPSSysCounter getPSSysCounter() {
        return this.iPSSysCounter;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true)
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668\u5f15\u7528", hideempty=true, dumpref=true, fields={"PSSYSCOUNTERID"})
    public IPSAppCounterRef getPSAppCounterRef() {
        if (this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef) {
            return (IPSAppCounterRef)this.getPSSysCounterRef();
        }
        return null;
    }

    @Override
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
        return this.getPSApplication().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSAPPMENU";
    }

    @Override
    public Iterator<IPSAppMenuItem> getAllPSAppMenuItems() throws Exception {
        return this.allPSAppMenuItemList.iterator();
    }

    @Override
    public String getFullModelName() {
        if (this.getPSAppView() == null && this.getPSApplication() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    public boolean isEnableCustomize() {
        return this.bEnableCustomize;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49", ignoredumpvalues="false", fields={"CUSTOMIZEDFLAG"})
    public boolean isEnableCustomized() {
        return this.bEnableCustomize;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u6837\u5f0f", codelist="AppMenuStyle", fields={"APPMENUSTYLE"})
    public String getAppMenuStyle() {
        return this.strAppMenuStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", codelist="PanelLayoutMode2", fields={"LAYOUTMODE"})
    public String getLayoutMode() {
        return this.strLayoutMode;
    }

    @Override
    @PSModelRTMeta(description="\u83dc\u5355\u5e03\u5c40\u5bf9\u8c61", child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    public String getControlSubType() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getAppMenuStyle())) {
            return super.getControlSubType();
        }
        return this.getAppMenuStyle();
    }

    @Override
    protected boolean isExportModelAlways() {
        return this.bExportModelAlways;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSAppMenuLogic> getPSAppMenuLogics() {
        if (this.psAppMenuLogicList == null || this.psAppMenuLogicList.size() == 0) {
            return null;
        }
        return this.psAppMenuLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psAppMenuLogicList == null || this.psAppMenuLogicList.size() == 0) {
            return null;
        }
        return this.psAppMenuLogicList.iterator();
    }
}

