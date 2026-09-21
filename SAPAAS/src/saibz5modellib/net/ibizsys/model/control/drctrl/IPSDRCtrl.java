/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.drctrl.DRCtrlRootItem
 *  net.ibizsys.paas.control.drctrl.IDRCtrl
 */
package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.paas.control.drctrl.DRCtrlRootItem;
import net.ibizsys.paas.control.drctrl.IDRCtrl;

public interface IPSDRCtrl
extends IPSAjaxControl,
IDRCtrl {
    public boolean isIncludeMajor();

    public IPSSysCounterRef getPSSysCounterRef();

    public DRCtrlRootItem getRootItem();
}

