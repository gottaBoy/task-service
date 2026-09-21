/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public class WebCtrlStyleHelper {
    public static final int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("TextBox") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("RichTextBox") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("HiddenInput") == 0) {
            return 3;
        }
        if (strValue.compareToIgnoreCase("Date") == 0) {
            return 4;
        }
        if (strValue.compareToIgnoreCase("DateTime") == 0) {
            return 5;
        }
        if (strValue.compareToIgnoreCase("DropDownList") == 0) {
            return 6;
        }
        if (strValue.compareToIgnoreCase("DataPicker") == 0) {
            return 7;
        }
        if (strValue.compareToIgnoreCase("Text") == 0) {
            return 8;
        }
        if (strValue.compareToIgnoreCase("MultiCheck") == 0) {
            return 9;
        }
        if (strValue.compareToIgnoreCase("MultiRadio") == 0) {
            return 10;
        }
        if (strValue.compareToIgnoreCase("Literal") == 0) {
            return 11;
        }
        if (strValue.compareToIgnoreCase("Time") == 0) {
            return 12;
        }
        if (strValue.compareToIgnoreCase("IpAddress") == 0) {
            return 13;
        }
        if (strValue.compareToIgnoreCase("MacAddress") == 0) {
            return 14;
        }
        return 0;
    }
}

