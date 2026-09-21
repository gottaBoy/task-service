/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEDataSync
extends IDataEntityObject {
    public static final String SYNCDIR_IN = "IN";
    public static final String SYNCDIR_OUT = "OUT";
    public static final int EVENTTYPE_CREATE = 1;
    public static final int EVENTTYPE_UPDATE = 2;
    public static final int EVENTTYPE_DELETE = 4;

    public void init(IDataEntity var1) throws Exception;

    public String getSyncAgent();

    public int getEventType();

    public boolean isInMode();

    public String getSyncTag();
}

