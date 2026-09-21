/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.helpdesign.demodel.pshelpsection.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSHelpSectionInitModelUIActionModelBase
extends DEUIActionModelBase<PSHelpSection> {
    private static final Log log = LogFactory.getLog(PSHelpSectionInitModelUIActionModelBase.class);

    public PSHelpSectionInitModelUIActionModelBase() {
        this.setId("C7E9AF07-A81E-4D78-B2A6-D2C9BF2ECB24");
        this.setName("InitModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("INITMODEL");
        this.setReloadData(true);
        this.setSuccessMsg("\u521d\u59cb\u5316\u7ae0\u8282\u5185\u5bb9\u6210\u529f\uff01");
    }
}

