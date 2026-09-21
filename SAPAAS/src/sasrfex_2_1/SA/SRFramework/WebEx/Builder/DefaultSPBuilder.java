/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.SearchPanelBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExSearchPanel;
import SA.SRFramework.WebEx.UI.SearchPanelConfig;
import java.io.Writer;

public class DefaultSPBuilder
extends SearchPanelBuilder {
    @Override
    public void RenderBegin(Writer writer, SRFExSearchPanel searchPanel) {
        try {
            SearchPanelConfig searchPanelConfig = searchPanel.getSearchPanelConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            if (searchPanelConfig.getWidth() > 0) {
                styleBuilder.AddStyle("width", StringHelper.Format((String)"%1$spx", (Object)searchPanelConfig.getWidth()));
            }
            if (searchPanelConfig.getHeight() > 0) {
                styleBuilder.AddStyle("height", StringHelper.Format((String)"%1$spx", (Object)searchPanelConfig.getHeight()));
            }
            String strClass = "sx-panel";
            if (StringHelper.Length((String)searchPanelConfig.getCssClass()) > 0) {
                strClass = searchPanelConfig.getCssClass();
            }
            writer.write("<DIV");
            DefaultSPBuilder.OutputAttribute(writer, "id", searchPanel.getUniqueID());
            DefaultSPBuilder.OutputAttribute(writer, "class", strClass);
            DefaultSPBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + searchPanelConfig.getExtStyle());
            writer.write(" >");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void RenderEnd(Writer writer, SRFExSearchPanel searchPanel) {
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
        return "SEARCHPANEL";
    }
}

