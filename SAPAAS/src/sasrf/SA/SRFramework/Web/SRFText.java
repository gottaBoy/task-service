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
import SA.SRFramework.Web.WebUtility;
import javax.servlet.jsp.JspWriter;

public class SRFText
extends SRFWebControl
implements IWebCtrl {
    private String strText = "";

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<span  ");
            this.OutputStyle();
            this.OutputAttributes(output);
            output.print(">");
            if (StringHelper.StringLength(this.strText) != 0) {
                output.print(WebUtility.TextToHTML(this.strText));
            } else {
                output.print("&nbsp;");
            }
            output.print("</span>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
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

    @Override
    protected boolean OnReadFromViewStates() {
        String strKey = String.valueOf(this.getUniqueID()) + "_TEXT";
        Object objValue = this.getPage().getViewStates().Get(strKey);
        if (objValue != null) {
            this.strText = (String)objValue;
        }
        return false;
    }

    @Override
    protected boolean OnWriteToViewStates() {
        if (StringHelper.StringLength(this.strText) != 0) {
            String strKey = String.valueOf(this.getUniqueID()) + "_TEXT";
            this.getPage().getViewStates().Set(strKey, this.strText);
        }
        return false;
    }
}

