/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappmenu.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppMenuPreviewSaveUIActionModelBase
extends DEUIActionModelBase<PSAppMenu> {
    private static final Log log = LogFactory.getLog(PSAppMenuPreviewSaveUIActionModelBase.class);

    public PSAppMenuPreviewSaveUIActionModelBase() {
        this.setId("7C139568-1168-439D-A79E-D9AA7C7A9E78");
        this.setName("PreviewSave");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PreviewSave");
    }
}

