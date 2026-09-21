/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  com.mysql.jdbc.Clob
 */
package SA.SRFramework.Data.MySQL;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLDataRow
extends DataRow {
    public MySQLDataRow(DataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object GetRealObject(Object obj) {
        if (obj != null && obj instanceof com.mysql.jdbc.Clob) {
            try {
                boolean bFirst = true;
                com.mysql.jdbc.Clob clob = (com.mysql.jdbc.Clob)obj;
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
        return super.GetRealObject(obj);
    }
}

