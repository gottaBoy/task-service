/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFImage
extends SRFWebControl {
    private String alternateText = "";
    private String imageAlign = "";
    private String imageUrl = "";

    public SRFImage() {
        this.getAttributes().Set("border", "0");
    }

    public void setAlternateText(String alternateText) {
        this.alternateText = alternateText;
    }

    public void setImageAlign(String imageAlign) {
        this.imageAlign = imageAlign;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAlternateText() {
        return this.alternateText;
    }

    public String getImageAlign() {
        return this.imageAlign;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<img ");
            this.OutputID(output);
            this.OutputName(output);
            this.OutputImageAttr();
            this.OutputWebControlAttr(output);
            output.print(" />");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    protected void OutputImageAttr() {
        if (StringHelper.StringLength(this.imageAlign) != 0) {
            this.getAttributes().Set("align", this.imageAlign);
        }
        if (StringHelper.StringLength(this.imageUrl) != 0) {
            this.getAttributes().Set("src", this.imageUrl);
        }
        this.getAttributes().Set("alt", this.alternateText);
    }
}

