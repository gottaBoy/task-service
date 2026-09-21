/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmsplatform.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMSPlatform;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDCMSPlatformPubConfigsUIActionModelBase
extends DEUIActionModelBase<PSDCMSPlatform> {
    private static final Log log = LogFactory.getLog(PSDCMSPlatformPubConfigsUIActionModelBase.class);

    public PSDCMSPlatformPubConfigsUIActionModelBase() {
        this.setId("EBC5DF17-ACD5-4A5D-8525-CEF1E2C7D504");
        this.setName("PubConfigs");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PubConfigs");
        this.setSuccessMsg("\u53d1\u5e03\u914d\u7f6e\u6210\u529f\uff01");
    }
}

