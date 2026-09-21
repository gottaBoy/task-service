/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.logic.impl;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.logic.IGroupCondition;
import net.ibizsys.paas.logic.impl.ConditionImpl;

public abstract class GroupConditionImpl<CT extends ICondition>
extends ConditionImpl
implements IGroupCondition<CT> {
    private boolean bNotMode = false;
    private ArrayList<CT> condList = new ArrayList();

    @Override
    public boolean isNotMode() {
        return this.bNotMode;
    }

    protected void setNotMode(boolean bNotMode) {
        this.bNotMode = bNotMode;
    }

    @Override
    public Iterator<CT> getChildConditions() {
        if (this.condList == null || this.condList.size() == 0) {
            return null;
        }
        return this.condList.iterator();
    }

    protected void addCondition(CT ct) {
        this.condList.add(ct);
    }
}

