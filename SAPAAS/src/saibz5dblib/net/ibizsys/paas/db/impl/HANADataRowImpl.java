/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataRowImpl
 */
package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataRowImpl;

public class HANADataRowImpl
extends DataRowImpl {
    public HANADataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object getRealObject(Object obj) throws Exception {
        if (obj != null && obj instanceof Blob) {
            Blob blob = (Blob)obj;
            InputStream is = null;
            ByteArrayOutputStream baos = null;
            try {
                int b;
                is = blob.getBinaryStream();
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                while ((b = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, b);
                }
                byte[] ret = baos.toByteArray();
                is.close();
                baos.close();
                return ret;
            }
            catch (Exception ex) {
                try {
                    if (is != null) {
                        is.close();
                    }
                }
                catch (Exception buffer) {
                    // empty catch block
                }
                try {
                    if (baos != null) {
                        baos.close();
                    }
                }
                catch (Exception buffer) {
                    // empty catch block
                }
                throw ex;
            }
        }
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
        return super.getRealObject(obj);
    }
}

