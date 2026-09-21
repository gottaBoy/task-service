/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.demodel.pssysdevbktask.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysDevBKTaskCancelTaskUIActionModelBase
extends DEUIActionModelBase<PSSysDevBKTask> {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskCancelTaskUIActionModelBase.class);

    public PSSysDevBKTaskCancelTaskUIActionModelBase() {
        this.setId("E8B43AF7-49FD-4086-BFAE-D8BEDDEDD80E");
        this.setName("CancelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_CANCELTASK");
        this.setReloadData(true);
    }
}

