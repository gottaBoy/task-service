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
import SA.SRFramework.WebEx.Builder.ShortcutBarBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.ShortcutBarConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExShortcutBar
extends SRFExControl {
    protected ShortcutBarConfig shortcutBarConfig = null;
    private static final Log log = LogFactory.getLog(SRFExShortcutBar.class);
    public static String BUILDER_SHORTCUTBAR = "SHORTCUTBAR";
    protected ShortcutBarBuilder shortcutBarBuilder = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new ShortcutBarConfig();
    }

    public ShortcutBarConfig getShortcutBarConfig() {
        if (this.shortcutBarConfig == null) {
            this.InitConfig();
        }
        return this.shortcutBarConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.shortcutBarConfig = null;
        if (this.config != null && this.config instanceof ShortcutBarConfig) {
            this.shortcutBarConfig = (ShortcutBarConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.shortcutBarBuilder == null) {
                return;
            }
            this.shortcutBarBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.shortcutBarBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.shortcutBarBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_SHORTCUTBAR, this.getShortcutBarConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof ShortcutBarBuilder) {
            this.shortcutBarBuilder = (ShortcutBarBuilder)builder;
        }
    }
}

