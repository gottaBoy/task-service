/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.IMDCtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;

public interface IGridHandler
extends IMDCtrlHandler,
ISDCtrlHandler {
    public static final String ITEMACTIONTYPE_GRIDEDITITEM = "GEI:";
    public static final String ITEMACTIONTYPE_GRIDEDITITEMUPDATE = "GEIU:";
    public static final String ACTION_ITEMFETCH = "itemfetch";
    public static final String ACTION_LOADDRAFT = "loaddraft";
    public static final String ACTION_LOADDRAFTFROM = "loaddraftfrom";
    public static final String ACTION_LOADDRAFTPASTE = "loaddraftpaste";
    public static final String ACTION_UPDATEGRIDEDITITEM = "updategridedititem";
}

