/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.GSRGroupColumn
 *  SA.SRFDA.Ctrl.Data.GSRMeasure
 *  SA.SRFDA.Ctrl.Data.GroupStatisticsRep
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDropDownList
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

import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Report.Ctrl.DataGrid.ThresholdColumnRender;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDropDownList;
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
import java.util.Vector;
import net.sf.json.JSONObject;

public class GroupStatisticsRepPage2
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected SRFExDataGrid dataGrid = null;
    protected SRFExToolbar toolbar = null;
    protected GroupStatisticsRep groupStatisticsRep = null;
    protected String strToolbarConfigId = "";
    protected String strSPExConfigId = "";
    protected String strDGConfigId = "";
    protected DataGrid gridView = null;
    protected SRFExDropDownList timeGroupColumnList = null;
    protected SRFExDropDownList groupColumnList = null;
    protected SRFExDropDownList measureGroupList = null;
    protected SRFExTextBox tbTopN = null;
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
        String strGSRId = this.getWebContext().GetParamValue("GROUPSTATISTICSREPID");
        if (StringHelper.IsNullOrEmpty((String)strGSRId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u7f16\u53f7");
            return false;
        }
        this.groupStatisticsRep = this.getDAModelStorage().FindGroupStatisticsRep(strGSRId);
        if (this.groupStatisticsRep == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868\u914d\u7f6e[%1$s]", (Object)strGSRId));
            return false;
        }
        this.strPageDataEntityId = this.groupStatisticsRep.getDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.setPageParam("GROUPSTATISTICSREP", this.groupStatisticsRep);
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
        if (StringHelper.IsNullOrEmpty((String)this.groupStatisticsRep.getDETAILDGPAGEID())) {
            this.strDetailDGUrl = "../srfpage/embedgridview.jsp";
        } else {
            Page page = this.getDAModelStorage().FindPage(this.groupStatisticsRep.getDETAILDGPAGEID());
            if (page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)this.groupStatisticsRep.getDETAILDGPAGEID()));
                return;
            }
            this.strDetailDGUrl = page.GetTotalPagePath();
        }
        this.strDetailDGUrl = URLHelper.AppendURLSeperator((String)this.strDetailDGUrl);
        this.strDetailDGUrl = String.valueOf(this.strDetailDGUrl) + StringHelper.Format((String)"SRFDGAL=FALSE&SRFGRIDVIEW=%1$s&", (Object)this.groupStatisticsRep.getDETAILDGID());
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
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), this.GetDGActionHelper());
    }

    protected void LoadGroupControls() {
        if (this.groupStatisticsRep.getENABLETIMEGROUP()) {
            this.timeGroupColumnList = new SRFExDropDownList();
            this.timeGroupColumnList.InitConfig();
            this.timeGroupColumnList.setID("ddlTimeGroupColumn");
            this.timeGroupColumnList.getDropDownListConfig().setWidth(200);
            if (!this.IsBackEndMode()) {
                this.timeGroupColumnList.getDropDownListConfig().getListFillerConfig().setCodeList(this.groupStatisticsRep.getTIMECODELISTID());
                this.timeGroupColumnList.getDropDownListConfig().getListFillerConfig().setEmptySupported(false);
                this.timeGroupColumnList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId()));
            }
            this.AddControl((SRFExControl)this.timeGroupColumnList);
        } else {
            this.groupColumnList = new SRFExDropDownList();
            this.groupColumnList.InitConfig();
            this.groupColumnList.setID("ddlGroupColumn");
            this.groupColumnList.getDropDownListConfig().setWidth(200);
            if (!this.IsBackEndMode()) {
                for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                    if (groupColumn.getDEFAULTGROUP() || groupColumn.getORDERFLAG() == -1) continue;
                    this.groupColumnList.getDropDownListConfig().getListItems().Add(new ListItem(groupColumn.getGSRGROUPCOLUMNNAME(), groupColumn.getDEFIELDNAME()));
                    if (!StringHelper.IsNullOrEmpty((String)this.strGroupColumns)) {
                        this.strGroupColumns = String.valueOf(this.strGroupColumns) + ",";
                    }
                    this.strGroupColumns = String.valueOf(this.strGroupColumns) + StringHelper.Format((String)"'%1$s'", (Object)groupColumn.getDEFIELDNAME());
                }
                this.groupColumnList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId()));
            }
            this.AddControl((SRFExControl)this.groupColumnList);
            this.tbTopN = new SRFExTextBox();
            this.tbTopN.InitConfig();
            this.tbTopN.setID("tbTopN");
            this.tbTopN.getTextBoxConfig().setWidth(40);
            this.tbTopN.getTextBoxConfig().setValue(StringHelper.Format((String)"%1$s", (Object)this.groupStatisticsRep.getTopNCount(10)));
            this.AddControl((SRFExControl)this.tbTopN);
            if (!this.IsBackEndMode()) {
                this.RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('blue',function(){%2$s.search();});", (Object)this.tbTopN.getUniqueID(), (Object)this.getDefaultFormId()));
            }
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
            for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
                String strGroupId;
                String strSort;
                if (gsrMeasure.getORDERFLAG() < 0) continue;
                String strGroup = gsrMeasure.getGSRMEASUREGROUPNAME();
                if (StringHelper.IsNullOrEmpty((String)strGroup)) {
                    strGroup = "\u9ed8\u8ba4\u5206\u7ec4";
                }
                jo.put(gsrMeasure.getEXPALIAS().toLowerCase(), (Object)gsrMeasure.getGSRMEASUREGROUPID());
                if (!measureGroupMap.containsKey(strGroup)) {
                    measureGroupMap.put(strGroup, "");
                    this.measureGroupList.getDropDownListConfig().getListItems().Add(new ListItem(strGroup, gsrMeasure.getGSRMEASUREGROUPID()));
                }
                if (StringHelper.IsNullOrEmpty((String)(strSort = gsrMeasure.getDEFAULTSORT())) || measureGroupSort.has((strGroupId = StringHelper.Format((String)"g%1$s", (Object)(this.measureGroupList.getDropDownListConfig().getListItems().size() - 1))).toLowerCase())) continue;
                gsrMeasure.getGSRMEASUREGROUPID();
                JSONObject jo2 = new JSONObject();
                jo2.put("field", (Object)gsrMeasure.getEXPALIAS().toLowerCase());
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
            if (this.groupStatisticsRep.getENABLETIMEGROUP()) {
                String strScript = StringHelper.Format((String)"$P.store['%1$s'].setDefaultSort('%2$s','%3$s');", (Object)this.dataGrid.getUniqueID(), (Object)"srftdname", (Object)"ASC");
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
        this.spEx = GroupStatisticsRepPage2.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.strSPExConfigId);
        if (this.spEx != null) {
            if (this.groupStatisticsRep.getENABLECONDSL()) {
                this.spEx.getSearchForm().setFormTag(this.groupStatisticsRep.getGROUPSTATISTICSREPID());
                this.spEx.getSPExConfig().setSaveLoad(true);
            }
            this.spEx.getSPExConfig().setWidth(1024);
        }
    }

    protected String OnGetSPExConfigId() {
        String strSearchformId = this.groupStatisticsRep.getSEARCHFORMID();
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
        this.dataGrid = GroupStatisticsRepPage2.CreateDataGrid((SRFDAPage)this, (String)"dataGrid", (double)0.0, (double)0.0, (String)this.strDGConfigId, (boolean)false);
        if (!this.IsBackEndMode()) {
            DataGridDSItemConfig dsItemConfig;
            DataGridColumnConfig dgColumnConfig;
            this.dataGrid.getDataGridConfig().setDeferEmptyText(false);
            DataGridColumnConfig dgColumnConfig2 = new DataGridColumnConfig();
            dgColumnConfig2.setHidden(false);
            dgColumnConfig2.setID("SRFROWSN");
            dgColumnConfig2.setCaption("\u884c\u53f7");
            dgColumnConfig2.setWidth(50);
            dgColumnConfig2.setSortable(false);
            dgColumnConfig2.setLocked(false);
            dgColumnConfig2.setDSItem("SRFROWSN");
            dgColumnConfig2.setAlign("right");
            dgColumnConfig2.setHideable(false);
            dgColumnConfig2.setMenuDisabled(true);
            this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig2);
            DataGridDSItemConfig dsItemConfig2 = new DataGridDSItemConfig();
            dsItemConfig2.setID("SRFROWSN");
            this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig2);
            if (this.groupStatisticsRep.getENABLETIMEGROUP()) {
                dgColumnConfig2 = new DataGridColumnConfig();
                dgColumnConfig2.setHidden(false);
                dgColumnConfig2.setID("SRFTDID");
                dgColumnConfig2.setCaption("\u65f6\u95f4");
                dgColumnConfig2.setWidth(140);
                dgColumnConfig2.setSortable(true);
                dgColumnConfig2.setLocked(false);
                dgColumnConfig2.setMenuDisabled(true);
                dgColumnConfig2.setDSItem("SRFTDNAME");
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig2);
                dsItemConfig2 = new DataGridDSItemConfig();
                dsItemConfig2.setID("SRFTDNAME");
                dsItemConfig2.setKey(true);
                dsItemConfig2.setKeyFormat("%1$s");
                dsItemConfig2.setItemFormat("%1$s");
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig2);
            } else {
                for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                    dgColumnConfig = new DataGridColumnConfig();
                    if (groupColumn.getORDERFLAG() < 0) continue;
                    dgColumnConfig.setHidden(!groupColumn.getDEFAULTGROUP());
                    dgColumnConfig.setID(groupColumn.getDEFIELDNAME());
                    dgColumnConfig.setCaption(groupColumn.getColumnName());
                    dgColumnConfig.setWidth(groupColumn.getWIDTH());
                    dgColumnConfig.setSortable(true);
                    dgColumnConfig.setLocked(false);
                    dgColumnConfig.setDSItem(groupColumn.getDEFIELDNAME());
                    dgColumnConfig.setMenuDisabled(true);
                    this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                    dsItemConfig = new DataGridDSItemConfig();
                    dsItemConfig.setID(groupColumn.getDEFIELDNAME());
                    dsItemConfig.setKey(true);
                    dsItemConfig.setKeyFormat("%1$s");
                    dsItemConfig.setItemFormat("%1$s");
                    if (!StringHelper.IsNullOrEmpty((String)groupColumn.getNAMEDEFNAME())) {
                        dsItemConfig.setSortParam(groupColumn.getNAMEDEFNAME());
                    }
                    this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                    DataGridDSItemConfig dsNameItemConfig = new DataGridDSItemConfig();
                    dsNameItemConfig.setID("SRFTEXT_" + groupColumn.getDEFIELDNAME());
                    dsNameItemConfig.setKey(false);
                    dsNameItemConfig.setKeyFormat("%1$s");
                    dsNameItemConfig.setItemFormat("%1$s");
                    this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsNameItemConfig);
                }
            }
            for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
                if (gsrMeasure.getORDERFLAG() < 0) continue;
                dgColumnConfig = new DataGridColumnConfig();
                dgColumnConfig.setHidden(false);
                dgColumnConfig.setID(gsrMeasure.getEXPALIAS());
                dgColumnConfig.setCaption(gsrMeasure.getGSRMEASURENAME());
                dgColumnConfig.setWidth(gsrMeasure.getWIDTH());
                dgColumnConfig.setSortable(true);
                dgColumnConfig.setLocked(false);
                dgColumnConfig.setDSItem(gsrMeasure.getEXPALIAS());
                dgColumnConfig.setAlign("right");
                dgColumnConfig.setMenuDisabled(true);
                this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                if (!StringHelper.IsNullOrEmpty((String)gsrMeasure.getTHGROUPID())) {
                    DataGridColumnRenderConfig dataGridColumnRenderConfig = new DataGridColumnRenderConfig();
                    dataGridColumnRenderConfig.setID(gsrMeasure.getEXPALIAS());
                    dataGridColumnRenderConfig.setObject(ThresholdColumnRender.class.getName());
                    dataGridColumnRenderConfig.SetExtValue("THGROUPID", gsrMeasure.getTHGROUPID());
                    dataGridColumnRenderConfig.setDataGridConfig(this.dataGrid.getDataGridConfig());
                    this.dataGrid.getDataGridConfig().getDataGridColumnRendersConfig(true).getList().add(dataGridColumnRenderConfig);
                    dgColumnConfig.setRenderId(gsrMeasure.getEXPALIAS());
                }
                dsItemConfig = new DataGridDSItemConfig();
                dsItemConfig.setID(gsrMeasure.getEXPALIAS());
                dsItemConfig.setItemFormat(gsrMeasure.getITEMFORMAT());
                this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
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
            String strActionType = this.webContext.getActionType();
            if (StringHelper.Compare((String)"gridaction", (String)strActionType, (boolean)true) == 0) {
                String strAction = this.webContext.getAction();
                if (StringHelper.Compare((String)strAction, (String)"SRFDAEXPORT", (boolean)true) != 0) {
                    DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
                    dgColumnConfig.setHidden(false);
                    dgColumnConfig.setID("SRFROWSN");
                    dgColumnConfig.setCaption("\u884c\u53f7");
                    dgColumnConfig.setWidth(50);
                    dgColumnConfig.setSortable(false);
                    dgColumnConfig.setLocked(false);
                    dgColumnConfig.setDSItem("SRFROWSN");
                    dgColumnConfig.setAlign("right");
                    this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                    DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
                    dsItemConfig.setID("SRFROWSN");
                    this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                }
                String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
                ItemParamsConfig textItemParamsConfig = new ItemParamsConfig();
                String strTextItemFormat = "";
                String strDrillDownFormat = "";
                int nIndex = 1;
                if (!this.groupStatisticsRep.getENABLETIMEGROUP()) {
                    String strTimeGroupField = "";
                    Vector<String> groupColumns = new Vector<String>();
                    for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                        if (StringHelper.Compare((String)groupColumn.getDEFIELDNAME(), (String)strGroupField, (boolean)true) != 0 && !groupColumn.getDEFAULTGROUP() && groupColumn.getORDERFLAG() >= 0) continue;
                        if (!groupColumn.getENABLETIMEGROUP()) {
                            groupColumns.add(groupColumn.getDEFIELDNAME());
                        } else {
                            strTimeGroupField = groupColumn.getDEFIELDNAME();
                        }
                        ItemParamConfig itemParamConfig = new ItemParamConfig();
                        if (StringHelper.IsNullOrEmpty((String)groupColumn.getNAMEDEFNAME())) {
                            itemParamConfig.setID(groupColumn.getDEFIELDNAME());
                        } else {
                            itemParamConfig.setID(groupColumn.getNAMEDEFNAME());
                        }
                        itemParamConfig.setCodeList(groupColumn.getCODELISTID());
                        textItemParamsConfig.getList().add(itemParamConfig);
                        if (!StringHelper.IsNullOrEmpty((String)strTextItemFormat)) {
                            strTextItemFormat = String.valueOf(strTextItemFormat) + "/";
                        }
                        strTextItemFormat = String.valueOf(strTextItemFormat) + StringHelper.Format((String)"%%%1$s$s", (Object)nIndex);
                        ++nIndex;
                    }
                    nIndex = 3;
                    for (String strGroupColumn : groupColumns) {
                        if (!StringHelper.IsNullOrEmpty((String)strDrillDownFormat)) {
                            strDrillDownFormat = String.valueOf(strDrillDownFormat) + ",";
                        }
                        strDrillDownFormat = String.valueOf(strDrillDownFormat) + StringHelper.Format((String)"n_%1$s_eq:'%%%2$s$s'", (Object)strGroupColumn.toLowerCase(), (Object)nIndex);
                        ++nIndex;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strTimeGroupField)) {
                        if (!StringHelper.IsNullOrEmpty((String)strDrillDownFormat)) {
                            strDrillDownFormat = String.valueOf(strDrillDownFormat) + ",";
                        }
                        strDrillDownFormat = String.valueOf(strDrillDownFormat) + StringHelper.Format((String)"n_%1$s_gtandeq:'%%%2$s$s',n_%1$s_lt:'%%%3$s$s'", (Object)strTimeGroupField.toLowerCase(), (Object)nIndex, (Object)(nIndex + 1));
                        nIndex += 2;
                    }
                    for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                        if (StringHelper.Compare((String)groupColumn.getDEFIELDNAME(), (String)strGroupField, (boolean)true) != 0 && !groupColumn.getDEFAULTGROUP() && groupColumn.getORDERFLAG() >= 0) continue;
                        DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
                        dgColumnConfig.setHidden(!groupColumn.getDEFAULTGROUP());
                        dgColumnConfig.setID(groupColumn.getDEFIELDNAME());
                        dgColumnConfig.setCaption(groupColumn.getColumnName());
                        dgColumnConfig.setWidth(groupColumn.getWIDTH());
                        dgColumnConfig.setSortable(true);
                        dgColumnConfig.setLocked(false);
                        dgColumnConfig.setDSItem(groupColumn.getDEFIELDNAME());
                        this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                        DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
                        dsItemConfig.setID(groupColumn.getDEFIELDNAME());
                        dsItemConfig.setKey(true);
                        ItemParamsConfig itemParamsConfig = dsItemConfig.getItemParamsConfig(true);
                        ItemParamConfig keyItemParamConfig = new ItemParamConfig();
                        keyItemParamConfig.setID(groupColumn.getDEFIELDNAME());
                        itemParamsConfig.getList().add(keyItemParamConfig);
                        ItemParamConfig itemParamConfig = new ItemParamConfig();
                        if (StringHelper.IsNullOrEmpty((String)groupColumn.getNAMEDEFNAME())) {
                            itemParamConfig.setID(groupColumn.getDEFIELDNAME());
                        } else {
                            itemParamConfig.setID(groupColumn.getNAMEDEFNAME());
                        }
                        itemParamConfig.setCodeList(groupColumn.getCODELISTID());
                        itemParamsConfig.getList().add(itemParamConfig);
                        for (String strGroupColumn : groupColumns) {
                            ItemParamConfig itemParamConfig2 = new ItemParamConfig();
                            itemParamConfig2.setID(strGroupColumn);
                            itemParamsConfig.getList().add(itemParamConfig2);
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strTimeGroupField)) {
                            itemParamConfig = new ItemParamConfig();
                            itemParamConfig.setID("SRFTDFROM");
                            itemParamConfig.setItemFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
                            itemParamsConfig.getList().add(itemParamConfig);
                            itemParamConfig = new ItemParamConfig();
                            itemParamConfig.setID("SRFTDTO");
                            itemParamConfig.setItemFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
                            itemParamsConfig.getList().add(itemParamConfig);
                        }
                        dsItemConfig.setKeyFormat("%1$s");
                        dsItemConfig.setItemFormat(StringHelper.Format((String)"<a href='#' title='\u5411\u4e0b\u94bb\u53d6\u660e\u7ec6\u6570\u636e' onclick=\"drilldown({%2$s});\"><IMG src='../sasrfex/images/default/icon_drilldown3.png' border='0'></A>&nbsp;%%2$s", (Object)groupColumn.getDEFIELDNAME().toLowerCase(), (Object)strDrillDownFormat));
                        dsItemConfig.setExcelFormat("%2$s");
                        this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                        dsItemConfig = new DataGridDSItemConfig();
                        dsItemConfig.setID("SRFTEXT_" + groupColumn.getDEFIELDNAME());
                        dsItemConfig.setKey(false);
                        dsItemConfig.setItemFormat(strTextItemFormat);
                        itemParamsConfig = dsItemConfig.getItemParamsConfig(true);
                        itemParamsConfig.getList().addAll(textItemParamsConfig.getList());
                        this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                    }
                } else {
                    DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
                    dgColumnConfig.setID("SRFTDID");
                    dgColumnConfig.setCaption("\u65f6\u95f4");
                    dgColumnConfig.setWidth(140);
                    dgColumnConfig.setSortable(true);
                    dgColumnConfig.setLocked(false);
                    dgColumnConfig.setMenuDisabled(true);
                    dgColumnConfig.setDSItem("SRFTDNAME");
                    this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                    DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
                    dsItemConfig.setID("SRFTDNAME");
                    dsItemConfig.setKey(true);
                    ItemParamsConfig itemParamsConfig = dsItemConfig.getItemParamsConfig(true);
                    ItemParamConfig keyItemParamConfig = new ItemParamConfig();
                    keyItemParamConfig.setID("SRFTDNAME");
                    itemParamsConfig.getList().add(keyItemParamConfig);
                    keyItemParamConfig = new ItemParamConfig();
                    keyItemParamConfig.setID("SRFTDNAME");
                    itemParamsConfig.getList().add(keyItemParamConfig);
                    ItemParamConfig itemParamConfig = new ItemParamConfig();
                    itemParamConfig.setID("SRFTDFROM");
                    itemParamConfig.setItemFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
                    itemParamsConfig.getList().add(itemParamConfig);
                    itemParamConfig = new ItemParamConfig();
                    itemParamConfig.setID("SRFTDTO");
                    itemParamConfig.setItemFormat("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS");
                    itemParamsConfig.getList().add(itemParamConfig);
                    dsItemConfig.setKeyFormat("%1$s");
                    strDrillDownFormat = StringHelper.Format((String)"n_%1$s_gtandeq:'%%3$s',n_%1$s_lt:'%%4$s'", (Object)this.groupStatisticsRep.getTIMEDEFIELDTIME().toLowerCase());
                    dsItemConfig.setItemFormat(StringHelper.Format((String)"<a href='#' title='\u5411\u4e0b\u94bb\u53d6\u660e\u7ec6\u6570\u636e' onclick=\"drilldown({%1$s});\"><IMG src='../sasrfex/images/default/icon_drilldown3.png' border='0'></A>&nbsp;%%1$s", (Object)strDrillDownFormat));
                    dsItemConfig.setExcelFormat("%2$s");
                    this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                }
                for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
                    if (gsrMeasure.getORDERFLAG() < 0) continue;
                    DataGridColumnConfig dgColumnConfig = new DataGridColumnConfig();
                    dgColumnConfig.setHidden(false);
                    dgColumnConfig.setID(gsrMeasure.getEXPALIAS());
                    dgColumnConfig.setCaption(gsrMeasure.getGSRMEASURENAME());
                    dgColumnConfig.setWidth(gsrMeasure.getWIDTH());
                    dgColumnConfig.setSortable(true);
                    dgColumnConfig.setLocked(false);
                    dgColumnConfig.setDSItem(gsrMeasure.getEXPALIAS());
                    dgColumnConfig.setAlign("right");
                    this.dataGrid.getDataGridConfig().getDataGridColumnsConfig().getList().add(dgColumnConfig);
                    DataGridDSItemConfig dsItemConfig = new DataGridDSItemConfig();
                    dsItemConfig.setID(gsrMeasure.getEXPALIAS());
                    dsItemConfig.setItemFormat(gsrMeasure.getITEMFORMAT());
                    this.dataGrid.getDataGridConfig().getDataGridDSConfig().getList().add(dsItemConfig);
                }
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
        this.toolbar = GroupStatisticsRepPage2.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
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
        return this.GetDefaultDGActionHelper();
    }

    protected String GetDefaultDGActionHelper() {
        return "SA.SRFDA.Report.Ctrl.DataGrid.GSRDataGridActionHelper";
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
        if (this.toolbar != null && (filterTBBConfig = this.toolbar.getToolbarConfig().getToolbarItemsConfig().FindToolbarItemConfig("TBB_FILTER")) != null) {
            script.Append(StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(showhidesp());", (Object)this.toolbar.getUniqueID(), (Object)"TBB_FILTER"));
        }
    }

    public String OutputPageCaption() {
        if (this.groupStatisticsRep != null) {
            return this.groupStatisticsRep.getGROUPSTATISTICSREPNAME();
        }
        return super.OutputPageCaption();
    }

    public String OutputPageIcon(boolean bSmall) {
        if (bSmall && this.groupStatisticsRep != null) {
            return this.groupStatisticsRep.getIconPath("../sasrfex/images/default/icon_report.gif");
        }
        return super.OutputPageIcon(bSmall);
    }

    public boolean IsTimeGroup() {
        if (this.groupStatisticsRep != null) {
            return this.groupStatisticsRep.getENABLETIMEGROUP();
        }
        return false;
    }

    public boolean IsTableViewDefault() {
        if (this.groupStatisticsRep != null) {
            return this.groupStatisticsRep.getTABLVIEWDEFAULT();
        }
        return false;
    }
}

