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

public abstract class PSSysDevBKTaskRemoveExecutedUIActionModelBase
extends DEUIActionModelBase<PSSysDevBKTask> {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskRemoveExecutedUIActionModelBase.class);

    public PSSysDevBKTaskRemoveExecutedUIActionModelBase() {
        this.setId("CC455055-79FB-4538-85CA-D035DCDBA229");
        this.setName("RemoveExecuted");
        this.setActionTarget("NONE");
        this.setDEActionName("RemoveExecuted");
        this.setReloadData(true);
    }
}

