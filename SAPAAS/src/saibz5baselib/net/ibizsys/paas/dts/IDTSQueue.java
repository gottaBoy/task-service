/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.dts;

import net.ibizsys.paas.core.IModelBase2;

public interface IDTSQueue
extends IModelBase2 {
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_CREATED = 10;
    public static final int STATE_PROCESSING = 20;
    public static final int STATE_FINISHED = 30;
    public static final int STATE_FAILED = 40;
    public static final int STATE_CANCELLED = 41;

    public String getDEName();

    public String getHistoryDEName();

    public String getStateField();

    public String getErrorField();

    public String getTimeField();

    public String getConfirmDEActionName();

    public String getCancelDEActionName();

    public int getCancelTimeout();

    public int getRefreshTimer();

    public String getPushDEActionName();

    public String getRefreshDEActionName();
}

