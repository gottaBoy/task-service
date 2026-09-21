/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IModelBase2;
import net.ibizsys.paas.core.ModelBaseImpl;

public abstract class ModelBase2Impl
extends ModelBaseImpl
implements IModelBase2 {
    private String strUserTag = null;
    private String strUserTag2 = null;

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }

    public void setUserTag2(String strUserTag2) {
        this.strUserTag2 = strUserTag2;
    }

    @Override
    public String getUserTag() {
        return this.strUserTag;
    }

    @Override
    public String getUserTag2() {
        return this.strUserTag2;
    }
}

