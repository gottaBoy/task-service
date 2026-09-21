/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.config.demodel.pspfstyle.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.config.entity.PSPFStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSPFStylePublishStyleUIActionModelBase
extends DEUIActionModelBase<PSPFStyle> {
    private static final Log log = LogFactory.getLog(PSPFStylePublishStyleUIActionModelBase.class);

    public PSPFStylePublishStyleUIActionModelBase() {
        this.setId("8F19C4FA-2DC3-41BE-92C5-3FDE8CA2B3C7");
        this.setName("PublishStyle");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PUBLISH");
        this.setReloadData(true);
        this.setSuccessMsg("\u53d1\u5e03\u6a21\u677f\u6210\u529f\uff01");
    }
}

