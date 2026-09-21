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

public abstract class PSDevSysDiffRepStopAnalysisTaskUIActionModelBase
extends DEUIActionModelBase<PSDevSysDiffRep> {
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepStopAnalysisTaskUIActionModelBase.class);

    public PSDevSysDiffRepStopAnalysisTaskUIActionModelBase() {
        this.setId("FDFF7557-E5DC-458F-8E3C-8021273AF6C7");
        this.setName("StopAnalysisTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_STOPANALYSISTASK");
        this.setReloadData(true);
        this.setSuccessMsg("\u5df2\u53d6\u6d88\u540e\u53f0\u5dee\u5f02\u5206\u6790\u4efb\u52a1");
    }
}

