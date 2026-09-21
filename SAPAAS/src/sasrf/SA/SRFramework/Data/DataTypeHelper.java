/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TreeMap;

public final class DataTypeHelper {
    protected static TreeMap<String, Integer> str2intMap = new TreeMap();
    protected static TreeMap<Integer, String> int2strMap = new TreeMap();

    static {
        str2intMap.put("BIGINT", 1);
        str2intMap.put("BINARY", 2);
        str2intMap.put("BIT", 3);
        str2intMap.put("CHAR", 4);
        str2intMap.put("DATETIME", 5);
        str2intMap.put("DECIMAL", 6);
        str2intMap.put("FLOAT", 7);
        str2intMap.put("IMAGE", 8);
        str2intMap.put("INT", 9);
        str2intMap.put("MONEY", 10);
        str2intMap.put("NCHAR", 11);
        str2intMap.put("NTEXT", 12);
        str2intMap.put("NVARCHAR", 13);
        str2intMap.put("NUMERIC", 14);
        str2intMap.put("REAL", 15);
        str2intMap.put("SMALLDATETIME", 16);
        str2intMap.put("SMALLINT", 17);
        str2intMap.put("SMALLMONEY", 18);
        str2intMap.put("SQL_VARIANT", 19);
        str2intMap.put("SYSNAME", 20);
        str2intMap.put("TEXT", 21);
        str2intMap.put("TIMESTAMP", 22);
        str2intMap.put("TINYINT", 23);
        str2intMap.put("VARBINARY", 24);
        str2intMap.put("VARCHAR", 25);
        str2intMap.put("UNIQUEIDENTIFIER", 26);
        str2intMap.put("DATE", 27);
        str2intMap.put("TIME", 28);
        int2strMap.put(1, "BIGINT");
        int2strMap.put(2, "BINARY");
        int2strMap.put(3, "BIT");
        int2strMap.put(4, "CHAR");
        int2strMap.put(5, "DATETIME");
        int2strMap.put(6, "DECIMAL");
        int2strMap.put(7, "FLOAT");
        int2strMap.put(8, "IMAGE");
        int2strMap.put(9, "INT");
        int2strMap.put(10, "MONEY");
        int2strMap.put(11, "NCHAR");
        int2strMap.put(12, "NTEXT");
        int2strMap.put(13, "NVARCHAR");
        int2strMap.put(14, "NUMERIC");
        int2strMap.put(15, "REAL");
        int2strMap.put(16, "SMALLDATETIME");
        int2strMap.put(17, "SMALLINT");
        int2strMap.put(18, "SMALLMONEY");
        int2strMap.put(19, "SQL_VARIANT");
        int2strMap.put(20, "SYSNAME");
        int2strMap.put(21, "TEXT");
        int2strMap.put(22, "TIMESTAMP");
        int2strMap.put(23, "TINYINT");
        int2strMap.put(24, "VARBINARY");
        int2strMap.put(25, "VARCHAR");
        int2strMap.put(26, "UNIQUEIDENTIFIER");
        int2strMap.put(27, "DATE");
        int2strMap.put(28, "TIME");
    }

    public static final boolean IsContainsDataType(String strValue) {
        strValue = strValue.toUpperCase();
        return str2intMap.containsKey(strValue);
    }

    public static final String ToString(int nValue) {
        if (int2strMap.containsKey(nValue)) {
            return int2strMap.get(nValue);
        }
        return "VARCHAR";
    }

    public static final int FromString(String strValue) {
        if (str2intMap.containsKey(strValue = strValue.toUpperCase())) {
            return str2intMap.get(strValue);
        }
        return 25;
    }

    public static final boolean IsStringType(int dataType) {
        return dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25;
    }

    public static final boolean IsStringType(String strDataType) {
        return DataTypeHelper.IsStringType(DataTypeHelper.FromString(strDataType));
    }

    public static final boolean IsLongStringType(int dataType) {
        return dataType == 8 || dataType == 12 || dataType == 13 || dataType == 21;
    }

    public static final boolean IsDateTimeType(int dataType) {
        return dataType == 5 || dataType == 16 || dataType == 27 || dataType == 28;
    }

    public static final boolean IsDateTimeType(String strDataType) {
        return DataTypeHelper.IsDateTimeType(DataTypeHelper.FromString(strDataType));
    }

    public static final boolean IsBigIntType(int dataType) {
        return dataType == 1;
    }

    public static final boolean IsBigIntType(String strDataType) {
        return DataTypeHelper.IsBigIntType(DataTypeHelper.FromString(strDataType));
    }

    public static final boolean IsIntType(int dataType) {
        return dataType == 1 || dataType == 9 || dataType == 17;
    }

    public static final boolean IsIntType(String strDataType) {
        return DataTypeHelper.IsIntType(DataTypeHelper.FromString(strDataType));
    }

    public static final boolean IsDoubleType(int dataType) {
        return dataType == 7 || dataType == 6;
    }

    public static String GetTypeName(String strDataType) {
        return DataTypeHelper.GetTypeName(DataTypeHelper.FromString(strDataType));
    }

    public static String GetTypeName(int dataType) {
        if (dataType == 1 || dataType == 9 || dataType == 17) {
            return "\u6574\u6570\u578b";
        }
        if (dataType == 4 || dataType == 11 || dataType == 12 || dataType == 13 || dataType == 20 || dataType == 21 || dataType == 25) {
            return "\u5b57\u7b26\u578b";
        }
        if (dataType == 5 || dataType == 16) {
            return "\u65e5\u671f\u65f6\u95f4\u578b";
        }
        if (dataType == 27) {
            return "\u65e5\u671f\u578b";
        }
        if (dataType == 28) {
            return "\u65f6\u95f4\u578b";
        }
        if (dataType == 6 || dataType == 10 || dataType == 14 || dataType == 18 || dataType == 7 || dataType == 15) {
            return "\u6570\u503c\u578b";
        }
        return "\u672a\u77e5\u7c7b\u578b";
    }

    public static int GetObjectDataType(Object objValue) {
        if (objValue instanceof String || objValue instanceof Character) {
            return 25;
        }
        if (objValue instanceof java.sql.Date || objValue instanceof Date || objValue instanceof Timestamp) {
            return 5;
        }
        if (objValue instanceof Integer) {
            return 9;
        }
        if (objValue instanceof BigInteger) {
            return 1;
        }
        if (objValue instanceof Float || objValue instanceof Double) {
            return 7;
        }
        return 25;
    }
}

