/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.db.impl;

import net.ibizsys.paas.db.impl.DBFunctionImplBase;

public abstract class DateDiffNowDBFunctionImplBase
extends DBFunctionImplBase {
    @Override
    public String getName() {
        return "DATEDIFFNOW";
    }

    @Override
    public int getOutputDataType() {
        return 9;
    }
}

