/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.PP.PPMenuTreeBar
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.MainMenuExConfig
 *  SA.SRFramework.WebEx.UI.MenuExConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  SA.SRFramework.WebEx.UI.TabViewConfig
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.Data.PP.PPMenuTreeBar;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.MenuTreeGridViewModel;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class MenuTreeGridViewPage
extends BaseMainPage {
    public static final String TAG_PAGELEFTMENUTREE = "PAGE.LEFTMENUTREE";
    public static final String TAG_PAGETREENAME = "PAGE.TREENAME";
    public static final String TAG_PAGETITLEBARVISIBLE = "PAGE.TITLEBAR.VISIBLE";
    public static final String TAG_PAGEACTIVEFOLDER = "PAGE.ACTIVEFOLDER";
    public static final String TAG_PAGETREEUPDATEPATH = "PAGE.TREEUPDATEPATH";
    protected SRFExTabView tabView = null;
    protected SRFExTreePanel treePanel = null;
    protected String strActiveFolder = "";
    protected MenuExConfig curMenuExConfig = null;
    protected TreeMap<String, String> outputSectors = new TreeMap();
    protected int nTreeNodeIndex = 99;
    protected TreeMap<String, JSONObject> updateTreeNodeMap = new TreeMap();
    protected String strMainMenuId = "";
    public static final String PPCTRLID_LEFTMENUBAR = "LEFTMENUBAR";
    private PPMenuTreeBar ppMenuTreeBar = null;
    protected String strMenuMode = "";
    protected MenuTreeGridViewModel menuTreeGirdViewModel = null;

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strMenuMode = this.OnGetMenuMode();
        if (StringHelper.IsNullOrEmpty((String)this.strMenuMode)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u83dc\u5355\u6811\u7684\u83dc\u5355\u6a21\u5f0f"));
            return false;
        }
        this.strMainMenuId = this.getDAConfigHelper().GetMainMenuExConfigId(this.getWebContext(), this.strMenuMode);
        if (StringHelper.IsNullOrEmpty((String)this.strMainMenuId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u83dc\u5355\u6a21\u5f0f[%1$s]\u5bf9\u5e94\u7684\u914d\u7f6e", (Object)this.strMenuMode));
            return false;
        }
        this.curMenuExConfig = this.getWebContext().getMenuExMgr().GetMenuExConfig(this.strMainMenuId);
        if (this.curMenuExConfig == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u83dc\u5355\u6a21\u5f0f[%1$s]\u5bf9\u5e94\u7684\u914d\u7f6e", (Object)this.strMenuMode));
            return false;
        }
        if (this.curMenuExConfig.getMainMenus().size() < 1) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83dc\u5355\u4e0d\u5305\u62ec\u4efb\u4f55\u5b50\u9879"));
            return false;
        }
        this.strActiveFolder = this.OnGetActiveFolder();
        return true;
    }

    @Override
    protected PageModel CreatePageModel() {
        return new MenuTreeGridViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.menuTreeGirdViewModel = (MenuTreeGridViewModel)this.pageModel;
    }

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_LEFTMENUBAR, "PP_MENUTREEBAR")) != null && pageParam instanceof PPMenuTreeBar) {
            this.ppMenuTreeBar = (PPMenuTreeBar)pageParam;
        }
    }

    protected String OnGetActiveFolder() {
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getACTIVEFOLDER();
        }
        return this.getPageParam(TAG_PAGEACTIVEFOLDER, strParamValue);
    }

    protected String OnGetMenuMode() {
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getMENUMODE();
        }
        return this.getPageParam(TAG_PAGELEFTMENUTREE, strParamValue);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadTabView();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        if (this.updateTreeNodeMap.size() > 0) {
            String strTreeUpdatePath = this.OnGetTreeUpdatePath();
            if (StringHelper.IsNullOrEmpty((String)strTreeUpdatePath)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u5b58\u5728\u9700\u8981\u66f4\u65b0\u7684\u6811\u8282\u70b9\uff0c\u4f46\u6ca1\u6709\u6307\u5b9a\u66f4\u65b0\u8def\u5f84"));
            } else {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("function updatetree(_1){\r\n");
                script.Append("var tree=$P.tree['%1$s'];\r\n", (Object)this.treePanel.getUniqueID());
                script.Append("if(!tree)return;\r\n");
                script.Append("var cnt='';\r\n");
                script.Append("var text='';\r\n");
                script.Append("var treeNode=null;\r\n");
                for (String strKey : this.updateTreeNodeMap.keySet()) {
                    JSONObject jsonObject = this.updateTreeNodeMap.get(strKey);
                    script.Append("cnt = $V(_1['%1$s'],'');\r\n", (Object)strKey);
                    String strNodeId = jsonObject.getString("id");
                    script.Append("treeNode=tree.getNodeById('%1$s');if(treeNode!=null){treeNode.setText(gettreenodetext('%2$s',cnt));}\r\n", (Object)strNodeId, (Object)jsonObject.getString("caption"));
                }
                script.Append("}");
                script.Append("function refreshwftree(){\r\n");
                script.Append("var varUpdate = new Ext.UpdateManager(\"update\");\r\n");
                script.Append("varUpdate.update({url:'%1$s',scripts:true,nocache:true});\r\n", (Object)strTreeUpdatePath);
                script.Append("}");
                this.RegisterScript(1, script.toString());
            }
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null)return;\r\n", (Object)this.treePanel.getUniqueID());
        script.Append("if(node==$P.tree['%1$s'].getRootNode())return;\r\n", (Object)this.treePanel.getUniqueID());
        if (this.tabView != null) {
            script.Append(TabViewJSHelper.getShowTabPageScript2((String)this.tabView.getUniqueID(), (String)"node.id"));
        }
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
    }

    protected String OnGetTreeUpdatePath() {
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getTREEUPDATEPATH();
        }
        return this.getPageParam(TAG_PAGETREEUPDATEPATH, strParamValue);
    }

    protected void LoadTreePanel() {
        this.treePanel = MenuTreeGridViewPage.CreateTreePanel(this, "treePanel", 200.0, 200.0, "SRFDEFAULT.TV_DEFAULT2");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setAsyncMode(false);
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.nTreeNodeIndex = 99;
            this.OnFillTreeMenuConfig(this.treePanel);
            this.OnAfterFillTreeMenuConfig(this.treePanel);
            this.treePanel.getTreePanelConfig().setSelectedValue(this.strActiveFolder);
            if (this.menuTreeGirdViewModel != null) {
                this.menuTreeGirdViewModel.getTreePanelModel().setConfigId("SRFDEFAULT.TV_DEFAULT2");
                this.menuTreeGirdViewModel.getTreePanelModel().setRemoteCtrlId(this.treePanel.getUniqueID());
                this.menuTreeGirdViewModel.getTreePanelModel().setShowRoot(this.treePanel.getTreePanelConfig().isRootVisible());
                this.menuTreeGirdViewModel.getTreePanelModel().setActiveNode(this.strActiveFolder);
                this.menuTreeGirdViewModel.getTreePanelModel().setCounterPath(this.OnGetTreeUpdatePath());
            }
        }
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel) {
        String strUpdateId;
        MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
        treePanel.getTreePanelConfig().getRootNodeConfig().setText(mainMenuExConfig.getCaption());
        if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getIconCls())) {
            treePanel.getTreePanelConfig().getRootNodeConfig().setIconCssClass(mainMenuExConfig.getIconCls());
        }
        if (StringHelper.Length((String)mainMenuExConfig.getPagePath()) != 0 && StringHelper.IsNullOrEmpty((String)this.strActiveFolder)) {
            this.strActiveFolder = "root";
        }
        if (!StringHelper.IsNullOrEmpty((String)(strUpdateId = mainMenuExConfig.GetExtValue("UPDATEID", "")))) {
            JSONObject obj = new JSONObject();
            obj.put("id", (Object)"root");
            obj.put("caption", (Object)mainMenuExConfig.getCaption());
            this.updateTreeNodeMap.put(strUpdateId.toLowerCase(), obj);
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
        this.OnFillTreeNodeConfig(treePanel.getTreePanelConfig().getRootNodeConfig(), mainMenuExConfig.getChildMenuItems(), iUserPrivilegeMgr);
    }

    protected void OnFillTreeNodeConfig(TreeNodeConfig nodeConfig, ArrayList childMenuItems, IUserPrivilegeMgr iUserPrivilegeMgr) {
        if (childMenuItems == null) {
            return;
        }
        int nCount = childMenuItems.size();
        int i = 0;
        while (i < nCount) {
            ++this.nTreeNodeIndex;
            MenuItemExConfig menuItemExConfig = (MenuItemExConfig)childMenuItems.get(i);
            String strResourceId = menuItemExConfig.getResourceId();
            if (!(iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(this.webContext, strResourceId) || StringHelper.Length((String)menuItemExConfig.getCaption()) == 0 && StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) == 0)) {
                String strUpdateId;
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setText(menuItemExConfig.getCaption());
                treeNodeConfig.setID(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex));
                if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getIconCls())) {
                    treeNodeConfig.setIconCssClass(menuItemExConfig.getIconCls());
                }
                if (StringHelper.Length((String)menuItemExConfig.getPagePath()) != 0 && StringHelper.IsNullOrEmpty((String)this.strActiveFolder)) {
                    this.strActiveFolder = treeNodeConfig.getID();
                }
                if (!StringHelper.IsNullOrEmpty((String)(strUpdateId = menuItemExConfig.GetExtValue("UPDATEID", "")))) {
                    JSONObject obj = new JSONObject();
                    obj.put("id", (Object)treeNodeConfig.getID());
                    obj.put("caption", (Object)menuItemExConfig.getCaption());
                    this.updateTreeNodeMap.put(strUpdateId.toLowerCase(), obj);
                }
                nodeConfig.AddChildNode(treeNodeConfig);
                this.OnFillTreeNodeConfig(treeNodeConfig, menuItemExConfig.getChildMenuItems(), iUserPrivilegeMgr);
            }
            ++i;
        }
        nodeConfig.setExpand(true);
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel, String strGroup) {
    }

    protected void OnAfterFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig) {
        try {
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
            MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
            String strLink = mainMenuExConfig.getPagePath();
            if (StringHelper.Length((String)strLink) != 0 && (strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                strLink = ".." + strLink;
            }
            if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getAppendParams())) {
                    strLink = URLHelper.AppendURLSeperator((String)strLink);
                    strLink = String.valueOf(strLink) + mainMenuExConfig.getAppendParams();
                }
                TabViewPageConfig tvpConfig = new TabViewPageConfig();
                tvpConfig.setID("root");
                tvpConfig.setResourceId("NONE");
                tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strLink, "UTF-8")));
                tabViewConfig.AddTabPage(tvpConfig);
            }
            this.OnFillTabViewConfig(tabViewConfig, strIfGridViewPath, mainMenuExConfig.getChildMenuItems(), iUserPrivilegeMgr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void OnFillTabViewConfig(TabViewConfig tabViewConfig, String strIfGridViewPath, ArrayList childMenuItems, IUserPrivilegeMgr iUserPrivilegeMgr) {
        try {
            if (childMenuItems == null) {
                return;
            }
            int nCount = childMenuItems.size();
            int i = 0;
            while (i < nCount) {
                ++this.nTreeNodeIndex;
                MenuItemExConfig menuItemExConfig = (MenuItemExConfig)childMenuItems.get(i);
                String strResourceId = menuItemExConfig.getResourceId();
                if (!(iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(this.webContext, strResourceId) || StringHelper.Length((String)menuItemExConfig.getCaption()) == 0 && StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) == 0)) {
                    String strLink = menuItemExConfig.getPagePath();
                    if (StringHelper.Length((String)strLink) != 0 && (strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                        strLink = ".." + strLink;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                        if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getAppendParams())) {
                            strLink = URLHelper.AppendURLSeperator((String)strLink);
                            strLink = String.valueOf(strLink) + menuItemExConfig.getAppendParams();
                        }
                        TabViewPageConfig tvpConfig = new TabViewPageConfig();
                        tvpConfig.setID(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex));
                        tvpConfig.setResourceId("NONE");
                        tvpConfig.setRemoteURL(StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strLink, "UTF-8")));
                        tabViewConfig.AddTabPage(tvpConfig);
                    }
                    this.OnFillTabViewConfig(tabViewConfig, strIfGridViewPath, menuItemExConfig.getChildMenuItems(), iUserPrivilegeMgr);
                }
                ++i;
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
        this.nTreeNodeIndex = 99;
        this.OnFillTabViewConfig(tabViewConfig);
        tabViewConfig.ActiveTabViewPage(this.strActiveFolder);
        this.tabView = MenuTreeGridViewPage.CreateTabView((SRFDAPage)this, "TabView", 600.0, 0.0, tabViewConfig);
    }

    public String GetUpdateCode() {
        String strTreeUpdatePath = this.OnGetTreeUpdatePath();
        if (!StringHelper.IsNullOrEmpty((String)strTreeUpdatePath)) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var varUpdate=new Ext.UpdateManager(\"update\");\r\n");
            script.Append("varUpdate.startAutoRefresh(60,{url:'%1$s',scripts:true,nocache:true},null,null,true);\r\n", (Object)strTreeUpdatePath);
            return script.toString();
        }
        return "";
    }

    public String GetTreeName() {
        String strTreeName;
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getTREENAME();
        }
        if (!StringHelper.IsNullOrEmpty((String)(strTreeName = this.getPageParam(TAG_PAGETREENAME, strParamValue)))) {
            return strTreeName;
        }
        MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
        return mainMenuExConfig.getCaption();
    }

    public boolean IsShowTitleBar() {
        boolean bParamValue = false;
        if (this.ppMenuTreeBar != null && this.ppMenuTreeBar.ContainesParam("SHOWTITLEBAR")) {
            bParamValue = this.ppMenuTreeBar.getSHOWTITLEBAR();
        }
        return this.getPageParam(TAG_PAGETITLEBARVISIBLE, bParamValue);
    }

    protected void OnFillTabViewModel(XMLNode tabViewConfig) {
        try {
            MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
            String strIfGridViewPath = "../srfpage/ifgridview2.jsp?REALURL=%1$s";
            String strLink = mainMenuExConfig.getPagePath();
            if (StringHelper.Length((String)strLink) != 0 && (strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                strLink = ".." + strLink;
            }
            if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getAppendParams())) {
                    strLink = URLHelper.AppendURLSeperator((String)strLink);
                    strLink = String.valueOf(strLink) + mainMenuExConfig.getAppendParams();
                }
                XMLNode tvpConfig = new XMLNode();
                tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                tvpConfig.setID("root");
                tvpConfig.SetValue("RESOURCEID", "NONE");
                tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strLink, "UTF-8")));
                tabViewConfig.AddNode(tvpConfig);
            }
            this.OnFillTabViewModel(tabViewConfig, strIfGridViewPath, mainMenuExConfig.getChildMenuItems());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    protected void OnFillTabViewModel(XMLNode tabViewConfig, String strIfGridViewPath, ArrayList childMenuItems) {
        try {
            if (childMenuItems == null) {
                return;
            }
            int nCount = childMenuItems.size();
            int i = 0;
            while (i < nCount) {
                ++this.nTreeNodeIndex;
                MenuItemExConfig menuItemExConfig = (MenuItemExConfig)childMenuItems.get(i);
                String strResourceId = menuItemExConfig.getResourceId();
                if (StringHelper.Length((String)menuItemExConfig.getCaption()) != 0 || StringHelper.Length((String)menuItemExConfig.getUserMenuCaptionId()) != 0) {
                    String strLink = menuItemExConfig.getPagePath();
                    if (StringHelper.Length((String)strLink) != 0 && (strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                        strLink = ".." + strLink;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strLink)) {
                        if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getAppendParams())) {
                            strLink = URLHelper.AppendURLSeperator((String)strLink);
                            strLink = String.valueOf(strLink) + menuItemExConfig.getAppendParams();
                        }
                        XMLNode tvpConfig = new XMLNode();
                        tvpConfig.setNodeName("SRFEXTABVIEWPAGE");
                        tvpConfig.setID(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex));
                        tvpConfig.SetValue("RESOURCEID", strResourceId);
                        tvpConfig.SetValue("REMOTEURL", StringHelper.Format((String)strIfGridViewPath, (Object)URLEncoder.encode(strLink, "UTF-8")));
                        tabViewConfig.AddNode(tvpConfig);
                    }
                    this.OnFillTabViewModel(tabViewConfig, strIfGridViewPath, menuItemExConfig.getChildMenuItems());
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.menuTreeGirdViewModel.setMenuMode(this.strMenuMode);
        this.menuTreeGirdViewModel.setTreeName(this.GetTreeName());
        String strTabViewConfigId = this.strMainMenuId;
        strTabViewConfigId = strTabViewConfigId.toUpperCase();
        String strTabViewFilePath = ConfigPathHelper.GetRuntimeTVConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strTabViewConfigId);
        File file2 = new File(strTabViewFilePath);
        if (!file2.exists()) {
            XMLNode tabViewNode = new XMLNode();
            tabViewNode.setNodeName("SRFEXTABVIEW");
            tabViewNode.SetValue("TOPHEADER", "FALSE");
            this.nTreeNodeIndex = 99;
            this.OnFillTabViewModel(tabViewNode);
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)tabViewNode, (String)strTabViewFilePath)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u83dc\u5355\u5206\u9875\u89c6\u56fe\u914d\u7f6e\u5931\u8d25"));
            }
        }
        this.menuTreeGirdViewModel.getTabViewModel().setConfigId(strTabViewConfigId);
        return true;
    }

    @Override
    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.EXPLORERVIEW", "\u6811\u5bfc\u822a\u89c6\u56fe");
    }
}

