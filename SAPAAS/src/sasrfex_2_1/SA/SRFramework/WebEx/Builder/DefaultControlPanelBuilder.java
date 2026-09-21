/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.ControlPanelBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExControlPanel;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import java.io.Writer;

public class DefaultControlPanelBuilder
extends ControlPanelBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExControlPanel controlPanel) {
        try {
            ControlPanelConfig controlPanelConfig = controlPanel.getControlPanelConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", controlPanelConfig.getWidthString());
            styleBuilder.AddStyle("height", controlPanelConfig.getHeightString());
            String strClass = "sx-ctrlpanel";
            if (StringHelper.Length((String)controlPanelConfig.getCssClass()) > 0) {
                strClass = controlPanelConfig.getCssClass();
            }
            writer.write("<DIV");
            DefaultControlPanelBuilder.OutputAttribute(writer, "id", controlPanel.getUniqueID());
            DefaultControlPanelBuilder.OutputAttribute(writer, "class", strClass);
            DefaultControlPanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + controlPanelConfig.getExtStyle());
            writer.write(" >");
            writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            writer.write("<tr>");
            if (StringHelper.Length((String)controlPanelConfig.getCaption()) > 0) {
                if (controlPanelConfig.getCaptionOnTop()) {
                    if (controlPanelConfig.getAutoErrorRegion()) {
                        writer.write("<td colspan='2' class='sx-cl-top-tb' width='100%'>");
                    } else {
                        writer.write("<td class='sx-cl-top-tb' width='100%'>");
                    }
                } else if (controlPanelConfig.getCaptionWidth() > 0) {
                    writer.write(StringHelper.Format((String)"<td class='sx-cl-tb' width='%1$s'>", (Object)controlPanelConfig.getCaptionWidth()));
                } else {
                    writer.write("<td class='sx-cl-tb'>");
                }
                String strCaptionCssClass = "sx-cp-lb";
                if (!controlPanelConfig.getAllowEmpty()) {
                    strCaptionCssClass = "sx-cp-lb2";
                }
                if (StringHelper.Length((String)controlPanelConfig.getCaptionCssClass()) > 0) {
                    strCaptionCssClass = controlPanelConfig.getCaptionCssClass();
                }
                if (StringHelper.Length((String)controlPanelConfig.getTips()) > 0) {
                    writer.write(StringHelper.Format((String)"<IMG src='../sasrfex/images/default/icon_t.gif' alt='%1$s' align='absmiddle'>", (Object)controlPanelConfig.getTips()));
                }
                writer.write("<SPAN");
                DefaultControlPanelBuilder.OutputAttribute(writer, "class", strCaptionCssClass);
                DefaultControlPanelBuilder.OutputAttribute(writer, "style", controlPanelConfig.getCaptionExtStyle());
                writer.write(" >");
                writer.write(controlPanelConfig.getCaption());
                writer.write("</SPAN>");
                writer.write("</td>");
                if (controlPanelConfig.getCaptionOnTop()) {
                    writer.write("</tr><tr>");
                }
            }
            writer.write("<td class='sx-ci-tb'>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExControlPanel controlPanel) {
        try {
            writer.write("</td>");
            ControlPanelConfig controlPanelConfig = controlPanel.getControlPanelConfig();
            if (controlPanelConfig.getAutoErrorRegion()) {
                writer.write("<td ");
                DefaultControlPanelBuilder.OutputAttribute(writer, "width", "5");
                writer.write(">");
                writer.write("<DIV");
                DefaultControlPanelBuilder.OutputAttribute(writer, "id", StringHelper.Format((String)"E%1$s", (Object)controlPanel.getUniqueID()));
                DefaultControlPanelBuilder.OutputAttribute(writer, "class", "sx-cp-er");
                writer.write("></DIV>");
                writer.write("</td>");
            }
            writer.write("</tr></table>");
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
        return "CONTROLPANEL";
    }
}

