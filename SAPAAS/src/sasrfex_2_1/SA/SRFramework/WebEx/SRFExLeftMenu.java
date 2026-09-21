/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.LeftMenuExBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExLeftMenu
extends SRFExControl {
    protected MenuExConfig mainExConfig = null;
    private static final Log log = LogFactory.getLog(SRFExLeftMenu.class);
    protected LeftMenuExBuilder leftMenuExBuilder = null;
    public static String BUILDER_LEFTMENUEX = "LEFTMENUEX";

    public MenuExConfig getMenuExConfig() {
        if (this.mainExConfig == null) {
            this.InitConfig();
        }
        return this.mainExConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.mainExConfig = null;
        if (this.config != null && this.config instanceof MenuExConfig) {
            this.mainExConfig = (MenuExConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.leftMenuExBuilder == null) {
                return;
            }
            this.leftMenuExBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void PrepareBuilder() {
        if (this.leftMenuExBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_LEFTMENUEX, this.getMenuExConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof LeftMenuExBuilder) {
            this.leftMenuExBuilder = (LeftMenuExBuilder)builder;
        }
    }
}

