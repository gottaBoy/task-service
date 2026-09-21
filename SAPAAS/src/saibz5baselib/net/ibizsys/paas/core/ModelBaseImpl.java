/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase;

public abstract class ModelBaseImpl
implements IModelBase {
    protected String strId = null;
    protected String strName = null;

    protected void onInit() throws Exception {
    }

    @Override
    public String getId() {
        return this.strId;
    }

    @Override
    public String getName() {
        return this.strName;
    }
}

