/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.form.IFIDEACMode
 *  net.ibizsys.paas.control.form.IFIDEFValueRule
 *  net.ibizsys.paas.control.form.IForm
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.ValueRule.IPSAppValueRule;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItemUpdate;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.Control.Form.PSDEFDCatGroupLogicImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDataItemImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormDetailImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelRTMeta;
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
import com.fasterxml.jackson.databind.JsonNode;
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

public class PSDEFormItemImpl
extends PSDEFormDetailImpl
implements IPSDEFormItem {
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
    protected FIDEACModeImpl fiDEACModeImpl = null;
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

    /*
     * WARNING - void declaration
     */
    @Override
    protected void onInit() throws Exception {
        String strResetItemName;
        int n;
        void var3_16;
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
        this.editorParams = PropertiesHelper.load((String)this.psDEFormDetail.getEDITORPARAMS());
        if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = this.psDEFormDetail.getEDITORTYPE();
        }
        this.strEditorStyle = this.psDEFormDetail.getPSSYSEDITORSTYLEID();
        if (!StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.bDefineEditorType = true;
        }
        if (!this.psDEFormDetail.isWBDEFMODENull()) {
            this.nWriteBackDEFMode = this.psDEFormDetail.getWBDEFMODE();
        }
        if (!this.psDEFormDetail.isCONVERTCITEXTNull()) {
            this.bConvertToCodeItemText = this.psDEFormDetail.getCONVERTCITEXT();
        }
        this.nNoPrivDisplayMode = !this.psDEFormDetail.isNOPRIVDMNull() ? this.psDEFormDetail.getNOPRIVDM() : this.getPSDEForm().getPSAppView().getPSApplication().getPSApplicationUI().getFormItemNoPrivDisplayMode();
        String strItemPSACHandlerId = null;
        this.preparePSDEFFormItem();
        if (this.getPSDEFFormItem() != null) {
            void var3_6;
            strItemPSACHandlerId = this.getPSDEFFormItem().getPSAjaxHandlerId();
            boolean bl = false;
            if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.iPSDEFFormItem.getEditorType();
                boolean bl2 = true;
            } else if (StringHelper.Compare((String)this.strEditorType, (String)this.iPSDEFFormItem.getEditorType(), (boolean)true) == 0) {
                boolean bl3 = true;
            }
            if (var3_6 != false) {
                for (Object objKey : this.iPSDEFFormItem.getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(objKey)) continue;
                    this.editorParams.put(objKey, this.iPSDEFFormItem.getEditorParams().get(objKey));
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                this.strEditorStyle = this.iPSDEFFormItem.getEditorStyle();
            }
        }
        if (this.isDesignMode()) {
            this.strEditorStyle = "";
            if (StringHelper.Compare((String)this.getEditorType(), (String)"USERCONTROL", (boolean)true) == 0) {
                this.strEditorType = "SPAN";
                this.bDefineEditorType = true;
                this.strEditorStyle = "";
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = "TEXTBOX";
            if (this.getPSDEForm().getPSAppView() != null && this.getPSDEForm().getPSAppView().getPSApplication() != null && this.getPSDEForm().getPSAppView().getPSApplication().isMobileApp()) {
                this.strEditorType = "MOBTEXT";
            }
        }
        boolean bl = this.bHidden = StringHelper.Compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
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
                    Object linkPSAppView;
                    String string;
                    if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getLINKPSDEVIEWID())) {
                        this.strEditorType = "PICKEREX_LINKONLY";
                    } else if (this.getPSDEFFormItem() != null && !StringHelper.IsNullOrEmpty((String)(string = this.getPSDEFFormItem().getRefLinkPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication()))) && (linkPSAppView = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppViewByDEViewId(string, true)) != null) {
                        this.strEditorType = "PICKEREX_LINKONLY";
                    }
                }
                this.strEditorStyle = "";
                this.bDefineEditorType = true;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            this.strValueProcessor = this.iPSEditorType.getValueProcessor();
            if (!StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "FORMITEM");
            } else if (!this.isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "FORMITEM");
            }
            if (this.getPSSysEditorStyle() != null) {
                this.strItemHandlerType = this.getPSSysEditorStyle().getAjaxHandlerType();
                if (StringHelper.IsNullOrEmpty((String)strItemPSACHandlerId)) {
                    strItemPSACHandlerId = this.getPSSysEditorStyle().getPSAjaxHandlerId();
                }
                for (Object e : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(e)) continue;
                    this.editorParams.put(e, this.getPSSysEditorStyle().getEditorParams().get(e));
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strItemHandlerType)) {
                this.strItemHandlerType = this.getPSEditorType().getAjaxHandlerType();
            }
            for (Object e : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(e)) continue;
                this.editorParams.put(e, this.iPSEditorType.getEditorParams().get(e));
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strItemPSACHandlerId)) {
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
            boolean bl4 = false;
            if (this.bDefineEditorType) {
                boolean bl5;
                if (this.iPSDEFFormItem != null && StringHelper.Compare((String)this.strEditorType, (String)this.iPSDEFFormItem.getEditorType(), (boolean)true) == 0) {
                    this.fEditorWidth = this.iPSDEFFormItem.getEditorWidth();
                    this.fEditorHeight = this.iPSDEFFormItem.getEditorHeight();
                    bl5 = true;
                }
                if (!bl5) {
                    this.fEditorWidth = this.getPSEditorType().getWidth(this.getPSDEForm().getPSAppView().getPSApplication().getPSPF().getId());
                    this.fEditorHeight = this.getPSEditorType().getHeight(this.getPSDEForm().getPSAppView().getPSApplication().getPSPF().getId());
                    String strEditorWidthKey = StringHelper.Format((String)"EDITOR.%1$s.WIDTH", (Object)this.getPSEditorType().getId()).toUpperCase();
                    String strEditorHeightKey = StringHelper.Format((String)"EDITOR.%1$s.HEIGHT", (Object)this.getPSEditorType().getId()).toUpperCase();
                    this.fEditorWidth = this.getPSDEForm().getPSAppView().getPSApplication().getPFStyleParam(strEditorWidthKey, this.fEditorWidth);
                    this.fEditorHeight = this.getPSDEForm().getPSAppView().getPSApplication().getPFStyleParam(strEditorHeightKey, this.fEditorHeight);
                }
            } else if (this.iPSDEFFormItem != null) {
                this.fEditorWidth = this.iPSDEFFormItem.getEditorWidth();
                this.fEditorHeight = this.iPSDEFFormItem.getEditorHeight();
                boolean bl6 = true;
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
        if (StringHelper.IsNullOrEmpty((String)this.strPSCodeListId) && this.iPSDEFFormItem != null) {
            this.strPSCodeListId = this.iPSDEFFormItem.getPSCodeListId();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPLACEHOLDER())) {
            this.strPlaceHolder = this.psDEFormDetail.getPLACEHOLDER();
        } else if (this.getPSDEFFormItem() != null) {
            this.strPlaceHolder = this.getPSDEFFormItem().getPlaceHolder();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getPSSYSDICTCATID())) {
            this.strPSSysDictCatId = this.psDEFormDetail.getPSSYSDICTCATID();
        } else if (this.getPSDEFFormItem() != null) {
            this.strPSSysDictCatId = this.getPSDEFFormItem().getPSSysDictCatId();
        }
        if (this.iPSDEFFormItem != null) {
            this.strPSSysValueRuleId = this.iPSDEFFormItem.getPSSysValueRuleId();
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSFIDEFValueRules() != null) {
            Iterator<IPSFIDEFValueRule> iterator = this.iPSDEFFormItem.getPSFIDEFValueRules();
            while (iterator.hasNext()) {
                if (this.fiDEFValueRuleList == null) {
                    this.fiDEFValueRuleList = new ArrayList();
                }
                this.fiDEFValueRuleList.add(iterator.next());
            }
        }
        if (this.iPSDEFFormItem != null && !StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEId()) && !StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEACModeId())) {
            this.fiDEACModeImpl = new FIDEACModeImpl();
            this.fiDEACModeImpl.setDEACModeName(this.iPSDEFFormItem.getRefPSDEACModeName());
            this.fiDEACModeImpl.setDEName(this.iPSDEFFormItem.getRefPSDEName());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
        }
        if (this.iPSCodeList != null) {
            this.iPSCodeList = this.getPSDEForm().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
        }
        this.bShowCaption = StringHelper.Compare((String)this.psDEFormDetail.getLABELPOS(), (String)"NONE", (boolean)true) != 0;
        this.strCreateDVT = this.psDEFormDetail.getCREATEDVT();
        this.strCreateDV = this.psDEFormDetail.getCREATEDV();
        this.strUpdateDVT = this.psDEFormDetail.getUPDATEDVT();
        this.strUpdateDV = this.psDEFormDetail.getUPDATEDV();
        if (this.iPSDEFFormItem != null) {
            if (StringHelper.IsNullOrEmpty((String)this.strCreateDVT)) {
                this.strCreateDVT = this.iPSDEFFormItem.getCreateDVT();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strCreateDV)) {
                this.strCreateDV = this.iPSDEFFormItem.getCreateDV();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strUpdateDVT)) {
                this.strUpdateDVT = this.iPSDEFFormItem.getUpdateDVT();
            }
            if (StringHelper.IsNullOrEmpty((String)this.strUpdateDV)) {
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
                if (this.getPSDEFFormItem() != null && StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                    this.bNeedCodeListConfig = this.getPSDEFFormItem().isNeedCodeListConfig();
                }
            }
            if (!this.psDEFormDetail.isCODELISTCONFIGMODENull()) {
                this.nOutputCodeListConfig = this.psDEFormDetail.getCODELISTCONFIGMODE();
            } else {
                this.nOutputCodeListConfig = this.getPSEditorType().getOutputCodeListConfigMode();
                if (this.getPSDEFFormItem() != null && StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                    this.nOutputCodeListConfig = this.getPSDEFFormItem().getOutputCodeListConfigMode();
                }
            }
        }
        this.prepareDataItem();
        this.strEditorCssStyle = this.calcEditorCssStyle();
        this.strCtrlCssStyle = this.calcCtrlCssStyle();
        this.strLabelCssStyle = this.calcLabelCssStyle();
        String string = this.psDEFormDetail.getVALUEITEMNAME();
        if (StringHelper.IsNullOrEmpty((String)string) && this.iPSDEFFormItem != null) {
            String string2 = this.iPSDEFFormItem.getValueItemName(this);
        }
        if (!StringHelper.IsNullOrEmpty((String)var3_16)) {
            String[] items;
            this.valueItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)var3_16);
            n = items.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray[n2];
                if (!this.valueItemNameList.contains(strItem = strItem.trim())) {
                    this.valueItemNameList.add(strItem);
                }
                ++n2;
            }
            if (this.valueItemNameList.size() > 0) {
                this.strValueItemName = this.valueItemNameList.get(0);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)(strResetItemName = this.psDEFormDetail.getRESETITEMNAME())) && this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
            strResetItemName = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
        }
        if (StringHelper.IsNullOrEmpty((String)strResetItemName) && this.iPSDEFFormItem != null && this.iPSDEFFormItem.isEnableResetItemName()) {
            strResetItemName = this.iPSDEFFormItem.getResetItemName();
        }
        if (!StringHelper.IsNullOrEmpty((String)strResetItemName)) {
            String[] items;
            this.resetItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)strResetItemName);
            int n3 = items.length;
            n = 0;
            while (n < n3) {
                String strItem = stringArray[n];
                if (!this.resetItemNameList.contains(strItem = strItem.trim())) {
                    this.resetItemNameList.add(strItem);
                    this.getPSDEForm().hookPSDEFormItem(strItem, this);
                }
                ++n;
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
            this.strPrivilegeId = StringHelper.Format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
            this.strPrivDEFieldName = this.iPSDEField.getName();
        }
        this.bEnableUnitName = true;
        if (this.iPSDEFFormItem != null) {
            if (StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
                this.strUnitName = this.iPSDEFFormItem.getUnitName();
            }
            if (this.nUnitNameWidth <= 0) {
                this.nUnitNameWidth = this.iPSDEFFormItem.getUnitNameWidth();
            }
            if (this.iPSDEFInputTip == null) {
                this.iPSDEFInputTip = this.iPSDEFFormItem.getPSDEFInputTip();
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strUnitName)) {
            this.bEnableUnitName = false;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            this.getPSDEForm().hookPSDEFormItem(this.getName(), this);
        }
        if (this.getPSEditorType() != null && !this.getPSEditorType().isEditable()) {
            this.bAllowEmpty = true;
            this.bEditable = false;
        }
        if (this.getParentPSDEFormDetail() instanceof IPSDEFormGroupPanel && ((IPSDEFormGroupPanel)this.getParentPSDEFormDetail()).isHideEmptyItems() && this.getPSDEFDGroupLogic("PANELVISIBLE") == null) {
            ArrayList<PSDEFDLogic> psDEFDLogicList = new ArrayList<PSDEFDLogic>();
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
            psDEFDLogic.setPSDEFDLOGICID(KeyValueHelper.genUniqueId((String)this.getId(), (String)"PANELVISIBLE"));
            psDEFDLogic.setPSDEFDLOGICNAME(StringHelper.Format((String)"\u8868\u5355\u6210\u5458[%1$s][%2$s]\u903b\u8f91", (Object)this.getName(), (Object)fdLogicCatCodeListModel.getCodeListText("PANELVISIBLE", true)));
            psDEFDLogic.setGROUPOP("AND");
            psDEFDLogic.setLOGICTYPE("GROUP");
            psDEFDLogic.setLOGICCAT("PANELVISIBLE");
            psDEFDLogic.getChildPSDEFDLogics(true).addAll(psDEFDLogicList);
            PSDEFDCatGroupLogicImpl iPSDEFDLogic = new PSDEFDCatGroupLogicImpl();
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
            editorCssStyle.Append("height:%1$spx;", (Object)((int)this.getEditorHeight()));
        }
        if (this.getEditorWidth() > 0.0) {
            editorCssStyle.Append("width:%1$spx;", (Object)((int)this.getEditorWidth()));
        }
        return editorCssStyle.toString();
    }

    protected String calcLabelCssStyle() throws Exception {
        return this.psDEFormDetail.getLABELRAWCSSSTYLE();
    }

    protected String calcCtrlCssStyle() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"}, doc="\u975e\u7a7a\u767d\u6807\u9898\u65f6\u8fd4\u56de\u914d\u7f6e\u7684\u6807\u9898\u5185\u5bb9")
    public String getCaption() {
        if (this.isEmptyCaption()) {
            return "";
        }
        return super.getCaption();
    }

    @Override
    protected String onGetCaption() {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getCaption("");
        }
        return super.onGetCaption();
    }

    @Override
    protected IPSLanguageRes onGetCapPSLanguageRes() {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getCapPSLanguageRes();
        }
        return super.onGetCapPSLanguageRes();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u4f4d\u7f6e", codelist="FormItemLabelPos", fields={"LABELPOS"})
    public String getLabelPos() {
        return this.strLabelPos;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u5bbd\u5ea6", fields={"LABELWIDTH"}, ignoresetvalues="130;0")
    public int getLabelWidth() {
        if (this.isShowCaption()) {
            return this.nLabelWidth;
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u8868\u5355\u9879", ignoredumpvalues="false", doc="\u8ba1\u7b97\u7f16\u8f91\u5668\u7c7b\u578b\u4e3a\u9690\u85cf\u9879(HIDDEN)")
    public boolean isHidden() {
        return this.bHidden;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292, dump=false)
    public String getEditorType() {
        return this.strEditorType;
    }

    protected void setEditorType(String strEditorType) {
        this.strEditorType = strEditorType;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293, dump=false)
    public String getEditorStyle() {
        if (this.getPSSysEditorStyle() != null && this.getPSDEForm().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()) {
            return this.getPSSysEditorStyle().getStyleCode();
        }
        return this.strEditorStyle;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        psDEFormItemList.add(this);
        try {
            IPSAppDataEntity iPSAppDataEntity;
            IPSDEDataSet iPSDEDataSet;
            if (this.isRegisterToPSAppDataEntity() && this.getPSDEForm().getPSDataEntity() != null && (iPSDEDataSet = this.getRefPSDEDataSet()) != null && (iPSAppDataEntity = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppDataEntityByDEId(this.getPSDEForm().getPSDataEntity().getId(), true)) != null) {
                iPSAppDataEntity.registerRefPSDEDataSet(iPSDEDataSet, this);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295, dump=false)
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300, dump=false)
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.onGetAllowEmpty();
        }
        return true;
    }

    protected boolean onGetAllowEmpty() {
        return this.bAllowEmpty;
    }

    protected boolean isAllowEmptyDefined() {
        return this.bAllowEmptyDefined;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getItemWidth() {
        if (this.getEditorWidth() <= 0.0) {
            return 0.0;
        }
        if (!this.isShowCaption() || this.getLabelPos() == "TOP" || this.getLabelPos() == "BOTTOM") {
            return this.getEditorWidth();
        }
        return (double)this.getLabelWidth() + this.getEditorWidth();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getItemHeight() {
        if (this.getEditorHeight() <= 0.0) {
            return 0.0;
        }
        if (!this.isShowCaption() || this.getLabelPos() == "LEFT" || this.getLabelPos() == "RIGHT") {
            return this.getEditorHeight();
        }
        return this.getEditorHeight() + 20.0;
    }

    @PSModelRTMeta(description="\u6570\u636e\u9879")
    public IDataItem getDataItem() {
        return this.psDataItemImpl;
    }

    public Object getInputValue(IWebContext iWebContext) throws Exception {
        return null;
    }

    public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
        return null;
    }

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

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", fields={"VALUEITEMNAME"}, ignorert=3)
    public String getValueItemName() {
        return this.strValueItemName;
    }

    public IFIDEACMode getFIDEACMode() {
        return this.fiDEACModeImpl;
    }

    public String getDEFName() {
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getName();
        }
        return "";
    }

    public IForm getForm() {
        return this.getPSDEForm();
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDEForm", from_method="getPSAppDataEntityMust().getPSAppDEField", fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    public Iterator<IFIDEFValueRule> getFIDEFValueRules() {
        if (this.fiDEFValueRuleList == null || this.fiDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.fiDEFValueRuleList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getPSFIDEFValueRules();
        }
        return null;
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
        if ((iPSAppView = this.getRefLinkPSAppView()) != null) {
            relatedAppViewList.add(iPSAppView);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe", hideempty=true, dump=false)
    public IPSAppView getRefPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = this.psDEFormDetail.getPICKUPPSDEVIEWID();
        if (StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFFormItem != null) {
            strPickupPSDEViewId = this.iPSDEFFormItem.getRefPickupPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication());
        }
        if (!StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            IPSAppView refPickupPSAppView = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEForm().getPSAppView());
            refPickupPSAppView.markViewUsage(2, this);
            return refPickupPSAppView;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u94fe\u63a5\u89c6\u56fe", hideempty=true, dump=false)
    public IPSAppView getRefLinkPSAppView() throws Exception {
        String strLinkPSDEViewId = this.psDEFormDetail.getLINKPSDEVIEWID();
        if (StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFFormItem != null) {
            strLinkPSDEViewId = this.iPSDEFFormItem.getRefLinkPSDEViewId(this.getPSDEForm().getPSAppView().getPSApplication());
        }
        if (!StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            IPSAppView refLinkPSAppView = this.getPSDEForm().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDEForm().getPSAppView());
            refLinkPSAppView.markViewUsage(2, this);
            return refLinkPSAppView;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u7c7b\u578b", dump=false)
    public String getItemHandlerType() {
        if (!StringHelper.IsNullOrEmpty((String)this.strItemHandlerType)) {
            if (StringHelper.Compare((String)this.strItemHandlerType, (String)"None", (boolean)true) == 0) {
                return "";
            }
            return this.strItemHandlerType;
        }
        try {
            if (this.getPSEditor() != null && !this.getPSEditor().isEditable()) {
                return "";
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getItemHandlerType(this);
        }
        if (StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && StringHelper.Compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
            return "AC";
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", dump=false)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond", fields={"ENABLECOND"})
    public int getEnableCond() {
        return this.nEnableCond;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898", ignoredumpvalues="false", doc="\u8ba1\u7b97{@link #getLabelPos}\u503c\u4e0d\u4e3a\u4e0d\u663e\u5f0f(NONE)")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"CREATEDVT"})
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    protected void setCreateDVT(String strCreateDVT) {
        this.strCreateDVT = strCreateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c", fields={"CREATEDV"})
    public String getCreateDV() {
        return this.strCreateDV;
    }

    protected void setCreateDV(String strCreateDV) {
        this.strCreateDV = strCreateDV;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"UPDATEDVT"})
    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c", fields={"UPDATEDV"})
    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    public ICodeList getCodeList() throws Exception {
        return this.getPSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", dump=false)
    public boolean isEditable() {
        return this.bEditable;
    }

    public String getCapLanId() {
        return this.getCapLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9879\u53c2\u6570", dump=false)
    public JSONObject getItemParam() throws Exception {
        if (this.itemParamJO != null) {
            return this.itemParamJO;
        }
        String strItemParam = this.getEditorParam(EDITORPARAM_ITEMPARAM, null);
        if (!StringHelper.IsNullOrEmpty((String)strItemParam)) {
            this.itemParamJO = JSONObjectHelper.fromString2((String)strItemParam);
            return this.itemParamJO;
        }
        if (this.iPSDEFFormItem != null) {
            this.itemParamJO = this.iPSDEFFormItem.getItemParam(this);
            return this.itemParamJO;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true, dump=false)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEID())) {
            IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEDATASETID())) {
                return refPSDataEntity.getPSDEDataSet(this.psDEFormDetail.getREFPSDEDATASETID());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEDataSet();
            }
            return null;
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEDataSetId())) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFFormItem.getRefPSDEDataSetId());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEDataSet();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true, dump=false)
    public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEID())) {
            return null;
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null && !StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefActiveDataPSDELogicId())) {
            return this.iPSDEFFormItem.getRefPSDataEntity().getPSDELogic(this.iPSDEFFormItem.getRefActiveDataPSDELogicId());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEID())) {
            return this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getRefPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true, dump=false)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEID())) {
            IPSDataEntity refPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDEFormDetail.getREFPSDEID());
            if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEACMODEID())) {
                return refPSDataEntity.getPSDEACMode(this.psDEFormDetail.getREFPSDEACMODEID());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEACMode();
            }
            return null;
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEACModeId())) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEACMode(this.iPSDEFFormItem.getRefPSDEACModeId());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEACMode();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb", hideempty=true, dump=false)
    public IPSDERBase getRefPSDER() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFormDetail.getREFPSDEID())) {
            return null;
        }
        if (this.iPSDEFFormItem != null && !StringHelper.IsNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDERId())) {
            return this.iPSDEFFormItem.getPSDEField().getPSDataEntity().getPSSystem().getPSDER(this.iPSDEFFormItem.getRefPSDERId());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
        return null;
    }

    @Override
    public String getPSDEFIUpdateId() {
        return this.psDEFormDetail.getPSDEFIUPDATEID();
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0", dumpref=true, from="IPSDEForm", fields={"PSDEFIUPDATEID"})
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            return null;
        }
        return this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        String strValue = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
        if (StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null) {
            if (StringHelper.Compare((String)"WRAPMODE", (String)strParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getSWAPMODE();
            }
            if (StringHelper.Compare((String)"HALIGN", (String)strParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getHALIGN();
            }
            if (StringHelper.Compare((String)"VALIGN", (String)strParam, (boolean)false) == 0) {
                return this.psDEFormDetail.getVALIGN();
            }
            if (StringHelper.Compare((String)"DEFAULTREADONLY", (String)strParam, (boolean)false) == 0) {
                if (this.bInfoReadOnlyMode) {
                    return "true";
                }
                if ((this.psDEFormDetail.getITEMSTATES() & 1) != 0) {
                    return "true";
                }
                return strValue;
            }
            if (StringHelper.Compare((String)"DEFAULTDISABLED", (String)strParam, (boolean)false) == 0) {
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
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    public String getCodeListId() {
        return this.getPSCodeListId();
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    public String getValueRuleId() {
        return this.getPSSysValueRuleId();
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", fields={"IGNOREINPUT"})
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    protected void setIgnoreInput(int nIgnoreInput) {
        this.nIgnoreInput = nIgnoreInput;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u6362\u4e3a\u4ee3\u7801\u9879\u6587\u672c", ignoredumpvalues="false", fields={"CONVERTCITEXT"})
    public boolean isConvertToCodeItemText() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        if (this.bConvertToCodeItemText != null) {
            return this.bConvertToCodeItemText;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
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
        if (this.parentPSDEFormGroupPanel != null && (StringHelper.Compare((String)this.parentPSDEFormGroupPanel.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) == 0 || StringHelper.Compare((String)this.parentPSDEFormGroupPanel.getLayoutMode(), (String)"TABLE_24COL", (boolean)true) == 0)) {
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

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u5217\u5e03\u5c40\u6837\u5f0f", hideempty2=true, dump=false)
    public String getLabelColCssClass() {
        if (this.nLabelColSpan > 0) {
            return StringHelper.Format((String)"col-md-%1$s", (Object)this.nLabelColSpan);
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u63a7\u4ef6\u5217\u5e03\u5c40\u6837\u5f0f", hideempty2=true, dump=false)
    public String getCtrlColCssClass() {
        if (this.nCtrlColSpan > 0) {
            return StringHelper.Format((String)"col-md-%1$s", (Object)this.nCtrlColSpan);
        }
        return "";
    }

    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e", ignoredumpvalues="false", fields={"NEEDCODELISTCONFIG"})
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode", ignoredumpvalues="0", fields={"CODELISTCONFIGMODE"})
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true)
    public String getLabelCssStyle() {
        return this.strLabelCssStyle;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868", hideempty2=true, fields={"LABELDYNACLASS"})
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

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", ignorert=3, hideempty2=true)
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0\u96c6\u5408", hideempty2=true, child=true, fields={"RESETITEMNAME"})
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    public String getUserDictCatId() {
        return this.strPSSysDictCatId;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u7a7a\u767d\u6807\u7b7e", ignoredumpvalues="false", fields={"EMPTYCAPTION"})
    public boolean isEmptyCaption() {
        return this.bEmptyCaption;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u56fe\u7247\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() != null) {
            return super.getPSSysImage();
        }
        if (this.getPSDEFFormItem() != null) {
            return this.getPSDEFFormItem().getPSSysImage();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f")
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236", ignoredumpvalues="false", fields={"ENABLEITEMPRIV"})
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    public String getPrivFieldName() {
        return this.strPrivDEFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5355\u4f4d", ignoredumpvalues="false")
    public boolean isEnableUnitName() {
        return this.bEnableUnitName;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u540d\u79f0")
    public String getUnitName() {
        return this.strUnitName;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getUnitNameWidth() {
        return this.nUnitNameWidth;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a")
    public IPSDEFInputTip getPSDEFInputTip() {
        return this.iPSDEFInputTip;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", fields={"INPUTTIP"})
    public String getInputTip() {
        if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
            return null;
        }
        if (this.getPSDEFInputTip() == null) {
            return null;
        }
        return this.getPSDEFInputTip().getContent();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u94fe\u63a5", fields={"INPUTTIPURL"})
    public String getInputTipUrl() {
        if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
            return null;
        }
        if (this.getPSDEFInputTip() == null) {
            return null;
        }
        return this.getPSDEFInputTip().getMoreUrl();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u652f\u6301\u5173\u95ed", ignoredumpvalues="false", fields={"INPUTTIPCLOSABLE"})
    public boolean isInputTipClosable() {
        if (this.getPSDEFInputTip() == null) {
            return false;
        }
        return this.getPSDEFInputTip().isEnableClose();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getPHPSLanguageRes() {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getPHPSLanguageRes();
        }
        return null;
    }

    @Override
    public String getPHLanResTag() {
        if (this.getPHPSLanguageRes() != null) {
            return this.getPHPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f\u8bed\u8a00\u6807\u8bb0", fields={"INPUTTIPLANRESTAG"})
    public String getInputTipLanResTag() {
        if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
            return null;
        }
        if (this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getContentPSLanguageRes() != null) {
            return this.getPSDEFInputTip().getContentPSLanguageRes().getLanResTag();
        }
        return null;
    }

    protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSDEForm().getPSDataEntity().getPSAjaxControlHandlerData(strPSACHandlerId);
        PSDEFormItemAjaxHandlerImpl psAjaxHandlerImpl = new PSDEFormItemAjaxHandlerImpl();
        psAjaxHandlerImpl.init(this.getDAGlobalHelper(), this, psACHandler);
        return psAjaxHandlerImpl;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return this.itemPSAjaxHandler;
    }

    public String getInputTipSetId() {
        if (this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getPSDEFInputTipSet() != null) {
            return this.getPSDEFInputTip().getPSDEFInputTipSet().getId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u5168\u5c40\u6807\u8bb0", fields={"INPUTTIPUNIQUETAG"})
    public String getInputTipUniqueTag() {
        if (this.isEnableInputTipDefined() && !this.bEnableInputTip) {
            return null;
        }
        if (this.getPSDEFInputTip() != null && this.getPSDEFInputTip().getPSDEFInputTipSet() != null) {
            return this.getPSDEFInputTip().getUniqueTag();
        }
        return null;
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
        if (!StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", codelist="NoPrivDisplayModes", fields={"NOPRIVDM"})
    public int getNoPrivDisplayMode() {
        return this.nNoPrivDisplayMode;
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u7684\u503c\u9879\u96c6\u5408")
    public String[] getValueItemNames() {
        if (this.valueItemNameList == null || this.valueItemNameList.size() == 0) {
            return null;
        }
        return this.valueItemNameList.toArray(new String[this.valueItemNameList.size()]);
    }

    @Override
    @PSModelRTMeta(description="\u590d\u5408\u8868\u5355\u9879", ignoredumpvalues="false")
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

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u4e34\u65f6\u6570\u636e", dump=false)
    public boolean isRefTempData() {
        if (this.getPSDEForm().getPSAjaxControlHandler() != null && this.getPSDEForm().getPSAjaxControlHandler().getTempMode() == 0) {
            return false;
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.isRefTempData();
        }
        return false;
    }

    @Override
    public int getStdDataType() {
        if (this.getPSDEField() != null) {
            if (this.isConvertToCodeItemText()) {
                return 25;
            }
            return this.getPSDEField().getStdDataType();
        }
        return 25;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getDataType() {
        return this.getStdDataType();
    }

    @Override
    protected String getDefaultDetailStyle() {
        return this.getPSDEForm().getDefaultFormItemStyle();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bf9\u8c61", child=true)
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

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"LEVELTAG"})
    public String getCaptionItemName() {
        return this.psDEFormDetail.getLEVELTAG();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u4f9b\u951a\u70b9", ignoredumpvalues="false", fields={"ENABLEANCHOR"})
    public boolean isEnableAnchor() {
        return this.bEnableAnchor;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u8f93\u5165\u63d0\u793a", ignoredumpvalues="false", fields={"ENABLEINPUTTIP"})
    public boolean isEnableInputTip() {
        if (this.isEnableInputTipDefined()) {
            return this.bEnableInputTip;
        }
        if (this.getPSDEForm().getPSAppDEFInputTipSet() != null) {
            return true;
        }
        return !StringHelper.IsNullOrEmpty((String)this.getInputTip()) || this.getPSDEFInputTip() != null && !StringHelper.IsNullOrEmpty((String)this.getPSDEFInputTip().getUniqueTag());
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
        if (!StringHelper.IsNullOrEmpty((String)this.getCreateDVT())) {
            objectNode.put("createDVT", this.getCreateDVT());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getCreateDV())) {
            objectNode.put("createDV", this.getCreateDV());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUpdateDVT())) {
            objectNode.put("updateDVT", this.getUpdateDVT());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getUpdateDV())) {
            objectNode.put("updateDV", this.getUpdateDV());
        }
        if (this.getPSAppDEField() != null) {
            objectNode.put("getPSAppDEField", (JsonNode)this.getPSAppDEField().getModelRef());
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
            if (iPSSysValueRule instanceof IPSAppValueRule) {
                return iPSSysValueRule;
            }
            return this.getPSDEForm().getPSAppView().getPSApplication().getPSAppValueRule(iPSSysValueRule.getId());
        }
        return iPSSysValueRule;
    }

    protected IPSSysValueRule onGetPSSysValueRule() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        if (this.psDataItemImpl != null) {
            return this.psDataItemImpl.getFormat();
        }
        return "";
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
        }
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getPSSysCss();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u5c5e\u6027", fields={"FIELDNAME"})
    public String getFieldName() {
        return this.psDEFormDetail.getFIELDNAME();
    }

    protected class FIDEACModeImpl
    implements IFIDEACMode {
        private String strDEName = "";
        private String strDEACModeName = "";

        protected FIDEACModeImpl() {
        }

        public String getDEName() {
            return this.strDEName;
        }

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

