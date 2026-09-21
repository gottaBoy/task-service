/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.IPSApplication
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationRuntime;

public abstract class PSApplicationGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSApplication iPSApplication = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSApplication iPSApplication) throws Exception {
        this.iPSApplication = iPSApplication;
        super.init(iPSModelStorageContext);
    }

    protected IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSApplication()).getPSSysModelInstId();
    }

    protected IPSApplicationRuntime getPSApplicationRuntime() {
        return (IPSApplicationRuntime)this.getPSApplication();
    }

    @Override
    public String getPSDynaInstId() {
        return ((IPSModelObjectRuntime)this.getPSApplication()).getPSDynaInstId();
    }

    @Override
    public int getDynaModelType() {
        return ((IPSModelObjectRuntime)this.getPSApplication()).getDynaModelType();
    }
}

