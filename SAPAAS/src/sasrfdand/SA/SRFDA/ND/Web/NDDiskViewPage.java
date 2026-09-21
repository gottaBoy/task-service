/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.ND.Web.ViewModel.NDDiskViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import net.sf.json.JSONObject;

public class NDDiskViewPage
extends BaseMainPage {
    protected SRFExTabView tabView = null;
    protected SRFExTreePanel treePanel = null;
    protected NDDisk ndDisk = null;
    private static String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
    protected NDDiskViewModel ndDiskViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "ND0011";
        return this.LoadPageDataEntity();
    }

    protected NDDisk getNDDisk() throws Exception {
        if (this.ndDisk != null) {
            return this.ndDisk;
        }
        this.ndDisk = this.OnGetNDDisk();
        return this.ndDisk;
    }

    protected NDDisk OnGetNDDisk() throws Exception {
        String strNDDiskId = SRFDANDWebCTXHelper.GetNDDiskId((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strNDDiskId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7f51\u7edc\u78c1\u76d8\u6807\u8bc6");
        }
        NDDisk ndDisk = new NDDisk();
        ndDisk.setNDDISKID(strNDDiskId);
        IDEDataCtrl ndDiskDataCtrl = this.GetDEDataCtrl("ND0011");
        CallResult callResult = ndDiskDataCtrl.Get((BaseDataEntity)ndDisk);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7edc\u78c1\u76d8[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strNDDiskId, (Object)callResult.getErrorInfo()));
        }
        return ndDisk;
    }

    protected PageModel CreatePageModel() {
        return new NDDiskViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.ndDiskViewModel = (NDDiskViewModel)this.pageModel;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadTabView();
    }

    protected void OnInit() {
        super.OnInit();
    }

    protected void LoadTreePanel() {
        this.treePanel = NDDiskViewPage.CreateTreePanel((SRFDAPage)this, (String)"treePanel", (double)200.0, (double)200.0, (String)"SRFND.TV_DISK");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillTreeMenuConfig(this.treePanel);
            this.treePanel.getTreePanelConfig().setSelectedValue("INBOX");
        }
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnAfterFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
    }

    protected String GetNDFolderPagePath(String strMsgFolder) {
        return "../srfnd/ndfolderview.jsp";
    }

    protected void LoadTabView() {
        TabViewConfig tabViewConfig = new TabViewConfig();
        tabViewConfig.setTopHeader(false);
        tabViewConfig.setBorder(false);
        tabViewConfig.setResizeChild(true);
        this.OnFillTabViewConfig(tabViewConfig);
        tabViewConfig.ActiveTabViewPage("INBOX");
        this.tabView = NDDiskViewPage.CreateTabView((SRFDAPage)this, (String)"TabView", (double)600.0, (double)0.0, (TabViewConfig)tabViewConfig);
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        try {
            this.ndDiskViewModel.setNDDiskId(this.getNDDisk().getNDDISKID());
            this.ndDiskViewModel.setNDDiskName(this.getNDDisk().getNDDISKNAME());
            String strFolderBrowserViewUrl = StringHelper.Format((String)"../srfpage/treepickupview.jsp?SRFPAGEID=PAGE_ND0010_P002&SRFDANDDISKID=%1$s", (Object)this.getNDDisk().getNDDISKID());
            this.ndDiskViewModel.setFolderBrowserViewUrl(strFolderBrowserViewUrl);
        }
        catch (Exception e) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u8bbe\u7f6e\u754c\u9762\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), e);
            return false;
        }
        this.ndDiskViewModel.getTabViewModel().setConfigId("SRFND.TABVIEW_DISK");
        this.ndDiskViewModel.getTreePanelModel().setConfigId("SRFND.TV_DISK");
        return true;
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.NDDISKVIEW", "\u7f51\u7edc\u78c1\u76d8");
    }
}

