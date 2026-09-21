/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.ConnectionPool;
import SA.SRFramework.Data.DBProcCaller;

public class DB2DBProcCaller
extends DBProcCaller {
    protected static String DRIVER = "COM.ibm.db2.jdbc.net.DB2Driver";
    private ConnectionPool connPool = null;

    public DB2DBProcCaller() {
        this.curDBType = 4;
    }

    @Override
    protected String GetDriverName() {
        return DRIVER;
    }

    public static String FormatProcCall(String strProcName, int nParamCount) {
        String strCall = "{CALL ";
        strCall = String.valueOf(strCall) + strProcName;
        strCall = String.valueOf(strCall) + " ";
        if (nParamCount > 0) {
            strCall = String.valueOf(strCall) + "(";
            int i = 0;
            while (i < nParamCount) {
                if (i != 0) {
                    strCall = String.valueOf(strCall) + ",";
                }
                strCall = String.valueOf(strCall) + "?";
                ++i;
            }
            strCall = String.valueOf(strCall) + ")";
        }
        strCall = String.valueOf(strCall) + " } ";
        return strCall;
    }

    public static int GetJDBCType(int dataType) {
        if (dataType == 1) {
            return -5;
        }
        if (dataType == 2 || dataType == 22) {
            return -2;
        }
        if (dataType == 3) {
            return -7;
        }
        if (dataType == 4 || dataType == 11 || dataType == 26) {
            return 1;
        }
        if (dataType == 28 || dataType == 5 || dataType == 16) {
            return 93;
        }
        if (dataType == 6 || dataType == 10 || dataType == 18) {
            return 3;
        }
        if (dataType == 7) {
            return 6;
        }
        if (dataType == 8) {
            return -4;
        }
        if (dataType == 9) {
            return 4;
        }
        if (dataType == 12 || dataType == 21) {
            return -1;
        }
        if (dataType == 14) {
            return 2;
        }
        if (dataType == 13 || dataType == 19 || dataType == 20 || dataType == 25) {
            return 12;
        }
        if (dataType == 15) {
            return 7;
        }
        if (dataType == 17) {
            return 5;
        }
        if (dataType == 23) {
            return -6;
        }
        if (dataType == 24) {
            return -3;
        }
        return 12;
    }
}

