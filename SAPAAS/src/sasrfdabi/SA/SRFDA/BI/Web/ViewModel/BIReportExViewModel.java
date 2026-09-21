/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFDA.Web.ViewModel.SearchFormModel
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.BI.Web.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFDA.Web.ViewModel.SearchFormModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class BIReportExViewModel
extends MainViewModel {
    protected SearchFormModel searchFormModel = new SearchFormModel();
    protected SPExModel spExModel = new SPExModel();
    protected String strReportTypeCodeList = "";
    protected String strDefaultReportType = "";
    protected String strReportDesc = "";
    protected JSONObject reportModel = null;

    public BIReportExViewModel() {
        this.RegisterCtrlModel("spex", (ControlModel)this.spExModel);
        this.RegisterCtrlModel("searchform", (ControlModel)this.searchFormModel);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getReportTypeCodeList())) {
            jo.put("reporttypecodelist", (Object)this.getReportTypeCodeList());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getDefaultReportType())) {
            jo.put("defaultreporttype", (Object)this.getDefaultReportType());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getReportDesc())) {
            jo.put("reportdesc", (Object)this.getReportDesc());
        }
        if (this.getReportModel() != null) {
            jo.put("reportmodel", (Object)this.getReportModel());
        }
    }

    public SPExModel getSPExModel() {
        return this.spExModel;
    }

    public SearchFormModel getSearchFormModel() {
        return this.searchFormModel;
    }

    public String getReportTypeCodeList() {
        return this.strReportTypeCodeList;
    }

    public void setReportTypeCodeList(String strReportTypeCodeList) {
        this.strReportTypeCodeList = strReportTypeCodeList;
    }

    public String getDefaultReportType() {
        return this.strDefaultReportType;
    }

    public void setDefaultReportType(String strDefaultReportType) {
        this.strDefaultReportType = strDefaultReportType;
    }

    public String getReportDesc() {
        return this.strReportDesc;
    }

    public void setReportDesc(String strReportDesc) {
        this.strReportDesc = strReportDesc;
    }

    public JSONObject getReportModel() {
        return this.reportModel;
    }

    public void setReportModel(JSONObject reportModel) {
        this.reportModel = reportModel;
    }
}

