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

public abstract class PSDevSlnSysOnlineSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysOnlineSysModelUIActionModelBase.class);

    public PSDevSlnSysOnlineSysModelUIActionModelBase() {
        this.setId("AFD56D55-416D-4025-888F-52D9CDB200F8");
        this.setName("OnlineSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDONLINESYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u8fde\u7ebf\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

