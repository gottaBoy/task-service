/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.panel.IPanel
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelField;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelDataItemImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelFieldAjaxHandlerImpl;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.panel.IPanel;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"FIELD"})
public class PSSysPanelFieldImpl
extends PSSysPanelItemImpl
implements IPSSysPanelField {
    private static final Log log = LogFactory.getLog(PSSysPanelFieldImpl.class);
    protected PSSysPanelDataItemImpl psDataItemImpl = new PSSysPanelDataItemImpl();
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    protected boolean bHidden = false;
    protected boolean bAllowEmpty = true;
    protected String strPSCodeListId = "";
    protected IPSCodeList iPSCodeList = null;
    private boolean bShowCaption = false;
    private boolean bEditable = true;
    private IPSEditorType iPSEditorType = null;
    private Properties editorParams = null;
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfig = 0;
    private String strCtrlCssStyle = "";
    private String strEditorCssStyle = "";
    private String strPlaceHolder = null;
    private IPSSysEditorStyle iPSSysEditorStyle = null;
    private String strItemHandlerType = null;
    private IPSAjaxHandler itemPSAjaxHandler = null;
    private Boolean bConvertToCodeItemText = null;
    private boolean bDefinedEditorType = false;
    private String strViewFieldName = "";
    private IPSEditor iPSEditor = null;
    private int nFieldStates = 0;
    private String strValueItemName = "";
    private ArrayList<String> valueItemNameList = null;
    private String strResetItemName = null;
    private ArrayList<String> resetItemNameList = null;

    @Override
    protected void onInit() throws Exception {
        String strResetItemName;
        int n;
        super.onInit();
        boolean bUseDTO = false;
        if (this.getPSSysPanel().getPSAppView() != null && this.getPSSysPanel().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSSysPanel().getPSAppView().getPSApplication().isUseServiceApi();
        }
        this.psDataItemImpl.init(this);
        if (!bUseDTO) {
            if (this.getPSSystemSetting() != null) {
                this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
        } else {
            this.psDataItemImpl.setFormat("");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getVALUEFORMAT())) {
            this.psDataItemImpl.setFormat(this.psSysPanelItem.getVALUEFORMAT());
        }
        this.strViewFieldName = this.psSysPanelItem.getFIELDNAME();
        if (!this.psSysPanelItem.isFIELDSTATESNull()) {
            this.nFieldStates = this.psSysPanelItem.getFIELDSTATES();
        }
        String strEditorParams = this.psSysPanelItem.getITEMPARAMS();
        this.editorParams = PropertiesHelper.load((String)strEditorParams);
        if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = this.psSysPanelItem.getEDITORTYPE();
        }
        this.strEditorStyle = this.psSysPanelItem.getPSSYSEDITORSTYLEID();
        if (!StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.bDefinedEditorType = true;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.strEditorType = "SPAN";
        }
        String strItemPSACHandlerId = null;
        if (this.isDesignMode()) {
            this.strEditorStyle = "";
            if (StringHelper.Compare((String)this.getEditorType(), (String)"USERCONTROL", (boolean)true) == 0) {
                this.strEditorType = "SPAN";
                this.bDefinedEditorType = true;
                this.strEditorStyle = "";
            }
        }
        boolean bl = this.bHidden = StringHelper.Compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
        if (!StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSSysPanel().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "PANELFIELD");
            } else if (!this.isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSSysPanel().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "PANELFIELD");
            }
            if (this.getPSSysEditorStyle() != null) {
                this.strItemHandlerType = this.getPSSysEditorStyle().getAjaxHandlerType();
                if (StringHelper.IsNullOrEmpty(strItemPSACHandlerId)) {
                    strItemPSACHandlerId = this.getPSSysEditorStyle().getPSAjaxHandlerId();
                }
                for (Object objKey : this.getPSSysEditorStyle().getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(objKey)) continue;
                    this.editorParams.put(objKey, this.getPSSysEditorStyle().getEditorParams().get(objKey));
                }
            }
            if (StringHelper.IsNullOrEmpty((String)this.strItemHandlerType)) {
                this.strItemHandlerType = this.getPSEditorType().getAjaxHandlerType();
            }
            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
            }
        }
        if ((this.getFieldStates() & 1) == 1) {
            this.editorParams.put("READONLY", "TRUE");
        }
        if (!StringHelper.IsNullOrEmpty(strItemPSACHandlerId)) {
            this.itemPSAjaxHandler = this.createItemPSAjaxHandler(strItemPSACHandlerId);
        }
        this.strPSCodeListId = this.psSysPanelItem.getPSCODELISTID();
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPLACEHOLDER())) {
            this.strPlaceHolder = this.psSysPanelItem.getPLACEHOLDER();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSSysPanel().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
        }
        if (this.iPSCodeList != null) {
            this.iPSCodeList = this.getPSSysPanel().getPSAppView().getPSApplication().getPSCodeList(this.iPSCodeList, true);
        }
        this.strEditorCssStyle = this.calcEditorCssStyle();
        this.strCtrlCssStyle = this.calcCtrlCssStyle();
        String strValueItemName = this.psSysPanelItem.getVALUEITEMNAME();
        if (!StringHelper.IsNullOrEmpty((String)strValueItemName)) {
            String[] items;
            this.valueItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)strValueItemName);
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
        if (!StringHelper.IsNullOrEmpty((String)(strResetItemName = this.psSysPanelItem.getRESETITEMNAME()))) {
            String[] items;
            this.resetItemNameList = new ArrayList();
            String[] stringArray = items = StringHelper.SplitEx((String)strResetItemName);
            int n3 = items.length;
            n = 0;
            while (n < n3) {
                String strItem = stringArray[n];
                if (!this.resetItemNameList.contains(strItem = strItem.trim())) {
                    this.resetItemNameList.add(strItem);
                }
                ++n;
            }
            if (this.resetItemNameList.size() > 0) {
                this.strResetItemName = this.resetItemNameList.get(0);
            }
        }
        if (!this.isDesignMode()) {
            this.getRefPickupPSAppView();
            this.getRefLinkPSAppView();
        }
        this.preparePSEditor();
    }

    protected void preparePSEditor() throws Exception {
        this.getPSEditor();
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
        return this.psSysPanelItem.getLABELRAWCSSSTYLE();
    }

    protected String calcCtrlCssStyle() throws Exception {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u5c5e\u6027\u9879", doc="\u8ba1\u7b97\u7f16\u8f91\u5668\u7c7b\u578b\u4e3a\u9690\u85cf\u9879(HIDDEN)", ignoredumpvalues="false")
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
        if (this.getPSSysEditorStyle() != null && this.getPSPanel().getPSAppView().getPSPFStyle().isEnableEditorStyleCode()) {
            return this.getPSSysEditorStyle().getStyleCode();
        }
        return this.strEditorStyle;
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psDEFormItemList) {
        psDEFormItemList.add(this);
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bbd\u5ea6", order=295, dump=false)
    public double getEditorWidth() {
        return this.getWidth();
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u9ad8\u5ea6", order=300, dump=false)
    public double getEditorHeight() {
        return this.getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.bAllowEmpty;
        }
        return true;
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
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
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898")
    public boolean isShowCaption() {
        return this.bShowCaption;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91", dump=false)
    public boolean isEditable() {
        return this.bEditable;
    }

    @Override
    public JSONObject getItemParam() throws Exception {
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
        String strValue = PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
        if (StringHelper.IsNullOrEmpty((String)strDefault) && StringHelper.IsNullOrEmpty((String)strValue) && strDefault != null) {
            if (StringHelper.Compare((String)"WRAPMODE", (String)strParam, (boolean)false) == 0) {
                return this.psSysPanelItem.getSWAPMODE();
            }
            if (StringHelper.Compare((String)"HALIGN", (String)strParam, (boolean)false) == 0) {
                return this.psSysPanelItem.getHALIGN();
            }
            if (StringHelper.Compare((String)"VALIGN", (String)strParam, (boolean)false) == 0) {
                return this.psSysPanelItem.getVALIGN();
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

    @Override
    @PSModelRTMeta(description="\u8f6c\u6362\u4e3a\u4ee3\u7801\u9879\u6587\u672c", ignoredumpvalues="false")
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
    protected void onLayout() throws Exception {
        super.onLayout();
        if (this.parentPSSysPanelContainer != null && StringHelper.Compare((String)this.parentPSSysPanelContainer.getLayoutMode(), (String)"TABLE_12COL", (boolean)true) != 0) {
            StringHelper.Compare((String)this.parentPSSysPanelContainer.getLayoutMode(), (String)"TABLE_24COL", (boolean)true);
        }
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
    public String getEditorCssStyle() {
        return this.strEditorCssStyle;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u9879\u56fe\u7247\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7f16\u8f91\u5668\u6837\u5f0f")
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
        PSACHandler psACHandler = this.getPSSysPanel().getPSDataEntity().getPSAjaxControlHandlerData(strPSACHandlerId);
        PSSysPanelFieldAjaxHandlerImpl psAjaxHandlerImpl = new PSSysPanelFieldAjaxHandlerImpl();
        psAjaxHandlerImpl.init(this.getDAGlobalHelper(), this, psACHandler);
        return psAjaxHandlerImpl;
    }

    @Override
    @PSModelRTMeta(description="\u9879\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return this.itemPSAjaxHandler;
    }

    @Override
    public String getFieldName() {
        return this.strViewFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u6a21\u578b\u5c5e\u6027\u540d\u79f0", fields={"FIELDNAME"})
    public String getViewFieldName() {
        return this.getFieldName();
    }

    @PSModelRTMeta(description="\u9879\u6570\u636e\u5bf9\u8c61")
    public IDataItem getDataItem() {
        return this.psDataItemImpl;
    }

    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public IPanel getPanel() {
        return this.getPSPanel();
    }

    public ICodeList getCodeList() throws Exception {
        return this.getPSCodeList();
    }

    public String getCodeListId() {
        return this.getPSCodeListId();
    }

    public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception {
        String strLinkPSDEViewId = this.psSysPanelItem.getREFLINKPSDEVIEWID();
        if (!StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSSysPanel().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            IPSAppView refLinkPSAppView = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSSysPanel().getPSAppView());
            refLinkPSAppView.markViewUsage(2, this);
            return refLinkPSAppView;
        }
        return null;
    }

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception {
        String strPickupPSDEViewId = this.psSysPanelItem.getREFPICKUPPSDEVIEWID();
        if (!StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSSysPanel().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            IPSAppView refPickupPSAppView = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSSysPanel().getPSAppView());
            refPickupPSAppView.markViewUsage(2, this);
            return refPickupPSAppView;
        }
        return null;
    }

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        IPSDataEntity refPSDataEntity = this.getRefPSDataEntity();
        if (refPSDataEntity != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getREFPSDEDATASETID())) {
                return refPSDataEntity.getPSDEDataSet(this.psSysPanelItem.getREFPSDEDATASETID());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEDataSet();
            }
        }
        return null;
    }

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        IPSDataEntity refPSDataEntity = this.getRefPSDataEntity();
        if (refPSDataEntity != null) {
            if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getREFPSDEACMODEID())) {
                return refPSDataEntity.getPSDEACMode(this.psSysPanelItem.getREFPSDEACMODEID());
            }
            if (this.isRegisterToPSAppDataEntity()) {
                return refPSDataEntity.getDefaultPSDEACMode();
            }
        }
        return null;
    }

    @Override
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getREFPSDEID())) {
            return this.getPSSystem().getPSDataEntity2(this.psSysPanelItem.getREFPSDEID());
        }
        return null;
    }

    @Override
    public String getEditorContainer() {
        return "PANELFIELD";
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_FIELD";
    }

    @Override
    public String getModelName() {
        if (!StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getCaption());
        }
        return super.getModelName();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", fields={"VALUEITEMNAME"}, ignorert=3)
    public String getValueItemName() {
        return this.strValueItemName;
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
        return this.getPSPanel();
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
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        if (this.psDataItemImpl != null) {
            return this.psDataItemImpl.getFormat();
        }
        return "";
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        super.onFillModelRefNode(objectNode, strModelRefType);
        if (this.isHidden()) {
            objectNode.put("hidden", this.isHidden());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getViewFieldName())) {
            objectNode.put("viewFieldName", this.getViewFieldName());
        }
        objectNode.remove("modelref");
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u72b6\u6001", codelist="PanelFieldState", ignoredumpvalues="0", fields={"FIELDSTATES"})
    public int getFieldStates() {
        return this.nFieldStates;
    }

    @Override
    public String getEditorDynaClass() {
        return this.psSysPanelItem.getCTRLDYNACLASS();
    }

    @Override
    public String getEditorCssStyle2() {
        return this.psSysPanelItem.getCTRLRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u76f4\u63a5\u6837\u5f0f", hideempty2=true, fields={"LABELRAWCSSSTYLE"}, dump=false)
    public String getLabelCssStyle() {
        return this.psSysPanelItem.getLABELRAWCSSSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u52a8\u6001\u6837\u5f0f\u8868", hideempty2=true, fields={"LABELDYNACLASS"}, dump=false)
    public String getLabelDynaClass() {
        return this.psSysPanelItem.getLABELDYNACLASS();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u7b7e\u6837\u5f0f\u8868\u5bf9\u8c61", fields={"LABELPSSYSCSSID"}, dump=false)
    public IPSSysCss getLabelPSSysCss() {
        return super.getLabelPSSysCss();
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
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        objectNode.remove("showCaption");
        objectNode.remove("labelCssStyle");
        objectNode.remove("labelDynaClass");
        objectNode.remove("getLabelPSSysCss");
        if (this.isHidden()) {
            objectNode.remove("itemStyle");
        }
    }
}

