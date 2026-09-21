/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Common;

public class Version {
    public static final int MAJOR = 3;
    public static final String MINOR = "14";
    public static final String BUILD = "061100";

    public static final String toVersionString() {
        return String.format("%1$s.%2$s.%3$s", 3, MINOR, BUILD);
    }
}

