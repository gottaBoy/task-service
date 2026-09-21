/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.control.grid.IGEIDEACMode
 *  net.ibizsys.paas.control.grid.IGEIDEFValueRule
 *  net.ibizsys.paas.control.grid.IGrid
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.IDataItem
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItemUpdate;
import SA.SRFDA.PS.Core.Control.Grid.IPSGEIDEFValueRule;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSEditor;
import SA.SRFDA.PS.Core.Control.IPSEditorType;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.Data.PSDataItemImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysEditorStyle;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.control.grid.IGEIDEACMode;
import net.ibizsys.paas.control.grid.IGEIDEFValueRule;
import net.ibizsys.paas.control.grid.IGrid;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HiddenPSDEGridEditItemImpl
extends PSObjectImpl
implements IPSDEGridEditItem {
    private static final Log log = LogFactory.getLog(HiddenPSDEGridEditItemImpl.class);
    private IPSDEGrid iPSDEGrid = null;
    protected IPSDEFGridColumn iPSDEFGridColumn = null;
    protected IPSDEField iPSDEField = null;
    protected IPSAppDEField iPSAppDEField = null;
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
    private boolean bRowEditable = true;
    private boolean bDefineEditorType = true;
    private IPSEditor iPSEditor = null;
    protected ArrayList<IPSDEGridDataItem> psDEGridDataItemList = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEGrid iPSDEGrid, IPSDEField iPSDEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEField = iPSDEField;
            this.iPSDEGrid = iPSDEGrid;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSDEGrid().getId(), (String)this.iPSDEField.getName()));
            this.setName(this.iPSDEField.getName().toLowerCase());
            if (this.getPSDEGrid().getPSAppDataEntity() != null && this.iPSDEField != null) {
                this.iPSAppDEField = this.getPSDEGrid().getPSAppDataEntity().getPSAppDEField(this.iPSDEField.getId(), true);
            }
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
        boolean bUseDTO = false;
        if (this.getPSDEGrid().getPSAppView() != null && this.getPSDEGrid().getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSDEGrid().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (!bUseDTO) {
            if (this.getPSSystemSetting() != null) {
                this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
        } else {
            this.psDataItemImpl.setFormat("");
        }
        IPSDEFUIMode iPSDEFUIMode = this.iPSDEField.getPSDEFUIMode("DEFAULT");
        this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
        this.strEditorType = "HIDDEN";
        this.bRowEditable = true;
        this.editorParams = PropertiesHelper.load((String)"");
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
            this.bDefineEditorType = true;
        }
        if (this.getPSDEFGridColumn() != null) {
            boolean bAppendParam = false;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorType)) {
                this.strEditorType = this.iPSDEFGridColumn.getEditorType();
                bAppendParam = true;
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strEditorType, (String)this.iPSDEFGridColumn.getEditorType(), (boolean)true) == 0) {
                bAppendParam = true;
            }
            if (bAppendParam) {
                for (Object object : this.iPSDEFGridColumn.getEditorParams().keySet()) {
                    if (this.editorParams.containsKey(object)) continue;
                    this.editorParams.put(object, this.iPSDEFGridColumn.getEditorParams().get(object));
                }
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                this.strEditorStyle = this.iPSDEFGridColumn.getEditorStyle();
            }
        }
        boolean bl = this.bHidden = SA.SRFramework.Utility.StringHelper.Compare((String)this.strEditorType, (String)"HIDDEN", (boolean)true) == 0;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getEditorType())) {
            this.iPSEditorType = this.getPSModelStorage().getPSEditorType(this.getEditorType());
            this.bEditable = this.iPSEditorType.isEditable();
            if (!this.iPSEditorType.isEditable()) {
                this.bAllowEmpty = true;
            }
            for (Object objKey : this.iPSEditorType.getEditorParams().keySet()) {
                if (this.editorParams.containsKey(objKey)) continue;
                this.editorParams.put(objKey, this.iPSEditorType.getEditorParams().get(objKey));
            }
            this.strValueProcessor = this.iPSEditorType.getValueProcessor();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEditorStyle)) {
                this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getPSSysEditorStyle(this.strEditorStyle, "GRIDCOLUMN");
            } else if (!this.iPSDEGrid.isDesignMode()) {
                this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getDefaultPSSysEditorStyle(this.getEditorType(), "GRIDCOLUMN");
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
            Iterator<IPSGEIDEFValueRule> psGEIDEFValueRules = this.iPSDEFGridColumn.getPSGEIDEFValueRules();
            while (psGEIDEFValueRules.hasNext()) {
                if (this.geiDEFValueRuleList == null) {
                    this.geiDEFValueRuleList = new ArrayList();
                }
                this.geiDEFValueRuleList.add(psGEIDEFValueRules.next());
            }
        }
        if (this.iPSDEFGridColumn != null) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCreateDVT)) {
                this.strCreateDVT = this.iPSDEFGridColumn.getCreateDVT();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCreateDV)) {
                this.strCreateDV = this.iPSDEFGridColumn.getCreateDV();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUpdateDVT)) {
                this.strUpdateDVT = this.iPSDEFGridColumn.getUpdateDVT();
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUpdateDV)) {
                this.strUpdateDV = this.iPSDEFGridColumn.getUpdateDV();
            }
        }
        if (this.iPSDEFGridColumn != null) {
            this.nIgnoreInput = this.iPSDEFGridColumn.getIgnoreInput();
        }
        if (this.isConvertToCodeItemText()) {
            this.nIgnoreInput = 3;
        }
        if (!this.iPSDEGrid.isDesignMode()) {
            this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
            if (this.getPSDEFGridColumn() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                this.bNeedCodeListConfig = this.getPSDEFGridColumn().isNeedCodeListConfig();
            }
            this.nOutputCodeListConfigMode = this.getPSEditorType().getOutputCodeListConfigMode();
            if (this.getPSDEFGridColumn() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                this.nOutputCodeListConfigMode = this.getPSDEFGridColumn().getOutputCodeListConfigMode();
            }
        }
        this.strEditorCssStyle = this.calcEditorCssStyle();
        String strResetItemName = "";
        if (this.getPSDEField() != null && this.getPSDEField().getRestrictedPSDEField() != null) {
            strResetItemName = this.getPSDEField().getRestrictedPSDEField().getName().toLowerCase();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strResetItemName)) {
            String[] stringArray;
            this.resetItemNameList = new ArrayList();
            String[] stringArray2 = stringArray = SA.SRFramework.Utility.StringHelper.SplitEx((String)strResetItemName);
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
        if (this.iPSDEFGridColumn != null) {
            this.psDEGridDataItemList = this.iPSDEFGridColumn.getPSDEGridDataItemsByEditItem(this);
        }
        if (this.iPSDEField != null) {
            this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
        }
        if (this.bEnableItemPriv && this.iPSDEField != null) {
            this.strItemPrivId = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
        }
        super.onInit();
        this.preparePSEditor();
    }

    protected void preparePSEditor() throws Exception {
        this.getPSEditor();
    }

    @Override
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public IPSCodeList getPSCodeList() {
        return null;
    }

    @Override
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

    @Override
    public String getEditorType() {
        return this.strEditorType;
    }

    @Override
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", fields={"ALLOWEMPTY"})
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

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", fields={"VALUEITEMNAME"}, ignorert=3)
    public String getValueItemName() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strValueItemName)) {
            return this.strValueItemName;
        }
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getValueItemName(this);
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

    @Override
    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules() {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getPSGEIDEFValueRules();
        }
        return null;
    }

    @Override
    public IPSDEFGridColumn getPSDEFGridColumn() {
        return this.iPSDEFGridColumn;
    }

    protected void setPSDEFGridColumn(IPSDEFGridColumn iPSDEFGridColumn) {
        this.iPSDEFGridColumn = iPSDEFGridColumn;
    }

    @Override
    public IPSAppView getRefPickupPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return null;
        }
        String strPickupPSDEViewId = "";
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFGridColumn != null) {
            strPickupPSDEViewId = this.iPSDEFGridColumn.getRefPickupPSDEViewId();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return this.getPSDEGrid().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strPickupPSDEViewId);
        }
        return null;
    }

    @Override
    public IPSAppView getRefLinkPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return null;
        }
        String strLinkPSDEViewId = "";
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFGridColumn != null) {
            strLinkPSDEViewId = this.iPSDEFGridColumn.getRefLinkPSDEViewId();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            return this.getPSDEGrid().getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, strLinkPSDEViewId);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b", hideempty=true, dump=false)
    public String getItemHandlerType() {
        if (!this.getPSDEGrid().isEnableRowEdit()) {
            return "";
        }
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemHandlerType(this);
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && this.getPSCodeList() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return "CodeList";
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
            return "AC";
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond", fields={"ENABLECOND"})
    public int getEnableCond() {
        return this.nEnableCond;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"CREATEDVT"})
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c", fields={"CREATEDV"})
    public String getCreateDV() {
        return this.strCreateDV;
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
    public boolean isEditable() {
        return this.bEditable;
    }

    public String getCapLanId() {
        return "";
    }

    @Override
    public JSONObject getItemParam() throws Exception {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemParam(this);
        }
        return null;
    }

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEDataSetId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFGridColumn.getRefPSDEDataSetId());
        }
        return null;
    }

    @Override
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEACModeId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEACMode(this.iPSDEFGridColumn.getRefPSDEACModeId());
        }
        return null;
    }

    @Override
    public IPSEditorType getPSEditorType() {
        return this.iPSEditorType;
    }

    public Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception {
        return null;
    }

    @Override
    public String getPSDEGEIUpdateId() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEGrid", fields={"PSDEGEIUPDATEID"})
    public IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEGEIUpdateId())) {
            return null;
        }
        return this.getPSDEGrid().getPSDEGridEditItemUpdate(this.getPSDEGEIUpdateId());
    }

    @Override
    public Properties getEditorParams() {
        return this.editorParams;
    }

    @Override
    public int getEditorParam(String strParam, int nDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (int)nDefault);
    }

    @Override
    public String getEditorParam(String strParam, String strDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (String)strDefault);
    }

    @Override
    public double getEditorParam(String strParam, double fDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getEditorParam(String strParam, boolean bDefault) {
        if (this.getPSSysEditorStyle() != null) {
            return this.getPSSysEditorStyle().getEditorParam(strParam, PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault));
        }
        return PropertiesHelper.getProperty((Properties)this.getEditorParams(), (String)strParam, (boolean)bDefault);
    }

    @Override
    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    public String getValueRuleId() {
        return this.getPSSysValueRuleId();
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", codelist="FormItemEnableCond", fields={"IGNOREINPUT"})
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @Override
    @PSModelRTMeta(description="\u8f6c\u5316\u4e3a\u4ee3\u7801\u9879\u6587\u672c", ignoredumpvalues="false")
    public boolean isConvertToCodeItemText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
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

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u540d\u79f0", ignorert=3, hideempty2=true, fields={"RESETITEMNAME"})
    public String getResetItemName() {
        return this.strResetItemName;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u96c6\u5408", hideempty2=true, child=true, outputdoc="false", fields={"RESETITEMNAME"})
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    public String getUserDictCatId() {
        return "";
    }

    @Override
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    @Override
    public IPSDEGridColumn getPSDEGridColumn() {
        return null;
    }

    @PSModelRTMeta(description="\u6570\u636e\u9879")
    public IDataItem getDataItem() {
        if (this.psDEGridDataItemList != null && this.psDEGridDataItemList.size() > 0) {
            return this.psDEGridDataItemList.get(0);
        }
        return this.psDataItemImpl;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", hideempty2=true)
    public String getCaption() {
        return null;
    }

    @Override
    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", hideempty2=true)
    public String getCodeName() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEGrid().getPSSysModelInstId();
    }

    @Override
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.getPSDEGrid().getPSDataEntity().getPSSystem();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)((Object)this.getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSDEGRIDEDITITEM";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u503c\u9879\u540d\u79f0\u96c6\u5408")
    public String[] getValueItemNames() {
        return null;
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

    @Override
    @PSModelRTMeta(description="\u5217\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getRefPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u5bf9\u8c61", hideempty=true, child=true)
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
        return this.getPSDEGrid();
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
    public String getPredefinedType() {
        return null;
    }

    @Override
    public String getRenderMode() {
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

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u540d\u79f0")
    public String getUnitName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getUnitNameWidth() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5355\u4f4d", ignoredumpvalues="false")
    public boolean isEnableUnitName() {
        return false;
    }
}

