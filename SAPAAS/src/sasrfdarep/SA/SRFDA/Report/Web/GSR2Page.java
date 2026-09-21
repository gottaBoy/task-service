/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.GSR2
 *  SA.SRFDA.Ctrl.Data.GSR2Dimension
 *  SA.SRFDA.Ctrl.Data.GSR2Measure
 *  SA.SRFDA.Ctrl.Data.GSR2SumTable
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExFormItem
 *  SA.SRFramework.WebEx.SRFExHidden
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig
 *  SA.SRFramework.WebEx.UI.DataGridColumnConfig
 *  SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig
 *  SA.SRFramework.WebEx.UI.DataGridDSItemConfig
 *  SA.SRFramework.WebEx.UI.ItemParamConfig
 *  SA.SRFramework.WebEx.UI.ItemParamsConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GSR2Dimension;
import SA.SRFDA.Ctrl.Data.GSR2Measure;
import SA.SRFDA.Ctrl.Data.GSR2SumTable;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Report.Ctrl.DataGrid.ThresholdColumnRender;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnConfig;
import SA.SRFramework.WebEx.UI.DataGridColumnRenderConfig;
import SA.SRFramework.WebEx.UI.DataGridDSItemConfig;
import SA.SRFramework.WebEx.UI.ItemParamConfig;
import SA.SRFramework.WebEx.UI.ItemParamsConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.HashMap;
import net.sf.json.JSONObject;

public class GSR2Page
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected SRFExDataGrid dataGrid = null;
    protected SRFExToolbar toolbar = null;
    protected GSR2 gsr2 = null;
    protected String strToolbarConfigId = "";
    protected String strSPExConfigId = "";
    protected String strDGConfigId = "";
    protected DataGrid gridView = null;
    protected SRFExDropDownList timeGroupColumnList = null;
    protected SRFExDropDownList groupColumnList = null;
    protected SRFExDropDownList measureGroupList = null;
    protected SRFExFormItem tbTopN = null;
    protected String strDetailDGUrl = "";
    protected String strGroupColumns = "";
    protected String strMeasureColumns = "";
    protected String strMeasureGroupSort = "";
    protected boolean bIsOutputMeasureGroup = true;
    protected SearchForm searchForm = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strGSRId = this.getWebContext().GetParamValue("GSR2ID");
        if (StringHelper.IsNullOrEmpty((String)strGSRId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u7f16\u53f7");
            return false;
        }
        this.gsr2 = this.getDAModelStorage().FindGSR2(strGSRId);
        if (this.gsr2 == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u914d\u7f6e[%1$s]", (Object)strGSRId));
            return false;
        }
        this.strPageDataEntityId = this.gsr2.getDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.setPageParam("GSR2", this.gsr2);
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadDataGrid();
        this.LoadToolbar();
        this.LoadGroupControls();
    }

    protected void OnInit() {
        super.OnInit();
        if (StringHelper.IsNullOrEmpty((String)this.gsr2.getDETAILDGPAGEID())) {
            this.strDetailDGUrl = "../srfpage/gridview.jsp";
        } else {
            Page page = this.getDAModelStorage().FindPage(this.gsr2.getDETAILDGPAGEID());
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)this.gsr2.getDETAILDGPAGEID()));
                return;
            }
            this.strDetailDGUrl = page.GetTotalPagePath();
        }
        this.strDetailDGUrl = URLHelper.AppendURLSeperator((String)this.strDetailDGUrl);
        this.strDetailDGUrl = String.valueOf(this.strDetailDGUrl) + StringHelper.Format((String)"SRFDEID=%1$s&SRFDGAL=FALSE&", (Object)this.getDEHelper().getId());
        StringBuilderEx script = new StringBuilderEx();
        JSONObject params = new JSONObject();
        params.put("deid", (Object)this.getPageDataEntityId());
        if (this.spEx != null) {
            params.put("spid", (Object)this.spEx.getUniqueID());
            params.put("spcs", false);
        }
        script.Append("$P.mainview=new SRFDA.GridView(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
        if (this.gsr2.getAUTOLOAD()) {
            String strAutoLoadScript = StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId());
            this.spEx.getSearchForm().getLoadAction().getSuccessAction().RegisterProcessCode(0, strAutoLoadScript);
        }
    }

    public boolean IsTopN() {
        return this.gsr2.getENABLETOPN();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDGActionHelper());
    }

    protected void LoadGroupControls() {
        this.timeGroupColumnList = new SRFExDropDownList();
        this.timeGroupColumnList.InitConfig();
        this.timeGroupColumnList.setID("ddlTimeGroupColumn");
        this.timeGroupColumnList.getDropDownListConfig().setWidth(200);
        if (!this.IsBackEndMode()) {
            CodeListConfig codeListConfig = this.getWebContext().getCodeListMgr().GetCodeListConfig("CODELIST_DE0501_001", this.getLanguage());
            if (codeListConfig != null) {
                for (GSR2SumTable sumTable : this.gsr2.getSumTables()) {
                    CodeItemConfig codeItemConfig = codeListConfig.FindCodeItemConfigByValue(sumTable.getTD(), true);
                    if (codeItemConfig == null) continue;
                    this.timeGroupColumnList.getDropDownListConfig().getListItems().Add(new ListItem(codeItemConfig.getText(), sumTable.getGSR2SUMTABLEID()));
                    if (!sumTable.getDEFAULTFLAG()) continue;
                    this.timeGroupColumnList.getDropDownListConfig().setSelectedValue(sumTable.getGSR2SUMTABLEID());
                }
                this.timeGroupColumnList.getDropDownListConfig().getListFillerConfig().setEmptySupported(false);
                this.timeGroupColumnList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId()));
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)"CODELIST_DE0501_001"));
            }
        }
        this.AddControl((SRFExControl)this.timeGroupColumnList);
        this.groupColumnList = new SRFExDropDownList();
        this.groupColumnList.InitConfig();
        this.groupColumnList.setID("ddlGroupColumn");
        this.groupColumnList.getDropDownListConfig().setWidth(200);
        if (!this.IsBackEndMode()) {
            JSONObject jo = new JSONObject();
            for (GSR2Dimension dimension : this.gsr2.getDimensions()) {
                this.groupColumnList.getDropDownListConfig().getListItems().Add(new ListItem(dimension.getGSR2DIMENSIONNAME(), dimension.getGSR2DIMENSIONID()));
                if (dimension.getDEFAULTFLAG()) {
                    this.groupColumnList.getDropDownListConfig().setSelectedValue(dimension.getGSR2DIMENSIONID());
                }
                jo.put(dimension.getGSR2DIMENSIONID(), (Object)dimension.getGSR2DIMENSIONNAME());
            }
            this.strGroupColumns = jo.toString();
            this.groupColumnList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId()));
        }
        this.AddControl((SRFExControl)this.groupColumnList);
        if (this.IsTopN()) {
            this.tbTopN = new SRFExTextBox();
            this.tbTopN.InitConfig();
            this.tbTopN.setID("tbTopN");
            ((SRFExTextBox)this.tbTopN).getTextBoxConfig().setWidth(40);
        } else {
            this.tbTopN = new SRFExHidden();
            this.tbTopN.InitConfig();
            this.tbTopN.setID("tbTopN");
        }
        this.tbTopN.setValue(StringHelper.Format((String)"%1$s", (Object)this.gsr2.getTopNCount(20)));
        this.AddControl((SRFExControl)this.tbTopN);
        if (!this.IsBackEndMode()) {
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('blue',function(){%2$s.search();});", (Object)this.tbTopN.getUniqueID(), (Object)this.getDefaultFormId()));
        }
        HashMap<String, String> measureGroupMap = new HashMap<String, String>();
        this.measureGroupList = new SRFExDropDownList();
        this.measureGroupList.InitConfig();
        this.measureGroupList.setID("ddlMeasureGroupList");
        this.measureGroupList.getDropDownListConfig().setWidth(200);
        if (!this.IsBackEndMode()) {
            JSONObject defSort;
            JSONObject jo = new JSONObject();
            JSONObject measureGroupSort = new JSONObject();
            for (GSR2Measure measure : this.gsr2.getMeasures()) {
                String strGroupId;
                String strSort;
                String strGroup = measure.getGSRMEASUREGROUPNAME();
                if (StringHelper.IsNullOrEmpty((String)strGroup)) {
                    strGroup = "\u9ed8\u8ba4\u5206\u7ec4";
                }
                jo.put(measure.getDEFNAME().toLowerCase(), (Object)measure.getGSRMEASUREGROUPID());
                if (!measureGroupMap.containsKey(strGroup)) {
                    measureGroupMap.put(strGroup, "");
                    this.measureGroupList.getDropDownListConfig().getListItems().Add(new ListItem(strGroup, measure.getGSRMEASUREGROUPID()));
                }
                if (StringHelper.IsNullOrEmpty((String)(strSort = measure.getDEFAULTSORT())) || measureGroupSort.has((strGroupId = StringHelper.Format((String)"g%1$s", (Object)(this.measureGroupList.getDropDownListConfig().getListItems().size() - 1))).toLowerCase())) continue;
                measure.getGSRMEASUREGROUPID();
                JSONObject jo2 = new JSONObject();
                jo2.put("field", (Object)measure.getDEFNAME().toLowerCase());
                jo2.put("dir", (Object)strSort.toUpperCase());
                measureGroupSort.put(strGroupId.toLowerCase(), (Object)jo2);
            }
            this.strMeasureColumns = jo.toString();
            this.strMeasureGroupSort = measureGroupSort.toString();
            boolean bl = this.bIsOutputMeasureGroup = this.measureGroupList.getDropDownListConfig().getListItems().size() > 1;
            if (this.bIsOutputMeasureGroup) {
                this.measureGroupList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"measuregroupchange();"));
                this.RegisterOnReadyScript(3, "measuregroupchange();");
            } else if (measureGroupSort.has("g0") && (defSort = measureGroupSort.getJSONObject("g0")) != null) {
                String strScript = StringHelper.Format((String)"$P.store['%1$s'].setDefaultSort('%2$s','%3$s');", (Object)this.dataGrid.getUniqueID(), (Object)defSort.get("field"), (Object)defSort.get("dir"));
                this.RegisterOnReadyScript(3, strScript);
            }
        }
        this.AddControl((SRFExControl)this.measureGroupList);
    }

    public boolean IsOutputMeasureGroup() {
        return this.bIsOutputMeasureGroup;
    }

    public String GetGroupColumns() {
        return this.strGroupColumns;
    }

    public String GetMeasureColumns() {
        return this.strMeasureColumns;
    }

    public String GetMeasureGroupSort() {
        return this.strMeasureGroupSort;
    }

    protected void LoadSPEx() {
        this.strSPExConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
            return;
        }
        this.spEx = GSR2Page.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.strSPExConfigId);
        if (this.spEx != null) {
            if (this.gsr2.getENABLECONDSL()) {
                this.spEx.getSearchForm().setFormTag(this.gsr2.getGSR2ID());
                this.spEx.getSPExConfig().setSaveLoad(true);
            }
            this.spEx.getSPExConfig().setWidth(1024);
        }
    }

    protected String OnGetSPExConfigId() {
        String strSearchformId = this.gsr2.getSEARCHFORMID();
        if (!StringHelper.IsNullOrEmpty((String)strSearchformId)) {
            this.searchForm = this.getWebContext().GetConfigCache().GetDESearchForm(this.getWebContext(), strSearchformId, false);
            if (this.searchForm != null) {
                return this.getDAConfigHelper().GetSPExId(this.getDEHelper(), this.searchForm);
            }
        }
        return "";
    }

    protected void LoadDataGrid() {
        this.strDGConfigId = this.OnGetDataGridConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDGConfigId)) {
            return;
        }
        this.dataGrid = GSR2Page.CreateDataGrid((SRFDAPage)this, (String)"dataGrid", (double)0.0, (double)0.0, (String)this.strDGConfigId, (boolean)false);
        if (!this.IsBackEndMode()) {
            this.dataGrid.getDataGridConfig().setDeferEmptyText(false);
            DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
            dgColumnConfig.setHidden(false);
            dgColumnConfig.setID("SRFROWSN");
            dgColumnConfig.setCaption("\u884c\u53f7");
            dgColumnConfig.setWidth(50);
            dgColumnConfig.setSortable(false);
            dgColumnConfig.setLocked(false);
            dgColumnConfig.setDSItem("SRFROWSN");
            dgColumnConfig.setAlign("right");
            dgColumnConfig.setHideable(false);
            dgColumnConfig.setMenuDisabled(true);
            this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
            DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
            dsItemConfig.setID("SRFROWSN");
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
            IDEFHelper timeDEFHelper = this.getDEHelper().GetDEFHelper(this.gsr2.getTIMEDEFID());
            if (timeDEFHelper != null) {
                DataGridColumnConfig dgColumnConfig2 = new DataGridColumnConfig();
                dgColumnConfig2.setHidden(false);
                dgColumnConfig2.setID(timeDEFHelper.GetDTColumn().GetColumnName());
                dgColumnConfig2.setCaption(timeDEFHelper.getLogicName(this.getLanguage()));
                dgColumnConfig2.setWidth(this.gsr2.getTIMECOLUMNWIDTH());
                dgColumnConfig2.setSortable(true);
                dgColumnConfig2.setLocked(false);
                dgColumnConfig2.setMenuDisabled(true);
                dgColumnConfig2.setDSItem(timeDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig2);
                DataGridDSItemConfig dsItemConfig2 = new DataGridDSItemConfig();
                dsItemConfig2.setID(timeDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
                dsItemConfig2.setKey(true);
                dsItemConfig2.setKeyFormat("%1$s");
                dsItemConfig2.setItemFormat("%1$s");
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig2);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.gsr2.getTIMEDEFID()));
            }
            IDEFHelper groupDEFHelper = this.getDEHelper().GetDEFHelper(this.gsr2.getGROUPDEFID());
            if (groupDEFHelper != null) {
                DataGridColumnConfig dgColumnConfig3 = new DataGridColumnConfig();
                dgColumnConfig3.setHidden(false);
                dgColumnConfig3.setID("SRFJOINNAME");
                dgColumnConfig3.setCaption(groupDEFHelper.getLogicName(this.getLanguage()));
                dgColumnConfig3.setWidth(this.gsr2.getGROUPCOLUMNWIDTH());
                dgColumnConfig3.setSortable(true);
                dgColumnConfig3.setLocked(false);
                dgColumnConfig3.setMenuDisabled(true);
                dgColumnConfig3.setDSItem("SRFJOINNAME");
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig3);
                DataGridDSItemConfig dsItemConfig3 = new DataGridDSItemConfig();
                dsItemConfig3.setID("SRFJOINNAME");
                dsItemConfig3.setKey(true);
                dsItemConfig3.setKeyFormat("%1$s");
                dsItemConfig3.setItemFormat("%1$s");
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig3);
                dsItemConfig3 = new DataGridDSItemConfig();
                dsItemConfig3.setID(groupDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
                dsItemConfig3.setKey(true);
                dsItemConfig3.setKeyFormat("%1$s");
                dsItemConfig3.setItemFormat("%1$s");
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig3);
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.gsr2.getGROUPDEFID()));
            }
            for (GSR2Measure measure : this.gsr2.getMeasures()) {
                DataGridColumnConfig dgColumnConfig4 = new DataGridColumnConfig();
                dgColumnConfig4.setHidden(false);
                dgColumnConfig4.setID(measure.getDEFNAME());
                dgColumnConfig4.setCaption(measure.getGSR2MEASURENAME());
                dgColumnConfig4.setWidth(measure.getWIDTH());
                dgColumnConfig4.setSortable(true);
                dgColumnConfig4.setLocked(false);
                dgColumnConfig4.setDSItem(measure.getDEFNAME());
                dgColumnConfig4.setAlign("right");
                dgColumnConfig4.setMenuDisabled(true);
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig4);
                if (!StringHelper.IsNullOrEmpty((String)measure.getTHGROUPID())) {
                    DataGridColumnRenderConfig dataGridColumnRenderConfig = new DataGridColumnRenderConfig();
                    dataGridColumnRenderConfig.setID(measure.getDEFNAME());
                    dataGridColumnRenderConfig.setObject(ThresholdColumnRender.class.getName());
                    dataGridColumnRenderConfig.SetExtValue("THGROUPID", measure.getTHGROUPID());
                    dataGridColumnRenderConfig.setDataGridConfig(this.dataGrid.getDataGridConfig());
                    this.dataGrid.getDataGridConfig().getDataGridColumnRendersConfig(true).getList().add(dataGridColumnRenderConfig);
                    dgColumnConfig4.setRenderId(measure.getDEFNAME());
                }
                DataGridDSItemConfig dsItemConfig4 = new DataGridDSItemConfig();
                dsItemConfig4.setID(measure.getDEFNAME());
                dsItemConfig4.setItemFormat(measure.getITEMFORMAT());
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig4);
            }
            this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.store['%1$s'].userparams", (Object)this.dataGrid.getUniqueID()));
            this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"searchdgex();", (Object)this.dataGrid.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            String strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", "");
            if (!StringHelper.IsNullOrEmpty((String)strBeforeLoadDefault)) {
                script.Append(strBeforeLoadDefault);
            }
            this.RegisterOnReadyScript(3, script.toString());
        } else {
            String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
            String strTD = this.getWebContext().GetPostValue("srftd");
            this.dataGrid.getDataGridConfig().setDeferEmptyText(false);
            DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
            dgColumnConfig.setHidden(false);
            dgColumnConfig.setID("SRFROWSN");
            dgColumnConfig.setCaption("\u884c\u53f7");
            dgColumnConfig.setWidth(50);
            dgColumnConfig.setSortable(false);
            dgColumnConfig.setLocked(false);
            dgColumnConfig.setDSItem("SRFROWSN");
            dgColumnConfig.setAlign("right");
            dgColumnConfig.setHideable(false);
            dgColumnConfig.setMenuDisabled(true);
            this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
            DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
            dsItemConfig.setID("SRFROWSN");
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
            GSR2Dimension dimension = this.gsr2.FindDimension(strGroupField);
            if (dimension == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7ef4\u5ea6[%1$s]", (Object)strGroupField));
                return;
            }
            IDEHelper joinDEHElper = this.getDAModelStorage().FindDEHelper(dimension.getJOINDEID());
            if (joinDEHElper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dimension.getJOINDEID()));
                return;
            }
            IDEFHelper timeDEFHelper = this.getDEHelper().GetDEFHelper(this.gsr2.getTIMEDEFID());
            if (timeDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.gsr2.getTIMEDEFID()));
                return;
            }
            IDEFHelper groupDEFHelper = this.getDEHelper().GetDEFHelper(this.gsr2.getGROUPDEFID());
            if (groupDEFHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)this.gsr2.getGROUPDEFID()));
                return;
            }
            DataGridColumnConfig dgColumnConfig5 = new DataGridColumnConfig();
            dgColumnConfig5.setHidden(false);
            dgColumnConfig5.setID(timeDEFHelper.GetDTColumn().GetColumnName());
            dgColumnConfig5.setCaption(timeDEFHelper.getLogicName(this.getLanguage()));
            dgColumnConfig5.setWidth(this.gsr2.getTIMECOLUMNWIDTH());
            dgColumnConfig5.setSortable(true);
            dgColumnConfig5.setLocked(false);
            dgColumnConfig5.setMenuDisabled(true);
            dgColumnConfig5.setDSItem(timeDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
            this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig5);
            DataGridDSItemConfig dsItemConfig5 = new DataGridDSItemConfig();
            dsItemConfig5.setID(timeDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
            dsItemConfig5.setKey(true);
            dsItemConfig5.setKeyFormat("%1$s");
            dsItemConfig5.setExcelFormat("%1$s");
            String strJoinFormat = StringHelper.Format((String)"%1$s:'%%2$s',%2$s:'%%3$s',srftd:'%3$s',srfgsr2id:'%4$s'", (Object)joinDEHElper.GetKeyDEFHelper().getName(), (Object)joinDEHElper.GetMajorDEFHelper().getName(), (Object)strTD, (Object)this.gsr2.getGSR2ID());
            String strDrillFormat = StringHelper.Format((String)"<a href='#' title='\u5411\u4e0b\u94bb\u53d6\u660e\u7ec6\u6570\u636e' onclick=\"drilldown({srftime:'%%1$s',%1$s});\"><IMG src='../sasrfex/images/default/icon_drilldown3.png' border='0'></A>&nbsp;%%1$s", (Object)strJoinFormat);
            dsItemConfig5.setItemFormat(strDrillFormat);
            ItemParamsConfig itemParamsConfig = dsItemConfig5.getItemParamsConfig(true);
            String strItemFormat = "%1$s";
            ItemParamConfig keyItemParamConfig = new ItemParamConfig();
            keyItemParamConfig.setID(timeDEFHelper.GetDTColumn().GetColumnName());
            GSR2SumTable sumTable = this.gsr2.FindSumTable(strTD);
            if (sumTable != null) {
                strItemFormat = sumTable.GetParamStringValue("ITEMFORMAT", "");
            }
            keyItemParamConfig.setItemFormat(strItemFormat);
            itemParamsConfig.getList().add(keyItemParamConfig);
            ItemParamConfig keyItemParamConfig2 = new ItemParamConfig();
            keyItemParamConfig2.setID(groupDEFHelper.GetDTColumn().GetColumnName());
            itemParamsConfig.getList().add(keyItemParamConfig2);
            keyItemParamConfig2 = new ItemParamConfig();
            keyItemParamConfig2.setID("SRFJOINNAME");
            itemParamsConfig.getList().add(keyItemParamConfig2);
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig5);
            dgColumnConfig5 = new DataGridColumnConfig();
            dgColumnConfig5.setHidden(false);
            dgColumnConfig5.setID("SRFJOINNAME");
            dgColumnConfig5.setCaption(groupDEFHelper.getLogicName(this.getLanguage()));
            dgColumnConfig5.setWidth(this.gsr2.getGROUPCOLUMNWIDTH());
            dgColumnConfig5.setSortable(true);
            dgColumnConfig5.setLocked(false);
            dgColumnConfig5.setMenuDisabled(true);
            dgColumnConfig5.setDSItem("SRFJOINNAME");
            this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig5);
            dsItemConfig5 = new DataGridDSItemConfig();
            dsItemConfig5.setID("SRFJOINNAME");
            dsItemConfig5.setKey(true);
            dsItemConfig5.setKeyFormat("%1$s");
            dsItemConfig5.setExcelFormat("%1$s");
            if (StringHelper.Compare((String)dimension.GetParamStringValue("ISDRILLDOWN", "0"), (String)"0", (boolean)true) == 0) {
                strJoinFormat = StringHelper.Format((String)"%1$s:'%%3$s',%2$s:'%%1$s',srftd:'%3$s',srfgsr2id:'%4$s'", (Object)joinDEHElper.GetKeyDEFHelper().getName(), (Object)joinDEHElper.GetMajorDEFHelper().getName(), (Object)strTD, (Object)this.gsr2.getGSR2ID());
                strDrillFormat = StringHelper.Format((String)"<a href='#' title='\u5411\u4e0b\u94bb\u53d6\u660e\u7ec6\u6570\u636e' onclick=\"drilldown({srftime:'%%2$s',%1$s});\"><IMG src='../sasrfex/images/default/icon_drilldown3.png' border='0'></A>&nbsp;%%1$s", (Object)strJoinFormat);
                dsItemConfig5.setItemFormat(strDrillFormat);
                itemParamsConfig = dsItemConfig5.getItemParamsConfig(true);
                keyItemParamConfig2 = new ItemParamConfig();
                keyItemParamConfig2.setID("SRFJOINNAME");
                itemParamsConfig.getList().add(keyItemParamConfig2);
                strItemFormat = "%1$s";
                keyItemParamConfig = new ItemParamConfig();
                keyItemParamConfig.setID(timeDEFHelper.GetDTColumn().GetColumnName());
                sumTable = this.gsr2.FindSumTable(strTD);
                if (sumTable != null) {
                    strItemFormat = sumTable.GetParamStringValue("ITEMFORMAT", "");
                }
                keyItemParamConfig.setItemFormat(strItemFormat);
                itemParamsConfig.getList().add(keyItemParamConfig);
                keyItemParamConfig2 = new ItemParamConfig();
                keyItemParamConfig2.setID(groupDEFHelper.GetDTColumn().GetColumnName());
                itemParamsConfig.getList().add(keyItemParamConfig2);
            }
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig5);
            DataGridDSItemConfig dsItemConfig6 = new DataGridDSItemConfig();
            dsItemConfig6.setID(groupDEFHelper.GetDTColumn().GetColumnName().toUpperCase());
            dsItemConfig6.setKey(true);
            dsItemConfig6.setKeyFormat("%1$s");
            dsItemConfig6.setItemFormat("%1$s");
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig6);
            for (GSR2Measure measure : this.gsr2.getMeasures()) {
                DataGridColumnConfig dgColumnConfig6 = new DataGridColumnConfig();
                dgColumnConfig6.setHidden(false);
                dgColumnConfig6.setID(measure.getDEFNAME());
                dgColumnConfig6.setCaption(measure.getGSR2MEASURENAME());
                dgColumnConfig6.setWidth(measure.getWIDTH());
                dgColumnConfig6.setSortable(true);
                dgColumnConfig6.setLocked(false);
                dgColumnConfig6.setDSItem(measure.getDEFNAME());
                dgColumnConfig6.setAlign("right");
                dgColumnConfig6.setMenuDisabled(true);
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig6);
                if (!StringHelper.IsNullOrEmpty((String)measure.getTHGROUPID())) {
                    DataGridColumnRenderConfig dataGridColumnRenderConfig = new DataGridColumnRenderConfig();
                    dataGridColumnRenderConfig.setID(measure.getDEFNAME());
                    dataGridColumnRenderConfig.setObject(ThresholdColumnRender.class.getName());
                    dataGridColumnRenderConfig.SetExtValue("THGROUPID", measure.getTHGROUPID());
                    dataGridColumnRenderConfig.setDataGridConfig(this.dataGrid.getDataGridConfig());
                    this.dataGrid.getDataGridConfig().getDataGridColumnRendersConfig(true).getList().add(dataGridColumnRenderConfig);
                    dgColumnConfig6.setRenderId(measure.getDEFNAME());
                }
                DataGridDSItemConfig dsItemConfig7 = new DataGridDSItemConfig();
                dsItemConfig7.setID(measure.getDEFNAME());
                dsItemConfig7.setItemFormat(measure.getITEMFORMAT());
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig7);
            }
        }
        this.AddControl((SRFExControl)this.dataGrid);
    }

    protected String OnGetDataGridConfigId() {
        return "SRFREPORT.DG_GSR_DEFAULT";
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetGSPToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = GSR2Page.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dataGrid != null) {
                this.toolbar.setToolbarObject("DATAGRID", (Object)this.dataGrid);
                this.toolbar.setToolbarObject("", (Object)this.dataGrid);
            }
            this.toolbar.setToolbarObject("SPEX", (Object)this.spEx);
        }
    }

    protected String OnGetGSPToolbarConfigId() {
        return "SRFREPORT.TB_GSR_DEFAULT2";
    }

    public String GetSPExDPUniqueId() {
        return this.spEx.getPanel().getUniqueID();
    }

    protected String GetSearchFormActionHelper() {
        String strSearchFormActionHelper = this.getPageParam("PAGE.SPACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchFormActionHelper)) {
            if (this.searchForm != null && !StringHelper.IsNullOrEmpty((String)(strSearchFormActionHelper = this.searchForm.getBACKENDCTRL()))) {
                return strSearchFormActionHelper;
            }
            strSearchFormActionHelper = BaseDASearchFormActionHelper.class.getName();
        }
        return strSearchFormActionHelper;
    }

    protected String GetDGActionHelper() {
        String strDGActionHelper = this.getPageParam("PAGE.DGACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.gsr2.getBACKENDCTRL())) {
            return this.gsr2.getBACKENDCTRL();
        }
        return this.GetDefaultDGActionHelper();
    }

    protected String GetDefaultDGActionHelper() {
        return "SA.SRFDA.Report.Ctrl.DataGrid.GSR2DataGridActionHelper";
    }

    public String GetDetailDGPath() {
        return this.strDetailDGUrl;
    }

    public String GetAfterOnReadyCode() {
        StringBuilderEx script = new StringBuilderEx();
        this.OnGetAfterOnReadyCode(script);
        return script.toString();
    }

    protected void OnGetAfterOnReadyCode(StringBuilderEx script) {
        BaseToolbarItemConfig filterTBBConfig;
        if (this.gsr2.getSPEXPAND() && this.toolbar != null && (filterTBBConfig = this.toolbar.getToolbarConfig().getToolbarItemsConfig().FindToolbarItemConfig("TBB_FILTER")) != null) {
            script.Append(StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(showhidesp());", (Object)this.toolbar.getUniqueID(), (Object)"TBB_FILTER"));
        }
    }

    public String OutputPageCaption() {
        if (this.gsr2 != null) {
            return this.gsr2.getGSR2NAME();
        }
        return super.OutputPageCaption();
    }

    public String OutputPageIcon(boolean bSmall) {
        if (bSmall && this.gsr2 != null) {
            return this.gsr2.getIconPath("../sasrfex/images/default/icon_report.gif");
        }
        return super.OutputPageIcon(bSmall);
    }

    public boolean IsTableViewDefault() {
        if (this.gsr2 != null) {
            return this.gsr2.getTABLEVIEWDEFAULT();
        }
        return false;
    }

    public String GetTimeColumnName() {
        return this.gsr2.getTIMEDEFNAME().toUpperCase();
    }

    public String GetDrillPagePath() {
        String strPagePath = StringHelper.Format((String)"../srfpage/gridview.jsp?SRFDEID=%1$s", (Object)this.gsr2.getDEID());
        if (!StringHelper.IsNullOrEmpty((String)this.gsr2.getDETAILDGPAGEID())) {
            Page page = this.getDAModelStorage().FindPage(this.gsr2.getDETAILDGPAGEID());
            if (page != null) {
                strPagePath = page.GetTotalPagePath();
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)this.gsr2.getDETAILDGPAGEID()));
            }
            strPagePath = URLHelper.AppendURLSeperator((String)strPagePath);
            strPagePath = String.valueOf(strPagePath) + StringHelper.Format((String)"SRFDEID=%1$s", (Object)this.gsr2.getDEID());
        }
        return URLHelper.AppendURLSeperator((String)strPagePath);
    }
}

