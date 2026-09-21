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

public abstract class PSDataEntityAutoSyncDEFieldsUIActionModelBase
extends DEUIActionModelBase<PSDataEntity> {
    private static final Log log = LogFactory.getLog(PSDataEntityAutoSyncDEFieldsUIActionModelBase.class);

    public PSDataEntityAutoSyncDEFieldsUIActionModelBase() {
        this.setId("012FFF66-3895-402D-918C-88989DEFEF28");
        this.setName("AutoSyncDEFields");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("AutoSyncDEFields");
        this.setSuccessMsg("\u81ea\u52a8\u540c\u6b65\u5c5e\u6027\u5b8c\u6210\uff01");
    }
}

