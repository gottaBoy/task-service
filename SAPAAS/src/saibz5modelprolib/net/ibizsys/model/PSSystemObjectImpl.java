/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.IPSSystemObject
 *  net.ibizsys.paas.core.ISystem
 */
package net.ibizsys.model;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.IPSSystemRuntime;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.paas.core.ISystem;

public abstract class PSSystemObjectImpl
extends PSObjectImpl
implements IPSSystemObject {
    protected IPSSystem iPSSystem = null;

    @PSModelRTMeta(description="\u7cfb\u7edf")
    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected void setPSSystem(IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
    }

    public ISystem getSystem() {
        return this.getPSSystem();
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.getPSSystem()).getPSSysModelInstId();
    }

    protected IPSSystemSetting getPSSystemSetting() {
        return (IPSSystemSetting)this.getPSSystem();
    }

    protected IPSSystemRuntime getPSSystemRuntime() {
        return (IPSSystemRuntime)this.getPSSystem();
    }
}

