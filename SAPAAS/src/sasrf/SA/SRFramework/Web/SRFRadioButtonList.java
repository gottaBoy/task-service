/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.SRFRepeatListControl;
import SA.SRFramework.Web.WebUtility;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;

public class SRFRadioButtonList
extends SRFRepeatListControl
implements IWebCtrl {
    @Override
    protected boolean OnInitFromRequest() {
        this.setSelectedValue(this.getPage().getRequest().getParameter(this.getUniqueID()));
        return false;
    }

    @Override
    protected void OutputItem(JspWriter output, int nItemIndex, String strBoxClass, String strLableClass, boolean bSpanTag, String strUniqueId2) throws IOException {
        ListItem tempItem = this.getItems().Get(nItemIndex);
        output.print(String.format("<input id=\"%1$s_%3$d\" type=\"radio\" name=\"%2$s\" value=\"%4$s\"", strUniqueId2, this.getUniqueID(), nItemIndex, tempItem.getValue()));
        if (this.getSelectedValue() != null && tempItem.getValue().compareTo(this.getSelectedValue()) == 0) {
            output.print(" checked=\"checked\"");
        }
        if (StringHelper.StringLength(strBoxClass) != 0) {
            output.print(String.format(" class=\"%1$s\"", strBoxClass));
        }
        output.print("/>");
        if (bSpanTag) {
            output.print(String.format("<span class=\"%1$s\">", strLableClass));
        }
        if (this.getTextIsLiteral()) {
            output.print(tempItem.getText());
        } else {
            output.print(WebUtility.TextToHTML(tempItem.getText()));
        }
        if (bSpanTag) {
            output.print("</span>");
        }
    }

    @Override
    public void SetStrValue(String strValue) {
        this.setSelectedValue(strValue);
    }

    @Override
    public String GetCtrlValue() {
        return this.getSelectedValue();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }
}

