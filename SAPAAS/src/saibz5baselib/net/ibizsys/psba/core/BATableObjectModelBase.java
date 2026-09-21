/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.BAModelBase;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.core.IBATableObject;

public abstract class BATableObjectModelBase
extends BAModelBase
implements IBATableObject {
    private IBATable iBATable = null;

    protected void setBATable(IBATable iBATable) {
        this.iBATable = iBATable;
    }

    @Override
    public IBATable getBATable() {
        return this.iBATable;
    }
}

