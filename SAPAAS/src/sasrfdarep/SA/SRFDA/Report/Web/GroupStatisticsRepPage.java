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
 *  SA.SRFramework.WebEx.DGEx.SRFExDGEx
 *  SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig
 *  SA.SRFramework.WebEx.DGEx.UI.DGExColumnConfig
 *  SA.SRFramework.WebEx.DGEx.UI.DGExLabelCellConfig
 *  SA.SRFramework.WebEx.DGEx.UI.DGExSNCellConfig
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
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
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.DGEx.SRFExDGEx;
import SA.SRFramework.WebEx.DGEx.UI.DGExCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExColumnConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExLabelCellConfig;
import SA.SRFramework.WebEx.DGEx.UI.DGExSNCellConfig;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.Utility.URLHelper;
import net.sf.json.JSONObject;

public class GroupStatisticsRepPage
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected SRFExDGEx dgEx = null;
    protected SRFExToolbar toolbar = null;
    protected GroupStatisticsRep groupStatisticsRep = null;
    protected String strToolbarConfigId = "";
    protected String strSPExConfigId = "";
    protected String strDGExConfigId = "";
    protected DataGrid gridView = null;
    protected SRFExDropDownList groupColumnList = null;
    protected SRFExTextBox tbTopN = null;
    protected String strDetailDGUrl = "";
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
        this.gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), this.groupStatisticsRep.getDETAILDGID());
        if (this.gridView == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)this.groupStatisticsRep.getDETAILDGID()));
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadGroupControls();
        this.LoadDGEx();
        this.LoadToolbar();
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
        script.Append("$P.mainview=new SRFDA.GridViewEx(%1$s);", (Object)params.toString());
        this.RegisterOnReadyScript(3, script.toString());
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
        this.RegisterDGExActionHelper(this.dgEx.getUniqueID(), this.GetDGExActionHelper());
    }

    protected void LoadGroupControls() {
        this.groupColumnList = new SRFExDropDownList();
        this.groupColumnList.InitConfig();
        this.groupColumnList.setID("ddlGroupColumn");
        this.groupColumnList.getDropDownListConfig().setWidth(200);
        if (!this.IsBackEndMode()) {
            for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                this.groupColumnList.getDropDownListConfig().getListItems().Add(new ListItem(groupColumn.getGSRGROUPCOLUMNNAME(), groupColumn.getDEFIELDNAME()));
            }
            this.groupColumnList.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"%1$s.search();", (Object)this.getDefaultFormId()));
        }
        this.AddControl((SRFExControl)this.groupColumnList);
        this.tbTopN = new SRFExTextBox();
        this.tbTopN.InitConfig();
        this.tbTopN.setID("tbTopN");
        this.tbTopN.getTextBoxConfig().setWidth(60);
        this.tbTopN.getTextBoxConfig().setValue("100");
        this.AddControl((SRFExControl)this.tbTopN);
        if (!this.IsBackEndMode()) {
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"Ext.get('%1$s').on('blue',function(){%2$s.search();});", (Object)this.tbTopN.getUniqueID(), (Object)this.getDefaultFormId()));
        }
    }

    protected void LoadSPEx() {
        this.strSPExConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
            return;
        }
        this.spEx = GroupStatisticsRepPage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.strSPExConfigId);
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

    protected void LoadDGEx() {
        this.strDGExConfigId = this.OnGetDGExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strDGExConfigId)) {
            return;
        }
        this.dgEx = GroupStatisticsRepPage.CreateDGEx((SRFDAPage)this, (String)"dgEx", (double)0.0, (double)0.0, (String)this.strDGExConfigId, (boolean)false);
        if (!this.IsBackEndMode()) {
            this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.store['%1$s'].userparams", (Object)this.dgEx.getUniqueID()));
            this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"searchdgex();", (Object)this.dgEx.getUniqueID()));
            StringBuilderEx script = new StringBuilderEx();
            String strBeforeLoadDefault = this.getPageParam("PAGE.BEFORELOADDEFAULT", "");
            if (!StringHelper.IsNullOrEmpty((String)strBeforeLoadDefault)) {
                script.Append(strBeforeLoadDefault);
            }
            this.RegisterOnReadyScript(3, script.toString());
        } else {
            String strActionType = this.webContext.getActionType();
            if (StringHelper.Compare((String)"gridexaction", (String)strActionType, (boolean)true) == 0) {
                DGExCellConfig cellConfig;
                DGExColumnConfig columnConfig;
                DGExColumnConfig columnConfig2 = new DGExColumnConfig();
                columnConfig2.setHeight(30);
                columnConfig2.setCaption("\u5e8f\u53f7");
                columnConfig2.setWidth(50);
                columnConfig2.setBorder(15);
                this.dgEx.getDGExConfig().getRootGroupConfig().getGroupHeaderConfig().getColumnsConfig().add((Object)columnConfig2);
                DGExSNCellConfig cellConfig2 = new DGExSNCellConfig();
                cellConfig2.setWidth(50);
                cellConfig2.setHeight(25);
                cellConfig2.setBorder(13);
                cellConfig2.setLastBorder(13);
                this.dgEx.getDGExConfig().getRootGroupConfig().getGroupContentConfig().getCellsConfig().add((Object)cellConfig2);
                String strGroupField = this.getWebContext().GetPostValue("srfgroupfield");
                if (!StringHelper.IsNullOrEmpty((String)strGroupField)) {
                    for (GSRGroupColumn groupColumn : this.groupStatisticsRep.getGroupColumns()) {
                        if (StringHelper.Compare((String)groupColumn.getDEFIELDNAME(), (String)strGroupField, (boolean)true) != 0) continue;
                        columnConfig = new DGExColumnConfig();
                        columnConfig.setHeight(30);
                        columnConfig.setCaption("");
                        columnConfig.setWidth(30);
                        columnConfig.setBorder(14);
                        this.dgEx.getDGExConfig().getRootGroupConfig().getGroupHeaderConfig().getColumnsConfig().add((Object)columnConfig);
                        cellConfig = new DGExCellConfig();
                        cellConfig.setHeight(25);
                        cellConfig.setID(groupColumn.getDEFIELDNAME());
                        cellConfig.setItemFormat(StringHelper.Format((String)"<a href='#' title='\u5411\u4e0b\u94bb\u53d6\u660e\u7ec6\u6570\u636e' onclick=\"drilldown({n_%1$s_eq:'%%1$s'});\"><IMG src='../sasrfex/images/default/icon_drilldown2.png' border='0'></A>", (Object)groupColumn.getDEFIELDNAME().toLowerCase()));
                        cellConfig.setWidth(30);
                        cellConfig.setBorder(12);
                        cellConfig.setLastBorder(12);
                        this.dgEx.getDGExConfig().getRootGroupConfig().getGroupContentConfig().getCellsConfig().add((Object)cellConfig);
                        columnConfig = new DGExColumnConfig();
                        columnConfig.setHeight(30);
                        columnConfig.setCaption(groupColumn.getGSRGROUPCOLUMNNAME());
                        columnConfig.setWidth(groupColumn.getWIDTH());
                        columnConfig.setSortField(strGroupField);
                        columnConfig.setBorder(14);
                        this.dgEx.getDGExConfig().getRootGroupConfig().getGroupHeaderConfig().getColumnsConfig().add((Object)columnConfig);
                        cellConfig = new DGExCellConfig();
                        cellConfig.setHeight(25);
                        cellConfig.setID(groupColumn.getDEFIELDNAME());
                        cellConfig.setItemFormat("%1$s");
                        cellConfig.setWidth(groupColumn.getWIDTH());
                        cellConfig.setBorder(12);
                        cellConfig.setLastBorder(12);
                        this.dgEx.getDGExConfig().getRootGroupConfig().getGroupContentConfig().getCellsConfig().add((Object)cellConfig);
                        break;
                    }
                }
                for (GSRMeasure gsrMeasure : this.groupStatisticsRep.getMeasures()) {
                    columnConfig = new DGExColumnConfig();
                    columnConfig.setCaption(gsrMeasure.getGSRMEASURENAME());
                    columnConfig.setWidth(gsrMeasure.getWIDTH());
                    columnConfig.setHeight(30);
                    columnConfig.setSortField(gsrMeasure.getEXPALIAS());
                    columnConfig.setAlign("right");
                    columnConfig.setBorder(14);
                    this.dgEx.getDGExConfig().getRootGroupConfig().getGroupHeaderConfig().getColumnsConfig().add((Object)columnConfig);
                    cellConfig = new DGExCellConfig();
                    cellConfig.setID(gsrMeasure.getEXPALIAS());
                    cellConfig.setHeight(25);
                    cellConfig.setItemFormat(gsrMeasure.getITEMFORMAT());
                    cellConfig.setAlign("right");
                    cellConfig.setWidth(gsrMeasure.getWIDTH());
                    cellConfig.setBorder(12);
                    cellConfig.setLastBorder(12);
                    this.dgEx.getDGExConfig().getRootGroupConfig().getGroupContentConfig().getCellsConfig().add((Object)cellConfig);
                }
                DGExColumnConfig columnConfig3 = new DGExColumnConfig();
                columnConfig3.setCssClass("sx-dg-column2");
                this.dgEx.getDGExConfig().getRootGroupConfig().getGroupHeaderConfig().getColumnsConfig().add((Object)columnConfig3);
                DGExLabelCellConfig cellConfig3 = new DGExLabelCellConfig();
                cellConfig3.setHeight(25);
                this.dgEx.getDGExConfig().getRootGroupConfig().getGroupContentConfig().getCellsConfig().add((Object)cellConfig3);
            }
        }
        this.AddControl((SRFExControl)this.dgEx);
    }

    protected String OnGetDGExConfigId() {
        return "SRFREPORT.DGEX_GSR_DEFAULT";
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetGSPToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = GroupStatisticsRepPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
            if (this.dgEx != null) {
                this.toolbar.setToolbarObject("DGEX", (Object)this.dgEx);
                this.toolbar.setToolbarObject("", (Object)this.dgEx);
            }
            this.toolbar.setToolbarObject("SPEX", (Object)this.spEx);
        }
    }

    protected String OnGetGSPToolbarConfigId() {
        return "SRFREPORT.TB_GSR_DEFAULT";
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

    protected String GetDGExActionHelper() {
        String strDGActionHelper = this.getPageParam("PAGE.DGEXACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strDGActionHelper)) {
            return strDGActionHelper;
        }
        return this.GetDefaultDGExActionHelper();
    }

    protected String GetDefaultDGExActionHelper() {
        return "SA.SRFDA.Report.Ctrl.DGEx.GSRDGExActionHelper";
    }

    public String GetDetailDGPath() {
        return this.strDetailDGUrl;
    }
}

