/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSEditorType
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate
 *  net.ibizsys.model.control.grid.IPSDEGridFieldColumn
 *  net.ibizsys.model.control.grid.IPSGEIDEFValueRule
 *  net.ibizsys.model.dataentity.ac.IPSDEACMode
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.uiaction.IPSDEUIAction
 *  net.ibizsys.model.res.IPSSysEditorStyle
 *  net.ibizsys.model.view.IPSUIAction
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
 */
package net.ibizsys.model.control.grid;

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
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.control.grid.IPSDEFGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItemUpdate;
import net.ibizsys.model.control.grid.IPSDEGridFieldColumn;
import net.ibizsys.model.control.grid.IPSGEIDEFValueRule;
import net.ibizsys.model.control.grid.PSDEGridColumnImpl;
import net.ibizsys.model.control.grid.PSDEGridEditItemAjaxHandlerImpl;
import net.ibizsys.model.data.PSDataItemImpl;
import net.ibizsys.model.dataentity.IPSDataEntityRuntime;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionRuntime;
import net.ibizsys.model.entity.PSACHandler;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.view.IPSUIAction;
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

public class PSDEGridFieldColumnImpl
extends PSDEGridColumnImpl
implements IPSDEGridFieldColumn,
IPSDEGridEditItem {
    protected IPSDEFGridColumn iPSDEFGridColumn = null;
    protected IPSDEField iPSDEField = null;
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
    protected GEIDEACModeImpl geiDEACModeImpl = null;
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
    private String strGroupItem = null;
    private String strDataItemName = null;
    private String strItemHandlerType = null;
    private IPSAjaxHandler itemPSAjaxHandler = null;
    private IPSDEUIAction iPSDEUIAction = null;
    private String strCLConvertMode = null;
    private boolean bGenerateDataItems = true;

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSystemSetting() != null) {
            this.psDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
        }
        this.iPSDEField = this.getPSDEGrid().getPSDataEntity().getPSDEField(this.psDEGridColumn.getPSDEFID(), false);
        IPSDEFUIMode iPSDEFUIMode = null;
        iPSDEFUIMode = StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPSDEFUIMODEID()) ? this.iPSDEField.getPSDEFUIMode("DEFAULT") : this.iPSDEField.getPSDEFUIMode(this.psDEGridColumn.getPSDEFUIMODEID());
        this.iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
        this.strPSCodeListId = this.psDEGridColumn.getPSCODELISTID();
        this.strCLConvertMode = this.psDEGridColumn.getCLCONVERTMODE();
        if (this.iPSDEFGridColumn != null) {
            if (StringHelper.isNullOrEmpty((String)this.strPSCodeListId)) {
                this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
            }
            if (StringHelper.isNullOrEmpty((String)this.strCLConvertMode)) {
                this.strCLConvertMode = this.iPSDEFGridColumn.getCLConvertMode();
            }
            if (!this.isDefineEnableSort()) {
                this.setEnableSort(this.iPSDEFGridColumn.isEnableSort());
            }
        }
        if (StringHelper.compare((String)this.getCLConvertMode(), (String)"NONE", (boolean)true) == 0) {
            this.strPSCodeListId = "";
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            this.iPSCodeList = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
            if (StringHelper.isNullOrEmpty((String)this.getCLConvertMode())) {
                this.strCLConvertMode = this.iPSCodeList.isEnableDynaSys() || StringHelper.compare((String)this.iPSCodeList.getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0 ? "BACKEND" : "FRONT";
            }
        }
        if (this.iPSCodeList == null) {
            this.strCLConvertMode = "NONE";
        }
        if (StringHelper.isNullOrEmpty((String)this.getAlign())) {
            this.setAlign(this.iPSDEFGridColumn.getColumnAlign());
        }
        if (this.isFixColDataItemBug()) {
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getDATAITEMS())) {
                this.strDataItemName = this.psDEGridColumn.getDATAITEMS().toLowerCase();
                this.bGenerateDataItems = false;
            }
        } else {
            String strDataItems = this.psDEGridColumn.getDATAITEMS();
            if (!StringHelper.isNullOrEmpty((String)strDataItems)) {
                strDataItems = strDataItems.toLowerCase();
                this.fields = StringHelper.splitEx((String)strDataItems);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getVALUEFORMAT())) {
            this.strValueFormat = this.psDEGridColumn.getVALUEFORMAT();
        }
        if (StringHelper.isNullOrEmpty((String)this.strValueFormat) && this.iPSDEFGridColumn != null) {
            this.strValueFormat = this.iPSDEFGridColumn.getValueFormat();
        }
        if (!this.psDEGridColumn.isENABLEROWEDITNull() && this.psDEGridColumn.getENABLEROWEDIT()) {
            this.bRowEditable = true;
            this.strValueItemName = this.psDEGridColumn.getVALUEITEMNAME();
            this.editorParams = PropertiesHelper.load((String)this.psDEGridColumn.getEDITORPARAMS());
            this.strEditorType = this.psDEGridColumn.getEDITORTYPE();
            this.strEditorStyle = this.psDEGridColumn.getPSSYSEDITORSTYLEID();
            if (!StringHelper.isNullOrEmpty((String)this.strEditorType)) {
                this.bDefineEditorType = true;
            }
            String strItemPSACHandlerId = null;
            if (this.getPSDEFGridColumn() != null) {
                strItemPSACHandlerId = this.getPSDEFGridColumn().getPSAjaxHandlerId();
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
            if (this.isDesignMode() && StringHelper.compare((String)this.getEditorType(), (String)"USERCONTROL", (boolean)true) == 0) {
                this.strEditorType = "SPAN";
                this.bDefineEditorType = true;
                this.strEditorStyle = "";
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
                    this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getPSSystem().getPSSysEditorStyle(this.strEditorStyle);
                } else if (!this.isDesignMode()) {
                    this.iPSSysEditorStyle = this.getPSDEGrid().getPSAppView().getPSApplication().getPSSystem().getDefaultPSSysEditorStyle(this.getEditorType());
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
            if (!this.psDEGridColumn.isALLOWEMPTYNull()) {
                this.bAllowEmpty = this.psDEGridColumn.getALLOWEMPTY();
            } else if (!this.bHidden && this.iPSDEFGridColumn != null) {
                this.bAllowEmpty = this.iPSDEFGridColumn.isAllowEmpty();
            }
            if (!this.bAllowEmpty && this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getPSDEField().isKeyDEField()) {
                this.bAllowEmpty = true;
            }
            if (!this.psDEGridColumn.isENABLECONDNull()) {
                this.nEnableCond = this.psDEGridColumn.getENABLECOND();
            } else if (this.iPSDEFGridColumn != null) {
                this.nEnableCond = this.iPSDEFGridColumn.getEnableCond();
            }
            this.strPSCodeListId = this.psDEGridColumn.getPSCODELISTID();
            if (StringHelper.isNullOrEmpty((String)this.strPSCodeListId) && this.iPSDEFGridColumn != null) {
                this.strPSCodeListId = this.iPSDEFGridColumn.getPSCodeListId();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPLACEHOLDER())) {
                this.strPlaceHolder = this.psDEGridColumn.getPLACEHOLDER();
            } else if (this.getPSDEFGridColumn() != null) {
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
            if (this.iPSDEFGridColumn != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEId()) && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEACModeId())) {
                this.geiDEACModeImpl = new GEIDEACModeImpl();
                this.geiDEACModeImpl.setDEACModeName(this.iPSDEFGridColumn.getRefPSDEACModeName());
                this.geiDEACModeImpl.setDEName(this.iPSDEFGridColumn.getRefPSDEName());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
                this.iPSCodeList = this.getPSDEGrid().getPSDataEntity().getPSSystem().getPSCodeList(this.getPSCodeListId());
            }
            this.strCreateDVT = this.psDEGridColumn.getCREATEDVT();
            this.strCreateDV = this.psDEGridColumn.getCREATEDV();
            this.strUpdateDVT = this.psDEGridColumn.getUPDATEDVT();
            this.strUpdateDV = this.psDEGridColumn.getUPDATEDV();
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
            if (!this.psDEGridColumn.isIGNOREINPUTNull()) {
                this.nIgnoreInput = this.psDEGridColumn.getIGNOREINPUT();
            } else if (this.iPSDEFGridColumn != null) {
                this.nIgnoreInput = this.iPSDEFGridColumn.getIgnoreInput();
            }
            if (this.isConvertToCodeItemText()) {
                this.nIgnoreInput = 3;
            }
            if (!this.isDesignMode()) {
                if (!this.psDEGridColumn.isNEEDCODELISTCONFIGNull()) {
                    this.bNeedCodeListConfig = this.psDEGridColumn.getNEEDCODELISTCONFIG();
                } else {
                    this.bNeedCodeListConfig = this.getPSEditorType().isNeedCodeListConfig();
                    if (this.getPSDEFGridColumn() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                        this.bNeedCodeListConfig = this.getPSDEFGridColumn().isNeedCodeListConfig();
                    }
                }
                if (!this.psDEGridColumn.isCODELISTCONFIGMODENull()) {
                    this.nOutputCodeListConfigMode = this.psDEGridColumn.getCODELISTCONFIGMODE();
                } else {
                    this.nOutputCodeListConfigMode = this.getPSEditorType().getOutputCodeListConfigMode();
                    if (this.getPSDEFGridColumn() != null && StringHelper.compare((String)this.strEditorType, (String)this.getPSDEFGridColumn().getEditorType(), (boolean)true) == 0) {
                        this.nOutputCodeListConfigMode = this.getPSDEFGridColumn().getOutputCodeListConfigMode();
                    }
                }
            }
            this.strEditorCssStyle = this.calcEditorCssStyle();
            String strResetItemName = this.psDEGridColumn.getRESETITEMNAME();
            StringHelper.isNullOrEmpty((String)strResetItemName);
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
        }
        if (this.iPSDEField != null) {
            this.bEnableItemPriv = this.iPSDEField.isEnablePrivilege();
        }
        if (!this.psDEGridColumn.isENABLEITEMPRIVNull()) {
            this.bEnableItemPriv = this.psDEGridColumn.getENABLEITEMPRIV();
        }
        if (this.bEnableItemPriv && this.iPSDEField != null) {
            this.strItemPrivId = StringHelper.format((String)"%1$s|%2$s", (Object)this.iPSDEField.getPSDataEntity().getName(), (Object)this.iPSDEField.getName());
        }
        this.psDEGridDataItemList = this.iPSDEFGridColumn.getPSDEGridDataItems((IPSDEGridFieldColumn)this);
        this.strDataItemName = this.iPSDEFGridColumn.getDataItemName((IPSDEGridFieldColumn)this);
        this.strGroupItem = this.psDEGridColumn.getGROUPITEM();
        if (!StringHelper.isNullOrEmpty((String)this.psDEGridColumn.getPSDEUIACTIONID())) {
            this.iPSDEUIAction = this.getPSDEGrid().getPSDataEntity().getPSDEUIAction(this.psDEGridColumn.getPSDEUIACTIONID());
            ((IPSAppViewRuntime)this.getPSDEGrid().getPSAppView()).registerPSUIAction((IPSUIAction)this.iPSDEUIAction);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u636e\u9879\u96c6\u5408")
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return this.psDEGridDataItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u6570\u636e\u9879\u540d\u79f0")
    public String getDataItemName() {
        return this.strDataItemName;
    }

    @Override
    protected int onGetWidth() {
        return this.iPSDEFGridColumn.getColumnWidth();
    }

    @Override
    protected String onGetCaption() {
        return this.iPSDEFGridColumn.getCaption(this.getPSDEGrid().getPSAppView().getLanguage());
    }

    @PSModelRTMeta(description="\u5217\u5b9e\u4f53\u5c5e\u6027")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public String getPSCodeListId() {
        return this.strPSCodeListId;
    }

    @Override
    @PSModelRTMeta(description="Excel\u5bfc\u51fa\u6807\u9898")
    public String getExcelCaption() {
        return this.getCaption();
    }

    @Override
    public String getCodeListId() {
        return this.getPSCodeListId();
    }

    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    public String[] getFields() {
        return this.fields;
    }

    protected String calcEditorCssStyle() throws Exception {
        StringBuilderEx editorCssStyle = new StringBuilderEx();
        return editorCssStyle.toString();
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u7c7b\u578b")
    public String getEditorType() {
        return this.strEditorType;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u5668\u6837\u5f0f")
    public String getEditorStyle() {
        return this.strEditorStyle;
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
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

    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0")
    public String getValueItemName() {
        if (!StringHelper.isNullOrEmpty((String)this.strValueItemName)) {
            return this.strValueItemName;
        }
        if (this.iPSDEFGridColumn != null) {
            return ((IPSDEFGridColumnRuntime)this.iPSDEFGridColumn).getValueItemName(this);
        }
        return "";
    }

    @PSModelRTMeta(description="\u81ea\u52a8\u586b\u5145\u6a21\u5f0f")
    public IGEIDEACMode getGEIDEACMode() {
        return this.geiDEACModeImpl;
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

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u503c\u89c4\u5219\u96c6\u5408", hideempty=true)
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

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        IPSAppView refPSAppView;
        super.fillRelatedPSAppViews(relatedAppViewList);
        IPSAppView iPSAppView = this.getRefPickupPSAppView();
        if (iPSAppView != null) {
            relatedAppViewList.add(iPSAppView);
        }
        if ((iPSAppView = this.getRefLinkPSAppView()) != null) {
            relatedAppViewList.add(iPSAppView);
        }
        if (this.getPSDEUIAction() != null && (refPSAppView = ((IPSDEUIActionRuntime)this.getPSDEUIAction()).getFrontPSAppView(this)) != null) {
            relatedAppViewList.add(refPSAppView);
        }
    }

    @PSModelRTMeta(description="\u5f15\u7528\u9009\u62e9\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefPickupPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return null;
        }
        String strPickupPSDEViewId = this.psDEGridColumn.getPICKUPPSDEVIEWID();
        if (StringHelper.isNullOrEmpty((String)strPickupPSDEViewId) && this.getPSEditorType().hasPickupView() && this.iPSDEFGridColumn != null) {
            strPickupPSDEViewId = this.iPSDEFGridColumn.getRefPickupPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strPickupPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strPickupPSDEViewId);
            return ((IPSApplicationRuntime)this.getPSDEGrid().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strPickupPSDEViewId, this.getPSDEGrid().getPSAppView());
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u6570\u636e\u94fe\u63a5\u89c6\u56fe", hideempty=true)
    public IPSAppView getRefLinkPSAppView() throws Exception {
        if (!this.getPSDEGrid().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return null;
        }
        String strLinkPSDEViewId = this.psDEGridColumn.getLINKPSDEVIEWID();
        if (StringHelper.isNullOrEmpty((String)strLinkPSDEViewId) && this.getPSEditorType().hasLinkView() && this.iPSDEFGridColumn != null) {
            strLinkPSDEViewId = this.iPSDEFGridColumn.getRefLinkPSDEViewId();
        }
        if (!StringHelper.isNullOrEmpty((String)strLinkPSDEViewId)) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSDEGrid().getPSAppView().getPSApplication().getId(), (String)strLinkPSDEViewId);
            return ((IPSApplicationRuntime)this.getPSDEGrid().getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, strLinkPSDEViewId, this.getPSDEGrid().getPSAppView());
        }
        return null;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u5f02\u6b65\u5904\u7406\u5668\u7c7b\u578b", hideempty=true)
    public String getItemHandlerType() {
        if (!this.getPSDEGrid().isEnableRowEdit() || !this.isEnableRowEdit()) {
            return "";
        }
        if (!StringHelper.isNullOrEmpty((String)this.strItemHandlerType)) {
            if (StringHelper.compare((String)this.strItemHandlerType, (String)"None", (boolean)true) == 0) {
                return "";
            }
            return this.strItemHandlerType;
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

    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond")
    public int getEnableCond() {
        return this.nEnableCond;
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

    @PSModelRTMeta(description="\u652f\u6301\u7f16\u8f91")
    public boolean isEditable() {
        return this.bEditable;
    }

    public String getCapLanId() {
        return "";
    }

    @PSModelRTMeta(description="\u9879\u53c2\u6570", hideempty=true)
    public ObjectNode getItemParam() throws Exception {
        if (this.iPSDEFGridColumn != null) {
            return this.iPSDEFGridColumn.getItemParam((IPSDEGridEditItem)this);
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u6570\u636e\u96c6\u5408", hideempty=true)
    public IPSDEDataSet getRefPSDEDataSet() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEDataSetId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEDataSet(this.iPSDEFGridColumn.getRefPSDEDataSetId());
        }
        return null;
    }

    @PSModelRTMeta(description="\u5f15\u7528\u81ea\u52a8\u586b\u5145\u6a21\u5f0f", hideempty=true)
    public IPSDEACMode getRefPSDEACMode() throws Exception {
        if (this.iPSDEFGridColumn != null && this.iPSDEFGridColumn.getRefPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.iPSDEFGridColumn.getRefPSDEACModeId())) {
            return this.iPSDEFGridColumn.getRefPSDataEntity().getPSDEACMode(this.iPSDEFGridColumn.getRefPSDEACModeId());
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

    public String getPSDEGEIUpdateId() {
        return this.psDEGridColumn.getPSDEGEIUPDATEID();
    }

    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u5bf9\u8c61", hideempty=true)
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

    public String getPSSysValueRuleId() {
        return this.strPSSysValueRuleId;
    }

    public String getValueRuleId() {
        return this.getPSSysValueRuleId();
    }

    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u5165\u6a21\u5f0f", codelist="FormItemEnableCond")
    public int getIgnoreInput() {
        return this.nIgnoreInput;
    }

    @PSModelRTMeta(description="\u8f6c\u5316\u4e3a\u4ee3\u7801\u9879\u6587\u672c")
    public boolean isConvertToCodeItemText() {
        if (StringHelper.isNullOrEmpty((String)this.getPSCodeListId())) {
            return false;
        }
        return this.getPSEditorType().isConvertToCodeItemText();
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
        return this.nOutputCodeListConfigMode;
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

    @PSModelRTMeta(description="\u91cd\u7f6e\u9879\u96c6\u5408", hideempty2=true)
    public Iterator<String> getResetItemNames() {
        if (this.resetItemNameList == null || this.resetItemNameList.size() == 0) {
            return null;
        }
        return this.resetItemNameList.iterator();
    }

    public String getUserDictCatId() {
        return this.psDEGridColumn.getPSSYSDICTCATID();
    }

    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f")
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    public IPSSysEditorStyle getPSSysEditorStyle() {
        return this.iPSSysEditorStyle;
    }

    public IPSDEGridColumn getPSDEGridColumn() {
        return this;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91")
    public boolean isEnableRowEdit() {
        return this.bRowEditable;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u7f16\u8f91\u9879\u5bf9\u8c61", hideempty=true)
    public IPSDEGridEditItem getPSDEGridEditItem() {
        if (this.isEnableRowEdit()) {
            return this;
        }
        return super.getPSDEGridEditItem();
    }

    public IDataItem getDataItem() {
        Iterator list = this.iPSDEFGridColumn.getPSDEGridDataItems();
        if (list != null && list.hasNext()) {
            return (IDataItem)list.next();
        }
        return this.psDataItemImpl;
    }

    @PSModelRTMeta(description="\u542f\u7528\u9879\u6743\u9650\u63a7\u5236")
    public boolean isEnableItemPriv() {
        return this.bEnableItemPriv;
    }

    protected void setEnableItemPriv(boolean bEnableItemPriv) {
        this.bEnableItemPriv = bEnableItemPriv;
    }

    public String getItemPrivId() {
        return this.strItemPrivId;
    }

    protected void setItemPrivId(String strItemPrivId) {
        this.strItemPrivId = strItemPrivId;
    }

    public String getGroupItem() {
        return this.strGroupItem;
    }

    protected void setGroupItem(String strGroupItem) {
        this.strGroupItem = strGroupItem;
    }

    protected IPSAjaxHandler createItemPSAjaxHandler(String strPSACHandlerId) throws Exception {
        PSACHandler psACHandler = ((IPSDataEntityRuntime)this.getPSDEGrid().getPSDataEntity()).getPSAjaxControlHandlerData(strPSACHandlerId);
        PSDEGridEditItemAjaxHandlerImpl psAjaxHandlerImpl = new PSDEGridEditItemAjaxHandlerImpl();
        psAjaxHandlerImpl.init(this.getPSModelStorageContext(), this, psACHandler);
        return psAjaxHandlerImpl;
    }

    @PSModelRTMeta(description="\u7f16\u8f91\u9879\u540e\u53f0\u5904\u7406\u5bf9\u8c61")
    public IPSAjaxHandler getItemPSAjaxHandler() {
        return this.itemPSAjaxHandler;
    }

    @PSModelRTMeta(description="\u89e6\u53d1\u754c\u9762\u884c\u4e3a", hideempty2=true)
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true)
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    protected boolean isFixColDataItemBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 2) == 2;
    }

    @PSModelRTMeta(description="\u662f\u5426\u81ea\u52a8\u4ea7\u751f\u6570\u636e\u9879")
    public boolean isGenerateDataItems() {
        return this.bGenerateDataItems;
    }

    protected class GEIDEACModeImpl
    implements IGEIDEACMode {
        private String strDEName = "";
        private String strDEACModeName = "";

        protected GEIDEACModeImpl() {
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

