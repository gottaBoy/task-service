/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.MainMenuExBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.MenuExConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExMainMenu
extends SRFExControl {
    protected MenuExConfig mainMenuConfig = null;
    private static final Log log = LogFactory.getLog(SRFExMainMenu.class);
    protected MainMenuExBuilder mainMenuExBuilder = null;
    public static String BUILDER_MAINMENUEX = "MAINMENUEX";

    public MenuExConfig getMenuExConfig() {
        if (this.mainMenuConfig == null) {
            this.InitConfig();
        }
        return this.mainMenuConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.mainMenuConfig = null;
        if (this.config != null && this.config instanceof MenuExConfig) {
            this.mainMenuConfig = (MenuExConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.mainMenuExBuilder == null) {
                return;
            }
            this.mainMenuExBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void PrepareBuilder() {
        if (this.mainMenuExBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_MAINMENUEX, this.getMenuExConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof MainMenuExBuilder) {
            this.mainMenuExBuilder = (MainMenuExBuilder)builder;
        }
    }
}

