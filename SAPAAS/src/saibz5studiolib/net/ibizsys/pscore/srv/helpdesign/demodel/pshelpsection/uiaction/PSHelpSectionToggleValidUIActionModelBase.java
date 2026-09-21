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

public abstract class PSHelpSectionToggleValidUIActionModelBase
extends DEUIActionModelBase<PSHelpSection> {
    private static final Log log = LogFactory.getLog(PSHelpSectionToggleValidUIActionModelBase.class);

    public PSHelpSectionToggleValidUIActionModelBase() {
        this.setId("786FDABD-8708-45A5-8A8F-AAEE4066F748");
        this.setName("ToggleValid");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("ToggleValid");
        this.setReloadData(true);
    }
}

