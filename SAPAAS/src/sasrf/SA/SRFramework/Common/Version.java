/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Common;

public class Version {
    public static final int MAJOR = 1;
    public static final String MINOR = "14";
    public static final String BUILD = "061100";

    public static final String toVersionString() {
        return String.format("%1$s.%2$s.%3$s", 1, MINOR, BUILD);
    }
}

