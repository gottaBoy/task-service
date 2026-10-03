package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTO;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodDTOField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethodReturn;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERNN;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroup;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroupDetail;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeFieldColumnImpl extends PSDETreeNodeColumnImpl implements IPSDETreeNodeFieldColumn, IPSDETreeNodeEditItem {
   private static final Log log = LogFactory.getLog(PSDETreeNodeFieldColumnImpl.class);
   protected IPSDEFGridColumn iPSDEFGridColumn = null;
   protected IPSDEField iPSDEField = null;
   private IPSAppDEField iPSAppDEField = null;
   protected String strPSCodeListId = "";
   protected IPSCodeList iPSCodeList = null;
   private String strValueFormat = "";
   private String[] fields = null;
   protected String strEditorType = "";
   protected String strEditorStyle = "";
   private boolean bEditable = false;
   private boolean bRowEditable = false;
   private Properties editorParams = null;
   private boolean bDefineEditorType = false;
   protected boolean bHidden = false;
   private IPSEditorType iPSEditorType = null;
   protected boolean bAllowEmpty = true;
   private String strValueProcessor = "";
   private String strResetItemName = null;
   private String strPlaceHolder = null;
   private IPSSysEditorStyle iPSSysEditorStyle = null;
   private String strPSSysValueRuleId = null;
   private int nIgnoreInput = 0;
   private int nEnableCond = 3;
   private String strCreateDVT = "";
   private String strCreateDV = "";
   private String strUpdateDVT = "";
   private String strUpdateDV = "";
   private String strEditorCssStyle = "";
   private ArrayList<String> resetItemNameList = null;
   private ArrayList<String> valueItemNameList = null;
   private boolean bNeedCodeListConfig = false;
   private int nOutputCodeListConfigMode = 0;
   private String strValueItemName = "";
   private boolean bEnableItemPriv = false;
   private String strItemPrivId = null;
   protected PSDataItemImpl psDataItemImpl = new PSDataItemImpl();
   protected ArrayList<IPSDETreeNodeDataItem> psDETreeNodeDataItemList = null;
   private String strDataItemName = null;
   private String strItemHandlerType = null;
   private IPSDEUIAction iPSDEUIAction = null;
   private String strCLConvertMode = null;
   private IPSEditor iPSEditor = null;
   private int nEnableLink = 2;
   private IPSAppView linkPSAppView = null;
   private boolean bEnableLinkView = false;
   private String strPSSysDictCatId = "";
   private String strUnitName = null;
   private int nUnitNameWidth = 0;
   private boolean bEnableUnitName = false;
   private IPSDEUIActionGroup iPSDEUIActionGroup = null;

   @Override
   protected void onInit() throws Exception {
      if (StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPSDEFID())) {
         throw new Exception(StringHelper.Format("树表格属性列[%1$s]没有指定实体属性", this.getName()));
      }

      boolean bUseDTO = false;
      if (this.getPSDETree().getPSAppView() != null && this.getPSDETree().getPSAppView().getPSApplication() != null) {
         bUseDTO = this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi();
      }

      if (!bUseDTO) {
         if (this.getPSSystemSetting() != null) {
            this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
         }
      } else {
         this.psDataItemImpl.setFormat("");
      }

      if (this.getPSDETreeNode().getPSDataEntity() == null) {
         throw new Exception("树节点没有指定实体对象");
      }

      this.iPSDEField = this.getPSDETreeNode().getPSDataEntity().getPSDEField(this.psDETreeNodeColumn.getPSDEFID(), false);
      if (this.iPSDEField != null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
         this.iPSAppDEField = this.getPSDETreeNode().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
      }

      IPSDEFUIMode iPSDEFUIMode = null;
      if (StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPSDEFUIMODEID())) {
         String strDEFUIMode = StringHelper.Format("APPDEFAULT:%1$s", this.getPSDETree().getPSAppView().getPSApplication().getId());
         iPSDEFUIMode = this.getPSDEField().getPSDEFUIMode(strDEFUIMode, true);
         if (iPSDEFUIMode == null) {
            iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode("DEFAULT");
         }
      } else {
         iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode(this.psDETreeNodeColumn.getPSDEFUIMODEID());
      }

      this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
      if (!this.psDETreeNodeColumn.isENABLELINKNull()) {
         this.nEnableLink = this.psDETreeNodeColumn.getENABLELINK();
      } else if (this.getPSDETreeColumn() != null) {
         this.nEnableLink = this.getPSDETreeColumn().getEnableLink();
      }

      this.strPSCodeListId = this.psDETreeNodeColumn.getPSCODELISTID();
      this.strCLConvertMode = this.psDETreeNodeColumn.getCLCONVERTMODE();
      if (this.iPSDEFGridColumn != null) {
         if (StringHelper.IsNullOrEmpty(this.strPSCodeListId)) {
            this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
         }

         if (StringHelper.IsNullOrEmpty(this.strCLConvertMode)) {
            this.strCLConvertMode = this.iPSDEFGridColumn.getCLConvertMode();
         }

         if (this.getRenderPSSysPFPlugin() == null) {
            this.setRenderPSSysPFPlugin(this.iPSDEFGridColumn.getRenderPSSysPFPlugin());
         }
      }

      if (StringHelper.Compare(this.getCLConvertMode(), "NONE", true) == 0) {
         this.strPSCodeListId = "";
      }

      if (!StringHelper.IsNullOrEmpty(this.getPSCodeListId())) {
         this.iPSCodeList = this.getPSDETreeNode().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
         if (this.iPSCodeList != null) {
            this.iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
         }

         if (StringHelper.IsNullOrEmpty(this.getCLConvertMode())) {
            if (this.getPSDETree().getPSAppView().getPSApplication().isUseServiceApi()) {
               this.strCLConvertMode = "FRONT";
            } else if (!this.iPSCodeList.isEnableDynaSys() && StringHelper.Compare(this.iPSCodeList.getCodeListType(), "DYNAMIC", true) != 0) {
               this.strCLConvertMode = "FRONT";
            } else {
               this.strCLConvertMode = "BACKEND";
            }
         }
      }

      if (this.iPSCodeList == null) {
         this.strCLConvertMode = "NONE";
      }

      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getVALUEFORMAT())) {
         this.strValueFormat = this.psDETreeNodeColumn.getVALUEFORMAT();
      }

      if (StringHelper.IsNullOrEmpty(this.strValueFormat) && this.iPSDEFGridColumn != null) {
         if (!bUseDTO) {
            this.strValueFormat = this.iPSDEFGridColumn.getValueFormat();
         } else {
            this.strValueFormat = this.iPSDEFGridColumn.getOriginValueFormat();
         }
      }

      if (StringHelper.IsNullOrEmpty(this.strValueFormat) && bUseDTO && this.iPSAppDEField != null) {
         this.strValueFormat = this.iPSAppDEField.getValueFormat();
      }

      this.editorParams = PropertiesHelper.load(this.psDETreeNodeColumn.getEDITORPARAMS());
      if (!this.psDETreeNodeColumn.isENABLEROWEDITNull() && (this.psDETreeNodeColumn.getENABLEROWEDIT() & 1) == 1) {
         this.bRowEditable = true;
         this.strEditorType = this.psDETreeNodeColumn.getEDITORTYPE();
         this.strEditorStyle = this.psDETreeNodeColumn.getPSSYSEDITORSTYLEID();
         if (!StringHelper.IsNullOrEmpty(this.strEditorType)) {
            this.bDefineEditorType = true;
         }

         String strItemPSACHandlerId = null;
         if (this.getPSDEFGridColumn() != null) {
            strItemPSACHandlerId = this.getPSDEFGridColumn().getPSAjaxHandlerId();
            boolean bAppendParam = false;
            if (StringHelper.IsNullOrEmpty(this.strEditorType)) {
               this.strEditorType = this.iPSDEFGridColumn.getEditorType();
               bAppendParam = true;
            } else if (StringHelper.Compare(this.strEditorType, this.iPSDEFGridColumn.getEditorType(), true) == 0) {
               bAppendParam = true;
            }

            if (bAppendParam) {
               for (Object objKey : this.iPSDEFGridColumn.getEditorParams().keySet()) {
                  if (!this.editorParams.containsKey(objKey)) {
                     this.editorParams.put(objKey, this.iPSDEFGridColumn.getEditorParams().get(objKey));
                  }
               }
            }

            if (StringHelper.IsNullOrEmpty(this.strEditorStyle)) {
               this.strEditorStyle = this.iPSDEFGridColumn.getEditorStyle();
            }
         }

         if (this.isDesignMode() && StringHelper.Compare(this.getEditorType(), "USERCONTROL", true) == 0) {
            this.strEditorType = "SPAN";
            this.bDefineEditorType = true;
            this.strEditorStyle = "";
         }

         if (StringHelper.IsNullOrEmpty(this.strEditorType)) {
            this.strEditorType = "TEXTBOX";
            if (this.getPSDETree().getPSAppView() != null
               && this.getPSDETree().getPSAppView().getPSApplication() != null
               && this.getPSDETree().getPSAppView().getPSApplication().isMobileApp()) {
               this.strEditorType = "MOBTEXT";
            }
         }

         this.bHidden = StringHelper.Compare(this.strEditorType, "HIDDEN", true) == 0;
         if (!StringHelper.IsNullOrEmpty(this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
               this.bAllowEmpty = true;
            }

            this.strValueProcessor = this.iPSEditorType.getValueProcessor();
            if (!StringHelper.IsNullOrEmpty(this.strEditorStyle)) {
               this.iPSSysEditorStyle = this.getPSDETree().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "GRIDCOLUMN");
            } else if (!this.isDesignMode()) {
               this.iPSSysEditorStyle = this.getPSDETree().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "GRIDCOLUMN");
            }

            if (this.getPSSysEditorStyle() != null) {
               this.strItemHandlerType = this.getPSSysEditorStyle().getAjaxHandlerType();
               if (StringHelper.IsNullOrEmpty(strItemPSACHandlerId)) {
                  strItemPSACHandlerId = this.getPSSysEditorStyle().getPSAjaxHandlerId();
               }

               for (Object objKey : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                  if (!this.editorParams.containsKey(objKey)) {
                     this.editorParams.put(objKey, this.getPSSysEditorStyle().getEditorParams().get(objKey));
                  }
               }
            }

            if (StringHelper.IsNullOrEmpty(this.strItemHandlerType)) {
               this.strItemHandlerType = this.getPSEditorType().getAjaxHandlerType();
            }

            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
               if (!this.editorParams.containsKey(objKey)) {
                  this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
               }
            }
         }

         if (!this.psDETreeNodeColumn.isENABLECONDNull()) {
            this.nEnableCond = this.psDETreeNodeColumn.getENABLECOND();
         } else if (this.iPSDEFGridColumn != null) {
            this.nEnableCond = this.iPSDEFGridColumn.getEnableCond();
         }

         this.strPSCodeListId = this.psDETreeNodeColumn.getPSCODELISTID();
         if (StringHelper.IsNullOrEmpty(this.strPSCodeListId) && this.iPSDEFGridColumn != null) {
            this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
         }

         if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPLACEHOLDER())) {
            this.strPlaceHolder = this.psDETreeNodeColumn.getPLACEHOLDER();
         } else if (this.getPSDEFGridColumn() != null) {
            this.strPlaceHolder = this.getPSDEFGridColumn().getPlaceHolder();
         }

         if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPSSYSDICTCATID())) {
            this.strPSSysDictCatId = this.psDETreeNodeColumn.getPSSYSDICTCATID();
         } else if (this.getPSDEFGridColumn() != null) {
            this.strPSSysDictCatId = this.getPSDEFGridColumn().getPSSysDictCatId();
         }

         if (this.iPSDEFGridColumn != null) {
            this.strPSSysValueRuleId = this.iPSDEFGridColumn.getPSSysValueRuleId();
         }

         if (this.iPSDEFGridColumn != null) {
            this.iPSDEFGridColumn.getPSGEIDEFValueRules();
         }

         if (!StringHelper.IsNullOrEmpty(this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDETreeNode().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
            if (this.iPSCodeList != null) {
               this.iPSCodeList = this.getPSDETree().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
            }
         }

         this.strCreateDVT = this.psDETreeNodeColumn.getCREATEDVT();
         this.strCreateDV = this.psDETreeNodeColumn.getCREATEDV();
         this.strUpdateDVT = this.psDETreeNodeColumn.getUPDATEDVT();
         this.strUpdateDV = this.psDETreeNodeColumn.getUPDATEDV();
         if (this.iPSDEFGridColumn != null) {
            if (StringHelper.IsNullOrEmpty(this.strCreateDVT)) {
               this.strCreateDVT = this.iPSDEFGridColumn.getCreateDVT();
            }

            if (StringHelper.IsNullOrEmpty(this.strCreateDV)) {
               this.strCreateDV = this.iPSDEFGridColumn.getCreateDV();
            }

            if (StringHelper.IsNullOrEmpty(this.strUpdateDVT)) {
               this.strUpdateDVT = this.iPSDEFGridColumn.getUpdateDVT();
            }

            if (StringHelper.IsNullOrEmpty(this.strUpdateDV)) {
               this.strUpdateDV = this.iPSDEFGridColumn.getUpdateDV();
            }
         }

         if (!this.psDETreeNodeColumn.isIGNOREINPUTNull()) {
            this.nIgnoreInput = this.psDETreeNodeColumn.getIGNOREINPUT();
         } else if (this.iPSDEFGridColumn != null) {
            this.nIgnoreInput = this.iPSDEFGridColumn.getIgnoreInput();
         }

         if (this.isConvertToCodeItemText()) {
            this.nIgnoreInput = 3;
         }

         if (!this.isDesignMode()) {
            if (!this.psDETreeNodeColumn.isNEEDCODELISTCONFIGNull()) {
               this.bNeedCodeListConfig = this.psDETreeNodeColumn.getNEEDCODELISTCONFIG();
            } else {
               this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
               if (this.getPSDEFGridColumn() != null && StringHelper.Compare(this.strEditorType, this.getPSDEFGridColumn().getEditorType(), true) == 0) {
                  this.bNeedCodeListConfig = this.getPSDEFGridColumn().isNeedCodeListConfig();
               }
            }

            if (!this.psDETreeNodeColumn.isCODELISTCONFIGMODENull()) {
               this.nOutputCodeListConfigMode = this.psDETreeNodeColumn.getCODELISTCONFIGMODE();
            } else {
               this.nOutputCodeListConfigMode = this.getPSEditorType().getOutputCodeListConfigMode();
               if (this.getPSDEFGridColumn() != null && StringHelper.Compare(this.strEditorType, this.getPSDEFGridColumn().getEditorType(), true) == 0) {
                  this.nOutputCodeListConfigMode = this.getPSDEFGridColumn().getOutputCodeListConfigMode();
               }
            }
         }

         this.strEditorCssStyle = this.calcEditorCssStyle();
         String strValueItemName = this.psDETreeNodeColumn.getVALUEITEMNAME();
         if (StringHelper.IsNullOrEmpty(strValueItemName) && this.iPSDEFGridColumn != null) {
            strValueItemName = this.iPSDEFGridColumn.getValueItemName(this);
         }

         if (!StringHelper.IsNullOrEmpty(strValueItemName)) {
            this.valueItemNameList = new ArrayList<>();
            String[] items = StringHelper.SplitEx(strValueItemName);
            String[] var9 = items;
            int var8 = items.length;

            for (int strItem = 0; strItem < var8; strItem++) {
               String strItemx = var9[strItem];
               strItemx = strItemx.trim();
               if (!this.valueItemNameList.contains(strItemx)) {
                  this.valueItemNameList.add(strItemx);
               }
            }

            if (this.valueItemNameList.size() > 0) {
               this.strValueItemName = this.valueItemNameList.get(0);
            }
         }

         String strResetItemName = this.psDETreeNodeColumn.getRESETITEMNAME();
         if (StringHelper.IsNullOrEmpty(strResetItemName) && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
            strResetItemName = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
         }

         if (!StringHelper.IsNullOrEmpty(strResetItemName)) {
            this.resetItemNameList = new ArrayList<>();
            String[] items = StringHelper.SplitEx(strResetItemName);
            String[] var10 = items;
            int var34 = items.length;

            for (int var33 = 0; var33 < var34; var33++) {
               String strItem = var10[var33];
               strItem = strItem.trim();
               if (!this.resetItemNameList.contains(strItem)) {
                  this.resetItemNameList.add(strItem);
               }
            }

            if (this.resetItemNameList.size() > 0) {
               this.strResetItemName = this.resetItemNameList.get(0);
            }
         }

         if (!this.psDETreeNodeColumn.isALLOWEMPTYNull()) {
            this.bAllowEmpty = this.psDETreeNodeColumn.getALLOWEMPTY();
         } else if (!this.bHidden && this.iPSDEFGridColumn != null && this.bAllowEmpty) {
            this.bAllowEmpty = this.iPSDEFGridColumn.getAllowEmpty(this);
         }

         if (!this.bAllowEmpty && this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getPSDEField().isKeyDEField()) {
            this.bAllowEmpty = true;
         }

         this.getRefPickupPSAppView();
         this.getRefLinkPSAppView();
      }

      if (this.iPSDEField != null) {
         this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
      }

      if (!this.psDETreeNodeColumn.isENABLEITEMPRIVNull()) {
         this.bEnableItemPriv = this.psDETreeNodeColumn.getENABLEITEMPRIV();
      }

      if (this.bEnableItemPriv && this.iPSDEField != null) {
         this.strItemPrivId = StringHelper.Format("%1$s|%2$s", this.iPSDEField.getPSDataEntity().getName(), this.iPSDEField.getName());
      }

      this.psDETreeNodeDataItemList = this.iPSDEFGridColumn.getPSDETreeNodeDataItems(this);
      this.strDataItemName = this.iPSDEFGridColumn.getDataItemName(this);
      if (this.getEnableLink() == 1) {
         IPSAppView linkPSAppView = this.onGetLinkPSAppView(false);
         if (linkPSAppView == null) {
            throw new Exception("表格列启用链接，但没有指定链接视图");
         }

         this.bEnableLinkView = true;
         this.linkPSAppView = linkPSAppView;
      } else if (this.getEnableLink() == 2) {
         IPSAppView linkPSAppView = this.onGetLinkPSAppView(true);
         if (linkPSAppView != null) {
            this.bEnableLinkView = true;
            this.linkPSAppView = linkPSAppView;
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPSDEUIACTIONID())) {
         if (this.iPSDEUIAction == null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
            this.iPSDEUIAction = this.getPSDETreeNode()
               .getPSAppDataEntity()
               .getPSAppDEUIAction(this.psDETreeNodeColumn.getPSDEUIACTIONID(), true, this.getOwnedPSControl());
         }

         if (this.iPSDEUIAction == null) {
            this.iPSDEUIAction = this.getPSDETreeNode().getPSDataEntity().getPSDEUIAction(this.psDETreeNodeColumn.getPSDEUIACTIONID());
         }

         if (this.getPSDETree().isPrepareTemplV2logic()) {
            IPSAppViewUIAction iPSAppViewUIAction = new PSAppViewUIActionProxy(this, this.iPSDEUIAction, this.getPSDETree());
            this.getPSDETree().registerPSAppViewUIAction(iPSAppViewUIAction);
            this.registerPSAppViewLogic(iPSAppViewUIAction);
         } else {
            this.getPSDETree().getPSAppView().registerPSUIAction(this.iPSDEUIAction);
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getPSDEUAGROUPID())) {
         if (this.iPSDEUIActionGroup == null && this.getPSDETreeNode().getPSAppDataEntity() != null) {
            this.iPSDEUIActionGroup = this.getPSDETreeNode()
               .getPSAppDataEntity()
               .getPSAppDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID(), true, this.getOwnedPSControl());
         }

         if (this.iPSDEUIActionGroup == null) {
            this.iPSDEUIActionGroup = this.getPSDETreeNode().getPSDataEntity().getPSDEUIActionGroup(this.psDETreeNodeColumn.getPSDEUAGROUPID());
         }

         Iterator<IPSUIActionGroupDetail> psUIActionGroupDetails = this.iPSDEUIActionGroup.getPSUIActionGroupDetails();
         if (psUIActionGroupDetails != null) {
            while (psUIActionGroupDetails.hasNext()) {
               IPSUIActionGroupDetail iPSUIActionGroupDetail = psUIActionGroupDetails.next();
               IPSUIAction iPSUIAction = iPSUIActionGroupDetail.getPSUIAction();
               if (iPSUIAction != null) {
                  if (this.getPSDETree().isPrepareTemplV2logic()) {
                     IPSAppViewUIAction iPSAppViewUIAction = new PSAppViewUIActionProxy(this, iPSUIAction, this.getPSDETree());
                     this.getPSDETree().registerPSAppViewUIAction(iPSAppViewUIAction);
                     this.registerPSAppViewLogic(iPSAppViewUIAction, iPSUIActionGroupDetail);
                  } else {
                     this.getPSDETree().getPSAppView().registerPSUIAction(iPSUIAction);
                  }
               }
            }
         }
      }

      this.bEnableUnitName = true;
      if (this.iPSDEFGridColumn != null) {
         if (StringHelper.IsNullOrEmpty(this.strUnitName)) {
            this.strUnitName = this.iPSDEFGridColumn.getUnitName();
         }

         if (this.nUnitNameWidth <= 0) {
            this.nUnitNameWidth = this.iPSDEFGridColumn.getUnitNameWidth();
         }
      }

      if (StringHelper.IsNullOrEmpty(this.strUnitName)) {
         this.bEnableUnitName = false;
      }

      super.onInit();
      this.preparePSEditor();
   }

   protected void preparePSEditor() throws Exception {
      this.getPSEditor();
   }

   @PSModelRTMeta(description = "列数据项集合", outputdoc = "false")
   @Override
   public Iterator<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems() {
      return this.psDETreeNodeDataItemList.iterator();
   }

   @PSModelRTMeta(description = "列数据项名称")
   @Override
   public String getDataItemName() {
      return this.strDataItemName;
   }

   @PSModelRTMeta(description = "列实体属性", outputdoc = "false")
   @Override
   public IPSDEField getPSDEField() {
      return this.iPSDEField;
   }

   @PSModelRTMeta(description = "列应用实体属性", dumpref = true, fields = "PSDEFID")
   @Override
   public IPSAppDEField getPSAppDEField() {
      return this.iPSAppDEField;
   }

   @PSModelRTMeta(description = "代码表对象", hideempty = true, dump = false)
   @Override
   public IPSCodeList getPSCodeList() {
      return this.iPSCodeList;
   }

   @PSModelRTMeta(description = "应用代码表", hideempty = true, dumpref = true, fields = "PSCODELISTID")
   @Override
   public IPSAppCodeList getPSAppCodeList() {
      return this.getPSCodeList() != null && this.getPSCodeList() instanceof IPSAppCodeList ? (IPSAppCodeList)this.getPSCodeList() : null;
   }

   @Override
   public String getPSCodeListId() {
      return this.strPSCodeListId;
   }

   @PSModelRTMeta(description = "值格式化", fields = "VALUEFORMAT")
   @Override
   public String getValueFormat() {
      return this.strValueFormat;
   }

   @Override
   public String[] getFields() {
      return this.fields;
   }

   protected String calcEditorCssStyle() throws Exception {
      StringBuilderEx editorCssStyle = new StringBuilderEx();
      return editorCssStyle.toString();
   }

   @PSModelRTMeta(description = "编辑器类型", dump = false)
   @Override
   public String getEditorType() {
      return this.strEditorType;
   }

   @PSModelRTMeta(description = "编辑器样式", dump = false)
   @Override
   public String getEditorStyle() {
      return this.getPSSysEditorStyle() != null && this.getPSDETree().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()
         ? this.getPSSysEditorStyle().getStyleCode()
         : this.strEditorStyle;
   }

   @PSModelRTMeta(description = "允许空值输入", fields = "ALLOWEMPTY")
   @Override
   public boolean isAllowEmpty() {
      return this.isEditable() ? this.bAllowEmpty : true;
   }

   @PSModelRTMeta(description = "值项名称", fields = "VALUEITEMNAME", ignorert = 3)
   @Override
   public String getValueItemName() {
      return this.strValueItemName;
   }

   public IPSDEFGridColumn getPSDEFGridColumn() {
      return this.iPSDEFGridColumn;
   }

   protected void setPSDEFGridColumn(IPSDEFGridColumn iPSDEFGridColumn) {
      this.iPSDEFGridColumn = iPSDEFGridColumn;
   }

   @Override
   public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
      super.fillRelatedPSAppViews(relatedAppViewList);
      IPSAppView iPSAppView = this.getRefPickupPSAppView();
      if (iPSAppView != null) {
         relatedAppViewList.add(iPSAppView);
      }

      iPSAppView = this.getRefLinkPSAppView();
      if (iPSAppView != null) {
         relatedAppViewList.add(iPSAppView);
      }

      if (this.getPSDEUIAction() != null && this.getPSDEUIAction().getFrontPSAppView(this) != null) {
         relatedAppViewList.add(this.getPSDEUIAction().getFrontPSAppView(this));
      }
   }

   @PSModelRTMeta(description = "引用选择视图", hideempty = true)
   @Override
   public IPSAppView getRefPickupPSAppView() throws Exception {
      if (this.getPSDETreeNode().isEnableRowEdit() && this.isEnableRowEdit()) {
         String strPickupPSDEViewId = this.psDETreeNodeColumn.getPICKUPPSDEVIEWID();
         if (StringHelper.IsNullOrEmpty(strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFGridColumn != null) {
            strPickupPSDEViewId = this.iPSDEFGridColumn.getRefPickupPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
         }

         if (!StringHelper.IsNullOrEmpty(strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId(this.getPSDETree().getPSAppView().getPSApplication().getId(), strPickupPSDEViewId);
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDETree().getPSAppView());
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "引用数据链接视图", hideempty = true)
   @Override
   public IPSAppView getRefLinkPSAppView() throws Exception {
      if (this.getPSDETreeNode().isEnableRowEdit() && this.isEnableRowEdit()) {
         String strLinkPSDEViewId = this.psDETreeNodeColumn.getLINKPSDEVIEWID();
         if (StringHelper.IsNullOrEmpty(strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFGridColumn != null) {
            strLinkPSDEViewId = this.iPSDEFGridColumn.getRefLinkPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
         }

         if (!StringHelper.IsNullOrEmpty(strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId(this.getPSDETree().getPSAppView().getPSApplication().getId(), strLinkPSDEViewId);
            return this.getPSDETree().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDETree().getPSAppView());
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "编辑项异步处理器类型", hideempty = true, dump = false)
   @Override
   public String getItemHandlerType() {
      if (!this.getPSDETreeNode().isEnableRowEdit() || !this.isEnableRowEdit()) {
         return "";
      } else if (!StringHelper.IsNullOrEmpty(this.strItemHandlerType)) {
         return StringHelper.Compare(this.strItemHandlerType, "None", true) == 0 ? "" : this.strItemHandlerType;
      } else if (this.iPSDEFGridColumn != null) {
         return this.iPSDEFGridColumn.getItemHandlerType(this);
      } else if (StringHelper.Compare(this.getPSEditorType().getStandardPSEditorType(), "DROPDOWNLIST", true) == 0
         && this.getPSCodeList() != null
         && StringHelper.Compare(this.getPSCodeList().getCodeListType(), "DYNAMIC", true) == 0) {
         return "CodeList";
      } else {
         return StringHelper.Compare(this.getPSEditorType().getStandardPSEditorType(), "AC", true) == 0 ? "AC" : "";
      }
   }

   @PSModelRTMeta(description = "启用条件", codelist = "FormItemEnableCond", fields = "ENABLECOND")
   @Override
   public int getEnableCond() {
      return this.nEnableCond;
   }

   @PSModelRTMeta(description = "建立默认值类型", codelist = "FieldDefaultValueType", fields = "CREATEDVT")
   @Override
   public String getCreateDVT() {
      return this.strCreateDVT;
   }

   @PSModelRTMeta(description = "建立默认值", fields = "CREATEDV")
   @Override
   public String getCreateDV() {
      return this.strCreateDV;
   }

   @PSModelRTMeta(description = "更新默认值类型", codelist = "FieldDefaultValueType", fields = "UPDATEDVT")
   @Override
   public String getUpdateDVT() {
      return this.strUpdateDVT;
   }

   @PSModelRTMeta(description = "更新默认值", fields = "UPDATEDV")
   @Override
   public String getUpdateDV() {
      return this.strUpdateDV;
   }

   @PSModelRTMeta(description = "支持编辑", dump = false)
   @Override
   public boolean isEditable() {
      return this.bEditable;
   }

   @PSModelRTMeta(description = "项参数", hideempty = true, dump = false)
   @Override
   public JSONObject getItemParam() throws Exception {
      return this.iPSDEFGridColumn != null ? this.iPSDEFGridColumn.getItemParam(this) : null;
   }

   @PSModelRTMeta(description = "引用实体数据集", hideempty = true)
   @Override
   public IPSDEDataSet getRefPSDEDataSet() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getREFPSDEID())) {
         IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
         if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getREFPSDEDATASETID())) {
            return refPSDataEntity.getPSDEDataSet(this.psDETreeNodeColumn.getREFPSDEDATASETID());
         } else {
            return this.getPSDETree().isRegisterToPSAppDataEntity() ? refPSDataEntity.getDefaultPSDEDataSet() : null;
         }
      } else {
         if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty(this.iPSDEFGridColumn.getRefPSDEDataSetId())) {
               return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFGridColumn.getRefPSDEDataSetId());
            }

            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
               return this.iPSDEFGridColumn.getRefPSDataEntity().getDefaultPSDEDataSet();
            }
         }

         return null;
      }
   }

   @PSModelRTMeta(description = "引用自动填充模式", hideempty = true)
   @Override
   public IPSDEACMode getRefPSDEACMode() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getREFPSDEID())) {
         IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
         if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getREFPSDEACMODEID())) {
            return refPSDataEntity.getPSDEACMode(this.psDETreeNodeColumn.getREFPSDEACMODEID());
         } else {
            return this.getPSDETree().isRegisterToPSAppDataEntity() ? refPSDataEntity.getDefaultPSDEACMode() : null;
         }
      } else {
         if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty(this.iPSDEFGridColumn.getRefPSDEACModeId())) {
               return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEACMode(this.iPSDEFGridColumn.getRefPSDEACModeId());
            }

            if (this.getPSDETree().isRegisterToPSAppDataEntity()) {
               return this.iPSDEFGridColumn.getRefPSDataEntity().getDefaultPSDEACMode();
            }
         }

         return null;
      }
   }

   @PSModelRTMeta(description = "编辑器类型")
   @Override
   public IPSEditorType getPSEditorType() {
      return this.iPSEditorType;
   }

   @Override
   public String getPSDETEIUpdateId() {
      return this.psDETreeNodeColumn.getPSDETEIUPDATEID();
   }

   @PSModelRTMeta(description = "树表编辑项更新对象", hideempty = true, dumpref = true, from = "IPSDETreeNode", fields = "PSDETEIUPDATEID")
   @Override
   public IPSDETreeNodeEditItemUpdate getPSDETreeNodeEditItemUpdate() throws Exception {
      return StringHelper.IsNullOrEmpty(this.getPSDETEIUpdateId()) ? null : this.getPSDETreeNode().getPSDETreeNodeEditItemUpdate(this.getPSDETEIUpdateId());
   }

   @PSModelRTMeta(description = "树表格编辑项对象", hideempty = true, modelcls = "SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem")
   @Override
   public IPSDETreeNodeEditItem getPSDETreeNodeEditItem() {
      return this.isEnableRowEdit() ? this : super.getPSDETreeNodeEditItem();
   }

   @Override
   public Properties getEditorParams() {
      return this.editorParams;
   }

   @Override
   public int getEditorParam(String strParam, int nDefault) {
      return PropertiesHelper.getProperty(this.getEditorParams(), strParam, nDefault);
   }

   @Override
   public String getEditorParam(String strParam, String strDefault) {
      String strValue = PropertiesHelper.getProperty(this.getEditorParams(), strParam, strDefault);
      if (this.isHiddenDataItem()
         || !StringHelper.IsNullOrEmpty(strDefault)
         || !StringHelper.IsNullOrEmpty(strValue)
         || strDefault == null
         || StringHelper.Compare(strParam, "DEFAULTVALUETYPE", false) != 0
            && StringHelper.Compare(strParam, "DEFAULTOBJECTIDFIELD", false) != 0
            && StringHelper.Compare(strParam, "DEFAULTOBJECTNAMEFIELD", false) != 0
            && StringHelper.Compare(strParam, "DEFAULTOBJECTVALUEFIELD", false) != 0
            && StringHelper.Compare(strParam, "DEFAULTTEXTSEPARATOR", false) != 0
            && StringHelper.Compare(strParam, "DEFAULTVALUESEPARATOR", false) != 0) {
         if (this.isEditable() && StringHelper.IsNullOrEmpty(strDefault) && StringHelper.IsNullOrEmpty(strValue) && strDefault != null) {
            if (StringHelper.Compare(strParam, "DEFAULTMAXLENGTH", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTMINLENGTH", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTMAXVALUE", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTMINVALUE", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTPRECISION", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTARRAY", false) == 0
               || StringHelper.Compare(strParam, "DEFAULTARRAYDATATYPE", false) == 0) {
               String strValue2 = PropertiesHelper.getProperty(this.getEditorParams(), strParam, null);
               if (strValue2 != null) {
                  return strValue2;
               }

               IPSDETreeNodeDataItem iPSDETreeNodeDataItem = null;

               try {
                  iPSDETreeNodeDataItem = this.getPSDETreeNode().getPSDETreeNodeDataItem(this.getDataItemName(), true);
               } catch (Exception ex) {
                  log.error(ex);
               }

               if (iPSDETreeNodeDataItem == null || iPSDETreeNodeDataItem.getPSAppDEField() == null) {
                  return strValue;
               }

               IPSDEFieldBase iPSDEFieldBase = iPSDETreeNodeDataItem.getPSAppDEField();
               if (this.getPSDEFGridColumn() == null && iPSDEFieldBase == null) {
                  return strValue;
               }

               if (StringHelper.Compare(strParam, "DEFAULTMAXLENGTH", false) == 0) {
                  int nLength = -1;
                  if (this.getPSDEFGridColumn() != null) {
                     nLength = this.getPSDEFGridColumn().getStringLength(iPSDEFieldBase);
                  } else {
                     nLength = iPSDEFieldBase.getStringLength();
                  }

                  if (nLength <= 0) {
                     return null;
                  }

                  return String.format("%1$s", nLength);
               }

               if (StringHelper.Compare(strParam, "DEFAULTMINLENGTH", false) == 0) {
                  int nLength = -1;
                  if (this.getPSDEFGridColumn() != null) {
                     nLength = this.getPSDEFGridColumn().getMinStringLength(iPSDEFieldBase);
                  } else {
                     nLength = iPSDEFieldBase.getMinStringLength();
                  }

                  if (nLength <= 0) {
                     return null;
                  }

                  return String.format("%1$s", nLength);
               }

               if (StringHelper.Compare(strParam, "DEFAULTMAXVALUE", false) == 0) {
                  if (this.getPSDEFGridColumn() != null) {
                     return this.getPSDEFGridColumn().getMaxValueString(iPSDEFieldBase);
                  }

                  return iPSDEFieldBase.getMaxValueString();
               }

               if (StringHelper.Compare(strParam, "DEFAULTMINVALUE", false) == 0) {
                  if (this.getPSDEFGridColumn() != null) {
                     return this.getPSDEFGridColumn().getMinValueString(iPSDEFieldBase);
                  }

                  return iPSDEFieldBase.getMinValueString();
               }

               if (StringHelper.Compare(strParam, "DEFAULTPRECISION", false) == 0) {
                  int nLength = -1;
                  if (this.getPSDEFGridColumn() != null) {
                     nLength = this.getPSDEFGridColumn().getPrecision(iPSDEFieldBase);
                  } else {
                     nLength = iPSDEFieldBase.getPrecision();
                  }

                  if (nLength <= 0) {
                     return null;
                  }

                  return String.format("%1$s", nLength);
               }

               if (this.getPSAppDEField() != null && StringHelper.Compare(strParam, "DEFAULTARRAYDATATYPE", false) == 0) {
                  try {
                     IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                     if (iPSAppDEMethodDTO != null) {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true);
                        if (iPSAppDEMethodDTOField != null && "SIMPLES".equals(iPSAppDEMethodDTOField.getType())) {
                           if (!DataTypeHelper.isBigIntType(iPSAppDEMethodDTOField.getStdDataType())
                              && !DataTypeHelper.isBigDecimalType(iPSAppDEMethodDTOField.getStdDataType())
                              && !DataTypeHelper.isDoubleType(iPSAppDEMethodDTOField.getStdDataType())) {
                              if (DataTypeHelper.isIntType(iPSAppDEMethodDTOField.getStdDataType())) {
                                 return "INTEGER";
                              }

                              return "STRING";
                           }

                           return "NUMBER";
                        }
                     }
                  } catch (Exception ex) {
                     log.error(ex);
                  }

                  return strValue;
               }

               if (this.getPSAppDEField() != null && StringHelper.Compare(strParam, "DEFAULTARRAY", false) == 0) {
                  try {
                     IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
                     if (iPSAppDEMethodDTO != null) {
                        IPSAppDEMethodDTOField iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(this.getPSAppDEField(), true);
                        if (iPSAppDEMethodDTOField != null && "SIMPLES".equals(iPSAppDEMethodDTOField.getType())) {
                           return "true";
                        }
                     }
                  } catch (Exception ex) {
                     log.error(ex);
                  }

                  return strValue;
               }
            }

            return strValue;
         } else {
            return strValue;
         }
      } else {
         String strValue2 = PropertiesHelper.getProperty(this.getEditorParams(), strParam, null);
         if (strValue2 != null) {
            return strValue2;
         }

         if (StringHelper.IsNullOrEmpty(this.getDataItemName())) {
            return strValue;
         }

         IPSDETreeNodeDataItem iPSDETreeNodeDataItem = null;

         try {
            iPSDETreeNodeDataItem = this.getPSDETreeNode().getPSDETreeNodeDataItem(this.getDataItemName(), true);
         } catch (Exception ex) {
            log.error(ex);
         }

         if (iPSDETreeNodeDataItem != null && iPSDETreeNodeDataItem.getPSAppDEField() != null) {
            IPSAppDEField iPSAppDEField = iPSDETreeNodeDataItem.getPSAppDEField();
            if (StringHelper.Compare(strParam, "DEFAULTVALUETYPE", false) == 0) {
               return iPSDETreeNodeDataItem.getValueType();
            }

            if (StringHelper.Compare(strParam, "DEFAULTOBJECTIDFIELD", false) != 0
               && StringHelper.Compare(strParam, "DEFAULTOBJECTNAMEFIELD", false) != 0
               && StringHelper.Compare(strParam, "DEFAULTOBJECTVALUEFIELD", false) != 0) {
               return strValue;
            }

            try {
               IPSAppDEMethodDTO iPSAppDEMethodDTO = this.getPSAppDEMethodDTO();
               if (iPSAppDEMethodDTO != null) {
                  IPSAppDEMethodDTOField iPSAppDEMethodDTOField = iPSAppDEMethodDTO.getPSAppDEMethodDTOField(iPSAppDEField, true);
                  if (iPSAppDEMethodDTOField != null && iPSAppDEMethodDTOField.getPSDEMethodDTOField() != null) {
                     IPSDEMethodDTOField iPSDEMethodDTOField = iPSAppDEMethodDTOField.getPSDEMethodDTOField();
                     if (iPSDEMethodDTOField.getPSDER() != null
                        && ("DTO".equals(iPSAppDEMethodDTOField.getType()) || "DTOS".equals(iPSAppDEMethodDTOField.getType()))
                        && iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO() != null
                        && iPSAppDEMethodDTOField.getRefPSAppDataEntity() != null) {
                        IPSDER1N iPSDER1N = null;
                        IPSDERCustom iPSDERCustom = null;
                        IPSDEField pickupPSDEField = null;
                        IPSDEField pickupTextPSDEField = null;
                        IPSDEField pickupObjectPSDEField = null;
                        IPSDataEntity dstPSDataEntity = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSDataEntity();
                        IPSDataEntity refPSDataEntity = this.getRefPSDataEntity();
                        if (refPSDataEntity != null) {
                           Iterator<IPSDERBase> psDERs = dstPSDataEntity.getMinorPSDERs();
                           if (psDERs != null) {
                              while (psDERs.hasNext()) {
                                 IPSDERBase iPSDERBase = psDERs.next();
                                 if (StringHelper.Compare(refPSDataEntity.getId(), iPSDERBase.getMajorDEId(), false) == 0) {
                                    if ("DER1N".equals(iPSDERBase.getDERType())) {
                                       iPSDER1N = (IPSDER1N)iPSDERBase;
                                       break;
                                    }

                                    if ("DER11".equals(iPSDERBase.getDERType())) {
                                       iPSDER1N = (IPSDER1N)iPSDERBase;
                                       break;
                                    }

                                    if ("DERCUSTOM".equals(iPSDERBase.getDERType()) && ((IPSDERCustom)iPSDERBase).getPickupPSDEField() != null) {
                                       iPSDERCustom = (IPSDERCustom)iPSDERBase;
                                       break;
                                    }
                                 }
                              }
                           }
                        } else if (dstPSDataEntity.getDEType() == 3) {
                           IPSDERNN iPSDERNN = dstPSDataEntity.getPSDERNN();
                           if (StringHelper.Compare(
                                 iPSDERNN.getFirstPSDER().getMajorDEId(), iPSAppDEField.getPSAppDataEntity().getPSDataEntity().getId(), false
                              )
                              == 0) {
                              if (iPSDERNN.getSecondPSDER() instanceof IPSDER1N) {
                                 iPSDER1N = (IPSDER1N)iPSDERNN.getSecondPSDER();
                              } else {
                                 iPSDERCustom = (IPSDERCustom)iPSDERNN.getSecondPSDER();
                              }
                           } else if (iPSDERNN.getFirstPSDER() instanceof IPSDER1N) {
                              iPSDER1N = (IPSDER1N)iPSDERNN.getFirstPSDER();
                           } else {
                              iPSDERCustom = (IPSDERCustom)iPSDERNN.getFirstPSDER();
                           }
                        }

                        if (iPSDER1N != null) {
                           pickupPSDEField = iPSDER1N.getPickupPSDEField();
                           pickupTextPSDEField = iPSDER1N.getPSPickupTextDEField();
                           pickupObjectPSDEField = iPSDER1N.getPSPickupObjectDEField();
                        } else if (iPSDERCustom != null) {
                           iPSDERCustom = (IPSDERCustom)iPSDEMethodDTOField.getPSDER();
                           pickupPSDEField = iPSDERCustom.getPickupPSDEField();
                           pickupTextPSDEField = iPSDERCustom.getPickupTextPSDEField();
                        } else {
                           pickupPSDEField = dstPSDataEntity.getKeyPSDEField();
                           pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }

                        if (pickupPSDEField != null && pickupTextPSDEField == null) {
                           pickupTextPSDEField = dstPSDataEntity.getMajorPSDEField();
                        }

                        IPSDEField dstPSDEField = null;
                        if (StringHelper.Compare(strParam, "DEFAULTOBJECTIDFIELD", false) == 0) {
                           dstPSDEField = pickupPSDEField;
                        } else if (StringHelper.Compare(strParam, "DEFAULTOBJECTNAMEFIELD", false) == 0) {
                           dstPSDEField = pickupTextPSDEField;
                        } else if (StringHelper.Compare(strParam, "DEFAULTOBJECTVALUEFIELD", false) == 0) {
                           dstPSDEField = pickupObjectPSDEField;
                        }

                        if (dstPSDEField != null) {
                           IPSAppDEField dstPSAppDEField = iPSAppDEMethodDTOField.getRefPSAppDataEntity().getPSAppDEField(dstPSDEField, true);
                           if (dstPSAppDEField != null) {
                              IPSAppDEMethodDTOField dstPSAppDEMethodDTOField = iPSAppDEMethodDTOField.getRefPSAppDEMethodDTO()
                                 .getPSAppDEMethodDTOField(dstPSAppDEField, true);
                              if (dstPSAppDEMethodDTOField != null) {
                                 return dstPSAppDEMethodDTOField.getName();
                              }
                           }
                        }
                     }
                  }
               }
            } catch (Exception ex) {
               log.error(ex);
            }

            return strValue;
         } else {
            return strValue;
         }
      }
   }

   @Override
   public double getEditorParam(String strParam, double fDefault) {
      return PropertiesHelper.getProperty(this.getEditorParams(), strParam, fDefault);
   }

   @Override
   public boolean getEditorParam(String strParam, boolean bDefault) {
      return PropertiesHelper.getProperty(this.getEditorParams(), strParam, bDefault);
   }

   @Override
   public String getPSSysValueRuleId() {
      return this.strPSSysValueRuleId;
   }

   @PSModelRTMeta(description = "忽略输入模式", codelist = "FormItemEnableCond", fields = "IGNOREINPUT")
   @Override
   public int getIgnoreInput() {
      return this.nIgnoreInput;
   }

   @PSModelRTMeta(description = "转化为代码项文本", ignoredumpvalues = "false")
   @Override
   public boolean isConvertToCodeItemText() {
      if (StringHelper.IsNullOrEmpty(this.getPSCodeListId())) {
         return false;
      } else {
         return this.getPSEditorType() != null ? this.getPSEditorType().isConvertToCodeItemText() : false;
      }
   }

   @PSModelRTMeta(description = "需要代码表配置", ignoredumpvalues = "false", fields = "NEEDCODELISTCONFIG")
   @Override
   public boolean isNeedCodeListConfig() {
      return this.bNeedCodeListConfig;
   }

   @PSModelRTMeta(description = "输出代码表配置模式", codelist = "OutputCodeListConfigMode", ignoredumpvalues = "0", fields = "CODELISTCONFIGMODE")
   @Override
   public int getOutputCodeListConfigMode() {
      return this.nOutputCodeListConfigMode;
   }

   @Override
   public String getEditorCssStyle() {
      return this.strEditorCssStyle;
   }

   @Override
   public String getValueTranslator() {
      return this.strValueProcessor;
   }

   @PSModelRTMeta(description = "重置项名称", ignorert = 3, hideempty2 = true, fields = "RESETITEMNAME")
   @Override
   public String getResetItemName() {
      return this.strResetItemName;
   }

   @PSModelRTMeta(description = "重置项集合", hideempty2 = true, child = true, outputdoc = "false", fields = "RESETITEMNAME")
   @Override
   public Iterator<String> getResetItemNames() {
      return this.resetItemNameList != null && this.resetItemNameList.size() != 0 ? this.resetItemNameList.iterator() : null;
   }

   @PSModelRTMeta(description = "输入提示信息", dump = false)
   @Override
   public String getPlaceHolder() {
      return this.strPlaceHolder;
   }

   @PSModelRTMeta(description = "系统编辑器样式")
   @Override
   public IPSSysEditorStyle getPSSysEditorStyle() {
      return this.iPSSysEditorStyle;
   }

   @PSModelRTMeta(description = "支持行编辑", ignoredumpvalues = "false", fields = "ENABLEROWEDIT")
   @Override
   public boolean isEnableRowEdit() {
      return this.bRowEditable;
   }

   @PSModelRTMeta(description = "数据项")
   @Override
   public IDataItem getDataItem() {
      return this.psDETreeNodeDataItemList != null && this.psDETreeNodeDataItemList.size() > 0 ? this.psDETreeNodeDataItemList.get(0) : this.psDataItemImpl;
   }

   @PSModelRTMeta(description = "启用项权限控制", ignoredumpvalues = "false", fields = "ENABLEITEMPRIV")
   @Override
   public boolean isEnableItemPriv() {
      return this.bEnableItemPriv;
   }

   protected void setEnableItemPriv(boolean bEnableItemPriv) {
      this.bEnableItemPriv = bEnableItemPriv;
   }

   @Override
   public String getItemPrivId() {
      return this.strItemPrivId;
   }

   protected void setItemPrivId(String strItemPrivId) {
      this.strItemPrivId = strItemPrivId;
   }

   @PSModelRTMeta(description = "内置界面行为", hideempty2 = true, child = true, fields = "PSDEUIACTIONID")
   @Override
   public IPSDEUIAction getPSDEUIAction() {
      return this.iPSDEUIAction;
   }

   @PSModelRTMeta(description = "界面行为组", child = true, fields = "PSDEUAGROUPID")
   @Override
   public IPSDEUIActionGroup getPSDEUIActionGroup() {
      return this.iPSDEUIActionGroup;
   }

   @PSModelRTMeta(description = "代码表输出模式", codelist = "CLConvertModes", hideempty2 = true, fields = "CLCONVERTMODE")
   @Override
   public String getCLConvertMode() {
      return this.strCLConvertMode;
   }

   protected boolean isFixColDataItemBug() {
      return (this.getPSSystemSetting().getEngineBugFixs() & 2) == 2;
   }

   @PSModelRTMeta(description = "绑定值项名称集合", fields = "VALUEITEMNAME")
   @Override
   public String[] getValueItemNames() {
      return this.valueItemNameList != null && this.valueItemNameList.size() != 0
         ? this.valueItemNameList.toArray(new String[this.valueItemNameList.size()])
         : null;
   }

   @Override
   public String getEditorContainer() {
      return "GRIDCOLUMN";
   }

   @Override
   public double getEditorHeight() {
      return 0.0;
   }

   @Override
   public double getEditorWidth() {
      return 0.0;
   }

   @PSModelRTMeta(description = "引用实体对象", hideempty = true)
   @Override
   public IPSDataEntity getRefPSDataEntity() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDETreeNodeColumn.getREFPSDEID())) {
         return this.getPSSystem().getPSDataEntity2(this.psDETreeNodeColumn.getREFPSDEID());
      } else {
         return this.iPSDEFGridColumn != null ? this.iPSDEFGridColumn.getRefPSDataEntity() : null;
      }
   }

   @PSModelRTMeta(description = "编辑器对象", hideempty = true, child = true)
   @Override
   public IPSEditor getPSEditor() throws Exception {
      if (this.iPSEditor == null && this.getPSEditorType() != null) {
         this.iPSEditor = this.getPSEditorType().createPSEditor(this);
      }

      return this.iPSEditor;
   }

   @Override
   public String getEditorName() {
      return this.getCodeName();
   }

   @Override
   public IPSControlContainer getPSControlContainer() {
      return this.getPSDETree();
   }

   @PSModelRTMeta(description = "支持链接视图", ignoredumpvalues = "false")
   @Override
   public boolean isEnableLinkView() {
      return this.bEnableLinkView;
   }

   @PSModelRTMeta(description = "启用链接模式", codelist = "DEGridColLinkMode", dump = false)
   @Override
   public int getEnableLink() {
      return this.nEnableLink;
   }

   @PSModelRTMeta(description = "链接值项", fields = "VALUEITEMNAME")
   @Override
   public String getLinkValueItem() {
      if (!this.isEnableLinkView()) {
         return "";
      }

      String strLinkValueItem = this.psDETreeNodeColumn.getVALUEITEMNAME();
      if (!StringHelper.IsNullOrEmpty(strLinkValueItem)) {
         return strLinkValueItem;
      }

      if (this.iPSDEFGridColumn != null) {
         strLinkValueItem = this.iPSDEFGridColumn.getLinkValueItem(this);
         if (!StringHelper.IsNullOrEmpty(strLinkValueItem)) {
            return strLinkValueItem;
         }
      }

      return this.getPSDEField() != null && this.getPSDEField().isMajorDEField() ? "srfkey" : this.getDataItemName();
   }

   @PSModelRTMeta(description = "链接视图", dumpref = true, fields = "LINKPSDEVIEWID")
   @Override
   public IPSAppView getLinkPSAppView() throws Exception {
      if (!this.isEnableLinkView()) {
         return null;
      }

      if (this.linkPSAppView == null) {
         this.linkPSAppView = this.onGetLinkPSAppView(false);
      }

      return this.linkPSAppView;
   }

   protected IPSAppView onGetLinkPSAppView(boolean bTryMode) throws Exception {
      String strLinkPSDEViewId = this.psDETreeNodeColumn.getLINKPSDEVIEWID();
      if (StringHelper.IsNullOrEmpty(strLinkPSDEViewId) && this.getPSDEFGridColumn() != null) {
         strLinkPSDEViewId = this.getPSDEFGridColumn().getRefLinkPSDEViewId(this.getPSDETree().getPSAppView().getPSApplication());
      }

      if (StringHelper.IsNullOrEmpty(strLinkPSDEViewId) && this.getPSCodeList() != null) {
         strLinkPSDEViewId = this.getPSCodeList().getLinkPSDEViewId();
      }

      if (StringHelper.IsNullOrEmpty(strLinkPSDEViewId)
         && this.getPSDEField() != null
         && this.getPSDEField().isMajorDEField()
         && this.getPSDETreeNode().getPSAppDataEntity() != null) {
         strLinkPSDEViewId = this.getPSDETreeNode().getPSAppDataEntity().getRefLinkPSDEViewId();
      }

      return !StringHelper.IsNullOrEmpty(strLinkPSDEViewId)
         ? this.getPSDETree().getPSAppView().getPSApplication().getPSAppViewByDEViewId(strLinkPSDEViewId, bTryMode)
         : null;
   }

   protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction) throws Exception {
      String strCtrlName = this.getPSDETree().getName();
      String strLogicTag = StringHelper.Format("%1$s_%2$s_%3$s_click", strCtrlName, this.getPSDETreeNode().getNodeType(), this.getName()).toLowerCase();
      PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
      psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
      psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
      psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
      psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
      PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
      psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this.getPSDETree(), psAppViewLogic, iPSAppViewUIAction);
      this.getPSDETree().registerPSAppViewLogic(psAppDEViewLogicImpl);
   }

   protected void registerPSAppViewLogic(IPSAppViewUIAction iPSAppViewUIAction, IPSUIActionGroupDetail iPSUIActionGroupDetail) throws Exception {
      String strCtrlName = this.getPSDETree().getName();
      String strLogicTag = StringHelper.Format(
            "%1$s_%2$s_%3$s_%4$s_click", strCtrlName, this.getPSDETreeNode().getNodeType(), this.getName(), iPSUIActionGroupDetail.getName()
         )
         .toLowerCase();
      PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
      psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
      psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
      psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
      psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
      PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
      psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this.getPSDETree(), psAppViewLogic, iPSAppViewUIAction);
      this.getPSDETree().registerPSAppViewLogic(psAppDEViewLogicImpl);
   }

   @Override
   public String getPSSysDictCatId() {
      return this.strPSSysDictCatId;
   }

   @Override
   protected String onGetRenderPSSysPFPluginId() {
      String strRenderPSSysPFPluginId = super.onGetRenderPSSysPFPluginId();
      return StringHelper.IsNullOrEmpty(strRenderPSSysPFPluginId)
            && this.getPSDEFGridColumn() != null
            && this.getPSDEFGridColumn().getRenderPSSysPFPlugin() != null
         ? this.getPSDEFGridColumn().getRenderPSSysPFPlugin().getId()
         : strRenderPSSysPFPluginId;
   }

   @Override
   public IPSSysValueRule getPSSysValueRule() throws Exception {
      if (!this.isEditable()) {
         return null;
      } else {
         IPSSysValueRule iPSSysValueRule = this.onGetPSSysValueRule();
         if (iPSSysValueRule != null) {
            return iPSSysValueRule instanceof IPSAppValueRule
               ? iPSSysValueRule
               : this.getPSDETree().getPSAppView().getPSApplication().getPSAppValueRule(iPSSysValueRule.getId());
         } else {
            return iPSSysValueRule;
         }
      }
   }

   protected IPSSysValueRule onGetPSSysValueRule() throws Exception {
      if (this.getPSDEFGridColumn() != null) {
         if (this.getPSAppDEField() != null) {
            return this.getPSDEFGridColumn().getPSSysValueRule(this.getPSAppDEField());
         }

         if (this.getPSDEField() != null) {
            return this.getPSDEFGridColumn().getPSSysValueRule(this.getPSDEField());
         }
      } else {
         if (this.getPSAppDEField() != null) {
            return this.getPSAppDEField().getPSSysValueRule();
         }

         if (this.getPSDEField() != null) {
            return this.getPSDEField().getPSSysValueRule();
         }
      }

      return null;
   }

   @Override
   public String getEditorDynaClass() {
      return null;
   }

   @Override
   public String getEditorCssStyle2() {
      return null;
   }

   @Override
   public IPSSysCss getEditorPSSysCss() {
      return null;
   }

   @PSModelRTMeta(description = "单位名称")
   @Override
   public String getUnitName() {
      return this.strUnitName;
   }

   @PSModelRTMeta(description = "单位宽度", ignoredumpvalues = "0")
   @Override
   public int getUnitNameWidth() {
      return this.nUnitNameWidth;
   }

   @PSModelRTMeta(description = "支持单位", ignoredumpvalues = "false")
   @Override
   public boolean isEnableUnitName() {
      return this.bEnableUnitName;
   }

   @PSModelRTMeta(description = "值类型[VALUETYPE]{SIMPLE|SIMPLES|OBJECT|OBJECTS}", codelist = "EditorValueType", ignoredumpvalues = "SIMPLE")
   @Override
   public String getValueType() {
      return this.getEditorParam("VALUETYPE", this.getDefaultValueType());
   }

   protected String getDefaultValueType() {
      String strValue = this.getEditorParam("DEFAULTVALUETYPE", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   @PSModelRTMeta(description = "对象标识属性[OBJECTIDFIELD]")
   @Override
   public String getObjectIdField() {
      return this.getEditorParam("OBJECTIDFIELD", this.getDefaultObjectIdField());
   }

   protected String getDefaultObjectIdField() {
      String strValueType = this.getValueType();
      if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
         return null;
      }

      String strValue = this.getEditorParam("DEFAULTOBJECTIDFIELD", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   @PSModelRTMeta(description = "对象名称属性[OBJECTNAMEFIELD]")
   @Override
   public String getObjectNameField() {
      return this.getEditorParam("OBJECTNAMEFIELD", this.getDefaultObjectNameField());
   }

   protected String getDefaultObjectNameField() {
      String strValueType = this.getValueType();
      if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
         return null;
      }

      String strValue = this.getEditorParam("DEFAULTOBJECTNAMEFIELD", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   @PSModelRTMeta(description = "对象值属性[OBJECTVALUEFIELD]")
   @Override
   public String getObjectValueField() {
      return this.getEditorParam("OBJECTVALUEFIELD", this.getDefaultObjectValueField());
   }

   protected String getDefaultObjectValueField() {
      String strValueType = this.getValueType();
      if (!"OBJECT".equalsIgnoreCase(strValueType) && !"OBJECTS".equalsIgnoreCase(strValueType)) {
         return null;
      }

      String strValue = this.getEditorParam("DEFAULTOBJECTVALUEFIELD", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   @PSModelRTMeta(description = "多项值分隔符[VALUESEPARATOR]")
   @Override
   public String getValueSeparator() {
      return this.getEditorParam("VALUESEPARATOR", this.getDefaultValueSeparator());
   }

   protected String getDefaultValueSeparator() {
      String strValueType = this.getValueType();
      if (!"SIMPLE".equalsIgnoreCase(strValueType) && !StringHelper.IsNullOrEmpty(strValueType)) {
         return null;
      }

      String strValue = this.getEditorParam("DEFAULTVALUESEPARATOR", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   @PSModelRTMeta(description = "多项文本分隔符[TEXTSEPARATOR]")
   @Override
   public String getTextSeparator() {
      return this.getEditorParam("TEXTSEPARATOR", this.getDefaultTextSeparator());
   }

   protected String getDefaultTextSeparator() {
      String strValue = this.getEditorParam("DEFAULTTEXTSEPARATOR", "");
      return StringHelper.IsNullOrEmpty(strValue) ? null : strValue;
   }

   protected IPSAppDEMethodDTO getPSAppDEMethodDTO() throws Exception {
      if (this.getPSDETree().getFetchPSControlAction() != null
         && this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod() != null
         && this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn() != null) {
         IPSAppDEMethodReturn iPSAppDEMethodReturn = this.getPSDETree().getFetchPSControlAction().getPSAppDEMethod().getPSAppDEMethodReturn();
         return !"DTO".equals(iPSAppDEMethodReturn.getType())
               && !"DTOS".equals(iPSAppDEMethodReturn.getType())
               && !"PAGE".equals(iPSAppDEMethodReturn.getType())
            ? null
            : iPSAppDEMethodReturn.getPSAppDEMethodDTO();
      } else {
         return null;
      }
   }

   @Override
   protected void onFillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
      if (this.getPSDEUIActionGroup() != null) {
         Iterator<IPSDEUIAction> psDEUIActions = this.getPSDEUIActionGroup().getPSDEUIActions();
         if (psDEUIActions != null) {
            while (psDEUIActions.hasNext()) {
               IPSDEUIAction iPSDEUIAction = psDEUIActions.next();
               if (iPSDEUIAction.getFrontPSAppView(this) != null) {
                  relatedAppViewList.add(iPSDEUIAction.getFrontPSAppView(this));
               }
            }
         }
      }

      if (this.getPSDEUIAction() != null && this.getPSDEUIAction().getFrontPSAppView(this) != null) {
         relatedAppViewList.add(this.getPSDEUIAction().getFrontPSAppView(this));
      }

      super.onFillRelatedPSAppViews(relatedAppViewList);
   }

   @Override
   public IPSAjaxHandler getItemPSAjaxHandler() {
      return null;
   }
}
