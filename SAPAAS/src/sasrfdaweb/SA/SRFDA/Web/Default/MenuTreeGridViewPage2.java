/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.PP.PPMenuTreeBar
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.TreeJSHelper
 *  SA.SRFramework.WebEx.UI.MainMenuExConfig
 *  SA.SRFramework.WebEx.UI.MenuExConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.PP.PPMenuTreeBar;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.ViewModel.MenuTreeGridViewModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import net.sf.json.JSONObject;

public class MenuTreeGridViewPage2
extends BaseMainPage {
    public static final String TAG_PAGELEFTMENUTREE = "PAGE.LEFTMENUTREE";
    public static final String TAG_PAGETREENAME = "PAGE.TREENAME";
    public static final String TAG_PAGETITLEBARVISIBLE = "PAGE.TITLEBAR.VISIBLE";
    public static final String TAG_PAGETITLEBARNAME = "PAGE.TITLEBAR.NAME";
    public static final String TAG_PAGEACTIVEFOLDER = "PAGE.ACTIVEFOLDER";
    public static final String TAG_PAGETREEUPDATEPATH = "PAGE.TREEUPDATEPATH";
    public static final String TAG_PAGEACTIVEFOLDER_NOSELECT = "%%NOSELECT%%";
    protected SRFExIFrame iFrame = null;
    protected SRFExTreePanel treePanel = null;
    protected String strActiveFolder = "";
    protected MenuExConfig curMenuExConfig = null;
    protected TreeMap<String, String> outputSectors = new TreeMap();
    protected int nTreeNodeIndex = 99;
    public static final String PPCTRLID_LEFTMENUBAR = "LEFTMENUBAR";
    private PPMenuTreeBar ppMenuTreeBar = null;
    protected String strMenuMode = "";
    protected String strMainMenuId = "";
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
        this.LoadIFrame();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.nTreeNodeIndex = 99;
        HashMap<String, String> menuLinkMap = new HashMap<String, String>();
        HashMap<String, String> menuLinkTypeMap = new HashMap<String, String>();
        this.CalcMenuLinkMap(menuLinkMap, menuLinkTypeMap);
        StringBuilderEx script = new StringBuilderEx();
        script.Append("function calcmenulink(_1){\r\n");
        for (String strId : menuLinkMap.keySet()) {
            if (StringHelper.Compare((String)menuLinkTypeMap.get(strId), (String)"LINK", (boolean)true) == 0) {
                script.Append("if(_1=='%1$s')return '%2$s';\r\n", (Object)strId, (Object)menuLinkMap.get(strId));
                continue;
            }
            if (StringHelper.Compare((String)menuLinkTypeMap.get(strId), (String)"JSCRIPT", (boolean)true) != 0) continue;
            script.Append("if(_1=='%1$s'){%2$s return '';}\r\n", (Object)strId, (Object)menuLinkMap.get(strId));
        }
        script.Append("return '';\r\n");
        script.Append("}\r\n");
        this.RegisterScript(3, script.toString());
        StringBuilderEx script2 = new StringBuilderEx();
        script2.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();if(node==null)return;\r\n", (Object)this.treePanel.getUniqueID());
        script2.Append("if(node==$P.tree['%1$s'].getRootNode())return;\r\n", (Object)this.treePanel.getUniqueID());
        if (this.iFrame != null) {
            script2.Append("var A=calcmenulink(node.id);if(A=='')return;\r\n");
            script2.Append("var B=Ext.getDom('%1$s').src=A;\r\n", (Object)this.iFrame.getUniqueID());
        }
        this.RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript((String)this.treePanel.getUniqueID(), (String)script2.toString()));
    }

    protected void LoadTreePanel() {
        this.treePanel = MenuTreeGridViewPage2.CreateTreePanel(this, "treePanel", 200.0, 200.0, "SRFDEFAULT.TV_DEFAULT2");
        if (this.treePanel != null) {
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setShowLine(false);
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setAsyncMode(false);
            this.nTreeNodeIndex = 99;
            this.OnFillTreeMenuConfig(this.treePanel);
            this.OnAfterFillTreeMenuConfig(this.treePanel);
            if (StringHelper.Compare((String)TAG_PAGEACTIVEFOLDER_NOSELECT, (String)this.strActiveFolder, (boolean)true) != 0) {
                this.treePanel.getTreePanelConfig().setSelectedValue(this.strActiveFolder);
            }
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
        MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
        treePanel.getTreePanelConfig().getRootNodeConfig().setText(mainMenuExConfig.getCaption());
        if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getIconCls())) {
            treePanel.getTreePanelConfig().getRootNodeConfig().setIconCssClass(mainMenuExConfig.getIconCls());
        }
        if (StringHelper.Length((String)mainMenuExConfig.getPagePath()) != 0 && StringHelper.IsNullOrEmpty((String)this.strActiveFolder)) {
            this.strActiveFolder = "root";
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
                TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                treeNodeConfig.setText(menuItemExConfig.getCaption());
                treeNodeConfig.setID(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex));
                if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getIconCls())) {
                    treeNodeConfig.setIconCssClass(menuItemExConfig.getIconCls());
                }
                if (StringHelper.Length((String)menuItemExConfig.getPagePath()) != 0 && StringHelper.IsNullOrEmpty((String)this.strActiveFolder)) {
                    this.strActiveFolder = treeNodeConfig.getID();
                }
                nodeConfig.AddChildNode(treeNodeConfig);
                this.OnFillTreeNodeConfig(treeNodeConfig, menuItemExConfig.getChildMenuItems(), iUserPrivilegeMgr);
                String strAutoExpand = menuItemExConfig.GetExtValue("AUTOEXPAND", "TRUE");
                if (StringHelper.Compare((String)strAutoExpand, (String)"FALSE", (boolean)true) == 0) {
                    treeNodeConfig.setExpand(false);
                }
            }
            ++i;
        }
        nodeConfig.setExpand(true);
    }

    protected void OnFillTreeMenuConfig(SRFExTreePanel treePanel, String strGroup) {
    }

    protected void OnAfterFillTreeMenuConfig(SRFExTreePanel treePanel) {
    }

    protected void CalcMenuLinkMap(HashMap<String, String> menuLink, HashMap<String, String> menuLinkTypeMap) {
        try {
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
            MainMenuExConfig mainMenuExConfig = (MainMenuExConfig)this.curMenuExConfig.getMainMenus().get(0);
            String strLink = mainMenuExConfig.getPagePath();
            if (StringHelper.Length((String)strLink) != 0) {
                if ((strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                    strLink = ".." + strLink;
                }
                if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getAppendParams())) {
                    strLink = URLHelper.AppendURLSeperator((String)strLink);
                    strLink = String.valueOf(strLink) + mainMenuExConfig.getAppendParams();
                }
                strLink = String.valueOf(strLink) + "&SRFCAPTION=" + SRFExWebContext.EncodeURLParamValue((String)mainMenuExConfig.getCaption());
                menuLink.put("root", strLink);
                menuLinkTypeMap.put("root", "LINK");
            } else if (!StringHelper.IsNullOrEmpty((String)mainMenuExConfig.getJSCode())) {
                menuLink.put("root", mainMenuExConfig.getJSCode());
                menuLinkTypeMap.put("root", "JSCRIPT");
            }
            this.CalcMenuLinkMap(menuLink, menuLinkTypeMap, mainMenuExConfig.getChildMenuItems(), iUserPrivilegeMgr);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void CalcMenuLinkMap(HashMap<String, String> menuLink, HashMap<String, String> menuLinkTypeMap, ArrayList childMenuItems, IUserPrivilegeMgr iUserPrivilegeMgr) {
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
                    if (StringHelper.Length((String)strLink) != 0) {
                        if ((strLink = URLHelper.AppendURLSeperator((String)strLink)).indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                            strLink = ".." + strLink;
                        }
                        if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getAppendParams())) {
                            strLink = URLHelper.AppendURLSeperator((String)strLink);
                            strLink = String.valueOf(strLink) + menuItemExConfig.getAppendParams();
                        }
                        strLink = String.valueOf(strLink) + "&SRFCAPTION=" + SRFExWebContext.EncodeURLParamValue((String)menuItemExConfig.getCaption());
                        menuLink.put(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex), strLink);
                        menuLinkTypeMap.put(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex), "LINK");
                    } else if (!StringHelper.IsNullOrEmpty((String)menuItemExConfig.getJSCode())) {
                        menuLink.put(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex), menuItemExConfig.getJSCode());
                        menuLinkTypeMap.put(StringHelper.Format((String)"_%1$s", (Object)this.nTreeNodeIndex), "JSCRIPT");
                    }
                    this.CalcMenuLinkMap(menuLink, menuLinkTypeMap, menuItemExConfig.getChildMenuItems(), iUserPrivilegeMgr);
                }
                ++i;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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
        this.iFrame.getIFrameConfig().setURL("");
        this.AddControl((SRFExControl)this.iFrame);
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
        boolean bParamValue = true;
        if (this.ppMenuTreeBar != null && this.ppMenuTreeBar.ContainesParam("SHOWTITLEBAR")) {
            bParamValue = this.ppMenuTreeBar.getSHOWTITLEBAR();
        }
        return this.getPageParam(TAG_PAGETITLEBARVISIBLE, bParamValue);
    }

    public String GetTitleBarName() {
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getTITLEBARNAME();
        }
        if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
            strParamValue = "\u8fb9\u680f";
        }
        return this.getPageParam(TAG_PAGETITLEBARNAME, strParamValue);
    }

    protected String OnGetTreeUpdatePath() {
        String strParamValue = "";
        if (this.ppMenuTreeBar != null) {
            strParamValue = this.ppMenuTreeBar.getTREEUPDATEPATH();
        }
        return this.getPageParam(TAG_PAGETREEUPDATEPATH, strParamValue);
    }

    @Override
    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.menuTreeGirdViewModel.setMenuMode(this.strMenuMode);
        this.menuTreeGirdViewModel.setTreeName(this.GetTreeName());
        return true;
    }
}

