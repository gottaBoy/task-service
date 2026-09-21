/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewbase.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEViewBaseJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSDEViewBase> {
    private static final Log log = LogFactory.getLog(PSDEViewBaseJITPreviewUIActionModelBase.class);

    public PSDEViewBaseJITPreviewUIActionModelBase() {
        this.setId("C6CDA603-1670-4D31-A560-D80F64CC175C");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

