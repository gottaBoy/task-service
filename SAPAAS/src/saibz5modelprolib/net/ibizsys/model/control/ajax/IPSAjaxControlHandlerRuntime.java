/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.IPSAjaxControl
 *  net.ibizsys.model.control.ajax.IPSAjaxControlHandler
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.ajax.IPSAjaxControlHandler;
import net.ibizsys.model.entity.PSACHandler;

public interface IPSAjaxControlHandlerRuntime
extends IPSAjaxControlHandler {
    public void init(IPSModelStorageContext var1, IPSAppView var2, IPSAjaxControl var3, PSACHandler var4) throws Exception;
}

