/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.GroupPanelBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExGroupPanel;
import SA.SRFramework.WebEx.UI.GroupPanelConfig;
import java.io.Writer;

public class DefaultGroupPanelBuilder
extends GroupPanelBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExGroupPanel groupPanel) {
        try {
            GroupPanelConfig groupPanelConfig = groupPanel.getGroupPanelConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            if (groupPanelConfig.getWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)groupPanelConfig.getWidth()));
            }
            if (groupPanelConfig.getHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)groupPanelConfig.getHeight()));
            }
            if (!groupPanelConfig.getShowCaptionBar()) {
                String strClass = "sx-grouppanel";
                if (StringHelper.Length((String)groupPanelConfig.getCssClass()) > 0) {
                    strClass = groupPanelConfig.getCssClass();
                }
                writer.write("<DIV");
                DefaultGroupPanelBuilder.OutputAttribute(writer, "id", groupPanel.getUniqueID());
                DefaultGroupPanelBuilder.OutputAttribute(writer, "class", strClass);
                DefaultGroupPanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + groupPanelConfig.getExtStyle());
                writer.write(" >");
                writer.write("<FIELDSET>");
                if (StringHelper.Length((String)groupPanelConfig.getCaption()) > 0) {
                    String strCaptionCssClass = "sx-groupcaption";
                    if (StringHelper.Length((String)groupPanelConfig.getCaptionCssClass()) > 0) {
                        strCaptionCssClass = groupPanelConfig.getCaptionCssClass();
                    }
                    writer.write(StringHelper.Format((String)"<LEGEND ><SPAN class=\"%1$s\">%2$s</SPAN></LEGEND>", (Object)strCaptionCssClass, (Object)groupPanelConfig.getCaption()));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExGroupPanel groupPanel) {
        try {
            GroupPanelConfig groupPanelConfig = groupPanel.getGroupPanelConfig();
            if (!groupPanelConfig.getShowCaptionBar()) {
                writer.write("</FIELDSET>");
                writer.write("</DIV>");
            }
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
        return "GROUPPANEL";
    }
}

