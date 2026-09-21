/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.form.IPSDEFFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItem
 *  net.ibizsys.model.control.form.IPSDEFormItemUpdate
 *  net.ibizsys.model.control.form.IPSFIDEFValueRule
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.res.IPSSysEditorStyle
 *  net.ibizsys.model.res.IPSSysImage
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.form.IFIDEACMode
 *  net.ibizsys.paas.control.form.IFIDEFValueRule
 *  net.ibizsys.paas.control.form.IForm
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.model.control.form;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.form.IPSDEFFormItem;
import net.ibizsys.model.control.form.IPSDEFormItem;
import net.ibizsys.model.control.form.IPSDEFormItemUpdate;
import net.ibizsys.model.control.form.IPSFIDEFValueRule;
import net.ibizsys.model.control.form.PSDEFormDetailImpl;
import net.ibizsys.model.control.form.PSDEFormItemAjaxHandlerImpl;
import net.ibizsys.model.data.PSDataItemImpl;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.form.IFIDEACMode;
import net.ibizsys.paas.control.form.IFIDEFValueRule;
import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

public class PSDEFormItemImpl
extends PSDEFormDetailImpl
implements IPSDEFormItem {
    private IPSDEFFormItem iPSDEFFormItem = null;
    protected IPSDEField iPSDEField = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    protected boolean bHidden = false;
    protected boolean bAllowEmpty = true;
    protected String strLabelPos = "LEFT";
    protected double fEditorWidth = 0.0;
    protected double fEditorHeight = 0.0;
    protected String strPSCodeListId = "";
    protected PSDataItemImpl psDataItemImpl = new PSDataItemImpl();
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
    private String strItemHandlerType = null;
    private IPSAjaxHandler itemPSAjaxHandler = null;
    private int nWriteBackDEFMode = 0;
    private Boolean bConvertToCodeItemText = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (this.getPSSystemSetting() != null) {
            this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
        }
        this.strValueItemName = this.psDEFormDetail.getVALUEITEMNAME();
        this.editorParams = PropertiesHelper.load((String)this.psDEFormDetail.getEDITORPARAMS());
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = this.psDEFormDetail.getEDITORTYPE();
        }
        this.strEditorStyle = this.psDEFormDetail.getPSSYSEDITORSTYLEID();
        if (!StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.bDefineEditorType = true;
        }
        if (!this.psDEFormDetail.isWBDEFMODENull()) {
            this.nWriteBackDEFMode = this.psDEFormDetail.getWBDEFMODE();
        }
        if (!this.psDEFormDetail.isCONVERTCITEXTNull()) {
            this.bConvertToCodeItemText = this.psDEFormDetail.getCONVERTCITEXT();
        }
        String strItemPSACHandlerId = null;
        this.preparePSDEFFormItem();
        if (this.getPSDEFFormItem() != null) {
            strItemPSACHandlerId = this.getPSDEFFormItem().getPSAjaxHandlerId();
            boolean bAppendParam = false;
            if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.iPSDEFFormItem.getEditorType();
                bAppendParam = true;
            } else if (StringHelper.compare((String)this.strEditorType, (String)this.iPSDEFFormItem.getEditorType(), (boolean)true) == 0) {
                bAppendParam = true;
            }
            if (bAppendParam) {
                for (Object object : this.iPSDEFFormItem.getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(object)) continue;
                    this.editorParams.put(object, this.iPSDEFFormItem.getEditorParams().get(object));
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strEditorStyle)) {
                this.strEditorStyle = this.iPSDEFFormItem.getEditorStyle();
            }
        }
        if (this.isDesignMode()) {
            this.strEditorStyle = "";
            if (StringHelper.compare((String)this.getEditorType(), (String)"USERCONTROL", (boolean)true) == 0) {
                this.strEditorType = "SPAN";
                this.bDefineEditorType = true;
                this.strEditorStyle = "";
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = "TEXTBOX";
        }
        boolean bl = this.bHidden = StringHelper.compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
        if (!StringHelper.isNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            this.strValueProcessor = this.iPSEditorType.getValueProcessor();
            if (!StringHelper.isNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getPSSystem().getPSSysEditorStyle(this.strEditorStyle);
            } else if (!this.isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSDEForm().getPSAppView().getPSApplication().getPSSystem().getDefaultPSSysEditorStyle(this.getEditorType());
            }
            if (this.getPSSysEditorStyle() != null) {
                this.strItemHandlerType = this.getPSSysEditorStyle().getAjaxHandlerType();
                if (StringHelper.isNullOrEmpty((String)strItemPSACHandlerId)) {
                    strItemPSACHandlerId = this.getPSSysEditorStyle().getPSAjaxHandlerId();
                }
                for (Object objKey : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(objKey)) continue;
                    this.editorParams.put(objKey, this.getPSSysEditorStyle().getEditorParams().get(objKey));
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strItemHandlerType)) {
                this.strItemHandlerType = this.getPSEditorType().getAjaxHandlerType();
            }
            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strItemPSACHandlerId)) {
            this.itemPSAjaxHandler = this.createItemPSAjaxHandler(strItemPSACHandlerId);
        }
        if (!this.psDEFormDetail.isALLOWEMPTYNull()) {
            this.bAllowEmpty = this.psDEFormDetail.getALLOWEMPTY();
        } else if (!this.bHidden && this.iPSDEFFormItem != null) {
            this.bAllowEmpty = this.iPSDEFFormItem.isAllowEmpty();
        }
        if (!this.bAllowEmpty && this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSDEField().isKeyDEField()) {
            this.bAllowEmpty = true;
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
                if (this.iPSDEFFormItem != null && StringHelper.compare((String)this.strEditorType, (String)this.iPSDEFFormItem.getEditorType(), (boolean)true) == 0) {
                    this.fEditorWidth = this.iPSDEFFormItem.getEditorWidth();
                    this.fEditorHeight = this.iPSDEFFormItem.getEditorHeight();
                    bCalc = true;
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
        if (StringHelper.isNullOrEmpty((String)this.strPSCodeListId) && this.iPSDEFFormItem != null) {
            this.strPSCodeListId = this.iPSDEFFormItem.getPSCodeListId();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFormDetail.getPLACEHOLDER())) {
            this.strPlaceHolder = this.psDEFormDetail.getPLACEHOLDER();
        } else if (this.getPSDEFFormItem() != null) {
            this.strPlaceHolder = this.getPSDEFFormItem().getPlaceHolder();
        }
        if (this.iPSDEFFormItem != null) {
            this.strPSSysValueRuleId = this.iPSDEFFormItem.getPSSysValueRuleId();
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSFIDEFValueRules() != null) {
            Iterator psFIDEFValueRules = this.iPSDEFFormItem.getPSFIDEFValueRules();
            while (psFIDEFValueRules.hasNext()) {
                if (this.fiDEFValueRuleList == null) {
                    this.fiDEFValueRuleList = new ArrayList();
                }
                this.fiDEFValueRuleList.add((IFIDEFValueRule)psFIDEFValueRules.next());
            }
        }
        if (this.iPSDEFFormItem != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEId()) && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEACModeId())) {
            this.fiDEACModeImpl = new FIDEACModeImpl();
            this.fiDEACModeImpl.setDEACModeName(this.iPSDEFFormItem.getRefPSDEACModeName());
            this.fiDEACModeImpl.setDEName(this.iPSDEFFormItem.getRefPSDEName());
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDEForm().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
        }
        this.bShowCaption = StringHelper.compare((String)this.psDEFormDetail.getLABELPOS(), (String)"NONE", (boolean)true) != 0;
        this.strCreateDVT = this.psDEFormDetail.getCREATEDVT();
        this.strCreateDV = this.psDEFormDetail.getCREATEDV();
        this.strUpdateDVT = this.psDEFormDetail.getUPDATEDVT();
        this.strUpdateDV = this.psDEFormDetail.getUPDATEDV();
        if (this.iPSDEFFormItem != null) {
            if (StringHelper.isNullOrEmpty((String)this.strCreateDVT)) {
                this.strCreateDVT = this.iPSDEFFormItem.getCreateDVT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strCreateDV)) {
                this.strCreateDV = this.iPSDEFFormItem.getCreateDV();
            }
            if (StringHelper.isNullOrEmpty((String)this.strUpdateDVT)) {
                this.strUpdateDVT = this.iPSDEFFormItem.getUpdateDVT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strUpdateDV)) {
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
                if (this.getPSDEFFormItem() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                    this.bNeedCodeListConfig = this.getPSDEFFormItem().isNeedCodeListConfig();
                }
            }
            if (!this.psDEFormDetail.isCODELISTCONFIGMODENull()) {
                this.nOutputCodeListConfig = this.psDEFormDetail.getCODELISTCONFIGMODE();
            } else {
                this.nOutputCodeListConfig = this.getPSEditorType().getOutputCodeListConfigMode();
                if (this.getPSDEFFormItem() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                    this.nOutputCodeListConfig = this.getPSDEFFormItem().getOutputCodeListConfigMode();
                }
            }
        }
        this.prepareDataItem();
        this.strEditorCssStyle = this.calcEditorCssStyle();
        this.strCtrlCssStyle = this.calcCtrlCssStyle();
        this.strLabelCssStyle = this.calcLabelCssStyle();
        String strResetItemName = this.psDEFormDetail.getRESETITEMNAME();
        if (StringHelper.isNullOrEmpty((String)strResetItemName) && this.iPSDEFFormItem != null && this.iPSDEFFormItem.isEnableResetItemName()) {
            strResetItemName = this.iPSDEFFormItem.getResetItemName();
        }
        if (!StringHelper.isNullOrEmpty((String)strResetItemName)) {
            String[] stringArray;
            this.resetItemNameList = new ArrayList();
            String[] stringArray2 = stringArray = StringHelper.splitEx((String)strResetItemName);
            int n = stringArray.length;
            int n2 = 0;
            while (n2 < n) {
                String strItem = stringArray2[n2];
                if (!this.resetItemNameList.contains(strItem = strItem.trim())) {
                    this.resetItemNameList.add(strItem);
                }
                ++n2;
            }
            if (this.resetItemNameList.size() > 0) {
                this.strResetItemName = this.resetItemNameList.get(0);
            }
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
            this.strPrivilegeId = StringHelper.format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
            this.strPrivDEFieldName = this.iPSDEField.getName();
        }
        this.bEnableUnitName = true;
        if (this.iPSDEFFormItem != null) {
            if (StringHelper.isNullOrEmpty((String)this.strUnitName)) {
                this.strUnitName = this.iPSDEFFormItem.getUnitName();
            }
            if (this.nUnitNameWidth <= 0) {
                this.nUnitNameWidth = this.iPSDEFFormItem.getUnitNameWidth();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strUnitName)) {
            this.bEnableUnitName = false;
        }
    }

    protected void preparePSDEFFormItem() throws Exception {
    }

    protected void prepareDataItem() throws Exception {
    }

    protected String calcEditorCssStyle() throws Exception {
        StringBuilderEx editorCssStyle = new StringBuilderEx();
        if (this.getEditorHeight() > 0.0) {
            editorCssStyle.append("height:%1$spx;", (Object)((int)this.getEditorHeight()));
        }
        if (this.getEditorWidth() > 0.0) {
            editorCssStyle.append("width:%1$spx;", (Object)((int)this.getEditorWidth()));
        }
        return editorCssStyle.toString();
    }

    protected String calcLabelCssStyle() throws Exception {
        return "";
    }

    protected String calcCtrlCssStyle() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
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

    @PSModelRTMeta(description="\u6807\u7b7e\u4f4d\u7f6e", codelist="FormItemLabelPos")
    public String getLabelPos() {
        return this.strLabelPos;
    }

    @PSModelRTMeta(description="\u6807\u7b7e\u5bbd\u5ea6")
    public int getLabelWidth() {
        if (this.isShowCaption()) {
            return this.nLabelWidth;
        }
        return 0;
    }

    @PSModelRTMeta(description="\u9690\u85cf\u8868\u5355\u9879")
    public boolean isHidden() {
        return this.bHidden;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b", order=292)
    public String getEditorType() {
        return this.strEditorType;
    }

    protected void setEditorType(String strEditorType) {
        this.strEditorType = strEditorType;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f", order=293)
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @Override
    public void fillPSDEFormItems(ArrayList<IPSDEFormItem> psDEFormItemList) {
        psDEFormItemList.add(this);
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295)
    public double getEditorWidth() {
        return this.fEditorWidth;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300)
    public double getEditorHeight() {
        return this.fEditorHeight;
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.bAllowEmpty;
        }
        return true;
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u5bbd\u5ea6")
    public double getItemWidth() {
        if (this.getEditorWidth() <= 0.0) {
            return 0.0;
        }
        if (!this.isShowCaption() || this.getLabelPos() == "TOP" || this.getLabelPos() == "BOTTOM") {
            return this.getEditorWidth();
        }
        return (double)this.getLabelWidth() + this.getEditorWidth();
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u9ad8\u5ea6")
    public double getItemHeight() {
        if (this.getEditorHeight() <= 0.0) {
            return 0.0;
        }
        if (!this.isShowCaption() || this.getLabelPos() == "LEFT" || this.getLabelPos() == "RIGHT") {
            return this.getEditorHeight();
        }
        return this.getEditorHeight() + 20.0;
    }

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

    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0")
    public String getValueItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.strValueItemName)) {
            return this.strValueItemName;
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getValueItemName((IPSDEFormItem)this);
        }
        return "";
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

    @PSModelRTMeta(description="\u76f8\u5173\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    public Iterator<IFIDEFValueRule> getFIDEFValueRules() {
        if (this.fiDEFValueRuleList == null || this.fiDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.fiDEFValueRuleList.iterator();
    }

    @PSModelRTMeta(description="\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules() {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getPSFIDEFValueRules();
        }
        return null;
    }

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

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = this.psDEFormDetail.getPICKUPPSDEVIEWID();
        if (StringHelper.isNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFFormItem != null) {
            strPickupPSDEViewId = this.iPSDEFFormItem.getRefPickupPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            IPSAppView refPickupPSAppView = ((IPSApplicationRuntime)this.getPSDEForm().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEForm().getPSAppView());
            ((IPSAppViewRuntime)refPickupPSAppView).markViewUsage(2, this);
            return refPickupPSAppView;
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u94fe\u63a5\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefLinkPSAppView() throws Exception {
        String strLinkPSDEViewId = this.psDEFormDetail.getLINKPSDEVIEWID();
        if (StringHelper.isNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFFormItem != null) {
            strLinkPSDEViewId = this.iPSDEFFormItem.getRefLinkPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEForm().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            IPSAppView refLinkPSAppView = ((IPSApplicationRuntime)this.getPSDEForm().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDEForm().getPSAppView());
            ((IPSAppViewRuntime)refLinkPSAppView).markViewUsage(2, this);
            return refLinkPSAppView;
        }
        return null;
    }

    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u7c7b\u578b")
    public String getItemHandlerType() {
        if (!StringHelper.isNullOrEmpty((String)this.strItemHandlerType)) {
            if (StringHelper.compare((String)this.strItemHandlerType, (String)"None", (boolean)true) == 0) {
                return "";
            }
            return this.strItemHandlerType;
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getItemHandlerType((IPSDEFormItem)this);
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && StringHelper.compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
            return "AC";
        }
        return "";
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61")
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond")
    public int getEnableCond() {
        return this.nEnableCond;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType")
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c")
    public String getCreateDV() {
        return this.strCreateDV;
    }

    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType")
    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c")
    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    public ICodeList getCodeList() throws Exception {
        return this.getPSCodeList();
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u7f16\u8f91")
    public boolean isEditable() {
        return this.bEditable;
    }

    public String getCapLanId() {
        return this.getCapLanResTag();
    }

    public ObjectNode getItemParam() throws Exception {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getItemParam((IPSDEFormItem)this);
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEDataSetId())) {
            return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFFormItem.getRefPSDEDataSetId());
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true)
    public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefActiveDataPSDELogicId())) {
            return this.iPSDEFFormItem.getRefPSDataEntity().getPSDELogic(this.iPSDEFFormItem.getRefActiveDataPSDELogicId());
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEACModeId())) {
            return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEACMode(this.iPSDEFFormItem.getRefPSDEACModeId());
        }
        return null;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
        return null;
    }

    public String getPSDEFIUpdateId() {
        return this.psDEFormDetail.getPSDEFIUPDATEID();
    }

    @PSModelRTMeta(description="\u8868\u5355\u9879\u66f4\u65b0")
    public IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDEFIUpdateId())) {
            return null;
        }
        return this.getPSDEForm().getPSDEFormItemUpdate(this.getPSDEFIUpdateId());
    }

    public Properties getEditorParams() {
        return this.editorParams;
    }

    public int getEditorParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    public String getEditorParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    public String getCodeListId() {
        return this.getPSCodeListId();
    }

    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    public String getValueRuleId() {
        return this.getPSSysValueRuleId();
    }

    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f")
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @PSModelRTMeta(description="\u8f6c\u6362\u4e3a\u4ee3\u7801\u9879\u6587\u672c")
    public boolean isConvertToCodeItemText() {
        if (StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        if (this.bConvertToCodeItemText != null) {
            return this.bConvertToCodeItemText;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
    }

    public int getLabelColSpan() {
        return this.nLabelColSpan;
    }

    public int getCtrlColSpan() {
        return this.nCtrlColSpan;
    }

    @Override
    protected void onLayout() throws Exception {
        super.onLayout();
        if (this.parentPSDEFormGroupPanel != null && (StringHelper.compare((String)this.parentPSDEFormGroupPanel.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) == 0 || StringHelper.compare((String)this.parentPSDEFormGroupPanel.getLayoutMode(), (String)"TABLE_24COL", (boolean)true) == 0)) {
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

    public int getLabelRealColSpan() {
        return -1;
    }

    public int getCtrlRealColSpan() {
        return -1;
    }

    @PSModelRTMeta(description="\u6807\u7b7e\u5217\u5e03\u5c40\u6837\u5f0f", hideempty2=true)
    public String getLabelColCssClass() {
        if (this.nLabelColSpan > 0) {
            return StringHelper.format((String)"col-md-%1$s", (Object)this.nLabelColSpan);
        }
        return "";
    }

    @PSModelRTMeta(description="\u63a7\u4ef6\u5217\u5e03\u5c40\u6837\u5f0f", hideempty2=true)
    public String getCtrlColCssClass() {
        if (this.nCtrlColSpan > 0) {
            return StringHelper.format((String)"col-md-%1$s", (Object)this.nCtrlColSpan);
        }
        return "";
    }

    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception {
        return null;
    }

    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode")
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfig;
    }

    public String getLabelCssStyle() {
        return this.strLabelCssStyle;
    }

    public String getCtrlCssStyle() {
        return this.strCtrlCssStyle;
    }

    public String getEditorCssStyle() {
        return this.strEditorCssStyle;
    }

    public String getValueTranslator() {
        return this.strValueProcessor;
    }

    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", hideempty2=true)
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0\u96c6\u5408", hideempty2=true)
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    public String getUserDictCatId() {
        return this.psDEFormDetail.getPSSYSDICTCATID();
    }

    @PSModelRTMeta(description="\u662f\u5426\u7a7a\u767d\u6807\u7b7e")
    public boolean isEmptyCaption() {
        return this.bEmptyCaption;
    }

    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f")
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u5355\u9879\u56fe\u7247\u5bf9\u8c61")
    public IPSSysImage getPSSysImage() {
        if (super.getPSSysImage() != null) {
            return super.getPSSysImage();
        }
        if (this.getPSDEFFormItem() != null) {
            return this.getPSDEFFormItem().getPSSysImage();
        }
        return null;
    }

    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236")
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    public String getPrivFieldName() {
        return this.strPrivDEFieldName;
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u5355\u4f4d")
    public boolean isEnableUnitName() {
        return this.bEnableUnitName;
    }

    @PSModelRTMeta(description="\u5355\u4f4d\u540d\u79f0")
    public String getUnitName() {
        return this.strUnitName;
    }

    public int getUnitNameWidth() {
        return this.nUnitNameWidth;
    }

    public String getInputTip() {
        return null;
    }

    public String getInputTipUrl() {
        return null;
    }

    public boolean isInputTipClosable() {
        return false;
    }

    public String getPHLanResTag() {
        return null;
    }

    public String getInputTipLanResTag() {
        return null;
    }

    protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
        PSACHandler psACHandler = ((IPSDataEntityRuntime)this.getPSDEForm().getPSDataEntity()).getPSAjaxControlHandlerData(strPSACHandlerId);
        PSDEFormItemAjaxHandlerImpl psAjaxHandlerImpl = new PSDEFormItemAjaxHandlerImpl();
        psAjaxHandlerImpl.init(this.getPSModelStorageContext(), this, psACHandler);
        return psAjaxHandlerImpl;
    }

    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return this.itemPSAjaxHandler;
    }

    public String getInputTipSetId() {
        return null;
    }

    public String getInputTipUniqueTag() {
        return null;
    }

    public int getWriteBackDEFMode() {
        return this.nWriteBackDEFMode;
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

