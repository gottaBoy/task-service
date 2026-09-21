/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pswf.core.IWFProcessModel
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.pswf.core.IWFProcessModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public interface IDynaWFProcessModel
extends IWFProcessModel {
    public IDynaWFVersionModel getDynaWFVersionModel();
}

