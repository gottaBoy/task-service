/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDERBase;

public interface IDER1N
extends IDERBase {
    public static final int MASTERRS_NONE = 0;
    public static final int MASTERRS_ATTACHED = 1;
    public static final int MASTERRS_ATTACHED_NN = 2;
    public static final int MASTERRS_ATTACHED_ACC = 4;
    public static final int MASTERRS_ATTACHED_NESTED = 8;
    public static final int MASTERRS_RECURSIVE = 16;

    public String getPickupDEFName();

    public int getMasterRS();
}

