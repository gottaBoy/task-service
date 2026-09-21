/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridEditItem;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridFieldColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSGEIDEFValueRule;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridDataItemImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeDataItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeEditItem;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeFieldColumn;
import SA.SRFDA.PS.Core.DEField.PSDEFUIItemImpl;
import SA.SRFDA.PS.Core.Data.PSDataItemParamImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFGridColumnImpl
extends PSDEFUIItemImpl
implements IPSDEFGridColumn {
    private static final Log log = LogFactory.getLog(PSDEFGridColumnImpl.class);
    private IPSSysPFPlugin renderPSSysPFPlugin = null;
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
        } else if (this.getPSDEField().getDEFType() == 5 || this.getPSDEField().getDEFType() == 4) {
            this.bEnableSort = false;
        } else if (DataTypeHelper.IsLongStringType((int)this.getPSDEField().getStdDataType())) {
            this.bEnableSort = false;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getGCRPSSYSPFPLUGINID())) {
            this.renderPSSysPFPlugin = this.getPSDEField().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEFUIMode.getGCRPSSYSPFPLUGINID());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEFUIMode.getGRIDCOLALIGN())) {
            this.strColAlign = this.psDEFUIMode.getGRIDCOLALIGN();
        } else if (this.getPSDEField().getPSDEFieldType() != null && !StringHelper.IsNullOrEmpty((String)this.getPSDEField().getPSDEFieldType().getGridColumnAlign())) {
            this.strColAlign = this.getPSDEField().getPSDEFieldType().getGridColumnAlign();
        }
        this.strValueItemName = this.psDEFUIMode.getVALUEITEMNAME();
        super.onInit();
    }

    protected void onPreparePSDEGridDataItems() throws Exception {
        PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
        psDEGridDataItemImpl.setName(this.getPSDEField().getName().toLowerCase());
        PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
        psItemParamImpl.setName(this.getPSDEField().getName());
        psItemParamImpl.setFormat(this.getValueFormat());
        String strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
        if (StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
            strPSCodeListId = this.getPSDEField().getCodeListId();
        }
        if (!StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
            psItemParamImpl.setCodeListId(strPSCodeListId);
            psItemParamImpl.setPSCodeList(this.getPSDEField().getPSDataEntity().getPSSystem().getPSCodeList(strPSCodeListId));
        }
        psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
        this.psDEGridDataItemList.add(psDEGridDataItemImpl);
    }

    @Override
    public Iterator<IPSDEGridDataItem> getPSDEGridDataItems() {
        return this.psDEGridDataItemList.iterator();
    }

    @Override
    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItems(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        return this.onPreparePSDEGridDataItems(iPSDEGridFieldColumn);
    }

    protected ArrayList<IPSDEGridDataItem> onPreparePSDEGridDataItems(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        IPSDEGridEditItem iPSDEGridEditItem;
        ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList<IPSDEGridDataItem>();
        String strDataItemName = iPSDEGridFieldColumn.getDataItemName();
        if (StringHelper.IsNullOrEmpty((String)strDataItemName)) {
            strDataItemName = this.getDataItemName();
        }
        boolean bUseDTO = false;
        if (iPSDEGridFieldColumn.getPSDEGrid().getPSAppView() != null && iPSDEGridFieldColumn.getPSDEGrid().getPSAppView().getPSApplication() != null) {
            bUseDTO = iPSDEGridFieldColumn.getPSDEGrid().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (iPSDEGridFieldColumn.isEnableRowEdit() && iPSDEGridFieldColumn.getPSDEGridEditItem() != null && (iPSDEGridEditItem = iPSDEGridFieldColumn.getPSDEGridEditItem()).getPSEditorType() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
            psDEGridDataItemImpl.setName(String.valueOf(strDataItemName) + "_text");
            if (bUseDTO) {
                psDEGridDataItemImpl.setFormat("");
            }
            PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDEField().getName());
            if (!bUseDTO) {
                psItemParamImpl.setFormat(this.getValueFormat());
            } else {
                psItemParamImpl.setFormat(iPSDEGridFieldColumn.getValueFormat());
            }
            String strPSCodeListId = iPSDEGridFieldColumn.getPSCodeListId();
            if (StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
                strPSCodeListId = this.psDEFUIMode.getPSCODELISTID();
            }
            if (StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
                strPSCodeListId = this.getPSDEField().getCodeListId();
            }
            if (!StringHelper.IsNullOrEmpty((String)strPSCodeListId)) {
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
                if (bUseDTO) {
                    psDEGridDataItemImpl.setFormat("");
                }
                psItemParamImpl = new PSDataItemParamImpl();
                psItemParamImpl.setName(this.getPSDEField().getName());
                if (!bUseDTO) {
                    psItemParamImpl.setFormat(this.getValueFormat());
                } else {
                    psItemParamImpl.setFormat(iPSDEGridFieldColumn.getValueFormat());
                }
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
            if (bUseDTO) {
                psDEGridDataItemImpl.setFormat("");
            }
            if (iPSDEGridFieldColumn.isHiddenDataItem() && this.isFixDataItemNameBug()) {
                psDEGridDataItemImpl.setName(iPSDEGridFieldColumn.getName().toLowerCase());
            } else {
                psDEGridDataItemImpl.setName(strDataItemName);
            }
            if ((iPSDEGridFieldColumn.getTreeColumnMode() & 2) == 2) {
                psDEGridDataItemImpl.setTreeNodeValue(true);
            }
            if ((iPSDEGridFieldColumn.getTreeColumnMode() & 4) == 4) {
                psDEGridDataItemImpl.setTreeNodePValue(true);
            }
            if ((iPSDEGridFieldColumn.getTreeColumnMode() & 1) == 1) {
                psDEGridDataItemImpl.setTreeNodeText(true);
            }
            if ((iPSDEGridFieldColumn.getTreeColumnMode() & 8) == 8) {
                psDEGridDataItemImpl.setTreeNodePText(true);
            }
            PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
            psItemParamImpl.setName(this.getPSDEField().getName());
            psItemParamImpl.setPSDEField(this.getPSDEField());
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
            if (iPSDEGridFieldColumn.isCustomCode()) {
                psDEGridDataItemImpl.setCustomCode(true);
                psDEGridDataItemImpl.setScriptCode(iPSDEGridFieldColumn.getScriptCode());
            }
            psDEGridDataItemImpl.init(iPSDEGridFieldColumn);
            psDEGridDataItemList.add(psDEGridDataItemImpl);
        }
        return psDEGridDataItemList;
    }

    @Override
    public String getDataItemName() {
        return this.getPSDEField().getName().toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u5217\u5bbd\u5ea6", fields={"GRIDCOLWIDTH"})
    public int getColumnWidth() {
        if (this.psDEFUIMode.isGRIDCOLWIDTHNull()) {
            return 100;
        }
        return this.psDEFUIMode.getGRIDCOLWIDTH();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6392\u5e8f", fields={"NOSORT"})
    public boolean isEnableSort() {
        return this.bEnableSort;
    }

    @Override
    @PSModelRTMeta(description="\u5217\u7ed8\u5236\u524d\u7aef\u6a21\u677f\u63d2\u4ef6")
    public IPSSysPFPlugin getRenderPSSysPFPlugin() {
        return this.renderPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u5217\u5bf9\u9f50", codelist="GridColAlign", fields={"GRIDCOLALIGN"})
    public String getColumnAlign() {
        return this.strColAlign;
    }

    @Override
    public String getValueItemName(IPSDEGridEditItem iPSDEGridEditItem) {
        if (StringHelper.IsNullOrEmpty((String)this.strValueItemName) && iPSDEGridEditItem.getPSEditorType() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return this.getPSDEField().getName().toLowerCase();
        }
        return this.strValueItemName;
    }

    @Override
    public String getLinkValueItem(IPSDEGridEditItem iPSDEGridEditItem) {
        return this.psDEFUIMode.getVALUEITEMNAME();
    }

    @Override
    public Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules() {
        if (this.psGEIDEFValueRuleList == null || this.psGEIDEFValueRuleList.size() == 0) {
            return null;
        }
        return this.psGEIDEFValueRuleList.iterator();
    }

    @Override
    public String getItemHandlerType(IPSDEGridEditItem iPSDEGridEditItem) {
        if (iPSDEGridEditItem.getPSEditorType() != null) {
            if (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSAjaxHandlerId())) {
            return "Custom";
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6761\u4ef6", codelist="FormItemEnableCond")
    public int getEnableCond() {
        return this.iPSDEField.getEnableUserInput();
    }

    @Override
    public JSONObject getItemParam(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        return null;
    }

    @Override
    public String getDataItemName(IPSDEGridFieldColumn iPSDEGridFieldColumn) throws Exception {
        IPSDEGridEditItem iPSDEGridEditItem;
        String strDataItemName = iPSDEGridFieldColumn.getDataItemName();
        if (StringHelper.IsNullOrEmpty((String)strDataItemName)) {
            strDataItemName = this.getDataItemName();
        }
        if (iPSDEGridFieldColumn.isEnableRowEdit() && iPSDEGridFieldColumn.getPSDEGridEditItem() != null && (iPSDEGridEditItem = iPSDEGridFieldColumn.getPSDEGridEditItem()).getPSEditorType() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDEGridEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDEGridEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return String.valueOf(strDataItemName) + "_text";
        }
        return strDataItemName;
    }

    protected boolean isFixDataItemNameBug() {
        return (this.getPSSystemSetting().getEngineBugFixs() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", codelist="CLConvertModes", hideempty2=true, fields={"GRIDCOLCLMODE"})
    public String getCLConvertMode() {
        return this.strCLConvertMode;
    }

    @Override
    public ArrayList<IPSDEGridDataItem> getPSDEGridDataItemsByEditItem(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        return this.onPreparePSDEGridDataItems2(iPSDEGridEditItem);
    }

    protected ArrayList<IPSDEGridDataItem> onPreparePSDEGridDataItems2(IPSDEGridEditItem iPSDEGridEditItem) throws Exception {
        ArrayList<IPSDEGridDataItem> psDEGridDataItemList = new ArrayList<IPSDEGridDataItem>();
        String strDataItemName = iPSDEGridEditItem.getName();
        PSDEGridDataItemImpl psDEGridDataItemImpl = new PSDEGridDataItemImpl();
        psDEGridDataItemImpl.setName(strDataItemName);
        boolean bUseDTO = false;
        if (iPSDEGridEditItem.getPSDEGrid() != null && iPSDEGridEditItem.getPSDEGrid().getPSAppView() != null && iPSDEGridEditItem.getPSDEGrid().getPSAppView().getPSApplication() != null && iPSDEGridEditItem.getPSDEGrid().getPSAppView().getPSApplication().isUseServiceApi()) {
            bUseDTO = true;
        }
        if (bUseDTO) {
            psDEGridDataItemImpl.setFormat("");
        }
        PSDataItemParamImpl psItemParamImpl = new PSDataItemParamImpl();
        psItemParamImpl.setName(this.getPSDEField().getName());
        if (!bUseDTO) {
            psItemParamImpl.setFormat(this.getValueFormat());
        }
        psItemParamImpl.setPSDEField(iPSDEGridEditItem.getPSDEField());
        psItemParamImpl.setPSAppDEField(iPSDEGridEditItem.getPSAppDEField());
        psDEGridDataItemImpl.addDataItemParam(psItemParamImpl);
        psDEGridDataItemList.add(psDEGridDataItemImpl);
        return psDEGridDataItemList;
    }

    @Override
    public String getModelType() {
        return "PSDEFGRIDCOLUMN";
    }

    @Override
    public boolean getAllowEmpty(IPSDEGridEditItem iPSDEGridEditItem) {
        return this.isAllowEmpty();
    }

    @Override
    public String getValueItemName(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        if (StringHelper.IsNullOrEmpty((String)this.strValueItemName) && iPSDETreeNodeEditItem.getPSEditorType() != null && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDETreeNodeEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return this.getPSDEField().getName().toLowerCase();
        }
        return this.strValueItemName;
    }

    @Override
    public String getLinkValueItem(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        if (StringHelper.IsNullOrEmpty((String)this.strValueItemName) && iPSDETreeNodeEditItem.getPSEditorType() != null && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDETreeNodeEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
            return this.getPSDEField().getName().toLowerCase();
        }
        return this.strValueItemName;
    }

    @Override
    public boolean getAllowEmpty(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        return this.isAllowEmpty();
    }

    @Override
    public ArrayList<IPSDETreeNodeDataItem> getPSDETreeNodeDataItems(IPSDETreeNodeFieldColumn iPSDETreeNodeFieldColumn) throws Exception {
        return this.onPreparePSDETreeNodeDataItems(iPSDETreeNodeFieldColumn);
    }

    protected ArrayList<IPSDETreeNodeDataItem> onPreparePSDETreeNodeDataItems(IPSDETreeNodeFieldColumn iPSDETreeNodeFieldColumn) throws Exception {
        ArrayList<IPSDETreeNodeDataItem> psDETreeNodeDataItemList = new ArrayList<IPSDETreeNodeDataItem>();
        String strDataItemName = iPSDETreeNodeFieldColumn.getDataItemName();
        if (StringHelper.IsNullOrEmpty((String)strDataItemName)) {
            strDataItemName = this.getDataItemName();
        }
        boolean bUseDTO = false;
        if (iPSDETreeNodeFieldColumn.getPSDETreeNode().getPSDETree().getPSAppView() != null && iPSDETreeNodeFieldColumn.getPSDETreeNode().getPSDETree().getPSAppView().getPSApplication() != null) {
            bUseDTO = iPSDETreeNodeFieldColumn.getPSDETreeNode().getPSDETree().getPSAppView().getPSApplication().isUseServiceApi();
        }
        if (iPSDETreeNodeFieldColumn.isEnableRowEdit() && iPSDETreeNodeFieldColumn.getPSDETreeNodeEditItem() != null) {
            IPSDETreeNodeEditItem iPSDETreeNodeEditItem = iPSDETreeNodeFieldColumn.getPSDETreeNodeEditItem();
        }
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem = iPSDETreeNodeFieldColumn.getPSDETreeNode().getPSDETreeNodeDataItem(strDataItemName, false);
        psDETreeNodeDataItemList.add(iPSDETreeNodeDataItem);
        return psDETreeNodeDataItemList;
    }

    @Override
    public ArrayList<IPSDETreeNodeDataItem> getPSDETreeNodeDataItemsByEditItem(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) throws Exception {
        return this.onPreparePSDETreeNodeDataItems2(iPSDETreeNodeEditItem);
    }

    protected ArrayList<IPSDETreeNodeDataItem> onPreparePSDETreeNodeDataItems2(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) throws Exception {
        ArrayList<IPSDETreeNodeDataItem> psDETreeNodeDataItemList = new ArrayList<IPSDETreeNodeDataItem>();
        IPSDETreeNodeDataItem iPSDETreeNodeDataItem = iPSDETreeNodeEditItem.getPSDETreeNode().getPSDETreeNodeDataItem(iPSDETreeNodeEditItem.getPSDEField(), false);
        psDETreeNodeDataItemList.add(iPSDETreeNodeDataItem);
        return psDETreeNodeDataItemList;
    }

    @Override
    public JSONObject getItemParam(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) throws Exception {
        return null;
    }

    @Override
    public String getItemHandlerType(IPSDETreeNodeEditItem iPSDETreeNodeEditItem) {
        if (iPSDETreeNodeEditItem.getPSEditorType() != null) {
            if (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"DROPDOWNLIST", (boolean)true) == 0 && iPSDETreeNodeEditItem.getPSCodeList() != null && StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSCodeList().getCodeListType(), (String)"DYNAMIC", (boolean)true) == 0) {
                return "CodeList";
            }
            if (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"AC", (boolean)true) == 0) {
                return "AC";
            }
            if (StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"PICKER", (boolean)true) == 0 || StringHelper.Compare((String)iPSDETreeNodeEditItem.getPSEditorType().getStandardPSEditorType(), (String)"MOBPICKER", (boolean)true) == 0) {
                return "PickupText";
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPSAjaxHandlerId())) {
            return "Custom";
        }
        return "";
    }

    @Override
    public String getDataItemName(IPSDETreeNodeFieldColumn iPSDETreeNodeFieldColumn) throws Exception {
        String strDataItemName = iPSDETreeNodeFieldColumn.getDataItemName();
        if (StringHelper.IsNullOrEmpty((String)strDataItemName)) {
            strDataItemName = iPSDETreeNodeFieldColumn.getName();
        }
        if (iPSDETreeNodeFieldColumn.isEnableRowEdit() && iPSDETreeNodeFieldColumn.getPSDETreeNodeEditItem() != null) {
            IPSDETreeNodeEditItem iPSDETreeNodeEditItem = iPSDETreeNodeFieldColumn.getPSDETreeNodeEditItem();
        }
        return strDataItemName;
    }
}

