/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.counter;

import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSCounter
extends IPSModelObject {
    public String getCounterType();

    public IPSCounterType getPSCounterType();

    public String getBaseClass(String var1) throws Exception;

    public String getCodeName();
}

