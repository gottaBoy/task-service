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

public abstract class WXAccountSyncOrgUserUIActionModelBase
extends DEUIActionModelBase<WXAccount> {
    private static final Log log = LogFactory.getLog(WXAccountSyncOrgUserUIActionModelBase.class);

    public WXAccountSyncOrgUserUIActionModelBase() {
        this.setId("F6243B79-4890-4FA2-AFA7-2F829473CBF9");
        this.setName("SyncOrgUser");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncOrgUser");
        this.setSuccessMsg("\u540c\u6b65\u7528\u6237\u6210\u529f\uff01");
    }
}

