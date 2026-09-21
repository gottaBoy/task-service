/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.app.IPSApplication
 *  net.ibizsys.model.app.IPSApplicationObject
 *  net.ibizsys.paas.core.ISystem
 */
package net.ibizsys.model.app;

import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.paas.core.ISystem;

public abstract class PSApplicationObjectImpl
extends PSObjectImpl
implements IPSApplicationObject {
    private IPSApplication iPSApplication = null;

    protected void setPSApplication(IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
    }

    public IPSSystem getPSSystem() {
        return this.getPSApplication().getPSSystem();
    }

    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)this.getPSSystem();
    }

    protected IPSApplicationRuntime getPSApplicationRuntime() {
        return (IPSApplicationRuntime)this.getPSApplication();
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplicationRuntime().getPSSysModelInstId();
    }
}

