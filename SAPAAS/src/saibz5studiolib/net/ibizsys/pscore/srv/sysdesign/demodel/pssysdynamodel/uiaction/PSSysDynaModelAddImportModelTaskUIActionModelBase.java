/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.demodel.DEUIActionModelBase
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysdynamodel.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSysDynaModelAddImportModelTaskUIActionModelBase
extends DEUIActionModelBase<PSSysDynaModel> {
    private static final Log log = LogFactory.getLog(PSSysDynaModelAddImportModelTaskUIActionModelBase.class);

    public PSSysDynaModelAddImportModelTaskUIActionModelBase() {
        this.setId("3BC7C0D6-1970-4E93-9494-FB45D83C05A7");
        this.setName("AddImportModelTask");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("X_ADDIMPORTMODELTASK");
        this.setSuccessMsg("\u5df2\u5efa\u7acb\u540e\u53f0\u5bfc\u5165\u6a21\u578b\u4efb\u52a1");
    }
}

