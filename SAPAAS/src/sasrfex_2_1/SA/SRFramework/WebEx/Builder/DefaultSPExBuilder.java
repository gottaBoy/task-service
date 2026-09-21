/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.SearchPanelExBuilder;
import SA.SRFramework.WebEx.Builder.StyleBuilder;
import SA.SRFramework.WebEx.SRFExSearchPanelEx;
import SA.SRFramework.WebEx.UI.SearchPanelExConfig;
import java.io.Writer;

public class DefaultSPExBuilder
extends SearchPanelExBuilder {
    @Override
    public void Render(Writer writer, SRFExSearchPanelEx searchPanel) {
        try {
            SearchPanelExConfig searchPanelConfig = searchPanel.getSearchPanelExConfig();
            StyleBuilder styleBuilder = new StyleBuilder();
            styleBuilder.AddStyle("width", searchPanelConfig.getWidthString());
            styleBuilder.AddStyle("height", searchPanelConfig.getHeightString());
            writer.write("<table border='0' cellspacing='0' cellpadding='0'");
            DefaultSPExBuilder.OutputAttribute(writer, "id", searchPanel.getUniqueID());
            DefaultSPExBuilder.OutputAttribute(writer, "class", searchPanelConfig.getCssClass());
            DefaultSPExBuilder.OutputAttribute(writer, "style", String.valueOf(styleBuilder.ToStyleList()) + searchPanelConfig.getExtStyle());
            writer.write("><tr><td>");
            searchPanel.RenderChild(writer, "Panel");
            writer.write("</td><td width='100' style='padding-bottom:1px;'>");
            searchPanel.RenderChild(writer, "BTN_SEARCH");
            writer.write("<div style=\"float:left;width:5px\"></DIV>");
            searchPanel.RenderChild(writer, "BTN_RESET");
            writer.write("</td></tr></table>");
            if (searchPanelConfig.getSearchOnReady()) {
                searchPanel.getPage().RegisterOnReadyScript(5, StringHelper.Format((String)"%1$s.search();", (Object)searchPanel.getSearchForm().getFormId()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

