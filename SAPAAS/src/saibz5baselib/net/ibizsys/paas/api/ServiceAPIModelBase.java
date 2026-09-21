/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.api.IServiceAPIModel;
import net.ibizsys.paas.core.ModelBase3Impl;

public abstract class ServiceAPIModelBase
extends ModelBase3Impl
implements IServiceAPIModel {
    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }
}

