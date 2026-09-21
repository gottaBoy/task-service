/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysconsole.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysConsoleResetLogUIActionModelBase
extends DEUIActionModelBase<PSSysConsole> {
    private static final Log log = LogFactory.getLog(PSSysConsoleResetLogUIActionModelBase.class);

    public PSSysConsoleResetLogUIActionModelBase() {
        this.setId("427ECD77-62BA-44BE-B75A-DBB369FB9F69");
        this.setName("ResetLog");
        this.setActionTarget("NONE");
        this.setDEActionName("ResetLog");
        this.setReloadData(true);
    }
}

