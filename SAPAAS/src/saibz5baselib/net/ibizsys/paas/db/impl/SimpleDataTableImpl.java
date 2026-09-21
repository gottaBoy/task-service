/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleDataTableImpl
implements IDataTable {
    private static final Log log = LogFactory.getLog(SimpleDataTableImpl.class);
    protected Vector<IDataRow> rowVector = new Vector();

    public SimpleDataTableImpl(IDataSet iDataSet) throws SQLException {
    }

    @Override
    public int getColumnCount() {
        return -1;
    }

    @Override
    public int getColumnIndex(String strColumnName) {
        return -1;
    }

    @Override
    public IDataColumn getDataColumn(int nIndex) {
        return null;
    }

    @Override
    public IDataRow next() throws SQLException {
        return null;
    }

    @Override
    public ResultSet getResultSet() {
        return null;
    }

    @Override
    public void close() {
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
        return this.rowVector.size();
    }

    @Override
    public IDataRow getCachedRow(int nIndex) throws Exception {
        return this.rowVector.get(nIndex);
    }

    public void addCachedRow(IDataRow iDataRow) {
        this.rowVector.add(iDataRow);
    }

    @Override
    public int cacheAllRows() throws SQLException {
        return this.cacheRows(-1);
    }

    public void reset() {
        if (this.rowVector != null) {
            this.rowVector.clear();
        }
    }
}

