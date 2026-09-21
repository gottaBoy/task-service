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
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.RealTabPageConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExRealTabPage
extends SRFExControl
implements INamingContainer {
    protected RealTabPageConfig realTabPageConfig = null;
    private static final Log log = LogFactory.getLog(SRFExRealTabPage.class);

    public RealTabPageConfig getRealTabPageConfig() {
        return this.realTabPageConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.realTabPageConfig = null;
        if (this.config != null && this.config instanceof RealTabPageConfig) {
            this.realTabPageConfig = (RealTabPageConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    @Override
    protected void OnRender(Writer writer) {
    }
}

