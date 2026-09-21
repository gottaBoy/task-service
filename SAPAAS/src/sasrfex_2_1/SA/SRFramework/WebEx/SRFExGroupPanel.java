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
import SA.SRFramework.WebEx.Builder.GroupPanelBuilder;
import SA.SRFramework.WebEx.SRFExBasePanel;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.GroupPanelConfig;
import java.io.Writer;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExGroupPanel
extends SRFExBasePanel {
    protected GroupPanelConfig panelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExGroupPanel.class);
    protected GroupPanelBuilder groupPanelBuilder = null;
    public static String BUILDER_GROUPPANEL = "GROUPPANEL";

    public GroupPanelConfig getGroupPanelConfig() {
        return this.panelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.panelConfig = null;
        if (this.config != null && this.config instanceof GroupPanelConfig) {
            this.panelConfig = (GroupPanelConfig)this.config;
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
                SRFExControl childPanel = SRFExGroupPanel.CreatePanel(objPanel);
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
            if (this.groupPanelBuilder == null) {
                return;
            }
            this.groupPanelBuilder.RenderBegin(writer, this);
            super.OnRender(writer);
            this.groupPanelBuilder.RenderEnd(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.groupPanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_GROUPPANEL, this.getGroupPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof GroupPanelBuilder) {
            this.groupPanelBuilder = (GroupPanelBuilder)builder;
        }
    }
}

