/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExFormItem
 *  SA.SRFramework.WebEx.SRFExTextBox
 *  SA.SRFramework.WebEx.UI.DatePickerExConfig
 *  SA.SRFramework.WebEx.UI.FormItemConfig
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.UX;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExControl;
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
    protected DatePickerExConfig datePickerExConfig = null;

    protected XMLConfig CreateConfig() {
        return new DatePickerExConfig();
    }

    public DatePickerExConfig getDatePickerExConfig() {
        return this.datePickerExConfig;
    }

    protected void OnSetConfig() {
        super.OnSetConfig();
        this.datePickerExConfig = null;
        if (this.config != null && this.config instanceof DatePickerExConfig) {
            this.datePickerExConfig = (DatePickerExConfig)this.config;
        }
    }

    protected void OnReloadConfig() {
        super.OnReloadConfig();
        this.RemoveControls();
        this.textBox = null;
        if (this.datePickerExConfig != null) {
            this.textBox = new SRFExTextBox();
            this.textBox.InitConfig();
            this.textBox.setID(String.valueOf(this.getID()) + "_DAY");
            this.textBox.getTextBoxConfig().SetExtAttribute("MAXLENGTH", "2");
            this.textBox.getTextBoxConfig().setMaxLength(10);
            if (!this.getDatePickerExConfig().getHourEnable()) {
                this.textBox.getTextBoxConfig().setCssClass("srfdatepicker");
                this.textBox.getTextBoxConfig().setExtStyle("width: 100px;");
            } else if (!this.getDatePickerExConfig().getDayEnable()) {
                this.textBox.getTextBoxConfig().setCssClass("srftimepicker");
                this.textBox.getTextBoxConfig().setExtStyle("width: 80px;");
            } else if (this.getDatePickerExConfig().getDayEnable()) {
                this.textBox.getTextBoxConfig().setCssClass("srfdatetimepicker");
                this.textBox.getTextBoxConfig().setExtStyle("width: 160px;");
            } else if (this.getDatePickerExConfig().getSecondEnable()) {
                this.textBox.getTextBoxConfig().setCssClass("srftimepicker");
                this.textBox.getTextBoxConfig().setExtStyle("width: 80px;");
            }
            this.AddControl((SRFExControl)this.textBox);
            this.setValue(this.getDatePickerExConfig().getValue());
        }
    }

    protected void OnRender(Writer writer) {
        try {
            this.textBox.getTextBoxConfig().setTextMode(3);
            this.textBox.getTextBoxConfig().setReadOnly(true);
            this.textBox.Render(writer);
            StringBuilderEx script = new StringBuilderEx();
            script.Append("Behaviour.register(srfrules); Behaviour.start();");
            this.getPage().RegisterScript(3, script.toString());
            if (!this.getDatePickerExConfig().getReadOnly()) {
                writer.write(String.format("", new Object[0]));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public FormItemConfig getFormItemConfig() {
        return this.getDatePickerExConfig().getFormItemConfig();
    }

    public String getValue() {
        return this.getDatePickerExConfig().getValue();
    }

    public void setValue(String strValue) {
        Date date;
        if (StringHelper.Length((String)strValue) > 0) {
            try {
                date = DateParser.Parser((String)strValue);
                if (!this.getDatePickerExConfig().getHourEnable()) {
                    strValue = DateParser.toDateString((Date)date);
                } else if (!this.getDatePickerExConfig().getDayEnable()) {
                    strValue = DateParser.toTimeString((Date)date);
                } else if (this.getDatePickerExConfig().getDayEnable()) {
                    strValue = DateParser.toDateTimeString((Date)date);
                }
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
                    if (!this.getDatePickerExConfig().getHourEnable()) {
                        this.textBox.setValue(DateParser.toDateString((Date)date));
                    } else if (!this.getDatePickerExConfig().getDayEnable()) {
                        this.textBox.setValue(DateParser.toTimeString((Date)date));
                    } else if (this.getDatePickerExConfig().getDayEnable()) {
                        this.textBox.setValue(DateParser.toDateTimeString((Date)date));
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                this.textBox.setValue("");
            }
        }
    }

    public boolean FillValueJSON(Vector vector, boolean bUniId) {
        JSONObject obj = new JSONObject();
        obj.put("id", (Object)(bUniId ? this.getUniqueID() : this.getID()));
        obj.put("value", (Object)this.getValue());
        obj.put("enabled", this.getEnabled());
        vector.add(obj);
        return true;
    }

    public String getItemValueJSCall(boolean bGetMode) {
        if (bGetMode) {
            return StringHelper.Format((String)"_V=SRFForm.getValue('%1$s');", (Object)this.textBox.getUniqueID());
        }
        return StringHelper.Format((String)"SRFForm.setValue('%1$s',_V);", (Object)this.textBox.getUniqueID());
    }

    public String getItemEnableStateJSCall() {
        return StringHelper.Format((String)"Ext.getDom('%1$s').disabled=_V?'':'disabled';", (Object)this.textBox.getUniqueID());
    }

    public void OnInitFormPostData() {
        try {
            String strValue = null;
            strValue = this.getPage().isControlValueFromUniqueId() ? this.getPage().getRequest().getParameter(this.getUniqueID()) : this.getPage().getRequest().getParameter(this.getID().toLowerCase());
            if (strValue == null) {
                return;
            }
            this.getDatePickerExConfig().setValue(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public SRFExTextBox GetDayCtrl() {
        return this.textBox;
    }

    public void GetFocusItemIds(Vector vector) {
        if (this.getDatePickerExConfig().getDayEnable()) {
            vector.add(this.textBox.getUniqueID());
        }
    }
}

