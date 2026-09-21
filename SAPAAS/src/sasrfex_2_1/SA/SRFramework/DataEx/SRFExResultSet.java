/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTable
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DataTable;
import SA.SRFramework.DataEx.SRFExResultSetMetaData;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class SRFExResultSet
implements ResultSet {
    protected SRFExResultSetMetaData resultSetMetaData;
    protected String tableName;
    protected int lastIndexRead = -1;
    private int nRowIndex = -1;
    private DataTable dataTable = null;

    public SRFExResultSet(DataTable dt) {
        this.dataTable = dt;
    }

    public void select() throws SQLException {
    }

    public void selectTableNames() throws SQLException {
    }

    @Override
    public void close() {
    }

    @Override
    public boolean next() throws SQLException {
        try {
            ++this.nRowIndex;
            return this.dataTable.GetRowCount() > this.nRowIndex;
        }
        catch (Exception e) {
            throw new SQLException("Error in ResultSet.next() : " + e.getMessage());
        }
    }

    @Override
    public String getString(int i) throws SQLException {
        block3: {
            try {
                this.lastIndexRead = i;
                if (!this.dataTable.GetRow(this.nRowIndex).IsDBNull(i - 1)) break block3;
                return null;
            }
            catch (Exception e) {
                throw new SQLException("Error ResultSet.getString( index ) : " + e.getMessage());
            }
        }
        return (String)this.dataTable.GetRow(this.nRowIndex).Get(i - 1);
    }

    @Override
    public boolean wasNull() throws SQLException {
        if (this.lastIndexRead >= 0) {
            return this.dataTable.GetRow(this.nRowIndex).IsDBNull(this.lastIndexRead - 1);
        }
        return true;
    }

    @Override
    public boolean getBoolean(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return false;
        }
        return (Boolean)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public byte getByte(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0;
        }
        return (Byte)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public short getShort(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0;
        }
        return (Short)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public int getInt(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0;
        }
        return (Integer)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public long getLong(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0L;
        }
        return (Long)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public float getFloat(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0.0f;
        }
        return ((Float)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1)).floatValue();
    }

    @Override
    public double getDouble(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return 0.0;
        }
        return (Double)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return this.getBigDecimal(columnIndex);
    }

    @Override
    public byte[] getBytes(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        return null;
    }

    @Override
    public Date getDate(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return null;
        }
        return (Date)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public Time getTime(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return null;
        }
        return (Time)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        if (this.dataTable.GetRow(this.nRowIndex).IsDBNull(columnIndex - 1)) {
            return null;
        }
        return (Timestamp)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        return null;
    }

    @Override
    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return this.getAsciiStream(columnIndex);
    }

    @Override
    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return this.getAsciiStream(columnIndex);
    }

    @Override
    public String getString(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getString(nColumnIndex);
    }

    @Override
    public boolean getBoolean(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getBoolean(nColumnIndex);
    }

    @Override
    public byte getByte(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getByte(nColumnIndex);
    }

    @Override
    public short getShort(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getShort(nColumnIndex);
    }

    @Override
    public int getInt(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getInt(nColumnIndex);
    }

    @Override
    public long getLong(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getLong(nColumnIndex);
    }

    @Override
    public float getFloat(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getFloat(nColumnIndex);
    }

    @Override
    public double getDouble(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getDouble(nColumnIndex);
    }

    @Override
    public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
        return this.getBigDecimal(columnName);
    }

    @Override
    public byte[] getBytes(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getBytes(nColumnIndex);
    }

    @Override
    public Date getDate(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getDate(nColumnIndex);
    }

    @Override
    public Time getTime(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getTime(nColumnIndex);
    }

    @Override
    public Timestamp getTimestamp(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getTimestamp(nColumnIndex);
    }

    @Override
    public InputStream getAsciiStream(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.getAsciiStream(nColumnIndex);
    }

    @Override
    public InputStream getUnicodeStream(String columnName) throws SQLException {
        return this.getAsciiStream(columnName);
    }

    @Override
    public InputStream getBinaryStream(String columnName) throws SQLException {
        return this.getAsciiStream(columnName);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getWarnings() unsupported");
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.clearWarnings() unsupported");
    }

    @Override
    public String getCursorName() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getCursorName() unsupported");
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        if (this.resultSetMetaData == null) {
            this.resultSetMetaData = new SRFExResultSetMetaData(this.dataTable);
        }
        return this.resultSetMetaData;
    }

    @Override
    public Object getObject(int columnIndex) throws SQLException {
        return this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public Object getObject(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return this.dataTable.GetRow(this.nRowIndex).Get(nColumnIndex - 1);
    }

    @Override
    public int findColumn(String columnName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.findColumn(String) unsupported");
    }

    @Override
    public Reader getCharacterStream(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        return null;
    }

    @Override
    public Reader getCharacterStream(String columnName) throws SQLException {
        return null;
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        this.lastIndexRead = columnIndex;
        return (BigDecimal)this.dataTable.GetRow(this.nRowIndex).Get(columnIndex - 1);
    }

    @Override
    public BigDecimal getBigDecimal(String columnName) throws SQLException {
        int nColumnIndex = this.dataTable.GetColumnIndex(columnName);
        return (BigDecimal)this.dataTable.GetRow(this.nRowIndex).Get(nColumnIndex - 1);
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.isBeforeFirst() unsupported");
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.isAfterLast() unsupported");
    }

    @Override
    public boolean isFirst() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.isFirst() unsupported");
    }

    @Override
    public boolean isLast() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.isLast() unsupported");
    }

    @Override
    public void beforeFirst() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.beforeFirst() unsupported");
    }

    @Override
    public void afterLast() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.afterLast() unsupported");
    }

    @Override
    public boolean first() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.first() unsupported");
    }

    @Override
    public boolean last() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.last() unsupported");
    }

    @Override
    public int getRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getRow() unsupported");
    }

    @Override
    public boolean absolute(int row) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.absolute() unsupported");
    }

    @Override
    public boolean relative(int rows) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.relative() unsupported");
    }

    @Override
    public boolean previous() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.previous() unsupported");
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.setFetchDirection(int) unsupported");
    }

    @Override
    public int getFetchDirection() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getFetchDirection() unsupported");
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.setFetchSize(int) unsupported");
    }

    @Override
    public int getFetchSize() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getFetchSize() unsupported");
    }

    @Override
    public int getType() throws SQLException {
        return 1003;
    }

    @Override
    public int getConcurrency() throws SQLException {
        return 1007;
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.rowUpdated() unsupported");
    }

    @Override
    public boolean rowInserted() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.rowInserted() unsupported");
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.rowDeleted() unsupported");
    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateNull() unsupported");
    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBoolean() unsupported");
    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateByte() unsupported");
    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateShort() unsupported");
    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateInt() unsupported");
    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateLong(int, long) unsupported");
    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateFloat(int, float) unsupported");
    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateDouble(int, double) unsupported");
    }

    @Override
    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBigDecimal(int, BigDecimal) unsupported");
    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateString(int, String) unsupported");
    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBytes(int, byte[]) unsupported");
    }

    @Override
    public void updateDate(int columnIndex, Date x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateDate(int, Date) unsupported");
    }

    @Override
    public void updateTime(int columnIndex, Time x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateTime(int, Time) unsupported");
    }

    @Override
    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateTimestamp(int, Timestamp) unsupported");
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateAsciiStream (int, InputStream, int) unsupported");
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBinaryStream(int, InputStream, int) unsupported");
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateCharacterStream(int, Reader, int) unsupported");
    }

    @Override
    public void updateObject(int columnIndex, Object x, int scale) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.udpateObject(int, Object) unsupported");
    }

    @Override
    public void updateObject(int columnIndex, Object x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateObject(int, Object, int) unsupported");
    }

    @Override
    public void updateNull(String columnName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateNull(String) unsupported");
    }

    @Override
    public void updateBoolean(String columnName, boolean x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBoolean(String, boolean) unsupported");
    }

    @Override
    public void updateByte(String columnName, byte x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateByte(String, byte) unsupported");
    }

    @Override
    public void updateShort(String columnName, short x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateShort(String, short) unsupported");
    }

    @Override
    public void updateInt(String columnName, int x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateInt(String, int) unsupported");
    }

    @Override
    public void updateLong(String columnName, long x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateLong(String, long) unsupported");
    }

    @Override
    public void updateFloat(String columnName, float x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateFloat(String, float) unsupported");
    }

    @Override
    public void updateDouble(String columnName, double x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateDouble(String, double) unsupported");
    }

    @Override
    public void updateBigDecimal(String columnName, BigDecimal x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBigDecimal(String, BigDecimal) unsupported");
    }

    @Override
    public void updateString(String columnName, String x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateString(String, String) unsupported");
    }

    @Override
    public void updateBytes(String columnName, byte[] x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBytes(String, byte[]) unsupported");
    }

    @Override
    public void updateDate(String columnName, Date x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateDate(String, Date) unsupported");
    }

    @Override
    public void updateTime(String columnName, Time x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateTime(String, Time) unsupported");
    }

    @Override
    public void updateTimestamp(String columnName, Timestamp x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateTimestamp(String, Timestamp) unsupported");
    }

    @Override
    public void updateAsciiStream(String columnName, InputStream x, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateAsciiStream(String, InputStream, int) unsupported");
    }

    @Override
    public void updateBinaryStream(String columnName, InputStream x, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBinaryStream(String, InputStream, int) unsupported");
    }

    @Override
    public void updateCharacterStream(String columnName, Reader reader, int length) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateCharacterStream(String, Reader, int) unsupported");
    }

    @Override
    public void updateObject(String columnName, Object x, int scale) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateObject(String, Object, int) unsupported");
    }

    @Override
    public void updateObject(String columnName, Object x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateObject(String, Object) unsupported");
    }

    @Override
    public void insertRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.insertRow() unsupported");
    }

    @Override
    public void updateRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateRow() unsupported");
    }

    @Override
    public void deleteRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.deleteRow() unsupported");
    }

    @Override
    public void refreshRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.refreshRow() unsupported");
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.cancelRowUpdates() unsupported");
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.moveToInsertRow() unsupported");
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new UnsupportedOperationException("ResultSet.moveToeCurrentRow() unsupported");
    }

    @Override
    public Statement getStatement() throws SQLException {
        return null;
    }

    public Object getObject(int i, Map map) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getObject(int, Map) unsupported");
    }

    @Override
    public Ref getRef(int i) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getRef(int) unsupported");
    }

    @Override
    public Blob getBlob(int i) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getBlob(int) unsupported");
    }

    @Override
    public Clob getClob(int i) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getClob(int) unsupported");
    }

    @Override
    public Array getArray(int i) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getArray(int) unsupported");
    }

    public Object getObject(String colName, Map map) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getObject(String, Map) unsupported");
    }

    @Override
    public Ref getRef(String colName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getRef(String) unsupported");
    }

    @Override
    public Blob getBlob(String colName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getBlob(String) unsupported");
    }

    @Override
    public Clob getClob(String colName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getClob(String) unsupported");
    }

    @Override
    public Array getArray(String colName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getArray(String) unsupported");
    }

    @Override
    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getDate(int, Calendar) unsupported");
    }

    @Override
    public Date getDate(String columnName, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getDate(String, Calendar) unsupported");
    }

    @Override
    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getTime(int, Calendar) unsupported");
    }

    @Override
    public Time getTime(String columnName, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getTime(String, Calendar) unsupported");
    }

    @Override
    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getTimestamp(int, Calendar) unsupported");
    }

    @Override
    public Timestamp getTimestamp(String columnName, Calendar cal) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getTimestamp(String, Calendar) unsupported");
    }

    @Override
    public URL getURL(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getURL(int) unsupported");
    }

    @Override
    public URL getURL(String columnName) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.getURL(String) unsupported");
    }

    @Override
    public void updateRef(int columnIndex, Ref x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateRef(int,java.sql.Ref) unsupported");
    }

    @Override
    public void updateRef(String columnName, Ref x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateRef(String,java.sql.Ref) unsupported");
    }

    @Override
    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBlob(int,java.sql.Blob) unsupported");
    }

    @Override
    public void updateBlob(String columnName, Blob x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateBlob(String,java.sql.Blob) unsupported");
    }

    @Override
    public void updateClob(int columnIndex, Clob x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateClob(int,java.sql.Clob) unsupported");
    }

    @Override
    public void updateClob(String columnName, Clob x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateClob(String,java.sql.Clob) unsupported");
    }

    @Override
    public void updateArray(int columnIndex, Array x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateArray(int,java.sql.Array) unsupported");
    }

    @Override
    public void updateArray(String columnName, Array x) throws SQLException {
        throw new UnsupportedOperationException("ResultSet.updateArray(String,java.sql.Array) unsupported");
    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public NClob getNClob(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public NClob getNClob(String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public String getNString(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public String getNString(String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public RowId getRowId(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public RowId getRowId(String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return null;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
    }

    @Override
    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateClob(int columnIndex, Reader reader) throws SQLException {
    }

    @Override
    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateClob(String columnLabel, Reader reader) throws SQLException {
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
    }

    @Override
    public void updateNClob(int columnIndex, NClob clob) throws SQLException {
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
    }

    @Override
    public void updateNClob(String columnLabel, NClob clob) throws SQLException {
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
    }

    @Override
    public void updateNString(int columnIndex, String string) throws SQLException {
    }

    @Override
    public void updateNString(String columnLabel, String string) throws SQLException {
    }

    @Override
    public void updateRowId(int columnIndex, RowId x) throws SQLException {
    }

    @Override
    public void updateRowId(String columnLabel, RowId x) throws SQLException {
    }

    @Override
    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
    }

    @Override
    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public <T> T getObject(int arg0, Class<T> arg1) throws SQLException {
        return null;
    }

    @Override
    public <T> T getObject(String arg0, Class<T> arg1) throws SQLException {
        return null;
    }
}

