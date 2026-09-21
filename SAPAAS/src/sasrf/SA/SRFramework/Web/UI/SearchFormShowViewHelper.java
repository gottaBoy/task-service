/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public class SearchFormShowViewHelper {
    public static int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("Normal") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("Advance") == 0) {
            return 2;
        }
        return 1;
    }
}

