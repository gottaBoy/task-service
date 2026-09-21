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

public class TableControlPanelBuilder
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
            TableControlPanelBuilder.OutputAttribute(writer, "id", controlPanel.getUniqueID());
            TableControlPanelBuilder.OutputAttribute(writer, "class", strClass);
            TableControlPanelBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + controlPanelConfig.getExtStyle());
            writer.write(" >");
            writer.write("<table width='100%' border='0' cellspacing='0' cellpadding='0'>");
            writer.write("<tr>");
            if (StringHelper.Length((String)controlPanelConfig.getCaption()) > 0) {
                int nCaptionWidth = 60;
                if (controlPanelConfig.getCaptionWidth() != 0) {
                    nCaptionWidth = controlPanelConfig.getCaptionWidth();
                }
                writer.write(StringHelper.Format((String)"<td width='%1$spx' align='right' style='padding-right:2px;padding-top: 1px;'>", (Object)nCaptionWidth));
                String strCaptionCssClass = "sx-cp-lb";
                if (!controlPanelConfig.getAllowEmpty()) {
                    strCaptionCssClass = "sx-cp-lb2";
                }
                if (StringHelper.Length((String)controlPanelConfig.getCaptionCssClass()) > 0) {
                    strCaptionCssClass = controlPanelConfig.getCaptionCssClass();
                }
                if (StringHelper.Length((String)controlPanelConfig.getTips()) > 0) {
                    writer.write(StringHelper.Format((String)"<IMG src='../sasrfex/images/default/icon_t.gif' alt='%1$s' align='absmiddle' style=\"float:right\">", (Object)controlPanelConfig.getTips()));
                }
                writer.write("<SPAN");
                TableControlPanelBuilder.OutputAttribute(writer, "class", strCaptionCssClass);
                TableControlPanelBuilder.OutputAttribute(writer, "style", controlPanelConfig.getCaptionExtStyle());
                writer.write(" >");
                writer.write(controlPanelConfig.getCaption());
                writer.write("</SPAN>");
                writer.write("</td>");
            }
            writer.write("<td>");
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
                writer.write("<td width='6px'>");
                writer.write("<DIV");
                TableControlPanelBuilder.OutputAttribute(writer, "id", StringHelper.Format((String)"E%1$s", (Object)controlPanel.getUniqueID()));
                TableControlPanelBuilder.OutputAttribute(writer, "class", "sx-cp-er");
                writer.write("></DIV>");
                writer.write("</td>");
            }
            writer.write("</tr></table></DIV>");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getBuilderMode() {
        return "TABLE";
    }

    @Override
    public String getBuilderName() {
        return "CONTROLPANEL";
    }
}

