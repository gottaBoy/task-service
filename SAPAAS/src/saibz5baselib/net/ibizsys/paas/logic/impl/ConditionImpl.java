/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.logic.impl;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.logic.ICondition;

public class ConditionImpl
extends ModelBaseImpl
implements ICondition {
    private String strCondOp = null;
    private String strCondType = null;

    @Override
    public String getCondOp() {
        return this.strCondOp;
    }

    @Override
    public String getCondType() {
        return this.strCondType;
    }

    protected void setCondOp(String strCondOp) {
        this.strCondOp = strCondOp;
    }

    protected void setCondType(String strCondType) {
        this.strCondType = strCondType;
    }
}

