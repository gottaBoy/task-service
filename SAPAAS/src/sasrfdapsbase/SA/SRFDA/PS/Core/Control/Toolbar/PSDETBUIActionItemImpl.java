/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEContextMenuItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItemRuntime;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbar;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDETBGroupItemImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDETBSeperatorItemImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.PSDEToolbarItemImpl;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemSetting;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDEToolbarItem;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;

public class PSDETBUIActionItemImpl
extends PSDEToolbarItemImpl
implements IPSDETBUIActionItem,
IPSDECMUIActionItem,
IPSDETBUIActionItemRuntime {
    private static final ArrayList<IPSDEContextMenuItem> emptyPSDEContextMenuItemList = new ArrayList();
    private IPSAppView frontPSAppView = null;
    private IPSUIAction iPSUIAction = null;
    private JSONObject uiActionParamJO = null;
    private ArrayList<IPSDEContextMenuItem> psDEContextMenuItemList = null;
    private boolean bHiddenItem = false;
    private int nNoPrivDisplayMode = 2;
    private String strGroupExtractMode = "ITEM";
    private int nActionLevel = 100;
    private IPSAppCounterRef iPSAppCounterRef = null;
    private PSAppViewUIActionProxy psAppViewUIActionProxy = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEToolbar iPSDEToolbar, IPSDEToolbarItem parentPSDEToolbarItem, PSDEToolbarItem psDEToolbarItem, IPSUIAction iPSUIAction) throws Exception {
        this.iPSUIAction = iPSUIAction;
        String strUIActionParam = psDEToolbarItem.getUIACTIONPARAMS().trim();
        if (!StringHelper.IsNullOrEmpty((String)strUIActionParam)) {
            if (strUIActionParam.charAt(0) == '{') {
                this.uiActionParamJO = JSONObject.fromString((String)strUIActionParam);
            } else {
                this.uiActionParamJO = new JSONObject();
                Properties properties = PropertiesHelper.load((String)strUIActionParam);
                Enumeration<Object> keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String strKey = keys.nextElement().toString();
                    String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
                    this.uiActionParamJO.put(strKey, (Object)strValue);
                }
            }
        }
        if (this.iPSUIAction != null && this.iPSUIAction.getUIActionParamJO() != null) {
            JSONObject uiActionParamJO2;
            Iterator fieldNames;
            if (this.uiActionParamJO == null) {
                this.uiActionParamJO = new JSONObject();
            }
            if ((fieldNames = (uiActionParamJO2 = this.iPSUIAction.getUIActionParamJO()).keys()) != null) {
                while (fieldNames.hasNext()) {
                    String strFieldName = (String)fieldNames.next();
                    if (this.uiActionParamJO.has(strFieldName)) continue;
                    this.uiActionParamJO.put(strFieldName, uiActionParamJO2.get(strFieldName));
                }
            }
        }
        if (!psDEToolbarItem.isHIDDENITEMNull()) {
            this.bHiddenItem = this.psDEToolbarItem.getHIDDENITEM();
        }
        super.init(iDAGlobalHelper, iPSDEToolbar, parentPSDEToolbarItem, psDEToolbarItem);
    }

    @Override
    protected void onInit() throws Exception {
        String strButtonActionType = this.getPSDEToolbarItemData().getBTNACTIONTYPE();
        if (StringHelper.IsNullOrEmpty((String)strButtonActionType)) {
            strButtonActionType = "UIACTION";
        }
        if (this.iPSUIAction == null && this.getPSAppDataEntity() != null) {
            if (StringHelper.Compare((String)strButtonActionType, (String)"UIACTION", (boolean)false) == 0) {
                if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getPSDEUIACTIONID())) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u884c\u4e3a");
                }
                this.iPSUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(this.getPSDEToolbarItemData().getPSDEUIACTIONID(), true, this.getOwnedPSControl());
            } else {
                PSDEUIAction psDEUIAction;
                IPSAppView openPSAppView = null;
                if (StringHelper.Compare((String)strButtonActionType, (String)"UILOGIC", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getPSDELOGICID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u903b\u8f91\u5bf9\u8c61");
                    }
                    psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()).toUpperCase());
                    psDEUIAction.setCODENAME(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()));
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("FRONT");
                    psDEUIAction.setFRONTPROTYPE("OTHER");
                    psDEUIAction.setVLEXECMODE("REPLACE");
                    psDEUIAction.setVIEWLOGICTYPE("DELOGIC");
                    psDEUIAction.setPSDEVIEWLOGICID(this.getPSDEToolbarItemData().getPSDELOGICID());
                    psDEUIAction.setACTIONTARGET("SINGLEDATA");
                    psDEUIAction.setPSDEID(this.getPSAppDataEntity().getPSDataEntity().getId());
                    psDEUIAction.setPSDENAME(this.getPSAppDataEntity().getPSDataEntity().getName());
                    psDEUIAction.setUIACTIONPARAMS(this.getPSDEToolbarItemData().getUIACTIONPARAMS());
                    psDEUIAction.set("AUTOMODEL", 1);
                    this.iPSUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"OPENDEVIEW", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getOPENPSDEVIEWID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u5b9e\u4f53\u89c6\u56fe\u5bf9\u8c61");
                    }
                    openPSAppView = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppViewByDEViewId(this.getPSDEToolbarItemData().getOPENPSDEVIEWID(), false);
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"OPENVIEW", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getOPENPSAPPVIEWID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61");
                    }
                    try {
                        openPSAppView = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppView(this.getPSDEToolbarItemData().getOPENPSAPPVIEWID(), false);
                    }
                    catch (Exception ex) {
                        throw new Exception(String.format("\u6307\u5b9a\u6253\u5f00\u7684\u5e94\u7528\u89c6\u56fe[%1$s]\u4e0d\u5728\u5f53\u524d\u5e94\u7528\u4e2d", this.getPSDEToolbarItemData().getOPENPSAPPVIEWNAME()));
                    }
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"OPENSYSPDTVIEW", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getOPENPSSYSPDTVIEWID())) {
                        throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe\u5bf9\u8c61");
                    }
                    String strPSAppPDTViewId = Helper.GenUniqueId((String)this.getPSDEToolbar().getPSAppView().getPSApplication().getId(), (String)this.getPSDEToolbarItemData().getOPENPSSYSPDTVIEWID());
                    openPSAppView = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppPDTView(strPSAppPDTViewId, false).getPSAppView();
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"OPENHTMLPAGE", (boolean)false) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getHTMLPAGEURL())) {
                        throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u9875\u9762\u8def\u5f84");
                    }
                    psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()).toUpperCase());
                    psDEUIAction.setCODENAME(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()));
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("FRONT");
                    psDEUIAction.setFRONTPROTYPE("OPENHTMLPAGE");
                    psDEUIAction.setHTMLPAGEURL(this.getPSDEToolbarItemData().getHTMLPAGEURL());
                    psDEUIAction.setACTIONTARGET("SINGLEDATA");
                    psDEUIAction.setUIACTIONPARAMS(this.getPSDEToolbarItemData().getUIACTIONPARAMS());
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (this.getPSDEToolbar().getPSAppDataEntity() != null) {
                        psDEUIAction.setPSDEID(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getName());
                        this.iPSUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSDEToolbar().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        this.iPSUIAction = ((IPSApplicationRuntime)((Object)this.getPSDEToolbar().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
                    }
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"CUSTOM", (boolean)false) == 0) {
                    psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()).toUpperCase());
                    psDEUIAction.setCODENAME(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()));
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(this.getCaption());
                    psDEUIAction.setUIACTIONTYPE("CUSTOM");
                    psDEUIAction.setCUSTOMCODE(this.getPSDEToolbarItemData().getCUSTOMCODE());
                    psDEUIAction.setACTIONTARGET("NONE");
                    psDEUIAction.setUIACTIONPARAMS(this.getPSDEToolbarItemData().getUIACTIONPARAMS());
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (this.getPSDEToolbar().getPSAppDataEntity() != null) {
                        psDEUIAction.setPSDEID(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getName());
                        this.iPSUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSDEToolbar().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        this.iPSUIAction = ((IPSApplicationRuntime)((Object)this.getPSDEToolbar().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
                    }
                } else if (StringHelper.Compare((String)strButtonActionType, (String)"NONE", (boolean)false) != 0) {
                    this.iPSUIAction = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppDEUIActionByPredefinedType(strButtonActionType, true);
                    if (this.iPSUIAction == null) {
                        psDEUIAction = new PSDEUIAction();
                        psDEUIAction.setPSDEUIACTIONID(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()).toUpperCase());
                        psDEUIAction.setCODENAME(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()));
                        psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                        psDEUIAction.setCAPTION(this.getCaption());
                        psDEUIAction.setUIACTIONTYPE("SYS");
                        psDEUIAction.setPSSYSUIACTIONID(strButtonActionType);
                        psDEUIAction.setUIACTIONPARAMS(this.getPSDEToolbarItemData().getUIACTIONPARAMS());
                        psDEUIAction.set("AUTOMODEL", 1);
                        if (this.getPSDEToolbar().getPSAppDataEntity() != null) {
                            psDEUIAction.setPSDEID(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getId());
                            psDEUIAction.setPSDENAME(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getName());
                            this.iPSUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSDEToolbar().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
                        } else {
                            this.iPSUIAction = ((IPSApplicationRuntime)((Object)this.getPSDEToolbar().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
                        }
                    }
                }
                if (openPSAppView != null) {
                    psDEUIAction = new PSDEUIAction();
                    psDEUIAction.setPSDEUIACTIONID(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()).toUpperCase());
                    psDEUIAction.setCODENAME(String.format("toolbar_%1$s_%2$s_click", this.getPSDEToolbar().getCodeName(), this.getName()));
                    psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
                    psDEUIAction.setCAPTION(openPSAppView.getCaption());
                    psDEUIAction.setUIACTIONTYPE("FRONT");
                    psDEUIAction.setFRONTPROTYPE("WIZARD");
                    psDEUIAction.setPSAPPVIEWID(openPSAppView.getId());
                    psDEUIAction.setPSAPPVIEWNAME(openPSAppView.getName());
                    psDEUIAction.setACTIONTARGET("SINGLEDATA");
                    psDEUIAction.setUIACTIONPARAMS(this.getPSDEToolbarItemData().getUIACTIONPARAMS());
                    psDEUIAction.set("AUTOMODEL", 1);
                    if (this.getPSDEToolbar().getPSAppDataEntity() != null) {
                        psDEUIAction.setPSDEID(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getId());
                        psDEUIAction.setPSDENAME(this.getPSDEToolbar().getPSAppDataEntity().getPSDataEntity().getName());
                        this.iPSUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSDEToolbar().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
                    } else {
                        this.iPSUIAction = ((IPSApplicationRuntime)((Object)this.getPSDEToolbar().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
                    }
                }
            }
        }
        if (this.iPSUIAction == null) {
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEToolbarItemData().getPSDEUIACTIONID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u754c\u9762\u884c\u4e3a");
            }
            this.iPSUIAction = this.getPSDEToolbar().getPSDataEntity().getPSDEUIAction(this.getPSDEToolbarItemData().getPSDEUIACTIONID());
        }
        this.nNoPrivDisplayMode = this.psDEToolbarItem.isNOPRIVDMNull() ? (this.iPSUIAction != null ? this.iPSUIAction.getNoPrivDisplayMode(this.getPSDEToolbar().getPSAppView()) : this.getPSDEToolbar().getPSAppView().getButtonNoPrivDisplayMode()) : this.psDEToolbarItem.getNOPRIVDM();
        if (!StringHelper.IsNullOrEmpty((String)this.psDEToolbarItem.getGROUPEXTRACTMODE())) {
            this.strGroupExtractMode = this.psDEToolbarItem.getGROUPEXTRACTMODE();
        }
        if (!this.psDEToolbarItem.isACTIONLEVELNull()) {
            this.nActionLevel = this.psDEToolbarItem.getACTIONLEVEL();
        } else if (this.getPSUIAction() != null) {
            this.nActionLevel = this.getPSUIAction().getActionLevel();
        }
        this.psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getId(), this.getName(), this, this);
        this.psAppViewUIActionProxy.setPSAppCounterRef(this.getPSAppCounterRef());
        if (!this.psDEToolbarItem.isHIDDENITEMNull()) {
            this.bHiddenItem = this.psDEToolbarItem.getHIDDENITEM();
        }
        super.onInit();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onPreparePSDEToolbarItems() throws Exception {
        block40: {
            block39: {
                psDEToolbarItemList = this.getPSDEToolbarItemList(false);
                if (psDEToolbarItemList != null) {
                    psDEToolbarItemList.clear();
                }
                if (this.psDEContextMenuItemList != null) {
                    this.psDEContextMenuItemList.clear();
                }
                nViewUARegMode = 0;
                iPSSysEngineConfig = PSSystemSetting.getPSSysEngineConfig(this.getPSDEToolbar().getPSDataEntity().getPSSystem());
                if (iPSSysEngineConfig != null) {
                    nViewUARegMode = iPSSysEngineConfig.getViewUARegMode();
                }
                if (nViewUARegMode == 0) {
                    if (!this.iPSUIAction.isUIActionGroup(this)) {
                        if (this.isPrepareTemplV2logic()) {
                            this.getPSControlContainer().registerPSAppViewUIAction(this.psAppViewUIActionProxy);
                            this.registerPSAppViewLogic();
                        } else {
                            this.getPSAppView().registerPSUIAction(this.iPSUIAction, this.uiActionParamJO);
                        }
                        return;
                    }
                    if (!this.iPSUIAction.isValid(this)) {
                        return;
                    }
                } else if (nViewUARegMode == 1) {
                    if (!this.iPSUIAction.isValid(this)) {
                        return;
                    }
                    if (!this.iPSUIAction.isUIActionGroup(this)) {
                        if (this.isPrepareTemplV2logic()) {
                            this.getPSControlContainer().registerPSAppViewUIAction(this.psAppViewUIActionProxy);
                            this.registerPSAppViewLogic();
                        } else {
                            this.getPSAppView().registerPSUIAction(this.iPSUIAction, this.uiActionParamJO);
                        }
                        return;
                    }
                }
                if ((iPSUIActionGroup = this.iPSUIAction.getPSUIActionGroup(this)) == null) {
                    return;
                }
                psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
                if (psUIActionGroupDetails == null && !this.iPSUIAction.isEnableUIActionGroupExMode(this)) {
                    return;
                }
                if (this.psDEContextMenuItemList == null) {
                    this.psDEContextMenuItemList = new ArrayList<E>();
                }
                if (psDEToolbarItemList == null) {
                    psDEToolbarItemList = this.getPSDEToolbarItemList(true);
                }
                if (this.iPSUIAction.isEnableUIActionGroupExMode(this)) break block39;
                psDETBGroupItemImpl = null;
                if (StringHelper.Compare((String)this.getGroupExtractMode(), (String)"ITEMS", (boolean)true) == 0) {
                    psDEToolbarItem = new PSDEToolbarItem();
                    this.psDEToolbarItem.CopyTo(psDEToolbarItem, false);
                    psDEToolbarItem.setTBITEMTYPE("ITEMS");
                    psDEToolbarItem.setPSDEUIACTIONID(null);
                    psDEToolbarItem.setPSDEUIACTIONNAME(null);
                    psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
                    psDETBGroupItemImpl = new PSDETBGroupItemImpl();
                    psDETBGroupItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
                    psDEToolbarItemList.add(psDETBGroupItemImpl);
                } else if (StringHelper.Compare((String)this.getGroupExtractMode(), (String)"ITEMX", (boolean)true) == 0) {
                    psDEToolbarItem = new PSDEToolbarItem();
                    this.psDEToolbarItem.CopyTo(psDEToolbarItem, false);
                    psDEToolbarItem.setTBITEMTYPE("ITEMS");
                    psDEToolbarItem.setPSDEUIACTIONID(null);
                    psDEToolbarItem.setPSDEUIACTIONNAME(null);
                    psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
                    psDEToolbarItem.setPSDEUAGROUPID(iPSUIActionGroup.getId());
                    psDEToolbarItem.setPSDEUAGROUPNAME(iPSUIActionGroup.getName());
                    psDETBGroupItemImpl = new PSDETBGroupItemImpl();
                    psDETBGroupItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
                    psDEToolbarItemList.add(psDETBGroupItemImpl);
                }
                if (StringHelper.Compare((String)this.getGroupExtractMode(), (String)"ITEMX", (boolean)true) == 0) break block40;
                bClose = false;
                strRecursionId = null;
                try {
                    block41: {
                        strRecursionId = String.valueOf(this.getPSAppView().getId()) + "||" + this.getPSDEToolbar().getId() + "||" + this.iPSUIAction.getId();
                        actionSession = ActionSessionManager.getCurrentSession();
                        if (actionSession != null) break block41;
                        bClose = true;
                        actionSession = ActionSessionManager.openSession((String)"PSDETBUIActionItemImpl");
                        actionSession.registerRecursion("PSUIAction", (Object)strRecursionId);
                        ** GOTO lbl132
                    }
                    if (actionSession.registerRecursion("PSUIAction", (Object)strRecursionId)) ** GOTO lbl132
                    throw new Exception(StringHelper.Format((String)"\u754c\u9762\u884c\u4e3a[%1$s]\u5b58\u5728\u9012\u5f52\u5173\u7cfb", (Object)this.iPSUIAction.getName()));
lbl-1000:
                    // 1 sources

                    {
                        iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                        iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                        if (iPSUIAction == null) continue;
                        psDEToolbarItem = new PSDEToolbarItem();
                        psDEToolbarItem.setTBITEMTYPE("DEUIACTION");
                        psDEToolbarItem.setPSDETBITEMID(iPSUIAction.getId());
                        strTBItemName = "";
                        strTBItemName = StringHelper.IsNullOrEmpty((String)iPSUIAction.getCodeName()) != false ? StringHelper.Format((String)"%1$s_%2$s", (Object)this.getName(), (Object)iPSUIAction.getId().substring(0, 6)) : StringHelper.Format((String)"%1$s_%2$s", (Object)this.getName(), (Object)iPSUIAction.getCodeName());
                        strTBItemName = strTBItemName.toLowerCase();
                        psDEToolbarItem.setPSDETBITEMNAME(strTBItemName);
                        psDEToolbarItem.setPSDEUIACTIONID(iPSUIAction.getId());
                        psDEToolbarItem.setPSDEUIACTIONNAME(iPSUIAction.getName());
                        strShowMode = this.getPSDEToolbarItemData().getSHOWMODE();
                        if (StringHelper.IsNullOrEmpty((String)strShowMode)) {
                            if (iPSUIActionGroupDetail.isShowCaption() && iPSUIActionGroupDetail.isShowIcon()) {
                                strShowMode = "ICONANDSHORTWORD";
                            } else if (iPSUIActionGroupDetail.isShowCaption()) {
                                strShowMode = "SHORTWORD";
                            } else if (iPSUIActionGroupDetail.isShowIcon()) {
                                strShowMode = "ICON";
                            }
                        }
                        psDEToolbarItem.setSHOWMODE(strShowMode);
                        if (!StringHelper.IsNullOrEmpty((String)iPSUIActionGroupDetail.getPSSysCssId())) {
                            psDEToolbarItem.setPSSYSCSSID(iPSUIActionGroupDetail.getPSSysCssId());
                        }
                        if (!StringHelper.IsNullOrEmpty((String)iPSUIActionGroupDetail.getPSSysImageId())) {
                            psDEToolbarItem.setPSSYSIMAGEID(iPSUIActionGroupDetail.getPSSysImageId());
                        }
                        psDEToolbarItem.setUIACTIONPARAMS(iPSUIActionGroupDetail.getUIActionParam());
                        iPSUIAction.fillUIActionItem((Object)psDEToolbarItem);
                        psDETBUIActionItemImpl = new PSDETBUIActionItemImpl();
                        psDETBUIActionItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem, iPSUIAction);
                        psDETBSeperatorItemImpl = null;
                        if (iPSUIActionGroupDetail.isAddSeparator()) {
                            psDEToolbarItem2 = new PSDEToolbarItem();
                            psDEToolbarItem2.setTBITEMTYPE("SEPERATOR");
                            psDEToolbarItem2.setPSDETBITEMID(String.valueOf(iPSUIAction.getId()) + "_SEP");
                            strTBItemName2 = String.valueOf(strTBItemName) + "_sep";
                            psDEToolbarItem2.setPSDETBITEMNAME(strTBItemName2);
                            psDETBSeperatorItemImpl = new PSDETBSeperatorItemImpl();
                            psDETBSeperatorItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem2);
                        }
                        if (psDETBGroupItemImpl != null) {
                            if (psDETBSeperatorItemImpl != null) {
                                psDETBGroupItemImpl.addPSDEToolbarItem(psDETBSeperatorItemImpl);
                            }
                            psDETBGroupItemImpl.addPSDEToolbarItem(psDETBUIActionItemImpl);
                            continue;
                        }
                        if (psDETBSeperatorItemImpl != null) {
                            psDEToolbarItemList.add(psDETBSeperatorItemImpl);
                        }
                        psDEToolbarItemList.add(psDETBUIActionItemImpl);
lbl132:
                        // 5 sources

                        ** while (psUIActionGroupDetails.hasNext())
                    }
lbl133:
                    // 2 sources

                    for (IPSDEToolbarItem iPSDEToolbarItem : psDEToolbarItemList) {
                        this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
                    }
                    ActionSessionManager.getCurrentSession().unregisterRecursion("PSUIAction", (Object)strRecursionId);
                    if (!bClose) ** GOTO lbl161
                    ActionSessionManager.closeSession();
                }
                catch (Exception ex) {
                    if (!StringHelper.IsNullOrEmpty(strRecursionId)) {
                        ActionSessionManager.getCurrentSession().unregisterRecursion("PSUIAction", strRecursionId);
                    }
                    if (bClose) {
                        ActionSessionManager.closeSession();
                    }
                    throw ex;
                }
            }
            psDEToolbarItem = new PSDEToolbarItem();
            this.psDEToolbarItem.CopyTo(psDEToolbarItem, false);
            psDEToolbarItem.setTBITEMTYPE("ITEMS");
            psDEToolbarItem.setPSDEUIACTIONID(null);
            psDEToolbarItem.setPSDEUIACTIONNAME(null);
            psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
            psDEToolbarItem.setPSDEUAGROUPID(iPSUIActionGroup.getId());
            psDEToolbarItem.setPSDEUAGROUPNAME(iPSUIActionGroup.getName());
            psDETBGroupItemImpl = new PSDETBGroupItemImpl();
            psDETBGroupItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
            psDEToolbarItemList.add(psDETBGroupItemImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u9879\u96c6\u5408", modeltype="SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItemAll", hideempty2=true, child=true, outputdoc="false")
    public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception {
        ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
        if (psDEToolbarItemList != null) {
            return psDEToolbarItemList.iterator();
        }
        return emptyPSDEToolbarItemList.iterator();
    }

    @Override
    public IPSDEUIAction getPSDEUIAction() {
        if (this.getPSUIAction() instanceof IPSDEUIAction) {
            return (IPSDEUIAction)this.getPSUIAction();
        }
        return null;
    }

    @Override
    public IPSWFUIAction getPSWFUIAction() {
        if (this.getPSUIAction() instanceof IPSWFUIAction) {
            return (IPSWFUIAction)this.getPSUIAction();
        }
        return null;
    }

    @Override
    public IPSAppView getPSAppView() {
        if (this.getPSDEToolbar() != null) {
            return this.getPSDEToolbar().getPSAppView();
        }
        if (this.getPSDEContextMenu() != null) {
            return this.getPSDEContextMenu().getPSAppView();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", child=true, fields={"PSDEUIACTIONID"}, doc="\u9664\u4e86\u663e\u5f0f\u6307\u5b9a\u754c\u9762\u884c\u4e3a\uff0c\u5176\u5b83\u7c7b\u578b{@link PSDETBItemDTO#FIELD_BTNACTIONTYPE}\u4e5f\u4f1a\u88ab\u4eff\u771f\u4e3a\u754c\u9762\u884c\u4e3a")
    public IPSUIAction getPSUIAction() {
        return this.iPSUIAction;
    }

    @Override
    public void setPSUIAction(IPSUIAction iPSUIAction) {
        this.iPSUIAction = iPSUIAction;
    }

    @Override
    protected String onGetCaption() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCaption(this.getPSAppView().getLanguage());
        }
        return super.onGetCaption();
    }

    @Override
    protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        IPSAppView refPSAppView;
        super.onFillRelatedPSAppViews(relatedAppViewList);
        if (this.getPSDEUIAction() != null) {
            IPSAppView refPSAppView2 = this.getPSDEUIAction().getFrontPSAppView(this);
            if (refPSAppView2 != null) {
                relatedAppViewList.add(refPSAppView2);
            }
        } else if (this.getPSWFUIAction() != null && (refPSAppView = this.getPSWFUIAction().getFrontPSAppView(this)) != null) {
            relatedAppViewList.add(refPSAppView);
        }
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() throws Exception {
        if (this.getPSUIAction() != null && this.getPSUIAction().isUIActionGroup(this)) {
            if (this.getPSUIAction().isEnableUIActionGroupExMode(this)) {
                return true;
            }
            ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
            return psDEToolbarItemList != null && psDEToolbarItemList.size() > 0;
        }
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().isValid(this);
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().isValid(this);
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() == null && this.getPSUIAction() != null) {
            return this.getPSUIAction().getPSSysImage();
        }
        return super.getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u5de5\u5177\u63d0\u793a", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        String strTooltipInfo = this.psDEToolbarItem.getTOOLTIPINFO();
        if (!StringHelper.IsNullOrEmpty((String)strTooltipInfo)) {
            return strTooltipInfo;
        }
        if (this.getPSUIAction() != null) {
            strTooltipInfo = this.getPSUIAction().getTooltip(this.getPSAppView().getLanguage());
        }
        if (StringHelper.IsNullOrEmpty((String)strTooltipInfo)) {
            return this.getCaption();
        }
        return strTooltipInfo;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u70b9\u51fb\u5207\u6362\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isEnableToggleMode() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().isEnableToggleMode();
        }
        return false;
    }

    @Override
    public JSONObject getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @Override
    public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
        if (this.psDEContextMenuItemList != null) {
            return this.psDEContextMenuItemList.iterator();
        }
        return emptyPSDEContextMenuItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        if (super.getCapPSLanguageRes() == null && this.getPSUIAction() != null) {
            return this.getPSUIAction().getCapPSLanguageRes();
        }
        return super.getCapPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        if (super.getTooltipPSLanguageRes() == null && this.getPSUIAction() != null) {
            return this.getPSUIAction().getTooltipPSLanguageRes();
        }
        return super.getTooltipPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf", ignoredumpvalues="false", fields={"HIDDENITEM"})
    public boolean isHiddenItem() {
        return this.bHiddenItem;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="BtnNoPrivDisplayMode", fields={"NOPRIVDM"})
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7ec4\u5c55\u5f00\u6a21\u5f0f", ignorert=3, codelist="UGExtractMode", fields={"GROUPEXTRACTMODE"})
    public String getGroupExtractMode() {
        return this.strGroupExtractMode;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6253\u5f00\u89c6\u56fe", hideempty=true)
    public IPSAppView getFrontPSAppView() throws Exception {
        if (this.frontPSAppView != null) {
            return this.frontPSAppView;
        }
        if (this.getPSDEUIAction() != null) {
            this.frontPSAppView = this.getPSDEUIAction().getFrontPSAppView(this);
            if (this.frontPSAppView != null) {
                return this.frontPSAppView;
            }
        }
        if (this.getPSWFUIAction() != null) {
            this.frontPSAppView = this.getPSWFUIAction().getFrontPSAppView(this);
            if (this.frontPSAppView != null) {
                return this.frontPSAppView;
            }
        }
        return null;
    }

    @Override
    public String getXDataControlName() {
        try {
            IPSControl refPSControl = this.getOwnedPSControl().getRefPSControl();
            if (refPSControl != null) {
                return refPSControl.getName();
            }
        }
        catch (Exception ex) {
            this.error(String.format("\u8ba1\u7b97\u5de5\u5177\u680f\u5f15\u7528\u90e8\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            return null;
        }
        if (this.getOwner() instanceof IPSControl) {
            return ((IPSControl)this.getOwner()).getName();
        }
        if (this.getOwner() instanceof IPSControlObject) {
            return ((IPSControlObject)this.getOwner()).getOwnedPSControl().getName();
        }
        if (this.getOwner() instanceof IPSAppDEXDataView) {
            return ((IPSAppDEXDataView)this.getOwner()).getXDataControlName();
        }
        return null;
    }

    @Override
    public IPSControl getXDataPSControl() throws Exception {
        try {
            IPSControl refPSControl = this.getOwnedPSControl().getRefPSControl();
            if (refPSControl != null) {
                return refPSControl;
            }
        }
        catch (Exception ex) {
            this.error(String.format("\u8ba1\u7b97\u5de5\u5177\u680f\u5f15\u7528\u90e8\u4ef6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()));
            return null;
        }
        if (this.getOwner() instanceof IPSControl) {
            return (IPSControl)this.getOwner();
        }
        if (this.getOwner() instanceof IPSControlObject) {
            return ((IPSControlObject)this.getOwner()).getOwnedPSControl();
        }
        if (this.getOwner() instanceof IPSAppDEXDataView) {
            return ((IPSAppDEXDataView)this.getOwner()).getXDataPSControl();
        }
        return null;
    }

    protected void registerPSAppViewLogic() throws Exception {
        if (this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
            String strCtrlName = null;
            if (this.getPSDEToolbar() != null) {
                strCtrlName = this.getPSDEToolbar().getName();
            } else if (this.getPSDEContextMenu() != null) {
                strCtrlName = this.getPSDEContextMenu().getName();
            }
            String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_click", (Object)strCtrlName, (Object)this.getName()).toLowerCase();
            PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
            psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
            psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
            psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
            psAppViewLogic.setPSAPPVIEWLOGICTYPE("CTRLEVENT");
            psAppViewLogic.setPSAPPVIEWCTRLNAME(strCtrlName);
            psAppViewLogic.setEVENTNAMES("CLICK");
            psAppViewLogic.setEVENTARG(this.getName());
            PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
            psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSControlContainer(), psAppViewLogic, this.psAppViewUIActionProxy);
            this.getPSControlContainer().registerPSAppViewLogic(psAppDEViewLogicImpl);
        }
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        if (StringHelper.Compare((String)strModelType, (String)"PSAPPVIEWUIACTION", (boolean)true) == 0) {
            return IPSAppViewUIAction.class;
        }
        return super.getModelClass(strModelType);
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100", fields={"ACTIONLEVEL"})
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    public boolean isSaveTargetFirst() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().isSaveTargetFirst();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().isSaveTargetFirst();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getUIActionTarget() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getActionTarget();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getActionTarget();
        }
        return "NONE";
    }

    @Override
    public IPSAppCounterRef getPSAppCounterRef() {
        return this.iPSAppCounterRef;
    }

    @Override
    public void setPSAppCounterRef(IPSAppCounterRef iPSAppCounterRef) {
        this.iPSAppCounterRef = iPSAppCounterRef;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a", dumpref=true)
    public IPSAppViewUIAction getPSAppViewUIAction() {
        return this.psAppViewUIActionProxy;
    }

    @Override
    protected boolean isPrepareTemplV2logic() {
        return this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    public IPSAppDataEntity getPSAppDataEntity() {
        return this.getPSDEToolbar().getPSAppDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u6837\u5f0f", codelist="BorderStyle", fields={"BORDERSTYLE"})
    public String getBorderStyle() {
        return this.psDEToolbarItem.getBORDERSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", fields={"ITEMSTYLE"})
    public String getButtonStyle() {
        String strItemStyle = this.psDEToolbarItem.getITEMSTYLE();
        if (StringHelper.IsNullOrEmpty((String)strItemStyle) && this.getPSUIAction() != null) {
            strItemStyle = this.getPSUIAction().getButtonStyle();
        }
        if (!StringHelper.IsNullOrEmpty((String)strItemStyle)) {
            return strItemStyle;
        }
        return this.getItemStyle();
    }

    @Override
    protected String onGetCounterId() {
        if (StringHelper.IsNullOrEmpty((String)super.onGetCounterId()) && this.getPSUIAction() != null) {
            return this.getPSUIAction().getCounterId();
        }
        return super.onGetCounterId();
    }
}

