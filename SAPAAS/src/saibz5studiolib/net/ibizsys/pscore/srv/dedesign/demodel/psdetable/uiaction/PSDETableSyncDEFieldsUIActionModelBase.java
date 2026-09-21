/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetable.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDETableSyncDEFieldsUIActionModelBase
extends DEUIActionModelBase<PSDETable> {
    private static final Log log = LogFactory.getLog(PSDETableSyncDEFieldsUIActionModelBase.class);

    public PSDETableSyncDEFieldsUIActionModelBase() {
        this.setId("71E1A8CA-CFAB-4AD3-BB35-A2DC00AE3F25");
        this.setName("SyncDEFields");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncDEFields");
        this.setSuccessMsg("\u540c\u6b65\u5b9e\u4f53\u5c5e\u6027\u6210\u529f\uff01");
    }
}

