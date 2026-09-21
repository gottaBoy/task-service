/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystemdbcfg.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSystemDBCfgAddSyncSubSysDBModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSystemDBCfg> {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgAddSyncSubSysDBModelTaskUIActionModelBase.class);

    public PSSystemDBCfgAddSyncSubSysDBModelTaskUIActionModelBase() {
        this.setId("259AA90D-9F5A-4324-8DC4-632975197145");
        this.setName("AddSyncSubSysDBModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDSYNCSUBSYSDBMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540c\u6b65\u5b50\u7cfb\u7edf\u6570\u636e\u5e93\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

