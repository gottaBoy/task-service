/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

public interface IDataColumn {
    public String getCatalogName();

    public String getColumnClassName();

    public int getDisplaySize();

    public int getColumnType();

    public String getName();

    public String getDBDataType();

    public int getIndex();
}

