/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.WF.Web.ViewModel.WFBaseTreeGridViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class WFBaseTreeGridViewPage
extends BaseMainPage {
    public static final String TAG_PAGEWFTREECONFIG = "PAGE.WFTREECONFIG";
    public static final String TAG_PAGEWFGRIDVIEW = "PAGE.WFGRIDVIEW";
    public static final String TAG_PAGEGRIDVIEW = "PAGE.GRIDVIEW";
    public static final String TAG_PAGESECTOR = "PAGE.SECTOR";
    public static final String TAG_PAGESECTORNAME = "PAGE.SECTOR.NAME";
    public static final String TAG_PAGESECTORPAGE = "PAGE.SECTOR.PAGE";
    protected SRFExTabView tabView = null;
    protected SRFExTreePanel treePanel = null;
    protected String strActiveWFFolder = "";
    protected DEWF dewf = null;
    protected TreeMap<String, String> outputSectors = new TreeMap();
    protected WFBaseTreeGridViewModel wfBaseTreeGridViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.getDEHelper().IsEnableWF()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41", (Object)this.getDEHelper().GetFullName()));
            return false;
        }
        this.dewf = this.getDEHelper().GetDEWF();
        if (!this.LoadWFConfig()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u52a0\u8f7d\u5de5\u4f5c\u6d41\u76f8\u5173\u4fe1\u606f\u5931\u8d25"));
            return false;
        }
        return true;
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.wfBaseTreeGridViewModel = (WFBaseTreeGridViewModel)this.pageModel;
    }

    protected boolean LoadWFConfig() {
        return this.OnLoadWFConfig();
    }

    protected boolean OnLoadWFConfig() {
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadTabView();
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null)return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(node == $P.tree['%1$s'].getRootNode()) return;\r\n", (Object)this.treePanel.getUniqueID());
        if (this.tabView != null) {
            script.Append(TabViewJSHelper.getShowTabPageScript2((String)this.tabView.getUniqueID(), (String)"node.id"));
        }
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
    }

    protected void LoadTreePanel() {
        String strTreePanelConfigId = this.getPageParam(TAG_PAGEWFTREECONFIG, "SRFWF.TV_WFTREE2");
        if (StringHelper.IsNullOrEmpty((String)strTreePanelConfigId)) {
            return;
        }
        this.treePanel = WFBaseTreeGridViewPage.CreateTreePanel((SRFDAPage)this, (String)"treePanel", (double)200.0, (double)200.0, (String)strTreePanelConfigId);
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillTreeMenuConfig(this.treePanel);
            this.OnAfterFillTreeMenuConfig(this.treePanel);
            this.treePanel.getTreePanelConfig().setSelectedValue(this.strActiveWFFolder);
        }
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel, String strGroup) {
    }

    protected void OnAfterFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig, String strGroup) {
    }

    protected void LoadTabView() {
        TabViewConfig tabViewConfig = new TabViewConfig();
        tabViewConfig.setTopHeader(false);
        tabViewConfig.setBorder(false);
        tabViewConfig.setResizeChild(true);
        this.OnFillTabViewConfig(tabViewConfig);
        tabViewConfig.ActiveTabViewPage(this.strActiveWFFolder);
        this.tabView = WFBaseTreeGridViewPage.CreateTabView((SRFDAPage)this, (String)"TabView", (double)600.0, (double)0.0, (TabViewConfig)tabViewConfig);
    }

    public String GetUpdateCode() {
        return "";
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.wfBaseTreeGridViewModel.getTreePanelModel().setActiveNode(this.strActiveWFFolder);
        return true;
    }
}

