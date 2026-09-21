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

public class SRFCheckBoxList
extends SRFRepeatListControl
implements IWebCtrl {
    protected String strSeparator = "|";

    @Override
    protected boolean OnInitFromRequest() {
        int nItemCount = this.getItems().size();
        int i = 0;
        while (i < nItemCount) {
            ListItem tempItem = this.getItems().Get(i);
            String strReqId = String.format("%1$s:%2$d", this.getUniqueID(), i);
            String strReqValue = this.getPage().getRequest().getParameter(strReqId);
            tempItem.setSelected(strReqValue != null);
            if (tempItem.getSelected() && StringHelper.StringLength(this.getSelectedValue()) == 0) {
                this.setSelectedValue(tempItem.getValue());
            }
            ++i;
        }
        return false;
    }

    @Override
    protected void OutputItem(JspWriter output, int nItemIndex, String strBoxClass, String strLableClass, boolean bSpanTag, String strUniqueId2) throws IOException {
        ListItem tempItem = this.getItems().Get(nItemIndex);
        output.print(String.format("<input id=\"%1$s_%3$d\" type=\"checkbox\" name=\"%2$s:%3$d\"", strUniqueId2, this.getUniqueID(), nItemIndex));
        if (tempItem.getSelected()) {
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
        if (StringHelper.StringLength(strValue) == 0) {
            return;
        }
        if (StringHelper.StringLength(this.strSeparator) == 0) {
            return;
        }
        String[] strPart = strValue.split(this.strSeparator);
        this.getItems().CheckAll(false);
        int i = 0;
        while (i < strPart.length) {
            ListItem item = this.getItems().FindByValue(strPart[i]);
            if (item != null) {
                item.setSelected(true);
            }
            ++i;
        }
    }

    @Override
    public String GetCtrlValue() {
        String strOutput = "";
        if (StringHelper.StringLength(this.strSeparator) == 0) {
            return strOutput;
        }
        int nItemCount = this.getItems().size();
        int i = 0;
        while (i < nItemCount) {
            ListItem item = this.getItems().Get(i);
            if (item != null && item.getSelected()) {
                if (StringHelper.StringLength(strOutput) != 0) {
                    strOutput = String.valueOf(strOutput) + this.strSeparator;
                }
                strOutput = String.valueOf(strOutput) + item.getValue();
            }
            ++i;
        }
        return strOutput;
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String value) {
        this.strSeparator = value;
    }
}

