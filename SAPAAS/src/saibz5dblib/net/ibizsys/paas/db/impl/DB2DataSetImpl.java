/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataSetImpl
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DB2DataTableImpl;
import net.ibizsys.paas.db.impl.DataSetImpl;

public class DB2DataSetImpl
extends DataSetImpl {
    public DB2DataSetImpl(Connection conn, PreparedStatement cstmt) {
        super(conn, cstmt);
    }

    protected IDataTable createDataTable(ResultSet rs) throws SQLException {
        return new DB2DataTableImpl((IDataSet)this, rs);
    }
}

