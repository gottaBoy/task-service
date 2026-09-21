/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.logic;

import java.util.Iterator;
import net.ibizsys.paas.logic.ICondition;

public interface IGroupCondition<CT extends ICondition>
extends ICondition {
    public boolean isNotMode();

    public Iterator<CT> getChildConditions();
}

