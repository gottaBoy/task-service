/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspace.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCWorkspaceUninstallSysUIActionModelBase
extends DEUIActionModelBase<PSDCWorkspace> {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceUninstallSysUIActionModelBase.class);

    public PSDCWorkspaceUninstallSysUIActionModelBase() {
        this.setId("5D4C9139-4ED5-458A-97C4-229226E7A4A8");
        this.setName("UninstallSys");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("UninstallSys");
        this.setReloadData(true);
    }
}

