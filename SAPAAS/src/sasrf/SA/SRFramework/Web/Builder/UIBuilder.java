/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web.Builder;

import SA.SRFramework.Web.WebContext;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class UIBuilder {
    protected WebContext webContext = null;
    protected String strControlId = "";
    protected int nHeight = 400;
    protected int nWidth = 200;

    public void Render(JspWriter output) throws IOException {
    }

    public void setCurWebContext(WebContext value) {
        this.webContext = value;
    }

    public void setControlId(String value) {
        this.strControlId = value;
    }

    public void setHeight(int value) {
        this.nHeight = value;
    }

    public void setWidth(int value) {
        this.nWidth = value;
    }
}

