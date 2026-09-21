/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.saas.web.ISaaSWebContext
 */
package net.ibizsys.ssdyna.web;

import net.ibizsys.saas.web.ISaaSWebContext;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

public interface IDynaWebContext
extends ISaaSWebContext {
    public IDynaSysModel getDynaSysModel(boolean var1) throws Exception;
}

