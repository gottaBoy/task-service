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
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.SRFDropDownList;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFWebControl;
import java.util.Date;
import javax.servlet.jsp.JspWriter;

public class SRFDateTime
extends SRFWebControl
implements IWebCtrl {
    protected static String strPreFix_Date = "dpk_";
    protected static String strPreFix_Hour = "hpk_";
    protected static String strPreFix_Minute = "mpk_";
    protected static String strPreFix_Second = "spk_";
    protected SRFTextBox htmlInputText = null;
    protected SRFDropDownList ddl_Hour = null;
    protected SRFDropDownList ddl_Minute = null;
    protected SRFDropDownList ddl_Second = null;
    protected boolean bShowHour = true;
    protected boolean bShowMinute = true;
    protected boolean bShowSecond = false;
    protected boolean bReadOnly = false;

    @Override
    protected void OnInit() {
        super.OnInit();
        this.htmlInputText = new SRFTextBox();
        this.htmlInputText.setID(String.valueOf(strPreFix_Date) + this.getID());
        this.AddControl(this.htmlInputText);
        this.ddl_Hour = new SRFDropDownList();
        this.ddl_Hour.setID(String.valueOf(strPreFix_Hour) + this.getID());
        this.BindHourList(this.ddl_Hour);
        this.AddControl(this.ddl_Hour);
        this.ddl_Minute = new SRFDropDownList();
        this.ddl_Minute.setID(String.valueOf(strPreFix_Minute) + this.getID());
        this.BindMinuteList(this.ddl_Minute);
        this.AddControl(this.ddl_Minute);
        this.ddl_Second = new SRFDropDownList();
        this.ddl_Second.setID(String.valueOf(strPreFix_Second) + this.getID());
        this.BindMinuteList(this.ddl_Second);
        this.AddControl(this.ddl_Second);
    }

    protected void BindHourList(SRFDropDownList ddl) {
        ddl.getItems().Clear();
        Integer i = 0;
        while (i < 24) {
            String strValue = i.toString();
            if (StringHelper.Length(strValue) == 1) {
                strValue = "0" + strValue;
            }
            ddl.getItems().Add(new ListItem(strValue, strValue));
            i = i + 1;
        }
    }

    protected void BindMinuteList(SRFDropDownList ddl) {
        ddl.getItems().Clear();
        Integer i = 0;
        while (i < 60) {
            String strValue = i.toString();
            if (StringHelper.Length(strValue) == 1) {
                strValue = "0" + strValue;
            }
            ddl.getItems().Add(new ListItem(strValue, strValue));
            i = i + 1;
        }
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            String[] styles = this.getCssClass().split(";");
            String strInputClass = "";
            String strDdlClass = "";
            if (styles.length >= 1) {
                strInputClass = styles[0];
            }
            if (styles.length >= 2) {
                strDdlClass = styles[1];
            }
            this.htmlInputText.setCssClass(strInputClass);
            this.htmlInputText.getAttributes().Set("size", Integer.valueOf(this.getWidth()).toString());
            this.htmlInputText.getAttributes().Set("onclick", "calendar()");
            this.htmlInputText.getAttributes().Set("readonly", "readonly");
            this.htmlInputText.RenderControl(output);
            if (!this.bReadOnly) {
                output.print(String.format("<A href=\"javascript:document.getElementById('%1$s').click()\"><IMG src=\"../images/icon_datepicker.gif\" align=\"absMiddle\" border=\"0\" alt=\"\u70b9\u51fb\u9009\u62e9\u65e5\u671f\"></A>", this.htmlInputText.getUniqueID()));
            }
            output.print("&nbsp;");
            if (strDdlClass.compareTo("") != 0) {
                this.ddl_Hour.setCssClass(strDdlClass);
                this.ddl_Minute.setCssClass(strDdlClass);
                this.ddl_Second.setCssClass(strDdlClass);
            }
            if (this.bReadOnly) {
                this.ddl_Hour.setEnabled(false);
                this.ddl_Minute.setEnabled(false);
                this.ddl_Second.setEnabled(false);
            }
            if (this.bShowHour) {
                this.ddl_Hour.RenderControl(output);
                if (this.bShowMinute) {
                    output.print(":");
                    this.ddl_Minute.RenderControl(output);
                    if (this.bShowSecond) {
                        output.print(":");
                        this.ddl_Second.RenderControl(output);
                    }
                }
            }
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
        String strHourValue = "00";
        String strMinuteValue = "00";
        String strSecondValue = "00";
        if (this.bShowHour) {
            strHourValue = this.ddl_Hour.getSelectedValue();
            if (this.bShowMinute) {
                strMinuteValue = this.ddl_Minute.getSelectedValue();
                if (this.bShowSecond) {
                    strSecondValue = this.ddl_Second.getSelectedValue();
                }
            }
        }
        return String.format("%1$s %2$s:%3$s:%4$s", this.htmlInputText.getText(), strHourValue, strMinuteValue, strSecondValue);
    }

    @Override
    public void SetStrValue(String strValue) {
        if (StringHelper.StringLength(strValue) != 0) {
            try {
                Date date = DateParser.Parser(strValue);
                this.htmlInputText.setText(DateParser.toDateString(date));
                this.ddl_Hour.setSelectedValue(DateParser.toHourString(date));
                this.ddl_Minute.setSelectedValue(DateParser.toMinuteString(date));
                this.ddl_Second.setSelectedValue(DateParser.toSecondString(date));
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

    public boolean getShowHour() {
        return this.bShowHour;
    }

    public boolean getShowMinute() {
        return this.bShowMinute;
    }

    public boolean getShowSecond() {
        return this.bShowSecond;
    }

    public void setShowHour(boolean value) {
        this.bShowHour = value;
    }

    public void setShowSecond(boolean value) {
        this.bShowSecond = value;
    }

    public void setShowMinute(boolean value) {
        this.bShowMinute = value;
    }
}

