/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psdevslnsysbak.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSlnSysBakRestoreSysModelUIActionModelBase
extends DEUIActionModelBase<PSDevSlnSysBak> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakRestoreSysModelUIActionModelBase.class);

    public PSDevSlnSysBakRestoreSysModelUIActionModelBase() {
        this.setId("2DB15F47-6517-4460-A31E-221F03BA7719");
        this.setName("RestoreSysModel");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDRESTORESYSMODELTASK");
        this.setSuccessMsg("\u5df2\u521b\u5efa\u6062\u590d\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\uff01");
    }
}

