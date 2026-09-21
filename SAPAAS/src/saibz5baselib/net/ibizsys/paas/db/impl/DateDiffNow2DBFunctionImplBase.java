/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.impl.DBFunctionImplBase;

public abstract class DateDiffNow2DBFunctionImplBase
extends DBFunctionImplBase {
    @Override
    public String getName() {
        return "DATEDIFFNOW2";
    }

    @Override
    public int getOutputDataType() {
        return 9;
    }
}

