/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevsysdiffrep.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSysDiffRep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDevSysDiffRepStartAnalysisTaskUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffRep> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepStartAnalysisTaskUIActionModelBase.class);

    public PSDevSysDiffRepStartAnalysisTaskUIActionModelBase() {
        this.setId("A67A9524-C3AD-43AA-9CE4-BF4A1CA1D8B1");
        this.setName("StartAnalysisTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_STARTANALYSISTASK");
        this.setReloadData(true);
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u5dee\u5f02\u5206\u6790\u4efb\u52a1");
    }
}

