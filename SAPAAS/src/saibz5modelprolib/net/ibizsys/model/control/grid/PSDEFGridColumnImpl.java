/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridColumn
 *  net.ibizsys.model.control.grid.IPSDEGridDataItem
 *  net.ibizsys.model.control.grid.IPSDEGridEditItem
 *  net.ibizsys.model.control.grid.IPSDEGridFieldColumn
 *  net.ibizsys.model.control.grid.IPSGEIDEFValueRule
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.grid;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.control.grid.IPSDEFGridColumnRuntime;
import net.ibizsys.model.control.grid.IPSDEGridColumn;
import net.ibizsys.model.control.grid.IPSDEGridDataItem;
import net.ibizsys.model.control.grid.IPSDEGridEditItem;
import net.ibizsys.model.control.grid.IPSDEGridFieldColumn;
import net.ibizsys.model.control.grid.IPSGEIDEFValueRule;
import net.ibizsys.model.control.grid.PSDEGridDataItemImpl;
import net.ibizsys.model.control.grid.PSGEIDEFValueRuleImpl;
import net.ibizsys.model.data.PSDataItemParamImpl;
import net.ibizsys.model.dataentity.field.PSDEFUIItemImpl;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFGridColumnImpl
extends PSDEFUIItemImpl
implements IPSDEFGridColumn,
IPSDEFGridColumnRuntime {
    private static final Log log = LogFactory.getLog(PSDEFGridColumnImpl.class);
    protected ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList();
    private String strColAlign = "LEFT";
    private boolean bEnableSort = true;
    protected ArrayList<IPSGEIDEFValueRule> psGEIDEFValueRuleList = new ArrayList();
    private String strValueItemName = "";
    private String strCLConvertMode = null;

    @Override
    protected void onInit() throws Exception {
        this.onPreparePSDEGridDataItems();
        this.strCLConvertMode = this.psDEFUIMode.getGRIDCOLCLMODE();
        if (!this.psDEFUIMode.isNOSORTNull()) {
            this.bEnableSort = !this.psDEFUIMode.getNOSORT();
        } else if (DataTypeHelper.isLongStringType((int)this.getPSDEField().getStdDataType())) {
            this.bEnableSort = false;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEFUIMode.getGRIDCOLALIGN())) {
            this.strColAlign = this.psDEFUIMode.getGRIDCOLALIGN();
        }
        this.strValueItemName = this.psDEFUIMode.getVALUEITEMNAME();
        Iterator psDEFValueRules = this.iPSDEField.getAllPSDEFValueRules();
        if (psDEFValueRules != null) {
            while (psDEFValueRules.hasNext()) {
                IPSDEFValueRule iPSDEFValueRule = (IPSDEFValueRule)psDEFValueRules.next();
                PSGEIDEFValueRuleImpl psFIDEFValueRuleImpl = new PSGEIDEFValueRuleImpl();
                psFIDEFValueRuleImpl.setDEFValueRule((IDEFValueRule)iPSDEFValueRule);
                this.psGEIDEFValueRuleList.add(psFIDEFValueRuleImpl);
            }
        }
        super.onInit();
    }

    protected void onPreparePSDEGridDataItems() throws Exception {
        PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
        psDEGridDataItemImpl.setName(this.getPSDEField().getName().toLowerCase());
        PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
        psItemParamImpl.setName(this.getPSDEField().getName());
        psItemParamImpl.setFormat(this.getValueFormat());
        String strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
        if (StringHelper.isNullOrEmpty((String)strPSCodeListId)) {
            strPSCodeListId = this.getPSDEField().getCodeListId();
        }
        if (!StringHelper.isNullOrEmpty((String)strPSCodeListId)) {
            psItemParamImpl.setCodeListId(strPSCodeListId);
            psItemParamImpl.setPSCodeList(this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(strPSCodeListId));
        }
        psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
        this.psDEGridDataItemList.add(psDEGridDataItemImpl);
    }

    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return this.psDEGridDataItemList.iterator();
    }

    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItems(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        return this.onPreparePSDEGridDataItems(iPSDEGridFieldColumn);
    }

    protected ArrayList<IPSDEGridDataItem> onPreparePSDEGridDataItems(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        IPSDEGridEditItem iPSDEGridEditItem;
        ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList<IPSDEGridDataItem>();
        String strDataItemName = iPSDEGridFieldColumn.getDataItemName();
        if (StringHelper.isNullOrEmpty((String)strDataItemName)) {
            strDataItemName = this.getDataItemName();
        }
        if (iPSDEGridFieldColumn.isEnableRowEdit() && iPSDEGridFieldColumn.getPSDEGridEditItem() != null && (iPSDEGridEditItem = iPSDEGridFieldColumn.getPSDEGridEditItem()).getPSEditorType() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName(String.valueOf(strDataItemName) + "_text");
            PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDEField().getName());
            psItemParamImpl.setFormat(this.getValueFormat());
            String strPSCodeListId = iPSDEGridFieldColumn.getPSCodeListId();
            if (StringHelper.isNullOrEmpty((String)strPSCodeListId)) {
                strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
            }
            if (StringHelper.isNullOrEmpty((String)strPSCodeListId)) {
                strPSCodeListId = this.getPSDEField().getCodeListId();
            }
            if (!StringHelper.isNullOrEmpty((String)strPSCodeListId)) {
                psItemParamImpl.setCodeListId(strPSCodeListId);
                psItemParamImpl.setPSCodeList(this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(strPSCodeListId));
            }
            if (iPSDEGridFieldColumn.isEnableItemPriv()) {
                psDEGridDataItemImpl.setPrivilegeId(iPSDEGridFieldColumn.getItemPrivId());
            }
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init(iPSDEGridFieldColumn.getPSDEGrid());
            psDEGridDataItemList.add(psDEGridDataItemImpl);
            if (iPSDEGridFieldColumn.isGenerateDataItems()) {
                psDEGridDataItemImpl = new PSDEGridDataItemImpl();
                psDEGridDataItemImpl.setName(strDataItemName);
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDEField().getName());
                psItemParamImpl.setFormat(this.getValueFormat());
                if (iPSDEGridFieldColumn.isEnableItemPriv()) {
                    psDEGridDataItemImpl.setPrivilegeId(iPSDEGridFieldColumn.getItemPrivId());
                }
                psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
                psDEGridDataItemImpl.init(iPSDEGridFieldColumn.getPSDEGrid());
                psDEGridDataItemList.add(psDEGridDataItemImpl);
            }
            return psDEGridDataItemList;
        }
        if (iPSDEGridFieldColumn.isGenerateDataItems()) {
            PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            if (iPSDEGridFieldColumn.isHiddenDataItem() && this.isFixDataItemNameBug()) {
                psDEGridDataItemImpl.setName(iPSDEGridFieldColumn.getName().toLowerCase());
            } else {
                psDEGridDataItemImpl.setName(strDataItemName);
            }
            PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDEField().getName());
            psItemParamImpl.setFormat(iPSDEGridFieldColumn.getValueFormat());
            IPSCodeList iPSCodeList = iPSDEGridFieldColumn.getPSCodeList();
            if (iPSCodeList != null) {
                psItemParamImpl.setCodeListId(iPSCodeList.getId());
                psItemParamImpl.setPSCodeList(iPSCodeList);
            }
            if (iPSDEGridFieldColumn.isEnableItemPriv()) {
                psDEGridDataItemImpl.setPrivilegeId(iPSDEGridFieldColumn.getItemPrivId());
            }
            psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
            psDEGridDataItemImpl.init((IPSDEGridColumn)iPSDEGridFieldColumn);
            psDEGridDataItemList.add(psDEGridDataItemImpl);
        }
        return psDEGridDataItemList;
    }

    @Override
    public String getDataItemName() {
        return this.getPSDEField().getName().toLowerCase();
    }

    @PSModelRTMeta(description="\u5217\u5bbd\u5ea6")
    public int getColumnWidth() {
        if (this.psDEFUIMode.isGRIDCOLWIDTHNull()) {
            return 100;
        }
        return this.psDEFUIMode.getGRIDCOLWIDTH();
    }

    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f")
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    @PSModelRTMeta(description="\u8868\u683c\u5217\u5bf9\u9f50", codelist="GridColAlign")
    public String getColumnAlign() {
        return this.strColAlign;
    }

    @Override
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        if (StringHelper.isNullOrEmpty((String)this.strValueItemName) && iPSDEGridEditItem.getPSEditorType() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return this.getPSDEField().getName().toLowerCase();
        }
        return this.strValueItemName;
    }

    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules() {
        if (this.psGEIDEFValueRuleList == null || this.psGEIDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.psGEIDEFValueRuleList.iterator();
    }

    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        if (iPSDEGridEditItem.getPSEditorType() != null) {
            if (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSAjaxHandlerId())) {
            return "Custom";
        }
        return "";
    }

    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond")
    public int getEnableCond() {
        return this.iPSDEField.getEnableUserInput();
    }

    public ObjectNode getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        return null;
    }

    public String getDataItemName(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        IPSDEGridEditItem iPSDEGridEditItem;
        String strDataItemName = iPSDEGridFieldColumn.getDataItemName();
        if (StringHelper.isNullOrEmpty((String)strDataItemName)) {
            strDataItemName = this.getDataItemName();
        }
        if (iPSDEGridFieldColumn.isEnableRowEdit() && iPSDEGridFieldColumn.getPSDEGridEditItem() != null && (iPSDEGridEditItem = iPSDEGridFieldColumn.getPSDEGridEditItem()).getPSEditorType() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return String.valueOf(strDataItemName) + "_text";
        }
        return strDataItemName;
    }

    protected boolean isFixDataItemNameBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 1) == 1;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true)
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }
}

