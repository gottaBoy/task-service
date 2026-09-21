/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.INamingContainer
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Web.INamingContainer;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.RemoteTabPageBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.RemoteTabPageConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExRemoteTabPage
extends SRFExControl
implements INamingContainer {
    protected RemoteTabPageConfig remoteTabPageConfig = null;
    private static final Log log = LogFactory.getLog(SRFExRemoteTabPage.class);
    protected RemoteTabPageBuilder remoteTabPageBuilder = null;
    public static String BUILDER_REMOTETABPAGE = "REMOTETABPAGE";

    public RemoteTabPageConfig getRemoteTabPageConfig() {
        return this.remoteTabPageConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.remoteTabPageConfig = null;
        if (this.config != null && this.config instanceof RemoteTabPageConfig) {
            this.remoteTabPageConfig = (RemoteTabPageConfig)this.config;
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
            if (this.remoteTabPageBuilder == null) {
                return;
            }
            this.remoteTabPageBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.remoteTabPageBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_REMOTETABPAGE, this.getRemoteTabPageConfig().getRenderMode());
        if (builder == null) {
            return;
        }
        if (builder instanceof RemoteTabPageBuilder) {
            this.remoteTabPageBuilder = (RemoteTabPageBuilder)builder;
        }
    }
}

