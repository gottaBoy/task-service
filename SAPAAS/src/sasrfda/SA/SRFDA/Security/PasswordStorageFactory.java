/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Security;

import SA.SRFDA.Security.DefaultPasswordStorage;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class PasswordStorageFactory {
    private static IPasswordStorage iPasswordStorage = null;

    public static IPasswordStorage Create(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        return PasswordStorageFactory.Create(iDAGlobalHelper, "");
    }

    public static IPasswordStorage Create(ISRFDAGlobalHelper iDAGlobalHelper, String strTag) throws Exception {
        if (iPasswordStorage != null) {
            return iPasswordStorage;
        }
        DefaultPasswordStorage iPasswordStorage = new DefaultPasswordStorage();
        iPasswordStorage.Init(iDAGlobalHelper);
        PasswordStorageFactory.iPasswordStorage = iPasswordStorage;
        return iPasswordStorage;
    }
}

