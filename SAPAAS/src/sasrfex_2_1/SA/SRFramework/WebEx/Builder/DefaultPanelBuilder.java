/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.PanelBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExPanel;
import SA.SRFramework.WebEx.UI.PanelConfig;
import java.io.Writer;

public class DefaultPanelBuilder
extends PanelBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExPanel panel) {
        try {
            PanelConfig panelConfig = panel.getPanelConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", panelConfig.getWidthString());
            styleBuilder.AddStyle("height", panelConfig.getHeightString());
            String strClass = "sx-panel";
            if (StringHelper.Length((String)panelConfig.getCssClass()) > 0) {
                strClass = panelConfig.getCssClass();
            }
            writer.write("<DIV");
            DefaultPanelBuilder.OutputAttribute(writer, "id", panel.getUniqueID());
            DefaultPanelBuilder.OutputAttribute(writer, "class", strClass);
            DefaultPanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + panelConfig.getExtStyle());
            writer.write(" >");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExPanel panel) {
        try {
            writer.write("</DIV>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "";
    }

    @Override
    public String getBuilderName() {
        return "PANEL";
    }
}

