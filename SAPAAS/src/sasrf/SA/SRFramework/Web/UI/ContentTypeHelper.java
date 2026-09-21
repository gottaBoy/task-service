/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

public class ContentTypeHelper {
    public static int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("Text") == 0) {
            return 0;
        }
        if (strValue.compareToIgnoreCase("Html") == 0) {
            return 1;
        }
        return 0;
    }
}

