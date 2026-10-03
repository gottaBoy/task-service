package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSDEFDLogic;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.form.IFIDEACMode;
import net.ibizsys.paas.control.form.IFIDEFValueRule;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFormItemImpl extends PSDEFormDetailImpl implements IPSDEFormItem {
   private static final Log log = LogFactory.getLog(PSDEFormItemImpl.class);
   public static final String EDITORPARAM_ITEMPARAM = "ITEMPARAM";
   private IPSDEFFormItem iPSDEFFormItem = null;
   protected IPSDEField iPSDEField = null;
   private IPSAppDEField iPSAppDEField = null;
   protected String strEditorType = "";
   protected String strEditorStyle = "";
   protected boolean bHidden = false;
   protected boolean bAllowEmpty = true;
   protected boolean bAllowEmptyDefined = false;
   protected String strLabelPos = "LEFT";
   protected double fEditorWidth = 0.0;
   protected double fEditorHeight = 0.0;
   protected String strPSCodeListId = "";
   protected PSDEFormDataItemImpl psDataItemImpl = new PSDEFormDataItemImpl();
   private ArrayList<IFIDEFValueRule> fiDEFValueRuleList = null;
   protected PSDEFormItemImpl.FIDEACModeImpl fiDEACModeImpl = null;
   protected IPSCodeList iPSCodeList = null;
   private int nEnableCond = 3;
   private boolean bShowCaption = true;
   private String strCreateDVT = "";
   private String strCreateDV = "";
   private String strUpdateDVT = "";
   private String strUpdateDV = "";
   private boolean bEditable = true;
   private IPSEditorType iPSEditorType = null;
   private Properties editorParams = null;
   private boolean bDefineEditorType = false;
   private String strPSSysValueRuleId = null;
   private int nIgnoreInput = 0;
   private int nLabelColSpan = 4;
   private int nCtrlColSpan = 6;
   private String strValueItemName = "";
   private ArrayList<String> valueItemNameList = null;
   private boolean bNeedCodeListConfig = false;
   private int nOutputCodeListConfig = 0;
   private String strLabelCssStyle = "";
   private String strCtrlCssStyle = "";
   private String strEditorCssStyle = "";
   private String strValueProcessor = "";
   private String strResetItemName = null;
   private ArrayList<String> resetItemNameList = null;
   private boolean bEmptyCaption = false;
   private int nLabelWidth = 0;
   private String strPlaceHolder = null;
   private IPSSysEditorStyle iPSSysEditorStyle = null;
   private boolean bEnableItemPriv = false;
   private String strPrivilegeId = null;
   private String strPrivDEFieldName = null;
   private String strUnitName = null;
   private int nUnitNameWidth = 0;
   private boolean bEnableUnitName = false;
   private IPSDEFInputTip iPSDEFInputTip = null;
   private String strItemHandlerType = null;
   private IPSAjaxHandler itemPSAjaxHandler = null;
   private int nWriteBackDEFMode = 0;
   private Boolean bConvertToCodeItemText = null;
   private int nNoPrivDisplayMode = 1;
   private JSONObject itemParamJO = null;
   private boolean bInfoMode = false;
   private boolean bInfoConvertPickerToLink = false;
   private boolean bInfoReadOnlyMode = false;
   private IPSEditor iPSEditor = null;
   private boolean bEnableAnchor = false;
   private String strPSSysDictCatId = "";
   private boolean bEnableInputTip = false;
   private boolean bEnableInputTipDefined = false;

   @Override
   protected void onInit() throws Exception {
      if (!this.psDEFormDetail.isENABLEANCHORNull()) {
         this.bEnableAnchor = this.psDEFormDetail.getENABLEANCHOR();
      }

      if (!this.psDEFormDetail.isENABLEINPUTTIPNull()) {
         this.bEnableInputTip = this.psDEFormDetail.getENABLEINPUTTIP();
         this.bEnableInputTipDefined = true;
      }

      super.onInit();
      if (this.iPSDEField != null && this.getPSAppDEField() == null && this.getPSDEForm().getPSAppDataEntity() != null) {
         this.iPSAppDEField = this.getPSDEForm().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
      }

      boolean bUseDTO = false;
      if (this.getPSDEForm().getPSAppView() != null && this.getPSDEForm().getPSAppView().getPSApplication() != null) {
         bUseDTO = this.getPSDEForm().getPSAppView().getPSApplication().isUseServiceApi();
      }

      this.psDataItemImpl.init(this);
      if (!bUseDTO) {
         if (this.getPSSystemSetting() != null) {
            this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
         }
      } else {
         this.psDataItemImpl.setFormat("");
      }

      if (this.isRegisterToPSAppDataEntity() && this.getPSDEFDGroupLogic("ITEMBLANK") != null) {
         this.bAllowEmpty = false;
      }

      this.editorParams = PropertiesHelper.load(this.psDEFormDetail.getEDITORPARAMS());
      if (StringHelper.IsNullOrEmpty(this.strEditorType)) {
         this.strEditorType = this.psDEFormDetail.getEDITORTYPE();
      }

      this.strEditorStyle = this.psDEFormDetail.getPSSYSEDITORSTYLEID();
      if (!StringHelper.IsNullOrEmpty(this.strEditorType)) {
         this.bDefineEditorType = true;
      }

      if (!this.psDEFormDetail.isWBDEFMODENull()) {
         this.nWriteBackDEFMode = this.psDEFormDetail.getWBDEFMODE();
      }

      if (!this.psDEFormDetail.isCONVERTCITEXTNull()) {
         this.bConvertToCodeItemText = this.psDEFormDetail.getCONVERTCITEXT();
      }

      if (!this.psDEFormDetail.isNOPRIVDMNull()) {
         this.nNoPrivDisplayMode = this.psDEFormDetail.getNOPRIVDM();
      } else {
         this.nNoPrivDisplayMode = this.getPSDEForm().getPSAppView().getPSApplication().getPSApplicationUI().getFormItemNoPrivDisplayMode();
      }

      String strItemPSACHandlerId = null;
      this.preparePSDEFFormItem();
      if (this.getPSDEFFormItem() != null) {
         strItemPSACHandlerId = this.getPSDEFFormItem().getPSAjaxHandlerId();
         boolean bAppendParam = false;
         if (StringHelper.IsNullOrEmpty(this.strEditorType)) {
            this.strEditorType = this.iPSDEFFormItem.getEditorType();
            bAppendParam = true;
         } else if (StringHelper.Compare(this.strEditorType, this.iPSDEFFormItem.getEditorType(), true) == 0) {
            bAppendParam = true;
         }

         if (bAppendParam) {
            for (Object objKey : this.iPSDEFFormItem.getEditorParams().keySet()) {
               if (!this.editorParams.containsKey(objKey)) {
                  this.editorParams.put(objKey, this.iPSDEFFormItem.getEditorParams().get(objKey));
               }
            }
         }

         if (StringHelper.IsNullOrEmpty(this.strEditorStyle)) {
            this.strEditorStyle = this.iPSDEFFormItem.getEditorStyle();
         }
      }

      if (this.isDesignMode()) {
         this.strEditorStyle = "";
         if (StringHelper.Compare(this.getEditorType(), "USERCONTROL", true) == 0) {
            this.strEditorType = "SPAN";
            this.bDefineEditorType = true;
            this.strEditorStyle = "";
         }
      }

      if (StringHelper.IsNullOrEmpty(this.strEditorType)) {
         this.strEditorType = "TEXTBOX";
         if (this.getPSDEForm().getPSAppView() != null
            && this.getPSDEForm().getPSAppView().getPSApplication() != null
            && this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp()) {
            this.strEditorType = "MOBTEXT";
         }
      }

      this.bHidden = StringHelper.Compare(this.strEditorType, "HIDDEN", true) == 0;
      if (!this.bHidden && !this.bDefineEditorType) {
         if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel) {
            this.bInfoMode = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupMode();
            this.bInfoConvertPickerToLink = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupConvertPickerToLink();
            this.bInfoReadOnlyMode = ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isInfoGroupReadOnlyMode();
         } else if (this.getForm() instanceof IPSDEEditForm) {
            if (((IPSDEEditForm)this.getForm()).isInfoFormMode()) {
               this.bInfoMode = true;
            }

            if (((IPSDEEditForm)this.getForm()).isInfoFormConvertPickerToLink()) {
               this.bInfoConvertPickerToLink = true;
            }

            if (((IPSDEEditForm)this.getForm()).isInfoFormReadOnlyMode()) {
               this.bInfoReadOnlyMode = true;
            }
         }

         if (this.bInfoMode && !this.bInfoReadOnlyMode) {
            this.strEditorType = "SPAN";
            if (this.bInfoConvertPickerToLink) {
               if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getLINKPSDEVIEWID())) {
                  this.strEditorType = "PICKEREX_LINKONLY";
               } else if (this.getPSDEFFormItem() != null) {
                  String strLinkPSDEViewId = this.getPSDEFFormItem().getRefLinkPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication());
                  if (!StringHelper.IsNullOrEmpty(strLinkPSDEViewId)) {
                     IPSAppView linkPSAppView = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppViewByDEViewId(strLinkPSDEViewId, true);
                     if (linkPSAppView != null) {
                        this.strEditorType = "PICKEREX_LINKONLY";
                     }
                  }
               }
            }

            this.strEditorStyle = "";
            this.bDefineEditorType = true;
         }
      }

      if (!StringHelper.IsNullOrEmpty(this.getEditorType())) {
         this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
         this.bEditable = this.iPSEditorType.isEditable();
         if (!this.iPSEditorType.isEditable()) {
            this.bAllowEmpty = true;
         }

         this.strValueProcessor = this.iPSEditorType.getValueProcessor();
         if (!StringHelper.IsNullOrEmpty(this.strEditorStyle)) {
            this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "FORMITEM");
         } else if (!this.isDesignMode()) {
            this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "FORMITEM");
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

      if (!StringHelper.IsNullOrEmpty(strItemPSACHandlerId)) {
         this.itemPSAjaxHandler = this.createItemPSAjaxHandler(strItemPSACHandlerId);
      }

      if (!this.psDEFormDetail.isLABELPOSNull()) {
         this.strLabelPos = this.psDEFormDetail.getLABELPOS();
      }

      this.nLabelWidth = this.getPSDEForm().getDefaultLabelWidth();
      if (!this.psDEFormDetail.isLABELWIDTHNull() && this.psDEFormDetail.getLABELWIDTH() >= 0) {
         this.nLabelWidth = this.psDEFormDetail.getLABELWIDTH();
      }

      if (!this.psDEFormDetail.isEMPTYCAPTIONNull()) {
         this.bEmptyCaption = this.psDEFormDetail.getEMPTYCAPTION();
      }

      this.fEditorWidth = -1.0;
      this.fEditorHeight = -1.0;
      if (!this.psDEFormDetail.isCTRLWIDTHNull()) {
         this.fEditorWidth = this.psDEFormDetail.getCTRLWIDTH();
      }

      if (!this.psDEFormDetail.isCTRLHEIGHTNull()) {
         this.fEditorHeight = this.psDEFormDetail.getCTRLHEIGHT();
      }

      if (this.fEditorWidth < 0.0 && this.fEditorHeight < 0.0 && this.getPSSysEditorStyle() != null) {
         this.fEditorWidth = this.getPSSysEditorStyle().getEditorWidth();
         this.fEditorHeight = this.getPSSysEditorStyle().getEditorHeight();
      }

      if (this.fEditorWidth < 0.0 && this.fEditorHeight < 0.0) {
         boolean bCalc = false;
         if (this.bDefineEditorType) {
            if (this.iPSDEFFormItem != null && StringHelper.Compare(this.strEditorType, this.iPSDEFFormItem.getEditorType(), true) == 0) {
               this.fEditorWidth = this.iPSDEFFormItem.getEditorWidth();
               this.fEditorHeight = this.iPSDEFFormItem.getEditorHeight();
               bCalc = true;
            }

            if (!bCalc) {
               this.fEditorWidth = this.getPSEditorType().getWidth(this.getPSDEForm().getPSAppView().getPSApplication().getPSPF().getId());
               this.fEditorHeight = this.getPSEditorType().getHeight(this.getPSDEForm().getPSAppView().getPSApplication().getPSPF().getId());
               String strEditorWidthKey = StringHelper.Format("EDITOR.%1$s.WIDTH", this.getPSEditorType().getId()).toUpperCase();
               String strEditorHeightKey = StringHelper.Format("EDITOR.%1$s.HEIGHT", this.getPSEditorType().getId()).toUpperCase();
               this.fEditorWidth = this.getPSDEForm().getPSAppView().getPSApplication().getPFStyleParam(strEditorWidthKey, this.fEditorWidth);
               this.fEditorHeight = this.getPSDEForm().getPSAppView().getPSApplication().getPFStyleParam(strEditorHeightKey, this.fEditorHeight);
            }
         } else if (this.iPSDEFFormItem != null) {
            this.fEditorWidth = this.iPSDEFFormItem.getEditorWidth();
            this.fEditorHeight = this.iPSDEFFormItem.getEditorHeight();
            bCalc = true;
         }
      }

      if (this.fEditorWidth < 0.0) {
         this.fEditorWidth = 0.0;
      }

      if (this.fEditorHeight < 0.0) {
         this.fEditorHeight = 0.0;
      }

      if (!this.psDEFormDetail.isENABLECONDNull()) {
         this.nEnableCond = this.psDEFormDetail.getENABLECOND();
      } else if (this.iPSDEFFormItem != null) {
         this.nEnableCond = this.iPSDEFFormItem.getEnableCond();
      }

      this.strPSCodeListId = this.psDEFormDetail.getPSCODELISTID();
      if (StringHelper.IsNullOrEmpty(this.strPSCodeListId) && this.iPSDEFFormItem != null) {
         this.strPSCodeListId = this.iPSDEFFormItem.getPSCodeListId();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getPLACEHOLDER())) {
         this.strPlaceHolder = this.psDEFormDetail.getPLACEHOLDER();
      } else if (this.getPSDEFFormItem() != null) {
         this.strPlaceHolder = this.getPSDEFFormItem().getPlaceHolder();
      }

      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getPSSYSDICTCATID())) {
         this.strPSSysDictCatId = this.psDEFormDetail.getPSSYSDICTCATID();
      } else if (this.getPSDEFFormItem() != null) {
         this.strPSSysDictCatId = this.getPSDEFFormItem().getPSSysDictCatId();
      }

      if (this.iPSDEFFormItem != null) {
         this.strPSSysValueRuleId = this.iPSDEFFormItem.getPSSysValueRuleId();
      }

      if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSFIDEFValueRules() != null) {
         for (Iterator<IPSFIDEFValueRule> psFIDEFValueRules = this.iPSDEFFormItem.getPSFIDEFValueRules();
            psFIDEFValueRules.hasNext();
            this.fiDEFValueRuleList.add(psFIDEFValueRules.next())
         ) {
            if (this.fiDEFValueRuleList == null) {
               this.fiDEFValueRuleList = new ArrayList<>();
            }
         }
      }

      if (this.iPSDEFFormItem != null
         && !StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefPSDEId())
         && !StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefPSDEACModeId())) {
         this.fiDEACModeImpl = new PSDEFormItemImpl.FIDEACModeImpl();
         this.fiDEACModeImpl.setDEACModeName(this.iPSDEFFormItem.getRefPSDEACModeName());
         this.fiDEACModeImpl.setDEName(this.iPSDEFFormItem.getRefPSDEName());
      }

      if (!StringHelper.IsNullOrEmpty(this.getPSCodeListId())) {
         this.iPSCodeList = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
      }

      if (this.iPSCodeList != null) {
         this.iPSCodeList = this.getPSDEForm().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
      }

      this.bShowCaption = StringHelper.Compare(this.psDEFormDetail.getLABELPOS(), "NONE", true) != 0;
      this.strCreateDVT = this.psDEFormDetail.getCREATEDVT();
      this.strCreateDV = this.psDEFormDetail.getCREATEDV();
      this.strUpdateDVT = this.psDEFormDetail.getUPDATEDVT();
      this.strUpdateDV = this.psDEFormDetail.getUPDATEDV();
      if (this.iPSDEFFormItem != null) {
         if (StringHelper.IsNullOrEmpty(this.strCreateDVT)) {
            this.strCreateDVT = this.iPSDEFFormItem.getCreateDVT();
         }

         if (StringHelper.IsNullOrEmpty(this.strCreateDV)) {
            this.strCreateDV = this.iPSDEFFormItem.getCreateDV();
         }

         if (StringHelper.IsNullOrEmpty(this.strUpdateDVT)) {
            this.strUpdateDVT = this.iPSDEFFormItem.getUpdateDVT();
         }

         if (StringHelper.IsNullOrEmpty(this.strUpdateDV)) {
            this.strUpdateDV = this.iPSDEFFormItem.getUpdateDV();
         }
      }

      if (!this.psDEFormDetail.isIGNOREINPUTNull()) {
         this.nIgnoreInput = this.psDEFormDetail.getIGNOREINPUT();
      } else if (this.iPSDEFFormItem != null) {
         this.nIgnoreInput = this.iPSDEFFormItem.getIgnoreInput();
      }

      if (this.isConvertToCodeItemText()) {
         this.nIgnoreInput = 3;
      }

      if (!this.isDesignMode()) {
         if (!this.psDEFormDetail.isNEEDCODELISTCONFIGNull()) {
            this.bNeedCodeListConfig = this.psDEFormDetail.getNEEDCODELISTCONFIG();
         } else {
            this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
            if (this.getPSDEFFormItem() != null && StringHelper.Compare(this.strEditorType, this.getPSDEFFormItem().getEditorType(), true) == 0) {
               this.bNeedCodeListConfig = this.getPSDEFFormItem().isNeedCodeListConfig();
            }
         }

         if (!this.psDEFormDetail.isCODELISTCONFIGMODENull()) {
            this.nOutputCodeListConfig = this.psDEFormDetail.getCODELISTCONFIGMODE();
         } else {
            this.nOutputCodeListConfig = this.getPSEditorType().getOutputCodeListConfigMode();
            if (this.getPSDEFFormItem() != null && StringHelper.Compare(this.strEditorType, this.getPSDEFFormItem().getEditorType(), true) == 0) {
               this.nOutputCodeListConfig = this.getPSDEFFormItem().getOutputCodeListConfigMode();
            }
         }
      }

      this.prepareDataItem();
      this.strEditorCssStyle = this.calcEditorCssStyle();
      this.strCtrlCssStyle = this.calcCtrlCssStyle();
      this.strLabelCssStyle = this.calcLabelCssStyle();
      String strValueItemName = this.psDEFormDetail.getVALUEITEMNAME();
      if (StringHelper.IsNullOrEmpty(strValueItemName) && this.iPSDEFFormItem != null) {
         strValueItemName = this.iPSDEFFormItem.getValueItemName(this);
      }

      if (!StringHelper.IsNullOrEmpty(strValueItemName)) {
         this.valueItemNameList = new ArrayList<>();
         String[] items = StringHelper.SplitEx(strValueItemName);
         String[] iPSDEFDLogic = items;
         int psDEFDLogic = items.length;

         for (int fdLogicCatCodeListModel = 0; fdLogicCatCodeListModel < psDEFDLogic; fdLogicCatCodeListModel++) {
            String strItem = iPSDEFDLogic[fdLogicCatCodeListModel];
            strItem = strItem.trim();
            if (!this.valueItemNameList.contains(strItem)) {
               this.valueItemNameList.add(strItem);
            }
         }

         if (this.valueItemNameList.size() > 0) {
            this.strValueItemName = this.valueItemNameList.get(0);
         }
      }

      String strResetItemName = this.psDEFormDetail.getRESETITEMNAME();
      if (StringHelper.IsNullOrEmpty(strResetItemName) && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
         strResetItemName = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
      }

      if (StringHelper.IsNullOrEmpty(strResetItemName) && this.iPSDEFFormItem != null && this.iPSDEFFormItem.isEnableResetItemName()) {
         strResetItemName = this.iPSDEFFormItem.getResetItemName();
      }

      if (!StringHelper.IsNullOrEmpty(strResetItemName)) {
         this.resetItemNameList = new ArrayList<>();
         String[] items = StringHelper.SplitEx(strResetItemName);
         String[] var9 = items;
         int var35 = items.length;

         for (int var33 = 0; var33 < var35; var33++) {
            String strItem = var9[var33];
            strItem = strItem.trim();
            if (!this.resetItemNameList.contains(strItem)) {
               this.resetItemNameList.add(strItem);
               this.getPSDEForm().hookPSDEFormItem(strItem, this);
            }
         }

         if (this.resetItemNameList.size() > 0) {
            this.strResetItemName = this.resetItemNameList.get(0);
         }
      }

      if (!this.psDEFormDetail.isALLOWEMPTYNull()) {
         this.bAllowEmpty = this.psDEFormDetail.getALLOWEMPTY();
         this.bAllowEmptyDefined = true;
      } else if (!this.bHidden && this.iPSDEFFormItem != null && this.bAllowEmpty) {
         this.bAllowEmpty = this.iPSDEFFormItem.getAllowEmpty(this);
      }

      if (!this.bAllowEmpty && this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSDEField().isKeyDEField()) {
         this.bAllowEmpty = true;
      }

      this.getRefPickupPSAppView();
      this.getRefLinkPSAppView();
      if (this.iPSDEField != null) {
         this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
      }

      if (!this.psDEFormDetail.isENABLEITEMPRIVNull()) {
         this.bEnableItemPriv = this.psDEFormDetail.getENABLEITEMPRIV();
      }

      if (this.bEnableItemPriv && this.iPSDEField != null) {
         this.strPrivilegeId = StringHelper.Format("%1$s|%2$s", this.iPSDEField.getPSDataEntity().getName(), this.iPSDEField.getName());
         this.strPrivDEFieldName = this.iPSDEField.getName();
      }

      this.bEnableUnitName = true;
      if (this.iPSDEFFormItem != null) {
         if (StringHelper.IsNullOrEmpty(this.strUnitName)) {
            this.strUnitName = this.iPSDEFFormItem.getUnitName();
         }

         if (this.nUnitNameWidth <= 0) {
            this.nUnitNameWidth = this.iPSDEFFormItem.getUnitNameWidth();
         }

         if (this.iPSDEFInputTip == null) {
            this.iPSDEFInputTip = this.iPSDEFFormItem.getPSDEFInputTip();
         }
      }

      if (StringHelper.IsNullOrEmpty(this.strUnitName)) {
         this.bEnableUnitName = false;
      }

      if (!StringHelper.IsNullOrEmpty(this.getPSDEFIUpdateId())) {
         this.getPSDEForm().hookPSDEFormItem(this.getName(), this);
      }

      if (this.getPSEditorType() != null && !this.getPSEditorType().isEditable()) {
         this.bAllowEmpty = true;
         this.bEditable = false;
      }

      if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel
         && ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isHideEmptyItems()
         && this.getPSDEFDGroupLogic("PANELVISIBLE") == null) {
         ArrayList<PSDEFDLogic> psDEFDLogicList = new ArrayList<>();
         PSDEFDLogic child = new PSDEFDLogic();
         child.setPSDEFORMDETAILID(this.getId());
         child.setPSDEFORMDETAILNAME(this.getName());
         child.setFDNAME(this.getName());
         child.setLOGICTYPE("SINGLE");
         child.setPSDBVALUEOPID("ISNOTNULL");
         psDEFDLogicList.add(child);
         child = new PSDEFDLogic();
         child.setPSDEFORMDETAILID(this.getId());
         child.setPSDEFORMDETAILNAME(this.getName());
         child.setFDNAME(this.getName());
         child.setLOGICTYPE("SINGLE");
         child.setPSDBVALUEOPID("NOTEQ");
         child.setCONDVALUE("");
         psDEFDLogicList.add(child);
         FDLogicCatCodeListModel fdLogicCatCodeListModel = (FDLogicCatCodeListModel)CodeListGlobal.getCodeList(FDLogicCatCodeListModel.class);
         PSDEFDLogic psDEFDLogic = new PSDEFDLogic();
         psDEFDLogic.setPSDEFDLOGICID(KeyValueHelper.genUniqueId(this.getId(), "PANELVISIBLE"));
         psDEFDLogic.setPSDEFDLOGICNAME(
            StringHelper.Format("表单成员[%1$s][%2$s]逻辑", this.getName(), fdLogicCatCodeListModel.getCodeListText("PANELVISIBLE", true))
         );
         psDEFDLogic.setGROUPOP("AND");
         psDEFDLogic.setLOGICTYPE("GROUP");
         psDEFDLogic.setLOGICCAT("PANELVISIBLE");
         psDEFDLogic.getChildPSDEFDLogics(true).addAll(psDEFDLogicList);
         IPSDEFDCatGroupLogic iPSDEFDLogic = new PSDEFDCatGroupLogicImpl();
         iPSDEFDLogic.init(this.getDAGlobalHelper(), this, null, psDEFDLogic);
         if (iPSDEFDLogic.getPSDEFDLogics() != null) {
            this.registerPSDEFDGroupLogic("PANELVISIBLE", iPSDEFDLogic);
         }
      }

      if (this.bInfoMode) {
         this.removePSDEFDGroupLogic("ITEMBLANK");
      }

      this.preparePSEditor();
   }

   protected void preparePSEditor() throws Exception {
      this.getPSEditor();
   }

   protected boolean isInfoMode() {
      return this.bInfoMode;
   }

   protected void preparePSDEFFormItem() throws Exception {
   }

   protected void prepareDataItem() throws Exception {
   }

   protected String calcEditorCssStyle() throws Exception {
      StringBuilderEx editorCssStyle = new StringBuilderEx();
      if (this.getEditorHeight() > 0.0) {
         editorCssStyle.Append("height:%1$spx;", (int)this.getEditorHeight());
      }

      if (this.getEditorWidth() > 0.0) {
         editorCssStyle.Append("width:%1$spx;", (int)this.getEditorWidth());
      }

      return editorCssStyle.toString();
   }

   protected String calcLabelCssStyle() throws Exception {
      return this.psDEFormDetail.getLABELRAWCSSSTYLE();
   }

   protected String calcCtrlCssStyle() throws Exception {
      return "";
   }

   @PSModelRTMeta(description = "标题", fields = "CAPTION", doc = "非空白标题时返回配置的标题内容")
   @Override
   public String getCaption() {
      return this.isEmptyCaption() ? "" : super.getCaption();
   }

   @Override
   protected String onGetCaption() {
      return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.getCaption("") : super.onGetCaption();
   }

   @Override
   protected IPSLanguageRes onGetCapPSLanguageRes() {
      return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.getCapPSLanguageRes() : super.onGetCapPSLanguageRes();
   }

   @PSModelRTMeta(description = "标签位置", codelist = "FormItemLabelPos", fields = "LABELPOS")
   @Override
   public String getLabelPos() {
      return this.strLabelPos;
   }

   @PSModelRTMeta(description = "标签宽度", fields = "LABELWIDTH", ignoresetvalues = "130;0")
   @Override
   public int getLabelWidth() {
      return this.isShowCaption() ? this.nLabelWidth : 0;
   }

   @PSModelRTMeta(description = "隐藏表单项", ignoredumpvalues = "false", doc = "计算编辑器类型为隐藏项(HIDDEN)")
   @Override
   public boolean isHidden() {
      return this.bHidden;
   }

   @PSModelRTMeta(description = "编辑器类型", order = 292, dump = false)
   @Override
   public String getEditorType() {
      return this.strEditorType;
   }

   protected void setEditorType(String strEditorType) {
      this.strEditorType = strEditorType;
   }

   @PSModelRTMeta(description = "编辑器样式", order = 293, dump = false)
   @Override
   public String getEditorStyle() {
      return this.getPSSysEditorStyle() != null && this.getPSDEForm().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()
         ? this.getPSSysEditorStyle().getStyleCode()
         : this.strEditorStyle;
   }

   @Override
   public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
      psDEFormItemList.add(this);

      try {
         if (this.isRegisterToPSAppDataEntity() && this.getPSDEForm().getPSDataEntity() != null) {
            IPSDEDataSet iPSDEDataSet = this.getRefPSDEDataSet();
            if (iPSDEDataSet != null) {
               IPSAppDataEntity iPSAppDataEntity = this.getPSDEForm()
                  .getPSAppView()
                  .getPSApplication()
                  .getPSAppDataEntityByDEId(this.getPSDEForm().getPSDataEntity().getId(), true);
               if (iPSAppDataEntity != null) {
                  iPSAppDataEntity.registerRefPSDEDataSet(iPSDEDataSet, this);
               }
            }
         }
      } catch (Exception ex) {
         log.error(ex);
      }
   }

   @PSModelRTMeta(description = "编辑器宽度", order = 295, dump = false)
   @Override
   public double getEditorWidth() {
      return this.fEditorWidth;
   }

   @PSModelRTMeta(description = "编辑器高度", order = 300, dump = false)
   @Override
   public double getEditorHeight() {
      return this.fEditorHeight;
   }

   @PSModelRTMeta(description = "允许空值输入", fields = "ALLOWEMPTY")
   @Override
   public boolean isAllowEmpty() {
      return this.isEditable() ? this.onGetAllowEmpty() : true;
   }

   protected boolean onGetAllowEmpty() {
      return this.bAllowEmpty;
   }

   protected boolean isAllowEmptyDefined() {
      return this.bAllowEmptyDefined;
   }

   @PSModelRTMeta(description = "表单项宽度", ignoredumpvalues = "0.0")
   @Override
   public double getItemWidth() {
      if (this.getEditorWidth() <= 0.0) {
         return 0.0;
      } else {
         return this.isShowCaption() && this.getLabelPos() != "TOP" && this.getLabelPos() != "BOTTOM"
            ? this.getLabelWidth() + this.getEditorWidth()
            : this.getEditorWidth();
      }
   }

   @PSModelRTMeta(description = "表单项高度", ignoredumpvalues = "0.0")
   @Override
   public double getItemHeight() {
      if (this.getEditorHeight() <= 0.0) {
         return 0.0;
      } else {
         return this.isShowCaption() && this.getLabelPos() != "LEFT" && this.getLabelPos() != "RIGHT" ? this.getEditorHeight() + 20.0 : this.getEditorHeight();
      }
   }

   @PSModelRTMeta(description = "数据项")
   @Override
   public IDataItem getDataItem() {
      return this.psDataItemImpl;
   }

   @Override
   public Object getInputValue(IWebContext iWebContext) throws Exception {
      return null;
   }

   @Override
   public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
      return null;
   }

   @Override
   public String getPrivilegeId() {
      return this.strPrivilegeId;
   }

   protected void setPrivilegeId(String strPrivilegeId) {
      this.strPrivilegeId = strPrivilegeId;
   }

   @Override
   public String getPSCodeListId() {
      return this.strPSCodeListId;
   }

   @PSModelRTMeta(description = "值项名称", fields = "VALUEITEMNAME", ignorert = 3)
   @Override
   public String getValueItemName() {
      return this.strValueItemName;
   }

   @Override
   public IFIDEACMode getFIDEACMode() {
      return this.fiDEACModeImpl;
   }

   @Override
   public String getDEFName() {
      return this.getPSDEField() != null ? this.getPSDEField().getName() : "";
   }

   @Override
   public IForm getForm() {
      return this.getPSDEForm();
   }

   @Override
   public IDEField getDEField() {
      return this.getPSDEField();
   }

   @PSModelRTMeta(description = "相关实体属性")
   @Override
   public IPSDEField getPSDEField() {
      return this.iPSDEField;
   }

   @PSModelRTMeta(description = "应用实体属性", dumpref = true, from = "IPSDEForm", from_method = "getPSAppDataEntityMust().getPSAppDEField", fields = "PSDEFID")
   @Override
   public IPSAppDEField getPSAppDEField() {
      return this.iPSAppDEField;
   }

   @Override
   public Iterator<IFIDEFValueRule> getFIDEFValueRules() {
      return this.fiDEFValueRuleList != null && this.fiDEFValueRuleList.size() != 0 ? this.fiDEFValueRuleList.iterator() : null;
   }

   @PSModelRTMeta(description = "值规则集合")
   @Override
   public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
      return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.getPSFIDEFValueRules() : null;
   }

   @Override
   public IPSDEFFormItem getPSDEFFormItem() {
      return this.iPSDEFFormItem;
   }

   protected void setPSDEFFormItem(IPSDEFFormItem iPSDEFFormItem) {
      this.iPSDEFFormItem = iPSDEFFormItem;
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
   }

   @PSModelRTMeta(description = "引用实体选择视图", hideempty = true, dump = false)
   @Override
   public IPSAppView getRefPickupPSAppView() throws Exception {
      String strPickupPSDEViewId = this.psDEFormDetail.getPICKUPPSDEVIEWID();
      if (StringHelper.IsNullOrEmpty(strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFFormItem != null) {
         strPickupPSDEViewId = this.iPSDEFFormItem.getRefPickupPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication());
      }

      if (!StringHelper.IsNullOrEmpty(strPickupPSDEViewId)) {
         String strPSAppViewId = Helper.GenUniqueId(this.getPSDEForm().getPSAppView().getPSApplication().getId(), strPickupPSDEViewId);
         IPSAppView refPickupPSAppView = this.getPSDEForm()
            .getPSAppView()
            .getPSApplication()
            .getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEForm().getPSAppView());
         refPickupPSAppView.markViewUsage(2, this);
         return refPickupPSAppView;
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "引用实体链接视图", hideempty = true, dump = false)
   @Override
   public IPSAppView getRefLinkPSAppView() throws Exception {
      String strLinkPSDEViewId = this.psDEFormDetail.getLINKPSDEVIEWID();
      if (StringHelper.IsNullOrEmpty(strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFFormItem != null) {
         strLinkPSDEViewId = this.iPSDEFFormItem.getRefLinkPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication());
      }

      if (!StringHelper.IsNullOrEmpty(strLinkPSDEViewId)) {
         String strPSAppViewId = Helper.GenUniqueId(this.getPSDEForm().getPSAppView().getPSApplication().getId(), strLinkPSDEViewId);
         IPSAppView refLinkPSAppView = this.getPSDEForm()
            .getPSAppView()
            .getPSApplication()
            .getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDEForm().getPSAppView());
         refLinkPSAppView.markViewUsage(2, this);
         return refLinkPSAppView;
      } else {
         return null;
      }
   }

   @PSModelRTMeta(description = "项后台处理类型", dump = false)
   @Override
   public String getItemHandlerType() {
      if (!StringHelper.IsNullOrEmpty(this.strItemHandlerType)) {
         return StringHelper.Compare(this.strItemHandlerType, "None", true) == 0 ? "" : this.strItemHandlerType;
      }

      try {
         if (this.getPSEditor() != null && !this.getPSEditor().isEditable()) {
            return "";
         }
      } catch (Exception ex) {
         log.error(ex);
      }

      if (this.iPSDEFFormItem != null) {
         return this.iPSDEFFormItem.getItemHandlerType(this);
      } else if (StringHelper.Compare(this.getPSEditorType().getStandardPSEditorType(), "DROPDOWNLIST", true) == 0
         && this.getPSCodeList() != null
         && StringHelper.Compare(this.getPSCodeList().getCodeListType(), "DYNAMIC", true) == 0) {
         return "CodeList";
      } else {
         return StringHelper.Compare(this.getPSEditorType().getStandardPSEditorType(), "AC", true) == 0 ? "AC" : "";
      }
   }

   @PSModelRTMeta(description = "代码表对象", dump = false)
   @Override
   public IPSCodeList getPSCodeList() {
      return this.iPSCodeList;
   }

   @PSModelRTMeta(description = "启用条件", codelist = "FormItemEnableCond", fields = "ENABLECOND")
   @Override
   public int getEnableCond() {
      return this.nEnableCond;
   }

   @PSModelRTMeta(description = "显示标题", ignoredumpvalues = "false", doc = "计算{@link #getLabelPos}值不为不显式(NONE)")
   @Override
   public boolean isShowCaption() {
      return this.bShowCaption;
   }

   @PSModelRTMeta(description = "建立默认值类型", codelist = "FieldDefaultValueType", fields = "CREATEDVT")
   @Override
   public String getCreateDVT() {
      return this.strCreateDVT;
   }

   protected void setCreateDVT(String strCreateDVT) {
      this.strCreateDVT = strCreateDVT;
   }

   @PSModelRTMeta(description = "建立默认值", fields = "CREATEDV")
   @Override
   public String getCreateDV() {
      return this.strCreateDV;
   }

   protected void setCreateDV(String strCreateDV) {
      this.strCreateDV = strCreateDV;
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

   @Override
   public ICodeList getCodeList() throws Exception {
      return this.getPSCodeList();
   }

   @PSModelRTMeta(description = "支持编辑", dump = false)
   @Override
   public boolean isEditable() {
      return this.bEditable;
   }

   @Override
   public String getCapLanId() {
      return this.getCapLanResTag();
   }

   @PSModelRTMeta(description = "编辑器项参数", dump = false)
   @Override
   public JSONObject getItemParam() throws Exception {
      if (this.itemParamJO != null) {
         return this.itemParamJO;
      } else {
         String strItemParam = this.getEditorParam("ITEMPARAM", null);
         if (!StringHelper.IsNullOrEmpty(strItemParam)) {
            this.itemParamJO = JSONObjectHelper.fromString2(strItemParam);
            return this.itemParamJO;
         } else if (this.iPSDEFFormItem != null) {
            this.itemParamJO = this.iPSDEFFormItem.getItemParam(this);
            return this.itemParamJO;
         } else {
            return null;
         }
      }
   }

   @PSModelRTMeta(description = "引用实体数据集", hideempty = true, dump = false)
   @Override
   public IPSDEDataSet getRefPSDEDataSet() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEID())) {
         IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
         if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEDATASETID())) {
            return refPSDataEntity.getPSDEDataSet(this.psDEFormDetail.getREFPSDEDATASETID());
         } else {
            return this.isRegisterToPSAppDataEntity() ? refPSDataEntity.getDefaultPSDEDataSet() : null;
         }
      } else {
         if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefPSDEDataSetId())) {
               return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFFormItem.getRefPSDEDataSetId());
            }

            if (this.isRegisterToPSAppDataEntity()) {
               return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEDataSet();
            }
         }

         return null;
      }
   }

   @PSModelRTMeta(description = "引用实体数据集上下文逻辑", hideempty = true, dump = false)
   @Override
   public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEID())) {
         return null;
      } else {
         return this.iPSDEFFormItem != null
               && this.iPSDEFFormItem.getRefPSDataEntity() != null
               && !StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefActiveDataPSDELogicId())
            ? this.iPSDEFFormItem.getRefPSDataEntity().getPSDELogic(this.iPSDEFFormItem.getRefActiveDataPSDELogicId())
            : null;
      }
   }

   @PSModelRTMeta(description = "引用实体对象", hideempty = true, dump = false)
   @Override
   public IPSDataEntity getRefPSDataEntity() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEID())) {
         return this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
      } else {
         return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.getRefPSDataEntity() : null;
      }
   }

   @PSModelRTMeta(description = "引用实体自填模式", hideempty = true, dump = false)
   @Override
   public IPSDEACMode getRefPSDEACMode() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEID())) {
         IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
         if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEACMODEID())) {
            return refPSDataEntity.getPSDEACMode(this.psDEFormDetail.getREFPSDEACMODEID());
         } else {
            return this.isRegisterToPSAppDataEntity() ? refPSDataEntity.getDefaultPSDEACMode() : null;
         }
      } else {
         if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefPSDEACModeId())) {
               return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEACMode(this.iPSDEFFormItem.getRefPSDEACModeId());
            }

            if (this.isRegisterToPSAppDataEntity()) {
               return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEACMode();
            }
         }

         return null;
      }
   }

   @PSModelRTMeta(description = "引用实体关系", hideempty = true, dump = false)
   @Override
   public IPSDERBase getRefPSDER() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psDEFormDetail.getREFPSDEID())) {
         return null;
      } else {
         return this.iPSDEFFormItem != null && !StringHelper.IsNullOrEmpty(this.iPSDEFFormItem.getRefPSDERId())
            ? this.iPSDEFFormItem.getPSDEField().getPSDataEntity().getPSSystem().getPSDER(this.iPSDEFFormItem.getRefPSDERId())
            : null;
      }
   }

   @PSModelRTMeta(description = "编辑器类型")
   @Override
   public IPSEditorType getPSEditorType() {
      return this.iPSEditorType;
   }

   @Override
   public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
      return null;
   }

   @Override
   public String getPSDEFIUpdateId() {
      return this.psDEFormDetail.getPSDEFIUPDATEID();
   }

   @PSModelRTMeta(description = "表单项更新", dumpref = true, from = "IPSDEForm", fields = "PSDEFIUPDATEID")
   @Override
   public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
      return StringHelper.IsNullOrEmpty(this.getPSDEFIUpdateId()) ? null : this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
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
      if (StringHelper.IsNullOrEmpty(strDefault) && StringHelper.IsNullOrEmpty(strValue) && strDefault != null) {
         if (StringHelper.Compare("WRAPMODE", strParam, false) == 0) {
            return this.psDEFormDetail.getSWAPMODE();
         }

         if (StringHelper.Compare("HALIGN", strParam, false) == 0) {
            return this.psDEFormDetail.getHALIGN();
         }

         if (StringHelper.Compare("VALIGN", strParam, false) == 0) {
            return this.psDEFormDetail.getVALIGN();
         }

         if (StringHelper.Compare("DEFAULTREADONLY", strParam, false) == 0) {
            if (this.bInfoReadOnlyMode) {
               return "true";
            }

            if ((this.psDEFormDetail.getITEMSTATES() & 1) != 0) {
               return "true";
            }

            return strValue;
         }

         if (StringHelper.Compare("DEFAULTDISABLED", strParam, false) == 0) {
            if ((this.psDEFormDetail.getITEMSTATES() & 2) != 0) {
               return "true";
            }

            return strValue;
         }
      }

      return strValue;
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
   public String getCodeListId() {
      return this.getPSCodeListId();
   }

   @Override
   public String getPSSysValueRuleId() {
      return this.strPSSysValueRuleId;
   }

   @Override
   public String getValueRuleId() {
      return this.getPSSysValueRuleId();
   }

   @PSModelRTMeta(description = "忽略输入模式", fields = "IGNOREINPUT")
   @Override
   public int getIgnoreInput() {
      return this.nIgnoreInput;
   }

   protected void setIgnoreInput(int nIgnoreInput) {
      this.nIgnoreInput = nIgnoreInput;
   }

   @PSModelRTMeta(description = "转换为代码项文本", ignoredumpvalues = "false", fields = "CONVERTCITEXT")
   @Override
   public boolean isConvertToCodeItemText() {
      if (StringHelper.IsNullOrEmpty(this.getPSCodeListId())) {
         return false;
      } else {
         return this.bConvertToCodeItemText != null ? this.bConvertToCodeItemText : this.getPSEditorType().isConvertToCodeItemText();
      }
   }

   @Override
   public int getLabelColSpan() {
      return this.nLabelColSpan;
   }

   @Override
   public int getCtrlColSpan() {
      return this.nCtrlColSpan;
   }

   @Override
   protected void onLayout() throws Exception {
      super.onLayout();
      if (this.parentPSDEFormGroupPanel != null
         && (
            StringHelper.Compare(this.parentPSDEFormGroupPanel.getLayoutMode(), "TABLE_12COL", true) == 0
               || StringHelper.Compare(this.parentPSDEFormGroupPanel.getLayoutMode(), "TABLE_24COL", true) == 0
         )) {
         if (this.isShowCaption()) {
            if (this.psDEFormDetail.getLABELCOLSPAN() > 0) {
               this.nLabelColSpan = this.psDEFormDetail.getLABELCOLSPAN();
            }
         } else {
            this.nLabelColSpan = 0;
         }

         if (this.psDEFormDetail.getCTRLCOLSPAN() > 0) {
            this.nCtrlColSpan = this.psDEFormDetail.getCTRLCOLSPAN();
         }
      }
   }

   @Override
   public int getLabelRealColSpan() {
      return -1;
   }

   @Override
   public int getCtrlRealColSpan() {
      return -1;
   }

   @PSModelRTMeta(description = "标签列布局样式", hideempty2 = true, dump = false)
   @Override
   public String getLabelColCssClass() {
      return this.nLabelColSpan > 0 ? StringHelper.Format("col-md-%1$s", this.nLabelColSpan) : "";
   }

   @PSModelRTMeta(description = "控件列布局样式", hideempty2 = true, dump = false)
   @Override
   public String getCtrlColCssClass() {
      return this.nCtrlColSpan > 0 ? StringHelper.Format("col-md-%1$s", this.nCtrlColSpan) : "";
   }

   @Override
   public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception {
      return null;
   }

   @PSModelRTMeta(description = "需要代码表配置", ignoredumpvalues = "false", fields = "NEEDCODELISTCONFIG")
   @Override
   public boolean isNeedCodeListConfig() {
      return this.bNeedCodeListConfig;
   }

   @PSModelRTMeta(description = "输出代码表配置模式", codelist = "OutputCodeListConfigMode", ignoredumpvalues = "0", fields = "CODELISTCONFIGMODE")
   @Override
   public int getOutputCodeListConfigMode() {
      return this.nOutputCodeListConfig;
   }

   @PSModelRTMeta(description = "标签直接样式", hideempty2 = true)
   @Override
   public String getLabelCssStyle() {
      return this.strLabelCssStyle;
   }

   @PSModelRTMeta(description = "标签动态样式表", hideempty2 = true, fields = "LABELDYNACLASS")
   @Override
   public String getLabelDynaClass() {
      return this.psDEFormDetail.getLABELDYNACLASS();
   }

   @Override
   public String getCtrlCssStyle() {
      return this.strCtrlCssStyle;
   }

   @Override
   public String getEditorCssStyle() {
      return this.strEditorCssStyle;
   }

   @Override
   public String getValueTranslator() {
      return this.strValueProcessor;
   }

   @PSModelRTMeta(description = "重置项名称", ignorert = 3, hideempty2 = true)
   @Override
   public String getResetItemName() {
      return this.strResetItemName;
   }

   @PSModelRTMeta(description = "重置项名称集合", hideempty2 = true, child = true, fields = "RESETITEMNAME")
   @Override
   public Iterator<String> getResetItemNames() {
      return this.resetItemNameList != null && this.resetItemNameList.size() != 0 ? this.resetItemNameList.iterator() : null;
   }

   @Override
   public String getUserDictCatId() {
      return this.strPSSysDictCatId;
   }

   @PSModelRTMeta(description = "是否空白标签", ignoredumpvalues = "false", fields = "EMPTYCAPTION")
   @Override
   public boolean isEmptyCaption() {
      return this.bEmptyCaption;
   }

   @PSModelRTMeta(description = "输入提示信息", dump = false)
   @Override
   public String getPlaceHolder() {
      return this.strPlaceHolder;
   }

   @PSModelRTMeta(description = "表单项图片对象", fields = "PSSYSIMAGEID")
   @Override
   public IPSSysImage getPSSysImage() {
      if (super.getPSSysImage() != null) {
         return super.getPSSysImage();
      } else {
         return this.getPSDEFFormItem() != null ? this.getPSDEFFormItem().getPSSysImage() : null;
      }
   }

   @PSModelRTMeta(description = "系统编辑器样式")
   @Override
   public IPSSysEditorStyle getPSSysEditorStyle() {
      return this.iPSSysEditorStyle;
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
   public String getPrivFieldName() {
      return this.strPrivDEFieldName;
   }

   @PSModelRTMeta(description = "支持单位", ignoredumpvalues = "false")
   @Override
   public boolean isEnableUnitName() {
      return this.bEnableUnitName;
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

   @PSModelRTMeta(description = "输入提示")
   @Override
   public IPSDEFInputTip getPSDEFInputTip() {
      return this.iPSDEFInputTip;
   }

   @PSModelRTMeta(description = "输入提示信息", fields = "INPUTTIP")
   @Override
   public String getInputTip() {
      if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
         return null;
      } else {
         return this.getPSDEFInputTip() == null ? null : this.getPSDEFInputTip().getContent();
      }
   }

   @PSModelRTMeta(description = "输入提示链接", fields = "INPUTTIPURL")
   @Override
   public String getInputTipUrl() {
      if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
         return null;
      } else {
         return this.getPSDEFInputTip() == null ? null : this.getPSDEFInputTip().getMoreUrl();
      }
   }

   @PSModelRTMeta(description = "输入提示支持关闭", ignoredumpvalues = "false", fields = "INPUTTIPCLOSABLE")
   @Override
   public boolean isInputTipClosable() {
      return this.getPSDEFInputTip() == null ? false : this.getPSDEFInputTip().isEnableClose();
   }

   @PSModelRTMeta(description = "输入提示语言资源")
   @Override
   public IPSLanguageRes getPHPSLanguageRes() {
      return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.getPHPSLanguageRes() : null;
   }

   @Override
   public String getPHLanResTag() {
      return this.getPHPSLanguageRes() != null ? this.getPHPSLanguageRes().getLanResTag() : null;
   }

   @PSModelRTMeta(description = "输入提示信息语言标记", fields = "INPUTTIPLANRESTAG")
   @Override
   public String getInputTipLanResTag() {
      if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
         return null;
      } else {
         return this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getContentPSLanguageRes() != null
            ? this.getPSDEFInputTip().getContentPSLanguageRes().getLanResTag()
            : null;
      }
   }

   protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
      PSACHandler psACHandler = this.getPSDEForm().getPSDataEntity().getPSAjaxControlHandlerData(strPSACHandlerId);
      PSDEFormItemAjaxHandlerImpl psAjaxHandlerImpl = new PSDEFormItemAjaxHandlerImpl();
      psAjaxHandlerImpl.init(this.getDAGlobalHelper(), this, psACHandler);
      return psAjaxHandlerImpl;
   }

   @PSModelRTMeta(description = "项后台处理对象")
   @Override
   public IPSAjaxHandler getItemPSAjaxHandler() {
      return this.itemPSAjaxHandler;
   }

   @Override
   public String getInputTipSetId() {
      return this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getPSDEFInputTipSet() != null
         ? this.getPSDEFInputTip().getPSDEFInputTipSet().getId()
         : null;
   }

   @PSModelRTMeta(description = "输入提示全局标记", fields = "INPUTTIPUNIQUETAG")
   @Override
   public String getInputTipUniqueTag() {
      if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
         return null;
      } else {
         return this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getPSDEFInputTipSet() != null ? this.getPSDEFInputTip().getUniqueTag() : null;
      }
   }

   @Override
   public int getWriteBackDEFMode() {
      return this.nWriteBackDEFMode;
   }

   @Override
   public String getModelType() {
      return "PSDEFORMDETAIL_FORMITEM";
   }

   @Override
   public String getModelName() {
      return !StringHelper.IsNullOrEmpty(this.getCaption()) ? StringHelper.Format("%1$s#%2$s", this.getName(), this.getCaption()) : super.getModelName();
   }

   @PSModelRTMeta(description = "无权限显示模式", codelist = "NoPrivDisplayModes", fields = "NOPRIVDM")
   @Override
   public int getNoPrivDisplayMode() {
      return this.nNoPrivDisplayMode;
   }

   @PSModelRTMeta(description = "绑定的值项集合")
   @Override
   public String[] getValueItemNames() {
      return this.valueItemNameList != null && this.valueItemNameList.size() != 0
         ? this.valueItemNameList.toArray(new String[this.valueItemNameList.size()])
         : null;
   }

   @PSModelRTMeta(description = "复合表单项", ignoredumpvalues = "false")
   @Override
   public boolean isCompositeItem() {
      return false;
   }

   @Override
   public String getEditorContainer() {
      return "FORMITEM";
   }

   protected boolean isRegisterToPSAppDataEntity() {
      return this.getPSDEForm().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
   }

   @PSModelRTMeta(description = "引用临时数据", dump = false)
   @Override
   public boolean isRefTempData() {
      if (this.getPSDEForm().getPSAjaxControlHandler() != null && this.getPSDEForm().getPSAjaxControlHandler().getTempMode() == 0) {
         return false;
      } else {
         return this.iPSDEFFormItem != null ? this.iPSDEFFormItem.isRefTempData() : false;
      }
   }

   @Override
   public int getStdDataType() {
      if (this.getPSDEField() != null) {
         return this.isConvertToCodeItemText() ? 25 : this.getPSDEField().getStdDataType();
      } else {
         return 25;
      }
   }

   @PSModelRTMeta(description = "标准数据类型", codelist = "StdDataType")
   @Override
   public int getDataType() {
      return this.getStdDataType();
   }

   @Override
   protected String getDefaultDetailStyle() {
      return this.getPSDEForm().getDefaultFormItemStyle();
   }

   @PSModelRTMeta(description = "编辑器对象", child = true)
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
      return this.getPSDEForm();
   }

   @PSModelRTMeta(description = "动态标题绑定值项", fields = "LEVELTAG")
   @Override
   public String getCaptionItemName() {
      return this.psDEFormDetail.getLEVELTAG();
   }

   @PSModelRTMeta(description = "提供锚点", ignoredumpvalues = "false", fields = "ENABLEANCHOR")
   @Override
   public boolean isEnableAnchor() {
      return this.bEnableAnchor;
   }

   @PSModelRTMeta(description = "支持输入提示", ignoredumpvalues = "false", fields = "ENABLEINPUTTIP")
   @Override
   public boolean isEnableInputTip() {
      if (this.isEnableInputTipDefined()) {
         return this.bEnableInputTip;
      } else {
         return this.getPSDEForm().getPSAppDEFInputTipSet() != null
            ? true
            : !StringHelper.IsNullOrEmpty(this.getInputTip())
               || this.getPSDEFInputTip() != null && !StringHelper.IsNullOrEmpty(this.getPSDEFInputTip().getUniqueTag());
      }
   }

   protected boolean isEnableInputTipDefined() {
      return this.bEnableInputTipDefined;
   }

   @Override
   public String getPSSysDictCatId() {
      return this.strPSSysDictCatId;
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      super.onFillModelRefNode(objectNode, strModelRefType);
      if (this.isHidden()) {
         objectNode.put("hidden", this.isHidden());
      }

      objectNode.put("dataType", this.getDataType());
      if (!StringHelper.IsNullOrEmpty(this.getCreateDVT())) {
         objectNode.put("createDVT", this.getCreateDVT());
      }

      if (!StringHelper.IsNullOrEmpty(this.getCreateDV())) {
         objectNode.put("createDV", this.getCreateDV());
      }

      if (!StringHelper.IsNullOrEmpty(this.getUpdateDVT())) {
         objectNode.put("updateDVT", this.getUpdateDVT());
      }

      if (!StringHelper.IsNullOrEmpty(this.getUpdateDV())) {
         objectNode.put("updateDV", this.getUpdateDV());
      }

      if (this.getPSAppDEField() != null) {
         objectNode.put("getPSAppDEField", this.getPSAppDEField().getModelRef());
      }

      objectNode.remove("modelref");
   }

   @Override
   protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
      super.onFillModelNode(objectNode, strModelType);
      if (this.isHidden()) {
         objectNode.remove("showCaption");
         objectNode.remove("DetailStyle");
      }
   }

   @Override
   public IPSSysValueRule getPSSysValueRule() throws Exception {
      IPSSysValueRule iPSSysValueRule = this.onGetPSSysValueRule();
      if (iPSSysValueRule != null) {
         return iPSSysValueRule instanceof IPSAppValueRule
            ? iPSSysValueRule
            : this.getPSDEForm().getPSAppView().getPSApplication().getPSAppValueRule(iPSSysValueRule.getId());
      } else {
         return iPSSysValueRule;
      }
   }

   protected IPSSysValueRule onGetPSSysValueRule() throws Exception {
      return null;
   }

   @PSModelRTMeta(description = "值格式化", fields = "VALUEFORMAT")
   @Override
   public String getValueFormat() {
      return this.psDataItemImpl != null ? this.psDataItemImpl.getFormat() : "";
   }

   @Override
   public String getEditorDynaClass() {
      return this.psDEFormDetail.getCTRLDYNACLASS();
   }

   @Override
   public String getEditorCssStyle2() {
      return this.psDEFormDetail.getCTRLRAWCSSSTYLE();
   }

   @Override
   public IPSSysCss getEditorPSSysCss() {
      if (this.getCtrlPSSysCss() != null) {
         return this.getCtrlPSSysCss();
      } else {
         return this.getPSSysEditorStyle() != null ? this.getPSSysEditorStyle().getPSSysCss() : null;
      }
   }

   @PSModelRTMeta(description = "绑定属性", fields = "FIELDNAME")
   @Override
   public String getFieldName() {
      return this.psDEFormDetail.getFIELDNAME();
   }

   protected class FIDEACModeImpl implements IFIDEACMode {
      private String strDEName = "";
      private String strDEACModeName = "";

      @Override
      public String getDEName() {
         return this.strDEName;
      }

      @Override
      public String getDEACModeName() {
         return this.strDEACModeName;
      }

      public void setDEName(String strDEName) {
         this.strDEName = strDEName;
      }

      public void setDEACModeName(String strDEACModeName) {
         this.strDEACModeName = strDEACModeName;
      }
   }
}
