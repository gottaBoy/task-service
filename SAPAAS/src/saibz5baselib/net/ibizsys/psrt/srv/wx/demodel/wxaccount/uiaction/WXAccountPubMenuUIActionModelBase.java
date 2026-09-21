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

public abstract class WXAccountPubMenuUIActionModelBase
extends DEUIActionModelBase<WXAccount> {
    private static final Log log = LogFactory.getLog(WXAccountPubMenuUIActionModelBase.class);

    public WXAccountPubMenuUIActionModelBase() {
        this.setId("CA66A548-31A2-427D-8E6C-BA4233209E1C");
        this.setName("PubMenu");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PubMenu");
        this.setSuccessMsg("\u53d1\u5e03\u83dc\u5355\u6210\u529f\uff01");
    }
}

