/*
 * Decompiled with CFR 0.152.
 */
package SRFWF;

public class WFVersion {
    public static final int MAJOR = 2;
    public static final int MINOR = 11;
    public static final int BUILD = 3;

    public static String toVersionString() {
        return String.format("%1$s.%2$s.%3$s", 2, 11, 3);
    }
}

