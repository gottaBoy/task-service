/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.dedesign.demodel.psdemainstate.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEMainStateInitDEMSViewsUIActionModelBase
extends DEUIActionModelBase<PSDEMainState> {
    private static final Log log = LogFactory.getLog(PSDEMainStateInitDEMSViewsUIActionModelBase.class);

    public PSDEMainStateInitDEMSViewsUIActionModelBase() {
        this.setId("5DB60434-EBA4-4A79-895A-73B7CBFE34DB");
        this.setName("InitDEMSViews");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitDEMSViews");
        this.setSuccessMsg("\u521d\u59cb\u5316\u4e3b\u72b6\u6001\u89c6\u56fe\u6210\u529f\uff01");
    }
}

