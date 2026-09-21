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

public abstract class PSPFStyleFixStyleUIActionModelBase
extends DEUIActionModelBase<PSPFStyle> {
    private static final Log log = LogFactory.getLog(PSPFStyleFixStyleUIActionModelBase.class);

    public PSPFStyleFixStyleUIActionModelBase() {
        this.setId("A1F550FC-F5C1-4FA8-B39D-523C00E62050");
        this.setName("FixStyle");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("FixStyle");
        this.setReloadData(true);
        this.setSuccessMsg("\u56fa\u5b9a\u6a21\u677f\u6210\u529f\uff01");
    }
}

