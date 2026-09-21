/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.TabViewBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.UI.TabViewConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTabView
extends SRFExBasePanel {
    protected TabViewConfig tabViewConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTabView.class);
    public static String BUILDER_TABVIEW = "TABVIEW";
    protected TabViewBuilder tabViewBuilder = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new TabViewConfig();
    }

    public TabViewConfig getTabViewConfig() {
        if (this.tabViewConfig == null) {
            this.InitConfig();
        }
        return this.tabViewConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.tabViewConfig = null;
        if (this.config != null && this.config instanceof TabViewConfig) {
            this.tabViewConfig = (TabViewConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.tabViewBuilder == null) {
                return;
            }
            this.tabViewBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.tabViewBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.tabViewBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_TABVIEW, this.getTabViewConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof TabViewBuilder) {
            this.tabViewBuilder = (TabViewBuilder)builder;
        }
    }
}

