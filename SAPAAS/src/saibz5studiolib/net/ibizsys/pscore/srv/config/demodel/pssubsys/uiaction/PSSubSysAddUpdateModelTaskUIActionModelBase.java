/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.config.demodel.pssubsys.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSubSysAddUpdateModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSubSys> {
    private static final Log log = LogFactory.getLog(PSSubSysAddUpdateModelTaskUIActionModelBase.class);

    public PSSubSysAddUpdateModelTaskUIActionModelBase() {
        this.setId("4CF396EC-FE86-4AF0-AEF6-8F85987049D8");
        this.setName("AddUpdateModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDUPDATEMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u5b50\u7cfb\u7edf\u66f4\u65b0\u6a21\u578b\u4efb\u52a1\uff01");
    }
}

