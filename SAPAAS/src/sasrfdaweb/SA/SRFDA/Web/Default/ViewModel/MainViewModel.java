/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import net.sf.json.JSONObject;

public class MainViewModel
extends PageModel {
    protected ControlModel toolbarModel = new ControlModel();
    protected String strPageCaption = "";
    protected String strPageBigIcon = "";
    protected String strPageIcon = "";
    protected String strPageTitle = "";

    public MainViewModel() {
        this.RegisterCtrlModel("toolbar", this.toolbarModel);
    }

    public ControlModel getToolbarModel() {
        return this.toolbarModel;
    }

    public String getPageCaption() {
        return this.strPageCaption;
    }

    public void setPageCaption(String strPageCaption) {
        this.strPageCaption = strPageCaption;
    }

    public String getPageBigIcon() {
        return this.strPageBigIcon;
    }

    public void setPageBigIcon(String strPageBigIcon) {
        this.strPageBigIcon = strPageBigIcon;
    }

    public String getPageIcon() {
        return this.strPageIcon;
    }

    public void setPageIcon(String strPageIcon) {
        this.strPageIcon = strPageIcon;
    }

    public String getPageTitle() {
        return this.strPageTitle;
    }

    public void setPageTitle(String strPageTitle) {
        this.strPageTitle = strPageTitle;
    }

    @Override
    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        if (!StringHelper.IsNullOrEmpty((String)this.getPageCaption())) {
            jo.put("pagecaption", (Object)this.getPageCaption());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPageBigIcon())) {
            jo.put("pagebigicon", (Object)this.getPageBigIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPageIcon())) {
            jo.put("pageicon", (Object)this.getPageIcon());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getPageTitle())) {
            jo.put("pagetitle", (Object)this.getPageTitle());
        }
    }
}

