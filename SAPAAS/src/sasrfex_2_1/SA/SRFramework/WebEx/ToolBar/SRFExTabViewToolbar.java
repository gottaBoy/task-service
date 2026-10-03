/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExTabViewTBBHandler;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.TabViewToolbarConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarButtonConfig;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarSeperatorConfig;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTabViewToolbar
extends SRFExToolbar {
    protected TabViewToolbarConfig tabViewToolbarConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTabViewToolbar.class);
    protected SRFExTabView tabView = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new TabViewToolbarConfig();
    }

    public TabViewToolbarConfig getTabViewToolbarConfig() {
        if (this.tabViewToolbarConfig == null) {
            this.InitConfig();
        }
        return this.tabViewToolbarConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.tabViewToolbarConfig = null;
        if (this.config != null && this.config instanceof TabViewToolbarConfig) {
            this.tabViewToolbarConfig = (TabViewToolbarConfig)this.config;
        }
    }

    protected void BuildToolbarButtons() {
        this.getTabViewToolbarConfig().getToolbarItemsConfig().clear();
        if (this.tabView != null) {
            IUserPrivilegeMgr iUserPrivilegeMgr = this.getWebContext().GetUserPrivilegeMgr();
            TabViewConfig tabViewConfig = this.tabView.getTabViewConfig();
            int nPageCount = tabViewConfig.getTabViewPages().size();
            boolean bFirstPage = true;
            int i = 0;
            while (i < nPageCount) {
                TabViewPageConfig tabViewPageConfig = (TabViewPageConfig)((Object)tabViewConfig.getTabViewPages().get(i));
                String strResourceId = tabViewPageConfig.getResourceId();
                if (iUserPrivilegeMgr == null || StringHelper.Length((String)strResourceId) <= 0 || iUserPrivilegeMgr.Test(this.getWebContext(), strResourceId)) {
                    if (!bFirstPage) {
                        ToolbarSeperatorConfig seperatorConfig = new ToolbarSeperatorConfig();
                        this.getTabViewToolbarConfig().getToolbarItemsConfig().add(seperatorConfig);
                    }
                    ToolbarButtonConfig buttonConfig = new ToolbarButtonConfig();
                    buttonConfig.setText(tabViewPageConfig.getCaption());
                    buttonConfig.setTips(tabViewPageConfig.getCaption());
                    buttonConfig.setHandler(SRFExTabViewTBBHandler.class.getName());
                    buttonConfig.SetValue("TABVIEWPAGEID", tabViewPageConfig.getID());
                    buttonConfig.setEnableToggle(true);
                    buttonConfig.setTag(tabViewPageConfig.getID());
                    if (bFirstPage) {
                        buttonConfig.setPressed(true);
                        bFirstPage = false;
                    }
                    this.getTabViewToolbarConfig().getToolbarItemsConfig().add(buttonConfig);
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
        this.setToolbarObject("", tabView);
        this.setToolbarObject("TABVIEW", tabView);
        this.BuildToolbarButtons();
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            if (this.tabView != null) {
                StringBuilderEx script = new StringBuilderEx();
                script.Append("$P.tabview['%1$s'].toolbarclick = function(_1){\r\n", this.tabView.getUniqueID());
                script.Append(TabViewJSHelper.getShowTabPageScript2(this.tabView.getUniqueID(), "_1"));
                script.Append("};\r\n");
                script.Append("$P.tabview['%1$s']._TAB.on('tabchange',function(_1,_2){var _TVPID=$P.tabview['%1$s']._PAGES[_2.id].realid;var _TB = $P.toolbar['%2$s'];for(var i=0;i<_TB.items.getCount();i++){var _TBB =_TB.items.itemAt(i); if(_TBB.tag == undefined)\r\ncontinue;\r\nif(_TBB.tag == _TVPID)\r\n_TBB.toggle(true);\r\nelse\r\n{_TBB.toggle(false);}\r\n}\r\n});\r\n", this.tabView.getUniqueID(), this.getUniqueID());
                this.getPage().RegisterOnReadyScript(3, script.toString());
            }
            super.OnRender(writer);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }
}

