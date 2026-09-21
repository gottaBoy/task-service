/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataRowImpl
 */
package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataRowImpl;

public class PostgreSQLDataRowImpl
extends DataRowImpl {
    public PostgreSQLDataRowImpl(IDataTable dt, ResultSet rs) throws SQLException {
        super(dt, rs);
    }

    protected Object getRealObject(Object obj) throws Exception {
        return super.getRealObject(obj);
    }
}

