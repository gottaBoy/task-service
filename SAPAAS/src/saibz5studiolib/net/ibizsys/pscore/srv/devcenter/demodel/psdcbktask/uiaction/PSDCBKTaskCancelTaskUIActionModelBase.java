/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcbktask.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCBKTaskCancelTaskUIActionModelBase
extends DEUIActionModelBase<PSDCBKTask> {
    private static final Log log = LogFactory.getLog(PSDCBKTaskCancelTaskUIActionModelBase.class);

    public PSDCBKTaskCancelTaskUIActionModelBase() {
        this.setId("B5F585F0-25F0-4A56-88E9-D45695A8D116");
        this.setName("CancelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_CANCELTASK");
        this.setReloadData(true);
    }
}

