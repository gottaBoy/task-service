/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdegrid.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEGridPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSDEGrid> {
    private static final Log log = LogFactory.getLog(PSDEGridPreviewSaveUIActionModelBase.class);

    public PSDEGridPreviewSaveUIActionModelBase() {
        this.setId("UID_201542212133031000313684393");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

