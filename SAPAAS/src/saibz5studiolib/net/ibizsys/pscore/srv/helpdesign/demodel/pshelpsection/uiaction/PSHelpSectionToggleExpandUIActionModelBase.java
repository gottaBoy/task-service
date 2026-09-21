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

public abstract class PSHelpSectionToggleExpandUIActionModelBase
extends DEUIActionModelBase<PSHelpSection> {
    private static final Log log = LogFactory.getLog(PSHelpSectionToggleExpandUIActionModelBase.class);

    public PSHelpSectionToggleExpandUIActionModelBase() {
        this.setId("B11B2A9D-C60F-43D0-AF1C-3D7820E2C61C");
        this.setName("ToggleExpand");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("ToggleExpand");
        this.setReloadData(true);
    }
}

