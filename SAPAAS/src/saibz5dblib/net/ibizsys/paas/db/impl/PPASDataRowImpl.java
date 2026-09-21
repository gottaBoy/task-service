/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataRowImpl
 *  org.postgresql.jdbc.PgClob
 */
package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataRowImpl;
import org.postgresql.jdbc.PgClob;

public class PPASDataRowImpl
extends DataRowImpl {
    public PPASDataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object getRealObject(Object obj) throws Exception {
        if (obj != null && obj instanceof PgClob) {
            boolean bFirst = true;
            PgClob clob = (PgClob)obj;
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

