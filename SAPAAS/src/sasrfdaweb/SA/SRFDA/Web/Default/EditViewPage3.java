/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Web.Default.BaseEditViewPage;
import SA.SRFDA.Web.Default.ViewModel.EditViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataNavBarJSGear;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import net.sf.json.JSONObject;

public class EditViewPage3
extends BaseEditViewPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExTabView tabView = null;
    protected boolean bSimpleMode = false;
    protected String strToolbarConfigId = "";
    protected String strTabViewConfigId = "";
    private boolean bContainKey = true;
    private JSONObject keyJson = new JSONObject();
    private EditViewModel editViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.ProcessDEIndexMode()) {
            return false;
        }
        if (this.OnGetProcessDEDataWFMode() && !this.ProcessDEDataWFMode()) {
            return false;
        }
        this.bInfoMode = this.OnGetEditViewInfoMode();
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new EditViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.editViewModel = (EditViewModel)this.pageModel;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        this.LoadTabView();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        if (!SRFDAWebCTXHelper.IsNewDataMode((ISRFDAWebContext)this.getWebContext())) {
            String strValue = this.getWebContext().GetParamValue(keyDEFHelper.getName());
            if (SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false)) {
                strValue = this.getWebContext().GetParamValue("SRFDATEMPKEYID");
            } else if (StringHelper.IsNullOrEmpty((String)strValue) && !StringHelper.IsNullOrEmpty((String)(strValue = SRFDAWebCTXHelper.GetDAKey((ISRFDAWebContext)this.getWebContext())))) {
                this.getWebContext().SetParamValue(keyDEFHelper.getName(), strValue);
                this.getWebContext().SetParamValue("SRFDAKEYS", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                this.bContainKey = false;
            } else {
                this.keyJson.put(keyDEFHelper.getName().toLowerCase(), (Object)strValue);
            }
            if (this.bContainKey) {
                this.RegisterUncacheOnReadyScript(3, TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)this.keyJson.toString()));
            }
        }
        DataNavBarJSGear.Load(this, this.tabView, null, keyDEFHelper.getName());
        FormModifyAlertJSGear.Load(this);
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.GetToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = EditViewPage3.CreateToolbar(this, "toolBar", 0.0, 0.0, this.strToolbarConfigId);
        if (this.editViewModel != null && this.editViewModel.getToolbarModel() != null) {
            this.editViewModel.getToolbarModel().setCtrlId("toolBar");
            this.editViewModel.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.editViewModel.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected String GetToolbarConfigId() {
        return this.getDAConfigHelper().GetEditViewToolbarConfigId(this.getDEHelper(), this.page, null, false, this.bInfoMode);
    }

    protected void LoadTabView() {
        this.strTabViewConfigId = this.OnGetTabViewConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strTabViewConfigId)) {
            return;
        }
        this.tabView = EditViewPage3.CreateTabView((SRFDAPage)this, "TabView", 600.0, 0.0, this.strTabViewConfigId);
        if (this.tabView != null) {
            this.tabView.getTabViewConfig().setTopHeader(false);
            this.tabView.getTabViewConfig().setBorder(false);
            this.tabView.getTabViewConfig().setResizeChild(true);
            String strFormName = "";
            if (!this.IsBackEndMode() && !StringHelper.IsNullOrEmpty((String)(strFormName = this.ProcessMultiFormMode()))) {
                TabViewPageConfig tvpConfig = (TabViewPageConfig)this.tabView.getTabViewConfig().getTabViewPages().get(0);
                String strURL = URLHelper.AppendURLSeperator((String)tvpConfig.getRemoteURL());
                strURL = String.valueOf(strURL) + "SRFFormView=" + strFormName;
                tvpConfig.setRemoteURL(strURL);
            }
            this.tabView.getTabViewConfig().setFirstPageOnly(true);
            if (this.editViewModel != null && this.editViewModel.getTabViewModel() != null) {
                TabViewModel tabViewModel = this.editViewModel.getTabViewModel();
                tabViewModel.setCtrlId("tabView");
                tabViewModel.setConfigId(this.strTabViewConfigId);
                tabViewModel.setRemoteCtrlId(this.tabView.getUniqueID());
                tabViewModel.setFormView(strFormName);
            }
        }
    }

    protected String OnGetTabViewConfigId() {
        return this.getDAConfigHelper().GetEditViewTabViewConfigId(this.getDEHelper(), this.page);
    }

    @Override
    protected int OnGetDefaultPageFunc() {
        return 141;
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.editViewModel.setContainKey(this.bContainKey);
        if (this.bContainKey) {
            this.editViewModel.setKeyData(this.keyJson);
        }
        return true;
    }
}

