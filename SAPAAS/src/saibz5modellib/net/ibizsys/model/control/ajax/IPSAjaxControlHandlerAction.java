/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.control.ajax.IPSAjaxHandlerAction;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;

public interface IPSAjaxControlHandlerAction
extends IPSAjaxHandlerAction {
    public static final String ACTIONTYPE_DEACTION = "DEACTION";
    public static final String ACTIONTYPE_DEDATASET = "DEDATASET";

    @Override
    public String getActionType();

    public IPSDEOPPriv getPSDEOPPriv();

    public IPSDEAction getPSDEAction();

    public String getDEActionName();

    public IPSDataEntity getPSDataEntity();

    public String getDataAccessAction();
}

