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

public abstract class PSDEFormJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSDEForm> {
    private static final Log log = LogFactory.getLog(PSDEFormJITPreviewUIActionModelBase.class);

    public PSDEFormJITPreviewUIActionModelBase() {
        this.setId("A7D48106-7F2F-4754-BC1E-7286BBDB69E6");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

