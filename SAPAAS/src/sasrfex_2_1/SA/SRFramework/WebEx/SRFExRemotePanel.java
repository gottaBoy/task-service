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
import SA.SRFramework.WebEx.Builder.RemotePanelBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExRemotePanel
extends SRFExControl
implements INamingContainer {
    protected RemotePanelConfig remotePanelConfig = null;
    private static final Log log = LogFactory.getLog(SRFExRemotePanel.class);
    protected RemotePanelBuilder remotePanelBuilder = null;
    public static String BUILDER_REMOTEPANEL = "REMOTEPANEL";

    @Override
    protected XMLConfig CreateConfig() {
        return new RemotePanelConfig();
    }

    public RemotePanelConfig getRemotePanelConfig() {
        return this.remotePanelConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.remotePanelConfig = null;
        if (this.config != null && this.config instanceof RemotePanelConfig) {
            this.remotePanelConfig = (RemotePanelConfig)this.config;
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
            if (this.remotePanelBuilder == null) {
                return;
            }
            this.remotePanelBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.remotePanelBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_REMOTEPANEL, this.getRemotePanelConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof RemotePanelBuilder) {
            this.remotePanelBuilder = (RemotePanelBuilder)builder;
        }
    }
}

