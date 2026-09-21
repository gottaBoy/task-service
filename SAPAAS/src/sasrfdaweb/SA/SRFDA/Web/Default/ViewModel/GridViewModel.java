/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.BaseGridViewModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFDA.Web.ViewModel.SearchFormModel;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.sf.json.JSONObject;

public class GridViewModel
extends BaseGridViewModel {
    protected SPExModel spExModel = new SPExModel();
    protected SearchFormModel searchFormModel = new SearchFormModel();
    protected boolean bPickupMode = false;
    protected String strDGMode = "";
    protected String strGridViewId = "";
    protected boolean bCustomSummaryArea = true;
    protected String strSummaryArea = "";
    protected boolean bGridViewTheme = true;
    protected boolean bCustomTheme = true;
    protected boolean bSPExpand = false;
    protected String strSummaryPage = "";
    protected boolean bDGAutoLoad = true;
    protected boolean bQuickSearch = true;
    protected boolean bDGEditDefault = false;
    protected boolean bRowActionList = true;
    protected Vector themeList = null;
    protected Vector summaryList = null;
    protected JSONObject newDataConfig = null;
    protected JSONObject editDataConfig = null;
    protected String strQuickSearchMask = "";
    protected int nSummaryWidth = 0;
    protected int nSummaryHeight = 0;

    public GridViewModel() {
        this.RegisterCtrlModel("spex", this.spExModel);
        this.RegisterCtrlModel("searchform", this.searchFormModel);
    }

    public SPExModel getSPExModel() {
        return this.spExModel;
    }

    public SearchFormModel getSearchFormModel() {
        return this.searchFormModel;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("pickupmode", this.getPickupMode());
        jo.put("dgmode", (Object)this.getDGMode());
        jo.put("gridviewid", (Object)this.getGridViewId());
        jo.put("customsummaryarea", this.getCustomSummaryArea());
        if (!StringHelper.IsNullOrEmpty((String)this.getSummaryArea())) {
            jo.put("summaryarea", (Object)this.getSummaryArea());
            if (this.getSummaryHeight() > 0) {
                jo.put("summaryheight", this.getSummaryHeight());
            }
            if (this.getSummaryWidth() > 0) {
                jo.put("summarywidth", this.getSummaryWidth());
            }
        }
        jo.put("rowactionlist", this.getRowActionList());
        jo.put("gridviewtheme", this.getGridViewTheme());
        jo.put("customtheme", this.getCustomTheme());
        jo.put("spautoexpand", this.getSPExpand());
        jo.put("dgautoload", this.getDGAutoLoad());
        jo.put("dgeditdefault", this.getDGEditDefault());
        jo.put("quicksearch", this.getQuickSearch());
        if (!StringHelper.IsNullOrEmpty((String)this.getQuickSearchMask())) {
            jo.put("quicksearchmask", (Object)this.getQuickSearchMask());
        }
        if (this.themeList != null) {
            jo.put("datagridthemes", (Object)this.themeList.toArray());
        }
        if (this.getSummaryList() != null) {
            jo.put("summarylist", (Object)this.getSummaryList().toArray());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getSummaryPage())) {
            jo.put("summarypage", (Object)this.getSummaryPage());
        }
        if (this.getNewDataConfig() != null) {
            jo.put("newdata", (Object)this.getNewDataConfig());
        }
        if (this.getEditDataConfig() != null) {
            jo.put("editdata", (Object)this.getEditDataConfig());
        }
    }

    public boolean getPickupMode() {
        return this.bPickupMode;
    }

    public void setPickupMode(boolean bPickupMode) {
        this.bPickupMode = bPickupMode;
    }

    public String getDGMode() {
        return this.strDGMode;
    }

    public void setDGMode(String strDGMode) {
        this.strDGMode = strDGMode;
    }

    public String getGridViewId() {
        return this.strGridViewId;
    }

    public void setGridViewId(String strGridViewId) {
        this.strGridViewId = strGridViewId;
    }

    public boolean getRowActionList() {
        return this.bRowActionList;
    }

    public void setRowActionList(boolean bRowActionList) {
        this.bRowActionList = bRowActionList;
    }

    public boolean getCustomSummaryArea() {
        return this.bCustomSummaryArea;
    }

    public void setCustomSummaryArea(boolean bCustomSummaryArea) {
        this.bCustomSummaryArea = bCustomSummaryArea;
    }

    public String getSummaryArea() {
        return this.strSummaryArea;
    }

    public void setSummaryArea(String strSummaryArea) {
        this.strSummaryArea = strSummaryArea;
    }

    public boolean getGridViewTheme() {
        return this.bGridViewTheme;
    }

    public void setGridViewTheme(boolean bGridViewTheme) {
        this.bGridViewTheme = bGridViewTheme;
    }

    public boolean getCustomTheme() {
        return this.bCustomTheme;
    }

    public void setCustomTheme(boolean bCustomTheme) {
        this.bCustomTheme = bCustomTheme;
    }

    public boolean getSPExpand() {
        return this.bSPExpand;
    }

    public void setSPExpand(boolean bSPExpand) {
        this.bSPExpand = bSPExpand;
    }

    public String getSummaryPage() {
        return this.strSummaryPage;
    }

    public void setSummaryPage(String strSummaryPage) {
        this.strSummaryPage = strSummaryPage;
    }

    public Vector getThemeList() {
        return this.themeList;
    }

    public void setThemeList(Vector themeList) {
        this.themeList = themeList;
    }

    public JSONObject getNewDataConfig() {
        return this.newDataConfig;
    }

    public void setNewDataConfig(JSONObject newDataConfig) {
        this.newDataConfig = newDataConfig;
    }

    public JSONObject getEditDataConfig() {
        return this.editDataConfig;
    }

    public void setEditDataConfig(JSONObject editDataConfig) {
        this.editDataConfig = editDataConfig;
    }

    public Vector getSummaryList() {
        return this.summaryList;
    }

    public void setSummaryList(Vector summaryList) {
        this.summaryList = summaryList;
    }

    public boolean getDGAutoLoad() {
        return this.bDGAutoLoad;
    }

    public void setDGAutoLoad(boolean bDGAutoLoad) {
        this.bDGAutoLoad = bDGAutoLoad;
    }

    public boolean getQuickSearch() {
        return this.bQuickSearch;
    }

    public void setQuickSearch(boolean bQuickSearch) {
        this.bQuickSearch = bQuickSearch;
    }

    public String getQuickSearchMask() {
        return this.strQuickSearchMask;
    }

    public void setQuickSearchMask(String strQuickSearchMask) {
        this.strQuickSearchMask = strQuickSearchMask;
    }

    public boolean getDGEditDefault() {
        return this.bDGEditDefault;
    }

    public void setDGEditDefault(boolean bDGEditDefault) {
        this.bDGEditDefault = bDGEditDefault;
    }

    public int getSummaryWidth() {
        return this.nSummaryWidth;
    }

    public void setSummaryWidth(int nSummaryWidth) {
        this.nSummaryWidth = nSummaryWidth;
    }

    public int getSummaryHeight() {
        return this.nSummaryHeight;
    }

    public void setSummaryHeight(int nSummaryHeight) {
        this.nSummaryHeight = nSummaryHeight;
    }
}

