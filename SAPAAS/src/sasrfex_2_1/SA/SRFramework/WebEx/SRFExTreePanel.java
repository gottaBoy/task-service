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
import SA.SRFramework.WebEx.Builder.TreePanelBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.TreePanelConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExTreePanel
extends SRFExControl {
    protected TreePanelConfig treePanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExTreePanel.class);
    protected TreePanelBuilder treePanelBuilder = null;
    public static String BUILDER_TREEPANEL = "TREEPANEL";

    @Override
    protected XMLConfig CreateConfig() {
        return new TreePanelConfig();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    public TreePanelConfig getTreePanelConfig() {
        return this.treePanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.treePanelConfig = null;
        if (this.config != null && this.config instanceof TreePanelConfig) {
            this.treePanelConfig = (TreePanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.treePanelBuilder == null) {
                return;
            }
            this.treePanelBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.treePanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_TREEPANEL, this.getTreePanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof TreePanelBuilder) {
            this.treePanelBuilder = (TreePanelBuilder)builder;
        }
    }
}

