/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdeuiaction.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEUIActionCreateDEUAGroupUIActionModelBase
extends DEUIActionModelBase<PSDEUIAction> {
    private static final Log log = LogFactory.getLog(PSDEUIActionCreateDEUAGroupUIActionModelBase.class);

    public PSDEUIActionCreateDEUAGroupUIActionModelBase() {
        this.setId("EE0756AC-5161-4760-8591-EF1766665599");
        this.setName("CreateDEUAGroup");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreateDEUAGroup");
        this.setSuccessMsg("\u5efa\u7acb\u5305\u542b\u754c\u9762\u884c\u4e3a\u7ec4\u6210\u529f\uff01");
    }
}

