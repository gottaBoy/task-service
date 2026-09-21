/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFUCPolicyEnablePolicyUIActionModelBase
extends DEUIActionModelBase<WFUCPolicy> {
    private static final Log log = LogFactory.getLog(WFUCPolicyEnablePolicyUIActionModelBase.class);

    public WFUCPolicyEnablePolicyUIActionModelBase() {
        this.setId("F3BA7F9B-0579-4390-91D7-B91CA3133572");
        this.setName("EnablePolicy");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("EnablePolicy");
        this.setReloadData(true);
    }
}

