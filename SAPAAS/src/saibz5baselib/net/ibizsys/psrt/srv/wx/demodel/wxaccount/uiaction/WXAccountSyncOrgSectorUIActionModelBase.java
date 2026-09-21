/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccount.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXAccountSyncOrgSectorUIActionModelBase
extends DEUIActionModelBase<WXAccount> {
    private static final Log log = LogFactory.getLog(WXAccountSyncOrgSectorUIActionModelBase.class);

    public WXAccountSyncOrgSectorUIActionModelBase() {
        this.setId("FF25F1FA-ADF3-498B-A276-5B17CC0873D0");
        this.setName("SyncOrgSector");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncOrgSector");
        this.setSuccessMsg("\u540c\u6b65\u90e8\u95e8\u6210\u529f\uff01");
    }
}

