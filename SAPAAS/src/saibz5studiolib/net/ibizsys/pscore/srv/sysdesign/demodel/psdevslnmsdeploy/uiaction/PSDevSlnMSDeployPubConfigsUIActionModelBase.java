/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnmsdeploy.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnMSDeploy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSlnMSDeployPubConfigsUIActionModelBase
extends DEUIActionModelBase<PSDevSlnMSDeploy> {
    private static final Log log = LogFactory.getLog(PSDevSlnMSDeployPubConfigsUIActionModelBase.class);

    public PSDevSlnMSDeployPubConfigsUIActionModelBase() {
        this.setId("8299825C-6D3B-47B3-BB49-08E6DE9AE561");
        this.setName("PubConfigs");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("PubConfigs");
        this.setSuccessMsg("\u53d1\u5e03\u914d\u7f6e\u6210\u529f\uff01");
    }
}

