/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppViewJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSAppView> {
    private static final Log log = LogFactory.getLog(PSAppViewJITPreviewUIActionModelBase.class);

    public PSAppViewJITPreviewUIActionModelBase() {
        this.setId("05D511A7-A763-460E-AB0F-6EC03EF975ED");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

