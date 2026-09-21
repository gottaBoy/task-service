/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  oracle.sql.CLOB
 *  oracle.sql.TIMESTAMP
 */
package SA.SRFramework.Data.Oracle;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import oracle.sql.CLOB;
import oracle.sql.TIMESTAMP;

public class OracleDataRow
extends DataRow {
    public OracleDataRow(DataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    @Override
    protected Object GetRealObject(Object obj) {
        if (obj != null && obj instanceof CLOB) {
            try {
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
            catch (Exception ex) {
                System.out.print(obj.toString());
                ex.printStackTrace();
                return "";
            }
        }
        if (obj != null && obj instanceof Clob) {
            try {
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
            catch (Exception ex) {
                System.out.print(obj.toString());
                ex.printStackTrace();
                return "";
            }
        }
        if (obj != null && obj instanceof TIMESTAMP) {
            TIMESTAMP ts = (TIMESTAMP)obj;
            try {
                Timestamp ts2 = TIMESTAMP.toTimestamp((byte[])ts.toBytes());
                return ts2;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return super.GetRealObject(obj);
    }
}

