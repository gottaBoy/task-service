/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas;

import net.ibizsys.paas.util.StringHelper;

public class Version {
    public static final Integer MAJOR = 5;
    public static final Integer MINOR = 0;
    public static final Integer FUNC = 23;
    public static final Integer FIX = 8;
    public static final Integer DATE = 200403;

    public String toString() {
        return StringHelper.format("%1$s.%2$s.%3$s.%4$s", MAJOR, MINOR, FUNC, FIX);
    }

    public static String toVersionString() {
        return StringHelper.format("%1$s.%2$s.%3$s.%4$s", MAJOR, MINOR, FUNC, FIX);
    }
}

