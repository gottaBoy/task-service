/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapppanelview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppPanelView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppPanelViewPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSAppPanelView> {
    private static final Log log = LogFactory.getLog(PSAppPanelViewPreviewSaveUIActionModelBase.class);

    public PSAppPanelViewPreviewSaveUIActionModelBase() {
        this.setId("FEB64BA9-A86A-419F-9FE1-C1B6A5743A1C");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

