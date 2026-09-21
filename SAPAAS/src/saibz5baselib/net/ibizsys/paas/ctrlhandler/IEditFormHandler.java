/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;

public interface IEditFormHandler
extends ISDCtrlHandler {
    public static final String ITEMACTIONTYPE_FORMITEM = "FI:";
    public static final String ITEMACTIONTYPE_FORMITEMUPDATE = "FIU:";
    public static final String ACTION_ITEMFETCH = "itemfetch";
    public static final String ACTION_LOADDRAFT = "loaddraft";
    public static final String ACTION_LOADDRAFTFROM = "loaddraftfrom";
    public static final String ACTION_UPDATEFORMITEM = "updateformitem";
    public static final String ACTION_LOADDRAFTANDCREATE = "loaddraftandcreate";
    public static final String ACTION_LOADDRAFTFROMANDCREATE = "loaddraftfromandcreate";
    public static final String ACTION_ITEMTIP = "itemtip";
}

