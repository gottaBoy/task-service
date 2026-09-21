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
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.TabPanelBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExLinkTabPage;
import SA.SRFramework.WebEx.SRFExRealTabPage;
import SA.SRFramework.WebEx.SRFExRemoteTabPage;
import SA.SRFramework.WebEx.SRFExTabPage;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.UI.BasePanelConfig;
import SA.SRFramework.WebEx.UI.LinkTabPageConfig;
import SA.SRFramework.WebEx.UI.RealTabPageConfig;
import SA.SRFramework.WebEx.UI.RemoteTabPageConfig;
import SA.SRFramework.WebEx.UI.TabPageConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTabPanel
extends SRFExBasePanel {
    protected TabPanelConfig tabPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTabPanel.class);
    protected TabPanelBuilder tabPanelBuilder = null;
    public static String BUILDER_TABPANEL = "TABPANEL";

    @Override
    protected XMLConfig CreateConfig() {
        return new TabPanelConfig();
    }

    public TabPanelConfig getTabPanelConfig() {
        if (this.tabPanelConfig == null) {
            this.InitConfig();
        }
        return this.tabPanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.tabPanelConfig = null;
        if (this.config != null && this.config instanceof TabPanelConfig) {
            this.tabPanelConfig = (TabPanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.tabPanelConfig != null) {
            ArrayList tabPages = this.tabPanelConfig.getTabPages();
            int i = 0;
            while (i < tabPages.size()) {
                Object objPanel = tabPages.get(i);
                SRFExControl childPanel = this.CreatePage(objPanel);
                if (childPanel != null) {
                    childPanel.setConfig((XMLConfig)tabPages.get(i));
                    this.AddControl(childPanel);
                }
                ++i;
            }
        }
    }

    protected SRFExControl CreatePage(Object objPanel) {
        if (objPanel == null) {
            return null;
        }
        if (objPanel instanceof BasePanelConfig) {
            SRFExWebContext webContext = this.getPage().getWebContext();
            IUserPrivilegeMgr iUserPrivilegeMgr = webContext.GetUserPrivilegeMgr();
            BasePanelConfig basePanelConfig = (BasePanelConfig)((Object)objPanel);
            String strResourceId = basePanelConfig.getResourceId();
            if (iUserPrivilegeMgr != null && StringHelper.Length((String)strResourceId) > 0 && !iUserPrivilegeMgr.Test(webContext, strResourceId)) {
                return null;
            }
        }
        if (objPanel instanceof RealTabPageConfig) {
            return new SRFExRealTabPage();
        }
        if (objPanel instanceof LinkTabPageConfig) {
            return new SRFExLinkTabPage();
        }
        if (objPanel instanceof RemoteTabPageConfig) {
            return new SRFExRemoteTabPage();
        }
        if (objPanel instanceof TabPageConfig) {
            return new SRFExTabPage();
        }
        return null;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.tabPanelBuilder == null) {
                return;
            }
            this.tabPanelBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.tabPanelBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.tabPanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_TABPANEL, this.getTabPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof TabPanelBuilder) {
            this.tabPanelBuilder = (TabPanelBuilder)builder;
        }
    }
}

