/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 */
package net.ibizsys.model;

import net.ibizsys.model.core.IPSModelObject;

public interface IPSSysEngineConfig
extends IPSModelObject {
    public static final int IMPDEFRULE_1 = 1;
    public static final int VIEWUAREGMODE_ALWAYS = 0;
    public static final int VIEWUAREGMODE_VALID = 1;
    public static final int VIEWCTRLAJAXRECVRANGE_ALL = 0;
    public static final int VIEWCTRLAJAXRECVRANGE_VIEWUAONLY = 1;

    public int getImpDEFRule();

    public int getViewUARegMode();

    public int getViewCtrlAjaxRecvRange();

    public boolean isViewCtrlHandlerFirst();
}

