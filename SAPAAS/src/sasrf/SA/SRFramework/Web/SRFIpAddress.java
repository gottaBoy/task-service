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

public class SRFIpAddress
extends SRFWebControl
implements IWebCtrl {
    protected static String strPreFix_IpPartA = "ipparta_";
    protected static String strPreFix_IpPartB = "ippartb_";
    protected static String strPreFix_IpPartC = "ippartc_";
    protected static String strPreFix_IpPartD = "ippartd_";
    protected SRFTextBox tbx_PartA = null;
    protected SRFTextBox tbx_PartB = null;
    protected SRFTextBox tbx_PartC = null;
    protected SRFTextBox tbx_PartD = null;
    protected boolean bReadOnly = false;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.tbx_PartA = new SRFTextBox();
        this.tbx_PartA.setID(String.valueOf(strPreFix_IpPartA) + this.getID());
        this.AddControl(this.tbx_PartA);
        this.tbx_PartB = new SRFTextBox();
        this.tbx_PartB.setID(String.valueOf(strPreFix_IpPartB) + this.getID());
        this.AddControl(this.tbx_PartB);
        this.tbx_PartC = new SRFTextBox();
        this.tbx_PartC.setID(String.valueOf(strPreFix_IpPartC) + this.getID());
        this.AddControl(this.tbx_PartC);
        this.tbx_PartD = new SRFTextBox();
        this.tbx_PartD.setID(String.valueOf(strPreFix_IpPartD) + this.getID());
        this.AddControl(this.tbx_PartD);
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String strInputClass = this.getCssClass();
            output.print("<span class=\"normaltext\">");
            this.tbx_PartA.setCssClass(strInputClass);
            this.tbx_PartA.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartA.getAttributes().Set("MAXLENGTH", "3");
            if (this.bReadOnly) {
                this.tbx_PartA.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartA.RenderControl(output);
            output.print(".");
            this.tbx_PartB.setCssClass(strInputClass);
            this.tbx_PartB.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartB.getAttributes().Set("MAXLENGTH", "3");
            if (this.bReadOnly) {
                this.tbx_PartB.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartB.RenderControl(output);
            output.print(".");
            this.tbx_PartC.setCssClass(strInputClass);
            this.tbx_PartC.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartC.getAttributes().Set("MAXLENGTH", "3");
            if (this.bReadOnly) {
                this.tbx_PartC.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartC.RenderControl(output);
            output.print(".");
            this.tbx_PartD.setCssClass(strInputClass);
            this.tbx_PartD.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.tbx_PartD.getAttributes().Set("MAXLENGTH", "3");
            if (this.bReadOnly) {
                this.tbx_PartD.getAttributes().Set("readonly", "readonly");
            }
            this.tbx_PartD.RenderControl(output);
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
        String strIpAddress = String.format("%1$s.%2$s.%3$s.%4$s", this.tbx_PartA.getText(), this.tbx_PartB.getText(), this.tbx_PartC.getText(), this.tbx_PartD.getText());
        if (StringHelper.Length(strIpAddress) == 3) {
            return "";
        }
        int[] IpAddress = new int[4];
        if (NetHelper.ParseIpAddr(strIpAddress, IpAddress)) {
            return strIpAddress;
        }
        return "$$SRFWEBCONTROLERRORVALUE$$";
    }

    @Override
    public void SetStrValue(String strValue) {
        if (StringHelper.StringLength(strValue) != 0) {
            try {
                int[] IpAddress = new int[4];
                if (NetHelper.ParseIpAddr(strValue, IpAddress)) {
                    this.tbx_PartA.setText(Integer.valueOf(IpAddress[0]).toString());
                    this.tbx_PartB.setText(Integer.valueOf(IpAddress[1]).toString());
                    this.tbx_PartC.setText(Integer.valueOf(IpAddress[2]).toString());
                    this.tbx_PartD.setText(Integer.valueOf(IpAddress[3]).toString());
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

