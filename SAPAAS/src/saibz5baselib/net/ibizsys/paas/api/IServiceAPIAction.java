/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.api;

import net.ibizsys.paas.core.IModelBase2;

public interface IServiceAPIAction
extends IModelBase2 {
    public static final String ACTIONTYPE_DEACTION = "DEACTION";
    public static final String ACTIONTYPE_SELECT = "SELECT";
    public static final String ACTIONTYPE_FETCH = "FETCH";
    public static final String ACTIONTYPE_SELECTTEMP = "SELECTTEMP";
    public static final String ACTIONTYPE_FETCHTEMP = "FETCHTEMP";

    public String getActionType();

    public String getUniqueTag();

    public String getDEName();
}

