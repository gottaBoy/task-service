/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdashboard.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysDashboardPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSSysDashboard> {
    private static final Log log = LogFactory.getLog(PSSysDashboardPreviewSaveUIActionModelBase.class);

    public PSSysDashboardPreviewSaveUIActionModelBase() {
        this.setId("A96A513D-3518-440D-BB49-DEEC4EAE0337");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

