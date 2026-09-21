/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.db.IDatabase;
import net.ibizsys.paas.util.StringHelper;

public abstract class DatabaseImpl
extends ModelBaseImpl
implements IDatabase {
    public static final String PROPERTY_DBTYPE = "DBTYPE";
    public static final String PROPERTY_DSN = "DSN";
    protected String strDBType = "";
    protected String strDSN = "";
    protected boolean bUnicodeChar = false;

    @Override
    public String getDBType() {
        return this.strDBType;
    }

    @Override
    public Connection getConnection() throws Exception {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup(this.getDSN());
        return ds.getConnection();
    }

    protected void setDBType(String strDBType) {
        this.strDBType = strDBType;
    }

    protected void setDSN(String strDSN) {
        this.strDSN = strDSN;
    }

    protected String getDSN() {
        return this.strDSN;
    }

    @Override
    public String getCountSQL(String strSQL) {
        return StringHelper.format("select count(*) as TOTALROW from (%1$s) m1", strSQL);
    }

    @Override
    public int getJDBCType(int dataType) {
        if (dataType == 1) {
            return -5;
        }
        if (dataType == 2) {
            return -2;
        }
        if (dataType == 3) {
            return -7;
        }
        if (dataType == 4 || dataType == 11 || dataType == 26) {
            return 1;
        }
        if (dataType == 28 || dataType == 5 || dataType == 16 || dataType == 22) {
            return 93;
        }
        if (dataType == 6 || dataType == 29 || dataType == 10 || dataType == 18) {
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

    public boolean isUnicodeChar() {
        return this.bUnicodeChar;
    }

    public void setUnicodeChar(boolean bUnicodeChar) {
        this.bUnicodeChar = bUnicodeChar;
    }

    @Override
    public String getDBObjStandardName(String strOriginName) {
        return strOriginName;
    }
}

