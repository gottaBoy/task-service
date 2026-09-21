/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psder.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDERCreatePickupTextFieldUIActionModelBase
extends DEUIActionModelBase<PSDER> {
    private static final Log log = LogFactory.getLog(PSDERCreatePickupTextFieldUIActionModelBase.class);

    public PSDERCreatePickupTextFieldUIActionModelBase() {
        this.setId("B4D10179-6E9F-4808-91FE-963BC6DF613F");
        this.setName("CreatePickupTextField");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("CreatePickupTextField");
        this.setSuccessMsg("\u5efa\u7acb\u5916\u952e\u503c\u6587\u672c\u5c5e\u6027\u6210\u529f\uff01");
    }
}

