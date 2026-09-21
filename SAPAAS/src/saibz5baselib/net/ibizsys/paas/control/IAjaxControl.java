/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control;

import net.ibizsys.paas.control.IAjaxControlHandlerParam;
import net.ibizsys.paas.control.IControl;

public interface IAjaxControl
extends IControl {
    public String getHandler();

    public IAjaxControlHandlerParam getHandlerParam();
}

