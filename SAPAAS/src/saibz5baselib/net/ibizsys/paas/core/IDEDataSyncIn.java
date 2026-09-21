/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataSync;

public interface IDEDataSyncIn
extends IDEDataSync {
    public Iterator<String> getDENames();

    public String getTestDEActionName();

    public String getImportDEActionName();
}

