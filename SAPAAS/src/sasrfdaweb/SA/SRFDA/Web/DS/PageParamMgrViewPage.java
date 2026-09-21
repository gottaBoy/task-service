/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.PageParamFolder
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.DS;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.net.URLEncoder;
import java.util.TreeMap;
import java.util.Vector;

public class PageParamMgrViewPage
extends BaseMainPage {
    public static final String TAG_PAGETREENAME = "PAGE.TREENAME";
    public static final String TAG_PAGETITLEBARVISIBLE = "PAGE.TITLEBAR.VISIBLE";
    public static final String TAG_PAGEACTIVEFOLDER = "PAGE.ACTIVEFOLDER";
    public static final String TAG_PAGETREEUPDATEPATH = "PAGE.TREEUPDATEPATH";
    protected SRFExTabView tabView = null;
    protected SRFExTreePanel treePanel = null;
    protected TreeMap<String, String> outputSectors = new TreeMap();
    protected String strPageTemplId = "";
    protected String strPageId = "";
    protected Vector<PageParamFolder> pageParamFolders = new Vector();
    protected String strActiveFolder = "";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageTemplId = this.getWebContext().GetParamValue("PAGETEMPLID");
        this.strPageId = this.getWebContext().GetParamValue("PAGEID");
        if (StringHelper.IsNullOrEmpty((String)this.strPageTemplId) || StringHelper.IsNullOrEmpty((String)this.strPageId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u4f20\u5165\u9875\u9762\u7f16\u53f7\u6216\u9875\u9762\u6a21\u677f\u7f16\u53f7"));
            return false;
        }
        IDEDataCtrl paramFolderDataCtrl = this.GetDEDataCtrl("DE0059");
        if (paramFolderDataCtrl == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0059"));
            return false;
        }
        BaseDataEntity conds = new BaseDataEntity();
        conds.SetParamValue("PAGETEMPLID", (Object)this.strPageTemplId);
        CallResult callResult = paramFolderDataCtrl.Select("SELECTBYPAGETEMPL", conds, this.pageParamFolders, PageParamFolder.class.getName());
        if (callResult.IsError()) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0059"));
            return false;
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadTabView();
    }

    @Override
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
        this.treePanel = PageParamMgrViewPage.CreateTreePanel(this, "treePanel", 200.0, 200.0, "SRFDEFAULT.TV_DEFAULT");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.OnFillPageParamTreeConfig(this.treePanel);
            this.treePanel.getTreePanelConfig().setSelectedValue(this.strActiveFolder);
        }
    }

    protected void OnFillPageParamTreeConfig(SRFExTreePanel treePanel) {
        PageParamFolder rootPageParamFolder = null;
        for (PageParamFolder paramFolder : this.pageParamFolders) {
            if (!StringHelper.IsNullOrEmpty((String)paramFolder.getPPAGEPARAMFOLDERID())) continue;
            rootPageParamFolder = paramFolder;
            break;
        }
        if (rootPageParamFolder == null) {
            this.PageLog(this, 1, "\u65e0\u6cd5\u627e\u5230\u53c2\u6570\u6839\u8282\u70b9");
            return;
        }
        treePanel.getTreePanelConfig().getRootNodeConfig().setID(rootPageParamFolder.getPAGEPARAMFOLDERID());
        treePanel.getTreePanelConfig().getRootNodeConfig().setText(rootPageParamFolder.getPAGEPARAMFOLDERNAME());
        String strIconCls = rootPageParamFolder.GetParamStringValue("ICONCLS", "");
        if (!StringHelper.IsNullOrEmpty((String)strIconCls)) {
            treePanel.getTreePanelConfig().getRootNodeConfig().setIconCssClass(strIconCls);
        }
        this.strActiveFolder = rootPageParamFolder.getPAGEPARAMFOLDERID();
        this.OnFillTreeNodeConfig(treePanel.getTreePanelConfig().getRootNodeConfig(), rootPageParamFolder);
    }

    protected void OnFillTreeNodeConfig(TreeNodeConfig nodeConfig, PageParamFolder pPageParamFolder) {
        Vector<PageParamFolder> childItems = new Vector<PageParamFolder>();
        for (PageParamFolder pageParamFolder : this.pageParamFolders) {
            if (StringHelper.Compare((String)pageParamFolder.getPPAGEPARAMFOLDERID(), (String)pPageParamFolder.getPAGEPARAMFOLDERID(), (boolean)true) != 0) continue;
            childItems.add(pageParamFolder);
        }
        if (childItems.size() == 0) {
            return;
        }
        int nCount = childItems.size();
        int i = 0;
        while (i < nCount) {
            PageParamFolder pageParamFolder = (PageParamFolder)childItems.get(0);
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            treeNodeConfig.setText(pageParamFolder.getPAGEPARAMFOLDERNAME());
            treeNodeConfig.setID(pageParamFolder.getPAGEPARAMFOLDERID());
            String strIconCls = pageParamFolder.GetParamStringValue("ICONCLS", "");
            if (!StringHelper.IsNullOrEmpty((String)strIconCls)) {
                treeNodeConfig.setIconCssClass(strIconCls);
            }
            nodeConfig.AddChildNode(treeNodeConfig);
            this.OnFillTreeNodeConfig(treeNodeConfig, pageParamFolder);
            ++i;
        }
        nodeConfig.setExpand(true);
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
        try {
            Page editPage = this.getDAModelStorage().FindPage("PAGE_DE0066_E001");
            if (editPage == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)"PAGE_DE0066_E001"));
                return;
            }
            String strIfGridViewPath = "../srfpage/ifgridview.jsp?REALURL=%1$s";
            String strEditPath = editPage.GetTotalPagePath();
            strEditPath = URLHelper.AppendURLSeperator((String)strEditPath);
            for (PageParamFolder pageParamFolder : this.pageParamFolders) {
                TabViewPageConfig tvpConfig = new TabViewPageConfig();
                tvpConfig.setID(pageParamFolder.getPAGEPARAMFOLDERID());
                tvpConfig.setResourceId("NONE");
                String strLink = String.valueOf(strEditPath) + StringHelper.Format((String)"PAGETYPE=%3$s&PAGEPARAMID=%1$s_%2$s&CTRLID=%4$s&PAGEID=%1$s", (Object)this.strPageId, (Object)pageParamFolder.getPAGEPARAMFOLDERID(), (Object)pageParamFolder.getPAGEPARAMTYPEID(), (Object)pageParamFolder.getCTRLID());
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strLink, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void LoadTabView() {
        TabViewConfig tabViewConfig = new TabViewConfig();
        tabViewConfig.setTopHeader(false);
        tabViewConfig.setBorder(false);
        tabViewConfig.setResizeChild(true);
        this.OnFillTabViewConfig(tabViewConfig);
        tabViewConfig.ActiveTabViewPage(this.strActiveFolder);
        this.tabView = PageParamMgrViewPage.CreateTabView((SRFDAPage)this, "TabView", 600.0, 0.0, tabViewConfig);
    }

    public String GetTreeName() {
        return "\u9875\u9762\u53c2\u6570";
    }

    public boolean IsShowTitleBar() {
        return this.getPageParam(TAG_PAGETITLEBARVISIBLE, false);
    }
}

