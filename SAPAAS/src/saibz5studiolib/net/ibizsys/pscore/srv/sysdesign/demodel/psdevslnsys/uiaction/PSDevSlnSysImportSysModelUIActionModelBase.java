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

public abstract class PSDevSlnSysImportSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysImportSysModelUIActionModelBase.class);

    public PSDevSlnSysImportSysModelUIActionModelBase() {
        this.setId("96A2EAF4-5776-4585-BC52-BFB5D394F8BF");
        this.setName("ImportSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDIMPORTSYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u5bfc\u5165\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

