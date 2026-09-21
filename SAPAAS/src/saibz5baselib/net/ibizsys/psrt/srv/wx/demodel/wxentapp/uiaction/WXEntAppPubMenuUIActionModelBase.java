/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wx.demodel.wxentapp.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WXEntAppPubMenuUIActionModelBase
extends DEUIActionModelBase<WXEntApp> {
    private static final Log log = LogFactory.getLog(WXEntAppPubMenuUIActionModelBase.class);

    public WXEntAppPubMenuUIActionModelBase() {
        this.setId("EA4930E9-876E-46F5-A36E-AEAB00FB08F1");
        this.setName("PubMenu");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PubMenu");
        this.setSuccessMsg("\u53d1\u5e03\u83dc\u5355\u6210\u529f\uff01");
    }
}

