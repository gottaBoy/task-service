/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.sswf.core.ISaaSWFVersionModel
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.sswf.core.ISaaSWFVersionModel;

public interface IDynaWFVersionModel
extends ISaaSWFVersionModel {
    public IDynaWFModel getDynaWFModel();

    public IPSWFVersion getPSWFVersion();
}

