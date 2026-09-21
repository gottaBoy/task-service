/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.IWebCtrl2;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.SRFListControl;
import SA.SRFramework.Web.SelectedIndexChangedListener;
import java.util.EventObject;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public class SRFDropDownList
extends SRFListControl
implements IWebCtrl,
IWebCtrl2 {
    private int nCurSelectIndex = -1;
    private int nLastSelectIndex = -1;
    protected String strSeparator = "|";
    transient Vector selectedIndexChangedListeners;

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<select  ");
            this.OutputName(output);
            this.OutputID(output);
            this.OutputWebControlAttr(output);
            if (this.getAutoPostBack()) {
                output.print(" ");
                this.OutputProperty(output, "onchange", String.format("__doPostBack('%1$s','')", this.getUniqueID().replace(":", "$")));
            }
            output.print(">");
            String strSelectedText = "selected=\"selected\" ";
            ListItem selectedItem = this.getSelectedItem();
            int nListCount = this.getItems().size();
            int i = 0;
            while (i < nListCount) {
                ListItem tempItem = this.getItems().Get(i);
                output.println(String.format("<option %3$s value=\"%1$s\"  >%2$s</option>", tempItem.getValue(), tempItem.getText(), selectedItem == tempItem ? strSelectedText : ""));
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
        if (value == null) {
            value = "";
        }
        this.strSelectValue = value;
        int nItemCount = this.getItems().size();
        int i = 0;
        while (i < nItemCount) {
            ListItem listItem = this.getItems().Get(i);
            if (listItem.getValue().compareToIgnoreCase(this.strSelectValue) == 0) {
                listItem.setSelected(true);
            } else {
                listItem.setSelected(false);
            }
            ++i;
        }
        this.CalcSelectedIndex();
    }

    @Override
    protected boolean OnInitFromRequest() {
        this.setSelectedValue(this.getPage().getRequest().getParameter(this.getUniqueID()));
        return false;
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

    @Override
    public String GetUrlValue() {
        ListItem listItem = this.getSelectedItem();
        if (listItem == null) {
            return "";
        }
        return StringHelper.Format("%1$s%2$s%3$s", listItem.getValue(), this.strSeparator, listItem.getText());
    }

    @Override
    public void SetUrlValue(String strValue) {
        String strHiddenValue = "";
        if (StringHelper.StringLength(this.strSeparator) != 0) {
            int nPos = strValue.indexOf(this.strSeparator);
            strHiddenValue = nPos != -1 ? strValue.substring(0, nPos) : strValue;
        }
        this.SetStrValue(strHiddenValue);
    }

    public synchronized void addSelectedIndexChangedListener(SelectedIndexChangedListener l) {
        if (this.selectedIndexChangedListeners == null) {
            this.selectedIndexChangedListeners = new Vector();
        }
        this.selectedIndexChangedListeners.add(l);
    }

    public synchronized void removeSelectedIndexChangedListener(SelectedIndexChangedListener l) {
        if (this.selectedIndexChangedListeners == null) {
            return;
        }
        this.selectedIndexChangedListeners.remove(l);
        if (this.selectedIndexChangedListeners.size() == 0) {
            this.selectedIndexChangedListeners = null;
        }
    }

    protected void fireOnSelectedIndexChanged(EventObject eventObject) {
        if (this.selectedIndexChangedListeners != null) {
            Vector listeners = this.selectedIndexChangedListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((SelectedIndexChangedListener)listeners.elementAt(i)).OnSelectedIndexChanged(eventObject);
                ++i;
            }
        }
    }

    @Override
    protected boolean OnRaiseEvent() {
        if (this.getUniqueID().compareToIgnoreCase(this.getPage().getEventTarget()) == 0 && this.nLastSelectIndex != this.nCurSelectIndex) {
            this.fireOnSelectedIndexChanged(new EventObject(this));
        }
        return false;
    }

    @Override
    protected boolean OnReadFromViewStates() {
        String strSelectIndexKey = String.valueOf(this.getUniqueID()) + "_SI";
        Object objLastSelectIndex = this.getPage().getViewStates().Get(strSelectIndexKey);
        if (objLastSelectIndex != null) {
            this.nLastSelectIndex = (Integer)objLastSelectIndex;
        }
        return super.OnReadFromViewStates();
    }

    @Override
    protected boolean OnWriteToViewStates() {
        this.CalcSelectedIndex();
        String strSelectIndexKey = String.valueOf(this.getUniqueID()) + "_SI";
        this.getPage().getViewStates().Set(strSelectIndexKey, this.nCurSelectIndex);
        return super.OnWriteToViewStates();
    }

    protected void CalcSelectedIndex() {
        this.nCurSelectIndex = -1;
        int nItemCount = this.getItems().size();
        int i = 0;
        while (i < nItemCount) {
            ListItem listItem = this.getItems().Get(i);
            if (listItem.getSelected()) {
                this.nCurSelectIndex = i;
                break;
            }
            ++i;
        }
    }
}

