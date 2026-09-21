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

public abstract class WFUCPolicyDisablePolicyUIActionModelBase
extends DEUIActionModelBase<WFUCPolicy> {
    private static final Log log = LogFactory.getLog(WFUCPolicyDisablePolicyUIActionModelBase.class);

    public WFUCPolicyDisablePolicyUIActionModelBase() {
        this.setId("E1E4A34B-93C9-481D-9242-4556BF9ABA1E");
        this.setName("DisablePolicy");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("DisablePolicy");
        this.setReloadData(true);
    }
}

