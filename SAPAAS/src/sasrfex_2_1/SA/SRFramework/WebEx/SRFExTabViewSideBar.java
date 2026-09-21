/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.SRFExTreePanel;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.Script.TreeJSHelper;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.UI.TabViewSideBarConfig;
import SA.SRFramework.WebEx.UI.TreeNodeConfig;
import java.io.Writer;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTabViewSideBar
extends SRFExTreePanel {
    protected TabViewSideBarConfig tabViewSideBarConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTabViewSideBar.class);
    protected SRFExTabView tabView = null;
    protected StringBuilderEx tabViewBarCond = new StringBuilderEx();

    @Override
    protected XMLConfig CreateConfig() {
        return new TabViewSideBarConfig();
    }

    public TabViewSideBarConfig getTabViewSideBarConfig() {
        if (this.tabViewSideBarConfig == null) {
            this.InitConfig();
        }
        return this.tabViewSideBarConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.tabViewSideBarConfig = null;
        if (this.config != null && this.config instanceof TabViewSideBarConfig) {
            this.tabViewSideBarConfig = (TabViewSideBarConfig)this.config;
            this.tabViewSideBarConfig.setShowLine(false);
        }
    }

    protected void BuildTreePanelNodes() {
        this.tabViewBarCond.Reset();
        this.getTreePanelConfig().getRootNodeConfig().ResetChildNode();
        if (this.tabView != null) {
            String strGroup;
            String strResourceId;
            TabViewPageConfig tabViewPage;
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
            TreeMap<String, TreeNodeConfig> groupMap = new TreeMap<String, TreeNodeConfig>();
            TabViewConfig tabViewConfig = this.tabView.getTabViewConfig();
            int nPageCount = tabViewConfig.getTabViewPages().size();
            int i = 0;
            while (i < nPageCount) {
                tabViewPage = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                strResourceId = tabViewPage.getResourceId();
                if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(this.getWebContext(), strResourceId)) {
                    if (i == 0 && this.tabViewSideBarConfig.getFirstAsRoot()) {
                        this.getTreePanelConfig().getRootNodeConfig().setText("<B>" + tabViewPage.getCaption() + "</B>");
                        this.getTreePanelConfig().getRootNodeConfig().setID(tabViewPage.getID());
                        this.getTreePanelConfig().getRootNodeConfig().setTips(tabViewPage.getCaption());
                        this.getTreePanelConfig().getRootNodeConfig().setIcon(tabViewPage.GetExtValue("ICON", ""));
                        this.getTreePanelConfig().setRootVisible(true);
                    } else {
                        strGroup = tabViewPage.GetExtValue("GROUP", "");
                        if (!groupMap.containsKey(strGroup)) {
                            String strGroupCaption = strGroup;
                            if (StringHelper.IsNullOrEmpty((String)strGroupCaption)) {
                                strGroupCaption = "\u8be6\u7ec6\u4fe1\u606f";
                            }
                            TreeNodeConfig groupNode = new TreeNodeConfig();
                            groupNode.setText(strGroupCaption);
                            groupNode.setID(StringHelper.Format((String)"GROUP%1$s", (Object)i));
                            groupNode.setTips(strGroupCaption);
                            groupNode.setExpand(true);
                            groupNode.setIcon(tabViewPage.GetExtValue("GROUPICON", ""));
                            if (tabViewPage.GetExtValue("ISCOLLAPSE", false)) {
                                groupNode.setExpand(false);
                            }
                            this.getTreePanelConfig().getRootNodeConfig().AddChildNode(groupNode);
                            groupMap.put(strGroup, groupNode);
                        }
                    }
                }
                ++i;
            }
            i = 0;
            while (i < nPageCount) {
                tabViewPage = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                strResourceId = tabViewPage.getResourceId();
                if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(this.getWebContext(), strResourceId)) {
                    String strTabViewBarCond;
                    if (i != 0 || !this.tabViewSideBarConfig.getFirstAsRoot()) {
                        strGroup = tabViewPage.GetExtValue("GROUP", "");
                        TreeNodeConfig groupNode = (TreeNodeConfig)groupMap.get(strGroup);
                        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
                        treeNodeConfig.setText(tabViewPage.getCaption());
                        treeNodeConfig.setID(tabViewPage.getID());
                        treeNodeConfig.setTips(tabViewPage.getCaption());
                        treeNodeConfig.setIcon(tabViewPage.GetExtValue("ICON", ""));
                        groupNode.AddChildNode(treeNodeConfig);
                    }
                    if (i == 0) {
                        this.getTreePanelConfig().setSelectedValue(tabViewPage.getID());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)(strTabViewBarCond = tabViewPage.GetExtValue("TABVIEWBARCOND", "")))) {
                        this.tabViewBarCond.Append("$U.showtreenode(_T.getNodeById('%1$s'),(%2$s));", tabViewPage.getID(), strTabViewBarCond);
                    }
                }
                ++i;
            }
        }
    }

    public SRFExTabView getTabView() {
        return this.tabView;
    }

    public void setTabView(SRFExTabView tabView) {
        this.tabView = tabView;
        this.BuildTreePanelNodes();
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("if(_2==null)return;", this.getUniqueID());
            script.Append("if(_2.parentNode==$P.tree['%1$s'].getRootNode())return;", this.getUniqueID());
            if (this.tabView != null) {
                script.Append(TabViewJSHelper.getShowTabPageScript2(this.tabView.getUniqueID(), "_2.id"));
            }
            this.getPage().RegisterOnReadyScript(3, TreeJSHelper.getOnSelectionchangeEventScript(this.getUniqueID(), script.toString()));
            super.OnRender(writer);
            String strTabViewBarCond = this.tabViewBarCond.toString();
            if (!StringHelper.IsNullOrEmpty((String)strTabViewBarCond)) {
                String strPreFix = StringHelper.Format((String)"var _T=$P.tree['%1$s'];var _F=$P.object['TABVIEWBAR'].form;", (Object)this.getUniqueID());
                script.Reset();
                script.Append("$P.object['TABVIEWBAR']={};");
                script.Append("$P.object['TABVIEWBAR'].setform=function(_1){$P.object['TABVIEWBAR'].form=$P.form[_1]._FORM;$P.form[_1].on('filled',function(){%1$s %2$s});};", strPreFix, strTabViewBarCond);
                this.getPage().RegisterOnReadyScript(2, script.toString());
            }
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }
}

