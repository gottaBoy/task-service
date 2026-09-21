/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.counter;

import java.util.Iterator;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.control.counter.IPSSysCounterItem;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysCounter
extends IPSSystemObject,
IPSModelObject {
    public String getCounterType();

    public IPSCounterType getPSCounterType();

    public int getTimer();

    public boolean getRefFlag();

    public boolean isSubSysCounter();

    public Iterator<IPSSysCounterItem> getPSSysCounterItems();

    public IPSCounter getPSCounter();
}

