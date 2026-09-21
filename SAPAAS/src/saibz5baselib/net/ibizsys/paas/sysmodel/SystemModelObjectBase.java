/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemModelObject;

public abstract class SystemModelObjectBase
extends ModelBase3Impl
implements ISystemModelObject {
    private ISystemModel iSystemModel = null;

    protected void setSystemModel(ISystemModel iSystemModel) {
        this.iSystemModel = iSystemModel;
    }

    @Override
    public ISystem getSystem() {
        return this.iSystemModel;
    }

    @Override
    public ISystemModel getSystemModel() {
        return this.iSystemModel;
    }
}

