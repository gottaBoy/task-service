/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysCounterItem
extends IPSModelObject {
    public String getLogicName();

    public IPSSysCounter getPSSysCounter();
}

