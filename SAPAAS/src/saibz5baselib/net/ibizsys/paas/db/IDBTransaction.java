/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

import java.sql.Connection;
import net.ibizsys.paas.service.ITransaction;

public interface IDBTransaction
extends ITransaction {
    public Connection getConnection();
}

