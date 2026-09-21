/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core.valuerule;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;

public interface IDEFValueRule
extends IModelBase {
    public IDataEntity getDataEntity();

    public IDEField getDEField();
}

