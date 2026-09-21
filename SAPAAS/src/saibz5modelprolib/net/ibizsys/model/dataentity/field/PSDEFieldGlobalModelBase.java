/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.field.IPSDEField
 */
package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.field.IPSDEField;

public abstract class PSDEFieldGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDEField iPSDEField = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEField iPSDEField) throws Exception {
        this.iPSDEField = iPSDEField;
        this.init(iPSModelStorageContext);
    }

    protected IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDEField()).getPSSysModelInstId();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.getPSDEField() != null) {
            return ((IPSModelObjectRuntime)this.getPSDEField()).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

