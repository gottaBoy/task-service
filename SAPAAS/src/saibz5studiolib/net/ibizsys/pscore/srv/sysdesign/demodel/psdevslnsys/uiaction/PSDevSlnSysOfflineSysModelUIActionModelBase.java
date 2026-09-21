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

public abstract class PSDevSlnSysOfflineSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysOfflineSysModelUIActionModelBase.class);

    public PSDevSlnSysOfflineSysModelUIActionModelBase() {
        this.setId("164CD1B6-5464-4AFD-9CF2-7EC2D83B8C2C");
        this.setName("OfflineSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDOFFLINESYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u79bb\u7ebf\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

