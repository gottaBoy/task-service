/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataRowImpl
 *  oracle.sql.BLOB
 *  oracle.sql.CLOB
 *  oracle.sql.TIMESTAMP
 */
package net.ibizsys.paas.db.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataRowImpl;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import oracle.sql.TIMESTAMP;

public class OracleDataRowImpl
extends DataRowImpl {
    public OracleDataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object getRealObject(Object obj) throws Exception {
        if (obj != null && obj instanceof CLOB) {
            boolean bFirst = true;
            CLOB clob = (CLOB)obj;
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
        if (obj != null && obj instanceof BLOB) {
            InputStream is = null;
            ByteArrayOutputStream baos = null;
            try {
                int b;
                BLOB blob = (BLOB)obj;
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
                catch (Exception b) {
                    // empty catch block
                }
                try {
                    if (baos != null) {
                        baos.close();
                    }
                }
                catch (Exception b) {
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
                catch (Exception exception) {
                    // empty catch block
                }
                try {
                    if (baos != null) {
                        baos.close();
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
                throw ex;
            }
        }
        if (obj != null && obj instanceof TIMESTAMP) {
            TIMESTAMP ts = (TIMESTAMP)obj;
            Timestamp ts2 = TIMESTAMP.toTimestamp((byte[])ts.toBytes());
            return ts2;
        }
        return super.getRealObject(obj);
    }
}

