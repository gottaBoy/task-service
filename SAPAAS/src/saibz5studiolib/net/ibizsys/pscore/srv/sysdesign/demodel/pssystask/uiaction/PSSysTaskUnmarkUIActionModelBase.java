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

public abstract class PSSysTaskUnmarkUIActionModelBase
extends DEUIActionModelBase<PSSysTask> {
    private static final Log log = LogFactory.getLog(PSSysTaskUnmarkUIActionModelBase.class);

    public PSSysTaskUnmarkUIActionModelBase() {
        this.setId("B98EBAD5-25EF-4916-8368-FCC0344A7DBA");
        this.setName("Unmark");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Unmark");
        this.setReloadData(true);
    }
}

