/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data.DB2;

import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import java.io.BufferedReader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB2DataRow
extends DataRow {
    public DB2DataRow(DataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    @Override
    protected Object GetRealObject(Object obj) {
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

