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

public abstract class PSDevSlnSysBackupSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysBackupSysModelUIActionModelBase.class);

    public PSDevSlnSysBackupSysModelUIActionModelBase() {
        this.setId("3F0A26E3-6E88-4807-AA28-AED431EA0D76");
        this.setName("BackupSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDBACKUPSYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u5907\u4efd\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

