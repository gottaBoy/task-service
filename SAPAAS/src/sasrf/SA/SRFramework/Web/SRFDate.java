/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFWebControl;
import java.util.Date;
import javax.servlet.jsp.JspWriter;

public class SRFDate
extends SRFWebControl
implements IWebCtrl {
    protected static String strPreFix_Date = "dpk_";
    protected SRFTextBox htmlInputText = null;
    protected boolean bReadOnly = false;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.htmlInputText = new SRFTextBox();
        this.htmlInputText.setID(String.valueOf(strPreFix_Date) + this.getID());
        this.AddControl(this.htmlInputText);
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            this.htmlInputText.setCssClass(this.getCssClass());
            this.htmlInputText.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.htmlInputText.getAttributes().Set("onclick", "calendar()");
            this.htmlInputText.getAttributes().Set("readonly", "readonly");
            this.htmlInputText.RenderControl(output);
            if (!this.bReadOnly) {
                output.print(String.format("<A href=\"javascript:document.getElementById('%1$s').click()\"><IMG src=\"../images/icon_datepicker.gif\" align=\"absMiddle\" border=\"0\" alt=\"\u70b9\u51fb\u9009\u62e9\u65e5\u671f\"></A>", this.htmlInputText.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void SetStrValue(String strValue) {
        if (StringHelper.StringLength(strValue) == 0) {
            return;
        }
        try {
            Date date = DateParser.Parser(strValue);
            this.htmlInputText.setText(DateParser.toDateString(date));
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String GetCtrlValue() {
        return this.htmlInputText.getText();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    public void setReadOnly(boolean value) {
        this.bReadOnly = value;
    }

    public boolean getReadOnly() {
        return this.bReadOnly;
    }
}

