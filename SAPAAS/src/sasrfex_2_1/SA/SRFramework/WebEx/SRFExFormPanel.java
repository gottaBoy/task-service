/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.FormPanelBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExPanel;
import SA.SRFramework.WebEx.UI.FormPanelConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExFormPanel
extends SRFExControl {
    protected FormPanelBuilder formPanelBuilder = null;
    protected FormPanelConfig formPanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExFormPanel.class);
    public static final String BUILDER_FORMPANEL = "FORMPANEL";

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.formPanelConfig = null;
        if (this.config != null && this.config instanceof FormPanelConfig) {
            this.formPanelConfig = (FormPanelConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        SRFExPanel panel = new SRFExPanel();
        if (this.formPanelConfig != null) {
            panel.setConfig(this.formPanelConfig.getPanel());
        } else {
            panel.InitConfig();
        }
        panel.setID(StringHelper.Format((String)"%1$s_%2$s", (Object)"PANEL", (Object)this.getID()));
        this.AddControl(panel);
    }

    public FormPanelConfig getFormPanelConfig() {
        if (this.config == null) {
            this.getConfig();
        }
        return this.formPanelConfig;
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.formPanelBuilder == null) {
                writer.write("<!-- \u6784\u5efa\u5668\u65e0\u6548 -->");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        super.OnRender(writer);
    }

    protected void PrepareBuilder() {
        if (this.formPanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_FORMPANEL, this.getFormPanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof FormPanelBuilder) {
            this.formPanelBuilder = (FormPanelBuilder)builder;
        }
    }
}

