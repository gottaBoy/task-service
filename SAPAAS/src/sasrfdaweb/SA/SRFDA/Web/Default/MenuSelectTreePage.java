/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExTreePanel
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.UI.BaseMenuExConfig
 *  SA.SRFramework.WebEx.UI.MainMenuExConfig
 *  SA.SRFramework.WebEx.UI.MenuItemExConfig
 *  SA.SRFramework.WebEx.UI.TreeNodeConfig
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.UI.BaseMenuExConfig;
import SA.SRFramework.WebEx.UI.MainMenuExConfig;
import SA.SRFramework.WebEx.UI.MenuItemExConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;

public class MenuSelectTreePage
extends BaseMainPage {
    protected SRFExTreePanel treePanel = null;

    @Override
    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        this.setID(this.getWebContext().getContainerId());
        super.OnInitComponents();
        this.LoadTreePanel();
        this.LoadButton();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
    }

    @Override
    public String OutputPageCaption() {
        return "\u83dc\u5355\u9879";
    }

    protected void LoadButton() {
        StringBuilderEx script;
        SRFExButton OkButton = new SRFExButton();
        OkButton.InitConfig();
        OkButton.setID("OkButton");
        OkButton.getButtonConfig().setText("\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setTips("\u786e\u5b9a\u9009\u62e9");
        OkButton.getButtonConfig().setIconCls("sx-tb-ok");
        OkButton.setResourceId("");
        this.AddControl((SRFExControl)OkButton);
        if (!this.IsBackEndMode()) {
            script = new StringBuilderEx();
            script.Append("var node=$P.tree['%1$s'].getSelectionModel().getSelectedNode();", (Object)this.treePanel.getUniqueID());
            script.Append("if(node==null){alert('\u6240\u9009\u6570\u636e\u4e0d\u80fd\u4e3a\u7a7a');return false;}");
            script.Append("if(node.attributes.sclink==null || node.attributes.sclink==''){alert('\u6240\u9009\u6570\u636e\u6ca1\u6709\u5305\u542b\u94fe\u63a5\uff0c\u8bf7\u91cd\u65b0\u9009\u62e9');return false;}");
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append("window.returnValue=node.attributes;");
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"text", (String)"node.text"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getCloseWindowScript());
            OkButton.getButtonConfig().setJSCode(script.toString());
        }
        SRFExButton CancelButton = new SRFExButton();
        CancelButton.InitConfig();
        CancelButton.setID("CancelButton");
        CancelButton.getButtonConfig().setText("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setTips("\u53d6\u6d88\u64cd\u4f5c");
        CancelButton.getButtonConfig().setIconCls("sx-tb-cancel");
        CancelButton.setResourceId("");
        this.AddControl((SRFExControl)CancelButton);
        script = new StringBuilderEx();
        script.Append(BrowserJSHelper.getResetDialogReturnValue());
        script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'cancel'"));
        script.Append(BrowserJSHelper.getCloseWindowScript());
        CancelButton.getButtonConfig().setJSCode(script.toString());
    }

    protected void LoadTreePanel() {
        String strTreePanelConfigId = "SRFDEFAULT.TV_COMMONPANEL";
        if (StringHelper.IsNullOrEmpty((String)strTreePanelConfigId)) {
            return;
        }
        this.treePanel = MenuSelectTreePage.CreateTreePanel(this, "treePanel", 100.0, 300.0, strTreePanelConfigId);
        if (this.treePanel != null && !this.IsBackEndMode()) {
            this.treePanel.getTreePanelConfig().getRootNodeConfig().setAsyncMode(false);
            if (this.getWebContext().getCurMenuExConfig().getMainMenus() != null) {
                int i = 0;
                while (i < this.getWebContext().getCurMenuExConfig().getMainMenus().size()) {
                    this.FillMenuItemTreeNode(this.treePanel.getTreePanelConfig().getRootNodeConfig(), (BaseMenuExConfig)this.getWebContext().getCurMenuExConfig().getMainMenus().get(i));
                    ++i;
                }
            }
            this.treePanel.getTreePanelConfig().setRootVisible(false);
            this.treePanel.getTreePanelConfig().setBorder(false);
            this.treePanel.getTreePanelConfig().setShowLine(true);
        }
    }

    protected void FillMenuItemTreeNode(TreeNodeConfig parentConfig, BaseMenuExConfig baseMenuItemConfig) {
        if (!StringHelper.IsNullOrEmpty((String)baseMenuItemConfig.getResourceId()) && !this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), baseMenuItemConfig.getResourceId())) {
            return;
        }
        if (baseMenuItemConfig instanceof MainMenuExConfig) {
            MainMenuExConfig mainMenuConfig = (MainMenuExConfig)baseMenuItemConfig;
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            treeNodeConfig.setText(mainMenuConfig.getCaption());
            treeNodeConfig.setAsyncMode(false);
            treeNodeConfig.setIcon("../sasrfex/images/default/icon_shortcut.gif");
            String strLink = mainMenuConfig.getPagePath();
            String strJSCode = mainMenuConfig.getJSCode();
            if (StringHelper.Length((String)strLink) != 0 && (strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&").indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                strLink = ".." + strLink;
            }
            treeNodeConfig.setTagValue("sclink", (Object)strLink);
            parentConfig.AddChildNode(treeNodeConfig);
            parentConfig.setExpand(false);
            if (mainMenuConfig.getChildMenuItems() != null) {
                int i = 0;
                while (i < mainMenuConfig.getChildMenuItems().size()) {
                    BaseMenuExConfig baseItemConfig = (BaseMenuExConfig)mainMenuConfig.getChildMenuItems().get(i);
                    this.FillMenuItemTreeNode(treeNodeConfig, baseItemConfig);
                    ++i;
                }
            } else {
                treeNodeConfig.setLeaf(true);
            }
            return;
        }
        if (baseMenuItemConfig instanceof MenuItemExConfig) {
            MenuItemExConfig menuItemConfig = (MenuItemExConfig)baseMenuItemConfig;
            TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
            treeNodeConfig.setText(menuItemConfig.getCaption());
            treeNodeConfig.setIcon("../sasrfex/images/default/icon_shortcut.gif");
            String strLink = menuItemConfig.getPagePath();
            String strJSCode = menuItemConfig.getJSCode();
            if (StringHelper.Length((String)strLink) != 0 && (strLink = strLink.indexOf("?") == -1 ? String.valueOf(strLink) + "?" : String.valueOf(strLink) + "&").indexOf("http") != 0 && strLink.indexOf("ftp") != 0 && strLink.indexOf("..") != 0) {
                strLink = ".." + strLink;
            }
            treeNodeConfig.setTagValue("sclink", (Object)strLink);
            parentConfig.AddChildNode(treeNodeConfig);
            parentConfig.setExpand(false);
            if (menuItemConfig.getChildMenuItems() != null) {
                int i = 0;
                while (i < menuItemConfig.getChildMenuItems().size()) {
                    BaseMenuExConfig baseItemConfig = (BaseMenuExConfig)menuItemConfig.getChildMenuItems().get(i);
                    this.FillMenuItemTreeNode(treeNodeConfig, baseItemConfig);
                    ++i;
                }
            } else {
                treeNodeConfig.setLeaf(true);
            }
            return;
        }
    }
}

