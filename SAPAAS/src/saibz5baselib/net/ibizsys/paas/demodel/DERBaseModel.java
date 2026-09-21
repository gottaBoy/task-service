/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.ISystem;

public abstract class DERBaseModel
implements IDERBase {
    protected ISystem iSystem = null;
    protected DER der = null;

    public void init(ISystem iSystem, DER der) {
        this.iSystem = iSystem;
        this.der = der;
    }

    @Override
    public String getId() {
        return this.der.id();
    }

    @Override
    public String getName() {
        return this.der.name();
    }

    @Override
    public String getDERType() {
        return this.der.type();
    }

    @Override
    public String getMajorDEId() {
        return this.der.majordeid();
    }

    @Override
    public String getMinorDEId() {
        return this.der.minordeid();
    }

    @Override
    public String getMajorDEName() {
        return this.der.majordename();
    }

    @Override
    public String getMinorDEName() {
        return this.der.minordename();
    }

    protected ISystem getSystem() {
        return this.iSystem;
    }
}

