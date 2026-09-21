/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdtable.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.bdscheme.entity.PSSysBDTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysBDTableSyncDEFieldsUIActionModelBase
extends DEUIActionModelBase<PSSysBDTable> {
    private static final Log log = LogFactory.getLog(PSSysBDTableSyncDEFieldsUIActionModelBase.class);

    public PSSysBDTableSyncDEFieldsUIActionModelBase() {
        this.setId("C1278E42-188C-4FBC-A1D8-DDE17FC77ECE");
        this.setName("SyncDEFields");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncDEFields");
        this.setSuccessMsg("\u540c\u6b65\u5c5e\u6027\u6210\u529f\uff01");
    }
}

