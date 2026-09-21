/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAConfigHelper
 *  SA.SRFDA.Ctrl.ConfigPathHelper
 *  SA.SRFDA.Ctrl.Data.PP.PPTreeViewBar
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.TreeNode
 *  SA.SRFDA.Ctrl.Data.TreeNodeRS
 *  SA.SRFDA.Ctrl.Data.TreeView
 *  SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig
 *  SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SA.SRFramework.XML.XMLNode
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.BaseDAConfigHelper;
import SA.SRFDA.Ctrl.ConfigPathHelper;
import SA.SRFDA.Ctrl.DAConfigHelper;
import SA.SRFDA.Ctrl.Data.PP.PPTreeViewBar;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.TreeNode;
import SA.SRFDA.Ctrl.Data.TreeNodeRS;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.ToolbarWriter.BaseToolbarItemWriter;
import SA.SRFDA.Ctrl.ToolbarWriter.DefaultToolbarWriterContext;
import SA.SRFDA.Ctrl.ToolbarWriter.TBItemConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.ToolbarItemWriterConfig;
import SA.SRFDA.Ctrl.ToolbarWriter.TreeViewCMDEBHGroupWriter;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.TreeExplorerViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SA.SRFramework.XML.XMLNode;
import java.io.File;
import java.util.Vector;
import net.sf.json.JSONObject;

public class TreeExplorerPage
extends BaseMainPage {
    public static final String TAG_PAGETITLEBARVISIBLE = "PAGE.TITLEBAR.VISIBLE";
    public static final String TAG_PAGETITLEBARNAME = "PAGE.TITLEBAR.NAME";
    public static final String TAG_PAGETITLEBARWIDTH = "PAGE.TITLEBAR.WIDTH";
    public static final String PPCTRLID_TREEVIEWBAR = "TREEVIEWBAR";
    protected SRFExIFrame iFrame = null;
    protected SRFExTreePanel treePanel = null;
    protected TreeView treeView = null;
    protected SRFExDropDownList ddlTreeDimension = null;
    protected SRFExTextBox tbTreeFilter = null;
    protected String strTreeViewId = "";
    protected Vector treeDimensions = null;
    protected String strSLTreeSelectCode = "";
    protected TreeExplorerViewModel treeExplorerViewModel = null;
    protected PPTreeViewBar ppTreeViewBar = null;

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam(PPCTRLID_TREEVIEWBAR, "PP_TREEVIEWBAR")) != null && pageParam instanceof PPTreeViewBar) {
            this.ppTreeViewBar = (PPTreeViewBar)pageParam;
        }
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strTreeViewId = this.OnGetTreeView();
        if (StringHelper.IsNullOrEmpty((String)this.strTreeViewId)) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6811\u89c6\u56fe"));
            return false;
        }
        this.treeView = this.getDAModelStorage().FindTreeView(this.strTreeViewId);
        if (this.treeView == null) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6811\u89c6\u56fe[%1$s]", (Object)this.strTreeViewId));
            return false;
        }
        this.setPageParam("TREEVIEW", this.treeView);
        this.strPageDataEntityId = !StringHelper.IsNullOrEmpty((String)this.treeView.getDEID()) ? this.treeView.getDEID() : this.GetDefaultPageDataEntityId();
        return this.LoadPageDataEntity();
    }

    @Override
    protected PageModel CreatePageModel() {
        return new TreeExplorerViewModel();
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.treeExplorerViewModel = (TreeExplorerViewModel)this.pageModel;
    }

    protected String OnGetTreeView() {
        String strTreeViewId = SRFDAWebCTXHelper.GetTreeView((ISRFDAWebContext)this.getWebContext());
        if (StringHelper.IsNullOrEmpty((String)strTreeViewId) && this.ppTreeViewBar != null) {
            strTreeViewId = this.ppTreeViewBar.getTREEVIEWID();
        }
        return this.getPageParam("PAGE.TREEVIEW", strTreeViewId);
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadTreePanel();
        if (this.IsEnableRootSelect()) {
            this.LoadTreeDimensionControl();
        }
        if (this.IsEnableNodeSearch()) {
            this.LoadTreeFilterControl();
        }
        this.LoadIFrame();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        boolean bSL = !StringHelper.IsNullOrEmpty((String)this.getPageModel());
        StringBuilderEx script = new StringBuilderEx();
        if (!bSL) {
            script.Append("function nodeselect(NODETYPE,ALLNODEID,NODETEXT)\r\n");
            script.Append("{\r\n");
        }
        script.Append("var NODEID=ALLNODEID.split(';');\r\n");
        if (!bSL) {
            script.Append("var _IF=Ext.getDom('%1$s');\r\n", (Object)this.iFrame.getUniqueID());
        }
        script.Append("switch(NODETYPE){\r\n");
        for (TreeNode treeNode : this.treeView.getTreeNodeList()) {
            if (StringHelper.Compare((String)treeNode.getNODEACTION(), (String)"PAGELINK", (boolean)true) == 0) {
                String strURL = "";
                if (!StringHelper.IsNullOrEmpty((String)treeNode.getPAGEID())) {
                    Page page = this.getDAModelStorage().FindPage(treeNode.getPAGEID());
                    if (page == null) {
                        this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]", (Object)treeNode.getPAGEID()));
                        continue;
                    }
                    strURL = page.GetTotalPagePath();
                }
                if (!StringHelper.IsNullOrEmpty((String)strURL)) {
                    strURL = URLHelper.AppendURLSeperator((String)strURL);
                }
                strURL = String.valueOf(strURL) + treeNode.getACTIONPARAM();
                script.Append("case '%1$s':{var _URL='%2$s';_URL=_URL.replace('{##NODETEXT}',NODETEXT);for(i=0;i<NODEID.length;i++){_URL=_URL.replace('{##NODEID'+((i==0)?'':(i+1).toString())+'}',NODEID[i]);}_IF.src=_URL;break;}\r\n", (Object)treeNode.getTREENODEID(), (Object)strURL);
                continue;
            }
            if (StringHelper.Compare((String)treeNode.getNODEACTION(), (String)"JAVASCRIPT", (boolean)true) != 0) continue;
            script.Append("case '%1$s':{%2$s break;}\r\n", (Object)treeNode.getTREENODEID(), (Object)treeNode.getACTIONPARAM());
        }
        script.Append("default:break;\r\n");
        script.Append("}\r\n");
        if (!bSL) {
            script.Append("}\r\n");
        } else {
            this.strSLTreeSelectCode = script.toString();
        }
        this.RegisterScript(2, script.toString());
        script.Reset();
        script.Append("if(_2==undefined||_2==null){nodeselect('','','');return;}\r\n");
        script.Append("var _ID=_2.id;\r\n");
        script.Append("var _TEXT=_2.text;\r\n");
        script.Append("var _P=_ID.indexOf(';');\r\n");
        script.Append("if(_P==-1){nodeselect(_ID,'',_TEXT);}\r\n");
        script.Append("else{nodeselect(_ID.substring(0,_P),_ID.substring(_P+1),_TEXT);}\r\n");
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
        script.Reset();
        script.Append("$P.object['CM_%1$s']=new Ext.menu.Menu({items:[{text:'\u5237\u65b0',iconCls:'sx-tb-refresh',handler:function(_1,_2){if(Ext.isFunction(_1.parentMenu.tag.reload)){_1.parentMenu.tag.reload();}}}]});", (Object)this.treePanel.getUniqueID());
        this.RegisterOnReadyScript(2, script.toString());
        script.Reset();
        script.Append("$P.object['CM_%1$s'].tag=_1;$P.object['CM_%1$s'].show(_1.ui.getAnchor());", (Object)this.treePanel.getUniqueID());
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnContextMenuEventScript((String)this.treePanel.getUniqueID(), (String)script.toString()));
    }

    protected void LoadTreePanel() {
        this.treePanel = TreeExplorerPage.CreateTreePanel(this, "treePanel", 200.0, 200.0, "SRFDEFAULT.TV_DEFAULT");
        if (this.treePanel != null) {
            if (!this.IsBackEndMode()) {
                this.treePanel.getTreePanelConfig().setBorder(false);
                this.treePanel.getTreePanelConfig().setShowLine(false);
                this.treePanel.getTreePanelConfig().setRootVisible(this.treeView.getSHOWROOT());
                this.treePanel.getTreePanelConfig().getRootNodeConfig().setText(this.treeView.getRootTreeNode().getTREENODENAME());
                this.treePanel.getTreePanelConfig().getRootNodeConfig().setAlwaysAsyncMode(true);
                this.treePanel.getTreePanelConfig().getRootNodeConfig().setLeaf(false);
            }
            if (this.treeExplorerViewModel != null) {
                this.treeExplorerViewModel.getTreePanelModel().setConfigId("SRFDEFAULT.TV_DEFAULT");
                this.treeExplorerViewModel.getTreePanelModel().setRemoteCtrlId(this.treePanel.getUniqueID());
                this.treeExplorerViewModel.getTreePanelModel().setShowRoot(this.treeView.getSHOWROOT());
            }
        }
    }

    protected void LoadTreeDimensionControl() {
        this.ddlTreeDimension = new SRFExDropDownList();
        this.ddlTreeDimension.InitConfig();
        this.ddlTreeDimension.setID("ddlTreeDimension");
        this.ddlTreeDimension.getDropDownListConfig().setWidthEx(1.0);
        if (!this.IsBackEndMode()) {
            TreeNode rootNode;
            if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.treeDimensions = new Vector();
            }
            if ((rootNode = this.treeView.getRootTreeNode()) == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6811\u5b9e\u4f53\u8ddf\u8282\u70b9"));
                return;
            }
            for (TreeNodeRS treeNodeRS : rootNode.getTreeNodeRSList()) {
                TreeNode treeNode = this.treeView.FindTreeNode(treeNodeRS.getCTREENODEID());
                this.ddlTreeDimension.getDropDownListConfig().getListItems().Add(new ListItem(treeNode.getTREENODENAME(), treeNode.getTREENODEID()));
                if (this.treeDimensions == null) continue;
                JSONObject jo = new JSONObject();
                jo.put("value", (Object)treeNode.getTREENODEID());
                jo.put("text", (Object)treeNode.getTREENODENAME());
                this.treeDimensions.add(jo);
            }
        }
        this.AddControl((SRFExControl)this.ddlTreeDimension);
        if (!this.IsBackEndMode()) {
            this.ddlTreeDimension.getDropDownListConfig().setSelectChangedJSCode(StringHelper.Format((String)"$P.tree['%1$s'].getLoader().dparams.srfnodeselect=Ext.getDom('%2$s').value;$P.tree['%1$s'].getRootNode().reload();", (Object)this.treePanel.getUniqueID(), (Object)this.ddlTreeDimension.getUniqueID()));
        }
    }

    protected void LoadTreeFilterControl() {
        this.tbTreeFilter = new SRFExTextBox();
        this.tbTreeFilter.InitConfig();
        this.tbTreeFilter.setID("tbTreeFilter");
        this.tbTreeFilter.getTextBoxConfig().setWidthEx(1.0);
        this.tbTreeFilter.getTextBoxConfig().setValue("");
        this.AddControl((SRFExControl)this.tbTreeFilter);
        if (!this.IsBackEndMode()) {
            this.RegisterScript(3, StringHelper.Format((String)"function nodefilter(){var varTree=$P.tree['%1$s'];varTree.getLoader().dparams.srfnodefilter=Ext.getDom('%2$s').value;varTree.getLoader().dparams.srfautoexpand=Ext.getDom('cbAutoExpand').checked;varTree.getRootNode().reload();}", (Object)this.treePanel.getUniqueID(), (Object)this.tbTreeFilter.getUniqueID()));
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"var map=new Ext.KeyMap('%1$s',[{key:[10,13],fn:function(){nodefilter();}}]);", (Object)this.tbTreeFilter.getUniqueID()));
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterTreeActionHelper(this.treePanel.getUniqueID(), this.GetTreeActionHelper());
    }

    protected String GetTreeActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.treeView.getBACKENDCTRL())) {
            return this.treeView.getBACKENDCTRL();
        }
        return "SA.SRFDA.Ctrl.Tree.BaseDATreeActionHelperEx";
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("no");
        this.iFrame.getIFrameConfig().setURL(this.treeView.getDEFAULTVIEW());
        this.AddControl((SRFExControl)this.iFrame);
    }

    public boolean IsShowTitleBar() {
        boolean bTitleBarVisible = true;
        if (this.ppTreeViewBar != null && !this.ppTreeViewBar.isTITLEBARVISIBLENull()) {
            bTitleBarVisible = this.ppTreeViewBar.getTITLEBARVISIBLE();
        }
        return this.getPageParam(TAG_PAGETITLEBARVISIBLE, bTitleBarVisible);
    }

    public String GetTitleBarName() {
        String strTitleBarName = this.treeView.getTREEVIEWNAME();
        if (this.ppTreeViewBar != null && !this.ppTreeViewBar.isTITLEBARNAMENull()) {
            strTitleBarName = this.ppTreeViewBar.getTITLEBARNAME();
        }
        if (StringHelper.IsNullOrEmpty((String)strTitleBarName)) {
            strTitleBarName = "\u8fb9\u680f";
        }
        return this.getPageParam(TAG_PAGETITLEBARNAME, strTitleBarName);
    }

    public String GetTreeName() {
        return this.GetTitleBarName();
    }

    public int GetTitleBarWidth() {
        int nWidth = 200;
        if (this.ppTreeViewBar != null && !this.ppTreeViewBar.isTITLEBARWIDTHNull()) {
            nWidth = this.ppTreeViewBar.getTITLEBARWIDTH();
        }
        return this.getPageParam(TAG_PAGETITLEBARWIDTH, nWidth);
    }

    public boolean IsEnableRootSelect() {
        return this.treeView.getROOTSELECT();
    }

    public boolean IsEnableNodeSearch() {
        return this.treeView.getENABLESEARCH();
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.treeExplorerViewModel.setRootDimension(this.IsEnableRootSelect());
        this.treeExplorerViewModel.setRootDimensionList(this.treeDimensions);
        this.treeExplorerViewModel.setNodeSearch(this.IsEnableNodeSearch());
        this.treeExplorerViewModel.setDefaultView(this.treeView.getDEFAULTVIEW());
        this.treeExplorerViewModel.setNodeSelectCode(this.strSLTreeSelectCode);
        this.treeExplorerViewModel.setNodeContextMenuId(this.ExportTreeViewContextMenu());
        this.treeExplorerViewModel.setTitleBarWidth(this.GetTitleBarWidth());
        return true;
    }

    protected String ExportTreeViewContextMenu() {
        String strMenuConfigId = StringHelper.Format((String)"TREEVIEW.MENU_%1$s_%2$s", (Object)this.treeView.getTREEVIEWID(), (Object)this.treeView.getVERSION());
        if (!StringHelper.IsNullOrEmpty((String)this.strPageModel)) {
            strMenuConfigId = String.valueOf(strMenuConfigId) + StringHelper.Format((String)"_PM_%1$s", (Object)this.strPageModel);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getLanguage())) {
            strMenuConfigId = String.valueOf(strMenuConfigId) + StringHelper.Format((String)"_%1$s", (Object)this.getLanguage());
        }
        strMenuConfigId = strMenuConfigId.toUpperCase();
        String strMenuFilePath = ConfigPathHelper.GetRuntimeMainMenuConfigPath((String)this.getWebContext().getGlobalHelper().GetAppRootPath(), (String)strMenuConfigId);
        File file = new File(strMenuFilePath);
        if (!file.exists()) {
            DefaultToolbarWriterContext tbWriterContext = this.CreateTBWriterContext();
            tbWriterContext.setPage(this.page);
            tbWriterContext.setDEHelper(this.iDEHelper);
            tbWriterContext.setViewStyle("TREEVIEW");
            XMLNode menuNode = new XMLNode();
            menuNode.setNodeName("SRFEXMENUEX");
            for (TreeNode treeNode : this.treeView.getTreeNodeList()) {
                XMLNode treeNodeMenu = this.PrepareTreeNodeMenu(tbWriterContext, menuNode, treeNode);
                menuNode.AddNode(treeNodeMenu);
            }
            if (!BaseDAConfigHelper.ExportConfigFile((XMLNode)menuNode, (String)strMenuFilePath)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u5bfc\u51fa\u6811\u89c6\u56fe\u83dc\u5355\u914d\u7f6e\u5931\u8d25"));
            }
        }
        return strMenuConfigId;
    }

    protected XMLNode PrepareTreeNodeMenu(DefaultToolbarWriterContext tbWriterContext, XMLNode menuNode, TreeNode treeNode) {
        XMLNode mainMenuNode = new XMLNode();
        mainMenuNode.setNodeName("SRFEXMAINMENUEX");
        mainMenuNode.SetProperty("CAPTION", treeNode.getTREENODEID());
        if (treeNode.getCMREFRESH()) {
            XMLNode menuItemExNode = new XMLNode();
            menuItemExNode.setNodeName("SRFEXMENUITEMEX");
            menuItemExNode.SetProperty("CAPTION", "\u5237\u65b0");
            menuItemExNode.SetProperty("HANDLER", "SA.SRFDA.Ctrl.Toolbar.TreeRefreshHandler");
            menuItemExNode.SetProperty("ICONCLS", "sx-tb-refresh");
            mainMenuNode.AddNode(menuItemExNode);
        }
        TreeViewCMDEBHGroupWriter deBHGroupWriter = new TreeViewCMDEBHGroupWriter();
        deBHGroupWriter.Init(new ToolbarItemWriterConfig(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        for (TreeNodeRS treeNodeRS : treeNode.getTreeNodeRSList()) {
            if (!treeNodeRS.getCMCREATE()) continue;
            String strNewDEBHGroupId = treeNodeRS.getNEWDEBHGROUPID();
            if (StringHelper.IsNullOrEmpty((String)strNewDEBHGroupId)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u65b0\u5efa\u64cd\u4f5c\u5bf9\u5e94\u7684\u754c\u9762\u884c\u4e3a\u7ec4"));
                continue;
            }
            TBItemConfig tbItemConfig = new TBItemConfig();
            tbItemConfig.setSeperator("ALL");
            tbItemConfig.SetValue("DEBHGROUPID", strNewDEBHGroupId);
            tbItemConfig.SetValue("TREENODEPARAM", treeNodeRS.getNEWCHILDPATH());
            deBHGroupWriter.Export(menuNode, mainMenuNode, tbItemConfig, null, tbWriterContext, true);
        }
        if (treeNode.getCMREMOVE()) {
            BaseToolbarItemWriter.AddToolbarSeperator(mainMenuNode, true);
            XMLNode menuItemExNode = new XMLNode();
            menuItemExNode.setNodeName("SRFEXMENUITEMEX");
            menuItemExNode.SetProperty("CAPTION", "\u5220\u9664");
            menuItemExNode.SetProperty("HANDLER", "SA.SRFDA.Ctrl.Toolbar.TreeRemoveHandler");
            menuItemExNode.SetProperty("ICONCLS", "sx-tb-remove");
            mainMenuNode.AddNode(menuItemExNode);
        }
        DAConfigHelper.EraseToolbarUnnecessarySeperator(mainMenuNode);
        return mainMenuNode;
    }

    protected DefaultToolbarWriterContext CreateTBWriterContext() {
        DefaultToolbarWriterContext tbWriterContext = new DefaultToolbarWriterContext();
        tbWriterContext.setPageModel(this.getLanguage());
        tbWriterContext.setLanguage(this.getLanguage());
        tbWriterContext.setDAGlobalHelper((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        return tbWriterContext;
    }
}

