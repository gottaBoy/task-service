/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataColumn
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Utility.StringHelper;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SRFExResultSetMetaData
implements ResultSetMetaData {
    protected DataTable dataTable = null;

    public SRFExResultSetMetaData(DataTable dt) {
        this.dataTable = dt;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return "";
        }
        return dataColumn.getCatalogName();
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return "";
        }
        return dataColumn.getColumnClassName();
    }

    @Override
    public int getColumnCount() throws SQLException {
        return this.dataTable.GetColumnCount();
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return 20;
        }
        return dataColumn.getDisplaySize();
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return "";
        }
        return dataColumn.getName();
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return "";
        }
        return dataColumn.getName();
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return 0;
        }
        return dataColumn.getColumnType();
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        DataColumn dataColumn = this.dataTable.GetDataColumn(column - 1);
        if (dataColumn == null) {
            System.err.print(StringHelper.Format((String)" invalid DataColumn[$1%s]", (Object)column));
            return "";
        }
        return dataColumn.getDBDataType();
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return "";
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return "TABLE";
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return 0;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }
}

