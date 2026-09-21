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

public abstract class PSAppPortalViewPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSAppPortalView> {
    private static final Log log = LogFactory.getLog(PSAppPortalViewPreviewSaveUIActionModelBase.class);

    public PSAppPortalViewPreviewSaveUIActionModelBase() {
        this.setId("F9FC6604-0E96-4B9B-8AFC-D8D329A79D5A");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

