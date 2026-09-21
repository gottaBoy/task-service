/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.psba.core.IBAModelBase;

public abstract class BAModelBase
extends ModelBaseImpl
implements IBAModelBase {
    @Override
    public void setId(String strId) {
        this.strId = strId;
    }

    @Override
    public void setName(String strName) {
        this.strName = strName;
    }
}

