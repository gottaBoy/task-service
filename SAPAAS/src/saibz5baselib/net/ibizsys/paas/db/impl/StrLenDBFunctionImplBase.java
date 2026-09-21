/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.impl.DBFunctionImplBase;

public abstract class StrLenDBFunctionImplBase
extends DBFunctionImplBase {
    @Override
    public String getName() {
        return "STRLEN";
    }

    @Override
    public int getOutputDataType() {
        return 9;
    }
}

