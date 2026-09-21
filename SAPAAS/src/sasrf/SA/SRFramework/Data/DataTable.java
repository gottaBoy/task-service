/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataSet;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Vector;

public class DataTable {
    protected Hashtable<String, Integer> columnIndextable = new Hashtable();
    protected Vector columnVector = new Vector();
    protected Vector rowVector = new Vector();
    protected ResultSet resultSet = null;
    private boolean bDelayReadMode = false;

    public DataTable(DataSet ds, ResultSet rs, boolean bDelayRead) throws SQLException {
        if (ds == null || rs == null) {
            return;
        }
        this.InitColumns(rs);
        if (!bDelayRead) {
            this.InitRows(rs);
        } else {
            this.resultSet = rs;
            this.bDelayReadMode = true;
        }
    }

    public DataTable(DataSet ds, ResultSet rs) throws SQLException {
        if (ds == null || rs == null) {
            return;
        }
        this.InitColumns(rs);
        this.InitRows(rs);
    }

    public int GetColumnCount() {
        return this.columnVector.size();
    }

    public int GetColumnIndex(String strColumnName) {
        if (this.columnIndextable.containsKey(strColumnName = strColumnName.toUpperCase())) {
            return this.columnIndextable.get(strColumnName);
        }
        return -1;
    }

    public DataColumn GetDataColumn(int nIndex) {
        if (nIndex < 0 || nIndex >= this.columnVector.size()) {
            return null;
        }
        return (DataColumn)this.columnVector.get(nIndex);
    }

    public int GetRowCount() {
        return this.rowVector.size();
    }

    public DataRow GetRow(int nIndex) {
        return (DataRow)this.rowVector.get(nIndex);
    }

    public Vector getRows() {
        return this.rowVector;
    }

    private void InitColumns(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int numberOfColumns = rsmd.getColumnCount();
        int i = 1;
        while (i <= numberOfColumns) {
            DataColumn dataColumn = new DataColumn();
            dataColumn.setName(rsmd.getColumnName(i));
            dataColumn.setIndex(i);
            dataColumn.setDBDataType(rsmd.getColumnTypeName(i));
            dataColumn.setCatalogName(rsmd.getCatalogName(i));
            dataColumn.setColumnClassName(rsmd.getColumnClassName(i));
            dataColumn.setColumnType(rsmd.getColumnType(i));
            dataColumn.setDisplaySize(rsmd.getColumnDisplaySize(i));
            this.columnVector.add(dataColumn);
            this.columnIndextable.put(dataColumn.getName().toUpperCase(), i - 1);
            ++i;
        }
    }

    private void InitRows(ResultSet rs) throws SQLException {
        while (rs.next()) {
            DataRow dr = this.CreateRow(rs);
            this.rowVector.add(dr);
        }
    }

    protected DataRow CreateRow(ResultSet rs) throws SQLException {
        return new DataRow(this, rs);
    }

    public int ReadRows(int nSize) throws SQLException {
        if (this.resultSet == null) {
            throw new SQLException("\u7ed3\u679c\u96c6\u5408\u5bf9\u8c61\u65e0\u6548");
        }
        if (nSize <= 0) {
            throw new SQLException("\u8bfb\u53d6\u8bb0\u5f55\u6570\u65e0\u6548");
        }
        int nReadSize = 0;
        this.rowVector.clear();
        while (this.resultSet.next()) {
            DataRow dr = this.CreateRow(this.resultSet);
            this.rowVector.add(dr);
            if (++nReadSize >= nSize) break;
        }
        return nReadSize;
    }

    public ResultSet getResultSet() throws SQLException {
        if (this.resultSet == null) {
            throw new SQLException("\u7ed3\u679c\u96c6\u5408\u5bf9\u8c61\u65e0\u6548");
        }
        return this.resultSet;
    }

    public boolean isDelayReadMode() {
        return this.bDelayReadMode;
    }

    public void Reset() {
        if (this.columnIndextable != null) {
            this.columnIndextable.clear();
            this.columnIndextable = null;
        }
        if (this.columnVector != null) {
            this.columnVector.clear();
            this.columnVector = null;
        }
        if (this.rowVector != null) {
            this.rowVector.clear();
            this.rowVector = null;
        }
    }
}

