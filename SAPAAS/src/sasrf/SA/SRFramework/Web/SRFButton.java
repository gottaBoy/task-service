/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ButtonClickListener;
import SA.SRFramework.Web.SRFWebControl;
import java.util.EventObject;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public class SRFButton
extends SRFWebControl {
    String strValue = "";
    private Vector click_listeners = new Vector();

    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<input type=\"submit\" ");
            this.OutputName(output);
            this.OutputID(output);
            if (StringHelper.StringLength(this.getValue()) != 0) {
                this.getAttributes().Set("value", this.getValue());
            }
            this.OutputWebControlAttr(output);
            output.print("/>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
            return;
        }
    }

    public synchronized void addButtonClickListener(ButtonClickListener listener) {
        this.click_listeners.addElement(listener);
    }

    public synchronized void removeButtonClickListener(ButtonClickListener listener) {
        this.click_listeners.remove(listener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void FireButtonClick() {
        Object temp = null;
        EventObject buttonClickEvent = new EventObject(this);
        Vector tempVector = null;
        SRFButton sRFButton = this;
        synchronized (sRFButton) {
            tempVector = (Vector)this.click_listeners.clone();
            int i = 0;
            while (i < tempVector.size()) {
                ((ButtonClickListener)tempVector.elementAt(i)).OnButtonClick(buttonClickEvent);
                ++i;
            }
        }
    }

    @Override
    protected boolean OnRaiseEvent() {
        String strSubmitValue = this.getPage().getRequest().getParameter(this.getUniqueID());
        if (strSubmitValue == null) {
            return false;
        }
        if (strSubmitValue.equalsIgnoreCase(this.strValue)) {
            this.FireButtonClick();
        }
        return false;
    }
}

