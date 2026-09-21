/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.MainViewBuilder;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class DefaultMainViewBuilder
extends MainViewBuilder {
    protected int nFrameBorder = 0;
    protected int nMarginHeight = 0;
    protected int nMarginWidth = 0;
    protected String strScrolling = "no";
    protected String strURL = "";

    @Override
    public void Render(JspWriter output) throws IOException {
        if (this.mainViewConfig == null) {
            return;
        }
        if (StringHelper.StringLength(this.strCustomPath) != 0) {
            this.strURL = this.strCustomPath;
        }
        output.print("<iframe ");
        output.print(String.format(" name=\"%1$s\"", this.strMainViewId));
        output.print(String.format(" width=\"%1$d\"", this.nWidth));
        output.print(String.format(" frameBorder=\"%1$d\"", this.nFrameBorder));
        output.print(String.format(" marginheight=\"%1$d\"", this.nMarginHeight));
        output.print(String.format(" marginwidth=\"%1$d\"", this.nMarginWidth));
        output.print(String.format(" height=\"%1$d\"", this.nHeight));
        output.print(String.format(" src=\"%1$s\"", this.strURL));
        output.print(String.format(" scrolling=\"%1$s\"", this.strScrolling));
        output.print(" ></iframe>");
    }
}

