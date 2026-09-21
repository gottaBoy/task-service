/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSlnSysOfflineSysUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysOfflineSysUIActionModelBase.class);

    public PSDevSlnSysOfflineSysUIActionModelBase() {
        this.setId("11E42E3E-C6E2-426C-9EF2-5845354146A7");
        this.setName("OfflineSys");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("Offline");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u7cfb\u7edf\u79bb\u7ebf\u540e\u53f0\u4efb\u52a1");
    }
}

