/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Security;

import SA.SRFramework.Utility.StringHelper;

public final class PrivilegesHelper {
    public static final int FromString(String strValue) {
        if (StringHelper.Compare("CreateWrite", strValue, true) == 0) {
            return 2;
        }
        if (StringHelper.Compare("Read", strValue, true) == 0) {
            return 1;
        }
        if (StringHelper.Compare("All", strValue, true) == 0) {
            return 3;
        }
        return 0;
    }
}

