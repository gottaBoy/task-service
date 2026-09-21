/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public class PageStyleHelper {
    public static final int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("Dialog") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("MainList") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("if_MainList") == 0) {
            return 3;
        }
        if (strValue.compareToIgnoreCase("MainEdit") == 0) {
            return 4;
        }
        return 0;
    }
}

