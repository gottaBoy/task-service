/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.TipsBarBuilder;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultTipsBarBuilder
extends TipsBarBuilder {
    @Override
    public void Render(JspWriter output) throws IOException {
        if (StringHelper.Length(this.strMessage) != 0) {
            output.print("<TABLE class=\"tipstable\" cellSpacing=\"0\" cellPadding=\"0\" width=\"98%\" align=\"center\" border=\"0\">");
            output.print("<TR>");
            output.print("<TD vAlign=\"top\" width=\"20\"><IMG height=\"12\"  src=\"../images/icon_attention.gif\" width=\"15\"></TD>");
            output.print("<TD vAlign=\"top\" align=\"left\"><span class=\"normaltext\">");
            output.print(this.strMessage);
            output.print("</span></TD>");
            output.print("</TR>");
            output.print("</TABLE>");
        } else {
            output.print("&nbsp;");
        }
    }
}

