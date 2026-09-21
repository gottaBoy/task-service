/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ICtrlHandler;

public interface ISearchFormHandler
extends ICtrlHandler {
    public static final String ITEMACTIONTYPE_FORMITEM = "FI:";
    public static final String ITEMACTIONTYPE_FORMITEMUPDATE = "FIU:";
    public static final String ACTION_UPDATEFORMITEM = "updateformitem";
    public static final String ACTION_SEARCH = "search";
    public static final String ACTION_ITEMFETCH = "itemfetch";
    public static final String ACTION_LOADDRAFT = "loaddraft";
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_FETCH = "fetch";
}

