/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataColumnImpl;
import net.ibizsys.paas.db.impl.DataRowImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataTableImpl
implements IDataTable {
    private static Integer rsCount = 0;
    private static final Log log = LogFactory.getLog(DataTableImpl.class);
    protected ResultSet resultSet = null;
    protected HashMap<String, Integer> columnIndextable = new HashMap();
    protected ArrayList<IDataColumn> columnVector = new ArrayList();
    protected Vector<IDataRow> rowVector = null;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
        if (iDataSet == null || resultSet == null) {
            return;
        }
        this.initColumns(resultSet);
        this.resultSet = resultSet;
        if (this.resultSet != null) {
            Integer n = rsCount;
            synchronized (n) {
                rsCount = rsCount + 1;
            }
        }
    }

    @Override
    public int getColumnCount() {
        return this.columnVector.size();
    }

    @Override
    public int getColumnIndex(String strColumnName) {
        if (this.columnIndextable.containsKey(strColumnName = strColumnName.toUpperCase())) {
            return this.columnIndextable.get(strColumnName);
        }
        return -1;
    }

    @Override
    public IDataColumn getDataColumn(int nIndex) {
        if (nIndex < 0 || nIndex >= this.columnVector.size()) {
            return null;
        }
        return this.columnVector.get(nIndex);
    }

    private void initColumns(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetmd = resultSet.getMetaData();
        int numberOfColumns = resultSetmd.getColumnCount();
        int i = 1;
        while (i <= numberOfColumns) {
            DataColumnImpl dataColumn = new DataColumnImpl();
            dataColumn.setName(resultSetmd.getColumnName(i));
            dataColumn.setIndex(i);
            dataColumn.setDBDataType(resultSetmd.getColumnTypeName(i));
            dataColumn.setCatalogName(resultSetmd.getCatalogName(i));
            dataColumn.setColumnClassName(resultSetmd.getColumnClassName(i));
            dataColumn.setColumnType(resultSetmd.getColumnType(i));
            dataColumn.setDisplaySize(resultSetmd.getColumnDisplaySize(i));
            this.columnVector.add(dataColumn);
            this.columnIndextable.put(dataColumn.getName().toUpperCase(), i - 1);
            ++i;
        }
    }

    @Override
    public IDataRow next() throws SQLException {
        if (this.getResultSet() == null) {
            return null;
        }
        if (this.getResultSet().next()) {
            return this.createDataRow();
        }
        return null;
    }

    protected IDataRow createDataRow() throws SQLException {
        return new DataRowImpl(this, this.getResultSet());
    }

    @Override
    public ResultSet getResultSet() {
        return this.resultSet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        block5: {
            try {
                if (this.resultSet == null) break block5;
                this.resultSet.close();
                this.resultSet = null;
                Integer n = rsCount;
                synchronized (n) {
                    rsCount = rsCount - 1;
                }
            }
            catch (Exception e) {
                log.error((Object)e.getMessage(), (Throwable)e);
            }
        }
    }

    @Override
    public int getCachedRowCount() {
        if (this.rowVector == null) {
            return -1;
        }
        return this.rowVector.size();
    }

    @Override
    public int cacheRows(int nSize) throws SQLException {
        if (this.rowVector == null) {
            this.rowVector = new Vector();
        } else {
            this.rowVector.clear();
        }
        while (nSize == -1 || nSize > 0) {
            IDataRow iDataRow = this.next();
            if (iDataRow == null) {
                this.close();
                break;
            }
            this.rowVector.add(iDataRow);
            if (nSize <= 0) continue;
            --nSize;
        }
        return this.rowVector.size();
    }

    @Override
    public IDataRow getCachedRow(int nIndex) throws Exception {
        return this.rowVector.get(nIndex);
    }

    public static int getUnclosedRSCount() {
        return rsCount;
    }

    @Override
    public int cacheAllRows() throws SQLException {
        if (this.getResultSet() == null) {
            return this.getCachedRowCount();
        }
        return this.cacheRows(-1);
    }
}

