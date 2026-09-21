/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.IAjaxControl
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.paas.control.IAjaxControl;

public interface IPSAjaxControl
extends IPSControl,
IAjaxControl {
    public IPSAjaxControlParam getPSAjaxControlParam();

    public IPSAjaxControlHandler getPSAjaxControlHandler();

    public boolean isTempMode();

    public boolean isAutoLoad();

    public boolean isEnableItemPrivilege();

    public int getRecvAjaxActionMode();

    public boolean isAjaxCtrl();
}

