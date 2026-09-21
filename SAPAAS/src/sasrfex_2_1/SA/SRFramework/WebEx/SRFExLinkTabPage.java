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
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.LinkTabPageConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExLinkTabPage
extends SRFExControl {
    protected LinkTabPageConfig linkTabPageConfig = null;
    private static final Log log = LogFactory.getLog(SRFExLinkTabPage.class);

    public LinkTabPageConfig getLinkTabPageConfig() {
        return this.linkTabPageConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.linkTabPageConfig = null;
        if (this.config != null && this.config instanceof LinkTabPageConfig) {
            this.linkTabPageConfig = (LinkTabPageConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", "100%");
            styleBuilder.AddStyle("height", "40px");
            String strClass = "sx-tabpage";
            if (StringHelper.Length((String)this.linkTabPageConfig.getCssClass()) > 0) {
                strClass = this.linkTabPageConfig.getCssClass();
            }
            writer.write("<DIV ");
            SRFExLinkTabPage.OutputAttribute(writer, "id", this.getUniqueID());
            SRFExLinkTabPage.OutputAttribute(writer, "class", strClass);
            SRFExLinkTabPage.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + this.linkTabPageConfig.getExtStyle());
            writer.write(StringHelper.Format((String)" ><SPAN class='sx-normaltext'>\u52a0\u8f7d\u8fc7\u7a0b\u4e2d...</SPAN></DIV>"));
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }
}

