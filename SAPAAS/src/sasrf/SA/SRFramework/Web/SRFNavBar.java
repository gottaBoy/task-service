/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFNavBar
extends SRFWebControl {
    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<span class=\"normaltext\"><a href=\"javascript:alert('\u5f53\u524d\u7248\u672c\u6682\u4e0d\u63d0\u4f9b\u5e2e\u52a9')\">\u5e2e\u52a9</a></span>&nbsp;");
            output.print("<span class=\"normaltext\">");
            if (this.getWebContext().getCurPageStyle() == 1) {
                output.print("<a href=\"javascript:closedialog('false')\">");
            } else {
                output.print("<a href='javascript:history.go(-1)'>");
            }
            output.print("\u8fd4\u56de</a></span>");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

