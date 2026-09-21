/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.core.IDEDataRange;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;

public interface IMDCtrlHandler
extends ICtrlHandler,
IDEDataRange {
    public static final String EXPORTTYPE_EXCEL = "EXCEL";
    public static final String EXPORTTYPE_HTML = "HTML";
    public static final String SORTDIR_ASC = "ASC";
    public static final String SORTDIR_DESC = "DESC";
    public static final String ACTION_FETCH = "fetch";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_ADDBATCH = "addbatch";
    public static final String ACTION_UIACTION = "uiaction";
    public static final String ACTION_LOADUIACTION = "loaduiaction";
    public static final String ACTION_EXPORTMODEL = "exportmodel";
    public static final String ACTION_EXPORTIMPTEMPL = "exportimptempl";
    public static final String ACTION_EXPORTDATA = "exportdata";
    public static final String ACTION_ITEMTIP = "itemtip";

    public boolean isEnableItemPriv();
}

