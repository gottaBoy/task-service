/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IAjaxControlHandlerParam
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.paas.control.IAjaxControlHandlerParam;

public interface IPSAjaxControlParam
extends IPSControlParam,
IAjaxControlHandlerParam {
    public Boolean isEnableItemPrivilege();

    public Integer getRecvAjaxActionMode();

    public String getPSAjaxControlHandlerId();

    public boolean isAutoLoad();
}

