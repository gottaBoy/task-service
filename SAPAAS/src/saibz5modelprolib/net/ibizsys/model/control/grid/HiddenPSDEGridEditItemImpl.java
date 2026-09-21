/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGrid
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 *  net.ibizsys.model.control.grid.IPSGEIDEFValueRule
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.res.IPSSysEditorStyle
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.grid.IGEIDEACMode
 *  net.ibizsys.paas.control.grid.IGEIDEFValueRule
 *  net.ibizsys.paas.control.grid.IGrid
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSControlRuntime;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.control.grid.IPSDEFGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItemRuntime;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.control.grid.IPSGEIDEFValueRule;
import net.ibizsys.model.data.PSDataItemImpl;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.grid.IGEIDEACMode;
import net.ibizsys.paas.control.grid.IGEIDEFValueRule;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HiddenPSDEGridEditItemImpl
extends PSObjectImpl
implements IPSDEGridEditItem,
IPSDEGridEditItemRuntime {
    private static final Log log = LogFactory.getLog(HiddenPSDEGridEditItemImpl.class);
    private IPSDEGrid iPSDEGrid = null;
    protected IPSDEFGridColumn iPSDEFGridColumn = null;
    protected IPSDEField iPSDEField = null;
    protected String strEditorType = "";
    protected String strEditorStyle = "";
    private boolean bEditable = false;
    private Properties editorParams = null;
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
    private ArrayList<IGEIDEFValueRule> geiDEFValueRuleList = null;
    private boolean bNeedCodeListConfig = false;
    private int nOutputCodeListConfigMode = 0;
    private String strValueItemName = "";
    private boolean bEnableItemPriv = false;
    private String strItemPrivId = null;
    protected PSDataItemImpl psDataItemImpl = new PSDataItemImpl();
    protected ArrayList<IPSDEGridDataItem> psDEGridDataItemList = null;
    private boolean bRowEditable = true;
    private boolean bDefineEditorType = true;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEGrid iPSDEGrid, IPSDEField iPSDEField) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEField = iPSDEField;
            this.iPSDEGrid = iPSDEGrid;
            this.setName(this.iPSDEField.getName().toLowerCase());
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSystemSetting() != null) {
            this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
        }
        IPSDEFUIMode iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode("DEFAULT");
        this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
        this.strEditorType = "HIDDEN";
        this.bRowEditable = true;
        this.editorParams = PropertiesHelper.load((String)"");
        if (!StringHelper.isNullOrEmpty((String)this.strEditorType)) {
            this.bDefineEditorType = true;
        }
        if (this.getPSDEFGridColumn() != null) {
            boolean bAppendParam = false;
            if (StringHelper.isNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.iPSDEFGridColumn.getEditorType();
                bAppendParam = true;
            } else if (StringHelper.compare((String)this.strEditorType, (String)this.iPSDEFGridColumn.getEditorType(), (boolean)true) == 0) {
                bAppendParam = true;
            }
            if (bAppendParam) {
                for (Object object : this.iPSDEFGridColumn.getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(object)) continue;
                    this.editorParams.put(object, this.iPSDEFGridColumn.getEditorParams().get(object));
                }
            }
            if (StringHelper.isNullOrEmpty((String)this.strEditorStyle)) {
                this.strEditorStyle = this.iPSDEFGridColumn.getEditorStyle();
            }
        }
        boolean bl = this.bHidden = StringHelper.compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
        if (!StringHelper.isNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorageContext().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
            }
            this.strValueProcessor = this.iPSEditorType.getValueProcessor();
            if (!StringHelper.isNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getPSSystem().getPSSysEditorStyle(this.strEditorStyle);
            } else if (!((IPSControlRuntime)this.iPSDEGrid).isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getPSSystem().getDefaultPSSysEditorStyle(this.getEditorType());
            }
        }
        if (!this.bHidden && this.iPSDEFGridColumn != null) {
            this.bAllowEmpty = this.iPSDEFGridColumn.isAllowEmpty();
        }
        if (!this.bAllowEmpty && this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getPSDEField().isKeyDEField()) {
            this.bAllowEmpty = true;
        }
        if (this.iPSDEFGridColumn != null) {
            this.nEnableCond = this.iPSDEFGridColumn.getEnableCond();
        }
        if (this.getPSDEFGridColumn() != null) {
            this.strPlaceHolder = this.getPSDEFGridColumn().getPlaceHolder();
        }
        if (this.iPSDEFGridColumn != null) {
            this.strPSSysValueRuleId = this.iPSDEFGridColumn.getPSSysValueRuleId();
        }
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getPSGEIDEFValueRules() != null) {
            Iterator psGEIDEFValueRules = this.iPSDEFGridColumn.getPSGEIDEFValueRules();
            while (psGEIDEFValueRules.hasNext()) {
                if (this.geiDEFValueRuleList == null) {
                    this.geiDEFValueRuleList = new ArrayList();
                }
                this.geiDEFValueRuleList.add((IGEIDEFValueRule)psGEIDEFValueRules.next());
            }
        }
        if (this.iPSDEFGridColumn != null) {
            if (StringHelper.isNullOrEmpty((String)this.strCreateDVT)) {
                this.strCreateDVT = this.iPSDEFGridColumn.getCreateDVT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strCreateDV)) {
                this.strCreateDV = this.iPSDEFGridColumn.getCreateDV();
            }
            if (StringHelper.isNullOrEmpty((String)this.strUpdateDVT)) {
                this.strUpdateDVT = this.iPSDEFGridColumn.getUpdateDVT();
            }
            if (StringHelper.isNullOrEmpty((String)this.strUpdateDV)) {
                this.strUpdateDV = this.iPSDEFGridColumn.getUpdateDV();
            }
        }
        if (this.iPSDEFGridColumn != null) {
            this.nIgnoreInput = this.iPSDEFGridColumn.getIgnoreInput();
        }
        if (this.isConvertToCodeItemText()) {
            this.nIgnoreInput = 3;
        }
        if (!((IPSControlRuntime)this.iPSDEGrid).isDesignMode()) {
            this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
            if (this.getPSDEFGridColumn() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                this.bNeedCodeListConfig = this.getPSDEFGridColumn().isNeedCodeListConfig();
            }
            this.nOutputCodeListConfigMode = this.getPSEditorType().getOutputCodeListConfigMode();
            if (this.getPSDEFGridColumn() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                this.nOutputCodeListConfigMode = this.getPSDEFGridColumn().getOutputCodeListConfigMode();
            }
        }
        this.strEditorCssStyle = this.calcEditorCssStyle();
        String strResetItemName = "";
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
        if (this.bEnableItemPriv && this.iPSDEField != null) {
            this.strItemPrivId = StringHelper.format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
        }
        super.onInit();
    }

    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    public IPSCodeList getPSCodeList() {
        return null;
    }

    public String getPSCodeListId() {
        return "";
    }

    public String getCodeListId() {
        return this.getPSCodeListId();
    }

    protected String calcEditorCssStyle() throws Exception {
        StringBuilderEx editorCssStyle = new StringBuilderEx();
        return editorCssStyle.toString();
    }

    public String getEditorType() {
        return this.strEditorType;
    }

    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    public boolean isAllowEmpty() {
        if (this.isEditable()) {
            return this.bAllowEmpty;
        }
        return true;
    }

    public Object getInputValue(IWebContext iWebContext) throws Exception {
        return null;
    }

    public Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception {
        return null;
    }

    public String getPrivilegeId() {
        return null;
    }

    public String getValueItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.strValueItemName)) {
            return this.strValueItemName;
        }
        if (this.iPSDEFGridColumn != null) {
            return ((IPSDEFGridColumnRuntime)this.iPSDEFGridColumn).getValueItemName(this);
        }
        return "";
    }

    public IGEIDEACMode getGEIDEACMode() {
        return null;
    }

    public String getDEFName() {
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getName();
        }
        return "";
    }

    public IGrid getGrid() {
        return this.getPSDEGrid();
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    public Iterator<IGEIDEFValueRule> getGEIDEFValueRules() {
        if (this.geiDEFValueRuleList == null || this.geiDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.geiDEFValueRuleList.iterator();
    }

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules() {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getPSGEIDEFValueRules();
        }
        return null;
    }

    public IPSDEFGridColumn getPSDEFGridColumn() {
        return this.iPSDEFGridColumn;
    }

    protected void setPSDEFGridColumn(IPSDEFGridColumn iPSDEFGridColumn) {
        this.iPSDEFGridColumn = iPSDEFGridColumn;
    }

    public IPSAppView getRefPickupPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return null;
        }
        String strPickupPSDEViewId = "";
        if (StringHelper.isNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFGridColumn != null) {
            strPickupPSDEViewId = this.iPSDEFGridColumn.getRefPickupPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return ((IPSApplicationRuntime)this.getPSDEGrid().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strPickupPSDEViewId);
        }
        return null;
    }

    public IPSAppView getRefLinkPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return null;
        }
        String strLinkPSDEViewId = "";
        if (StringHelper.isNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFGridColumn != null) {
            strLinkPSDEViewId = this.iPSDEFGridColumn.getRefLinkPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            return ((IPSApplicationRuntime)this.getPSDEGrid().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strLinkPSDEViewId);
        }
        return null;
    }

    public String getItemHandlerType() {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return "";
        }
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemHandlerType((IPSDEGridEditItem)this);
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && StringHelper.compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (StringHelper.compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
            return "AC";
        }
        return "";
    }

    public int getEnableCond() {
        return this.nEnableCond;
    }

    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    public String getCreateDV() {
        return this.strCreateDV;
    }

    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    public ICodeList getCodeList() throws Exception {
        return this.getPSCodeList();
    }

    public boolean isEditable() {
        return this.bEditable;
    }

    public String getCapLanId() {
        return "";
    }

    public ObjectNode getItemParam() throws Exception {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemParam((IPSDEGridEditItem)this);
        }
        return null;
    }

    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEDataSetId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFGridColumn.getRefPSDEDataSetId());
        }
        return null;
    }

    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEACModeId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEACMode(this.iPSDEFGridColumn.getRefPSDEACModeId());
        }
        return null;
    }

    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
        return null;
    }

    public String getPSDEGEIUpdateId() {
        return "";
    }

    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.getPSDEGEIUpdateId())) {
            return null;
        }
        return this.getPSDEGrid().getPSDEGridEditItemUpdate(this.getPSDEGEIUpdateId());
    }

    public Properties getEditorParams() {
        return this.editorParams;
    }

    public int getEditorParam(String strParam, int nDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    public String getEditorParam(String strParam, String strDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    public double getEditorParam(String strParam, double fDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    public boolean getEditorParam(String strParam, boolean bDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    public String getValueRuleId() {
        return this.getPSSysValueRuleId();
    }

    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    public boolean isConvertToCodeItemText() {
        if (StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
    }

    public JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception {
        return null;
    }

    public boolean isNeedCodeListConfig() {
        return this.bNeedCodeListConfig;
    }

    public int getOutputCodeListConfigMode() {
        return this.nOutputCodeListConfigMode;
    }

    public String getEditorCssStyle() {
        return this.strEditorCssStyle;
    }

    public String getValueTranslator() {
        return this.strValueProcessor;
    }

    public String getResetItemName() {
        return this.strResetItemName;
    }

    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    public String getUserDictCatId() {
        return "";
    }

    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    public IPSDEGridColumn getPSDEGridColumn() {
        return null;
    }

    public IDataItem getDataItem() {
        Iterator list = this.iPSDEFGridColumn.getPSDEGridDataItems();
        if (list != null && list.hasNext()) {
            return (IDataItem)list.next();
        }
        return this.psDataItemImpl;
    }

    public String getCaption() {
        return null;
    }

    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0", hideempty2=true)
    public String getCodeName() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDEGrid()).getPSSysModelInstId();
    }

    public IPSAjaxHandler getItemPSAjaxHandler() {
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEGrid().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSSystem();
    }
}

