/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataSync;

public interface IDEDataSyncOut
extends IDEDataSync {
    public String getTestDEActionName();

    public Iterator<String> getFileFields();
}

