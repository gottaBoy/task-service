/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFTextBox
extends SRFWebControl
implements IWebCtrl {
    private String strText = "";
    protected int curTextBoxMode = 3;
    protected int curRows = 1;
    private boolean readOnly = false;

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String strTagHeader = "";
            if (this.curTextBoxMode == 3) {
                output.print("<input type=\"text\" ");
                this.OutputName(output);
                this.OutputID(output);
                if (StringHelper.StringLength(this.strText) != 0) {
                    this.getAttributes().Set("value", this.strText);
                }
                if (this.getReadOnly()) {
                    this.getAttributes().Set("readonly", "readonly");
                }
                this.OutputWebControlAttr(output);
                output.print("/>");
            } else if (this.curTextBoxMode == 2) {
                output.print("<input type=\"password\" ");
                this.OutputName(output);
                this.OutputID(output);
                if (this.getReadOnly()) {
                    this.getAttributes().Set("readonly", "readonly");
                }
                this.OutputWebControlAttr(output);
                output.print("/>");
            } else {
                output.print("<textarea  ");
                this.OutputName(output);
                this.OutputID(output);
                this.getAttributes().Set("rows", Integer.valueOf(this.getRows()).toString());
                if (this.getReadOnly()) {
                    this.getAttributes().Set("readonly", "readonly");
                }
                this.OutputWebControlAttr(output);
                output.print(">");
                if (StringHelper.StringLength(this.strText) > 0) {
                    output.print(this.strText);
                }
                output.print("</textarea>");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getText() {
        return this.strText;
    }

    public void setText(String value) {
        this.strText = value;
    }

    @Override
    public void SetStrValue(String strValue) {
        this.setText(strValue);
    }

    @Override
    public String GetCtrlValue() {
        return this.getText();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    public int getTextMode() {
        return this.curTextBoxMode;
    }

    public void setTextMode(int value) {
        this.curTextBoxMode = value;
    }

    public int getRows() {
        return this.curRows;
    }

    public void setRows(int value) {
        this.curRows = value;
    }

    @Override
    protected boolean OnInitFromRequest() {
        this.setText(this.getPage().getRequest().getParameter(this.getUniqueID()));
        return false;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean getReadOnly() {
        return this.readOnly;
    }
}

