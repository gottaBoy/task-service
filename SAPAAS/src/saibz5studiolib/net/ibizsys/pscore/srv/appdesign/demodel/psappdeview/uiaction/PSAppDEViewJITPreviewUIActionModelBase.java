/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappdeview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppDEViewJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSAppDEView> {
    private static final Log log = LogFactory.getLog(PSAppDEViewJITPreviewUIActionModelBase.class);

    public PSAppDEViewJITPreviewUIActionModelBase() {
        this.setId("F1596210-6BFF-48A4-845E-800B233DB13B");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

