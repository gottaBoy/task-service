/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Web.INamingContainer
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.TabPageBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.TabPageConfig;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTabPage
extends SRFExBasePanel
implements INamingContainer {
    protected TabPageConfig tabPageConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTabPage.class);
    protected TabPageBuilder tabPageBuilder = null;
    public static String BUILDER_TABPAGE = "TABPAGE";

    public TabPageConfig getTabPageConfig() {
        return this.tabPageConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.tabPageConfig = null;
        if (this.config != null && this.config instanceof TabPageConfig) {
            this.tabPageConfig = (TabPageConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.tabPageConfig != null) {
            ArrayList panels = this.tabPageConfig.getPanels();
            int i = 0;
            while (i < panels.size()) {
                Object objPanel = panels.get(i);
                SRFExControl childPanel = SRFExTabPage.CreatePanel(objPanel);
                if (childPanel != null) {
                    childPanel.setConfig((XMLConfig)panels.get(i));
                    this.AddControl(childPanel);
                }
                ++i;
            }
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.tabPageBuilder == null) {
                return;
            }
            this.tabPageBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.tabPageBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.tabPageBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_TABPAGE, this.getTabPageConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof TabPageBuilder) {
            this.tabPageBuilder = (TabPageBuilder)builder;
        }
    }
}

