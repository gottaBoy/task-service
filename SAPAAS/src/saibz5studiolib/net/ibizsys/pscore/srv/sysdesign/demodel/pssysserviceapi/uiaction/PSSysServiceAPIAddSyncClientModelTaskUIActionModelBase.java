/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysserviceapi.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysServiceAPIAddSyncClientModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSysServiceAPIAddSyncClientModelTaskUIActionModelBase.class);

    public PSSysServiceAPIAddSyncClientModelTaskUIActionModelBase() {
        this.setId("0E172808-2E26-4AB4-9D71-79F1E8A99B54");
        this.setName("AddSyncClientModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDSYNCCLIENTMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u540c\u6b65\u5ba2\u6237\u7aef\u6a21\u578b\u4efb\u52a1");
    }
}

