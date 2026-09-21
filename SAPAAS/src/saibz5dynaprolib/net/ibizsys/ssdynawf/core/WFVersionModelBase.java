/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.wf.IPSWFVersion
 *  net.ibizsys.sswf.core.WFVersionModelBase
 */
package net.ibizsys.ssdynawf.core;

import net.ibizsys.model.wf.IPSWFVersion;
import net.ibizsys.ssdynawf.core.IDynaWFModel;
import net.ibizsys.ssdynawf.core.IDynaWFVersionModel;

public abstract class WFVersionModelBase
extends net.ibizsys.sswf.core.WFVersionModelBase
implements IDynaWFVersionModel {
    private IPSWFVersion iPSWFVersion = null;

    @Override
    public IDynaWFModel getDynaWFModel() {
        return (IDynaWFModel)this.getWFModel();
    }

    @Override
    public IPSWFVersion getPSWFVersion() {
        return this.iPSWFVersion;
    }

    protected void setPSWFVersion(IPSWFVersion iPSWFVersion) {
        this.iPSWFVersion = iPSWFVersion;
    }
}

