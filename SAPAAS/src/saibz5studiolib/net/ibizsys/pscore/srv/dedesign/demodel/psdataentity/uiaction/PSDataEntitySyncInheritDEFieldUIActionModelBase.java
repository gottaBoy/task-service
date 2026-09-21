/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdataentity.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDataEntitySyncInheritDEFieldUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntitySyncInheritDEFieldUIActionModelBase.class);

    public PSDataEntitySyncInheritDEFieldUIActionModelBase() {
        this.setId("A7F056B1-0F7D-4547-8CBD-236C461A9EBF");
        this.setName("SyncInheritDEField");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncInheritDEField");
        this.setSuccessMsg("\u540c\u6b65\u7ee7\u627f\u5c5e\u6027\u5b8c\u6210\uff01");
    }
}

