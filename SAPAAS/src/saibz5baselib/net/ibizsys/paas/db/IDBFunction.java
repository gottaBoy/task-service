/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db;

public interface IDBFunction {
    public String getName();

    public String getFuncSQL(boolean var1, String[] var2) throws Exception;

    public int getOutputDataType();
}

