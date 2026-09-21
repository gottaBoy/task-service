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

public abstract class PSDCWorkspaceUnssignSlnUIActionModelBase
extends DEUIActionModelBase<PSDCWorkspace> {
    private static final Log log = LogFactory.getLog(PSDCWorkspaceUnssignSlnUIActionModelBase.class);

    public PSDCWorkspaceUnssignSlnUIActionModelBase() {
        this.setId("0455D28B-9518-4EDF-8315-C0C1A5678363");
        this.setName("UnssignSln");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("Unassign");
        this.setReloadData(true);
    }
}

