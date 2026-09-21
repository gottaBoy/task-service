/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.util;

public class LogLevels {
    public static final int NORMAL = 0;
    public static final int ERROR = 1;
    public static final int CRITICAL = 2;
    public static final int WARNING = 4;
    public static final int DEBUG = 5;
    public static final String NORMAL_MSG = "\ufffd\ufffd\ufffd\ufffd";
    public static final String WARNING_MSG = "\ufffd\ufffd\ufffd\ufffd";
    public static final String ERROR_MSG = "\u04bb\ufffd\ufffd\ufffd\ufffd\ufffd";
    public static final String CRITICAL_MSG = "\ufffd\u063c\ufffd\ufffd\ufffd\ufffd\ufffd";
    public static final String DEBUG_MSG = "\ufffd\ufffd\ufffd\ufffd\ufffd\ufffd\u03e2";

    public static String ToString(int nCode) {
        switch (nCode) {
            case 0: {
                return "\ufffd\ufffd\ufffd\ufffd";
            }
            case 4: {
                return "\ufffd\ufffd\ufffd\ufffd";
            }
            case 1: {
                return ERROR_MSG;
            }
            case 2: {
                return CRITICAL_MSG;
            }
            case 5: {
                return DEBUG_MSG;
            }
        }
        return "\ufffd\ufffd\ufffd\ufffd";
    }
}

