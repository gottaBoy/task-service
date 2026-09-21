/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.SRFListControl;
import javax.servlet.jsp.JspWriter;

public class SRFListBox
extends SRFListControl {
    protected String strSeparator = "|";
    protected int nRowCount = 2;
    protected boolean bMultiple = false;

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<select  ");
            this.OutputName(output);
            this.OutputID(output);
            this.getAttributes().Set("size", Integer.valueOf(this.nRowCount).toString());
            if (this.bMultiple) {
                this.getAttributes().Set("multiple", "multiple");
            }
            this.OutputWebControlAttr(output);
            output.print(">");
            String strSelectedText = "selected=\"selected\" ";
            ListItem selectedItem = this.getSelectedItem();
            int nListCount = this.getItems().size();
            int i = 0;
            while (i < nListCount) {
                ListItem tempItem = this.getItems().Get(i);
                output.println(String.format("<option %3$s value=\"%1$s\"  >%2$s</option>", tempItem.getValue(), tempItem.getText(), tempItem.getSelected() ? strSelectedText : ""));
                ++i;
            }
            output.print("</select>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void setSelectedValue(String value) {
        this.strSelectValue = value;
        int nItemCount = this.getItems().size();
        int i = 0;
        while (i < nItemCount) {
            ListItem listItem = this.getItems().Get(i);
            if (StringHelper.Compare(listItem.getValue(), this.strSelectValue, false) == 0) {
                listItem.setSelected(true);
            } else {
                listItem.setSelected(false);
            }
            ++i;
        }
    }

    public int getRowCount() {
        return this.nRowCount;
    }

    public void setRowCount(int value) {
        this.nRowCount = value;
    }

    public void setMultiple(boolean value) {
        this.bMultiple = value;
    }

    public boolean getMultiple() {
        return this.bMultiple;
    }

    @Override
    protected boolean OnInitFromRequest() {
        if (this.bMultiple) {
            String[] strValues = this.getPage().getRequest().getParameterValues(this.getUniqueID());
            if (strValues == null) {
                return false;
            }
            int i = 0;
            while (i < strValues.length) {
                ListItem tempItem = this.getItems().FindByValue(strValues[i]);
                if (tempItem != null) {
                    tempItem.setSelected(true);
                }
                ++i;
            }
        } else {
            this.setSelectedValue(this.getPage().getRequest().getParameter(this.getUniqueID()));
        }
        return false;
    }

    public void SetStrValue(String strValue) {
        this.setSelectedValue(strValue);
    }

    public String GetCtrlValue() {
        return this.getSelectedValue();
    }

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

