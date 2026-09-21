/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.IBADataSource;
import net.ibizsys.psba.core.IBADialect;

public interface IBASchemeRuntime {
    public IBADataSource getBADataSource();

    public IBADialect getBADialect();

    public void install() throws Exception;

    public String getNamespace();

    public int getMaxVersions();
}

