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
import SA.SRFramework.WebEx.Builder.PanelBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.PanelConfig;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExPanel
extends SRFExBasePanel {
    protected PanelConfig panelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExPanel.class);
    protected PanelBuilder panelBuilder = null;
    public static String BUILDER_PANEL = "PANEL";

    public PanelConfig getPanelConfig() {
        return this.panelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.panelConfig = null;
        if (this.config != null && this.config instanceof PanelConfig) {
            this.panelConfig = (PanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        if (this.panelConfig != null) {
            ArrayList panels = this.panelConfig.getPanels();
            int i = 0;
            while (i < panels.size()) {
                Object objPanel = panels.get(i);
                SRFExControl childPanel = SRFExPanel.CreatePanel(objPanel);
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
            if (this.panelBuilder == null) {
                return;
            }
            this.panelBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.panelBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.panelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_PANEL, this.getPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof PanelBuilder) {
            this.panelBuilder = (PanelBuilder)builder;
        }
    }
}

