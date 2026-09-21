/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappportalview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPortalView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppPortalViewJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSAppPortalView> {
    private static final Log log = LogFactory.getLog(PSAppPortalViewJITPreviewUIActionModelBase.class);

    public PSAppPortalViewJITPreviewUIActionModelBase() {
        this.setId("B5741925-7C59-4258-A4C0-FB894503136F");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

