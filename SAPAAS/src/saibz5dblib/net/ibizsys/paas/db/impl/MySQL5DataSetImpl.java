/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.db.impl.DataSetImpl
 */
package net.ibizsys.paas.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import net.ibizsys.paas.db.impl.DataSetImpl;

public class MySQL5DataSetImpl
extends DataSetImpl {
    public MySQL5DataSetImpl(Connection conn, PreparedStatement cstmt) {
        super(conn, cstmt);
    }
}

