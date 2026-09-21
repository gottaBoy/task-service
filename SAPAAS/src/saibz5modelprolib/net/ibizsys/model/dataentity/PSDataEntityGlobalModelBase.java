/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 */
package net.ibizsys.model.dataentity;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.dataentity.IPSDataEntity;

public abstract class PSDataEntityGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDataEntity iPSDataEntity = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity) throws Exception {
        this.iPSDataEntity = iPSDataEntity;
        super.init(iPSModelStorageContext);
    }

    protected IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSDataEntity()).getPSSysModelInstId();
    }

    @Override
    public String getPSDynaInstId() {
        if (this.getPSDataEntity() != null) {
            return ((IPSModelObjectRuntime)this.getPSDataEntity()).getPSDynaInstId();
        }
        return super.getPSDynaInstId();
    }
}

