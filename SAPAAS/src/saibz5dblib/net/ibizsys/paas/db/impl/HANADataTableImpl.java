/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataSet
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.impl.DataTableImpl
 */
package net.ibizsys.paas.db.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataSet;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.impl.DataTableImpl;
import net.ibizsys.paas.db.impl.HANADataRowImpl;

public class HANADataTableImpl
extends DataTableImpl {
    public HANADataTableImpl(IDataSet iDataSet, ResultSet resultSet) throws SQLException {
        super(iDataSet, resultSet);
    }

    protected IDataRow createDataRow() throws SQLException {
        return new HANADataRowImpl((IDataTable)this, this.getResultSet());
    }
}

