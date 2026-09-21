/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysviewpanel.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysViewPanelPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSSysViewPanel> {
    private static final Log log = LogFactory.getLog(PSSysViewPanelPreviewSaveUIActionModelBase.class);

    public PSSysViewPanelPreviewSaveUIActionModelBase() {
        this.setId("1957EA3F-258E-4A44-A62C-290122E6A7F4");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

