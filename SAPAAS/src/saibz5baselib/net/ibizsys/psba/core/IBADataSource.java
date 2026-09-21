/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

public interface IBADataSource {
    public Object getConnection() throws Exception;

    public void closeConnection(Object var1) throws Exception;

    public String getNamespace();

    public int getMaxVersions();
}

