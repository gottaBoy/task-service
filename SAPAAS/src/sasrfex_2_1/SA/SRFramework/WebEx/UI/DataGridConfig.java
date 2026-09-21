/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BaseControlConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnEditorsConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnRendersConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnsConfig;
import SA.SRFramework.WebEx.UI.DataGridDSConfig;
import SA.SRFramework.WebEx.UI.DataGridGroupConfig;
import SA.SRFramework.WebEx.UI.DataGridPagingConfig;
import org.w3c.dom.Node;

public class DataGridConfig
extends BaseControlConfig {
    public static final String TAG_DATAGRID = "SRFEXDATAGRID";
    public static final String TAG_DATAURL = "DATAURL";
    public static final String TAG_DEFAULTCONDITION = "DEFAULTCONDITION";
    public static final String TAG_PAGING = "PAGING";
    public static final String TAG_GROUP = "GROUP";
    public static final String TAG_FORCEFIT = "FORCEFIT";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_SELECTCOLUMN = "SELECTCOLUMN";
    public static final String TAG_EXCELREPORT = "EXCELREPORT";
    public static final String TAG_EDITABLE = "EDITABLE";
    public static final String TAG_FROMVALUERULE = "FROMVALUERULE";
    public static final String TAG_MULTISELECT = "MULTISELECT";
    public static final String TAG_BACKENDCONFIG = "BACKENDCONFIG";
    public static final String TAG_BACKENDCTRL = "BACKENDCTRL";
    public static final String TAG_HIDEHEADER = "HIDEHEADER";
    public static final String TAG_CTRLOBJECT = "CTRLOBJECT";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_CTRLID = "CTRLID";
    public static final String TAG_CLICKSTOEDIT = "CLICKSTOEDIT";
    public static final String TAG_LOADINGMSG = "LOADINGMSG";
    public static final String TAG_SUMMARYHEIGHT = "SUMMARYHEIGHT";
    public static final String TAG_ROWCLASSHELPER = "ROWCLASSHELPER";
    public static final String TAG_STRIPEROWS = "STRIPEROWS";
    public static final String TAG_DEFEREMPTYTEXT = "DEFEREMPTYTEXT";
    public static final String TAG_TEMPDATA = "TEMPDATA";
    public static final String TAG_RESPONSETYPE = "RESPONSETYPE";
    public static final String RESPONSETYPE_JSON = "JSON";
    public static final String RESPONSETYPE_JSONARRAY = "JSONARRAY";
    public static final String TAG_ROWEXPANDER = "ROWEXPANDER";
    public static final String TAG_ROWEXPANDERPARAM = "ROWEXPANDERPARAM";
    public static final String TAG_USERTHEME = "USERTHEME";
    public static final String TAG_HIDEGROUPPANEL = "HIDEGROUPPANEL";
    public static final String TAG_HIDEGROUPCOLUMN = "HIDEGROUPCOLUMN";
    public static final String TAG_HIERARCHYDATA = "HIERARCHYDATA";
    protected String strDataURL = "";
    protected String strDefaultCondition = "";
    protected boolean bPaging = false;
    protected boolean bGroup = false;
    protected boolean bForceFit = false;
    protected boolean bLoadDefault = false;
    protected boolean bSelectColumn = false;
    protected String strExcelReport = "";
    protected boolean bEditable = false;
    protected String strFormValueRuleId = "";
    protected String strBackEndCtrl = "";
    protected String strBackEndConfig = "";
    protected boolean bHideHeader = false;
    protected String strCtrlObject = "";
    protected String strCtrlId = "";
    protected int nClicksToEdit = 2;
    protected boolean bMultiSelect = false;
    protected String strLoadingMsg = "";
    protected int nSummaryHeight = 0;
    protected String strRowClassHelper = "";
    protected boolean bStripeRows = true;
    protected boolean bDeferEmptyText = true;
    protected int nTimeout = 60000;
    protected boolean bTempData = false;
    protected String strResponseType = "JSON";
    protected boolean bRowExpander = false;
    protected String strRowExpanderParam = "";
    protected boolean bUserTheme = true;
    protected boolean bHideGroupPanel = false;
    protected boolean bHideGroupColumn = false;
    protected String strHierarchyData = "";
    protected DataGridDSConfig dataGridRS = new DataGridDSConfig();
    protected DataGridColumnsConfig dataGridColumns = new DataGridColumnsConfig();
    protected DataGridPagingConfig dataGridPaging = new DataGridPagingConfig();
    protected DataGridColumnEditorsConfig dataGridColumnEditors = null;
    protected DataGridGroupConfig dataGridGroup = null;
    protected DataGridColumnRendersConfig dataGridColumnRenders = null;

    public DataGridConfig() {
        this.dataGridRS.setDataGridConfig(this);
        this.dataGridColumns.setDataGridConfig(this);
        this.dataGridPaging.setDataGridConfig(this);
    }

    public DataGridDSConfig getDataGridDSConfig() {
        return this.dataGridRS;
    }

    public DataGridColumnsConfig getDataGridColumnsConfig() {
        return this.dataGridColumns;
    }

    public DataGridPagingConfig getDataGridPagingConfig() {
        return this.dataGridPaging;
    }

    public DataGridColumnEditorsConfig getDataGridColumnEditorsConfig() {
        return this.dataGridColumnEditors;
    }

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_DATAURL, (boolean)true) == 0) {
            this.strDataURL = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFAULTCONDITION, (boolean)true) == 0) {
            this.strDefaultCondition = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_PAGING, (boolean)true) == 0) {
            this.bPaging = DataGridConfig.GetValue((String)strValue, (boolean)this.bPaging);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUP, (boolean)true) == 0) {
            this.bGroup = DataGridConfig.GetValue((String)strValue, (boolean)this.bGroup);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORCEFIT, (boolean)true) == 0) {
            this.bForceFit = DataGridConfig.GetValue((String)strValue, (boolean)this.bForceFit);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADDEFAULT, (boolean)true) == 0) {
            this.bLoadDefault = DataGridConfig.GetValue((String)strValue, (boolean)this.bLoadDefault);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SELECTCOLUMN, (boolean)true) == 0) {
            this.bSelectColumn = DataGridConfig.GetValue((String)strValue, (boolean)this.bSelectColumn);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EXCELREPORT, (boolean)true) == 0) {
            this.strExcelReport = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_EDITABLE, (boolean)true) == 0) {
            this.bEditable = DataGridConfig.GetValue((String)strValue, (boolean)this.bEditable);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_MULTISELECT, (boolean)true) == 0) {
            this.bMultiSelect = DataGridConfig.GetValue((String)strValue, (boolean)this.bMultiSelect);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FROMVALUERULE, (boolean)true) == 0) {
            this.strFormValueRuleId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCTRL, (boolean)true) == 0) {
            this.strBackEndCtrl = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_BACKENDCONFIG, (boolean)true) == 0) {
            this.strBackEndConfig = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDEHEADER, (boolean)true) == 0) {
            this.bHideHeader = DataGridConfig.GetValue((String)strValue, (boolean)this.bHideHeader);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLOBJECT, (boolean)true) == 0) {
            this.strCtrlObject = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLID, (boolean)true) == 0) {
            this.strCtrlId = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CLICKSTOEDIT, (boolean)true) == 0) {
            this.nClicksToEdit = DataGridConfig.GetValue((String)strValue, (int)this.nClicksToEdit);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_LOADINGMSG, (boolean)true) == 0) {
            this.strLoadingMsg = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SUMMARYHEIGHT, (boolean)true) == 0) {
            this.setSummaryHeight(DataGridConfig.GetValue((String)strValue, (int)this.nSummaryHeight));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWCLASSHELPER, (boolean)true) == 0) {
            this.strRowClassHelper = strValue;
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_STRIPEROWS, (boolean)true) == 0) {
            this.bStripeRows = DataGridConfig.GetValue((String)strValue, (boolean)this.bStripeRows);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_DEFEREMPTYTEXT, (boolean)true) == 0) {
            this.bDeferEmptyText = DataGridConfig.GetValue((String)strValue, (boolean)this.bDeferEmptyText);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TIMEOUT, (boolean)true) == 0) {
            this.setTimeout(DataGridConfig.GetValue((String)strValue, (int)this.getTimeout()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_TEMPDATA, (boolean)true) == 0) {
            this.setTempData(DataGridConfig.GetValue((String)strValue, (boolean)this.isTempData()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_RESPONSETYPE, (boolean)true) == 0) {
            this.setResponseType(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWEXPANDER, (boolean)true) == 0) {
            this.setRowExpander(DataGridConfig.GetValue((String)strValue, (boolean)this.isRowExpander()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ROWEXPANDERPARAM, (boolean)true) == 0) {
            this.setRowExpanderParam(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_USERTHEME, (boolean)true) == 0) {
            this.setUserTheme(DataGridConfig.GetValue((String)strValue, (boolean)this.isUserTheme()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDEGROUPPANEL, (boolean)true) == 0) {
            this.setHideGroupPanel(DataGridConfig.GetValue((String)strValue, (boolean)this.isHideGroupPanel()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIDEGROUPCOLUMN, (boolean)true) == 0) {
            this.setHideGroupColumn(DataGridConfig.GetValue((String)strValue, (boolean)this.isHideGroupColumn()));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_HIERARCHYDATA, (boolean)true) == 0) {
            this.setHierarchyData(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDDS", (boolean)true) == 0) {
            this.dataGridRS.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMNS", (boolean)true) == 0) {
            this.dataGridColumns.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDPAGING", (boolean)true) == 0) {
            this.dataGridPaging.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMNEDITORS", (boolean)true) == 0) {
            if (this.dataGridColumnEditors == null) {
                this.dataGridColumnEditors = new DataGridColumnEditorsConfig();
            }
            this.dataGridColumnEditors.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDGROUP", (boolean)true) == 0) {
            this.dataGridGroup = this.getDataGridGroupConfig(true);
            this.dataGridGroup.LoadConfig(xmlNode);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)"SRFEXDATAGRIDCOLUMNRENDERS", (boolean)true) == 0) {
            this.dataGridColumnRenders = this.getDataGridColumnRendersConfig(true);
            this.dataGridColumnRenders.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public void setDefaultCondition(String strDefaultCondition) {
        this.strDefaultCondition = strDefaultCondition;
    }

    public String getDefaultCondition() {
        return this.strDefaultCondition;
    }

    public void setPaging(boolean bPaging) {
        this.bPaging = bPaging;
    }

    public boolean getPaging() {
        return this.bPaging;
    }

    public void setLoadDefault(boolean bLoadDefault) {
        this.bLoadDefault = bLoadDefault;
    }

    public boolean getLoadDefault() {
        return this.bLoadDefault;
    }

    public void setSelectColumn(boolean bSelectColumn) {
        this.bSelectColumn = bSelectColumn;
    }

    public boolean getSelectColumn() {
        return this.bSelectColumn;
    }

    public void setExcelReport(String strExcelReport) {
        this.strExcelReport = strExcelReport;
    }

    public String getExcelReport() {
        return this.strExcelReport;
    }

    public void setEditable(boolean bEditable) {
        this.bEditable = bEditable;
    }

    public boolean getEditable() {
        return this.bEditable;
    }

    public String getFormValueRuleId() {
        return this.strFormValueRuleId;
    }

    public void setFormValueRuleId(String strFormValueRuleId) {
        this.strFormValueRuleId = strFormValueRuleId;
    }

    public String getBackEndCtrl() {
        return this.strBackEndCtrl;
    }

    public void setBackEndCtrl(String strBackEndCtrl) {
        this.strBackEndCtrl = strBackEndCtrl;
    }

    public String getBackEndConfig() {
        return this.strBackEndConfig;
    }

    public void setBackEndConfig(String strBackEndConfig) {
        this.strBackEndConfig = strBackEndConfig;
    }

    public boolean isHideHeader() {
        return this.bHideHeader;
    }

    public void setHideHeader(boolean hideHeader) {
        this.bHideHeader = hideHeader;
    }

    public String getCtrlObject() {
        return this.strCtrlObject;
    }

    public void setCtrlObject(String strCtrlObject) {
        this.strCtrlObject = strCtrlObject;
    }

    public String getCtrlId() {
        return this.strCtrlId;
    }

    public void setCtrlId(String strCtrlId) {
        this.strCtrlId = strCtrlId;
    }

    public int getClicksToEdit() {
        return this.nClicksToEdit;
    }

    public void setClicksToEdit(int clicksToEdit) {
        this.nClicksToEdit = clicksToEdit;
    }

    public boolean isMultiSelect() {
        return this.bMultiSelect;
    }

    public void setMultiSelect(boolean multiSelect) {
        this.bMultiSelect = multiSelect;
    }

    public boolean isGroup() {
        return this.bGroup;
    }

    public void setGroup(boolean group) {
        this.bGroup = group;
    }

    public DataGridGroupConfig getDataGridGroupConfig(boolean bNullCreate) {
        if (this.dataGridGroup == null && bNullCreate) {
            this.dataGridGroup = new DataGridGroupConfig();
            this.dataGridGroup.setDataGridConfig(this);
        }
        return this.dataGridGroup;
    }

    public DataGridColumnRendersConfig getDataGridColumnRendersConfig(boolean bCreateIfNull) {
        if (this.dataGridColumnRenders == null && bCreateIfNull) {
            this.dataGridColumnRenders = new DataGridColumnRendersConfig();
            this.dataGridColumnRenders.setDataGridConfig(this);
        }
        return this.dataGridColumnRenders;
    }

    public boolean isForceFit() {
        return this.bForceFit;
    }

    public void setForceFit(boolean bForceFit) {
        this.bForceFit = bForceFit;
    }

    public String getLoadingMsg() {
        return this.strLoadingMsg;
    }

    public void setLoadingMsg(String strLoadingMsg) {
        this.strLoadingMsg = strLoadingMsg;
    }

    public int getSummaryHeight() {
        return this.nSummaryHeight;
    }

    public void setSummaryHeight(int nSummaryHeight) {
        this.nSummaryHeight = nSummaryHeight;
        if (this.nSummaryHeight > 500 || this.nSummaryHeight < 0) {
            this.nSummaryHeight = 0;
        }
    }

    public String getRowClassHelper() {
        return this.strRowClassHelper;
    }

    public void setRowClassHelper(String strRowClassHelper) {
        this.strRowClassHelper = strRowClassHelper;
    }

    public boolean isStripeRows() {
        return this.bStripeRows;
    }

    public void setStripeRows(boolean bStripeRows) {
        this.bStripeRows = bStripeRows;
    }

    public boolean isDeferEmptyText() {
        return this.bDeferEmptyText;
    }

    public void setDeferEmptyText(boolean bDeferEmptyText) {
        this.bDeferEmptyText = bDeferEmptyText;
    }

    public int getTimeout() {
        return this.nTimeout;
    }

    public void setTimeout(int nTimeout) {
        this.nTimeout = nTimeout;
        if (this.nTimeout <= 0) {
            this.nTimeout = 60000;
        }
    }

    public boolean isTempData() {
        return this.bTempData;
    }

    public void setTempData(boolean bTempData) {
        this.bTempData = bTempData;
    }

    public String getResponseType() {
        return this.strResponseType;
    }

    public void setResponseType(String strResponseType) {
        this.strResponseType = strResponseType;
    }

    public boolean isRowExpander() {
        return this.bRowExpander;
    }

    public void setRowExpander(boolean bRowExpander) {
        this.bRowExpander = bRowExpander;
    }

    public String getRowExpanderParam() {
        return this.strRowExpanderParam;
    }

    public void setRowExpanderParam(String strRowExpanderParam) {
        this.strRowExpanderParam = strRowExpanderParam;
    }

    public boolean isUserTheme() {
        return this.bUserTheme;
    }

    public void setUserTheme(boolean bUserTheme) {
        this.bUserTheme = bUserTheme;
    }

    public boolean isHideGroupPanel() {
        return this.bHideGroupPanel;
    }

    public void setHideGroupPanel(boolean bHideGroupPanel) {
        this.bHideGroupPanel = bHideGroupPanel;
    }

    public boolean isHideGroupColumn() {
        return this.bHideGroupColumn;
    }

    public void setHideGroupColumn(boolean bHideGroupColumn) {
        this.bHideGroupColumn = bHideGroupColumn;
    }

    public String getHierarchyData() {
        return this.strHierarchyData;
    }

    public void setHierarchyData(String strHierarchyData) {
        this.strHierarchyData = strHierarchyData;
    }
}

