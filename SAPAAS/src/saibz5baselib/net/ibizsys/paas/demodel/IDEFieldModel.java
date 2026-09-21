/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.demodel.IDataEntityModel;

public interface IDEFieldModel
extends IDEField,
IModelBase3 {
    public IDEFieldModel getLinkDEField() throws Exception;

    public IDEFieldModel getRealDEField() throws Exception;

    public IDataEntityModel getDEModel();

    public void registerDEFDTColumn(IDEFDTColumn var1);
}

