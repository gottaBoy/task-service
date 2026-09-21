/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.DGEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.DGEx.DGExBuilder;
import SA.SRFramework.WebEx.DGEx.UI.DGExConfig;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.SRFExControl;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDGEx
extends SRFExControl {
    protected DGExConfig DGExConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDPEx.class);
    protected DGExBuilder dgExBuilder = null;
    public static String BUILDER_DGEX = "DGEX";

    public DGExConfig getDGExConfig() {
        return this.DGExConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.DGExConfig = null;
        if (this.config != null && this.config instanceof DGExConfig) {
            this.DGExConfig = (DGExConfig)this.config;
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
            if (this.dgExBuilder == null) {
                return;
            }
            this.dgExBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.dgExBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_DGEX, this.getDGExConfig().getRenderMode());
        if (builder == null) {
            log.error((Object)StringHelper.Format((String)"\u6269\u5c55\u8868\u683c\u7ed8\u5236\u5668\u65e0\u6548"));
            return;
        }
        if (builder instanceof DGExBuilder) {
            this.dgExBuilder = (DGExBuilder)builder;
        }
    }
}

