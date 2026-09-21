/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdetoolbar.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEToolbarPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSDEToolbar> {
    private static final Log log = LogFactory.getLog(PSDEToolbarPreviewSaveUIActionModelBase.class);

    public PSDEToolbarPreviewSaveUIActionModelBase() {
        this.setId("UID_20154256194568000113706807");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

