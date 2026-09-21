/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import net.ibizsys.paas.core.IDEActionCaller;
import net.ibizsys.paas.core.IDataEntityObject;

public interface IDEAction
extends IDataEntityObject {
    public static final String ACTIONTYPE_SYSDBPROC = "SYSDBPROC";
    public static final String ACTIONTYPE_USERDBPROC = "USERDBPROC";
    public static final String ACTIONTYPE_USERCUSTOM = "USERCUSTOM";
    public static final String ACTIONTYPE_DELOGIC = "DELOGIC";
    public static final String ACTIONTYPE_BUILTIN = "BUILTIN";

    public int getTimeOut();

    public String getActionType();

    public String getCallerObject();

    public IDEActionCaller getDEActionCaller() throws Exception;

    public void releaseDEActionCaller(IDEActionCaller var1);
}

