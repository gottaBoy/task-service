/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS;

import net.ibizsys.paas.util.StringHelper;

public class Version {
    public static final Integer MAJOR = 8;
    public static final Integer MINOR = 1;
    public static final Integer FUNC = 240;
    public static final Integer DATE = 20240308;

    public String toString() {
        return StringHelper.format((String)"%1$s.%2$s.%3$s.%4$s", (Object)MAJOR, (Object)MINOR, (Object)DATE, (Object)FUNC);
    }

    public static String toVersionString() {
        return StringHelper.format((String)"%1$s.%2$s.%3$s.%4$s", (Object)MAJOR, (Object)MINOR, (Object)DATE, (Object)FUNC);
    }
}

