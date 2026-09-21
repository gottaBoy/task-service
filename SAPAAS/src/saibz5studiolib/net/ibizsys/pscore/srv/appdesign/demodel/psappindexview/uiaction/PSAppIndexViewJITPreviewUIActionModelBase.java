/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psappindexview.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppIndexView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSAppIndexViewJITPreviewUIActionModelBase
extends DEUIActionModelBase<PSAppIndexView> {
    private static final Log log = LogFactory.getLog(PSAppIndexViewJITPreviewUIActionModelBase.class);

    public PSAppIndexViewJITPreviewUIActionModelBase() {
        this.setId("76B93B29-C828-4984-A54A-DBE5CC9FED23");
        this.setName("JITPreview");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("JITPREVIEW");
    }
}

