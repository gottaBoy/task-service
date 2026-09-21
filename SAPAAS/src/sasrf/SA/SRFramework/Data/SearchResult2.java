/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.DBResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class SearchResult2
extends DBResult {
    protected int nTotalRow = 0;
    protected int nItemPerPage = 10;
    protected ResultSet searchResultSet = null;
    protected int nPageNo = 0;
    protected int nDataTableIndex = 0;
    protected Connection connection = null;
    protected CallableStatement cstmt = null;

    public ResultSet getSearchData() {
        return this.searchResultSet;
    }

    public void setSearchData(ResultSet value) {
        this.searchResultSet = value;
    }

    public int getTotalRow() {
        return this.nTotalRow;
    }

    public void setTotalRow(int value) {
        this.nTotalRow = value;
    }

    public int getItemPerPage() {
        return this.nItemPerPage;
    }

    public void setItemPerPage(int value) {
        this.nItemPerPage = value;
    }

    public int getTotalPage() {
        if (this.nItemPerPage == 0) {
            return 0;
        }
        int nTemp1 = this.nTotalRow % this.nItemPerPage;
        int nTemp2 = this.nTotalRow / this.nItemPerPage;
        if (nTemp1 != 0) {
            ++nTemp2;
        }
        return nTemp2;
    }

    public int getPageNo() {
        return this.nPageNo;
    }

    public void setPageNo(int value) {
        this.nPageNo = value;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setCallableStatement(CallableStatement cstmt) {
        this.cstmt = cstmt;
    }

    public CallableStatement getCallableStatement() {
        return this.cstmt;
    }
}

