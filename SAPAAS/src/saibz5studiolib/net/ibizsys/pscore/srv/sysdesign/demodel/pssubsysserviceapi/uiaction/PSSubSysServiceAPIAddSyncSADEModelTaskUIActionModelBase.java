/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssubsysserviceapi.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSubSysServiceAPIAddSyncSADEModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSubSysServiceAPI> {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIAddSyncSADEModelTaskUIActionModelBase.class);

    public PSSubSysServiceAPIAddSyncSADEModelTaskUIActionModelBase() {
        this.setId("C9B05044-31F2-4D54-A43C-5A1BBFF0DAA6");
        this.setName("AddSyncSADEModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDSYNCSADEMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u540c\u6b65\u63a5\u53e3\u6a21\u578b\u4efb\u52a1");
    }
}

