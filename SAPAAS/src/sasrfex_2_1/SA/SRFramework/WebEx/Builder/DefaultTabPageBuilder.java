/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.Builder.TabPageBuilder;
import SA.SRFramework.WebEx.SRFExTabPage;
import SA.SRFramework.WebEx.UI.TabPageConfig;
import java.io.Writer;

public class DefaultTabPageBuilder
extends TabPageBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExTabPage tabPage) {
        try {
            TabPageConfig tabPageConfig = tabPage.getTabPageConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", tabPageConfig.getWidthString());
            styleBuilder.AddStyle("height", tabPageConfig.getHeightString());
            String strClass = "x-hide-display";
            if (StringHelper.Length((String)tabPageConfig.getCssClass()) > 0) {
                strClass = tabPageConfig.getCssClass();
            }
            styleBuilder.AddStyle("padding-right", "4px");
            styleBuilder.AddStyle("padding-left", "4px");
            styleBuilder.AddStyle("padding-bottom", "4px");
            styleBuilder.AddStyle("padding-top", "4px");
            styleBuilder.AddStyle("background-color", "#ffffff");
            writer.write("<DIV");
            DefaultTabPageBuilder.OutputAttribute(writer, "id", tabPage.getUniqueID());
            DefaultTabPageBuilder.OutputAttribute(writer, "class", strClass);
            DefaultTabPageBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + tabPageConfig.getExtStyle());
            writer.write(" >");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExTabPage tabPage) {
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
        return "TABPAGE";
    }
}

