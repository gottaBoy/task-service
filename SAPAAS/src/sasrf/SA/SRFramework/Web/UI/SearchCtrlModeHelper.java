/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public final class SearchCtrlModeHelper {
    public static final int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("None") == 0) {
            return 0;
        }
        if (strValue.compareToIgnoreCase("Normal") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("Advance") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("NormalAndAdvance") == 0) {
            return 3;
        }
        return 0;
    }
}

