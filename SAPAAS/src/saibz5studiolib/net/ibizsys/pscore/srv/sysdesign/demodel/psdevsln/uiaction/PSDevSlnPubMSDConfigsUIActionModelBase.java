/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsln.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSlnPubMSDConfigsUIActionModelBase
extends DEUIActionModelBase<PSDevSln> {
    private static final Log log = LogFactory.getLog(PSDevSlnPubMSDConfigsUIActionModelBase.class);

    public PSDevSlnPubMSDConfigsUIActionModelBase() {
        this.setId("B350119F-8596-4F62-B00E-4CC6DE2A1843");
        this.setName("PubMSDConfigs");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PubMSDConfigs");
        this.setSuccessMsg("\u53d1\u5e03\u914d\u7f6e\u6210\u529f\uff01");
    }
}

