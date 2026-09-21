/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;

public abstract class DEActionModelBase
extends ModelBaseImpl
implements IDEAction {
    @Override
    public IDataEntity getDataEntity() {
        return null;
    }

    @Override
    public String getActionType() {
        return null;
    }

    @Override
    public String getCallerObject() {
        return null;
    }

    @Override
    public IDEActionCaller getDEActionCaller() throws Exception {
        return null;
    }

    @Override
    public void releaseDEActionCaller(IDEActionCaller iDEActionCaller) {
    }
}

