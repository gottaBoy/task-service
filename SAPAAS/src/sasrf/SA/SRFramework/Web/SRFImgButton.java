/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Web.ButtonClickListener;
import SA.SRFramework.Web.SRFImage;
import java.util.EventObject;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public class SRFImgButton
extends SRFImage {
    private Vector click_listeners = new Vector();

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
        SRFImgButton sRFImgButton = this;
        synchronized (sRFImgButton) {
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
        String strSubmitXValue = null;
        String strSubmitYValue = null;
        if (strSubmitXValue == null) {
            strSubmitXValue = this.getPage().getRequest().getParameter(String.valueOf(this.getUniqueID()) + ".x");
        }
        if (strSubmitXValue == null) {
            strSubmitXValue = this.getPage().getRequest().getParameter(String.valueOf(this.getUniqueID()) + ".X");
        }
        if (strSubmitXValue == null) {
            return false;
        }
        if (strSubmitYValue == null) {
            strSubmitYValue = this.getPage().getRequest().getParameter(String.valueOf(this.getUniqueID()) + ".y");
        }
        if (strSubmitYValue == null) {
            strSubmitYValue = this.getPage().getRequest().getParameter(String.valueOf(this.getUniqueID()) + ".Y");
        }
        if (strSubmitYValue == null) {
            return false;
        }
        this.FireButtonClick();
        return false;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.print("<input type=\"image\" ");
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
}

