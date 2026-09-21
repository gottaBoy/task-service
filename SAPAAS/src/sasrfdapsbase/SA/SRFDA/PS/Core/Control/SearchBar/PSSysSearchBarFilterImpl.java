/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  net.ibizsys.paas.control.form.IFIDEFValueRule
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFFormItem;
import SA.SRFDA.PS.Core.Control.Form.IPSFIDEFValueRule;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormItemAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBarFilter;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarItemImplBase;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
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
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.control.form.IFIDEFValueRule;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchBarFilterImpl
extends PSSysSearchBarItemImplBase
implements IPSSearchBarFilter {
    private static final Log log = LogFactory.getLog(PSSysSearchBarFilterImpl.class);
    public static final String EDITORPARAM_ITEMPARAM = "ITEMPARAM";
    private IPSDEFFormItem iPSDEFFormItem = null;
    private IPSDEFSearchMode iPSDEFSearchMode = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    protected boolean bHidden = false;
    protected boolean bAllowEmpty = true;
    protected String strLabelPos = "NONE";
    protected double fEditorWidth = 0.0;
    protected double fEditorHeight = 0.0;
    protected String strPSCodeListId = "";
    private ArrayList<IFIDEFValueRule> fiDEFValueRuleList = null;
    protected IPSCodeList iPSCodeList = null;
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
    private String strValueItemName = "";
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfig = 0;
    private String strLabelCssStyle = "";
    private String strCtrlCssStyle = "";
    private String strEditorCssStyle = "";
    private String strResetItemName = null;
    private ArrayList<String> resetItemNameList = null;
    private boolean bEmptyCaption = false;
    private int nLabelWidth = 0;
    private String strPlaceHolder = null;
    private IPSSysEditorStyle iPSSysEditorStyle = null;
    private boolean bEnableItemPriv = false;
    private String strUnitName = null;
    private int nUnitNameWidth = 0;
    private boolean bEnableUnitName = false;
    private IPSDEFInputTip iPSDEFInputTip = null;
    private String strItemHandlerType = null;
    private IPSAjaxHandler itemPSAjaxHandler = null;
    private Boolean bConvertToCodeItemText = null;
    private JSONObject itemParamJO = null;
    private IPSEditor iPSEditor = null;
    private double fWidth = 0.0;
    private boolean bAddSeparator = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psSysSearchBarItem.isADDSEPARATORNull()) {
            this.bAddSeparator = this.psSysSearchBarItem.getADDSEPARATOR();
        }
        if (!this.psSysSearchBarItem.isWIDTHNull()) {
            this.fWidth = this.psSysSearchBarItem.GetParamDoubleValue("WIDTH", this.fWidth);
            if (this.fWidth < 0.0) {
                this.fWidth = 0.0;
            }
        }
        this.strValueItemName = this.psSysSearchBarItem.getVALUEITEMNAME();
        this.editorParams = PropertiesHelper.load((String)this.psSysSearchBarItem.getEDITORPARAMS());
        if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = this.psSysSearchBarItem.getEDITORTYPE();
        }
        this.strEditorStyle = this.psSysSearchBarItem.getPSSYSEDITORSTYLEID();
        if (!StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.bDefineEditorType = true;
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
            if (this.getPSSysSearchBar().getPSAppView() != null && this.getPSSysSearchBar().getPSAppView().getPSApplication() != null && this.getPSSysSearchBar().getPSAppView().getPSApplication().isMobileApp()) {
                this.strEditorType = "MOBTEXT";
            }
        }
        boolean bl = this.bHidden = StringHelper.compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
        if (!StringHelper.isNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            if (!StringHelper.isNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "FORMITEM");
            } else if (!this.isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSSysSearchBar().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "FORMITEM");
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
        if (!this.bHidden && this.iPSDEFFormItem != null && this.bAllowEmpty) {
            this.bAllowEmpty = this.iPSDEFFormItem.isAllowEmpty();
        }
        if (!this.bAllowEmpty && this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSDEField().isKeyDEField()) {
            this.bAllowEmpty = true;
        }
        if (!this.psSysSearchBarItem.isLABELPOSNull()) {
            this.strLabelPos = this.psSysSearchBarItem.getLABELPOS();
        }
        if (!this.psSysSearchBarItem.isLABELWIDTHNull() && this.psSysSearchBarItem.getLABELWIDTH() >= 0) {
            this.nLabelWidth = this.psSysSearchBarItem.getLABELWIDTH();
        }
        this.fEditorWidth = -1.0;
        this.fEditorHeight = -1.0;
        if (!this.psSysSearchBarItem.isCTRLWIDTHNull()) {
            this.fEditorWidth = this.psSysSearchBarItem.getCTRLWIDTH();
        }
        if (!this.psSysSearchBarItem.isCTRLHEIGHTNull()) {
            this.fEditorHeight = this.psSysSearchBarItem.getCTRLHEIGHT();
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
                if (!bCalc) {
                    this.fEditorWidth = this.getPSEditorType().getWidth(this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSPF().getId());
                    this.fEditorHeight = this.getPSEditorType().getHeight(this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSPF().getId());
                    String string = StringHelper.format((String)"EDITOR.%1$s.WIDTH", (Object)this.getPSEditorType().getId()).toUpperCase();
                    String strEditorHeightKey = StringHelper.format((String)"EDITOR.%1$s.HEIGHT", (Object)this.getPSEditorType().getId()).toUpperCase();
                    this.fEditorWidth = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPFStyleParam(string, this.fEditorWidth);
                    this.fEditorHeight = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPFStyleParam(strEditorHeightKey, this.fEditorHeight);
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
        this.strPSCodeListId = this.psSysSearchBarItem.getPSCODELISTID();
        if (StringHelper.isNullOrEmpty((String)this.strPSCodeListId) && this.iPSDEFFormItem != null) {
            this.strPSCodeListId = this.iPSDEFFormItem.getPSCodeListId();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPLACEHOLDER())) {
            this.strPlaceHolder = this.psSysSearchBarItem.getPLACEHOLDER();
        } else if (this.getPSDEFFormItem() != null) {
            this.strPlaceHolder = this.getPSDEFFormItem().getPlaceHolder();
        }
        if (this.iPSDEFFormItem != null) {
            this.strPSSysValueRuleId = this.iPSDEFFormItem.getPSSysValueRuleId();
        }
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getPSFIDEFValueRules() != null) {
            Iterator<IPSFIDEFValueRule> psFIDEFValueRules = this.iPSDEFFormItem.getPSFIDEFValueRules();
            while (psFIDEFValueRules.hasNext()) {
                if (this.fiDEFValueRuleList == null) {
                    this.fiDEFValueRuleList = new ArrayList();
                }
                this.fiDEFValueRuleList.add(psFIDEFValueRules.next());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSSysSearchBar().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
        }
        if (this.iPSCodeList != null) {
            this.iPSCodeList = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
        }
        this.bShowCaption = StringHelper.compare((String)this.getLabelPos(), (String)"NONE", (boolean)true) != 0;
        this.strCreateDVT = this.psSysSearchBarItem.getCREATEDVT();
        this.strCreateDV = this.psSysSearchBarItem.getCREATEDV();
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
        if (!this.isDesignMode()) {
            this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
            if (this.getPSDEFFormItem() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                this.bNeedCodeListConfig = this.getPSDEFFormItem().isNeedCodeListConfig();
            }
            this.nOutputCodeListConfig = this.getPSEditorType().getOutputCodeListConfigMode();
            if (this.getPSDEFFormItem() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFFormItem().getEditorType(), (boolean)true) == 0) {
                this.nOutputCodeListConfig = this.getPSDEFFormItem().getOutputCodeListConfigMode();
            }
        }
        this.strEditorCssStyle = this.calcEditorCssStyle();
        this.strCtrlCssStyle = this.calcCtrlCssStyle();
        this.strLabelCssStyle = this.calcLabelCssStyle();
        String strResetItemName = this.psSysSearchBarItem.getRESETITEMNAME();
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
        this.bEnableUnitName = true;
        if (this.iPSDEFFormItem != null) {
            if (StringHelper.isNullOrEmpty((String)this.strUnitName)) {
                this.strUnitName = this.iPSDEFFormItem.getUnitName();
            }
            if (this.nUnitNameWidth <= 0) {
                this.nUnitNameWidth = this.iPSDEFFormItem.getUnitNameWidth();
            }
            if (this.iPSDEFInputTip == null) {
                this.iPSDEFInputTip = this.iPSDEFFormItem.getPSDEFInputTip();
            }
        }
        if (StringHelper.isNullOrEmpty((String)this.strUnitName)) {
            this.bEnableUnitName = false;
        }
        if (this.getPSEditorType() != null && !this.getPSEditorType().isEditable()) {
            this.bAllowEmpty = true;
            this.bEditable = false;
        }
        this.preparePSEditor();
    }

    protected void preparePSEditor() throws Exception {
        this.getPSEditor();
    }

    protected void preparePSDEFFormItem() throws Exception {
        if (this.getPSDEField() != null && !StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSDEFSFITEMID())) {
            this.iPSDEFSearchMode = this.getPSDEField().getPSDEFSearchMode(this.psSysSearchBarItem.getPSDEFSFITEMID());
            this.setPSDEFFormItem(this.iPSDEFSearchMode.getPSDEFFormItem(this.getPSSysSearchBar().getPSAppView().getPSApplication().isMobileApp() ? "MOBILEDEFAULT" : "DEFAULT"));
        }
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
        return this.psSysSearchBarItem.getLABELRAWCSSSTYLE();
    }

    protected String calcCtrlCssStyle() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        if (this.isEmptyCaption()) {
            return "";
        }
        if (!StringHelper.isNullOrEmpty((String)super.getCaption())) {
            return super.getCaption();
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getCaption("");
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u4f4d\u7f6e", codelist="FormItemLabelPos")
    public String getLabelPos() {
        return this.strLabelPos;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u5bbd\u5ea6")
    public int getLabelWidth() {
        if (this.isShowCaption()) {
            return this.nLabelWidth;
        }
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u8868\u5355\u9879")
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
        if (this.getPSSysEditorStyle() != null && this.getPSSysSearchBar().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()) {
            return this.getPSSysEditorStyle().getStyleCode();
        }
        return this.strEditorStyle;
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
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.bAllowEmpty;
        }
        return true;
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

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", ignorert=3)
    public String getValueItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.strValueItemName)) {
            return this.strValueItemName;
        }
        return "";
    }

    public IPSDEFFormItem getPSDEFFormItem() {
        return this.iPSDEFFormItem;
    }

    protected void setPSDEFFormItem(IPSDEFFormItem iPSDEFFormItem) {
        this.iPSDEFFormItem = iPSDEFFormItem;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        IPSAppView iPSAppView = this.getRefPickupPSAppView();
        if (iPSAppView != null) {
            relatedAppViewList.add(iPSAppView);
        }
        if ((iPSAppView = this.getRefLinkPSAppView()) != null) {
            relatedAppViewList.add(iPSAppView);
        }
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u9009\u62e9\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = "";
        if (StringHelper.isNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFFormItem != null) {
            strPickupPSDEViewId = this.iPSDEFFormItem.getRefPickupPSDEViewId(this.getPSSysSearchBar().getPSAppView().getPSApplication());
        }
        if (!StringHelper.isNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSSysSearchBar().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            IPSAppView refPickupPSAppView = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSSysSearchBar().getPSAppView());
            refPickupPSAppView.markViewUsage(2, this);
            return refPickupPSAppView;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u94fe\u63a5\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefLinkPSAppView() throws Exception {
        String strLinkPSDEViewId = "";
        if (StringHelper.isNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFFormItem != null) {
            strLinkPSDEViewId = this.iPSDEFFormItem.getRefLinkPSDEViewId(this.getPSSysSearchBar().getPSAppView().getPSApplication());
        }
        if (!StringHelper.isNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSSysSearchBar().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            IPSAppView refLinkPSAppView = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSSysSearchBar().getPSAppView());
            refLinkPSAppView.markViewUsage(2, this);
            return refLinkPSAppView;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u7c7b\u578b", dump=false)
    public String getItemHandlerType() {
        if (!StringHelper.isNullOrEmpty((String)this.strItemHandlerType)) {
            if (StringHelper.compare((String)this.strItemHandlerType, (String)"None", (boolean)true) == 0) {
                return "";
            }
            return this.strItemHandlerType;
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && StringHelper.compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
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
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType")
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c")
    public String getCreateDV() {
        return this.strCreateDV;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", dump=false)
    public boolean isEditable() {
        return this.bEditable;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9879\u53c2\u6570", dump=false)
    public JSONObject getItemParam() throws Exception {
        if (this.itemParamJO != null) {
            return this.itemParamJO;
        }
        String strItemParam = this.getEditorParam(EDITORPARAM_ITEMPARAM, null);
        if (!StringHelper.isNullOrEmpty((String)strItemParam)) {
            this.itemParamJO = JSONObjectHelper.fromString2((String)strItemParam);
            return this.itemParamJO;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEDataSetId())) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFFormItem.getRefPSDEDataSetId());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEDataSet();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u6570\u636e\u96c6\u4e0a\u4e0b\u6587\u903b\u8f91", hideempty=true)
    public IPSDELogic getRefActiveDataPSDELogic() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefActiveDataPSDELogicId())) {
            return this.iPSDEFFormItem.getRefPSDataEntity().getPSDELogic(this.iPSDEFFormItem.getRefActiveDataPSDELogicId());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getRefPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (this.iPSDEFFormItem != null && this.iPSDEFFormItem.getRefPSDataEntity() != null) {
            if (!StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDEACModeId())) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getPSDEACMode(this.iPSDEFFormItem.getRefPSDEACModeId());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return this.iPSDEFFormItem.getRefPSDataEntity().getDefaultPSDEACMode();
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5173\u7cfb", hideempty=true)
    public IPSDERBase getRefPSDER() throws Exception {
        if (this.iPSDEFFormItem != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFFormItem.getRefPSDERId())) {
            return this.iPSDEFFormItem.getPSDEField().getPSDataEntity().getPSSystem().getPSDER(this.iPSDEFFormItem.getRefPSDERId());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
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
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u6362\u4e3a\u4ee3\u7801\u9879\u6587\u672c", ignoredumpvalues="false")
    public boolean isConvertToCodeItemText() {
        if (StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        if (this.bConvertToCodeItemText != null) {
            return this.bConvertToCodeItemText;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
    }

    @Override
    @PSModelRTMeta(description="\u9700\u8981\u4ee3\u7801\u8868\u914d\u7f6e", ignoredumpvalues="false")
    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u4ee3\u7801\u8868\u914d\u7f6e\u6a21\u5f0f", codelist="OutputCodeListConfigMode", ignoredumpvalues="0")
    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfig;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"LABELRAWCSSSTYLE"})
    public String getLabelCssStyle() {
        return this.strLabelCssStyle;
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
    public String getEditorDynaClass() {
        return null;
    }

    @Override
    public String getEditorCssStyle2() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", ignorert=3, hideempty2=true)
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0\u96c6\u5408", hideempty2=true, child=true)
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u7a7a\u767d\u6807\u7b7e")
    public boolean isEmptyCaption() {
        return this.bEmptyCaption;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u7247\u5bf9\u8c61")
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
    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236", ignoredumpvalues="false")
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
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
    public IPSDEFInputTip getPSDEFInputTip() {
        return this.iPSDEFInputTip;
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

    protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSysSearchBar().getPSDataEntity().getPSAjaxControlHandlerData(strPSACHandlerId);
        PSDEFormItemAjaxHandlerImpl psAjaxHandlerImpl = new PSDEFormItemAjaxHandlerImpl();
        psAjaxHandlerImpl.init(this.getDAGlobalHelper(), this, psACHandler);
        return psAjaxHandlerImpl;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return this.itemPSAjaxHandler;
    }

    @Override
    public String getModelName() {
        if (!StringHelper.isNullOrEmpty((String)this.getCaption())) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u7684\u503c\u9879\u96c6\u5408")
    public String[] getValueItemNames() {
        String strValueItemName = this.getValueItemName();
        if (StringHelper.isNullOrEmpty((String)strValueItemName)) {
            return null;
        }
        return strValueItemName.split("[;]");
    }

    @Override
    public String getEditorContainer() {
        return "SEARCHBARFILTER";
    }

    protected boolean isRegisterToPSAppDataEntity() {
        return this.getPSSysSearchBar().getPSAppView().getPSPFStyle().getPFEngineVer() >= 20;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u4e34\u65f6\u6570\u636e", dump=false)
    public boolean isRefTempData() {
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
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bf9\u8c61", child=true)
    public IPSEditor getPSEditor() throws Exception {
        if (this.iPSEditor == null && this.getPSEditorType() != null) {
            this.iPSEditor = this.getPSEditorType().createPSEditor(this);
        }
        return this.iPSEditor;
    }

    @Override
    public String getEditorName() {
        return this.getName();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSSysSearchBar();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u591a\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        if (super.getCapPSLanguageRes() != null) {
            return super.getCapPSLanguageRes();
        }
        if (this.iPSDEFFormItem != null) {
            return this.iPSDEFFormItem.getCapPSLanguageRes();
        }
        return null;
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() == null) {
            return null;
        }
        return this.getCapPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u9879\u754c\u9762\u6837\u5f0f\u8868")
    public IPSSysCss getPSSysCss() {
        return super.getPSSysCss();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", child=true)
    public IPSDEFSearchMode getPSDEFSearchMode() {
        return this.iPSDEFSearchMode;
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHBARFILTER";
    }

    @Override
    @PSModelRTMeta(description="\u6dfb\u52a0\u5206\u9694\u680f", ignoredumpvalues="false")
    public boolean isAddSeparator() {
        return this.bAddSeparator;
    }

    @Override
    public String getPSSysDictCatId() {
        return null;
    }

    @Override
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        return null;
    }

    @Override
    public IPSSysCss getEditorPSSysCss() {
        return null;
    }
}

