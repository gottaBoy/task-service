/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.BaseTableCellConfig;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class TableRenderHelper {
    public static void RenderCell(JspWriter output, BaseTableCellConfig cellConfig) throws IOException {
        TableRenderHelper.RenderCell(output, cellConfig, "");
    }

    public static void RenderCell(JspWriter output, BaseTableCellConfig cellConfig, String strExtValue) throws IOException {
        output.print("<td ");
        if (cellConfig.getWidth() != 0) {
            output.print(String.format(" width=\"%1$d\"", cellConfig.getWidth()));
        }
        if (cellConfig.getHeight() != 0) {
            output.print(String.format(" height=\"%1$d\"", cellConfig.getHeight()));
        }
        if (StringHelper.Length(cellConfig.getCSS()) != 0) {
            output.print(String.format(" class=\"%1$s\"", cellConfig.getCSS()));
        }
        if (StringHelper.Length(cellConfig.getAlign()) != 0) {
            output.print(String.format(" align=\"%1$s\"", cellConfig.getAlign()));
        }
        output.print(">");
        if (StringHelper.Length(strExtValue) != 0) {
            output.print(strExtValue);
        } else {
            output.print(cellConfig.getValue());
        }
        output.println("</td>");
    }
}

