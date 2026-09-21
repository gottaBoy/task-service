/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystask.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysTaskMarkUIActionModelBase
extends DEUIActionModelBase<PSSysTask> {
    private static final Log log = LogFactory.getLog(PSSysTaskMarkUIActionModelBase.class);

    public PSSysTaskMarkUIActionModelBase() {
        this.setId("4000C591-C71D-4CA0-B336-6480EB52CCFF");
        this.setName("Mark");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Mark");
        this.setReloadData(true);
    }
}

