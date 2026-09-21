/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

public final class ParameterDirectionHelper {
    public static final int FromString(String strValue) {
        if (strValue.compareToIgnoreCase("Input") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("IN") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("Output") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("OUT") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("InputOutput") == 0) {
            return 3;
        }
        if (strValue.compareToIgnoreCase("INOUT") == 0) {
            return 3;
        }
        if (strValue.compareToIgnoreCase("ReturnValue") == 0) {
            return 4;
        }
        if (strValue.compareToIgnoreCase("None") == 0) {
            return 5;
        }
        return 1;
    }
}

