/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;

public interface IGanttHandler
extends IMDCtrlHandler,
ISDCtrlHandler {
    public static final String ACTION_LOADDRAFT = "loaddraft";
    public static final String ACTION_LOADDRAFTFROM = "loaddraftfrom";
    public static final String ACTION_LOADDRAFTPASTE = "loaddraftpaste";
}

