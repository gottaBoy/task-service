/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.ajax.IPSAjaxHandler
 */
package net.ibizsys.model.control.ajax;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.entity.PSACHandler;

public interface IPSAjaxHandlerRuntime
extends IPSAjaxHandler,
IPSModelObjectRuntime {
    public void init(IPSModelStorageContext var1, Object var2, PSACHandler var3) throws Exception;
}

