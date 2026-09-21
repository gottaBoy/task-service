/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysref.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysRefAddImpSubSysModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSysRef> {
    private static final Log log = LogFactory.getLog(PSSysRefAddImpSubSysModelTaskUIActionModelBase.class);

    public PSSysRefAddImpSubSysModelTaskUIActionModelBase() {
        this.setId("6FDABC3A-54EF-4200-BB36-E84381691B61");
        this.setName("AddImpSubSysModelTask");
        this.setActionTarget("SINGLEKEY");
        this.setDEActionName("X_ADDIMPSUBSYSMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540c\u6b65\u5b50\u7cfb\u7edf\u6a21\u578b\u540e\u53f0\u4efb\u52a1");
    }
}

