/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psba.core;

import net.ibizsys.psba.core.BAModelBase;
import net.ibizsys.psba.core.IBAScheme;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBASchemeObject;

public abstract class BASchemeObjectModelBase
extends BAModelBase
implements IBASchemeObject {
    private IBAScheme iBAScheme = null;

    protected void setBAScheme(IBAScheme iBAScheme) {
        this.iBAScheme = iBAScheme;
    }

    @Override
    public IBAScheme getBAScheme() {
        return this.iBAScheme;
    }

    public IBASchemeModel getBASchemeModel() {
        return (IBASchemeModel)this.getBAScheme();
    }
}

