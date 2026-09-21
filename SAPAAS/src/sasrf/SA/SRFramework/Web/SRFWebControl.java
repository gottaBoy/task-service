/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.AttributeCollection;
import SA.SRFramework.Web.SRFControl;
import javax.servlet.jsp.JspWriter;

public abstract class SRFWebControl
extends SRFControl {
    public static final String ERRORVALUE = "$$SRFWEBCONTROLERRORVALUE$$";
    private AttributeCollection attributes = new AttributeCollection();
    private String strCssClass = "";
    private boolean bEnabled = true;
    private int nHeight = -1;
    private int nWidth = -1;
    private String toolTip = "";

    public AttributeCollection getAttributes() {
        return this.attributes;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public String getCssClass() {
        return this.strCssClass;
    }

    public void setCssClass(String strValue) {
        this.strCssClass = strValue;
    }

    public boolean getEnabled() {
        return this.bEnabled;
    }

    public void setEnabled(boolean bValue) {
        this.bEnabled = bValue;
    }

    public int getHeight() {
        return this.nHeight;
    }

    public void setHeight(int nValue) {
        this.nHeight = nValue;
    }

    public int getWidth() {
        return this.nWidth;
    }

    public void setWidth(int nValue) {
        this.nWidth = nValue;
    }

    public String getStyle() {
        String strStyle = "";
        if (this.nWidth > 0) {
            strStyle = String.valueOf(strStyle) + String.format("width:%1$dpx;", this.nWidth);
        }
        if (this.nHeight > 0) {
            strStyle = String.valueOf(strStyle) + String.format("height:%1$dpx;", this.nHeight);
        }
        return strStyle;
    }

    protected void OutputAttributes(JspWriter output) {
        try {
            output.print(this.attributes.ToOutputString());
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    protected void OutputWebControlAttr(JspWriter output) {
        this.OutputToolTip();
        this.OutputDisable();
        this.OutputStyle();
        this.OutputAttributes(output);
    }

    protected void OutputToolTip() {
        if (StringHelper.StringLength(this.getToolTip()) != 0) {
            this.attributes.Set("title", this.getToolTip());
        }
    }

    protected void OutputDisable() {
        if (!this.getEnabled()) {
            this.attributes.Set("disabled", "disabled");
        }
    }

    protected void OutputStyle() {
        String strStyle;
        if (StringHelper.StringLength(this.strCssClass) != 0) {
            this.attributes.Set("class", this.strCssClass);
        }
        if (StringHelper.StringLength(strStyle = this.getStyle()) != 0) {
            this.attributes.Set("style", strStyle);
        }
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }
}

