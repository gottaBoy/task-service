/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.StringHelper;

public class TextBoxModeHelper {
    public static int FromString(String strValue) {
        if (StringHelper.Compare(strValue, "MultiLine", true) == 0) {
            return 1;
        }
        if (StringHelper.Compare(strValue, "Password", true) == 0) {
            return 2;
        }
        if (StringHelper.Compare(strValue, "SingleLine", true) == 0) {
            return 3;
        }
        if (StringHelper.Compare(strValue, "Caret", true) == 0) {
            return 4;
        }
        return 3;
    }

    public static String ToString(int nValue) {
        switch (nValue) {
            case 1: {
                return "MultiLine";
            }
            case 2: {
                return "Password";
            }
            case 3: {
                return "SingleLine";
            }
            case 4: {
                return "Caret";
            }
        }
        return "SingleLine";
    }
}

