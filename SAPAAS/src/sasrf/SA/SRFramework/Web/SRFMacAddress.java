/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.NetHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.IWebCtrl;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFWebControl;
import javax.servlet.jsp.JspWriter;

public class SRFMacAddress
extends SRFWebControl
implements IWebCtrl {
    protected static String strPreFix_MacPartA = "macparta_";
    protected static String strPreFix_MacPartB = "macpartb_";
    protected static String strPreFix_MacPartC = "macpartc_";
    protected static String strPreFix_MacPartD = "macpartd_";
    protected static String strPreFix_MacPartE = "macparte_";
    protected static String strPreFix_MacPartF = "macpartf_";
    protected SRFTextBox tbx_PartA = null;
    protected SRFTextBox tbx_PartB = null;
    protected SRFTextBox tbx_PartC = null;
    protected SRFTextBox tbx_PartD = null;
    protected SRFTextBox tbx_PartE = null;
    protected SRFTextBox tbx_PartF = null;
    protected boolean bReadOnly = false;
    protected String strSeparator = ":";

    @Override
    protected void OnInit() {
        super.OnInit();
        this.tbx_PartA = new SRFTextBox();
        this.tbx_PartA.setID(String.valueOf(strPreFix_MacPartA) + this.getID());
        this.AddControl(this.tbx_PartA);
        this.tbx_PartB = new SRFTextBox();
        this.tbx_PartB.setID(String.valueOf(strPreFix_MacPartB) + this.getID());
        this.AddControl(this.tbx_PartB);
        this.tbx_PartC = new SRFTextBox();
        this.tbx_PartC.setID(String.valueOf(strPreFix_MacPartC) + this.getID());
        this.AddControl(this.tbx_PartC);
        this.tbx_PartD = new SRFTextBox();
        this.tbx_PartD.setID(String.valueOf(strPreFix_MacPartD) + this.getID());
        this.AddControl(this.tbx_PartD);
        this.tbx_PartE = new SRFTextBox();
        this.tbx_PartE.setID(String.valueOf(strPreFix_MacPartE) + this.getID());
        this.AddControl(this.tbx_PartE);
        this.tbx_PartF = new SRFTextBox();
        this.tbx_PartF.setID(String.valueOf(strPreFix_MacPartF) + this.getID());
        this.AddControl(this.tbx_PartF);
    }

    public String getSeparator() {
        return this.strSeparator;
    }

    public void setSeparator(String value) {
        this.strSeparator = value;
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String strInputClass = this.getCssClass();
            output.print("<span class=\"normaltext\">");
            this.tbx_PartA.setCssClass(strInputClass);
            this.tbx_PartA.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartA.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartA.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartA.RenderControl(output);
            output.print(this.strSeparator);
            this.tbx_PartB.setCssClass(strInputClass);
            this.tbx_PartB.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartB.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartB.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartB.RenderControl(output);
            output.print(this.strSeparator);
            this.tbx_PartC.setCssClass(strInputClass);
            this.tbx_PartC.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartC.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartC.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartC.RenderControl(output);
            output.print(this.strSeparator);
            this.tbx_PartD.setCssClass(strInputClass);
            this.tbx_PartD.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartD.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartD.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartD.RenderControl(output);
            output.print(this.strSeparator);
            this.tbx_PartE.setCssClass(strInputClass);
            this.tbx_PartE.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartE.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartE.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartE.RenderControl(output);
            output.print(this.strSeparator);
            this.tbx_PartF.setCssClass(strInputClass);
            this.tbx_PartF.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartF.getAttributes().Set("MAXLENGTH", "2");
            if (this.bReadOnly) {
                this.tbx_PartF.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartF.RenderControl(output);
            output.print("</span>");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public boolean DoCommand(String strCmdId, Object cmdArg1, Object cmdArg2) {
        return false;
    }

    @Override
    public String GetCtrlValue() {
        String strMacAddress = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$s", this.tbx_PartA.getText(), this.tbx_PartB.getText(), this.tbx_PartC.getText(), this.tbx_PartD.getText(), this.tbx_PartE.getText(), this.tbx_PartF.getText());
        if (StringHelper.Length(strMacAddress) == 5) {
            return "";
        }
        if (StringHelper.Length(strMacAddress = NetHelper.ReformatMacAddr(strMacAddress, this.strSeparator)) > 0) {
            return strMacAddress;
        }
        return "$$SRFWEBCONTROLERRORVALUE$$";
    }

    @Override
    public void SetStrValue(String strValue) {
        if (StringHelper.StringLength(strValue) != 0) {
            try {
                String strMacAddress = NetHelper.ReformatMacAddr(strValue, this.strSeparator);
                String[] list = strMacAddress.split("[" + this.strSeparator + "]");
                if (list.length == 6) {
                    this.tbx_PartA.setText(list[0]);
                    this.tbx_PartB.setText(list[1]);
                    this.tbx_PartC.setText(list[2]);
                    this.tbx_PartD.setText(list[3]);
                    this.tbx_PartE.setText(list[4]);
                    this.tbx_PartF.setText(list[5]);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                return;
            }
        }
    }

    public void setReadOnly(boolean value) {
        this.bReadOnly = value;
    }

    public boolean getReadOnly() {
        return this.bReadOnly;
    }
}

