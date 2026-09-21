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
import SA.SRFramework.Web.SRFHidden;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFDataPicker
extends SRFWebControl
implements IWebCtrl,
IWebCtrl2 {
    protected static final String DEFAULTPICKIMG = "../images/icon_datapicker.gif";
    protected static final String DEFAULTNEWIMG = "../images/icon_datanew.gif";
    protected static String strPreFix_Hidden = "hidden_";
    protected static String strPreFix_Tbx = "tbx_";
    protected boolean bPickOnly = true;
    protected String strPickMessage = "\u70b9\u51fb\u9009\u62e9\u6570\u636e";
    protected String strSeparator = "|";
    protected String strPickJsCall = "datapick";
    protected String strNewJsCall = "datanew";
    protected String strNewMessage = "\u70b9\u51fb\u65b0\u5efa\u6570\u636e";
    protected SRFTextBox htmlInputText = null;
    protected SRFHidden htmlInputHidden = null;
    protected boolean bReadOnly = false;
    protected String strPickImage = "../images/icon_datapicker.gif";
    protected String strNewImage = "../images/icon_datanew.gif";
    protected boolean bSupportNew = false;

    public boolean getPickOnly() {
        return this.bPickOnly;
    }

    public void setPickOnly(boolean value) {
        this.bPickOnly = value;
    }

    public String getPickMessage() {
        return this.strPickMessage;
    }

    public void getPickMessage(String value) {
        this.strPickMessage = value;
    }

    public String getNewMessage() {
        return this.strNewMessage;
    }

    public void getNewMessage(String value) {
        this.strNewMessage = value;
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String value) {
        this.strSeparator = value;
    }

    public String getPickJSCall() {
        return this.strPickJsCall;
    }

    public void setPickJSCall(String value) {
        this.strPickJsCall = value;
    }

    public String getNewJSCall() {
        return this.strNewJsCall;
    }

    public void setNewJSCall(String value) {
        this.strNewJsCall = value;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.htmlInputText = new SRFTextBox();
        this.htmlInputText.setID(String.valueOf(strPreFix_Tbx) + this.getID());
        this.AddControl(this.htmlInputText);
        this.htmlInputHidden = new SRFHidden();
        this.htmlInputHidden.setID(String.valueOf(strPreFix_Hidden) + this.getID());
        this.AddControl(this.htmlInputHidden);
    }

    @Override
    public void SetStrValue(String strValue) {
        String strHiddenValue = "";
        String strTextValue = "";
        if (StringHelper.StringLength(this.strSeparator) != 0) {
            int nPos = strValue.indexOf(this.strSeparator);
            if (nPos != -1) {
                strHiddenValue = strValue.substring(0, nPos);
                strTextValue = strValue.substring(nPos + 1);
            } else if (this.bPickOnly) {
                strHiddenValue = strValue;
            } else {
                strTextValue = strValue;
            }
        }
        this.htmlInputText.setText(strTextValue);
        this.htmlInputHidden.setValue(strHiddenValue);
    }

    @Override
    public String GetCtrlValue() {
        if (this.bPickOnly) {
            return this.htmlInputHidden.getValue();
        }
        return this.htmlInputText.getText();
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    @Override
    public String GetUrlValue() {
        if (StringHelper.Length(this.htmlInputHidden.getValue()) == 0 && StringHelper.Length(this.htmlInputText.getText()) == 0) {
            return "";
        }
        return StringHelper.Format("%1$s%2$s%3$s", this.htmlInputHidden.getValue(), this.strSeparator, this.htmlInputText.getText());
    }

    @Override
    public void SetUrlValue(String strValue) {
        this.SetStrValue(strValue);
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            this.htmlInputHidden.RenderControl(output);
            this.htmlInputText.setCssClass(this.getCssClass());
            this.htmlInputText.setWidth(this.getWidth());
            if (this.getPickOnly()) {
                this.htmlInputText.setReadOnly(true);
                if (!this.bReadOnly) {
                    this.htmlInputText.getAttributes().Set("onclick", String.format("javascript:%1$s('%2$s')", this.strPickJsCall, this.getUniqueID()));
                }
            }
            if (this.bReadOnly) {
                this.htmlInputText.setReadOnly(true);
            }
            this.htmlInputText.RenderControl(output);
            if (!this.bReadOnly) {
                if (this.bSupportNew) {
                    output.print(String.format("<A href=\"javascript:%1$s('%2$s')\"><IMG src=\"%4$s\" align=\"absMiddle\" border=\"0\" alt=\"%3$s\"></A>", this.strNewJsCall, this.getUniqueID(), this.strNewMessage, this.strNewImage));
                    output.print("&nbsp;");
                }
                output.print(String.format("<A href=\"javascript:%1$s('%2$s')\"><IMG src=\"%4$s\" align=\"absMiddle\" border=\"0\" alt=\"%3$s\"></A>", this.strPickJsCall, this.getUniqueID(), this.strPickMessage, this.strPickImage));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void setReadOnly(boolean value) {
        this.bReadOnly = value;
    }

    public boolean getReadOnly() {
        return this.bReadOnly;
    }

    public void setPickImage(String value) {
        this.strPickImage = value;
    }

    public void setNewImage(String value) {
        this.strNewImage = value;
    }

    public void setSupportNew(boolean value) {
        this.bSupportNew = value;
    }

    public boolean getSupportNew() {
        return this.bSupportNew;
    }
}

