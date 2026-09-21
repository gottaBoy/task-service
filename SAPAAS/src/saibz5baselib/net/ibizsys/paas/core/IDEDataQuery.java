/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEDataQuery
extends IDataEntityObject {
    public void init(IDataEntity var1) throws Exception;

    public IDEDataQueryCode getDEDataQueryCode(String var1) throws Exception;

    public boolean isDefaultMode();

    public int getViewLevel();
}

