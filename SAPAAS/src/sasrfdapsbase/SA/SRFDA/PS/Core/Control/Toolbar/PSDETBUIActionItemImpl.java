package SA.SRFDA.PS.Core.Control.Toolbar;

import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemSetting;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
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
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;

public class PSDETBUIActionItemImpl extends PSDEToolbarItemImpl implements IPSDETBUIActionItem, IPSDECMUIActionItem, IPSDETBUIActionItemRuntime {
   private static final ArrayList<IPSDEContextMenuItem> emptyPSDEContextMenuItemList = new ArrayList<>();
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

   public void init(
      ISRFDAGlobalHelper iDAGlobalHelper,
      IPSDEToolbar iPSDEToolbar,
      IPSDEToolbarItem parentPSDEToolbarItem,
      PSDEToolbarItem psDEToolbarItem,
      IPSUIAction iPSUIAction
   ) throws Exception {
      this.iPSUIAction = iPSUIAction;
      String strUIActionParam = psDEToolbarItem.getUIACTIONPARAMS().trim();
      if (!StringHelper.IsNullOrEmpty(strUIActionParam)) {
         if (strUIActionParam.charAt(0) == '{') {
            this.uiActionParamJO = JSONObject.fromString(strUIActionParam);
         } else {
            this.uiActionParamJO = new JSONObject();
            Properties properties = PropertiesHelper.load(strUIActionParam);
            Enumeration<Object> keys = properties.keys();

            while (keys.hasMoreElements()) {
               String strKey = keys.nextElement().toString();
               String strValue = PropertiesHelper.getProperty(properties, strKey);
               this.uiActionParamJO.put(strKey, strValue);
            }
         }
      }

      if (this.iPSUIAction != null && this.iPSUIAction.getUIActionParamJO() != null) {
         if (this.uiActionParamJO == null) {
            this.uiActionParamJO = new JSONObject();
         }

         JSONObject uiActionParamJO2 = this.iPSUIAction.getUIActionParamJO();
         Iterator fieldNames = uiActionParamJO2.keys();
         if (fieldNames != null) {
            while (fieldNames.hasNext()) {
               String strFieldName = (String)fieldNames.next();
               if (!this.uiActionParamJO.has(strFieldName)) {
                  this.uiActionParamJO.put(strFieldName, uiActionParamJO2.get(strFieldName));
               }
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
      if (StringHelper.IsNullOrEmpty(strButtonActionType)) {
         strButtonActionType = "UIACTION";
      }

      if (this.iPSUIAction == null && this.getPSAppDataEntity() != null) {
         if (StringHelper.Compare(strButtonActionType, "UIACTION", false) == 0) {
            if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getPSDEUIACTIONID())) {
               throw new Exception("没有指定界面行为");
            }

            this.iPSUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(this.getPSDEToolbarItemData().getPSDEUIACTIONID(), true, this.getOwnedPSControl());
         } else {
            IPSAppView openPSAppView = null;
            if (StringHelper.Compare(strButtonActionType, "UILOGIC", false) == 0) {
               if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getPSDELOGICID())) {
                  throw new Exception("未指定界面逻辑对象");
               }

               PSDEUIAction psDEUIAction = new PSDEUIAction();
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
               this.iPSUIAction = ((IPSAppDataEntityRuntime)this.getPSAppDataEntity()).registerPSAppDEUIAction(psDEUIAction);
            } else if (StringHelper.Compare(strButtonActionType, "OPENDEVIEW", false) == 0) {
               if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getOPENPSDEVIEWID())) {
                  throw new Exception("未指定打开的实体视图对象");
               }

               openPSAppView = this.getPSDEToolbar()
                  .getPSAppView()
                  .getPSApplication()
                  .getPSAppViewByDEViewId(this.getPSDEToolbarItemData().getOPENPSDEVIEWID(), false);
            } else if (StringHelper.Compare(strButtonActionType, "OPENVIEW", false) == 0) {
               if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getOPENPSAPPVIEWID())) {
                  throw new Exception("未指定打开的应用视图对象");
               }

               try {
                  openPSAppView = this.getPSDEToolbar()
                     .getPSAppView()
                     .getPSApplication()
                     .getPSAppView(this.getPSDEToolbarItemData().getOPENPSAPPVIEWID(), false);
               } catch (Exception ex) {
                  throw new Exception(String.format("指定打开的应用视图[%1$s]不在当前应用中", this.getPSDEToolbarItemData().getOPENPSAPPVIEWNAME()));
               }
            } else if (StringHelper.Compare(strButtonActionType, "OPENSYSPDTVIEW", false) == 0) {
               if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getOPENPSSYSPDTVIEWID())) {
                  throw new Exception("未指定打开的系统预置视图对象");
               }

               String strPSAppPDTViewId = Helper.GenUniqueId(
                  this.getPSDEToolbar().getPSAppView().getPSApplication().getId(), this.getPSDEToolbarItemData().getOPENPSSYSPDTVIEWID()
               );
               openPSAppView = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppPDTView(strPSAppPDTViewId, false).getPSAppView();
            } else if (StringHelper.Compare(strButtonActionType, "OPENHTMLPAGE", false) == 0) {
               if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getHTMLPAGEURL())) {
                  throw new Exception("未指定打开的页面路径");
               }

               PSDEUIAction psDEUIAction = new PSDEUIAction();
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
                  this.iPSUIAction = ((IPSAppDataEntityRuntime)this.getPSDEToolbar().getPSAppDataEntity()).registerPSAppDEUIAction(psDEUIAction);
               } else {
                  this.iPSUIAction = ((IPSApplicationRuntime)this.getPSDEToolbar().getPSAppView().getPSApplication()).registerPSAppDEUIAction(psDEUIAction);
               }
            } else if (StringHelper.Compare(strButtonActionType, "CUSTOM", false) == 0) {
               PSDEUIAction psDEUIAction = new PSDEUIAction();
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
                  this.iPSUIAction = ((IPSAppDataEntityRuntime)this.getPSDEToolbar().getPSAppDataEntity()).registerPSAppDEUIAction(psDEUIAction);
               } else {
                  this.iPSUIAction = ((IPSApplicationRuntime)this.getPSDEToolbar().getPSAppView().getPSApplication()).registerPSAppDEUIAction(psDEUIAction);
               }
            } else if (StringHelper.Compare(strButtonActionType, "NONE", false) != 0) {
               this.iPSUIAction = this.getPSDEToolbar().getPSAppView().getPSApplication().getPSAppDEUIActionByPredefinedType(strButtonActionType, true);
               if (this.iPSUIAction == null) {
                  PSDEUIAction psDEUIAction = new PSDEUIAction();
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
                     this.iPSUIAction = ((IPSAppDataEntityRuntime)this.getPSDEToolbar().getPSAppDataEntity()).registerPSAppDEUIAction(psDEUIAction);
                  } else {
                     this.iPSUIAction = ((IPSApplicationRuntime)this.getPSDEToolbar().getPSAppView().getPSApplication()).registerPSAppDEUIAction(psDEUIAction);
                  }
               }
            }

            if (openPSAppView != null) {
               PSDEUIAction psDEUIAction = new PSDEUIAction();
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
                  this.iPSUIAction = ((IPSAppDataEntityRuntime)this.getPSDEToolbar().getPSAppDataEntity()).registerPSAppDEUIAction(psDEUIAction);
               } else {
                  this.iPSUIAction = ((IPSApplicationRuntime)this.getPSDEToolbar().getPSAppView().getPSApplication()).registerPSAppDEUIAction(psDEUIAction);
               }
            }
         }
      }

      if (this.iPSUIAction == null) {
         if (StringHelper.IsNullOrEmpty(this.getPSDEToolbarItemData().getPSDEUIACTIONID())) {
            throw new Exception("没有指定界面行为");
         }

         this.iPSUIAction = this.getPSDEToolbar().getPSDataEntity().getPSDEUIAction(this.getPSDEToolbarItemData().getPSDEUIACTIONID());
      }

      if (this.psDEToolbarItem.isNOPRIVDMNull()) {
         if (this.iPSUIAction != null) {
            this.nNoPrivDisplayMode = this.iPSUIAction.getNoPrivDisplayMode(this.getPSDEToolbar().getPSAppView());
         } else {
            this.nNoPrivDisplayMode = this.getPSDEToolbar().getPSAppView().getButtonNoPrivDisplayMode();
         }
      } else {
         this.nNoPrivDisplayMode = this.psDEToolbarItem.getNOPRIVDM();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEToolbarItem.getGROUPEXTRACTMODE())) {
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

   @Override
   protected void onPreparePSDEToolbarItems() throws Exception {
      ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
      if (psDEToolbarItemList != null) {
         psDEToolbarItemList.clear();
      }

      if (this.psDEContextMenuItemList != null) {
         this.psDEContextMenuItemList.clear();
      }

      int nViewUARegMode = 0;
      IPSSysEngineConfig iPSSysEngineConfig = PSSystemSetting.getPSSysEngineConfig(this.getPSDEToolbar().getPSDataEntity().getPSSystem());
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

      IPSUIActionGroup iPSUIActionGroup = this.iPSUIAction.getPSUIActionGroup(this);
      if (iPSUIActionGroup != null) {
         Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = iPSUIActionGroup.getPSUIActionGroupDetails();
         if (psUIActionGroupDetails != null || this.iPSUIAction.isEnableUIActionGroupExMode(this)) {
            if (this.psDEContextMenuItemList == null) {
               this.psDEContextMenuItemList = new ArrayList<>();
            }

            if (psDEToolbarItemList == null) {
               psDEToolbarItemList = this.getPSDEToolbarItemList(true);
            }

            if (!this.iPSUIAction.isEnableUIActionGroupExMode(this)) {
               PSDETBGroupItemImpl psDETBGroupItemImpl = null;
               if (StringHelper.Compare(this.getGroupExtractMode(), "ITEMS", true) == 0) {
                  PSDEToolbarItem psDEToolbarItem = new PSDEToolbarItem();
                  this.psDEToolbarItem.CopyTo(psDEToolbarItem, false);
                  psDEToolbarItem.setTBITEMTYPE("ITEMS");
                  psDEToolbarItem.setPSDEUIACTIONID(null);
                  psDEToolbarItem.setPSDEUIACTIONNAME(null);
                  psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
                  psDETBGroupItemImpl = new PSDETBGroupItemImpl();
                  psDETBGroupItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
                  psDEToolbarItemList.add(psDETBGroupItemImpl);
               } else if (StringHelper.Compare(this.getGroupExtractMode(), "ITEMX", true) == 0) {
                  PSDEToolbarItem psDEToolbarItem = new PSDEToolbarItem();
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

               if (StringHelper.Compare(this.getGroupExtractMode(), "ITEMX", true) != 0) {
                  boolean bClose = false;
                  String strRecursionId = null;

                  try {
                     strRecursionId = this.getPSAppView().getId() + "||" + this.getPSDEToolbar().getId() + "||" + this.iPSUIAction.getId();
                     ActionSession actionSession = ActionSessionManager.getCurrentSession();
                     if (actionSession == null) {
                        bClose = true;
                        actionSession = ActionSessionManager.openSession("PSDETBUIActionItemImpl");
                        actionSession.registerRecursion("PSUIAction", strRecursionId);
                     } else if (!actionSession.registerRecursion("PSUIAction", strRecursionId)) {
                        throw new Exception(StringHelper.Format("界面行为[%1$s]存在递归关系", this.iPSUIAction.getName()));
                     }

                     while (psUIActionGroupDetails.hasNext()) {
                        IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
                        IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
                        if (iPSUIAction != null) {
                           PSDEToolbarItem psDEToolbarItem = new PSDEToolbarItem();
                           psDEToolbarItem.setTBITEMTYPE("DEUIACTION");
                           psDEToolbarItem.setPSDETBITEMID(iPSUIAction.getId());
                           String strTBItemName = "";
                           if (StringHelper.IsNullOrEmpty(iPSUIAction.getCodeName())) {
                              strTBItemName = StringHelper.Format("%1$s_%2$s", this.getName(), iPSUIAction.getId().substring(0, 6));
                           } else {
                              strTBItemName = StringHelper.Format("%1$s_%2$s", this.getName(), iPSUIAction.getCodeName());
                           }

                           strTBItemName = strTBItemName.toLowerCase();
                           psDEToolbarItem.setPSDETBITEMNAME(strTBItemName);
                           psDEToolbarItem.setPSDEUIACTIONID(iPSUIAction.getId());
                           psDEToolbarItem.setPSDEUIACTIONNAME(iPSUIAction.getName());
                           String strShowMode = this.getPSDEToolbarItemData().getSHOWMODE();
                           if (StringHelper.IsNullOrEmpty(strShowMode)) {
                              if (iPSUIActionGroupDetail.isShowCaption() && iPSUIActionGroupDetail.isShowIcon()) {
                                 strShowMode = "ICONANDSHORTWORD";
                              } else if (iPSUIActionGroupDetail.isShowCaption()) {
                                 strShowMode = "SHORTWORD";
                              } else if (iPSUIActionGroupDetail.isShowIcon()) {
                                 strShowMode = "ICON";
                              }
                           }

                           psDEToolbarItem.setSHOWMODE(strShowMode);
                           if (!StringHelper.IsNullOrEmpty(iPSUIActionGroupDetail.getPSSysCssId())) {
                              psDEToolbarItem.setPSSYSCSSID(iPSUIActionGroupDetail.getPSSysCssId());
                           }

                           if (!StringHelper.IsNullOrEmpty(iPSUIActionGroupDetail.getPSSysImageId())) {
                              psDEToolbarItem.setPSSYSIMAGEID(iPSUIActionGroupDetail.getPSSysImageId());
                           }

                           psDEToolbarItem.setUIACTIONPARAMS(iPSUIActionGroupDetail.getUIActionParam());
                           iPSUIAction.fillUIActionItem(psDEToolbarItem);
                           PSDETBUIActionItemImpl psDETBUIActionItemImpl = new PSDETBUIActionItemImpl();
                           psDETBUIActionItemImpl.init(
                              this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem, iPSUIAction
                           );
                           PSDETBSeperatorItemImpl psDETBSeperatorItemImpl = null;
                           if (iPSUIActionGroupDetail.isAddSeparator()) {
                              PSDEToolbarItem psDEToolbarItem2 = new PSDEToolbarItem();
                              psDEToolbarItem2.setTBITEMTYPE("SEPERATOR");
                              psDEToolbarItem2.setPSDETBITEMID(iPSUIAction.getId() + "_SEP");
                              String strTBItemName2 = strTBItemName + "_sep";
                              psDEToolbarItem2.setPSDETBITEMNAME(strTBItemName2);
                              psDETBSeperatorItemImpl = new PSDETBSeperatorItemImpl();
                              psDETBSeperatorItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem2);
                           }

                           if (psDETBGroupItemImpl != null) {
                              if (psDETBSeperatorItemImpl != null) {
                                 psDETBGroupItemImpl.addPSDEToolbarItem(psDETBSeperatorItemImpl);
                              }

                              psDETBGroupItemImpl.addPSDEToolbarItem(psDETBUIActionItemImpl);
                           } else {
                              if (psDETBSeperatorItemImpl != null) {
                                 psDEToolbarItemList.add(psDETBSeperatorItemImpl);
                              }

                              psDEToolbarItemList.add(psDETBUIActionItemImpl);
                           }
                        }
                     }

                     for (IPSDEToolbarItem iPSDEToolbarItem : psDEToolbarItemList) {
                        this.psDEContextMenuItemList.add((IPSDEContextMenuItem)iPSDEToolbarItem);
                     }

                     ActionSessionManager.getCurrentSession().unregisterRecursion("PSUIAction", strRecursionId);
                     if (bClose) {
                        ActionSessionManager.closeSession();
                     }
                  } catch (Exception ex) {
                     if (!StringHelper.IsNullOrEmpty(strRecursionId)) {
                        ActionSessionManager.getCurrentSession().unregisterRecursion("PSUIAction", strRecursionId);
                     }

                     if (bClose) {
                        ActionSessionManager.closeSession();
                     }

                     throw ex;
                  }
               }
            } else {
               PSDEToolbarItem psDEToolbarItem = new PSDEToolbarItem();
               this.psDEToolbarItem.CopyTo(psDEToolbarItem, false);
               psDEToolbarItem.setTBITEMTYPE("ITEMS");
               psDEToolbarItem.setPSDEUIACTIONID(null);
               psDEToolbarItem.setPSDEUIACTIONNAME(null);
               psDEToolbarItem.setSHOWMODE(this.getPSDEToolbarItemData().getSHOWMODE());
               psDEToolbarItem.setPSDEUAGROUPID(iPSUIActionGroup.getId());
               psDEToolbarItem.setPSDEUAGROUPNAME(iPSUIActionGroup.getName());
               PSDETBGroupItemImpl psDETBGroupItemImpl = new PSDETBGroupItemImpl();
               psDETBGroupItemImpl.init(this.getDAGlobalHelper(), this.getPSDEToolbar(), this.getParentPSDEToolbarItem(), psDEToolbarItem);
               psDEToolbarItemList.add(psDETBGroupItemImpl);
            }
         }
      }
   }

   @PSModelRTMeta(
      description = "子项集合",
      modeltype = "SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItemAll",
      hideempty2 = true,
      child = true,
      outputdoc = "false"
   )
   @Override
   public Iterator<IPSDEToolbarItem> getPSDEToolbarItems() throws Exception {
      ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
      return psDEToolbarItemList != null ? psDEToolbarItemList.iterator() : emptyPSDEToolbarItemList.iterator();
   }

   @Override
   public IPSDEUIAction getPSDEUIAction() {
      return this.getPSUIAction() instanceof IPSDEUIAction ? (IPSDEUIAction)this.getPSUIAction() : null;
   }

   @Override
   public IPSWFUIAction getPSWFUIAction() {
      return this.getPSUIAction() instanceof IPSWFUIAction ? (IPSWFUIAction)this.getPSUIAction() : null;
   }

   @Override
   public IPSAppView getPSAppView() {
      if (this.getPSDEToolbar() != null) {
         return this.getPSDEToolbar().getPSAppView();
      } else {
         return this.getPSDEContextMenu() != null ? this.getPSDEContextMenu().getPSAppView() : null;
      }
   }

   @PSModelRTMeta(description = "界面行为对象", child = true, fields = "PSDEUIACTIONID", doc = "除了显式指定界面行为，其它类型{@link PSDETBItemDTO#FIELD_BTNACTIONTYPE}也会被仿真为界面行为")
   @Override
   public IPSUIAction getPSUIAction() {
      return this.iPSUIAction;
   }

   @Override
   public void setPSUIAction(IPSUIAction iPSUIAction) {
      this.iPSUIAction = iPSUIAction;
   }

   @Override
   protected String onGetCaption() {
      return this.getPSUIAction() != null ? this.getPSUIAction().getCaption(this.getPSAppView().getLanguage()) : super.onGetCaption();
   }

   @Override
   protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
      super.onFillRelatedPSAppViews(relatedAppViewList);
      if (this.getPSDEUIAction() != null) {
         IPSAppView refPSAppView = this.getPSDEUIAction().getFrontPSAppView(this);
         if (refPSAppView != null) {
            relatedAppViewList.add(refPSAppView);
         }
      } else if (this.getPSWFUIAction() != null) {
         IPSAppView refPSAppView = this.getPSWFUIAction().getFrontPSAppView(this);
         if (refPSAppView != null) {
            relatedAppViewList.add(refPSAppView);
         }
      }
   }

   @PSModelRTMeta(description = "启用", ignoredumpvalues = "true")
   @Override
   public boolean isValid() throws Exception {
      if (this.getPSUIAction() != null && this.getPSUIAction().isUIActionGroup(this)) {
         if (this.getPSUIAction().isEnableUIActionGroupExMode(this)) {
            return true;
         }

         ArrayList<IPSDEToolbarItem> psDEToolbarItemList = this.getPSDEToolbarItemList(false);
         return psDEToolbarItemList != null && psDEToolbarItemList.size() > 0;
      } else if (this.getPSDEUIAction() != null) {
         return this.getPSDEUIAction().isValid(this);
      } else {
         return this.getPSWFUIAction() != null ? this.getPSWFUIAction().isValid(this) : true;
      }
   }

   @PSModelRTMeta(description = "图标资源对象", fields = "PSSYSIMAGEID")
   @Override
   public IPSSysImage getPSSysImage() {
      return super.getPSSysImage() == null && this.getPSUIAction() != null ? this.getPSUIAction().getPSSysImage() : super.getPSSysImage();
   }

   @PSModelRTMeta(description = "工具提示", fields = "TOOLTIPINFO")
   @Override
   public String getTooltip() {
      String strTooltipInfo = this.psDEToolbarItem.getTOOLTIPINFO();
      if (!StringHelper.IsNullOrEmpty(strTooltipInfo)) {
         return strTooltipInfo;
      }

      if (this.getPSUIAction() != null) {
         strTooltipInfo = this.getPSUIAction().getTooltip(this.getPSAppView().getLanguage());
      }

      return StringHelper.IsNullOrEmpty(strTooltipInfo) ? this.getCaption() : strTooltipInfo;
   }

   @PSModelRTMeta(description = "启用点击切换模式", ignoredumpvalues = "false")
   @Override
   public boolean isEnableToggleMode() {
      return this.getPSUIAction() != null ? this.getPSUIAction().isEnableToggleMode() : false;
   }

   @Override
   public JSONObject getUIActionParamJO() {
      return this.uiActionParamJO;
   }

   @Override
   public Iterator<IPSDEContextMenuItem> getPSDEContextMenuItems() throws Exception {
      return this.psDEContextMenuItemList != null ? this.psDEContextMenuItemList.iterator() : emptyPSDEContextMenuItemList.iterator();
   }

   @PSModelRTMeta(description = "标题语言资源", fields = "CAPPSLANRESID")
   @Override
   public IPSLanguageRes getCapPSLanguageRes() {
      return super.getCapPSLanguageRes() == null && this.getPSUIAction() != null ? this.getPSUIAction().getCapPSLanguageRes() : super.getCapPSLanguageRes();
   }

   @PSModelRTMeta(description = "提示语言资源", fields = "TIPPSLANRESID")
   @Override
   public IPSLanguageRes getTooltipPSLanguageRes() {
      return super.getTooltipPSLanguageRes() == null && this.getPSUIAction() != null
         ? this.getPSUIAction().getTooltipPSLanguageRes()
         : super.getTooltipPSLanguageRes();
   }

   @PSModelRTMeta(description = "是否隐藏", ignoredumpvalues = "false", fields = "HIDDENITEM")
   @Override
   public boolean isHiddenItem() {
      return this.bHiddenItem;
   }

   @PSModelRTMeta(description = "无权限显示模式", codelist = "BtnNoPrivDisplayMode", fields = "NOPRIVDM")
   @Override
   public int getNoPrivDisplayMode() {
      return this.nNoPrivDisplayMode;
   }

   @PSModelRTMeta(description = "界面行为组展开模式", ignorert = 3, codelist = "UGExtractMode", fields = "GROUPEXTRACTMODE")
   @Override
   public String getGroupExtractMode() {
      return this.strGroupExtractMode;
   }

   @PSModelRTMeta(description = "前端打开视图", hideempty = true)
   @Override
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
      } catch (Exception ex) {
         this.error(String.format("计算工具栏引用部件发生异常，%1$s", ex.getMessage()));
         return null;
      }

      if (this.getOwner() instanceof IPSControl) {
         return ((IPSControl)this.getOwner()).getName();
      } else if (this.getOwner() instanceof IPSControlObject) {
         return ((IPSControlObject)this.getOwner()).getOwnedPSControl().getName();
      } else {
         return this.getOwner() instanceof IPSAppDEXDataView ? ((IPSAppDEXDataView)this.getOwner()).getXDataControlName() : null;
      }
   }

   @Override
   public IPSControl getXDataPSControl() throws Exception {
      try {
         IPSControl refPSControl = this.getOwnedPSControl().getRefPSControl();
         if (refPSControl != null) {
            return refPSControl;
         }
      } catch (Exception ex) {
         this.error(String.format("计算工具栏引用部件发生异常，%1$s", ex.getMessage()));
         return null;
      }

      if (this.getOwner() instanceof IPSControl) {
         return (IPSControl)this.getOwner();
      } else if (this.getOwner() instanceof IPSControlObject) {
         return ((IPSControlObject)this.getOwner()).getOwnedPSControl();
      } else {
         return this.getOwner() instanceof IPSAppDEXDataView ? ((IPSAppDEXDataView)this.getOwner()).getXDataPSControl() : null;
      }
   }

   protected void registerPSAppViewLogic() throws Exception {
      if (this.getPSAppView().getPSPFStyle().getPFEngineVer() >= 20) {
         String strCtrlName = null;
         if (this.getPSDEToolbar() != null) {
            strCtrlName = this.getPSDEToolbar().getName();
         } else if (this.getPSDEContextMenu() != null) {
            strCtrlName = this.getPSDEContextMenu().getName();
         }

         String strLogicTag = StringHelper.Format("%1$s_%2$s_click", strCtrlName, this.getName()).toLowerCase();
         PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
         psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
         psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
         psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
         psAppViewLogic.setPSAPPVIEWLOGICTYPE("CTRLEVENT");
         psAppViewLogic.setPSAPPVIEWCTRLNAME(strCtrlName);
         psAppViewLogic.setEVENTNAMES("CLICK");
         psAppViewLogic.setEVENTARG(this.getName());
         PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
         psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this.getPSControlContainer(), psAppViewLogic, this.psAppViewUIActionProxy);
         this.getPSControlContainer().registerPSAppViewLogic(psAppDEViewLogicImpl);
      }
   }

   @Override
   public Class<?> getModelClass(String strModelType) {
      return StringHelper.Compare(strModelType, "PSAPPVIEWUIACTION", true) == 0 ? IPSAppViewUIAction.class : super.getModelClass(strModelType);
   }

   @PSModelRTMeta(description = "行为级别", codelist = "UIActionLevel", ignoredumpvalues = "100", fields = "ACTIONLEVEL")
   @Override
   public int getActionLevel() {
      return this.nActionLevel;
   }

   @Override
   public boolean isSaveTargetFirst() {
      if (this.getPSDEUIAction() != null) {
         return this.getPSDEUIAction().isSaveTargetFirst();
      } else {
         return this.getPSWFUIAction() != null ? this.getPSWFUIAction().isSaveTargetFirst() : false;
      }
   }

   @PSModelRTMeta(description = "界面行为操作目标", codelist = "DEUIActionDataRange")
   @Override
   public String getUIActionTarget() {
      if (this.getPSDEUIAction() != null) {
         return this.getPSDEUIAction().getActionTarget();
      } else {
         return this.getPSWFUIAction() != null ? this.getPSWFUIAction().getActionTarget() : "NONE";
      }
   }

   @Override
   public IPSAppCounterRef getPSAppCounterRef() {
      return this.iPSAppCounterRef;
   }

   @Override
   public void setPSAppCounterRef(IPSAppCounterRef iPSAppCounterRef) {
      this.iPSAppCounterRef = iPSAppCounterRef;
   }

   @PSModelRTMeta(description = "应用视图界面行为", dumpref = true)
   @Override
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

   @PSModelRTMeta(description = "边框样式", codelist = "BorderStyle", fields = "BORDERSTYLE")
   @Override
   public String getBorderStyle() {
      return this.psDEToolbarItem.getBORDERSTYLE();
   }

   @PSModelRTMeta(description = "按钮样式", codelist = "ButtonStyle", fields = "ITEMSTYLE")
   @Override
   public String getButtonStyle() {
      String strItemStyle = this.psDEToolbarItem.getITEMSTYLE();
      if (StringHelper.IsNullOrEmpty(strItemStyle) && this.getPSUIAction() != null) {
         strItemStyle = this.getPSUIAction().getButtonStyle();
      }

      return !StringHelper.IsNullOrEmpty(strItemStyle) ? strItemStyle : this.getItemStyle();
   }

   @Override
   protected String onGetCounterId() {
      return StringHelper.IsNullOrEmpty(super.onGetCounterId()) && this.getPSUIAction() != null ? this.getPSUIAction().getCounterId() : super.onGetCounterId();
   }
}
