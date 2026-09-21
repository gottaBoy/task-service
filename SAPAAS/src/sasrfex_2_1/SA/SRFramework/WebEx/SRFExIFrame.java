/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Builder.AttributeBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.UI.IFrameConfig;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExIFrame
extends SRFExControl {
    protected IFrameConfig iframeConfig = null;
    private static final Log log = LogFactory.getLog(SRFExIFrame.class);

    @Override
    protected XMLConfig CreateConfig() {
        return new IFrameConfig();
    }

    public IFrameConfig getIFrameConfig() {
        return this.iframeConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.iframeConfig = null;
        if (this.config != null && this.config instanceof IFrameConfig) {
            this.iframeConfig = (IFrameConfig)this.config;
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.RenderIFrame(writer);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void RenderIFrame(Writer writer) throws IOException {
        writer.write("<IFRAME ");
        this.OutputID(writer);
        this.OutputName(writer);
        AttributeBuilder attributesBuilder = new AttributeBuilder();
        attributesBuilder.InitFromHashtable(this.getIFrameConfig().getExtAttributes(), true);
        this.FillAttributeBuilder(attributesBuilder);
        StyleBuilder styleBuilder = new StyleBuilder();
        this.FillStyleBuilder(styleBuilder);
        attributesBuilder.Set("style", String.valueOf(styleBuilder.ToStyleList()) + this.getIFrameConfig().getExtStyle());
        writer.write(attributesBuilder.ToOutputString());
        if (!StringHelper.IsNullOrEmpty((String)this.getIFrameConfig().getScroll())) {
            SRFExIFrame.OutputAttribute(writer, "SCROLLING", this.getIFrameConfig().getScroll());
        }
        SRFExIFrame.OutputAttribute(writer, "frameBorder", StringHelper.Format((String)"%1$s", (Object)this.getIFrameConfig().getFrameBorder()));
        writer.write(">");
        writer.write("</IFRAME>");
        if (!StringHelper.IsNullOrEmpty((String)this.getIFrameConfig().getFrameAlias())) {
            this.getPage().RegisterScript(2, StringHelper.Format((String)"var %1$s='%2$s';", (Object)this.getIFrameConfig().getFrameAlias(), (Object)this.getUniqueID()));
        }
        this.getPage().RegisterOnReadyScript(2, StringHelper.Format((String)"$P.iframe['%1$s']='%1$s';", (Object)this.getUniqueID()));
        if (!StringHelper.IsNullOrEmpty((String)this.getIFrameConfig().getURL())) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("Ext.getDom('%1$s').src='%2$s';", this.getUniqueID(), this.getIFrameConfig().getURL());
            this.getPage().RegisterUncacheOnReadyScript(1, script.toString());
        }
    }
}

