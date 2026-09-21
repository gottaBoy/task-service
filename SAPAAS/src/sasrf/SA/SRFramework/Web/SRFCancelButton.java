/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFImage;
import javax.servlet.jsp.JspWriter;

public class SRFCancelButton
extends SRFImage {
    @Override
    protected void OnRender(JspWriter output) {
        try {
            int nCurPageStyle = this.getWebContext().getCurPageStyle();
            if (nCurPageStyle == 1) {
                if (this.getWebContext().getReload()) {
                    output.print("<a href=\"javascript:closedialog('true')\">");
                } else {
                    output.print("<a href=\"javascript:closedialog('')\">");
                }
            } else if (StringHelper.StringLength(this.getWebContext().getRU()) == 0) {
                output.print("<a href='javascript:history.go(-1)'>");
            } else {
                output.print(String.format("<a href='%1$s'>", this.getWebContext().getRU()));
            }
            super.OnRender(output);
            output.print("</a>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }
}

