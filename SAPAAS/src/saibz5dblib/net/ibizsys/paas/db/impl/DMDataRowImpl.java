/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dm.jdbc.driver.DmdbClob
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataRowImpl
 */
package net.ibizsys.paas.db.impl;

import dm.jdbc.driver.DmdbClob;
import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataRowImpl;

public class DMDataRowImpl
extends DataRowImpl {
    public DMDataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object getRealObject(Object obj) throws Exception {
        if (obj != null && obj instanceof Clob) {
            boolean bFirst = true;
            Clob clob = (Clob)obj;
            BufferedReader br = new BufferedReader(clob.getCharacterStream());
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (s != null) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.append("\r\n");
                }
                sb.append(s);
                s = br.readLine();
            }
            return sb.toString();
        }
        if (obj != null && obj instanceof DmdbClob) {
            boolean bFirst = true;
            DmdbClob clob = (DmdbClob)obj;
            BufferedReader br = new BufferedReader(clob.getCharacterStream());
            String s = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (s != null) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.append("\r\n");
                }
                sb.append(s);
                s = br.readLine();
            }
            return sb.toString();
        }
        return super.getRealObject(obj);
    }
}

