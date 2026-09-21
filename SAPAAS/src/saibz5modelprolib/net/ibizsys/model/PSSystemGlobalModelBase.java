/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSGlobalModelBase;

public abstract class PSSystemGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSystem iPSSystem = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem) throws Exception {
        this.iPSSystem = iPSSystem;
        this.init(iPSModelStorageContext);
    }

    protected IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSSystem()).getPSSysModelInstId();
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)this.getPSSystem();
    }

    @Override
    public String getPSDynaInstId() {
        return ((IPSModelObjectRuntime)this.getPSSystem()).getPSDynaInstId();
    }

    @Override
    public int getDynaModelType() {
        return ((IPSModelObjectRuntime)this.getPSSystem()).getDynaModelType();
    }
}

