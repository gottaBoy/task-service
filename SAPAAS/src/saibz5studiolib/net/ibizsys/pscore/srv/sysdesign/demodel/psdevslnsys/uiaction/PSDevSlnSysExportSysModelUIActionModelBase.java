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

public abstract class PSDevSlnSysExportSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysExportSysModelUIActionModelBase.class);

    public PSDevSlnSysExportSysModelUIActionModelBase() {
        this.setId("F96565CC-63FC-4BD2-9F05-99A38291EF4E");
        this.setName("ExportSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDEXPORTSYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u5bfc\u51fa\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

