/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.DatePickerExConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Date;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDatePickerEx
extends SRFExFormItem {
    private static final Log log = LogFactory.getLog(SRFExDatePickerEx.class);
    protected SRFExTextBox textBox = null;
    protected SRFExTextBox hourList = null;
    protected SRFExTextBox minList = null;
    protected SRFExTextBox secList = null;
    protected DatePickerExConfig datePickerExConfig = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new DatePickerExConfig();
    }

    public DatePickerExConfig getDatePickerExConfig() {
        return this.datePickerExConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.datePickerExConfig = null;
        if (this.config != null && this.config instanceof DatePickerExConfig) {
            this.datePickerExConfig = (DatePickerExConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.textBox = null;
        this.hourList = null;
        this.minList = null;
        this.secList = null;
        if (this.datePickerExConfig != null) {
            this.textBox = new SRFExTextBox();
            this.textBox.InitConfig();
            this.textBox.setID(String.valueOf(this.getID()) + "_DAY");
            this.textBox.getTextBoxConfig().setCssClass("sx-datepicker-day");
            this.textBox.getTextBoxConfig().SetExtAttribute("MAXLENGTH", "2");
            this.textBox.getTextBoxConfig().setMaxLength(10);
            this.AddControl(this.textBox);
            this.hourList = new SRFExTextBox();
            this.hourList.InitConfig();
            this.hourList.setID(String.valueOf(this.getID()) + "_HOUR");
            this.hourList.getTextBoxConfig().SetExtAttribute("MAXLENGTH", "2");
            this.hourList.getTextBoxConfig().setMaxLength(2);
            this.hourList.getTextBoxConfig().SetExtAttribute("onblur", "SRFUtility.check24(event)");
            this.hourList.getTextBoxConfig().SetExtAttribute("onfocus", "SRFUtility.selectall(event)");
            this.hourList.getTextBoxConfig().setCssClass("sx-datepicker-time");
            this.AddControl(this.hourList);
            this.minList = new SRFExTextBox();
            this.minList.InitConfig();
            this.minList.setID(String.valueOf(this.getID()) + "_MIN");
            this.minList.getTextBoxConfig().setMaxLength(2);
            this.minList.getTextBoxConfig().SetExtAttribute("onblur", "SRFUtility.check60(event)");
            this.minList.getTextBoxConfig().SetExtAttribute("onfocus", "SRFUtility.selectall(event)");
            this.minList.getTextBoxConfig().setCssClass("sx-datepicker-time");
            this.AddControl(this.minList);
            this.secList = new SRFExTextBox();
            this.secList.InitConfig();
            this.secList.setID(String.valueOf(this.getID()) + "_SEC");
            this.secList.getTextBoxConfig().setMaxLength(2);
            this.secList.getTextBoxConfig().SetExtAttribute("onblur", "SRFUtility.check60(event)");
            this.secList.getTextBoxConfig().SetExtAttribute("onfocus", "SRFUtility.selectall(event)");
            this.secList.getTextBoxConfig().setCssClass("sx-datepicker-time");
            this.AddControl(this.secList);
            this.setValue(this.getDatePickerExConfig().getValue());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            String strScript = "";
            strScript = StringHelper.Format((String)"$P.object['%1$s']=new SRFDatePicker({enable:true});", (Object)this.getUniqueID());
            this.getPage().RegisterOnReadyScript(3, strScript.toString());
            this.hourList.getTextBoxConfig().setEnabled(!this.getDatePickerExConfig().getReadOnly());
            this.minList.getTextBoxConfig().setEnabled(!this.getDatePickerExConfig().getReadOnly());
            this.secList.getTextBoxConfig().setEnabled(!this.getDatePickerExConfig().getReadOnly());
            this.textBox.getTextBoxConfig().setTextMode(3);
            this.textBox.getTextBoxConfig().setReadOnly(true);
            this.textBox.getTextBoxConfig().SetExtAttribute("onclick", StringHelper.Format((String)"javascript:if(!$P.object['%1$s'].enable)return;event.cancelBubble=true;WdatePicker({onpicked:$P.object['%1$s'].ondaychanged.createDelegate($P.object['%1$s']),oncleared:$P.object['%1$s'].ondaychanged.createDelegate($P.object['%1$s'])});", (Object)this.getUniqueID()));
            if (this.getDatePickerExConfig().getDayEnable()) {
                this.textBox.Render(writer);
                if (!this.getDatePickerExConfig().getReadOnly()) {
                    writer.write(String.format("<A  href='#' onclick=\"javascript:if(!$P.object['%3$s'].enable)return;event.cancelBubble=true;WdatePicker({el:'%1$s',onpicked:$P.object['%3$s'].ondaychanged.createDelegate($P.object['%3$s']),oncleared:$P.object['%3$s'].ondaychanged.createDelegate($P.object['%3$s'])});\"><IMG id='IMG_%3$s' src='../sasrfex/images/default/icon_datepicker.gif' align=\"absMiddle\" border=\"0\" alt=\"%2$s\"></A>", this.textBox.getUniqueID(), this.getDatePickerExConfig().getTipMessage(), this.getUniqueID()));
                }
            }
            if (this.getDatePickerExConfig().getHourEnable()) {
                this.hourList.Render(writer);
                if (this.getDatePickerExConfig().getMinuteEnable()) {
                    writer.write("<SPAN class='sx-normaltext'>:</SPAN>");
                    this.minList.Render(writer);
                    if (this.getDatePickerExConfig().getSecondEnable()) {
                        writer.write("<SPAN class='sx-normaltext'>:</SPAN>");
                        this.secList.Render(writer);
                    }
                }
            }
            if (this.getDatePickerExConfig().isTimeNowButton()) {
                writer.write(String.format("<A  href='#' onclick=\"javascript:if(!$P.object['%5$s'].enable)return;SRFForm.setDTValueNow('%1$s','%2$s','%3$s','%4$s');$P.object['%5$s'].ondaychanged();\"><IMG  src='../sasrfex/images/default/icon_timenow.gif' align=\"absMiddle\" border=\"0\" alt=\"\u5f53\u524d\u65f6\u95f4\"></A>", this.textBox.getUniqueID(), this.hourList.getUniqueID(), this.minList.getUniqueID(), this.secList.getUniqueID(), this.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getDatePickerExConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getDatePickerExConfig().getValue();
    }

    @Override
    public void setValue(String strValue) {
        Date date;
        if (StringHelper.Length((String)strValue) > 0) {
            try {
                date = DateParser.Parser((String)strValue);
                strValue = DateParser.toDateTimeString((Date)date);
            }
            catch (Exception ex) {
                strValue = "";
            }
        }
        this.getDatePickerExConfig().setValue(strValue);
        if (this.textBox != null) {
            if (StringHelper.Length((String)strValue) > 0) {
                try {
                    date = DateParser.Parser((String)strValue);
                    this.textBox.setValue(DateParser.toDateString((Date)date));
                    this.hourList.setValue(DateParser.toHourString((Date)date));
                    this.minList.setValue(DateParser.toMinuteString((Date)date));
                    this.secList.setValue(DateParser.toSecondString((Date)date));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                this.textBox.setValue("");
                this.hourList.setValue("");
                this.minList.setValue("");
                this.secList.setValue("");
            }
        }
    }

    @Override
    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        String strValue = this.getValue();
        obj.put("value", (Object)strValue);
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V=SRFForm.getDTValue('%1$s','%2$s','%3$s','%4$s');", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID());
        }
        return StringHelper.Format((String)"SRFForm.setDTValue('%1$s','%2$s','%3$s','%4$s',_V);", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$P.object['%5$s'].enable=_V;$FEI4(['%1$s','%2$s','%3$s','%4$s'], _V);", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID(), (Object)this.getUniqueID());
    }

    @Override
    public void OnInitFormPostData() {
        try {
            String strValue = null;
            strValue = this.getPage().isControlValueFromUniqueId() ? this.getPage().getRequest().getParameter(this.getUniqueID()) : this.getPage().getRequest().getParameter(this.getID().toLowerCase());
            if (strValue == null) {
                return;
            }
            this.getDatePickerExConfig().getFormItemConfig().getEndOfDay();
            this.getDatePickerExConfig().setValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public SRFExTextBox GetDayCtrl() {
        return this.textBox;
    }

    public SRFExTextBox GetHourCtrl() {
        return this.hourList;
    }

    public SRFExTextBox GetMinuteCtrl() {
        return this.minList;
    }

    public SRFExTextBox GetSecondCtrl() {
        return this.secList;
    }

    @Override
    public void GetFocusItemIds(Vector vector) {
        if (this.getDatePickerExConfig().getDayEnable()) {
            vector.add(this.textBox.getUniqueID());
        }
        if (this.getDatePickerExConfig().getHourEnable()) {
            vector.add(this.hourList.getUniqueID());
            if (this.getDatePickerExConfig().getMinuteEnable()) {
                vector.add(this.minList.getUniqueID());
                if (this.getDatePickerExConfig().getSecondEnable()) {
                    vector.add(this.secList.getUniqueID());
                }
            }
        }
    }
}

