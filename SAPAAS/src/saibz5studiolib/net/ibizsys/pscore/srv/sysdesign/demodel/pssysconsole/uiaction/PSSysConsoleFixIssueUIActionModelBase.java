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

public abstract class PSSysConsoleFixIssueUIActionModelBase
extends DEUIActionModelBase<PSSysConsole> {
    private static final Log log = LogFactory.getLog(PSSysConsoleFixIssueUIActionModelBase.class);

    public PSSysConsoleFixIssueUIActionModelBase() {
        this.setId("F609F9A4-4B2B-4E33-B90D-DA9DA81D680B");
        this.setName("FixIssue");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("FIXISSUE");
        this.setReloadData(true);
    }
}

