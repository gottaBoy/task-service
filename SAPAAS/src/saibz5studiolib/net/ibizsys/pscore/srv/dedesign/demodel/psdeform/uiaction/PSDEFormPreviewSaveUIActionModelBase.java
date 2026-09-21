/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeform.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEFormPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSDEForm> {
    private static final Log log = LogFactory.getLog(PSDEFormPreviewSaveUIActionModelBase.class);

    public PSDEFormPreviewSaveUIActionModelBase() {
        this.setId("UID_2015479233348400313567235");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

