/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.CommonEx;

public class LogLevels {
    public static final int NORMAL = 0;
    public static final int ERROR = 1;
    public static final int CRITICAL = 2;
    public static final int WARNING = 4;
    public static final int DEBUG = 5;
    public static final String NORMAL_MSG = "\u5e38\u89c4";
    public static final String WARNING_MSG = "\u8b66\u544a";
    public static final String ERROR_MSG = "\u4e00\u822c\u9519\u8bef";
    public static final String CRITICAL_MSG = "\u5173\u952e\u9519\u8bef";
    public static final String DEBUG_MSG = "\u8c03\u8bd5\u4fe1\u606f";

    public static String ToString(int nCode) {
        switch (nCode) {
            case 0: {
                return NORMAL_MSG;
            }
            case 4: {
                return WARNING_MSG;
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
        return NORMAL_MSG;
    }
}

