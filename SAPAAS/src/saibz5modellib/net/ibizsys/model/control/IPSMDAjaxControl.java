/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control;

import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;

public interface IPSMDAjaxControl
extends IPSAjaxControl {
    public IPSMDAjaxControlHandler getPSMDAjaxControlHandler();

    public boolean hasWFDataItems();
}

