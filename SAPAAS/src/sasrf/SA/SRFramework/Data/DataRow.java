/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

public class DataRow {
    protected Vector fieldVector = new Vector();
    protected DataTable dataTable = null;

    public DataRow(DataTable dt, ResultSet rs) throws SQLException {
        if (dt == null || rs == null) {
            return;
        }
        this.dataTable = dt;
        int nColumnCount = dt.GetColumnCount();
        int i = 1;
        while (i <= nColumnCount) {
            Object objOrigin = null;
            try {
                objOrigin = rs.getObject(i);
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                String strColumnClassName = dt.GetDataColumn(i - 1).getColumnClassName();
                if (StringHelper.Compare(strColumnClassName, String.class.getName(), true) == 0) {
                    objOrigin = null;
                }
                throw ex;
            }
            Object obj = this.GetRealObject(objOrigin);
            if (obj != null && obj instanceof Date) {
                Timestamp ti = rs.getTimestamp(i);
                obj = null;
                obj = ti;
            }
            this.fieldVector.add(obj);
            ++i;
        }
    }

    protected Object GetRealObject(Object obj) {
        return obj;
    }

    public DataTable getDataTable() {
        return this.dataTable;
    }

    public Object Get(int nIndex) {
        return this.fieldVector.get(nIndex);
    }

    public Object Get(String strColumnName) throws Exception {
        int nIndex = this.dataTable.GetColumnIndex(strColumnName);
        if (nIndex == -1) {
            throw new Exception("\u65e0\u6548\u7684\u5217\u540d\u79f0[" + strColumnName + "]");
        }
        return this.Get(nIndex);
    }

    public boolean IsDBNull(int nIndex) {
        return this.Get(nIndex) == null;
    }

    public boolean IsDBNull(String strColumnName) throws Exception {
        return this.Get(strColumnName) == null;
    }

    public void Reset() {
        if (this.fieldVector != null) {
            this.fieldVector.clear();
            this.fieldVector = null;
        }
        if (this.dataTable != null) {
            this.dataTable = null;
        }
    }
}

