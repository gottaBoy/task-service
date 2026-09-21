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

public abstract class PSSystemDBCfgAddPubSysDBModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSystemDBCfg> {
    private static final Log log = LogFactory.getLog(PSSystemDBCfgAddPubSysDBModelTaskUIActionModelBase.class);

    public PSSystemDBCfgAddPubSysDBModelTaskUIActionModelBase() {
        this.setId("813EE708-0D42-4CEB-98BD-1C79AFC1A7B6");
        this.setName("AddPubSysDBModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDPUBSYSDBMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u91cd\u65b0\u53d1\u5e03\u6570\u636e\u5e93\u7ed3\u6784\u4efb\u52a1");
    }
}

