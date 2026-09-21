/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;

public interface ISystem
extends IModelBase {
    public IDataEntity getDataEntity(String var1) throws Exception;

    public IDERBase getDER(String var1) throws Exception;

    public ICodeList getCodeList(String var1) throws Exception;
}

