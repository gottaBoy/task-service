/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.SRFCheckBoxList;
import SA.SRFramework.Web.SRFDataPicker;
import SA.SRFramework.Web.SRFDate;
import SA.SRFramework.Web.SRFDateTime;
import SA.SRFramework.Web.SRFDropDownList;
import SA.SRFramework.Web.SRFHidden;
import SA.SRFramework.Web.SRFIpAddress;
import SA.SRFramework.Web.SRFLiteral;
import SA.SRFramework.Web.SRFMacAddress;
import SA.SRFramework.Web.SRFRadioButtonList;
import SA.SRFramework.Web.SRFText;
import SA.SRFramework.Web.SRFTextBox;
import SA.SRFramework.Web.SRFTime;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.WebCtrlConfig;
import SA.SRFramework.Web.UI.WebCtrlTags;

public class WebCtrlHelper {
    protected static String strPreFix_TextBox = "tbx_";
    protected static String strPreFix_DropDownList = "ddl_";

    public static SRFWebControl Create(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        Object objCtrl;
        int nCtrlStyle = webCtrlConfig.getCtrlStyle();
        if (nCtrlStyle == 1) {
            return WebCtrlHelper.CreateTextBox(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 2) {
            return WebCtrlHelper.CreateRichTextBox(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 4) {
            return WebCtrlHelper.CreateDateCtrl(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 5) {
            return WebCtrlHelper.CreateDateTimeCtrl(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 6) {
            return WebCtrlHelper.CreateDropDownList(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 7) {
            return WebCtrlHelper.CreateDataPicker(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 3) {
            return WebCtrlHelper.CreateHiddenInput(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 8) {
            return WebCtrlHelper.CreateText(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 11) {
            return WebCtrlHelper.CreateLiteral(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 9) {
            return WebCtrlHelper.CreateCheckBoxList(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 10) {
            return WebCtrlHelper.CreateRadioButtonList(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 12) {
            return WebCtrlHelper.CreateTimeCtrl(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 13) {
            return WebCtrlHelper.CreateIpAddress(webCtrlConfig, strIdFormat);
        }
        if (nCtrlStyle == 14) {
            return WebCtrlHelper.CreateMacAddress(webCtrlConfig, strIdFormat);
        }
        String strCustomTag = webCtrlConfig.getCustomTag();
        if (StringHelper.Length(strCustomTag) != 0 && (objCtrl = WebCtrlHelper.InternalCreateObject(strCustomTag)) != null && ClassHelper.ContainClass(objCtrl.getClass(), SRFWebControl.class)) {
            return (SRFWebControl)objCtrl;
        }
        return null;
    }

    protected static SRFTextBox CreateTextBox(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFTextBox textBox = new SRFTextBox();
        textBox.setTextMode(3);
        textBox.setID(String.valueOf(strPreFix_TextBox) + strIdFormat);
        if (webCtrlConfig.GetExtValue(WebCtrlTags.PASSWORD, false)) {
            textBox.setTextMode(2);
        }
        return textBox;
    }

    protected static SRFTextBox CreateRichTextBox(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFTextBox textBox = new SRFTextBox();
        textBox.setTextMode(1);
        textBox.setID(String.valueOf(strPreFix_TextBox) + strIdFormat);
        textBox.setRows(webCtrlConfig.GetExtValue(WebCtrlTags.ROWS, 5));
        return textBox;
    }

    protected static SRFDate CreateDateCtrl(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFDate dateCtrl = new SRFDate();
        dateCtrl.setID(strIdFormat);
        return dateCtrl;
    }

    protected static SRFTime CreateTimeCtrl(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFTime timeCtrl = new SRFTime();
        timeCtrl.setID(strIdFormat);
        return timeCtrl;
    }

    protected static SRFHidden CreateHiddenInput(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFHidden hidden = new SRFHidden();
        hidden.setID(strIdFormat);
        return hidden;
    }

    protected static SRFDateTime CreateDateTimeCtrl(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFDateTime dateTimeCtrl = new SRFDateTime();
        dateTimeCtrl.setID(strIdFormat);
        return dateTimeCtrl;
    }

    protected static SRFDropDownList CreateDropDownList(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFDropDownList dropDownList = new SRFDropDownList();
        dropDownList.setID(String.valueOf(strPreFix_DropDownList) + strIdFormat);
        return dropDownList;
    }

    protected static SRFDataPicker CreateDataPicker(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFDataPicker dataPicker = new SRFDataPicker();
        dataPicker.setID(strIdFormat);
        dataPicker.setPickOnly(webCtrlConfig.GetExtValue(WebCtrlTags.PICKONLY, true));
        dataPicker.setSeparator(webCtrlConfig.GetExtValue(WebCtrlTags.SEPARATOR, "|"));
        dataPicker.setPickJSCall(webCtrlConfig.GetExtValue(WebCtrlTags.PICKJSCALL, "datapick"));
        dataPicker.setSupportNew(webCtrlConfig.GetExtValue(WebCtrlTags.SUPPORTNEW, false));
        dataPicker.setNewJSCall(webCtrlConfig.GetExtValue(WebCtrlTags.NEWJSCALL, "datanew"));
        return dataPicker;
    }

    protected static SRFLiteral CreateLiteral(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFLiteral literal = new SRFLiteral();
        literal.setID(strIdFormat);
        return literal;
    }

    protected static SRFText CreateText(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFText text = new SRFText();
        text.setID(strIdFormat);
        return text;
    }

    protected static SRFCheckBoxList CreateCheckBoxList(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFCheckBoxList checkBoxList = new SRFCheckBoxList();
        checkBoxList.setID(strIdFormat);
        int nColumns = webCtrlConfig.GetExtValue("COLUMNCOUNT", 6);
        checkBoxList.setRepeatColumns(nColumns);
        checkBoxList.setSeparator(webCtrlConfig.GetExtValue(WebCtrlTags.SEPARATOR, "|"));
        return checkBoxList;
    }

    protected static SRFRadioButtonList CreateRadioButtonList(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFRadioButtonList radioButtonList = new SRFRadioButtonList();
        radioButtonList.setID(strIdFormat);
        int nColumns = webCtrlConfig.GetExtValue("COLUMNCOUNT", 6);
        radioButtonList.setRepeatColumns(nColumns);
        return radioButtonList;
    }

    protected static SRFIpAddress CreateIpAddress(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFIpAddress ipAddressCtrl = new SRFIpAddress();
        ipAddressCtrl.setID(strIdFormat);
        return ipAddressCtrl;
    }

    protected static SRFMacAddress CreateMacAddress(WebCtrlConfig webCtrlConfig, String strIdFormat) {
        SRFMacAddress macAddressCtrl = new SRFMacAddress();
        macAddressCtrl.setSeparator(webCtrlConfig.GetExtValue(WebCtrlTags.SEPARATOR, ":"));
        macAddressCtrl.setID(strIdFormat);
        return macAddressCtrl;
    }

    private static Object InternalCreateObject(String strType) {
        try {
            return Class.forName(strType).newInstance();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }
}

