/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ListItem
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.SRFExTextBox;
import SA.SRFramework.WebEx.UI.DatePickerConfig;
import SA.SRFramework.WebEx.UI.FormItemConfig;
import java.io.Writer;
import java.util.Date;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDatePicker
extends SRFExFormItem {
    private static final Log log = LogFactory.getLog(SRFExDatePicker.class);
    protected SRFExTextBox textBox = null;
    protected SRFExDropDownList hourList = null;
    protected SRFExDropDownList minList = null;
    protected SRFExDropDownList secList = null;
    protected DatePickerConfig datePickerConfig = null;

    protected void BindNumberList(SRFExDropDownList ddl, int nMaxTick) {
        ddl.getListItems().Clear();
        Integer i = 0;
        while (i < nMaxTick) {
            String strValue = i.toString();
            if (StringHelper.Length((String)strValue) == 1) {
                strValue = "0" + strValue;
            }
            ddl.getListItems().Add(new ListItem(strValue, strValue));
            i = i + 1;
        }
    }

    @Override
    protected XMLConfig CreateConfig() {
        return new DatePickerConfig();
    }

    public DatePickerConfig getDatePickerConfig() {
        return this.datePickerConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.datePickerConfig = null;
        if (this.config != null && this.config instanceof DatePickerConfig) {
            this.datePickerConfig = (DatePickerConfig)this.config;
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
        if (this.datePickerConfig != null) {
            this.textBox = new SRFExTextBox();
            this.textBox.InitConfig();
            this.textBox.setID(String.valueOf(this.getID()) + "_DAY");
            this.AddControl(this.textBox);
            this.hourList = new SRFExDropDownList();
            this.hourList.InitConfig();
            this.hourList.setID(String.valueOf(this.getID()) + "_HOUR");
            this.hourList.getDropDownListConfig().setWidth(45);
            this.AddControl(this.hourList);
            this.minList = new SRFExDropDownList();
            this.minList.InitConfig();
            this.minList.setID(String.valueOf(this.getID()) + "_MIN");
            this.minList.getDropDownListConfig().setWidth(45);
            this.AddControl(this.minList);
            this.secList = new SRFExDropDownList();
            this.secList.InitConfig();
            this.secList.setID(String.valueOf(this.getID()) + "_SEC");
            this.secList.getDropDownListConfig().setWidth(45);
            this.AddControl(this.secList);
            this.BindNumberList(this.hourList, 24);
            this.BindNumberList(this.minList, 60);
            this.BindNumberList(this.secList, 60);
            this.setValue(this.getDatePickerConfig().getValue());
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.hourList.getDropDownListConfig().setEnabled(!this.getDatePickerConfig().getReadOnly());
            this.minList.getDropDownListConfig().setEnabled(!this.getDatePickerConfig().getReadOnly());
            this.secList.getDropDownListConfig().setEnabled(!this.getDatePickerConfig().getReadOnly());
            this.textBox.getTextBoxConfig().setTextMode(3);
            this.textBox.getTextBoxConfig().setReadOnly(true);
            this.textBox.getTextBoxConfig().setWidth(65);
            this.textBox.getTextBoxConfig().SetExtAttribute("onclick", StringHelper.Format((String)"javascript:event.cancelBubble=true;WdatePicker();", (Object)this.textBox.getUniqueID()));
            this.textBox.Render(writer);
            if (!this.getDatePickerConfig().getReadOnly()) {
                writer.write(String.format("<A  href='#' onclick=\"javascript:event.cancelBubble=true;WdatePicker({el:'%1$s'});\"><IMG id='IMG_%3$s' src='../sasrfex/images/default/icon_datepicker.gif' align=\"absMiddle\" border=\"0\" alt=\"%2$s\"></A>", this.textBox.getUniqueID(), this.getDatePickerConfig().getTipMessage(), this.getUniqueID()));
            }
            if (this.getDatePickerConfig().getHourEnable()) {
                this.hourList.Render(writer);
                writer.write("<SPAN class='sx-normaltext'> \u65f6 </SPAN> ");
                if (this.getDatePickerConfig().getMinuteEnable()) {
                    this.minList.Render(writer);
                    writer.write("<SPAN class='sx-normaltext'> \u5206 </SPAN> ");
                    if (this.getDatePickerConfig().getSecondEnable()) {
                        this.secList.Render(writer);
                        writer.write("<SPAN class='sx-normaltext'> \u79d2 </SPAN> ");
                    }
                }
            }
            if (!this.getDatePickerConfig().getReadOnly()) {
                writer.write(String.format("<A href='#' onclick=\"javascript:SRFForm.setDTValueNow('%1$s','%2$s','%3$s','%4$s')\"><IMG src='../sasrfex/images/default/icon_timenow.gif' align=\"absMiddle\" border=\"0\" alt=\"\u5f53\u524d\u65f6\u95f4\"></A>", this.textBox.getUniqueID(), this.hourList.getUniqueID(), this.minList.getUniqueID(), this.secList.getUniqueID()));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public FormItemConfig getFormItemConfig() {
        return this.getDatePickerConfig().getFormItemConfig();
    }

    @Override
    public String getValue() {
        return this.getDatePickerConfig().getValue();
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
        this.getDatePickerConfig().setValue(strValue);
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
        obj.put("value", (Object)this.getValue());
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    @Override
    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V = SRFForm.getDTValue('%1$s','%2$s','%3$s','%4$s') ;", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID());
        }
        return StringHelper.Format((String)"SRFForm.setDTValue('%1$s','%2$s','%3$s','%4$s', _V);", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID());
    }

    @Override
    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"$FEI4(['%1$s','%2$s','%3$s','%4$s'], _V);", (Object)this.textBox.getUniqueID(), (Object)this.hourList.getUniqueID(), (Object)this.minList.getUniqueID(), (Object)this.secList.getUniqueID());
    }

    @Override
    public void OnInitFormPostData() {
        try {
            String strValue = null;
            strValue = this.getPage().isControlValueFromUniqueId() ? this.getPage().getRequest().getParameter(this.getUniqueID()) : this.getPage().getRequest().getParameter(this.getID().toLowerCase());
            if (strValue == null) {
                return;
            }
            this.getDatePickerConfig().setValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

