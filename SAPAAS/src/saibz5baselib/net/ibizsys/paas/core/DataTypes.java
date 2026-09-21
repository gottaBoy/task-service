/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

public final class DataTypes {
    public static final int UNKNOWN = 0;
    public static final int BIGINT = 1;
    public static final int BINARY = 2;
    public static final int BIT = 3;
    public static final int CHAR = 4;
    public static final int DATETIME = 5;
    public static final int DECIMAL = 6;
    public static final int FLOAT = 7;
    public static final int IMAGE = 8;
    public static final int INT = 9;
    public static final int MONEY = 10;
    public static final int NCHAR = 11;
    public static final int NTEXT = 12;
    public static final int NVARCHAR = 13;
    public static final int NUMERIC = 14;
    public static final int REAL = 15;
    public static final int SMALLDATETIME = 16;
    public static final int SMALLINT = 17;
    public static final int SMALLMONEY = 18;
    public static final int SQL_VARIANT = 19;
    public static final int SYSNAME = 20;
    public static final int TEXT = 21;
    public static final int TIMESTAMP = 22;
    public static final int TINYINT = 23;
    public static final int VARBINARY = 24;
    public static final int VARCHAR = 25;
    public static final int UNIQUEIDENTIFIER = 26;
    public static final int DATE = 27;
    public static final int TIME = 28;
    public static final int BIGDECIMAL = 29;

    public static final int fromString(String strValue) {
        if (strValue.compareToIgnoreCase("BIGINT") == 0) {
            return 1;
        }
        if (strValue.compareToIgnoreCase("BINARY") == 0) {
            return 2;
        }
        if (strValue.compareToIgnoreCase("BIT") == 0) {
            return 3;
        }
        if (strValue.compareToIgnoreCase("CHAR") == 0) {
            return 4;
        }
        if (strValue.compareToIgnoreCase("DATETIME") == 0) {
            return 5;
        }
        if (strValue.compareToIgnoreCase("DECIMAL") == 0) {
            return 6;
        }
        if (strValue.compareToIgnoreCase("FLOAT") == 0) {
            return 7;
        }
        if (strValue.compareToIgnoreCase("IMAGE") == 0) {
            return 8;
        }
        if (strValue.compareToIgnoreCase("INT") == 0) {
            return 9;
        }
        if (strValue.compareToIgnoreCase("MONEY") == 0) {
            return 10;
        }
        if (strValue.compareToIgnoreCase("NCHAR") == 0) {
            return 11;
        }
        if (strValue.compareToIgnoreCase("NTEXT") == 0) {
            return 12;
        }
        if (strValue.compareToIgnoreCase("NVARCHAR") == 0) {
            return 13;
        }
        if (strValue.compareToIgnoreCase("NUMERIC") == 0) {
            return 14;
        }
        if (strValue.compareToIgnoreCase("REAL") == 0) {
            return 15;
        }
        if (strValue.compareToIgnoreCase("SMALLDATETIME") == 0) {
            return 16;
        }
        if (strValue.compareToIgnoreCase("SMALLINT") == 0) {
            return 17;
        }
        if (strValue.compareToIgnoreCase("SMALLMONEY") == 0) {
            return 18;
        }
        if (strValue.compareToIgnoreCase("SQL_VARIANT") == 0) {
            return 19;
        }
        if (strValue.compareToIgnoreCase("SYSNAME") == 0) {
            return 20;
        }
        if (strValue.compareToIgnoreCase("TEXT") == 0) {
            return 21;
        }
        if (strValue.compareToIgnoreCase("TIMESTAMP") == 0) {
            return 22;
        }
        if (strValue.compareToIgnoreCase("TINYINT") == 0) {
            return 23;
        }
        if (strValue.compareToIgnoreCase("VARBINARY") == 0) {
            return 24;
        }
        if (strValue.compareToIgnoreCase("VARCHAR") == 0) {
            return 25;
        }
        if (strValue.compareToIgnoreCase("UNIQUEIDENTIFIER") == 0) {
            return 26;
        }
        if (strValue.compareToIgnoreCase("DATE") == 0) {
            return 27;
        }
        if (strValue.compareToIgnoreCase("TIME") == 0) {
            return 28;
        }
        if (strValue.compareToIgnoreCase("BIGDECIMAL") == 0) {
            return 29;
        }
        return 25;
    }

    public static final String toString(int nDataType) {
        if (nDataType == 1) {
            return "BIGINT";
        }
        if (nDataType == 2) {
            return "BINARY";
        }
        if (nDataType == 3) {
            return "BIT";
        }
        if (nDataType == 4) {
            return "CHAR";
        }
        if (nDataType == 5) {
            return "DATETIME";
        }
        if (nDataType == 6) {
            return "DECIMAL";
        }
        if (nDataType == 7) {
            return "FLOAT";
        }
        if (nDataType == 8) {
            return "IMAGE";
        }
        if (nDataType == 9) {
            return "INT";
        }
        if (nDataType == 10) {
            return "MONEY";
        }
        if (nDataType == 11) {
            return "NCHAR";
        }
        if (nDataType == 12) {
            return "NTEXT";
        }
        if (nDataType == 13) {
            return "NVARCHAR";
        }
        if (nDataType == 14) {
            return "NUMERIC";
        }
        if (nDataType == 15) {
            return "REAL";
        }
        if (nDataType == 16) {
            return "SMALLDATETIME";
        }
        if (nDataType == 17) {
            return "SMALLINT";
        }
        if (nDataType == 18) {
            return "SMALLMONEY";
        }
        if (nDataType == 19) {
            return "SQL_VARIANT";
        }
        if (nDataType == 20) {
            return "SYSNAME";
        }
        if (nDataType == 21) {
            return "TEXT";
        }
        if (nDataType == 22) {
            return "TIMESTAMP";
        }
        if (nDataType == 23) {
            return "TINYINT";
        }
        if (nDataType == 24) {
            return "VARBINARY";
        }
        if (nDataType == 25) {
            return "VARCHAR";
        }
        if (nDataType == 26) {
            return "UNIQUEIDENTIFIER";
        }
        if (nDataType == 27) {
            return "DATE";
        }
        if (nDataType == 28) {
            return "TIME";
        }
        if (nDataType == 29) {
            return "BIGDECIMAL";
        }
        return "VARCHAR";
    }
}

